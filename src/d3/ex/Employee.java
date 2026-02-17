package d3.ex;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private LocalDate hireDate;

    // all args cons.
    public Employee(int id, String name, String department, double salary, LocalDate hireDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    // override toString to show readable message


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
