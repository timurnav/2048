package ru.timurnav;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Тимур Мухитдинов on 20.04.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * создаем и запускаем наблюдателя, который будет отслеживать нажатия клавиш
         */
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        int column;
        int row;
        while (true){
            System.out.println("Enter the number of columns.");
            while (!keyboardObserver.hasKeyEvents()) {
                //do nothing
            }
            KeyEvent event = keyboardObserver.getEventFromTop();
            column = event.getKeyCode();
            if (column>98 && column<102 ||
                    column>50 && column<54) break;
            System.out.println("It should be 3, 4 or 5");
        }
        while (true){
            System.out.println("Enter the number of rows.");
            while (!keyboardObserver.hasKeyEvents()) {
                //do nothing
            }
            KeyEvent event = keyboardObserver.getEventFromTop();
            row = event.getKeyCode();
            if (row>98 && row<102 ||
                    row>50 && row<54) break;
            System.out.println("It should be 3, 4 or 5");
        }
        /**
         * создаем новый холст(читай игровое поле), сейчас он пуст
         */
        int [][] canvas = GameLogic.createNewCanvas(
                (row-96)>0 ? row-96 : row-48,
                (column-96)>0 ? column-96 : column-48);
        /**
         * бесконечный цикл содержит всю логику игры
         * с выходом из этого цикла игра заканчивается
         * создадим переменную направления для расширения ее области видимости
         */
        Direction d;
        while (true) {
            /**
             * отрисовываем холст и проверяем есть ли еще ходы
             */
            ConsoleHelper.paintCanvas(canvas);
            if (GameLogic.isGameOver(canvas)) {
                System.out.println("Game over");
                break;
            }
            int[][] tmpArray = GameLogic.copy2DArray(canvas);
            do{
                d = null;
                /**
                 * цикл проверки кнопки на соответствие направлению
                 */
                do{
                    while (!keyboardObserver.hasKeyEvents()) {
                        //do nothing
                    }
                    KeyEvent event = keyboardObserver.getEventFromTop();
                    /**
                     * получаем клавишу от наблюдателя
                     */
                    if (event.getKeyCode() == KeyEvent.VK_LEFT)
                        d = Direction.LEFT;
                    else if (event.getKeyCode() == KeyEvent.VK_UP)
                        d = Direction.UP;
                    else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                        d = Direction.DOWN;
                    else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                        d = Direction.RIGHT;
                } while (d == null);
                /**
                 * получив направление, двигаем
                 * проверяем на изменения исходный массив
                 * если они есть, то выходим из цикла
                 */
                Moving.move(d, canvas);
            } while (!GameLogic.isCanged(tmpArray, canvas));
            /**
             * раз мы сдвинули, значит есть минимум одно свободное место
             * получаем новую цифру и возвращаемся к началу бесконечного цикла
             */
            GameLogic.randomSquare(d, canvas);

        }
    }
}
