package chapter3_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/
 * ebook/zh/03.1.md
 * 
 * @author root
 * 
 */
public class Solution {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src\\chapter3_1\\input.txt"));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (map.containsKey(s) == false) {
				map.put(s, 1);
			} else {
				map.put(s, map.get(s) + 1);
			}
		}
		sc.close();
		PriorityQueue<Element> pq = new PriorityQueue<Element>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			Element e = new Element(entry.getKey(), entry.getValue());
			pq.add(e);
		}
		for (int i = 0; i < 10; i++) {
			if (pq.size() != 0) {
				System.out.println(pq.poll().data);
			}
		}
	}

}

class Element implements Comparable<Element> {
	String data;
	int count;

	public Element(String data, int count) {
		this.data = data;
		this.count = count;
	}

	@Override
	public int compareTo(Element o) {
		if (this.count < o.count) {
			return 1;
		} else if (this.count > o.count) {
			return -1;
		} else {
			return 0;
		}
	}

}
