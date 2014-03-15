package chapter16;

public class Solution2 {

	public static <T extends Comparable<? super T>> boolean NextPermutation(T[] s) {
		if (s == null || s.length <= 1) {
			return false;
		}
		int i = s.length - 2;
		for (; i >= 0; i--) {
			if (s[i].compareTo(s[i + 1]) < 0) {
				break;
			}
		}
		if (i < 0) {
			return false;
		}
		int j = s.length - 1;
		for (; j > i; j--) {
			if (s[j].compareTo(s[i]) > 0) {
				break;
			}
		}
		T t = s[i];
		s[i] = s[j];
		s[j] = t;
		Reverse(s, i + 1, s.length - 1);
		return true;
	}

	public static <T extends Comparable<? super T>> void Reverse(T[] s, int begin, int end) {
		while (begin < end) {
			T t = s[begin];
			s[begin] = s[end];
			s[end] = t;
			begin++;
			end--;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] test = new Integer[] { 1, 2, 3, 4 };
		while (NextPermutation(test)) {
			for (Integer i : test) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
