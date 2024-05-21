package basic.java8.feature.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        List<Integer> list1 = Arrays.asList(10,20,30,40);
        List<Integer> list2 = Arrays.asList(20,30,60,80);
        List<Integer> resp = list1.stream().filter(list2::contains).collect(Collectors.toList());
        int sum =0;
        int c = list1.stream().reduce(0,(a,b)->a+b);
        System.out.println("SUM********** ="+ c);
        System.out.println(resp);
        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();
       // distinctProject();
        //employeeOf2023();
        //sortFirstNameThenSalary();
        //print3rdHighestSalariedEmployee();
        //printMinimumSalary();
        //printMinimumSalariedEmployeeList();
        //listOfEmployeeWorkingOnMoreThan2Projects();
       // countOfTotalLaptop();
        //fetchTop3SalariedEmployee();
        fetchEmployeeLessThan3TopSalariedEmployee();
    }

    //2. Print full name of any employee whose firstName starts with ‘A’.
    private static void distinctProject(){
       Employee e =  employeeList.stream().filter(x->x.getFirstName().charAt(0)=='A').findFirst().orElse(null);
       System.out.println(e.getFirstName() + e.getLastName());
    }

    // List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)
    private static void employeeOf2023(){
        List<Employee> employeeOf2023 = employeeList.stream().filter(x->x.getId().substring(0,4).equals("2023")).collect(Collectors.toList());
        System.out.println(employeeOf2023);
    }

    //4. Sort employees based on firstName, for same firstName sort by salary.
    private static void sortFirstNameThenSalary(){
        employeeList.sort(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary));
        System.out.println(employeeList);
    }

    //5. Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).
    private static void print3rdHighestSalariedEmployee(){
        List<Integer> salaries = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).map(x->x.getSalary()).collect(Collectors.toList());
        salaries.stream().forEach(System.out::println);
        Employee thirdHighestSalariedEmployee = employeeList.stream().sorted(Comparator.comparing(x->-x.getSalary())).skip(2).findFirst().orElse(null);
        System.out.println("Third highest salary");
        System.out.println(thirdHighestSalariedEmployee);
    }
    //6. print min salary
    private static void printMinimumSalary(){
        int minSalary = employeeList.stream().mapToInt(x->x.getSalary()).min().getAsInt();
        System.out.println(minSalary);
    }

    //7.List of all employee with minimum salary
    private static void printMinimumSalariedEmployeeList(){
        List<Employee> minSalaryEmployee = employeeList.stream().filter(x->x.getSalary()==(employeeList.stream().mapToInt(y->y.getSalary()).min().getAsInt())).collect(Collectors.toList());
        System.out.println(minSalaryEmployee);
    }

    //8. List of people working on more than 2 projects.
    private static void listOfEmployeeWorkingOnMoreThan2Projects(){
        List<Employee> employeeMoreThan2Projects = employeeList.stream().filter(x->x.getProjects().size()>2).collect(Collectors.toList());
        System.out.println(employeeMoreThan2Projects);
    }

    //9. Count of total laptops assigned to the employees.
    private static void countOfTotalLaptop(){
        int laptops = employeeList.stream().mapToInt(x->x.getTotalLaptopsAssigned()).sum();
        System.out.println(laptops);
    }

    //10. Count of all projects with Robert Downey Jr as PM.
    private static void countOfProjectWithRobert(){

    }

    /*11. List of all projects with Robert Downey Jr as PM.

    12. List of all people working with Robert Downey Jr.

    13. Create a map based on this data, they key should be the year of joining, and value should be list of all the employees who joined the particular year.

    14. Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year.

     */

    private static void fetchTop3SalariedEmployee(){
        System.out.println(employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList()));
        System.out.println("Top 3 salaried employees !!!!!");
       List<Employee> topSalariedEmployeeList =  employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(employeeList.size()-3).collect(Collectors.toList());
       System.out.println(topSalariedEmployeeList);
    }

    private static void fetchEmployeeLessThan3TopSalariedEmployee(){
        System.out.println(employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList()));
        System.out.println("Employee having salary less than third highest salaried employee !!!!!");
       // int thirdHighestSalary = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).map(y->y.getSalary()).skip(employeeList.size()-3).findFirst().get();
        List<Employee> employeeSalaryLessThan3rdHighest = employeeList.stream().filter(x->x.getSalary()< (employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).map(y->y.getSalary()).skip(employeeList.size()-3).findFirst().get())).collect(Collectors.toList());
        System.out.println(employeeSalaryLessThan3rdHighest);
    }
}
