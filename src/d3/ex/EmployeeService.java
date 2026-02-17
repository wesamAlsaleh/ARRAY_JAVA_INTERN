package d3.ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeService {
    public EmployeeService() {
    }

    // function to filter the employees
    public List<String> filterAndStringTransform(
            List<Employee> employees,
            Predicate<Employee> filter, // take T return boolean
            Function<Employee, String> transform // take t return r
    ) {
        // result holder
        List<String> result = new ArrayList<>();

        // iterate over the employees
        for (Employee employee : employees) {
            // if the employee salary greater than 500
            if (filter.test(employee)) {
                // add the employee name uppercase in the array
                result.add(transform.apply(employee));
            }
        }

        // return
        return result;
    }

    // function to print the employees
    public void printEmployees(
            List<Employee> employees,
            Predicate<Employee> validate, // take t return boolean
            Consumer<Employee> print // take t return void
    ) {
        // iterate over the employees
        for (Employee employee : employees) {
            // if the employee salary greater than 500
            if (validate.test(employee)) {
                print.accept(employee);
            }
        }
    }

    // function to generate a default employee
    public Employee generateDefaultEmployee(
            Supplier<Employee> supplier // take void return r
    ) {
        // generate and return the default generated employee
        return supplier.get();
    }

    // function to get the highest paid by department
    public Map<String, Employee> getHighestPaidByDepartment(
            List<Employee> employees
    ) {
        // prepare the result array
        Map<String, Employee> highestPaidByDepartment = new HashMap<>();

        // iterate over the employees
        for (Employee employee : employees) {
            // get the employee salary
            var salary = employee.getSalary();

            // if the array contain the department
            if (highestPaidByDepartment.containsKey(employee.getDepartment())) {
                // replace the salary if its higher
                if (highestPaidByDepartment.get(employee.getDepartment()).getSalary() < salary) {
                    // update the employee
                    highestPaidByDepartment.put(employee.getDepartment(), employee);
                }

                // go to the next employee
                continue;
            }

            // add new dep
            highestPaidByDepartment.put(employee.getDepartment(), employee);
        }

        // return
        return highestPaidByDepartment;
    }

    // function to get the average salary by department
    public Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees) {
        // prepare the total salaries hashMap
        HashMap<String, Double> totalSalary = new HashMap<>();

        // prepare the employees counter hashMap
        HashMap<String, Integer> employeesCounter = new HashMap<>();

        // iterate over the employees
        for (Employee employee : employees) {
            // get the employee data
            var salary = employee.getSalary();
            var department = employee.getDepartment();

            // put new or update the total salary
            totalSalary.put(department, totalSalary.getOrDefault(department, 0.0) + salary);
            employeesCounter.put(department, employeesCounter.getOrDefault(department, 0) + 1);
        }

        // prepare the average hashMap
        HashMap<String, Double> averageSalaryByDepartment = new HashMap<>();

        // iterate over the departments
        for (String department : employeesCounter.keySet()) {
            var totalSalaryForDepartment = totalSalary.getOrDefault(department, 0.0);
            var totalEmployeesInADepartment = employeesCounter.getOrDefault(department, 0);

            // calculate the average salary for each dep (total salary/employees number)
            averageSalaryByDepartment.put(department, totalSalaryForDepartment / totalEmployeesInADepartment);
        }

        // return
        return averageSalaryByDepartment;
    }
}
