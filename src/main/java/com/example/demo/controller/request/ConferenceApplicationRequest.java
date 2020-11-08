package com.example.demo.controller.request;

public class ConferenceApplicationRequest {
    int userId;
    String nameAbbreviation;
    String fullname;
    String time;
    String location;
    String deadline;
    String resultAnnounceDate;

    public ConferenceApplicationRequest(int userId, String nameAbbreviation, String fullname, String time, String location, String deadline, String resultAnnounceDate) {
        this.userId = userId;
        this.nameAbbreviation = nameAbbreviation;
        this.fullname = fullname;
        this.time = time;
        this.location = location;
        this.deadline = deadline;
        this.resultAnnounceDate = resultAnnounceDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNameAbbreviation() {
        return nameAbbreviation;
    }

    public void setNameAbbreviation(String nameAbbreviation) {
        this.nameAbbreviation = nameAbbreviation;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getResultAnnounceDate() {
        return resultAnnounceDate;
    }

    public void setResultAnnounceDate(String resultAnnounceDate) {
        this.resultAnnounceDate = resultAnnounceDate;
    }
}
