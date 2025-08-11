package practice.java8;

import practice.java8.vo.Employee;
import practice.java8.vo.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FeaturePractice {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", 75000),
                new Employee("Jane", "Finance", 90000),
                new Employee("Mark", "IT", 60000),
                new Employee("Lucy", "Finance", 50000)
        );
        System.out.println("Question 1 Answer :");
        filterEmpByDepartmentAndSalary(employees);
        System.out.println("Question 2 Answer :");
        empWithHighestSalary(employees);

        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 80000),
                new Product("Shirt", "Clothing", 2000),
                new Product("Mobile", "Electronics", 30000),
                new Product("Pants", "Clothing", 2500)
        );

        System.out.println("Question 3 Answer :");
        getProductCategoryGroupWithTotalCategoryPrice(products);
    }

    //1. Filter Employees by Department & Salary
    //Task: Print names of employees from "IT" department whose salary is greater than 65000.
    public static void filterEmpByDepartmentAndSalary(List<Employee> employees) {
        employees.stream()
                .filter(x -> "IT".equalsIgnoreCase(x.getDepartmentName()))
                .filter(x -> x.getSalary() > 65000)
                .forEach(x -> System.out.println(x.getName()));
    }

    //    2. Top 3 Highest Paid Employees
//    Input: Same employees list as above.
//    Task: Print the top 3 employees with the highest salary.
    public static void empWithHighestSalary(List<Employee> employees) {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .reversed()
                        .thenComparing(Employee::getName))
                .limit(3)
                .forEach(x -> System.out.println(x.getName()));
    }

//    3. Product Category-wise Total Price
//    Input:
//    java
//    List<Product> products = Arrays.asList(
//            new Product("Laptop", "Electronics", 80000),
//            new Product("Shirt", "Clothing", 2000),
//            new Product("Mobile", "Electronics", 30000),
//            new Product("Pants", "Clothing", 2500)
//    );
//    Task: Group products by category and calculate total price per category.

    public static void getProductCategoryGroupWithTotalCategoryPrice(List<Product> productList) {
        productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.summingDouble(Product::getPrice)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(x -> System.out.println(x.getKey() + " : " + x.getValue()));
    }
}
