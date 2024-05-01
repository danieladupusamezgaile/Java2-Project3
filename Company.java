import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {
    Scanner sc = new Scanner(System.in);
    List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void displayCompanyStructure() {
        System.out.println("Company Structure:");
        if (departments.size() < 1) {
            System.out.println("No departments to show");
        } else {
            for (Department department : departments) {
                System.out.println(department.name + " Department");
                department.displayEmployeesTable();
            }
        }
        System.out.println("Press Enter to continue..");
        sc.nextLine();
        if (sc.hasNextLine()) {
            this.menu();
        }
    }

    public void menu() {
        System.out.println("---------------------------------");
        System.out.println("|             MENU              |");
        System.out.println("---------------------------------");
        System.out.println("| 1. Add Department             |");
        System.out.println("| 2. Add Employee to Department |");
        System.out.println("| 3. Display Company Structure  |");
        System.out.println("| 4. Quit                       |");
        System.out.println("---------------------------------");
        System.out.println("Choose from the menu");
        System.out.print("-->");

        int option = this.validateOption("Choose from the menu: ", 4);

        switch (option) {
            case 1:
                this.addDepartmentOption();
                break;
            case 2:
                this.addEmployeeOption();
                break;
            case 3:
                this.displayCompanyStructure();
                break;
            default:
                System.out.println("Thank you, bye");
                break;
        }
    }

    public int validateOption(String message, int numOfOptions) {
        while (!sc.hasNextInt()) {
            System.out.println("not a valid option!");
            System.out.print(message);
            sc.next();
        }
        int option = sc.nextInt();
        while (option < 1 || option > numOfOptions) {
            System.out.println("not a valid option!");
            System.out.print(message);
            while (!sc.hasNextInt()) {
                System.out.println("Not a valid option!");
                System.out.print(message);
                sc.next();
            }
            option = sc.nextInt();
        }
        return option;
    }

    public void addDepartmentOption() {
        System.out.print("Enter Department name: ");
        String departmentName = sc.next();
        Department department = new Department(departmentName);
        this.departments.add(department);
        System.out.println("Department added successfully!");
        this.menu();
    }

    public void addEmployeeOption() {
        if (departments.size() < 1) {
            System.out.println("Please add department before adding employee");
            System.out.println("Press Enter to continue..");
            sc.nextLine();
            if (sc.hasNextLine()) {
                this.menu();
            }
        }

        Employee employee = new Employee();
        System.out.print("Enter employee name: ");
        String employeeName = sc.next();
        employee.setname(employeeName);
        System.out.print("Enter employee ID: ");
        int id = sc.nextInt();
        employee.setID(id);
        System.out.println("Available Departments:");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(i + 1 + ". " + departments.get(i).name);
        }
        System.out.print("Choose department: ");

        int option = this.validateOption("Choose from available departments: ", departments.size());

        for (int i = 0; i < departments.size(); i++) {
            if (option == i + 1) {
                departments.get(i).addEmployee(employee);
                System.out.println("Employee added to " + departments.get(i).name + " department!");
                break;
            }
        }
        this.menu();
    }

    public static void main(String[] args) {
        System.out.println("\n            WELLCOME!           ");
        Company company = new Company();
        company.menu();
    }
}
