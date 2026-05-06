### 問題理解

ソート済みのintを持つ連結リストから重複しているnodeを削除して返却する

#### 制約

- The number of nodes in the list is in the range [0, 300].
- -100 <= Node.val <= 100

### 考え

先頭から連続で重複していたらheadを返せないので新しくダミーノードが必要？

時間ぎれ  
手作業でもやり方がいまいちわからないので解けなかった

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
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                ListNode forward = node.next.next;
                while (forward != null) {

                }
            }

            if (dummy.next == null) {
                dummy.next = node;
            }
            node = node.next;
        }
        return dummy.next;
    }
}
```

### 考え２, 自然言語を使って解いてみよう

電車のおもちゃがあって重複している種類の車両を消して新たな電車として作る作業。  
同じ種類の車両は必ず連続するように整理されている。
作業員は交代する可能性があるので、途中参加する人にもわかるようにしておかないといけない。
車両同士の繋ぎなおしが必要。

次の作業員のためにも重複名簿と現在車両を用意しておく。
先頭車両から見ていき重複名簿に登録されている車両かを調べ、登録されていたら次の車両へ。  
その後次の車両を見て今の車両と種類が被っていたら、車両の種類を重複名簿に記録して次の次の車両へ。  
被ってなければ新たに完成品の電車として車両を登録する。  
次の車両に行く。
これを繰り返す。

自然言語を使う方法が意外とうまくいった。2 pointerを使用したらメモリ空間の使用量が減るが今回は最悪300車両なのでそう多くはならない。

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
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode current = head;
        Set<Integer> dupulicateValue = new HashSet<>();
        while (current != null) {
            if (dupulicateValue.contains(current.val)) {
                current = current.next;
                continue;
            }

            if (current.next != null && current.val == current.next.val) {
                dupulicateValue.add(current.val);
                current = current.next.next;
                continue;
            }

            tail.next = new ListNode(current.val);
            tail = tail.next;
            current = current.next;
        }

        return dummy.next;
    }
}
```
