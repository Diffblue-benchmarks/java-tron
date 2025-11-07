package org.tron.core.zen.address;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ZksnarkException;

public class PaymentAddressDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentAddress.<init>(DiversifierT, byte[])", "DiversifierT PaymentAddress.getD()",
      "byte[] PaymentAddress.getPkD()", "void PaymentAddress.setD(DiversifierT)", "void PaymentAddress.setPkD(byte[])"})
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
    byte[] actualPkD = actualPaymentAddress.getPkD();

    // Assert
    assertSame(pkD, actualPkD);
    assertSame(d2, actualD);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPkD);
  }
}
