package com.person.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
@EqualsAndHashCode
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "E-mail is required")
    private String email;

}