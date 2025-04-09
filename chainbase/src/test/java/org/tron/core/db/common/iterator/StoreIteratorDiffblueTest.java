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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import org.iq80.leveldb.DBIterator;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class StoreIteratorDiffblueTest {
  /**
   * Test {@link StoreIterator#StoreIterator(DBIterator)}.
   * <p>
   * Method under test: {@link StoreIterator#StoreIterator(DBIterator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreIterator.<init>(DBIterator)"})
  public void testNewStoreIterator() {
    // Arrange, Act and Assert
    assertFalse((new StoreIterator(mock(DBIterator.class))).hasNext());
  }

  /**
   * Test {@link StoreIterator#close()}.
   * <ul>
   *   <li>Given {@link DBIterator} {@link Closeable#close()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreIterator.close()"})
  public void testClose_givenDBIteratorCloseDoesNothing() throws IOException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doNothing().when(dbIterator).close();

    // Act
    (new StoreIterator(dbIterator)).close();

    // Assert
    verify(dbIterator).close();
  }

  /**
   * Test {@link StoreIterator#close()}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreIterator.close()"})
  public void testClose_thenThrowNoSuchElementException() throws IOException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doThrow(new NoSuchElementException("foo")).when(dbIterator).close();

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).close());
    verify(dbIterator).close();
  }

  /**
   * Test {@link StoreIterator#hasNext()}.
   * <ul>
   *   <li>Given {@link DBIterator} {@link Iterator#hasNext()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#hasNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StoreIterator.hasNext()"})
  public void testHasNext_givenDBIteratorHasNextReturnFalse_thenReturnFalse() throws IOException {
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
   * Test {@link StoreIterator#hasNext()}.
   * <ul>
   *   <li>Given {@link DBIterator} {@link Iterator#hasNext()} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#hasNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StoreIterator.hasNext()"})
  public void testHasNext_givenDBIteratorHasNextReturnTrue_thenReturnTrue() {
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
   * Test {@link StoreIterator#hasNext()}.
   * <ul>
   *   <li>Given {@link DBIterator} {@link DBIterator#seek(byte[])} does nothing.</li>
   *   <li>Then calls {@link DBIterator#seek(byte[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#hasNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StoreIterator.hasNext()"})
  public void testHasNext_givenDBIteratorSeekDoesNothing_thenCallsSeek() {
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
   * Test {@link StoreIterator#next()}.
   * <ul>
   *   <li>Then return {@link SimpleEntry#SimpleEntry(Object, Object)} with {@code AXAXAXAX} Bytes is {@code UTF-8} and {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#next()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entry StoreIterator.next()"})
  public void testNext_thenReturnSimpleEntryWithAxaxaxaxBytesIsUtf8AndAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    SimpleEntry<byte[], byte[]> simpleEntry = new SimpleEntry<>(bytes, "AXAXAXAX".getBytes("UTF-8"));

    when(dbIterator.next()).thenReturn(simpleEntry);

    // Act
    Entry<byte[], byte[]> actualNextResult = (new StoreIterator(dbIterator)).next();

    // Assert
    verify(dbIterator).next();
    assertSame(simpleEntry, actualNextResult);
  }

  /**
   * Test {@link StoreIterator#next()}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#next()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entry StoreIterator.next()"})
  public void testNext_thenThrowNoSuchElementException() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    when(dbIterator.next()).thenThrow(new NoSuchElementException("foo"));

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).next());
    verify(dbIterator).next();
  }

  /**
   * Test {@link StoreIterator#remove()}.
   * <p>
   * Method under test: {@link StoreIterator#remove()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreIterator.remove()"})
  public void testRemove() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new StoreIterator(mock(DBIterator.class))).remove());
  }

  /**
   * Test {@link StoreIterator#seek(byte[])}.
   * <ul>
   *   <li>Given {@link DBIterator} {@link DBIterator#seek(byte[])} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#seek(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreIterator.seek(byte[])"})
  public void testSeek_givenDBIteratorSeekDoesNothing() throws UnsupportedEncodingException {
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
   * Test {@link StoreIterator#seek(byte[])}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#seek(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreIterator.seek(byte[])"})
  public void testSeek_thenThrowNoSuchElementException() throws UnsupportedEncodingException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doThrow(new NoSuchElementException("foo")).when(dbIterator).seek(Mockito.<byte[]>any());
    StoreIterator storeIterator = new StoreIterator(dbIterator);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> storeIterator.seek("AXAXAXAX".getBytes("UTF-8")));
    verify(dbIterator).seek(isA(byte[].class));
  }

  /**
   * Test {@link StoreIterator#seekToFirst()}.
   * <ul>
   *   <li>Given {@link DBIterator} {@link DBIterator#seekToFirst()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#seekToFirst()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreIterator.seekToFirst()"})
  public void testSeekToFirst_givenDBIteratorSeekToFirstDoesNothing() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doNothing().when(dbIterator).seekToFirst();

    // Act
    (new StoreIterator(dbIterator)).seekToFirst();

    // Assert
    verify(dbIterator).seekToFirst();
  }

  /**
   * Test {@link StoreIterator#seekToFirst()}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#seekToFirst()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreIterator.seekToFirst()"})
  public void testSeekToFirst_thenThrowNoSuchElementException() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doThrow(new NoSuchElementException("foo")).when(dbIterator).seekToFirst();

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).seekToFirst());
    verify(dbIterator).seekToFirst();
  }

  /**
   * Test {@link StoreIterator#seekToLast()}.
   * <ul>
   *   <li>Given {@link DBIterator} {@link DBIterator#seekToLast()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#seekToLast()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreIterator.seekToLast()"})
  public void testSeekToLast_givenDBIteratorSeekToLastDoesNothing() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doNothing().when(dbIterator).seekToLast();

    // Act
    (new StoreIterator(dbIterator)).seekToLast();

    // Assert
    verify(dbIterator).seekToLast();
  }

  /**
   * Test {@link StoreIterator#seekToLast()}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#seekToLast()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreIterator.seekToLast()"})
  public void testSeekToLast_thenThrowNoSuchElementException() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    doThrow(new NoSuchElementException("foo")).when(dbIterator).seekToLast();

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).seekToLast());
    verify(dbIterator).seekToLast();
  }

  /**
   * Test {@link StoreIterator#valid()}.
   * <ul>
   *   <li>Given {@link DBIterator} {@link Iterator#hasNext()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#valid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StoreIterator.valid()"})
  public void testValid_givenDBIteratorHasNextReturnFalse_thenReturnFalse() {
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
   * Test {@link StoreIterator#valid()}.
   * <ul>
   *   <li>Given {@link DBIterator} {@link Iterator#hasNext()} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#valid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StoreIterator.valid()"})
  public void testValid_givenDBIteratorHasNextReturnTrue_thenReturnTrue() {
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
   * Test {@link StoreIterator#valid()}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#valid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StoreIterator.valid()"})
  public void testValid_thenThrowNoSuchElementException() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    when(dbIterator.hasNext()).thenThrow(new NoSuchElementException("foo"));

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).valid());
    verify(dbIterator).hasNext();
  }

  /**
   * Test {@link StoreIterator#getKey()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#getKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] StoreIterator.getKey()"})
  public void testGetKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    when(dbIterator.peekNext()).thenReturn(new SimpleEntry<>(bytes, "AXAXAXAX".getBytes("UTF-8")));
    when(dbIterator.hasNext()).thenReturn(true);

    // Act
    byte[] actualKey = (new StoreIterator(dbIterator)).getKey();

    // Assert
    verify(dbIterator).hasNext();
    verify(dbIterator).peekNext();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualKey);
  }

  /**
   * Test {@link StoreIterator#getKey()}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#getKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] StoreIterator.getKey()"})
  public void testGetKey_thenThrowNoSuchElementException() {
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
   * Test {@link StoreIterator#getValue()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] StoreIterator.getValue()"})
  public void testGetValue_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    when(dbIterator.peekNext()).thenReturn(new SimpleEntry<>(bytes, "AXAXAXAX".getBytes("UTF-8")));
    when(dbIterator.hasNext()).thenReturn(true);

    // Act
    byte[] actualValue = (new StoreIterator(dbIterator)).getValue();

    // Assert
    verify(dbIterator).hasNext();
    verify(dbIterator).peekNext();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualValue);
  }

  /**
   * Test {@link StoreIterator#getValue()}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreIterator#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] StoreIterator.getValue()"})
  public void testGetValue_thenThrowNoSuchElementException() {
    // Arrange
    DBIterator dbIterator = mock(DBIterator.class);
    when(dbIterator.peekNext()).thenThrow(new NoSuchElementException("foo"));
    when(dbIterator.hasNext()).thenReturn(true);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new StoreIterator(dbIterator)).getValue());
    verify(dbIterator).hasNext();
    verify(dbIterator).peekNext();
  }
}
