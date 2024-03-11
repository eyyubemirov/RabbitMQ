package com.example.rabbitmqg.handler;


import com.example.rabbitmqg.model.Notification;
import com.example.rabbitmqg.producer.NotificationProducer;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class NotificationSender {

    private final NotificationProducer producer;

    public void getThread() {
        Thread thread = new Thread(() -> {
            int count = 0;
            while (count < 5) {
                Notification notification = new Notification();
                notification.setNotificationId(UUID.randomUUID().toString());
                notification.setCreatedAt(new Date());
                notification.setMessage("message...");
                notification.setSeen(false);
                producer.sendToQueue(notification);
                count++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("Notification sender");
        thread.start();
    }



    @PostConstruct
    public void init() {
        getThread();

    }
}
