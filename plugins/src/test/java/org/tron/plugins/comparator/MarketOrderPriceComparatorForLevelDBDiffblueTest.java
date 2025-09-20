package org.tron.plugins.comparator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MarketOrderPriceComparatorForLevelDBDiffblueTest {
  /**
   * Test {@link MarketOrderPriceComparatorForLevelDB#name()}.
   *
   * <p>Method under test: {@link MarketOrderPriceComparatorForLevelDB#name()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String MarketOrderPriceComparatorForLevelDB.name()"})
  public void testName() {
    // Arrange, Act and Assert
    assertEquals("MarketOrderPriceComparator", new MarketOrderPriceComparatorForLevelDB().name());
  }

  /**
   * Test {@link MarketOrderPriceComparatorForLevelDB#findShortestSeparator(byte[], byte[])}.
   *
   * <p>Method under test: {@link MarketOrderPriceComparatorForLevelDB#findShortestSeparator(byte[],
   * byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "byte[] MarketOrderPriceComparatorForLevelDB.findShortestSeparator(byte[], byte[])"
  })
  public void testFindShortestSeparator() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {},
        new MarketOrderPriceComparatorForLevelDB()
            .findShortestSeparator("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketOrderPriceComparatorForLevelDB#findShortSuccessor(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderPriceComparatorForLevelDB#findShortSuccessor(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderPriceComparatorForLevelDB.findShortSuccessor(byte[])"})
  public void testFindShortSuccessor() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualFindShortSuccessorResult =
        new MarketOrderPriceComparatorForLevelDB().findShortSuccessor("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(new byte[] {}, actualFindShortSuccessorResult);
  }
}
