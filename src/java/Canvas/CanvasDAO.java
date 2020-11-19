package Canvas;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nils Danielsen
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class CanvasDAO {

    private final String GET_DATA = "SELECT * FROM gradeappdb.canvasresultat";
    private final String GET_DATA_BY_KURS_KOD = "SELECT * FROM gradeappdb.epok WHERE kurskod = ?";

    Connection con = null;
    PreparedStatement ps = null;
    PreparedStatement ps_GET_DATA_BY_KURS_KOD = null;
    ResultSet rs = null;

    public List<Canvas> getCanvas() {

        List<Canvas> canvas = new ArrayList<Canvas>();
        Database db = new Database();
        Canvas c = null;
        try {
            //        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = db.getConnection();
            ps = con.prepareStatement(GET_DATA);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Canvas();
                            
                c.setResultatid(rs.getString(1));
                c.setPersonnr(rs.getString(2));
                c.setNameltu(rs.getString(3));
                c.setModulnr(rs.getString(4));
                c.setBetyg(rs.getString(5));
                
                canvas.add(c);

                System.out.println(c.getResultatid()); 
                System.out.println(c.getPersonnr()); 
                System.out.println(c.getNameltu()); 
                System.out.println(c.getModulnr());
                System.out.println(c.getBetyg());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return canvas;
    }

//    public List<Epok> getEpokByKurskod(String kurskod) {
//
//        List<Epok> epoks = new ArrayList<Epok>();
//        Database db = new Database();
//        Epok epok = null;
//        try {
//            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            con = db.getConnection();
//            ps_GET_DATA_BY_KURS_KOD = con.prepareStatement(GET_DATA_BY_KURS_KOD);
//            ps_GET_DATA_BY_KURS_KOD.setString(1, kurskod);
//            rs = ps_GET_DATA_BY_KURS_KOD.executeQuery();
//
//            while (rs.next()) {
//                epok = new Epok();
//
//                epok.setModulnr(rs.getString(1));
//                epok.setKurskod(rs.getString(2));
//                epok.setKursname(rs.getString(4));
//                epok.setModulname(rs.getString(5));
//                epoks.add(epok);
//
//                System.out.println(epok.getModulnr());
//                System.out.println(epok.getModulname());
//                System.out.println(epok.getKursname());
//                System.out.println(epok.getKurskod());
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return epoks;
//
//    }

}
