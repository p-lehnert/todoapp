import javax.swing.*;
import java.awt.*;

public class GUI {

    public GUI() {
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

         screensize.setSize(screensize.getWidth() / 2, screensize.getHeight() / 2);

        JFrame frame = new JFrame();

        JButton addTask = new JButton("Add");


        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0,1));
        panel.add(addTask);


        frame.setPreferredSize(screensize);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("ToDo");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    private void setTable() {

    }

}
