package parentpackage.childpackage;

public class LinkedListNode {
    public Node node;
    public LinkedListNode next;
    public static LinkedListNode front = null;

    public LinkedListNode(Node x) {
        node = x;
        next = null;
    }

    public static void add(Node x) {
        LinkedListNode temp = front;
        if (temp == null) {
            front = new LinkedListNode(x);
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new LinkedListNode(x);
    }

    public static Node remove() {
        Node temp = front.node;
        front = front.next;
        return temp;
    }
}
