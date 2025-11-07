package org.tron.core.db.common.iterator;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.NoSuchElementException;
import org.junit.Test;
import org.rocksdb.RocksIterator;

public class DBIteratorDiffblueTest {
  /**
   * Method under test: {@link DBIterator#checkValid()}
   */
  @Test
  public void testCheckValid() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(true);

    // Act
    (new RockStoreIterator(dbIterator)).checkValid();

    // Assert that nothing has changed
    verify(dbIterator).isValid();
  }

  /**
   * Method under test: {@link DBIterator#checkValid()}
   */
  @Test
  public void testCheckValid2() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new RockStoreIterator(dbIterator)).checkValid());
    verify(dbIterator).isValid();
  }
}
