package com.gabriel.proposal_app.Mapper;

import com.gabriel.proposal_app.dto.ProposalRequestDto;
import com.gabriel.proposal_app.dto.ProposalResponseDto;
import com.gabriel.proposal_app.entity.Proposal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProposalMapper {

    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.lastName", source = "lastName")
    @Mapping(target = "user.cpf", source = "cpf")
    @Mapping(target = "user.income", source = "income")
    @Mapping(target = "user.phone", source = "phone")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "approved", ignore = true)
    @Mapping(target = "observation", ignore = true)
    @Mapping(target = "integrated", ignore = true)
    Proposal toProposal(ProposalRequestDto proposalRequestDto);

    @Mapping(target = "income", source = "user.income")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "lastName", source = "user.lastName")
    @Mapping(target = "phone", source = "user.phone")
    @Mapping(target = "cpf", source = "user.cpf")
    ProposalResponseDto toProposalResponseDto(Proposal proposal);

    List<ProposalResponseDto> toProposalResponseDtoList(List<Proposal> list);
}
