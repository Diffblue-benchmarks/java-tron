package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class MarketOrderPriceComparatorForLevelDBDiffblueTest {
  /**
   * Method under test: {@link MarketOrderPriceComparatorForLevelDB#name()}
   */
  @Test
  public void testName() {
    // Arrange, Act and Assert
    assertEquals("MarketOrderPriceComparator", (new MarketOrderPriceComparatorForLevelDB()).name());
  }

  /**
   * Method under test:
   * {@link MarketOrderPriceComparatorForLevelDB#findShortestSeparator(byte[], byte[])}
   */
  @Test
  public void testFindShortestSeparator() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderPriceComparatorForLevelDB marketOrderPriceComparatorForLevelDB = new MarketOrderPriceComparatorForLevelDB();
    byte[] start = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0,
        marketOrderPriceComparatorForLevelDB.findShortestSeparator(start, "AXAXAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Method under test:
   * {@link MarketOrderPriceComparatorForLevelDB#findShortSuccessor(byte[])}
   */
  @Test
  public void testFindShortSuccessor() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderPriceComparatorForLevelDB marketOrderPriceComparatorForLevelDB = new MarketOrderPriceComparatorForLevelDB();

    // Act and Assert
    assertEquals(0, marketOrderPriceComparatorForLevelDB.findShortSuccessor("AXAXAXAX".getBytes("UTF-8")).length);
  }
}
