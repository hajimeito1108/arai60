class Step1 {
    /**
     * 以前に個人的に解いたことがあった
     * 10分程で解けた
     * ただしleetcodeのsubmitでelse内の条件式が甘かったために一発では通らなかった。
     * stackの空チェックを忘れていた。初めにどの文字にも当てはまらないことを考慮すべきだった。
     * また、StringをCharArrayにするところは変数にしないでいきなり拡張forに入れることもできた。
     *
     * 時間計算量:O(n)
     * 空間計算量:O(n)
     */
    public boolean Ste(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (Character character : charArray) {
            if (character == '(') {
                stack.push(')');
            } else if (character == '[') {
                stack.push(']');
            } else if (character == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || character != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
