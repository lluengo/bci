package com.bci.examen.examen.service.impl;

import com.bci.examen.examen.entity.Phone;
import com.bci.examen.examen.entity.User;
import com.bci.examen.examen.entity.dto.UserResponseDto;
import com.bci.examen.examen.exception.EmailValidationException;
import com.bci.examen.examen.exception.PasswordException;
import com.bci.examen.examen.repository.UserRepository;
import data.Datos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class UserServiceImplTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @Test
    void saveUser(){
        //when(userRepository.findByEmail("leonel.luengo@globallogic.com")).thenReturn(Datos.getUser001());
        when(userRepository.save(any())).then(invocation -> {
           User u = invocation.getArgument(0);
           u.setId(UUID.fromString("bae0b173-4a38-41ae-988d-552fa8dd1b4c"));
           return u;
        });

        User userDto = new User();
        userDto.setEmail("leonel.luengo@globallogic.com");
        userDto.setName("lluengo");
        userDto.setPasssword("Leonel12");
        userDto.setPhones(Arrays.asList(new Phone(1l,44345343,1,"aa01")));

        UserResponseDto resultado = userService.save(userDto);

        assertEquals("leonel.luengo@globallogic.com",resultado.getUser().getEmail());
        assertEquals(UUID.fromString("bae0b173-4a38-41ae-988d-552fa8dd1b4c"), resultado.getUser().getId());
        verify(userRepository).findByEmail(any());
        verify(userRepository).save(any());
    }

    @Test
    void saveUserInvalidEmail(){
        //when(userRepository.findByEmail("leonel.luengo@globallogic.com")).thenReturn(Datos.getUser001());
        when(userRepository.save(any())).then(invocation -> {
            User u = invocation.getArgument(0);
            u.setId(UUID.fromString("bae0b173-4a38-41ae-988d-552fa8dd1b4c"));
            return u;
        });

        User userDto = new User();
        userDto.setEmail("leonel.luengogloballogic.com");
        userDto.setName("lluengo");
        userDto.setPasssword("Leonel12");
        userDto.setPhones(Arrays.asList(new Phone(1l,44345343,1,"aa01")));

        assertThrows(EmailValidationException.class, () -> {
            userService.save(userDto);
        });

    }

    @Test
    void saveUserInvalidPassword (){
        //when(userRepository.findByEmail("leonel.luengo@globallogic.com")).thenReturn(Datos.getUser001());
        when(userRepository.save(any())).then(invocation -> {
            User u = invocation.getArgument(0);
            u.setId(UUID.fromString("bae0b173-4a38-41ae-988d-552fa8dd1b4c"));
            return u;
        });

        User userDto = new User();
        userDto.setEmail("leonel.luengo@globallogic.com");
        userDto.setName("lluengo");
        userDto.setPasssword("1234");
        userDto.setPhones(Arrays.asList(new Phone(1l,44345343,1,"aa01")));

        assertThrows(PasswordException.class, () -> {
            userService.save(userDto);
        });

    }

}