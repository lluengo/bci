package com.bci.examen.examen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @OneToMany(targetEntity=Phone.class, cascade = {CascadeType.ALL})
    private List<Phone> phones;
}
