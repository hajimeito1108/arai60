## 解法

サイズを限定したPriorutyQueueを持つことで上位のスコアの維持とkthスコアを返せそう。  
サイズの限定方法については、offer後にpollすることで維持。
10分くらいで以下の回答。
選択肢の幅がおそらく狭い。  
単純にソートアルゴリズムを全然知らないからだと思う。

```java
class KthLargest {

    private int kTh;
    private PriorityQueue<Integer> ascendingScore;

    public KthLargest(int k, int[] nums) {
        kTh = k;
        ascendingScore = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        ascendingScore.offer(val);
        if (ascendingScore.size() > kTh) {
            ascendingScore.poll();
        }
        return ascendingScore.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
```

## メモ

```java
new PriorityQueue<>(int initialCapacity)
```

- デフォルトの初期容量(11)
- 指定した初期容量でキューを作成します。要素の順序付けは自然順序（Comparable）に従います。
- データ量が膨大だとわかっている場合、十分に大きな initialCapacity を設定しておくことで、要素の追加（add や offer）時に発生する配列のコピーや再割り当ての回数を減らし、パフォーマンスを向上させることができます。

ほえ～

- `add()`はIllegalStateException をスローする
- `offer()`はfalseを返す

offerで判定する方が楽そう
