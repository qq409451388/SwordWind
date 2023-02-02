package com.poethan.swordwindapi.logic;

import com.poethan.gear.anno.EzApiCache;
import com.poethan.gear.module.rabbitmq.RabbitMqClient;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

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

    @EzApiCache
    public List<Object> getList (String a, String b, Integer c) {
        return Lists.newArrayList(a, b, c);
    }
}
