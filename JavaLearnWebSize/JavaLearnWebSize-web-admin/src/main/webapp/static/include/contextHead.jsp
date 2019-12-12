<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<header class="main-header">
    <nav class="navbar navbar-static-top">
        <div class="navbar-custom-menu" style="height: 40px; background-color: white">


            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${baseurl}/static/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs">${sessionScope.user.getUserName()}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="${baseurl}/static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                            <p>
                                <label style="color: black">${sessionScope.user.getUserName()}</label>
                                <small style="color: black">个人信息</small>
                            </p>
                        </li>
                        <!-- Menu Body -->
                        <li class="user-body">
                            <div class="row">
                                <div class="col-xs-4 text-center">
                                    <a href="#">按钮</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">按钮</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="/quitLogin">退出登录</a>
                                </div>
                            </div>
                            <!-- /.row -->
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="/quitLogin" class="btn btn-default btn-flat">注销</a>
                            </div>
                            <div class="pull-right">
                                <a href="/quitLogin" class="btn btn-default btn-flat">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>







<%--<header class="main-header">--%>
    <%--<div class="navbar-custom-menu">--%>
        <%--<ul class="nav navbar-nav">--%>
            <%--<li class="dropdown user user-menu">--%>
                <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                    <%--<img src="${baseurl}/static/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">--%>
                    <%--<span class="hidden-xs">Alexander Pierce</span>--%>
                <%--</a>--%>
                <%--<ul class="dropdown-menu">--%>
                    <%--<!-- User image -->--%>
                    <%--<li class="user-header">--%>
                        <%--<img src="${baseurl}/static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">--%>

                        <%--<p>--%>
                            <%--Alexander Pierce - Web Developer--%>
                            <%--<small>Member since Nov. 2012</small>--%>
                        <%--</p>--%>
                    <%--</li>--%>
                    <%--<!-- Menu Body -->--%>
                    <%--<li class="user-body">--%>
                        <%--<div class="row">--%>
                            <%--<div class="col-xs-4 text-center">--%>
                                <%--<a href="#">Followers</a>--%>
                            <%--</div>--%>
                            <%--<div class="col-xs-4 text-center">--%>
                                <%--<a href="#">Sales</a>--%>
                            <%--</div>--%>
                            <%--<div class="col-xs-4 text-center">--%>
                                <%--<a href="#">Friends</a>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<!-- /.row -->--%>
                    <%--</li>--%>
                    <%--<!-- Menu Footer-->--%>
                    <%--<li class="user-footer">--%>
                        <%--<div class="pull-left">--%>
                            <%--<a href="#" class="btn btn-default btn-flat">Profile</a>--%>
                        <%--</div>--%>
                        <%--<div class="pull-right">--%>
                            <%--<a href="#" class="btn btn-default btn-flat">Sign out</a>--%>
                        <%--</div>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>

            <%--<li>--%>
                <%--<a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>--%>
            <%--</li>--%>

        <%--</ul>--%>
    <%--</div>--%>
<%--</header>--%>







<div class="header">
    <h1>Java Learn Net</h1>
</div>

<div class="topnav">
    <a href="/resourcesModule" class="fontSize">实例教程</a>
    <a href="/mainResource" class="fontSize">资源下载</a>
    <a href="#" class="fontSize">未完待续</a>
</div>

<br />
<br />
