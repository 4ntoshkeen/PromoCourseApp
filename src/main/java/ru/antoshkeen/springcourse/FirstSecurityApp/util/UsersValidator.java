package ru.antoshkeen.springcourse.FirstSecurityApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.User;
import ru.antoshkeen.springcourse.FirstSecurityApp.services.UsersDetailsService;

@Component
public class UsersValidator implements Validator {

    private final UsersDetailsService usersDetailsService;

    @Autowired
    public UsersValidator(UsersDetailsService usersDetailsService) {
        this.usersDetailsService = usersDetailsService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User)o;
        try {
            usersDetailsService.loadUserByUsername(user.getUsername());
        } catch (UsernameNotFoundException ignored) {
            return;
        }

        errors.rejectValue("username", "", "User already exists");
    }
}
