package org.tron.plugins.utils.db;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.rocksdb.AbstractRocksIterator;
import org.rocksdb.RocksIterator;

public class RockDBIteratorDiffblueTest {
  /**
   * Test {@link RockDBIterator#valid()}.
   * <ul>
   *   <li>Given {@link RocksIterator} {@link AbstractRocksIterator#isValid()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RockDBIterator#valid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RockDBIterator.valid()"})
  public void testValid_givenRocksIteratorIsValidReturnFalse_thenReturnFalse() {
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
   * Test {@link RockDBIterator#valid()}.
   * <ul>
   *   <li>Given {@link RocksIterator} {@link AbstractRocksIterator#isValid()} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RockDBIterator#valid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RockDBIterator.valid()"})
  public void testValid_givenRocksIteratorIsValidReturnTrue_thenReturnTrue() {
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
   * Test {@link RockDBIterator#seek(byte[])}.
   * <p>
   * Method under test: {@link RockDBIterator#seek(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RockDBIterator.seek(byte[])"})
  public void testSeek() throws UnsupportedEncodingException {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    doNothing().when(iterator).seek(Mockito.<byte[]>any());
    RockDBIterator rockDBIterator = new RockDBIterator(iterator);

    // Act
    rockDBIterator.seek("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(iterator).seek(isA(byte[].class));
  }

  /**
   * Test {@link RockDBIterator#seekToFirst()}.
   * <p>
   * Method under test: {@link RockDBIterator#seekToFirst()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RockDBIterator.seekToFirst()"})
  public void testSeekToFirst() {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    doNothing().when(iterator).seekToFirst();

    // Act
    (new RockDBIterator(iterator)).seekToFirst();

    // Assert
    verify(iterator).seekToFirst();
  }

  /**
   * Test {@link RockDBIterator#seekToLast()}.
   * <p>
   * Method under test: {@link RockDBIterator#seekToLast()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RockDBIterator.seekToLast()"})
  public void testSeekToLast() {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    doNothing().when(iterator).seekToLast();

    // Act
    (new RockDBIterator(iterator)).seekToLast();

    // Assert
    verify(iterator).seekToLast();
  }

  /**
   * Test {@link RockDBIterator#hasNext()}.
   * <ul>
   *   <li>Given {@link RocksIterator} {@link AbstractRocksIterator#isValid()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RockDBIterator#hasNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RockDBIterator.hasNext()"})
  public void testHasNext_givenRocksIteratorIsValidReturnFalse_thenReturnFalse() {
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
   * Test {@link RockDBIterator#hasNext()}.
   * <ul>
   *   <li>Given {@link RocksIterator} {@link AbstractRocksIterator#isValid()} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RockDBIterator#hasNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RockDBIterator.hasNext()"})
  public void testHasNext_givenRocksIteratorIsValidReturnTrue_thenReturnTrue() {
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
   * Test {@link RockDBIterator#getKey()}.
   * <p>
   * Method under test: {@link RockDBIterator#getKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] RockDBIterator.getKey()"})
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
   * Test {@link RockDBIterator#getValue()}.
   * <p>
   * Method under test: {@link RockDBIterator#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] RockDBIterator.getValue()"})
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
   * Test {@link RockDBIterator#next()}.
   * <p>
   * Method under test: {@link RockDBIterator#next()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map.Entry RockDBIterator.next()"})
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
   * Test {@link RockDBIterator#close()}.
   * <p>
   * Method under test: {@link RockDBIterator#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RockDBIterator.close()"})
  public void testClose() throws IOException {
    // Arrange
    RocksIterator iterator = mock(RocksIterator.class);
    doNothing().when(iterator).close();

    // Act
    (new RockDBIterator(iterator)).close();

    // Assert
    verify(iterator).close();
  }
}
