package org.tron.core;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.api.GrpcAPI;
import org.tron.api.GrpcAPI.Return;
import org.tron.common.crypto.ECKey;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;

public class WalletDiffblueTest {
  /**
   * Test {@link Wallet#broadcastTransaction(Transaction)}.
   * <p>
   * Method under test: {@link Wallet#broadcastTransaction(Transaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Return Wallet.broadcastTransaction(Transaction)"})
  public void testBroadcastTransaction() {
    // Arrange
    Wallet wallet = new Wallet();

    // Act
    Return actualBroadcastTransactionResult = wallet.broadcastTransaction(Transaction.getDefaultInstance());

    // Assert
    UnknownFieldSet unknownFields = actualBroadcastTransactionResult.getUnknownFields();
    Return defaultInstanceForType = actualBroadcastTransactionResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link Wallet#broadcastTransaction(Transaction)}.
   * <ul>
   *   <li>Given {@link Wallet#Wallet(SignInterface)} with cryptoEngine is {@link ECKey#ECKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Wallet#broadcastTransaction(Transaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Return Wallet.broadcastTransaction(Transaction)"})
  public void testBroadcastTransaction_givenWalletWithCryptoEngineIsECKey() {
    // Arrange
    Wallet wallet = new Wallet(new ECKey());

    // Act
    Return actualBroadcastTransactionResult = wallet.broadcastTransaction(Transaction.getDefaultInstance());

    // Assert
    UnknownFieldSet unknownFields = actualBroadcastTransactionResult.getUnknownFields();
    Return defaultInstanceForType = actualBroadcastTransactionResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }
}
