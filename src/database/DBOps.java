package database;

import frames.GUI;
import model.Task;
import resources.Constants;

import java.sql.*;

public class DBOps {

    private static int done;

    public static void persistTask (Task task) {
        if (task.isDone()) {
            done = 1;
        } else {
            done = 0;
        }
        String sqlAdd = "INSERT INTO tasks (task, done) VALUES (\"" + task.getText() + "\", " + done + ");";
        try (Connection conn = DriverManager.getConnection(Constants.DATABASE_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sqlAdd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTask (Task task) {
        if (task.isDone()) {
            done = 1;
        } else {
            done = 0;
        }
         String sqlDelete = "DELETE FROM tasks WHERE id = " + task.getId();
        try (Connection conn = DriverManager.getConnection(Constants.DATABASE_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sqlDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editTask (Task task, String edit) {
        String sqlUpdate = "UPDATE tasks SET task = \"" + edit + "\" WHERE id = " + task.getId() + ";";

        try (Connection conn = DriverManager.getConnection(Constants.DATABASE_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sqlUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editTask (Task task, boolean check) {
        int edit = check ? 1 : 0;
        String sqlUpdate = "UPDATE tasks SET done = " + edit + " WHERE id = " + task.getId() + ";";

        try (Connection conn = DriverManager.getConnection(Constants.DATABASE_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sqlUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getTasks () {
        String sqlGet = "SELECT * FROM tasks;";
        ResultSet set = null;
        boolean doneBool;
        // int index = 0;

        try (Connection conn = DriverManager.getConnection(Constants.DATABASE_URL)) {
            Statement stmt = conn.createStatement();
            set = stmt.executeQuery(sqlGet);
            while (set.next()) {
                //if (index > GUI.taskList.size()) {
                    doneBool = set.getInt("done") != 0;
                    GUI.taskList.add(new Task(set.getInt("id"), set.getString("task"), doneBool));
                //}
                //index++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getLength () {
        String sqlLength = "SELECT COUNT(*) FROM tasks;";
        ResultSet rs = null;
        int length = 0;

        try (Connection conn = DriverManager.getConnection(Constants.DATABASE_URL)){
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlLength);
            if (rs != null) {
                length = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return length;
    }
}
