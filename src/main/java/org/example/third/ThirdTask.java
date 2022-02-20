package org.example.third;

import java.util.Random;

/**
 * Массив firstPlayer используется для хранения стратегии первого игрока
 * Массив secondPlayer используется для хранения стратегии второго игрока
 * Массив throwsPlayers используется для хранения бросков игроков
 * Порядок работы:
 * 1) В методе initialization() создаем масивы firstPlayer, secondPlayer размером 3 и заполняем числами от 1 до 6.
 * Создаем массив throwsPlayers размером от 100 до 1000 (можно любой размер) и заполняем числами от 1 до 6;
 * 2) Выводим стратегии игроков и броски в консоль методом printArray();
 * 3) Методом searchWinningStrategies() находим выйгрышные ситуации для игроков;
 * 4) Методом determinationOfTheWinner() определяем победителя или ничью и выводим в консоль.
 */

public class ThirdTask {

    private static int[] firstPlayer;
    private static int[] secondPlayer;
    private static int[] throwsPlayers;

    public static void main(String[] args) {
        initialization();
        printArray(firstPlayer, "Стратегия первого игрока:");
        printArray(secondPlayer, "Стратегия второго игрока:");
        printArray(throwsPlayers, "Броски игроков:");
        determinationOfTheWinner();
    }

    private static void initialization() {
        Random random = new Random();
        firstPlayer = new int[3];
        secondPlayer = new int[3];
        throwsPlayers = new int[100 + random.nextInt(901)];
        for (int i = 0; i < 3; i++) {
            firstPlayer[i] = 1 + random.nextInt(6);
            secondPlayer[i] = 1 + random.nextInt(6);
        }
        for (int i = 0; i < throwsPlayers.length; i++) {
            throwsPlayers[i] = 1 + random.nextInt(6);
        }
    }

    private static void determinationOfTheWinner() {
        int numberOfTheFirst = searchWinningStrategies(firstPlayer);
        int numberOfTheSecond = searchWinningStrategies(secondPlayer);
        String str = "Счет " + numberOfTheFirst + ":" + numberOfTheSecond;
        if (numberOfTheFirst > numberOfTheSecond) {
            System.out.println(str + " - Победил первый игрок!");
        } else if (numberOfTheFirst < numberOfTheSecond) {
            System.out.println(str + " - Победил второй игрок!");
        } else {
            System.out.println(str + " - Ничья!");
        }
    }

    private static int searchWinningStrategies(final int[] array) {
        int count = 0;
        for (int i = 0; i < throwsPlayers.length - 2; i++) {
            if (throwsPlayers[i] == array[0]
                    && throwsPlayers[i + 1] == array[1]
                    && throwsPlayers[i + 2] == array[2]) {
                count++;
                i += 2;
            }
        }
        return count;
    }

    private static void printArray(final int[] array, final String str) {
        System.out.print(str);
        for (int element : array) {
            System.out.print(" " + element);
        }
        System.out.println();
    }
}
