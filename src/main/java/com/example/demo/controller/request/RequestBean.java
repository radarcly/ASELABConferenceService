package com.example.demo.controller.request;

public class RequestBean {
    int userToSent;
    String message;
    String type;

    public RequestBean(int userToSent, String message, String type) {
        this.userToSent = userToSent;
        this.message = message;
        this.type = type;
    }

    public int getUserToSent() {
        return userToSent;
    }

    public void setUserToSent(int userToSent) {
        this.userToSent = userToSent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
