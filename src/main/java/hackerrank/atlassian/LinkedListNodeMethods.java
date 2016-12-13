package hackerrank.atlassian;

/*
 * Implement a method 'find' that will find the starting index   
 * (zero based) where the second list occurs as a sub-list in the first list. 
 * It should return -1 if the sub-list cannot be found. Arguments are always 
 * given, not empty. Sample Input 1 list1 = (1, 2, 3) list2 = (2, 3) 
 * Sample Output 1 1 Explanation As second list (2, 3) is sub-list 
 * in first list (1, 2, 3) at index 1 Sample Input 2 list1 = (1, 2, 3) 
 * list2 = (3, 2) Sample Output 2 -1
 */
public class LinkedListNodeMethods {
	static int find(LinkedListNode list, LinkedListNode sublist) {
		String listString = asString(list);
		String sublistString = asString(sublist);
		return listString.indexOf(sublistString);
	}

	static String asString(LinkedListNode l) {
		String s = "";
		while (l != null) {
			s += l.data;
			l = l.next;
		}
		return s;
	}

	// http://stackoverflow.com/questions/5374077/what-is-linkedlistnode-in-java
	public static void main(String[] args) {
		LinkedListNode node_1 = new LinkedListNode("first");
		LinkedListNode node_2 = new LinkedListNode("second");
		node_1.next = node_2;
		LinkedListNode node_3 = new LinkedListNode("third");
		node_2.next = node_3;

		System.out.println("*** Print contents of linked list");
		LinkedListNode current = node_1;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}

		System.out.println("*** Now delete second node");
		deleteNode(node_2);

		System.out.println("*** Print after deleting second node");
		current = node_1;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		}
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
}

class LinkedListNode {
	public Object data;
	public LinkedListNode next;

	public LinkedListNode(Object data) {
		this.data = data;
	}
}
