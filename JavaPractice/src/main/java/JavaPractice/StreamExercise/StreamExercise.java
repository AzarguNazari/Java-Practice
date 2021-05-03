package JavaPractice.StreamExercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExercise {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException  {
        
        List<Product> products = new ArrayList<>();
        FileInputStream inputFile = new FileInputStream("statistics.txt");
        ObjectInputStream objectInput = new ObjectInputStream(inputFile);
        

        products = (List<Product>) objectInput.readObject();
        
        products = products.stream().filter(x -> x.getType().equalsIgnoreCase("food")).collect(Collectors.toList());
        
        printlnProducts(products);
        
        objectInput.close();
        
//        List<String> list = Arrays.asList("Ahmad", "Akim", "Jamshid");
//        
//        list
//                .stream()
//                .filter(x -> x.startsWith("A"))
//                .map(String::toUpperCase)
//                .forEach(System.out::println);
//        
//        List<String> list2 = Arrays.asList("a1", "a2", "a3");
//        list2.stream().findFirst().ifPresent(System.out::println);
        
        
//         List<Test> tests = Arrays.asList(new Test("Azargul", "Nazari"), new Test("Jamshid", "Rahimi"), new Test("Ahmad", "Karimi"));
//         tests
//                 .stream()
//                 .filter(x -> x.name.startsWith("A"))
//                 .sorted((Test a, Test b) -> a.name.compareToIgnoreCase(b.name))
//                 .forEach(x -> System.out.println(x.name + " " + x.lastname));
        
    }
    
    public static void printlnProducts(List<Product> products){
        // Number, ProductName, Type, Quantity, Price, ProductDate, Expire Date
        System.out.println(String.format("%-10s%-20s%-15s%-10s%-10s%-20s%-20s", "Number", "Product Name", "Type", "Quantity", "Price", "Product Date", "Expire Date"));
        for(int x = 0; x < products.size(); x++){
            String pDate = products.get(x).getProductDate().getYear() + "/" + products.get(x).getProductDate().getMonth() + "/" + products.get(x).getProductDate().getDay();
            String eDate = products.get(x).getExpireDate().getYear() + "/" + products.get(x).getExpireDate().getMonth() + "/" + products.get(x).getExpireDate().getDay();
            System.out.println(String.format("%-10d%-20s%-15s%-10d%-10.0f%-20s%-20s", (x + 1), products.get(x).getProductName(), products.get(x).getType(), products.get(x).getQuantity(), products.get(x).getPrice(), pDate, eDate));
        }
    }
}

class Product implements Serializable{
    private String productName;
    private Date productDate, expireDate;
    private int quantity;
    private String type;
    private double price;

    public Product(String productName, Date productDate, Date expireDate, int quantity, String type, double price) {
        this.productName = productName;
        this.productDate = productDate;
        this.expireDate = expireDate;
        this.quantity = quantity;
        this.type = type;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public Date getProductDate() {
        return productDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
    
//     
//        String[][] productNames = {{"Shampo", "Fashion"}, {"Egg", "Food"}, {"Computer", "Accessories"}, {"Mobile", "Accessories"}, {"Book", "Stationary"}, {"NoteBook", "Stationary"}, {"Coffee", "Food"}, {"Towal", "Equipments"}, {"Keyboard", "Accessories"}, {"Sun Glass", "Equipments"}, {"Wallet", "Personal"}, {"Headphone", "Accessories"}, {"Glass", "Equipments"}, {"Pen", "Stationary"}, {"Pencil", "Stationary"}};
//        
//        for(int x = 0; x < productNames.length; x++){
//            Date pdate = new Date(System.currentTimeMillis() - (int)(Math.random() * 10000));
//            Date edate = new Date(System.currentTimeMillis() + (int)(Math.random() * 10000));
//            String producateName = productNames[x][0];
//            String type = productNames[x][1];
//            double price = (Math.random() * 500) + 200;
//            int quantity = (int)(Math.random() * 1000);
//            products.add(new Product(producateName, pdate, edate, quantity, type, price));
//        }
//        
}
