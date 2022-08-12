<%--
  Created by IntelliJ IDEA.
  User: ben
  Date: 2022/8/11
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求传递参数</title>
</head>
<body>
<%--
    ${pageContext.request.contextPath} 动态获取项目路径springmvc_quickstart
    a标签的请求方式是get
--%>
<a href="${pageContext.request.contextPath}/user/simpleParam?id=1&username=张三">基本类型参数</a>
<hr>
<form action="${pageContext.request.contextPath}/user/pojoParam" method="post">
    id：<input type="text" name="id"><br>
    username：<input type="text" name="username"><br>
    <input type="submit" value="对象类型参数">
</form>
<hr>
<form action="${pageContext.request.contextPath}/user/arrayParam" method="post">
    编号：<br>
    <input type="checkbox" name="ids" value="1">1<br>
    <input type="checkbox" name="ids" value="2">2<br>
    <input type="checkbox" name="ids" value="3">3<br>
    <input type="checkbox" name="ids" value="4">4<br>
    <input type="submit" value="数组类型参数">
</form>
<hr>
<%--集合类型参数--%>
<form action="${pageContext.request.contextPath}/user/queryParam" method="post">
    搜索关键字：<br>
    <input type="text" name="keyword"><br>

    user对象：<br>
    id：<input type="text" name="user.id"><br>
    username：<input type="text" name="user.username"><br>

    list集合：<br>
    第1个元素：<br>
    id：<input type="text" name="userList[0].id"><br>
    username：<input type="text" name="userList[0].username"><br>
    第2个元素：<br>
    id：<input type="text" name="userList[1].id"><br>
    username：<input type="text" name="userList[1].username"><br>

    map集合<br>
    第1个元素：<br>
    id：<input type="text" name="userMap['u1'].id"><br>
    username：<input type="text" name="userMap['u1'].username"><br>
    第2个元素：<br>
    id：<input type="text" name="userMap['u2'].id"><br>
    username：<input type="text" name="userMap['u2'].username"><br>

    <input type="submit" value="复杂类型参数">
</form>
<hr>

<%--自定义类型转换器 错误产生--%>
<form action="${pageContext.request.contextPath}/user/converterParam" method="post">
    生日：<br>
    <input type="text" name="birthday"><br>

    <input type="submit" value="自定义类型转换器">
</form>
<hr>

<%--@requestParam 注解--%>
<form action="${pageContext.request.contextPath}/user/requestParam" method="post">
    birthday：<br>
    <input type="text" name="birthday"><br>

    <input type="submit" value="@requestParam">
</form>
</body>
</html>
