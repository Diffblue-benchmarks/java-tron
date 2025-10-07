package org.tron.core.db;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.ProgramResult;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.TransactionCapsule;
import org.tron.core.store.StoreFactory;

public class TransactionContextDiffblueTest {
  /**
   * Test {@link TransactionContext#TransactionContext(BlockCapsule, TransactionCapsule,
   * StoreFactory, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ProgramResult Exception is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionContext#TransactionContext(BlockCapsule,
   * TransactionCapsule, StoreFactory, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TransactionContext.<init>(BlockCapsule, TransactionCapsule, StoreFactory, boolean, boolean)"
  })
  public void testNewTransactionContext_whenNull_thenReturnProgramResultExceptionIsNull() {
    // Arrange and Act
    TransactionContext actualTransactionContext =
        new TransactionContext(null, null, StoreFactory.getInstance(), true, true);

    // Assert
    ProgramResult programResult = actualTransactionContext.getProgramResult();
    assertNull(programResult.getException());
    assertNull(programResult.getRuntimeError());
    assertNull(actualTransactionContext.getBlockCap());
    assertNull(actualTransactionContext.getTrxCap());
    assertNull(actualTransactionContext.getStoreFactory());
    assertNull(programResult.getResultCode());
    assertEquals(0L, programResult.getEnergyPenaltyTotal());
    assertEquals(0L, programResult.getEnergyUsed());
    assertFalse(programResult.isRevert());
    assertTrue(programResult.getCallCreateList().isEmpty());
    assertTrue(programResult.getInternalTransactions().isEmpty());
    assertTrue(programResult.getLogInfoList().isEmpty());
    assertTrue(programResult.getTriggerList().isEmpty());
    assertTrue(programResult.getDeleteAccounts().isEmpty());
    assertTrue(actualTransactionContext.isEventPluginLoaded());
    assertTrue(actualTransactionContext.isStatic());
    assertArrayEquals(new byte[] {}, programResult.getContractAddress());
    assertArrayEquals(new byte[] {}, programResult.getHReturn());
  }
}
