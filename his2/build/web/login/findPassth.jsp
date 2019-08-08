<%-- 
    Document   : findPassth
    Created on : 2019-7-28, 0:04:49
    Author     : Administrator
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            a{text-decoration: none;}
            table{margin-top: 100px;text-align: center; }
        </style>
    </head>
    <body>
    <center>
        <table bgcolor="CCCFFF" border="1" >
            <tr><td><h3>你的账户信息：</h3></td></tr>
            <%
                String[] tt= (String[])request.getAttribute("finepassth");
                out.print("<tr><td>" + "你的用户名：" + tt[0] + "</td></tr>");
                out.print("<tr><td>" + "你的密码：" + tt[1] + "</td></tr>");
            %>
            <tr><td  align="center"><a href="<%=request.getContextPath() %>/login/land.jsp">&emsp;&emsp;返回登录界面</a>&emsp;&emsp;
        </table>
    </center>
</body>
</html>
