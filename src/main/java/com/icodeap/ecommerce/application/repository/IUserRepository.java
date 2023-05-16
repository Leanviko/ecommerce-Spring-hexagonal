package com.icodeap.ecommerce.application.repository;

import com.icodeap.ecommerce.domain.User;

public interface IUserRepository {
    public User createUser(User user);
    public User findByEmail(String email);
    public User findById(Integer id);
}
