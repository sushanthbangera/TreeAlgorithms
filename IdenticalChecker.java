import models.Pair;
import models.Node;

import java.util.ArrayDeque;
import java.util.Deque;


public class IdenticalChecker {

    // Recursive function to check if two given binary trees are identical or not
    public boolean isIdentical(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }

        return (a != null && b != null) && (a.data == b.data)
                && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }

    public boolean isIdenticalIterative(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }

        Deque<Pair<Node, Node>> stack = new ArrayDeque<>();
        stack.add(Pair.of(a, b));

        while (!stack.isEmpty()) {

            a = stack.peekLast().getFirst();
            b = stack.peekLast().getSecond();

            stack.pollLast();

            if (a.data != b.data) {
                return false;
            }

            if (a.left != null && b.left != null) {
                stack.add(Pair.of(a.left, b.left));
            } else if (a.left != null || b.left != null) {
                return false;
            }

            if (a.right != null && b.right != null) {
                stack.add(Pair.of(a.right, b.right));
            } else if (a.right != null || b.right != null) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IdenticalChecker ic = new IdenticalChecker();
        // construct the first tree
        Node x = new Node(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);

        // construct the second tree
        Node y = new Node(15);
        y.left = new Node(10);
        y.right = new Node(20);
        y.left.left = new Node(8);
        y.left.right = new Node(12);
        y.right.left = new Node(16);
        y.right.right = new Node(25);

        if (ic.isIdentical(x, y)) {
            System.out.println("The given binary trees are identical");
        } else {
            System.out.println("The given binary trees are not identical");
        }

        if (ic.isIdenticalIterative(x, y)) {
            System.out.println("The given binary trees are identical");
        } else {
            System.out.println("The given binary trees are not identical");
        }
    }
}
