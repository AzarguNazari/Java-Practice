
package firstProject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task {
    private String taskName;
    private final ArrayList<Employee> collaborators;
    private Date startDate, finishDate;
    
    private Task(){
        collaborators = new ArrayList<>();
        startDate = new Date();
        finishDate = null;
    }
    
    public Task createTask(String taskName, Date finish){
        Task temp = new Task();
        temp.setTaskName(taskName);
        temp.setFinishData(finish);
        return temp;
    }
    
    public Task createTask(String taskName, Date start, Date finish){
        Task temp = new Task();
        temp.setTaskName(taskName);
        temp.setStartData(start);
        temp.setFinishData(finish);
        return temp;
    }

    public String getTaskName() {
        return taskName;
    }

    public ArrayList<Employee> getCollaborators() {
        return (ArrayList<Employee>) collaborators.clone();
    }

    public Date getStartData() {
        /*
        SimpleDateFormat ft = 
      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz"); */
        return (Date) startDate.clone();
    }

    public Date getFinishData() {
        return (Date) finishDate.clone();
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean addCollaborator(Employee collaborator) {
        return collaborators.add(collaborator);
    }
    
    public boolean removeCollaborator(Employee collaborator){
         return collaborators.remove(collaborator);
    }
    
    public boolean searchCollaborator(Employee collaborator){
        return collaborators.contains(collaborator);
    }
    
    public Employee findCollaborator(Employee collaborator){
        if(collaborators.contains(collaborator)){
            return collaborators.get(collaborators.indexOf(collaborator));
        }
        return null;
    }

    public void setStartData(Date startDate) {
        this.startDate = startDate;
    }

    public void setFinishData(Date finishDate) {
        this.finishDate = finishDate;
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public String toString(){
        String output = "----------------" + taskName + "-----------------\n";
        output += "Task Name: " + this.taskName + "\n";
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
        output += "Start Date: " + ft.format(startDate) + "\n";
        output += "Finish Date: " + ft.format(finishDate) + "\n";
        if(!collaborators.isEmpty()){
            output += "Collaborators: >>";
            for(Employee e : collaborators) {
                output += "Name : " + e.getFname() + " " + e.getlName() + "\n";
                String position = (e instanceof Programmer)? "Programmer" : "Manager";
                output += "Position: " + position + "\n=========\n";
            };
        }
        output += "------------------------------------------------------------";
        return output;
    }
}
