package com.gabriel.proposal_app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String cpf;

    private String phone;

    private Double income;

    @OneToOne(mappedBy = "user")
    private Proposal proposal;
}
