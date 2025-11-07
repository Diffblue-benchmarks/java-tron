package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class ValueDiffblueTest {
  /**
   * Method under test: {@link Value#asObj()}
   */
  @Test
  public void testAsObj() {
    // Arrange, Act and Assert
    assertNull((new Value()).asObj());
  }

  /**
   * Method under test: {@link Value#asInt()}
   */
  @Test
  public void testAsInt() {
    // Arrange, Act and Assert
    assertEquals(0, (new Value()).asInt());
    assertEquals(DecodeUtil.ADDRESS_SIZE, (new Value(DecodeUtil.ADDRESS_SIZE)).asInt());
  }

  /**
   * Method under test: {@link Value#asLong()}
   */
  @Test
  public void testAsLong() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Value()).asLong());
  }

  /**
   * Method under test: {@link Value#asBigInt()}
   */
  @Test
  public void testAsBigInt() {
    // Arrange, Act and Assert
    assertNull((new Value()).asBigInt());
  }

  /**
   * Method under test: {@link Value#asString()}
   */
  @Test
  public void testAsString() {
    // Arrange, Act and Assert
    assertEquals("", (new Value()).asString());
    assertEquals("Obj", (new Value("Obj")).asString());
  }

  /**
   * Method under test: {@link Value#asBytes()}
   */
  @Test
  public void testAsBytes() {
    // Arrange, Act and Assert
    assertEquals(0, (new Value()).asBytes().length);
  }

  /**
   * Method under test: {@link Value#asBytes()}
   */
  @Test
  public void testAsBytes2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualAsBytesResult = (new Value("Obj")).asBytes();

    // Assert
    assertArrayEquals("Obj".getBytes("UTF-8"), actualAsBytesResult);
  }

  /**
   * Method under test: {@link Value#get(int)}
   */
  @Test
  public void testGet() {
    // Arrange and Act
    Value actualGetResult = (new Value()).get(1);

    // Assert
    assertFalse(actualGetResult.isBigInt());
    assertFalse(actualGetResult.isBytes());
    assertFalse(actualGetResult.isInt());
    assertFalse(actualGetResult.isList());
    assertFalse(actualGetResult.isLong());
    assertFalse(actualGetResult.isString());
    assertTrue(actualGetResult.isNull());
  }

  /**
   * Method under test: {@link Value#get(int)}
   */
  @Test
  public void testGet2() {
    // Arrange and Act
    Value actualGetResult = (new Value("Obj")).get(1);

    // Assert
    assertFalse(actualGetResult.isBigInt());
    assertFalse(actualGetResult.isBytes());
    assertFalse(actualGetResult.isInt());
    assertFalse(actualGetResult.isList());
    assertFalse(actualGetResult.isLong());
    assertFalse(actualGetResult.isString());
    assertTrue(actualGetResult.isNull());
  }

  /**
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  public void testCmp() {
    // Arrange
    Value value = new Value();

    // Act and Assert
    assertTrue(value.cmp(new Value()));
  }

  /**
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  public void testCmp2() {
    // Arrange
    Value value = new Value("Obj");

    // Act and Assert
    assertFalse(value.cmp(new Value()));
  }

  /**
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  public void testCmp3() {
    // Arrange, Act and Assert
    assertFalse((new Value()).cmp(null));
  }

  /**
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  public void testCmp4() {
    // Arrange
    Value value = new Value();

    Value o = new Value();
    o.init(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act and Assert
    assertFalse(value.cmp(o));
  }

  /**
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  public void testCmp5() {
    // Arrange
    Value value = new Value();
    value.init(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    Value o = new Value();
    o.init(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act and Assert
    assertTrue(value.cmp(o));
  }

  /**
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  public void testCmp6() {
    // Arrange
    Value value = new Value();
    value.init(new byte[]{});

    Value o = new Value();
    o.init(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act and Assert
    assertFalse(value.cmp(o));
  }

  /**
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  public void testCmp7() {
    // Arrange
    Value value = new Value(4);

    // Act and Assert
    assertFalse(value.cmp(new Value("Obj")));
  }

  /**
   * Method under test: {@link Value#isList()}
   */
  @Test
  public void testIsList() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isList());
    assertFalse((new Value("Obj")).isList());
  }

  /**
   * Method under test: {@link Value#isString()}
   */
  @Test
  public void testIsString() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isString());
    assertTrue((new Value("Obj")).isString());
  }

  /**
   * Method under test: {@link Value#isInt()}
   */
  @Test
  public void testIsInt() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isInt());
    assertTrue((new Value(DecodeUtil.ADDRESS_SIZE)).isInt());
  }

  /**
   * Method under test: {@link Value#isLong()}
   */
  @Test
  public void testIsLong() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isLong());
  }

  /**
   * Method under test: {@link Value#isBigInt()}
   */
  @Test
  public void testIsBigInt() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isBigInt());
  }

  /**
   * Method under test: {@link Value#isBytes()}
   */
  @Test
  public void testIsBytes() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isBytes());
  }

  /**
   * Method under test: {@link Value#isHashCode()}
   */
  @Test
  public void testIsHashCode() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isHashCode());
    assertFalse((new Value("Obj")).isHashCode());
  }

  /**
   * Method under test: {@link Value#isNull()}
   */
  @Test
  public void testIsNull() {
    // Arrange, Act and Assert
    assertTrue((new Value()).isNull());
    assertFalse((new Value("Obj")).isNull());
  }

  /**
   * Method under test: {@link Value#isEmpty()}
   */
  @Test
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new Value()).isEmpty());
    assertFalse((new Value("Obj")).isEmpty());
    assertFalse((new Value(4)).isEmpty());
    assertTrue((new Value("")).isEmpty());
  }

  /**
   * Method under test: {@link Value#length()}
   */
  @Test
  public void testLength() {
    // Arrange, Act and Assert
    assertEquals(0, (new Value()).length());
    assertEquals(3, (new Value("Obj")).length());
  }

  /**
   * Method under test: {@link Value#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("", (new Value()).toString());
    assertEquals("Obj", (new Value("Obj")).toString());
    assertEquals("Unexpected type", (new Value(4)).toString());
    assertEquals("", (new Value("")).toString());
  }

  /**
   * Method under test: {@link Value#countBranchNodes()}
   */
  @Test
  public void testCountBranchNodes() {
    // Arrange, Act and Assert
    assertEquals(0, (new Value()).countBranchNodes());
    assertEquals(0, (new Value("Obj")).countBranchNodes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Value#Value()}
   *   <li>{@link Value#init(byte[])}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    Value actualValue = new Value();
    actualValue.init("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualValue.isBigInt());
    assertFalse(actualValue.isBytes());
    assertFalse(actualValue.isInt());
    assertFalse(actualValue.isList());
    assertFalse(actualValue.isLong());
    assertFalse(actualValue.isString());
    assertTrue(actualValue.isNull());
  }

  /**
   * Method under test: {@link Value#Value(Object)}
   */
  @Test
  public void testNewValue() {
    // Arrange and Act
    Value actualValue = new Value("Obj");

    // Assert
    assertFalse(actualValue.isBigInt());
    assertFalse(actualValue.isBytes());
    assertFalse(actualValue.isInt());
    assertFalse(actualValue.isList());
    assertFalse(actualValue.isLong());
    assertFalse(actualValue.isNull());
    assertTrue(actualValue.isString());
  }

  /**
   * Method under test: {@link Value#Value(Object)}
   */
  @Test
  public void testNewValue2() {
    // Arrange and Act
    Value actualValue = new Value(null);

    // Assert
    assertFalse(actualValue.isBigInt());
    assertFalse(actualValue.isBytes());
    assertFalse(actualValue.isInt());
    assertFalse(actualValue.isList());
    assertFalse(actualValue.isLong());
    assertFalse(actualValue.isString());
    assertTrue(actualValue.isNull());
  }

  /**
   * Method under test: {@link Value#Value(Object)}
   */
  @Test
  public void testNewValue3() {
    // Arrange and Act
    Value actualValue = new Value(new Value());

    // Assert
    assertFalse(actualValue.isBigInt());
    assertFalse(actualValue.isBytes());
    assertFalse(actualValue.isInt());
    assertFalse(actualValue.isList());
    assertFalse(actualValue.isLong());
    assertFalse(actualValue.isString());
    assertTrue(actualValue.isNull());
  }
}
