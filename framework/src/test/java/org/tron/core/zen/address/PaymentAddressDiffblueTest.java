package org.tron.core.zen.address;

import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.exception.ZksnarkException;

public class PaymentAddressDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentAddress#PaymentAddress(DiversifierT, byte[])}
   *   <li>{@link PaymentAddress#setD(DiversifierT)}
   *   <li>{@link PaymentAddress#setPkD(byte[])}
   *   <li>{@link PaymentAddress#getD()}
   *   <li>{@link PaymentAddress#getPkD()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    DiversifierT d = DiversifierT.random();

    // Act
    PaymentAddress actualPaymentAddress = new PaymentAddress(d, "AXAXAXAX".getBytes("UTF-8"));
    DiversifierT d2 = DiversifierT.random();
    actualPaymentAddress.setD(d2);
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");
    actualPaymentAddress.setPkD(pkD);
    DiversifierT actualD = actualPaymentAddress.getD();

    // Assert that nothing has changed
    assertSame(pkD, actualPaymentAddress.getPkD());
    assertSame(d2, actualD);
  }
}
