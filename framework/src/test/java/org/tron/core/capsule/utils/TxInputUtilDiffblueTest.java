package org.tron.core.capsule.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.TXInput;

public class TxInputUtilDiffblueTest {
  /**
   * Test {@link TxInputUtil#newTxInput(byte[], long, byte[], byte[])}.
   *
   * <p>Method under test: {@link TxInputUtil#newTxInput(byte[], long, byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TXInput TxInputUtil.newTxInput(byte[], long, byte[], byte[])"})
  public void testNewTxInput() throws UnsupportedEncodingException {
    // Arrange and Act
    TXInput actualNewTxInputResult =
        TxInputUtil.newTxInput(
            "AXAXAXAX".getBytes("UTF-8"),
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("", actualNewTxInputResult.getInitializationErrorString());
    assertEquals(2, actualNewTxInputResult.getAllFields().size());
    assertEquals(34, actualNewTxInputResult.getSerializedSize());
    assertTrue(actualNewTxInputResult.findInitializationErrors().isEmpty());
    assertTrue(actualNewTxInputResult.hasRawData());
    assertTrue(actualNewTxInputResult.isInitialized());
  }
}
