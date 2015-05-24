/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
import java.sql.*;
import javax.swing.*;

public class connect {
    private String user,pass,url;
    public Connection con=null;
    
    public connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            url="jdbc:mysql://localhost/myproject";
            user="root";
            pass="";
            try {
                con=DriverManager.getConnection(url,user,pass);
                JOptionPane.showMessageDialog(null, "conneksi berhasil");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "server belomstart");
                System.exit(1);
            }
        } catch (Exception e) {
            System.out.println("salah");
        }
    }
    
}

