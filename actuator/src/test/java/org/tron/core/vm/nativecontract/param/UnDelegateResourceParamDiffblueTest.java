package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class UnDelegateResourceParamDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UnDelegateResourceParam}
   *   <li>{@link UnDelegateResourceParam#setOwnerAddress(byte[])}
   *   <li>{@link UnDelegateResourceParam#setReceiverAddress(byte[])}
   *   <li>{@link UnDelegateResourceParam#setResourceType(ResourceCode)}
   *   <li>{@link UnDelegateResourceParam#setUnDelegateBalance(long)}
   *   <li>{@link UnDelegateResourceParam#getOwnerAddress()}
   *   <li>{@link UnDelegateResourceParam#getReceiverAddress()}
   *   <li>{@link UnDelegateResourceParam#getResourceType()}
   *   <li>{@link UnDelegateResourceParam#getUnDelegateBalance()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnDelegateResourceParam.<init>()",
    "byte[] UnDelegateResourceParam.getOwnerAddress()",
    "byte[] UnDelegateResourceParam.getReceiverAddress()",
    "ResourceCode UnDelegateResourceParam.getResourceType()",
    "long UnDelegateResourceParam.getUnDelegateBalance()",
    "void UnDelegateResourceParam.setOwnerAddress(byte[])",
    "void UnDelegateResourceParam.setReceiverAddress(byte[])",
    "void UnDelegateResourceParam.setResourceType(ResourceCode)",
    "void UnDelegateResourceParam.setUnDelegateBalance(long)"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    UnDelegateResourceParam actualUnDelegateResourceParam = new UnDelegateResourceParam();
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualUnDelegateResourceParam.setOwnerAddress(ownerAddress);
    byte[] receiverAddress = "AXAXAXAX".getBytes("UTF-8");
    actualUnDelegateResourceParam.setReceiverAddress(receiverAddress);
    actualUnDelegateResourceParam.setResourceType(ResourceCode.BANDWIDTH);
    actualUnDelegateResourceParam.setUnDelegateBalance(42L);
    byte[] actualOwnerAddress = actualUnDelegateResourceParam.getOwnerAddress();
    byte[] actualReceiverAddress = actualUnDelegateResourceParam.getReceiverAddress();
    ResourceCode actualResourceType = actualUnDelegateResourceParam.getResourceType();

    // Assert
    assertEquals(42L, actualUnDelegateResourceParam.getUnDelegateBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualResourceType);
    assertSame(ownerAddress, actualOwnerAddress);
    assertSame(receiverAddress, actualReceiverAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOwnerAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualReceiverAddress);
  }
}
