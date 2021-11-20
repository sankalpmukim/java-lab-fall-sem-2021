package parentpackage.childpackage;

import parentpackage.BinaryTree;

public class ArrayBinaryTree implements BinaryTree {
    public int[] arr;

    public ArrayBinaryTree(int n) {
        arr = new int[n];
    }

    public void insertion(int n, int parent, boolean set_left) {
        if (parent != -1 && arr[parent] == 0) {
            System.out.println("Parent not found at " + parent + ", therefore cannot set " + n);
        } else if (parent == -1) {
            arr[0] = n;
        } else if (set_left) {
            System.out.println("Element succesfully added left of " + parent + ":" + n);
            arr[(parent * 2) + 1] = n;
        } else {
            System.out.println("Element succesfully added right of " + parent + ":" + n);
            arr[(parent * 2) + 2] = n;
        }
    }

    public void levelOrderTraversal() {
        System.out.println("Level order traversal of linked binary tree!:");
        System.out.print("[\n\t");
        for (int i : arr) {
            System.out.print("" + i + ", ");
        }
        System.out.println("\n]");
    }
}
