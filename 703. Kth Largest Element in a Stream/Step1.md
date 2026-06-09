# 703. Kth Largest Element in a Stream

## 問題理解

テストスコア管理人
既存のテストスコアを並び替えておき、新たにスコアが追加されたら何位(k)かを提示する必要がある
また、何位まで保持する必要があるか`k`で渡される。
生徒の数は最大1万人、保持スコア数も同等
最大１万回追加される

## 解法

PriorityQueueを使用して降順とサイズ(k)を保証してqueueの最後尾(k)にいるものを毎回返せればよさそう
PriorityQueueの宣言方法と使い方とか曖昧なので公式ドキュメント見ながらになりそう

```java
class KthLargest {

    int placeAndSize = 0;
    Queue<Integer> queue = new PriorityQueue<Integer>();

    public KthLargest(int k, int[] nums) {
        placeAndSize = k;
        for(int num : nums) {
            queue.add(num);
            if (queue.size() > placeAndSize) {
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > placeAndSize) {
            queue.poll();
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
```

## 感想

PriorutyQueueの使い方に戸惑ったものの、解けはしたが重複が多くもっといい書き方が絶対にあるので後で見返す
