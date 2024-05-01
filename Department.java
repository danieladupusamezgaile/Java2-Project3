import java.util.List;

public class Department {
    String name;
    List<Employee> employees;

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public void displayEmployeesTable(){
        System.out.println("Total number of employees in " + this.name + " department: " + employees.size());
    }
}
