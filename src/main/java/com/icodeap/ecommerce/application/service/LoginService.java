package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.domain.User;
import com.icodeap.ecommerce.infrastructure.dto.UserDto;

public class LoginService {
    private final UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }

    //retorna true si encuentra el user
    public boolean existUser(UserDto userDto){
        try{
            User user = userService.findByEmail(userDto.getEmail());
        }catch (Exception e){
            return  false;
        }
        return true;
    }

    //obtenemos el id del usuario
    public Integer getUsuarioId(String email){
        try {
            return userService.findByEmail(email).getId();
        }catch (Exception e){
            return 0;
        }
    }

    //Obtenemos user mediante email
    public User getUser(String email){
        try {
            return userService.findByEmail(email);
        }catch (Exception e){
            return new User();
        }

    }
}
