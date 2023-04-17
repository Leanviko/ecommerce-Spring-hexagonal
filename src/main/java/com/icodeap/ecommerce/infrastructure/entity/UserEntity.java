package com.icodeap.ecommerce.infrastructure.entity;

import com.icodeap.ecommerce.domain.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String cellphone;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;
    private LocalDateTime dateCreated;

}
