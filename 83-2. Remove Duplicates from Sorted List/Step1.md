### 問題理解

連結リスト(sort済み)の先頭が与えられて重複を削除して返す

#### 制約

- nodeのレンジは[0, 300]
- -100 <= Node.val <= 100

### 考え

最終的に先頭のnodeを返す必要がある。 -> ダミーノードを用意  
また、ソートされているので重複は絶対に連続する。  
現在と未来か、過去と現在の二つのnodeを持つ必要がある。

### 終わってからの考え,

時間がないので考えがまとまらないうちにコードを書き出してしまった。  
よく考えてみたら実際headがnullなときはnullで返すのか、例外を投げるのか考えてなかった。  
実際のコーディングでは必ず考えないといけないことなのに。。  
あとnext.nextは単純に見づらすぎて保守性最悪

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
        ListNode dummy = new ListNode(-1, head);
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            if (next != null && node.val == next.val) {
                node.next = next.next;
                continue;
            }
            node = next;
        }
        return dummy.next;
    }
}
```
