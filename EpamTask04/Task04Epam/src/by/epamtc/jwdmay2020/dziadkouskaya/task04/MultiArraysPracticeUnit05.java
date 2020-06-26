package by.epamtc.jwdmay2020.dziadkouskaya.task04;

/*
найти произведение 2 матриц
*/
public class MultiArraysPracticeUnit05 {
	public static void main(String[] args) {
		int[][] matrix1 = { { 1, 2, 3, 6 }, { 1, 2, 4, 6 }, { 0, 7, 8, 6 }, { 1, 1, -1, -1 } };

		int[][] matrix2 = { { 2, 1 }, { 3, 4 }, { 5, 4 } , {4, 5}};

		String result = showMatrixMultiplicationAnswer(matrix1, matrix2);
		
		System.out.println(result);
	}

	public static int[][] calculateTwoMatrixMultiplication(int[][] matrix1, int[][] matrix2) {
		
		int colomnNumberInMatrix1 = matrix1[0].length;
		
		int rowNumberInMatrix2 = matrix2.length;

		if (colomnNumberInMatrix1 != rowNumberInMatrix2) {
			return null;
		}

		int row = matrix1.length;
		
		int colomn = matrix2[0].length;
		
		int[][] resultMatrix = new int[row][colomn];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colomn; j++) {
				for (int k = 0; k < colomnNumberInMatrix1; k++) {
					resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}
		return resultMatrix;
	}
	
	public static String showMatrixMultiplicationAnswer(int[][] matrix1, int[][] matrix2) {
		
		int [][] resultMatrix = calculateTwoMatrixMultiplication(matrix1, matrix2);
		
		String result = "Decision is \n";
		
		if (resultMatrix != null) {
			for (int i = 0; i < resultMatrix.length; i++) {
				
				for (int j = 0; j < resultMatrix[i].length; j++) {
					
					result += resultMatrix[i][j] + " ";
				}
				
				result += "\n";
			}
		} else {
			result = "No decisions";
		}
		
		return result;
	}

}
