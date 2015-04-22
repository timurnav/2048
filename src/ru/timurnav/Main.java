package ru.timurnav;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Тимур Мухитдинов on 20.04.2015.
 */
public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public static void main(String[] args) throws IOException {
        /**
         * создаем и запускаем наблюдателя, который будет отслеживать нажатия клавиш
         */
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();
        /**
         * задаем начальное направление вверх, по сути это означает, что
         * мы создаем цифру на нижней грани квадрата
         */
        Direction d = Direction.UP;

        /**
         * создаем новый холст(читай игровое поле), сейчас он пуст
         */
        int [][] canvas = GameLogic.createNewCanvas();

        while (true){
            try {
                /**
                 * пробуем получить новую цифру на холсте
                 */
                GameLogic.randomSquare(d, canvas);
            } catch (GameOverException e) {
                /**
                 * если на холсте нет свободных ячеек, метод бросает исключение,
                 * которое здесь мы и отлавливаем
                 */
                System.out.println("Game over");
                break;
            }
            /**
             * после получения новой цифры на холсте,
             * отрисовываем его
             */
            ConsoleHelper.paintCanvas(canvas);
            /**
             * получаем клон массива, чтобы потом сравнить
             * был ли корректно выполнен один из методов move*()
             */
            int [][] tempClone = GameLogic.copy2DArray(canvas);
            do{
                while (!keyboardObserver.hasKeyEvents()){}
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
                /**
                 * в зависимости от клавиши, получаем направление
                 * и двигаем...
                 */
                Moving.move(d, canvas);
                /**
                 * проверяем изменения, если их нет, то снова ждем клавишу
                 */
            }while (!GameLogic.isCanged(tempClone, canvas));
            /**
             * возвращаемся на старт бесконечного цикла
             */
        }
    }
}
