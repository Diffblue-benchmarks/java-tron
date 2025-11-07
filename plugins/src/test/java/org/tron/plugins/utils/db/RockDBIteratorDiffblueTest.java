package org.tron.plugins.utils.db;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.mockito.Mockito;
import org.rocksdb.RocksIterator;

public class RockDBIteratorDiffblueTest {
  /**
   * Method under test: {@link RockDBIterator#valid()}
   */
  @Test
  public void testValid() {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    when(iterator.isValid()).thenReturn(true);

    // Act
    boolean actualValidResult = (new RockDBIterator(iterator)).valid();

    // Assert
    verify(iterator).isValid();
    assertTrue(actualValidResult);
  }

  /**
   * Method under test: {@link RockDBIterator#valid()}
   */
  @Test
  public void testValid2() {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    when(iterator.isValid()).thenReturn(false);

    // Act
    boolean actualValidResult = (new RockDBIterator(iterator)).valid();

    // Assert
    verify(iterator).isValid();
    assertFalse(actualValidResult);
  }

  /**
   * Method under test: {@link RockDBIterator#seek(byte[])}
   */
  @Test
  public void testSeek() throws UnsupportedEncodingException {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    doNothing().when(iterator).seek(Mockito.<byte[]>any());
    RockDBIterator rockDBIterator = new RockDBIterator(iterator);

    // Act
    rockDBIterator.seek("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    verify(iterator).seek(isA(byte[].class));
  }

  /**
   * Method under test: {@link RockDBIterator#seekToFirst()}
   */
  @Test
  public void testSeekToFirst() {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    doNothing().when(iterator).seekToFirst();

    // Act
    (new RockDBIterator(iterator)).seekToFirst();

    // Assert that nothing has changed
    verify(iterator).seekToFirst();
  }

  /**
   * Method under test: {@link RockDBIterator#seekToLast()}
   */
  @Test
  public void testSeekToLast() {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    doNothing().when(iterator).seekToLast();

    // Act
    (new RockDBIterator(iterator)).seekToLast();

    // Assert that nothing has changed
    verify(iterator).seekToLast();
  }

  /**
   * Method under test: {@link RockDBIterator#hasNext()}
   */
  @Test
  public void testHasNext() {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    when(iterator.isValid()).thenReturn(true);

    // Act
    boolean actualHasNextResult = (new RockDBIterator(iterator)).hasNext();

    // Assert
    verify(iterator).isValid();
    assertTrue(actualHasNextResult);
  }

  /**
   * Method under test: {@link RockDBIterator#hasNext()}
   */
  @Test
  public void testHasNext2() {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    when(iterator.isValid()).thenReturn(false);

    // Act
    boolean actualHasNextResult = (new RockDBIterator(iterator)).hasNext();

    // Assert
    verify(iterator).isValid();
    assertFalse(actualHasNextResult);
  }

  /**
   * Method under test: {@link RockDBIterator#getKey()}
   */
  @Test
  public void testGetKey() throws UnsupportedEncodingException {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    when(iterator.key()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualKey = (new RockDBIterator(iterator)).getKey();

    // Assert
    verify(iterator).key();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualKey);
  }

  /**
   * Method under test: {@link RockDBIterator#getValue()}
   */
  @Test
  public void testGetValue() throws UnsupportedEncodingException {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    when(iterator.value()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualValue = (new RockDBIterator(iterator)).getValue();

    // Assert
    verify(iterator).value();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualValue);
  }

  /**
   * Method under test: {@link RockDBIterator#next()}
   */
  @Test
  public void testNext() throws UnsupportedEncodingException {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    when(iterator.key()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(iterator.value()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(iterator).next();

    // Act
    (new RockDBIterator(iterator)).next();

    // Assert
    verify(iterator).next();
    verify(iterator).key();
    verify(iterator).value();
  }

  /**
   * Method under test: {@link RockDBIterator#close()}
   */
  @Test
  public void testClose() throws IOException {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    doNothing().when(iterator).close();

    // Act
    (new RockDBIterator(iterator)).close();

    // Assert that nothing has changed
    verify(iterator).close();
  }
}
