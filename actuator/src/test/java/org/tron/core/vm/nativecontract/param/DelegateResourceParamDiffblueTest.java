package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class DelegateResourceParamDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DelegateResourceParam}
   *   <li>{@link DelegateResourceParam#setDelegateBalance(long)}
   *   <li>{@link DelegateResourceParam#setOwnerAddress(byte[])}
   *   <li>{@link DelegateResourceParam#setReceiverAddress(byte[])}
   *   <li>{@link DelegateResourceParam#setResourceType(ResourceCode)}
   *   <li>{@link DelegateResourceParam#getDelegateBalance()}
   *   <li>{@link DelegateResourceParam#getOwnerAddress()}
   *   <li>{@link DelegateResourceParam#getReceiverAddress()}
   *   <li>{@link DelegateResourceParam#getResourceType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DelegateResourceParam.<init>()",
    "long DelegateResourceParam.getDelegateBalance()",
    "byte[] DelegateResourceParam.getOwnerAddress()",
    "byte[] DelegateResourceParam.getReceiverAddress()",
    "ResourceCode DelegateResourceParam.getResourceType()",
    "void DelegateResourceParam.setDelegateBalance(long)",
    "void DelegateResourceParam.setOwnerAddress(byte[])",
    "void DelegateResourceParam.setReceiverAddress(byte[])",
    "void DelegateResourceParam.setResourceType(ResourceCode)"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    DelegateResourceParam actualDelegateResourceParam = new DelegateResourceParam();
    actualDelegateResourceParam.setDelegateBalance(42L);
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualDelegateResourceParam.setOwnerAddress(ownerAddress);
    byte[] receiverAddress = "AXAXAXAX".getBytes("UTF-8");
    actualDelegateResourceParam.setReceiverAddress(receiverAddress);
    actualDelegateResourceParam.setResourceType(ResourceCode.BANDWIDTH);
    long actualDelegateBalance = actualDelegateResourceParam.getDelegateBalance();
    byte[] actualOwnerAddress = actualDelegateResourceParam.getOwnerAddress();
    byte[] actualReceiverAddress = actualDelegateResourceParam.getReceiverAddress();

    // Assert
    assertEquals(42L, actualDelegateBalance);
    assertEquals(ResourceCode.BANDWIDTH, actualDelegateResourceParam.getResourceType());
    assertSame(ownerAddress, actualOwnerAddress);
    assertSame(receiverAddress, actualReceiverAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOwnerAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualReceiverAddress);
  }
}
