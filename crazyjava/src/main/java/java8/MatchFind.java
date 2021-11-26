package java8;

import java8.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MatchFind {
    public static void main(String[] args) {
        List<Integer> numbers=Arrays.asList(1,2,3,4,5);
        Integer total = numbers.stream().reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(total);
        total = numbers.stream().reduce(0, Integer::sum);
        System.out.println(total);

        List<String> letters=Arrays.asList("a","b","c","d","e");
        String lett = letters.stream().reduce("a", (a, b) -> a + b);
        System.out.println(lett);
        lett = letters.stream().reduce("", String::concat);
        System.out.println(lett);




        Employee e1=new Employee(1,12,"M","Rick","Haha");
        Employee e2=new Employee(2,13,"M","Gc","CH");
        Employee e3=new Employee(3,73,"M","Gc71","CH71");
        Employee e4=new Employee(4,73,"M","Gc71","CH72");
        List<Employee> employees= Arrays.asList(e1,e2,e3,e4);


        Integer reduce = employees.stream().map(Employee::getAge).reduce(0, Integer::sum,Integer::sum);//合并器
        System.out.println(reduce);

        Integer integer = employees.stream().reduce(0, (subtotal, emp) -> subtotal + emp.getAge(), Integer::sum);
        System.out.println(integer);


        //是否大于70
        //for循环

        boolean b = employees.stream().anyMatch(e -> e.getAge() > 70);
        System.out.println(b);

        boolean b1 = employees.stream().anyMatch(Employee.ageGreatThan70);
        System.out.println(b1);

        boolean b2 = employees.stream().allMatch(e -> e.getAge() > 12);
        System.out.println(b2);

        boolean b3 = employees.stream().noneMatch(e -> e.getAge() < 10);
        System.out.println(b3);

        Optional<Employee> optionalEmployee = employees.stream().filter(x -> x.getAge() > 70).findFirst();
        System.out.println(optionalEmployee.get());

        boolean present = employees.stream().filter(x -> x.getAge() > 80).findFirst().isPresent();
        System.out.println(present);
        //是否存在
        employees.stream().filter(x -> x.getAge() > 60).findFirst().ifPresent(e-> System.out.println(e));

        //默认值
        Employee employee = employees.stream().filter(x -> x.getAge() > 80).findFirst()
                .orElse(new Employee(1, 1, "M", "zhang", "san"));
        System.out.println(employee);


        Optional<Employee> optionalEmployee2 = employees.stream().filter(x -> x.getAge() > 70).findAny();
        System.out.println(optionalEmployee2.get());



    }
}
