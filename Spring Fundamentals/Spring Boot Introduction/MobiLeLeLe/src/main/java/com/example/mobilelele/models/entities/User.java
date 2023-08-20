package com.example.mobilelele.models.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole role;

    @Column(name = "image_url")
    private String imageURL;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;
}

//•	id – uuid or number.
//        •	username –  username of the user.
//        •	password – password of the user.
//        •	firstName –  first name of the user.
//        •	lastName –  last name of the user.
//        •	isActive – true OR false.
//        •	role –  user's role (User or Admin).
//        •	imageUrl – a url of user's picture.
//        •	created – a date and time.
//        •	modified – a date and time.

