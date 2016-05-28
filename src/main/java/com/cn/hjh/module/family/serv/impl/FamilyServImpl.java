package com.cn.hjh.module.family.serv.impl;

import com.cn.hjh.dao.IFamilyDao;
import com.cn.hjh.module.family.serv.FamilyServ;
import com.cn.hjh.po.FamilyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by kuangye on 2016/5/28.
 */
public class FamilyServImpl implements FamilyServ {


    @Autowired
    private IFamilyDao iFamilyDao;


    public List<FamilyVO> list(FamilyVO familyVO) {

        Map<String, Object> map = new HashMap<>();
        //添加查询条件

        return iFamilyDao.list(map);
    }

    public boolean add(FamilyVO familyVO) {
        try {
            if (familyVO != null) {

                Assert.hasText(familyVO.getFamilyName(), "家庭名称不能为空");


                // generate uuid
                familyVO.setFamilyId(UUID.randomUUID().toString());


                return iFamilyDao.insertSelective(familyVO) > 0;
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return false;
    }

    public boolean edit(FamilyVO familyVO) {
        if (familyVO != null && familyVO.getFamilyId() != null) {


            return iFamilyDao.updateByPrimaryKeySelective(familyVO) > 0;
        }

        return false;
    }

    public boolean del(String uuid) {
        if (uuid != null && !uuid.trim().equals("")) {
            return iFamilyDao.deleteByPrimaryKey(uuid) > 0;
        }
        return false;
    }


    pub

}
