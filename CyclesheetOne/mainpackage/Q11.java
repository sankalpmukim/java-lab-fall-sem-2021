package mainpackage;

import parentpackage.BinaryTree;
import parentpackage.childpackage.ArrayBinaryTree;
import parentpackage.childpackage.LinkedBinaryTree;

public class Q11 {
    public static void main(String[] args) {
        BinaryTree arrTree = new ArrayBinaryTree(10);
        arrTree.insertion(1, -1, true);
        arrTree.insertion(3, 0, false);
        arrTree.insertion(4, 1, true);
        arrTree.insertion(1, 1, false);
        arrTree.insertion(1, 2, false);

        arrTree.levelOrderTraversal();

        BinaryTree linkedTree = new LinkedBinaryTree(1);
        linkedTree.insertion(2, 1, true);
        linkedTree.insertion(3, 1, false);
        linkedTree.insertion(4, 2, true);
        linkedTree.insertion(5, 2, false);
        linkedTree.insertion(6, 3, true);
        linkedTree.insertion(7, 3, false);

        linkedTree.levelOrderTraversal();
    }
}
