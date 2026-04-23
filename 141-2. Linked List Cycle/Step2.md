#### 考え

たしか二個とばしのポインタと一つずつ進むポインタをいれるとアキレスと亀？的なやつでどこかで再開する解法があった気がする。  
HashSet の解法と比較して空間メモリ消費が少ないのがよさそう

```Java
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
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
```

上記でいけると思ったが null に対するケースが考慮されていなかった  
時間がないので前回のを見る。

なるほど, 条件一つ足せばいけたのか、、、、  
エッジケース漏れ？に近いのでまずはテストパターンを網羅するところから始めたほうがよさそう

```Java
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
```
