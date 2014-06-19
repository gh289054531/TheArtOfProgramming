package chapter9_7;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * ������,λͼ
 */
public class Solution2 {
	public static byte[] bs = new byte[] { 0x01, 0x02, 0x4, 0x08, 0x10, 0x20, 0x40, (byte) 0x80 };

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * BufferedWriter w = new BufferedWriter(new FileWriter(new
		 * File("src\\chapter10\\test.txt"))); ArrayList<Integer> test = new
		 * ArrayList<Integer>(5000000); for (int i = 0; i < 5000000; i++) {
		 * test.add(i + 1); } Collections.shuffle(test); for (int i = 0; i <
		 * 5000000; i++) { w.write(test.get(i) + " "); } w.close();
		 */
		long start = System.currentTimeMillis();
		byte[] bitmap = new byte[625000];
		int num = 0;
		Scanner sc = new Scanner(new File("src\\chapter10\\test.txt"));
		while (sc.hasNextInt()) {
			int temp = sc.nextInt();
			num++;
			int index = (temp - 1) / 8;
			int bitindex = (temp - 1) % 8;
			byte b = bs[bitindex];
			bitmap[index] |= b;
		}
		sc.close();
		for (int i = 0; i < num; i++) {
			if ((bitmap[i / 8] & bs[i % 8]) != 0x00) {
				System.out.println(i + 1);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000);
	}
}
