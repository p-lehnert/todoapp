package database;

import resources.Constants;

import java.sql.*;

public class CreateDB {

    public static void createNewDatabase() {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS tasks (id integer PRIMARY KEY, task text NOT NULL, done integer NOT NULL);";

        try {
            Connection conn = DriverManager.getConnection(Constants.DATABASE_URL);
            if (conn != null) {
                // connect to db
                DatabaseMetaData metaData = conn.getMetaData();
                System.out.println("Driver name is: " + metaData.getDriverName());
                System.out.println("Connected to Database.");

                // create table
                Statement stmt = conn.createStatement();
                stmt.execute(sqlCreateTable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
