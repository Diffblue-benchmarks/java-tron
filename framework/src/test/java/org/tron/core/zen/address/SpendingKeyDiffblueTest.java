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
   * <ul>
   *   <li>When {@code 0x}.</li>
   *   <li>Then return Value is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendingKey#decode(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendingKey SpendingKey.decode(String)"})
  public void testDecode_when0x_thenReturnValueIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, SpendingKey.decode("0x").getValue());
  }

  /**
   * Test {@link SpendingKey#encode()}.
   * <ul>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendingKey#encode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SpendingKey.encode()"})
  public void testEncode_thenReturn4158415841584158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", (new SpendingKey("AXAXAXAX".getBytes("UTF-8"))).encode());
  }

  /**
   * Test {@link SpendingKey#encode()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendingKey#encode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SpendingKey.encode()"})
  public void testEncode_thenReturnEmptyString() throws UnsupportedEncodingException {
    // Arrange
    SpendingKey spendingKey = new SpendingKey("AXAXAXAX".getBytes("UTF-8"));
    spendingKey.setValue(null);

    // Act and Assert
    assertEquals("", spendingKey.encode());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SpendingKey#SpendingKey(byte[])}
   *   <li>{@link SpendingKey#setValue(byte[])}
   *   <li>{@link SpendingKey#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendingKey.<init>(byte[])", "byte[] SpendingKey.getValue()",
      "void SpendingKey.setValue(byte[])"})
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
