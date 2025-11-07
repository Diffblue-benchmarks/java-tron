package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.protos.contract.Common;

public class DelegateResourceParamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DelegateResourceParam}
   *   <li>{@link DelegateResourceParam#setDelegateBalance(long)}
   *   <li>{@link DelegateResourceParam#setOwnerAddress(byte[])}
   *   <li>{@link DelegateResourceParam#setReceiverAddress(byte[])}
   *   <li>{@link DelegateResourceParam#setResourceType(Common.ResourceCode)}
   *   <li>{@link DelegateResourceParam#getDelegateBalance()}
   *   <li>{@link DelegateResourceParam#getOwnerAddress()}
   *   <li>{@link DelegateResourceParam#getReceiverAddress()}
   *   <li>{@link DelegateResourceParam#getResourceType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    DelegateResourceParam actualDelegateResourceParam = new DelegateResourceParam();
    actualDelegateResourceParam.setDelegateBalance(42L);
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualDelegateResourceParam.setOwnerAddress(ownerAddress);
    byte[] receiverAddress = "AXAXAXAX".getBytes("UTF-8");
    actualDelegateResourceParam.setReceiverAddress(receiverAddress);
    actualDelegateResourceParam.setResourceType(Common.ResourceCode.BANDWIDTH);
    long actualDelegateBalance = actualDelegateResourceParam.getDelegateBalance();
    byte[] actualOwnerAddress = actualDelegateResourceParam.getOwnerAddress();
    byte[] actualReceiverAddress = actualDelegateResourceParam.getReceiverAddress();

    // Assert that nothing has changed
    assertEquals(42L, actualDelegateBalance);
    assertEquals(Common.ResourceCode.BANDWIDTH, actualDelegateResourceParam.getResourceType());
    assertSame(ownerAddress, actualOwnerAddress);
    assertSame(receiverAddress, actualReceiverAddress);
  }
}
