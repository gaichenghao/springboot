package java8;

import java8.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap2 {

    public static void main(String[] args) {
        Employee e1=new Employee(1,12,"M","Rick","Haha");
        Employee e2=new Employee(2,13,"M","Gc","CH");
        Employee e3=new Employee(3,73,"M","Gc71","CH71");
        Employee e4=new Employee(4,73,"M","Gc71","CH71");
        List<Employee> employees= Arrays.asList(e1,e2,e3,e4);

        System.out.println(employees);
        List<Employee> m = employees.stream()
                //创建新对象
                .map(x -> {
                    x.setAge(x.getAge() + 1);
                    x.setGender(x.getGender().equals("M") ? "male" : "female");
                    return x;
                }).collect(Collectors.toList());
        System.out.println(employees);
        List<Employee> m2 = employees.stream()
                //引用类型 特殊的map函数
                .peek(x -> {
                    x.setAge(x.getAge() + 1);
                    x.setGender(x.getGender().equals("M") ? "male" : "female");
                }).collect(Collectors.toList());
        System.out.println(employees);
        System.out.println(m);
    }
}
