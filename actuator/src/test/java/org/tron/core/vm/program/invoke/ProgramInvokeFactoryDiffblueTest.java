package org.tron.core.vm.program.invoke;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test {@link ProgramInvokeFactory#createProgramInvoke(Program, DataWord, DataWord, DataWord,
   * DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long, long)} with {@code
   * program}, {@code toAddress}, {@code callerAddress}, {@code inValue}, {@code tokenValue}, {@code
   * tokenId}, {@code balanceInt}, {@code dataIn}, {@code deposit}, {@code isStaticCall}, {@code
   * byTestingSuite}, {@code vmStartInUs}, {@code vmShouldEndInUs}, {@code energyLimit}.
   *
   * <p>Method under test: {@link ProgramInvokeFactory#createProgramInvoke(Program, DataWord,
   * DataWord, DataWord, DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProgramInvoke ProgramInvokeFactory.createProgramInvoke(Program, DataWord, DataWord, DataWord, DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long, long)"
  })
  public void
      testCreateProgramInvokeWithProgramToAddressCallerAddressInValueTokenValueTokenIdBalanceIntDataInDepositIsStaticCallByTestingSuiteVmStartInUsVmShouldEndInUsEnergyLimit()
          throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord toAddress = DataWord.ZERO();
    DataWord callerAddress = DataWord.ZERO();
    DataWord inValue = DataWord.ZERO();
    DataWord tokenValue = DataWord.ZERO();
    DataWord tokenId = DataWord.ZERO();
    byte[] dataIn = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    ProgramInvoke actualCreateProgramInvokeResult =
        ProgramInvokeFactory.createProgramInvoke(
            program,
            toAddress,
            callerAddress,
            inValue,
            tokenValue,
            tokenId,
            42L,
            dataIn,
            deposit,
            true,
            true,
            1L,
            1L,
            1L);

    // Assert
    assertTrue(actualCreateProgramInvokeResult instanceof ProgramInvokeImpl);
  }

  /**
   * Test {@link ProgramInvokeFactory#createProgramInvoke(Program, DataWord, DataWord, DataWord,
   * DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long, long)} with {@code
   * program}, {@code toAddress}, {@code callerAddress}, {@code inValue}, {@code tokenValue}, {@code
   * tokenId}, {@code balanceInt}, {@code dataIn}, {@code deposit}, {@code isStaticCall}, {@code
   * byTestingSuite}, {@code vmStartInUs}, {@code vmShouldEndInUs}, {@code energyLimit}.
   *
   * <p>Method under test: {@link ProgramInvokeFactory#createProgramInvoke(Program, DataWord,
   * DataWord, DataWord, DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProgramInvoke ProgramInvokeFactory.createProgramInvoke(Program, DataWord, DataWord, DataWord, DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long, long)"
  })
  public void
      testCreateProgramInvokeWithProgramToAddressCallerAddressInValueTokenValueTokenIdBalanceIntDataInDepositIsStaticCallByTestingSuiteVmStartInUsVmShouldEndInUsEnergyLimit2()
          throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl(true);
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord toAddress = DataWord.ZERO();
    DataWord callerAddress = DataWord.ZERO();
    DataWord inValue = DataWord.ZERO();
    DataWord tokenValue = DataWord.ZERO();
    DataWord tokenId = DataWord.ZERO();
    byte[] dataIn = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    ProgramInvoke actualCreateProgramInvokeResult =
        ProgramInvokeFactory.createProgramInvoke(
            program,
            toAddress,
            callerAddress,
            inValue,
            tokenValue,
            tokenId,
            42L,
            dataIn,
            deposit,
            true,
            true,
            1L,
            1L,
            1L);

    // Assert
    assertTrue(actualCreateProgramInvokeResult instanceof ProgramInvokeImpl);
  }

  /**
   * Test {@link ProgramInvokeFactory#createProgramInvoke(Program, DataWord, DataWord, DataWord,
   * DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long, long)} with {@code
   * program}, {@code toAddress}, {@code callerAddress}, {@code inValue}, {@code tokenValue}, {@code
   * tokenId}, {@code balanceInt}, {@code dataIn}, {@code deposit}, {@code isStaticCall}, {@code
   * byTestingSuite}, {@code vmStartInUs}, {@code vmShouldEndInUs}, {@code energyLimit}.
   *
   * <p>Method under test: {@link ProgramInvokeFactory#createProgramInvoke(Program, DataWord,
   * DataWord, DataWord, DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProgramInvoke ProgramInvokeFactory.createProgramInvoke(Program, DataWord, DataWord, DataWord, DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long, long)"
  })
  public void
      testCreateProgramInvokeWithProgramToAddressCallerAddressInValueTokenValueTokenIdBalanceIntDataInDepositIsStaticCallByTestingSuiteVmStartInUsVmShouldEndInUsEnergyLimit3()
          throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord toAddress = DataWord.ZERO();
    DataWord callerAddress = DataWord.ZERO();
    DataWord inValue = DataWord.ZERO();
    DataWord tokenValue = DataWord.ZERO();
    DataWord tokenId = DataWord.ZERO();
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    ProgramInvoke actualCreateProgramInvokeResult =
        ProgramInvokeFactory.createProgramInvoke(
            program,
            toAddress,
            callerAddress,
            inValue,
            tokenValue,
            tokenId,
            42L,
            null,
            deposit,
            true,
            true,
            1L,
            1L,
            1L);

    // Assert
    assertTrue(actualCreateProgramInvokeResult instanceof ProgramInvokeImpl);
    assertSame(DataWord.ZERO, actualCreateProgramInvokeResult.getDataSize());
  }

  /**
   * Test {@link ProgramInvokeFactory#createProgramInvoke(TrxType, ExecutorType, Transaction, long,
   * long, Block, Repository, long, long, long)} with {@code trxType}, {@code executorType}, {@code
   * tx}, {@code tokenValue}, {@code tokenId}, {@code block}, {@code deposit}, {@code vmStartInUs},
   * {@code vmShouldEndInUs}, {@code energyLimit}.
   *
   * <p>Method under test: {@link ProgramInvokeFactory#createProgramInvoke(TrxType,
   * InternalTransaction.ExecutorType, Transaction, long, long, Block, Repository, long, long,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProgramInvoke ProgramInvokeFactory.createProgramInvoke(TrxType, InternalTransaction.ExecutorType, Transaction, long, long, Block, Repository, long, long, long)"
  })
  public void
      testCreateProgramInvokeWithTrxTypeExecutorTypeTxTokenValueTokenIdBlockDepositVmStartInUsVmShouldEndInUsEnergyLimit()
          throws ContractValidateException {
    // Arrange
    Transaction tx = Transaction.getDefaultInstance();
    Block block = Block.getDefaultInstance();
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act and Assert
    assertThrows(
        ContractValidateException.class,
        () ->
            ProgramInvokeFactory.createProgramInvoke(
                TrxType.TRX_PRECOMPILED_TYPE,
                ExecutorType.ET_PRE_TYPE,
                tx,
                42L,
                1L,
                block,
                deposit,
                1L,
                1L,
                1L));
  }
}
