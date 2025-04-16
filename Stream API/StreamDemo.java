import java.util.*;
import java.util.stream.Stream;
import java.util.function.Predicate;



public class StreamDemo{

	public static void main(String args[]){
		List<Integer> nums = Arrays.asList(4, 5, 6, 7, 8, 9, 1);
		
		//Stream<Integer> data = nums.stream();
		
		//long count = data.count();
		//System.out.println(count);

		//Stream<Integer> sortedData = data.sorted();


		//data.forEach(n -> System.out.println(n));
		//data.forEach(n -> System.out.println(n));

		//sortedData.forEach(n -> System.out.println(n));

		//Stream<Integer> mappedData = data.map(n -> n*2);

		//mappedData.forEach(n -> System.out.println(n));		


		//nums.stream().sorted().map(n->n*2).forEach(n -> System.out.println(n));
		nums.stream()
			.filter( n -> n%2 == 1) 
			.sorted()
			.map(n -> n*2)
			.forEach( n -> System.out.println(n) );


		Predicate<Integer> predi = new Predicate<Integer>(){
			@Override
			public boolean test(Integer n){
				if(n%2 ==1){
					return true;
				}
				else{
					return false;
				}
			}
		};

		
		nums.stream()
			.filter(predi)
			.sorted()
			.map(n->n*2)
			.forEach(n -> System.out.println(n));
	}
}

/*

- Once used stream, it cannot be reused again.



*/