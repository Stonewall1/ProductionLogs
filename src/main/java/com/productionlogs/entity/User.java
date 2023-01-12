package com.productionlogs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @NotBlank(message = "Field cant be empty!")
    private String firstName;
    @NotBlank(message = "Field cant be empty!")
    private String lastName;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
