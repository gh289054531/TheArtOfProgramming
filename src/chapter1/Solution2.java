package chapter1;

public class Solution2 {
	private static void Reverse(char[] s, int left, int right) {
		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}

	public static String LeftShift(String s, int n) {
		if (s == null || n > s.length() || n < 0) {
			return s;
		}
		char[] temps = s.toCharArray();
		Reverse(temps, 0, n - 1);
		Reverse(temps, n, s.length() - 1);
		Reverse(temps, 0, s.length() - 1);
		return String.valueOf(temps);
	}

	public static void main(String[] args) {
		System.out.println(LeftShift("", 0));
		System.out.println(LeftShift("s", 0));
		System.out.println(LeftShift("s", 1));
		System.out.println(LeftShift("ab", 0));
		System.out.println(LeftShift("ab", 1));
		System.out.println(LeftShift("ab", 2));
		System.out.println(LeftShift("abc", 0));
		System.out.println(LeftShift("abc", 1));
		System.out.println(LeftShift("abc", 2));
		System.out.println(LeftShift("abc", 3));
	}
}
