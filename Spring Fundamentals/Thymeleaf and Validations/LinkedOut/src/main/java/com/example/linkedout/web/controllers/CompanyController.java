package com.example.linkedout.web.controllers;

import com.example.linkedout.domain.entities.Company;
import com.example.linkedout.domain.models.CompanyAddModel;
import com.example.linkedout.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/add")
    public String getAddCompany(Model model){
        if(!model.containsAttribute("companyAddModel")){
            model.addAttribute("companyAddModel",
                    new CompanyAddModel());
        }

        return "company-add";
    }

    @PostMapping("/add")
    public String addCompany(@Valid @ModelAttribute("companyAddModel") CompanyAddModel companyAddModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors() || !this.companyService.addCompany(companyAddModel)){
            redirectAttributes.addFlashAttribute(
                    "companyAddModel", companyAddModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.CompanyAddModel",
                    bindingResult);

            return "redirect:/companies/add";
        }

        return "company-all";
    }

    @GetMapping("/all")
    public String getAllCompanies(Model model){
        List<Company> allCompanies = this.companyService.getAllCompanies();
        model.addAttribute("companies", allCompanies);
        return "company-all";
    }

    @GetMapping("/details/{id}")
    public String getDetails(Model model, @PathVariable Long id){
        model.addAttribute("company",
                this.companyService.getCompanyById(id));
        return "company-details";
    }
}
