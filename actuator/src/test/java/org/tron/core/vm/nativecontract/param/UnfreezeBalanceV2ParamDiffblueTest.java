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

public class UnfreezeBalanceV2ParamDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UnfreezeBalanceV2Param}
   *   <li>{@link UnfreezeBalanceV2Param#setOwnerAddress(byte[])}
   *   <li>{@link UnfreezeBalanceV2Param#setResourceType(ResourceCode)}
   *   <li>{@link UnfreezeBalanceV2Param#setUnfreezeBalance(long)}
   *   <li>{@link UnfreezeBalanceV2Param#getOwnerAddress()}
   *   <li>{@link UnfreezeBalanceV2Param#getResourceType()}
   *   <li>{@link UnfreezeBalanceV2Param#getUnfreezeBalance()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnfreezeBalanceV2Param.<init>()", "byte[] UnfreezeBalanceV2Param.getOwnerAddress()",
      "ResourceCode UnfreezeBalanceV2Param.getResourceType()", "long UnfreezeBalanceV2Param.getUnfreezeBalance()",
      "void UnfreezeBalanceV2Param.setOwnerAddress(byte[])",
      "void UnfreezeBalanceV2Param.setResourceType(ResourceCode)",
      "void UnfreezeBalanceV2Param.setUnfreezeBalance(long)"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    UnfreezeBalanceV2Param actualUnfreezeBalanceV2Param = new UnfreezeBalanceV2Param();
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualUnfreezeBalanceV2Param.setOwnerAddress(ownerAddress);
    actualUnfreezeBalanceV2Param.setResourceType(ResourceCode.BANDWIDTH);
    actualUnfreezeBalanceV2Param.setUnfreezeBalance(42L);
    byte[] actualOwnerAddress = actualUnfreezeBalanceV2Param.getOwnerAddress();
    ResourceCode actualResourceType = actualUnfreezeBalanceV2Param.getResourceType();

    // Assert
    assertEquals(42L, actualUnfreezeBalanceV2Param.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualResourceType);
    assertSame(ownerAddress, actualOwnerAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOwnerAddress);
  }
}
