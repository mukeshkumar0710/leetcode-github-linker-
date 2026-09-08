/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a clone for each node and interweave it: A -> A' -> B -> B'
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step 2: Assign random pointers for cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original and copied lists
        curr = head;
        Node clonedHead = head.next;
        Node cloneCurr = clonedHead;

        while (curr != null) {
            curr.next = curr.next.next;
            curr = curr.next;

            if (cloneCurr.next != null) {
                cloneCurr.next = cloneCurr.next.next;
                cloneCurr = cloneCurr.next;
            }
        }

        return clonedHead;
    }
}