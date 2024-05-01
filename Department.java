import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    List<Employee> employees = new ArrayList<>();

    Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void displayEmployeesTable() {
        if (employees.size() < 1) {
            System.out.println("------------------------------------------------");
            System.out.println("No Employees to show");
            System.out.println("------------------------------------------------");
        } else {
            System.out.println("------------------------------------------------");
            System.out.printf("| %-10s | %-8s | %-20s |%n", "Name", "ID", "Department");
            System.out.println("------------------------------------------------");
            for (Employee employee : employees) {
                System.out.printf("| %-10s | %-8s | %-20s |%n", employee.getName(), employee.getID(), this.name);
            }
            System.out.println("------------------------------------------------");
        }
    }
}
