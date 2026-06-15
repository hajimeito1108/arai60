# 49. Group Anagrams

## 問題

String の配列をアナグラムでグループ化せよ、順序は問わない

- strs[i] consists of lowercase English letters.

## 解法

Character にはなにか数字が割り当てられていたような,,,  
ぱっと思いついたのは Character をソートして、ソート済み文字列 : アナグラムグループにする方法

- character をソートできるのか不安になって調べた
- Map の value を全部かき集める方法がわからなくて調べた

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if (group.containsKey(sortedString)) {
                List<String> anagrams = group.get(sortedString);
                anagrams.add(str);
                group.put(sortedString, anagrams);
            } else {
                group.put(sortedString, new ArrayList<>(List.of(str)));
            }
        }
        return group.values().stream().toList();
    }
}
```
