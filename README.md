# ASELABConferenceService
## 部署
dockerfile

FROM java:8

COPY "./target/conference-0.0.1-SNAPSHOT.jar" "/conference-0.0.1-SNAPSHOT.jar"

EXPOSE 8080

CMD ["java", "-jar","conference-0.0.1-SNAPSHOT.jar","--spring.profiles.active=product"]

## 运行
#!/bin/bash

mvn clean package -DskipTests

docker build -t aselab:conference .

docker run -p 8080:8080 -d --name aselabconferenceservice aselab:conference

## REST api的访问
1.申请创建会议

http://{{ip}}/api/conference/ConferenceApplication

method:POST

header:{Content-Type: application/json;charset=UTF-8}

data：

|  字段   | 类型  | 是否必填| 描述 |
|  ----  | ----  |----  |----  |
| userId| int   |Y     | 用户的id|
| nameAbbreviation| string   |Y     | 会议简称|
| fullname| string   |Y     | 全名|
|time| string   |Y     | 会议时间|
| location| string   |Y     | 会议地点|
| deadline| string   |Y     | 截稿日期|
| resultAnnounceDate| string   |Y     | 会议录取结果公布时间|

return：

```json
{
     "errorCode": 0,
     "message": "success!",
     "data": {
         "conferenceId": 0
     }
}
```

2.开启会议投稿

http://{{ip}}/api/conference/ConferenceOpenSubmit

method:POST

header:{Content-Type: application/json;charset=UTF-8}

data：

|  字段   | 类型  | 是否必填| 描述 |
|  ----  | ----  |----  |----  |
| userId| int   |Y     | 会议发起人的userId|
|conferenceId| int   |Y     | 	会议的id|

return：

```json
{
     "errorCode": 0,
     "message": "success!"     
}
```

3.邀请投稿人

http://{{ip}}/api/conference/InvitePCMember

method:POST

header:{Content-Type: application/json;charset=UTF-8}

data：

|  字段   | 类型  | 是否必填| 描述 |
|  ----  | ----  |----  |----  |
| userId| int   |Y     | 会议发起人的userId|
|conferenceId| int   |Y     | 	会议的id|
|pcMemberId| int   |Y     | 	被邀请人的userId|

return：

```json
{
     "errorCode": 0,
     "message": "success!"     
}
```

4.申请加入会议

http://{{ip}}/api/conference/joinConference

method:POST

header:{Content-Type: application/json;charset=UTF-8}

data：

|  字段   | 类型  | 是否必填| 描述 |
|  ----  | ----  |----  |----  |
| userId| int   |Y     | 申请加入会议的userId|
|conferenceId| int   |Y     | 	会议的id|


return：

```json
{
     "errorCode": 0,
     "message": "success!"     
}
```

5.分发稿件

http://{{ip}}/api/conference/DistributeAuthority

method:POST

header:{Content-Type: application/json;charset=UTF-8}

data：

|  字段   | 类型  | 是否必填| 描述 |
|  ----  | ----  |----  |----  |
| userId| int   |Y     | 相当于检查当前用户是否有分发稿件的权限。|
|conferenceId| int   |Y     | 	分发会议的Id|


return：

```json
{
     "errorCode": 0,
     "message": "success!"     
}
```

6.展示所有会议

http://{{ip}}/api/conference/ShowConferences

method:GET

header:{Content-Type: application/json;charset=UTF-8}

data：

无

return：

```json
  {
    "errorCode": 0,
    "message": "success!",
    "data": [
        {
            "id": 0,
            "nameAbbreviation": "NARSAC",
            "...": "..."
        }
    ]
  }
```

7.收到用户接受或拒绝主席PC Member邀请的信息

http://{{ip}}/api/conference/UserAcceptORDeclinePCMemberInvite

method:POST

header:{Content-Type: application/json;charset=UTF-8}

data：

|  字段   | 类型  | 是否必填| 描述 |
|  ----  | ----  |----  |----  |
| userId| int   |Y     | 用户id|
|conferenceId| int   |Y     | 会议的Id|
|pcMemberId| int   |Y     | 主席的Id|
return：

```json
  {
    "errorCode": 0,
    "message": "success!"    
  }
```

8.当论文录用结果发布后，给所有author发通知

http://{{ip}}/api/conference/AuthorInfoAfterPaperResult

method:POST

header:{Content-Type: application/json;charset=UTF-8}

data：

|  字段   | 类型  | 是否必填| 描述 |
|  ----  | ----  |----  |----  |
| userIds| Arraylist<Integer>   |Y     | 用户id|
|messages| Arraylist<String>   |Y     | 发送信息|

return：

```json
  {
    "errorCode": 0,
    "message": "success!"    
  }
```