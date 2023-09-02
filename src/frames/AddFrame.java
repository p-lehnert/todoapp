package frames;

import database.DBOps;
import model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AddFrame extends JFrame implements ActionListener {

    private JTextPane textField;

    private JButton acceptButton;

    private JPanel addPanel;

    public AddFrame() {

        addPanel = new JPanel();

        textField = new JTextPane();
        KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0);
        String actionKey= "none";
        InputMap map = textField.getInputMap();
        map.put(enterKey, actionKey);

        acceptButton = new JButton("Add");
        acceptButton.addActionListener(this);

        addPanel.add(textField);
        addPanel.add(acceptButton);
        addPanel.setVisible(true);
        this.getRootPane().setDefaultButton(acceptButton);
        this.setTitle("Add model.Task");
        this.add(addPanel, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(200, 200));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.setAlwaysOnTop(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = DBOps.getLength() + 1;
        Task task = new Task(index, textField.getText(), false);
        DBOps.persistTask(task);
        GUI.taskList.add(task);
        GUI.showList();
        this.dispose();
    }
}
