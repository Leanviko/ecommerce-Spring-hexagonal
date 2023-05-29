package com.icodeap.ecommerce.application.service;

import javax.servlet.http.HttpSession;

public class LogoutService {

    public LogoutService(){
    }

    public void logout(HttpSession httpSession){
        httpSession.removeAttribute("iduser");
    }
}
