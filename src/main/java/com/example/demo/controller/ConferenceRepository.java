package com.example.demo.controller;

import java.util.List;
import java.util.Map;

public interface ConferenceRepository {
    void invitePCMember(int conferenceId,int userId);
    void joinConference(int userId, int conferenceId);
    void distributeAuthority(int userId, int conferenceId);
    void conferenceOpenSubmit(int userId, int conferenceId);
    int conferenceApplication(int userId,String nameAbbreviation,String fullName,String time,String location,String deadline,String resultAnnounceDate);
    List<Map<String,Object>> showConferences();

}
