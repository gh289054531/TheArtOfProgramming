package chapter9_7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 多路归并外部排序
 */
public class Solution3 {
	static int l = 1024 * 1024 / 4;
	static int k = (int) Math.ceil(5000000.0 / l);
	static int lastFileLen = 5000000 - l * (k - 1);

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		BufferedWriter[] ws = new BufferedWriter[k];
		for (int i = 0; i < k; i++) {
			ws[i] = new BufferedWriter(new FileWriter(new File("src\\chapter10\\k_mergesort" + i + ".txt")));
		}
		Scanner sc = new Scanner(new File("src\\chapter10\\test.txt"));
		for (int i = 0; i < k; i++) {
			int[] num;
			if (i != k - 1) {
				num = new int[l];
				for (int j = 0; j < l; j++) {
					num[j] = sc.nextInt();
				}
			} else {
				num = new int[lastFileLen];
				for (int j = 0; j < lastFileLen; j++) {
					num[j] = sc.nextInt();
				}
			}
			Arrays.sort(num);
			for (int n : num) {
				ws[i].write(n + " ");
			}
			ws[i].close();
		}
		sc.close();

		Scanner[] rs = new Scanner[k];
		for (int i = 0; i < k; i++) {
			rs[i] = new Scanner(new File("src\\chapter10\\k_mergesort" + i + ".txt"));
		}
		BufferedWriter result = new BufferedWriter(new FileWriter("src\\chapter10\\k_mergesort_result.txt"));
		PriorityQueue<Element> pq = new PriorityQueue<Element>(k);
		for (int i = 0; i < k; i++) {
			if (rs[i].hasNextInt()) {
				int temp = rs[i].nextInt();
				pq.add(new Element(temp, i));
			}
		}
		while (pq.isEmpty() == false) {
			Element e = pq.poll();
			result.write(e.data + " ");
			if (rs[e.fileIndex].hasNext()) {
				pq.add(new Element(rs[e.fileIndex].nextInt(), e.fileIndex));
			}
		}
		for (int i = 0; i < k; i++) {
			rs[i].close();
		}
		result.close();
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000);
	}
}

class Element implements Comparable<Element> {
	int data;
	int fileIndex;

	public Element(int data, int fileIndex) {
		this.data = data;
		this.fileIndex = fileIndex;
	}

	@Override
	public int compareTo(Element o) {
		if (this.data < o.data) {
			return -1;
		} else if (this.data > o.data) {
			return 1;
		} else {
			return 0;
		}
	}

}
