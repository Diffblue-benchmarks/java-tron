package org.tron.core.db.common.iterator;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.NoSuchElementException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.rocksdb.AbstractRocksIterator;
import org.rocksdb.RocksIterator;

public class DBIteratorDiffblueTest {
  /**
   * Test {@link DBIterator#checkValid()}.
   * <ul>
   *   <li>Given {@link RocksIterator} {@link AbstractRocksIterator#isValid()} return {@code true}.</li>
   *   <li>Then calls {@link AbstractRocksIterator#isValid()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DBIterator#checkValid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DBIterator.checkValid()"})
  public void testCheckValid_givenRocksIteratorIsValidReturnTrue_thenCallsIsValid() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(true);

    // Act
    (new RockStoreIterator(dbIterator)).checkValid();

    // Assert
    verify(dbIterator).isValid();
  }

  /**
   * Test {@link DBIterator#checkValid()}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DBIterator#checkValid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DBIterator.checkValid()"})
  public void testCheckValid_thenThrowNoSuchElementException() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new RockStoreIterator(dbIterator)).checkValid());
    verify(dbIterator).isValid();
  }
}
