package com.cn.hjh.module.mina.message;

import com.google.gson.Gson;

import java.util.Date;

/**
 * Created by yourdady on 2016/5/17.
 */
public class LoginMessage extends  MessageVO {

    private String userName;
    private String password;

    public LoginMessage(String userName,String password){
        this.userName = userName;
        this.password = password;
        this.messageStatus = MessageVO.STAUTS_LOGIN;
        this.device = MessageVO.ADDRESS_PHONE;
        this.from  = "123";
        this.to = "123";
    }

    public static void main(String[] args) {
        LoginMessage loginMessage = new LoginMessage("123","123");
        System.out.println(loginMessage.toJson());
        String string = " {password:\"35485698-7f91-49e5-a106-a7f51ca13999\",userName:\"c0d1224a-09ac-4705-a2fd-6466562e10cc\",date:\"May 17, 2016 9:20:14 AM\",device:1,from:\"123\",messageStatus:1,to:\"123\"}";
        System.out.println(string);
        MessageVO messageVO = new Gson().fromJson(string,MessageVO.class);
        System.out.println(messageVO.getFrom());
    }
}
