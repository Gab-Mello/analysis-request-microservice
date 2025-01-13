package com.gabriel.proposal_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class ProposalResponseDto {

    private Long id;

    private String name;

    private String lastName;

    private String phone;

    private String cpf;

    private Double income;

    private Double requestAmount;

    private int paymentTerm;

    private Boolean approved;

    private String observation;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public Double getRequestAmount() {
        return requestAmount;
    }

    public int getPaymentTerm() {
        return paymentTerm;
    }

    public Boolean getApproved() {
        return approved;
    }

    public String getObservation() {
        return observation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public void setRequestAmount(Double requestAmount) {
        this.requestAmount = requestAmount;
    }

    public void setPaymentTerm(int paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
