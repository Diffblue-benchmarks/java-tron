package org.tron.core.actuator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.InternalTransaction.TrxType;
import org.tron.core.ChainBaseManager;
import org.tron.core.db.TransactionContext;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.program.Program.TransferException;

public class VMActuatorDiffblueTest {
  /**
   * Test {@link VMActuator#VMActuator(boolean)}.
   *
   * <p>Method under test: {@link VMActuator#VMActuator(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.<init>(boolean)"})
  public void testNewVMActuator() {
    // Arrange and Act
    VMActuator actualVmActuator = new VMActuator(true);

    // Assert
    assertNull(actualVmActuator.getTrxType());
    assertTrue(actualVmActuator.isConstantCall());
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate() throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenThrow(new RuntimeException());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate2() throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate3() throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate4() throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getDynamicPropertiesStore()}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenChainBaseManagerGetDynamicPropertiesStoreReturnNull()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link
   *       DynamicPropertiesStore#getAllowDynamicEnergy()} return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowDynamicEnergyReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link
   *       DynamicPropertiesStore#getAllowEnergyAdjustment()} return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowEnergyAdjustmentReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#getAllowMultiSign()}
   *       return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowMultiSignReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#getAllowStrictMath()}
   *       return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowStrictMathReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link
   *       DynamicPropertiesStore#getAllowTvmCompatibleEvm()} return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowTvmCompatibleEvmReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link
   *       DynamicPropertiesStore#getAllowTvmConstantinople()} return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowTvmConstantinopleReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#getAllowTvmFreeze()}
   *       return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowTvmFreezeReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#getAllowTvmIstanbul()}
   *       return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowTvmIstanbulReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#getAllowTvmLondon()}
   *       return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowTvmLondonReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#getAllowTvmShangHai()}
   *       return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowTvmShangHaiReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link
   *       DynamicPropertiesStore#getAllowTvmSolidity059()} return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowTvmSolidity059ReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link
   *       DynamicPropertiesStore#getAllowTvmTransferTrc10()} return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowTvmTransferTrc10ReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(3L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#getAllowTvmVote()}
   *       return three.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetAllowTvmVoteReturnThree()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(3L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link
   *       DynamicPropertiesStore#getLatestBlockHeaderNumber()} return minus one.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreGetLatestBlockHeaderNumberReturnMinusOne()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(-1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link
   *       DynamicPropertiesStore#supportUnfreezeDelay()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreSupportUnfreezeDelayReturnFalse()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link
   *       DynamicPropertiesStore#supportUnfreezeDelay()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenDynamicPropertiesStoreSupportUnfreezeDelayReturnTrue()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowDynamicEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowEnergyAdjustment()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowHigherLimitForMaxCpuTimeOfOneTx()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowOptimizedReturnValueOfChainId()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowShieldedTRC20Transaction()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowStrictMath()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmCompatibleEvm()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmConstantinople()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmIstanbul()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmLondon()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmShangHai()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmSolidity059()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmTransferTrc10()).thenReturn(1L);
    when(dynamicPropertiesStore.getAllowTvmVote()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dynamicPropertiesStore.getDynamicEnergyThreshold()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(chainBaseManager);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(TransferException.class, () -> vmActuator.validate(transactionContext));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(dynamicPropertiesStore).getAllowDynamicEnergy();
    verify(dynamicPropertiesStore).getAllowEnergyAdjustment();
    verify(dynamicPropertiesStore).getAllowHigherLimitForMaxCpuTimeOfOneTx();
    verify(dynamicPropertiesStore).getAllowMultiSign();
    verify(dynamicPropertiesStore).getAllowOptimizedReturnValueOfChainId();
    verify(dynamicPropertiesStore).getAllowShieldedTRC20Transaction();
    verify(dynamicPropertiesStore).getAllowStrictMath();
    verify(dynamicPropertiesStore).getAllowTvmCompatibleEvm();
    verify(dynamicPropertiesStore).getAllowTvmConstantinople();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getAllowTvmIstanbul();
    verify(dynamicPropertiesStore).getAllowTvmLondon();
    verify(dynamicPropertiesStore).getAllowTvmShangHai();
    verify(dynamicPropertiesStore).getAllowTvmSolidity059();
    verify(dynamicPropertiesStore).getAllowTvmTransferTrc10();
    verify(dynamicPropertiesStore).getAllowTvmVote();
    verify(dynamicPropertiesStore).getDynamicEnergyIncreaseFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyMaxFactor();
    verify(dynamicPropertiesStore).getDynamicEnergyThreshold();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>Given {@link StoreFactory} {@link StoreFactory#getChainBaseManager()} return {@link
   *       ChainBaseManager} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_givenStoreFactoryGetChainBaseManagerReturnChainBaseManager()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(new ChainBaseManager());

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getTrxCap()).thenThrow(new RuntimeException());
    when(transactionContext.getStoreFactory()).thenReturn(storeFactory);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> vmActuator.validate(transactionContext));
    verify(transactionContext).getStoreFactory();
    verify(transactionContext).getTrxCap();
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_whenNull_thenThrowRuntimeException() throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new VMActuator(true).validate(null));
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   *
   * <ul>
   *   <li>When {@link TransactionContext} {@link TransactionContext#getStoreFactory()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate_whenTransactionContextGetStoreFactoryThrowRuntimeException()
      throws ContractValidateException {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    TransactionContext transactionContext = mock(TransactionContext.class);
    when(transactionContext.getStoreFactory()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> vmActuator.validate(transactionContext));
    verify(transactionContext).getStoreFactory();
  }

  /**
   * Test {@link VMActuator#execute(Object)}.
   *
   * <p>Method under test: {@link VMActuator#execute(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMActuator.execute(Object)"})
  public void testExecute() throws ContractExeException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new VMActuator(true).execute(null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VMActuator#setConstantCall(boolean)}
   *   <li>{@link VMActuator#setEnableEventListener(boolean)}
   *   <li>{@link VMActuator#setTrxType(TrxType)}
   *   <li>{@link VMActuator#getTrxType()}
   *   <li>{@link VMActuator#isConstantCall()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TrxType VMActuator.getTrxType()",
    "boolean VMActuator.isConstantCall()",
    "void VMActuator.setConstantCall(boolean)",
    "void VMActuator.setEnableEventListener(boolean)",
    "void VMActuator.setTrxType(TrxType)"
  })
  public void testGettersAndSetters() {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    // Act
    vmActuator.setConstantCall(true);
    vmActuator.setEnableEventListener(true);
    vmActuator.setTrxType(TrxType.TRX_PRECOMPILED_TYPE);
    TrxType actualTrxType = vmActuator.getTrxType();

    // Assert
    assertEquals(TrxType.TRX_PRECOMPILED_TYPE, actualTrxType);
    assertTrue(vmActuator.isConstantCall());
  }
}
