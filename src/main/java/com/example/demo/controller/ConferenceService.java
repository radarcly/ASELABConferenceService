package com.example.demo.controller;

import com.example.demo.controller.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@Service
public class ConferenceService implements ConferenceRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void invitePCMember(int conferenceId,int userId){
        String sql = "insert into authorityinvitation (conferenceId,userId) values (?,?)";
        jdbcTemplate.update(sql,conferenceId,userId);
    }

    @Override
    public void joinConference(int userId, int conferenceId){
        String sql = "insert into contributorapplication (conferenceId,userId) values (?,?)";
        jdbcTemplate.update(sql,conferenceId,userId);

    }

    @Override
    public void distributeAuthority(int userId, int conferenceId){
        String sql = "insert into authority (conferenceId,userId) values (?,?)";
        jdbcTemplate.update(sql,conferenceId,userId);

    }

    @Override
    public void conferenceOpenSubmit(int userId, int conferenceId){
        String sql = "insert into contributor (conferenceId,userId) values (?,?)";
        jdbcTemplate.update(sql,conferenceId,userId);
    }

    @Override
    public int conferenceApplication(int userId,String nameAbbreviation,String fullName,String time,String location,String deadline,String resultAnnounceDate){
        String sql = "insert into conference (ownerId,nameAbbreviation,fullName,time,location,deadline,resultAnnounceDate) values (?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, userId);
                ps.setString(2, nameAbbreviation);
                ps.setString(3, fullName);
                ps.setString(4, time);
                ps.setString(5, fullName);
                ps.setString(6, location);
                ps.setString(7, resultAnnounceDate);
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Map<String,Object>> showConferences(){
        String sql = "SELECT * FROM conference";
        return jdbcTemplate.queryForList(sql);
    }
}
