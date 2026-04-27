### 問題整理

連結リストが循環しているか判定して、循環し始めたListNodeを特定する。  
循環していなければnullを返す。

#### 制約

- node の数は[0, 10^4]
- -10^5 <= Node.val <= 10^5

### 考え

nodeを順に辿りHashSetに記録します。  
重複が発覚した際、そのnodeが開始位置となります。  
この解は最悪10^4個nodeを記録することになります。

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
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (!visited.add(head)) {
                return head;
            }
            head = head.next;
        }
        return head;
    }
}
```
