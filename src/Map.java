public class Map {

    private static int [][] mapGame;

    public Map() {
        mapGame = new int[20][10];
    }

    public int[][] getMapGame() {
        return mapGame;
    }

    public void setMapGame(int[][] mapGame) {
        this.mapGame = mapGame;
    }

    public static void vivodMasivvaTesta(){
        for (int i = 0; i < mapGame.length; i++) {
            for (int j = 0; j < mapGame[i].length; j++) {
                System.out.print(mapGame[i][j] + " ");
            }
            System.out.println();
        }

//        MainWindow.timer.stop();
    }


}
