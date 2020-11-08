package com.example.demo.controller.request;

public class InvitePCMemberRequest {
    int userId;
    int conferenceId;
    int pcMemberID;

    public InvitePCMemberRequest(int userId, int conferenceId, int pcMemberID) {
        this.userId = userId;
        this.conferenceId = conferenceId;
        this.pcMemberID = pcMemberID;
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

    public int getPcMemberID() {
        return pcMemberID;
    }

    public void setPcMemberID(int pcMemberID) {
        this.pcMemberID = pcMemberID;
    }
}
