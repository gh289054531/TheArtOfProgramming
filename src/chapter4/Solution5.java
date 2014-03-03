package chapter4;

import java.util.Arrays;

/**
 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/04.0.md
 * @author root
 *
 */
public class Solution5 {
	/**
	 * 
	 * @param input
	 *            ±ÿ–Î”––Ú
	 * @param sum
	 * @return
	 */
	public static int[] FindSum(int[] input, int sum) {
		if (input == null || input.length < 2) {
			return null;
		}
		int i = 0, j = input.length - 1;
		while (i < j) {
			int tempSum = input[i] + input[j];
			if (tempSum < sum) {
				i++;
			} else if (tempSum > sum) {
				j--;
			} else {
				return new int[] { input[i], input[j] };
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 4, 7, 11, 15 };
		int[] result = Solution5.FindSum(input, 15);
		System.out.println(Arrays.toString(result));
	}
}
