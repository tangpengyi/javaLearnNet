<%--
  Created by IntelliJ IDEA.
  User: tpy
  Date: 2019/11/23
  Time: 20:49
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



<div class="context">

    <div class="teacherButton" ${requestScope.user.getUserCharactor() == 2?"style='display: none'":" "}>
        <div class="btn-group">
            <a class="btn btn-default" href="/addResourcePage?filetype=${requestScope.filetype}">添加资源</a>
            <a href="/deleteResourcePage?filetype=${requestScope.filetype}" class="btn btn-default">删除资源</a>
        </div>
    </div>




    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">添加软件资源</h3>
        </div>
        <!-- /.box-header -->


        <form id="uploadForm" enctype="multipart/form-data" method="post">
            <div class="box-body">

                <label>类型：</label>
                <select id="selectid">
                    <option value="软件">软件</option>
                    <option value="jar">jar包</option>
                </select>
                <br/>
                <div class="form-group">
                    <label for="resourceName">资源名称</label>
                    <input type="text" class="form-control" id="resourceName" placeholder="文件名称">
                </div>
                <div class="form-group">
                    <label for="file">File input</label>
                    <input type="file" name="file" id="file">
                </div>
            </div>
        </form>

        <div class="box-footer">
            <button type="submit" class="btn btn-primary" onclick="addResources()">提交</button>
        </div>

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


<script type="text/javascript">
    function addResources() {

        var $resourceName = $("#resourceName").val();
        var $selectValue = $('#selectid').val();
        var formData = new FormData($('#uploadForm')[0]);
        formData.append("resourceName",$resourceName);
        formData.append("filetype",$selectValue);

        $.ajax({
            type: 'POST',
            url: '../../../addResource',
            data: formData,
            cache: false,
            processData: false,
            contentType: false,
            success: function (result) {
                alert("新增成功");
            },
            error: function (xhr) {
                alert("系统异常");
            }

        });

    }
</script>

</html>

