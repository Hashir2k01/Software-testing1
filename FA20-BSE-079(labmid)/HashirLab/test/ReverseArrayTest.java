import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseArrayTest {

    @Test
    public void testReverseOddLengthArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        ReverseArray.reverseArray(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testReverseEvenLengthArray() {
        int[] input = {1, 2, 3, 4, 5, 6};
        int[] expected = {6, 5, 4, 3, 2, 1};
        ReverseArray.reverseArray(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testReverseSingleElementArray() {
        int[] input = {1};
        int[] expected = {1};
        ReverseArray.reverseArray(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testReverseEmptyArray() {
        int[] input = {};
        int[] expected = {}; // Empty array remains empty after reversal
        ReverseArray.reverseArray(input);
        assertArrayEquals(expected, input);
    }

    // Additional test cases (consider these for robustness)
    @Test
    public void testReverseLargeArray() {
        int[] input = new int[1000]; // Create a large array
        for (int i = 0; i < input.length; i++) {
            input[i] = i + 1; // Fill the array with sequential numbers
        }
        int[] expected = new int[input.length]; // Create a reversed copy
        for (int i = 0; i < input.length; i++) {
            expected[i] = input[input.length - 1 - i];
        }
        ReverseArray.reverseArray(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testReverseArrayWithNegativeNumbers() {
        int[] input = {-1, 2, -3, 4, -5};
        int[] expected = {-5, 4, -3, 2, -1};
        ReverseArray.reverseArray(input);
        assertArrayEquals(expected, input);
    }
}
