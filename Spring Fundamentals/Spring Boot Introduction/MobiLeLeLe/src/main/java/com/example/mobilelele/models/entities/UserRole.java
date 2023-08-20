package com.example.mobilelele.models.entities;

import com.example.mobilelele.models.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "name")
    private Role role;
}
