package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WithdrawRewardParamDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link WithdrawRewardParam}
   *   <li>{@link WithdrawRewardParam#setNowInMs(long)}
   *   <li>{@link WithdrawRewardParam#setOwnerAddress(byte[])}
   *   <li>{@link WithdrawRewardParam#getNowInMs()}
   *   <li>{@link WithdrawRewardParam#getOwnerAddress()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void WithdrawRewardParam.<init>()",
    "long WithdrawRewardParam.getNowInMs()",
    "byte[] WithdrawRewardParam.getOwnerAddress()",
    "void WithdrawRewardParam.setNowInMs(long)",
    "void WithdrawRewardParam.setOwnerAddress(byte[])"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    WithdrawRewardParam actualWithdrawRewardParam = new WithdrawRewardParam();
    actualWithdrawRewardParam.setNowInMs(1L);
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    actualWithdrawRewardParam.setOwnerAddress(ownerAddress);
    long actualNowInMs = actualWithdrawRewardParam.getNowInMs();
    byte[] actualOwnerAddress = actualWithdrawRewardParam.getOwnerAddress();

    // Assert
    assertEquals(1L, actualNowInMs);
    assertSame(ownerAddress, actualOwnerAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOwnerAddress);
  }
}
