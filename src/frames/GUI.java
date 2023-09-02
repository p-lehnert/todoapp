package frames;

import database.CreateDB;
import database.DBOps;
import model.Task;
import model.TaskComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

public class GUI implements ActionListener {

    public static ArrayList<Task> taskList;

    private final JPanel panel;

    private static final JPanel taskPanel = new JPanel();

    public GUI() {

        taskList = new ArrayList<>();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

        screensize.setSize(screensize.getWidth() / 4, screensize.getHeight() / 2);

        JFrame frame = new JFrame("ToDo");



        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton addTask = new JButton("Add");
        addTask.setPreferredSize(new Dimension(panel.getWidth(),20));
        addTask.addActionListener(this);
        panel.add(addTask);

        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.PAGE_AXIS));
        taskPanel.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()));
        taskPanel.setBackground(Color.LIGHT_GRAY);
        panel.add(taskPanel);

        showList();

        taskPanel.setVisible(true);
        panel.setVisible(true);


        frame.setPreferredSize(screensize);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void showList() {
        GUI.taskList.clear();
        DBOps.getTasks();
        taskPanel.removeAll();
        JLabel label;

        for (Task task : taskList) {
            TaskComponent comp = new TaskComponent(task);
            label = new JLabel(comp.getTask().getText());
            if (task.isDone()) {
                label.setForeground(Color.GREEN);
            }
            taskPanel.add(label);
            taskPanel.add(comp.getCheckBox());
            taskPanel.add(comp.getEditButton());
            taskPanel.add(comp.getDeleteButton());
        }
        taskPanel.repaint();
        taskPanel.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AddFrame();
    }
}
