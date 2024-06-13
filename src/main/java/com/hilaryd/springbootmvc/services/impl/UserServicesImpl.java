package com.hilaryd.springbootmvc.services.impl;

import com.hilaryd.springbootmvc.entity.Role;
import com.hilaryd.springbootmvc.entity.User;
import com.hilaryd.springbootmvc.registration.RegistrationRequest;
import com.hilaryd.springbootmvc.repository.UserRepository;
import com.hilaryd.springbootmvc.security.EndToEndSecurityDemo;
import com.hilaryd.springbootmvc.services.UserServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {

        return repository.findAll();
    }

    @Override
    public User registration(RegistrationRequest registration) {
        var user = new User(
                registration.getFirstName(), registration.getLastName(), registration.getEmail(),
                passwordEncoder.encode(registration.getPassword()), Arrays.asList(new Role("ROLE_USER"))
        );
        return repository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User  not found"));
    }
}
