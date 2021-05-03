package JavaPractice.IOLessons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class serializationExercise {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        Person ahmad = new Person("Ahmad", 32);
        ahmad.addItem("Apple");
        ahmad.addItem("Orange");
        ahmad.addItem("Egg");
        
        FileOutputStream outputFile = new FileOutputStream("persons.txt");
        ObjectOutputStream objectOutput = new ObjectOutputStream(outputFile);
        objectOutput.writeObject(ahmad);
        
        
        FileInputStream inputFile = new FileInputStream("persons.txt");
        ObjectInputStream objectInput = new ObjectInputStream(inputFile);
        
        ahmad = (Person) objectInput.readObject();
        
        ahmad.print();
        
    }
    
    
}

class Person implements Serializable{
    public static final long serialVersionUID = 20L;
    private transient static final String var = "someting";
    private transient int year = 2018;
    private static int month = 2;
    private static String version;
    private final List<String> shopping = new ArrayList<>();
    private final String name;
    private final int socialID;
    public Person(String name, int id){
        this.name = name;
        this.socialID = id;
        Person.version = "1.1";
    }
    public String getName(){return name;}
    public int getID(){return socialID;}
    public void addItem(String item){shopping.add(item);};
    public void removeItem(String item){  
        if(shopping.contains(item)){
            shopping.remove(item);
        }
    }
    public void print(){
        System.out.println("Version : " + version);
        System.out.println("Name : " + name);
        System.out.println("ID: " + socialID);
        System.out.println("Shoppings: ");
        shopping.stream().map(String::toUpperCase).forEach(System.out::println);
    }
    
    public void writeObject(ObjectOutputStream  wb) throws IOException{
    
    }
    
    public void readObject(ObjectInputStream  wb) throws IOException{
        
    }
}
