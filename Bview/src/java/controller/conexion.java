package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class conexion {

    Connection con = null;
    Statement stat = null;

    public conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batizviewdb", "root", "n0m3l0");
        } catch (ClassNotFoundException | SQLException x) {
            System.out.println(x + "No se conecto");
            x.printStackTrace();
        }
    }

    public void endConexion() {
        if (con == null || stat == null) {
            try {
                stat.close();
                con.close();
            } catch (SQLException x) {
                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, x);
            }
        } else {
            System.out.println("Connection is already finished");
        }
    }

    public void setStat(Statement x) {
        this.stat = x;
    }

    public void setCon(Connection x) {
        this.con = x;
    }

    public Statement getStat() {
        return this.stat;
    }

    public Connection getCon() {
        return this.con;
    }
}
