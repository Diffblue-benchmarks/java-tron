package org.tron.core.vm.repository;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class WriteOptionsWrapperDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link WriteOptionsWrapper}
   *   <li>{@link WriteOptionsWrapper#getLevel()}
   *   <li>{@link WriteOptionsWrapper#getRocks()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    WriteOptionsWrapper actualWriteOptionsWrapper = new WriteOptionsWrapper();
    org.iq80.leveldb.WriteOptions actualLevel = actualWriteOptionsWrapper.getLevel();

    // Assert
    assertNull(actualLevel);
    assertNull(actualWriteOptionsWrapper.getRocks());
  }
}
