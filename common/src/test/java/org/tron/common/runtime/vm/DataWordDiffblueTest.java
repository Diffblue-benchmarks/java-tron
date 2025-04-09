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
   * Test {@link DataWord#DataWord()}.
   * <p>
   * Method under test: {@link DataWord#DataWord()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.<init>()"})
  public void testNewDataWord7() {
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
  public void testNewDataWord8() {
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
  public void testNewDataWord9() {
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
  public void testNewDataWord10() {
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
  public void testNewDataWord11() throws UnsupportedEncodingException {
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
  public void testNewDataWord12() throws UnsupportedEncodingException {
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
  public void testNewDataWord_whenEmptyString_thenReturnToPrefixStringIs002() {
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
  public void testNewDataWord_whenNull_thenReturnToHexStringIsEmptyString2() {
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
   * Test {@link DataWord#ONE()}.
   * <p>
   * Method under test: {@link DataWord#ONE()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.ONE()"})
  public void testOne2() {
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
   * Test {@link DataWord#ZERO()}.
   * <p>
   * Method under test: {@link DataWord#ZERO()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.ZERO()"})
  public void testZero2() {
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
   * Test {@link DataWord#of(byte)}.
   * <p>
   * Method under test: {@link DataWord#of(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.of(byte)"})
  public void testOf2() {
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
  public void testBigIntValueWithByte_whenAxaxaxaxBytesIsUtf8_thenReturn47085852577250839922()
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
   *   <li>When array of {@code byte} with zero and zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#isZero(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.isZero(byte[])"})
  public void testIsZeroWithByte_whenArrayOfByteWithZeroAndZero_thenReturnTrue2() {
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
  public void testIsZeroWithByte_whenAxaxaxaxBytesIsUtf8_thenReturnFalse2() throws UnsupportedEncodingException {
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
  public void testIsZero_givenDataWordWithNumIsA_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(DataWord.of((byte) 'A').isZero());
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
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return {@code 0x41}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsA_thenReturn0x412() {
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
   *   <li>Given {@link DataWord} with num is backspace.</li>
   *   <li>Then return {@code 0x8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsBackspace_thenReturn0x82() {
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
   *   <li>Given {@link DataWord} with num is five.</li>
   *   <li>Then return {@code 0x5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsFive_thenReturn0x52() {
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
   *   <li>Given {@link DataWord} with num is four.</li>
   *   <li>Then return {@code 0x4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsFour_thenReturn0x42() {
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
   *   <li>Given {@link DataWord} with num is lf.</li>
   *   <li>Then return {@code 0xA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsLf_thenReturn0xA2() {
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
   *   <li>Given {@link DataWord} with num is one.</li>
   *   <li>Then return {@code 0x1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsOne_thenReturn0x12() {
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
   *   <li>Given {@link DataWord} with num is seven.</li>
   *   <li>Then return {@code 0x7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsSeven_thenReturn0x72() {
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
   *   <li>Given {@link DataWord} with num is six.</li>
   *   <li>Then return {@code 0x6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsSix_thenReturn0x62() {
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
   *   <li>Given {@link DataWord} with num is tab.</li>
   *   <li>Then return {@code 0x9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsTab_thenReturn0x92() {
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
   *   <li>Given {@link DataWord} with num is three.</li>
   *   <li>Then return {@code 0x3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsThree_thenReturn0x32() {
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
   *   <li>Given {@link DataWord} with num is two.</li>
   *   <li>Then return {@code 0x2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shortHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.shortHex()"})
  public void testShortHex_givenDataWordWithNumIsTwo_thenReturn0x22() {
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
  public void testShortHex_givenZero_thenReturn0x02() {
    // Arrange, Act and Assert
    assertEquals("0x0", DataWord.ZERO.shortHex());
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
   * Test {@link DataWord#parseArray(byte[])}.
   * <p>
   * Method under test: {@link DataWord#parseArray(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord[] DataWord.parseArray(byte[])"})
  public void testParseArray2() throws UnsupportedEncodingException {
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
   * Test {@link DataWord#isNegative()}.
   * <p>
   * Method under test: {@link DataWord#isNegative()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.isNegative()"})
  public void testIsNegative2() {
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
   *   <li>When array of {@code byte} with {@code A} and twenty.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equalAddressByteArray(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equalAddressByteArray(byte[], byte[])"})
  public void testEqualAddressByteArray_whenArrayOfByteWithAAndTwenty_thenReturnFalse2()
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
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equalAddressByteArray(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equalAddressByteArray(byte[], byte[])"})
  public void testEqualAddressByteArray_whenAxaxaxaxBytesIsUtf8_thenReturnFalse2() throws UnsupportedEncodingException {
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
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equalAddressByteArray(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equalAddressByteArray(byte[], byte[])"})
  public void testEqualAddressByteArray_whenNull_thenReturnTrue2() {
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
  public void testEqualAddressByteArray_whenX_thenReturnFalse3() {
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
  public void testEqualAddressByteArray_whenX_thenReturnFalse4() {
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
  public void testGettersAndSetters2() {
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
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return array of {@code byte} with {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#getNoLeadZeroesData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DataWord.getNoLeadZeroesData()"})
  public void testGetNoLeadZeroesData_givenDataWordWithNumIsA_thenReturnArrayOfByteWithA2() {
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
  public void testGetNoLeadZeroesData_thenReturnArrayOfByteWithAsteriskAndI2() {
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
  public void testGetNoEndZeroesData_thenReturnArrayOfByteWithZeroAndZero2() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'},
        DataWord.of((byte) 'A').getNoEndZeroesData());
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
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#intValueSafe()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DataWord.intValueSafe()"})
  public void testIntValueSafe_givenDataWordWithNumIsA_thenReturnSixtyFive2() {
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
  public void testIntValueSafe_thenReturnMax_value2() {
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
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#longValueSafe()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DataWord.longValueSafe()"})
  public void testLongValueSafe_givenDataWordWithNumIsA_thenReturnSixtyFive2() {
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
  public void testLongValueSafe_thenReturnMax_value2() {
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
   * Test {@link DataWord#sValue()}.
   * <p>
   * Method under test: {@link DataWord#sValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigInteger DataWord.sValue()"})
  public void testSValue2() {
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
  public void testAnd_whenZero_thenReturnZero2() {
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
  public void testOr_whenZero_thenReturnZero2() {
    // Arrange and Act
    DataWord actualOrResult = DataWord.ZERO.or(DataWord.ZERO);

    // Assert
    assertSame(actualOrResult.ZERO, actualOrResult);
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
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   *   <li>Then {@link DataWord} with num is {@code A} toPrefixString is {@code ffffff}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.negate()"})
  public void testNegate_givenDataWordWithNumIsA_thenDataWordWithNumIsAToPrefixStringIsFfffff2() {
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
  public void testBnot_givenDataWordWithNumIsA_thenDataWordWithNumIsAToPrefixStringIsFfffff2() {
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
   * Test {@link DataWord#mul(DataWord)}.
   * <p>
   * Method under test: {@link DataWord#mul(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.mul(DataWord)"})
  public void testMul3() {
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
  public void testMul4() {
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
   * Test {@link DataWord#exp(DataWord)}.
   * <p>
   * Method under test: {@link DataWord#exp(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.exp(DataWord)"})
  public void testExp4() {
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
  public void testExp5() {
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
  public void testExp6() {
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
   * <p>
   * Method under test: {@link DataWord#mulmod(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.mulmod(DataWord, DataWord)"})
  public void testMulmod2() {
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
  public void testMulmod_givenZero_whenZero_thenZeroToPrefixStringIs002() {
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
   *   <li>When {@link DataWord} with num is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#mulmod(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataWord.mulmod(DataWord, DataWord)"})
  public void testMulmod_whenDataWordWithNumIsMinusOne2() {
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
   * Test {@link DataWord#clone()}.
   * <p>
   * Method under test: {@link DataWord#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.clone()"})
  public void testClone2() {
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
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
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
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual2() {
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
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equals(Object)", "int DataWord.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataWord.equals(Object)", "int DataWord.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual2() {
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
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual2() {
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
   *   <li>When {@code null}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#compareTo(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DataWord.compareTo(DataWord)"})
  public void testCompareToWithDataWord_whenNull_thenReturnMinusOne2() {
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
   *   <li>When {@link DataWord#ZERO} mul {@link DataWord#ZERO}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#compareTo(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DataWord.compareTo(DataWord)"})
  public void testCompareToWithDataWord_whenZeroMulZero_thenReturnZero2() {
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
  public void testCompareToWithDataWord_whenZero_thenReturnZero2() {
    // Arrange, Act and Assert
    assertEquals(0, DataWord.ZERO.compareTo(DataWord.ZERO));
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
  public void testBytesOccupied_givenZero3() {
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
  public void testBytesOccupied_givenZero4() {
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
  public void testIsHex_when0123456789abcdef_thenReturnFalse2() {
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
   *   <li>Given {@link DataWord} with num is {@code A} exp {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#asString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataWord.asString()"})
  public void testAsString_givenDataWordWithNumIsAExpDataWordWithNumIsA_thenReturnAString2() {
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
  public void testAsString_givenDataWordWithNumIsA_thenReturnA2() {
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
   * <p>
   * Method under test: {@link DataWord#shiftLeft(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.shiftLeft(DataWord)"})
  public void testShiftLeft3() {
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
  public void testShiftLeft4() {
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
   *   <li>When {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shiftLeft(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.shiftLeft(DataWord)"})
  public void testShiftLeft_givenZero_whenDataWordWithNumIsA_thenReturnZero2() {
    // Arrange and Act
    DataWord actualShiftLeftResult = DataWord.ZERO.shiftLeft(DataWord.of((byte) 'A'));

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
   *   <li>When {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWord#shiftRight(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord DataWord.shiftRight(DataWord)"})
  public void testShiftRight_givenZero_whenDataWordWithNumIsA_thenReturnZero2() {
    // Arrange and Act
    DataWord actualShiftRightResult = DataWord.ZERO.shiftRight(DataWord.of((byte) 'A'));

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
  public void testShiftRight_thenReturnDataWordWithNumIsMinusOne2() {
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
  public void testShiftRightSigned_givenZero_whenZero_thenReturnZero2() {
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
  public void testShiftRightSigned_thenReturnDataWordWithNumIsMinusOne2() {
    // Arrange
    DataWord ofResult = DataWord.of((byte) -1);

    // Act and Assert
    assertEquals(ofResult, ofResult.shiftRightSigned(DataWord.ZERO));
  }
}
