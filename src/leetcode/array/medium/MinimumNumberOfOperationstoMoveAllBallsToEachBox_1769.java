package leetcode.array.medium;

public class MinimumNumberOfOperationstoMoveAllBallsToEachBox_1769 {

	public static void main(String args[]) {
		String boxes = "110";
		int[] res = minOperations(boxes);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
	}
	public static int[] minOperations(String boxes) {
		int[] result = new int[boxes.length()];
        char[] eachBox = boxes.toCharArray();
        for(int i=0;i<eachBox.length;i++) {
        	int count = 0;
        	for(int j=0;j<eachBox.length;j++) {
        		if(i!=j && eachBox[j]=='1') {
        			count =count+ Math.abs(j-i);
        		}
        		result[i]=count;
        	}
        }
		return result;
    }
}
