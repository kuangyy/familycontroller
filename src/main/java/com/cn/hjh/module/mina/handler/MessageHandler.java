package com.cn.hjh.module.mina.handler;


import com.cn.hjh.module.mina.message.LoginMessage;
import com.cn.hjh.module.mina.message.MessageVO;
import com.cn.hjh.module.mina.session.MyConnection;
import com.cn.hjh.module.mina.session.SessionManager;
import com.google.gson.Gson;


/**
 * 消息处理类
 */
public class MessageHandler {
	
	private MyConnection conn;
	private Gson gson = new Gson();
	private SessionManager sessionManager;

	public MessageHandler(MyConnection connection) {
		this.conn = connection;
		sessionManager = sessionManager.getInstance();
	}

	
	//处理message
	public void process(Object message) {
		String str = message.toString();
		MessageVO msg = gson.fromJson(str.trim(),MessageVO.class);
		switch(msg.getMessageStatus()){
			case MessageVO.MESSAGE_LOGIN:
				LoginMessage loginMessage = gson.fromJson(message.toString().trim(),LoginMessage.class);
				processLogin(loginMessage);
				break;
		}
	}

	//处理登陆的Message
	private void processLogin(LoginMessage loginMessage) {
		String name = loginMessage.getFrom();
		if(loginMessage.getMessageStatus() == MessageVO.ADDRESS_PHONE){
			sessionManager.putPhoneMap(name,conn);
		}else{
			sessionManager.putClientMap(name,conn);
		}
	}

}
