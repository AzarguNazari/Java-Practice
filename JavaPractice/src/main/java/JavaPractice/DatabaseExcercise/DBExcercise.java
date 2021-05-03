/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaPractice.DatabaseExcercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hazar Gul
 */
public class DBExcercise {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver"); 
        
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        ResultSet result = con.createStatement().executeQuery("select * from customer");
        
        System.out.println(result.next());
        
        
//        try {
//            DB database = new DB();
//            database.insert("Azargul", 1414322);
//        } catch (SQLException ex) {
//            System.out.println("Sorry the database execution didn't happen");
//        }
    }

}

class DB implements AutoCloseable {

    private Connection con;
    private Statement state = null;

    public DB() throws SQLException {
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/test", "test", "");
    }

    public void insert(String name, int id) throws SQLException {
        state = con.createStatement();
        ResultSet result = state.executeQuery("select id from employee");
        if (result.next()) {
            System.out.println("Sorry, " + id + " is already existed");
            return;
        }
        
        result = state.executeQuery("insert into employee values('" + name + "'," + id + ")");
        if (result.next()) {
            System.out.println("{" + name + "," + id + "}" + "is inserted");
        }
        else{
            System.out.println("Sorry there' some problem on insert command");
        }
    }

    @Override
    public void close() throws SQLException {
        con.close();
        state.close();
    }

}
