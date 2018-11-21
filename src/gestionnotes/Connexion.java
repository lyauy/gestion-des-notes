package gestionnotes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {

    static final String DB_URL
            = "jdbc:mysql://localhost:3306/gestionnote";
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";

    public static void main(String[] args) {

        System.out.print("Test connexion");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM eleve");
            ResultSetMetaData resultMeta = resultSet.getMetaData();

            while (resultSet.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    System.out.print("\t" + resultSet.getObject(i).toString() + "\t |");
                }
            }

        } catch (SQLException ex) {
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
            }
        }
    }
}
