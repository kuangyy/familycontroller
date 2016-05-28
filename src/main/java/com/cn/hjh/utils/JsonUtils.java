package com.cn.hjh.utils;

import com.cn.hjh.module.mina.message.MessageVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by hehe on 2016/4/27.
 */
public class JsonUtils {

    public static <T> T jsonParsePo(String data, Class<T> type){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(data,type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toJson(Object o){
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  json;
    }

    public static void main(String[] args) {
        MessageVO messageVO = new MessageVO();
        messageVO.setFrom("双");
        messageVO.setDevice(1);
        System.out.print(toJson(messageVO));
    }


}
