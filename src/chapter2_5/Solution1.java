package chapter2_5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *寻找和为定值的多个数
 */
public class Solution1 {
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void cal(int sum, int n) {
		if (sum <= 0 || n <= 0) {
			return;
		}
		for (int i = n; i > 0; i--) {
			if (i == sum) {
				list.add(i);
				System.out.println(list.toString());
				list.remove(list.size() - 1);
			} else if (i < sum) {
				list.add(i);
				cal(sum - i, i - 1);
				list.remove(list.size() - 1);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		cal(m, n);
		sc.close();
	}

}
