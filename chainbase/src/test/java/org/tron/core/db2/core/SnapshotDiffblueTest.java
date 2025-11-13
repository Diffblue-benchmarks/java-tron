package org.tron.core.db2.core;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SnapshotDiffblueTest {
  /**
   * Test {@link Snapshot#isRoot(Snapshot)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Snapshot#isRoot(Snapshot)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Snapshot.isRoot(Snapshot)"})
  public void testIsRoot_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Snapshot.isRoot(null));
  }

  /**
   * Test {@link Snapshot#isImpl(Snapshot)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Snapshot#isImpl(Snapshot)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Snapshot.isImpl(Snapshot)"})
  public void testIsImpl_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Snapshot.isImpl(null));
  }
}
