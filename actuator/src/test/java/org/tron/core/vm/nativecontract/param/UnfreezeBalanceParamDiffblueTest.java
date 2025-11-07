package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.protos.contract.Common;

public class UnfreezeBalanceParamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UnfreezeBalanceParam}
   *   <li>{@link UnfreezeBalanceParam#setDelegating(boolean)}
   *   <li>{@link UnfreezeBalanceParam#setOwnerAddress(byte[])}
   *   <li>{@link UnfreezeBalanceParam#setReceiverAddress(byte[])}
   *   <li>{@link UnfreezeBalanceParam#setResourceType(Common.ResourceCode)}
   *   <li>{@link UnfreezeBalanceParam#getOwnerAddress()}
   *   <li>{@link UnfreezeBalanceParam#getReceiverAddress()}
   *   <li>{@link UnfreezeBalanceParam#getResourceType()}
   *   <li>{@link UnfreezeBalanceParam#isDelegating()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    UnfreezeBalanceParam actualUnfreezeBalanceParam = new UnfreezeBalanceParam();
    actualUnfreezeBalanceParam.setDelegating(true);
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualUnfreezeBalanceParam.setOwnerAddress(ownerAddress);
    byte[] receiverAddress = "AXAXAXAX".getBytes("UTF-8");
    actualUnfreezeBalanceParam.setReceiverAddress(receiverAddress);
    actualUnfreezeBalanceParam.setResourceType(Common.ResourceCode.BANDWIDTH);
    byte[] actualOwnerAddress = actualUnfreezeBalanceParam.getOwnerAddress();
    byte[] actualReceiverAddress = actualUnfreezeBalanceParam.getReceiverAddress();
    Common.ResourceCode actualResourceType = actualUnfreezeBalanceParam.getResourceType();

    // Assert that nothing has changed
    assertEquals(Common.ResourceCode.BANDWIDTH, actualResourceType);
    assertTrue(actualUnfreezeBalanceParam.isDelegating());
    assertSame(ownerAddress, actualOwnerAddress);
    assertSame(receiverAddress, actualReceiverAddress);
  }
}
