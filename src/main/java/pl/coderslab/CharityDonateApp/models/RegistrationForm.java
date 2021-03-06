package pl.coderslab.CharityDonateApp.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegistrationForm {
    @NotBlank(message = "Wprowadzane danę nie mogą być puste.")
    @Size(min = 2, max = 30, message = "Wprowadzane danę muszą zawierać pomiędzy {min} a {max} znaków.")
    private String firstName;
    @NotBlank(message = "Wprowadzane danę nie mogą być puste.")
    @Size(min = 2, max = 30, message = "Wprowadzane danę muszą zawierać pomiędzy {min} a {max} znaków.")
    private String lastName;
    @Email(message = "Wprowadzane dane muszą być poprawnym adresem email.")
    @NotBlank(message = "Wprowadzane danę nie mogą być puste.")
    private String email;
    @NotBlank(message = "Wprowadzane danę nie mogą być puste.")
    @Size(min = 8, message = "Wprowadzane danę muszą zawierać przynajmniej {min} znaków, w tym jedną dużą literę, jedną małą literę, jedną cyfrę oraz jeden znak specjalny.")
    private String pass1;
    @NotBlank(message = "Wprowadzane danę nie mogą być puste.")
    private String pass2;

}
