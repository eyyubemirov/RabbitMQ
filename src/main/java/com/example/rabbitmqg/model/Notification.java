package com.example.rabbitmqg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification implements Serializable {

    private String notificationId;
    private Date createdAt;
    private Boolean seen;
    private String message;
}

