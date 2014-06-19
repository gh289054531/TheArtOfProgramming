package chapter5_1;

/**
 * 最长公共子序列(LCS)问题
 */
public class Solution {

	public static void LCS(String a, String b) {
		if (a == null || b == null) {
			return;
		}
		int[][] len = new int[a.length()][b.length()];
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (i == 0 || j == 0) {
					if (a.charAt(i) == b.charAt(j)) {
						len[i][j] = 1;
					}
				} else {
					if (a.charAt(i) == b.charAt(j)) {
						len[i][j] = len[i - 1][j - 1] + 1;
					} else {
						len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
					}
				}
			}
		}
		int i = 0, j = 0;
		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) == b.charAt(j)) {
				System.out.println(a.charAt(i));
				i++;
				j++;
			} else {
				if (i + 1 < a.length() && j + 1 < b.length()) {
					if (len[i + 1][j] > len[i][j + 1]) {
						i++;
					} else {
						j++;
					}
				} else if (i + 1 >= a.length() && j + 1 < b.length()) {
					j++;
				} else if (i + 1 < a.length() && j + 1 >= b.length()) {
					i++;
				} else {
					break;
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcbdab";
		String b = "bdcaba";
		LCS(a, b);
	}

}
