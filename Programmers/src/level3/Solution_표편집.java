package level3;

import java.util.Stack;

public class Solution_표편집 { //링크드리스트
	static Stack<Node> stack;

	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
		System.out.println(solution(n, k, cmd));
	}

	static public String solution(int n, int k, String[] cmd) {
		StringBuffer answer = new StringBuffer();
		stack = new Stack<Node>();
		Node head = new Node(-1);
		Node prev = head;
		for (int i = 0; i < n; i++) {
			Node node = new Node(i);
			prev.next = node;
			node.prev = prev;
			prev = node;
		}
		prev.next = new Node(-1);
		Node cur = head.next;
		for (int i = 0; i < k; i++) {
			cur = cur.next;
		}
		for (int i = 0; i < cmd.length; i++) {
			String[] op = cmd[i].split(" ");
			if (op[0].equals("U")) {
				cur = up(cur, Integer.parseInt(op[1]));
			} else if (op[0].equals("D")) {
				cur = down(cur, Integer.parseInt(op[1]));
			} else if (op[0].equals("C")) {
				cur = delete(cur);
			} else { // Z
				restore();
			}
		}
		for (int i = 0; i < n; i++) {
			answer.append('O');
		}
		while (!stack.isEmpty()) {
			answer.setCharAt(stack.pop().data, 'X');
		}

		return answer.toString();
	}

	public static Node up(Node cur, int n) {
		for (int i = 0; i < n; i++) {
			cur = cur.prev;
		}
		return cur;
	}

	public static Node down(Node cur, int n) {
		for (int i = 0; i < n; i++) {
			cur = cur.next;
		}
		return cur;
	}

	public static Node delete(Node cur) {
		stack.push(cur);
		cur = cur.delete();
		return cur;
	}

	public static void restore() {
		Node n = stack.pop();
		n.restore();
	}

}

class Node {
	int data;
	Node prev, next;

	Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	public Node delete() {
		prev.next = next;
		next.prev = prev;
		if (this.next.data == -1) {
			return this.prev;
		} else {
			return this.next;
		}
	}

	public void restore() {
		prev.next = this;
		next.prev = this;
	}

	public String toString() {
		return this.prev.data + " " + this.data + " " + this.next.data;
	}
}
