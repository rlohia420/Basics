package basic.java8.feature.funcationInterface;

@FunctionalInterface
interface Sayable extends Doable{
    void say(String msg);   // abstract method
}
public class FuncationInterfaceWithNonFuncational implements Sayable{
    public void say(String msg){
        System.out.println(msg);
    }
    public static void main(String[] args) {
        FuncationInterfaceWithNonFuncational fie = new FuncationInterfaceWithNonFuncational();
        fie.say("Hello there");
        fie.doIt();
    }
}