package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.protos.contract.Common;

public class FreezeBalanceParamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FreezeBalanceParam}
   *   <li>{@link FreezeBalanceParam#setDelegating(boolean)}
   *   <li>{@link FreezeBalanceParam#setFrozenBalance(long)}
   *   <li>{@link FreezeBalanceParam#setFrozenDuration(long)}
   *   <li>{@link FreezeBalanceParam#setOwnerAddress(byte[])}
   *   <li>{@link FreezeBalanceParam#setReceiverAddress(byte[])}
   *   <li>{@link FreezeBalanceParam#setResourceType(Common.ResourceCode)}
   *   <li>{@link FreezeBalanceParam#getFrozenBalance()}
   *   <li>{@link FreezeBalanceParam#getFrozenDuration()}
   *   <li>{@link FreezeBalanceParam#getOwnerAddress()}
   *   <li>{@link FreezeBalanceParam#getReceiverAddress()}
   *   <li>{@link FreezeBalanceParam#getResourceType()}
   *   <li>{@link FreezeBalanceParam#isDelegating()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    FreezeBalanceParam actualFreezeBalanceParam = new FreezeBalanceParam();
    actualFreezeBalanceParam.setDelegating(true);
    actualFreezeBalanceParam.setFrozenBalance(42L);
    actualFreezeBalanceParam.setFrozenDuration(1L);
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualFreezeBalanceParam.setOwnerAddress(ownerAddress);
    byte[] receiverAddress = "AXAXAXAX".getBytes("UTF-8");
    actualFreezeBalanceParam.setReceiverAddress(receiverAddress);
    actualFreezeBalanceParam.setResourceType(Common.ResourceCode.BANDWIDTH);
    long actualFrozenBalance = actualFreezeBalanceParam.getFrozenBalance();
    long actualFrozenDuration = actualFreezeBalanceParam.getFrozenDuration();
    byte[] actualOwnerAddress = actualFreezeBalanceParam.getOwnerAddress();
    byte[] actualReceiverAddress = actualFreezeBalanceParam.getReceiverAddress();
    Common.ResourceCode actualResourceType = actualFreezeBalanceParam.getResourceType();

    // Assert that nothing has changed
    assertEquals(1L, actualFrozenDuration);
    assertEquals(42L, actualFrozenBalance);
    assertEquals(Common.ResourceCode.BANDWIDTH, actualResourceType);
    assertTrue(actualFreezeBalanceParam.isDelegating());
    assertSame(ownerAddress, actualOwnerAddress);
    assertSame(receiverAddress, actualReceiverAddress);
  }
}
