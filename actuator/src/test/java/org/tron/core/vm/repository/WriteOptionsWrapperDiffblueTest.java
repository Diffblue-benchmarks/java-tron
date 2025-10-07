package org.tron.core.vm.repository;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.iq80.leveldb.WriteOptions;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WriteOptionsWrapperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link WriteOptionsWrapper}
   *   <li>{@link WriteOptionsWrapper#getLevel()}
   *   <li>{@link WriteOptionsWrapper#getRocks()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WriteOptionsWrapper.<init>()",
    "WriteOptions WriteOptionsWrapper.getLevel()",
    "org.rocksdb.WriteOptions WriteOptionsWrapper.getRocks()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    WriteOptionsWrapper actualWriteOptionsWrapper = new WriteOptionsWrapper();
    WriteOptions actualLevel = actualWriteOptionsWrapper.getLevel();

    // Assert
    assertNull(actualLevel);
    assertNull(actualWriteOptionsWrapper.getRocks());
  }
}
