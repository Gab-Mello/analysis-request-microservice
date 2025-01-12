package com.gabriel.proposal_app.controller;

import com.gabriel.proposal_app.dto.ProposalRequestDto;
import com.gabriel.proposal_app.dto.ProposalResponseDto;
import com.gabriel.proposal_app.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/proposal")
@RestController
public class ProposalController {

    @Autowired
    ProposalService proposalService;

    @PostMapping("/create")
    public ResponseEntity<ProposalResponseDto> create(@RequestBody ProposalRequestDto dto){
        ProposalResponseDto response = proposalService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
