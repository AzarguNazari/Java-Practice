package JavaPractice.Java8.Lamda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 *
 * @author Codex Coffee
 */
public class lamda {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// IntSummaryStatistics is used for the statistics calculations such as
		// finding max, min, sum, count, average
		IntSummaryStatistics statistis = IntStream.of(5, 3, 5, 2, 5, 1, 5, 34,
				53, 2, 3).summaryStatistics();
		statistis.accept(100);
		statistis.combine(IntStream.of(2, 3, 4, 5).summaryStatistics());
		statistis.getAverage();
		statistis.getCount();
		statistis.getMax();
		statistis.getMin();
		statistis.getSum();
		statistis.toString();

		//IntStream is used for playing with streams of int
		IntStream stream = IntStream.range(1, 100);
		stream.allMatch(n -> n % 2 == 0);  // returns true if all numbers are divisble by 2
		stream.anyMatch(n -> n % 2 == 0); // if any number is divisble by 2, returns true
		stream.asDoubleStream();   // converts the Instream to doublestream
		DoubleStream doubleSream = stream.asDoubleStream(); 
		stream.asLongStream(); // to LongStream
		stream.average(); // find the average of all numbers
		stream.boxed();    // returns a stream of integer inside a box
		stream.close();    // close the stream, so the resources are freed
		stream.count();    // returns the count of elements stream has
		stream.filter(num -> num % 3 == 0).forEach(System.out::println);   // only the numbers that are divisble by 3
		stream.unordered().forEach(System.out::println);
		stream.toArray();
		stream.toString();
		stream.sorted();
		stream.skip(1);
		stream.reduce((sum, total) -> sum += total);
		stream.sequential();
		stream.parallel();


	}
}
