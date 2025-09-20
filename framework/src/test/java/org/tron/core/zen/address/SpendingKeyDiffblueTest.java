package org.tron.core.zen.address;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SpendingKeyDiffblueTest {
  /**
   * Test {@link SpendingKey#decode(String)}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return Value is array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link SpendingKey#decode(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendingKey SpendingKey.decode(String)"})
  public void testDecode_when0_thenReturnValueIsArrayOfByteWithZero() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0}, SpendingKey.decode("0").getValue());
  }

  /**
   * Test {@link SpendingKey#decode(String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then return Value is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link SpendingKey#decode(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendingKey SpendingKey.decode(String)"})
  public void testDecode_when0x_thenReturnValueIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, SpendingKey.decode("0x").getValue());
  }

  /**
   * Test {@link SpendingKey#encode()}.
   *
   * <ul>
   *   <li>Given {@link SpendingKey#SpendingKey(byte[])} with value is {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SpendingKey#encode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SpendingKey.encode()"})
  public void testEncode_givenSpendingKeyWithValueIsNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new SpendingKey(null).encode());
  }

  /**
   * Test {@link SpendingKey#encode()}.
   *
   * <ul>
   *   <li>Then return {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link SpendingKey#encode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SpendingKey.encode()"})
  public void testEncode_thenReturn4158415841584158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", new SpendingKey("AXAXAXAX".getBytes("UTF-8")).encode());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpendingKey#SpendingKey(byte[])}
   *   <li>{@link SpendingKey#setValue(byte[])}
   *   <li>{@link SpendingKey#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SpendingKey.<init>(byte[])",
    "byte[] SpendingKey.getValue()",
    "void SpendingKey.setValue(byte[])"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    SpendingKey actualSpendingKey = new SpendingKey("AXAXAXAX".getBytes("UTF-8"));
    byte[] value = "AXAXAXAX".getBytes("UTF-8");
    actualSpendingKey.setValue(value);
    byte[] actualValue = actualSpendingKey.getValue();

    // Assert
    assertSame(value, actualValue);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualValue);
  }
}
