package lesson5.using_multithreading;

import java.util.Arrays;

public class MultyThreadArrayCounter {
    /**
     * 1. Написать два метода, которые делают следующее:
     * 1) Создают одномерный длинный массив, например:
     * 2) Заполняют этот массив единицами;
     * 3) Засекают время выполнения: long a = System.currentTimeMillis();
     * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
     * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
     * 5) Проверяется время окончания метода System.currentTimeMillis();
     * 6) Выводится время работы: System.out.println(System.currentTimeMillis() - a);
     *
     * Отличие первого метода от второго: Первый просто бежит по массиву и вычисляет значения.
     * Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
     * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
     */

    private static int SIZE = 10000000;
    private static int HALF = SIZE / 2;
    private static float[] initialArray = new float[SIZE];
    private static float[] firstHalfOfArray = new float[HALF];
    private static float[] secondHalfOfArray = new float[HALF];

    //TODO
    public static String firstCountMethod () {
        float result = 0;
        Arrays.fill(initialArray, 1F);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            initialArray[i] = (float) (initialArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long lastTime = System.currentTimeMillis() - startTime;

        for (float v : initialArray) { result += v; }
        return "Time of one thread operation is: " + lastTime + ", result of operation is: " + result;
    }

    //TODO
    public static String secondCountMethod () {
        float result = 0;
        Arrays.fill(initialArray, 1F);

        long startTime = System.currentTimeMillis();

        System.arraycopy(initialArray, 0, firstHalfOfArray, 0, HALF);
        System.arraycopy(initialArray, HALF, secondHalfOfArray, 0, HALF);

        CounterThread firstThread = new CounterThread(firstHalfOfArray, 0);
        CounterThread secondThread = new CounterThread(secondHalfOfArray, HALF);
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.arraycopy(firstHalfOfArray, 0, initialArray, 0, HALF);
        System.arraycopy(secondHalfOfArray, 0, initialArray, HALF, HALF);

        long lastTime = System.currentTimeMillis() - startTime;

        for (float v : initialArray) { result += v; }
        return "Time of twice thread operation is: " + lastTime + ", result of operation is: " + result;
    }

    public static void main(String[] args) {
        System.out.println(MultyThreadArrayCounter.firstCountMethod());
        System.out.println(MultyThreadArrayCounter.secondCountMethod());
    }
}
