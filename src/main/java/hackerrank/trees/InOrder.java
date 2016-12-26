package hackerrank.trees;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/tree-preorder-traversal
 * 
 * @author felipereis
 *
 */
public class InOrder {

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
            
        }
    }

    @Test
    public void run() {
        new InOrder().inOrder(Node.sampleTree());
    }
}
