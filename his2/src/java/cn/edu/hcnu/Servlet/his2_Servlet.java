/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.hcnu.Servlet;

import cn.edu.hcnu.Bean.Drug;
import cn.edu.hcnu.Bean.Student;
import cn.edu.hcnu.Bean.Stuff;
import cn.edu.hcnu.dao.His2_Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "his2_Servlet", urlPatterns = {"/his2_Servlet"})
public class his2_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        His2_Dao dao = new His2_Dao();
        response.setContentType("text/html;charset=utf-8");////在PrintWriter前面有效果,弹出框乱码问题
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();   //弹出框
        String action = request.getParameter("action");
        switch (action) {

            case "login.do":
                String[] users = {request.getParameter("user"), request.getParameter("pass")};  //获取提交过来的值，赋值改数组
                String[] t = dao.Login(users);
                if (t[0] != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", t[0]);  //设置一个用户名会话
                    session.setAttribute("name", t[1]);  //设置一个名字会话
                    out.write("  <script>alert('登录成功！');document.location.href ='open/main.jsp';</script>");
                    // request.getRequestDispatcher("model_1.jsp").forward(request, response);
                } else {
                    out.write("  <script>alert('用户名、密码输入有误！请重新输入！');document.location.href = 'login/land.jsp';</script>");
                    // request.getRequestDispatcher("login/land.jsp").forward(request, response);
                }
                break;

            case "findPass.do":
                String[] findpass = {request.getParameter("user"), request.getParameter("idNumber")};
                String[] findpassth = dao.FindPass(findpass);
                //out.print(findpassth[0]);
                if (findpassth[0] != null) {
                    request.setAttribute("finepassth", findpassth);
                    request.getRequestDispatcher("login/findPassth.jsp").forward(request, response);
                } else {

                    out.print("<script>alert('身份证号码、用户输入有误,请重新输入!');document.location.href = 'login/findPass.jsp';</script>  ");
                }
                break;

            case "open_begin.do":    //在dao类中创建两个方法，一个是学生，一个是材料
                List<Drug> drugs = dao.getALlDrug();
                List<Stuff> stuffs = dao.getAllStuff();
                request.setAttribute("drug", drugs);
                request.setAttribute("stuffs", stuffs);
//                for(Stuff s:stuffs){
//                    out.println(s.getStuff_name()+" "+s.getStuff_number()+"<br>");
//                }
                request.getRequestDispatcher("open/open_begin.jsp").forward(request, response);
                break;

            case "get_studentID.do":
                String studentID = java.net.URLDecoder.decode(request.getParameter("studentID"), "utf-8");   // 对参数进行解码，提交那边设置二次编码
                // out.println("studentID=" + studentID);
                List<Student> stu = dao.getStudentID(studentID);  // 对输入的学号做实参
                drugs = dao.getALlDrug();
                stuffs = dao.getAllStuff();
                request.setAttribute("stu", stu);
                request.setAttribute("drug", drugs);
                request.setAttribute("stuffs", stuffs);
//                for(Student tt : stu)
//                {
//                    out.println(tt.getName());
//                }
                request.getRequestDispatcher("open/open_begin2.jsp").forward(request, response);
                break;

            case "get_name.do":
                String name = java.net.URLDecoder.decode(request.getParameter("name"), "utf-8");
                //out.println("name=" + name);
                stu = dao.getName(name);    // 获输入的名字做为实参
                drugs = dao.getALlDrug();
                stuffs = dao.getAllStuff();
                request.setAttribute("stu", stu);
                request.setAttribute("drug", drugs);
                request.setAttribute("stuffs", stuffs);
//                   for(Student tt : stu)
//                {
//                    out.println(tt.getName());
//                }
                request.getRequestDispatcher("open/open_begin2.jsp").forward(request, response);
                break;
            case "open_deal.do":
                String[] stud = {request.getParameter("studentID"), request.getParameter("student_name"), request.getParameter("sex"), request.getParameter("age"), request.getParameter("major"), request.getParameter("phone"), request.getParameter("sign")};  //学生信息数组
               
                String[] drugID = request.getParameterValues("drugID");   // 药品所以信息数组
                String[] drugname = request.getParameterValues("drugname");
                String[] spec = request.getParameterValues("spec");
                String[] date = request.getParameterValues("date");
                String[] drug_number = request.getParameterValues("drug_number");
                String[] open_number = request.getParameterValues("open_number");
                String[] way1 = request.getParameterValues("way1");
                String[] way2 = request.getParameterValues("way2");
                String[] way3 = request.getParameterValues("way3");
                String[] way4 = request.getParameterValues("way4");
                String[] way5 = request.getParameterValues("way5");
                String[] way6 = request.getParameterValues("way6");
                String[] way7 = request.getParameterValues("way7");
                String[] way8 = request.getParameterValues("way8"); 
                String[] ways =new String[drugID.length];
                for(int i=0;i<drugID.length;i++)
                {
                    ways[i] =(way1[i]+"     "+way2[i]+"     "+way3[i]+way4[i]+way5[i]+"     "+way6[i]+way7[i]+way8[i]);
                    out.println("tt="+ways[i]+"<br>");
                }
                
                  
//                for( i=0;i<drugID.length;i++)
//                {
//                      String[] drug1 ={}
//                }
                for (String s : open_number) {
                    out.println("s=" + s + "<br>");
                }
                break;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(his2_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(his2_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
