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
    <menu:firstMenu  menuName="查看连接"></menu:firstMenu>
    <!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            <!-- page start-->
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            连接查看
                        </header>
                        <table class="table table-striped table-advance table-hover">
                            <thead>
                            <tr>
                                <th class="hidden-phone"><i class="icon-question-sign"></i> 用户名</th>
                                <th><i class="icon-bookmark"></i> session</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${sessionList}" var="index">
                                <tr>
                                    <td class="hidden-phone">${index.name}</td>
                                    <td>${index.session}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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
<script src ="<%=path%>/resource/myResource/base/js/baseJs.js"></script>

<!--zTree js-->
<script src="<%=path%>/resource/zTree/js/jquery.ztree.core-3.5.min.js"></script>
<script src="<%=path%>/resource/zTree/js/jquery.ztree.excheck-3.5.min.js"></script>

<script>
</script>
</body>
</html>
