import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RemoveDuplicatesTest {

  @Test
  public void testRemoveDuplicatesEmptyArray() {
    int[] input = {};
    int expectedLength = 0;
    int newLength = RemoveDuplicates.removeDuplicates(input);
    assertArrayEquals(input, Arrays.copyOf(input, newLength));
  }

  @Test
  public void testRemoveDuplicatesSingleElementArray() {
    int[] input = {1};
    int expectedLength = 1;
    int newLength = RemoveDuplicates.removeDuplicates(input);
    assertArrayEquals(input, Arrays.copyOf(input, newLength));
  }

  @Test
  public void testRemoveDuplicatesAllDuplicates() {
    int[] input = {1, 1, 1, 1};
    int expectedLength = 1;
    int[] expectedArray = {1};
    int newLength = RemoveDuplicates.removeDuplicates(input);
    assertArrayEquals(expectedArray, Arrays.copyOf(input, newLength));
  }

  @Test
  public void testRemoveDuplicatesSomeDuplicates() {
    int[] input = {1, 2, 2, 3, 4, 4, 5};
    int expectedLength = 5;
    int[] expectedArray = {1, 2, 3, 4, 5};
    int newLength = RemoveDuplicates.removeDuplicates(input);
    assertArrayEquals(expectedArray, Arrays.copyOf(input, newLength));
  }
}