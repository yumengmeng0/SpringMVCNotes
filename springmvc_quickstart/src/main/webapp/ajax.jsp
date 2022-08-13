<%--
  Created by IntelliJ IDEA.
  User: ben
  Date: 2022/8/13
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax异步交互</title>
</head>
<body>

<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
<button id="btn1">ajax异步提交</button>
<script>
    $("#btn1").click(function () {
        let url = "${pageContext.request.contextPath}/user/ajaxRequest";
        let data = '[{"id":1, "username":"张三"}, {"id":2, "username":"李四"}]';

        $.ajax({
            type: 'POST',
            url: url,
            data: data,
            contentType: 'application/json;charset=utf-8',
            success:function (resp) {
                console.log(JSON.stringify(resp))
            }
        });
    });


</script>
</body>
</html>
