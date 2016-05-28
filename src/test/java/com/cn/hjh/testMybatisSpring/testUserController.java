package com.cn.hjh.testMybatisSpring;

import com.cn.hjh.module.Permission.controller.PermissionController;
import com.cn.hjh.module.User.controller.UserController;
import com.cn.hjh.module.User.serv.UserServ;
import com.cn.hjh.module.User.serv.impl.UserServImpl;
import com.cn.hjh.po.PermissionVO;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by hehe on 2016/4/16.
 */
public class testUserController   {

    public static ApplicationContext ac;
    @BeforeClass
    public static void setBeforClass() throws  Exception{
        ac = new ClassPathXmlApplicationContext("classpath:xml/db.xml") ;
    }

    @Test
    public void test(){
        UserController controller = ac.getBean("userController", UserController.class);
        controller.insertUser("黄建辉","123123");
    }

    @Test
    public void testPermission(){
        PermissionController controller = ac.getBean("permissionController", PermissionController.class);
        List<PermissionVO> permissionVOs = controller.showRolePermission(1);
        for(PermissionVO p : permissionVOs){
            System.out.println(p.getPermissionName()+"  "+p.getPermissionExtr());
        }
    }
//
//    @Test
//    public void testVali(){
//            UserController controller = ac.getBean("userController", UserController.class);
//    }
}
