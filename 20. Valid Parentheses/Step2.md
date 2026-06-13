## 解法

'(', ')', '{', '}', '[', ']' の組み合わせしかないのでmapで持つ。

先頭文字かの確認  
先頭文字でない場合はstackからpollして照合。
対応する文字をStackで積む

15分くらいで以下の回答。

```java
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> bracketMap = new HashMap<>();
            bracketMap.put('(', ')');
            bracketMap.put('{', '}');
            bracketMap.put('[', ']');

            Stack<Character> stack = new Stack<>();
            for (Character bracket : s.toCharArray()) {
                if (bracketMap.containsKey(bracket)) {
                    stack.push(bracketMap.get(bracket));
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!bracket.equals(stack.pop())) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
```
