package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WithdrawExpireUnfreezeParamDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link WithdrawExpireUnfreezeParam}
   *   <li>{@link WithdrawExpireUnfreezeParam#setOwnerAddress(byte[])}
   *   <li>{@link WithdrawExpireUnfreezeParam#getOwnerAddress()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WithdrawExpireUnfreezeParam.<init>()",
    "byte[] WithdrawExpireUnfreezeParam.getOwnerAddress()",
    "void WithdrawExpireUnfreezeParam.setOwnerAddress(byte[])"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    WithdrawExpireUnfreezeParam actualWithdrawExpireUnfreezeParam =
        new WithdrawExpireUnfreezeParam();
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualWithdrawExpireUnfreezeParam.setOwnerAddress(ownerAddress);
    byte[] actualOwnerAddress = actualWithdrawExpireUnfreezeParam.getOwnerAddress();

    // Assert
    assertSame(ownerAddress, actualOwnerAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOwnerAddress);
  }
}
