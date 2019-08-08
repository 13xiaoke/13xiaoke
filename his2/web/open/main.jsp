<%-- 
    Document   : main
    Created on : 2019-7-28, 1:40:29
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <frameset rows="20%,*" frameborder="yes" border="5">
            <frame src="top.jsp" name="top" scrollling="yes" noresize="no" />
            <frameset cols="15%,*" frameborder="yes" border="5" >
                <frame src="left.jsp" name="left" scrolling="yes"  noresize="no" />
                <frame src="open_main.jsp" name="opin" scrolling="yes"   noresize="no" />
            </frameset>
        </frameset>
</html>
