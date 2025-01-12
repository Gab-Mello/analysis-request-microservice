package com.gabriel.proposal_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProposalRequestDto {

    private String name;

    private String lastName;

    private String phone;

    private String cpf;

    private Double income;

    private Double requestAmount;

    private int paymentTerm;
}
