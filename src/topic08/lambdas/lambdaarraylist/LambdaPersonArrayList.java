package topic08.lambdas.lambdaarraylist;

import java.util.ArrayList;
import java.util.List;
import lambdaarraylist.Person;

public class LambdaPersonArrayList {

    public static void main(String[] args){
        List<Person> a1 = new ArrayList<>();
        a1.add(new Person(1, "Julian"));
        a1.add(new Person(2, "Manuel"));
        a1.add(new Person(3, "Nico"));
        a1.add(new Person(4, "Ali"));
        a1.add(new Person(5, "Armani"));
        a1.add(new Person(6, "Timati"));

        a1.forEach(a -> System.out.println("id: " + a.getPid() + ", Name: " + a.getName()));
        System.out.println("");
        a1.forEach(a -> a.setName("***" + a.getName() + "***"));

        a1.forEach(a -> System.out.println("id: " + a.getPid() + ", Name: " + a.getName()));
        System.out.println("");
        a1.removeIf(a -> a.getPid() % 2 == 0);

        a1.forEach(a -> System.out.println("id: " + a.getPid() + ", Name: " + a.getName()));
    }
}
