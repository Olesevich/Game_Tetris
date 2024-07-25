import java.util.SplittableRandom;

public class Fogure {

    public static int namberFigure ;
    private int [] perFigureX;
    private int [] perFigureY;
    private String noFigure;
    private int [] gamFigure_X;
    private int [] gamFigure_Y;
    private int [] gFigure_X;
    private int [] gFigure_Y;
    private static int nextRandomNumber;

    Fogure() {
    }

    public int getNextRandomNumber() {
        return nextRandomNumber;
    }

    public int[] getPerFigureX() {
        return perFigureX;
    }

    public int[] getPerFigureY() {
        return perFigureY;
    }

    public int[] getGamFigure_X() {
        return gamFigure_X;
    }

    public int[] getGamFigure_Y() {
        return gamFigure_Y;
    }

    public String getNoFigure() {
        return noFigure;
    }

    public int[] getgFigure_X() {
        return gFigure_X;
    }

    public int[] getgFigure_Y() {
        return gFigure_Y;
    }

    private void creatins(){
        gamFigure_X = new int[4];
        gamFigure_Y = new int[4];
    }

    private void creat(){
        gFigure_X = new int[4];
        gFigure_Y = new int[4];
    }

    public void figure_O(){//создание новой фигуры "O" "1"
        creat();
        nextRandomNumber = 1;
        gFigure_X = new int[]{1, 2, 2, 1};
        gFigure_Y = new int[]{1, 1, 2, 2};
    }

    public void creatingFigure_O(){//создание новой фигуры "O" "1"
        namberFigure = 1;
        creatins();
        gamFigure_X = new int[]{1, 2, 2, 1};
        gamFigure_Y = new int[]{1, 1, 2, 2};
        noFigure = "O1";
    }

    public void rotation_O1(){
        noFigure = "O1";
        perFigureX = new int[]{0, 0, 0, 0};
        perFigureY = new int[]{0, 0, 0, 0};
    }

    public void figure_I(){ //создание фигуры "I" "2"
        creat();
        nextRandomNumber = 2;
        gFigure_X = new int[]{2, 2, 2, 2};
        gFigure_Y = new int[]{0, 1, 2, 3};
    }

    public void creatigFigure_I(){ //создание фигуры "I" "2"
        namberFigure = 2;
        creatins();
        gamFigure_X = new int[]{2, 2, 2, 2};
        gamFigure_Y = new int[]{0, 1, 2, 3};
        noFigure = "I1";
    }

    public void rotation_I1(){
        noFigure = "I1";
        perFigureX = new int[]{-32, 0, 32, 64};
        perFigureY = new int[]{-32, 0, 32, 64};
    }

    public void rotation_I2(){
        noFigure = "I2";
        perFigureX = new int[]{32, 0, -32, -64};
        perFigureY = new int[]{32, 0, -32, -64};
    }

    public void figure_L(){
        creat();
        nextRandomNumber = 3;
        gFigure_X = new int[]{1, 1, 1, 2};
        gFigure_Y = new int[]{0, 1, 2, 2};
    }

    public void creatigFigure_L(){
        namberFigure = 3;
        creatins();
        gamFigure_X = new int[]{1, 1, 1, 2};
        gamFigure_Y = new int[]{0, 1, 2, 2};
        noFigure = "L1";
    }

    public void rotation_L1(){
        noFigure = "L1";
        perFigureX = new int[]{32, 0, -32, 0};
        perFigureY = new int[]{-64, -32, 0, 32};
    }

    public void rotation_L2(){
        noFigure = "L2";
        perFigureX = new int[]{64, 32, 0, -32};
        perFigureY = new int[]{32, 0, -32, 0};
    }

    public void rotation_L3(){
        noFigure = "L3";
        perFigureX = new int[]{-32, 0, 32, 0};
        perFigureY = new int[]{64, 32, 0, -32};
    }

    public void rotation_L4(){
        noFigure = "L4";
        perFigureX = new int[]{-64, -32, 0, 32};
        perFigureY = new int[]{-32, 0, 32, 0};
    }

    public void figure_J(){
        creat();
        nextRandomNumber = 4;
        gFigure_X = new int[]{2, 2, 2, 1};
        gFigure_Y = new int[]{0, 1, 2, 2};
    }

    public void creatigFigure_J(){
        namberFigure = 4;
        creatins();
        gamFigure_X = new int[]{2, 2, 2, 1};
        gamFigure_Y = new int[]{0, 1, 2, 2};
        noFigure = "J1";
    }

