下記のほうがシンプルでアキレスと亀よりも好きだが、空間計算量が多くなる

- 亀とアキレス：O(1)
- HashSet：O(n)

```
public class Solution {
public ListNode detectCycle(ListNode head) {
    HashSet<ListNode> hashSet = new HashSet<>();
    ListNode node = head;

        while (node != null) {
            if (!hashSet.add(node)) {
                return node;
            }
            node = node.next;
        }

        return null;
    }
}
```
