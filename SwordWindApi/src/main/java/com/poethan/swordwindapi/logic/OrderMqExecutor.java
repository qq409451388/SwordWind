package com.poethan.swordwindapi.logic;

import com.poethan.gear.module.rabbitmq.MqExecutor;
import com.poethan.gear.module.rabbitmq.RabbitMqConnectionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OrderMqExecutor extends MqExecutor {
    public OrderMqExecutor(RabbitMqConnectionFactory rabbitMqConnectionFactory) {
        super(rabbitMqConnectionFactory);
    }

    @PostConstruct
    public void init() {
        this.addReceiver("order.direct", "test.routingkey", "testQueue", this::read);
        this.addReceiver("order.direct", "test.routingkey", "testQueue2", this::read);
        //super.init();
    }

    public boolean read(String message) {
        return true;
    }
}
