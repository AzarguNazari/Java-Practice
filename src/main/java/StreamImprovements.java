import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamImprovements {

    public static void main(String[] args) throws Exception {

        // takeWhile
        // dropWhile
        // ofNullable
        // iterate

        // better use for ordered streams


        // 1. takewhile

        Stream<Shape> colors = List.of(new Shape("box","green"),
                                       new Shape("circle", "green"),
                                       new Shape("Rectangular", "blue"),
                                       new Shape("circle", "blue"))
                                    .stream();

//        colors.takeWhile(color -> color.color.equals("green")).forEach(System.out::println);


//        colors.dropWhile(color -> color.color.equals("blue")).forEach(System.out::println);

        // get the conflict of git
//        Files.lines(Paths.get("resources/index.html"))
//                .dropWhile(l -> !l.contains("<<<<<<<<"))
//                .skip(1)
//                .takeWhile(l -> !l.contains(">>>>>>>>>"))
//                .forEach(System.out::println);

//        List<Integer> ints = Stream.of(1,,2,3).map(n -> n + 1).collect(Collectors.toList());

//        Map<Integer, List<Integer>> ints = Stream.of(1,2,3,3).collect(Collectors.groupingBy(i -> i % 2, Collectors.toList()));
//        ints.forEach((key, value) -> System.out.println(key + " => " + value));

        Optional<String> full = Optional.of("book");
        full.ifPresentOrElse(System.out::println, () -> System.out.println("Nothing here!"));

        Optional.empty();
        Optional.of("string").ifPresent(System.out::println);
        Optional.of("anotherstring").or(null);
        Optional.ofNullable(new String()).ifPresent(System.out::println);

        // new collectors in stream


    }

}

class Book {
    public final String title;
    public final Set<String> authors;
    public final double price;

    public Book(String title, Set<String> authors, double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", price=" + price +
                '}';
    }
}

class Shape {
    public String name;
    public String color;

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
