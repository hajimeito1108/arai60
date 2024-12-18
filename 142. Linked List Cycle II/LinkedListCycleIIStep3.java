/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycleIIStep3 {
    public ListNode detectCycle(ListNode head) {
        ListNode fromCollision = getCollisionPoint(head);
        if (fromCollision == null) return null;

        ListNode fromHead = head;
        while (fromHead != fromCollision) {
            fromHead = fromHead.next;
            fromCollision = fromCollision.next;
        }
        return fromHead;
    }

    private ListNode getCollisionPoint(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return fast;
            }
        }
        return null;
    }
}
