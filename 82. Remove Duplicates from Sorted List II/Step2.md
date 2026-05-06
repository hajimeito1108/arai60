```Java
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode sentinel = new ListNode(0, head);
        ListNode previous = sentinel;
        ListNode node = previous.next;
        while (node != null) {
            if (node.next == null || node.val != node.next.val) {
                previous = node;
                node = node.next;
                continue;
            }

            while (node.next != null && node.val == node.next.val) {
                node = node.next;
            }
            previous.next = node.next;
            node = previous.next;
        }
    }
}
```

### 他人のコードを参考に１０分以内に書く

line 19 はメモリのアドレスを参照しているだけなのでsentinelの値が変わることはない。  
line 31 はprevious.nextで単方向連結リストの実態である次ポインタを上書きしているのでsentinelも変化するようになっている。
