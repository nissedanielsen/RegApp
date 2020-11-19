
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studentits;

import db.Database;
import Studentits.Studentits;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nils Danielsen
 */
public class StudentitsDAO {

    // private final String GET_DATA = "SELECT counselor_id, first_name, last_name FROM counselor";
    private final String GET_DATA = "SELECT * FROM gradeappdb.studentits";
    private final String GET_DATA_BY_FIRST_NAME = "SELECT * FROM gradeappdb.studentits WHERE firstName = ?";
    private final String GET_PERSONNR_BY_LTUNAME = "SELECT * FROM gradeappdb.STUDENTITS where nameLtu = ?";

    Connection con = null;
    PreparedStatement ps = null;
    PreparedStatement ps_DATA_BY_FIRST_NAME = null;
    PreparedStatement ps_PERSONNR_BY_LTUNAME = null;
    ResultSet rs = null;

    public List<Studentits> getStudents() {

        // ActorDTO actorDto = null;
        List<Studentits> students = new ArrayList<Studentits>();
        Database db = new Database();
        Studentits student = null;
        try {
            //        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = db.getConnection();
            ps = con.prepareStatement(GET_DATA);
            rs = ps.executeQuery();

            while (rs.next()) {
                student = new Studentits();
                student.setPersonnr(rs.getString(1));
                student.setFirstname(rs.getString(2));
                student.setLastname(rs.getString(3));              
                student.setNameltu(rs.getString(4));
               
                students.add(student);
                
                
                System.out.println(student.getPersonnr());
                System.out.println(student.getFirstname());
                System.out.println(student.getLastname());
                System.out.println(student.getNameltu());
          

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<Studentits> getStudentByFirstName(String firstName) {

        List<Studentits> students = new ArrayList<Studentits>();
        Database db = new Database();
        Studentits student = null;
        try {
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = db.getConnection();
            ps_DATA_BY_FIRST_NAME = con.prepareStatement(GET_DATA_BY_FIRST_NAME);
            ps_DATA_BY_FIRST_NAME.setString(1, firstName);
            rs = ps_DATA_BY_FIRST_NAME.executeQuery();

            while (rs.next()) {

                student = new Studentits();
                
                student.setPersonnr(rs.getString(1));
                student.setFirstname(rs.getString(2));
                student.setLastname(rs.getString(3));
                student.setNameltu(rs.getString(4));
                
                students.add(student);

                System.out.println(student.getFirstname());
                System.out.println(student.getLastname());
                System.out.println(student.getNameltu());
                System.out.println(student.getPersonnr());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;

    }

    public Studentits getStudentByFirstName1(String firstName) {

        // List<Studentits> students = new ArrayList<Studentits>();
        Database db = new Database();
        Studentits student = null;
        try {
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = db.getConnection();
            ps_DATA_BY_FIRST_NAME = con.prepareStatement(GET_DATA_BY_FIRST_NAME);
            ps_DATA_BY_FIRST_NAME.setString(1, firstName);
            rs = ps_DATA_BY_FIRST_NAME.executeQuery();

            while (rs.next()) {

                student = new Studentits();
                student.setFirstname(rs.getString(1));
                student.setLastname(rs.getString(2));
                student.setNameltu(rs.getString(3));
                student.setPersonnr(rs.getString(4));
                //  students.add(student);

                System.out.println(student.getFirstname());
                System.out.println(student.getLastname());
                System.out.println(student.getNameltu());
                System.out.println(student.getPersonnr());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // return students;
        return student;
    }

    public String getPeronnrByLtuName(String LtuName) {

        List<Studentits> students = new ArrayList<Studentits>();
        Database db = new Database();
        Studentits student = null;
        try {
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = db.getConnection();
            ps_PERSONNR_BY_LTUNAME = con.prepareStatement(GET_PERSONNR_BY_LTUNAME);
            ps_PERSONNR_BY_LTUNAME.setString(1, LtuName);
            rs = ps_PERSONNR_BY_LTUNAME.executeQuery();

            while (rs.next()) {

                student = new Studentits();
                
                student.setPersonnr(rs.getString(1));
                student.setFirstname(rs.getString(2));
                student.setLastname(rs.getString(3));
                student.setNameltu(rs.getString(4));
                
                students.add(student);

                System.out.println(student.getFirstname());
                System.out.println(student.getLastname());
                System.out.println(student.getNameltu());
                System.out.println(student.getPersonnr());

                //String personnr = student.getPersonnr();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //   System.out.println("test: " + student.getFirstname());
        String personnr = student.getFirstname();

        return personnr;

    }

    public Studentits getStudentByLtuName(String LtuName) {

        List<Studentits> students = new ArrayList<Studentits>();
        Database db = new Database();
        Studentits student = null;
        try {
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = db.getConnection();
            ps_PERSONNR_BY_LTUNAME = con.prepareStatement(GET_PERSONNR_BY_LTUNAME);
            ps_PERSONNR_BY_LTUNAME.setString(1, LtuName);
            rs = ps_PERSONNR_BY_LTUNAME.executeQuery();

            while (rs.next()) {

                student = new Studentits();
                student.setFirstname(rs.getString(1));
                student.setLastname(rs.getString(2));
                student.setNameltu(rs.getString(3));
                student.setPersonnr(rs.getString(4));
                students.add(student);

                System.out.println(student.getFirstname());
                System.out.println(student.getLastname());
                System.out.println(student.getNameltu());
                System.out.println(student.getPersonnr());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;

    }
    

}
