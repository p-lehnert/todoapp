import database.CreateDB;
import database.DBOps;
import frames.GUI;
import model.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    private static ResultSet set;

    public static void main(String[] args) {
        CreateDB.createNewDatabase();
        new GUI();
    }
}
