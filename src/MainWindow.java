import javax.swing.*;
import java.awt.*;


public class MainWindow {

    public static final int DOT_SIZE = 32;
    public static final int WIDTH = 10*DOT_SIZE;
    public static final int HEIGTH = 20*DOT_SIZE;
    public static boolean inGame;
    public static Timer timer;
    public static JLabel l1 = new JLabel();
    public static JLabel l3 = new JLabel();
    public static JLabel l2 = new JLabel();
    public static JLabel l4 = new JLabel();

    public MainWindow() {
        inGame = true;
        PlayingField pf = new PlayingField();

        DrawGame dw = new DrawGame();
        pf.setupDraGame(dw,1,1,WIDTH+1,HEIGTH+1);

        DrawInterfece di = new DrawInterfece();
        pf.setupDraGame(di, WIDTH+DOT_SIZE,50,DOT_SIZE*4+1,DOT_SIZE*4+1);

        GamePlay gp = new GamePlay();
        pf.setupDraGame(gp,1,1,WIDTH,HEIGTH);

        DrawWindow dww = new DrawWindow();
        pf.setupDraGame(dww,WIDTH+DOT_SIZE,50,DOT_SIZE*4,DOT_SIZE*4);

        StaticField sf = new StaticField();
        pf.setupDraGame(sf,1,1,WIDTH,HEIGTH);

        skrinLaben(l1, "Очки", WIDTH+70, DOT_SIZE*5,90,90);
        skrinLaben(l3, "Макс. очки", WIDTH+40, DOT_SIZE*7,140,90);
    }

    public static void main(String[] args) {
       new GameWindow();
    }

    public static void skrinLaben(JLabel l, String str, int a, int b, int c, int d){
        l.setBounds(a,b,c,d);
        GameWindow.jf.add(l);
        l.setText(str);
        l.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l.setVisible(true);
    }
}



