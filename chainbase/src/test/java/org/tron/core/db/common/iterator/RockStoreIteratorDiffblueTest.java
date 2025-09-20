package org.tron.core.db.common.iterator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.rocksdb.RocksIterator;

public class RockStoreIteratorDiffblueTest {
  /**
   * Test {@link RockStoreIterator#RockStoreIterator(RocksIterator)}.
   *
   * <p>Method under test: {@link RockStoreIterator#RockStoreIterator(RocksIterator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RockStoreIterator.<init>(RocksIterator)"})
  public void testNewRockStoreIterator() {
    // Arrange, Act and Assert
    assertFalse(new RockStoreIterator(mock(RocksIterator.class)).hasNext());
  }

  /**
   * Test {@link RockStoreIterator#close()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#close()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RockStoreIterator.close()"})
  public void testClose_givenRocksIteratorCloseDoesNothing() throws IOException {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doNothing().when(dbIterator).close();
    try (RockStoreIterator rockStoreIterator = new RockStoreIterator(dbIterator)) {}

    // Act and Assert
    verify(dbIterator).close();
  }

  /**
   * Test {@link RockStoreIterator#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#close()} throw {@link
   *       NoSuchElementException#NoSuchElementException()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#hasNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RockStoreIterator.hasNext()"})
  public void testHasNext_givenRocksIteratorCloseThrowNoSuchElementException_thenReturnFalse() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doThrow(new NoSuchElementException()).when(dbIterator).close();
    doThrow(new NoSuchElementException()).when(dbIterator).seekToFirst();

    // Act
    boolean actualHasNextResult = new RockStoreIterator(dbIterator).hasNext();

    // Assert
    verify(dbIterator).close();
    verify(dbIterator).seekToFirst();
    assertFalse(actualHasNextResult);
  }

  /**
   * Test {@link RockStoreIterator#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#isValid()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#hasNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RockStoreIterator.hasNext()"})
  public void testHasNext_givenRocksIteratorIsValidReturnFalse_thenReturnFalse() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doNothing().when(dbIterator).seek(Mockito.<byte[]>any());
    when(dbIterator.isValid()).thenReturn(false);
    doNothing().when(dbIterator).close();

    RockStoreIterator rockStoreIterator = new RockStoreIterator(dbIterator);
    rockStoreIterator.seek(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    boolean actualHasNextResult = rockStoreIterator.hasNext();

    // Assert
    verify(dbIterator).close();
    verify(dbIterator).isValid();
    verify(dbIterator).seek(isA(byte[].class));
    assertFalse(actualHasNextResult);
  }

  /**
   * Test {@link RockStoreIterator#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#seek(byte[])} does nothing.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#hasNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RockStoreIterator.hasNext()"})
  public void testHasNext_givenRocksIteratorSeekDoesNothing_thenReturnTrue() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doNothing().when(dbIterator).seek(Mockito.<byte[]>any());
    when(dbIterator.isValid()).thenReturn(true);

    RockStoreIterator rockStoreIterator = new RockStoreIterator(dbIterator);
    rockStoreIterator.seek(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    boolean actualHasNextResult = rockStoreIterator.hasNext();

    // Assert
    verify(dbIterator).isValid();
    verify(dbIterator).seek(isA(byte[].class));
    assertTrue(actualHasNextResult);
  }

  /**
   * Test {@link RockStoreIterator#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#seekToFirst()} does nothing.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#hasNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RockStoreIterator.hasNext()"})
  public void testHasNext_givenRocksIteratorSeekToFirstDoesNothing_thenReturnTrue() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(true);
    doNothing().when(dbIterator).seekToFirst();

    // Act
    boolean actualHasNextResult = new RockStoreIterator(dbIterator).hasNext();

    // Assert
    verify(dbIterator).isValid();
    verify(dbIterator).seekToFirst();
    assertTrue(actualHasNextResult);
  }

  /**
   * Test {@link RockStoreIterator#next()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#key()} return {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   *   <li>Then calls {@link RocksIterator#next()}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#next()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map.Entry RockStoreIterator.next()"})
  public void testNext_givenRocksIteratorKeyReturnAxaxaxaxBytesIsUtf8_thenCallsNext()
      throws UnsupportedEncodingException {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.key()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dbIterator.value()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(dbIterator).next();

    // Act
    new RockStoreIterator(dbIterator).next();

    // Assert
    verify(dbIterator).next();
    verify(dbIterator).key();
    verify(dbIterator).value();
  }

  /**
   * Test {@link RockStoreIterator#next()}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#next()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map.Entry RockStoreIterator.next()"})
  public void testNext_thenThrowNoSuchElementException() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.key()).thenThrow(new NoSuchElementException());

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> new RockStoreIterator(dbIterator).next());
    verify(dbIterator).key();
  }

  /**
   * Test {@link RockStoreIterator#seek(byte[])}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#seek(byte[])} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#seek(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RockStoreIterator.seek(byte[])"})
  public void testSeek_givenRocksIteratorSeekDoesNothing() throws UnsupportedEncodingException {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doNothing().when(dbIterator).seek(Mockito.<byte[]>any());

    // Act
    new RockStoreIterator(dbIterator).seek("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(dbIterator).seek(isA(byte[].class));
  }

  /**
   * Test {@link RockStoreIterator#seek(byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#seek(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RockStoreIterator.seek(byte[])"})
  public void testSeek_thenThrowNoSuchElementException() throws UnsupportedEncodingException {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doThrow(new NoSuchElementException()).when(dbIterator).seek(Mockito.<byte[]>any());

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> new RockStoreIterator(dbIterator).seek("AXAXAXAX".getBytes("UTF-8")));
    verify(dbIterator).seek(isA(byte[].class));
  }

  /**
   * Test {@link RockStoreIterator#seekToFirst()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#seekToFirst()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#seekToFirst()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RockStoreIterator.seekToFirst()"})
  public void testSeekToFirst_givenRocksIteratorSeekToFirstDoesNothing() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doNothing().when(dbIterator).seekToFirst();

    // Act
    new RockStoreIterator(dbIterator).seekToFirst();

    // Assert
    verify(dbIterator).seekToFirst();
  }

  /**
   * Test {@link RockStoreIterator#seekToFirst()}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#seekToFirst()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RockStoreIterator.seekToFirst()"})
  public void testSeekToFirst_thenThrowNoSuchElementException() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doThrow(new NoSuchElementException()).when(dbIterator).seekToFirst();

    // Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> new RockStoreIterator(dbIterator).seekToFirst());
    verify(dbIterator).seekToFirst();
  }

  /**
   * Test {@link RockStoreIterator#seekToLast()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#seekToLast()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#seekToLast()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RockStoreIterator.seekToLast()"})
  public void testSeekToLast_givenRocksIteratorSeekToLastDoesNothing() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doNothing().when(dbIterator).seekToLast();

    // Act
    new RockStoreIterator(dbIterator).seekToLast();

    // Assert
    verify(dbIterator).seekToLast();
  }

  /**
   * Test {@link RockStoreIterator#seekToLast()}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#seekToLast()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RockStoreIterator.seekToLast()"})
  public void testSeekToLast_thenThrowNoSuchElementException() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    doThrow(new NoSuchElementException()).when(dbIterator).seekToLast();

    // Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> new RockStoreIterator(dbIterator).seekToLast());
    verify(dbIterator).seekToLast();
  }

  /**
   * Test {@link RockStoreIterator#valid()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#isValid()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#valid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RockStoreIterator.valid()"})
  public void testValid_givenRocksIteratorIsValidReturnFalse_thenReturnFalse() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(false);

    // Act
    boolean actualValidResult = new RockStoreIterator(dbIterator).valid();

    // Assert
    verify(dbIterator).isValid();
    assertFalse(actualValidResult);
  }

  /**
   * Test {@link RockStoreIterator#valid()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#isValid()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#valid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RockStoreIterator.valid()"})
  public void testValid_givenRocksIteratorIsValidReturnTrue_thenReturnTrue() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenReturn(true);

    // Act
    boolean actualValidResult = new RockStoreIterator(dbIterator).valid();

    // Assert
    verify(dbIterator).isValid();
    assertTrue(actualValidResult);
  }

  /**
   * Test {@link RockStoreIterator#valid()}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#valid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RockStoreIterator.valid()"})
  public void testValid_thenThrowNoSuchElementException() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenThrow(new NoSuchElementException());

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> new RockStoreIterator(dbIterator).valid());
    verify(dbIterator).isValid();
  }

  /**
   * Test {@link RockStoreIterator#getKey()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#isValid()} return {@code true}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#getKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] RockStoreIterator.getKey()"})
  public void testGetKey_givenRocksIteratorIsValidReturnTrue_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.key()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dbIterator.isValid()).thenReturn(true);

    // Act
    byte[] actualKey = new RockStoreIterator(dbIterator).getKey();

    // Assert
    verify(dbIterator).isValid();
    verify(dbIterator).key();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualKey);
  }

  /**
   * Test {@link RockStoreIterator#getKey()}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#getKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] RockStoreIterator.getKey()"})
  public void testGetKey_thenThrowNoSuchElementException() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenThrow(new NoSuchElementException());

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> new RockStoreIterator(dbIterator).getKey());
    verify(dbIterator).isValid();
  }

  /**
   * Test {@link RockStoreIterator#getValue()}.
   *
   * <ul>
   *   <li>Given {@link RocksIterator} {@link RocksIterator#isValid()} return {@code true}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] RockStoreIterator.getValue()"})
  public void testGetValue_givenRocksIteratorIsValidReturnTrue_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.value()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dbIterator.isValid()).thenReturn(true);

    // Act
    byte[] actualValue = new RockStoreIterator(dbIterator).getValue();

    // Assert
    verify(dbIterator).isValid();
    verify(dbIterator).value();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualValue);
  }

  /**
   * Test {@link RockStoreIterator#getValue()}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link RockStoreIterator#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] RockStoreIterator.getValue()"})
  public void testGetValue_thenThrowNoSuchElementException() {
    // Arrange
    RocksIterator dbIterator = mock(RocksIterator.class);
    when(dbIterator.isValid()).thenThrow(new NoSuchElementException());

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> new RockStoreIterator(dbIterator).getValue());
    verify(dbIterator).isValid();
  }
}
