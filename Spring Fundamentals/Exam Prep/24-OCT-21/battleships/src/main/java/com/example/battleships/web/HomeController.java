package com.example.battleships.web;

import com.example.battleships.domain.dto.BattleShipsModel;
import com.example.battleships.domain.dto.UserWithShipsModel;
import com.example.battleships.domain.entity.Ship;
import com.example.battleships.domain.helper.LoggedUser;
import com.example.battleships.repository.ShipRepository;
import com.example.battleships.service.BattleService;
import com.example.battleships.service.ShipService;
import com.example.battleships.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private LoggedUser loggedUser;
    private ShipRepository shipRepository;
    private UserService userService;
    private BattleService battleService;

    private ShipService shipService;

    @Autowired
    public HomeController(LoggedUser loggedUser, ShipRepository shipRepository, UserService userService, BattleService battleService, ShipService shipService) {
        this.loggedUser = loggedUser;
        this.shipRepository = shipRepository;
        this.userService = userService;
        this.battleService = battleService;
        this.shipService = shipService;
    }

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping("home")
    public ModelAndView getHome(ModelAndView modelAndView) {
        if(!this.loggedUser.isLogged()){
            modelAndView.setViewName("redirect:auth/login");
            return modelAndView;
        }

        UserWithShipsModel loggedUserWithShips = battleService.getUserWithShips(this.loggedUser.getId());
        UserWithShipsModel notLoggedUserWithShips = battleService.getUserWithShips(this.userService
                .findByIdNot(loggedUser.getId())
                .getId());

        modelAndView.setViewName("home");
        modelAndView.addObject("loggedUserWithShips", loggedUserWithShips);
        modelAndView.addObject("notLoggedUserWithShips", notLoggedUserWithShips);

        return modelAndView;
    }

    @PostMapping("battle")
    public String getHome(@ModelAttribute(name = "battleShipsModel") BattleShipsModel battleShipsModel) {
        this.shipService.fight(battleShipsModel);

        return "redirect:home";
    }

    @ModelAttribute(name = "battleShipsModel")
    public BattleShipsModel battleShipsModel() {
        return new BattleShipsModel();
    }

    @ModelAttribute(name = "allShips")
    public List<Ship> ships() {
        if (!loggedUser.isLogged()) {
            return List.of();
        }
        return this.shipRepository.findAll();
    }
}
