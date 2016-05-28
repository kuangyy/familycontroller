package com.cn.hjh.commom;

import com.cn.hjh.po.PermissionVO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by hehe on 2016/4/22.
 */
public class MenuTag extends TagSupport {
    /**
     * 所在的页面的名字
     */
    private String menuName;
    @Override
    public int doStartTag() throws JspException {
        String id = null;
        String workName = (String) this.pageContext.getSession().getAttribute(Constants.ITEM_NAME);
        StringBuffer sb = new StringBuffer("<aside><div id=\"sidebar\"  class=\"nav-collapse \"><ul class=\"sidebar-menu\">");
        List<PermissionVO> list = (List<PermissionVO>) this.pageContext.getSession().getAttribute(Constants.PERMISSION_SESSION_KEY);
        for(PermissionVO permission:list){
            sb.append("<li class=\"sub-menu\"><a href=\"javascript:;\" id = 'permission_"+permission.getPermissionId()+"' class=\"\"><i class=\"icon-book\"></i>");
            sb.append("<span>"+permission.getPermissionName()+"</span>");
            sb.append("<span class=\"arrow\"></span></a><ul class=\"sub\">");
            List<PermissionVO> permissions = permission.getPermissions();
            for(PermissionVO p:permissions){
                if(p.getPermissionName().equals(menuName)){
                    sb.append("<li class=\"active\"><a  href='"+workName+p.getPermissionUrl()+"'>"+p.getPermissionName()+"</a></li>");
                    id = "permission_"+permission.getPermissionId();
                }else{
                    sb.append("<li><a class=\"\" href='"+workName+p.getPermissionUrl()+"'>"+p.getPermissionName()+"</a></li>");
                }
            }
            sb.append("</ul>");
            sb.append("</li>");
            sb.append("<input type='hidden' id ='permissionId' value = '"+id+"'>");
        }
        sb.append("</ul></div></aside>");
        JspWriter out = this.pageContext.getOut();
        try {
            out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName.trim();
    }
}
