import javax.swing.*;

public class GameWindow {

    public static JFrame jf;

    public static int maxPoints;

    public GameWindow() {
        jf = new JFrame();
        jf.setTitle("Tetris");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(MainWindow.WIDTH+17+180,MainWindow.HEIGTH+41);//WIDTH+17,HEIGHT+41
        jf.setLayout(null);
        jf.addKeyListener(new GamePlay.GameEvent());
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setVisible(true);
        new MainWindow();
        maxPoints = 0;
    }
}
