package topic06.shuffle;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] before = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] after = shuffleArray(before);

        for(int i = 0; i < before.length; i++){
            System.out.println("Before: " + before[i] + ", After: " + after[i]);
        }
    }

    public static int[] shuffleArray(int[] array) {
        int[] tempArray = new int[array.length];
        Arrays.fill(tempArray, Integer.MIN_VALUE);

        Random rand = new Random();
        boolean valueChanged = false;

        for (int i = 0; i < array.length; i++) {
            while (!valueChanged) {
                int randInt = rand.nextInt(array.length);
                if (tempArray[randInt] == Integer.MIN_VALUE) {
                    tempArray[randInt] = array[i];
                    valueChanged = true;
                }
            }

            valueChanged = false;
        }

        return tempArray;
    }
}

