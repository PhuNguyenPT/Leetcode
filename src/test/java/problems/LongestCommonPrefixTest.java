package problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class LongestCommonPrefixTest {
    @Test
    public void longestCommonPrefixTest() {
        String[] strings = new String[]{"flower", "flow", "flight"};
        assertEquals("Should be true", "fl", longestCommonPrefix(strings));
        strings = new String[]{"dog","race_car","car"};
        assertEquals("Should be empty", "", longestCommonPrefix(strings));
    }

    private String longestCommonPrefix(String[] strings) {
        StringBuilder str = new StringBuilder();
        Arrays.sort(strings);
        String first = strings[0];
        String last = strings[strings.length - 1];
        int length = Math.min(first.length(), last.length());
        for (int i = 0; i < length; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return str.toString();
            }
            str.append(first.charAt(i));
        }
        return str.toString();
    }


}
