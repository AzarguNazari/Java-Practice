package ToolsQA;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java8Examples {

    @Test
    public void defaultFunctionTest() {

        interface Formula {
            double calculate(int a);

            default double sqrt(int a) {
                return Math.sqrt(a);
            }
        }

        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        assertEquals(100, formula.calculate(100));     // 100.0
        assertEquals(4, formula.sqrt(16));           // 4.0
    }

    @Test
    public void sortingExample() {

        String[] names = {"peter", "anna", "mike", "xenia"};
        String[] sortedNames = {"anna", "mike", "peter", "xenia"};

        List<String> nameList1 = List.of(names);

        assertArrayEquals(sortedNames, nameList1.stream().sorted().toArray());        // #1 way to sort

        List<String> nameList2 = Arrays.asList(names);
        Collections.sort(nameList2);
        assertArrayEquals(sortedNames, nameList2.toArray());
    }

    @Test
    public void functionAccess() {

        // Example 1
        @FunctionalInterface
        interface Converter<F, T> {
            T convert(F from);
        }

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        var converted = converter.convert("123");
        assertEquals(converted, 123);    // 123

        record Person(String firstname, String lastname) {
        }
        // Example 2
        interface PersonFactory<P extends Person> {
            P create(String firstName, String lastName);
        }

        class Something {
            String startsWith(String s) {
                return String.valueOf(s.charAt(0));
            }
        }
        Something something = new Something();
        Converter<String, String> startsWithConverter = something::startsWith;
        var convertedString = startsWithConverter.convert("Java");
        assertEquals("J", convertedString);


        // Example 3
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        assertEquals("Peter", person.firstname);
        assertEquals("Parker", person.lastname);

    }

    @Test
    public void predicateExamples() {

        Predicate<String> predicate = (s) -> s.length() > 0;

        assertEquals(true, predicate.test("foo"));              // true
        assertEquals(false, predicate.negate().test("foo"));     // false

        Predicate<String> containsApredicate = predicate.and(s -> s.contains("A"));
        assertEquals(false, containsApredicate.test("foo"));              // true

        class Person {
            String firstName;
            String lastname;

            Person() {
                firstName = "john";
                lastname = "ibrahim";
            }
        }
        Supplier<Person> personSupplier = Person::new;
        assertEquals(personSupplier.get().firstName, "john");

        AtomicInteger counter = new AtomicInteger();
        Consumer<Person> greeter = (p) -> counter.getAndIncrement();
        greeter.accept(new Person());
        assertEquals(counter.get(), 1);


        Comparator<Person> comparator = Comparator.comparing(p -> p.firstName);

        Person p1 = new Person();
        Person p2 = new Person();

        assertEquals(0, comparator.compare(p1, p2));             // > 0

        p2.firstName = "hakim";
        p2.lastname = "nazari";
        assertEquals(-2, comparator.reversed().compare(p1, p2));  // < 0

    }

    @Test
    public void optionUsage() {

        Optional<String> optional = Optional.of("bam");

        assertEquals(true, optional.isPresent());           // true
        assertEquals("bam", optional.get());                 // "bam"
        assertEquals("bam", optional.orElse("fallback"));    // "bam"
        assertEquals(false, optional.isEmpty());
        assertEquals(true, optional.isPresent());
    }

    @Test
    public void functionalStreamingexample() {

        // Example 1
        List<String> stringCollection = List.of("ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc", "bbb2", "ddd1");
        List<String> as = stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .toList();

        assertEquals(as.size(), 2);


        // Example 2
        List<String> sortedAs = stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .toList();
        assertEquals(sortedAs.size(), 2);
        assertEquals(sortedAs.get(0), "aaa1");
        assertEquals(sortedAs.get(1), "aaa2");


        // Example 3
        List<String> sortedDesAs = stringCollection
                .stream()
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .toList();
        assertEquals(8, sortedDesAs.size());
        assertEquals("DDD2", sortedDesAs.get(0));
        assertEquals("DDD1", sortedDesAs.get(1));


        // Example 3
        assertEquals(stringCollection.stream().anyMatch((s) -> s.startsWith("a")), true);
        assertEquals(stringCollection.stream().allMatch((s) -> s.startsWith("a")), false);
        assertEquals(stringCollection.stream().noneMatch((s) -> s.startsWith("z")), true);
        assertEquals(stringCollection.stream().filter((s) -> s.startsWith("b")).count(), 3);
        assertEquals(stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2).get(), "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2");


    }

    @Test
    public void mapExample() {

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));
        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);             // val33

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);     // false

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);    // true

        map.computeIfAbsent(3, num -> "bam");
        map.get(3);             // val33
        map.getOrDefault(42, "not found");  // not found
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9concat
    }

    @Test
    public void dateAPI() {

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        assertEquals(System.currentTimeMillis(), millis);

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date

        System.out.println(ZoneId.getAvailableZoneIds());
// prints all available timezone ids

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

// ZoneRules[currentStandardOffset=+01:00]
// ZoneRules[currentStandardOffset=-03:00]



        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2));  // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);       // -3
        System.out.println(minutesBetween);     // -239



        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);       // 23:59:59

        DateTimeFormatter germanFormatter = DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);   // 13:37


        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);    // FRIDAY


        DateTimeFormatter germanFormatter2 =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter2);
        System.out.println(xmas);   // 2014-12-24




        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek2 = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek2);      // WEDNESDAY

        Month month = sylvester.getMonth();
        System.out.println(month);          // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);    // 1439


        Instant instant2 = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Date legacyDate2 = Date.from(instant2);
        System.out.println(legacyDate2);     // Wed Dec 31 23:59:59 CET 2014


        DateTimeFormatter formatter =
                DateTimeFormatter
                        .ofPattern("MMM dd, yyyy - HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        String string = formatter.format(parsed);
        System.out.println(string);     // Nov 03, 2014 - 07:13

    }

}


