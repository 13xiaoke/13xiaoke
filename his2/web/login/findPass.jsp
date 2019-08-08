<%-- 
    Document   : findpass
    Created on : 2019-7-27, 23:46:01
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            a {text-decoration: none}
            table{margin-top: 100px;}
        </style>
    </head>
    <body>
    <center>
        <form action="../his2_Servlet?action=findPass.do" method="post">
            <table bgcolor="CCCFFF">
                <tr><td align="center" ><h2>查找密码</h2></td></tr>
                <tr><td>用户名：<input type="text" name="user"  autocomplete="off" required="required"  placeholder ="输入你的用户名" title="输入用户名不正确" ></td></tr>
                <tr><td>身份证：<input type="text" name="idNumber" autocomplete="off" pattern="\w{18}"   required="required" placeholder ="输入18位合法的身份证号" title="输入不是18位合法的身份证号！" ></td></tr>
                <tr><td align="center" ><input type="submit" values="提交"></td></tr>
                <tr><td  align="center"><a href="land.jsp">&emsp;&emsp;登录界面</a>&emsp;&emsp;</td></tr> 
            </table>
        </form>
    </center>
</body>
</html>