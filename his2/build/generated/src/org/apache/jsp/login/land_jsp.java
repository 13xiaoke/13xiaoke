package org.apache.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class land_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write(' ');
      out.write(' ');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            a {text-decoration: none;}\n");
      out.write("            table{margin-top:100px; }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body  >\n");
      out.write("    <center>\n");
      out.write("        <form action=\"../his2_Servlet?action=login.do\" method=\"post\">\n");
      out.write("            <table bordre=\"1\"  bgcolor=\"CCCFFF\" >\n");
      out.write("                <tr align=\"center\"><td><h3>《医院管理系统登录》</h3></td></tr>\n");
      out.write("                <tr><td>用户名：<input type=\"text\" name=\"user\" required=\"required\"></td></tr>\n");
      out.write("                <tr><td>密&emsp;码：<input type=\"password\" name=\"pass\" placeholder=\"不少于6单词个字符\" required=\"required\"  pattern=\"\\w{6,}\" title=\"密码输入不符合要求！\"></td></tr>\n");
      out.write("                <tr><td  align=\"center\"><input type=\"submit\" value=\"登陆\"></td></tr>\n");
      out.write("                <tr><td  align=\"center\"><a href=\"findPass.jsp\">&emsp;&emsp;忘记密码</a>&emsp;&emsp;\n");
      out.write("                    </td></tr> \n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </center>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
