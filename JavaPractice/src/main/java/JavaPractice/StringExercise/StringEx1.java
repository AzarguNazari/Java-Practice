package JavaPractice.StringExercise;

public class StringEx1 {
    
    public static void main(String[] args) {
        
        String firstType = "First Type";
        String secondType = new String("Second Type");
        
        firstType.charAt(0);
        firstType.chars().sum();
        firstType.codePointAt(0);
        firstType.codePointBefore(1);
        firstType.codePointCount(1, 3);
        firstType.codePoints().forEach(System.out::println);
        firstType.compareTo("Seond Type");
        firstType.compareToIgnoreCase("Ignoring Case sensitivity");
        firstType.concat("A new Added part");
        firstType.contains("Does it contain any part");
        firstType.contentEquals("Exactly equal content");
        firstType.endsWith("Ends with a specific string");
        firstType.equals("Some other string");
        firstType.equalsIgnoreCase("Without case sensitivty");
        int totalByte = firstType.getBytes().length;
        firstType.hashCode();
        firstType.toUpperCase();
        firstType.toLowerCase();
        firstType.toCharArray();
        firstType.substring(2, 5);
        firstType.startsWith("A");
        firstType.split("a+", 15);
        firstType.replace("First", "Second");
        firstType.split(" ");
        firstType.isEmpty();
        firstType.length();
        firstType.lastIndexOf("Ahmad");
        firstType.matches("Match it");
        
        
        StringBuilder thirthType = new StringBuilder("Thirth Type");
        
        thirthType.append("New added");
        thirthType.capacity();
        thirthType.chars().count();
    
        StringBuffer forthType = new StringBuffer("Forth Type");

        
    }
    
}
