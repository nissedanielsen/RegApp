
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public Connection getConnection() {
        Connection con = null;
        try {
           // Class.forName("com.mysql.jdbc.Driver");

           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradeappdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "Pompe2007!");
        // con = DriverManager.getConnection("jdbc:derby://localhost:1527/gradeSytemDB", "gradeSytemDB", "gradeSytemDB");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("uppkopplad");
        return con;
    }

}
