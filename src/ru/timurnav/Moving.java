package ru.timurnav;

/**
 * Created by Тимур Мухитдинов on 22.04.2015.
 */
public class Moving {

    static int[][] move(Direction d, int[][] canvas){
        if (d.equals(Direction.UP)) return moveUp(canvas);
        if (d.equals(Direction.DOWN)) return moveDown(canvas);
        if (d.equals(Direction.RIGHT)) return moveRight(canvas);
        else return moveLeft(canvas);
    }

    static int [][] moveUp (int[][] canvas){
        for (int i = 0; i < 4; i++) {//это столбцы
            for (int j = 0; j < 3; j++) {//это строки
                for (int l = 0; l < 3-j; l++) {//это просто счетчик
                    if (canvas[j][i]==0) {
                        for (int k = j; k < 3; k++) {
                            canvas[k][i] = canvas[k+1][i];
                        }
                        canvas[3][i]=0;
                    }
                }
            }
            for (int j = 0; j < 3; j++) {//это столбцы
                    if (canvas[j][i]==canvas[j+1][i]) {
                        canvas[j][i]+=canvas[j+1][i];
                        for (int k = j+1; k < 3; k++) {
                            canvas[k][i] = canvas[k+1][i];
                        }
                        canvas[3][i]=0;
                    }
            }
        }
        return canvas;
    }

    static int [][] moveDown(int[][] canvas){
        for (int i = 0; i < 4; i++) {//это столбцы
            for (int j = 3; j > 0; j--) {//это строки
                for (int l = 0; l < j; l++) {//это просто счетчик
                    if (canvas[j][i]==0) {
                        for (int k = j; k > 0; k--) {
                            canvas[k][i] = canvas[k-1][i];
                        }
                        canvas[0][i]=0;
                    }
                }
            }
            for (int j = 3; j > 0; j--) {//это строки
                    if (canvas[j][i]==canvas[j-1][i]) {
                        canvas[j][i]+=canvas[j-1][i];
                        for (int k = j-1; k > 0; k--) {
                            canvas[k][i] = canvas[k-1][i];
                        }
                        canvas[0][i]=0;
                    }
            }
        }
        return canvas;
    }

    static int [][] moveRight(int[][] canvas){
        for (int i = 0; i < 4; i++) {//это строки
            for (int j = 3; j > 0; j--) {//это столбцы
                for (int l = 0; l < j; l++) {//это просто счетчик
                    if (canvas[i][j]==0) {
                        for (int k = j; k > 0; k--) {
                            canvas[i][k] = canvas[i][k-1];
                        }
                        canvas[i][0]=0;
                    }
                }
            }
            for (int j = 3; j > 0; j--) {//это столбцы
                    if (canvas[i][j]==canvas[i][j-1]) {
                        canvas[i][j]+=canvas[i][j-1];
                        for (int k = j-1; k > 0; k--) {
                            canvas[i][k] = canvas[i][k-1];
                        }
                        canvas[i][0]=0;
                    }
            }
        }
        return canvas;
    }

    static int [][] moveLeft(int[][] canvas){
        for (int i = 0; i < 4; i++) {//это строки
            for (int j = 0; j < 3; j++) {//это столбцы
                for (int l = 0; l < 3-j; l++) {//это просто счетчик
                    if (canvas[i][j]==0) {
                        for (int k = j; k < 3; k++) {
                            canvas[i][k] = canvas[i][k+1];
                        }
                        canvas[i][3]=0;
                    }
                }
            }
            for (int j = 0; j < 3; j++) {//это столбцы
                    if (canvas[i][j]==canvas[i][j+1]) {
                        canvas[i][j]+=canvas[i][j+1];
                        for (int k = j+1; k < 3; k++) {
                            canvas[i][k] = canvas[i][k+1];
                        }
                        canvas[i][3]=0;
                    }
            }
        }
        return canvas;
    }
}
