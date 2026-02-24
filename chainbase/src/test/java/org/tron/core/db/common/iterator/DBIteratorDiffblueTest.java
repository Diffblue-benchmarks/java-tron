package org.tron.core.db.common.iterator;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.NoSuchElementException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.rocksdb.RocksIterator;

public class DBIteratorDiffblueTest {
  /**
   * Test {@link DBIterator#checkValid()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#isValid()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DBIterator#checkValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DBIterator.checkValid()"})
  public void testCheckValid_givenRocksIteratorIsValidReturnFalse() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> new RockStoreIterator(dbIterator).checkValid());
    verify(dbIterator).isValid();
  }

  /**
   * Test {@link DBIterator#checkValid()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#isValid()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DBIterator#checkValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DBIterator.checkValid()"})
  public void testCheckValid_givenRocksIteratorIsValidReturnTrue() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(true);

    // Act
    new RockStoreIterator(dbIterator).checkValid();

    // Assert
    verify(dbIterator).isValid();
  }

  /**
   * Test {@link DBIterator#checkValid()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#isValid()} throw {@link
   *       NoSuchElementException#NoSuchElementException()}.
   * </ul>
   *
   * <p>Method under test: {@link DBIterator#checkValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DBIterator.checkValid()"})
  public void testCheckValid_givenRocksIteratorIsValidThrowNoSuchElementException() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenThrow(new NoSuchElementException());

    // Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> new RockStoreIterator(dbIterator).checkValid());
    verify(dbIterator).isValid();
  }
}
