package org.example;

// Fig. 17.24: RandomIntStream.java
// Rolling a die 60,000,000 times with streams
import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RandomIntStream {
   public static void main(String[] args) {
      SecureRandom random = new SecureRandom();

      // roll a die 60,000,000 times and summarize the results
      System.out.printf("%-6s%s%n", "Face", "Frequency");
      random.ints(60_000_000, 1, 7)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(),
               Collectors.counting()))
            .forEach((face, frequency) -> 
               System.out.printf("%-6d%d%n", face, frequency));
   } 
}