package org.tron.core.capsule.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.TXInput;

public class TxInputUtilDiffblueTest {
  /**
   * Test {@link TxInputUtil#newTxInput(byte[], long, byte[], byte[])}.
   * <p>
   * Method under test: {@link TxInputUtil#newTxInput(byte[], long, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TXInput TxInputUtil.newTxInput(byte[], long, byte[], byte[])"})
  public void testNewTxInput() throws UnsupportedEncodingException {
    // Arrange
    byte[] txId = "AXAXAXAX".getBytes("UTF-8");
    byte[] signature = "AXAXAXAX".getBytes("UTF-8");

    // Act
    TXInput actualNewTxInputResult = TxInputUtil.newTxInput(txId, 1L, signature, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("", actualNewTxInputResult.getInitializationErrorString());
    assertEquals(2, actualNewTxInputResult.getAllFields().size());
    assertEquals(34, actualNewTxInputResult.getSerializedSize());
    assertTrue(actualNewTxInputResult.findInitializationErrors().isEmpty());
    assertTrue(actualNewTxInputResult.hasRawData());
    assertTrue(actualNewTxInputResult.isInitialized());
  }
}
