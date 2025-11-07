package org.tron.common.runtime.vm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.db.ByteArrayWrapper;

public class DataWordDiffblueTest {
  /**
   * Test {@link DataWord#DataWord()}.
   * <p>
   * Method under test: {@link DataWord#DataWord()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.<init>()"})
  public void testNewDataWord() {
    // Arrange and Act
    DataWord actualDataWord = new DataWord();

    // Assert
    assertEquals("00", actualDataWord.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", actualDataWord.toHexString());
    assertFalse(actualDataWord.isNegative());
    assertTrue(actualDataWord.isZero());
    byte[] noEndZeroesData = actualDataWord.getNoEndZeroesData();
    assertSame(noEndZeroesData, actualDataWord.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataWord.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataWord.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataWord.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataWord.getData());
  }

  /**
   * Test {@link DataWord#DataWord(int)}.
   * <p>
   * Method under test: {@link DataWord#DataWord(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.<init>(int)"})
  public void testNewDataWord2() {
    // Arrange and Act
    DataWord actualDataWord = new DataWord(10);

    // Assert
    assertEquals("000000000000000000000000000000000000000000000000000000000000000a", actualDataWord.toHexString());
    assertEquals("0a", actualDataWord.toPrefixString());
    assertFalse(actualDataWord.isNegative());
    assertFalse(actualDataWord.isZero());
    byte[] data = actualDataWord.getData();
    assertSame(data, actualDataWord.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'\n'}, actualDataWord.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        actualDataWord.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        actualDataWord.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        actualDataWord.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        data);
  }

  /**
   * Test {@link DataWord#DataWord(long)}.
   * <p>
   * Method under test: {@link DataWord#DataWord(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.<init>(long)"})
  public void testNewDataWord3() {
    // Arrange and Act
    DataWord actualDataWord = new DataWord(1L);

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", actualDataWord.toHexString());
    assertEquals("01", actualDataWord.toPrefixString());
    assertFalse(actualDataWord.isNegative());
    assertFalse(actualDataWord.isZero());
    byte[] data = actualDataWord.getData();
    assertSame(data, actualDataWord.getNoEndZeroesData());
    assertArrayEquals(new byte[]{1}, actualDataWord.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualDataWord.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualDataWord.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualDataWord.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data);
  }

  /**
   * Test {@link DataWord#DataWord(String)}.
   * <p>
   * Method under test: {@link DataWord#DataWord(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.<init>(String)"})
  public void testNewDataWord4() {
    // Arrange and Act
    DataWord actualDataWord = new DataWord("42");

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000042", actualDataWord.toHexString());
    assertEquals("42", actualDataWord.toPrefixString());
    assertFalse(actualDataWord.isZero());
    byte[] data = actualDataWord.getData();
    assertSame(data, actualDataWord.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'B'}, actualDataWord.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'B'},
        actualDataWord.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'B'},
        actualDataWord.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'B'},
        actualDataWord.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'B'},
        data);
  }

  /**
   * Test {@link DataWord#DataWord(ByteArrayWrapper)}.
   * <p>
   * Method under test: {@link DataWord#DataWord(ByteArrayWrapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.<init>(ByteArrayWrapper)"})
  public void testNewDataWord5() throws UnsupportedEncodingException {
    // Arrange and Act
    DataWord actualDataWord = new DataWord(new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158", actualDataWord.toHexString());
    assertEquals("415841", actualDataWord.toPrefixString());
    assertFalse(actualDataWord.isNegative());
    assertFalse(actualDataWord.isZero());
    byte[] data = actualDataWord.getData();
    assertSame(data, actualDataWord.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualDataWord.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualDataWord.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualDataWord.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualDataWord.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data);
  }

  /**
   * Test {@link DataWord#DataWord(byte[])}.
   * <p>
   * Method under test: {@link DataWord#DataWord(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.<init>(byte[])"})
  public void testNewDataWord6() throws UnsupportedEncodingException {
    // Arrange and Act
    DataWord actualDataWord = new DataWord("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158", actualDataWord.toHexString());
    assertEquals("415841", actualDataWord.toPrefixString());
    assertFalse(actualDataWord.isNegative());
    assertFalse(actualDataWord.isZero());
    byte[] data = actualDataWord.getData();
    assertSame(data, actualDataWord.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualDataWord.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualDataWord.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualDataWord.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualDataWord.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data);
  }

  /**
   * Test {@link DataWord#DataWord(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return toPrefixString is {@code 00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#DataWord(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.<init>(String)"})
  public void testNewDataWord_whenEmptyString_thenReturnToPrefixStringIs00() {
    // Arrange and Act
    DataWord actualDataWord = new DataWord("");

    // Assert
    assertEquals("00", actualDataWord.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", actualDataWord.toHexString());
    assertTrue(actualDataWord.isZero());
    byte[] noEndZeroesData = actualDataWord.getNoEndZeroesData();
    assertSame(noEndZeroesData, actualDataWord.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataWord.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataWord.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataWord.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataWord.getData());
  }

  /**
   * Test {@link DataWord#DataWord(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return toHexString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#DataWord(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.<init>(byte[])"})
  public void testNewDataWord_whenNull_thenReturnToHexStringIsEmptyString() {
    // Arrange and Act
    DataWord actualDataWord = new DataWord((byte[]) null);

    // Assert
    assertEquals("", actualDataWord.toHexString());
    assertEquals("00", actualDataWord.toPrefixString());
    assertTrue(actualDataWord.isZero());
    assertArrayEquals(new byte[]{}, actualDataWord.getData());
    assertArrayEquals(new byte[]{0}, actualDataWord.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataWord.getClonedData());
  }

  /**
   * Test {@link DataWord#ONE()}.
   * <p>
   * Method under test: {@link DataWord#ONE()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.ONE()"})
  public void testOne() {
    // Arrange and Act
    DataWord actualONEResult = DataWord.ONE();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", actualONEResult.toHexString());
    assertEquals("01", actualONEResult.toPrefixString());
    assertFalse(actualONEResult.isNegative());
    assertFalse(actualONEResult.isZero());
    byte[] data = actualONEResult.getData();
    assertSame(data, actualONEResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{1}, actualONEResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualONEResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualONEResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualONEResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data);
  }

  /**
   * Test {@link DataWord#ZERO()}.
   * <p>
   * Method under test: {@link DataWord#ZERO()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.ZERO()"})
  public void testZero() {
    // Arrange and Act
    DataWord actualZEROResult = DataWord.ZERO();

    // Assert
    assertEquals("00", actualZEROResult.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", actualZEROResult.toHexString());
    assertFalse(actualZEROResult.isNegative());
    assertTrue(actualZEROResult.isZero());
    byte[] noEndZeroesData = actualZEROResult.getNoEndZeroesData();
    assertSame(noEndZeroesData, actualZEROResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualZEROResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualZEROResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualZEROResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualZEROResult.getData());
  }

  /**
   * Test {@link DataWord#of(byte)}.
   * <p>
   * Method under test: {@link DataWord#of(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.of(byte)"})
  public void testOf() {
    // Arrange and Act
    DataWord actualOfResult = DataWord.of((byte) 'A');

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000041", actualOfResult.toHexString());
    assertEquals("41", actualOfResult.toPrefixString());
    assertFalse(actualOfResult.isNegative());
    assertFalse(actualOfResult.isZero());
    byte[] data = actualOfResult.getData();
    assertSame(data, actualOfResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'A'}, actualOfResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        actualOfResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        actualOfResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        actualOfResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        data);
  }

  /**
   * Test {@link DataWord#bigIntValue(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#bigIntValue(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.bigIntValue(byte[])"})
  public void testBigIntValueWithByte_whenAxaxaxaxBytesIsUtf8_thenReturn4708585257725083992()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4708585257725083992", DataWord.bigIntValue("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#isZero(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#isZero(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.isZero(byte[])"})
  public void testIsZeroWithByte_whenArrayOfByteWithZeroAndZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DataWord.isZero(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
  }

  /**
   * Test {@link DataWord#isZero(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#isZero(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.isZero(byte[])"})
  public void testIsZeroWithByte_whenAxaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(DataWord.isZero("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#isZero()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.isZero()"})
  public void testIsZero_givenDataWordWithNumIsA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DataWord.of((byte) 'A').isZero());
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x7FF415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x7FF415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x7FF415841584158", DataWord.shortHex(new byte[]{7, -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF7F5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF7F5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF7F5841584158", DataWord.shortHex(new byte[]{'\b', -1, Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF41FF41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF41FF41584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF41FF41584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF417F41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF417F41584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF417F41584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', Byte.MAX_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF4158FF584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF4158FF584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF4158FF584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF41587F584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF41587F584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF41587F584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', Byte.MAX_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841FF4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841FF4158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841FF4158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF4158417F4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF4158417F4158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF4158417F4158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', Byte.MAX_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF41584158FF58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF41584158FF58() {
    // Arrange, Act and Assert
    assertEquals("0x8FF41584158FF58", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841587F58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841587F58() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841587F58", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', Byte.MAX_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF4158415841FF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF4158415841FF() {
    // Arrange, Act and Assert
    assertEquals("0x8FF4158415841FF", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 'A', -1}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF005841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF005841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF005841584158", DataWord.shortHex(new byte[]{'\b', -1, 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF41584158417F}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF41584158417F() {
    // Arrange, Act and Assert
    assertEquals("0x8FF41584158417F", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF075841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF075841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF075841584158", DataWord.shortHex(new byte[]{'\b', -1, 7, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF085841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF085841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF085841584158", DataWord.shortHex(new byte[]{'\b', -1, '\b', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF145841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF145841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF145841584158", DataWord.shortHex(new byte[]{'\b', -1, 20, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF410041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF410041584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF410041584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF410741584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF410741584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF410741584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 7, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF410841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF410841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF410841584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', '\b', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF411441584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF411441584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF411441584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 20, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF414141584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF414141584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF414141584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'A', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415800584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415800584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415800584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415807584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415807584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415807584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 7, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415808584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415808584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415808584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', '\b', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415814584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415814584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415814584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 20, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841004158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841004158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841004158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 0, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841074158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841074158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841074158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 7, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841084158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841084158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841084158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', '\b', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841144158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841144158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841144158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 20, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841414158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841414158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841414158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'A', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841580058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841580058() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841580058", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 0, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841580758}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841580758() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841580758", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 7, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841580858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841580858() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841580858", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', '\b', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841581458}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841581458() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841581458", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 20, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841584100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841584100() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841584100", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841584107}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841584107() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841584107", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 'A', 7}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841584108}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841584108() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841584108", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 'A', '\b'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841584114}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841584114() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841584114", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 'A', 20}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841584141}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841584141() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841584141", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 'A', 'A'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841584180}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841584180() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841584180", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841585858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841585858() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841585858", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', 'X', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841588058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841588058() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841588058", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', 'X', Byte.MIN_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415841804158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415841804158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415841804158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415858584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415858584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415858584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', 'X', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF415880584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF415880584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF415880584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF418041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF418041584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF418041584158", DataWord.shortHex(new byte[]{'\b', -1, 'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF585841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF585841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF585841584158", DataWord.shortHex(new byte[]{'\b', -1, 'X', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FF805841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FF805841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FF805841584158", DataWord.shortHex(new byte[]{'\b', -1, Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8FFFF5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8FFFF5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8FFFF5841584158", DataWord.shortHex(new byte[]{'\b', -1, -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x77F415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x77F415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x77F415841584158", DataWord.shortHex(new byte[]{7, Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F7F5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F7F5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F7F5841584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F41FF41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F41FF41584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F41FF41584158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F417F41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F417F41584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F417F41584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', Byte.MAX_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F4158FF584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F4158FF584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F4158FF584158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F41587F584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F41587F584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F41587F584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', Byte.MAX_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841FF4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841FF4158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841FF4158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F4158417F4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F4158417F4158() {
    // Arrange, Act and Assert
    assertEquals("0x87F4158417F4158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', Byte.MAX_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F41584158FF58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F41584158FF58() {
    // Arrange, Act and Assert
    assertEquals("0x87F41584158FF58", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841587F58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841587F58() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841587F58",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', Byte.MAX_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F4158415841FF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F4158415841FF() {
    // Arrange, Act and Assert
    assertEquals("0x87F4158415841FF", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', -1}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F005841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F005841584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F005841584158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F41584158417F}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F41584158417F() {
    // Arrange, Act and Assert
    assertEquals("0x87F41584158417F",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F075841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F075841584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F075841584158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 7, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F085841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F085841584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F085841584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, '\b', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F145841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F145841584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F145841584158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 20, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F410041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F410041584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F410041584158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F410741584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F410741584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F410741584158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 7, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F410841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F410841584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F410841584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', '\b', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F411441584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F411441584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F411441584158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 20, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F414141584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F414141584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F414141584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'A', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415800584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415800584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415800584158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415807584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415807584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415807584158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 7, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415808584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415808584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415808584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', '\b', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415814584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415814584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415814584158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 20, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841004158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841004158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841004158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 0, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841074158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841074158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841074158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 7, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841084158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841084158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841084158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', '\b', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841144158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841144158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841144158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 20, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841414158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841414158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841414158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'A', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841580058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841580058() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841580058", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 0, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841580758}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841580758() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841580758", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 7, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841580858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841580858() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841580858",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', '\b', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841581458}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841581458() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841581458", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 20, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841584100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841584100() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841584100", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841584107}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841584107() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841584107", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', 7}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841584108}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841584108() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841584108",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', '\b'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841584114}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841584114() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841584114", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', 20}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841584141}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841584141() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841584141",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', 'A'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841584180}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841584180() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841584180",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841585858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841585858() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841585858",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'X', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841588058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841588058() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841588058",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X', Byte.MIN_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415841804158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415841804158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415841804158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415858584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415858584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415858584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', 'X', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F415880584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F415880584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F415880584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F418041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F418041584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F418041584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F585841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F585841584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F585841584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, 'X', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87F805841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87F805841584158() {
    // Arrange, Act and Assert
    assertEquals("0x87F805841584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x87FFF5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x87FFF5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x87FFF5841584158", DataWord.shortHex(new byte[]{'\b', Byte.MAX_VALUE, -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800FF5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800FF5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x800FF5841584158", DataWord.shortHex(new byte[]{'\b', 0, -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807FF5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807FF5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x807FF5841584158", DataWord.shortHex(new byte[]{'\b', 7, -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808FF5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808FF5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x808FF5841584158", DataWord.shortHex(new byte[]{'\b', '\b', -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814FF5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814FF5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x814FF5841584158", DataWord.shortHex(new byte[]{'\b', 20, -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841FF5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841FF5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x841FF5841584158", DataWord.shortHex(new byte[]{'\b', 'A', -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858FF5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858FF5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x858FF5841584158", DataWord.shortHex(new byte[]{'\b', 'X', -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880FF5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880FF5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x880FF5841584158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8007F5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8007F5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8007F5841584158", DataWord.shortHex(new byte[]{'\b', 0, Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8077F5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8077F5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8077F5841584158", DataWord.shortHex(new byte[]{'\b', 7, Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8087F5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8087F5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8087F5841584158",
        DataWord.shortHex(new byte[]{'\b', '\b', Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8147F5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8147F5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8147F5841584158", DataWord.shortHex(new byte[]{'\b', 20, Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8417F5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8417F5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8417F5841584158",
        DataWord.shortHex(new byte[]{'\b', 'A', Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8587F5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8587F5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8587F5841584158",
        DataWord.shortHex(new byte[]{'\b', 'X', Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8807F5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8807F5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8807F5841584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x80041FF41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x80041FF41584158() {
    // Arrange, Act and Assert
    assertEquals("0x80041FF41584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x80741FF41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x80741FF41584158() {
    // Arrange, Act and Assert
    assertEquals("0x80741FF41584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x80841FF41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x80841FF41584158() {
    // Arrange, Act and Assert
    assertEquals("0x80841FF41584158", DataWord.shortHex(new byte[]{'\b', '\b', 'A', -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x81441FF41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x81441FF41584158() {
    // Arrange, Act and Assert
    assertEquals("0x81441FF41584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x84141FF41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x84141FF41584158() {
    // Arrange, Act and Assert
    assertEquals("0x84141FF41584158", DataWord.shortHex(new byte[]{'\b', 'A', 'A', -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x85808FF41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x85808FF41584158() {
    // Arrange, Act and Assert
    assertEquals("0x85808FF41584158", DataWord.shortHex(new byte[]{'\b', 'X', '\b', -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x85841FF41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x85841FF41584158() {
    // Arrange, Act and Assert
    assertEquals("0x85841FF41584158", DataWord.shortHex(new byte[]{'\b', 'X', 'A', -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x88041FF41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x88041FF41584158() {
    // Arrange, Act and Assert
    assertEquals("0x88041FF41584158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800417F41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800417F41584158() {
    // Arrange, Act and Assert
    assertEquals("0x800417F41584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', Byte.MAX_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807417F41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807417F41584158() {
    // Arrange, Act and Assert
    assertEquals("0x807417F41584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', Byte.MAX_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808417F41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808417F41584158() {
    // Arrange, Act and Assert
    assertEquals("0x808417F41584158",
        DataWord.shortHex(new byte[]{'\b', '\b', 'A', Byte.MAX_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814417F41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814417F41584158() {
    // Arrange, Act and Assert
    assertEquals("0x814417F41584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', Byte.MAX_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841417F41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841417F41584158() {
    // Arrange, Act and Assert
    assertEquals("0x841417F41584158",
        DataWord.shortHex(new byte[]{'\b', 'A', 'A', Byte.MAX_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858087F41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858087F41584158() {
    // Arrange, Act and Assert
    assertEquals("0x858087F41584158",
        DataWord.shortHex(new byte[]{'\b', 'X', '\b', Byte.MAX_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858417F41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858417F41584158() {
    // Arrange, Act and Assert
    assertEquals("0x858417F41584158",
        DataWord.shortHex(new byte[]{'\b', 'X', 'A', Byte.MAX_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880417F41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880417F41584158() {
    // Arrange, Act and Assert
    assertEquals("0x880417F41584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', Byte.MAX_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8004158FF584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8004158FF584158() {
    // Arrange, Act and Assert
    assertEquals("0x8004158FF584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8074158FF584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8074158FF584158() {
    // Arrange, Act and Assert
    assertEquals("0x8074158FF584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8084158FF584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8084158FF584158() {
    // Arrange, Act and Assert
    assertEquals("0x8084158FF584158", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8144158FF584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8144158FF584158() {
    // Arrange, Act and Assert
    assertEquals("0x8144158FF584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8414158FF584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8414158FF584158() {
    // Arrange, Act and Assert
    assertEquals("0x8414158FF584158", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8580858FF584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8580858FF584158() {
    // Arrange, Act and Assert
    assertEquals("0x8580858FF584158", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8584158FF584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8584158FF584158() {
    // Arrange, Act and Assert
    assertEquals("0x8584158FF584158", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8804158FF584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8804158FF584158() {
    // Arrange, Act and Assert
    assertEquals("0x8804158FF584158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x80041587F584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x80041587F584158() {
    // Arrange, Act and Assert
    assertEquals("0x80041587F584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', Byte.MAX_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x80741587F584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x80741587F584158() {
    // Arrange, Act and Assert
    assertEquals("0x80741587F584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', Byte.MAX_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x80841587F584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x80841587F584158() {
    // Arrange, Act and Assert
    assertEquals("0x80841587F584158",
        DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', Byte.MAX_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x81441587F584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x81441587F584158() {
    // Arrange, Act and Assert
    assertEquals("0x81441587F584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', Byte.MAX_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x84141587F584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x84141587F584158() {
    // Arrange, Act and Assert
    assertEquals("0x84141587F584158",
        DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', Byte.MAX_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x85808587F584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x85808587F584158() {
    // Arrange, Act and Assert
    assertEquals("0x85808587F584158",
        DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', Byte.MAX_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x85841587F584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x85841587F584158() {
    // Arrange, Act and Assert
    assertEquals("0x85841587F584158",
        DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', Byte.MAX_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x88041587F584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x88041587F584158() {
    // Arrange, Act and Assert
    assertEquals("0x88041587F584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', Byte.MAX_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841FF4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841FF4158() {
    // Arrange, Act and Assert
    assertEquals("0x800415841FF4158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841FF4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841FF4158() {
    // Arrange, Act and Assert
    assertEquals("0x807415841FF4158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841FF4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841FF4158() {
    // Arrange, Act and Assert
    assertEquals("0x808415841FF4158", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841FF4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841FF4158() {
    // Arrange, Act and Assert
    assertEquals("0x814415841FF4158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841FF4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841FF4158() {
    // Arrange, Act and Assert
    assertEquals("0x841415841FF4158", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841FF4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841FF4158() {
    // Arrange, Act and Assert
    assertEquals("0x858085841FF4158", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841FF4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841FF4158() {
    // Arrange, Act and Assert
    assertEquals("0x858415841FF4158", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841FF4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841FF4158() {
    // Arrange, Act and Assert
    assertEquals("0x880415841FF4158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8004158417F4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8004158417F4158() {
    // Arrange, Act and Assert
    assertEquals("0x8004158417F4158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', Byte.MAX_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8074158417F4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8074158417F4158() {
    // Arrange, Act and Assert
    assertEquals("0x8074158417F4158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', Byte.MAX_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8084158417F4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8084158417F4158() {
    // Arrange, Act and Assert
    assertEquals("0x8084158417F4158",
        DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', Byte.MAX_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8144158417F4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8144158417F4158() {
    // Arrange, Act and Assert
    assertEquals("0x8144158417F4158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', Byte.MAX_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8414158417F4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8414158417F4158() {
    // Arrange, Act and Assert
    assertEquals("0x8414158417F4158",
        DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', Byte.MAX_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8580858417F4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8580858417F4158() {
    // Arrange, Act and Assert
    assertEquals("0x8580858417F4158",
        DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', Byte.MAX_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8584158417F4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8584158417F4158() {
    // Arrange, Act and Assert
    assertEquals("0x8584158417F4158",
        DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', Byte.MAX_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8804158417F4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8804158417F4158() {
    // Arrange, Act and Assert
    assertEquals("0x8804158417F4158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', Byte.MAX_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x80041584158FF58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x80041584158FF58() {
    // Arrange, Act and Assert
    assertEquals("0x80041584158FF58", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x80741584158FF58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x80741584158FF58() {
    // Arrange, Act and Assert
    assertEquals("0x80741584158FF58", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x80841584158FF58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x80841584158FF58() {
    // Arrange, Act and Assert
    assertEquals("0x80841584158FF58", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x81441584158FF58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x81441584158FF58() {
    // Arrange, Act and Assert
    assertEquals("0x81441584158FF58", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x84141584158FF58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x84141584158FF58() {
    // Arrange, Act and Assert
    assertEquals("0x84141584158FF58", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x85808584158FF58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x85808584158FF58() {
    // Arrange, Act and Assert
    assertEquals("0x85808584158FF58", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x85841584158FF58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x85841584158FF58() {
    // Arrange, Act and Assert
    assertEquals("0x85841584158FF58", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x88041584158FF58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x88041584158FF58() {
    // Arrange, Act and Assert
    assertEquals("0x88041584158FF58", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841587F58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841587F58() {
    // Arrange, Act and Assert
    assertEquals("0x800415841587F58", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', Byte.MAX_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841587F58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841587F58() {
    // Arrange, Act and Assert
    assertEquals("0x807415841587F58", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', Byte.MAX_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841587F58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841587F58() {
    // Arrange, Act and Assert
    assertEquals("0x808415841587F58",
        DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 'X', Byte.MAX_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841587F58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841587F58() {
    // Arrange, Act and Assert
    assertEquals("0x814415841587F58", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', Byte.MAX_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841587F58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841587F58() {
    // Arrange, Act and Assert
    assertEquals("0x841415841587F58",
        DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 'X', Byte.MAX_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841587F58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841587F58() {
    // Arrange, Act and Assert
    assertEquals("0x858085841587F58",
        DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 'X', Byte.MAX_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841587F58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841587F58() {
    // Arrange, Act and Assert
    assertEquals("0x858415841587F58",
        DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 'X', Byte.MAX_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841587F58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841587F58() {
    // Arrange, Act and Assert
    assertEquals("0x880415841587F58",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', Byte.MAX_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8004158415841FF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8004158415841FF() {
    // Arrange, Act and Assert
    assertEquals("0x8004158415841FF", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 'A', -1}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8074158415841FF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8074158415841FF() {
    // Arrange, Act and Assert
    assertEquals("0x8074158415841FF", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 'A', -1}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8084158415841FF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8084158415841FF() {
    // Arrange, Act and Assert
    assertEquals("0x8084158415841FF", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 'X', 'A', -1}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8144158415841FF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8144158415841FF() {
    // Arrange, Act and Assert
    assertEquals("0x8144158415841FF", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 'A', -1}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8414158415841FF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8414158415841FF() {
    // Arrange, Act and Assert
    assertEquals("0x8414158415841FF", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 'X', 'A', -1}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x8415841584158", DataWord.shortHex(new byte[]{0, '\b', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8580858415841FF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8580858415841FF() {
    // Arrange, Act and Assert
    assertEquals("0x8580858415841FF", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 'X', 'A', -1}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8584158415841FF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8584158415841FF() {
    // Arrange, Act and Assert
    assertEquals("0x8584158415841FF", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 'X', 'A', -1}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x8804158415841FF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x8804158415841FF() {
    // Arrange, Act and Assert
    assertEquals("0x8804158415841FF", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', -1}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x80041584158417F}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x80041584158417F() {
    // Arrange, Act and Assert
    assertEquals("0x80041584158417F", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x80741584158417F}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x80741584158417F() {
    // Arrange, Act and Assert
    assertEquals("0x80741584158417F", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x80841584158417F}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x80841584158417F() {
    // Arrange, Act and Assert
    assertEquals("0x80841584158417F",
        DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x81441584158417F}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x81441584158417F() {
    // Arrange, Act and Assert
    assertEquals("0x81441584158417F", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x84141584158417F}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x84141584158417F() {
    // Arrange, Act and Assert
    assertEquals("0x84141584158417F",
        DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x85808584158417F}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x85808584158417F() {
    // Arrange, Act and Assert
    assertEquals("0x85808584158417F",
        DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 'X', 'A', Byte.MAX_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x85841584158417F}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x85841584158417F() {
    // Arrange, Act and Assert
    assertEquals("0x85841584158417F",
        DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x88041584158417F}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x88041584158417F() {
    // Arrange, Act and Assert
    assertEquals("0x88041584158417F",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x707415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x707415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x707415841584158", DataWord.shortHex(new byte[]{7, 7, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x708415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x708415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x708415841584158", DataWord.shortHex(new byte[]{7, '\b', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x714415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x714415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x714415841584158", DataWord.shortHex(new byte[]{7, 20, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x780415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x780415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x780415841584158", DataWord.shortHex(new byte[]{7, Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800005841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800005841584158() {
    // Arrange, Act and Assert
    assertEquals("0x800005841584158", DataWord.shortHex(new byte[]{'\b', 0, 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800075841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800075841584158() {
    // Arrange, Act and Assert
    assertEquals("0x800075841584158", DataWord.shortHex(new byte[]{'\b', 0, 7, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800085841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800085841584158() {
    // Arrange, Act and Assert
    assertEquals("0x800085841584158", DataWord.shortHex(new byte[]{'\b', 0, '\b', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800145841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800145841584158() {
    // Arrange, Act and Assert
    assertEquals("0x800145841584158", DataWord.shortHex(new byte[]{'\b', 0, 20, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800410041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800410041584158() {
    // Arrange, Act and Assert
    assertEquals("0x800410041584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800410741584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800410741584158() {
    // Arrange, Act and Assert
    assertEquals("0x800410741584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 7, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800410841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800410841584158() {
    // Arrange, Act and Assert
    assertEquals("0x800410841584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', '\b', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800411441584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800411441584158() {
    // Arrange, Act and Assert
    assertEquals("0x800411441584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 20, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800414141584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800414141584158() {
    // Arrange, Act and Assert
    assertEquals("0x800414141584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'A', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415800584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415800584158() {
    // Arrange, Act and Assert
    assertEquals("0x800415800584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415807584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415807584158() {
    // Arrange, Act and Assert
    assertEquals("0x800415807584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 7, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415808584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415808584158() {
    // Arrange, Act and Assert
    assertEquals("0x800415808584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', '\b', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415814584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415814584158() {
    // Arrange, Act and Assert
    assertEquals("0x800415814584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 20, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841004158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841004158() {
    // Arrange, Act and Assert
    assertEquals("0x800415841004158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 0, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841074158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841074158() {
    // Arrange, Act and Assert
    assertEquals("0x800415841074158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 7, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841084158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841084158() {
    // Arrange, Act and Assert
    assertEquals("0x800415841084158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', '\b', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841144158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841144158() {
    // Arrange, Act and Assert
    assertEquals("0x800415841144158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 20, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841414158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841414158() {
    // Arrange, Act and Assert
    assertEquals("0x800415841414158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'A', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841580058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841580058() {
    // Arrange, Act and Assert
    assertEquals("0x800415841580058", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 0, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841580758}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841580758() {
    // Arrange, Act and Assert
    assertEquals("0x800415841580758", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 7, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841580858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841580858() {
    // Arrange, Act and Assert
    assertEquals("0x800415841580858", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', '\b', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841581458}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841581458() {
    // Arrange, Act and Assert
    assertEquals("0x800415841581458", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 20, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841584100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841584100() {
    // Arrange, Act and Assert
    assertEquals("0x800415841584100", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841584107}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841584107() {
    // Arrange, Act and Assert
    assertEquals("0x800415841584107", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 'A', 7}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841584108}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841584108() {
    // Arrange, Act and Assert
    assertEquals("0x800415841584108", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 'A', '\b'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841584114}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841584114() {
    // Arrange, Act and Assert
    assertEquals("0x800415841584114", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 'A', 20}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841584141}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841584141() {
    // Arrange, Act and Assert
    assertEquals("0x800415841584141", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 'A', 'A'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x800415841584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841584180}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841584180() {
    // Arrange, Act and Assert
    assertEquals("0x800415841584180", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841585858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841585858() {
    // Arrange, Act and Assert
    assertEquals("0x800415841585858", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', 'X', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841588058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841588058() {
    // Arrange, Act and Assert
    assertEquals("0x800415841588058", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', 'X', Byte.MIN_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415841804158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415841804158() {
    // Arrange, Act and Assert
    assertEquals("0x800415841804158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415858584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415858584158() {
    // Arrange, Act and Assert
    assertEquals("0x800415858584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', 'X', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800415880584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800415880584158() {
    // Arrange, Act and Assert
    assertEquals("0x800415880584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800418041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800418041584158() {
    // Arrange, Act and Assert
    assertEquals("0x800418041584158", DataWord.shortHex(new byte[]{'\b', 0, 'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800585841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800585841584158() {
    // Arrange, Act and Assert
    assertEquals("0x800585841584158", DataWord.shortHex(new byte[]{'\b', 0, 'X', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x800805841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x800805841584158() {
    // Arrange, Act and Assert
    assertEquals("0x800805841584158", DataWord.shortHex(new byte[]{'\b', 0, Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807005841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807005841584158() {
    // Arrange, Act and Assert
    assertEquals("0x807005841584158", DataWord.shortHex(new byte[]{'\b', 7, 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807075841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807075841584158() {
    // Arrange, Act and Assert
    assertEquals("0x807075841584158", DataWord.shortHex(new byte[]{'\b', 7, 7, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807085841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807085841584158() {
    // Arrange, Act and Assert
    assertEquals("0x807085841584158", DataWord.shortHex(new byte[]{'\b', 7, '\b', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807145841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807145841584158() {
    // Arrange, Act and Assert
    assertEquals("0x807145841584158", DataWord.shortHex(new byte[]{'\b', 7, 20, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807410041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807410041584158() {
    // Arrange, Act and Assert
    assertEquals("0x807410041584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807410741584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807410741584158() {
    // Arrange, Act and Assert
    assertEquals("0x807410741584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 7, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807410841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807410841584158() {
    // Arrange, Act and Assert
    assertEquals("0x807410841584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', '\b', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807411441584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807411441584158() {
    // Arrange, Act and Assert
    assertEquals("0x807411441584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 20, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807414141584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807414141584158() {
    // Arrange, Act and Assert
    assertEquals("0x807414141584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'A', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415800584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415800584158() {
    // Arrange, Act and Assert
    assertEquals("0x807415800584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415807584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415807584158() {
    // Arrange, Act and Assert
    assertEquals("0x807415807584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 7, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415808584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415808584158() {
    // Arrange, Act and Assert
    assertEquals("0x807415808584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', '\b', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415814584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415814584158() {
    // Arrange, Act and Assert
    assertEquals("0x807415814584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 20, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841004158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841004158() {
    // Arrange, Act and Assert
    assertEquals("0x807415841004158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 0, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841074158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841074158() {
    // Arrange, Act and Assert
    assertEquals("0x807415841074158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 7, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841084158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841084158() {
    // Arrange, Act and Assert
    assertEquals("0x807415841084158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', '\b', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841144158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841144158() {
    // Arrange, Act and Assert
    assertEquals("0x807415841144158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 20, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841414158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841414158() {
    // Arrange, Act and Assert
    assertEquals("0x807415841414158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'A', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841580058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841580058() {
    // Arrange, Act and Assert
    assertEquals("0x807415841580058", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 0, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841580758}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841580758() {
    // Arrange, Act and Assert
    assertEquals("0x807415841580758", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 7, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841580858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841580858() {
    // Arrange, Act and Assert
    assertEquals("0x807415841580858", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', '\b', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841581458}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841581458() {
    // Arrange, Act and Assert
    assertEquals("0x807415841581458", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 20, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841584100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841584100() {
    // Arrange, Act and Assert
    assertEquals("0x807415841584100", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841584107}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841584107() {
    // Arrange, Act and Assert
    assertEquals("0x807415841584107", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 'A', 7}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841584108}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841584108() {
    // Arrange, Act and Assert
    assertEquals("0x807415841584108", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 'A', '\b'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841584114}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841584114() {
    // Arrange, Act and Assert
    assertEquals("0x807415841584114", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 'A', 20}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841584141}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841584141() {
    // Arrange, Act and Assert
    assertEquals("0x807415841584141", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 'A', 'A'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x807415841584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841584180}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841584180() {
    // Arrange, Act and Assert
    assertEquals("0x807415841584180", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841585858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841585858() {
    // Arrange, Act and Assert
    assertEquals("0x807415841585858", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', 'X', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841588058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841588058() {
    // Arrange, Act and Assert
    assertEquals("0x807415841588058", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', 'X', Byte.MIN_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415841804158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415841804158() {
    // Arrange, Act and Assert
    assertEquals("0x807415841804158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415858584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415858584158() {
    // Arrange, Act and Assert
    assertEquals("0x807415858584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', 'X', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807415880584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807415880584158() {
    // Arrange, Act and Assert
    assertEquals("0x807415880584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807418041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807418041584158() {
    // Arrange, Act and Assert
    assertEquals("0x807418041584158", DataWord.shortHex(new byte[]{'\b', 7, 'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807585841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807585841584158() {
    // Arrange, Act and Assert
    assertEquals("0x807585841584158", DataWord.shortHex(new byte[]{'\b', 7, 'X', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x807805841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x807805841584158() {
    // Arrange, Act and Assert
    assertEquals("0x807805841584158", DataWord.shortHex(new byte[]{'\b', 7, Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808005841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808005841584158() {
    // Arrange, Act and Assert
    assertEquals("0x808005841584158", DataWord.shortHex(new byte[]{'\b', '\b', 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808075841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808075841584158() {
    // Arrange, Act and Assert
    assertEquals("0x808075841584158", DataWord.shortHex(new byte[]{'\b', '\b', 7, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808145841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808145841584158() {
    // Arrange, Act and Assert
    assertEquals("0x808145841584158", DataWord.shortHex(new byte[]{'\b', '\b', 20, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808410041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808410041584158() {
    // Arrange, Act and Assert
    assertEquals("0x808410041584158", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808410741584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808410741584158() {
    // Arrange, Act and Assert
    assertEquals("0x808410741584158", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 7, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808411441584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808411441584158() {
    // Arrange, Act and Assert
    assertEquals("0x808411441584158", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 20, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415800584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415800584158() {
    // Arrange, Act and Assert
    assertEquals("0x808415800584158", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415807584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415807584158() {
    // Arrange, Act and Assert
    assertEquals("0x808415807584158", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 7, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415814584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415814584158() {
    // Arrange, Act and Assert
    assertEquals("0x808415814584158", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 20, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841004158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841004158() {
    // Arrange, Act and Assert
    assertEquals("0x808415841004158", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 0, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841074158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841074158() {
    // Arrange, Act and Assert
    assertEquals("0x808415841074158", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 7, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841144158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841144158() {
    // Arrange, Act and Assert
    assertEquals("0x808415841144158", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 20, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841580058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841580058() {
    // Arrange, Act and Assert
    assertEquals("0x808415841580058", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 'X', 0, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841580758}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841580758() {
    // Arrange, Act and Assert
    assertEquals("0x808415841580758", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 'X', 7, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841581458}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841581458() {
    // Arrange, Act and Assert
    assertEquals("0x808415841581458", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 'X', 20, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841584100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841584100() {
    // Arrange, Act and Assert
    assertEquals("0x808415841584100", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841584107}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841584107() {
    // Arrange, Act and Assert
    assertEquals("0x808415841584107", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 'X', 'A', 7}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841584114}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841584114() {
    // Arrange, Act and Assert
    assertEquals("0x808415841584114", DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 'X', 'A', 20}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841584180}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841584180() {
    // Arrange, Act and Assert
    assertEquals("0x808415841584180",
        DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841588058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841588058() {
    // Arrange, Act and Assert
    assertEquals("0x808415841588058",
        DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', 'X', Byte.MIN_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415841804158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415841804158() {
    // Arrange, Act and Assert
    assertEquals("0x808415841804158",
        DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808415880584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808415880584158() {
    // Arrange, Act and Assert
    assertEquals("0x808415880584158",
        DataWord.shortHex(new byte[]{'\b', '\b', 'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808418041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808418041584158() {
    // Arrange, Act and Assert
    assertEquals("0x808418041584158",
        DataWord.shortHex(new byte[]{'\b', '\b', 'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x808805841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x808805841584158() {
    // Arrange, Act and Assert
    assertEquals("0x808805841584158",
        DataWord.shortHex(new byte[]{'\b', '\b', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814005841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814005841584158() {
    // Arrange, Act and Assert
    assertEquals("0x814005841584158", DataWord.shortHex(new byte[]{'\b', 20, 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814075841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814075841584158() {
    // Arrange, Act and Assert
    assertEquals("0x814075841584158", DataWord.shortHex(new byte[]{'\b', 20, 7, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814085841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814085841584158() {
    // Arrange, Act and Assert
    assertEquals("0x814085841584158", DataWord.shortHex(new byte[]{'\b', 20, '\b', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814145841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814145841584158() {
    // Arrange, Act and Assert
    assertEquals("0x814145841584158", DataWord.shortHex(new byte[]{'\b', 20, 20, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814410041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814410041584158() {
    // Arrange, Act and Assert
    assertEquals("0x814410041584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814410741584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814410741584158() {
    // Arrange, Act and Assert
    assertEquals("0x814410741584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 7, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814410841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814410841584158() {
    // Arrange, Act and Assert
    assertEquals("0x814410841584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', '\b', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814411441584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814411441584158() {
    // Arrange, Act and Assert
    assertEquals("0x814411441584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 20, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814414141584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814414141584158() {
    // Arrange, Act and Assert
    assertEquals("0x814414141584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'A', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415800584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415800584158() {
    // Arrange, Act and Assert
    assertEquals("0x814415800584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415807584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415807584158() {
    // Arrange, Act and Assert
    assertEquals("0x814415807584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 7, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415808584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415808584158() {
    // Arrange, Act and Assert
    assertEquals("0x814415808584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', '\b', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415814584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415814584158() {
    // Arrange, Act and Assert
    assertEquals("0x814415814584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 20, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841004158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841004158() {
    // Arrange, Act and Assert
    assertEquals("0x814415841004158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 0, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841074158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841074158() {
    // Arrange, Act and Assert
    assertEquals("0x814415841074158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 7, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841084158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841084158() {
    // Arrange, Act and Assert
    assertEquals("0x814415841084158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', '\b', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841144158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841144158() {
    // Arrange, Act and Assert
    assertEquals("0x814415841144158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 20, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841414158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841414158() {
    // Arrange, Act and Assert
    assertEquals("0x814415841414158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'A', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841580058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841580058() {
    // Arrange, Act and Assert
    assertEquals("0x814415841580058", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 0, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841580758}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841580758() {
    // Arrange, Act and Assert
    assertEquals("0x814415841580758", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 7, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841580858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841580858() {
    // Arrange, Act and Assert
    assertEquals("0x814415841580858", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', '\b', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841581458}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841581458() {
    // Arrange, Act and Assert
    assertEquals("0x814415841581458", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 20, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841584100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841584100() {
    // Arrange, Act and Assert
    assertEquals("0x814415841584100", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841584107}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841584107() {
    // Arrange, Act and Assert
    assertEquals("0x814415841584107", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 'A', 7}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841584108}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841584108() {
    // Arrange, Act and Assert
    assertEquals("0x814415841584108", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 'A', '\b'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841584114}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841584114() {
    // Arrange, Act and Assert
    assertEquals("0x814415841584114", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 'A', 20}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841584141}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841584141() {
    // Arrange, Act and Assert
    assertEquals("0x814415841584141", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 'A', 'A'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x814415841584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841584180}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841584180() {
    // Arrange, Act and Assert
    assertEquals("0x814415841584180", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841585858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841585858() {
    // Arrange, Act and Assert
    assertEquals("0x814415841585858", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', 'X', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841588058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841588058() {
    // Arrange, Act and Assert
    assertEquals("0x814415841588058", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', 'X', Byte.MIN_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415841804158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415841804158() {
    // Arrange, Act and Assert
    assertEquals("0x814415841804158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415858584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415858584158() {
    // Arrange, Act and Assert
    assertEquals("0x814415858584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', 'X', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814415880584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814415880584158() {
    // Arrange, Act and Assert
    assertEquals("0x814415880584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814418041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814418041584158() {
    // Arrange, Act and Assert
    assertEquals("0x814418041584158", DataWord.shortHex(new byte[]{'\b', 20, 'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814585841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814585841584158() {
    // Arrange, Act and Assert
    assertEquals("0x814585841584158", DataWord.shortHex(new byte[]{'\b', 20, 'X', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x814805841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x814805841584158() {
    // Arrange, Act and Assert
    assertEquals("0x814805841584158", DataWord.shortHex(new byte[]{'\b', 20, Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x815415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x815415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x815415841584158", DataWord.shortHex(new byte[]{'\b', 21, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841005841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841005841584158() {
    // Arrange, Act and Assert
    assertEquals("0x841005841584158", DataWord.shortHex(new byte[]{'\b', 'A', 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841075841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841075841584158() {
    // Arrange, Act and Assert
    assertEquals("0x841075841584158", DataWord.shortHex(new byte[]{'\b', 'A', 7, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841145841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841145841584158() {
    // Arrange, Act and Assert
    assertEquals("0x841145841584158", DataWord.shortHex(new byte[]{'\b', 'A', 20, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841410041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841410041584158() {
    // Arrange, Act and Assert
    assertEquals("0x841410041584158", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841410741584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841410741584158() {
    // Arrange, Act and Assert
    assertEquals("0x841410741584158", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 7, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841411441584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841411441584158() {
    // Arrange, Act and Assert
    assertEquals("0x841411441584158", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 20, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415800584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415800584158() {
    // Arrange, Act and Assert
    assertEquals("0x841415800584158", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415807584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415807584158() {
    // Arrange, Act and Assert
    assertEquals("0x841415807584158", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 7, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415814584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415814584158() {
    // Arrange, Act and Assert
    assertEquals("0x841415814584158", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 20, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841004158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841004158() {
    // Arrange, Act and Assert
    assertEquals("0x841415841004158", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 0, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841074158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841074158() {
    // Arrange, Act and Assert
    assertEquals("0x841415841074158", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 7, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841144158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841144158() {
    // Arrange, Act and Assert
    assertEquals("0x841415841144158", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 20, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841580058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841580058() {
    // Arrange, Act and Assert
    assertEquals("0x841415841580058", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 'X', 0, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841580758}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841580758() {
    // Arrange, Act and Assert
    assertEquals("0x841415841580758", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 'X', 7, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841581458}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841581458() {
    // Arrange, Act and Assert
    assertEquals("0x841415841581458", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 'X', 20, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841584100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841584100() {
    // Arrange, Act and Assert
    assertEquals("0x841415841584100", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841584107}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841584107() {
    // Arrange, Act and Assert
    assertEquals("0x841415841584107", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 'X', 'A', 7}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841584114}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841584114() {
    // Arrange, Act and Assert
    assertEquals("0x841415841584114", DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 'X', 'A', 20}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841584180}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841584180() {
    // Arrange, Act and Assert
    assertEquals("0x841415841584180",
        DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841588058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841588058() {
    // Arrange, Act and Assert
    assertEquals("0x841415841588058",
        DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', 'X', Byte.MIN_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415841804158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415841804158() {
    // Arrange, Act and Assert
    assertEquals("0x841415841804158",
        DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841415880584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841415880584158() {
    // Arrange, Act and Assert
    assertEquals("0x841415880584158",
        DataWord.shortHex(new byte[]{'\b', 'A', 'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841418041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841418041584158() {
    // Arrange, Act and Assert
    assertEquals("0x841418041584158",
        DataWord.shortHex(new byte[]{'\b', 'A', 'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x841805841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x841805841584158() {
    // Arrange, Act and Assert
    assertEquals("0x841805841584158",
        DataWord.shortHex(new byte[]{'\b', 'A', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858005841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858005841584158() {
    // Arrange, Act and Assert
    assertEquals("0x858005841584158", DataWord.shortHex(new byte[]{'\b', 'X', 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858075841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858075841584158() {
    // Arrange, Act and Assert
    assertEquals("0x858075841584158", DataWord.shortHex(new byte[]{'\b', 'X', 7, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858080041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858080041584158() {
    // Arrange, Act and Assert
    assertEquals("0x858080041584158", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858080741584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858080741584158() {
    // Arrange, Act and Assert
    assertEquals("0x858080741584158", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 7, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858080841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858080841584158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858080841584158", DataWord.shortHex("\bX\b\bAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858081441584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858081441584158() {
    // Arrange, Act and Assert
    assertEquals("0x858081441584158", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 20, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085800584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085800584158() {
    // Arrange, Act and Assert
    assertEquals("0x858085800584158", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085807584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085807584158() {
    // Arrange, Act and Assert
    assertEquals("0x858085807584158", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 7, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085808584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085808584158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858085808584158", DataWord.shortHex("\bX\bX\bXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085814584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085814584158() {
    // Arrange, Act and Assert
    assertEquals("0x858085814584158", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 20, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841004158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841004158() {
    // Arrange, Act and Assert
    assertEquals("0x858085841004158", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 0, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841074158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841074158() {
    // Arrange, Act and Assert
    assertEquals("0x858085841074158", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 7, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841084158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841084158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858085841084158", DataWord.shortHex("\bX\bXA\bAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841144158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841144158() {
    // Arrange, Act and Assert
    assertEquals("0x858085841144158", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 20, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841580058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841580058() {
    // Arrange, Act and Assert
    assertEquals("0x858085841580058", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 'X', 0, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841580758}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841580758() {
    // Arrange, Act and Assert
    assertEquals("0x858085841580758", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 'X', 7, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841580858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841580858() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858085841580858", DataWord.shortHex("\bX\bXAX\bX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841581458}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841581458() {
    // Arrange, Act and Assert
    assertEquals("0x858085841581458", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 'X', 20, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841584100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841584100() {
    // Arrange, Act and Assert
    assertEquals("0x858085841584100", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841584107}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841584107() {
    // Arrange, Act and Assert
    assertEquals("0x858085841584107", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 'X', 'A', 7}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841584114}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841584114() {
    // Arrange, Act and Assert
    assertEquals("0x858085841584114", DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 'X', 'A', 20}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841584180}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841584180() {
    // Arrange, Act and Assert
    assertEquals("0x858085841584180",
        DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 'X', 'A', Byte.MIN_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841588058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841588058() {
    // Arrange, Act and Assert
    assertEquals("0x858085841588058",
        DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', 'X', Byte.MIN_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085841804158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085841804158() {
    // Arrange, Act and Assert
    assertEquals("0x858085841804158",
        DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858085880584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858085880584158() {
    // Arrange, Act and Assert
    assertEquals("0x858085880584158",
        DataWord.shortHex(new byte[]{'\b', 'X', '\b', 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858088041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858088041584158() {
    // Arrange, Act and Assert
    assertEquals("0x858088041584158",
        DataWord.shortHex(new byte[]{'\b', 'X', '\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858145841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858145841584158() {
    // Arrange, Act and Assert
    assertEquals("0x858145841584158", DataWord.shortHex(new byte[]{'\b', 'X', 20, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858155841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858155841584158() {
    // Arrange, Act and Assert
    assertEquals("0x858155841584158", DataWord.shortHex(new byte[]{'\b', 'X', 21, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858410041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858410041584158() {
    // Arrange, Act and Assert
    assertEquals("0x858410041584158", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858410741584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858410741584158() {
    // Arrange, Act and Assert
    assertEquals("0x858410741584158", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 7, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858411441584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858411441584158() {
    // Arrange, Act and Assert
    assertEquals("0x858411441584158", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 20, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415800584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415800584158() {
    // Arrange, Act and Assert
    assertEquals("0x858415800584158", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415807584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415807584158() {
    // Arrange, Act and Assert
    assertEquals("0x858415807584158", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 7, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415814584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415814584158() {
    // Arrange, Act and Assert
    assertEquals("0x858415814584158", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 20, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841004158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841004158() {
    // Arrange, Act and Assert
    assertEquals("0x858415841004158", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 0, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841074158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841074158() {
    // Arrange, Act and Assert
    assertEquals("0x858415841074158", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 7, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841144158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841144158() {
    // Arrange, Act and Assert
    assertEquals("0x858415841144158", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 20, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841580058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841580058() {
    // Arrange, Act and Assert
    assertEquals("0x858415841580058", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 'X', 0, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841580758}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841580758() {
    // Arrange, Act and Assert
    assertEquals("0x858415841580758", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 'X', 7, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841581458}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841581458() {
    // Arrange, Act and Assert
    assertEquals("0x858415841581458", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 'X', 20, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841584100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841584100() {
    // Arrange, Act and Assert
    assertEquals("0x858415841584100", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841584107}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841584107() {
    // Arrange, Act and Assert
    assertEquals("0x858415841584107", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 'X', 'A', 7}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841584114}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841584114() {
    // Arrange, Act and Assert
    assertEquals("0x858415841584114", DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 'X', 'A', 20}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841584180}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841584180() {
    // Arrange, Act and Assert
    assertEquals("0x858415841584180",
        DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841588058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841588058() {
    // Arrange, Act and Assert
    assertEquals("0x858415841588058",
        DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', 'X', Byte.MIN_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415841804158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415841804158() {
    // Arrange, Act and Assert
    assertEquals("0x858415841804158",
        DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858415880584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858415880584158() {
    // Arrange, Act and Assert
    assertEquals("0x858415880584158",
        DataWord.shortHex(new byte[]{'\b', 'X', 'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858418041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858418041584158() {
    // Arrange, Act and Assert
    assertEquals("0x858418041584158",
        DataWord.shortHex(new byte[]{'\b', 'X', 'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x858805841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x858805841584158() {
    // Arrange, Act and Assert
    assertEquals("0x858805841584158",
        DataWord.shortHex(new byte[]{'\b', 'X', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880005841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880005841584158() {
    // Arrange, Act and Assert
    assertEquals("0x880005841584158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880075841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880075841584158() {
    // Arrange, Act and Assert
    assertEquals("0x880075841584158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 7, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880085841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880085841584158() {
    // Arrange, Act and Assert
    assertEquals("0x880085841584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, '\b', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880145841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880145841584158() {
    // Arrange, Act and Assert
    assertEquals("0x880145841584158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 20, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880410041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880410041584158() {
    // Arrange, Act and Assert
    assertEquals("0x880410041584158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880410741584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880410741584158() {
    // Arrange, Act and Assert
    assertEquals("0x880410741584158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 7, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880410841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880410841584158() {
    // Arrange, Act and Assert
    assertEquals("0x880410841584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', '\b', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880411441584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880411441584158() {
    // Arrange, Act and Assert
    assertEquals("0x880411441584158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 20, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880414141584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880414141584158() {
    // Arrange, Act and Assert
    assertEquals("0x880414141584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'A', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415800584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415800584158() {
    // Arrange, Act and Assert
    assertEquals("0x880415800584158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415807584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415807584158() {
    // Arrange, Act and Assert
    assertEquals("0x880415807584158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 7, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415808584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415808584158() {
    // Arrange, Act and Assert
    assertEquals("0x880415808584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', '\b', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415814584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415814584158() {
    // Arrange, Act and Assert
    assertEquals("0x880415814584158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 20, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841004158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841004158() {
    // Arrange, Act and Assert
    assertEquals("0x880415841004158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 0, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841074158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841074158() {
    // Arrange, Act and Assert
    assertEquals("0x880415841074158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 7, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841084158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841084158() {
    // Arrange, Act and Assert
    assertEquals("0x880415841084158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', '\b', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841144158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841144158() {
    // Arrange, Act and Assert
    assertEquals("0x880415841144158", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 20, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841414158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841414158() {
    // Arrange, Act and Assert
    assertEquals("0x880415841414158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'A', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841580058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841580058() {
    // Arrange, Act and Assert
    assertEquals("0x880415841580058", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 0, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841580758}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841580758() {
    // Arrange, Act and Assert
    assertEquals("0x880415841580758", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 7, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841580858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841580858() {
    // Arrange, Act and Assert
    assertEquals("0x880415841580858",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', '\b', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841581458}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841581458() {
    // Arrange, Act and Assert
    assertEquals("0x880415841581458", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 20, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841584100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841584100() {
    // Arrange, Act and Assert
    assertEquals("0x880415841584100", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841584107}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841584107() {
    // Arrange, Act and Assert
    assertEquals("0x880415841584107", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 7}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841584108}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841584108() {
    // Arrange, Act and Assert
    assertEquals("0x880415841584108",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', '\b'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841584114}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841584114() {
    // Arrange, Act and Assert
    assertEquals("0x880415841584114", DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 20}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841584141}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841584141() {
    // Arrange, Act and Assert
    assertEquals("0x880415841584141",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'A'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x880415841584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841584180}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841584180() {
    // Arrange, Act and Assert
    assertEquals("0x880415841584180",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841585858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841585858() {
    // Arrange, Act and Assert
    assertEquals("0x880415841585858",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'X', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841588058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841588058() {
    // Arrange, Act and Assert
    assertEquals("0x880415841588058",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', Byte.MIN_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415841804158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415841804158() {
    // Arrange, Act and Assert
    assertEquals("0x880415841804158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415858584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415858584158() {
    // Arrange, Act and Assert
    assertEquals("0x880415858584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', 'X', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880415880584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880415880584158() {
    // Arrange, Act and Assert
    assertEquals("0x880415880584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880418041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880418041584158() {
    // Arrange, Act and Assert
    assertEquals("0x880418041584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880585841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880585841584158() {
    // Arrange, Act and Assert
    assertEquals("0x880585841584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, 'X', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code 0x880805841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_thenReturn0x880805841584158() {
    // Arrange, Act and Assert
    assertEquals("0x880805841584158",
        DataWord.shortHex(new byte[]{'\b', Byte.MIN_VALUE, Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When A backspace AXAX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808410841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenABackspaceAxaxBytesIsUtf8_thenReturn0x808410841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808410841584158", DataWord.shortHex("\b\bA\bAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When A backspace XAXAX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841085841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenABackspaceXaxaxBytesIsUtf8_thenReturn0x841085841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841085841584158", DataWord.shortHex("\bA\bXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When AA backspace AXAX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841410841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAaBackspaceAxaxBytesIsUtf8_thenReturn0x841410841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841410841584158", DataWord.shortHex("\bAA\bAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AAAAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841414141584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAaaaxaxBytesIsUtf8_thenReturn0x841414141584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841414141584158", DataWord.shortHex("\bAAAAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AAAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808414141584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAaaxaxBytesIsUtf8_thenReturn0x808414141584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808414141584158", DataWord.shortHex("\b\bAAAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When AAX backspace XAX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841415808584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAaxBackspaceXaxBytesIsUtf8_thenReturn0x841415808584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841415808584158", DataWord.shortHex("\bAAX\bXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When AAXA backspace AX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841415841084158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAaxaBackspaceAxBytesIsUtf8_thenReturn0x841415841084158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841415841084158", DataWord.shortHex("\bAAXA\bAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AAXAAAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841415841414158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAaxaaaxBytesIsUtf8_thenReturn0x841415841414158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841415841414158", DataWord.shortHex("\bAAXAAAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When AAXAX backspace X Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841415841580858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAaxaxBackspaceXBytesIsUtf8_thenReturn0x841415841580858()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841415841580858", DataWord.shortHex("\bAAXAX\bX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AAXAXA} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841415841584108}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAaxaxaBytesIsUtf8_thenReturn0x841415841584108()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841415841584108", DataWord.shortHex("\bAAXAXA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AAXAXAA} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841415841584141}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAaxaxaaBytesIsUtf8_thenReturn0x841415841584141()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841415841584141", DataWord.shortHex("\bAAXAXAA".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAaxaxaxBytesIsUtf8_thenReturn0x841415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841415841584158", DataWord.shortHex("\bAAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AAXAXXX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841415841585858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAaxaxxxBytesIsUtf8_thenReturn0x841415841585858()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841415841585858", DataWord.shortHex("\bAAXAXXX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AAXXXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841415858584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAaxxxaxBytesIsUtf8_thenReturn0x841415858584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841415858584158", DataWord.shortHex("\bAAXXXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code A}.</li>
   *   <li>Then return {@code 0x741415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndA_thenReturn0x741415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x741415841584158", DataWord.shortHex(new byte[]{7, 'A', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758FF5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758FF5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x758FF5841584158", DataWord.shortHex(new byte[]{7, 'X', -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x7587F5841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x7587F5841584158() {
    // Arrange, Act and Assert
    assertEquals("0x7587F5841584158", DataWord.shortHex(new byte[]{7, 'X', Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x75841FF41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x75841FF41584158() {
    // Arrange, Act and Assert
    assertEquals("0x75841FF41584158", DataWord.shortHex(new byte[]{7, 'X', 'A', -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758417F41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758417F41584158() {
    // Arrange, Act and Assert
    assertEquals("0x758417F41584158", DataWord.shortHex(new byte[]{7, 'X', 'A', Byte.MAX_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x7584158FF584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x7584158FF584158() {
    // Arrange, Act and Assert
    assertEquals("0x7584158FF584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x75841587F584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x75841587F584158() {
    // Arrange, Act and Assert
    assertEquals("0x75841587F584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', Byte.MAX_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841FF4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841FF4158() {
    // Arrange, Act and Assert
    assertEquals("0x758415841FF4158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x7584158417F4158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x7584158417F4158() {
    // Arrange, Act and Assert
    assertEquals("0x7584158417F4158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', Byte.MAX_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x75841584158FF58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x75841584158FF58() {
    // Arrange, Act and Assert
    assertEquals("0x75841584158FF58", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841587F58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841587F58() {
    // Arrange, Act and Assert
    assertEquals("0x758415841587F58", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', Byte.MAX_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x7584158415841FF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x7584158415841FF() {
    // Arrange, Act and Assert
    assertEquals("0x7584158415841FF", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 'A', -1}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x75841584158417F}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x75841584158417F() {
    // Arrange, Act and Assert
    assertEquals("0x75841584158417F", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758005841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758005841584158() {
    // Arrange, Act and Assert
    assertEquals("0x758005841584158", DataWord.shortHex(new byte[]{7, 'X', 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758075841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758075841584158() {
    // Arrange, Act and Assert
    assertEquals("0x758075841584158", DataWord.shortHex(new byte[]{7, 'X', 7, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758085841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758085841584158() {
    // Arrange, Act and Assert
    assertEquals("0x758085841584158", DataWord.shortHex(new byte[]{7, 'X', '\b', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758145841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758145841584158() {
    // Arrange, Act and Assert
    assertEquals("0x758145841584158", DataWord.shortHex(new byte[]{7, 'X', 20, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758410041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758410041584158() {
    // Arrange, Act and Assert
    assertEquals("0x758410041584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758410741584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758410741584158() {
    // Arrange, Act and Assert
    assertEquals("0x758410741584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 7, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758410841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758410841584158() {
    // Arrange, Act and Assert
    assertEquals("0x758410841584158", DataWord.shortHex(new byte[]{7, 'X', 'A', '\b', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758411441584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758411441584158() {
    // Arrange, Act and Assert
    assertEquals("0x758411441584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 20, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758414141584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758414141584158() {
    // Arrange, Act and Assert
    assertEquals("0x758414141584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'A', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415800584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415800584158() {
    // Arrange, Act and Assert
    assertEquals("0x758415800584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415807584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415807584158() {
    // Arrange, Act and Assert
    assertEquals("0x758415807584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 7, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415808584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415808584158() {
    // Arrange, Act and Assert
    assertEquals("0x758415808584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', '\b', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415814584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415814584158() {
    // Arrange, Act and Assert
    assertEquals("0x758415814584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 20, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841004158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841004158() {
    // Arrange, Act and Assert
    assertEquals("0x758415841004158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 0, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841074158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841074158() {
    // Arrange, Act and Assert
    assertEquals("0x758415841074158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 7, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841084158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841084158() {
    // Arrange, Act and Assert
    assertEquals("0x758415841084158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', '\b', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841144158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841144158() {
    // Arrange, Act and Assert
    assertEquals("0x758415841144158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 20, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841414158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841414158() {
    // Arrange, Act and Assert
    assertEquals("0x758415841414158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'A', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841580058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841580058() {
    // Arrange, Act and Assert
    assertEquals("0x758415841580058", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 0, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841580758}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841580758() {
    // Arrange, Act and Assert
    assertEquals("0x758415841580758", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 7, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841580858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841580858() {
    // Arrange, Act and Assert
    assertEquals("0x758415841580858", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', '\b', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841581458}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841581458() {
    // Arrange, Act and Assert
    assertEquals("0x758415841581458", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 20, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841584100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841584100() {
    // Arrange, Act and Assert
    assertEquals("0x758415841584100", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841584107}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841584107() {
    // Arrange, Act and Assert
    assertEquals("0x758415841584107", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 'A', 7}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841584108}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841584108() {
    // Arrange, Act and Assert
    assertEquals("0x758415841584108", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 'A', '\b'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841584114}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841584114() {
    // Arrange, Act and Assert
    assertEquals("0x758415841584114", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 'A', 20}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841584141}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841584141() {
    // Arrange, Act and Assert
    assertEquals("0x758415841584141", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 'A', 'A'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x758415841584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841584180}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841584180() {
    // Arrange, Act and Assert
    assertEquals("0x758415841584180", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841585858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841585858() {
    // Arrange, Act and Assert
    assertEquals("0x758415841585858", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 'X', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841588058}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841588058() {
    // Arrange, Act and Assert
    assertEquals("0x758415841588058", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', 'X', Byte.MIN_VALUE, 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415841804158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415841804158() {
    // Arrange, Act and Assert
    assertEquals("0x758415841804158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415858584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415858584158() {
    // Arrange, Act and Assert
    assertEquals("0x758415858584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', 'X', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758415880584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758415880584158() {
    // Arrange, Act and Assert
    assertEquals("0x758415880584158", DataWord.shortHex(new byte[]{7, 'X', 'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758418041584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758418041584158() {
    // Arrange, Act and Assert
    assertEquals("0x758418041584158", DataWord.shortHex(new byte[]{7, 'X', 'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758585841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758585841584158() {
    // Arrange, Act and Assert
    assertEquals("0x758585841584158", DataWord.shortHex(new byte[]{7, 'X', 'X', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@code 0x758805841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndX_thenReturn0x758805841584158() {
    // Arrange, Act and Assert
    assertEquals("0x758805841584158", DataWord.shortHex(new byte[]{7, 'X', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with seven and zero.</li>
   *   <li>Then return {@code 0x700415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithSevenAndZero_thenReturn0x700415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x700415841584158", DataWord.shortHex(new byte[]{7, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with zero and one.</li>
   *   <li>Then return {@code 0x1415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithZeroAndOne_thenReturn0x1415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x1415841584158", DataWord.shortHex(new byte[]{0, 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with zero and seven.</li>
   *   <li>Then return {@code 0x7415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithZeroAndSeven_thenReturn0x7415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x7415841584158", DataWord.shortHex(new byte[]{0, 7, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then return {@code 0x58415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithZeroAndX_thenReturn0x58415841584158() {
    // Arrange, Act and Assert
    assertEquals("0x58415841584158", DataWord.shortHex(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   *   <li>Then return {@code 0x0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenArrayOfByteWithZeroAndZero_thenReturn0x0() {
    // Arrange, Act and Assert
    assertEquals("0x0", DataWord.shortHex(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When AX backspace XAX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808415808584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAxBackspaceXaxBytesIsUtf8_thenReturn0x808415808584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808415808584158", DataWord.shortHex("\b\bAX\bXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When AXA backspace AX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808415841084158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAxaBackspaceAxBytesIsUtf8_thenReturn0x808415841084158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808415841084158", DataWord.shortHex("\b\bAXA\bAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AXAAAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808415841414158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAxaaaxBytesIsUtf8_thenReturn0x808415841414158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808415841414158", DataWord.shortHex("\b\bAXAAAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When AXAX backspace X Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808415841580858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAxaxBackspaceXBytesIsUtf8_thenReturn0x808415841580858()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808415841580858", DataWord.shortHex("\b\bAXAX\bX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AXAXA} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808415841584108}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAxaxaBytesIsUtf8_thenReturn0x808415841584108()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808415841584108", DataWord.shortHex("\b\bAXAXA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AXAXAA} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808415841584141}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAxaxaaBytesIsUtf8_thenReturn0x808415841584141()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808415841584141", DataWord.shortHex("\b\bAXAXAA".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAxaxaxBytesIsUtf8_thenReturn0x808415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808415841584158", DataWord.shortHex("\b\bAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAxaxaxaxBytesIsUtf8_thenReturn0x4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x4158415841584158", DataWord.shortHex("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AXAXXX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808415841585858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAxaxxxBytesIsUtf8_thenReturn0x808415841585858()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808415841585858", DataWord.shortHex("\b\bAXAXXX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AXXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x841585841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAxxaxaxBytesIsUtf8_thenReturn0x841585841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x841585841584158", DataWord.shortHex("\bAXXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AXXXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808415858584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenAxxxaxBytesIsUtf8_thenReturn0x808415858584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808415858584158", DataWord.shortHex("\b\bAXXXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When X backspace AAXAX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858084141584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXBackspaceAaxaxBytesIsUtf8_thenReturn0x858084141584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858084141584158", DataWord.shortHex("\bX\bAAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When X backspace XAAAX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858085841414158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXBackspaceXaaaxBytesIsUtf8_thenReturn0x858085841414158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858085841414158", DataWord.shortHex("\bX\bXAAAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When X backspace XAXA Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858085841584108}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXBackspaceXaxaBytesIsUtf8_thenReturn0x858085841584108()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858085841584108", DataWord.shortHex("\bX\bXAXA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When X backspace XAXAA Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858085841584141}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXBackspaceXaxaaBytesIsUtf8_thenReturn0x858085841584141()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858085841584141", DataWord.shortHex("\bX\bXAXAA".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When X backspace XAXAX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858085841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXBackspaceXaxaxBytesIsUtf8_thenReturn0x858085841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858085841584158", DataWord.shortHex("\bX\bXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When X backspace XAXXX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858085841585858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXBackspaceXaxxxBytesIsUtf8_thenReturn0x858085841585858()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858085841585858", DataWord.shortHex("\bX\bXAXXX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When X backspace XXXAX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858085858584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXBackspaceXxxaxBytesIsUtf8_thenReturn0x858085858584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858085858584158", DataWord.shortHex("\bX\bXXXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When XA backspace AXAX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858410841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXaBackspaceAxaxBytesIsUtf8_thenReturn0x858410841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858410841584158", DataWord.shortHex("\bXA\bAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code XAAAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858414141584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXaaaxaxBytesIsUtf8_thenReturn0x858414141584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858414141584158", DataWord.shortHex("\bXAAAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When XAX backspace XAX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858415808584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXaxBackspaceXaxBytesIsUtf8_thenReturn0x858415808584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858415808584158", DataWord.shortHex("\bXAX\bXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When XAXA backspace AX Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858415841084158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXaxaBackspaceAxBytesIsUtf8_thenReturn0x858415841084158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858415841084158", DataWord.shortHex("\bXAXA\bAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code XAXAAAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858415841414158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXaxaaaxBytesIsUtf8_thenReturn0x858415841414158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858415841414158", DataWord.shortHex("\bXAXAAAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When XAXAX backspace X Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858415841580858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXaxaxBackspaceXBytesIsUtf8_thenReturn0x858415841580858()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858415841580858", DataWord.shortHex("\bXAXAX\bX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code XAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808085841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXaxaxBytesIsUtf8_thenReturn0x808085841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808085841584158", DataWord.shortHex("\b\b\bXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code XAXAXA} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858415841584108}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXaxaxaBytesIsUtf8_thenReturn0x858415841584108()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858415841584108", DataWord.shortHex("\bXAXAXA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code XAXAXAA} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858415841584141}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXaxaxaaBytesIsUtf8_thenReturn0x858415841584141()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858415841584141", DataWord.shortHex("\bXAXAXAA".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXaxaxaxBytesIsUtf8_thenReturn0x858415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858415841584158", DataWord.shortHex("\bXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code XAXAXXX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858415841585858}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXaxaxxxBytesIsUtf8_thenReturn0x858415841585858()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858415841585858", DataWord.shortHex("\bXAXAXXX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code XAXXXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858415858584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXaxxxaxBytesIsUtf8_thenReturn0x858415858584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858415858584158", DataWord.shortHex("\bXAXXXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code XXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x808585841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXxaxaxBytesIsUtf8_thenReturn0x808585841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x808585841584158", DataWord.shortHex("\b\bXXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code XXXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0x858585841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex(byte[])"})
  public void testShortHexWithByte_whenXxxaxaxBytesIsUtf8_thenReturn0x858585841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x858585841584158", DataWord.shortHex("\bXXXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#shortHex()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return {@code 0x41}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsA_thenReturn0x41() {
    // Arrange, Act and Assert
    assertEquals("0x41", DataWord.of((byte) 'A').shortHex());
  }

  /**
   * Test {@link DataWord#shortHex()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is backspace.</li>
   *   <li>Then return {@code 0x8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsBackspace_thenReturn0x8() {
    // Arrange, Act and Assert
    assertEquals("0x8", DataWord.of((byte) '\b').shortHex());
  }

  /**
   * Test {@link DataWord#shortHex()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is five.</li>
   *   <li>Then return {@code 0x5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsFive_thenReturn0x5() {
    // Arrange, Act and Assert
    assertEquals("0x5", DataWord.of((byte) 5).shortHex());
  }

  /**
   * Test {@link DataWord#shortHex()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is four.</li>
   *   <li>Then return {@code 0x4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsFour_thenReturn0x4() {
    // Arrange, Act and Assert
    assertEquals("0x4", DataWord.of((byte) 4).shortHex());
  }

  /**
   * Test {@link DataWord#shortHex()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is lf.</li>
   *   <li>Then return {@code 0xA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsLf_thenReturn0xA() {
    // Arrange, Act and Assert
    assertEquals("0xA", DataWord.of((byte) '\n').shortHex());
  }

  /**
   * Test {@link DataWord#shortHex()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is one.</li>
   *   <li>Then return {@code 0x1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsOne_thenReturn0x1() {
    // Arrange, Act and Assert
    assertEquals("0x1", DataWord.of((byte) 1).shortHex());
  }

  /**
   * Test {@link DataWord#shortHex()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is seven.</li>
   *   <li>Then return {@code 0x7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsSeven_thenReturn0x7() {
    // Arrange, Act and Assert
    assertEquals("0x7", DataWord.of((byte) 7).shortHex());
  }

  /**
   * Test {@link DataWord#shortHex()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is six.</li>
   *   <li>Then return {@code 0x6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsSix_thenReturn0x6() {
    // Arrange, Act and Assert
    assertEquals("0x6", DataWord.of((byte) 6).shortHex());
  }

  /**
   * Test {@link DataWord#shortHex()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is tab.</li>
   *   <li>Then return {@code 0x9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsTab_thenReturn0x9() {
    // Arrange, Act and Assert
    assertEquals("0x9", DataWord.of((byte) '\t').shortHex());
  }

  /**
   * Test {@link DataWord#shortHex()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is three.</li>
   *   <li>Then return {@code 0x3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsThree_thenReturn0x3() {
    // Arrange, Act and Assert
    assertEquals("0x3", DataWord.of((byte) 3).shortHex());
  }

  /**
   * Test {@link DataWord#shortHex()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is two.</li>
   *   <li>Then return {@code 0x2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsTwo_thenReturn0x2() {
    // Arrange, Act and Assert
    assertEquals("0x2", DataWord.of((byte) 2).shortHex());
  }

  /**
   * Test {@link DataWord#shortHex()}.
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.</li>
   *   <li>Then return {@code 0x0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenZero_thenReturn0x0() {
    // Arrange, Act and Assert
    assertEquals("0x0", DataWord.ZERO.shortHex());
  }

  /**
   * Test {@link DataWord#sizeInWords(long)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#sizeInWords(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DataWord.sizeInWords(long)"})
  public void testSizeInWords_whenThree_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1L, DataWord.sizeInWords(3L));
  }

  /**
   * Test {@link DataWord#sizeInWords(long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#sizeInWords(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DataWord.sizeInWords(long)"})
  public void testSizeInWords_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, DataWord.sizeInWords(0L));
  }

  /**
   * Test {@link DataWord#parseArray(byte[])}.
   * <p>
   * Method under test: {@link DataWord#parseArray(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord[] DataWord.parseArray(byte[])"})
  public void testParseArray() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, DataWord.parseArray("AXAXAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Test {@link DataWord#isNegative()}.
   * <p>
   * Method under test: {@link DataWord#isNegative()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.isNegative()"})
  public void testIsNegative() {
    // Arrange, Act and Assert
    assertFalse(DataWord.ZERO.isNegative());
  }

  /**
   * Test {@link DataWord#equalAddressByteArray(byte[], byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and twenty.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equalAddressByteArray(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equalAddressByteArray(byte[], byte[])"})
  public void testEqualAddressByteArray_whenArrayOfByteWithAAndTwenty_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(DataWord.equalAddressByteArray(new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20,
        'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#equalAddressByteArray(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equalAddressByteArray(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equalAddressByteArray(byte[], byte[])"})
  public void testEqualAddressByteArray_whenAxaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] arr1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(DataWord.equalAddressByteArray(arr1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DataWord#equalAddressByteArray(byte[], byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equalAddressByteArray(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equalAddressByteArray(byte[], byte[])"})
  public void testEqualAddressByteArray_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DataWord.equalAddressByteArray(null, null));
  }

  /**
   * Test {@link DataWord#equalAddressByteArray(byte[], byte[])}.
   * <ul>
   *   <li>When {@code X}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equalAddressByteArray(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equalAddressByteArray(byte[], byte[])"})
  public void testEqualAddressByteArray_whenX_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DataWord.equalAddressByteArray(null, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DataWord#equalAddressByteArray(byte[], byte[])}.
   * <ul>
   *   <li>When {@code X}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equalAddressByteArray(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equalAddressByteArray(byte[], byte[])"})
  public void testEqualAddressByteArray_whenX_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(DataWord.equalAddressByteArray(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataWord#toString()}
   *   <li>{@link DataWord#getData()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DataWord.getData()", "String DataWord.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    DataWord ZEROResult = DataWord.ZERO();

    // Act
    String actualToStringResult = ZEROResult.toString();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", actualToStringResult);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ZEROResult.getData());
  }

  /**
   * Test {@link DataWord#getNoLeadZeroesData()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return array of {@code byte} with {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#getNoLeadZeroesData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DataWord.getNoLeadZeroesData()"})
  public void testGetNoLeadZeroesData_givenDataWordWithNumIsA_thenReturnArrayOfByteWithA() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A'}, DataWord.of((byte) 'A').getNoLeadZeroesData());
  }

  /**
   * Test {@link DataWord#getNoLeadZeroesData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code *} and {@code I}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#getNoLeadZeroesData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DataWord.getNoLeadZeroesData()"})
  public void testGetNoLeadZeroesData_thenReturnArrayOfByteWithAsteriskAndI() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 'A');
    ofResult.exp(DataWord.of((byte) 'A'));

    // Act and Assert
    assertArrayEquals(new byte[]{'*', 'I', -110, 27, -112, 14, -10, -127, 'b', -32, '$', 'a', -114, '\r', -117, -16,
        '.', '$', 'x', -82, -33, ')', 2, 'R', 'g', '6', -54, -93, '[', 2, 16, 'A'}, ofResult.getNoLeadZeroesData());
  }

  /**
   * Test {@link DataWord#getNoEndZeroesData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#getNoEndZeroesData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DataWord.getNoEndZeroesData()"})
  public void testGetNoEndZeroesData_thenReturnArrayOfByteWithZeroAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        DataWord.of((byte) 'A').getNoEndZeroesData());
  }

  /**
   * Test {@link DataWord#toTronAddress()}.
   * <p>
   * Method under test: {@link DataWord#toTronAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DataWord.toTronAddress()"})
  public void testToTronAddress() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        DataWord.ZERO.toTronAddress());
  }

  /**
   * Test {@link DataWord#intValueSafe()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#intValueSafe()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DataWord.intValueSafe()"})
  public void testIntValueSafe_givenDataWordWithNumIsA_thenReturnSixtyFive() {
    // Arrange, Act and Assert
    assertEquals(65, DataWord.of((byte) 'A').intValueSafe());
  }

  /**
   * Test {@link DataWord#intValueSafe()}.
   * <ul>
   *   <li>Then return {@link Integer#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#intValueSafe()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DataWord.intValueSafe()"})
  public void testIntValueSafe_thenReturnMax_value() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 'A');
    ofResult.exp(DataWord.of((byte) 'A'));

    // Act and Assert
    assertEquals(Integer.MAX_VALUE, ofResult.intValueSafe());
  }

  /**
   * Test {@link DataWord#longValueSafe()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#longValueSafe()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DataWord.longValueSafe()"})
  public void testLongValueSafe_givenDataWordWithNumIsA_thenReturnSixtyFive() {
    // Arrange, Act and Assert
    assertEquals(65L, DataWord.of((byte) 'A').longValueSafe());
  }

  /**
   * Test {@link DataWord#longValueSafe()}.
   * <ul>
   *   <li>Then return {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#longValueSafe()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DataWord.longValueSafe()"})
  public void testLongValueSafe_thenReturnMax_value() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 'A');
    ofResult.exp(DataWord.of((byte) 'A'));

    // Act and Assert
    assertEquals(Long.MAX_VALUE, ofResult.longValueSafe());
  }

  /**
   * Test {@link DataWord#sValue()}.
   * <p>
   * Method under test: {@link DataWord#sValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigInteger DataWord.sValue()"})
  public void testSValue() {
    // Arrange and Act
    BigInteger actualSValueResult = DataWord.ZERO.sValue();

    // Assert
    assertEquals(actualSValueResult.ZERO, actualSValueResult);
  }

  /**
   * Test {@link DataWord#and(DataWord)}.
   * <ul>
   *   <li>When {@link DataWord#ZERO}.</li>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#and(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.and(DataWord)"})
  public void testAnd_whenZero_thenReturnZero() {
    // Arrange and Act
    DataWord actualAndResult = DataWord.ZERO.and(DataWord.ZERO);

    // Assert
    assertSame(actualAndResult.ZERO, actualAndResult);
  }

  /**
   * Test {@link DataWord#or(DataWord)}.
   * <ul>
   *   <li>When {@link DataWord#ZERO}.</li>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#or(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.or(DataWord)"})
  public void testOr_whenZero_thenReturnZero() {
    // Arrange and Act
    DataWord actualOrResult = DataWord.ZERO.or(DataWord.ZERO);

    // Assert
    assertSame(actualOrResult.ZERO, actualOrResult);
  }

  /**
   * Test {@link DataWord#xor(DataWord)}.
   * <ul>
   *   <li>When {@link DataWord#ZERO}.</li>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#xor(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.xor(DataWord)"})
  public void testXor_whenZero_thenReturnZero() {
    // Arrange and Act
    DataWord actualXorResult = DataWord.ZERO.xor(DataWord.ZERO);

    // Assert
    assertSame(actualXorResult.ZERO, actualXorResult);
  }

  /**
   * Test {@link DataWord#negate()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then {@link DataWord} with num is {@code A} toPrefixString is {@code ffffff}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.negate()"})
  public void testNegate_givenDataWordWithNumIsA_thenDataWordWithNumIsAToPrefixStringIsFfffff() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 'A');

    // Act
    ofResult.negate();

    // Assert
    assertEquals("ffffff", ofResult.toPrefixString());
    assertEquals("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffbf", ofResult.toHexString());
    assertTrue(ofResult.isNegative());
    byte[] data = ofResult.getData();
    assertSame(data, ofResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -65},
        ofResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -65},
        ofResult.toTronAddress());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -65}, ofResult.getClonedData());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -65}, data);
  }

  /**
   * Test {@link DataWord#negate()}.
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.</li>
   *   <li>Then {@link DataWord#ZERO} toPrefixString is {@code 00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.negate()"})
  public void testNegate_givenZero_thenZeroToPrefixStringIs00() {
    // Arrange
    DataWord dataWord = DataWord.ZERO;

    // Act
    dataWord.negate();

    // Assert that nothing has changed
    assertEquals("00", dataWord.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", dataWord.toHexString());
    assertFalse(dataWord.isNegative());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataWord.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataWord.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataWord.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataWord.getData());
  }

  /**
   * Test {@link DataWord#bnot()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then {@link DataWord} with num is {@code A} toPrefixString is {@code ffffff}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#bnot()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.bnot()"})
  public void testBnot_givenDataWordWithNumIsA_thenDataWordWithNumIsAToPrefixStringIsFfffff() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 'A');

    // Act
    ofResult.bnot();

    // Assert
    assertEquals("ffffff", ofResult.toPrefixString());
    assertEquals("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffbe", ofResult.toHexString());
    assertTrue(ofResult.isNegative());
    byte[] data = ofResult.getData();
    assertSame(data, ofResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -66},
        ofResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -66},
        ofResult.toTronAddress());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -66}, ofResult.getClonedData());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -66}, data);
  }

  /**
   * Test {@link DataWord#mul(DataWord)}.
   * <p>
   * Method under test: {@link DataWord#mul(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.mul(DataWord)"})
  public void testMul() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 'A');
    DataWord word = DataWord.of((byte) 'A');

    // Act
    ofResult.mul(word);

    // Assert that nothing has changed
    assertEquals("0000000000000000000000000000000000000000000000000000000000000041", word.toHexString());
    assertEquals("41", word.toPrefixString());
    assertArrayEquals(new byte[]{'A'}, word.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'}, word.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        word.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        word.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        word.getData());
  }

  /**
   * Test {@link DataWord#mul(DataWord)}.
   * <p>
   * Method under test: {@link DataWord#mul(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.mul(DataWord)"})
  public void testMul2() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 2);

    // Act
    ofResult.mul(DataWord.of((byte) 'A'));

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000082", ofResult.toHexString());
    assertEquals("82", ofResult.toPrefixString());
    assertArrayEquals(new byte[]{-126}, ofResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -126},
        ofResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -126},
        ofResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -126},
        ofResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -126},
        ofResult.getData());
  }

  /**
   * Test {@link DataWord#exp(DataWord)}.
   * <p>
   * Method under test: {@link DataWord#exp(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.exp(DataWord)"})
  public void testExp() {
    // Arrange
    DataWord word = DataWord.ZERO;

    // Act
    DataWord.ZERO.exp(word);

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", word.toHexString());
    assertEquals("01", word.toPrefixString());
    assertFalse(word.isZero());
    byte[] data = word.getData();
    assertSame(data, word.getNoEndZeroesData());
    assertArrayEquals(new byte[]{1}, word.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, word.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        word.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        word.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data);
  }

  /**
   * Test {@link DataWord#exp(DataWord)}.
   * <p>
   * Method under test: {@link DataWord#exp(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.exp(DataWord)"})
  public void testExp2() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) -1);

    // Act
    ofResult.exp(DataWord.ZERO);

    // Assert that nothing has changed
    assertEquals("00000000000000000000000000000000000000000000000000000000000000ff", ofResult.toHexString());
    assertEquals("ff", ofResult.toPrefixString());
    assertFalse(ofResult.isZero());
    byte[] data = ofResult.getData();
    assertSame(data, ofResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-1}, ofResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
        ofResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
        ofResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
        ofResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
        data);
  }

  /**
   * Test {@link DataWord#exp(DataWord)}.
   * <p>
   * Method under test: {@link DataWord#exp(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.exp(DataWord)"})
  public void testExp3() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) -1);
    ofResult.add(DataWord.ZERO);

    // Act
    ofResult.exp(DataWord.ZERO);

    // Assert that nothing has changed
    assertEquals("0000000000000000000000000000000000000000000000000000000000000100", ofResult.toHexString());
    assertEquals("0100", ofResult.toPrefixString());
    assertFalse(ofResult.isZero());
    assertArrayEquals(new byte[]{1, 0}, ofResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        ofResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        ofResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        ofResult.getNoEndZeroesData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        ofResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        ofResult.getData());
  }

  /**
   * Test {@link DataWord#mulmod(DataWord, DataWord)}.
   * <p>
   * Method under test: {@link DataWord#mulmod(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.mulmod(DataWord, DataWord)"})
  public void testMulmod() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 'A');
    DataWord word1 = DataWord.of((byte) 'A');

    // Act
    ofResult.mulmod(word1, DataWord.of((byte) 'A'));

    // Assert that nothing has changed
    assertEquals("0000000000000000000000000000000000000000000000000000000000000041", word1.toHexString());
    assertEquals("41", word1.toPrefixString());
    assertFalse(word1.isZero());
    byte[] data = word1.getData();
    assertSame(data, word1.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'A'}, word1.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'}, word1.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        word1.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        word1.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        data);
  }

  /**
   * Test {@link DataWord#mulmod(DataWord, DataWord)}.
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.</li>
   *   <li>When {@link DataWord#ZERO}.</li>
   *   <li>Then {@link DataWord#ZERO} toPrefixString is {@code 00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#mulmod(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.mulmod(DataWord, DataWord)"})
  public void testMulmod_givenZero_whenZero_thenZeroToPrefixStringIs00() {
    // Arrange
    DataWord word1 = DataWord.ZERO;

    // Act
    DataWord.ZERO.mulmod(word1, DataWord.ZERO);

    // Assert that nothing has changed
    assertEquals("00", word1.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", word1.toHexString());
    assertTrue(word1.isZero());
    byte[] noEndZeroesData = word1.getNoEndZeroesData();
    assertSame(noEndZeroesData, word1.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, word1.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        word1.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        word1.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        word1.getData());
  }

  /**
   * Test {@link DataWord#mulmod(DataWord, DataWord)}.
   * <ul>
   *   <li>When {@link DataWord} with num is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#mulmod(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.mulmod(DataWord, DataWord)"})
  public void testMulmod_whenDataWordWithNumIsMinusOne() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 'A');
    DataWord word1 = DataWord.of((byte) 'A');

    // Act
    ofResult.mulmod(word1, DataWord.of((byte) -1));

    // Assert that nothing has changed
    assertEquals("0000000000000000000000000000000000000000000000000000000000000041", word1.toHexString());
    assertEquals("41", word1.toPrefixString());
    assertFalse(word1.isZero());
    byte[] data = word1.getData();
    assertSame(data, word1.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'A'}, word1.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'}, word1.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        word1.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        word1.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        data);
  }

  /**
   * Test {@link DataWord#mulmod(DataWord, DataWord)}.
   * <ul>
   *   <li>When {@link DataWord#ZERO}.</li>
   *   <li>Then {@link DataWord} with num is {@code A} toPrefixString is {@code 00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#mulmod(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.mulmod(DataWord, DataWord)"})
  public void testMulmod_whenZero_thenDataWordWithNumIsAToPrefixStringIs00() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 'A');
    DataWord word1 = DataWord.ZERO;

    // Act
    ofResult.mulmod(word1, DataWord.ZERO);

    // Assert
    assertEquals("00", ofResult.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", ofResult.toHexString());
    assertTrue(ofResult.isZero());
    assertEquals(ofResult, word1);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ofResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ofResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ofResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ofResult.getData());
  }

  /**
   * Test {@link DataWord#toPrefixString()}.
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#toPrefixString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.toPrefixString()"})
  public void testToPrefixString_givenZero() {
    // Arrange, Act and Assert
    assertEquals("00", DataWord.ZERO.toPrefixString());
  }

  /**
   * Test {@link DataWord#toPrefixString()}.
   * <ul>
   *   <li>Given ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#toPrefixString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.toPrefixString()"})
  public void testToPrefixString_givenZero2() {
    // Arrange, Act and Assert
    assertEquals("00", DataWord.ZERO().toPrefixString());
  }

  /**
   * Test {@link DataWord#toPrefixString()}.
   * <ul>
   *   <li>Given {@link DataWord#ZERO} mul {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#toPrefixString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.toPrefixString()"})
  public void testToPrefixString_givenZeroMulZero() {
    // Arrange
    DataWord dataWord = DataWord.ZERO;
    dataWord.mul(DataWord.ZERO);

    // Act and Assert
    assertEquals("00", dataWord.toPrefixString());
  }

  /**
   * Test {@link DataWord#clone()}.
   * <p>
   * Method under test: {@link DataWord#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.clone()"})
  public void testClone() {
    // Arrange and Act
    DataWord actualCloneResult = DataWord.ZERO.clone();

    // Assert
    assertEquals(actualCloneResult.ZERO, actualCloneResult);
  }

  /**
   * Test {@link DataWord#equals(Object)}, and {@link DataWord#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataWord#equals(Object)}
   *   <li>{@link DataWord#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equals(Object)", "int DataWord.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataWord dataWord = DataWord.ZERO;
    DataWord dataWord2 = DataWord.ZERO;

    // Act and Assert
    assertEquals(dataWord, dataWord2);
    int expectedHashCodeResult = dataWord.hashCode();
    assertEquals(expectedHashCodeResult, dataWord2.hashCode());
  }

  /**
   * Test {@link DataWord#equals(Object)}, and {@link DataWord#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataWord#equals(Object)}
   *   <li>{@link DataWord#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equals(Object)", "int DataWord.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DataWord ZEROResult = DataWord.ZERO();
    DataWord dataWord = DataWord.ZERO;

    // Act and Assert
    assertEquals(ZEROResult, dataWord);
    int expectedHashCodeResult = ZEROResult.hashCode();
    assertEquals(expectedHashCodeResult, dataWord.hashCode());
  }

  /**
   * Test {@link DataWord#equals(Object)}, and {@link DataWord#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataWord#equals(Object)}
   *   <li>{@link DataWord#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equals(Object)", "int DataWord.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataWord dataWord = DataWord.ZERO;

    // Act and Assert
    assertEquals(dataWord, dataWord);
    int expectedHashCodeResult = dataWord.hashCode();
    assertEquals(expectedHashCodeResult, dataWord.hashCode());
  }

  /**
   * Test {@link DataWord#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equals(Object)", "int DataWord.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataWord.of((byte) 'A'), DataWord.ZERO);
  }

  /**
   * Test {@link DataWord#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equals(Object)", "int DataWord.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataWord.ZERO, null);
  }

  /**
   * Test {@link DataWord#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equals(Object)", "int DataWord.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataWord.ZERO, "Different type to DataWord");
  }

  /**
   * Test {@link DataWord#compareTo(DataWord)} with {@code DataWord}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#compareTo(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DataWord.compareTo(DataWord)"})
  public void testCompareToWithDataWord_whenNull_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, DataWord.ZERO.compareTo(null));
  }

  /**
   * Test {@link DataWord#compareTo(DataWord)} with {@code DataWord}.
   * <ul>
   *   <li>When {@link DataWord#ZERO} mul {@link DataWord#ZERO}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#compareTo(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DataWord.compareTo(DataWord)"})
  public void testCompareToWithDataWord_whenZeroMulZero_thenReturnZero() {
    // Arrange
    DataWord o = DataWord.ZERO;
    o.mul(DataWord.ZERO);

    // Act and Assert
    assertEquals(0, DataWord.ZERO.compareTo(o));
  }

  /**
   * Test {@link DataWord#compareTo(DataWord)} with {@code DataWord}.
   * <ul>
   *   <li>When {@link DataWord#ZERO}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#compareTo(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DataWord.compareTo(DataWord)"})
  public void testCompareToWithDataWord_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, DataWord.ZERO.compareTo(DataWord.ZERO));
  }

  /**
   * Test {@link DataWord#signExtend(byte)}.
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.</li>
   *   <li>When zero.</li>
   *   <li>Then {@link DataWord#ZERO} toPrefixString is {@code 00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#signExtend(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.signExtend(byte)"})
  public void testSignExtend_givenZero_whenZero_thenZeroToPrefixStringIs00() {
    // Arrange
    DataWord dataWord = DataWord.ZERO;

    // Act
    dataWord.signExtend((byte) 0);

    // Assert that nothing has changed
    assertEquals("00", dataWord.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", dataWord.toHexString());
    assertFalse(dataWord.isNegative());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataWord.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataWord.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataWord.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataWord.getData());
  }

  /**
   * Test {@link DataWord#signExtend(byte)}.
   * <ul>
   *   <li>Then {@link DataWord} with num is minus one toPrefixString is {@code ffffff}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#signExtend(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.signExtend(byte)"})
  public void testSignExtend_thenDataWordWithNumIsMinusOneToPrefixStringIsFfffff() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) -1);

    // Act
    ofResult.signExtend((byte) 0);

    // Assert
    assertEquals("ffffff", ofResult.toPrefixString());
    assertEquals("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff", ofResult.toHexString());
    assertTrue(ofResult.isNegative());
    byte[] data = ofResult.getData();
    assertSame(data, ofResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        ofResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        ofResult.toTronAddress());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, ofResult.getClonedData());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, data);
  }

  /**
   * Test {@link DataWord#bytesOccupied()}.
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#bytesOccupied()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DataWord.bytesOccupied()"})
  public void testBytesOccupied_givenZero() {
    // Arrange, Act and Assert
    assertEquals(0, DataWord.ZERO.bytesOccupied());
  }

  /**
   * Test {@link DataWord#bytesOccupied()}.
   * <ul>
   *   <li>Given ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#bytesOccupied()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DataWord.bytesOccupied()"})
  public void testBytesOccupied_givenZero2() {
    // Arrange, Act and Assert
    assertEquals(0, DataWord.ZERO().bytesOccupied());
  }

  /**
   * Test {@link DataWord#isHex(String)}.
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#isHex(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.isHex(String)"})
  public void testIsHex_when0123456789abcdef_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DataWord.ZERO.isHex("0123456789ABCDEF"));
  }

  /**
   * Test {@link DataWord#asString()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A} exp {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#asString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.asString()"})
  public void testAsString_givenDataWordWithNumIsAExpDataWordWithNumIsA_thenReturnAString() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 'A');
    ofResult.exp(DataWord.of((byte) 'A'));

    // Act and Assert
    assertEquals("*I�\u001b�\u000e��b�$a�\r��.$x��)\u0002Rg6ʣ[\u0002\u0010A", ofResult.asString());
  }

  /**
   * Test {@link DataWord#asString()}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#asString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.asString()"})
  public void testAsString_givenDataWordWithNumIsA_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals("A", DataWord.of((byte) 'A').asString());
  }

  /**
   * Test {@link DataWord#shiftLeft(DataWord)}.
   * <p>
   * Method under test: {@link DataWord#shiftLeft(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.shiftLeft(DataWord)"})
  public void testShiftLeft() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 'A');

    // Act
    DataWord actualShiftLeftResult = ofResult.shiftLeft(DataWord.of((byte) 'A'));

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000820000000000000000",
        actualShiftLeftResult.toHexString());
    assertEquals("820000", actualShiftLeftResult.toPrefixString());
    assertArrayEquals(new byte[]{-126, 0, 0, 0, 0, 0, 0, 0, 0}, actualShiftLeftResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -126, 0, 0, 0, 0, 0, 0, 0, 0},
        actualShiftLeftResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -126, 0, 0, 0, 0, 0, 0, 0, 0},
        actualShiftLeftResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -126},
        actualShiftLeftResult.getNoEndZeroesData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -126, 0, 0, 0, 0, 0, 0, 0, 0},
        actualShiftLeftResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -126, 0, 0, 0, 0, 0, 0, 0, 0},
        actualShiftLeftResult.getData());
  }

  /**
   * Test {@link DataWord#shiftLeft(DataWord)}.
   * <p>
   * Method under test: {@link DataWord#shiftLeft(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.shiftLeft(DataWord)"})
  public void testShiftLeft2() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) 1);

    // Act
    DataWord actualShiftLeftResult = ofResult.shiftLeft(DataWord.of((byte) 'A'));

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000020000000000000000",
        actualShiftLeftResult.toHexString());
    assertEquals("020000", actualShiftLeftResult.toPrefixString());
    assertArrayEquals(new byte[]{2, 0, 0, 0, 0, 0, 0, 0, 0}, actualShiftLeftResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
        actualShiftLeftResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
        actualShiftLeftResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
        actualShiftLeftResult.getNoEndZeroesData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
        actualShiftLeftResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
        actualShiftLeftResult.getData());
  }

  /**
   * Test {@link DataWord#shiftLeft(DataWord)}.
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.</li>
   *   <li>When {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shiftLeft(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.shiftLeft(DataWord)"})
  public void testShiftLeft_givenZero_whenDataWordWithNumIsA_thenReturnZero() {
    // Arrange and Act
    DataWord actualShiftLeftResult = DataWord.ZERO.shiftLeft(DataWord.of((byte) 'A'));

    // Assert
    assertEquals(actualShiftLeftResult.ZERO, actualShiftLeftResult);
  }

  /**
   * Test {@link DataWord#shiftLeft(DataWord)}.
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.</li>
   *   <li>When {@link DataWord#ZERO}.</li>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shiftLeft(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.shiftLeft(DataWord)"})
  public void testShiftLeft_givenZero_whenZero_thenReturnZero() {
    // Arrange and Act
    DataWord actualShiftLeftResult = DataWord.ZERO.shiftLeft(DataWord.ZERO);

    // Assert
    assertEquals(actualShiftLeftResult.ZERO, actualShiftLeftResult);
  }

  /**
   * Test {@link DataWord#shiftRight(DataWord)}.
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.</li>
   *   <li>When {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shiftRight(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.shiftRight(DataWord)"})
  public void testShiftRight_givenZero_whenDataWordWithNumIsA_thenReturnZero() {
    // Arrange and Act
    DataWord actualShiftRightResult = DataWord.ZERO.shiftRight(DataWord.of((byte) 'A'));

    // Assert
    assertEquals(actualShiftRightResult.ZERO, actualShiftRightResult);
  }

  /**
   * Test {@link DataWord#shiftRight(DataWord)}.
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.</li>
   *   <li>When {@link DataWord#ZERO}.</li>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shiftRight(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.shiftRight(DataWord)"})
  public void testShiftRight_givenZero_whenZero_thenReturnZero() {
    // Arrange and Act
    DataWord actualShiftRightResult = DataWord.ZERO.shiftRight(DataWord.ZERO);

    // Assert
    assertEquals(actualShiftRightResult.ZERO, actualShiftRightResult);
  }

  /**
   * Test {@link DataWord#shiftRight(DataWord)}.
   * <ul>
   *   <li>Then return {@link DataWord} with num is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shiftRight(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.shiftRight(DataWord)"})
  public void testShiftRight_thenReturnDataWordWithNumIsMinusOne() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) -1);

    // Act and Assert
    assertEquals(ofResult, ofResult.shiftRight(DataWord.ZERO));
  }

  /**
   * Test {@link DataWord#shiftRightSigned(DataWord)}.
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.</li>
   *   <li>When {@link DataWord#ZERO}.</li>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shiftRightSigned(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.shiftRightSigned(DataWord)"})
  public void testShiftRightSigned_givenZero_whenZero_thenReturnZero() {
    // Arrange and Act
    DataWord actualShiftRightSignedResult = DataWord.ZERO.shiftRightSigned(DataWord.ZERO);

    // Assert
    assertEquals(actualShiftRightSignedResult.ZERO, actualShiftRightSignedResult);
  }

  /**
   * Test {@link DataWord#shiftRightSigned(DataWord)}.
   * <ul>
   *   <li>Then return {@link DataWord} with num is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shiftRightSigned(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.shiftRightSigned(DataWord)"})
  public void testShiftRightSigned_thenReturnDataWordWithNumIsMinusOne() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) -1);

    // Act and Assert
    assertEquals(ofResult, ofResult.shiftRightSigned(DataWord.ZERO));
  }
}
