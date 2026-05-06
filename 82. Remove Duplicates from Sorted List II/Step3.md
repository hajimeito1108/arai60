```Java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode sentinel = new ListNode(0, head);
        ListNode tail = sentinel;
        ListNode node = tail.next;
        while (node != null) {
            if (node.next == null || node.val != node.next.val) {
                tail = node;
                node = tail.next;
                continue;
            }

            while (node.next != null && node.val == node.next.val) {
                node = node.next;
            }
            tail.next = node.next;
            node = tail.next;
        }
        return sentinel.next;
    }
}
```
