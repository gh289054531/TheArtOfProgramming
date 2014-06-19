package chapter3_3;

/**
 * 找出出现次数刚好是一半的数字
 */
public class Solution_extend {

	public static int Find(int[] input) throws Exception {
		if (input == null || input.length == 0) {
			throw new Exception("Input error");
		}
		int candidate = 0;
		int ntimes = 0;
		for (int i = 0; i < input.length; i++) {
			if (ntimes == 0) {
				candidate = input[i];
				ntimes = 1;
			} else {
				if (candidate == input[i])
					ntimes++;
				else
					ntimes--;
			}
		}
		int candidate2 = input[input.length - 1];
		if (candidate == candidate2) {
			return candidate;
		} else {
			ntimes = 0;
			for (int i = 0; i < input.length; i++) {
				if (input[i] == candidate) {
					ntimes++;
				}
			}
			return ntimes * 2 == input.length ? candidate : candidate2;
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		int[] a1 = { 1, 2, 1, 3, 4, 1 };
		System.out.println(Find(a1));
		int[] a2 = { 1, 2, 1, 1, 3, 4 };
		System.out.println(Find(a2));
		int[] a3 = { 1, 2, 1, 3, 1, 4 };
		System.out.println(Find(a3));
		int[] a4 = { 1, 2, 3, 4, 1, 1 };
		System.out.println(Find(a4));

	}

}
