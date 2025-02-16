package problems;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class IsValidParenthesesTest {
    @Test
    public void isValidParenthesesTest() {
        String s = "[]";
        assertEquals("Should be true", true, isValid1(s));
        s = "([])";
        assertEquals("Should be true", true, isValid1(s));
        s = "()[]{}";
        assertEquals("Should be true", true, isValid1(s));
        s= "(]";
        assertEquals("Should be false", false, isValid1(s));
        s= "({[)";
        assertEquals("Should be false", false, isValid1(s));

        s = "[]";
        assertEquals("Should be true", true, isValid2(s));
        s = "([])";
        assertEquals("Should be true", true, isValid2(s));
        s = "()[]{}";
        assertEquals("Should be true", true, isValid2(s));
        s= "(]";
        assertEquals("Should be false", false, isValid2(s));
        s= "({[)";
        assertEquals("Should be false", false, isValid2(s));

        s = "[]";
        assertEquals("Should be true", true, isValid3(s));
        s = "([])";
        assertEquals("Should be true", true, isValid3(s));
        s = "()[]{}";
        assertEquals("Should be true", true, isValid3(s));
        s= "(]";
        assertEquals("Should be false", false, isValid3(s));
        s= "({[)";
        assertEquals("Should be false", false, isValid3(s));
    }

    private boolean isValid1(String s) {
        Stack<Character> characterStack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (Character c : s.toCharArray()) {
            if (map.containsValue(c)) {
                characterStack.push(c);
            } else if (map.containsKey(c)) {
                if (characterStack.empty() || map.get(c) != characterStack.pop())
                    return false;
            }
        }
        return characterStack.empty();
    }

    private boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    private boolean isValid3(String s) {
        int i = -1;
        char[] stack = new char[s.length()];
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack[++i] = ch;
            else {
                if (i >= 0
                        && ((stack[i] == '(' && ch == ')')
                        || (stack[i] == '{' && ch == '}')
                        || (stack[i] == '[' && ch == ']')))
                    i--;
                else
                    return false;
            }
        }
        return i == -1;
    }
}
