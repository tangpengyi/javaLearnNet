<%--
  Created by IntelliJ IDEA.
  User: tpy
  Date: 2019/11/30
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Java Learn Net</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <c:set var="baseurl" value="${pageContext.request.contextPath }"></c:set>



    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${baseurl}/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${baseurl}/static/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${baseurl}/static/dist/css/skins/_all-skins.min.css">

    <style type="text/css">

        /*<link rel="stylesheet" href="/dist/css/AdminLTE.min.css">*/
        body {
            margin: 0;
        }

        /* 头部样式 */
        .header {
            background-color: #FFFFFF;
            padding: 10px;
            text-align: center;
        }

        /* 导航条 */
        .topnav {
            overflow: hidden;
            background-color: #F4F4F4;
            margin-left: 2%;
            margin-right: 2%;
        }


        /* 右侧目录 */
        .youmulu {
            overflow: hidden;
            background-color: #FFFFFF;

        }
        .youmulu a {
            float: left;
            display: block;
            color: #000000;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        .youmulu a:hover {
            background-color: #E5E5E5;
            color: black;
        }



        /* 导航链接 */
        .topnav a {
            float: left;
            display: block;
            color: #000000;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;

        }

        /* 链接 - 修改颜色 */
        .topnav a:hover {
            background-color: #E5E5E5;
            color: black;
        }

        /* 创建三个不相等的列 */
        .column {
            float: left;
            padding: 10px;
        }

        /* 左右两侧宽度 */
        .column.left{
            width: 10%;
            margin-left: 2%;
        }
        .column.right {
            width: 10%;
            margin-right: 2%;
        }


        /* 中间区域宽度 */
        .column.middle {
            width: 69%;
            margin-left: 2%;
        }

        /* 列后面清除浮动 */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* 响应式布局 - 宽度小于600px时设置上下布局 */
        @media screen and (max-width: 600px) {
            .column.side, .column.middle {
                width: 100%;
            }
        }
    </style>
</head>
<body>


<jsp:include page="/static/include/contextHead.jsp" />


<div class="row">
    <div class="column left" style="border:1px solid #DBDAD7 ;">
        <div style="text-align:center; background-color:#F4F4F4;">
            <h4>资源类型</h4>
        </div>

        <div class="youmulu">
            <a href="/rmIndex">软件下载</a>
        </div>

        <div class="youmulu">
            <a href="/jarResource">jar包下载</a>
        </div>
    </div>


    <div class="column middle">
        首页
    </div>

    <div class="column right">
        <p>广====================中！</p>
    </div>
</div>


<div style="text-align: center; padding-top: 40px">
    版权所属：&copy;长沙学院洪山一栋133
</div>


<!-- jQuery 3 -->
<script src="${baseurl}/static/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap 3.3.7 -->
<script src="${baseurl}/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>


</body>
</html>
