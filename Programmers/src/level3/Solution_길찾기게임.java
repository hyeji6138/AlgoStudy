package level3;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_길찾기게임 {
	static int cnt;

	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };
		printArray(solution(nodeinfo));
	}

	static public int[][] solution(int[][] nodeinfo) {
		int[][] answer = new int[2][nodeinfo.length];
		int[][] nodes = new int[nodeinfo.length][3];
		for (int i = 0; i < nodeinfo.length; i++) {
			nodes[i] = new int[] { i + 1, nodeinfo[i][0], nodeinfo[i][1] };
		}
		Arrays.sort(nodes, new MySort());
		Node tree = new Node(nodes[0][0], nodes[0][1], nodes[0][2]);
		for (int i = 1; i < nodes.length; i++) {
			addNode(tree, nodes[i]);
		}
		cnt = 0;
		preorder(tree, answer[0]);
		cnt = 0;
		postorder(tree, answer[1]);
		return answer;
	}

	static public void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

	static class MySort implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[2] == o2[2]) {
				return o1[1] - o2[1];
			}
			return o2[2] - o1[2];
		}

	}

	static class Node {
		int x, y;
		int num;
		Node left, right;

		Node(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.left = null;
			this.right = null;
		}

		public String toString() {
			return "num: " + num + " x: " + x + " y: " + y;
		}
	}

	static public void addNode(Node n, int[] newNode) {
		if (newNode[1] < n.x) {
			if (n.left != null) {
				addNode(n.left, newNode);
			} else {
				n.left = new Node(newNode[0], newNode[1], newNode[2]);
			}
		} else {
			if (n.right != null) {
				addNode(n.right, newNode);
			} else {
				n.right = new Node(newNode[0], newNode[1], newNode[2]);
			}
		}
	}

	static public void preorder(Node n, int[] array) {
//		System.out.println(n);
		array[cnt++] = n.num;
		if (n.left != null) {
			preorder(n.left, array);
		}
		if (n.right != null) {
			preorder(n.right, array);
		}
	}

	static public void postorder(Node n, int[] array) {
		if (n.left != null) {
			postorder(n.left, array);
		}
		if (n.right != null) {
			postorder(n.right, array);
		}
//		System.out.println(n);
		array[cnt++] = n.num;

	}
}
