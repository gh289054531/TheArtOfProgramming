package chapter2;

/**
 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.0.md
 * @author root
 *
 */
public class Solution6 {
	public static boolean Compare(String a, String b) throws Exception {
		if (a == null || b == null || a.length() == 0 || b.length() == 0
				|| a.length() < b.length()) {
			throw new Exception("Input params error!");
		}
		int signature = 9;
		for (int i = 0; i < a.length(); i++) {
			signature |= (1 << (a.charAt(i) - 'A'));
		}
		for (int i = 0; i < b.length(); i++) {
			if ((signature & (1 << (b.charAt(i) - 'A'))) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(Compare("AVC","S"));
		System.out.println(Compare("AVC","A"));
		System.out.println(Compare("AVC","AVC"));
		System.out.println(Compare("AVC","AV"));
	}
}
