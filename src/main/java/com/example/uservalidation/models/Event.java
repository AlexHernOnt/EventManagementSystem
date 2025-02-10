package com.example.uservalidation.models;

import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class Event {

    @NotBlank(message = "Name must not be blank")

    private String eventName;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private List<User> users = new ArrayList<>();

    public Event(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
