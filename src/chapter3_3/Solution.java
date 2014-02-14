package chapter3_3;

import java.util.Arrays;

public class Solution {
	public static void Preprocess(Element[] input) throws Exception {
		if (input == null || input.length == 0) {
			throw new Exception("Input array error!");
		}
		Arrays.sort(input);
	}

	/**
	 * 
	 * @param input
	 * @param left
	 * @param right
	 * @param k
	 *            µÚkÐ¡
	 * @return
	 */
	public static Element Choose(Element[] input, int left, int right, int k) {
		int elementNumInRange = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i].index >= left && input[i].index <= right) {
				elementNumInRange++;
			}
			if (elementNumInRange == k) {
				return input[i];
			}
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		Integer[] input = new Integer[] { 1, 5, 2, 6, 3, 7, 4 };
		Element[] result = Element.ChangeToArray(input);
		Solution.Preprocess(result);
		Element kth1 = Solution.Choose(result, 2, 5, 3);
		System.out.println(kth1.data);
		Element kth2 = Solution.Choose(result, 3, 6, 3);
		System.out.println(kth2.data);
	}
}

class Element<T extends Comparable<? super T>> implements
		Comparable<Element<T>> {
	T data;
	int index;

	public Element(T data, int index) {
		this.data = data;
		this.index = index;
	}

	@Override
	public int compareTo(Element<T> o) {
		if (this.data.compareTo(o.data) > 0) {
			return 1;
		} else if (this.data.compareTo(o.data) < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	public static Element[] ChangeToArray(Comparable[] originDataArray) {
		if (originDataArray == null || originDataArray.length == 0) {
			return null;
		}
		Element[] result = new Element[originDataArray.length];
		for (int i = 0; i < originDataArray.length; i++) {
			result[i] = new Element(originDataArray[i], i + 1);
		}
		return result;
	}
}
