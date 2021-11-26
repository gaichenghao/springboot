package java8.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class Employee {

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lstName;

    public static Predicate<Employee> ageGreatThan70=x->x.getAge()>70;

    public static Predicate<Employee> genderM=x->x.getGender().equals("M");
}
