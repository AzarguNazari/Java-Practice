package firstProject;


import Lesson2.EmployeeDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Employee implements EmployeeDAO{
    
    
    protected String fName, lName;
    protected Date startWork;
    protected int age, id;
    protected double salary;

    private Employee() {}
    
    public static Employee create(int id, String fName, String lName, Date startWork, int age, double salary){
        /*
        String name = "com.example.dao.EmployeeDAOMemoryImpl";
        Class clazz = Class.forName(name);
        EmployeDAO dao = (EmployeeDAO)clazz.newInstance();
        */
        Employee temp = new Employee();
        temp.id = id;
        temp.fName = fName;
        temp.lName = lName;
        temp.startWork = startWork;
        temp.age = age;
        temp.salary = salary;
        return temp;
    }
    
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if ((o != null) && (o instanceof Employee)) {
            Employee e = (Employee) o;
            if ((e.getID() == this.id)
                    && (e.getFname().equals(this.fName))
                    && (e.getlName().equals(this.lName))
                    && (e.getAge() == this.age)
                    && (e.getSalary() == this.salary)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.fName);
        hash = 59 * hash + Objects.hashCode(this.lName);
        hash = 59 * hash + this.age;
        hash = 59 * hash + this.id;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.salary) ^ (Double.doubleToLongBits(this.salary) >>> 32));
        return hash;
    }
    
    
    public int getID(){
        return id;
    }
    
    public String getFname() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public Date getStartWork() {
        return startWork;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    /*
    public void setID(int id){
        this.id = id;
    }
    
    public void setFname(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }*/

    @Override
    public void add(Lesson2.Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Lesson2.Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Lesson2.Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lesson2.Employee findByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Lesson2.Employee> getEmployees() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
