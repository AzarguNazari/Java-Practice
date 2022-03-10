





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author codex
 */
public class lamda {
    public static void main(String[] args) {
        
        //System.out.println(IntStream.range(2, 20).sum());
        //IntStream.range(12, 20).skip(2).skip(2).forEach(x -> System.out.println(x));
        
        //Stream.of("Baram", "Jamshid", "Kamal", "Ahmad").sorted().findFirst().ifPresent(System.out::println);
        
        //String[] names = {"Baram", "Jamshid", "Kamal", "Ahmad", "Alim"};
        //Arrays.stream(names).filter(s -> s.startsWith("A")).sorted().forEach(System.out::println);
        
//        Arrays.stream(new int[]{5,123,5,34,523,5,2})
//                .map(x -> x * x)
//                .average()
//                .ifPresent(System.out::println);

//        List<String> names = Arrays.asList("jamshid", "karim", "hakim", "nabi");
//        names.stream()
//                .map(String::toUpperCase)
//                .filter(x -> x.startsWith("K"))
//                .forEach(System.out::println);
        
//        Stream<String> band = Files.lines(Paths.get("azargul.txt"));
//        band.sorted().filter(x -> x.length() > 5).forEach(System.out::println);
//        band.close();

//          List<String> band = Files.lines(Paths.get("azargul.txt"));
//          band.filter(x -> x.contains("a")).collect(Collectors.toList());
//          band.forEach(x -> System.out.println(x));
        
//            Stream<String> lines = Files.lines(Paths.get("azargul.txt"));
//            int count = (int) lines.map(x -> x.split(",")).filter(x -> x.length > 3).count();
//            System.out.println(count);
//            lines.close();
            
            
//            Stream<String> lines = Files.lines(Paths.get("azargul.txt"));
//            Map<String, String> map = new HashMap<>();
//            map = lines.map(x -> x.split(",")).filter(x -> x.length > 3).collect(Collectors.toMap(x -> x[0], x -> x[1]));
//            lines.close();
//            
//            for(String line : map.keySet()){
//                System.out.println(line);
//            }

//            double total = Stream.of(2.5, 3.5, 4.5).reduce(0.0, (Double a, Double b) -> a + b);
//            System.out.println("Total is " + total);
//
//            IntSummaryStatistics statistis = IntStream.of(5,3,5,2,5,1,5,34,53,2,3).summaryStatistics();
//            System.out.println("Max is : " + statistis.getMax());
//            System.out.println("Min is : " + statistis.getMin());
//            System.out.println("Sum is : " + statistis.getSum());
//            System.out.println("Total Count is : " + statistis.getCount());
          
    }
}
