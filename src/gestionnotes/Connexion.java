package gestionnotes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion {

    static final String DB_URL
            = "jdbc:mysql://localhost:3306/gestionnote";
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public Connexion() {
        System.out.print("Test connexion");
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
//            resultSet = statement.executeQuery("SELECT * FROM eleve");
//            ResultSetMetaData resultMeta = resultSet.getMetaData();

        } catch (SQLException ex) {
        }
    }

    public void setResultSet(String req) {
        try {
            this.resultSet = statement.executeQuery(req);
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        ;
    }

    public Statement getStatement() {
        return statement;
    }

    public void Close() {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
        }
    }
}
