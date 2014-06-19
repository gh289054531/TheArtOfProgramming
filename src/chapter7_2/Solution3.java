package chapter7_2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 最短摘要的生成
 */
public class Solution3 {

	public static void GetAbstract(String[] s, String[] q) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String temp : q) {
			map.put(temp, 0);
		}
		ArrayList<KW> keyword = new ArrayList<KW>();
		for (int i = 0; i < s.length; i++) {
			if (map.containsKey(s[i])) {
				keyword.add(new KW(s[i], i));
			}
		}
		int start = 0;
		int end = keyword.size();
		int i = 0;
		int begin = 0;
		int count = q.length;
		while (i < keyword.size()) {
			while (i < keyword.size() && count > 0) {
				if (map.get(keyword.get(i).data) == 0) {
					map.put(keyword.get(i).data, 1);
					count--;
				} else {
					map.put(keyword.get(i).data, map.get(keyword.get(i).data) + 1);
				}
				i++;
			}
			while (map.get(keyword.get(begin).data) > 1) {
				map.put(keyword.get(begin).data, map.get(keyword.get(begin).data) - 1);
				begin++;
			}
			if (keyword.get(i - 1).index - keyword.get(begin).index < keyword.get(end - 1).index - keyword.get(start).index) {
				start = begin;
				end = i;
			}
			count++;
			map.put(keyword.get(begin).data, 0);
			begin++;
		}
		for (i = keyword.get(start).index; i <= keyword.get(end - 1).index; i++) {
			System.out.println(s[i]);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = new String[] { "w0", "w1", "w2", "w3", "q0", "w4", "w5", "q1", "w6", "w7", "w8", "q0", "w9", "q1" };
		String[] q = new String[] { "q0", "q1" };
		GetAbstract(s, q);
	}
}

class KW {
	String data;
	int index;

	public KW(String data, int index) {
		this.data = data;
		this.index = index;
	}
}