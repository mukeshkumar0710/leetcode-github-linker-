/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastSorted = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                // Already in sorted order, simply advance the sorted boundary
                lastSorted = lastSorted.next;
            } else {
                // Find insertion position starting from the dummy head
                ListNode prev = dummy;
                while (prev.next.val < curr.val) {
                    prev = prev.next;
                }

                // Splice curr out of its current position and insert after prev
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }

        return dummy.next;
    }
}