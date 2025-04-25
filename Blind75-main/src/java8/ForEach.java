package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForEach {
    public static void main(String[] args) {

        Employee e1 = new Employee(2200,"Rishi Sunak");
        Employee e2 = new Employee(3200,"Borris Johnson");
        Employee e3 = new Employee(4200,"Liz Truss");


        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        // code to multiply each salary by factor of 3

        List<Employee>answer = list.stream()
                .map(Employee::multiply)
                .collect(Collectors.toList());

        answer.forEach(p-> {
            System.out.println(p.getSalary());
        });


        // Collect the names into a seperate list

        List<String> namesList = list.stream()
                .map(Employee::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        namesList.forEach(p-> {
            System.out.println(p);
        });


        //filter the salaries greater 3000

        List<Employee>ans = list.stream()
                .filter(p->p.salary>7000)
                .collect(Collectors.toList());

        ans.forEach(p-> {
            System.out.println(p.getSalary());
        });


        // sorting based on the object
        List<Employee>ansq = list.stream().sorted((a,b)->a.name.compareTo(b.name)).collect(Collectors.toList());

        ansq.forEach(p-> {
            System.out.println(p.getName());
        });



    }


}
