package com.hilaryd.springbootmvc.events;

import com.hilaryd.springbootmvc.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;


@Setter
@Getter
public class RegistrationCompleteEven extends ApplicationEvent {
    private User user;
    private String confirmationUrl;
    public RegistrationCompleteEven(User user, String confirmationUrl) {
        super(user);
        this.user = user;
        this.confirmationUrl = confirmationUrl;
    }
}
