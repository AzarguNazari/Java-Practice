
package JavaPractice.IOLessons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class streamsExercise {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
//        File f1 = new File("hello.txt");
//        if(!f1.exists()) f1.createNewFile();
//        
//        PrintWriter output = new PrintWriter(f1);
//       
//        for(int x = 0; x < 10; x++) output.print(x);
//        output.close();
//        
//               
//        FileInputStream input = new FileInputStream(new File("hello.txt"));
//        
//        byte[] chars = new byte[(int)f1.length() + 10];
//        input.read(chars);
//        
//        for(byte c : chars){
//            System.out.println((char)c);
//        }
//        
//        PrintStream print = new PrintStream(f1);
//        
        
//        URL note = new URL("https://www.inf.unibz.it/~calvanese/teaching/ip/lecture-notes/uni09/node14.html");
//        InputStream in = note.openStream();
//        Scanner inputReader = new Scanner(in);
//        
//        while(inputReader.hasNextLine())
//            System.out.println(inputReader.nextLine());
//        

//    
//          OutputStream out = System.out;
//          FileOutputStream fileOutput = new FileOutputStream(new File("file"));
//     
//

//        InputStream in = System.in;
//        InputStreamReader reader = new InputStreamReader(in);
//        BufferedReader buffer = new BufferedReader(reader);
//        
//        while(true){
//            System.out.print("Write here: ");
//            String command = buffer.readLine();
//            if(command.trim().equalsIgnoreCase("exit")) break;
//            System.out.println(command);
//        }
//        
        
////        FileOutputStream fileOutput = new FileOutputStream(); for file
        
//            OutputStream out = System.out; 
//            OutputStreamWriter writer = new OutputStreamWriter(out);
//            BufferedWriter writeBuffer = new BufferedWriter(writer);
//            
//            writeBuffer.write("This is another thing \n");
//            writeBuffer.flush();


              OutputStream out = System.out;
              PrintStream print = new PrintStream(out);
              print.println("Hello print writer");

    }
    
}
