

  import java.util.*;

// Employee Class
class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: ₹" + salary);
    }
}

// Main Class
public class Employee_Management_System {

    static ArrayList<Employee> empList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Employee");
            System.out.println("2. Read All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createEmployee();
                    break;
                case 2:
                    readEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // CREATE
    static void createEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        // Check duplicate ID
        for (Employee e : empList) {
            if (e.getId() == id) {
                System.out.println("Employee ID already exists!");
                return;
            }
        }

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        empList.add(new Employee(id, name, salary));
        System.out.println("Employee Created Successfully!");
    }

    // READ
    static void readEmployees() {
        if (empList.isEmpty()) {
            System.out.println("No employees available!");
            return;
        }

        for (Employee e : empList) {
            e.display();
        }
    }

    // SEARCH
    static void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : empList) {
            if (e.getId() == id) {
                e.display();
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    // UPDATE
    static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Employee e : empList) {
            if (e.getId() == id) {
                System.out.print("Enter new name: ");
                e.setName(sc.nextLine());

                System.out.print("Enter new salary: ");
                e.setSalary(sc.nextDouble());

                System.out.println("Employee Updated Successfully!");
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    // DELETE
    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        Iterator<Employee> it = empList.iterator();

        while (it.hasNext()) {
            Employee e = it.next();
            if (e.getId() == id) {
                it.remove();
                System.out.println("Employee Deleted Successfully!");
                return;
            }
        }

        System.out.println("Employee not found!");
    }
}
