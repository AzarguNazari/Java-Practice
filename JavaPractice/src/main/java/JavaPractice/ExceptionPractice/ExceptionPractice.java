package JavaPractice.ExceptionPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.processing.FilerException;

public class ExceptionPractice{

    public static void main(String[] args) throws FileNotFoundException {

//        try (FileInputStream in = new FileInputStream(new File("file.txt"));
//                ObjectInputStream objectInput = new ObjectInputStream(in);
//                FileOutputStream out = new FileOutputStream(new File("file.txt"));
//                ObjectOutputStream objectOutput = new ObjectOutputStream(out);) {
//
//        } catch (SerializationException ex) {
//
//        } catch (FileNotFoundException ex) {
//
//        } catch (IOException ex) {
//
//        } catch (Exception ex) {
//
//        } finally {
//
//        }
//
//        FileInputStream in = new FileInputStream("file.txt");
//        try {
//            ObjectInputStream input = new ObjectInputStream(in);
//        } catch (IOException ex) {
//            Logger.getLogger(ExceptionPractice.class.getName()).log(Level.SEVERE, null, ex);
//        }
        

        int age = 20;
        
        assert age == 20 : "Please your age should not be 20";

    }

    public static void ReadFile(File file) throws FileNotFoundException, IOException {
        try (FileInputStream in = new FileInputStream(new File("file.txt"));
            ObjectInputStream objectInput = new ObjectInputStream(in);
            FileOutputStream out = new FileOutputStream(new File("file.txt"));
            ObjectOutputStream objectOutput = new ObjectOutputStream(out);) {
        }
    }

}


class CustomedException extends Exception{
    
    public CustomedException(){
        this("Customed Exception Occured");
    }
    public CustomedException(String execption){
        super(execption);
    }
    
}