<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <!--小图标
    <link rel="shortcut icon" href="img/favicon.html">-->
    <title>登录界面</title>
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
</head>
  <body class="login-body">

    <div class="container">

      <form class="form-signin" action="<%=path%>/user/login" method="post">
        <h2 class="form-signin-heading">登录</h2>
        <div class="login-wrap">
            <input type="text" id = "userName" name ="userName" class="form-control" placeholder="用 户 名" autofocus>
            <input type="password" name="password" class="form-control" placeholder="密   码">
            <label class="checkbox">
                <input type="checkbox"  id = "userNameTag" value="remember-me" > 记住账号
                <span class="pull-right" > <a href="#"> 忘记密码？</a></span>
            </label>
            <button class="btn btn-lg btn-login btn-block" onclick="saveUserName()" type="submit">登  录</button>
            <p><font color = "red" size = "2">
                <c:if test="${ message == false}">
                    你输入的用户名不存在或者密码错误
                </c:if>
            </font></p>
        </div>

      </form>

    </div>

  </body>
    <script src="<%=path%>/resource/myResource/base/js/jquery-1.9.1.js"></script>
    <script src="<%=path%>/resource/myResource/base/js/jquery.cookie.js"></script>
    <script >
        //初始化的时候就进行执行
        $(document).ready(function(){
            //在cookie中得到rmUser 进行判断
            if($.cookie("rmUser") == "true"){
                //将其checkbox 的标签进行设为true
                $("#userNameTag").prop("checked",true);
                //将cookie中的值取出来
                $("#userName").val($.cookie("userName"));
                }

        });
        function saveUserName(){
            //得到check的标签
            if($("#userNameTag").prop("checked") == true){
                var userName = $("#userName").val();
                //在cookie中存放一个叫 reUser的变量 将值给成 true 并且存七天
                $.cookie("rmUser","true",{expires:7});
                $.cookie("userName",userName,{expires:7});
            }else{
                //否则就进行删除cookie  将expires 的值变成-1的时候 就是删除 expires: -1 必须空格
                $.cookie("rmUser","false",{ expires: 7});
                $.cookie("userName",'',{ expires: -1});
            }
        }
    </script>
</html>
