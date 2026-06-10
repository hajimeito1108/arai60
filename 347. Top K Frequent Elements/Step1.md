# 347. Top K Frequent Elements

## 問題理解

数字の配列（重複あり）が渡されて、出てくる数字のうち頻度の高いk個を新たな配列にして返す

- 1 <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4
- k is in the range [1, the number of unique elements in the array].
- It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

## 解法

配列を順にみていき、数字 : 頻度をmapとして持っておく。  
mapを順にみていき、頻度が多い順に並び替えて上からｋ個だけ取得。  
数字の配列に直して返却。  
がぱっと思いついた回答。  
頻度が多い順に並び変えるをどう実現するか、  
多分PriorityQueue使えばうまくいくはず  
それ以外の並び変えかたが思いつかない、、、、  
以下で時間切れ

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFrequent = new HashMap<>();
        for (int num : nums) {
            // index 0 or 1 ?
            numToFrequent.put(num, numToFrequent.getOrDefault(num, 0) + 1);
        }
        Queue<Map<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparting(k,v -> Collections.reversOrder(v)));
        for ()

    }
}
```

他人の回答を参考に書いてみる

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

    }
}
```
