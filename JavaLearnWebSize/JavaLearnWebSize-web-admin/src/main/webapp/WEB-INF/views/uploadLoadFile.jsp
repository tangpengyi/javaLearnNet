<%--
  Created by IntelliJ IDEA.
  User: tpy
  Date: 2019/11/6
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>Title</title>

    <c:set var="baseurl" value="${pageContext.request.contextPath }"></c:set>
    <script src="${baseurl}/static/jQuery/jquery.1.8.3.min.js"></script>
    <script src="${baseurl}/static/bower_components/ckeditor/ckeditor.js"></script>


</head>
<body>


<form id="uploadForm" enctype="multipart/form-data" method="post">
    <textarea id="area"></textarea>
    <input type="file" name="file">
</form>
<br>
<input type="button" id="upload" onclick="test()" value="上传">



<a href="/downloadFile">下载文件</a>


</body>

<script type="text/javascript">


    $(function () {
        CKEDITOR.replace('area');
        $('.textarea').wysihtml5();
    })


    function test() {

        var $area =CKEDITOR.instances.area.getData();
        // var $area = $('#area').val();
        alert($area);
        var formData = new FormData($('#uploadForm')[0]);
        formData.append("area", $area);
        $.ajax({
            type: 'POST',
            // url: '../../../upload',
            url: '../../../addResource',
            data: formData,
            cache: false,
            processData: false,
            contentType: false,

        }).success(function (data) {
            var result = JSON.parse(data);
            alert(result.back);
        }).error(function () {
            alert("上传失败");

        });
    }

</script>


</html>
