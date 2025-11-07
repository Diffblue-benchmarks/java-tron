package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.protos.contract.Common;

public class UnfreezeBalanceV2ParamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UnfreezeBalanceV2Param}
   *   <li>{@link UnfreezeBalanceV2Param#setOwnerAddress(byte[])}
   *   <li>{@link UnfreezeBalanceV2Param#setResourceType(Common.ResourceCode)}
   *   <li>{@link UnfreezeBalanceV2Param#setUnfreezeBalance(long)}
   *   <li>{@link UnfreezeBalanceV2Param#getOwnerAddress()}
   *   <li>{@link UnfreezeBalanceV2Param#getResourceType()}
   *   <li>{@link UnfreezeBalanceV2Param#getUnfreezeBalance()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    UnfreezeBalanceV2Param actualUnfreezeBalanceV2Param = new UnfreezeBalanceV2Param();
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualUnfreezeBalanceV2Param.setOwnerAddress(ownerAddress);
    actualUnfreezeBalanceV2Param.setResourceType(Common.ResourceCode.BANDWIDTH);
    actualUnfreezeBalanceV2Param.setUnfreezeBalance(42L);
    byte[] actualOwnerAddress = actualUnfreezeBalanceV2Param.getOwnerAddress();
    Common.ResourceCode actualResourceType = actualUnfreezeBalanceV2Param.getResourceType();

    // Assert that nothing has changed
    assertEquals(42L, actualUnfreezeBalanceV2Param.getUnfreezeBalance());
    assertEquals(Common.ResourceCode.BANDWIDTH, actualResourceType);
    assertSame(ownerAddress, actualOwnerAddress);
  }
}
