<%--
  Created by IntelliJ IDEA.
  User: hehe
  Date: 2016/4/20
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="com.cn.hjh.commom.*" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!--sidebar start-->
<aside>
    <div id="sidebar"  class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
            <%//TODO 这里出现硬编码了 一定要注意%>
            <c:forEach items="${sessionScope.permission_session_key}" var="permission">
                <li class="sub-menu">
                    <a href="javascript:;" class="">
                        <i class="icon-book"></i>
                        <span>${permission.permissionName}</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <c:forEach items="${permission.permissions}" var="p">
                            <li><a class="" href="${p.permissionUrl}">${p.permissionName}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->