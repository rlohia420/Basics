package basic.arrays;

public class IsFlipToZero {
	public static void main(String args[]) {
		int[][] arr = {{0,0,1,0,0},
					   {0,0,1,0,0},
					   {0,0,1,0,0},
					   {1,1,0,1,1},
					   {0,0,1,0,0}};
		System.out.println(canFlipToZero(arr));
	}
	public static boolean canFlipToZero(int[][] arr) {
		int m = arr.length ; int n=arr[0].length;
		for(int i=0;i<m;i++) {
			if(arr[i][0]==0)
				continue;
			for(int j=0;j<n;j++) {
				arr[i][j]^=1;
			}
		}
		for(int i=0;i<n;i++) {
			if(arr[0][i]==0)
				continue;
			for(int j=0;j<m;j++) {
				arr[j][i]^=1;
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1)
					return false;
			}
		}
		return true;
	}
}
