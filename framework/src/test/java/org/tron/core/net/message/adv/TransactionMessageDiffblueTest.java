package org.tron.core.net.message.adv;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.UnpooledHeapByteBuf;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.net.message.MessageTypes;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;

public class TransactionMessageDiffblueTest {
  /**
   * Test {@link TransactionMessage#TransactionMessage(Transaction)}.
   *
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionMessage#TransactionMessage(Transaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionMessage.<init>(Transaction)"})
  public void testNewTransactionMessage_thenSendDataReturnUnpooledHeapByteBuf() {
    // Arrange and Act
    TransactionMessage actualTransactionMessage =
        new TransactionMessage(Transaction.getDefaultInstance());

    // Assert
    assertTrue(actualTransactionMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualTransactionMessage.getAnswerMessage());
    assertEquals(MessageTypes.TRX, actualTransactionMessage.getType());
    assertArrayEquals(new byte[] {}, actualTransactionMessage.getData());
    assertArrayEquals(new byte[] {1}, actualTransactionMessage.getSendBytes());
  }
}
