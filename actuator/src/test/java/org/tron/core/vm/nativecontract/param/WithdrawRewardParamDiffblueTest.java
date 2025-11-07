package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class WithdrawRewardParamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link WithdrawRewardParam}
   *   <li>{@link WithdrawRewardParam#setNowInMs(long)}
   *   <li>{@link WithdrawRewardParam#setOwnerAddress(byte[])}
   *   <li>{@link WithdrawRewardParam#getNowInMs()}
   *   <li>{@link WithdrawRewardParam#getOwnerAddress()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    WithdrawRewardParam actualWithdrawRewardParam = new WithdrawRewardParam();
    actualWithdrawRewardParam.setNowInMs(1L);
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualWithdrawRewardParam.setOwnerAddress(ownerAddress);
    long actualNowInMs = actualWithdrawRewardParam.getNowInMs();

    // Assert that nothing has changed
    assertEquals(1L, actualNowInMs);
    assertSame(ownerAddress, actualWithdrawRewardParam.getOwnerAddress());
  }
}
