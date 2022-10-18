package com.bci.examen.examen.controller;

import com.bci.examen.examen.entity.User;
import com.bci.examen.examen.entity.dto.UserDto;
import com.bci.examen.examen.entity.dto.UserResponseDto;
import com.bci.examen.examen.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@RequestMapping("/users")
public class UserController  {

    UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @ApiOperation(value = "Save or Update user", notes = "Save or update user")
    @PostMapping(path = "/sign-up",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE},
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody ResponseEntity<UserResponseDto> saveOrUpdate(@RequestBody UserDto request) {
            return new ResponseEntity<>(userService.save(toDomain(request)), HttpStatus.CREATED);
    }


    private User toDomain(UserDto dto) {
        return User.build(dto.getId() != null ? UUID.fromString(dto.getId()) : null, dto.getName(), dto.getEmail(), dto.getPasssword(), dto.getPhones());
    }

}