    public void rotation_J1(){
        noFigure = "J1";
        perFigureX = new int[]{64, 32, 0, -32};
        perFigureY = new int[]{-32, 0, 32, 0};
    }

    public void rotation_J2(){
        noFigure = "J2";
        perFigureX = new int[]{32, 0, -32, 0};
        perFigureY = new int[]{64, 32, 0, -32};
    }

    public void rotation_J3(){
        noFigure = "J3";
        perFigureX = new int[]{-64, -32, 0, 32};
        perFigureY = new int[]{0, -32, -64, -32};
    }

    public void rotation_J4(){
        noFigure = "J4";
        perFigureX = new int[]{-32, 0, 32, 0};
        perFigureY = new int[]{-32, 0, 32, 64};
    }

    public void figure_Z(){
        creat();
        nextRandomNumber = 5;
        gFigure_X = new int[]{1, 2, 2, 3};
        gFigure_Y = new int[]{1, 1, 2, 2};
    }

    public void creatigFigure_Z(){
        namberFigure = 5;
        creatins();
        gamFigure_X = new int[]{1, 2, 2, 3};
        gamFigure_Y = new int[]{1, 1, 2, 2};
        noFigure = "Z1";
    }

    public void rotation_Z1(){
        noFigure = "Z1";
        perFigureX = new int[]{0, 32, 0, 32};
        perFigureY = new int[]{-32, 0, 32, 64};
    }

    public void rotation_Z2(){
        noFigure = "Z2";
        perFigureX = new int[]{0, -32, 0, -32};
        perFigureY = new int[]{32, 0, -32, -64};
    }

    public void figure_T(){
        creat();
        nextRandomNumber = 6;
        gFigure_X = new int[]{2, 1, 2, 3};
        gFigure_Y = new int[]{1, 2, 2, 2};
    }

    public void creatigFigure_T(){
        namberFigure = 6;
        creatins();
        gamFigure_X = new int[]{2, 1, 2, 3};
        gamFigure_Y = new int[]{1, 2, 2, 2};
        noFigure = "T1";
    }

    public void rotation_T1(){
        noFigure = "T1";
        perFigureX = new int[]{32, -32, 0, 32};
        perFigureY = new int[]{0, 64, 32, 0};
    }

    public void rotation_T2(){
        noFigure = "T2";
        perFigureX = new int[]{32, 32, 0, -32};
        perFigureY = new int[]{64, 64, 32, 0};
    }

    public void rotation_T3(){
        noFigure = "T3";
        perFigureX = new int[]{-32, 32, -0, -32};
        perFigureY = new int[]{0, -64, -32, 0};
    }

    public void rotation_T4(){
        noFigure = "T4";
        perFigureX = new int[]{-32, -32, 0, 32};
        perFigureY = new int[]{0, 0, 32, 64};
    }

    public void figure_S(){
        creat();
        nextRandomNumber = 7;
        gFigure_X = new int[]{1, 2, 2, 3};
        gFigure_Y = new int[]{2, 2, 1, 1};
    }

    public void creatigFigure_S(){
        namberFigure = 7;
        creatins();
        gamFigure_X = new int[]{1, 2, 2, 3};
        gamFigure_Y = new int[]{2, 2, 1, 1};
        noFigure = "S1";
    }

    public void rotation_S1(){
        noFigure = "S1";
        perFigureX = new int[]{-32, 0, 32, 64};
        perFigureY = new int[]{0, 32, 0, 32};
    }

    public void rotation_S2(){
        noFigure = "S2";
        perFigureX = new int[]{32, 0, -32, -64};
        perFigureY = new int[]{0, -32, 0, -32};
    }

    public int random(){
        SplittableRandom rd = new SplittableRandom();
        int random = rd.nextInt(1,8);
        return random;
    }

    public void nextFigure(int a){
        switch (a){
            case 1:creatingFigure_O();
                break;
            case 2:creatigFigure_I();
                break;
            case 3:creatigFigure_L();
                break;
            case 4:creatigFigure_J();
                break;
            case 5:creatigFigure_Z();
                break;
            case 6:creatigFigure_T();
                break;
            case 7:creatigFigure_S();
                break;
        }
    }

    public void randomFigure(){
        switch (random()){
            case 1:
                figure_O();
                break;
            case 2:
                figure_I();
                break;
            case 3:
                figure_L();
                break;
            case 4:
                figure_J();
                break;
            case 5:
                figure_Z();
                break;
            case 6:
                figure_T();
                break;
            case 7:
                figure_S();
                break;
        }
    }
}
