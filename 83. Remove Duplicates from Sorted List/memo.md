LeetCode には下記のような回答も見られたがコメントでスタックオバーフローになる可能性あるくね？的なことを言われてた
自分は再起が苦手で避けてきたので以下の回答を思いつかなかった

```java
public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
}
```
