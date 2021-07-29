package basic.integerMix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextGreaterNumber {
	// wrong program
	private void swap(int[] number, int i, int j) {
		int temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}

	private void sortSubarray(int[] number, int i, int j) {
		// for this sub-array, all the digits would be in there reverse sorted position
		while (i < j) {
			swap(number, i, j);
			i += 1;
			j -= 1;
		}
	}

	public void findNextGreaterNumber(int[] number) {// [6, 9, 3, 8, 6, 5, 2]
		int lastDigitSeen = number[number.length - 1], i, j;
		for (i = number.length - 2; i >= 0; i--) {
			// if this digit is where the sorted ordering breaks
			if (lastDigitSeen > number[i]) {
				break;
			}
			lastDigitSeen = number[i];
		}

		if (i >= 0) // we found the digit breaking the sorted ordering
		{
			// find the next greater digit in the right sub-array from number[i+1 to end]
			for (j = number.length - 1; j > i; j--) {
				if (number[j] > number[i]) {
					break;
				}
			}

			// swap digits at indices 'i' and 'j'
			swap(number, i, j);

			// sort the sub-array - number[i+1 to end]
			sortSubarray(number, i + 1, number.length - 1);
		}
	}

	public static void main(String[] args) {
		NextGreaterNumber solution = new NextGreaterNumber();
		
		int[] number = { 6, 9, 3, 8, 6, 5, 2 };

		// solution.findNextGreaterNumber(number);
		int[] test = solution.nextGreaterElement(number);
		System.out.println("Next greater number is: ");
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]);
		}
	}

	public int[] nextGreaterElement(int[] array) {
		int length = array.length;
		int index = -1;
        for (int i = 0; i < length-1; i++) {
             if(array[length-i-2]<array[length-i-1]) {
                  index = length-i-2;
                  break;
             }
        }
       
        /** If no index found then greater number is no possible. */
        if(index==-1) {
             System.out.println("No possible sequence !!");
             return null;
        }
       
        int smallMaxIdx = index+1;
        for (int i = index+2; i < length; i++) {
             if(array[smallMaxIdx]>array[i]) {
                  smallMaxIdx = i;
             }
        }
        int temp = array[index];
        array[index] = array[smallMaxIdx];
        array[smallMaxIdx] = temp;
       
        Arrays.sort(array, index+1, length);
       
        return array;
       
	}
}
