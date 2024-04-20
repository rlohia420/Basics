package basic.java8.feature.funcationInterface;

interface Doable{
    default void doIt(){
        System.out.println("Do it now");
    }
}