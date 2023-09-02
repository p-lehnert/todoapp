package model;

import database.DBOps;
import frames.EditFrame;
import frames.GUI;
import model.Task;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskComponent extends JPanel implements ActionListener {

    private Task task;

    private JCheckBox checkBox;

    private JButton editButton;

    private JButton deleteButton;

    public TaskComponent (final Task task) {
        this.task = task;
        if (task.isDone()) {
            checkBox = new JCheckBox((Icon) null, true);
        } else {
            checkBox = new JCheckBox();
        }
        checkBox.addActionListener(this::check);
        editButton = new JButton("Edit");
        editButton.addActionListener(this::editTask);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DBOps.deleteTask(task);
        removeFromList();
        GUI.showList();
    }

    private void removeFromList () {
        GUI.taskList.remove(task);
    }

    private void editTask(ActionEvent e) {
        new EditFrame(task);
    }

    private void check(ActionEvent e) {
        DBOps.editTask(task, !task.isDone());
        GUI.showList();
    }

    public Task getTask () {
        return task;
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
}
