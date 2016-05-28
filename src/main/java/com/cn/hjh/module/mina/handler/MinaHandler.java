package com.cn.hjh.module.mina.handler;




import com.cn.hjh.module.mina.session.MyConnection;
import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;


/**
 * Created by yourdady on 2016/5/11.
 */
public class MinaHandler  implements IoHandler {
	
	private Logger log = Logger.getLogger(this.getClass());
    private  static final String CONNECTION_NAME = "CONNECTION_NAME";
	private  static final String MESSAGE_HANDLER = "MESSAGE_HANDLER";
	
	

    public void sessionCreated(IoSession session) throws Exception {
        log.debug("session创建出来了");
    }

    public void sessionOpened(IoSession session) throws Exception {
        log.debug("session打开");
        log.info(session.getRemoteAddress());
        //连接类
        MyConnection connection = new MyConnection(session.getRemoteAddress().toString(),session);
        session.setAttribute(CONNECTION_NAME, connection);
        //处理类
        MessageHandler messageHandler = new MessageHandler(connection);
        session.setAttribute(MESSAGE_HANDLER,messageHandler);
    }

    public void sessionClosed(IoSession session) throws Exception {
    	log.debug("session关闭");
    }

    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
    	log.debug("session空闲");
    }

    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
    	log.warn("session出错了"+cause.toString());
    	cause.printStackTrace();
    }

    public void messageReceived(IoSession session, Object message) throws Exception {
        log.debug("session接受到信息");
        log.info("接受的信息为："+message.toString());
        MessageHandler handler = (MessageHandler) session.getAttribute(MESSAGE_HANDLER);
        handler.process(message);
    }

    public void messageSent(IoSession session, Object message) throws Exception {
        log.debug("session发送信息");
        log.info("发送的信息为："+message.toString());
    }

}
