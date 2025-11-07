package org.tron.core.db.common.iterator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import org.junit.Test;
import org.mockito.Mockito;
import org.rocksdb.RocksIterator;

public class RockStoreIteratorDiffblueTest {
  /**
   * Method under test: {@link RockStoreIterator#close()}
   */
  @Test
  public void testClose() throws IOException {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doNothing().when(dbIterator).close();

    // Act
    (new RockStoreIterator(dbIterator)).close();

    // Assert
    verify(dbIterator).close();
  }

  /**
   * Method under test: {@link RockStoreIterator#hasNext()}
   */
  @Test
  public void testHasNext() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(true);
    doNothing().when(dbIterator).seekToFirst();

    // Act
    boolean actualHasNextResult = (new RockStoreIterator(dbIterator)).hasNext();

    // Assert
    verify(dbIterator).isValid();
    verify(dbIterator).seekToFirst();
    assertTrue(actualHasNextResult);
  }

  /**
   * Method under test: {@link RockStoreIterator#hasNext()}
   */
  @Test
  public void testHasNext2() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(false);
    doNothing().when(dbIterator).close();
    doNothing().when(dbIterator).seekToFirst();

    // Act
    boolean actualHasNextResult = (new RockStoreIterator(dbIterator)).hasNext();

    // Assert
    verify(dbIterator).close();
    verify(dbIterator).isValid();
    verify(dbIterator).seekToFirst();
    assertFalse(actualHasNextResult);
  }

  /**
   * Method under test: {@link RockStoreIterator#hasNext()}
   */
  @Test
  public void testHasNext3() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doNothing().when(dbIterator).seek(Mockito.<byte[]>any());
    when(dbIterator.isValid()).thenReturn(true);

    RockStoreIterator rockStoreIterator = new RockStoreIterator(dbIterator);
    rockStoreIterator.seek(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    boolean actualHasNextResult = rockStoreIterator.hasNext();

    // Assert
    verify(dbIterator).isValid();
    verify(dbIterator).seek(isA(byte[].class));
    assertTrue(actualHasNextResult);
  }

  /**
   * Method under test: {@link RockStoreIterator#next()}
   */
  @Test
  public void testNext() throws UnsupportedEncodingException {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.key()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dbIterator.value()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(dbIterator).next();

    // Act
    (new RockStoreIterator(dbIterator)).next();

    // Assert
    verify(dbIterator).next();
    verify(dbIterator).key();
    verify(dbIterator).value();
  }

  /**
   * Method under test: {@link RockStoreIterator#next()}
   */
  @Test
  public void testNext2() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.key()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> (new RockStoreIterator(dbIterator)).next());
    verify(dbIterator).key();
  }

  /**
   * Method under test: {@link RockStoreIterator#seek(byte[])}
   */
  @Test
  public void testSeek() throws UnsupportedEncodingException {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doNothing().when(dbIterator).seek(Mockito.<byte[]>any());
    RockStoreIterator rockStoreIterator = new RockStoreIterator(dbIterator);

    // Act
    rockStoreIterator.seek("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(dbIterator).seek(isA(byte[].class));
  }

  /**
   * Method under test: {@link RockStoreIterator#seekToFirst()}
   */
  @Test
  public void testSeekToFirst() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doNothing().when(dbIterator).seekToFirst();

    // Act
    (new RockStoreIterator(dbIterator)).seekToFirst();

    // Assert
    verify(dbIterator).seekToFirst();
  }

  /**
   * Method under test: {@link RockStoreIterator#seekToLast()}
   */
  @Test
  public void testSeekToLast() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doNothing().when(dbIterator).seekToLast();

    // Act
    (new RockStoreIterator(dbIterator)).seekToLast();

    // Assert
    verify(dbIterator).seekToLast();
  }

  /**
   * Method under test: {@link RockStoreIterator#valid()}
   */
  @Test
  public void testValid() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(true);

    // Act
    boolean actualValidResult = (new RockStoreIterator(dbIterator)).valid();

    // Assert
    verify(dbIterator).isValid();
    assertTrue(actualValidResult);
  }

  /**
   * Method under test: {@link RockStoreIterator#valid()}
   */
  @Test
  public void testValid2() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(false);

    // Act
    boolean actualValidResult = (new RockStoreIterator(dbIterator)).valid();

    // Assert
    verify(dbIterator).isValid();
    assertFalse(actualValidResult);
  }

  /**
   * Method under test: {@link RockStoreIterator#getKey()}
   */
  @Test
  public void testGetKey() throws UnsupportedEncodingException {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.key()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dbIterator.isValid()).thenReturn(true);

    // Act
    byte[] actualKey = (new RockStoreIterator(dbIterator)).getKey();

    // Assert
    verify(dbIterator).isValid();
    verify(dbIterator).key();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualKey);
  }

  /**
   * Method under test: {@link RockStoreIterator#getKey()}
   */
  @Test
  public void testGetKey2() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.key()).thenThrow(new NoSuchElementException("foo"));
    when(dbIterator.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new RockStoreIterator(dbIterator)).getKey());
    verify(dbIterator).isValid();
    verify(dbIterator).key();
  }

  /**
   * Method under test: {@link RockStoreIterator#getValue()}
   */
  @Test
  public void testGetValue() throws UnsupportedEncodingException {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.value()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dbIterator.isValid()).thenReturn(true);

    // Act
    byte[] actualValue = (new RockStoreIterator(dbIterator)).getValue();

    // Assert
    verify(dbIterator).isValid();
    verify(dbIterator).value();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualValue);
  }

  /**
   * Method under test: {@link RockStoreIterator#getValue()}
   */
  @Test
  public void testGetValue2() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.value()).thenThrow(new NoSuchElementException("foo"));
    when(dbIterator.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new RockStoreIterator(dbIterator)).getValue());
    verify(dbIterator).isValid();
    verify(dbIterator).value();
  }

  /**
   * Method under test: {@link RockStoreIterator#RockStoreIterator(RocksIterator)}
   */
  @Test
  public void testNewRockStoreIterator() {
    // Arrange, Act and Assert
    assertFalse((new RockStoreIterator(mock(RocksIterator.class))).hasNext());
  }
}
