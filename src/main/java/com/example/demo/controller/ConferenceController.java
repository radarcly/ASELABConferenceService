package com.example.demo.controller;

import com.example.demo.controller.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
@RequestMapping(value = "/api/conference")
public class ConferenceController {
    @Autowired
    ConferenceService conferenceService;

    //邀请审稿人
    @PostMapping("/InvitePCMember")
    public ResponseEntity <Map<String,Object>> createConference(@RequestBody InvitePCMemberRequest request){
        conferenceService.invitePCMember(request.getConferenceId(),request.getPcMemberID());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","success!");
        map.put("errorCode","0");
        return ResponseEntity.ok(map);
    }

    //申请加入会议
    @PostMapping("/joinConference")
    public ResponseEntity <Map<String,Object>> joinConference(@RequestBody JoinConferenceRequest request){
        conferenceService.joinConference(request.getConferenceId(),request.getUserId());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","success!");
        map.put("errorCode","0");
        return ResponseEntity.ok(map);
    }

    //分发稿件
    @PostMapping("/DistributeAuthority")
    public ResponseEntity <Map<String,Object>> distributeAuthority(@RequestBody DistributeAuthorityRequest request){
        conferenceService.distributeAuthority(request.getConferenceId(),request.getUserId());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","success!");
        map.put("errorCode","0");
        return ResponseEntity.ok(map);
    }

    //开启会议投稿
    @PostMapping("/ConferenceOpenSubmit")
    public ResponseEntity <Map<String,Object>> onferenceOpenSubmit(@RequestBody ConferenceOpenSubmitRequest request){
        conferenceService.conferenceOpenSubmit(request.getConferenceId(),request.getUserId());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","success!");
        map.put("errorCode","0");
        return ResponseEntity.ok(map);
    }

    //申请创建一个会议
    @PostMapping("/ConferenceApplication")
    public ResponseEntity <Map<String,Object>> conferenceOpenSubmit(@RequestBody ConferenceApplicationRequest request){
        int key = conferenceService.conferenceApplication(request.getUserId(),request.getNameAbbreviation(),request.getFullname(),request.getTime(),request.getLocation(),request.getDeadline(),request.getResultAnnounceDate());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","success!");
        map.put("errorCode","0");
        Map<String,Integer> map1 = new HashMap<String, Integer>();
        map1.put("conferenceId",key);
        map.put("data",map1);
        return ResponseEntity.ok(map);
    }

    //展示所有会议
    @GetMapping("/ShowConferences")
    public ResponseEntity <Map<String,Object>> showConferences(){
        List<Map<String,Object>> list = conferenceService.showConferences();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","success!");
        map.put("errorCode","0");
        map.put("data",list);
        return ResponseEntity.ok(map);
    }

    //收到用户接受或拒绝主席PC Member邀请的信息
    @GetMapping("/UserAcceptORDeclinePCMemberInvite")
    public ResponseEntity <Map<String,Object>> UserAcceptORDeclinePCMemberInvite(@RequestBody UserAcceptORDeclinePCMemberInviteRequest request){
        //请求地址
        String url = "47.100.106.153:21000/message/SendMessage";
        String message;
        if(request.isAccept()){
            message = request.getUserId() + "接受了" + request.getConferenceId() + "的邀请";
        }else{
            message = request.getUserId() + "拒绝了" + request.getConferenceId() + "的邀请";
        }
        //入参
        RequestBean requestBean = new RequestBean(request.getPcMemberID(),message,"accept");

        RestTemplate restTemplate = new RestTemplate();
        ResponseBean responseBean = restTemplate.postForObject(url, requestBean, ResponseBean.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","success!");
        map.put("errorCode","0");

        return ResponseEntity.ok(map);
    }

    //当论文录用结果发布后，给所有author发通知
    @GetMapping("/AuthorInfoAfterPaperResult")
    public ResponseEntity <Map<String,Object>> AuthorInfoAfterPaperResult(@RequestBody AuthorInfoAfterPaperResultRequest request){
        //请求地址
        String url = "47.100.106.153:21000/message/SendMessage";
        String message = "论文录用结果发布了";
        for(int i=0;i<request.getUserID().size();i++){
            RequestBean requestBean = new RequestBean(request.getUserID().get(i),message,"accept");

            RestTemplate restTemplate = new RestTemplate();
            ResponseBean responseBean = restTemplate.postForObject(url, requestBean, ResponseBean.class);
        }
        //入参
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","success!");
        map.put("errorCode","0");

        return ResponseEntity.ok(map);
    }


}
