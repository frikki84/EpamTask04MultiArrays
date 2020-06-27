package by.epamtc.jwdmay2020.dziadkouskaya.task04;

import java.util.ArrayList;
import java.util.Arrays;


public class MultiArraysPracticeUnit06 {

	public static void main(String[] args) {
		
		ArrayList<String> mainList = createMagicSquare(3);
		
		System.out.println("Количество решений: " + mainList.size());
		
		for (String item : mainList) {
			System.out.println(item);
		}

	}

	public static ArrayList<String> createMagicSquare(int number) {

		int[] magicSquare = createArrayForMagicsquare(number);
		
		int maxvalue = (int) Math.pow(number, 2);

		int lineSum = (number * (maxvalue + 1)) / 2;

		ArrayList<String> mainList = new ArrayList<>();
		

		while (arrayElementionsPermutation(magicSquare)) {
			

			if (calcAllRowSum(number, magicSquare, lineSum) && calcAllColomnSum(number, magicSquare, lineSum)
					&& calcAllDiagonalSum(number, magicSquare, lineSum)) {
				
				String decicion = Arrays.toString(magicSquare);
				
				mainList.add(decicion);
				
			}
		}
	
		return mainList;

	}

	public static int[] createArrayForMagicsquare(int number) {
		int maxValue = (int) Math.pow(number, 2);

		int[] resultArray = new int[maxValue];

		for (int i = 0; i < resultArray.length; i++) {
			resultArray[i] = i + 1;
		}

		return resultArray;

	}

	public static boolean arrayElementionsPermutation(int[] array) {

		int length = array.length;

		int prelastIndex = length - 2;

		int lastIndex = length - 1;

		while (prelastIndex != -1 && array[prelastIndex] >= array[prelastIndex + 1]) {
			prelastIndex--;
		}

		if (prelastIndex == -1) {
			return false;

		}

		while (array[prelastIndex] >= array[lastIndex]) {
			lastIndex--;
		}
		swapElements(array, prelastIndex, lastIndex);

		int nextNumber = prelastIndex + 1;
		int newLength = length - 1; // сортируем оставшуюся часть последовательности
		while (nextNumber < newLength)
			swapElements(array, nextNumber++, newLength--);

		return true;
	}

	public static void swapElements(int[] array, int index, int nextIndex) {
		int middleNumber = array[index];
		array[index] = array[nextIndex];
		array[nextIndex] = middleNumber;
	}

	public static boolean calcAllRowSum(int n, int[] array, int lineSum) {
		boolean result = true;
		for (int i = 1; i <= n; i++) {
			if (calcOneRowSum(n, array, i) != lineSum) {
				result = false;
				break;
			}
		}

		return result;
	}

	public static int calcOneRowSum(int n, int[] array, int lineNumber) {
		int sum = 0;
		int firstIndex = (lineNumber - 1) * n;
		int lastIndex = lineNumber * n;

		for (int i = firstIndex; i < lastIndex; i++) {
			sum += array[i];
		}

		return sum;
	}

	public static boolean calcAllColomnSum(int n, int[] array, int lineSum) {
		boolean result = true;
		for (int i = 1; i <= n; i++) {
			if (calcOneColomnSum(n, array, i) != lineSum) {
				result = false;
				break;
			}
		}

		return result;
	}

	public static int calcOneColomnSum(int n, int[] array, int lineNumber) {
		int sum = 0;
		int firstIndex = lineNumber - 1;
		int lastIndex = firstIndex + n * (n - 1);

		for (int i = firstIndex; i <= lastIndex; i += n) {
			sum += array[i];
		}

		return sum;
	}

	public static boolean calcAllDiagonalSum(int n, int[] array, int lineSum) {
		boolean result = true;
		if (calcLeftDiagonalSum(n, array) != lineSum && calcRightDiagonalSum(n, array) != lineSum) {
			result = false;

		}

		return result;
	}

	public static int calcLeftDiagonalSum(int n, int[] array) {
		int sum = 0;
		int firstIndex = 0;
		int lastIndex = array.length - 1;

		for (int i = firstIndex; i <= lastIndex; i += (n + 1)) {
			sum += array[i];
		}

		return sum;
	}

	public static int calcRightDiagonalSum(int n, int[] array) {
		int sum = n - 1;
		int firstIndex = 0;
		int lastIndex = array.length - n - 1;

		for (int i = firstIndex; i < lastIndex; i += (n + 1)) {
			sum += array[i];
		}

		return sum;
	}

}
