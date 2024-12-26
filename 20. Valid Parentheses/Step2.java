/**
 * 特に問題なさそうなのでStep2でやめる
 */
class Step2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character character : s.toCharArray()) {
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
