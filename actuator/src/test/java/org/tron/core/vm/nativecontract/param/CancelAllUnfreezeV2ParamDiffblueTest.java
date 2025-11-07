package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class CancelAllUnfreezeV2ParamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CancelAllUnfreezeV2Param}
   *   <li>{@link CancelAllUnfreezeV2Param#setOwnerAddress(byte[])}
   *   <li>{@link CancelAllUnfreezeV2Param#getOwnerAddress()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    CancelAllUnfreezeV2Param actualCancelAllUnfreezeV2Param = new CancelAllUnfreezeV2Param();
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualCancelAllUnfreezeV2Param.setOwnerAddress(ownerAddress);

    // Assert that nothing has changed
    assertSame(ownerAddress, actualCancelAllUnfreezeV2Param.getOwnerAddress());
  }
}
