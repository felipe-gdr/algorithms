package hackerrank.trees;

/**
 * A node from a binary tree
 * 
 * @author felipereis
 *
 */
public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    static Node sampleTree() {
        Node n1 = new Node(1, null, null);
        Node n4 = new Node(4, null, null);
        Node n5 = new Node(5, n1, n4);

        Node n6 = new Node(6, null, null);
        Node n2 = new Node(2, n6, null);

        Node n3 = new Node(3, n5, n2);

        return n3;
    }
}
