package com.example.demo.controller.request;

public class UserAcceptORDeclinePCMemberInviteRequest {
    int userId;
    int conferenceId;
    int pcMemberID;
    boolean accept;

    public UserAcceptORDeclinePCMemberInviteRequest(int userId, int conferenceId, int pcMemberID, boolean accept) {
        this.userId = userId;
        this.conferenceId = conferenceId;
        this.pcMemberID = pcMemberID;
        this.accept = accept;
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

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}
