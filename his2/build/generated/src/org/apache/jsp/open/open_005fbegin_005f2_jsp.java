package org.apache.jsp.open;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cn.edu.hcnu.Bean.Student;
import cn.edu.hcnu.Bean.Stuff;
import java.util.Date;
import cn.edu.hcnu.Bean.Drug;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.Context;

public final class open_005fbegin_005f2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/open/../js/session.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style type = \"text/css\"> \n");
      out.write("            .tt{  \n");
      out.write("                border: 0;\n");
      out.write("                outline: 0;\n");
      out.write("                background:transparent;\n");
      out.write("                border-bottom: 2px solid black;\n");
      out.write("                width: 120px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .t2{  \n");
      out.write("                border: 0;\n");
      out.write("                outline: 0;\n");
      out.write("                background:transparent;\n");
      out.write("                border-bottom: 2px solid black;\n");
      out.write("                width: 250px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .t3{  \n");
      out.write("                border: 0;\n");
      out.write("                outline: 0;\n");
      out.write("                background:transparent;\n");
      out.write("                border-bottom: 2px solid black;\n");
      out.write("                width: 150px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            #sub{float: left; margin-left: 1020px; margin-top: 10px;}  \n");
      out.write("            .drugname{width: 200px; }\n");
      out.write("            .spec{width:150px;}\n");
      out.write("            .date{width:80px;}\n");
      out.write("            .open_number{width: 80px;}\n");
      out.write("            .open_number1{float:right;height: 24px;width: 50px;}\n");
      out.write("            .drug_number{width:70px;}\n");
      out.write("            .way1{width: 100px;margin-right: -5px;}\n");
      out.write("            .way2{width:50px;margin-right: -2px;}\n");
      out.write("            .stuffnumber{width: 100px;}\n");
      out.write("            .use_number{width:70px;}\n");
      out.write("            body{position:absolute;left:5px;top:0px;}\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        ");

            request.setCharacterEncoding("utf-8");
            List<Drug> drugs = (List<Drug>) request.getAttribute("drug");     //获取提交过来的所有药品
            List<Stuff> stuffs = (List<Stuff>) request.getAttribute("stuffs");  //获取所有的材料
            List<Student> stu = (List<Student>) request.getAttribute("stu");   // 获取查询得到的学生

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

            int[] stuffID = new int[stuffs.size()];     //存储材料信息，实现自动填充
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
            
