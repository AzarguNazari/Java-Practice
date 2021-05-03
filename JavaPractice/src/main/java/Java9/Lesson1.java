package Java9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//interface Util{
//	void doit();
//	default void doSomethingElseToo() {
//		privateOperation();
//		System.out.println("Here is another thing to do ");
//	}
//	private void privateOperation() {
//		System.out.println("Operation Dependencies");
//	}
//}

public class Lesson1 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Util it = () -> System.out.println("Hello World");
//		it.doit();
//		it.doSomethingElseToo();
		
		List<Integer> numbers = Arrays.asList(11,2,42,534,1,23,5,34,5,34,22);
		
		// break the look while the condition is met
//		numbers.stream().takeWhile(num -> num > 10).forEach(System.out::println);
		
		//numbers.stream().dropWhile(num -> num % 2 == 0).forEach(System.out::println);
		
		
		 // Antoher way of crewating list and set
//		 Set<Integer> set = Set.of(1,2,3,4,5);
		
//		List<Integer> list = List.of(1,2,3,4,5);
		
//		IntStream.iterate(0, i -> i < 5, i -> i + 1).forEach(System.out::println);
		
//		IntStream.iterate(i, i -> i + 2).limit(3).forEach(System.out::println);
		
//		Optional<Integer> first numbers.stream().filter(e -> e < 5).findFirst();
		
//		first.ifPresentOrElse(e -> System.out.rintln(e), ()-> System.out.println("Doesn't exist"));
		
		
		
	}

}
