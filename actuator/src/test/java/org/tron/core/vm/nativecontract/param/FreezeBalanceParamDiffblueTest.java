package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class FreezeBalanceParamDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FreezeBalanceParam}
   *   <li>{@link FreezeBalanceParam#setDelegating(boolean)}
   *   <li>{@link FreezeBalanceParam#setFrozenBalance(long)}
   *   <li>{@link FreezeBalanceParam#setFrozenDuration(long)}
   *   <li>{@link FreezeBalanceParam#setOwnerAddress(byte[])}
   *   <li>{@link FreezeBalanceParam#setReceiverAddress(byte[])}
   *   <li>{@link FreezeBalanceParam#setResourceType(ResourceCode)}
   *   <li>{@link FreezeBalanceParam#getFrozenBalance()}
   *   <li>{@link FreezeBalanceParam#getFrozenDuration()}
   *   <li>{@link FreezeBalanceParam#getOwnerAddress()}
   *   <li>{@link FreezeBalanceParam#getReceiverAddress()}
   *   <li>{@link FreezeBalanceParam#getResourceType()}
   *   <li>{@link FreezeBalanceParam#isDelegating()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FreezeBalanceParam.<init>()",
    "long FreezeBalanceParam.getFrozenBalance()",
    "long FreezeBalanceParam.getFrozenDuration()",
    "byte[] FreezeBalanceParam.getOwnerAddress()",
    "byte[] FreezeBalanceParam.getReceiverAddress()",
    "ResourceCode FreezeBalanceParam.getResourceType()",
    "boolean FreezeBalanceParam.isDelegating()",
    "void FreezeBalanceParam.setDelegating(boolean)",
    "void FreezeBalanceParam.setFrozenBalance(long)",
    "void FreezeBalanceParam.setFrozenDuration(long)",
    "void FreezeBalanceParam.setOwnerAddress(byte[])",
    "void FreezeBalanceParam.setReceiverAddress(byte[])",
    "void FreezeBalanceParam.setResourceType(ResourceCode)"
  })
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
    actualFreezeBalanceParam.setResourceType(ResourceCode.BANDWIDTH);
    long actualFrozenBalance = actualFreezeBalanceParam.getFrozenBalance();
    long actualFrozenDuration = actualFreezeBalanceParam.getFrozenDuration();
    byte[] actualOwnerAddress = actualFreezeBalanceParam.getOwnerAddress();
    byte[] actualReceiverAddress = actualFreezeBalanceParam.getReceiverAddress();
    ResourceCode actualResourceType = actualFreezeBalanceParam.getResourceType();

    // Assert
    assertEquals(1L, actualFrozenDuration);
    assertEquals(42L, actualFrozenBalance);
    assertEquals(ResourceCode.BANDWIDTH, actualResourceType);
    assertTrue(actualFreezeBalanceParam.isDelegating());
    assertSame(ownerAddress, actualOwnerAddress);
    assertSame(receiverAddress, actualReceiverAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOwnerAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualReceiverAddress);
  }
}
