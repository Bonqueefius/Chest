import javax.swing.*;
import java.awt.*;

public class Maine {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chest");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        int width = 600;
        int height = 600;
        frame.setPreferredSize(new Dimension(width, height + 24));



        JPanel panel = new Bored(width, height);
        panel.setFocusable(true);
        panel.grabFocus();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}