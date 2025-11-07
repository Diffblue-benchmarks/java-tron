package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class WithdrawExpireUnfreezeParamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link WithdrawExpireUnfreezeParam}
   *   <li>{@link WithdrawExpireUnfreezeParam#setOwnerAddress(byte[])}
   *   <li>{@link WithdrawExpireUnfreezeParam#getOwnerAddress()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    WithdrawExpireUnfreezeParam actualWithdrawExpireUnfreezeParam = new WithdrawExpireUnfreezeParam();
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualWithdrawExpireUnfreezeParam.setOwnerAddress(ownerAddress);

    // Assert that nothing has changed
    assertSame(ownerAddress, actualWithdrawExpireUnfreezeParam.getOwnerAddress());
  }
}
