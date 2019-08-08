
<%@page import="cn.edu.hcnu.Bean.Stuff"%>
<%@page import="java.util.Date"%>
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
            #sub{float: left; margin-left: 1020px; margin-top: 10px;}  
            .drugname{width: 200px; }
            .spec{width:150px;}
            .date{width:80px;}
            .open_number{width: 80px;}
            .open_number1{float:right;height: 24px;width: 50px;}
            .drug_number{width:70px;}
            .way1{width: 100px;margin-right: -5px;}
            .way2{width:50px;margin-right: -2px;}
            .stuffnumber{width: 100px;}
            .use_number{width:70px;}
            body{position:absolute;left:5px;top:0px;}

        </style>

        <%
            request.setCharacterEncoding("utf-8");
            List<Drug> drugs = (List<Drug>) request.getAttribute("drug");     //获取提交过来的所有药品
            List<Stuff> stuffs = (List<Stuff>) request.getAttribute("stuffs");  //获取所有的学生

            int[] drugID = new int[drugs.size()];  //统一存储在数组中，对应下标  //存储药品
            String[] drug_name = new String[drugs.size()];
            String[] drug_pyname = new String[drugs.size()];
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
                drug_number[i] = d.getNumber();
                i++;
                //  out.println(d.getSpec()+"<br>");

            }

            int[] stuffID = new int[stuffs.size()];
            String[] stuffname = new String[stuffs.size()];
            int[] stuffnumber = new int[stuffs.size()];
            i = 0;
            for (Stuff st : stuffs) {
                stuffID[i] = st.getStuffID();
                stuffname[i] = st.getStuff_name();
                stuffnumber[i] = st.getStuff_number();
                //   out.println(st.getStuff_number());
                i++;
            }
        %>

        <script type="text/javascript" >

            function deleteRow(r)
            {
                //alert("tt");
                //实现增加和删除一行      
                var table = document.getElementById("myTable");
                var i = r.parentNode.parentNode.rowIndex;  //返回r所在的<tr>位置
                var drug_name = document.getElementsByClassName("drugname"); // 因为 getElementsById 只能获取一个元素，这个是自动添加多个的，
                var drugID = document.getElementsByClassName("drugID"); //所以要用getElementByClassName()通过类名获取集合，也可以用getElementName(),名字属性值获取
                var spec = document.getElementsByClassName("spec"); // 获取的是一个标签属性，用value 得到标签属性值
                var date = document.getElementsByClassName("date");
                var drug_number = document.getElementsByClassName("drug_number");
                var open_number1 = document.getElementsByClassName("open_number1"); //获取使用方法下拉框的选择框的属性。
                var open_number = document.getElementsByName("open_number");
                var open_way1 = document.getElementsByName("way1");
                var open_way2 = document.getElementsByName("way2");
                var open_way3 = document.getElementsByName("way3");
                var open_way4 = document.getElementsByName("way4");
                var open_way5 = document.getElementsByName("way5");
                var open_way6 = document.getElementsByName("way6");
                var open_way7 = document.getElementsByName("way7");
                var open_way8 = document.getElementsByName("way8");
                // alert(table.rows.length);
                if (table.rows.length === 2) {
                    drug_name[0].value = "";
                    open_number[0].value = "";
                    spec[0].value = "";
                    date[0].value = "";
                    drug_number[0].value = "";
                    open_number1[0].value = "";
                    open_way1[0].value = "";
                    open_way2[0].value = "";
                    open_way3[0].value = "";
                    open_way4[0].value = "";
                    open_way5[0].value = "";
                    open_way6[0].value = "";
                    open_way7[0].value = "";
                    open_way8[0].value = "";
                    alert("基础数据，不允许删除");
                } else {
                    document.getElementById('myTable').deleteRow(i);  //删除这一行
                }

            }

            function insertRowInTable() {
                var table = document.getElementById("myTable");
                var newRow = table.insertRow(-1);  //获取表格最后一行
                newRow.insertCell().innerHTML = "<input type='hidden' name='drugID' class='drugID' > <input type='text' name='drugname' list='drugname' onblur='auto_Drug(this)' class='drugname'  autocomplete='off'  >";
                newRow.insertCell().innerHTML = "<input type='text' name='spec'  class='spec' readonly='true'>";
                newRow.insertCell().innerHTML = "<input type='text' name='date' class='date' readonly='true' >";
                newRow.insertCell().innerHTML = "<input type='text' name='drug_number' class='drug_number' readonly='true'>";
                newRow.insertCell().innerHTML = "<input type='text' name='open_number' class='open_number' >";
                newRow.insertCell().innerHTML = "<select  name='open_number1' class='open_number1'  onblur='selectspec(this)'>";
                newRow.insertCell().innerHTML = "<input type='text' name='way1' class='way1' list='way1' ><input type='text' name='way2' class='way1' list='way2' ><input type='text' name='way3' class='way2' list='way3' ><input type='text' name='way4' class='way2' list='way4'><input type='text' name='way5' class='way2' list='way5' ><input type='text' name='way6' class='way2' list='way6' ><input type='text' name='way7' class='way2' list='way7' ><input type='text' name='way8' class='way2' list='way8' > ";
                newRow.insertCell().innerHTML = "<input type ='button' value='删除' onclick='deleteRow(this)' >&ensp;<input type='button' value='添加' onclick='insertRowInTable()' >";
            }
