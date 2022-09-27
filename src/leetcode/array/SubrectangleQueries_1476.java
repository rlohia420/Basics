package leetcode.array;

public class SubrectangleQueries_1476 {
	int[][] rectangle ;
	public SubrectangleQueries_1476(int[][] rectangle) {
		this.rectangle = rectangle;
	}

	public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
		for(int i=row1;i<=row2;i++) {
			for(int j=col1;j<=col2;j++) {
				rectangle[i][j] = newValue;
			}
		}
	}

	public int getValue(int row, int col) {
		
		return rectangle[row][col];
	}
	
	public static void main(String args[]) {
		int[][] rectangle = {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
		SubrectangleQueries_1476 obj = new SubrectangleQueries_1476(rectangle);
		obj.updateSubrectangle(0,0,3,2,5);
		int param_2 = obj.getValue(0,2);
		
		int rowCount = rectangle.length;
		int colCount = rectangle[0].length;
		for(int i=0;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				System.out.print(rectangle[i][j]);
			}
			System.out.println();
		}
	}
}
