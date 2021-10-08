import models.Node;

public class TreeHeight {

    public int height(Node root) {
        return height(root, 0);
    }

    public int height(Node root, int height) {
        if (root == null) {
            return height;
        }
        return Math.max(height(root.left, height + 1), height(root.right, height + 1));
    }

    public static void main(String[] args) {
        Node node = new Node(15);
        node.left = new Node(10);
        node.right = new Node(20);
        node.left.left = new Node(8);
        node.left.right = new Node(12);
        node.right.left = new Node(16);
        node.right.right = new Node(25);

        TreeHeight th = new TreeHeight();
        System.out.println(th.height(node));
    }
}
