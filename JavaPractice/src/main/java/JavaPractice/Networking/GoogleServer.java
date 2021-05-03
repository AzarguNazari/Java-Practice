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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author Hazar Gul
 */
public class GoogleServer {

    static List<Person> users = new ArrayList<>();

    public static void main(String[] args) {

        users.add(new Person("Azargul Nazari", 1414322, "nazariazargul@gmail.com"));
        users.add(new Person("Jamshid Nazari", 1000, "jamshid@gmail.com"));

        try (ServerSocket server = new ServerSocket(1500);
                Socket socket = server.accept()) {

            // recievd command
            InputStream receivedMessage = socket.getInputStream();
            DataInputStream dataRecieved = new DataInputStream(receivedMessage);
            String message = new String(dataRecieved.readUTF()).trim();

            OutputStream output = socket.getOutputStream();
            DataOutputStream dataOutput = new DataOutputStream(output);
            dataOutput.writeUTF(find(message));

            dataOutput.close();
            output.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("There's some mother fucker problem in the connection");
        }

    }

    public static String find(String user){
        for (Person p : users) {
            if(p.email.equalsIgnoreCase(user) || String.valueOf(p.id).equals(user) || p.name.equalsIgnoreCase(user)){
                return p.toString();
            }
        }
        return "User is not found";
    }

}

class Person {

    String name;
    int id;
    String email;

    public Person(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + " \nID: " + id + "\nEmail: " + email;
    }
}
