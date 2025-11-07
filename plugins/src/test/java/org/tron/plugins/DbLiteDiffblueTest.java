package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.plugins.DbLite.BlockNumInfo;

public class DbLiteDiffblueTest {
  /**
   * Test BlockNumInfo getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlockNumInfo#getHistoryMaxNum()}
   *   <li>{@link BlockNumInfo#getSnapshotMaxNum()}
   *   <li>{@link BlockNumInfo#getSnapshotMinNum()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BlockNumInfo.getHistoryMaxNum()", "long BlockNumInfo.getSnapshotMaxNum()",
      "long BlockNumInfo.getSnapshotMinNum()"})
  public void testBlockNumInfoGettersAndSetters() {
    // Arrange
    BlockNumInfo blockNumInfo = new BlockNumInfo(1L, 1L, 1L);

    // Act
    long actualHistoryMaxNum = blockNumInfo.getHistoryMaxNum();
    long actualSnapshotMaxNum = blockNumInfo.getSnapshotMaxNum();

    // Assert
    assertEquals(1L, actualHistoryMaxNum);
    assertEquals(1L, actualSnapshotMaxNum);
    assertEquals(1L, blockNumInfo.getSnapshotMinNum());
  }

  /**
   * Test BlockNumInfo {@link BlockNumInfo#BlockNumInfo(long, long, long)}.
   * <p>
   * Method under test: {@link BlockNumInfo#BlockNumInfo(long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockNumInfo.<init>(long, long, long)"})
  public void testBlockNumInfoNewBlockNumInfo() {
    // Arrange and Act
    BlockNumInfo actualBlockNumInfo = new BlockNumInfo(1L, 1L, 1L);

    // Assert
    assertEquals(1L, actualBlockNumInfo.getHistoryMaxNum());
    assertEquals(1L, actualBlockNumInfo.getSnapshotMaxNum());
    assertEquals(1L, actualBlockNumInfo.getSnapshotMinNum());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DbLite}
   *   <li>{@link DbLite#reSetRecentBlks()}
   *   <li>{@link DbLite#setRecentBlks(long)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DbLite.<init>()", "void DbLite.reSetRecentBlks()", "void DbLite.setRecentBlks(long)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    DbLite actualDbLite = new DbLite();
    actualDbLite.reSetRecentBlks();
    actualDbLite.setRecentBlks(1L);

    // Assert
    assertNull(actualDbLite.spec);
  }
}
