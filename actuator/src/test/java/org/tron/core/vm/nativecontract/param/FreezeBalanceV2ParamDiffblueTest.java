package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.protos.contract.Common;

public class FreezeBalanceV2ParamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FreezeBalanceV2Param}
   *   <li>{@link FreezeBalanceV2Param#setFrozenBalance(long)}
   *   <li>{@link FreezeBalanceV2Param#setOwnerAddress(byte[])}
   *   <li>{@link FreezeBalanceV2Param#setResourceType(Common.ResourceCode)}
   *   <li>{@link FreezeBalanceV2Param#getFrozenBalance()}
   *   <li>{@link FreezeBalanceV2Param#getOwnerAddress()}
   *   <li>{@link FreezeBalanceV2Param#getResourceType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    FreezeBalanceV2Param actualFreezeBalanceV2Param = new FreezeBalanceV2Param();
    actualFreezeBalanceV2Param.setFrozenBalance(42L);
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualFreezeBalanceV2Param.setOwnerAddress(ownerAddress);
    actualFreezeBalanceV2Param.setResourceType(Common.ResourceCode.BANDWIDTH);
    long actualFrozenBalance = actualFreezeBalanceV2Param.getFrozenBalance();
    byte[] actualOwnerAddress = actualFreezeBalanceV2Param.getOwnerAddress();

    // Assert that nothing has changed
    assertEquals(42L, actualFrozenBalance);
    assertEquals(Common.ResourceCode.BANDWIDTH, actualFreezeBalanceV2Param.getResourceType());
    assertSame(ownerAddress, actualOwnerAddress);
  }
}
