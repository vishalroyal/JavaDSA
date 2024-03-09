package ComparatorLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {

    public static void main(String args[])
    {
        List<Employee1> comparrator =new ArrayList<>();
        comparrator.add(new Employee1("Vishal",473));
        comparrator.add(new Employee1("Abhay",456));
        comparrator.add(new Employee1("Bhau",416));
        System.out.println(comparrator);
        Collections.sort(comparrator);
        System.out.println(comparrator);


        List<Employee2> comparrator1 =new ArrayList<>();
        comparrator1.add(new Employee2("Bhau",567, 5400.00));
        comparrator1.add(new Employee2("Abhay",517, 3400.00));
        comparrator1.add(new Employee2("Vishal",534, 4400.00));

        System.out.println(comparrator1);
        Collections.sort(comparrator1,new SalaryComparator());
        System.out.println(comparrator1);

    }

}
