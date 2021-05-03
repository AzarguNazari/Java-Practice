package JavaPractice.Networking;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Hazar Gul
 */
public class Client {
    
    public static void main(String[] args){
        
        BufferedReader inputCommand;
        OutputStream sendCommand;
        InputStream receiveMessage;
        Socket socket;
        Scanner input = new Scanner(System.in);
        PrintWriter output;
        
        
        try{
            
            while(true){
                
                out:
                while(true){
                    System.out.print("Enter addressname(Google, Yahoo): ");
                    switch(input.next().toLowerCase()){
                        case "google":
                            socket = new Socket(InetAddress.getLocalHost(), 1500);
                            break out;
                        case "yahoo":
                            socket = new Socket(InetAddress.getLocalHost(), 2000);
                            break out;
                        default:
                            System.out.println("We don't support it");
                    }
                }
                
                System.out.print("Command >> ");
                inputCommand = new BufferedReader(new InputStreamReader(System.in));    // Input Command
                OutputStream send = socket.getOutputStream();
                output = new PrintWriter(send, true);
                
                // recievd command
                InputStream receivedMessage = socket.getInputStream();
                DataInputStream dataRecieved = new DataInputStream(receivedMessage);
                String message = new String(dataRecieved.readUTF()).trim();
                System.out.println(message);
            }
        }
        catch(UnknownHostException ex){
            System.out.println("The Host is not found");
        }
        catch(IOException ex){
            System.out.println("There's some problem in IO exception");
        }
        catch(Exception ex){
            System.out.println("Sorry there's some problem with internet connection");
        }
        
        
        
    }
    
}
