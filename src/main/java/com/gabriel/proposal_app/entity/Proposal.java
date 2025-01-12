package com.gabriel.proposal_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "proposals")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double requestAmount;

    private int paymentTerm;

    private Boolean approved;

    private boolean integrated;

    private String observation;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Proposal(String name,  String lastName, String phone, String cpf, Double income, Double requestAmount, int paymentTerm){

    }
}
