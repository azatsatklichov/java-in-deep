package net.sahet.utils;

public class ArrayUtil {

	public static void print2DArray(int[][] myArray) {
		for (int i = 0; i < myArray.length; i++) {
			int[] js = myArray[i];
			if (js != null) {
				for (int j = 0; j < js.length; j++) {
					int arr = js[j];
					System.out.print(arr + " ");
				}
			}
			System.out.println();

		}
	}

	public static void print2DMatrix(int[][] grid) {
		for (int r = 0; r < grid.length; r++) {
			int[] arr1D = grid[r];
			if (arr1D != null) {
				for (int c = 0; c < arr1D.length; c++)
					System.out.print(grid[r][c] + " ");
			}
			System.out.println();
		}
	}

	public static void fill2DArray(int[][] myArray, int defaultValue, int diagValue) {
		for (int i = 0; i < myArray.length; i++) {
			int[] js = myArray[i];
			if (js != null) {
				for (int j = 0; j < js.length; j++) {
					if (i == j)
						myArray[i][j] = diagValue;
					else
						myArray[i][j] = defaultValue;
				}
			}
		}
	}

}
