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
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.iq80.leveldb.impl.SeekingIteratorAdapter;
import org.iq80.leveldb.util.Slice;
import org.iq80.leveldb.util.Slices;
import org.junit.Test;
import org.mockito.Mockito;

public class LevelDBIteratorDiffblueTest {
  /**
   * Method under test: {@link LevelDBIterator#valid()}
   */
  @Test
  public void testValid() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    when(iterator.hasNext()).thenReturn(true);

    // Act
    boolean actualValidResult = (new LevelDBIterator(iterator)).valid();

    // Assert
    verify(iterator).hasNext();
    assertTrue(actualValidResult);
  }

  /**
   * Method under test: {@link LevelDBIterator#valid()}
   */
  @Test
  public void testValid2() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    when(iterator.hasNext()).thenReturn(false);

    // Act
    boolean actualValidResult = (new LevelDBIterator(iterator)).valid();

    // Assert
    verify(iterator).hasNext();
    assertFalse(actualValidResult);
  }

  /**
   * Method under test: {@link LevelDBIterator#seek(byte[])}
   */
  @Test
  public void testSeek() throws UnsupportedEncodingException {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    doNothing().when(iterator).seek(Mockito.<byte[]>any());
    LevelDBIterator levelDBIterator = new LevelDBIterator(iterator);

    // Act
    levelDBIterator.seek("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    verify(iterator).seek(isA(byte[].class));
  }

  /**
   * Method under test: {@link LevelDBIterator#seekToFirst()}
   */
  @Test
  public void testSeekToFirst() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    doNothing().when(iterator).seekToFirst();

    // Act
    (new LevelDBIterator(iterator)).seekToFirst();

    // Assert that nothing has changed
    verify(iterator).seekToFirst();
  }

  /**
   * Method under test: {@link LevelDBIterator#seekToLast()}
   */
  @Test
  public void testSeekToLast() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    doNothing().when(iterator).seekToLast();

    // Act
    (new LevelDBIterator(iterator)).seekToLast();

    // Assert that nothing has changed
    verify(iterator).seekToLast();
  }

  /**
   * Method under test: {@link LevelDBIterator#hasNext()}
   */
  @Test
  public void testHasNext() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    when(iterator.hasNext()).thenReturn(true);

    // Act
    boolean actualHasNextResult = (new LevelDBIterator(iterator)).hasNext();

    // Assert
    verify(iterator).hasNext();
    assertTrue(actualHasNextResult);
  }

  /**
   * Method under test: {@link LevelDBIterator#hasNext()}
   */
  @Test
  public void testHasNext2() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    when(iterator.hasNext()).thenReturn(false);

    // Act
    boolean actualHasNextResult = (new LevelDBIterator(iterator)).hasNext();

    // Assert
    verify(iterator).hasNext();
    assertFalse(actualHasNextResult);
  }

  /**
   * Method under test: {@link LevelDBIterator#getKey()}
   */
  @Test
  public void testGetKey() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    Slice key = Slices.allocate(3);
    when(iterator.peekNext()).thenReturn(new SeekingIteratorAdapter.DbEntry(key, Slices.allocate(3)));

    // Act
    byte[] actualKey = (new LevelDBIterator(iterator)).getKey();

    // Assert
    verify(iterator).peekNext();
    assertArrayEquals(new byte[]{0, 0, 0}, actualKey);
  }

  /**
   * Method under test: {@link LevelDBIterator#getValue()}
   */
  @Test
  public void testGetValue() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    Slice key = Slices.allocate(3);
    when(iterator.peekNext()).thenReturn(new SeekingIteratorAdapter.DbEntry(key, Slices.allocate(3)));

    // Act
    byte[] actualValue = (new LevelDBIterator(iterator)).getValue();

    // Assert
    verify(iterator).peekNext();
    assertArrayEquals(new byte[]{0, 0, 0}, actualValue);
  }

  /**
   * Method under test: {@link LevelDBIterator#next()}
   */
  @Test
  public void testNext() {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    Slice key = Slices.allocate(3);
    SeekingIteratorAdapter.DbEntry dbEntry = new SeekingIteratorAdapter.DbEntry(key, Slices.allocate(3));

    when(iterator.next()).thenReturn(dbEntry);

    // Act
    Map.Entry<byte[], byte[]> actualNextResult = (new LevelDBIterator(iterator)).next();

    // Assert
    verify(iterator).next();
    assertSame(dbEntry, actualNextResult);
  }

  /**
   * Method under test: {@link LevelDBIterator#close()}
   */
  @Test
  public void testClose() throws IOException {
    // Arrange
    SeekingIteratorAdapter iterator = mock(SeekingIteratorAdapter.class);
    doNothing().when(iterator).close();

    // Act
    (new LevelDBIterator(iterator)).close();

    // Assert that nothing has changed
    verify(iterator).close();
  }
}
