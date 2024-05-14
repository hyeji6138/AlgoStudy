package level3;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_양과늑대 {
	public static void main(String[] args) {
		int[] info = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 },
				{ 4, 6 }, { 8, 9 } };
		System.out.println(solution(info, edges));
	}

	public static int solution(int[] info, int[][] edges) {
		int answer = 0;
		Arrays.sort(edges, new MySort());
//		Node head = new Node(0, info[0], null, null, null);
//
//		for (int i = 0; i < edges.length; i++) {
//			Node node = findNode(head, edges[i][0]);
//			if (node.left == null) {
//				node.left = new Node(edges[i][1], info[edges[i][1]], node, null, null);
//			} else {
//				node.right = new Node(edges[i][1], info[edges[i][1]], node, null, null);
//			}
//		}
//		printTree(head);
//		go(head, 1, 0);
		return answer;
	}

//	public static void go(Node node, int sheepCnt, int wolfCnt) {
//		System.out.println(node.num+">> "+sheepCnt + " " + wolfCnt);
//		if (node.left != null) {
//			if (node.left.type == 0) {
//				go(node.left, sheepCnt + 1, wolfCnt);
//			} else if (sheepCnt > wolfCnt + 1) {
//				go(node.left, sheepCnt, wolfCnt + 1);
//			}
//		}
//
//		if (node.right != null) {
//			if (node.right.type == 0) {
//				go(node.right, sheepCnt + 1, wolfCnt);
//			} else if (sheepCnt > wolfCnt + 1) {
//				go(node.right, sheepCnt, wolfCnt + 1);
//			}
//		}
//	}

	public static class MySort implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}

	}

//	public static Node findNode(Node node, int num) {
//		if (node == null) {
//			return null;
//		}
//		if (node.num == num) {
//			return node;
//		}
//		Node result = null;
//		result = findNode(node.left, num);
//		if (result != null) {
//			return result;
//		}
//		result = findNode(node.right, num);
//		return result;
//	}
//
//	public static void printTree(Node node) {
//		if (node == null) {
//			return;
//		}
//		System.out.println(node.num);
//		printTree(node.left);
//		printTree(node.right);
//	}
//
//	static class Node {
//		int num, type;
//		Node parent;
//		Node left, right;
//
//		public Node(int num, int type, Node parent, Node left, Node right) {
//			this.num = num;
//			this.type = type;
//			this.parent = parent;
//			this.left = left;
//			this.right = right;
//		}
//	}
}
