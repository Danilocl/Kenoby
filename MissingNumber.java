import java.util.Arrays;

public class MissingNumber {

	static int[] missingNumbers = new int[10];

	public static void main(String[] args) {
		int[] array = { 4, 9, 2, 5, 4, 2, 3, 4 };
//		int[] array = { 32, 47, 41, 7, 47, 9, 36, 32, 20, 15, 11, 9, 6, 37, 9, 39, 45, 29, 29, 19, 28, 21, 50, 19, 43 };

		System.out.println(Arrays.toString(compare(array, 0, 10)));
	}

	public static int[] compare(int[] array, int min, int max) {

		for (int i = min; i < max; i++) {

			missingNumbers[i] = i + 1;
		}

		for (int i : array) {
			for (int j : missingNumbers) {
				if (i == j) {
					remove(missingNumbers, j);
				}
			}
		}

		return missingNumbers;
	}

	public static int[] remove(int[] array, int index) {

		// Se não houver alterações ele apenas retorna o array
		if (array == null) {

			return array;
		}

		// cria um novo array menor que o original
		int[] copyArray = new int[array.length - 1];

		for (int i = 0, k = 0; i < array.length; i++) {

			// se o index for o elemento a ser removido ele volta para o for
			if (array[i] == index) {
				continue;
			}

			// copia o elemento caso ele não seja o elemento a ser removido
			copyArray[k++] = array[i];
		}

		missingNumbers = copyArray;

		return copyArray;
	}
}
