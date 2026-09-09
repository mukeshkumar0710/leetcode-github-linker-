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
    private final ListNode head;
    private final Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    public int getRandom() {
        int chosenVal = head.val;
        ListNode curr = head.next;
        int count = 2;

        // Reservoir sampling for a stream of unknown length
        while (curr != null) {
            // Replace with probability 1/count
            if (rand.nextInt(count) == 0) {
                chosenVal = curr.val;
            }
            count++;
            curr = curr.next;
        }

        return chosenVal;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */