package com.gabriel.proposal_app.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
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

    @Bean
    public RabbitAdmin createRabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> startAdmin(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public FanoutExchange createPendingProposalFanoutExchange(){
        return ExchangeBuilder.fanoutExchange("pending-proposal.ex").build();
    }

    @Bean
    public Binding createBindingPendingProposalCreditAnalysisMS(){
        return BindingBuilder.bind(pendingProposalCreditAnalyisMSQueue()).to(createPendingProposalFanoutExchange());
    }

    @Bean
    public Binding createBindingPendingProposalNotificationMS(){
        return BindingBuilder.bind(pendingProposalNotificationMSQueue()).to(createPendingProposalFanoutExchange());
    }
}
