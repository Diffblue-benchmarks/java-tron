package org.tron.core.capsule.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.junit.Test;
import org.tron.common.runtime.InternalTransaction;

public class TransactionUtilDiffblueTest {
  /**
   * Method under test:
   * {@link TransactionUtil#newGenesisTransaction(byte[], long)}
   */
  @Test
  public void testNewGenesisTransaction() throws UnsupportedEncodingException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransactionUtil.newGenesisTransaction("AXAXAXAX".getBytes("UTF-8"), 42L));
    assertThrows(IllegalArgumentException.class, () -> TransactionUtil.newGenesisTransaction(null, 42L));
    assertThrows(IllegalArgumentException.class, () -> TransactionUtil.newGenesisTransaction(new byte[]{}, 42L));
  }

  /**
   * Method under test:
   * {@link TransactionUtil#buildInternalTransaction(InternalTransaction)}
   */
  @Test
  public void testBuildInternalTransaction() throws UnsupportedEncodingException {
    // Arrange
    InternalTransaction it = mock(InternalTransaction.class);
    when(it.isRejected()).thenThrow(new IllegalArgumentException("foo"));
    when(it.getNote()).thenReturn("Note");
    when(it.getTokenInfo()).thenReturn(new HashMap<>());
    when(it.getValue()).thenReturn(42L);
    when(it.getTransferToAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(it.getSender()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(it.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransactionUtil.buildInternalTransaction(it));
    verify(it).getHash();
    verify(it).getNote();
    verify(it).getSender();
    verify(it).getTokenInfo();
    verify(it).getTransferToAddress();
    verify(it).getValue();
    verify(it).isRejected();
  }

  /**
   * Method under test: {@link TransactionUtil#isNumber(byte[])}
   */
  @Test
  public void testIsNumber() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.isNumber("AXAXAXAX".getBytes("UTF-8")));
    assertFalse(TransactionUtil.isNumber("\bXAXAXAX".getBytes("UTF-8")));
    assertFalse(TransactionUtil.isNumber("0XAXAXAX".getBytes("UTF-8")));
    assertFalse(TransactionUtil.isNumber(new byte[]{}));
  }
}
