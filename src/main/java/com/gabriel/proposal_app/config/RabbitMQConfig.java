package com.gabriel.proposal_app.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue pendingProposalCreditAnalyisMSQueue(){
        return QueueBuilder.durable("pending-proposal.Credit-analysis-MS").build();
    }

    @Bean
    public Queue pendingProposalNotificationMSQueue(){
        return QueueBuilder.durable("pending-proposal.Notification-MS").build();
    }

    @Bean
    public Queue concludeProposalCreditAnalyisMSQueue(){
        return QueueBuilder.durable("conclude-proposal.Credit-analysis-MS").build();
    }

    @Bean
    public Queue concludeProposalNotificationMSQueue(){
        return QueueBuilder.durable("conclude-proposal.Notification-MS").build();
    }
}
