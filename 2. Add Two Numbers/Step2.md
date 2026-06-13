## 解法

1週間くらい経ってから再チャレ。  
普通のひっ算と同じはず。  
桁が違うことがあるので要注意。  
また、ひっ算と同じで10を超えると次の桁に持ち越しなことに注意。  
15分くらいで以下の回答にできた。  
個人的には三項演算子が少し見づらいかもという感想。

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinelNode = null;
        ListNode currentNode = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Num = l1 != null ? l1.val : 0;
            int l2Num = l2 != null ? l2.val : 0;
            int sum = l1Num + l2Num + carry;
            int digit = sum % 10;
            carry = sum / 10;

            if (currentNode == null) {
                // initial sentinelNode
                sentinelNode = new ListNode(digit);
                currentNode = sentinelNode;
            } else {
                currentNode.next = new ListNode(digit);
                currentNode = currentNode.next;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return sentinelNode;
    }
}
```
