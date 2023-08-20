package com.example.mobilelele.models.entities;

import com.example.mobilelele.models.enums.Engine;
import com.example.mobilelele.models.enums.Transmission;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private Engine engine;

    @Column(name = "image_url")
    private String imageURL;

    @Column
    private Integer mileage;

    @Column
    private BigDecimal price;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private Transmission transmission;

    @Column
    private Integer year;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;
}

//•	id – uuid or number.
//        •	description – some text.
//        •	engine – enumerated value (GASOLINE, DIESEL, ELECTRIC, HYBRID).
//        •	imageUrl – the url of image.
//        •	mileage – a number.
//        •	price – the price of the offer.
//        •	transmission – enumerated value (MANUAL, AUTOMATIC).
//        •	year – the year of offered car.
//        •	created – a date and time.
//        •	modified – a date and time.
//        •	model – the model of a car.
//        •	seller – a user that sells the car.

