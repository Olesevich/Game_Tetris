import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePlay extends JLabel implements ActionListener {

    static Fogure fog = new Fogure();
    public static int [] gameFogure_X;
    public static int [] gameFogure_Y;
    private static boolean left = false;
    private static boolean right = false;
    public static boolean down = true;
    private static boolean downSpeed = false;
    StaticField sf = new StaticField();
    private static boolean rotation = false;
    private String statusFigure;
    DrawWindow dww = new DrawWindow();



    public GamePlay(){
        timeR();
        startGameFillMassiv();
        DrawWindow.massiv_0();
        nextFigu(fog.random());
    }

    public static void setGameFogure_X(int[] gameFogure_X) {
        GamePlay.gameFogure_X = gameFogure_X;
    }

    public static void setGameFogure_Y(int[] gameFogure_Y) {
        GamePlay.gameFogure_Y = gameFogure_Y;
    }


    private void startGameFillMassiv(){
        gameFogure_X = new int[]{-32, -32, -32, -32};
        gameFogure_Y = new int[]{-32, -32, -32, -32};
    }

    public void timeR(){//игровой таймер, задающий скорость фигурам
        MainWindow.timer = new Timer(400,this);
        MainWindow.timer.start();
    }

    public void eventLeftRight(int [] x){//движение фигуры влево или вправо
        if (left){
            for (int i = 0; i < x.length; i++) {
                x[i] -= MainWindow.DOT_SIZE;
            }
            left = false;
        }
        if (right){
            for (int q = 0; q < x.length; q++) {
                x[q] += MainWindow.DOT_SIZE;
            }
            right = false;
        }
    }

    public void movement(int [] y){//движение фигуры вниз
        if (down){
            for (int i = 0; i < y.length; i++) {
                y[i] += MainWindow.DOT_SIZE;
            }
        }
        if (downSpeed){
            MainWindow.timer.setDelay(1);
            downSpeed = false;
        }
    }

    public void wallAndFloorLimiter(int [] x, int [] y){//ограничитель по полу и стенам
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 0) {
                left = false;
            }
            if (x[i] >= MainWindow.WIDTH - MainWindow.DOT_SIZE ) {
                right = false;
            }
            if (y[i] >= MainWindow.HEIGTH - MainWindow.DOT_SIZE ) {
                down = false;
            }
        }
    }

    private void figureRotanions(String conditionFigure){
        if (rotation){
            switch (conditionFigure){
                case "T1": fog.rotation_T2();
                    break;
                case "T2": fog.rotation_T3();
                    break;
                case "T3": fog.rotation_T4();
                    break;
                case "T4": fog.rotation_T1();
                    break;
                case "L1": fog.rotation_L2();
                    break;
                case "L2": fog.rotation_L3();
                    break;
                case "L3": fog.rotation_L4();
                    break;
                case "L4": fog.rotation_L1();
                    break;
                case "J1": fog.rotation_J2();
                    break;
                case "J2": fog.rotation_J3();
                    break;
                case "J3": fog.rotation_J4();
                    break;
                case "J4": fog.rotation_J1();
                    break;
                case "I1": fog.rotation_I2();
                    break;
                case "I2": fog.rotation_I1();
                    break;
                case "Z1": fog.rotation_Z2();
                    break;
                case "Z2": fog.rotation_Z1();
                    break;
                case "S1": fog.rotation_S2();
                    break;
                case "S2": fog.rotation_S1();
                    break;
                case "O1": fog.rotation_O1();
                    break;
            }
            dopSumMassiv(conditionFigure);
            rotation = false;
        }
    }

    private void dopSumMassiv(String d){
        int [] rotatX;
        int [] rotatY;
        rotatX = fog.getPerFigureX();
        rotatY = fog.getPerFigureY();
        proverkaFigure_X(gameFogure_X, rotatX, d);
        proverkaFigure_Y(gameFogure_Y,rotatY);
        sumMassiv(gameFogure_X,rotatX);
        sumMassiv(gameFogure_Y,rotatY);
    }

    private int [] sumMassiv(int [] a, int [] b){
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] + b[i];
        }
        return a;
    }

    private void proverkaFigure_X(int [] a, int [] b, String d){//проверяет что бы фигура при вращение не ушла за правое и левое поле
        int [] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
            if(c[i] > MainWindow.WIDTH - MainWindow.DOT_SIZE){
                proverkaRigt(a);
                break;
            }
            if(c[i] == 0){
                proverkaLeft(a,d);
                break;
            }
        }
    }

    private void proverkaFigure_Y(int [] a, int [] b){//проверяет что бы фигура при вращение не ушла ниже стакана
        int [] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
            if(c[i] > MainWindow.HEIGTH - MainWindow.DOT_SIZE){
                proverkaDown(a);
                break;
            }
        }
    }

    private  void proverkaDown(int [] a){
        for (int i = 0; i < a.length; i++) {
            a[i] -= MainWindow.DOT_SIZE;
        }
    }

    private void proverkaRigt(int [] a){
        for (int i = 0; i < a.length; i++) {
            a[i] -= MainWindow.DOT_SIZE;
        }
    }

    private void proverkaLeft(int [] a, String d){
        if(d  ==  "I1"){
            for (int i = 0; i < a.length; i++) {
                a[i] += MainWindow.DOT_SIZE * 2;
            }
        }
    }


    private String setStatusFigure(){
        return statusFigure = fog.getNoFigure();
    }

    public  static void colorFigurs(Graphics g, int a){
        switch (a){
            case 1: g.setColor(Color.YELLOW);
                break;
            case 2: g.setColor(Color.cyan);
                break;
            case 3: g.setColor(Color.ORANGE);
                break;
            case 4: g.setColor(Color.BLUE);
                break;
            case 5: g.setColor(Color.RED);
                break;
            case 6: g.setColor(Color.PINK);
                break;
            case 7: g.setColor(Color.GREEN);
                break;
        }
    }

    private void startPosikFigure(int [] x, int [] y){
        for (int i = 0; i < x.length; i++) {
            x [i] = (MainWindow.WIDTH/MainWindow.DOT_SIZE-x.length)/2*MainWindow.DOT_SIZE + x[i] *MainWindow.DOT_SIZE;
            y [i] = - MainWindow.DOT_SIZE*2+y[i]*MainWindow.DOT_SIZE;
        }
    }

    private void nextFigu(int x){
        fog.nextFigure(x);
        setGameFogure_X(fog.getGamFigure_X());
        setGameFogure_Y(fog.getGamFigure_Y());
        startPosikFigure(gameFogure_X,gameFogure_Y);
        dww.nextFigureMiniWindow();
    }

    private void skrinPoints(){
        MainWindow.skrinLaben(MainWindow.l2,String.valueOf(sf.getPoints()),MainWindow.WIDTH+90,
                MainWindow.DOT_SIZE*6,90,90);
    }

    private void skrinMaxPoints(){
        MainWindow.skrinLaben(MainWindow.l4,String.valueOf(GameWindow.maxPoints),MainWindow.WIDTH+90,
                MainWindow.DOT_SIZE*8,90,90);
    }

    @Override
    public void actionPerformed(ActionEvent e) {//действие
        if(MainWindow.inGame) {
            skrinPoints();
            skrinMaxPoints();
            if (!down){
                MainWindow.timer.setDelay(400);
                nextFigu(fog.getNextRandomNumber());
                down = true;
            }
            setStatusFigure();
            movement(gameFogure_Y);
            wallAndFloorLimiter(gameFogure_X,gameFogure_Y);
            eventLeftRight(gameFogure_X);
            figureRotanions(statusFigure);
            sf.ckechFigure();
            sf.transferFigureOnMap();
            sf.chekLineOnPoints();
            sf.skrinMaxPoints();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {//рисование элементов на игровой доске которые падают
        super.paintComponent(g);
        colorFigurs(g,Fogure.namberFigure);
        for (int i = 0; i < gameFogure_X.length; i++) {
            g.fillRect(gameFogure_X[i],gameFogure_Y[i],MainWindow.DOT_SIZE,MainWindow.DOT_SIZE);
        }
        repaint();
    }

    static class GameEvent extends KeyAdapter {//управление фигурами
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && !right){
                left = true;
            }
            if(key == KeyEvent.VK_RIGHT && !left ){
                right = true;
            }
            if (key == KeyEvent.VK_DOWN){
                downSpeed = true;
            }
            if (key == KeyEvent.VK_UP){
                rotation = true;
            }
        }
    }
}
