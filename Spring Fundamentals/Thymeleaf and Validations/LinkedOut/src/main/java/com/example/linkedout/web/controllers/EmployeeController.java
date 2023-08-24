package com.example.linkedout.web.controllers;

import com.example.linkedout.domain.models.EmployeeAddModel;
import com.example.linkedout.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private CompanyService companyService;

    @Autowired
    public EmployeeController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/add")
    public String getAddEmployee(Model model){
        if(!model.containsAttribute("employeeAddModel")){
            model.addAttribute("employeeAddModel", new EmployeeAddModel());
        }
        model.addAttribute("companyNames", this.companyService.getAllCompanyNames());
        return "employee-add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employeeAddModel") EmployeeAddModel employeeAddModel){

        return "employee-add";
    }

    @GetMapping("/all")
    public String getAllEmployees(){
        return "employee-all";
    }
}
