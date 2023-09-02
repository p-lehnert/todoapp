package frames;

import database.DBOps;
import model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFrame extends JFrame implements ActionListener {

    private JPanel editPanel;

    private JTextPane textToEdit;

    private JButton acceptButton;

    private Task taskToEdit;

    public EditFrame (Task taskToEdit) {
        editPanel = new JPanel();

        this.taskToEdit = taskToEdit;

        textToEdit = new JTextPane();
        textToEdit.setText(taskToEdit.getText());

        acceptButton = new JButton("Add");
        acceptButton.addActionListener(this);

        editPanel.add(textToEdit);
        editPanel.add(acceptButton);
        editPanel.setVisible(true);
        this.setTitle("Edit model.Task");
        this.add(editPanel, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(200, 200));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.setAlwaysOnTop(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = GUI.taskList.indexOf(taskToEdit);
        DBOps.editTask(taskToEdit, textToEdit.getText());
        //GUI.taskList.set(index, new Task(index, textToEdit.getText(), taskToEdit.isDone()));
        GUI.showList();
        this.dispose();
    }
}
