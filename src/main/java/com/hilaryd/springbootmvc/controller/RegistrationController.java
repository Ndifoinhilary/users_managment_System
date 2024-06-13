package com.hilaryd.springbootmvc.controller;

import com.hilaryd.springbootmvc.entity.User;
import com.hilaryd.springbootmvc.events.RegistrationCompleteEven;
import com.hilaryd.springbootmvc.registration.RegistrationRequest;
import com.hilaryd.springbootmvc.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class RegistrationController {

    private final UserServices userServices;
    private final ApplicationEventPublisher publisher;


    @GetMapping("/registration-form")
    public String userRegistrationForm(Model model){
        model.addAttribute("user", new RegistrationRequest());
        return "registration";
    }

    @PostMapping("/register")
    public String regiter(@ModelAttribute("user") RegistrationRequest registration){
        User user = userServices.registration(registration);
        publisher.publishEvent(new RegistrationCompleteEven(user, ""));

        return  "redirect:/auth/registration-form?success";
    }
}
