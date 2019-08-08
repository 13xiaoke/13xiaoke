  <%-- 
    Document   : login
    Created on : 2019-5-22, 12:07:34
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            a {text-decoration: none;}
            table{margin-top:100px; }
        </style>
    </head>
    <body  >
    <center>
        <form action="../his2_Servlet?action=login.do" method="post">
            <table bordre="1"  bgcolor="CCCFFF" >
                <tr align="center"><td><h3>《医院管理系统登录》</h3></td></tr>
                <tr><td>用户名：<input type="text" name="user" required="required"></td></tr>
                <tr><td>密&emsp;码：<input type="password" name="pass" placeholder="不少于6单词个字符" required="required"  pattern="\w{6,}" title="密码输入不符合要求！"></td></tr>
                <tr><td  align="center"><input type="submit" value="登陆"></td></tr>
                <tr><td  align="center"><a href="findPass.jsp">&emsp;&emsp;忘记密码</a>&emsp;&emsp;
                    </td></tr> 
            </table>
        </form>
    </center>
</body>
</html>

