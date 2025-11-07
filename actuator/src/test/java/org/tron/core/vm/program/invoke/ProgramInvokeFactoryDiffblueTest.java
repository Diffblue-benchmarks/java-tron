package org.tron.core.vm.program.invoke;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;

public class ProgramInvokeFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link ProgramInvokeFactory#createProgramInvoke(InternalTransaction.TrxType, InternalTransaction.ExecutorType, Protocol.Transaction, long, long, Protocol.Block, Repository, long, long, long)}
   */
  @Test
  public void testCreateProgramInvoke() throws ContractValidateException {
    // Arrange
    Protocol.Transaction tx = Protocol.Transaction.getDefaultInstance();
    Protocol.Block block = Protocol.Block.getDefaultInstance();

    // Act and Assert
    assertThrows(ContractValidateException.class,
        () -> ProgramInvokeFactory.createProgramInvoke(InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE,
            InternalTransaction.ExecutorType.ET_PRE_TYPE, tx, 42L, 1L, block,
            new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 1L, 1L, 1L));
  }

  /**
   * Method under test:
   * {@link ProgramInvokeFactory#createProgramInvoke(Program, DataWord, DataWord, DataWord, DataWord, DataWord, long, byte[], Repository, boolean, boolean, long, long, long)}
   */
  @Test
  public void testCreateProgramInvoke2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

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
    DataWord dataSize = actualCreateProgramInvokeResult.getDataSize();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", dataSize.toHexString());
    DataWord number = actualCreateProgramInvokeResult.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", number.toHexString());
    DataWord balance = actualCreateProgramInvokeResult.getBalance();
    assertEquals("000000000000000000000000000000000000000000000000000000000000002a", balance.toHexString());
    DataWord timestamp = actualCreateProgramInvokeResult.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", timestamp.toHexString());
    DataWord coinbase = actualCreateProgramInvokeResult.getCoinbase();
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", coinbase.toHexString());
    DataWord originAddress = actualCreateProgramInvokeResult.getOriginAddress();
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", originAddress.toHexString());
    assertEquals("08", dataSize.toPrefixString());
    assertEquals("21", number.toPrefixString());
    assertEquals("2a", balance.toPrefixString());
    assertEquals("411397", originAddress.toPrefixString());
    assertEquals("5387fe24", timestamp.toPrefixString());
    DataWord prevHash = actualCreateProgramInvokeResult.getPrevHash();
    assertEquals("961cb1", prevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", prevHash.toHexString());
    assertEquals("e559de", coinbase.toPrefixString());
    assertEquals(1, actualCreateProgramInvokeResult.getCallDeep());
    assertEquals(1L, actualCreateProgramInvokeResult.getEnergyLimit());
    assertEquals(1L, actualCreateProgramInvokeResult.getVmShouldEndInUs());
    assertEquals(1L, actualCreateProgramInvokeResult.getVmStartInUs());
    assertFalse(balance.isNegative());
    assertFalse(coinbase.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(number.isNegative());
    assertFalse(originAddress.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(coinbase.isZero());
    assertFalse(dataSize.isZero());
    assertFalse(number.isZero());
    assertFalse(originAddress.isZero());
    assertFalse(prevHash.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualCreateProgramInvokeResult.isConstantCall());
    assertTrue(prevHash.isNegative());
    assertTrue(actualCreateProgramInvokeResult.byTestingSuite());
    assertTrue(actualCreateProgramInvokeResult.isStaticCall());
    assertEquals(toAddress, actualCreateProgramInvokeResult.getDifficulty());
    assertSame(deposit, actualCreateProgramInvokeResult.getDeposit());
    byte[] data = balance.getData();
    assertSame(data, balance.getNoEndZeroesData());
    byte[] data2 = coinbase.getData();
    assertSame(data2, coinbase.getNoEndZeroesData());
    byte[] data3 = dataSize.getData();
    assertSame(data3, dataSize.getNoEndZeroesData());
    byte[] data4 = number.getData();
    assertSame(data4, number.getNoEndZeroesData());
    byte[] data5 = originAddress.getData();
    assertSame(data5, originAddress.getNoEndZeroesData());
    byte[] data6 = prevHash.getData();
    assertSame(data6, prevHash.getNoEndZeroesData());
    assertSame(data6, prevHash.getNoLeadZeroesData());
    byte[] data7 = timestamp.getData();
    assertSame(data7, timestamp.getNoEndZeroesData());
    assertSame(inValue, actualCreateProgramInvokeResult.getCallValue());
    assertSame(callerAddress, actualCreateProgramInvokeResult.getCallerAddress());
    assertSame(toAddress, actualCreateProgramInvokeResult.getContractAddress());
    assertSame(tokenId, actualCreateProgramInvokeResult.getTokenId());
    assertSame(tokenValue, actualCreateProgramInvokeResult.getTokenValue());
    assertArrayEquals(new byte[]{'!'}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'*'}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\b'}, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, originAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        prevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, coinbase.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, prevHash.toTronAddress());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, prevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data6);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, coinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data4);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        data);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data3);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, timestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data7);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, originAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data5);
  }
}
