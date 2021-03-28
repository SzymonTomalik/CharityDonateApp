package pl.coderslab.CharityDonateApp.services;

import pl.coderslab.CharityDonateApp.entities.CharityUser;

public interface CharityUserService {
    CharityUser findByEmail(String email);
    void addUser (CharityUser charityUser);
}
