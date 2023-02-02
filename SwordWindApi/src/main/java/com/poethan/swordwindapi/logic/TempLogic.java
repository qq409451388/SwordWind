package com.poethan.swordwindapi.logic;

import com.poethan.gear.module.rabbitmq.RabbitMqClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class TempLogic {
    @Resource
    private RabbitMqClient rabbitMqClient;

    public void publish(String msg, String exchangeName, String routingKey) {
        try {
            rabbitMqClient.publish(msg, exchangeName, routingKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
