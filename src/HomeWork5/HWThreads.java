package HomeWork5;

import java.util.Arrays;

public class HWThreads {
    public static void main(String[] args) {
        arrayCalculate();
        arrayCalculateThreads(15);
    }

    public static void arrayCalculate() {
        final int size = 1000000;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void arrayCalculateThreads(int threads) {
        final int size = 1000000;
        final int h = size / threads;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < threads; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    float[] a1 = new float[h];
                    System.arraycopy(arr, h * finalI, a1, 0, h);
                    for (int j = 0; j < h; j++) {
                        a1[j] = (float) (a1[j] * Math.sin(0.2f + (h * finalI + j) / 5) * Math.cos(0.2f + (h * finalI + j) / 5) * Math.cos(0.4f + (h * finalI + j) / 2));
                    }
                    System.arraycopy(a1, 0, arr, h * finalI, h);
                }
            }).start();
        }
        System.out.println(System.currentTimeMillis() - a);

    }
}
