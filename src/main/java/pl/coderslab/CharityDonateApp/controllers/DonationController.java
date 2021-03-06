package pl.coderslab.CharityDonateApp.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.CharityDonateApp.entities.Donation;
import pl.coderslab.CharityDonateApp.services.CategoryService;
import pl.coderslab.CharityDonateApp.services.DonationService;
import pl.coderslab.CharityDonateApp.services.InstitutionService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class DonationController {
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    @GetMapping("/form")
    public String homeAction(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/form")
    public String proceedForm(@Valid Donation donation, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()) {
            donationService.saveDonation(donation);
            return "form-confirmation";
        }
        return "form";
    }

}
