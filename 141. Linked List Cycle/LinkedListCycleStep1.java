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
 
 /**
  * 以前にこの問題を解いたことがあった。
  * その際はHashSetを使用した解法を思いついたが、その場合だと2pointerと比較して空間計算量が増えていた記憶がある
  */
  public class LinkedListCycleStep1 {
    public boolean hasCycle(ListNode head) {
        // // 独学でやっていて丸暗記していたがfast pointerとslow pointerがあったのしか思い出せん、
        // while(head.next != null && head.next.next != null){
        //     ListNode fast = head.next.next;
        //     ListNode slow = head.next;

        //     // 前回やった際は重複したときにtrue or falseのどちらを返すか確認してなかった、、
        //     if(fast == slow) {
        //         return true;
        //     }
        // }
        // return false;

        /**
         * two pointerでは時間が間に合わなかったのでhashsetで対応
         * 時間計算量:O(n)
         * 空間計算量:O(n)
         */
        ListNode curr = head;
        HashSet<ListNode> hashSet = new HashSet<>();
        while(curr != null) {
            if(!hashSet.add(curr)){
                return true;
            }
            curr = curr.next;
        }
        return false;

        /**
         * 上記で丸暗記のだめなところすべて出し尽くしました！、、
         * 上記がゴミコード過ぎて恥ずかしいけど晒していこうと思います
         * 自分の場合コンセプトは覚えているもののループする条件がわからなくなる場合が多い気がする
         * 時間計算量：O(n)
         * 空間計算量：O(1)
         */ 

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}