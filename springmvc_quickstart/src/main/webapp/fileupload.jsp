<%--
  Created by IntelliJ IDEA.
  User: ben
  Date: 2022/8/13
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>


<%--
    表单上传三要素：
    * 表单项type="file"
    * 表单提交方式method="POST"
    * 表单enctype属性是多部分表单形式enctype="multipart/form-data"
--%>

单文件上传
<hr>
<form action="${pageContext.request.contextPath}/fileupload" method="post" enctype="multipart/form-data">
    名称：<input type="text" name="username"><br>
    文件：<input type="file" name="filePic"><br>
    <input type="submit" value="单文件上传"><br>
</form>

多文件上传
<hr>
<form action="${pageContext.request.contextPath}/filesupload" method="post" enctype="multipart/form-data">
    名称：<input type="text" name="username"><br>
    文件：<input type="file" name="filePics"><br>
    文件：<input type="file" name="filePics"><br>
    <input type="submit" value="多文件上传"><br>
</form>
<hr>
</body>
</html>
