package basic.arrays;

public class SpiralMatrix {

	public static void main(String args[]) {
		int[][] arr = { { 1, 2, 3,4 }, { 5, 6,7,8 }, {9,6,3,1 },{0,4,3,7} };
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
		spiralMatrixViaRecursion(0,0,4,4,arr);
	}
	//Desired output is - 1 2 3 6 9 8 7 5 4 spiral matrix
	public static void spiralMatirx(int m , int n , int[][] a) {
		int i, sRow=0,sCol=0,eRow=m, eCol=n;
		while(sRow < eRow && sCol < eCol) {
			for(i=sCol;i<eCol;i++) {
				System.out.print(a[sRow][i] +"->");
			}
			sRow++;
			for(i=sRow;i<eRow;i++) {
				System.out.print(a[i][eCol-1]+"->");
			}
			eCol--;
			if(sRow<eRow) {
				for(i=eCol-1;i>=sCol;i--) {
					System.out.print(a[eRow-1][i]+"->");
				}
				eRow--;
			}
			if(sCol<eCol) {
				for(i =eRow-1;i>=sRow;i--) {
					System.out.print(a[i][sCol]+"->");
				}
				sCol++;
			}
		}
	}
	
	public static void spiralMatrixViaRecursion(int sRow , int sCol , int eRow, int eCol , int[][] a) {
		int i;
		for(i=sCol;i<eCol;i++) {
			System.out.print(a[sRow][i] +"->");
		}
		sRow++;
		for(i=sRow;i<eRow;i++) {
			System.out.print(a[i][eCol-1]+"->");
		}
		eCol--;
		if(sRow<eRow) {
			for(i=eCol-1;i>=sCol;i--) {
				System.out.print(a[eRow-1][i]+"->");
			}
			eRow--;
		}
		if(sCol<eCol) {
			for(i =eRow-1;i>=sRow;i--) {
				System.out.print(a[i][sCol]+"->");
			}
			sCol++;
		}
		
		if(sRow<=eRow && sCol<=eCol) {
			spiralMatrixViaRecursion(sRow,sCol,eRow, eCol,a);
		}
	}
}
















