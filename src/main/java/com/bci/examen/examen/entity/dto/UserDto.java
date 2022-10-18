package com.bci.examen.examen.entity.dto;

import com.bci.examen.examen.entity.Phone;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String id;
    private String name;
    private List<Phone> phones;
    private String email;
    private String passsword;
}
