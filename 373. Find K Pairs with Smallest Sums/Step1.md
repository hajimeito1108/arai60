# 373. Find K Pairs with Smallest Sums

## 問題理解

昇順ソート済みの数字の配列2つと、kが渡される。  
各配列の組み合わせ(u, v)の合計値が小さい順にk個返す。

- 1 <= nums1.length, nums2.length <= 105
- -109 <= nums1[i], nums2[i] <= 109
- nums1 and nums2 both are sorted in non-decreasing order.
- 1 <= k <= 104
- k <= nums1.length \* nums2.length

## 解法

まずは単純に考えてすべての組み合わせとその合計値を持ったクラスを作っておく。
合計値が少ない順に並び替える。
先頭から取得。
くらいがぱっと浮かんだ。

返す個数が決まっており、また数字（合計値）でソートできることからPriorityQueueが楽そう。

以下メモリ爆散コード

```java
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<PairAndSum> pairAndSumList = new ArrayList<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                pairAndSumList.add(new PairAndSum(List.of(num1, num2), num1 + num2));
            }
        }
        Comparator<PairAndSum> comparator = Comparator.comparing(PairAndSum::sum);
        List<PairAndSum> sortedList = pairAndSumList.stream().sorted(comparator).collect(Collectors.toList());;

        List<List<Integer>> kSmallestPairs = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            kSmallestPairs.add(sortedList.get(i).numPair());
        }
        return kSmallestPairs;
    }

    record PairAndSum(List<Integer> numPair, int sum) {};
}
```
