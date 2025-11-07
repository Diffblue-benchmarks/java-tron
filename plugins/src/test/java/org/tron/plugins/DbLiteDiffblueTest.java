package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DbLiteDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DbLite.BlockNumInfo#getHistoryMaxNum()}
   *   <li>{@link DbLite.BlockNumInfo#getSnapshotMaxNum()}
   *   <li>{@link DbLite.BlockNumInfo#getSnapshotMinNum()}
   * </ul>
   */
  @Test
  public void testBlockNumInfoGettersAndSetters() {
    // Arrange
    DbLite.BlockNumInfo blockNumInfo = new DbLite.BlockNumInfo(1L, 1L, 1L);

    // Act
    long actualHistoryMaxNum = blockNumInfo.getHistoryMaxNum();
    long actualSnapshotMaxNum = blockNumInfo.getSnapshotMaxNum();

    // Assert
    assertEquals(1L, actualHistoryMaxNum);
    assertEquals(1L, actualSnapshotMaxNum);
    assertEquals(1L, blockNumInfo.getSnapshotMinNum());
  }

  /**
   * Method under test: {@link DbLite.BlockNumInfo#BlockNumInfo(long, long, long)}
   */
  @Test
  public void testBlockNumInfoNewBlockNumInfo() {
    // Arrange and Act
    DbLite.BlockNumInfo actualBlockNumInfo = new DbLite.BlockNumInfo(1L, 1L, 1L);

    // Assert
    assertEquals(1L, actualBlockNumInfo.getHistoryMaxNum());
    assertEquals(1L, actualBlockNumInfo.getSnapshotMaxNum());
    assertEquals(1L, actualBlockNumInfo.getSnapshotMinNum());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DbLite}
   *   <li>{@link DbLite#reSetRecentBlks()}
   *   <li>{@link DbLite#setRecentBlks(long)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DbLite actualDbLite = new DbLite();
    actualDbLite.reSetRecentBlks();
    actualDbLite.setRecentBlks(1L);

    // Assert
    assertNull(actualDbLite.spec);
  }
}
