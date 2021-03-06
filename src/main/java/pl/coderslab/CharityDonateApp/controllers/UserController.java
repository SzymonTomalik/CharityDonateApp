package pl.coderslab.CharityDonateApp.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.CharityDonateApp.converters.UserConverter;
import pl.coderslab.CharityDonateApp.models.RegistrationForm;
import pl.coderslab.CharityDonateApp.services.PasswordService;
import pl.coderslab.CharityDonateApp.services.UserService;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final PasswordService passwordService;
    private final UserConverter userConverter;

    @GetMapping("/form")
    public String registrationForm(Model model) {
        model.addAttribute("registration", new RegistrationForm());
        model.addAttribute("usersList", userService.showUsers());
        return "user/register";
    }

    @PostMapping("/form")
    public String processForm(@Valid RegistrationForm registration, BindingResult bindingResult) {
        if (!passwordService.passwordValidator(registration)) {
            bindingResult.rejectValue("pass2", "registration.pattern.invalid", "Podane hasła nie są takie same lub nie zawierają wymaganych znaków. Hasło musi zawierać minimum 8 znaków, w tym: wielką literę [A-Z], małą literę [a-z], cyfrę [0-9] i znak specjalny [!@#$%^&*_()+-=]." );
        }
        if (!userService.isEmailUnique(registration.getEmail())) {
            bindingResult.rejectValue("email", "registration.email.invalid", "Podany adres email już istnieje.");
        }
        if (bindingResult.hasErrors()) {
            return "user/register";
        }
        userService.addUser(userConverter.convertRegistrationToUser(registration));
        return "user/register-confirmation";
    }
}


