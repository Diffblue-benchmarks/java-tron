package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class UnfreezeBalanceParamDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UnfreezeBalanceParam}
   *   <li>{@link UnfreezeBalanceParam#setDelegating(boolean)}
   *   <li>{@link UnfreezeBalanceParam#setOwnerAddress(byte[])}
   *   <li>{@link UnfreezeBalanceParam#setReceiverAddress(byte[])}
   *   <li>{@link UnfreezeBalanceParam#setResourceType(ResourceCode)}
   *   <li>{@link UnfreezeBalanceParam#getOwnerAddress()}
   *   <li>{@link UnfreezeBalanceParam#getReceiverAddress()}
   *   <li>{@link UnfreezeBalanceParam#getResourceType()}
   *   <li>{@link UnfreezeBalanceParam#isDelegating()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnfreezeBalanceParam.<init>()",
    "byte[] UnfreezeBalanceParam.getOwnerAddress()",
    "byte[] UnfreezeBalanceParam.getReceiverAddress()",
    "ResourceCode UnfreezeBalanceParam.getResourceType()",
    "boolean UnfreezeBalanceParam.isDelegating()",
    "void UnfreezeBalanceParam.setDelegating(boolean)",
    "void UnfreezeBalanceParam.setOwnerAddress(byte[])",
    "void UnfreezeBalanceParam.setReceiverAddress(byte[])",
    "void UnfreezeBalanceParam.setResourceType(ResourceCode)"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    UnfreezeBalanceParam actualUnfreezeBalanceParam = new UnfreezeBalanceParam();
    actualUnfreezeBalanceParam.setDelegating(true);
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualUnfreezeBalanceParam.setOwnerAddress(ownerAddress);
    byte[] receiverAddress = "AXAXAXAX".getBytes("UTF-8");
    actualUnfreezeBalanceParam.setReceiverAddress(receiverAddress);
    actualUnfreezeBalanceParam.setResourceType(ResourceCode.BANDWIDTH);
    byte[] actualOwnerAddress = actualUnfreezeBalanceParam.getOwnerAddress();
    byte[] actualReceiverAddress = actualUnfreezeBalanceParam.getReceiverAddress();
    ResourceCode actualResourceType = actualUnfreezeBalanceParam.getResourceType();

    // Assert
    assertEquals(ResourceCode.BANDWIDTH, actualResourceType);
    assertTrue(actualUnfreezeBalanceParam.isDelegating());
    assertSame(ownerAddress, actualOwnerAddress);
    assertSame(receiverAddress, actualReceiverAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOwnerAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualReceiverAddress);
  }
}
