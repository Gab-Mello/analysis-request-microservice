package com.gabriel.proposal_app.Mapper;

import com.gabriel.proposal_app.dto.ProposalRequestDto;
import com.gabriel.proposal_app.dto.ProposalResponseDto;
import com.gabriel.proposal_app.entity.Proposal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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
    @Mapping(target = "integrated", constant = "true")
    Proposal toProposal(ProposalRequestDto proposalRequestDto);

    @Mapping(target = "renda", source = "user.income")
    @Mapping(target = "nome", source = "user.name")
    @Mapping(target = "sobrenome", source = "user.lastName")
    @Mapping(target = "telefone", source = "user.phone")
    @Mapping(target = "cpf", source = "user.cpf")
    @Mapping(target = "valorSolicitadoFmt", expression = "java(setValorSolicitadoFmt(proposal))" )
    ProposalResponseDto toProposalResponseDto(Proposal proposal);

    List<ProposalResponseDto> toProposalResponseDtoList(List<Proposal> list);

    default String setValorSolicitadoFmt(Proposal proposal){
        return NumberFormat.getCurrencyInstance(Locale.of("pt", "BR")).format(proposal.getRequestAmount());
    }
}
