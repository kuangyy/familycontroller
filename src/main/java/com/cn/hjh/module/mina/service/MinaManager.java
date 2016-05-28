package com.cn.hjh.module.mina.service;

import com.cn.hjh.module.mina.session.MyConnection;
import com.cn.hjh.module.mina.session.SessionManager;
import org.apache.log4j.Logger;

import java.util.*;


/**
 * Created by yourdady on 2016/5/11.
 */
public class MinaManager {

    private static MinaManager  minaManger ;

    private static SessionManager sessionManger;

    private MinaManager(){
        sessionManger = SessionManager.getInstance();
    }

    protected Logger log = Logger.getLogger(this.getClass());

    public static MinaManager getInstance() {
        if( minaManger == null){
            minaManger = new MinaManager();
            return minaManger;
        }
        return minaManger;
    }


    public List<Map<String,String>> getPhoneOnLine() {
        Map<String, MyConnection> phoneSessions = sessionManger.getPhoneSessions();
        Set<String> strings = phoneSessions.keySet();
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        for (String name:strings) {
            HashMap<String,String> map = new HashMap<String,String>();
            map.put("name",name);
            map.put("session",phoneSessions.get(name).getIoSession().toString());
            list.add(map);
        }
        return list;
    }



    //销毁nima
    public void destory() {
        log.trace("销毁mina");
        sessionManger.destory();
    }
}
