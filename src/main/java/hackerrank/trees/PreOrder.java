package hackerrank.trees;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/tree-preorder-traversal
 * 
 * @author felipereis
 *
 */
public class PreOrder {

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            this.preOrder(root.left);
            this.preOrder(root.right);
        }
    }

    @Test
    public void run() {
        new PreOrder().preOrder(Node.sampleTree());
    }
}
