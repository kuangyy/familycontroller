package com.cn.hjh.module.mina.controller;

import com.cn.hjh.module.mina.service.MinaManager;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yourdady on 2016/5/11.
 */
@Controller
@RequestMapping("mina")
public class ChatController  {


    private MinaManager minaManger;
    public ChatController(){
        minaManger = MinaManager.getInstance();
    }

    @RequestMapping("showAll")
    public ModelAndView showAll(){
        List<Map<String,String>> list =  minaManger.getPhoneOnLine();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("sessionList",list);
        return new ModelAndView("backage/mina/mina_show",map);
    }

    @PreDestroy
    public void Destory(){
        minaManger.destory();
    }
}
