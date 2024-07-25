import javax.swing.*;
import java.awt.*;

public class DrawWindow extends JLabel {

    private static int [] gameFigur_X;
    private static int [] gameFigur_Y;
    Fogure fog = new Fogure();

    public DrawWindow() {
    }

    public void nextFigureMiniWindow(){
        fog.randomFigure();
        gameFigur_X = fog.getgFigure_X();
        gameFigur_Y = fog.getgFigure_Y();
    }

    public static void massiv_0(){
        gameFigur_X = new int[]{-1, -1, -1, -1};
        gameFigur_Y = new int[]{-1, -1, -1, -1};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        GamePlay.colorFigurs(g,fog.getNextRandomNumber());
        for (int i = 0; i < gameFigur_X.length; i++) {
            g.fillRect(gameFigur_X[i]*32,gameFigur_Y[i]*32,MainWindow.DOT_SIZE,MainWindow.DOT_SIZE);
        }
    }
}
