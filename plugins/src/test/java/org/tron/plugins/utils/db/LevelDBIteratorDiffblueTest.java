package org.tron.plugins.utils.db;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;
import org.iq80.leveldb.impl.SeekingIteratorAdapter;
import org.iq80.leveldb.impl.SeekingIteratorAdapter.DbEntry;
import org.iq80.leveldb.util.Slice;
import org.iq80.leveldb.util.Slices;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class LevelDBIteratorDiffblueTest {
  /**
   * Test {@link LevelDBIterator#valid()}.
   *
   * <ul>
   *   <li>Given {@link SeekingIteratorAdapter} {@link SeekingIteratorAdapter#hasNext()} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBIterator#valid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LevelDBIterator.valid()"})
  public void testValid_givenSeekingIteratorAdapterHasNextReturnFalse_thenReturnFalse() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    when(iterator.hasNext()).thenReturn(false);

    // Act
    boolean actualValidResult = new LevelDBIterator(iterator).valid();

    // Assert
    verify(iterator).hasNext();
    assertFalse(actualValidResult);
  }

  /**
   * Test {@link LevelDBIterator#valid()}.
   *
   * <ul>
   *   <li>Given {@link SeekingIteratorAdapter} {@link SeekingIteratorAdapter#hasNext()} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBIterator#valid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LevelDBIterator.valid()"})
  public void testValid_givenSeekingIteratorAdapterHasNextReturnTrue_thenReturnTrue() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    when(iterator.hasNext()).thenReturn(true);

    // Act
    boolean actualValidResult = new LevelDBIterator(iterator).valid();

    // Assert
    verify(iterator).hasNext();
    assertTrue(actualValidResult);
  }

  /**
   * Test {@link LevelDBIterator#seek(byte[])}.
   *
   * <ul>
   *   <li>Given {@link SeekingIteratorAdapter} {@link SeekingIteratorAdapter#seek(byte[])} does
   *       nothing.
   *   <li>Then calls {@link SeekingIteratorAdapter#seek(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBIterator#seek(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LevelDBIterator.seek(byte[])"})
  public void testSeek_givenSeekingIteratorAdapterSeekDoesNothing_thenCallsSeek()
      throws UnsupportedEncodingException {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    doNothing().when(iterator).seek(Mockito.<byte[]>any());

    // Act
    new LevelDBIterator(iterator).seek("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(iterator).seek(isA(byte[].class));
  }

  /**
   * Test {@link LevelDBIterator#seekToFirst()}.
   *
   * <ul>
   *   <li>Then calls {@link SeekingIteratorAdapter#seekToFirst()}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBIterator#seekToFirst()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LevelDBIterator.seekToFirst()"})
  public void testSeekToFirst_thenCallsSeekToFirst() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    doNothing().when(iterator).seekToFirst();

    // Act
    new LevelDBIterator(iterator).seekToFirst();

    // Assert
    verify(iterator).seekToFirst();
  }

  /**
   * Test {@link LevelDBIterator#seekToLast()}.
   *
   * <ul>
   *   <li>Then calls {@link SeekingIteratorAdapter#seekToLast()}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBIterator#seekToLast()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LevelDBIterator.seekToLast()"})
  public void testSeekToLast_thenCallsSeekToLast() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    doNothing().when(iterator).seekToLast();

    // Act
    new LevelDBIterator(iterator).seekToLast();

    // Assert
    verify(iterator).seekToLast();
  }

  /**
   * Test {@link LevelDBIterator#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link SeekingIteratorAdapter} {@link SeekingIteratorAdapter#hasNext()} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBIterator#hasNext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LevelDBIterator.hasNext()"})
  public void testHasNext_givenSeekingIteratorAdapterHasNextReturnFalse_thenReturnFalse() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    when(iterator.hasNext()).thenReturn(false);

    // Act
    boolean actualHasNextResult = new LevelDBIterator(iterator).hasNext();

    // Assert
    verify(iterator).hasNext();
    assertFalse(actualHasNextResult);
  }

  /**
   * Test {@link LevelDBIterator#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link SeekingIteratorAdapter} {@link SeekingIteratorAdapter#hasNext()} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBIterator#hasNext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LevelDBIterator.hasNext()"})
  public void testHasNext_givenSeekingIteratorAdapterHasNextReturnTrue_thenReturnTrue() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    when(iterator.hasNext()).thenReturn(true);

    // Act
    boolean actualHasNextResult = new LevelDBIterator(iterator).hasNext();

    // Assert
    verify(iterator).hasNext();
    assertTrue(actualHasNextResult);
  }

  /**
   * Test {@link LevelDBIterator#getKey()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBIterator#getKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LevelDBIterator.getKey()"})
  public void testGetKey_thenReturnArrayOfByteWithZeroAndZero() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    Slice key = Slices.allocate(3);
    DbEntry dbEntry = new DbEntry(key, Slices.allocate(3));
    when(iterator.peekNext()).thenReturn(dbEntry);

    // Act
    byte[] actualKey = new LevelDBIterator(iterator).getKey();

    // Assert
    verify(iterator).peekNext();
    assertArrayEquals(new byte[] {0, 0, 0}, actualKey);
  }

  /**
   * Test {@link LevelDBIterator#getValue()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBIterator#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LevelDBIterator.getValue()"})
  public void testGetValue_thenReturnArrayOfByteWithZeroAndZero() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    Slice key = Slices.allocate(3);
    DbEntry dbEntry = new DbEntry(key, Slices.allocate(3));
    when(iterator.peekNext()).thenReturn(dbEntry);

    // Act
    byte[] actualValue = new LevelDBIterator(iterator).getValue();

    // Assert
    verify(iterator).peekNext();
    assertArrayEquals(new byte[] {0, 0, 0}, actualValue);
  }

  /**
   * Test {@link LevelDBIterator#next()}.
   *
   * <ul>
   *   <li>Then return {@link DbEntry#DbEntry(Slice, Slice)} with key is allocate three and value is
   *       allocate three.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBIterator#next()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entry LevelDBIterator.next()"})
  public void testNext_thenReturnDbEntryWithKeyIsAllocateThreeAndValueIsAllocateThree() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    Slice key = Slices.allocate(3);
    DbEntry dbEntry = new DbEntry(key, Slices.allocate(3));
    when(iterator.next()).thenReturn(dbEntry);

    // Act
    Entry<byte[], byte[]> actualNextResult = new LevelDBIterator(iterator).next();

    // Assert
    verify(iterator).next();
    assertSame(dbEntry, actualNextResult);
  }

  /**
   * Test {@link LevelDBIterator#close()}.
   *
   * <ul>
   *   <li>Given {@link SeekingIteratorAdapter} {@link SeekingIteratorAdapter#close()} does nothing.
   *   <li>Then calls {@link SeekingIteratorAdapter#close()}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBIterator#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LevelDBIterator.close()"})
  public void testClose_givenSeekingIteratorAdapterCloseDoesNothing_thenCallsClose()
      throws IOException {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    doNothing().when(iterator).close();
    try (LevelDBIterator levelDBIterator = new LevelDBIterator(iterator)) {}

    // Act and Assert
    verify(iterator).close();
  }
}
