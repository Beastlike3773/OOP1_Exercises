package topic08.lambdas.sorting;

import java.util.Arrays;

public class SortingExamples {
  /**
   * Main method.
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    String[] words = {"hi", "hello", "hola", "bye", "goodbye", "adios"};

    Integer[] ints = {2, 3, 1545, 5345, 17, 533, 733, 32345, 56};

    Arrays.sort(ints, (i1, i2) -> i1 - i2);

    System.out.println("Int Array ascending: " + Arrays.asList(ints));

    Arrays.sort(ints, (i1, i2) -> i2 - i1);

    System.out.println("Int Array descending: " + Arrays.asList(ints));

    Arrays.sort(ints, (i1, i2) -> i1.toString().charAt(0) - i2.toString().charAt(0));

    System.out.println("Int Array first digit asc: " + Arrays.asList(ints));

    Arrays.sort(ints, (i1, i2) -> i2.toString().charAt(0) - i1.toString().charAt(0));
    System.out.println("Int Array first digit desc: " + Arrays.asList(ints));


    System.out.println("Original array: " + Arrays.asList(words));

    // sorting by length ascending ...
    Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());

    System.out.println("Sorted by length ascending: " + Arrays.asList(words));


    Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
    System.out.println("Sorted by length descending: " + Arrays.asList(words));

  }
}
