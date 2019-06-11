import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Maine extends JPanel{

    private Bored image;
    private int clicks;
    private int r, c;

    public Maine(){

        String filename = "Bbishop.png";
        image = new Bored(filename, 8, 8);
        clicks=0;
        r=-10;
        c=-10;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int r1 = mouseEvent.getY() / 75;
                int c1 = mouseEvent.getX() / 75;
                if (clicks%2==1){
                    image.movepieve(r1,c1,r,c);
                    clicks++;
                }
                else if (clicks%2==0 && image.peiceHeer(r1,c1)){
                    r=r1;
                    c=c1;
                    clicks++;
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

    }


    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        image.draw(g2);


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chest");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        int width = 600;
        int height = 600;
        frame.setPreferredSize(new Dimension(width, height + 24));

        JPanel panel = new Maine();
        panel.setFocusable(true);
        panel.grabFocus();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}