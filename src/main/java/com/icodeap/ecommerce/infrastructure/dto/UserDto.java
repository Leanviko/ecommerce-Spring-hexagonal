package com.icodeap.ecommerce.infrastructure.dto;

import com.icodeap.ecommerce.domain.User;
import com.icodeap.ecommerce.domain.UserType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class UserDto {
    private String username;
    @NotBlank(message = "Debe ingresar un nombre")
    private String firstName;
    @NotBlank(message = "Debe ingresar un apellido")
    private String lastName;
    @NotBlank(message = "Debe ingresar un email valido")
    private String email;
    @NotBlank(message = "Debe ingresar una direccion")
    private String address;
    @NotBlank(message = "Debe ingresar un numero de telefono")
    private String cellphone;
    @NotBlank(message = "Debe ingresar una contraseña")
    private String password;

    public User userDtoToUser() {
        return new User(null, this.getUsername(), this.getFirstName(), this.getLastName(), this.getEmail(), this.getAddress(), this.getCellphone(), this.getPassword(), UserType.USER, LocalDateTime.now());
    }
}
