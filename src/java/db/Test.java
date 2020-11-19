/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Canvas.CanvasDAO;
import Epok.EpokDAO;
import Studentits.StudentitsDAO;

/**
 *
 * @author Nils Danielsen
 */
public class Test {
    
    public static void main(String[] args) {
        
        Database db = new Database();
        db.getConnection();
        StudentitsDAO studentdao = new StudentitsDAO();
        studentdao.getStudents();
        EpokDAO epokdao = new EpokDAO();
        epokdao.getEpoks();
        System.out.println("");
        epokdao.getEpokByKurskod("D0025E");
        System.out.println("");
        CanvasDAO c = new CanvasDAO();
        c.getCanvas();
        
    }
    
}
