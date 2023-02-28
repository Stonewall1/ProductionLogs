package com.productionlogs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotBlank(message = "Field cant be empty!")
    private String username;
    @NotBlank(message = "Field cant be empty!")
    private String user_password;
    @NotBlank(message = "Field cant be empty!")
    private String firstName;
    @NotBlank(message = "Field cant be empty!")
    private String lastName;
}
