package org.tron.core.zen.address;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class SpendingKeyDiffblueTest {
  /**
   * Method under test: {@link SpendingKey#decode(String)}
   */
  @Test
  public void testDecode() {
    // Arrange, Act and Assert
    assertEquals(0, SpendingKey.decode("0x").getValue().length);
  }

  /**
   * Method under test: {@link SpendingKey#encode()}
   */
  @Test
  public void testEncode() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", (new SpendingKey("AXAXAXAX".getBytes("UTF-8"))).encode());
  }

  /**
   * Method under test: {@link SpendingKey#encode()}
   */
  @Test
  public void testEncode2() throws UnsupportedEncodingException {
    // Arrange
    SpendingKey spendingKey = new SpendingKey("AXAXAXAX".getBytes("UTF-8"));
    spendingKey.setValue(null);

    // Act and Assert
    assertEquals("", spendingKey.encode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SpendingKey#SpendingKey(byte[])}
   *   <li>{@link SpendingKey#setValue(byte[])}
   *   <li>{@link SpendingKey#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    SpendingKey actualSpendingKey = new SpendingKey("AXAXAXAX".getBytes("UTF-8"));
    byte[] value = "AXAXAXAX".getBytes("UTF-8");
    actualSpendingKey.setValue(value);

    // Assert that nothing has changed
    assertSame(value, actualSpendingKey.getValue());
  }
}
