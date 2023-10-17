package com.resellerapp.model.entity;

import com.resellerapp.model.dto.OfferCreateBindingModel;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {


    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "condition_id",
            nullable = false)
    private Condition condition;

    @ManyToOne
    @JoinColumn(nullable = false, name = "created_by")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "bought_by")
    private User boughtBy;

    public Offer() {
    }

    public Offer(OfferCreateBindingModel offerCreateBindingModel, Condition condition, User createdBy) {
        description = offerCreateBindingModel.getDescription();
        price = offerCreateBindingModel.getPrice();
        this.condition = condition;
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getBoughtBy() {
        return boughtBy;
    }

    public void setBoughtBy(User boughtBy) {
        this.boughtBy = boughtBy;
    }

}
