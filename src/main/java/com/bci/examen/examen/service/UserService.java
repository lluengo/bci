package com.bci.examen.examen.service;

import com.bci.examen.examen.entity.User;
import com.bci.examen.examen.entity.dto.UserResponseDto;

public interface UserService {
    UserResponseDto save (User userDto);
}
