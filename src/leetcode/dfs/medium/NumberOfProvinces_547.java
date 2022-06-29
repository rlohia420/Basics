package leetcode.dfs.medium;

public class NumberOfProvinces_547 {

	public static int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		int nums = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(isConnected, visited, i);
				nums++;
			}
		}

		return nums;
	}

	private static void dfs(int[][] isConnected, boolean[] visited, int i) {
		int n = isConnected.length;
		for (int j = 0; j < n; j++) {
			if (visited[j] == false && isConnected[i][j] == 1) {
				visited[j] = true;
				dfs(isConnected, visited, i);
			}
		}
	}

	public static void main(String args[]) {
		//int[][] isConnected = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		int[][] isCon = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(findCircleNum1(isCon));
	}

	public static int findCircleNum1(int[][] arr) {
		int count =0;
		int n= arr.length-1;
		int m = arr[0].length-1;
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				if(arr[i][j]!=0)
					if(isConnected(arr , i , j , n ,m)>1)
							count++;
			}
		}
		return count;
	}
	private static int isConnected(int[][] arr , int i, int j , int n , int m) {
		if(i<0 || j<0||i>n||j>m) {
			return 0;
		}
		if(arr[i][j]==0) {
			return 1;
		}arr[i][j]=0;
		int a = isConnected(arr,i+1,j,n,m);
		int b = isConnected(arr,i-1,j,n,m);
		int c = isConnected(arr,i,j+1,n,m);
		int d = isConnected(arr,i,j-1,n,m);
		return a+b+c+d;
	}
	
}