if(stu.size()!=0)
{
    for(Student stud:stu)
    {
        stud.getName();
    }
  // String[] student = new String[stu.size()];

}

            

        
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" >\n");
      out.write("\n");
      out.write("            function deleteRow(r)\n");
      out.write("            {\n");
      out.write("                //alert(\"tt\");\n");
      out.write("                //实现增加和删除一行      \n");
      out.write("                var table = document.getElementById(\"myTable\");\n");
      out.write("                var i = r.parentNode.parentNode.rowIndex;  //返回r所在的<tr>位置\n");
      out.write("                // alert(table.rows.length);\n");
      out.write("                if (table.rows.length === 2) {\n");
      out.write("                    alert(\"基础数据，不允许删除\");\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById('myTable').deleteRow(i);  //删除这一行\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function insertRowInTable() {\n");
      out.write("                var table = document.getElementById(\"myTable\");\n");
      out.write("                var newRow = table.insertRow(-1);  //获取表格最后一行\n");
      out.write("                newRow.insertCell().innerHTML = \"<input type='hidden' name='drugID' class='drugID' > <input type='text' name='drugname' list='drugname' onblur='auto_Drug(this)' class='drugname'  autocomplete='off'  >\";\n");
      out.write("                newRow.insertCell().innerHTML = \"<input type='text' name='spec'  class='spec' >\";\n");
      out.write("                newRow.insertCell().innerHTML = \"<input type='text' name='date' class='date'  >\";\n");
      out.write("                newRow.insertCell().innerHTML = \"<input type='text' name='drug_number' class='drug_number' >\";\n");
      out.write("                newRow.insertCell().innerHTML = \"<input type='text' name='open_number' class='open_number' >\";\n");
      out.write("                newRow.insertCell().innerHTML = \"<select  name='open_number1' class='open_number1'  onblur='selectspec(this)'>\";\n");
      out.write("                newRow.insertCell().innerHTML = \"<input type='text' name='way1' class='way1' list='way1' ><input type='text' name='way2' class='way1' list='way2' ><input type='text' name='way3' class='way2' list='way3' ><input type='text' name='way4' class='way2' list='way4'><input type='text' name='way5' class='way2' list='way5' ><input type='text' name='way6' class='way2' list='way6' ><input type='text' name='way7' class='way2' list='way7' ><input type='text' name='way8' class='way2' list='way8' > \";\n");
      out.write("                newRow.insertCell().innerHTML = \"<input type ='button' value='删除' onclick='deleteRow(this)' >&ensp;<input type='button' value='添加' onclick='insertRowInTable()' >\";\n");
      out.write("            }\n");
      out.write("//\n");
      out.write("//            function auto_student(r) {\n");
      out.write("//                alert(\"自动填充\");\n");
      out.write("//            }\n");
      out.write("\n");
      out.write("            function auto_Drug(r) {\n");
      out.write("                var i = r.parentNode.parentNode.rowIndex; //获取所在的行,一行有一个数据，可以记录当前行，用来获取document.getElementsByName返回数组的哪一个值\n");
      out.write("                //alert(i);\n");
      out.write("                var drug_name = document.getElementsByClassName(\"drugname\");  // 因为 getElementsById 只能获取一个元素，这个是自动添加多个的，\n");
      out.write("                var drugID = document.getElementsByClassName(\"drugID\");      //所以要用getElementByClassName()通过类名获取集合，也可以用getElementName(),名字属性值获取\n");
      out.write("                var spec = document.getElementsByClassName(\"spec\");          // 获取的是一个标签属性，用value 得到标签属性值\n");
      out.write("                var date = document.getElementsByClassName(\"date\");\n");
      out.write("                var drug_number = document.getElementsByClassName(\"drug_number\");\n");
      out.write("                var open_number1 = document.getElementsByClassName(\"open_number1\");   //获取使用方法下拉框的选择框的属性。\n");
      out.write("                //    for(var j=0;j<drug_name.length;j++)\n");
      out.write("//                {\n");
      out.write("//                    alert(drug_name[j].value);\n");
      out.write("//                }\n");
      out.write("            ");
   for (int j = 0; j < drug_name.length; j++) {
      out.write("   // jsp 语句嵌在script 中写，有for 循环的范围的括号，后面补上\n");
      out.write("                if (drug_name[i - 1].value === \"");
      out.print(drug_name[j]);
      out.write("\") {\n");
      out.write("                    drugID[i - 1].value = '");
      out.print(drugID[j]);
      out.write("';\n");
      out.write("                    spec[i - 1].value = '");
      out.print(spec[j]);
      out.write("';\n");
      out.write("                    date[i - 1].value = '");
      out.print(date[j]);
      out.write("';\n");
      out.write("                    drug_number[i - 1].value = '");
      out.print(drug_number[j]);
      out.write("';\n");
      out.write("\n");
      out.write("                    var str = \"");
      out.print(spec[j]);
      out.write("\";  // 提前规格中的中文，作为开方数量的选择\n");
      out.write("                    var str1 = str.replace(/[^\\u4e00-\\u9fa5]+/g, \",\"); // 匹配非中文字符，替换为 “,”\n");
      out.write("                    var str2 = str1.split(\",\");    // 分割 “,” 符号 。\n");
      out.write("                    var t = 0;\n");
      out.write("                    open_number1[i - 1].options.length = 0;\n");
      out.write("                    for (var j = 0; j < str2.length; j++)\n");
      out.write("                    {\n");
      out.write("                        console.log(str2[j]);\n");
      out.write("                        if (str2[j] !== \"\")  // 去除为空的数据。\n");
      out.write("                        {\n");
      out.write("                            open_number1[i - 1].options[t] = new Option(str2[j]);  //操作select 中的option，插入\n");
      out.write("                            t++;\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            ");
 }
            
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function auto_stuff_add() {   //材料增加\n");
      out.write("                var table = document.getElementById(\"table\");\n");
      out.write("                // console.log(table);\n");
      out.write("                //console.log(table.rows.length);\n");
      out.write("                var newRow = table.insertRow(-1);\n");
      out.write("                newRow.insertCell().innerHTML = \"<input type='hidden' name='stuffID' ><input type='text' name='stuffname' list='stuffname' onblur='auto_stuff(this)'   > \";\n");
      out.write("                newRow.insertCell().innerHTML = \"<input type='text' name='stuffnumber' class='stuffnumber' >\";\n");
      out.write("                newRow.insertCell().innerHTML = \"<input type='text' name='use_number' class='use_number' >\";\n");
      out.write("                newRow.insertCell().innerHTML = \"<input type='button'  value='添加' onclick='auto_stuff_add()' >&emsp;<input type='button' value='删除' onclick='auto_stuff_delete(this)' >\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            function auto_stuff_delete(r) {  // 材料删除\n");
      out.write("                var table = document.getElementById(\"table\");\n");
      out.write("                var i = r.parentNode.parentNode.rowIndex;  //返回r所在的<tr>位置\n");
      out.write("                // alert(table.rows.length);\n");
      out.write("                if (table.rows.length === 2) {\n");
      out.write("                    alert(\"基础数据，不允许删除\");\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById('table').deleteRow(i);  //删除这一行\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function auto_stuff(r) {\n");
      out.write("                var table = document.getElementById(\"table\");\n");
      out.write("                var i = r.parentNode.parentNode.rowIndex - 1;   //行数从第一行开始,获取所在的行-1\n");
      out.write("                var stuffID = document.getElementsByName(\"stuffID\");\n");
      out.write("                var stuffname = document.getElementsByName(\"stuffname\");\n");
      out.write("                var stuffnumber = document.getElementsByName(\"stuffnumber\");\n");
      out.write("                // console.log(stuffname[i].value);\n");
      out.write("            ");
  for (int j = 0; j < stuffname.length; j++) {
      out.write("\n");
      out.write("                if (stuffname[i].value === \"");
      out.print(stuffname[j]);
      out.write("\")\n");
      out.write("                {\n");
      out.write("                    //  console.log(\"tt\");\n");
      out.write("                    stuffID[i].value =");
      out.print(stuffID[j]);
      out.write(";\n");
      out.write("                    stuffnumber[i].value =");
      out.print(stuffnumber[j]);
      out.write(";\n");
      out.write("                }\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function select_ID() {\n");
      out.write("                var i = document.getElementById(\"studentID\").value;  //获取输入的学号\n");
      out.write("                // console.log(i);\n");
      out.write("                document.location.href = \"his2_Servlet?action=get_studentID.do&studentID=\" + encodeURI(encodeURI(i));\n");
      out.write("            }\n");
      out.write("            function select_name() {\n");
      out.write("                var i = document.getElementById(\"student_name\").value; //获取输入的名字\n");
      out.write("                //    console.log(i);\n");
      out.write("                  \n");
      out.write("                document.location.href = \"his2_Servlet?action=get_name.do&name=\" + encodeURI(encodeURI(i));\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function selectspec(r) {  //选择下拉框自动填充值,\n");
      out.write("                var open_number = document.getElementsByName(\"open_number\");  //所以名字为open_number 的对象，返回一个数组\n");
      out.write("                var i = r.parentNode.parentNode.rowIndex - 1;   // 下拉框所在的tr,从o开始,th 占了一会，所以现在从1开始\n");
      out.write("                // console.log(\"i=\"+i);\n");
      out.write("                var select = document.getElementsByName(\"open_number1\");  // 获取所以的下拉框对象select\n");
      out.write("                var index = select[i].selectedIndex; // 获取选择下拉框的索引\n");
      out.write("                //  console.log(\"tt=\"+select[index].value);\n");
      out.write("                open_number[i].value += (select[i]).options[index].value;\n");
      out.write("                // console.log(\"t1=\"+open_number[i]);\n");
      out.write("                // console.log(\"t2=\"+open_number[i].value);\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body bgcolor=\"CCCFFF\" >\n");
      out.write("        <small><small>");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style> \n");
      out.write("            b{float:right; margin-right: 10px; margin-top: 10px; }\n");
      out.write("            a{text-decoration: none;}\n");
      out.write("            a:visited{color: blue;}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <b>");
  
            if((session.getAttribute("user"))!=null )
            {
                out.print("<b>"+session.getAttribute("name")+"你好！"+"</b><br>");
                String t=request.getContextPath();
                out.print("<b><a  href='"+t+"/js/session_1.jsp'   targer='_top' >"+"退出&emsp;&emsp;"+"</a></b> ");
            }else
            {
               
      out.write("\n");
      out.write("               <script>alert(\"你还没用登录，请先登录\");parent.location.href=\"");
      out.print(request.getContextPath() );
      out.write("/login/land.jsp\";</script>\n");
      out.write("               ");

            }
        
      out.write("</b>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("</small></small>\n");
      out.write("        <h1 align=\"center\">河池学院卫生所主页</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"his2_Servlet?action=open_deal.do\" >  <!--总的提交-->\n");
      out.write("            学号/工号：<input type=\"text\"  list=\"student\"  class=\"t3\" name=\"studentID\" id=\"studentID\" required=\"required\"  >&emsp;<input type=\"button\" value=\"查询\" onclick=\"select_ID()\" >\n");
      out.write("            &emsp;名字：<input type=\"text\" name=\"student_name\" id=\"student_name\" class=\"tt\"  required=\"required\" > &emsp;<input type=\"button\"  value=\"查询\" onclick=\"select_name()\" >\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            &emsp;性别：<input type=\"text\" name=\"sex\"  class=\"tt\"  required=\"required\" >\n");
      out.write("            &emsp;年龄：<input type=\"text\" name=\"age\"  class=\"tt\"   required=\"required\">\n");
      out.write("            &emsp;专业：<input type=\"text\" name=\"major\"  class=\"t2\"   required=\"required\">\n");
      out.write("            &emsp;联系方式：<input type=\"text\" name=\"phone\"  class=\"tt\"  required=\"required\">\n");
      out.write("\n");
      out.write("            <!--下面的开方，只要输入了用户名就可以开方-->\n");
      out.write("            <br>\n");
      out.write("            <h3>医生开方:</h3>\n");
      out.write("            病史：<input type=\"text\" name=\"history\" class=\"t2\" > &emsp;药物过敏史：<input type=\"text\" name=\"allergy\" class=\"t2\" >\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <table id=\"myTable\" bgcolor=\"CCCFFF\" border=\"1\" >\n");
      out.write("                <th>药品名称</th>\n");
      out.write("                <th>规格</th>\n");
      out.write("                <th>药品有效期</th>\n");
      out.write("                <th>库存</th>\n");
      out.write("                <th colspan=\"2\">开药数量</th>\n");
      out.write("                <th>使用方法</th>\n");
      out.write("                <th>操作</th>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"hidden\" name=\"drugID\" class=\"drugID\" >\n");
      out.write("                        <input type=\"text\"  name=\"drugname\" list=\"drugname\" onblur=\"auto_Drug(this)\" class=\"drugname\" placeholder=\"无\"  autocomplete=\"off\"  > <!--药品名称的字典查询-->    \n");
      out.write("                    </td>\n");
      out.write("                    <td><input type=\"text\" name=\"spec\" class=\"spec\" ></td>    <!--药品规格-->\n");
      out.write("                    <td><input type=\"text\" name=\"date\"  class=\"date\" ></td>    <!--有效期-->\n");
      out.write("                    <td><input type=\"text\" name=\"drug_number\" class=\"drug_number\"  ></td>    <!--药品库存-->\n");
      out.write("                    <td><input type=\"text\" name=\"open_number\" class=\"open_number\" ></td> <!--开药数量-->\n");
      out.write("                    <td>  <!--开药的选择-->\n");
      out.write("                        <select  name=\"open_number1\" class=\"open_number1\"  onblur=\"selectspec(this)\" >  \n");
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td>    \n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"way1\" class=\"way1\" list=\"way1\" ><input type=\"text\" name=\"way2\" class=\"way1\" list=\"way2\" ><input type=\"text\" name=\"way3\" class=\"way2\" list=\"way3\" ><input type=\"text\" name=\"way4\" class=\"way2\" list=\"way4\"><input type=\"text\" name=\"way5\" class=\"way2\" list=\"way5\" ><input type=\"text\" name=\"way6\" class=\"way2\" list=\"way6\" ><input type=\"text\" name=\"way7\" class=\"way2\" list=\"way7\" ><input type=\"text\" name=\"way8\" class=\"way2\" list=\"way8\" >\n");
      out.write("                    </td>\n");
      out.write("                    <td><input type=\"button\" value=\"删除\" onclick=\"deleteRow(this)\" >&ensp;<input type=\"button\" value=\"添加\" onclick=\"insertRowInTable()\" ></td>\n");
      out.write("                </tr>   \n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("            <!--其他处理-->\n");
      out.write("            <br>\n");
      out.write("            其他处理：\n");
      out.write("            <select name=\"other\" style=\"height: 25px;\" >\n");
      out.write("                <option value=\"无\" selected=\"selected\" >无</option>\n");
      out.write("                <option value=\"伤口处理\" >伤口处理</option>\n");
      out.write("                <option value=\"注射处理\" >注射处理</option>\n");
      out.write("                <option value=\"伤口和注射处理\" >伤口和注射处理</option>\n");
      out.write("            </select>\n");
      out.write("\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <table id=\"table\" border=\"1\" >\n");
      out.write("                <th>处理材料/物品</th>\n");
      out.write("                <th>库存</th>\n");
      out.write("                <th>使用数量</th>\n");
      out.write("                <th>操作</th>\n");
      out.write("                <tr> \n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"hidden\" name=\"stuffID\" >\n");
      out.write("                        <input type=\"text\" name=\"stuffname\" list=\"stuffname\"  onblur=\"auto_stuff(this)\" placeholder=\"无\" > \n");
      out.write("                    </td>\n");
      out.write("                    <td><input type=\"text\" name=\"stuffnumber\" class=\"stuffnumber\" ></td>\n");
      out.write("                    <td><input type=\"text\" name=\"use_number\" class=\"use_number\" ></td>\n");
      out.write("                    <td><input type=\"button\"  value=\"添加\" onclick=\"auto_stuff_add()\" >&emsp;<input type=\"button\" value=\"删除\" onclick=\"auto_stuff_delete(this)\" ></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <br>\n");
      out.write("            处理费：<input type=\"text\" name=\"dealMon\"  class=\"tt\" >元&emsp;材料费：<input type=\"text\" name=\"goodsMon\" class=\"tt\"  >元\n");
      out.write("            <br>\n");
      out.write("            <input id=\"sub\" type=\"submit\" value=\"提交药方\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <datalist id=\"drugname\" >  <!--实现药品字典查询效果的代码-->\n");
      out.write("            ");
                for (i = 0; i < drug_name.length; i++) {
            
      out.write("\n");
      out.write("            <option  value=\"");
      out.print(drug_name[i]);
      out.write("\" >");
      out.print(drug_pyname[i]);
      out.write("</option>  <!--对象失去焦点时发生事件，用来自动填充药品信息-->\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </datalist>\n");
      out.write("\n");
      out.write("        <datalist id=\"stuffname\" >  <!--实现材料字典查询效果的代码-->\n");
      out.write("            ");

                for (i = 0; i < stuffname.length; i++) {

            
      out.write("\n");
      out.write("            <option value=\"");
      out.print(stuffname[i]);
      out.write('"');
      out.write('>');
      out.print(stuffname[i]);
      out.write("</option>\n");
      out.write("            ");
        }

            
      out.write("\n");
      out.write("        </datalist>\n");
      out.write("\n");
      out.write("        <!--开方数量的字典选择-->\n");
      out.write("        <datalist id=\"way1\">\n");
      out.write("            <option>口服</option>\n");
      out.write("            <option>含服</option>\n");
      out.write("            <option>口腔用药</option>\n");
      out.write("            <option>自用</option>\n");
      out.write("            <option>外用</option>\n");
      out.write("            <option>眼部用药</option> \n");
      out.write("            <option>舌下含服</option>\n");
      out.write("            <option>肌注</option>\n");
      out.write("            <option>皮下注射</option> \n");
      out.write("            <option>饭前30分钟服药</option>\n");
      out.write("            <option>睡前空腹服药</option>\n");
      out.write("            <option>上车前30分钟口服</option>\n");
      out.write("            <option>首次加倍</option>\n");
      out.write("        </datalist>\n");
      out.write("        <datalist id=\"way2\">\n");
      out.write("            <option>每1小时一次</option>\n");
      out.write("            <option>每2小时一次</option>\n");
      out.write("            <option>每3小时一次</option>\n");
      out.write("            <option>每4小时一次</option>\n");
      out.write("            <option>每5小时一次</option>\n");
      out.write("            <option>每6小时一次</option> \n");
      out.write("            <option>每7小时一次</option>\n");
      out.write("            <option>每8小时一次</option>\n");
      out.write("            <option>每9小时一次</option> \n");
      out.write("            <option>每10小时一次</option>\n");
      out.write("            <option>每11小时一次</option>\n");
      out.write("            <option>每12小时一次</option>\n");
      out.write("            <option>每24小时一次</option>\n");
      out.write("            <option>每36小时一次</option>\n");
      out.write("            <option>每48小时一次</option>\n");
      out.write("        </datalist>\n");
      out.write("        <datalist id=\"way3\">\n");
      out.write("            <option>一次</option>\n");
      out.write("        </datalist>\n");
      out.write("        <datalist id=\"way4\">\n");
      out.write("            <option>1</option>\n");
      out.write("            <option>2</option>\n");
      out.write("            <option>3</option>\n");
      out.write("            <option>4</option>\n");
      out.write("            <option>5</option>\n");
      out.write("            <option>6</option>\n");
      out.write("            <option>7</option>\n");
      out.write("            <option>8</option>\n");
      out.write("            <option>9</option>\n");
      out.write("            <option>10</option>\n");
      out.write("            <option>15</option>\n");
      out.write("            <option>20</option>\n");
      out.write("            <option>25</option>\n");
      out.write("            <option>30</option>\n");
      out.write("            <option>1-2</option>\n");
      out.write("            <option>1-3</option>\n");
      out.write("            <option>2-3</option> \n");
      out.write("            <option>2-4</option> \n");
      out.write("            <option>3-4</option>\n");
      out.write("        </datalist>\n");
      out.write("        <datalist id=\"way5\">\n");
      out.write("            <option>片</option>\n");
      out.write("            <option>粒</option>\n");
      out.write("            <option>板</option>\n");
      out.write("            <option>丸</option>\n");
      out.write("            <option>支</option>\n");
      out.write("            <option>小盒</option>\n");
      out.write("            <option>盒</option>\n");
      out.write("            <option>帖</option>\n");
      out.write("            <option>小瓶</option>\n");
      out.write("            <option>瓶</option>\n");
      out.write("            <option>小袋</option>\n");
      out.write("            <option>袋</option>\n");
      out.write("            <option>ml</option>\n");
      out.write("            <option>mg</option>\n");
      out.write("            <option>g</option>\n");
      out.write("            <option>卷</option>\n");
      out.write("            <option>滴</option> \n");
      out.write("            <option>张</option> \n");
      out.write("            <option>个</option>\n");
      out.write("            <option>小包</option>\n");
      out.write("            <option>包</option>\n");
      out.write("        </datalist>\n");
      out.write("\n");
      out.write("        <datalist id=\"way6\">\n");
      out.write("            <option>一天</option>\n");
      out.write("        </datalist>\n");
      out.write("        <datalist id=\"way7\">\n");
      out.write("            <option>1</option>\n");
      out.write("            <option>2</option>\n");
      out.write("            <option>3</option>\n");
      out.write("            <option>4</option>\n");
      out.write("            <option>5</option>\n");
      out.write("            <option>6</option>\n");
      out.write("            <option>7</option>\n");
      out.write("            <option>8</option>\n");
      out.write("            <option>9</option>\n");
      out.write("            <option>10</option>\n");
      out.write("            <option>1-2</option>\n");
      out.write("            <option>1-3</option>\n");
      out.write("            <option>2-3</option> \n");
      out.write("            <option>2-4</option> \n");
      out.write("            <option>3-4</option>\n");
      out.write("        </datalist>\n");
      out.write("        <datalist id=\"way8\">\n");
      out.write("            <option>次</option>\n");
      out.write("        </datalist>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
