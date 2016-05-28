<%--
  Created by IntelliJ IDEA.
  User: hehe
  Date: 2016/4/24
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="menu" uri="Menu" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <%--<base href="<%=basePath%>">--%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>空白模版</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/resource/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="<%=path%>/resource/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="<%=path%>/resource/css/style.css" rel="stylesheet">
    <link href="<%=path%>/resource/css/style-responsive.css" rel="stylesheet" />
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="<%=path%>/resource/js/html5shiv.js"></script>
    <script src="<%=path%>/resource/js/respond.min.js"></script>
    <![endif]-->
    <!--zTree css-->
    <link href="<%=path%>/resource/zTree/css/zTreeStyle.css" rel="stylesheet">
</head>
<body>
<section id="container" class="">
    <!--header start-->
    <jsp:include page="../base/baseHeader.jsp"/>
    <!--header end-->
    <!--sidebar start-->
    <!--这里写查看信息，就是定位到那-->
    <menu:firstMenu  menuName="角色管理"></menu:firstMenu>
    <!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            <!-- page start-->
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            角色管理
                        </header>
                        <table class="table table-striped table-advance table-hover">
                            <thead>
                            <tr>
                                <th><i class="icon-bullhorn"></i> 角色名字</th>
                                <th class="hidden-phone"><i class="icon-question-sign"></i> 描述</th>
                                <th><i class="icon-bookmark"></i> 创建时间</th>
                                <th><i class=" icon-edit"></i> 操作</th>
                                <th> <button class="btn  btn-warning" ><i class="icon-plus-sign"></i></button></th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${roleList}" var="role">
                                <tr>
                                    <td><a href="#">${role.roleName}</a></td>
                                    <td class="hidden-phone">${role.roleDesc}</td>
                                    <td><fmt:formatDate value="${role.roleCreateDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                                    <td>
                                        <button class="btn btn-primary btn-xs" onclick="showPermissions(${role.roleId})"><i class="icon-cog"></i></button>
                                        <button class="btn btn-primary btn-xs" onclick="modifyRole(${role.roleId},'${role.roleName}','${role.roleDesc}')"><i class="icon-pencil"></i></button>
                                        <button class="btn btn-danger btn-xs" onclick="showModal(${role.roleId})" ><i class="icon-trash "></i></button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <!-- Modal -->
                        <form id="roleDelteForm" method="get">
                            <div class="modal fade" id="roleDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title">系统消息</h4>
                                        </div>
                                        <div class="modal-body">
                                            <span style="font-size: larger">您确定要进行删除吗？</span>
                                        </div>
                                        <div class="modal-footer">
                                            <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                                            <button class="btn btn-warning"  type="submit">确定</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>

                        <form  action = "<%=path%>/role/updateRole" method="post">
                            <div class="modal fade" id="roleModify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                                            <h4 class="modal-title">角色修改</h4>
                                        </div>
                                        <div class="modal-body">
                                                <div class="form-group">
                                                    <input type="hidden" name = "roleId" id ="roleId" >
                                                    <label >角色名称</label>
                                                    <input type="text" class="form-control" name = "roleName"  id = "roleName" placeholder="">
                                                </div>
                                                <div class="form-group">
                                                    <label >角色描述</label>
                                                    <input type="text" class="form-control" name = "roleDesc" id = "roleDesc" placeholder="">
                                                </div>
                                                <button type="submit"  class="btn btn-default">确定</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>

                        <div class="modal fade" id="roleShow" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title">权限修改</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div id="tree" class="zTreeDemoBackground">
                                            <ul id="treeDemo" class="ztree" style="margin-top:10px;"></ul>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
                                        <button class="btn btn-warning" disabled="false"  id = "uptBtn"  type="submit">修改</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- modal -->
                    </section>
                </div>
            </div>
            <!-- page end-->
        </section>
    </section>
    <!--main content end-->
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="<%=path%>/resource/js/jquery.js"></script>
<script src="<%=path%>/resource/js/bootstrap.min.js"></script>
<script src="<%=path%>/resource/js/jquery.scrollTo.min.js"></script>
<script src="<%=path%>/resource/js/jquery.nicescroll.js" type="text/javascript"></script>
<!--common script for all pages-->
<script src="<%=path%>/resource/js/common-scripts.js"></script>
<!--本工程的base js-->
<script src="<%=path%>/resource/myResource/base/js/jquery.cookie.js"></script>
<script src="<%=path%>/resource/myResource/base/js/baseJs.js"></script>

<!--zTree js-->
<script src="<%=path%>/resource/zTree/js/jquery.ztree.core-3.5.min.js"></script>
<script src="<%=path%>/resource/zTree/js/jquery.ztree.excheck-3.5.min.js"></script>

<script>
    function showModal(roleId){
        $('#roleDelete').on('show.bs.modal', function (e) {
            $("#roleDelteForm").attr("action", basePath+"/role/delete/"+roleId);
        });
        $("#roleDelete").modal();
    }


    function showPermissions(roleId){
        $('#roleShow').on('show.bs.modal', function (e) {
            initZtree(roleId);
        });
        $("#roleShow").modal();
    }
    var role_id ;

    function initZtree(roleId){
        role_id = roleId;
        var setting = {
            treeId:'tree',
            check:{enable:true},
            data:{
                simpleData:{enable : true,idKey : "permissionId",pIdKey : "permissionParentId",rootPId:null},
                key:{name:"permissionName",checked: "permissionExtr"}
            },
            callback:{
                onCheck: zTreeOnCheck
            }
        };
        $.post("/FamilyController/permission/show/"+roleId,{},function(data){
            var zTree = $.fn.zTree.init($("#treeDemo"), setting,data);
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
            treeObj.expandAll(true);
        });
    }

    function zTreeOnCheck(event, treeId, treeNode){
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = treeObj.getChangeCheckedNodes();
        for(var i=0;i<nodes.length;i++){
            nodes[i].permissionExtr2 = role_id;
        }
        if(nodes !=''){
            $("#uptBtn").attr("disabled",false);
        }
        else{
            $("#uptBtn").attr("disabled",true);
        }
    };

    /**
     * 修改弹出框
     **/
    $("#uptBtn").click(function(){
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = treeObj.getChangeCheckedNodes();
        var array = new Array();
        for(var i=0;i<nodes.length;i++){
            var a = {
                permissionId:nodes[i].permissionId,
                permissionParentId:nodes[i].permissionParentId,
                permissionExtr:nodes[i].permissionExtr,
                permissionExtr2:nodes[i].permissionExtr2
        };
            array.push(a);
        }
        $.ajax({
            url:basePath+"/permission/modifyPermissions",
            type: "POST",
            contentType:"application/json;charset=UTF-8",
            dataType: "json",
            data:JSON.stringify(array),
            success:function(data){
                $("#roleShow").modal("hide");
            }
        });
    });


    function modifyRole(roleId,roleName,roleDesc){
        $('#roleModify').on('show.bs.modal', function (e) {
            $("#roleId").val(roleId);
            $("#roleName").attr("placeholder",roleName);
            $("#roleName").attr("value",roleName);
            $("#roleDesc").attr("placeholder",roleDesc);
            $("#roleDesc").attr("value",roleDesc);
        });
        $("#roleModify").modal();
    }


    function sRole(){
        $("#roleForm").submit();
    }
</script>
</body>
</html>
