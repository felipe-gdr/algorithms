package hackerrank.trees;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/tree-preorder-traversal
 * 
 * @author felipereis
 *
 */
public class GetHeight {

    private int highestCount = 0;

    public int getHeightFromTheEditorial(Node root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(getHeightFromTheEditorial(root.left), getHeightFromTheEditorial(root.right));
        }
    }

    public void getHeight(Node root) {
        int count = 0;

        inOrder(root, count);

        System.err.println(highestCount);
    }

    private void inOrder(Node root, int count) {
        if (root != null) {
            count++;
            // System.err.println(count);

            inOrder(root.left, count);
            inOrder(root.right, count);

        } else if (count > highestCount) {
            this.highestCount = count;
        }
    }

    @Test
    public void run() {
        new GetHeight().getHeightFromTheEditorial(Node.sampleTree());
    }
}
