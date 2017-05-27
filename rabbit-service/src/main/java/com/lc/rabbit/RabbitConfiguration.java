/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lc.rabbit;

import com.lc.rabbit.receiver.BaseReceiver;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@ComponentScan
@EnableConfigurationProperties({RabbitMQProperties.class})
@EnableRabbit
public class RabbitConfiguration {

    @Autowired
    RabbitMQProperties rabbitMQProperties;

    @Autowired
    @Qualifier("appLogMessageReceiver")
    private BaseReceiver aPPLogMessageReceiver;

    @Bean(name = "connectionFactory")
    public ConnectionFactory getConnectionFactory() {
        System.out.println("init connection factory...");
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(rabbitMQProperties.getHost());
        factory.setUsername(rabbitMQProperties.getUsername());
        factory.setPassword(rabbitMQProperties.getPassword());
        factory.setVirtualHost(rabbitMQProperties.getVhost());
        factory.setPublisherConfirms(true);
        factory.setPublisherReturns(true);
        return factory;
    }

    @Bean(name = "rabbitTemplate")
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        System.out.println("init rabbit template...");
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(rabbitMQProperties.getAppExchange());
        return rabbitTemplate;
    }

    @Bean
    public SimpleMessageListenerContainer appLogContainer(ConnectionFactory connectionFactory) {
        System.out.println(rabbitMQProperties.getVhost()+" "+rabbitMQProperties.getLogQueue());

        if (!StringUtils.isEmpty(rabbitMQProperties.getLogQueue())) {
            MessageListenerAdapter listener = new MessageListenerAdapter(aPPLogMessageReceiver, "receiveMessage");
            SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
            container.setConnectionFactory(connectionFactory);
            container.setQueueNames(rabbitMQProperties.getLogQueue());
            container.setMessageListener(listener);
            return container;
        } else {
            return null;
        }

    }

}
