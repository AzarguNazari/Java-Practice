package JavaPractice;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;



public class AdvanceJava {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
    	System.out.println("Hello world");
    	
        
//        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("output.txt"));
//        ObjectInputStream input = new ObjectInputStream(new FileInputStream("output.txt"));
//        
//        //List<Person> first = Arrays.asList(new Person("Azarggul", 25), new Person("jamshid", 18));
//        
//        //output.writeObject(first);
//        try{
//            List<Person> first = (List<Person>) input.readObject();
//        }
//        
//        
//        System.out.println(first);
        
    }
    
    
}

class Person implements Serializable{
    private static final long serialVersionUID = 23L;
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString(){
        return this.name + " " + this.age + "\n";
    }
}