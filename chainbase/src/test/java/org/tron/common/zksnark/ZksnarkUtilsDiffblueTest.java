package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ZksnarkUtilsDiffblueTest {
  /**
   * Test {@link ZksnarkUtils#sort(byte[])}.
   *
   * <p>Method under test: {@link ZksnarkUtils#sort(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZksnarkUtils.sort(byte[])"})
  public void testSort() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ZksnarkUtils.sort(bytes);

    // Assert
    assertArrayEquals("XAXAXAXA".getBytes("UTF-8"), bytes);
  }
}
