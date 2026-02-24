package org.tron.core.capsule.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RLPItemDiffblueTest {
  /**
   * Test {@link RLPItem#RLPItem(byte[])}.
   *
   * <p>Method under test: {@link RLPItem#RLPItem(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLPItem.<init>(byte[])"})
  public void testNewRLPItem() throws UnsupportedEncodingException {
    // Arrange
    byte[] rlpData = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    byte[] rLPData = new RLPItem(rlpData).getRLPData();
    assertSame(rlpData, rLPData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), rLPData);
  }

  /**
   * Test {@link RLPItem#getRLPData()}.
   *
   * <ul>
   *   <li>Given {@link RLPItem#RLPItem(byte[])} with rlpData is empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RLPItem#getRLPData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLPItem.getRLPData()"})
  public void testGetRLPData_givenRLPItemWithRlpDataIsEmptyArrayOfByte_thenReturnNull() {
    // Arrange
    RLPItem rlpItem = new RLPItem(new byte[] {});

    // Act and Assert
    assertNull(rlpItem.getRLPData());
  }

  /**
   * Test {@link RLPItem#getRLPData()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RLPItem#getRLPData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLPItem.getRLPData()"})
  public void testGetRLPData_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), new RLPItem("AXAXAXAX".getBytes("UTF-8")).getRLPData());
  }
}
