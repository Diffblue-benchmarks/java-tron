package org.tron.core.vm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.tron.common.runtime.ProgramResult;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.capsule.ProtoCapsule;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Key;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.core.vm.repository.Value;

public class PrecompiledContractsDiffblueTest {
  /**
   * Method under test:
   * {@link PrecompiledContracts.AvailableUnfreezeV2Size#execute(byte[])}
   */
  @Test
  public void testAvailableUnfreezeV2SizeExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = availableUnfreezeV2Size.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.AvailableUnfreezeV2Size#execute(byte[])}
   */
  @Test
  public void testAvailableUnfreezeV2SizeExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.AvailableUnfreezeV2Size()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.AvailableUnfreezeV2Size#getEnergyForData(byte[])}
   */
  @Test
  public void testAvailableUnfreezeV2SizeGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();

    // Act and Assert
    assertEquals(50L, availableUnfreezeV2Size.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.AvailableUnfreezeV2Size}
   */
  @Test
  public void testAvailableUnfreezeV2SizeNewAvailableUnfreezeV2Size() {
    // Arrange and Act
    PrecompiledContracts.AvailableUnfreezeV2Size actualAvailableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();

    // Assert
    assertNull(actualAvailableUnfreezeV2Size.getResult());
    assertNull(actualAvailableUnfreezeV2Size.getDeposit());
    assertEquals(0L, actualAvailableUnfreezeV2Size.getVmShouldEndInUs());
    assertFalse(actualAvailableUnfreezeV2Size.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.BN128Addition#execute(byte[])}
   */
  @Test
  public void testBN128AdditionExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.BN128Addition bn128Addition = new PrecompiledContracts.BN128Addition();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = bn128Addition.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals(0, right.length);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test: {@link PrecompiledContracts.BN128Addition#execute(byte[])}
   */
  @Test
  public void testBN128AdditionExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.BN128Addition()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test: {@link PrecompiledContracts.BN128Addition#execute(byte[])}
   */
  @Test
  public void testBN128AdditionExecute3() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.BN128Addition bn128Addition = new PrecompiledContracts.BN128Addition();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = bn128Addition.execute(" XAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals(0, right.length);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.BN128Addition#getEnergyForData(byte[])}
   */
  @Test
  public void testBN128AdditionGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.BN128Addition bn128Addition = new PrecompiledContracts.BN128Addition();

    // Act and Assert
    assertEquals(500L, bn128Addition.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.BN128Addition}
   */
  @Test
  public void testBN128AdditionNewBN128Addition() {
    // Arrange and Act
    PrecompiledContracts.BN128Addition actualBn128Addition = new PrecompiledContracts.BN128Addition();

    // Assert
    assertNull(actualBn128Addition.getResult());
    assertNull(actualBn128Addition.getDeposit());
    assertEquals(0L, actualBn128Addition.getVmShouldEndInUs());
    assertFalse(actualBn128Addition.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.BN128Multiplication#execute(byte[])}
   */
  @Test
  public void testBN128MultiplicationExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.BN128Multiplication bn128Multiplication = new PrecompiledContracts.BN128Multiplication();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = bn128Multiplication.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals(0, right.length);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.BN128Multiplication#execute(byte[])}
   */
  @Test
  public void testBN128MultiplicationExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.BN128Multiplication()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.BN128Multiplication#execute(byte[])}
   */
  @Test
  public void testBN128MultiplicationExecute3() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.BN128Multiplication bn128Multiplication = new PrecompiledContracts.BN128Multiplication();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = bn128Multiplication.execute(" XAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals(0, right.length);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.BN128Multiplication#getEnergyForData(byte[])}
   */
  @Test
  public void testBN128MultiplicationGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.BN128Multiplication bn128Multiplication = new PrecompiledContracts.BN128Multiplication();

    // Act and Assert
    assertEquals(40000L, bn128Multiplication.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.BN128Multiplication}
   */
  @Test
  public void testBN128MultiplicationNewBN128Multiplication() {
    // Arrange and Act
    PrecompiledContracts.BN128Multiplication actualBn128Multiplication = new PrecompiledContracts.BN128Multiplication();

    // Assert
    assertNull(actualBn128Multiplication.getResult());
    assertNull(actualBn128Multiplication.getDeposit());
    assertEquals(0L, actualBn128Multiplication.getVmShouldEndInUs());
    assertFalse(actualBn128Multiplication.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.BN128Pairing#execute(byte[])}
   */
  @Test
  public void testBN128PairingExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.BN128Pairing bn128Pairing = new PrecompiledContracts.BN128Pairing();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = bn128Pairing.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals(0, right.length);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test: {@link PrecompiledContracts.BN128Pairing#execute(byte[])}
   */
  @Test
  public void testBN128PairingExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.BN128Pairing()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        right);
  }

  /**
   * Method under test: {@link PrecompiledContracts.BN128Pairing#execute(byte[])}
   */
  @Test
  public void testBN128PairingExecute3() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.BN128Pairing()).execute(new byte[]{});

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.BN128Pairing#getEnergyForData(byte[])}
   */
  @Test
  public void testBN128PairingGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.BN128Pairing bn128Pairing = new PrecompiledContracts.BN128Pairing();

    // Act and Assert
    assertEquals(100000L, bn128Pairing.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.BN128Pairing#getEnergyForData(byte[])}
   */
  @Test
  public void testBN128PairingGetEnergyForData2() {
    // Arrange, Act and Assert
    assertEquals(100000L, (new PrecompiledContracts.BN128Pairing()).getEnergyForData(null));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.BN128Pairing}
   */
  @Test
  public void testBN128PairingNewBN128Pairing() {
    // Arrange and Act
    PrecompiledContracts.BN128Pairing actualBn128Pairing = new PrecompiledContracts.BN128Pairing();

    // Assert
    assertNull(actualBn128Pairing.getResult());
    assertNull(actualBn128Pairing.getDeposit());
    assertEquals(0L, actualBn128Pairing.getVmShouldEndInUs());
    assertFalse(actualBn128Pairing.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.BatchValidateSign#execute(byte[])}
   */
  @Test
  public void testBatchValidateSignExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.BatchValidateSign batchValidateSign = new PrecompiledContracts.BatchValidateSign();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = batchValidateSign.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.BatchValidateSign#getEnergyForData(byte[])}
   */
  @Test
  public void testBatchValidateSignGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.BatchValidateSign batchValidateSign = new PrecompiledContracts.BatchValidateSign();

    // Act and Assert
    assertEquals(0L, batchValidateSign.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.BatchValidateSign}
   */
  @Test
  public void testBatchValidateSignNewBatchValidateSign() {
    // Arrange and Act
    PrecompiledContracts.BatchValidateSign actualBatchValidateSign = new PrecompiledContracts.BatchValidateSign();

    // Assert
    assertNull(actualBatchValidateSign.getResult());
    assertNull(actualBatchValidateSign.getDeposit());
    assertEquals(0L, actualBatchValidateSign.getVmShouldEndInUs());
    assertFalse(actualBatchValidateSign.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.Blake2F#execute(byte[])}
   */
  @Test
  public void testBlake2FExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.Blake2F blake2F = new PrecompiledContracts.Blake2F();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = blake2F.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.Blake2F#getEnergyForData(byte[])}
   */
  @Test
  public void testBlake2FGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.Blake2F blake2F = new PrecompiledContracts.Blake2F();

    // Act and Assert
    assertEquals(0L, blake2F.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.Blake2F}
   */
  @Test
  public void testBlake2FNewBlake2F() {
    // Arrange and Act
    PrecompiledContracts.Blake2F actualBlake2F = new PrecompiledContracts.Blake2F();

    // Assert
    assertNull(actualBlake2F.getResult());
    assertNull(actualBlake2F.getDeposit());
    assertEquals(0L, actualBlake2F.getVmShouldEndInUs());
    assertFalse(actualBlake2F.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.CheckUnDelegateResource#execute(byte[])}
   */
  @Test
  public void testCheckUnDelegateResourceExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.CheckUnDelegateResource checkUnDelegateResource = new PrecompiledContracts.CheckUnDelegateResource();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = checkUnDelegateResource.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals((byte) 0, right[0]);
    assertEquals((byte) 0, right[1]);
    assertEquals((byte) 0, right[12]);
    assertEquals((byte) 0, right[13]);
    assertEquals((byte) 0, right[14]);
    assertEquals((byte) 0, right[15]);
    assertEquals((byte) 0, right[2]);
    assertEquals((byte) 0, right[3]);
    assertEquals((byte) 0, right[4]);
    assertEquals((byte) 0, right[5]);
    assertEquals((byte) 0, right[6]);
    assertEquals((byte) 0, right[7]);
    assertEquals((byte) 0, right[73]);
    assertEquals((byte) 0, right[74]);
    assertEquals((byte) 0, right[75]);
    assertEquals((byte) 0, right[76]);
    assertEquals((byte) 0, right[77]);
    assertEquals((byte) 0, right[78]);
    assertEquals((byte) 0, right[79]);
    assertEquals((byte) 0, right[8]);
    assertEquals((byte) 0, right[92]);
    assertEquals((byte) 0, right[93]);
    assertEquals((byte) 0, right[94]);
    assertEquals((byte) 0, right[Op.AND]);
    assertEquals((byte) 0, right[Op.BASEFEE]);
    assertEquals((byte) 0, right[Op.EQ]);
    assertEquals((byte) 0, right[Op.EXP]);
    assertEquals((byte) 0, right[Op.GAS]);
    assertEquals((byte) 0, right[Op.GT]);
    assertEquals((byte) 0, right[Op.ISZERO]);
    assertEquals((byte) 0, right[Op.JUMP]);
    assertEquals((byte) 0, right[Op.JUMPDEST]);
    assertEquals((byte) 0, right[Op.JUMPI]);
    assertEquals((byte) 0, right[Op.LT]);
    assertEquals((byte) 0, right[Op.MLOAD]);
    assertEquals((byte) 0, right[Op.MSIZE]);
    assertEquals((byte) 0, right[Op.MSTORE]);
    assertEquals((byte) 0, right[Op.MSTORE8]);
    assertEquals((byte) 0, right[Op.MULMOD]);
    assertEquals((byte) 0, right[Op.OR]);
    assertEquals((byte) 0, right[Op.PC]);
    assertEquals((byte) 0, right[Op.POP]);
    assertEquals((byte) 0, right[Op.PUSH0]);
    assertEquals((byte) 0, right[Op.SELFBALANCE]);
    assertEquals((byte) 0, right[Op.SGT]);
    assertEquals((byte) 0, right[Op.SIGNEXTEND]);
    assertEquals((byte) 0, right[Op.SLOAD]);
    assertEquals((byte) 0, right[Op.SLT]);
    assertEquals((byte) 0, right[Op.SSTORE]);
    assertEquals((byte) 0, right[Op.XOR]);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    assertEquals(Op.PUSH1, right.length);
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.CheckUnDelegateResource#execute(byte[])}
   */
  @Test
  public void testCheckUnDelegateResourceExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.CheckUnDelegateResource()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals((byte) 0, right[0]);
    assertEquals((byte) 0, right[1]);
    assertEquals((byte) 0, right[12]);
    assertEquals((byte) 0, right[13]);
    assertEquals((byte) 0, right[14]);
    assertEquals((byte) 0, right[15]);
    assertEquals((byte) 0, right[2]);
    assertEquals((byte) 0, right[3]);
    assertEquals((byte) 0, right[4]);
    assertEquals((byte) 0, right[5]);
    assertEquals((byte) 0, right[6]);
    assertEquals((byte) 0, right[7]);
    assertEquals((byte) 0, right[73]);
    assertEquals((byte) 0, right[74]);
    assertEquals((byte) 0, right[75]);
    assertEquals((byte) 0, right[76]);
    assertEquals((byte) 0, right[77]);
    assertEquals((byte) 0, right[78]);
    assertEquals((byte) 0, right[79]);
    assertEquals((byte) 0, right[8]);
    assertEquals((byte) 0, right[92]);
    assertEquals((byte) 0, right[93]);
    assertEquals((byte) 0, right[94]);
    assertEquals((byte) 0, right[Op.AND]);
    assertEquals((byte) 0, right[Op.BASEFEE]);
    assertEquals((byte) 0, right[Op.EQ]);
    assertEquals((byte) 0, right[Op.EXP]);
    assertEquals((byte) 0, right[Op.GAS]);
    assertEquals((byte) 0, right[Op.GT]);
    assertEquals((byte) 0, right[Op.ISZERO]);
    assertEquals((byte) 0, right[Op.JUMP]);
    assertEquals((byte) 0, right[Op.JUMPDEST]);
    assertEquals((byte) 0, right[Op.JUMPI]);
    assertEquals((byte) 0, right[Op.LT]);
    assertEquals((byte) 0, right[Op.MLOAD]);
    assertEquals((byte) 0, right[Op.MSIZE]);
    assertEquals((byte) 0, right[Op.MSTORE]);
    assertEquals((byte) 0, right[Op.MSTORE8]);
    assertEquals((byte) 0, right[Op.MULMOD]);
    assertEquals((byte) 0, right[Op.OR]);
    assertEquals((byte) 0, right[Op.PC]);
    assertEquals((byte) 0, right[Op.POP]);
    assertEquals((byte) 0, right[Op.PUSH0]);
    assertEquals((byte) 0, right[Op.SELFBALANCE]);
    assertEquals((byte) 0, right[Op.SGT]);
    assertEquals((byte) 0, right[Op.SIGNEXTEND]);
    assertEquals((byte) 0, right[Op.SLOAD]);
    assertEquals((byte) 0, right[Op.SLT]);
    assertEquals((byte) 0, right[Op.SSTORE]);
    assertEquals((byte) 0, right[Op.XOR]);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    assertEquals(Op.PUSH1, right.length);
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.CheckUnDelegateResource#getEnergyForData(byte[])}
   */
  @Test
  public void testCheckUnDelegateResourceGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.CheckUnDelegateResource checkUnDelegateResource = new PrecompiledContracts.CheckUnDelegateResource();

    // Act and Assert
    assertEquals(50L, checkUnDelegateResource.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.CheckUnDelegateResource}
   */
  @Test
  public void testCheckUnDelegateResourceNewCheckUnDelegateResource() {
    // Arrange and Act
    PrecompiledContracts.CheckUnDelegateResource actualCheckUnDelegateResource = new PrecompiledContracts.CheckUnDelegateResource();

    // Assert
    assertNull(actualCheckUnDelegateResource.getResult());
    assertNull(actualCheckUnDelegateResource.getDeposit());
    assertEquals(0L, actualCheckUnDelegateResource.getVmShouldEndInUs());
    assertFalse(actualCheckUnDelegateResource.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.DelegatableResource#execute(byte[])}
   */
  @Test
  public void testDelegatableResourceExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.DelegatableResource delegatableResource = new PrecompiledContracts.DelegatableResource();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = delegatableResource.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.DelegatableResource#execute(byte[])}
   */
  @Test
  public void testDelegatableResourceExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.DelegatableResource()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.DelegatableResource#getEnergyForData(byte[])}
   */
  @Test
  public void testDelegatableResourceGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.DelegatableResource delegatableResource = new PrecompiledContracts.DelegatableResource();

    // Act and Assert
    assertEquals(50L, delegatableResource.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.DelegatableResource}
   */
  @Test
  public void testDelegatableResourceNewDelegatableResource() {
    // Arrange and Act
    PrecompiledContracts.DelegatableResource actualDelegatableResource = new PrecompiledContracts.DelegatableResource();

    // Assert
    assertNull(actualDelegatableResource.getResult());
    assertNull(actualDelegatableResource.getDeposit());
    assertEquals(0L, actualDelegatableResource.getVmShouldEndInUs());
    assertFalse(actualDelegatableResource.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.ECRecover#execute(byte[])}
   */
  @Test
  public void testECRecoverExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ECRecover ecRecover = new PrecompiledContracts.ECRecover();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = ecRecover.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals(0, right.length);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.ECRecover#getEnergyForData(byte[])}
   */
  @Test
  public void testECRecoverGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ECRecover ecRecover = new PrecompiledContracts.ECRecover();

    // Act and Assert
    assertEquals(3000L, ecRecover.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.ECRecover}
   */
  @Test
  public void testECRecoverNewECRecover() {
    // Arrange and Act
    PrecompiledContracts.ECRecover actualEcRecover = new PrecompiledContracts.ECRecover();

    // Assert
    assertNull(actualEcRecover.getResult());
    assertNull(actualEcRecover.getDeposit());
    assertEquals(0L, actualEcRecover.getVmShouldEndInUs());
    assertFalse(actualEcRecover.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.EthRipemd160#execute(byte[])}
   */
  @Test
  public void testEthRipemd160Execute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.EthRipemd160 ethRipemd160 = new PrecompiledContracts.EthRipemd160();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = ethRipemd160.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -99, 'i', '~', -56, -105, '[', -65, '\r', 3, 'Q',
        -64, -113, -57, 1, 'U', -26, -28, -75, -47, -104}, right);
  }

  /**
   * Method under test: {@link PrecompiledContracts.EthRipemd160#execute(byte[])}
   */
  @Test
  public void testEthRipemd160Execute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.EthRipemd160()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -100, 17, -123, -91, -59, -23, -4, 'T', 'a', '(',
        '\b', -105, '~', -24, -11, 'H', -78, '%', -115, '1'}, right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.EthRipemd160#getEnergyForData(byte[])}
   */
  @Test
  public void testEthRipemd160GetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.EthRipemd160 ethRipemd160 = new PrecompiledContracts.EthRipemd160();

    // Act and Assert
    assertEquals(720L, ethRipemd160.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.EthRipemd160#getEnergyForData(byte[])}
   */
  @Test
  public void testEthRipemd160GetEnergyForData2() {
    // Arrange, Act and Assert
    assertEquals(600L, (new PrecompiledContracts.EthRipemd160()).getEnergyForData(null));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.EthRipemd160}
   */
  @Test
  public void testEthRipemd160NewEthRipemd160() {
    // Arrange and Act
    PrecompiledContracts.EthRipemd160 actualEthRipemd160 = new PrecompiledContracts.EthRipemd160();

    // Assert
    assertNull(actualEthRipemd160.getResult());
    assertNull(actualEthRipemd160.getDeposit());
    assertEquals(0L, actualEthRipemd160.getVmShouldEndInUs());
    assertFalse(actualEthRipemd160.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.ExpireUnfreezeBalanceV2#execute(byte[])}
   */
  @Test
  public void testExpireUnfreezeBalanceV2Execute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ExpireUnfreezeBalanceV2 expireUnfreezeBalanceV2 = new PrecompiledContracts.ExpireUnfreezeBalanceV2();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = expireUnfreezeBalanceV2.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.ExpireUnfreezeBalanceV2#execute(byte[])}
   */
  @Test
  public void testExpireUnfreezeBalanceV2Execute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.ExpireUnfreezeBalanceV2()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.ExpireUnfreezeBalanceV2#getEnergyForData(byte[])}
   */
  @Test
  public void testExpireUnfreezeBalanceV2GetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ExpireUnfreezeBalanceV2 expireUnfreezeBalanceV2 = new PrecompiledContracts.ExpireUnfreezeBalanceV2();

    // Act and Assert
    assertEquals(50L, expireUnfreezeBalanceV2.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.ExpireUnfreezeBalanceV2}
   */
  @Test
  public void testExpireUnfreezeBalanceV2NewExpireUnfreezeBalanceV2() {
    // Arrange and Act
    PrecompiledContracts.ExpireUnfreezeBalanceV2 actualExpireUnfreezeBalanceV2 = new PrecompiledContracts.ExpireUnfreezeBalanceV2();

    // Assert
    assertNull(actualExpireUnfreezeBalanceV2.getResult());
    assertNull(actualExpireUnfreezeBalanceV2.getDeposit());
    assertEquals(0L, actualExpireUnfreezeBalanceV2.getVmShouldEndInUs());
    assertFalse(actualExpireUnfreezeBalanceV2.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.GetChainParameter#execute(byte[])}
   */
  @Test
  public void testGetChainParameterExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.GetChainParameter getChainParameter = new PrecompiledContracts.GetChainParameter();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = getChainParameter.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.GetChainParameter#execute(byte[])}
   */
  @Test
  public void testGetChainParameterExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.GetChainParameter()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.GetChainParameter#getEnergyForData(byte[])}
   */
  @Test
  public void testGetChainParameterGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.GetChainParameter getChainParameter = new PrecompiledContracts.GetChainParameter();

    // Act and Assert
    assertEquals(50L, getChainParameter.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.GetChainParameter}
   */
  @Test
  public void testGetChainParameterNewGetChainParameter() {
    // Arrange and Act
    PrecompiledContracts.GetChainParameter actualGetChainParameter = new PrecompiledContracts.GetChainParameter();

    // Assert
    assertNull(actualGetChainParameter.getResult());
    assertNull(actualGetChainParameter.getDeposit());
    assertEquals(0L, actualGetChainParameter.getVmShouldEndInUs());
    assertFalse(actualGetChainParameter.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts#getOptimizedContractForConstant(PrecompiledContracts.PrecompiledContract)}
   */
  @Test
  public void testGetOptimizedContractForConstant() {
    // Arrange and Act
    PrecompiledContracts.PrecompiledContract actualOptimizedContractForConstant = PrecompiledContracts
        .getOptimizedContractForConstant(new PrecompiledContracts.AvailableUnfreezeV2Size());

    // Assert
    assertTrue(actualOptimizedContractForConstant instanceof PrecompiledContracts.AvailableUnfreezeV2Size);
    assertNull(actualOptimizedContractForConstant.getResult());
    assertNull(actualOptimizedContractForConstant.getDeposit());
    assertEquals(0L, actualOptimizedContractForConstant.getVmShouldEndInUs());
    assertFalse(actualOptimizedContractForConstant.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts#getOptimizedContractForConstant(PrecompiledContracts.PrecompiledContract)}
   */
  @Test
  public void testGetOptimizedContractForConstant2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    deposit.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    PrecompiledContracts.AvailableUnfreezeV2Size contract = new PrecompiledContracts.AvailableUnfreezeV2Size();
    contract.setRepository(deposit);

    // Act
    PrecompiledContracts.PrecompiledContract actualOptimizedContractForConstant = PrecompiledContracts
        .getOptimizedContractForConstant(contract);

    // Assert
    verify(capsule).getInstance();
    assertTrue(actualOptimizedContractForConstant instanceof PrecompiledContracts.AvailableUnfreezeV2Size);
    assertNull(actualOptimizedContractForConstant.getResult());
    assertNull(actualOptimizedContractForConstant.getDeposit());
    assertEquals(0L, actualOptimizedContractForConstant.getVmShouldEndInUs());
    assertFalse(actualOptimizedContractForConstant.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts#getContractForAddress(DataWord)}
   */
  @Test
  public void testGetContractForAddress() {
    // Arrange, Act and Assert
    assertNull(PrecompiledContracts.getContractForAddress(DataWord.ZERO()));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts#getContractForAddress(DataWord)}
   */
  @Test
  public void testGetContractForAddress2() {
    // Arrange and Act
    PrecompiledContracts.PrecompiledContract actualContractForAddress = PrecompiledContracts
        .getContractForAddress(null);

    // Assert
    assertTrue(actualContractForAddress instanceof PrecompiledContracts.Identity);
    assertNull(actualContractForAddress.getResult());
    assertNull(actualContractForAddress.getDeposit());
    assertEquals(0L, actualContractForAddress.getVmShouldEndInUs());
    assertFalse(actualContractForAddress.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts#getContractForAddress(DataWord)}
   */
  @Test
  public void testGetContractForAddress3() {
    // Arrange
    DataWord address = DataWord.ZERO();
    address.exp(DataWord.ZERO());

    // Act
    PrecompiledContracts.PrecompiledContract actualContractForAddress = PrecompiledContracts
        .getContractForAddress(address);

    // Assert
    assertTrue(actualContractForAddress instanceof PrecompiledContracts.ECRecover);
    assertNull(actualContractForAddress.getResult());
    assertNull(actualContractForAddress.getDeposit());
    assertEquals(0L, actualContractForAddress.getVmShouldEndInUs());
    assertFalse(actualContractForAddress.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.Identity#execute(byte[])}
   */
  @Test
  public void testIdentityExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.Identity identity = new PrecompiledContracts.Identity();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = identity.execute(data);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    assertSame(data, actualExecuteResult.getRight());
    assertSame(data, actualExecuteResult.getValue());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.Identity#getEnergyForData(byte[])}
   */
  @Test
  public void testIdentityGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.Identity identity = new PrecompiledContracts.Identity();

    // Act and Assert
    assertEquals(18L, identity.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.Identity#getEnergyForData(byte[])}
   */
  @Test
  public void testIdentityGetEnergyForData2() {
    // Arrange, Act and Assert
    assertEquals(15L, (new PrecompiledContracts.Identity()).getEnergyForData(null));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.Identity}
   */
  @Test
  public void testIdentityNewIdentity() {
    // Arrange and Act
    PrecompiledContracts.Identity actualIdentity = new PrecompiledContracts.Identity();

    // Assert
    assertNull(actualIdentity.getResult());
    assertNull(actualIdentity.getDeposit());
    assertEquals(0L, actualIdentity.getVmShouldEndInUs());
    assertFalse(actualIdentity.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.IsSrCandidate#execute(byte[])}
   */
  @Test
  public void testIsSrCandidateExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.IsSrCandidate isSrCandidate = new PrecompiledContracts.IsSrCandidate();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = isSrCandidate.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test: {@link PrecompiledContracts.IsSrCandidate#execute(byte[])}
   */
  @Test
  public void testIsSrCandidateExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.IsSrCandidate()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.IsSrCandidate#getEnergyForData(byte[])}
   */
  @Test
  public void testIsSrCandidateGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.IsSrCandidate isSrCandidate = new PrecompiledContracts.IsSrCandidate();

    // Act and Assert
    assertEquals(20L, isSrCandidate.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.IsSrCandidate}
   */
  @Test
  public void testIsSrCandidateNewIsSrCandidate() {
    // Arrange and Act
    PrecompiledContracts.IsSrCandidate actualIsSrCandidate = new PrecompiledContracts.IsSrCandidate();

    // Assert
    assertNull(actualIsSrCandidate.getResult());
    assertNull(actualIsSrCandidate.getDeposit());
    assertEquals(0L, actualIsSrCandidate.getVmShouldEndInUs());
    assertFalse(actualIsSrCandidate.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.MerkleHash#execute(byte[])}
   */
  @Test
  public void testMerkleHashExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.MerkleHash merkleHash = new PrecompiledContracts.MerkleHash();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = merkleHash.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals(0, right.length);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test: {@link PrecompiledContracts.MerkleHash#execute(byte[])}
   */
  @Test
  public void testMerkleHashExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.MerkleHash())
        .execute(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals(0, right.length);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test: {@link PrecompiledContracts.MerkleHash#execute(byte[])}
   */
  @Test
  public void testMerkleHashExecute3() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.MerkleHash()).execute(new byte[]{});

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals(0, right.length);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.MerkleHash#getEnergyForData(byte[])}
   */
  @Test
  public void testMerkleHashGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.MerkleHash merkleHash = new PrecompiledContracts.MerkleHash();

    // Act and Assert
    assertEquals(500L, merkleHash.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.MerkleHash}
   */
  @Test
  public void testMerkleHashNewMerkleHash() {
    // Arrange and Act
    PrecompiledContracts.MerkleHash actualMerkleHash = new PrecompiledContracts.MerkleHash();

    // Assert
    assertNull(actualMerkleHash.getResult());
    assertNull(actualMerkleHash.getDeposit());
    assertEquals(0L, actualMerkleHash.getVmShouldEndInUs());
    assertFalse(actualMerkleHash.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.ModExp#execute(byte[])}
   */
  @Test
  public void testModExpExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ModExp modExp = new PrecompiledContracts.ModExp();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = modExp.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals(0, right.length);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test: {@link PrecompiledContracts.ModExp#execute(byte[])}
   */
  @Test
  public void testModExpExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.ModExp()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    byte[] right = actualExecuteResult.getRight();
    assertEquals(0, right.length);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.ModExp#getEnergyForData(byte[])}
   */
  @Test
  public void testModExpGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ModExp modExp = new PrecompiledContracts.ModExp();

    // Act and Assert
    assertEquals(14411570333761358L, modExp.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.ModExp#getEnergyForData(byte[])}
   */
  @Test
  public void testModExpGetEnergyForData2() {
    // Arrange, Act and Assert
    assertEquals(0L, (new PrecompiledContracts.ModExp()).getEnergyForData(null));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.ModExp}
   */
  @Test
  public void testModExpNewModExp() {
    // Arrange and Act
    PrecompiledContracts.ModExp actualModExp = new PrecompiledContracts.ModExp();

    // Assert
    assertNull(actualModExp.getResult());
    assertNull(actualModExp.getDeposit());
    assertEquals(0L, actualModExp.getVmShouldEndInUs());
    assertFalse(actualModExp.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#dataBoolean(boolean)}
   */
  @Test
  public void testPrecompiledContractDataBoolean() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        (new PrecompiledContracts.AvailableUnfreezeV2Size()).dataBoolean(true));
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        (new PrecompiledContracts.AvailableUnfreezeV2Size()).dataBoolean(false));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#dataBoolean(boolean)}
   */
  @Test
  public void testPrecompiledContractDataBoolean2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    deposit.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    availableUnfreezeV2Size.setRepository(deposit);

    // Act
    byte[] actualDataBooleanResult = availableUnfreezeV2Size.dataBoolean(true);

    // Assert
    verify(capsule).getInstance();
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualDataBooleanResult);
  }

  /**
   * Method under test: {@link PrecompiledContracts.PrecompiledContract#dataOne()}
   */
  @Test
  public void testPrecompiledContractDataOne() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        (new PrecompiledContracts.AvailableUnfreezeV2Size()).dataOne());
  }

  /**
   * Method under test: {@link PrecompiledContracts.PrecompiledContract#dataOne()}
   */
  @Test
  public void testPrecompiledContractDataOne2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    deposit.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    availableUnfreezeV2Size.setRepository(deposit);

    // Act
    byte[] actualDataOneResult = availableUnfreezeV2Size.dataOne();

    // Assert
    verify(capsule).getInstance();
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualDataOneResult);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#getCallerAddress()}
   */
  @Test
  public void testPrecompiledContractGetCallerAddress() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    availableUnfreezeV2Size.setCallerAddress("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCallerAddress = availableUnfreezeV2Size.getCallerAddress();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCallerAddress);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#getDeposit()}
   */
  @Test
  public void testPrecompiledContractGetDeposit() {
    // Arrange, Act and Assert
    assertNull((new PrecompiledContracts.AvailableUnfreezeV2Size()).getDeposit());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#getDeposit()}
   */
  @Test
  public void testPrecompiledContractGetDeposit2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    deposit.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    availableUnfreezeV2Size.setRepository(deposit);

    // Act
    Repository actualDeposit = availableUnfreezeV2Size.getDeposit();

    // Assert
    verify(capsule).getInstance();
    assertSame(deposit, actualDeposit);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#getResult()}
   */
  @Test
  public void testPrecompiledContractGetResult() {
    // Arrange, Act and Assert
    assertNull((new PrecompiledContracts.AvailableUnfreezeV2Size()).getResult());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#getResult()}
   */
  @Test
  public void testPrecompiledContractGetResult2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    deposit.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    availableUnfreezeV2Size.setRepository(deposit);

    // Act
    ProgramResult actualResult = availableUnfreezeV2Size.getResult();

    // Assert
    verify(capsule).getInstance();
    assertNull(actualResult);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#getVmShouldEndInUs()}
   */
  @Test
  public void testPrecompiledContractGetVmShouldEndInUs() {
    // Arrange, Act and Assert
    assertEquals(0L, (new PrecompiledContracts.AvailableUnfreezeV2Size()).getVmShouldEndInUs());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#getVmShouldEndInUs()}
   */
  @Test
  public void testPrecompiledContractGetVmShouldEndInUs2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    deposit.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    availableUnfreezeV2Size.setRepository(deposit);

    // Act
    long actualVmShouldEndInUs = availableUnfreezeV2Size.getVmShouldEndInUs();

    // Assert
    verify(capsule).getInstance();
    assertEquals(0L, actualVmShouldEndInUs);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#isConstantCall()}
   */
  @Test
  public void testPrecompiledContractIsConstantCall() {
    // Arrange, Act and Assert
    assertFalse((new PrecompiledContracts.AvailableUnfreezeV2Size()).isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#isConstantCall()}
   */
  @Test
  public void testPrecompiledContractIsConstantCall2() {
    // Arrange
    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    availableUnfreezeV2Size.setConstantCall(true);

    // Act and Assert
    assertTrue(availableUnfreezeV2Size.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#isConstantCall()}
   */
  @Test
  public void testPrecompiledContractIsConstantCall3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    deposit.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    availableUnfreezeV2Size.setRepository(deposit);

    // Act
    boolean actualIsConstantCallResult = availableUnfreezeV2Size.isConstantCall();

    // Assert
    verify(capsule).getInstance();
    assertFalse(actualIsConstantCallResult);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#setCallerAddress(byte[])}
   */
  @Test
  public void testPrecompiledContractSetCallerAddress() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();

    // Act
    availableUnfreezeV2Size.setCallerAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedCallerAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedCallerAddress, availableUnfreezeV2Size.getCallerAddress());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#setConstantCall(boolean)}
   */
  @Test
  public void testPrecompiledContractSetConstantCall() {
    // Arrange
    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();

    // Act
    availableUnfreezeV2Size.setConstantCall(true);

    // Assert
    assertTrue(availableUnfreezeV2Size.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#setConstantCall(boolean)}
   */
  @Test
  public void testPrecompiledContractSetConstantCall2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    deposit.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    availableUnfreezeV2Size.setRepository(deposit);

    // Act
    availableUnfreezeV2Size.setConstantCall(true);

    // Assert
    verify(capsule).getInstance();
    assertTrue(availableUnfreezeV2Size.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#setRepository(Repository)}
   */
  @Test
  public void testPrecompiledContractSetRepository() {
    // Arrange
    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Act
    availableUnfreezeV2Size.setRepository(deposit);

    // Assert
    assertSame(deposit, availableUnfreezeV2Size.getDeposit());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#setRepository(Repository)}
   */
  @Test
  public void testPrecompiledContractSetRepository2() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    deposit.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    // Act
    availableUnfreezeV2Size.setRepository(deposit);

    // Assert
    verify(capsule).getInstance();
    assertSame(deposit, availableUnfreezeV2Size.getDeposit());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#setResult(ProgramResult)}
   */
  @Test
  public void testPrecompiledContractSetResult() {
    // Arrange
    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    ProgramResult result = mock(ProgramResult.class);

    // Act
    availableUnfreezeV2Size.setResult(result);

    // Assert
    assertSame(result, availableUnfreezeV2Size.getResult());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#setVmShouldEndInUs(long)}
   */
  @Test
  public void testPrecompiledContractSetVmShouldEndInUs() {
    // Arrange
    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();

    // Act
    availableUnfreezeV2Size.setVmShouldEndInUs(1L);

    // Assert
    assertEquals(1L, availableUnfreezeV2Size.getVmShouldEndInUs());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.PrecompiledContract#setVmShouldEndInUs(long)}
   */
  @Test
  public void testPrecompiledContractSetVmShouldEndInUs2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    deposit.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    PrecompiledContracts.AvailableUnfreezeV2Size availableUnfreezeV2Size = new PrecompiledContracts.AvailableUnfreezeV2Size();
    availableUnfreezeV2Size.setRepository(deposit);

    // Act
    availableUnfreezeV2Size.setVmShouldEndInUs(1L);

    // Assert
    verify(capsule).getInstance();
    assertEquals(1L, availableUnfreezeV2Size.getVmShouldEndInUs());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.ReceivedVoteCount#execute(byte[])}
   */
  @Test
  public void testReceivedVoteCountExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ReceivedVoteCount receivedVoteCount = new PrecompiledContracts.ReceivedVoteCount();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = receivedVoteCount.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.ReceivedVoteCount#execute(byte[])}
   */
  @Test
  public void testReceivedVoteCountExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.ReceivedVoteCount()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.ReceivedVoteCount#getEnergyForData(byte[])}
   */
  @Test
  public void testReceivedVoteCountGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ReceivedVoteCount receivedVoteCount = new PrecompiledContracts.ReceivedVoteCount();

    // Act and Assert
    assertEquals(20L, receivedVoteCount.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.ReceivedVoteCount}
   */
  @Test
  public void testReceivedVoteCountNewReceivedVoteCount() {
    // Arrange and Act
    PrecompiledContracts.ReceivedVoteCount actualReceivedVoteCount = new PrecompiledContracts.ReceivedVoteCount();

    // Assert
    assertNull(actualReceivedVoteCount.getResult());
    assertNull(actualReceivedVoteCount.getDeposit());
    assertEquals(0L, actualReceivedVoteCount.getVmShouldEndInUs());
    assertFalse(actualReceivedVoteCount.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.ResourceUsage#execute(byte[])}
   */
  @Test
  public void testResourceUsageExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ResourceUsage resourceUsage = new PrecompiledContracts.ResourceUsage();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = resourceUsage.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test: {@link PrecompiledContracts.ResourceUsage#execute(byte[])}
   */
  @Test
  public void testResourceUsageExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.ResourceUsage()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.ResourceUsage#getEnergyForData(byte[])}
   */
  @Test
  public void testResourceUsageGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ResourceUsage resourceUsage = new PrecompiledContracts.ResourceUsage();

    // Act and Assert
    assertEquals(50L, resourceUsage.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.ResourceUsage}
   */
  @Test
  public void testResourceUsageNewResourceUsage() {
    // Arrange and Act
    PrecompiledContracts.ResourceUsage actualResourceUsage = new PrecompiledContracts.ResourceUsage();

    // Assert
    assertNull(actualResourceUsage.getResult());
    assertNull(actualResourceUsage.getDeposit());
    assertEquals(0L, actualResourceUsage.getVmShouldEndInUs());
    assertFalse(actualResourceUsage.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.ResourceV2#execute(byte[])}
   */
  @Test
  public void testResourceV2Execute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ResourceV2 resourceV2 = new PrecompiledContracts.ResourceV2();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = resourceV2.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test: {@link PrecompiledContracts.ResourceV2#execute(byte[])}
   */
  @Test
  public void testResourceV2Execute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.ResourceV2()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.ResourceV2#getEnergyForData(byte[])}
   */
  @Test
  public void testResourceV2GetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ResourceV2 resourceV2 = new PrecompiledContracts.ResourceV2();

    // Act and Assert
    assertEquals(50L, resourceV2.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.ResourceV2}
   */
  @Test
  public void testResourceV2NewResourceV2() {
    // Arrange and Act
    PrecompiledContracts.ResourceV2 actualResourceV2 = new PrecompiledContracts.ResourceV2();

    // Assert
    assertNull(actualResourceV2.getResult());
    assertNull(actualResourceV2.getDeposit());
    assertEquals(0L, actualResourceV2.getVmShouldEndInUs());
    assertFalse(actualResourceV2.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.RewardBalance#execute(byte[])}
   */
  @Test
  public void testRewardBalanceExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.RewardBalance rewardBalance = new PrecompiledContracts.RewardBalance();
    rewardBalance.setCallerAddress("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = rewardBalance.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.RewardBalance#getEnergyForData(byte[])}
   */
  @Test
  public void testRewardBalanceGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.RewardBalance rewardBalance = new PrecompiledContracts.RewardBalance();

    // Act and Assert
    assertEquals(500L, rewardBalance.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.RewardBalance}
   */
  @Test
  public void testRewardBalanceNewRewardBalance() {
    // Arrange and Act
    PrecompiledContracts.RewardBalance actualRewardBalance = new PrecompiledContracts.RewardBalance();

    // Assert
    assertNull(actualRewardBalance.getResult());
    assertNull(actualRewardBalance.getDeposit());
    assertEquals(0L, actualRewardBalance.getVmShouldEndInUs());
    assertFalse(actualRewardBalance.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.Ripempd160#execute(byte[])}
   */
  @Test
  public void testRipempd160Execute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.Ripempd160 ripempd160 = new PrecompiledContracts.Ripempd160();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = ripempd160.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{-14, '`', '\f', 11, -13, 2, 15, 'C', -52, -69, '5', -1, 23, '&', -71, '<', -34, -14,
        -83, -113, -116, -72, '|', -70, -82, -102, 'A', -55, 28, -111, '0', '\r'}, right);
  }

  /**
   * Method under test: {@link PrecompiledContracts.Ripempd160#execute(byte[])}
   */
  @Test
  public void testRipempd160Execute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.Ripempd160()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{2, -39, ')', 'Z', -42, 'x', -55, -109, ':', 'Z', -18, '9', 16, 'P', -59, 25, 'l', -44,
        -115, '"', -47, 15, 'J', -31, '(', -95, '_', -72, 14, -22, -122, -111}, right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.Ripempd160#getEnergyForData(byte[])}
   */
  @Test
  public void testRipempd160GetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.Ripempd160 ripempd160 = new PrecompiledContracts.Ripempd160();

    // Act and Assert
    assertEquals(720L, ripempd160.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.Ripempd160#getEnergyForData(byte[])}
   */
  @Test
  public void testRipempd160GetEnergyForData2() {
    // Arrange, Act and Assert
    assertEquals(600L, (new PrecompiledContracts.Ripempd160()).getEnergyForData(null));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.Ripempd160}
   */
  @Test
  public void testRipempd160NewRipempd160() {
    // Arrange and Act
    PrecompiledContracts.Ripempd160 actualRipempd160 = new PrecompiledContracts.Ripempd160();

    // Assert
    assertNull(actualRipempd160.getResult());
    assertNull(actualRipempd160.getDeposit());
    assertEquals(0L, actualRipempd160.getVmShouldEndInUs());
    assertFalse(actualRipempd160.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.Sha256#execute(byte[])}
   */
  @Test
  public void testSha256Execute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.Sha256 sha256 = new PrecompiledContracts.Sha256();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = sha256.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{'\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
        'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36}, right);
  }

  /**
   * Method under test: {@link PrecompiledContracts.Sha256#execute(byte[])}
   */
  @Test
  public void testSha256Execute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.Sha256()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.Sha256#getEnergyForData(byte[])}
   */
  @Test
  public void testSha256GetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.Sha256 sha256 = new PrecompiledContracts.Sha256();

    // Act and Assert
    assertEquals(72L, sha256.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.Sha256#getEnergyForData(byte[])}
   */
  @Test
  public void testSha256GetEnergyForData2() {
    // Arrange, Act and Assert
    assertEquals(60L, (new PrecompiledContracts.Sha256()).getEnergyForData(null));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.Sha256}
   */
  @Test
  public void testSha256NewSha256() {
    // Arrange and Act
    PrecompiledContracts.Sha256 actualSha256 = new PrecompiledContracts.Sha256();

    // Assert
    assertNull(actualSha256.getResult());
    assertNull(actualSha256.getDeposit());
    assertEquals(0L, actualSha256.getVmShouldEndInUs());
    assertFalse(actualSha256.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.TotalAcquiredResource#execute(byte[])}
   */
  @Test
  public void testTotalAcquiredResourceExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.TotalAcquiredResource totalAcquiredResource = new PrecompiledContracts.TotalAcquiredResource();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = totalAcquiredResource.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.TotalAcquiredResource#execute(byte[])}
   */
  @Test
  public void testTotalAcquiredResourceExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.TotalAcquiredResource()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.TotalAcquiredResource#getEnergyForData(byte[])}
   */
  @Test
  public void testTotalAcquiredResourceGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.TotalAcquiredResource totalAcquiredResource = new PrecompiledContracts.TotalAcquiredResource();

    // Act and Assert
    assertEquals(50L, totalAcquiredResource.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.TotalAcquiredResource}
   */
  @Test
  public void testTotalAcquiredResourceNewTotalAcquiredResource() {
    // Arrange and Act
    PrecompiledContracts.TotalAcquiredResource actualTotalAcquiredResource = new PrecompiledContracts.TotalAcquiredResource();

    // Assert
    assertNull(actualTotalAcquiredResource.getResult());
    assertNull(actualTotalAcquiredResource.getDeposit());
    assertEquals(0L, actualTotalAcquiredResource.getVmShouldEndInUs());
    assertFalse(actualTotalAcquiredResource.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.TotalDelegatedResource#execute(byte[])}
   */
  @Test
  public void testTotalDelegatedResourceExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.TotalDelegatedResource totalDelegatedResource = new PrecompiledContracts.TotalDelegatedResource();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = totalDelegatedResource.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.TotalDelegatedResource#execute(byte[])}
   */
  @Test
  public void testTotalDelegatedResourceExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.TotalDelegatedResource()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.TotalDelegatedResource#getEnergyForData(byte[])}
   */
  @Test
  public void testTotalDelegatedResourceGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.TotalDelegatedResource totalDelegatedResource = new PrecompiledContracts.TotalDelegatedResource();

    // Act and Assert
    assertEquals(50L, totalDelegatedResource.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.TotalDelegatedResource}
   */
  @Test
  public void testTotalDelegatedResourceNewTotalDelegatedResource() {
    // Arrange and Act
    PrecompiledContracts.TotalDelegatedResource actualTotalDelegatedResource = new PrecompiledContracts.TotalDelegatedResource();

    // Assert
    assertNull(actualTotalDelegatedResource.getResult());
    assertNull(actualTotalDelegatedResource.getDeposit());
    assertEquals(0L, actualTotalDelegatedResource.getVmShouldEndInUs());
    assertFalse(actualTotalDelegatedResource.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.TotalResource#execute(byte[])}
   */
  @Test
  public void testTotalResourceExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.TotalResource totalResource = new PrecompiledContracts.TotalResource();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = totalResource.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test: {@link PrecompiledContracts.TotalResource#execute(byte[])}
   */
  @Test
  public void testTotalResourceExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.TotalResource()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.TotalResource#getEnergyForData(byte[])}
   */
  @Test
  public void testTotalResourceGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.TotalResource totalResource = new PrecompiledContracts.TotalResource();

    // Act and Assert
    assertEquals(50L, totalResource.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.TotalResource}
   */
  @Test
  public void testTotalResourceNewTotalResource() {
    // Arrange and Act
    PrecompiledContracts.TotalResource actualTotalResource = new PrecompiledContracts.TotalResource();

    // Assert
    assertNull(actualTotalResource.getResult());
    assertNull(actualTotalResource.getDeposit());
    assertEquals(0L, actualTotalResource.getVmShouldEndInUs());
    assertFalse(actualTotalResource.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.TotalVoteCount#execute(byte[])}
   */
  @Test
  public void testTotalVoteCountExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.TotalVoteCount totalVoteCount = new PrecompiledContracts.TotalVoteCount();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = totalVoteCount.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.TotalVoteCount#execute(byte[])}
   */
  @Test
  public void testTotalVoteCountExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.TotalVoteCount()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.TotalVoteCount#getEnergyForData(byte[])}
   */
  @Test
  public void testTotalVoteCountGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.TotalVoteCount totalVoteCount = new PrecompiledContracts.TotalVoteCount();

    // Act and Assert
    assertEquals(20L, totalVoteCount.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.TotalVoteCount}
   */
  @Test
  public void testTotalVoteCountNewTotalVoteCount() {
    // Arrange and Act
    PrecompiledContracts.TotalVoteCount actualTotalVoteCount = new PrecompiledContracts.TotalVoteCount();

    // Assert
    assertNull(actualTotalVoteCount.getResult());
    assertNull(actualTotalVoteCount.getDeposit());
    assertEquals(0L, actualTotalVoteCount.getVmShouldEndInUs());
    assertFalse(actualTotalVoteCount.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.UnfreezableBalanceV2#execute(byte[])}
   */
  @Test
  public void testUnfreezableBalanceV2Execute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.UnfreezableBalanceV2 unfreezableBalanceV2 = new PrecompiledContracts.UnfreezableBalanceV2();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = unfreezableBalanceV2.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.UnfreezableBalanceV2#execute(byte[])}
   */
  @Test
  public void testUnfreezableBalanceV2Execute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.UnfreezableBalanceV2()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.UnfreezableBalanceV2#getEnergyForData(byte[])}
   */
  @Test
  public void testUnfreezableBalanceV2GetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.UnfreezableBalanceV2 unfreezableBalanceV2 = new PrecompiledContracts.UnfreezableBalanceV2();

    // Act and Assert
    assertEquals(50L, unfreezableBalanceV2.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.UnfreezableBalanceV2}
   */
  @Test
  public void testUnfreezableBalanceV2NewUnfreezableBalanceV2() {
    // Arrange and Act
    PrecompiledContracts.UnfreezableBalanceV2 actualUnfreezableBalanceV2 = new PrecompiledContracts.UnfreezableBalanceV2();

    // Assert
    assertNull(actualUnfreezableBalanceV2.getResult());
    assertNull(actualUnfreezableBalanceV2.getDeposit());
    assertEquals(0L, actualUnfreezableBalanceV2.getVmShouldEndInUs());
    assertFalse(actualUnfreezableBalanceV2.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.UsedVoteCount#execute(byte[])}
   */
  @Test
  public void testUsedVoteCountExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.UsedVoteCount usedVoteCount = new PrecompiledContracts.UsedVoteCount();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = usedVoteCount.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test: {@link PrecompiledContracts.UsedVoteCount#execute(byte[])}
   */
  @Test
  public void testUsedVoteCountExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.UsedVoteCount()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.UsedVoteCount#getEnergyForData(byte[])}
   */
  @Test
  public void testUsedVoteCountGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.UsedVoteCount usedVoteCount = new PrecompiledContracts.UsedVoteCount();

    // Act and Assert
    assertEquals(20L, usedVoteCount.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.UsedVoteCount}
   */
  @Test
  public void testUsedVoteCountNewUsedVoteCount() {
    // Arrange and Act
    PrecompiledContracts.UsedVoteCount actualUsedVoteCount = new PrecompiledContracts.UsedVoteCount();

    // Assert
    assertNull(actualUsedVoteCount.getResult());
    assertNull(actualUsedVoteCount.getDeposit());
    assertEquals(0L, actualUsedVoteCount.getVmShouldEndInUs());
    assertFalse(actualUsedVoteCount.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.ValidateMultiSign#getEnergyForData(byte[])}
   */
  @Test
  public void testValidateMultiSignGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.ValidateMultiSign validateMultiSign = new PrecompiledContracts.ValidateMultiSign();

    // Act and Assert
    assertEquals(-1500L, validateMultiSign.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.ValidateMultiSign}
   */
  @Test
  public void testValidateMultiSignNewValidateMultiSign() {
    // Arrange and Act
    PrecompiledContracts.ValidateMultiSign actualValidateMultiSign = new PrecompiledContracts.ValidateMultiSign();

    // Assert
    assertNull(actualValidateMultiSign.getResult());
    assertNull(actualValidateMultiSign.getDeposit());
    assertEquals(0L, actualValidateMultiSign.getVmShouldEndInUs());
    assertFalse(actualValidateMultiSign.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyBurnProof#execute(byte[])}
   */
  @Test
  public void testVerifyBurnProofExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VerifyBurnProof verifyBurnProof = new PrecompiledContracts.VerifyBurnProof();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = verifyBurnProof.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyBurnProof#execute(byte[])}
   */
  @Test
  public void testVerifyBurnProofExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.VerifyBurnProof()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyBurnProof#getEnergyForData(byte[])}
   */
  @Test
  public void testVerifyBurnProofGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VerifyBurnProof verifyBurnProof = new PrecompiledContracts.VerifyBurnProof();

    // Act and Assert
    assertEquals(150000L, verifyBurnProof.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.VerifyBurnProof}
   */
  @Test
  public void testVerifyBurnProofNewVerifyBurnProof() {
    // Arrange and Act
    PrecompiledContracts.VerifyBurnProof actualVerifyBurnProof = new PrecompiledContracts.VerifyBurnProof();

    // Assert
    assertNull(actualVerifyBurnProof.getResult());
    assertNull(actualVerifyBurnProof.getDeposit());
    assertEquals(0L, actualVerifyBurnProof.getVmShouldEndInUs());
    assertFalse(actualVerifyBurnProof.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyMintProof#execute(byte[])}
   */
  @Test
  public void testVerifyMintProofExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VerifyMintProof verifyMintProof = new PrecompiledContracts.VerifyMintProof();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = verifyMintProof.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyMintProof#execute(byte[])}
   */
  @Test
  public void testVerifyMintProofExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.VerifyMintProof()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyMintProof#getEnergyForData(byte[])}
   */
  @Test
  public void testVerifyMintProofGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VerifyMintProof verifyMintProof = new PrecompiledContracts.VerifyMintProof();

    // Act and Assert
    assertEquals(150000L, verifyMintProof.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.VerifyMintProof}
   */
  @Test
  public void testVerifyMintProofNewVerifyMintProof() {
    // Arrange and Act
    PrecompiledContracts.VerifyMintProof actualVerifyMintProof = new PrecompiledContracts.VerifyMintProof();

    // Assert
    assertNull(actualVerifyMintProof.getResult());
    assertNull(actualVerifyMintProof.getDeposit());
    assertEquals(0L, actualVerifyMintProof.getVmShouldEndInUs());
    assertFalse(actualVerifyMintProof.isConstantCall());
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyProof#insertLeaves(byte[][], long, byte[][])}
   */
  @Test
  public void testVerifyProofInsertLeaves() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VerifyBurnProof verifyBurnProof = new PrecompiledContracts.VerifyBurnProof();

    // Act
    Pair<Boolean, byte[]> actualInsertLeavesResult = verifyBurnProof
        .insertLeaves(new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, 3L, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertTrue(actualInsertLeavesResult instanceof ImmutablePair);
    assertTrue(actualInsertLeavesResult.getKey());
    assertTrue(actualInsertLeavesResult.getLeft());
    byte[] right = actualInsertLeavesResult.getRight();
    assertSame(right, actualInsertLeavesResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyProof#insertLeaves(byte[][], long, byte[][])}
   */
  @Test
  public void testVerifyProofInsertLeaves2() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VerifyBurnProof verifyBurnProof = new PrecompiledContracts.VerifyBurnProof();

    // Act
    Pair<Boolean, byte[]> actualInsertLeavesResult = verifyBurnProof
        .insertLeaves(new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, 32L, new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertTrue(actualInsertLeavesResult instanceof ImmutablePair);
    assertTrue(actualInsertLeavesResult.getKey());
    assertTrue(actualInsertLeavesResult.getLeft());
    byte[] right = actualInsertLeavesResult.getRight();
    assertSame(right, actualInsertLeavesResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyProof#insertLeaves(byte[][], long, byte[][])}
   */
  @Test
  public void testVerifyProofInsertLeaves3() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VerifyBurnProof verifyBurnProof = new PrecompiledContracts.VerifyBurnProof();

    // Act
    Pair<Boolean, byte[]> actualInsertLeavesResult = verifyBurnProof
        .insertLeaves(new byte[][]{"AXAXAXAX".getBytes("UTF-8")}, 3L, new byte[][]{});

    // Assert
    assertTrue(actualInsertLeavesResult instanceof ImmutablePair);
    assertTrue(actualInsertLeavesResult.getKey());
    assertTrue(actualInsertLeavesResult.getLeft());
    byte[] right = actualInsertLeavesResult.getRight();
    assertSame(right, actualInsertLeavesResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyProof#parseInt(byte[], int)}
   */
  @Test
  public void testVerifyProofParseInt() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VerifyBurnProof verifyBurnProof = new PrecompiledContracts.VerifyBurnProof();

    // Act and Assert
    assertEquals(Integer.MAX_VALUE, verifyBurnProof.parseInt("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyProof#parseInt(byte[], int)}
   */
  @Test
  public void testVerifyProofParseInt2() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE,
        (new PrecompiledContracts.VerifyBurnProof()).parseInt(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyProof#parseInt(byte[], int)}
   */
  @Test
  public void testVerifyProofParseInt3() {
    // Arrange, Act and Assert
    assertEquals(0, (new PrecompiledContracts.VerifyBurnProof()).parseInt(new byte[]{}, 1));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyProof#parseLong(byte[], int)}
   */
  @Test
  public void testVerifyProofParseLong() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VerifyBurnProof verifyBurnProof = new PrecompiledContracts.VerifyBurnProof();

    // Act and Assert
    assertEquals(Long.MAX_VALUE, verifyBurnProof.parseLong("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyProof#parseLong(byte[], int)}
   */
  @Test
  public void testVerifyProofParseLong2() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE,
        (new PrecompiledContracts.VerifyBurnProof()).parseLong(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyProof#parseLong(byte[], int)}
   */
  @Test
  public void testVerifyProofParseLong3() {
    // Arrange, Act and Assert
    assertEquals(0L, (new PrecompiledContracts.VerifyBurnProof()).parseLong(new byte[]{}, 1));
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyTransferProof#execute(byte[])}
   */
  @Test
  public void testVerifyTransferProofExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VerifyTransferProof verifyTransferProof = new PrecompiledContracts.VerifyTransferProof();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = verifyTransferProof.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyTransferProof#execute(byte[])}
   */
  @Test
  public void testVerifyTransferProofExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.VerifyTransferProof()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VerifyTransferProof#getEnergyForData(byte[])}
   */
  @Test
  public void testVerifyTransferProofGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VerifyTransferProof verifyTransferProof = new PrecompiledContracts.VerifyTransferProof();

    // Act and Assert
    assertEquals(200000L, verifyTransferProof.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.VerifyTransferProof}
   */
  @Test
  public void testVerifyTransferProofNewVerifyTransferProof() {
    // Arrange and Act
    PrecompiledContracts.VerifyTransferProof actualVerifyTransferProof = new PrecompiledContracts.VerifyTransferProof();

    // Assert
    assertNull(actualVerifyTransferProof.getResult());
    assertNull(actualVerifyTransferProof.getDeposit());
    assertEquals(0L, actualVerifyTransferProof.getVmShouldEndInUs());
    assertFalse(actualVerifyTransferProof.isConstantCall());
  }

  /**
   * Method under test: {@link PrecompiledContracts.VoteCount#execute(byte[])}
   */
  @Test
  public void testVoteCountExecute() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VoteCount voteCount = new PrecompiledContracts.VoteCount();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = voteCount.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test: {@link PrecompiledContracts.VoteCount#execute(byte[])}
   */
  @Test
  public void testVoteCountExecute2() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new PrecompiledContracts.VoteCount()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        right);
  }

  /**
   * Method under test:
   * {@link PrecompiledContracts.VoteCount#getEnergyForData(byte[])}
   */
  @Test
  public void testVoteCountGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    PrecompiledContracts.VoteCount voteCount = new PrecompiledContracts.VoteCount();

    // Act and Assert
    assertEquals(500L, voteCount.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrecompiledContracts.VoteCount}
   */
  @Test
  public void testVoteCountNewVoteCount() {
    // Arrange and Act
    PrecompiledContracts.VoteCount actualVoteCount = new PrecompiledContracts.VoteCount();

    // Assert
    assertNull(actualVoteCount.getResult());
    assertNull(actualVoteCount.getDeposit());
    assertEquals(0L, actualVoteCount.getVmShouldEndInUs());
    assertFalse(actualVoteCount.isConstantCall());
  }
}
