package parentpackage.childpackage;

import parentpackage.BinaryTree;

public class LinkedBinaryTree implements BinaryTree {
    public Node root;

    public LinkedBinaryTree(int n) {
        System.out.println("New element " + n + " succesfully added");
        root = new Node(n);
    }

    public static Node findElementNode(Node root, int n) {
        if (root == null) {
            return null;
        }
        if (root.value == n) {
            return root;
        }
        Node leftSide = findElementNode(root.left, n);
        if (leftSide != null) {
            return leftSide;
        }
        Node rightSide = findElementNode(root.right, n);
        return rightSide;
    }

    public void insertion(int n, int parent, boolean set_left) {
        Node parentNode = findElementNode(root, parent);
        if (parentNode == null) {
            System.out.println("Parent element not found");
            return;
        }
        if (set_left) {
            parentNode.left = new Node(n);
        } else {
            parentNode.right = new Node(n);
        }
        System.out.println("New element " + n + " succesfully added");
    }

    public void levelOrderTraversal() {
        System.out.println("Level order traversal of linked binary tree!:");
        LinkedListNode.front = new LinkedListNode(this.root);
        while (LinkedListNode.front != null && LinkedListNode.front.node != null) {
            Node curr = LinkedListNode.remove();
            System.out.println("Node: " + curr.value);
            LinkedListNode.add(curr.left);
            LinkedListNode.add(curr.right);
        }
    }
}
