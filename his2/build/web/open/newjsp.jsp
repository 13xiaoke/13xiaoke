
<%@page import="java.util.Date"%>
<%@page import="cn.edu.hcnu.Bean.Student"%>
<%@page import="cn.edu.hcnu.Bean.Drug"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%-- 
Document   : opin_begin
Created on : 2019-7-29, 10:38:50
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
        <style type = "text/css"> 
            .tt{  
                border: 0;
                outline: 0;
                background:transparent;
                border-bottom: 2px solid black;
                width: 120px;
                text-align: center;
            }
            .t2{  
                border: 0;
                outline: 0;
                background:transparent;
                border-bottom: 2px solid black;
                width: 250px;
                text-align: center;
            }
            .t3{  
                border: 0;
                outline: 0;
                background:transparent;
                border-bottom: 2px solid black;
                width: 150px;
                text-align: center;
            }

        </style>


        <script type="text/javascript" >
            function deleteRow(r)
            {
                alert("tt");
                //实现增加和删除一行
                // var i = r.parentNode.parentNode.rowIndex;  //返回r所在的<tr>位置
                // document.getElementById('myTable').deleteRow(i);  //删除这一行
            }

            function insertRowInTable() {
                var table = document.getElementById("myTable");
                var newRow = table.insertRow(-1);
                newRow.insertCell().innerHTML = "<input type='text' name='name' list='name' autocomplete='off' >";
                newRow.insertCell().innerHTML = "<input type='text' name='spec' >";
                newRow.insertCell().innerHTML = "<input type='text' name='date' >";
                newRow.insertCell().innerHTML = "<input type='text' name='drug_number' >";
                newRow.insertCell().innerHTML = " <input type='text' name='open_number'  >";
                newRow.insertCell().innerHTML = " <input type='text' name='way' > ";
                newRow.insertCell().innerHTML = "<input type ='button' value='删除' onclick='deleteRow(this)' >&ensp;<input type='button' value='添加' onclick='insertRowInTable()' >";
            }

            function auto_student(r) {
                alert("自动填充");
            }

            function auto_Drug(r) {
                alert("自动填充");
            }


        </script>
    </head>

    <body bgcolor="CCCFFF" >
        <small><small><%@include file="../js/session.jsp" %></small></small>
        <h1 align="center">河池学院卫生所主页</h1>
        <br>
        <%  
            request.setCharacterEncoding("utf-8");
            List<Drug> drugs = (List<Drug>) request.getAttribute("drug");     //获取提交过来的所有药品
            List<Student> studs = (List<Student>) request.getAttribute("stu");  //获取所有的药品
            
            int[] drugID = new int[drugs.size()];  //统一存储在数组中，对应下标
            String[] drug_name = new String[drugs.size()];
            String[] drug_pyname=new String[drugs.size()];
            String[] spec = new String[drugs.size()];
            Date[] date = new Date[drugs.size()];
            String[] drug_number = new String[drugs.size()];
      
            int i = 0;
            for (Drug d : drugs) {
                drugID[i] = d.getDrugID();
                drug_name[i] = d.getName();
                drug_pyname[i] = d.getPyname();
                spec[i] = d.getSpec();
                date[i] = d.getDate();
                drug_number[i]=d.getNumber();       
                i++;

            }
        %>
        
        

    </body>
</html>


