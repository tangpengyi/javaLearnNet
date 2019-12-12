<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>JavaLearn | Log in</title>


    <c:set var="baseurl" value="${pageContext.request.contextPath }"></c:set>

    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${baseurl}/static/bower_components/bootstrap/dist/css/bootstrap.min.css"/>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${baseurl }/static/bower_components/font-awesome/css/font-awesome.min.css"/>
    <!-- Ionicons -->
    <link rel="stylesheet" href="${baseurl }/static/bower_components/Ionicons/css/ionicons.min.css"/>
    <!-- Theme style -->
    <link rel="stylesheet" href="${baseurl }/static/dist/css/AdminLTE.min.css"/>
    <!-- iCheck -->
    <link rel="stylesheet" href="${baseurl }/static/plugins/iCheck/square/blue.css"/>

</head>

<body class="hold-transition login-page">


<div class="login-box">
    <div class="login-logo">
        <a href="#">Java Learn Net</a>
    </div>

    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">Java Net登陆</p>

        <form name="loginForm" action="login" method="post">

            <!--<c:if test="${messege != null}">
                <div class="callout callout-danger">
                    <p>${messege}</p>
                </div>
            </c:if>-->
            <%--判断是否登陆失败，失败显示提示信息--%>
            <div class="callout callout-danger" ${message == null?"style='display: none'":" "}>
                <p>${message}</p>
            </div>


            <div class="form-group has-feedback">
                <input name="account" type="text" class="form-control" placeholder="用户名"
                       value="${requestScope.account}">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="password" type="password" class="form-control" placeholder="密码"
                       value="${requestScope.password}">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>

            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">

                        <label>
                            <input name="isRememeber" type="checkbox" ${requestScope.account != null ? "checked ='checked'":" "}>
                            记住我
                        </label>

                        <label>
                            <input name="isAutomaticLogin" type="checkbox" ${Automaticlogin != null ? "checked ='checked'":" "}>
                            自动登陆
                        </label>
                    </div>

                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat" onclick="mycheck()">登 陆</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="#">忘记密码？</a> &nbsp;&nbsp;&nbsp;<a href="register" style="padding-left:170px;">注册密码</a><br>
    </div>
    <!-- /.login-box-body -->

</div>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- jQuery 3 -->
<script src="${baseurl}/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${baseurl }/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${baseurl }/static/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });
    });
</script>

<script type="text/javascript">
    function mycheck(){

        if(loginForm.account.value == ""){
            alert("请输入手机号");
            loginForm.account.focus();
            return ;
        }

        if(loginForm.password.value == ""){
            alert("请输入密码");
            loginForm.password.focus();
            return ;
        }

    }

</script>


</body>
</html>


