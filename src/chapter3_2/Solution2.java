package chapter3_2;

/**
 * ÑîÊÏ¾ØÕó²éÕÒ
 */
public class Solution2 {

	public static boolean Find(int[][] num, int target) {
		int i = 0;
		int j = num[0].length - 1;
		while (i >= 0 && i < num.length && j >= 0 && j < num[0].length) {
			if (num[i][j] == target) {
				return true;
			} else if (num[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] num = new int[][] { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(Find(num, 6));
		System.out.println(Find(num, 5));
	}

}
