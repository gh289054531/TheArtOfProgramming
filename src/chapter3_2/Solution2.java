package chapter3_2;

import java.util.Arrays;

public class Solution2 {
	private static int Delt = 10;

	/**
	 * 五分中项的中项快速选择，平均时间复杂度O(n)，最坏时间复杂度O(n^2)最坏情况几乎不出现，空间复杂度O(1)
	 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/03.2.md
	 * @param input
	 * @param left
	 * @param right
	 */
	public static <T extends Comparable<? super T>> T QuickSelect(T[] input,
			int left, int right, int k) {
		if (right - left + 1 < Delt) {
			InsertionSort(input, left, right);
			return input[k - 1];
		}
		int i = left, j = right;
		T pivot = ChoosePivot(input, left, right);
		while (left < right) {
			while (input[left].compareTo(pivot) < 0) {
				left++;
			}
			while (input[right].compareTo(pivot) > 0) {
				right--;
			}
			Swap(input, left++, right--);
		}
		if (k <= left) {
			return QuickSelect(input, i, left - 1, k);
		} else if (k >= left + 2) {
			return QuickSelect(input, left + 1, j, k);
		} else {
			return input[left + 1];
		}
	}

	private static <T extends Comparable<? super T>> void InsertionSort(
			T[] input, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			T temp = input[i];
			int j = i - 1;
			for (; j >= left && temp.compareTo(input[j]) < 0; j--) {
				input[j + 1] = input[j];
			}
			input[j + 1] = temp;
		}
	}

	private static <T extends Comparable<? super T>> T ChoosePivot(T[] input,
			int left, int right) {
		if (left == right)
			return input[left];
		T[] medians = (T[]) new Comparable[(right - left + 1) / 5 + 1];
		int mediansNum = 0;
		int index = left;
		for (; index + 4 <= right; index += 5) {
			InsertionSort(input, index, index + 4);
			medians[mediansNum++] = input[index + 2];
		}
		if (index != right + 1) {
			InsertionSort(input, index, right);
			medians[mediansNum++] = input[index + (right - index) / 2];
		}
		return ChoosePivot(medians, 0, mediansNum - 1);
	}

	private static <T extends Comparable<? super T>> void Swap(T[] input,
			int i, int j) {
		T temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public static void main(String[] args) {
		Integer[] test1 = new Integer[] { 3, 7, 8, 21, 23, 23, 32, 34, 36, 46,
				54, 58, 87, 123, 213, 213, 234, 324, 432, 432, 543, 543, 543,
				653, 876, 987, 4865, 5324, 7645, 8768, 56765 };
		for (int i = 0; i < test1.length; i++) {
			System.out.println(Solution2.QuickSelect(test1, 0,
					test1.length - 1, i + 1));
			Arrays.sort(test1);
		}
	}
}
