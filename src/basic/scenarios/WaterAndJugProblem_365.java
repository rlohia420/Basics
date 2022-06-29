package basic.scenarios;

public class WaterAndJugProblem_365 {
	public static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity+jug2Capacity<targetCapacity){
            return false;
        }
        else if(targetCapacity%hcf(jug1Capacity,jug2Capacity)==0){
            return true;
        }
        return false;
    }
    
    static int hcf(int a,int b){
        if(a==0){
            return b;
        }
        return hcf(b%a,a);
    }
    
    public static void main(String args[]) {
    	int jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4;
    	System.out.println(canMeasureWater(jug1Capacity,jug2Capacity,targetCapacity));
    	System.out.println("hcf = "+hcf(14,4));
    }
}
