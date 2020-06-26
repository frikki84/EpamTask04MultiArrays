package by.epamtc.jwdmay2020.dziadkouskaya.task04;

public class MultiArraysPracticeUnit04 {
	public static void main(String[] args) {
		int [] array = {1, 2, 3, 4, 5, 7, -5};
		
		double [][] matrix = createSquareNOrderMatrix(array);
	
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.printf("%6.0f " , matrix[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static double [][] createSquareNOrderMatrix(int [] array) {
		int matrixLength = array.length;
		
		double [][] matrix = new double [matrixLength][matrixLength];
		
		for (int i = 0; i < matrixLength; i ++) {
			
			for (int j = 0; j < matrixLength; j ++) {
				
				int pow = i +1;
				matrix[i][j] = Math.pow(array[j], pow);
			}
		}
		
		
		return matrix;
		
		
	}

}
