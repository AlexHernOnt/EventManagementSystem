package com.example.uservalidation.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class User {
    private Long id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @Email(message = "Email must be a valid email format")
    private String email;

    @NotBlank(message = "eventName must not be blank")
    private String eventName;

    public User() {}

    public User(Long id, String name, String email, String eventName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.eventName = eventName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
