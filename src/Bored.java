import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.Point;
import javax.imageio.ImageIO;
import java.io.File;


public class Bored {

    private int row, col;
    private BufferedImage image, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13;
    private Point location;
    private String filename;
    private int[][] bored;
    private Piece[][] pieces;

    public Bored(String filename, int row, int col) {
//        setSize(row,col);


            bored = new int[8][8];
            for (int i = 0; i < bored.length; i++) {
                for (int j = 0; j < bored[0].length; j++) {
                    if ((i + j) % 2 == 1)
                        bored[i][j] = 0;
                    else
                        bored[i][j] = 1;

                }
            }

        try {
            image = ImageIO.read(new File("respiratory/" + "Wsquare.png"));
            img1 = ImageIO.read(new File("respiratory/" + "Bsquare.png"));
            img2 = ImageIO.read(new File("respiratory/" + "Bbishop.png"));
            img3 = ImageIO.read(new File("respiratory/" + "Bking.png"));
            img4 = ImageIO.read(new File("respiratory/" + "Bknight.png"));
            img5 = ImageIO.read(new File("respiratory/" + "Bpawn.png"));
            img6 = ImageIO.read(new File("respiratory/" + "Bqueen.png"));
            img7 = ImageIO.read(new File("respiratory/" + "Brook.png"));
            img8 = ImageIO.read(new File("respiratory/" + "Wbishop.png"));
            img9 = ImageIO.read(new File("respiratory/" + "Wking.png"));
            img10 = ImageIO.read(new File("respiratory/" + "Wknight.png"));
            img11 = ImageIO.read(new File("respiratory/" + "Wpawn.png"));
            img12 = ImageIO.read(new File("respiratory/" + "Wqueen.png"));
            img13 = ImageIO.read(new File("respiratory/" + "Wrook.png"));
            pieces = new Piece[8][8];
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    if(r==1) {
                        pieces[r][c] = new Piece(r, c, img5);
                    } else if (r==6){
                        pieces[r][c] = new Piece(r,c,img11);
                    }
                    else if (r==0 && (c==0||c==7)){
                        pieces[r][c] = new Piece(r,c,img7);
                    }
                    else if (r==0 && (c==1||c==6)){
                        pieces[r][c] = new Piece(r,c,img4);
                    }
                    else if (r==0 && (c==2||c==5)){
                        pieces[r][c] = new Piece(r,c,img2);
                    }
                    else if (r==0 && c==3){
                        pieces[r][c] = new Piece(r,c,img6);
                    }
                    else if (r==0 && c==4){
                        pieces[r][c] = new Piece(r,c,img3);
                    }
                    else if (r==7 && c==3){
                        pieces[r][c] = new Piece(r,c,img12);
                    }
                    else if (r==7 && c==4){
                        pieces[r][c] = new Piece(r,c,img9);
                    }
                    else if (r==7 && (c==0||c==7)){
                        pieces[r][c] = new Piece(r,c,img13);
                    }
                    else if (r==7 && (c==1||c==6)){
                        pieces[r][c] = new Piece(r,c,img10);
                    }
                    else if (r==7 && (c==2||c==5)){
                        pieces[r][c] = new Piece(r,c,img8);
                    }

                }
            }

        } catch (Exception e)

        {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        for (int i = 0; i < bored.length; i++) {
            for (int j = 0; j < bored[0].length; j++) {
                if(bored[i][j] == 1)
                    g2.drawImage(image, j*75, i*75, null);
                if(bored[i][j] == 0)
                    g2.drawImage(img1, j*75, i*75, null);
            }
        }

        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[0].length; j++) {
                if(pieces[i][j] != null)
                    pieces[i][j].draw(g2);
            }
        }


//        if(image != null){
//            g2.drawImage(image, 0, 0, null);
//        }else{
//            g2.fillRect(location.x, location.y, 100, 100);
//        }
    }
    public boolean peiceHeer(int r, int c){
        if (pieces[r][c]!=null){
            System.out.println("Good");
            return true;
        }
        return false;

    }
    public void movepieve(int r1, int c1, int r, int c){
        Piece pee= new Piece(pieces[r][c]);
        if (pee.getImage()==null){
            System.out.println("Hello World!");
        }
        pieces[r1][c1]=pee;
        pieces[r][c]=null;
    }


}
