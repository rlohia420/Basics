package basic.java8.feature.funcationInterface;

@FunctionalInterface
interface sayable{
    void say(String msz);
}

public class FuncationalInterfaceBasic implements sayable {
    @Override
    public void say(String msz) {
        System.out.println(msz);
    }
    public static void main(String[] args) {
        FuncationalInterfaceBasic fie = new FuncationalInterfaceBasic();
        fie.say("Hello there");
    }
}
//A functional interface can extends another interface only when it does not have any abstract method.
/*
interface sayable{
    void say(String msg);   // abstract method
}
@FunctionalInterface
interface Doable extends sayable{
    // Invalid '@FunctionalInterface' annotation; Doable is not a functional interface
    void doIt();
}
 */