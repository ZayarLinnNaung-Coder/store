package devz.assessment.store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class MedianCalculatorTest {
    
    @Test
    @DisplayName("Test median calculation")
    void testCalculateMedian() {
        double result1 = calculateMedian(new int[]{1, 3}, new int[]{2});
        assertEquals(2.0, result1, 0.0001);

        double result2 = calculateMedian(new int[]{1, 2}, new int[]{3, 4});
        assertEquals(2.5, result2, 0.0001);
    }

    private double calculateMedian(int[] numbers1, int[] numbers2) {
        if (numbers1 == null || numbers2 == null) {
            throw new NullPointerException("Input arrays cannot be null");
        }
        
        int m = numbers1.length;
        int n = numbers2.length;
        
        if (m == 0 && n == 0) {
            throw new IllegalArgumentException("Both arrays cannot be empty");
        }

        int[] merged = new int[m + n];
        System.arraycopy(numbers1, 0, merged, 0, m);
        System.arraycopy(numbers2, 0, merged, m, n);

        Arrays.sort(merged);
        
        int totalLength = merged.length;

        if (totalLength % 2 == 1) {
            return merged[totalLength / 2];
        } else {
            int mid1 = merged[totalLength / 2 - 1];
            int mid2 = merged[totalLength / 2];
            return (mid1 + mid2) / 2.0;
        }
    }
}