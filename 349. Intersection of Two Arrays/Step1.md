# 349. Intersection of Two Arrays

## 問題

二つの配列の共通項を配列として返す
配列内の要素は最大1000個くらい

1. 片方の配列をソートしておき、二分探索
2. 片方の配列をHashSetに入れて置き、そこに検索をかける

どちらが早いかわからないので計測するしかないかな？

## 解法

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> commonInteger = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int num : nums1) {
            visited.add(num);
        }
        for (int num : nums2) {
            if (visited.contains(num)) {
                commonInteger.add(num);
            }
        }

        int[] intArray = commonInteger.stream().mapToInt(Integer::intValue).toArray();
        return intArray;
    }
}
```

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> commonInteger = new HashSet<>();
        Arrays.sort(nums1);
        for (int num : nums2) {
            int has = Arrays.binarySearch(nums1, num);
            if (has > -1) {
                commonInteger.add(num);
            }
         }
        int[] intArray = commonInteger.stream().mapToInt(Integer::intValue).toArray();
        return intArray;
    }
}
```
