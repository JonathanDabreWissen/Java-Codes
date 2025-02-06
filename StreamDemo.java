import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;


public class StreamDemo {
    public static void main(String[] args) {
        List <Integer> list = new ArrayList<Integer>();

        list.add(22);
        list.add(44);
        list.add(32);
        list.add(35);
        list.add(29);
        list.add(12);
        list.add(39);
        list.add(94);
        list.add(47);
        list.add(66);
        list.add(58);
        
        System.out.println(list);

        Predicate<Integer> p1 = (x)-> x%2==0;

        Stream <Integer> s = list.stream();
        Stream <Integer> en = s.filter(p1);

        List<Integer> elist = en.collect(Collectors.toList());

        System.out.println(elist);

        List<Integer> olist = list.stream().filter(p1.negate()).collect(Collectors.toList());
        System.out.println(olist);

        List<Integer> dlist = list.stream().map(x->x+x).collect(Collectors.toList());
        System.out.println(dlist);

        List<Integer> slist = list.stream().sorted().limit(5).skip(1).collect(Collectors.toList());
        System.out.println(slist);


        Random random = new Random();
        random.ints().map(x->Math.abs(x)).limit(5).forEach((System.out::println));

        IntStream is = IntStream.rangeClosed((1), 10);
        is.forEach(System.out::println);

        OptionalInt result1 = IntStream.range(1, 6).reduce((a, b)->a*b);
        System.out.println(result1.getAsInt());

        int res1 = Stream.of(1, 2, 3).reduce(10, (a,b)->a+b, (a,b)->a+b);
        System.out.println(res1);


        int res2 = Arrays.asList(1, 2, 3).parallelStream().reduce(10, (a,b)->a+b, (a,b)->a+b);
        System.out.println(res2);



    }   
}
