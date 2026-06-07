### 問題

二つの連結リストがあり、二つを整数にした時の和を連結リストとして返す。

### 考え

連結リストのnextがnullになるまでカウントし、そこから10^カウントを持っておく。
これをリスト1と2でやり合計値を新しい連結リストとして返却する。

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode sentinel = new ListNode();
        int count = 0;
        int by = 0;
        ListNode tail1 = l1;
        ListNode tail2 = l2;
        while (tail1 != null) {
            int = tail
            while (tail2 != null) {

            }
        }
    }

    private get
}
```

### 反省

なぜか合計値を取得してから新たな連結リストにしようとしていた  
しかし小学生で習ったひっ算と同じやり方をするだけで解ける問題なことに他人のコードを見て気づいた  
一桁目から足していき10以上になれば+1を次の桁用に保存しておき、次の桁の計算に使用する。  
これを繰り返すだけ。

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = null;
        ListNode sentinelTail = null;
        ListNode l1Tail = l1;
        ListNode l2Tail = l2;
        int curry = 0;
        while (l1Tail != null || l2Tail != null || curry == 1) {
            int l1Value = l1Tail != null ? l1Tail.val : 0;
            int l2Value = l2Tail != null ? l2Tail.val : 0;

            int sum = l1Value + l2Value + curry;
            curry = sum / 10;
            if (sentinel == null) {
                sentinel = new ListNode(sum % 10);
                sentinelTail = sentinel;
            } else {
                sentinelTail.next = new ListNode(sum % 10);
                sentinelTail = sentinelTail.next;
            }

            l1Tail = l1Tail != null ? l1Tail.next : null;
            l2Tail = l2Tail != null ? l2Tail.next : null;
        }
        return sentinel;
    }
}
```
