package chapter5;

import java.util.Scanner;

/**
 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/05.0.md
 * @author root
 *
 */
public class Solution_extend1 {

	public static void LIS(int[] num, int[] len) {
		for (int i = 0; i < num.length; i++) {
			len[i] = 1;
			for (int j = 0; j < i; j++) {
				if (num[j] <= num[i] && len[i] < len[j] + 1) {
					len[i] = len[j] + 1;
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] temp = sc.nextLine().split(" ");
		int[] num = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			num[i] = Integer.parseInt(temp[i]);
		}
		sc.close();
		int[] len1 = new int[temp.length];
		LIS(num, len1);
		int i = 0, j = num.length - 1;
		while (i < j) {
			int t = num[i];
			num[i] = num[j];
			num[j] = t;
			i++;
			j--;
		}
		int[] len2 = new int[temp.length];
		LIS(num, len2);
		int max = 0;
		for (i = 0; i < num.length; i++) {
			int m = len1[i] + len2[num.length - 1 - i] - 1;
			if (m > max) {
				max = m;
			}
		}
		System.out.println(temp.length - max);
	}

}
