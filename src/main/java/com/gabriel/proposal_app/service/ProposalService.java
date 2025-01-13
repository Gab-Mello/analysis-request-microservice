package com.gabriel.proposal_app.service;

import com.gabriel.proposal_app.Mapper.ProposalMapper;
import com.gabriel.proposal_app.dto.ProposalRequestDto;
import com.gabriel.proposal_app.dto.ProposalResponseDto;
import com.gabriel.proposal_app.entity.Proposal;
import com.gabriel.proposal_app.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalService {

    @Autowired
    ProposalRepository proposalRepository;

    @Autowired
    ProposalMapper proposalMapper;

    public ProposalResponseDto create(ProposalRequestDto dto){
        Proposal proposal = proposalMapper.toProposal(dto);
        proposalRepository.save(proposal);
        return proposalMapper.toProposalResponseDto(proposal);
    }

    public List<ProposalResponseDto> getAll(){
        List<Proposal> list = proposalRepository.findAll();
        return proposalMapper.toProposalResponseDtoList(list);
    }
}
