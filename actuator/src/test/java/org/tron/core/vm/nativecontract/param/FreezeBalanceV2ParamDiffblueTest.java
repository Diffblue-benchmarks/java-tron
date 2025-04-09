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

public class FreezeBalanceV2ParamDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FreezeBalanceV2Param}
   *   <li>{@link FreezeBalanceV2Param#setFrozenBalance(long)}
   *   <li>{@link FreezeBalanceV2Param#setOwnerAddress(byte[])}
   *   <li>{@link FreezeBalanceV2Param#setResourceType(ResourceCode)}
   *   <li>{@link FreezeBalanceV2Param#getFrozenBalance()}
   *   <li>{@link FreezeBalanceV2Param#getOwnerAddress()}
   *   <li>{@link FreezeBalanceV2Param#getResourceType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Param.<init>()", "long FreezeBalanceV2Param.getFrozenBalance()",
      "byte[] FreezeBalanceV2Param.getOwnerAddress()", "ResourceCode FreezeBalanceV2Param.getResourceType()",
      "void FreezeBalanceV2Param.setFrozenBalance(long)", "void FreezeBalanceV2Param.setOwnerAddress(byte[])",
      "void FreezeBalanceV2Param.setResourceType(ResourceCode)"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    FreezeBalanceV2Param actualFreezeBalanceV2Param = new FreezeBalanceV2Param();
    actualFreezeBalanceV2Param.setFrozenBalance(42L);
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualFreezeBalanceV2Param.setOwnerAddress(ownerAddress);
    actualFreezeBalanceV2Param.setResourceType(ResourceCode.BANDWIDTH);
    long actualFrozenBalance = actualFreezeBalanceV2Param.getFrozenBalance();
    byte[] actualOwnerAddress = actualFreezeBalanceV2Param.getOwnerAddress();

    // Assert
    assertEquals(42L, actualFrozenBalance);
    assertEquals(ResourceCode.BANDWIDTH, actualFreezeBalanceV2Param.getResourceType());
    assertSame(ownerAddress, actualOwnerAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOwnerAddress);
  }
}
