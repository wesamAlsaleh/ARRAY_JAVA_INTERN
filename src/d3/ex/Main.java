package d3.ex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Alice", "IT", 5000, LocalDate.of(2020, 1, 10)),
                new Employee(2, "Bob", "HR", 4200, LocalDate.of(2019, 3, 5)),
                new Employee(3, "Charlie", "BUSINESS", 6000, LocalDate.of(2021, 7, 15)),
                new Employee(4, "Diana", "Finance", 6100, LocalDate.of(2018, 5, 20)),
                new Employee(5, "Ethan", "HR", 4500, LocalDate.of(2020, 9, 12)),
                new Employee(6, "Fiona", "Finance", 5800, LocalDate.of(2021, 2, 28))
        );

        var filteredEmployees = employeeService.filterAndStringTransform(
                employees,
                employee -> employee.getSalary() > 5000,
                Employee::getName
        );

        System.out.println(filteredEmployees);

        System.out.println(" ");

        employeeService.printEmployees(
                employees,
                employee -> employee.getSalary() > 6000,
                employee -> System.out.println(employee.toString())
        );

        var defaultEmployee = employeeService.generateDefaultEmployee(
                () -> new Employee(0, "Unknown", "Unknown", 0.0, LocalDate.now())
        );
        System.out.println(defaultEmployee.toString());

        System.out.println(" ");

        var highestPaidInEachDep = employeeService.getHighestPaidByDepartment(employees);
        System.out.println(highestPaidInEachDep);

        System.out.println(" ");

        var averageSalary = employeeService.getAverageSalaryByDepartment(employees);
        System.out.println(averageSalary);


    }
}
