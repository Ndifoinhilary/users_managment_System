package com.hilaryd.springbootmvc.services;

import com.hilaryd.springbootmvc.entity.User;
import com.hilaryd.springbootmvc.registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface UserServices {
    List<User> getAllUsers();
    User registration(RegistrationRequest registrationRequest);
    User findByEmail(String email);
}
