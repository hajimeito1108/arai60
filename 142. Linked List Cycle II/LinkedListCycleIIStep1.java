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
public class LinkedListCycleIIStep1 {
    public ListNode detectCycle(ListNode head) {
        // ListNode slow = head;
        // ListNode fast = head;

        // while(fast != null && fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;

        //     if(slow == fast) {
        //         ListNode loop = fast;

        //     }
        // }


        /**
         * ここまでで10分
         * two pointerを使用したサイクルの検知まではできた
         * ただし、どこからサイクルが始まってるのかの実装が全く手がでなかった
         *
         * ここでアキレスと亀のアルゴリズムの合流点が理解できなかったので過去のほかの方のコードを見る
         *
         * odaさんの神解説を見つける
         * https://discord.com/channels/1084280443945353267/1246383603122966570/1252209488815984710
         *
         * 関数で分けることで変数を整理できることを知る。
         * 
         * 時間計算量：O(n)
         * 空間計算量：O(1)
         */
         ListNode fromCollision = getCollisionPoint(head);
         if(fromCollision == null) return null;

         ListNode fromHead = head; 
         while(fromHead != collisionPoint) {
            fromHead = head.next;
            collisionPoint = collisionPoint.next;
         }
         return collisionPoint;

         
    }
    
    private ListNode getCollisionPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return fast;
            }
        }
        return null;
    }
}
