package com.gabriel.proposal_app.service;

import com.gabriel.proposal_app.Mapper.ProposalMapper;
import com.gabriel.proposal_app.dto.ProposalRequestDto;
import com.gabriel.proposal_app.dto.ProposalResponseDto;
import com.gabriel.proposal_app.entity.Proposal;
import com.gabriel.proposal_app.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalService {

    @Autowired
    ProposalRepository proposalRepository;

    public ProposalResponseDto create(ProposalRequestDto dto){
        Proposal proposal = ProposalMapper.INSTANCE.toProposal(dto);
        proposalRepository.save(proposal);

        return ProposalMapper.INSTANCE.toProposalResponseDto(proposal);
    }
}
