import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

public class CollectorsPractice {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Alex", "Bryan", "Chelsea", "Abraham");

        // Convert Stream to List
        List<String> collectedNames = names.stream()
            .collect(Collectors.toList());  

        System.out.println(collectedNames);

        // Convert Stream to set
        Set<String> nameSet = names.stream()
            .collect(Collectors.toSet());

        System.out.println(nameSet);

        //Convert Stream to map
        Map<String, Integer> nameLength = names.stream()
            .collect(
                Collectors.toMap(n->n, n->n.length())
            );

        System.out.println(nameLength);

        //Grouping Elements
        Map<Character, List<String>> groupByFirstLetter = names.stream()
            .collect(
                Collectors.groupingBy(s->s.charAt(0))
            );
        System.out.println(groupByFirstLetter);

        //Summarizing Data
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

        IntSummaryStatistics stats = numbers.stream()
            .collect(
                Collectors.summarizingInt(n->n)
            );
        System.out.println(stats);
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
        

        


    }
}
