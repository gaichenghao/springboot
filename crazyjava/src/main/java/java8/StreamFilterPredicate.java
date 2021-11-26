package java8;

import java8.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterPredicate {
    public static void main(String[] args) {
        Employee e1=new Employee(1,12,"M","Rick","Haha");
        Employee e2=new Employee(2,13,"M","Gc","CH");
        Employee e3=new Employee(3,73,"M","Gc71","CH71");
        Employee e4=new Employee(4,73,"M","Gc71","CH71");
        List<Employee> employees= Arrays.asList(e1,e2,e3,e4);

        /*List<Employee> employeeList = employees.stream()
                .filter(x -> x.getAge() > 70 && x.getGender().equals("M"))
                .collect(Collectors.toList());*/
        List<Employee> employeeList = employees.stream()
                .filter(
                        Employee.ageGreatThan70
                        .or(Employee.genderM)
                        .negate()//否定
                )
                .collect(Collectors.toList());
        System.out.println(employeeList);
    }
}
