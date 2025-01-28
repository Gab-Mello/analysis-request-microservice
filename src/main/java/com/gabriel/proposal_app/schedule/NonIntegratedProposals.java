package com.gabriel.proposal_app.schedule;

import com.gabriel.proposal_app.repository.ProposalRepository;
import com.gabriel.proposal_app.service.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class NonIntegratedProposals {

    @Autowired
    ProposalRepository proposalRepository;

    @Autowired
    RabbitMQProducer rabbitMQProducer;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void searchNonIntegratedProposals(){
        proposalRepository.findAllByIntegratedIsFalse().forEach(proposal -> {
            try{
                rabbitMQProducer.sendMessage(proposal, exchangeName);
                proposal.setIntegrated(true);
                proposalRepository.save(proposal);
            }
            catch (RuntimeException ex){
                System.out.println("erouuu");
            }
        });
    }
}
