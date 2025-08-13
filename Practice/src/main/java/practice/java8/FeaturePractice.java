package practice.java8;

import practice.java8.vo.*;

import java.util.*;
import java.util.function.Function;
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
        System.out.println("Question 4 Answer :");
        getAvgPriceForEachProduct(products);
        System.out.println("Question 5 Answer :");
        empWithHighestSalaryDepartmentWise(employees);
//        System.out.println("Question 6 Answer : Suggested Approach");
//        empSortByEmpThenBySalary(employees);
        System.out.println("Question 6 Answer : Old Approach");
        empSortByEmpThenBySalary_2(employees);


        List<Student> students = Arrays.asList(
                new Student("Alex", 85),
                new Student("Bob", 40),
                new Student("Clara", 65),
                new Student("David", 30)
        );
        System.out.println("Question 7 Answer :");
        partitionStudentsBasedOnMarks(students);

        List<User> users = Arrays.asList(
                new User(1, "Mike"),
                new User(2, "Sophia"),
                new User(3, "John")
        );
        System.out.println("Question 8 Answer :");
        convertListToMapOfUsers(users);

        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        System.out.println("Question 9 Answer :");
        countFrequencyAndStoreInMap(words);
        List<Person> people = Arrays.asList(
                new Person("Adam", 32),
                new Person("Eve", 45),
                new Person("John", 28)
        );
        System.out.println("Question 10 Answer :");
        findOldestPerson(people);
        System.out.println("Question 11 Answer :");
        findSecondHighestSalary(employees);
        System.out.println("Question 12 Answer :");
        List<String> strings = Arrays.asList("cat", "elephant", "tiger", "hippopotamus");
        findLongestString(strings);

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

    //    4. Average Price of Each Category
//    Input: Same products list as above.
//    Task: Find the average price for each product category.
    public static void getAvgPriceForEachProduct(List<Product> productList) {
        productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(x -> System.out.println(x.getKey() + " : " + x.getValue()));
    }
//    5. Department-wise Highest Salary
//Input: Use employees list from Problem 1.
//Task: For each department, find the employee with the highest salary.

    public static void empWithHighestSalaryDepartmentWise(List<Employee> employees) {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(empOpt ->
                        empOpt.getValue().ifPresent(x -> System.out.println(x.getDepartmentName() +
                                " >> " + x.getName() +
                                " : " + x.getSalary())));
    }

//    6. Sort by Multiple Conditions
//Input: Same employees list as above.
//Task: Sort employees first by department (asc), then by salary (desc).

    public static void empSortByEmpThenBySalary(List<Employee> employees) {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Comparator.comparing(Employee::getSalary).reversed()))
                .forEach(x -> System.out.println(x.getName() + " : " + x.getSalary()));
    }

    public static void empSortByEmpThenBySalary_2(List<Employee> employees) {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Employee::getSalary))
                .forEach(x -> System.out.println(x.getName() + " : " + x.getSalary()));
    }

//    7. Partition Students by Pass/Fail
//Input:
//List<Student> students = Arrays.asList(
//    new Student("Alex", 85),
//    new Student("Bob", 40),
//    new Student("Clara", 65),
//    new Student("David", 30)
//);
//Task: Partition students into two lists — pass marks >= 50 and fail marks < 50.

    public static void partitionStudentsBasedOnMarks(List<Student> students) {
        students.stream()
                .collect(Collectors.partitioningBy(s -> s.getMarks() >= 50))
                .forEach((key, list) -> {
                    if (key) {
                        System.out.println("Passed Students");
                        list.forEach(x -> System.out.println(x.getName() + " : " + x.getMarks()));
                    } else {
                        System.out.println("Failed Students");
                        list.forEach(x -> System.out.println(x.getName() + " : " + x.getMarks()));
                    }
                });
    }
//    8. Convert List to Map (ID → Name)
//Input:
//List<User> users = Arrays.asList(
//    new User(1, "Mike"),
//    new User(2, "Sophia"),
//    new User(3, "John")
//);
//Task: Convert list into a Map<Integer, String> where key = id, value = name.

    public static void convertListToMapOfUsers(List<User> users) {
        Map<Integer, String> userMap = users
                .stream()
                .collect(Collectors.toMap(User::getId, User::getName));

        userMap.entrySet().forEach(System.out::println);
    }

    //    9. Word Frequency Count
//Input:
//List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
//Task: Count frequency of each word and store in a Map<String, Long>.
    public static void countFrequencyAndStoreInMap(List<String> words) {
        Map<String, Long> wordCountMap = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordCountMap.entrySet().forEach(System.out::println);
    }

    //    10. Find Oldest Person
//Input:
//List<Person> people = Arrays.asList(
//    new Person("Adam", 32),
//    new Person("Eve", 45),
//    new Person("John", 28)
//);
//Task: Find the oldest person’s name.
    public static void findOldestPerson(List<Person> personList) {
//        personList.stream()
//                .sorted(Comparator.comparing(Person::getAge).reversed())
//                .limit(1)
//                .forEach(x -> System.out.println(x.getName() + " : " + x.getAge()));
        personList.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(x -> System.out.println(x.getName() + " : " + x.getAge()));
    }

    //11. Find Second Highest Salary
    //Input: Use employees list from Problem 1.
    //Task: Find the employee with the second highest salary.
    public static void findSecondHighestSalary(List<Employee> employeeList) {
//        employeeList.stream()
//                .sorted(Comparator.comparing(Employee::getSalary).reversed())
//                .skip(1)
//                .limit(1)
//                .forEach(x -> System.out.println(x.getName() + " : " + x.getSalary()));
        employeeList.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }

    //12. Longest String in List
//Input:
//List<String> strings = Arrays.asList("cat", "elephant", "tiger", "hippopotamus");
//Task: Find the longest string in the list.
    public static void findLongestString(List<String> strings) {
        Optional<String> first = strings.stream()
                .max(Comparator.comparing(String::length));
        first.ifPresent(System.out::println);
    }
//    13. Merge Two Lists and Remove Duplicates
//Input:
//List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
//List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
//Task: Merge both lists, remove duplicates, and sort in ascending order.

    public static void mergeAndRemoveDuplicate(List<Integer> list1, List<Integer> list2) {

    }

}
