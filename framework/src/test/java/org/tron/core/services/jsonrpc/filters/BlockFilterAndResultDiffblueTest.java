package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BlockFilterAndResultDiffblueTest {
  /**
   * Method under test: {@link BlockFilterAndResult#add(String)}
   */
  @Test
  public void testAdd() {
    // Arrange
    BlockFilterAndResult blockFilterAndResult = new BlockFilterAndResult();

    // Act
    blockFilterAndResult.add("foo");

    // Assert
    assertEquals(1, blockFilterAndResult.getResult().size());
  }

  /**
   * Method under test: {@link BlockFilterAndResult#popAll()}
   */
  @Test
  public void testPopAll() {
    // Arrange, Act and Assert
    assertTrue((new BlockFilterAndResult()).popAll().isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link BlockFilterAndResult}
   */
  @Test
  public void testNewBlockFilterAndResult() {
    // Arrange, Act and Assert
    assertTrue((new BlockFilterAndResult()).getResult().isEmpty());
  }
}
