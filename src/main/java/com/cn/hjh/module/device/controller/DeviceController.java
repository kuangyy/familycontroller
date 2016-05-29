package com.cn.hjh.module.device.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by yourdady on 2016/5/30.
 * 终端进行拉取信息的
 */
@RequestMapping("device")
public class DeviceController {

    /**
     * 通过穿过来的familyId 进行获取到所要的信息
     * @param familyId
     * @return
     */
    @RequestMapping("getFamilyInfo/{familyId}")
    @ResponseBody
    public String getFamilyInfo(@PathVariable String familyId){
        return null;
    }
}
