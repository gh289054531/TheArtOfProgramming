package chapter2_3;

/**
 * 求解 500 万以内的亲和数
 */
public class Solution1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sum = new int[5000001];

		// 时间复杂度O(N*logN)
		for (int i = 1; i + i <= 5000000; i++) {
			int j = i + i;
			for (; j <= 5000000; j += i) {
				sum[j] += i;
			}
		}
		for (int i = 1; i <= 5000000; i++) {
			if (sum[i] > i && sum[i] <= 5000000 && sum[sum[i]] == i) {
				System.out.println(i + " " + sum[i]);
			}
		}
	}

}
