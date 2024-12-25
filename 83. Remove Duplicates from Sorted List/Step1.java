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
class Step1 {
    public ListNode deleteDuplicates(ListNode head) {

        /**
         * ここまでで時間制限がきて終了
         * 現在のnodeの値と次のnodeの値を比較して同じならnextに次のnextを入れてあげるとこまではわかった
         * ただし、入れ替えた終えたときに最初のnodeを返す方法がわからなかった
         */
        // ListNode node = head;
        // while(node != null && node.next != null) {
        //     if(node.val == node.next.val) {
        //         node.next = node.next.next;
        //     } else {
        //         if(node = node)
        //     }

        // }



        /**
         * 上記はだいぶおしいところまでいけていたことが判明
         * Javaは基本データ型と参照型があり、参照型値の代入では参照型値を書き換えることになる
         * これほどの基本的なことがわかっていないことに驚いた
         */
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
