package com.example.pratik.dashboard;

public class User {
    String userid,mobile,username,emailid,uniqueid,password;

    public User()
    { }
    public User(String userid,  String username, String emailid, String uniqueid,String mobile,String password) {
        this.userid = userid;
        this.mobile = mobile;
        this.username = username;
        this.emailid = emailid;
        this.password = password;
        this.uniqueid = uniqueid;
    }

    public String getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }
}
