import java.util.Arrays;

public class SpiralMatrix {

	public static void main(String[] args) {

		System.out.println(Arrays.deepToString(matrix(2)).replace("], ", "]\n"));
//		System.out.println(Arrays.deepToString(matrix(3)).replace("], ", "]\n"));
//		System.out.println(Arrays.deepToString(matrix(4)).replace("], ", "]\n"));
	}

	public static int[][] matrix(int n) {

		int[][] result = new int[n][n];

		int count = 1;
		int startCol = 0;
		int endCol = n - 1;
		int startRow = 0;
		int endRow = n - 1;

		// preenche de forma incremental
		while (startCol <= endCol && startRow <= endRow) {
			for (int i = startCol; i <= endCol; i++) {
				result[startRow][i] = count;
				count++;
			}

			startRow++;

			// preenche linha por linha de forma decremental
			for (int i = startRow; i <= endRow; i++) {
				result[i][endCol] = count;
				count++;
			}

			// decrementa a coluna
			endCol--;

			// preenche de forma decremental
			for (int i = endCol; i >= startCol; i--) {
				result[endRow][i] = count;
				count++;
			}

			// decrementa a linha
			endRow--;

			// preenche linha por linha de forma incremental
			for (int i = endRow; i >= startRow; i--) {
				result[i][startCol] = count;
				count++;
			}

			// incrementa a coluna
			startCol++;

		}

		return result;
	}
}
