package problems;

import org.apache.logging.log4j.util.StringBuilders;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.util.AssertionErrors;
import org.springframework.util.Assert;

import java.util.*;

public class KeyboardRowTest {
    private static final Logger log = LoggerFactory.getLogger(KeyboardRowTest.class);

    @Test
    public void test() {
        String[] case1 = {"Hello", "Alaska", "Dad", "Peace"};
        String[] case2 = {"omk"};
        String[] case3 = {"adsdf","sfd"};
        log.info(Arrays.toString(findWords(case1)));
        log.info(Arrays.toString(findWords(case2)));
        log.info(Arrays.toString(findWords(case3)));
    }

    private String[] findWords(String[] words) {
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";
        List<String> rows = Arrays.asList(firstRow, secondRow, thirdRow);

        List<String> output = new ArrayList<>();

        for (String word : words) {
            for (String row : rows) {
                if (isInRow(word, row)) {
                    output.add(word);
                    break;
                }
            }
        }
        return output.toArray(new String[0]);
    }

    private boolean isInRow(String word, String row) {
        for (char c : word.toCharArray()) {
            if (row.indexOf(Character.toLowerCase(c)) < 0) {
                return false;
            }
        }
        return true;
    }
}


