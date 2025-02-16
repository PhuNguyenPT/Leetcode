package problems;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoveDuplicatesFromSortedArrayTest {
    private static final Logger log = LoggerFactory.getLogger(RemoveDuplicatesFromSortedArrayTest.class);

    @Test
    public void test() {
        int ans1 = removeDuplicates(new int[]{1,1,2});
        int ans2 = removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        log.info(String.valueOf(ans1));
        log.info(String.valueOf(ans2));
    }

    public int removeDuplicates(int[] nums) {
        int index = 1;

        for (int duplicateIndex = 1; duplicateIndex < nums.length; duplicateIndex++) {
            if (nums[duplicateIndex] != nums[duplicateIndex - 1]) {
                nums[index] = nums[duplicateIndex];
                index++;
            }

        }
        return index;
    }
}
