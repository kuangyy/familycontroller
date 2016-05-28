package com.cn.hjh.module.family.serv;

import com.cn.hjh.po.FamilyVO;

import java.util.List;

/**
 * Created by kuangye on 2016/5/28.
 */
public interface FamilyServ {


    List<FamilyVO> list(FamilyVO familyVO);

    boolean add(FamilyVO familyVO);

    boolean edit(FamilyVO familyVO);

    boolean del(String uuid);



}
