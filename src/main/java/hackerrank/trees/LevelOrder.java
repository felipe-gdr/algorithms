package hackerrank.trees;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/tree-level-order-traversal
 * 
 * @author felipereis
 *
 */
public class LevelOrder {

    public void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node visited = queue.poll();
            
            System.out.print(visited.data + " ");
            
            if (visited.left != null) {
                queue.add(visited.left);
            }
            if (visited.right != null) {
                queue.add(visited.right);
            }

        }

    }

    @Test
    public void run() {
        new LevelOrder().levelOrder(Node.sampleTree());
    }
}
