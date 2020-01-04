package lesson5.using_multithreading;

public class CounterThread extends Thread {
    private int shift;
    private float[] inputArray;

    public CounterThread (float[] inputArray, int shift) {
        this.inputArray = inputArray;
        this.shift = shift;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = (float) (inputArray[i] * Math.sin(0.2f + (i + shift) / 5) * Math.cos(0.2f + (i + shift) / 5) * Math.cos(0.4f + (i + shift) / 2));
        }
    }
}