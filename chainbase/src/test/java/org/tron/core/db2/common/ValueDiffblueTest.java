package org.tron.core.db2.common;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.db2.common.Value.Operator;

public class ValueDiffblueTest {
  /**
   * Test {@link Value#decode(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one.
   *   <li>Then return Operator is {@code MODIFY}.
   * </ul>
   *
   * <p>Method under test: {@link Value#decode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Value.decode(byte[])"})
  public void testDecode_whenArrayOfByteWithOne_thenReturnOperatorIsModify() {
    // Arrange and Act
    Value actualDecodeResult = Value.decode(new byte[] {1});

    // Assert
    assertNull(actualDecodeResult.getBytes());
    assertEquals(Operator.MODIFY, actualDecodeResult.getOperator());
  }

  /**
   * Test {@link Value#decode(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with three.
   *   <li>Then return Operator is {@code PUT}.
   * </ul>
   *
   * <p>Method under test: {@link Value#decode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Value.decode(byte[])"})
  public void testDecode_whenArrayOfByteWithThree_thenReturnOperatorIsPut() {
    // Arrange and Act
    Value actualDecodeResult = Value.decode(new byte[] {3});

    // Assert
    assertNull(actualDecodeResult.getBytes());
    assertEquals(Operator.PUT, actualDecodeResult.getOperator());
  }

  /**
   * Test {@link Value#decode(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with two.
   *   <li>Then return Operator is {@code DELETE}.
   * </ul>
   *
   * <p>Method under test: {@link Value#decode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Value.decode(byte[])"})
  public void testDecode_whenArrayOfByteWithTwo_thenReturnOperatorIsDelete() {
    // Arrange and Act
    Value actualDecodeResult = Value.decode(new byte[] {2});

    // Assert
    assertNull(actualDecodeResult.getBytes());
    assertEquals(Operator.DELETE, actualDecodeResult.getOperator());
  }

  /**
   * Test {@link Value#decode(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero.
   *   <li>Then return Operator is {@code CREATE}.
   * </ul>
   *
   * <p>Method under test: {@link Value#decode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Value.decode(byte[])"})
  public void testDecode_whenArrayOfByteWithZero_thenReturnOperatorIsCreate() {
    // Arrange and Act
    Value actualDecodeResult = Value.decode(new byte[] {0});

    // Assert
    assertNull(actualDecodeResult.getBytes());
    assertEquals(Operator.CREATE, actualDecodeResult.getOperator());
  }

  /**
   * Test {@link Value#decode(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Operator is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Value#decode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Value.decode(byte[])"})
  public void testDecode_whenAxaxaxaxBytesIsUtf8_thenReturnOperatorIsNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Value actualDecodeResult = Value.decode("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualDecodeResult.getOperator());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualDecodeResult.getBytes());
  }

  /**
   * Test {@link Value#copyOf(Operator, byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Bytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Value#copyOf(Operator, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Value.copyOf(Operator, byte[])"})
  public void testCopyOf_whenAxaxaxaxBytesIsUtf8_thenReturnBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Value actualCopyOfResult = Value.copyOf(Operator.CREATE, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(Operator.CREATE, actualCopyOfResult.getOperator());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCopyOfResult.getBytes());
  }

  /**
   * Test {@link Value#copyOf(Operator, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Bytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Value#copyOf(Operator, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Value.copyOf(Operator, byte[])"})
  public void testCopyOf_whenNull_thenReturnBytesIsNull() {
    // Arrange and Act
    Value actualCopyOfResult = Value.copyOf(Operator.CREATE, null);

    // Assert
    assertNull(actualCopyOfResult.getBytes());
    assertEquals(Operator.CREATE, actualCopyOfResult.getOperator());
  }

  /**
   * Test {@link Value#of(Operator, byte[])}.
   *
   * <p>Method under test: {@link Value#of(Operator, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Value.of(Operator, byte[])"})
  public void testOf() throws UnsupportedEncodingException {
    // Arrange and Act
    Value actualOfResult = Value.of(Operator.CREATE, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(Operator.CREATE, actualOfResult.getOperator());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOfResult.getBytes());
  }

  /**
   * Test {@link Value#encode()}.
   *
   * <ul>
   *   <li>Given copyOf {@code CREATE} and {@code null}.
   *   <li>Then return array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link Value#encode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Value.encode()"})
  public void testEncode_givenCopyOfCreateAndNull_thenReturnArrayOfByteWithZero() {
    // Arrange
    Value copyOfResult = Value.copyOf(Operator.CREATE, null);

    // Act and Assert
    assertArrayEquals(new byte[] {0}, copyOfResult.encode());
  }

  /**
   * Test {@link Value#encode()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Value#encode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Value.encode()"})
  public void testEncode_thenReturnArrayOfByteWithZeroAndA() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        Value.copyOf(Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")).encode());
  }

  /**
   * Test {@link Value#getBytes()}.
   *
   * <ul>
   *   <li>Given copyOf {@code CREATE} and {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Value#getBytes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Value.getBytes()"})
  public void testGetBytes_givenCopyOfCreateAndNull_thenReturnNull() {
    // Arrange
    Value copyOfResult = Value.copyOf(Operator.CREATE, null);

    // Act and Assert
    assertNull(copyOfResult.getBytes());
  }

  /**
   * Test {@link Value#getBytes()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Value#getBytes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Value.getBytes()"})
  public void testGetBytes_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        Value.copyOf(Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")).getBytes());
  }

  /**
   * Test {@link Value#equals(Object)}, and {@link Value#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Value#equals(Object)}
   *   <li>{@link Value#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    Value copyOfResult = Value.copyOf(Operator.CREATE, "AXAXAXAX".getBytes("UTF-8"));
    Value copyOfResult2 = Value.copyOf(Operator.CREATE, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(copyOfResult, copyOfResult2);
    assertEquals(copyOfResult.hashCode(), copyOfResult2.hashCode());
  }

  /**
   * Test {@link Value#equals(Object)}, and {@link Value#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Value#equals(Object)}
   *   <li>{@link Value#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    Value copyOfResult = Value.copyOf(Operator.CREATE, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(copyOfResult, copyOfResult);
    int expectedHashCodeResult = copyOfResult.hashCode();
    assertEquals(expectedHashCodeResult, copyOfResult.hashCode());
  }

  /**
   * Test {@link Value#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Value#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange
    Value ofResult = Value.of(Operator.CREATE, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(ofResult, Value.copyOf(Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Value#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Value#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(Value.copyOf(Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Test {@link Value#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Value#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(
        Value.copyOf(Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")), "Different type to Value");
  }

  /**
   * Test {@link Value#getOperator()}.
   *
   * <p>Method under test: {@link Value#getOperator()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operator Value.getOperator()"})
  public void testGetOperator() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        Operator.CREATE, Value.copyOf(Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")).getOperator());
  }

  /**
   * Test Operator {@link Operator#getValue()}.
   *
   * <p>Method under test: {@link Operator#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Operator.getValue()"})
  public void testOperatorGetValue() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, Operator.valueOf("CREATE").getValue());
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Operator.valueOf((byte) 'A'));
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code MODIFY}.
   * </ul>
   *
   * <p>Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenOne_thenReturnModify() {
    // Arrange, Act and Assert
    assertEquals(Operator.MODIFY, Operator.valueOf((byte) 1));
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code PUT}.
   * </ul>
   *
   * <p>Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenThree_thenReturnPut() {
    // Arrange, Act and Assert
    assertEquals(Operator.PUT, Operator.valueOf((byte) 3));
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code DELETE}.
   * </ul>
   *
   * <p>Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenTwo_thenReturnDelete() {
    // Arrange, Act and Assert
    assertEquals(Operator.DELETE, Operator.valueOf((byte) 2));
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code CREATE}.
   * </ul>
   *
   * <p>Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenZero_thenReturnCreate() {
    // Arrange, Act and Assert
    assertEquals(Operator.CREATE, Operator.valueOf((byte) 0));
  }
}
