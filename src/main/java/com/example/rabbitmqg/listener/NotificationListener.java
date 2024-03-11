package com.example.rabbitmqg.listener;

import com.example.rabbitmqg.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "rabbit-mq-queue")
    public void handleMessage(Notification notification) {
        System.out.println("Message received..");
        System.out.println(notification.toString());
    }
}
