<%--
  Created by IntelliJ IDEA.
  User: tpy
  Date: 2019/11/23
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Java Learn Net</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <c:set var="baseurl" value="${pageContext.request.contextPath }"></c:set>

    <link rel="stylesheet" type="text/css" href="${baseurl}/static/shop/css/webbase.css"/>
    <link rel="stylesheet" type="text/css" href="${baseurl}/static/shop/css/pages-seckillOrder.css"/>
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


        .context {
            padding-right: 6%;
            padding-left: 6%;
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


<jsp:include page="/static/include/contextHead.jsp"/>

<div style="text-align: center"><h4>软件下载</h4></div>

<div class="context">

    <div class="teacherButton" ${sessionScope.user.getUserCharactor() == 0?"style='display: none'":" "}>
        <div class="btn-group">
            <a class="btn btn-default" href="<c:url value='/addResourcePage'/>?filetype=${requestScope.filetype}">添加资源</a>
            <a href="<c:url value='/deleteResourcePage'/>?filetype=${requestScope.filetype}" class="btn btn-default">删除资源</a>
        </div>
    </div>



    <div style="text-align: center;">
        <%--<form action="#" method="get">--%>
            <input type="text" name="searchContext" id="searchContext" placeholder="Search...">
        <%--</form>--%>
        <input type="button" value="搜索" onclick="search()"></input>
    </div>

    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">实例文章</h3>
                    </div>

                    <div class="box-body" style="align-content: center;padding-left: 6%;padding-right: 6%">
                        <table id="example2" class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>名称</th>
                                <th>文件类型</th>
                                <th>文件大小</th>
                                <th>下载次数</th>
                                <th>下载</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach var="resourceModels" items="${sessionScope.resourceModels}" varStatus="status">
                            <tr>
                                <td>${status.index+1}</td>
                                <td>${resourceModels.getResourceName()}</td>
                                <td>${resourceModels.getFiletype()}</td>
                                <td>${resourceModels.getFilesize()}KB</td>
                                <td>${resourceModels.getUploadcount()}</td>
                                <td><a href="<c:url value='/uploadResourceFile'/>?pathName=${resourceModels.getPath()}&num=${resourceModels.getNum()}">下载</a></td>

                            </tr>
                            </c:forEach>

                            </tbody>
                            <tfoot>
                            <tr>
                                <th>Rendering engine</th>
                                <th>Browser</th>
                                <th>Platform(s)</th>
                            </tr>
                            </tfoot>
                        </table>
                    </div>


                    <div class="choose-order">

                        <div class="sui-pagination pagination-large top-pages">
                            <ul>
                                <li class="prev disabled"><a href="#">«上一页</a></li>
                                <li class="active"><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li class="dotted"><span>...</span></li>
                                <li class="next"><a href="#">下一页»</a></li>
                            </ul>
                            <div><span>共10页&nbsp;</span>
                                <span>到<input type="text" class="page-num"><button class="page-confirm"
                                                                                   onclick="alert(1)">确定</button>页</span>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </section>

</div>

<div style="text-align: center; padding-top: 40px">
    版权所属：&copy;长沙学院洪山一栋133
</div>


<!-- jQuery 3 -->
<script src="${baseurl}/static/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap 3.3.7 -->
<script src="${baseurl}/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>


</body>


<script type="text/javascript">

    function test() {
        alert("===");
    }

    function uploadResource(path) {

        alert(path);

        $.ajax({
            url: "../../../uploadResourceFile",
            type: "get",
            data: {"num": path},
            success: function (result) {
                alert("下载成功");
            },
            error: function (xhr) {
                alert("系统异常");
            }
        })

    };

    function search() {
        var $searchContext = $("#searchContext").val();
        $.ajax({
            url: "../../../searchResource",
            请求方式: "get",
            data: {"searchContext": $searchContext},
            success: function (result) {
                window.location.href = "resourceIndex";
            },
            error: function (xhr) {
                alert("系统异常");
            }
        })
    };

</script>

</html>
