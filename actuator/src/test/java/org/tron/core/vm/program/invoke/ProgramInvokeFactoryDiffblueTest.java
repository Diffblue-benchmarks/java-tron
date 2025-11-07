package org.tron.core.vm.program.invoke;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.InternalTransaction.ExecutorType;
import org.tron.common.runtime.InternalTransaction.TrxType;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Block;
import org.tron.protos.Protocol.Transaction;

public class ProgramInvokeFactoryDiffblueTest {
  /**
   * Test {@link ProgramInvokeFactory#createProgramInvoke(Program, DataWord, DataWord, DataWord, DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long, long)} with {@code program}, {@code toAddress}, {@code callerAddress}, {@code inValue}, {@code tokenValue}, {@code tokenId}, {@code balanceInt}, {@code dataIn}, {@code deposit}, {@code isStaticCall}, {@code byTestingSuite}, {@code vmStartInUs}, {@code vmShouldEndInUs}, {@code energyLimit}.
   * <p>
   * Method under test: {@link ProgramInvokeFactory#createProgramInvoke(Program, DataWord, DataWord, DataWord, DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ProgramInvoke ProgramInvokeFactory.createProgramInvoke(Program, DataWord, DataWord, DataWord, DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long, long)"})
  public void testCreateProgramInvokeWithProgramToAddressCallerAddressInValueTokenValueTokenIdBalanceIntDataInDepositIsStaticCallByTestingSuiteVmStartInUsVmShouldEndInUsEnergyLimit()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    DataWord toAddress = DataWord.ZERO();
    DataWord callerAddress = DataWord.ZERO();
    DataWord inValue = DataWord.ZERO();
    DataWord tokenValue = DataWord.ZERO();
    DataWord tokenId = DataWord.ZERO();
    byte[] dataIn = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    ProgramInvoke actualCreateProgramInvokeResult = ProgramInvokeFactory.createProgramInvoke(program, toAddress,
        callerAddress, inValue, tokenValue, tokenId, 42L, dataIn, deposit, true, true, 1L, 1L, 1L);

    // Assert
    assertTrue(actualCreateProgramInvokeResult instanceof ProgramInvokeImpl);
    Repository deposit2 = actualCreateProgramInvokeResult.getDeposit();
    assertTrue(deposit2 instanceof RepositoryImpl);
    assertEquals(1, actualCreateProgramInvokeResult.getCallDeep());
    assertEquals(1L, actualCreateProgramInvokeResult.getEnergyLimit());
    assertEquals(1L, actualCreateProgramInvokeResult.getVmShouldEndInUs());
    assertEquals(1L, actualCreateProgramInvokeResult.getVmStartInUs());
    assertFalse(actualCreateProgramInvokeResult.isConstantCall());
    assertTrue(actualCreateProgramInvokeResult.byTestingSuite());
    assertTrue(actualCreateProgramInvokeResult.isStaticCall());
    assertSame(deposit, deposit2);
    assertSame(inValue, actualCreateProgramInvokeResult.getCallValue());
    assertSame(callerAddress, actualCreateProgramInvokeResult.getCallerAddress());
    assertSame(toAddress, actualCreateProgramInvokeResult.getContractAddress());
    assertSame(tokenId, actualCreateProgramInvokeResult.getTokenId());
    assertSame(tokenValue, actualCreateProgramInvokeResult.getTokenValue());
  }

  /**
   * Test {@link ProgramInvokeFactory#createProgramInvoke(TrxType, ExecutorType, Transaction, long, long, Block, Repository, long, long, long)} with {@code trxType}, {@code executorType}, {@code tx}, {@code tokenValue}, {@code tokenId}, {@code block}, {@code deposit}, {@code vmStartInUs}, {@code vmShouldEndInUs}, {@code energyLimit}.
   * <p>
   * Method under test: {@link ProgramInvokeFactory#createProgramInvoke(TrxType, InternalTransaction.ExecutorType, Transaction, long, long, Block, Repository, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ProgramInvoke ProgramInvokeFactory.createProgramInvoke(TrxType, InternalTransaction.ExecutorType, Transaction, long, long, Block, Repository, long, long, long)"})
  public void testCreateProgramInvokeWithTrxTypeExecutorTypeTxTokenValueTokenIdBlockDepositVmStartInUsVmShouldEndInUsEnergyLimit()
      throws ContractValidateException {
    // Arrange
    Transaction tx = Transaction.getDefaultInstance();
    Block block = Block.getDefaultInstance();

    // Act and Assert
    assertThrows(ContractValidateException.class,
        () -> ProgramInvokeFactory.createProgramInvoke(TrxType.TRX_PRECOMPILED_TYPE, ExecutorType.ET_PRE_TYPE, tx, 42L,
            1L, block, new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 1L, 1L, 1L));
  }
}
