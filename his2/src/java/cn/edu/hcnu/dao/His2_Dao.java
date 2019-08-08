/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.hcnu.dao;

import cn.edu.hcnu.Bean.Drug;
import cn.edu.hcnu.Bean.Student;
import cn.edu.hcnu.Bean.Stuff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
public class His2_Dao {

    private Context ctx = null;
    private DataSource ds = null;
    private Connection conn = null;
    private ResultSet rs = null;
    private Statement stmt = null;
    private PreparedStatement ps = null;

    public String[] Login(String[] users) throws SQLException {
        String[] user = new String[2];
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                if (users[0].equals(rs.getString("userID")) == true && users[1].equals(rs.getString("pass")) == true) {  //用户名和密码都正确 
                    user[0] = rs.getString("userID");
                    user[1] = rs.getString("name");
                    break;
                }
            }
        } catch (NamingException ex) {
            Logger.getLogger(His2_Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(His2_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;

    }

    public String[] FindPass(String[] findpass) {
        String[] findpassth = new String[2];
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                if ((rs.getString("userID").equals(findpass[0])) == true && (rs.getString("idNumber").equals(findpass[1])) == true) {
                    findpassth[0] = rs.getString("userID");
                    findpassth[1] = rs.getString("pass");
                    break;
                }
            }
        } catch (NamingException ex) {
            Logger.getLogger(His2_Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(His2_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return findpassth;
    }

    public List<Drug> getALlDrug() {
        List<Drug> drugs = new ArrayList<Drug>();
        try {

            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from Drug");
            while (rs.next()) {
                Drug dr = new Drug();
                dr.setDrugID(rs.getInt("drugID"));
                dr.setName(rs.getString("name"));
                dr.setPyname(rs.getString("pyname"));
                dr.setSpec(rs.getString("spec"));
                dr.setDate(rs.getDate("date"));
                dr.setNumber(rs.getString("number"));
                drugs.add(dr);

            }
            for (Drug t : drugs) {
                System.out.println(t.getName());
            }

        } catch (NamingException ex) {
            Logger.getLogger(His2_Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(His2_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return drugs;

    }

    public List<Stuff> getAllStuff() {
        List<Stuff> stuffs = new ArrayList<Stuff>();
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from stuff ");
            while (rs.next()) {
                Stuff st = new Stuff();
                st.setStuffID(rs.getInt("stuffID"));
                st.setStuff_name(rs.getString("name"));
                st.setStuff_number(rs.getInt("number"));
                stuffs.add(st);
            }

        } catch (NamingException ex) {
            Logger.getLogger(His2_Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(His2_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stuffs;
    }

    public List<Student> getStudentID(String studentID) {
        List<Student> st = new ArrayList<Student>();
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from student where studentID='" + studentID + " '");
            while (rs.next()) {
                Student std = new Student();
                std.setStudentID(rs.getString("StudentID"));
                std.setName(rs.getString("name"));
                std.setSex((rs.getString("sex")));
                std.setAge(rs.getInt("age"));
                std.setMajor(rs.getString("major"));
                std.setPhone(rs.getString("phone"));
                std.setSign(rs.getInt("sign"));
                st.add(std);
            }

        } catch (NamingException ex) {
            Logger.getLogger(His2_Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(His2_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;

    }

    public List<Student> getName(String name) {
        List<Student> st = new ArrayList<Student>();
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from student where name='" + name + "' ");
            while (rs.next()) {
                Student std = new Student();
                std.setStudentID(rs.getString("StudentID"));
                std.setName(rs.getString("name"));
                std.setSex((rs.getString("sex")));
                std.setAge(rs.getInt("age"));
                std.setMajor(rs.getString("major"));
                std.setPhone(rs.getString("phone"));
                std.setSign(rs.getInt("sign"));
                st.add(std);
            }

        } catch (NamingException ex) {
            Logger.getLogger(His2_Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(His2_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }
}
