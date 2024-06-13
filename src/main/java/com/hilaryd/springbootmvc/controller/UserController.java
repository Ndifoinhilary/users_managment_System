package com.hilaryd.springbootmvc.controller;

import com.hilaryd.springbootmvc.entity.User;
import com.hilaryd.springbootmvc.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserServices userServices;


    @GetMapping
   public String getUsers(Model model){
       model.addAttribute("users", userServices.getAllUsers());

       return "users";
   }
}
