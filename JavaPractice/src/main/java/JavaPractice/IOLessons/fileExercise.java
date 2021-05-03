package JavaPractice.IOLessons;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class fileExercise {
    
    public static void main(String[] args) throws IOException {
        
        
//        File page = new File("index.html");
//       
//        if(!page.exists()) page.createNewFile();
//        
//        PrintWriter output = new PrintWriter(page);
//        Scanner input = new Scanner(System.in);
//        
//        output.println("<table border='1'>");
//        output.println("<tr><th>Name</th><th>Last Name</th><th>Country</th><th>City</th><th>Age</th><th></th></tr>");
//        
//        
//        while(true){
//            System.out.print("Do you want to add record? [y/n]: ");
//            String command = input.next();
//            if(command.substring(0, 1).equalsIgnoreCase("n")) break;
//            output.println("<tr>");
//            System.out.print("Write [name lastname country city age] : ");
//            input.nextLine();
//            String[] line = input.nextLine().split(" +");
//            
//            for(String s : line){
//                output.print("<td>" + s + "</td>");
//            }
//            
//            output.println("</tr>");
//        }
//        output.println("</table>");
//        output.close();
//        
//        
//            
//            File javaDirecotry = new File("C:\\Users\\Hazar Gul\\Documents\\NetBeansProjects\\AdvanceJava\\Java");
//
//            if(!javaDirecotry.exists()) javaDirecotry.mkdir();
//            
//            File OOP = new File(javaDirecotry, "OOP"); OOP.mkdir();
//            File concurrency = new File(javaDirecotry, "Concurrency"); concurrency.mkdir();
//            
            
            Scanner input = new Scanner(new File("numbers.txt"));
            ArrayList<String> numbers = new ArrayList<>();
            while(input.hasNext()){
                String n = input.next();
                if(!numbers.contains(n)) numbers.add(n);
            }
            
            PrintWriter output = new PrintWriter("uniqueNumbers.txt");
            numbers.forEach(line -> output.println(line));
            
            output.close();
            
                


    }
}
