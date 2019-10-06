package lesson5;

import java.util.Arrays;

public class ArrayCounter {
    static int size = 10000000;
    static int half = size / 2;
    static float[] initialArray = new float[size];
    static float[] firstHalfOfArray = new float[half];
    static float[] secondHalfOfArray = new float[half];

    private static void firstCountMethod () {
        float result = 0;
        Arrays.fill(initialArray, 1F);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            initialArray[i] = (float) (initialArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long lastTime = System.currentTimeMillis() - startTime;

        for (float v : initialArray) { result += v; }
        System.out.println(lastTime + " " + result);

    }

    private static void secondCountMethod () {
        float result = 0;
        Arrays.fill(initialArray, 1F);

        long startTime = System.currentTimeMillis();

        System.arraycopy(initialArray, 0, firstHalfOfArray, 0, half);
        System.arraycopy(initialArray, half, secondHalfOfArray, 0, half);

        FirstThread firstThread = new FirstThread();
        SecondThread secondThread = new SecondThread();
        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
        } catch (InterruptedException e) {
            System.out.println("FirstThread interrupted");
        }
        try {
            secondThread.join();
        } catch (InterruptedException e) {
            System.out.println("SecondThread interrupted");
        }

        System.arraycopy(firstHalfOfArray, 0, initialArray, 0, half);
        System.arraycopy(secondHalfOfArray, 0, initialArray, half, half);

        long lastTime = System.currentTimeMillis() - startTime;

        for (float v : initialArray) { result += v; }
        System.out.println(lastTime + " " + result);
    }

    private static class FirstThread extends Thread {
        public void run() {
            for (int i = 0; i < firstHalfOfArray.length; i++) {
                firstHalfOfArray[i] = (float) (firstHalfOfArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }

    private static class SecondThread extends Thread {
        public void run() {
            for (int i = 0; i < secondHalfOfArray.length; i++) {
                secondHalfOfArray[i] = (float) (secondHalfOfArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }

    public static void main(String[] args) {
        //Мне кажется методы как то неверно реализованы, чтобы в этом убедиться, я посчитал сумму членов полученного массива
        //после выполнения первого метода и второго метода, получил такие результаты в консоли
        //1673 -6.4977884
        //3528 0.95204055
        //В чем причина этого?
        secondCountMethod();
        firstCountMethod();
    }

//Это общий метод обработки данных, когда на вход подается массив
//            countArray(initialArray, 0, firstHalfOfArray, 0, half);
//            countArray(initialArray, half, secondHalfOfArray, 0, half);
/*    private static void countArray(float[] initialArray, int initialStartPoint, float[] halfOfArray, int halfStartPoint, int length) {
        System.arraycopy(initialArray, initialStartPoint, halfOfArray, halfStartPoint, length);
        for (int i = 0; i < halfOfArray.length; i++) {
            halfOfArray[i] = (float) (halfOfArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(halfOfArray, halfStartPoint, initialArray, initialStartPoint, length);
    }*/
}