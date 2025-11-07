package org.tron.core.db2.common;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class ValueDiffblueTest {
  /**
   * Method under test: {@link Value#decode(byte[])}
   */
  @Test
  public void testDecode() throws UnsupportedEncodingException {
    // Arrange and Act
    Value actualDecodeResult = Value.decode("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualDecodeResult.getOperator());
    byte[] expectedBytes = "XAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualDecodeResult.getBytes());
  }

  /**
   * Method under test: {@link Value#decode(byte[])}
   */
  @Test
  public void testDecode2() {
    // Arrange and Act
    Value actualDecodeResult = Value.decode(new byte[]{0});

    // Assert
    assertNull(actualDecodeResult.getBytes());
    assertEquals(Value.Operator.CREATE, actualDecodeResult.getOperator());
  }

  /**
   * Method under test: {@link Value#decode(byte[])}
   */
  @Test
  public void testDecode3() {
    // Arrange and Act
    Value actualDecodeResult = Value.decode(new byte[]{1});

    // Assert
    assertNull(actualDecodeResult.getBytes());
    assertEquals(Value.Operator.MODIFY, actualDecodeResult.getOperator());
  }

  /**
   * Method under test: {@link Value#decode(byte[])}
   */
  @Test
  public void testDecode4() {
    // Arrange and Act
    Value actualDecodeResult = Value.decode(new byte[]{2});

    // Assert
    assertNull(actualDecodeResult.getBytes());
    assertEquals(Value.Operator.DELETE, actualDecodeResult.getOperator());
  }

  /**
   * Method under test: {@link Value#decode(byte[])}
   */
  @Test
  public void testDecode5() {
    // Arrange and Act
    Value actualDecodeResult = Value.decode(new byte[]{3});

    // Assert
    assertNull(actualDecodeResult.getBytes());
    assertEquals(Value.Operator.PUT, actualDecodeResult.getOperator());
  }

  /**
   * Method under test: {@link Value#copyOf(Value.Operator, byte[])}
   */
  @Test
  public void testCopyOf() throws UnsupportedEncodingException {
    // Arrange and Act
    Value actualCopyOfResult = Value.copyOf(Value.Operator.CREATE, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(Value.Operator.CREATE, actualCopyOfResult.getOperator());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualCopyOfResult.getBytes());
  }

  /**
   * Method under test: {@link Value#copyOf(Value.Operator, byte[])}
   */
  @Test
  public void testCopyOf2() {
    // Arrange and Act
    Value actualCopyOfResult = Value.copyOf(Value.Operator.CREATE, null);

    // Assert
    assertNull(actualCopyOfResult.getBytes());
    assertEquals(Value.Operator.CREATE, actualCopyOfResult.getOperator());
  }

  /**
   * Method under test: {@link Value#of(Value.Operator, byte[])}
   */
  @Test
  public void testOf() throws UnsupportedEncodingException {
    // Arrange and Act
    Value actualOfResult = Value.of(Value.Operator.CREATE, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(Value.Operator.CREATE, actualOfResult.getOperator());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualOfResult.getBytes());
  }

  /**
   * Method under test: {@link Value#encode()}
   */
  @Test
  public void testEncode() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        Value.copyOf(Value.Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")).encode());
    assertArrayEquals(new byte[]{0}, Value.copyOf(Value.Operator.CREATE, null).encode());
  }

  /**
   * Method under test: {@link Value#getBytes()}
   */
  @Test
  public void testGetBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualBytes = Value.copyOf(Value.Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")).getBytes();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBytes);
  }

  /**
   * Method under test: {@link Value#getBytes()}
   */
  @Test
  public void testGetBytes2() {
    // Arrange, Act and Assert
    assertNull(Value.copyOf(Value.Operator.CREATE, null).getBytes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Value#equals(Object)}
   *   <li>{@link Value#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    Value copyOfResult = Value.copyOf(Value.Operator.CREATE, "AXAXAXAX".getBytes("UTF-8"));
    Value copyOfResult2 = Value.copyOf(Value.Operator.CREATE, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(copyOfResult, copyOfResult2);
    int expectedHashCodeResult = copyOfResult.hashCode();
    assertEquals(expectedHashCodeResult, copyOfResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Value#equals(Object)}
   *   <li>{@link Value#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    Value copyOfResult = Value.copyOf(Value.Operator.CREATE, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(copyOfResult, copyOfResult);
    int expectedHashCodeResult = copyOfResult.hashCode();
    assertEquals(expectedHashCodeResult, copyOfResult.hashCode());
  }

  /**
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    Value copyOfResult = Value.copyOf(Value.Operator.CREATE, new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNotEquals(copyOfResult, Value.copyOf(Value.Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(Value.copyOf(Value.Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(Value.copyOf(Value.Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")), "Different type to Value");
  }

  /**
   * Method under test: {@link Value#getOperator()}
   */
  @Test
  public void testGetOperator() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(Value.Operator.CREATE,
        Value.copyOf(Value.Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")).getOperator());
  }

  /**
   * Method under test: {@link Value.Operator#getValue()}
   */
  @Test
  public void testOperatorGetValue() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, Value.Operator.valueOf("CREATE").getValue());
  }

  /**
   * Method under test: {@link Value.Operator#valueOf(byte)}
   */
  @Test
  public void testOperatorValueOf() {
    // Arrange, Act and Assert
    assertNull(Value.Operator.valueOf((byte) 'A'));
    assertEquals(Value.Operator.CREATE, Value.Operator.valueOf((byte) 0));
    assertEquals(Value.Operator.MODIFY, Value.Operator.valueOf((byte) 1));
    assertEquals(Value.Operator.DELETE, Value.Operator.valueOf((byte) 2));
    assertEquals(Value.Operator.PUT, Value.Operator.valueOf((byte) 3));
  }
}
