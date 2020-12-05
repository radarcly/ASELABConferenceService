package com.example.demo.controller.request;

import java.util.ArrayList;

public class AuthorInfoAfterPaperResultRequest {
    ArrayList<Integer> userID;

    public AuthorInfoAfterPaperResultRequest(ArrayList<Integer> userID) {
        this.userID = userID;
    }

    public ArrayList<Integer> getUserID() {
        return userID;
    }

    public void setUserID(ArrayList<Integer> userID) {
        this.userID = userID;
    }
}
