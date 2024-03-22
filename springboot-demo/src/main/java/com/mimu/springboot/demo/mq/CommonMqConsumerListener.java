package com.mimu.springboot.demo.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "", consumerGroup = "")
public class CommonMqConsumerListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.printf("receive message %s%n", s);
    }
}
