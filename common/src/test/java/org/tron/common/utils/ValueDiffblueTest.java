package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ValueDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Value#Value()}
   *   <li>{@link Value#init(byte[])}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Value.<init>()", "void Value.init(byte[])"})
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
   * Test {@link Value#Value(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not String.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#Value(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Value.<init>(Object)"})
  public void testNewValue_whenNull_thenReturnNotString() {
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
   * Test {@link Value#Value(Object)}.
   * <ul>
   *   <li>When {@code Obj}.</li>
   *   <li>Then return not Null.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#Value(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Value.<init>(Object)"})
  public void testNewValue_whenObj_thenReturnNotNull() {
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
   * Test {@link Value#Value(Object)}.
   * <ul>
   *   <li>When {@link Value#Value()}.</li>
   *   <li>Then return not String.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#Value(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Value.<init>(Object)"})
  public void testNewValue_whenValue_thenReturnNotString() {
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

  /**
   * Test {@link Value#asObj()}.
   * <p>
   * Method under test: {@link Value#asObj()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object Value.asObj()"})
  public void testAsObj() {
    // Arrange, Act and Assert
    assertNull((new Value()).asObj());
  }

  /**
   * Test {@link Value#asInt()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with obj is {@link DecodeUtil#ADDRESS_SIZE}.</li>
   *   <li>Then return {@link DecodeUtil#ADDRESS_SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#asInt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Value.asInt()"})
  public void testAsInt_givenValueWithObjIsAddress_size_thenReturnAddress_size() {
    // Arrange, Act and Assert
    assertEquals(DecodeUtil.ADDRESS_SIZE, (new Value(DecodeUtil.ADDRESS_SIZE)).asInt());
  }

  /**
   * Test {@link Value#asInt()}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#asInt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Value.asInt()"})
  public void testAsInt_givenValue_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new Value()).asInt());
  }

  /**
   * Test {@link Value#asLong()}.
   * <p>
   * Method under test: {@link Value#asLong()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Value.asLong()"})
  public void testAsLong() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Value()).asLong());
  }

  /**
   * Test {@link Value#asBigInt()}.
   * <p>
   * Method under test: {@link Value#asBigInt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.math.BigInteger Value.asBigInt()"})
  public void testAsBigInt() {
    // Arrange, Act and Assert
    assertNull((new Value()).asBigInt());
  }

  /**
   * Test {@link Value#asString()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with {@code Obj}.</li>
   *   <li>Then return {@code Obj}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#asString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Value.asString()"})
  public void testAsString_givenValueWithObj_thenReturnObj() {
    // Arrange, Act and Assert
    assertEquals("Obj", (new Value("Obj")).asString());
  }

  /**
   * Test {@link Value#asString()}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#asString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Value.asString()"})
  public void testAsString_givenValue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new Value()).asString());
  }

  /**
   * Test {@link Value#asBytes()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with {@code Obj}.</li>
   *   <li>Then return {@code Obj} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#asBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Value.asBytes()"})
  public void testAsBytes_givenValueWithObj_thenReturnObjBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualAsBytesResult = (new Value("Obj")).asBytes();

    // Assert
    assertArrayEquals("Obj".getBytes("UTF-8"), actualAsBytesResult);
  }

  /**
   * Test {@link Value#asBytes()}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#asBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Value.asBytes()"})
  public void testAsBytes_givenValue_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new Value()).asBytes());
  }

  /**
   * Test {@link Value#get(int)}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#get(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Value.get(int)"})
  public void testGet_givenValue() {
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
   * Test {@link Value#get(int)}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with {@code Obj}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#get(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Value.get(int)"})
  public void testGet_givenValueWithObj() {
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
   * Test {@link Value#cmp(Value)}.
   * <ul>
   *   <li>Given {@link Value#Value()} init array of {@code byte} with {@code A} and four.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.cmp(Value)"})
  public void testCmp_givenValueInitArrayOfByteWithAAndFour_thenReturnTrue() {
    // Arrange
    Value value = new Value();
    value.init(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    Value o = new Value();
    o.init(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act and Assert
    assertTrue(value.cmp(o));
  }

  /**
   * Test {@link Value#cmp(Value)}.
   * <ul>
   *   <li>Given {@link Value#Value()} init empty array of {@code byte}.</li>
   *   <li>When {@link Value#Value()} init array of {@code byte} with {@code A} and four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.cmp(Value)"})
  public void testCmp_givenValueInitEmptyArrayOfByte_whenValueInitArrayOfByteWithAAndFour() {
    // Arrange
    Value value = new Value();
    value.init(new byte[]{});

    Value o = new Value();
    o.init(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act and Assert
    assertFalse(value.cmp(o));
  }

  /**
   * Test {@link Value#cmp(Value)}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with obj is four.</li>
   *   <li>When {@link Value#Value(Object)} with {@code Obj}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.cmp(Value)"})
  public void testCmp_givenValueWithObjIsFour_whenValueWithObj_thenReturnFalse() {
    // Arrange
    Value value = new Value(4);

    // Act and Assert
    assertFalse(value.cmp(new Value("Obj")));
  }

  /**
   * Test {@link Value#cmp(Value)}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with {@code Obj}.</li>
   *   <li>When {@link Value#Value()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.cmp(Value)"})
  public void testCmp_givenValueWithObj_whenValue_thenReturnFalse() {
    // Arrange
    Value value = new Value("Obj");

    // Act and Assert
    assertFalse(value.cmp(new Value()));
  }

  /**
   * Test {@link Value#cmp(Value)}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.cmp(Value)"})
  public void testCmp_givenValue_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Value()).cmp(null));
  }

  /**
   * Test {@link Value#cmp(Value)}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>When {@link Value#Value()} init array of {@code byte} with {@code A} and four.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.cmp(Value)"})
  public void testCmp_givenValue_whenValueInitArrayOfByteWithAAndFour_thenReturnFalse() {
    // Arrange
    Value value = new Value();

    Value o = new Value();
    o.init(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act and Assert
    assertFalse(value.cmp(o));
  }

  /**
   * Test {@link Value#cmp(Value)}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>When {@link Value#Value()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#cmp(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.cmp(Value)"})
  public void testCmp_givenValue_whenValue_thenReturnTrue() {
    // Arrange
    Value value = new Value();

    // Act and Assert
    assertTrue(value.cmp(new Value()));
  }

  /**
   * Test {@link Value#isList()}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isList()"})
  public void testIsList_givenValue() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isList());
  }

  /**
   * Test {@link Value#isList()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with {@code Obj}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isList()"})
  public void testIsList_givenValueWithObj() {
    // Arrange, Act and Assert
    assertFalse((new Value("Obj")).isList());
  }

  /**
   * Test {@link Value#isString()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with {@code Obj}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isString()"})
  public void testIsString_givenValueWithObj_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Value("Obj")).isString());
  }

  /**
   * Test {@link Value#isString()}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isString()"})
  public void testIsString_givenValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isString());
  }

  /**
   * Test {@link Value#isInt()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with obj is {@link DecodeUtil#ADDRESS_SIZE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isInt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isInt()"})
  public void testIsInt_givenValueWithObjIsAddress_size_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Value(DecodeUtil.ADDRESS_SIZE)).isInt());
  }

  /**
   * Test {@link Value#isInt()}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isInt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isInt()"})
  public void testIsInt_givenValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isInt());
  }

  /**
   * Test {@link Value#isLong()}.
   * <p>
   * Method under test: {@link Value#isLong()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isLong()"})
  public void testIsLong() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isLong());
  }

  /**
   * Test {@link Value#isBigInt()}.
   * <p>
   * Method under test: {@link Value#isBigInt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isBigInt()"})
  public void testIsBigInt() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isBigInt());
  }

  /**
   * Test {@link Value#isBytes()}.
   * <p>
   * Method under test: {@link Value#isBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isBytes()"})
  public void testIsBytes() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isBytes());
  }

  /**
   * Test {@link Value#isHashCode()}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isHashCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isHashCode()"})
  public void testIsHashCode_givenValue() {
    // Arrange, Act and Assert
    assertFalse((new Value()).isHashCode());
  }

  /**
   * Test {@link Value#isHashCode()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with {@code Obj}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isHashCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isHashCode()"})
  public void testIsHashCode_givenValueWithObj() {
    // Arrange, Act and Assert
    assertFalse((new Value("Obj")).isHashCode());
  }

  /**
   * Test {@link Value#isNull()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with {@code Obj}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isNull()"})
  public void testIsNull_givenValueWithObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Value("Obj")).isNull());
  }

  /**
   * Test {@link Value#isNull()}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isNull()"})
  public void testIsNull_givenValue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Value()).isNull());
  }

  /**
   * Test {@link Value#isEmpty()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with obj is empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isEmpty()"})
  public void testIsEmpty_givenValueWithObjIsEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Value("")).isEmpty());
  }

  /**
   * Test {@link Value#isEmpty()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with obj is four.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isEmpty()"})
  public void testIsEmpty_givenValueWithObjIsFour_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Value(4)).isEmpty());
  }

  /**
   * Test {@link Value#isEmpty()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with {@code Obj}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isEmpty()"})
  public void testIsEmpty_givenValueWithObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Value("Obj")).isEmpty());
  }

  /**
   * Test {@link Value#isEmpty()}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isEmpty()"})
  public void testIsEmpty_givenValue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Value()).isEmpty());
  }

  /**
   * Test {@link Value#length()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with {@code Obj}.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#length()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Value.length()"})
  public void testLength_givenValueWithObj_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new Value("Obj")).length());
  }

  /**
   * Test {@link Value#length()}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#length()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Value.length()"})
  public void testLength_givenValue_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new Value()).length());
  }

  /**
   * Test {@link Value#toString()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with obj is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Value.toString()"})
  public void testToString_givenValueWithObjIsEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new Value("")).toString());
  }

  /**
   * Test {@link Value#toString()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with obj is four.</li>
   *   <li>Then return {@code Unexpected type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Value.toString()"})
  public void testToString_givenValueWithObjIsFour_thenReturnUnexpectedType() {
    // Arrange, Act and Assert
    assertEquals("Unexpected type", (new Value(4)).toString());
  }

  /**
   * Test {@link Value#toString()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with {@code Obj}.</li>
   *   <li>Then return {@code Obj}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Value.toString()"})
  public void testToString_givenValueWithObj_thenReturnObj() {
    // Arrange, Act and Assert
    assertEquals("Obj", (new Value("Obj")).toString());
  }

  /**
   * Test {@link Value#toString()}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Value.toString()"})
  public void testToString_givenValue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new Value()).toString());
  }

  /**
   * Test {@link Value#countBranchNodes()}.
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#countBranchNodes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Value.countBranchNodes()"})
  public void testCountBranchNodes_givenValue() {
    // Arrange, Act and Assert
    assertEquals(0, (new Value()).countBranchNodes());
  }

  /**
   * Test {@link Value#countBranchNodes()}.
   * <ul>
   *   <li>Given {@link Value#Value(Object)} with {@code Obj}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#countBranchNodes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Value.countBranchNodes()"})
  public void testCountBranchNodes_givenValueWithObj() {
    // Arrange, Act and Assert
    assertEquals(0, (new Value("Obj")).countBranchNodes());
  }
}
