package com.resellerapp.controller;

import com.resellerapp.model.dto.OfferCreateBindingModel;
import com.resellerapp.service.LoggedUser;
import com.resellerapp.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final LoggedUser loggedUser;
    private final OfferService offerService;

    @Autowired
    public OfferController(LoggedUser loggedUser, OfferService offerService) {
        this.loggedUser = loggedUser;
        this.offerService = offerService;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("offer-add");
    }

    @PostMapping("/create")
    public ModelAndView create(OfferCreateBindingModel offerCreateBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        boolean isCreated = offerService.create(offerCreateBindingModel);

        String view = isCreated ? "redirect:/home" : "create";
        return new ModelAndView(view);
    }

    @GetMapping("/buy/{id}")
    public ModelAndView buyOffer(@PathVariable("id") Long id) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        offerService.buy(id);
        return new ModelAndView("redirect:/home");
    }
}
