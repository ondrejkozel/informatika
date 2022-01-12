package cz.okozel.zamestnanci;

import java.time.LocalDateTime;

/**
 *
 * Represents an employed person in some company.
 *
 * <p>
 * Holds employee's name, salary and timestamp of the commencement
 * of empoyment relationship.
 *
 */
class Employee implements Comparable<Employee> {

    private String name;
    private int salary;
    private final LocalDateTime employedSince;

    /**
     * Construct a new employee.
     * @param name employee's name
     * @param salary emplyee's wage
     */
    public Employee(String name, int salary) {
        this(name, salary, LocalDateTime.now());
    }

    public Employee(String name, int salary, LocalDateTime employedSince) {
        this.name = name;
        this.salary = salary;
        this.employedSince = employedSince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDateTime getEmployedSince() {
        return employedSince;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", employedSince=" + employedSince +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.name);
    }
}