//
//            function auto_student(r) {
//                alert("自动填充");
//            }

            function auto_Drug(r) {
                var i = r.parentNode.parentNode.rowIndex; //获取所在的行,一行有一个数据，可以记录当前行，用来获取document.getElementsByName返回数组的哪一个值
                //alert(i);
                var drug_name = document.getElementsByClassName("drugname");  // 因为 getElementsById 只能获取一个元素，这个是自动添加多个的，
                var drugID = document.getElementsByClassName("drugID");      //所以要用getElementByClassName()通过类名获取集合，也可以用getElementName(),名字属性值获取
                var spec = document.getElementsByClassName("spec");          // 获取的是一个标签属性，用value 得到标签属性值
                var date = document.getElementsByClassName("date");
                var drug_number = document.getElementsByClassName("drug_number");
                var open_number1 = document.getElementsByClassName("open_number1");   //获取使用方法下拉框的选择框的属性。
                var open_number = document.getElementsByName("open_number");
                var open_way1 = document.getElementsByName("way1");
                var open_way2 = document.getElementsByName("way2");
                var open_way3 = document.getElementsByName("way3");
                var open_way4 = document.getElementsByName("way4");
                var open_way5 = document.getElementsByName("way5");
                var open_way6 = document.getElementsByName("way6");
                var open_way7 = document.getElementsByName("way7");
                var open_way8 = document.getElementsByName("way8")
                //    for(var j=0;j<drug_name.length;j++)
//                {
//                    alert(drug_name[j].value);
//                }
            <%   for (int j = 0; j < drug_name.length; j++) {%>   // jsp 语句嵌在script 中写，有for 循环的范围的括号，后面补上
                if (drug_name[i - 1].value === "<%=drug_name[j]%>") {
                    drugID[i - 1].value = '<%=drugID[j]%>';
                    spec[i - 1].value = '<%=spec[j]%>';
                    date[i - 1].value = '<%=date[j]%>';
                    open_number[i - 1].value = "";
                    open_way1[i - 1].value = "";
                    open_way2[i - 1].value = "";
                    open_way3[i - 1].value = "";
                    open_way4[i - 1].value = "";
                    open_way5[i - 1].value = "";
                    open_way6[i - 1].value = "";
                    open_way7[i - 1].value = "";
                    open_way8[i - 1].value = "";
                    drug_number[i - 1].value = '<%=drug_number[j]%>';

                    var str = "<%=spec[j]%>";  // 提前规格中的中文，作为开方数量的选择
                    var str1 = str.replace(/[^\u4e00-\u9fa5]+/g, ","); // 匹配非中文字符，替换为 “,”
                    var str2 = str1.split(",");    // 分割 “,” 符号 。
                    var t = 0;
                    open_number1[i - 1].options.length = 0;
                    for (var j = 0; j < str2.length; j++)
                    {
                        console.log(str2[j]);
                        if (str2[j] !== "")  // 去除为空的数据。
                        {
                            open_number1[i - 1].options[t] = new Option(str2[j]);  //操作select 中的option，插入
                            t++;

                        }
                    }

                }
            <% }
            %>
            }

            function auto_stuff_add() {   //材料增加
                var table = document.getElementById("table");
                // console.log(table);
                //console.log(table.rows.length);
                var newRow = table.insertRow(-1);
                newRow.insertCell().innerHTML = "<input type='hidden' name='stuffID' ><input type='text' name='stuffname' list='stuffname' onblur='auto_stuff(this)'   > ";
                newRow.insertCell().innerHTML = "<input type='text' name='stuffnumber' class='stuffnumber' readonly='true'>";
                newRow.insertCell().innerHTML = "<input type='text' name='use_number' class='use_number' >";
                newRow.insertCell().innerHTML = "<input type='button'  value='添加' onclick='auto_stuff_add()' >&emsp;<input type='button' value='删除' onclick='auto_stuff_delete(this)' >";
            }


            function auto_stuff_delete(r) {  // 材料删除
                var table = document.getElementById("table");
                var i = r.parentNode.parentNode.rowIndex;  //返回r所在的<tr>位置
                // alert(table.rows.length);
                if (table.rows.length === 2) {
                    var stuffname = document.getElementsByName("stuffname");
                    var stuffnumber = document.getElementsByName("stuffnumber");
                    var use_number = document.getElementsByName("use_number");
                    stuffname[0].value = "";
                    stuffnumber[0].value = "";
                    use_number[0].value = "";
                    alert("基础数据，不允许删除");
                } else {
                    document.getElementById('table').deleteRow(i);  //删除这一行
                }
            }

            function auto_stuff(r) {
                var table = document.getElementById("table");
                var i = r.parentNode.parentNode.rowIndex - 1;   //行数从第一行开始,获取所在的行-1
                var stuffID = document.getElementsByName("stuffID");
                var stuffname = document.getElementsByName("stuffname");
                var stuffnumber = document.getElementsByName("stuffnumber");
                // console.log(stuffname[i].value);
            <%  for (int j = 0; j < stuffname.length; j++) {%>
                if (stuffname[i].value === "<%=stuffname[j]%>")
                {
                    //  console.log("tt");
                    stuffID[i].value =<%=stuffID[j]%>;
                    stuffnumber[i].value =<%=stuffnumber[j]%>;
                }
            <% }%>
            }

            function select_ID() {
                var i = document.getElementById("studentID").value;  //获取输入的学号
                // console.log(i);
                document.location.href = "his2_Servlet?action=get_studentID.do&studentID=" + encodeURI(encodeURI(i));
            }
            function select_name() {
                var i = document.getElementById("student_name").value; //获取输入的名字
                //    console.log(i);

                document.location.href = "his2_Servlet?action=get_name.do&name=" + encodeURI(encodeURI(i));

            }

            function selectspec(r) {  //选择下拉框自动填充值,
                var open_number = document.getElementsByName("open_number");  //所以名字为open_number 的对象，返回一个数组
                var i = r.parentNode.parentNode.rowIndex - 1;   // 下拉框所在的tr,从o开始,th 占了一会，所以现在从1开始
                // console.log("i="+i);
                var select = document.getElementsByName("open_number1");  // 获取所以的下拉框对象select
                var index = select[i].selectedIndex; // 获取选择下拉框的索引
                //  console.log("tt="+select[index].value);
                open_number[i].value += (select[i]).options[index].value;
                // console.log("t1="+open_number[i]);
                // console.log("t2="+open_number[i].value);

            }

        </script>
    </head>

    <body bgcolor="CCCFFF" >
        <small><small><%@include file="../js/session.jsp" %></small></small>
        <h1 align="center">河池学院卫生所主页</h1>


        <br>


        <form action="his2_Servlet?action=open_deal.do" method="post">  <!--总的提交-->
            学号/工号：<input type="text"  list="student"  class="t3" name="studentID" id="studentID" required="required"  >&emsp;<input type="button" value="查询" onclick="select_ID()" >
            &emsp;名字：<input type="text" name="student_name" id="student_name" class="tt"  required="required" > &emsp;<input type="button"  value="查询" onclick="select_name()" >
            <br>
            <br>
            &emsp;性别：<input type="text" name="sex"  class="tt"  required="required" >
            &emsp;年龄：<input type="text" name="age"  class="tt"   required="required">
            &emsp;所在单位：<input type="text" name="major"  class="t2"   required="required">
            &emsp;联系方式：<input type="text" name="phone"  class="tt"  required="required">
            &emsp;职务：<input type="text" name="sign" class="tt"  id="sign"  >
            <!--下面的开方，只要输入了用户名就可以开方-->
            <br>
            <h3>医生开方:</h3>
            病史：<input type="text" name="history" class="t2" > &emsp;药物过敏史：<input type="text" name="allergy" class="t2" >
            <br>
            <br>
            <table id="myTable" bgcolor="CCCFFF" border="1" >
                <th>药品名称</th>
                <th>规格</th>
                <th>药品有效期</th>
                <th>库存</th>
                <th colspan="2">开药数量</th>
                <th>使用方法</th>
                <th>操作</th>
                <tr>
                    <td>
                        <input type="hidden" name="drugID" class="drugID" >
                        <input type="text"  name="drugname" list="drugname" onblur="auto_Drug(this)" class="drugname" placeholder="无"  autocomplete="off" > <!--药品名称的字典查询-->    
                    </td>
                    <td><input type="text" name="spec" class="spec" readonly="true"></td>    <!--药品规格-->
                    <td><input type="text" name="date"  class="date" readonly="true"></td>    <!--有效期-->
                    <td><input type="text" name="drug_number" class="drug_number" readonly="true" ></td>    <!--药品库存-->
                    <td><input type="text" name="open_number" class="open_number" autocomplete="off" ></td> <!--开药数量-->
                    <td>  <!--开药的选择-->
                        <select  name="open_number1" class="open_number1"  onblur="selectspec(this)" >  

                        </select>
                    </td>    
                    <td>
                        <input type="text" name="way1" class="way1" list="way1" ><input type="text" name="way2" class="way1" list="way2" ><input type="text" name="way3" class="way2" list="way3" ><input type="text" name="way4" class="way2" list="way4"><input type="text" name="way5" class="way2" list="way5" ><input type="text" name="way6" class="way2" list="way6" ><input type="text" name="way7" class="way2" list="way7" ><input type="text" name="way8" class="way2" list="way8" >
                    </td>
                    <td><input type="button" value="删除" onclick="deleteRow(this)" >&ensp;<input type="button" value="添加" onclick="insertRowInTable()" ></td>
                </tr>   
            </table>

            <!--其他处理-->
            <br>
            其他处理：
            <select name="other" style="height: 25px;" >
                <option value="无" selected="selected" >无</option>
                <option value="伤口处理" >伤口处理</option>
                <option value="注射处理" >注射处理</option>
                <option value="伤口和注射处理" >伤口和注射处理</option>
            </select>

            <br>
            <br>
            <table id="table" border="1" >
                <th>处理材料/物品</th>
                <th>库存</th>
                <th>使用数量</th>
                <th>操作</th>
                <tr> 
                    <td>
                        <input type="hidden" name="stuffID" >
                        <input type="text" name="stuffname" list="stuffname"  onblur="auto_stuff(this)" placeholder="无" > 
                    </td>
                    <td><input type="text" name="stuffnumber" class="stuffnumber" readonly="true"></td>
                    <td><input type="text" name="use_number" class="use_number" ></td>
                    <td><input type="button"  value="添加" onclick="auto_stuff_add()" >&emsp;<input type="button" value="删除" onclick="auto_stuff_delete(this)" ></td>
                </tr>
            </table>
            <br>
            处理费：<input type="text" name="dealMon"  class="tt" >元&emsp;材料费：<input type="text" name="goodsMon" class="tt"  >元
            <br>
            <input id="sub" type="submit" value="提交药方">
        </form>


        <datalist id="drugname" >  <!--实现药品字典查询效果的代码-->
            <%                for (i = 0; i < drug_name.length; i++) {
            %>
            <option  value="<%=drug_name[i]%>" ><%=drug_pyname[i]%></option>  <!--对象失去焦点时发生事件，用来自动填充药品信息-->
            <%
                }
            %>
        </datalist>

        <datalist id="stuffname" >  <!--实现材料字典查询效果的代码-->
            <%
                for (i = 0; i < stuffname.length; i++) {

            %>
            <option value="<%=stuffname[i]%>"><%=stuffname[i]%></option>
            <%        }

            %>
        </datalist>

        <!--开方数量的字典选择-->
        <datalist id="way1">
            <option>口服</option>
            <option>含服</option>
            <option>口腔用药</option>
            <option>自用</option>
            <option>外用</option>
            <option>眼部用药</option> 
            <option>舌下含服</option>
            <option>肌注</option>
            <option>皮下注射</option> 
            <option>饭前30分钟服药</option>
            <option>睡前空腹服药</option>
            <option>上车前30分钟口服</option>
            <option>首次加倍</option>
        </datalist>
        <datalist id="way2">
            <option>每1小时一次</option>
            <option>每2小时一次</option>
            <option>每3小时一次</option>
            <option>每4小时一次</option>
            <option>每5小时一次</option>
            <option>每6小时一次</option> 
            <option>每7小时一次</option>
            <option>每8小时一次</option>
            <option>每9小时一次</option> 
            <option>每10小时一次</option>
            <option>每11小时一次</option>
            <option>每12小时一次</option>
            <option>每24小时一次</option>
            <option>每36小时一次</option>
            <option>每48小时一次</option>
        </datalist>
        <datalist id="way3">
            <option>一次</option>
        </datalist>
        <datalist id="way4">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
            <option>15</option>
            <option>20</option>
            <option>25</option>
            <option>30</option>
            <option>1-2</option>
            <option>1-3</option>
            <option>2-3</option> 
            <option>2-4</option> 
            <option>3-4</option>
        </datalist>
        <datalist id="way5">
            <option>片</option>
            <option>粒</option>
            <option>板</option>
            <option>丸</option>
            <option>支</option>
            <option>小盒</option>
            <option>盒</option>
            <option>帖</option>
            <option>小瓶</option>
            <option>瓶</option>
            <option>小袋</option>
            <option>袋</option>
            <option>ml</option>
            <option>mg</option>
            <option>g</option>
            <option>卷</option>
            <option>滴</option> 
            <option>张</option> 
            <option>个</option>
            <option>小包</option>
            <option>包</option>
        </datalist>

        <datalist id="way6">
            <option>一天</option>
        </datalist>
        <datalist id="way7">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
            <option>1-2</option>
            <option>1-3</option>
            <option>2-3</option> 
            <option>2-4</option> 
            <option>3-4</option>
        </datalist>
        <datalist id="way8">
            <option>次</option>
        </datalist>
    </body>
</html>


