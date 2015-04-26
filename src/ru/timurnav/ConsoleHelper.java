package ru.timurnav;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Тимур Мухитдинов on 22.04.2015.
 */
public class ConsoleHelper {
    static void paintCanvas(int[][] canvas){
        /*
         ______ ______ ______ ______
        |      |      |      |      |
        |  2   |  16  | 128  | 1024 |
        |______|______|______|______|
    */
        int rows = canvas.length;
        int columns = canvas[0].length;
        System.out.print(" ______ ______ ______ ");
        for (int i = 3; i < columns; i++) {
            System.out.print("______ ");
        }
        System.out.print("\n|      |      |      |");
        for (int i = 3; i < columns; i++) {
            System.out.print("      |");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j==0) System.out.print("|");
                if (canvas[i][j]==0) System.out.print("      |");
                else {
                    if (canvas[i][j]<10) System.out.print("   " + canvas[i][j] + "  |");
                    else if (canvas[i][j]<100) System.out.print("  " + canvas[i][j] + "  |");
                    else if (canvas[i][j]<1000) System.out.print("  " + canvas[i][j] + " |");
                    else if (canvas[i][j]<10000) System.out.print(" " + canvas[i][j] + " |");
                }
            }
            System.out.print("\n|______|______|______|");
            for (int j = 3; j < columns; j++) {
                System.out.print("______|");
            }
            System.out.println();
            if (i!=rows-1) {
                System.out.print("|      |      |      |");
                for (int j = 3; j < columns; j++) {
                    System.out.print("      |");
                }
                System.out.println();
            }
        }
    }
}
