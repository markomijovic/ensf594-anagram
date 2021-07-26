import java.util.Arrays;

public class Node {
    /**
     * Represents a node in a singly connected linked list
     */

    private String val;
    private Node next;

    public Node(String val) {
        setVal(val);
    }

    public Node(String val, Node n) {
        setVal(val);
        setNext(n);
    }

    public String getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setVal(String val) {
        this.val = val;
    }

    /**
     * O(nlog(n)) : The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Y., Jon B., and Joshua B.
     * Sorts node value (string)
     * @param inputString string to be sorted
     * @return sorted string
     */
    public static String sortString(String inputString)
    {
        /**
         * Website: https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/
         * Accessed: July 25, 2021
         */
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();
        // sort tempArray
        Arrays.sort(tempArray);
        // return new sorted string
        return new String(tempArray);
    }
}
