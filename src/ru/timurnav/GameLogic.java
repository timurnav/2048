package ru.timurnav;

/**
 * Created by Тимур Мухитдинов on 22.04.2015.
 */
public class GameLogic {

    static int [][] createNewCanvas(){
        return new int[][]{{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},};
    }

    static boolean isGameOver(int[][] canvas){
        for (int[] n : canvas)
            for (int i : n)
                if (i==0) return false;
        return true;
    }

    static void randomSquare(Direction d, int[][] canvas) throws GameOverException {
        if (isGameOver(canvas)) throw new GameOverException();
        while (true){
            int n = (int)(Math.random()*4);

            if (d.equals(Direction.UP)){
                if (canvas[3][n]==0) {
                    canvas[3][n] = 2;
                    break;
                }

            } else if (d.equals(Direction.DOWN)){
                if (canvas[0][n]==0){
                    canvas[0][n]=2;
                    break;
                }
            } else if (d.equals(Direction.RIGHT)){
                if (canvas[n][0]==0){
                    canvas[n][0]=2;
                    break;
                }
            } else if (d.equals(Direction.LEFT)){
                if (canvas[n][3]==0){
                    canvas[n][3]=2;
                    break;
                }
            }
        }

    }

    public static int[][] copy2DArray(int[][] canvasSource) {
        int[][] clone = canvasSource.clone();
        for (int i = 0; i < canvasSource.length; i++) {
            clone[i] = canvasSource[i].clone();
        }
        return clone;
    }

    public static boolean isCanged(int[][] tempClone, int[][] canvas) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tempClone[i][j]!=canvas[i][j]) return true;
            }
        }
        return false;
    }
}
