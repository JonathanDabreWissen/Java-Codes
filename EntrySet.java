import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntrySet {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(11, "Ramesh");
        map.put(12, "Suresh");
        map.put(13, "Dinesh");
        map.put(14, "Ganesh");
        map.put(15, "Mahesh");

        map.entrySet().stream().map(Map.Entry::getKey).forEach(System.out::println);
        map.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);
       
        System.out.println(map.entrySet());

    }
}
