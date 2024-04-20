package basic.java8.feature.funcationInterface;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface Square {
    int calculate(int x);
}

class Test {
    public static void main(String args[])
    {
        int a = 5;
        // lambda expression to define the calculate method
        Square s = (int x) -> x * x;
        // parameter passed and return type must be
        // same as defined in the prototype
        int ans = s.calculate(a);
        System.out.println(ans);


        //Using predicate functional interface
        // create a list of strings
        List<String> names = Arrays.asList(
                "Geek", "GeeksQuiz", "g1", "QA", "Geek2");

        // declare the predicate type as string and use
        // lambda expression to create object
        Predicate<String> p = (x) -> x.startsWith("G");

        // Iterate through the list
        for (String st : names) {
            // call the test method
            if (p.test(st))
                System.out.println(st);
        }
    }
}