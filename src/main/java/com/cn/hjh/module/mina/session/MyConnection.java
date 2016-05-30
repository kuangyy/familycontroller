package com.cn.hjh.module.mina.session;


import com.cn.hjh.module.mina.message.MessageVO;
import org.apache.mina.core.session.IoSession;


/**
 * Created by yourdady on 2016/5/11.
 */
public class MyConnection {
	
	private IoSession ioSession;

	private String userName;
	
	private String adress;
	
	
	
	public MyConnection(String string, IoSession session) {
		this.userName = string;
		this.ioSession = session;
	}

	
	
	public IoSession getIoSession() {
		return ioSession;
	}

	public void setIoSession(IoSession ioSession) {
		this.ioSession = ioSession;
	}

	//发送
	public synchronized void  deliver(MessageVO m) {
		ioSession.write(m.toJson());
	}
	
	
	
}
