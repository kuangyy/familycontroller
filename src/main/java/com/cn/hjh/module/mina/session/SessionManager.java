package com.cn.hjh.module.mina.session;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yourdady on 2016/5/11.
 */
public class SessionManager {

    private Logger log = Logger.getLogger(this.getClass());

    private static  SessionManager sessionManager;

    private ClassPathXmlApplicationContext context ;
    
    //手机端的session
    private Map<String,MyConnection> phoneSessions = new HashMap<String, MyConnection>();
    //家庭端的session
    private Map<String,MyConnection> clientSessions = new HashMap<String, MyConnection>();

    
    
    private SessionManager(){
    	context = new ClassPathXmlApplicationContext("xml/spring-mina.xml");
    }

    

	public static SessionManager getInstance() {
        if(sessionManager == null){
            sessionManager = new SessionManager();
            return sessionManager;
        }
        return sessionManager;
    }



	/**
	 * 将conn的存入map中去
	 * @param name
	 * @param conn
	 */
	public void putPhoneMap(String name, MyConnection conn) {
		phoneSessions.put(name, conn);
	}


	public void putClientMap(String name, MyConnection conn) {
		clientSessions.put(name, conn);
	}


    public Map<String, MyConnection> getClientSessions() {
        return clientSessions;
    }

    public void setClientSessions(Map<String, MyConnection> clientSessions) {
        this.clientSessions = clientSessions;
    }

    public Map<String, MyConnection> getPhoneSessions() {
        return phoneSessions;
    }

    public void setPhoneSessions(Map<String, MyConnection> phoneSessions) {
        this.phoneSessions = phoneSessions;
    }


    /**
     * 销毁mina服务器
     */
    public void destory() {
        log.trace("销毁mina");
        NioSocketAcceptor ioAcceptor = (NioSocketAcceptor) context.getBean("ioAcceptor");
        ioAcceptor.dispose();
    }
}
