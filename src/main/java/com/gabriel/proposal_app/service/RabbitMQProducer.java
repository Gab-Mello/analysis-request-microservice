package com.gabriel.proposal_app.service;

import com.gabriel.proposal_app.entity.Proposal;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Proposal proposal, String exchange){
        rabbitTemplate.convertAndSend(exchange,"",proposal);
    }

}
