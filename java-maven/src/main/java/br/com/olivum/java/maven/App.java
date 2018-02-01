package br.com.olivum.java.maven;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static String status = "";

    public App() {
    }

    public static java.sql.Connection getConnection() {
        Connection connection = null;

        try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

            Class.forName(driverName);

            String serverName = "localhost:1433";
            String databaseName = "commerce";

            String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + databaseName + ";integratedSecurity=true;";

            String username = "admin01";
            String password = "sqlserver";

            System.out.println("Connection URL: " + url);

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                status = "OK";

                System.out.println("Connection OK");
            }
            else {
                status = "ERROR";

                System.out.println("Connection Error");
            }

            return connection;

        }
        catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());

            return null;
        }
        catch (SQLException e) {
            System.err.println("Cannot connecct to database.");

            System.err.println(e.getMessage());

            return null;
        }
    }

    public static String statusConection() {
        return status;
    }

    public static boolean closeConnection() {
        try {
            App.getConnection().close();

            return true;
        }
        catch (SQLException e) {
            return false;
        }
    }

    public static java.sql.Connection restartConnection() {
        closeConnection();

        return App.getConnection();
    }

    public static void listRoutes(Connection con) throws SQLException {
        Statement stmt = null;
        String query = "SELECT * FROM product ORDER BY id";

        System.out.println("Query to retrieve products: " + query);

        try {
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int route_id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println("route id: " + route_id + ", name: " + name);
            }
        }
        catch (SQLException e) {
            System.err.println("Error on database query." + e);
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static void main(String args[]) {
        Connection connection = getConnection();

        try {
            listRoutes(connection);
        }
        catch (SQLException e) {
            System.err.println("Error on listing routes.");
        }

        closeConnection();
    }
}