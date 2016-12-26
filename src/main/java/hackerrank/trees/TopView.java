package hackerrank.trees;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/tree-top-view
 * 
 * @author felipereis
 *
 */
public class TopView {

    private void topView(Node root) {
        this.inOrder(root, 0);
    }

    private void inOrder(Node root, int pos) {
        if (root != null) {
            if (pos == -1) {
                inOrder(root.left, -1);
                System.out.print(root.data + " ");
            } else if (pos == 0) {
                inOrder(root.left, -1);
                System.out.print(root.data + " ");
                inOrder(root.right, 1);
            } else if (pos == 1) {
                System.out.print(root.data + " ");
                inOrder(root.right, 1);
            }

        }
    }

    @Test
    public void run() {
        new TopView().topView(Node.sampleTree());
    }
}
