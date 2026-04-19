package com.myweb.mongo.controller;

import com.myweb.mongo.model.Notification;
import com.myweb.mongo.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private org.springframework.data.mongodb.core.MongoTemplate mongoTemplate;

    @GetMapping("/debug")
    public Object debug() {
        return mongoTemplate.getDb().getName();
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    @GetMapping("/{accountId}")
    public List<Notification> getByAccountId(
            @PathVariable String accountId
    ) {
        return repository.findByAccountId(accountId);
    }
}
