package d4.hw;

import java.sql.SQLOutput;
import java.util.List;

public class Main {
    private static final EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        // list of 25 emp
        List<Employee> employees = List.of(
                new Employee(1, "Ali", "IT", 7500),
                new Employee(2, "Sara", "HR", 5200),
                new Employee(3, "John", "Finance", 6800),
                new Employee(4, "Mona", "IT", 8200),
                new Employee(5, "Omar", "Marketing", 4700),
                new Employee(6, "Lina", "HR", 5900),
                new Employee(7, "David", "Finance", 7200),
                new Employee(8, "Hassan", "IT", 9100),
                new Employee(9, "Nora", "Marketing", 5300),
                new Employee(10, "Adam", "IT", 6100),
                new Employee(11, "Layla", "Finance", 8400),
                new Employee(12, "Yousef", "HR", 4800),
                new Employee(13, "Fatima", "Marketing", 7600),
                new Employee(14, "Michael", "IT", 9900),
                new Employee(15, "Salma", "Finance", 6700),
                new Employee(16, "Ibrahim", "IT", 7100),
                new Employee(17, "Huda", "HR", 5500),
                new Employee(18, "Zaid", "Marketing", 6200),
                new Employee(19, "Rana", "Finance", 8800),
                new Employee(20, "Tariq", "IT", 5300),
                new Employee(21, "Mariam", "HR", 7300),
                new Employee(22, "Bilal", "Marketing", 4600),
                new Employee(23, "Noah", "Finance", 9400),
                new Employee(24, "Aisha", "IT", 6000),
                new Employee(25, "Khalid", "HR", 8100)
        );

        System.out.println(" "); // divider

        System.out.println("Employees with salary more than 8000:");
        var highEarnersEmployees = employeeService.getHighEarners(employees, 8000);
        System.out.println(highEarnersEmployees); // list of emp names

        System.out.println(" "); // divider

        System.out.println("The departments list in ascending order: ");
        var departmentsNames = employeeService.getDepartmentNames(employees);
        System.out.println(departmentsNames);

        System.out.println(" "); // divider

        System.out.println("5 Employees in the IT department:");
        var fiveITEmployees = employeeService.getTopNEmployeesByDepartment(employees, "IT", 5);
        fiveITEmployees.forEach(employee -> System.out.println(employee.toString()));

        System.out.println(" "); // divider

        System.out.println("All employees salaries:");
        var salaries = employeeService.getEmployeeSalaryMap(employees);
        salaries.forEach((name, salary) -> {
            System.out.println(String.format("%s - %.2f", name, salary));
        });

        System.out.println(" "); // divider

        System.out.println("Departments with their employees");
        var departmentWithEmployees = employeeService.groupEmployeesByDepartment(employees);
        System.out.println(departmentWithEmployees);

        System.out.println(" "); // divider

        System.out.println("Employees with salary more than 8000 in each department:");
        var highEarnersInEachDepartment = employeeService.getHighEarnersByDepartment(employees, 8000);
        System.out.println(highEarnersInEachDepartment);

        System.out.println(" "); // divider

        System.out.println("Salaries above the threshold (8.5k):");
        var salariesAboveThreshold = employeeService.getSalariesAboveThreshold(employees, 8500);
        System.out.println(salariesAboveThreshold);

        System.out.println(" "); // divider

        System.out.println("Employees names in ascending order in the IT department:");
        var ascDepNames = employeeService.getEmployeesByDepartmentSorted(employees, "IT");
        ascDepNames.forEach(employee -> System.out.println(employee.toString()));

    }
}
