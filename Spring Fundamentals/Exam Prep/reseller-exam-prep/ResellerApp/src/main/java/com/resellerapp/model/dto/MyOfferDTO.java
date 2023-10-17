package com.resellerapp.model.dto;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.enums.ConditionName;

public class MyOfferDTO extends BoughtOffersDTO {

    private Long id;
    private ConditionName condition;

    public MyOfferDTO() {
    }

    public MyOfferDTO(Offer offer) {
        super(offer);
        id = offer.getId();
        condition = offer.getCondition().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConditionName getCondition() {
        return condition;
    }

    public void setCondition(ConditionName condition) {
        this.condition = condition;
    }
}
