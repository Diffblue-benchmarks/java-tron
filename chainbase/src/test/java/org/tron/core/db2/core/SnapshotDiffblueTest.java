package org.tron.core.db2.core;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SnapshotDiffblueTest {
  /**
   * Test {@link Snapshot#isRoot(Snapshot)}.
   * <p>
   * Method under test: {@link Snapshot#isRoot(Snapshot)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Snapshot.isRoot(Snapshot)"})
  public void testIsRoot() {
    // Arrange, Act and Assert
    assertFalse(Snapshot.isRoot(null));
  }

  /**
   * Test {@link Snapshot#isImpl(Snapshot)}.
   * <p>
   * Method under test: {@link Snapshot#isImpl(Snapshot)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Snapshot.isImpl(Snapshot)"})
  public void testIsImpl() {
    // Arrange, Act and Assert
    assertFalse(Snapshot.isImpl(null));
  }
}
