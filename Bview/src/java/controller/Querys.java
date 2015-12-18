package controller;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.Map;

public class Querys {

    private conexion mycon;
    private ResultSet res;

    private ArrayList run = new ArrayList();
    private int ax = 1;

    private PreparedStatement pst;
    private String sql;

    public Querys() {

        this.mycon = new conexion();

    }

    public void endConexion() {

        this.mycon.endConexion();

    }

    public void setStatement(ArrayList valores) throws SQLException {

        pst = mycon.getCon().prepareStatement(this.sql);

        for (Object e : valores) {

            pst.setString(ax, valores.get(ax - 1).toString());
            ax++;

        }
        ax = 1;
    }

    public void executePST() throws SQLException {

        pst.executeUpdate();

    }

    /**
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public ResultSet executeSql() throws SQLException {

        return pst.getResultSet();

    }

    public ArrayList getResult(String[] valores) throws SQLException {

        this.res = pst.executeQuery();

        while (res.next()) {
            for (String valor : valores) {
                run.add(res.getString(valor));
                ax++;
            }
        }

        ax = 1;

        return run;
    }

    public void setSql(String query) {

        this.sql = query;

    }

    public String getQuery() {

        return this.sql;

    }
}
