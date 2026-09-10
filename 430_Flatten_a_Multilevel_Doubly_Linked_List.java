/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                Node nextNode = curr.next;
                Node childHead = curr.child;
                Node childTail = childHead;

                while (childTail.next != null) {
                    childTail = childTail.next;
                }

                curr.next = childHead;
                childHead.prev = curr;

                if (nextNode != null) {
                    childTail.next = nextNode;
                    nextNode.prev = childTail;
                }

                curr.child = null;
            }
            curr = curr.next;
        }

        return head;
    }
}