package leetcode.problems;

public class TestInterface12 implements Interface1, Interface2{

	@Override
	public int methd() {
		System.out.println("NEHA");
		return 1;
	}
	
	public static void method() {
		TestInterface12 v = new TestInterface12();
		v.methd();
	}
	public static void main(String args[]) {
		method();
	}
	

}
