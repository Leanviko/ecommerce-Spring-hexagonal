package com.icodeap.ecommerce.domain;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String cellphone;
    private String password;
    private UserType userType;
    private LocalDateTime dateCreated;
}