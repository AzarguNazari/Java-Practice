package firstProject;

import java.util.Date;

public class Manager extends Employee{

    
    public Manager(int id, String fName, String lName, Date startWork, int age, double salary){
        super(id, fName, lName, startWork, age, salary);
    }
    
    public void setTasks(Task task, Programmer programmer){
        programmer.addTask(task);
    }
}
