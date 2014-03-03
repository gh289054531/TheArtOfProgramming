package chapter7;

/**
 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/07.0.md
 * @author root
 *
 */
public class Solution3 {

	public static int maxSubArray(int[] num) {
		int max = 0;
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			if (sum + num[i] <= 0) {
				sum = 0;
			} else {
				sum += num[i];
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, -2, 3, -4};
		System.out.println(maxSubArray(a));
	}

}
