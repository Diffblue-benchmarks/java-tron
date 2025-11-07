package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.protos.contract.Common;

public class UnDelegateResourceParamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UnDelegateResourceParam}
   *   <li>{@link UnDelegateResourceParam#setOwnerAddress(byte[])}
   *   <li>{@link UnDelegateResourceParam#setReceiverAddress(byte[])}
   *   <li>{@link UnDelegateResourceParam#setResourceType(Common.ResourceCode)}
   *   <li>{@link UnDelegateResourceParam#setUnDelegateBalance(long)}
   *   <li>{@link UnDelegateResourceParam#getOwnerAddress()}
   *   <li>{@link UnDelegateResourceParam#getReceiverAddress()}
   *   <li>{@link UnDelegateResourceParam#getResourceType()}
   *   <li>{@link UnDelegateResourceParam#getUnDelegateBalance()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    UnDelegateResourceParam actualUnDelegateResourceParam = new UnDelegateResourceParam();
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualUnDelegateResourceParam.setOwnerAddress(ownerAddress);
    byte[] receiverAddress = "AXAXAXAX".getBytes("UTF-8");
    actualUnDelegateResourceParam.setReceiverAddress(receiverAddress);
    actualUnDelegateResourceParam.setResourceType(Common.ResourceCode.BANDWIDTH);
    actualUnDelegateResourceParam.setUnDelegateBalance(42L);
    byte[] actualOwnerAddress = actualUnDelegateResourceParam.getOwnerAddress();
    byte[] actualReceiverAddress = actualUnDelegateResourceParam.getReceiverAddress();
    Common.ResourceCode actualResourceType = actualUnDelegateResourceParam.getResourceType();

    // Assert that nothing has changed
    assertEquals(42L, actualUnDelegateResourceParam.getUnDelegateBalance());
    assertEquals(Common.ResourceCode.BANDWIDTH, actualResourceType);
    assertSame(ownerAddress, actualOwnerAddress);
    assertSame(receiverAddress, actualReceiverAddress);
  }
}
