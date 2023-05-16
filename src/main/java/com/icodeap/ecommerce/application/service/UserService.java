package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.application.repository.IUserRepository;
import com.icodeap.ecommerce.domain.User;

public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(User user){
        return userRepository.createUser(user);
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User findById(Integer id){
     return userRepository.findById(id);
    }
}
