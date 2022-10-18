package com.bci.examen.examen.entity.dto;

import com.bci.examen.examen.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class UserResponseDto {
    private User user;
    private String id;
    private Date created;
    private Date lastLogin;
    private String token;
    private boolean isActive;
}
