<%--
  Created by IntelliJ IDEA.
  User: tpy
  Date: 2019/11/7
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Java Learn Net</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <c:set var="baseurl" value="${pageContext.request.contextPath }"></c:set>
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${baseurl}/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${baseurl}/static/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${baseurl}/static/dist/css/skins/_all-skins.min.css">

    <script src="${baseurl}/static/jQuery/jquery.1.8.3.min.js"></script>
    <%--<script type="text/javascript" src="${baseurl}/static/ckeditor/ckeditor.js"></script>--%>


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
        .column.left {
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


<jsp:include page="/static/include/contextHead.jsp"/>


<!-- Content Header (Page header) -->
<section class="content-header" style="padding-left: 4%">
    <h1>新增实例</h1>


    <div class="breadcrumb">
        <a href="/home">返回</a>
    </div>
</section>

<br/>
<section class="content">
    <div class="row">
        <div class="col-md-12" style="padding-left: 4%">


            <label>专题：</label>
            <select id="selectid">
                <option value="Java基础">Java基础</option>
                <option value="Java面向对象">Java面向对象</option>
                <option value="Java高级教程">Java高级教程</option>
            </select>
            <br/>
            <label>类型：</label><input id="textType" size="40">
            <div style="width: 400px">
                <h3 class="box-title">标题:</h3>
                <input id="title" size="40">
            </div>
            <br>
            <br>

            <div class="box box-info">
                <div class="box-header">
                    <h3 class="box-title">示例代码</h3>
                    <!-- tools box -->
                    <div class="pull-right box-tools"></div>
                    <!-- /. tools -->
                </div>
                <!-- /.box-header -->
                <div class="box-body pad">

                    <textarea name="code" id="codeContext" rows="10" cols="80"></textarea>

                </div>
            </div>
            <!-- /.box -->


            <div class="box box-info">
                <div class="box-header">
                    <h3 class="box-title">实例讲解</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body pad">
                    <textarea name="explainContext" id="explainContext" rows="10" cols="80"></textarea>
                </div>
            </div>


            <div class="box box-info">
                <div class="box-header">
                    <h3 class="box-title">运行结果</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body pad">
                    <textarea name="runResult" id="runResult" rows="10" cols="80"></textarea>
                </div>
            </div>


            <form id="uploadFile" enctype="multipart/form-data" method="post">
                <h3>上转文件:</h3>
                <br/>
                <input type="file" name="file">
            </form>


            <input type="submit" value="提交" onclick="registers(${requestScope.dtNum})"/>


        </div>
        <!-- /.col-->
    </div>
    <!-- ./row -->
</section>


<div style="text-align: center; padding-top: 40px">
    版权所属：&copy;长沙学院洪山一栋133
</div>


<!-- jQuery 3 -->
<script src="${baseurl}/static/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap 3.3.7 -->
<script src="${baseurl}/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- CK Editor -->
<script src="${baseurl}/static/bower_components/ckeditor/ckeditor.js"></script>
<script>
    $(function () {
        CKEDITOR.replace('codeContext');
        CKEDITOR.replace('explainContext');
        CKEDITOR.replace('runResult');
        $('.textarea').wysihtml5();
    })
</script>


<script type="text/javascript">


    // :$editor3,"file":$file
    function registers(dtNum) {
        alert("====");
        var $selectValue = $('#selectid').val();
        var $textType = $('#textType').val();
        alert($selectValue+","+$textType);
        var $title = $('#title').val();//标题
        var $editor1 = CKEDITOR.instances.codeContext.getData();//代码
        var $explainContext = CKEDITOR.instances.explainContext.getData();//实例讲解
        var $runResult = CKEDITOR.instances.runResult.getData();//运行结果

        var formData = new FormData($('#uploadFile')[0]);


        formData.append("title", $title);
        formData.append("code", $editor1);
        formData.append("explain", $explainContext);
        formData.append("runResult", $runResult);
        formData.append("selectValue", $selectValue);
        formData.append("textType", $textType);
        formData.append("dtNum", dtNum);



        $.ajax({
            type: 'POST',
            url: '../../../addExamples',
            data: formData,
            cache: false,
            processData: false,
            contentType: false,
            success:function(result){
                alert(result);
                window.location.href="/resourcesModule";
            },
            error:function(xhr,errorMessage,e){
                alert("系统异常");
            }

        });



    }
</script>
</body>
</html>