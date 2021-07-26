public class LinkedList {
    /**
     * Singly connected linked list implementation
     */

    private Node head;
    private int size = 0;

    public LinkedList() {}

    /**
     * O(1)
     * @return the size of the linked list
     */
    public int size() {
        return size;
    }

    /**
     * O(1)
     * @return string value at the front of the linked list
     */
    public String getVal() {
        return head.getVal();
    }

    /**
     * O(1)
     * @return if the linked list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * O(1)
     * Adds a new node to the front of the linked list
     * @param val the value at the new node
     */
    public void add(String val) {
        Node n = new Node(val, head);
        head = n;
        size++;
    }

    /**
     * O(1)
     * Delete the first node from the linked list
     * @return value stored at the first node to be deleted
     */
    public String del() {
        if (isEmpty()) {return "";}
        String ans = head.getVal();
        head = head.getNext();
        size--;
        return ans;
    }

    /**
     * O(N)
     * Displays the linked list
     */
    public void show() {
        Node node = head;
        if (size() == 1) {
            System.out.print(node.getVal());
        } else {
            while (node != null) {
                // do not print , on the last iteration
                if (node.getNext() == null) {
                    System.out.print(node.getVal());
                } else {
                    System.out.print(node.getVal() + ", ");
                }
                node = node.getNext();
            }
        }
        System.out.println();
    }

    /**
     * @return a string version of the linked list
     */
    @Override
    public String toString() {
        String str = "";
        Node node = head;
        if (size() == 1) {
            str += node.getVal();
        } else {
            while (node != null) {
                if (node.getNext() == null) {
                    str += node.getVal();
                } else {
                    str += node.getVal() + ", ";
                }
                node = node.getNext();
            }
        }
        return str;
    }
}
