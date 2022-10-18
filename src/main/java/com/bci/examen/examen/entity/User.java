package com.bci.examen.examen.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class User extends Person{
    private String email;
    private String passsword;

    public User(UUID id, String name, String email, String password, List<Phone> phones) {
        super(id,name,phones);
        this.email = email;
        this.passsword = password;
    }

    @Builder
    public static User build(UUID id, String name, String email, String password, List<Phone> phones) {
        return new User(id, name, email, password, phones);
    }
}
