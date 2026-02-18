package d4.hw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
    // no args constructor
    public EmployeeService() {
    }

    // function to get the high earners
    public List<String> getHighEarners(List<Employee> employees, int minSalary) {
        // filter and return the employees
        return employees.stream()
                .filter(employee -> employee.getSalary() > minSalary)
                .sorted(Comparator.comparing(Employee::getSalary).reversed()) // sort employees in DESC
                .map(Employee::getName)
                .toList();
    }

    // function to get the department names
    public List<String> getDepartmentNames(List<Employee> employees) {
        // get and return the unique departments in ASC order
        return employees.stream()
                .map(Employee::getDepartment)
                .distinct() // make them unique
                .sorted() // sort the strings alphabetically
                .toList();
    }

    // function to get the top employees by department
    public List<Employee> getTopNEmployeesByDepartment(
            List<Employee> employees,
            String departmentName,
            int n
    ) {
        // filter and return the employees by the given dep
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(departmentName)) // by dep
                .sorted(Comparator.comparing(Employee::getSalary).reversed()) // highest first
                .limit(n) // return only n elements
                .toList();
    }

    // function to get the employees with their salaries
    public Map<String, Double> getEmployeeSalaryMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Employee::getSalary
                )); // convert to Map<K,V>
    }

    // function to group the employees into a map<String, List>
    public Map<String, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        // return each dep with its employees {"IT" : [emp1, emp2]}
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

    }

    // function to group the employees into a map<String, List>
    public Map<String, List<Employee>> getHighEarnersByDepartment(
            List<Employee> employees,
            int minSalary) {
        // @NOTE: the group by (input as Function<T,R> => <Employee, String(dep)>) and then grouping by produces Map<R, List<T>>
        return employees.stream()
                .filter(employee -> employee.getSalary() > minSalary) // filter
                .collect(Collectors.groupingBy(Employee::getDepartment)); // group by
    }

    // function to get custom employees
    public List<Integer> getSalariesAboveThreshold(List<Employee> employees, int threshold) {
        return employees.stream()
                .filter(employee -> employee.getSalary() > threshold)
                .mapToInt(employee -> (int) employee.getSalary()) // convert stream<T> to IntStream
                .boxed() // convert it back to stream<T>
                .sorted() // by def ASC
                .skip(2) // skip the first 2 emp
                .limit(10) // get 10 emp
                .collect(Collectors.toList()); // only works with stream<T>
    }

    // function to get employees by department sorted
    public List<Employee> getEmployeesByDepartmentSorted(
            List<Employee> employees,
            String departmentName
    ) {
        // filter employees based on the department and return them in ASC order
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(departmentName))
                .sorted(Comparator.comparing(Employee::getName)) // sort department in ASC
                .toList();
    }

}
