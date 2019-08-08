<%-- 
    Document   : session_1
    Created on : 2019-7-29, 3:49:01
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script>
            tt=window.confirm("确定退出登录？");
            if(tt==true)
            {
                alert('成功退出登录！');
                parent.location.href="<%=request.getContextPath() %>/login/land.jsp";  //parent 为在新的浏览器打开

            }
            else{
                 alert("暂不退出登录！");window.history.back(-1);  //返回代码
            }
        </script>
    </body>
</html>
