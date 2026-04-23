### 問題

linekdlist が循環参照しているかの問題  
各 Node が現在の値と次の値のポインタを持っている

#### 制約

- node の数は[0, 10^4]
- -10^5 <= Node.val <= 10^5

#### 考え

各 Node が固有であることを前提にしていいなら（勝手にしちゃいけない多分）HashSet が有効そう  
なんか slow ポインタと fast ポインタでも解けたようなきがする  
ひとまず HashSet で書くが最高４桁数入ってくる

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
        ListNode currentNode = head;
        HashSet<ListNode> hashSet = new HashSet<ListNode>();
        while (currentNode != null) {
            if (!hashSet.add(currentNode)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
}

```

上記でパスしたが固有の Node であることが明記されてない以上奇跡なので別の方法を Step ２で考える(本来とはやり方が違うがこれはこれで回答を残しておきたいため)
