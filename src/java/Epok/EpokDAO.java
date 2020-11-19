package Epok;

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
public class EpokDAO {

    private final String GET_DATA = "SELECT * FROM gradeappdb.epok";
    private final String GET_DATA_BY_KURS_KOD = "SELECT * FROM gradeappdb.epok WHERE kurskod = ?";

    Connection con = null;
    PreparedStatement ps = null;
    PreparedStatement ps_GET_DATA_BY_KURS_KOD = null;
    ResultSet rs = null;

    public List<Epok> getEpoks() {

        // ActorDTO actorDto = null;
        List<Epok> epoks = new ArrayList<Epok>();
        Database db = new Database();
        Epok epok = null;
        try {
            //        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = db.getConnection();
            ps = con.prepareStatement(GET_DATA);
            rs = ps.executeQuery();

            while (rs.next()) {
                epok = new Epok();

                epok.setModulnr(rs.getString(1));
                epok.setKurskod(rs.getString(2));
                epok.setKursname(rs.getString(4));
                epok.setModulname(rs.getString(5));
                epoks.add(epok);

                System.out.println(epok.getModulnr());
                System.out.println(epok.getModulname());
                System.out.println(epok.getKursname());
                System.out.println(epok.getKurskod());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return epoks;
    }

    public List<Epok> getEpokByKurskod(String kurskod) {

        List<Epok> epoks = new ArrayList<Epok>();
        Database db = new Database();
        Epok epok = null;
        try {
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = db.getConnection();
            ps_GET_DATA_BY_KURS_KOD = con.prepareStatement(GET_DATA_BY_KURS_KOD);
            ps_GET_DATA_BY_KURS_KOD.setString(1, kurskod);
            rs = ps_GET_DATA_BY_KURS_KOD.executeQuery();

            while (rs.next()) {
                epok = new Epok();

                epok.setModulnr(rs.getString(1));
                epok.setKurskod(rs.getString(2));
                epok.setKursname(rs.getString(4));
                epok.setModulname(rs.getString(5));
                epoks.add(epok);

                System.out.println(epok.getModulnr());
                System.out.println(epok.getModulname());
                System.out.println(epok.getKursname());
                System.out.println(epok.getKurskod());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return epoks;

    }

}
