package firstProject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Programmer extends Employee{

    private final List<Task> tasks;
    
    public Programmer(int id, String fName, String lName, Date startWork, int age, double salary){
        super(id, fName, lName, startWork, age, salary);
        tasks = new ArrayList<>();
    }
    
    public boolean addTask(Task task){
        return tasks.add(task);
    }
    
    public boolean removeTask(Task task){
        if(tasks.contains(task)){
           return tasks.remove(task);
        }
        return false;
    }
    
    public String showTasks(){
        if(tasks.isEmpty()){
            return "---- No Tasks ----";
        }
        String output = "------- Tasks -------- \n";
        for(Task t: tasks){
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
            output += t.getTaskName() + " | (" + ft.format(t.getStartData()) + " - " + ft.format(t.getFinishData()) + ")\n";
        }
        return output;
    }
}
