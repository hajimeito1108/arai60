## 解法

1週間くらい経ってからの回答。

連結リストをひっくり返して先頭nodeを返す。  
前のノード、現在のノード、次のノードがあればできる。  
次のノードは外に持たず、繰り替えしの中で持つことで対処可能なことに途中で気づく。
10分くらいで以下の回答に。

```java
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
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
```
