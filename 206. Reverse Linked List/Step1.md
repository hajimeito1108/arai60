## 問題理解

連結リストが与えられて、それを反転する

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

## 解法

電車の先頭車両が与えられ、順序をいれかえなければならない
最後の車両を先頭車両として返却する必要がある。
車両は次の車両を知っているが、前の車両を知らない。
前回の車両、現在の車両、次の車両の三つを持っておく。
現在の車両を前回の車両へと繋ぎ変える。
ここで次の車両がわからなくなるので、繋ぎ変える前に次の車両を保存する必要あり。
これを最後の車両までやれば、最後の車両自体が先頭車両になるはず

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
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prvious;
            previous = head;
            head = next;
        }
        return previous;
    }
}
```

## 感想

前回解いたことがあったので解けはしたが、自然言語でまとまってなく、コードを書いてる途中で次の車両保存しとかないと次ができないことに気づいたりした。
コードを書いてからでないと想像がついてない部分がある。
