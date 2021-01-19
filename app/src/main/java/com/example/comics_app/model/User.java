package com.example.comics_app.model;

import java.time.Instant;

public class User {
    private Long id;
    private String name;
    private String avatar;
    private String email;
    private String password;
    private String phoneNumber;
    private String created;
    private boolean enabled;
    private double cash;

    public User(Long id, String name, String avatar, String email, String password, String phoneNumber, String created, boolean enabled, double cash) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.created = created;
        this.enabled = enabled;
        this.cash = cash;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCreated() {
        return created;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public double getCash() {
        return cash;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
