package ru.timurnav;

/**
 * Created by Тимур Мухитдинов on 22.04.2015.
 */
public class GameLogic {

    static int [][] createNewCanvas(int row, int column){
        int[][] canvas = new int[row][column];
        int n1 = (int) (Math.random()*row);
        int n2;
        do{
            n2 = (int) (Math.random()*row);
        } while (n2==n1);
        int m1 = (int) (Math.random()*column);
        int m2;
        do{
            m2 = (int) (Math.random()*column);
        } while (m2==m1);
        canvas[n1][m1] = 2;
        canvas[n2][m2] = 4;
        return canvas;
    }

    static boolean isGameOver(int[][] canvas){
        for (int[] n : canvas)
            for (int i : n)
                if (i==0) return false;
        int row = canvas.length;
        int column = canvas[0].length;
        for (int i = 0; i < row-1; i++) {
            for (int j = 0; j < column-1; j++) {
                if (canvas[i][j]==canvas[i+1][j]) return false;
                if (canvas[i][j]==canvas[i][j+1]) return false;
                if (canvas[row-1][j]==canvas[row-1][j+1]) return false;
            }
            if (canvas[i][column-1]==canvas[i+1][column-1]) return false;
        }
        return true;
    }

    static void randomSquare(Direction d, int[][] canvas){
        while (true){
            int n = (int)(Math.random()*canvas.length);
            int m = (int)(Math.random()*canvas[0].length);

            if (d.equals(Direction.UP)){
                if (canvas[canvas.length-1][m]==0) {
                    canvas[canvas.length-1][m] = 2;
                    break;
                }

            } else if (d.equals(Direction.DOWN)){
                if (canvas[0][m]==0){
                    canvas[0][m]=2;
                    break;
                }
            } else if (d.equals(Direction.RIGHT)){
                if (canvas[n][0]==0){
                    canvas[n][0]=2;
                    break;
                }
            } else if (d.equals(Direction.LEFT)){
                if (canvas[n][canvas[0].length-1]==0){
                    canvas[n][canvas[0].length-1]=2;
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
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (tempClone[i][j]!=canvas[i][j]) return true;
            }
        }
        return false;
    }
}
