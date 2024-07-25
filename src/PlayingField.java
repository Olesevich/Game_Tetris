import javax.swing.*;
import java.awt.*;

public class PlayingField {

    public PlayingField() {

    }

    public void setupDraGame(JLabel draw, int x, int y, int WIDTH, int HEIGTH){
        draw.setBounds(x, y, WIDTH, HEIGTH);
        GameWindow.jf.add(draw);
        draw.setVisible(true);
    }
}

class DrawGame extends JLabel{  //класс ресует игровую сетку
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 24; j++) {
                g.drawRect(i*32,j*32,32,32);
            }
        }
        g.setColor(Color.black);
        g.drawRect(0,0,MainWindow.WIDTH,MainWindow.HEIGTH);//ресует контур вокруг черный методом drawRect()
        repaint();
    }
}

class DrawInterfece extends JLabel {//класс ресует поле в котором будет отбражаться следущая фигура
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                g.drawRect(i*32,j*32,32,32);
            }
        }
        g.setColor(Color.black);
        g.drawRect(0,0,128,128);//ресует контур вокруг черный методом drawRect()
        repaint();
    }
}
