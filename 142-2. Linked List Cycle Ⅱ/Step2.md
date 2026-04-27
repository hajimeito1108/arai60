### 他の方のコードを見て考えたこと

- 引数をコピーしてから問題を初めていて、基本引数自体をいじることはしてない
- 亀とアキレスを使用したほうがメモリにはやさしい

```Java
**
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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode node = head;
        Set<ListNode> visited = new HashSet<>();
        while (node != null) {
            if (!visited.add(node)) {
                return node;
            }
            node = node.next;
        }
        return node;
    }
}
```
