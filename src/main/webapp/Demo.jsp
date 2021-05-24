<%--
  Created by IntelliJ IDEA.
  User: baize
  Date: 2021/5/17
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName()+":"+request.getServerPort() +
            request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>" />
    <title>Title</title>
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
    <script type="text/javascript">
        $.ajax({
            url:"",
            data:{

            },
            type:"",
            dataType:"",
            success:function (data){

            }
        })

        //创建时间，当前的系统时间
        String createTime = DateTimeUtil.getSysTime();
        //创建人，当前登录的用户
        String createBy = ((User)request.getSession().getAttribute("user")).getName();
    </script>
</head>
<body>

</body>
</html>
