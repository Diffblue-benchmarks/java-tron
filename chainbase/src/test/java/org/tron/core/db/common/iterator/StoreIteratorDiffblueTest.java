package org.tron.core.db.common.iterator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.iq80.leveldb.DBIterator;
import org.junit.Test;
import org.mockito.Mockito;

public class StoreIteratorDiffblueTest {
  /**
   * Method under test: {@link StoreIterator#close()}
   */
  @Test
  public void testClose() throws IOException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doNothing().when(dbIterator).close();

    // Act
    (new StoreIterator(dbIterator)).close();

    // Assert
    verify(dbIterator).close();
  }

  /**
   * Method under test: {@link StoreIterator#close()}
   */
  @Test
  public void testClose2() throws IOException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doThrow(new NoSuchElementException("foo")).when(dbIterator).close();

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).close());
    verify(dbIterator).close();
  }

  /**
   * Method under test: {@link StoreIterator#hasNext()}
   */
  @Test
  public void testHasNext() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    when(dbIterator.hasNext()).thenReturn(true);
    doNothing().when(dbIterator).seekToFirst();

    // Act
    boolean actualHasNextResult = (new StoreIterator(dbIterator)).hasNext();

    // Assert
    verify(dbIterator).hasNext();
    verify(dbIterator).seekToFirst();
    assertTrue(actualHasNextResult);
  }

  /**
   * Method under test: {@link StoreIterator#hasNext()}
   */
  @Test
  public void testHasNext2() throws IOException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    when(dbIterator.hasNext()).thenReturn(false);
    doNothing().when(dbIterator).close();
    doNothing().when(dbIterator).seekToFirst();

    // Act
    boolean actualHasNextResult = (new StoreIterator(dbIterator)).hasNext();

    // Assert
    verify(dbIterator).close();
    verify(dbIterator).hasNext();
    verify(dbIterator).seekToFirst();
    assertFalse(actualHasNextResult);
  }

  /**
   * Method under test: {@link StoreIterator#hasNext()}
   */
  @Test
  public void testHasNext3() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doNothing().when(dbIterator).seek(Mockito.<byte[]>any());
    when(dbIterator.hasNext()).thenReturn(true);

    StoreIterator storeIterator = new StoreIterator(dbIterator);
    storeIterator.seek(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    boolean actualHasNextResult = storeIterator.hasNext();

    // Assert
    verify(dbIterator).hasNext();
    verify(dbIterator).seek(isA(byte[].class));
    assertTrue(actualHasNextResult);
  }

  /**
   * Method under test: {@link StoreIterator#next()}
   */
  @Test
  public void testNext() throws UnsupportedEncodingException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    AbstractMap.SimpleEntry<byte[], byte[]> simpleEntry = new AbstractMap.SimpleEntry<>(bytes,
        "AXAXAXAX".getBytes("UTF-8"));

    when(dbIterator.next()).thenReturn(simpleEntry);

    // Act
    Map.Entry<byte[], byte[]> actualNextResult = (new StoreIterator(dbIterator)).next();

    // Assert
    verify(dbIterator).next();
    assertSame(simpleEntry, actualNextResult);
  }

  /**
   * Method under test: {@link StoreIterator#next()}
   */
  @Test
  public void testNext2() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    when(dbIterator.next()).thenThrow(new NoSuchElementException("foo"));

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).next());
    verify(dbIterator).next();
  }

  /**
   * Method under test: {@link StoreIterator#remove()}
   */
  @Test
  public void testRemove() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new StoreIterator(mock(DBIterator.class))).remove());
  }

  /**
   * Method under test: {@link StoreIterator#seek(byte[])}
   */
  @Test
  public void testSeek() throws UnsupportedEncodingException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doNothing().when(dbIterator).seek(Mockito.<byte[]>any());
    StoreIterator storeIterator = new StoreIterator(dbIterator);

    // Act
    storeIterator.seek("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(dbIterator).seek(isA(byte[].class));
  }

  /**
   * Method under test: {@link StoreIterator#seek(byte[])}
   */
  @Test
  public void testSeek2() throws UnsupportedEncodingException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doThrow(new NoSuchElementException("foo")).when(dbIterator).seek(Mockito.<byte[]>any());
    StoreIterator storeIterator = new StoreIterator(dbIterator);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> storeIterator.seek("AXAXAXAX".getBytes("UTF-8")));
    verify(dbIterator).seek(isA(byte[].class));
  }

  /**
   * Method under test: {@link StoreIterator#seekToFirst()}
   */
  @Test
  public void testSeekToFirst() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doNothing().when(dbIterator).seekToFirst();

    // Act
    (new StoreIterator(dbIterator)).seekToFirst();

    // Assert
    verify(dbIterator).seekToFirst();
  }

  /**
   * Method under test: {@link StoreIterator#seekToFirst()}
   */
  @Test
  public void testSeekToFirst2() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doThrow(new NoSuchElementException("foo")).when(dbIterator).seekToFirst();

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).seekToFirst());
    verify(dbIterator).seekToFirst();
  }

  /**
   * Method under test: {@link StoreIterator#seekToLast()}
   */
  @Test
  public void testSeekToLast() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doNothing().when(dbIterator).seekToLast();

    // Act
    (new StoreIterator(dbIterator)).seekToLast();

    // Assert
    verify(dbIterator).seekToLast();
  }

  /**
   * Method under test: {@link StoreIterator#seekToLast()}
   */
  @Test
  public void testSeekToLast2() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doThrow(new NoSuchElementException("foo")).when(dbIterator).seekToLast();

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).seekToLast());
    verify(dbIterator).seekToLast();
  }

  /**
   * Method under test: {@link StoreIterator#valid()}
   */
  @Test
  public void testValid() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    when(dbIterator.hasNext()).thenReturn(true);

    // Act
    boolean actualValidResult = (new StoreIterator(dbIterator)).valid();

    // Assert
    verify(dbIterator).hasNext();
    assertTrue(actualValidResult);
  }

  /**
   * Method under test: {@link StoreIterator#valid()}
   */
  @Test
  public void testValid2() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    when(dbIterator.hasNext()).thenReturn(false);

    // Act
    boolean actualValidResult = (new StoreIterator(dbIterator)).valid();

    // Assert
    verify(dbIterator).hasNext();
    assertFalse(actualValidResult);
  }

  /**
   * Method under test: {@link StoreIterator#valid()}
   */
  @Test
  public void testValid3() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    when(dbIterator.hasNext()).thenThrow(new NoSuchElementException("foo"));

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).valid());
    verify(dbIterator).hasNext();
  }

  /**
   * Method under test: {@link StoreIterator#getKey()}
   */
  @Test
  public void testGetKey() throws UnsupportedEncodingException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    when(dbIterator.peekNext()).thenReturn(new AbstractMap.SimpleEntry<>(bytes, "AXAXAXAX".getBytes("UTF-8")));
    when(dbIterator.hasNext()).thenReturn(true);

    // Act
    byte[] actualKey = (new StoreIterator(dbIterator)).getKey();

    // Assert
    verify(dbIterator).hasNext();
    verify(dbIterator).peekNext();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualKey);
  }

  /**
   * Method under test: {@link StoreIterator#getKey()}
   */
  @Test
  public void testGetKey2() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    when(dbIterator.peekNext()).thenThrow(new NoSuchElementException("foo"));
    when(dbIterator.hasNext()).thenReturn(true);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).getKey());
    verify(dbIterator).hasNext();
    verify(dbIterator).peekNext();
  }

  /**
   * Method under test: {@link StoreIterator#getValue()}
   */
  @Test
  public void testGetValue() throws UnsupportedEncodingException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    when(dbIterator.peekNext()).thenReturn(new AbstractMap.SimpleEntry<>(bytes, "AXAXAXAX".getBytes("UTF-8")));
    when(dbIterator.hasNext()).thenReturn(true);

    // Act
    byte[] actualValue = (new StoreIterator(dbIterator)).getValue();

    // Assert
    verify(dbIterator).hasNext();
    verify(dbIterator).peekNext();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualValue);
  }

  /**
   * Method under test: {@link StoreIterator#getValue()}
   */
  @Test
  public void testGetValue2() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    when(dbIterator.peekNext()).thenThrow(new NoSuchElementException("foo"));
    when(dbIterator.hasNext()).thenReturn(true);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).getValue());
    verify(dbIterator).hasNext();
    verify(dbIterator).peekNext();
  }

  /**
   * Method under test: {@link StoreIterator#StoreIterator(DBIterator)}
   */
  @Test
  public void testNewStoreIterator() {
    // Arrange, Act and Assert
    assertFalse((new StoreIterator(mock(DBIterator.class))).hasNext());
  }
}
