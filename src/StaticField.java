import javax.swing.*;
import java.awt.*;

public class StaticField extends JLabel {

    private int [][] maps;
    Map mp = new Map();
    private int points;
    private int [] pointLevel = new int[]{100, 300, 700, 1500};

    public StaticField() {
    }

    public int getPoints() {
        return points;
    }

    public void skrinMaxPoints(){
        if (points > GameWindow.maxPoints){
            GameWindow.maxPoints = points;
        }
    }

    public void chekLineOnPoints(){
        if (!GamePlay.down) {
            getMaps();
            int line = 0;
            for (int i = 0; i < maps.length; i++) {
                int sum = 0;
                for (int j = 0; j < maps[i].length; j++) {
                    if (maps[i][j] != 0) {
                        sum++;
                    }
                }
                if (sum == 10) {
                    line++;
                    clearLine(i);
                    transferSquares(i);
                }
            }
            gettingPoints(line);
        }
    }

    private void gettingPoints(int line){
        switch (line){
            case 1: points += pointLevel[0];
                break;
            case 2: points += pointLevel[1];
                break;
            case 3: points += pointLevel[2];
                break;
            case 4: points += pointLevel[3];
                break;
        }
    }

    private void clearLine(int a){
        for (int i = 0; i < maps[a].length; i++) {
            maps[a][i] = 0;
        }
    }

    private void transferSquares(int a){
        for (int i = a; i > 0; i--) {
            for (int j = 0; j < maps[i].length ; j++) {
                int t = maps[i][j];
                maps[i][j] = maps[i - 1][j];
                maps[i - 1][j] = t;
            }
        }
    }

    private void clearSkrin(){
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                maps[i][j] = 0;
            }
        }
    }

    private void clearMassiv(int [] a){
        for (int i = 0; i < a.length; i++) {
            a[i] = - 32;
        }
    }

    public void transferFigureOnMap(){
        getMaps();
        if (!GamePlay.down) {
            for (int i = 0; i < GamePlay.gameFogure_X.length; i++) {
                if (GamePlay.gameFogure_X[i] / MainWindow.DOT_SIZE >= 0 && GamePlay.gameFogure_Y[i] / MainWindow.DOT_SIZE >= 0) {
                    maps[GamePlay.gameFogure_Y[i] / MainWindow.DOT_SIZE][GamePlay.gameFogure_X[i] / MainWindow.DOT_SIZE] = Fogure.namberFigure;
                }
                else {
                    MainWindow.timer.stop();
                    MainWindow.inGame = false;
                    clearSkrin();
                    clearMassiv(GamePlay.gameFogure_X);
                    clearMassiv(GamePlay.gameFogure_Y);
                    JOptionPane.showMessageDialog(null,"Вы проиграли!!! Начните заного");
                    new MainWindow();
                    break;
                }
            }
            setMaps();
        }
    }

    public void ckechFigure(){//проверка может ли дальше двигаться фигура
        getMaps();
        if (GamePlay.down){
            for (int i = 0; i < GamePlay.gameFogure_X.length; i++) {
                if (GamePlay.gameFogure_X[i] / MainWindow.DOT_SIZE >= 0 && GamePlay.gameFogure_Y[i] / MainWindow.DOT_SIZE >= 0) {
                    if (maps[(GamePlay.gameFogure_Y[i] / MainWindow.DOT_SIZE) + 1][GamePlay.gameFogure_X[i] / MainWindow.DOT_SIZE]  != 0){
                        GamePlay.down = false;//проверка движения только вниз...надо еще будет дописать в право????
                    }
                }
            }
        }
    }

    private void getMaps(){
        maps = mp.getMapGame();
    }

    private void setMaps(){
        mp.setMapGame(maps);
    }

    public void tessst(){//времененно
        if(!GamePlay.down){
            Map.vivodMasivvaTesta();
        }
    }

    private void scrin(Graphics g){
        getMaps();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] != 0 ){
                    GamePlay.colorFigurs(g,maps[i][j]);
                    g.fillRect(j * MainWindow.DOT_SIZE,i * MainWindow.DOT_SIZE,MainWindow.DOT_SIZE,MainWindow.DOT_SIZE);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {//выводит на экран замараживающиеся фигуры
        super.paintComponent(g);
        scrin(g);

    }
}
