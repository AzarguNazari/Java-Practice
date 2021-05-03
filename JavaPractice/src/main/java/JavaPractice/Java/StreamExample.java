package JavaPractice.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    
    
    
    public static void main(String[] args) {
        
//        List<String> list = Arrays.asList("first", "second", "third", "forth", "farth");
//        
//        
//        list.stream().filter(x -> x.startsWith("f")).map(String::toUpperCase).sorted().forEach(System.out::println);
//        System.out.println("-------------");
//        Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println);
//        System.out.println("---------------");
//        IntStream.range(10, 20).forEach(System.out::println);
//        System.out.println("-------------");
//        DoubleStream.of(2.3, 4.5, 4.5, 3.4).max().ifPresent(System.out::println);
//        System.out.println("--------------");
//        LongStream.range(200, 210).filter(x -> x % 2 == 0 && x % 3 == 0).max().ifPresent(System.out::println);
//        System.out.println("------------");
//        Stream<String> streams = list.stream();
//        streams.forEach(System.out::println);
//        System.out.println("----------------");
//        
//        Arrays.stream(new int[]{1, 2, 3})
//                .map(x -> 2 * x + 1)
//                .average()
//                .ifPresent(System.out::println);
//        
//        System.out.println("----------------");
//        Stream.of("a1", "a2", "a3")
//                .map(x -> x.substring(1))
//                .mapToInt(Integer::parseInt)
//                .max()
//                .ifPresent(System.out::println);
//        
//        System.out.println("-------------");
//        
//        IntStream.range(1, 4).mapToObj(i -> "a" + i).forEach(System.out::println);
//        System.out.println("---------------");
//        
//        
//        Stream<String> stream = Stream.of("a1", "a2", "a3", "c4").filter(s -> s.startsWith("a"));
//        stream.anyMatch(x -> true);
//        stream.noneMatch(x -> true);
//        
//        Supplier<Stream<String>> streamSupplier = () -> Stream.of("a1", "a2", "a3", "c4").filter(x -> x.startsWith("a"));
//        streamSupplier.get().anyMatch(x -> true);
//        streamSupplier.get().noneMatch(x -> true);
        
//          List<Person> persons = Arrays.asList(new Person("Ahmad", 20),
//                  new Person("Mohammad", 19),
//                  new Person("Kareem", 20),
//                  new Person("Jaweed", 19),
//                  new Person("Shayeeq", 18),
//                  new Person("Navi", 16));
//          
//          List<Person> youners = persons.stream().filter(x -> x.age > 18).collect(Collectors.toList());
//          Map<Integer, List<Person>> personAges = persons.
//                  stream().collect(Collectors.groupingBy(x -> x.age));
//          personAges.forEach((x, y) -> System.out.println(x + " " + y));
//          System.out.println("--------------");
//          
//          Double average = persons.stream().collect(Collectors.averagingInt(x -> x.age));
//          System.out.println(average);
//          System.out.println("------------------");
//          
//          
//          IntSummaryStatistics statics = persons.stream().collect(Collectors.summarizingInt(x -> x.age));
//          System.out.println(statics);
//          System.out.println("-----------------");
//
//          String phrase = persons
//                        .stream()
//                        .filter(p -> p.age >= 18)
//                        .map(p -> p.name)
//                        .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
//
//                    System.out.println(phrase);
     
        Fucking f = () -> {
            System.out.println("This is the fucking fucntion mother fucker");
        };
        
        f.work();
        
    }
    
    public static void printList(ArrayList<String> list){
         list.forEach(System.out::println);
    }
    
    public static double findAverage(ArrayList<Number> numbers){
        return numbers.stream().mapToInt(x -> (int)x).summaryStatistics().getSum() / numbers.size();
    }
    
    interface Fucking{
        void work();
    }
    
}

class Person{
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString(){
        return name;
    }
}