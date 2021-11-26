package java8;

import java8.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortList {

    public static void main(String[] args) {
        List<String> players = Arrays.asList("tom", "token", "lucy", "Lili", "kit");

        System.out.println(players);

        players.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(players);
        players.sort(Comparator.naturalOrder());
        System.out.println(players);


        Employee e1=new Employee(1,13,"M","Rick","Haha");
        Employee e2=new Employee(2,12,"M","Gc","CH");
        Employee e3=new Employee(3,73,"F","Gc71","CH71");
        Employee e4=new Employee(4,73,"M","Gc71","CH71");
        List<Employee> employees= Arrays.asList(e1,e2,e3,e4);
        employees.sort(
                Comparator.comparing(Employee::getGender)
                        .thenComparingInt(Employee::getAge)
                        .reversed()
        );
        //都是正序，不加reversed
        //都是倒序，最后面加一个reversed
        //先是倒序（加reversed），然后正序
        //先是正序（加reversed），然后倒序（加reversed）
        employees.forEach(System.out::println);

        System.out.println("------------------------------------");
/*        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.getAge()==o2.getAge()){
                    return 0;
                }
                return o1.getAge()-o2.getAge()>0?-1:1;
            }
        });*/
        employees.sort((o1,o2) ->{
                if(o1.getAge()==o2.getAge()){
                    return 0;
                }
                return o1.getAge()-o2.getAge()>0?-1:1;
            });
        employees.forEach(System.out::println);

    }
}
