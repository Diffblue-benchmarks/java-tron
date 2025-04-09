package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BlockFilterAndResultDiffblueTest {
  /**
   * Test new {@link BlockFilterAndResult} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BlockFilterAndResult}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockFilterAndResult.<init>()"})
  public void testNewBlockFilterAndResult() {
    // Arrange, Act and Assert
    assertTrue((new BlockFilterAndResult()).getResult().isEmpty());
  }

  /**
   * Test {@link BlockFilterAndResult#add(String)} with {@code String}.
   * <p>
   * Method under test: {@link BlockFilterAndResult#add(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockFilterAndResult.add(String)"})
  public void testAddWithString() {
    // Arrange
    BlockFilterAndResult blockFilterAndResult = new BlockFilterAndResult();

    // Act
    blockFilterAndResult.add("foo");

    // Assert
    assertEquals(1, blockFilterAndResult.getResult().size());
  }

  /**
   * Test {@link BlockFilterAndResult#popAll()}.
   * <p>
   * Method under test: {@link BlockFilterAndResult#popAll()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List BlockFilterAndResult.popAll()"})
  public void testPopAll() {
    // Arrange, Act and Assert
    assertTrue((new BlockFilterAndResult()).popAll().isEmpty());
  }
}
