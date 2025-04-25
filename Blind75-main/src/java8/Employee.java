package java8;

public class Employee {
    public Employee(float salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    float salary;
    String name;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Employee multiply(Employee employee) {
        employee.salary= employee.salary*3;
        return employee;
    }

}
