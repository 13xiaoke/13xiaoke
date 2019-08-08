<%-- 
    Document   : session
    Created on : 2019-7-28, 12:30:06
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style> 
            b{float:right; margin-right: 10px; margin-top: 10px; }
            a{text-decoration: none;}
            a:visited{color: blue;}
        </style>
    </head>
    <body>
        <b><%  
            if((session.getAttribute("user"))!=null )
            {
                out.print("<b>"+session.getAttribute("name")+"你好！"+"</b><br>");
                String t=request.getContextPath();
                out.print("<b><a  href='"+t+"/js/session_1.jsp'   targer='_top' >"+"退出&emsp;&emsp;"+"</a></b> ");
            }else
            {
               %>
               <script>alert("你还没用登录，请先登录");parent.location.href="<%=request.getContextPath() %>/login/land.jsp";</script>
               <%
            }
        %></b>
    </body>
</html>
