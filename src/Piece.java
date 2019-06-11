import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Piece {
    private int r, c;
    private BufferedImage image;
    public Piece(int r, int c, BufferedImage image) {
        this.r = r;
        this.c = c;
        this.image = image;

    }

    public Piece(Piece p){
        this.r=p.getR();
        this.c=p.getC();
        this.image=p.getImage();
    }

//    public void dirring(ArrayList[] pieces){
//        for (int i = 0; i < pieces.length; i++) {
//            pieces.add
//            }
//
//        }
//

    public void draw(Graphics2D g2){
        g2.drawImage(image, c*75, r*75, null);

    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public BufferedImage getImage() {
        return image;
    }
}
