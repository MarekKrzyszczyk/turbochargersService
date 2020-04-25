package com.turbo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class User {

    @Column(name = "user_id")   // nadpisanie nazwy mapowane w tabeli DB
    @Id                         // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "pole obowiązkowe")
    @Email(message = "niepoprawny adres e-mail")
    private String email;

    @NotBlank(message = "pole obowiązkowe")
    @Size(min = 6, max = 255, message = "hasło musi zawierać od {min} do {max} znaków")
    private String password;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name="role")
    private Role role;


    public User() {
    }
}
