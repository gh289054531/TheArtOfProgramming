package chapter3_2;

public class Solution1 {
	/**
	 * 三数取中值法的快排，最好、平均时间复杂度O(n*logn)，最坏时间复杂度O(n^2)，空间复杂度O(1)
	 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/03.2.md
	 * @param input
	 * @param left
	 * @param right
	 */
	public static <T extends Comparable<? super T>> void Quicksort(T[] input,
			int left, int right) {
		if (right - left < 1) {
			return;
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
			Swap(input, left, right);
			left++;
			right--;
		}
		Swap(input, left, j);
		Quicksort(input, i, left - 1);
		Quicksort(input, left + 1, j);
	}

	private static <T extends Comparable<? super T>> T ChoosePivot(T[] input,
			int left, int right) {
		int center = (left + right) / 2;
		if (input[left].compareTo(input[center]) > 0) {
			Swap(input, left, center);
		}
		if (input[left].compareTo(input[right]) > 0) {
			Swap(input, left, right);
		}
		if (input[center].compareTo(input[right]) > 0) {
			Swap(input, center, right);
		}
		Swap(input, center, right);
		return input[right];
	}

	private static <T extends Comparable<? super T>> void Swap(T[] input,
			int i, int j) {
		T temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public static void main(String[] args) {
		Integer[] test1 = new Integer[] { 213, 123, 432, 54, 56765, 5324, 8768,
				234 };
		Solution1.Quicksort(test1, 0, test1.length - 1);
		for (int i = 0; i < test1.length; i++) {
			System.out.println(test1[i]);
		}
	}

}
