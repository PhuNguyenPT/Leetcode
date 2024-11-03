package problems;

import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class IsPalindromeTest {
    @Test
    public void isPalindrome() {
        assertEquals("Should be true", true, isPalindrome(121));
        assertEquals("Should be false", false, isPalindrome(-121));
        assertEquals("Should be false", false, isPalindrome(10));
    }

    private boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) { return false; }
        int reversed=0;
        int temp=x;
        while (temp > reversed) {
            reversed=reversed*10+temp%10;
            temp=temp/10;
        }
        return temp==reversed || temp==reversed/10;
    }
}
