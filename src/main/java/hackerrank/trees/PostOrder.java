package hackerrank.trees;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/tree-preorder-traversal
 * 
 * @author felipereis
 *
 */
public class PostOrder {

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    @Test
    public void run() {
        new PostOrder().postOrder(Node.sampleTree());
    }
}
