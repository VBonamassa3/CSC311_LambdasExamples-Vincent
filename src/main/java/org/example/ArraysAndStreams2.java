package org.example;

// Fig. 17.12: ArraysAndStreams2.java
// Demonstrating lambdas and streams with an array of Strings.
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
   public static void main(String[] args) {
      String[] strings = 
         {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};
      System.out.println();

      // display original strings
      System.out.printf("Original strings: %s%n", Arrays.asList(strings));
      System.out.println();

      // strings in uppercase
      System.out.printf("strings in uppercase: %s%n",
         Arrays.stream(strings)             
               .map(String::toUpperCase)   
               .collect(Collectors.toList()));
      System.out.println();

      // strings less than "n" (case insensitive) sorted ascending
      System.out.printf("strings less than n sorted ascending: %s%n",
         Arrays.stream(strings)                            
               .filter(s -> s.compareToIgnoreCase("n") < 0)
               .sorted(String.CASE_INSENSITIVE_ORDER)
               .collect(Collectors.toList()));
      System.out.println();

      // strings less than "n" (case insensitive) sorted descending
      System.out.printf("strings less than n sorted descending: %s%n",
         Arrays.stream(strings)
               .filter(s -> s.compareToIgnoreCase("n") < 0)
               .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
               .collect(Collectors.toList()));
      System.out.println();

      //stream to filter strings that start with a vowel
      System.out.printf("strings starting with a vowel descending: %s%n",
              Arrays.stream(strings)
                      .filter(s -> s.matches("[aeiou].*"))
                      .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                      .collect(Collectors.toList()));
      System.out.println();

      //stream to concatenate (connect) all the strings into a single string
      System.out.printf("concatenated string: %s%n",
              Arrays.stream(strings)
                      .collect(Collectors.joining(", ")));
      System.out.println();

      //stream to count the number of strings that contain more than 5 characters
      System.out.printf("number of strings with more than 5 characters: %d%n",
              Arrays.stream(strings)
                      .filter(s -> s.length() > 5)
                      .count());
      System.out.println();
   }
}