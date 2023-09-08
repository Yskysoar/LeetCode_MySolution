import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        boolean res = solution20.isValid3("{[]}");
        System.out.println(res);
    }
    public boolean isValid1(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }//奇数个括号直接排除，长度一定大于0所以不考虑空数组的情况
        for (int i = 0; i < length / 2; i++) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.length() == 0;
    }

    public boolean isValid2(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }//奇数个括号直接排除，长度一定大于0所以不考虑空数组的情况
        Map<Character, Character> pairs = new HashMap<Character, Character> () {
            {
                put(')','(');
                put('}','{');
                put(']','[');
            }
        };
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < length; i++) {
            if (pairs.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.peek() != pairs.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid3(String s) {
        int length = s.length();
        int top = -1;
        if (length % 2 != 0) {
            return false;
        }//奇数个括号直接排除，长度一定大于0所以不考虑空数组的情况
        String[] arrays = new String[length];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(', '{', '[' -> {
                    top++;
                    arrays[top] = s.charAt(i) + "";
                }
                case ')' -> {
                    if (top == -1 || !arrays[top].equals("(")) {
                        return false;
                    }
                    top--;
                }
                case '}' -> {
                    if (top == -1 || !arrays[top].equals("{")) {
                        return false;
                    }
                    top--;
                }
                case ']' -> {
                    if (top == -1 || !arrays[top].equals("[")) {
                        return false;
                    }
                    top--;
                }
            }
        }
        return top == -1;
    }
}
