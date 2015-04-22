package ru.timurnav;

/**
 * Created by Тимур Мухитдинов on 22.04.2015.
 */
public class ConsoleHelper {
    static void paintCanvas(int[][] canvas){
        /*
         ____ ____ ____ ____
        |    |    |    |    |
        |  2 | 16 | 128|1024|
        |____|____|____|____|

    */
        System.out.println(" ______ ______ ______ ______ ");
        System.out.println("|      |      |      |      |");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j==0) System.out.print("|");
                if (canvas[i][j]==0) System.out.print("      |");
                else {
                    if (canvas[i][j]<10) System.out.print("   " + canvas[i][j] + "  |");
                    else if (canvas[i][j]<100) System.out.print("  " + canvas[i][j] + "  |");
                    else if (canvas[i][j]<1000) System.out.print("  " + canvas[i][j] + " |");
                    else if (canvas[i][j]<10000) System.out.print(" " + canvas[i][j] + " |");
                }
            }
            System.out.println("\n|______|______|______|______|");
            if (i!=3)
                System.out.println("|      |      |      |      |");
        }
    }
}
