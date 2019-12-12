package basic.pattern;

public class Patterns {
	public static void main(String args[]) {
		System.out.println("========leftInclinedTriangle===========");
		leftInclinedTriangle();
		System.out.println("========rightInclinedTriangle==========");
		rightInclinedTriangle();
		System.out.println("========upperTriangle==========");
		upperTriangle();
		System.out.println("========1to15DigitsTriangle==========");
		digitedTriangle();
		System.out.println("========upperDigitedTriangle==========");
		upperDigitedTriangle();
		System.out.println("========leftTriangle==========");
		leftTriangle();
	}

	private static void leftInclinedTriangle() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	private static void rightInclinedTriangle() {
		for (int i = 0; i < 4; i++) {
			for (int j = 4; j > i + 1; j--)
				System.out.print(" ");
			for (int k = 0; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	private static void upperTriangle() {
		for(int i=0;i<5;i++) {
			for(int k=5;k>i;k--) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			if(i>1) {
				for(int l=i-1;l>=1;l--) {
					System.out.print("*");
				}
			}System.out.println("");
		}
	}
	private static void digitedTriangle() {
		int n=1;
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(n+" ");
				n++;
			}System.out.println();
		}
	}
	private static void upperDigitedTriangle() {
		for(int i=1;i<5;i++) {
			for(int j=5;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=i;k>=1;k--) {
				System.out.print(k);
			}if(i>1) {
				for(int l=2;l<=i;l++) {
					System.out.print(l);
				}
			}System.out.println("");
		}
	}
	private static void leftTriangle() {
		for(int i=1;i<5;i++) {
			for(int j=5;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print(k);
			}System.out.println("");
		}
			for(int i=3;i>=1;i--) {
				for(int j=4;j>=i;j--) {
					System.out.print(" ");
				}
				for(int k=1;k<=i;k++) {
					System.out.print(k);
				}System.out.println("");
			}
	}
}
