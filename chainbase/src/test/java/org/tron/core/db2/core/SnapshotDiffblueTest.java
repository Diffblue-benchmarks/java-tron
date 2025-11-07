package org.tron.core.db2.core;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class SnapshotDiffblueTest {
  /**
   * Method under test: {@link Snapshot#isRoot(Snapshot)}
   */
  @Test
  public void testIsRoot() {
    // Arrange, Act and Assert
    assertFalse(Snapshot.isRoot(null));
  }

  /**
   * Method under test: {@link Snapshot#isImpl(Snapshot)}
   */
  @Test
  public void testIsImpl() {
    // Arrange, Act and Assert
    assertFalse(Snapshot.isImpl(null));
  }
}
