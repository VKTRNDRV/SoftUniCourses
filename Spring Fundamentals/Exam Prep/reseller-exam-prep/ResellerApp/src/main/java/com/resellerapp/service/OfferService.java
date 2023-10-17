package com.resellerapp.service;

import com.resellerapp.model.dto.*;
import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final ConditionRepository conditionRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    @Autowired
    public OfferService(OfferRepository offerRepository, ConditionRepository conditionRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.offerRepository = offerRepository;
        this.conditionRepository = conditionRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }


    public boolean create(OfferCreateBindingModel offerCreateBindingModel) {
        Condition condition = conditionRepository.findByName(offerCreateBindingModel.getCondition());
        User user = userRepository.findByUsername(loggedUser.getUsername());

        if (condition != null && user != null) {
            Offer offer = new Offer(offerCreateBindingModel, condition, user);

            offerRepository.save(offer);
            return true;
        }

        return false;
    }

    public OfferHomeDTO getOffersFotHomePage() {
        List<Offer> offers = offerRepository.findAll();

        List<MyOfferDTO> myOffers = new ArrayList<>();
        List<BoughtOffersDTO> boughtOffers = new ArrayList<>();
        List<OtherOffersDTO> otherOffers = new ArrayList<>();

        for (Offer offer : offers) {
            String loggedUsername = loggedUser.getUsername();

            if (offer.getBoughtBy() == null && offer.getCreatedBy().getUsername().equals(loggedUsername)) {
                myOffers.add(new MyOfferDTO(offer));
            } else if (offer.getBoughtBy() != null && offer.getBoughtBy().getUsername().equals(loggedUsername)) {
                boughtOffers.add(new BoughtOffersDTO(offer));
            } else if (offer.getBoughtBy() == null) {
                otherOffers.add(new OtherOffersDTO(offer));
            }
        }

        return new OfferHomeDTO(myOffers, boughtOffers, otherOffers);
    }

    public void buy(Long id) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);

        if (optionalOffer.isPresent()) {
            User user = userRepository.findByUsername(loggedUser.getUsername());
            Offer offer = optionalOffer.get();

            offer.setBoughtBy(user);

            offerRepository.save(offer);
        }
    }
}
