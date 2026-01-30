package collectors;

import java.util.*;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {

        String paragraph =
            "java stream api is powerful and java stream is easy";

        Map<String, Integer> wordCount =
            Arrays.stream(paragraph.split("\\s+"))
                  .collect(Collectors.toMap(
                      word -> word,        // key
                      word -> 1,           // value
                      Integer::sum         // merge if duplicate key
                  ));

        wordCount.forEach((word, count) ->
            System.out.println(word + " → " + count)
        );
    }
}
