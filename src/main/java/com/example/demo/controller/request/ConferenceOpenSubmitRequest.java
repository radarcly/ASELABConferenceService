package com.example.demo.controller.request;

public class ConferenceOpenSubmitRequest {
    int userId;
    int conferenceId;

    public ConferenceOpenSubmitRequest(int userId, int conferenceId) {
        this.userId = userId;
        this.conferenceId = conferenceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }
}
