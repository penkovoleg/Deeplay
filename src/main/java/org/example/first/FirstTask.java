package org.example.first;

import java.util.Arrays;
import java.util.Random;

/**
 * Массив Array - массив с которым проиходит вся работа
 * Переменная interim - переменная для хранения промежуточных значений
 * Порядок работы:
 * 1) Методом initialization() создается массив c размером от 10 до 100 и заполняется числами от 0 до 100;
 * 2) Вывод полученного массива на экран printArray();
 * 3) Выполняется сортировка массива методом Arrays.sort(array) для получения массива с сортированными
 * нечетными числами про возрастанию (исходя из условия "сначала по не убыванию нечетные числа");
 * 4) После сортировки нули, если они есть, окажутся первыми и методом
 * searchAndMovingZero() сдвигаем их в конец массива;
 * 5) Остается сдвинуть все остальные числа в конец и отсортировать их в порядке убывания (по условию "прочие числа
 * по не возрастанию");
 * 6) Вывод измененного массива на экран printArray().
 * По итогу получаем массив с структурой: нечетные числа в порядке возрастания, нули,
 * все остальное в порядке убывания.
 */

public class FirstTask {

    private static int[] array;
    private static int interim;

    public static void main(String[] args) {
        initialization();
        printArray("Созданный массив:");
        Arrays.sort(array);
        searchAndMovingZero();
        searchAndMovingOther();
        sortedOther();
        printArray("Полученный массив:");
    }

    private static void initialization() {
        Random random = new Random();
        int min = 10;
        int max = 100;
        array = new int[min + random.nextInt(max - min + 1)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max);
        }
    }

    private static void searchAndMovingZero() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                arrayShift(i);
                searchAndMovingZero();
            } else break;
        }
    }

    private static void searchAndMovingOther() {
        for (int element : array) {
            if (element % 2 != 1 && element != 0) {
                for (int j = 0; j < array.length; j++) {
                    if (array[j] % 2 != 1 && array[j] != 0) {
                        arrayShift(j);
                    }
                }
            }
        }
    }

    private static void arrayShift(final int i) {
        interim = array[i];
        if (array.length - 1 - i >= 0) {
            System.arraycopy(array, i + 1, array, i, array.length - 1 - i);
        }
        array[array.length - 1] = interim;
    }

    private static void sortedOther() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && array[i] % 2 != 1) {
                for (int j = i; j < array.length; j++) {
                    if (array[i] < array[j]) {
                        interim = array[i];
                        array[i] = array[j];
                        array[j] = interim;
                    }
                }
            }
        }
    }

    private static void printArray(final String str) {
        System.out.print(str);
        for (int element : array) {
            System.out.print(" " + element);
        }
        System.out.println();
    }
}

