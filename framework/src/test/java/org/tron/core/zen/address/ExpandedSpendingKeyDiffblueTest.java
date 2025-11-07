package org.tron.core.zen.address;

import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class ExpandedSpendingKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExpandedSpendingKey#ExpandedSpendingKey()}
   *   <li>{@link ExpandedSpendingKey#setAsk(byte[])}
   *   <li>{@link ExpandedSpendingKey#setNsk(byte[])}
   *   <li>{@link ExpandedSpendingKey#setOvk(byte[])}
   *   <li>{@link ExpandedSpendingKey#getAsk()}
   *   <li>{@link ExpandedSpendingKey#getNsk()}
   *   <li>{@link ExpandedSpendingKey#getOvk()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    ExpandedSpendingKey actualExpandedSpendingKey = new ExpandedSpendingKey();
    byte[] ask = "AXAXAXAX".getBytes("UTF-8");
    actualExpandedSpendingKey.setAsk(ask);
    byte[] nsk = "AXAXAXAX".getBytes("UTF-8");
    actualExpandedSpendingKey.setNsk(nsk);
    byte[] ovk = "AXAXAXAX".getBytes("UTF-8");
    actualExpandedSpendingKey.setOvk(ovk);
    byte[] actualAsk = actualExpandedSpendingKey.getAsk();
    byte[] actualNsk = actualExpandedSpendingKey.getNsk();

    // Assert that nothing has changed
    assertSame(ask, actualAsk);
    assertSame(nsk, actualNsk);
    assertSame(ovk, actualExpandedSpendingKey.getOvk());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExpandedSpendingKey#ExpandedSpendingKey(byte[], byte[], byte[])}
   *   <li>{@link ExpandedSpendingKey#setAsk(byte[])}
   *   <li>{@link ExpandedSpendingKey#setNsk(byte[])}
   *   <li>{@link ExpandedSpendingKey#setOvk(byte[])}
   *   <li>{@link ExpandedSpendingKey#getAsk()}
   *   <li>{@link ExpandedSpendingKey#getNsk()}
   *   <li>{@link ExpandedSpendingKey#getOvk()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ask = "AXAXAXAX".getBytes("UTF-8");
    byte[] nsk = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ExpandedSpendingKey actualExpandedSpendingKey = new ExpandedSpendingKey(ask, nsk, "AXAXAXAX".getBytes("UTF-8"));
    byte[] ask2 = "AXAXAXAX".getBytes("UTF-8");
    actualExpandedSpendingKey.setAsk(ask2);
    byte[] nsk2 = "AXAXAXAX".getBytes("UTF-8");
    actualExpandedSpendingKey.setNsk(nsk2);
    byte[] ovk = "AXAXAXAX".getBytes("UTF-8");
    actualExpandedSpendingKey.setOvk(ovk);
    byte[] actualAsk = actualExpandedSpendingKey.getAsk();
    byte[] actualNsk = actualExpandedSpendingKey.getNsk();

    // Assert that nothing has changed
    assertSame(ask2, actualAsk);
    assertSame(nsk2, actualNsk);
    assertSame(ovk, actualExpandedSpendingKey.getOvk());
  }
}
