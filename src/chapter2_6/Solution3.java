package chapter2_6;

/**
 * 求连续子数组的最大和
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
		int a[] = { 1, -2, 3, -4 };
		System.out.println(maxSubArray(a));
	}

}
