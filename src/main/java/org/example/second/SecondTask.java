package org.example.second;

import java.util.Arrays;
import java.util.Random;

/**
 * Массив array - массив с простыми числами
 * Массив arrayCounterRepetitions - массив для хранения количества повторений числа массива array.
 * Порядок работы:
 * 1) Методом initialization() создается массив array c размером от 10 до 100 и заполняется числами от 0 до 100 и
 * массив arrayCounterRepetitions с размером равным основному, но заполненный 1,
 * так как любое число будет встречаться хотя бы 1 раз;
 * 2) Вывод основного массива на экран printArray(array);
 * 3) Выполняется сортировка массива методом Arrays.sort(array) для получения отсортированного массива с по порядку
 * идущими повторяющимися числами (пример: 1, 1, 2, 6, 6, 6, 6, 7, 8);
 * 4) Вывод сортированного массива на экран printArray(array) для удобства;
 * 5) Методом searchDuplicateNumbers() находим дубликаты и заносим в новый массив их количество.
 * Получаем, по примеру из пункта 3: 2, 1, 1, 4, 3, 2, 1, 1, 1, где цифра 4 означает, что элемент с индексом 3
 * в основном массиве встречается 4 раза;
 * 6) Методом printArray(arrayCounterRepetitions) выводим массив на экран для удобства;
 * 7) Перебираем данный массив методом searchAndPrintMaxDuplicate() для нахождения максимальных повторений
 * и выводим их в консоль. Максимальным повторением считается число, которое больше одного повторения и больше данного
 * числа в массиве нет, если повторений несколько и числа разные, то тоже выводим их.
 */

public class SecondTask {

    private static int[] array;
    private static int[] arrayCounterRepetitions;

    public static void main(String[] args) {
        initialization();
        printArray(array, "Созданный массив:");
        Arrays.sort(array);
        printArray(array, "После сортировки:");
        searchDuplicateNumbers();
        printArray(arrayCounterRepetitions, "Количество повторений каждого числа:");
        searchAndPrintMaxDuplicate();
    }

    private static void initialization() {
        Random random = new Random();
        int min = 10;
        int max = 100;
        array = new int[min + random.nextInt(max - min + 1)];
        arrayCounterRepetitions = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max);
            arrayCounterRepetitions[i] = 1;
        }
    }

    private static void searchDuplicateNumbers() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    arrayCounterRepetitions[i]++;
                }
            }
        }
    }

    private static void searchAndPrintMaxDuplicate() {
        int max = 1;
        int indexMaxValue = 0;
        for (int i = 0; i < arrayCounterRepetitions.length; i++) {
            for (int j = 0; j < arrayCounterRepetitions.length; j++) {
                if (arrayCounterRepetitions[j] > max) {
                    max = arrayCounterRepetitions[j];
                    indexMaxValue = j;
                }
            }
            if (arrayCounterRepetitions[i] == max && i != indexMaxValue) {
                indexMaxValue = i;
            }
            if (max > 1 && i == indexMaxValue) {
                System.out.println("Число: " + array[indexMaxValue] + " Количество повторений: " + max);
            }
        }
    }

    private static void printArray(final int[] array, final String str) {
        System.out.print(str);
        for (int element : array) {
            System.out.print(" " + element);
        }
        System.out.println();
    }
}