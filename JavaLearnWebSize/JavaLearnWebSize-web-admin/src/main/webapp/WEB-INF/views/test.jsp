<%--
  Created by IntelliJ IDEA.
  User: tpy
  Date: 2019/11/4
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>图书系统 2 | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <c:set var="baseurl" value="${pageContext.request.contextPath }"></c:set>

    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${baseurl}/static/bower_components/bootstrap/dist/css/bootstrap.min.css"/>
    <!-- Theme style -->
    <link rel="stylesheet" href="${baseurl}/static/dist/css/AdminLTE.min.css"/>

    <script type="text/javascript" src="${baseurl}/static/ckeditor/ckeditor.js"></script>

    <script src="${baseurl}/static/jQuery/jquery.1.8.3.min.js"></script>


    <script type="text/javascript">
        var $editor1 = $("#editor1").val();
        var $context = $("#context").val();
        alert($editor1);
        alert($context);
        function registers() {
            $.post(
            "../../../test",
            {"editor1":$editor1,"context":$context},
            function(result){
            alert(result);
            },
            "text"
            );
        }
    </script>

</head>

<body class="hold-transition login-page">


<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Text Editors
            <small>Advanced form element</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Forms</a></li>
            <li class="active">Editors</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-md-12">


                <%--第一个文本编辑器--%>
                <div class="box box-info">
                    <div class="box-header">
                        <h3 class="box-title">CK Editor
                            <small>Advanced and full of features</small>
                        </h3>
                        <!-- tools box -->
                        <div class="pull-right box-tools">
                            <button type="button" class="btn btn-info btn-sm" data-widget="collapse" data-toggle="tooltip"
                                    title="Collapse">
                                <i class="fa fa-minus"></i></button>
                            <button type="button" class="btn btn-info btn-sm" data-widget="remove" data-toggle="tooltip"
                                    title="Remove">
                                <i class="fa fa-times"></i></button>
                        </div>
                        <!-- /. tools -->
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body pad">
                        <form>
                    <textarea id="editor1" name="editor1" rows="10" cols="80">
                                            This is my textarea to be replaced with CKEditor.
                    </textarea>
                        </form>
                    </div>
                </div>
                <!-- /.box -->


                <%--第二个文本编辑器--%>
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">Bootstrap WYSIHTML5
                            <small>Simple and fast</small>
                        </h3>
                        <!-- /. tools -->
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body pad">
                        <form>
                            <textarea name="editor2" id="editor2" class="textarea" placeholder="Place some text here"
                          style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                        </form>
                    </div>
                </div>


                <input type="submit" value="test" onclick="registers()">

            </div>
            <!-- /.col-->
        </div>
        <!-- ./row -->
    </section>
    <!-- /.content -->
</div>



<!-- CK Editor -->
<script src="${baseurl}/static/bower_components/ckeditor/ckeditor.js"></script>
<script>
    $(function () {
        // Replace the <textarea id="editor1"> with a CKEditor
        // instance, using default configuration.
        CKEDITOR.replace('editor1')
        //bootstrap WYSIHTML5 - text editor
        $('.textarea').wysihtml5()
    })



    $(function () {
        // Replace the <textarea id="editor1"> with a CKEditor
        // instance, using default configuration.
        CKEDITOR.replace('editor2')
        //bootstrap WYSIHTML5 - text editor
        $('.textarea').wysihtml5()
    })
</script>



</body>
</html>

