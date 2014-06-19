package chapter1_1;

import java.util.Stack;

public class ReverListByK1 {

	// must make sure k<=len(head)
	public static Node Revert(Node head, int k) {
		assert k > 0;
		if (head == null || k == 1) {
			return head;
		}
		Stack<Node> stack = new Stack<Node>();
		Node virtual = new Node(-1);
		Node cur = virtual;

		while (true) {
			for (int i = 0; i < k; i++) {
				if (head != null) {
					stack.push(head);
					head = head.next;
				} else {
					if (stack.isEmpty() == false) {
						cur.next = stack.firstElement();
					}
					return virtual.next;
				}
			}
			while (stack.isEmpty() == false) {
				cur.next = stack.pop();
				cur = cur.next;
			}
			cur.next = null;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head = Revert(head, 5);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	static class Node {
		int val;
		Node next = null;

		public Node(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}
}
