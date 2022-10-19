package com.bci.examen.examen.service.impl;

import com.bci.examen.examen.ExamenApplication;
import com.bci.examen.examen.entity.User;
import com.bci.examen.examen.entity.dto.UserResponseDto;
import com.bci.examen.examen.exception.EmailValidationException;
import com.bci.examen.examen.exception.PasswordException;
import com.bci.examen.examen.exception.UserFoundedException;
import com.bci.examen.examen.repository.UserRepository;
import com.bci.examen.examen.security.JwtProvider;
import com.bci.examen.examen.service.UserService;
import com.bci.examen.examen.utils.RegExValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    JwtProvider jwtProvider;
    PasswordEncoder passwordEncoder;
    RegExValidator regExValidator;

    @Autowired
    public UserServiceImpl (UserRepository userRepository, JwtProvider jwtProvider, PasswordEncoder passwordEncoder, RegExValidator regExValidator){
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.regExValidator = regExValidator;
    }

    @Override
    public UserResponseDto save (User user){

        userRepository.findByEmail(user.getEmail().trim()).ifPresent(s -> {
            throw new UserFoundedException(s);
        });

        if (!regExValidator.validateEmail(user.getEmail())) throw new EmailValidationException(user.getEmail());

        if (!regExValidator.validatePassword(user.getPasssword())) throw new PasswordException();

        UserResponseDto userResponseDto = new UserResponseDto();

        String password = passwordEncoder.encode(user.getPasssword());
        user.setPasssword(password);

        User userSaved = userRepository.save(user);

        userResponseDto.setUser(userSaved);
        userResponseDto.setId(userSaved.getId().toString());
        userResponseDto.setToken(jwtProvider.createToken(userSaved));
        userResponseDto.setCreated(new Date());
        userResponseDto.setActive(true);

        return userResponseDto;
    }
}
