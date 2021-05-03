/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaPractice.Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Hazar Gul
 */
public class YahooServer {

    public static void main(String[] args) {

        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try (ServerSocket server = new ServerSocket(2000);
                            Socket socket = server.accept()) {

                        // recievd command
                        InputStream receivedMessage = socket.getInputStream();
                        DataInputStream dataRecieved = new DataInputStream(receivedMessage);
                        String[] message = new String(dataRecieved.readUTF()).split(" +");
                        double digit1 = Double.parseDouble(message[1]);
                        double digit2 = Double.parseDouble(message[2]);
                        double answer = 0;
                        
                        switch(message[0].trim().toLowerCase()){
                            case "add":
                                answer = digit1 + digit2;
                                break;
                            case "sub":
                                answer = digit1 - digit2;
                                break;
                            case "div":
                                answer = digit1 / digit2;
                                break;
                            case "mul":
                                answer = digit1 * digit2;
                                break;
                            default:
                                answer = Double.NaN;
                        }
                        
                        
                        // Send back command
                        OutputStream output = socket.getOutputStream();
                        DataOutputStream dataOutput = new DataOutputStream(output);
                        dataOutput.writeUTF(String.valueOf(answer));

                        dataOutput.close();
                        output.close();
                        socket.close();
                    } catch (IOException ex) {
                        System.out.println("There's some mother fucker problem in the connection");
                    }
                }
            }

        };

        t.start();

    }
    

}
