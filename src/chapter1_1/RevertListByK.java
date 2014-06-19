package chapter1_1;

public class RevertListByK {

	// must make sure k<=len(head)
	public static Node Revert(Node head, int k) {
		assert k > 0;
		if (head == null || k == 1) {
			return head;
		}
		Node start = head;
		Node cur = head;
		Node virtual = new Node(-1);
		virtual.next = head;
		Node preEnd = virtual;
		while (cur != null) {
			Node nextPreEnd = start;
			for (int i = 0; i < k - 1; i++) {
				cur = cur.next;
				if (cur == null) {
					preEnd.next = start;
					return virtual.next;
				}
			}
			Node nextStart = cur.next;
			while (start != cur) {
				Node next = cur.next;
				cur.next = start;
				Node temp = start.next;
				start.next = next;
				start = temp;
			}
			preEnd.next = cur;
			preEnd = nextPreEnd;
			start = nextStart;
			cur = nextStart;
		}
		return virtual.next;
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
		head = Revert(head, 6);
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
