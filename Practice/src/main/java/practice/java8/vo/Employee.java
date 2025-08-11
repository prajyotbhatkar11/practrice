package practice.java8.vo;

public class Employee {
    private String name;
    private String departmentName;
    private double salary;

    public Employee(String name, String departmentName, double salary){
        this.name = name;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
