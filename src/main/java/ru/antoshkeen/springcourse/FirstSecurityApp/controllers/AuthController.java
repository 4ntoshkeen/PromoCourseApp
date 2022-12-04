package ru.antoshkeen.springcourse.FirstSecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.User;
import ru.antoshkeen.springcourse.FirstSecurityApp.services.RegistrationService;
import ru.antoshkeen.springcourse.FirstSecurityApp.util.UsersValidator;

import javax.validation.Valid;



@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;
    private final UsersValidator usersValidator;

    @Autowired
    public AuthController(RegistrationService registrationService, UsersValidator usersValidator) {
        this.registrationService = registrationService;
        this.usersValidator = usersValidator;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute ("user") User user) {
        return "auth/registration";
    }


    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        usersValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "auth/registration";
        }

        registrationService.register(user);

        return "redirect:/auth/login";
    }
}
