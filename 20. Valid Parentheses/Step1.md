## 問題理解

'(', ')',
'{', '}',
'[', ']'

1. 開始のブラケットと同じ種類のブラケットで閉じていること
2. 開始のブラケットは正しい順序で閉じていること
3. すべての終了ブラケットは同じ種類の開始ブラケットと呼応していること

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

## 解法

まず思いつくのが、
ブラケットのペアをつくる
開始のブラケットが来たら、スタックに終了のブラケットをつんでいく。
終了のブラケットが来たら、スタックから値を取り出して比較検討。
同じならつぎへ、同じでなかったらfalseを返す。

```Java
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mapOfBlackets = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
        );

        Stack<Character> stackBlackets = new Stack<>();
        for (Character blacket : s.toCharArray()) {
            if (mapOfBlackets.containsKey(blacket)) {
                stackBlackets.push(mapOfBlackets.get(blacket));
            } else {
                // 空 の場合
                if (stackBlackets.isEmpty()) {
                    return false;
                }
                Character target = stackBlackets.pop();
                if (!blacket.equals(target)) {
                    return false;
                }
            }
        }
        // この行を忘れていた、leetcodeで実行後に気づいた
        // 1文字しかない場合の考慮がされていないのでやはり最初にテストケースを出すのが効果的か？
        return stackBlackets.isEmpty();
    }
}
```
