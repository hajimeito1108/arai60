# 1. Two Sum

## 問題理解

数字の配列と、数値targetが渡され配列の要素二つを足してtargetになるような二つの要素のインデックスを配列(any order)として返却する  
要素は一回しか使えず二回使うのは禁止

- 2 <= nums.length <= 10^4
- -10^9 <= nums[i] <= 10^9
- -10^9 <= target <= 10^9

## 解法

ぱっと思いついたのは二重ループで全パターンを試す方法。  
index : target - num をMapで作成、その後valueがMapにあるかを探すとforが一回ずつになる
要素は二つなので num : index でいいことに気づく。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer index = numToIndex.get(diff);
            if (index != null) {
                return new int[] {index, i};
            }
            numToIndex.putIfAbsent(nums[i], i);
        }
        return null;
    }
}
```
