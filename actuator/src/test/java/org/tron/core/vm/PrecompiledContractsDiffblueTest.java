package org.tron.core.vm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.PrecompiledContracts.AvailableUnfreezeV2Size;
import org.tron.core.vm.PrecompiledContracts.BN128Addition;
import org.tron.core.vm.PrecompiledContracts.BN128Multiplication;
import org.tron.core.vm.PrecompiledContracts.BN128Pairing;
import org.tron.core.vm.PrecompiledContracts.BatchValidateSign;
import org.tron.core.vm.PrecompiledContracts.Blake2F;
import org.tron.core.vm.PrecompiledContracts.CheckUnDelegateResource;
import org.tron.core.vm.PrecompiledContracts.DelegatableResource;
import org.tron.core.vm.PrecompiledContracts.ECRecover;
import org.tron.core.vm.PrecompiledContracts.EthRipemd160;
import org.tron.core.vm.PrecompiledContracts.ExpireUnfreezeBalanceV2;
import org.tron.core.vm.PrecompiledContracts.GetChainParameter;
import org.tron.core.vm.PrecompiledContracts.Identity;
import org.tron.core.vm.PrecompiledContracts.IsSrCandidate;
import org.tron.core.vm.PrecompiledContracts.MerkleHash;
import org.tron.core.vm.PrecompiledContracts.ModExp;
import org.tron.core.vm.PrecompiledContracts.PrecompiledContract;
import org.tron.core.vm.PrecompiledContracts.ReceivedVoteCount;
import org.tron.core.vm.PrecompiledContracts.ResourceUsage;
import org.tron.core.vm.PrecompiledContracts.ResourceV2;
import org.tron.core.vm.PrecompiledContracts.RewardBalance;
import org.tron.core.vm.PrecompiledContracts.Ripempd160;
import org.tron.core.vm.PrecompiledContracts.Sha256;
import org.tron.core.vm.PrecompiledContracts.TotalAcquiredResource;
import org.tron.core.vm.PrecompiledContracts.TotalDelegatedResource;
import org.tron.core.vm.PrecompiledContracts.TotalResource;
import org.tron.core.vm.PrecompiledContracts.TotalVoteCount;
import org.tron.core.vm.PrecompiledContracts.UnfreezableBalanceV2;
import org.tron.core.vm.PrecompiledContracts.UsedVoteCount;
import org.tron.core.vm.PrecompiledContracts.ValidateMultiSign;
import org.tron.core.vm.PrecompiledContracts.VerifyBurnProof;
import org.tron.core.vm.PrecompiledContracts.VerifyMintProof;
import org.tron.core.vm.PrecompiledContracts.VerifyProof;
import org.tron.core.vm.PrecompiledContracts.VerifyTransferProof;
import org.tron.core.vm.PrecompiledContracts.VoteCount;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class PrecompiledContractsDiffblueTest {
  /**
   * Test AvailableUnfreezeV2Size {@link AvailableUnfreezeV2Size#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvailableUnfreezeV2Size#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair AvailableUnfreezeV2Size.execute(byte[])"})
  public void testAvailableUnfreezeV2SizeExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    AvailableUnfreezeV2Size availableUnfreezeV2Size = new AvailableUnfreezeV2Size();

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
   * Test AvailableUnfreezeV2Size {@link AvailableUnfreezeV2Size#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvailableUnfreezeV2Size#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair AvailableUnfreezeV2Size.execute(byte[])"})
  public void testAvailableUnfreezeV2SizeExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new AvailableUnfreezeV2Size()).execute(null);

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
   * Test AvailableUnfreezeV2Size {@link AvailableUnfreezeV2Size#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link AvailableUnfreezeV2Size#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long AvailableUnfreezeV2Size.getEnergyForData(byte[])"})
  public void testAvailableUnfreezeV2SizeGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    AvailableUnfreezeV2Size availableUnfreezeV2Size = new AvailableUnfreezeV2Size();

    // Act and Assert
    assertEquals(50L, availableUnfreezeV2Size.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test AvailableUnfreezeV2Size new {@link AvailableUnfreezeV2Size} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AvailableUnfreezeV2Size}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AvailableUnfreezeV2Size.<init>()"})
  public void testAvailableUnfreezeV2SizeNewAvailableUnfreezeV2Size() {
    // Arrange and Act
    AvailableUnfreezeV2Size actualAvailableUnfreezeV2Size = new AvailableUnfreezeV2Size();

    // Assert
    assertNull(actualAvailableUnfreezeV2Size.getResult());
    assertNull(actualAvailableUnfreezeV2Size.getDeposit());
    assertEquals(0L, actualAvailableUnfreezeV2Size.getVmShouldEndInUs());
    assertFalse(actualAvailableUnfreezeV2Size.isConstantCall());
  }

  /**
   * Test BN128Addition {@link BN128Addition#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return not Key.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128Addition#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair BN128Addition.execute(byte[])"})
  public void testBN128AdditionExecute_whenAxaxaxaxBytesIsUtf8_thenReturnNotKey() throws UnsupportedEncodingException {
    // Arrange
    BN128Addition bn128Addition = new BN128Addition();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = bn128Addition.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{}, right);
  }

  /**
   * Test BN128Addition {@link BN128Addition#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Key.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128Addition#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair BN128Addition.execute(byte[])"})
  public void testBN128AdditionExecute_whenNull_thenReturnKey() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new BN128Addition()).execute(null);

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
   * Test BN128Addition {@link BN128Addition#execute(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return not Key.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128Addition#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair BN128Addition.execute(byte[])"})
  public void testBN128AdditionExecute_whenXaxaxaxBytesIsUtf8_thenReturnNotKey() throws UnsupportedEncodingException {
    // Arrange
    BN128Addition bn128Addition = new BN128Addition();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = bn128Addition.execute(" XAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{}, right);
  }

  /**
   * Test BN128Addition {@link BN128Addition#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link BN128Addition#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BN128Addition.getEnergyForData(byte[])"})
  public void testBN128AdditionGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    BN128Addition bn128Addition = new BN128Addition();

    // Act and Assert
    assertEquals(500L, bn128Addition.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test BN128Addition new {@link BN128Addition} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BN128Addition}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BN128Addition.<init>()"})
  public void testBN128AdditionNewBN128Addition() {
    // Arrange and Act
    BN128Addition actualBn128Addition = new BN128Addition();

    // Assert
    assertNull(actualBn128Addition.getResult());
    assertNull(actualBn128Addition.getDeposit());
    assertEquals(0L, actualBn128Addition.getVmShouldEndInUs());
    assertFalse(actualBn128Addition.isConstantCall());
  }

  /**
   * Test BN128Multiplication {@link BN128Multiplication#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return not Key.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128Multiplication#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair BN128Multiplication.execute(byte[])"})
  public void testBN128MultiplicationExecute_whenAxaxaxaxBytesIsUtf8_thenReturnNotKey()
      throws UnsupportedEncodingException {
    // Arrange
    BN128Multiplication bn128Multiplication = new BN128Multiplication();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = bn128Multiplication.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{}, right);
  }

  /**
   * Test BN128Multiplication {@link BN128Multiplication#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Key.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128Multiplication#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair BN128Multiplication.execute(byte[])"})
  public void testBN128MultiplicationExecute_whenNull_thenReturnKey() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new BN128Multiplication()).execute(null);

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
   * Test BN128Multiplication {@link BN128Multiplication#execute(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return not Key.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128Multiplication#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair BN128Multiplication.execute(byte[])"})
  public void testBN128MultiplicationExecute_whenXaxaxaxBytesIsUtf8_thenReturnNotKey()
      throws UnsupportedEncodingException {
    // Arrange
    BN128Multiplication bn128Multiplication = new BN128Multiplication();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = bn128Multiplication.execute(" XAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{}, right);
  }

  /**
   * Test BN128Multiplication {@link BN128Multiplication#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link BN128Multiplication#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BN128Multiplication.getEnergyForData(byte[])"})
  public void testBN128MultiplicationGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    BN128Multiplication bn128Multiplication = new BN128Multiplication();

    // Act and Assert
    assertEquals(40000L, bn128Multiplication.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test BN128Multiplication new {@link BN128Multiplication} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BN128Multiplication}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BN128Multiplication.<init>()"})
  public void testBN128MultiplicationNewBN128Multiplication() {
    // Arrange and Act
    BN128Multiplication actualBn128Multiplication = new BN128Multiplication();

    // Assert
    assertNull(actualBn128Multiplication.getResult());
    assertNull(actualBn128Multiplication.getDeposit());
    assertEquals(0L, actualBn128Multiplication.getVmShouldEndInUs());
    assertFalse(actualBn128Multiplication.isConstantCall());
  }

  /**
   * Test BN128Pairing {@link BN128Pairing#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return not Key.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128Pairing#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair BN128Pairing.execute(byte[])"})
  public void testBN128PairingExecute_whenAxaxaxaxBytesIsUtf8_thenReturnNotKey() throws UnsupportedEncodingException {
    // Arrange
    BN128Pairing bn128Pairing = new BN128Pairing();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = bn128Pairing.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{}, right);
  }

  /**
   * Test BN128Pairing {@link BN128Pairing#execute(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Key.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128Pairing#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair BN128Pairing.execute(byte[])"})
  public void testBN128PairingExecute_whenEmptyArrayOfByte_thenReturnKey() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new BN128Pairing()).execute(new byte[]{});

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
   * Test BN128Pairing {@link BN128Pairing#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Key.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128Pairing#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair BN128Pairing.execute(byte[])"})
  public void testBN128PairingExecute_whenNull_thenReturnKey() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new BN128Pairing()).execute(null);

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
   * Test BN128Pairing {@link BN128Pairing#getEnergyForData(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128Pairing#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BN128Pairing.getEnergyForData(byte[])"})
  public void testBN128PairingGetEnergyForData_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    BN128Pairing bn128Pairing = new BN128Pairing();

    // Act and Assert
    assertEquals(100000L, bn128Pairing.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test BN128Pairing {@link BN128Pairing#getEnergyForData(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128Pairing#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BN128Pairing.getEnergyForData(byte[])"})
  public void testBN128PairingGetEnergyForData_whenNull() {
    // Arrange, Act and Assert
    assertEquals(100000L, (new BN128Pairing()).getEnergyForData(null));
  }

  /**
   * Test BN128Pairing new {@link BN128Pairing} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BN128Pairing}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BN128Pairing.<init>()"})
  public void testBN128PairingNewBN128Pairing() {
    // Arrange and Act
    BN128Pairing actualBn128Pairing = new BN128Pairing();

    // Assert
    assertNull(actualBn128Pairing.getResult());
    assertNull(actualBn128Pairing.getDeposit());
    assertEquals(0L, actualBn128Pairing.getVmShouldEndInUs());
    assertFalse(actualBn128Pairing.isConstantCall());
  }

  /**
   * Test BatchValidateSign {@link BatchValidateSign#execute(byte[])}.
   * <p>
   * Method under test: {@link BatchValidateSign#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair BatchValidateSign.execute(byte[])"})
  public void testBatchValidateSignExecute() throws UnsupportedEncodingException {
    // Arrange
    BatchValidateSign batchValidateSign = new BatchValidateSign();

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
   * Test BatchValidateSign {@link BatchValidateSign#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link BatchValidateSign#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BatchValidateSign.getEnergyForData(byte[])"})
  public void testBatchValidateSignGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    BatchValidateSign batchValidateSign = new BatchValidateSign();

    // Act and Assert
    assertEquals(0L, batchValidateSign.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test BatchValidateSign new {@link BatchValidateSign} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BatchValidateSign}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BatchValidateSign.<init>()"})
  public void testBatchValidateSignNewBatchValidateSign() {
    // Arrange and Act
    BatchValidateSign actualBatchValidateSign = new BatchValidateSign();

    // Assert
    assertNull(actualBatchValidateSign.getResult());
    assertNull(actualBatchValidateSign.getDeposit());
    assertEquals(0L, actualBatchValidateSign.getVmShouldEndInUs());
    assertFalse(actualBatchValidateSign.isConstantCall());
  }

  /**
   * Test Blake2F {@link Blake2F#execute(byte[])}.
   * <p>
   * Method under test: {@link Blake2F#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair Blake2F.execute(byte[])"})
  public void testBlake2FExecute() throws UnsupportedEncodingException {
    // Arrange
    Blake2F blake2F = new Blake2F();

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
   * Test Blake2F {@link Blake2F#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link Blake2F#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Blake2F.getEnergyForData(byte[])"})
  public void testBlake2FGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    Blake2F blake2F = new Blake2F();

    // Act and Assert
    assertEquals(0L, blake2F.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Blake2F new {@link Blake2F} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Blake2F}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Blake2F.<init>()"})
  public void testBlake2FNewBlake2F() {
    // Arrange and Act
    Blake2F actualBlake2F = new Blake2F();

    // Assert
    assertNull(actualBlake2F.getResult());
    assertNull(actualBlake2F.getDeposit());
    assertEquals(0L, actualBlake2F.getVmShouldEndInUs());
    assertFalse(actualBlake2F.isConstantCall());
  }

  /**
   * Test CheckUnDelegateResource {@link CheckUnDelegateResource#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckUnDelegateResource#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair CheckUnDelegateResource.execute(byte[])"})
  public void testCheckUnDelegateResourceExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    CheckUnDelegateResource checkUnDelegateResource = new CheckUnDelegateResource();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = checkUnDelegateResource.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertEquals(Op.PUSH1, right.length);
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Test CheckUnDelegateResource {@link CheckUnDelegateResource#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckUnDelegateResource#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair CheckUnDelegateResource.execute(byte[])"})
  public void testCheckUnDelegateResourceExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new CheckUnDelegateResource()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertEquals(Op.PUSH1, right.length);
    assertSame(right, actualExecuteResult.getValue());
  }

  /**
   * Test CheckUnDelegateResource {@link CheckUnDelegateResource#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link CheckUnDelegateResource#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long CheckUnDelegateResource.getEnergyForData(byte[])"})
  public void testCheckUnDelegateResourceGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    CheckUnDelegateResource checkUnDelegateResource = new CheckUnDelegateResource();

    // Act and Assert
    assertEquals(50L, checkUnDelegateResource.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test CheckUnDelegateResource new {@link CheckUnDelegateResource} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CheckUnDelegateResource}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CheckUnDelegateResource.<init>()"})
  public void testCheckUnDelegateResourceNewCheckUnDelegateResource() {
    // Arrange and Act
    CheckUnDelegateResource actualCheckUnDelegateResource = new CheckUnDelegateResource();

    // Assert
    assertNull(actualCheckUnDelegateResource.getResult());
    assertNull(actualCheckUnDelegateResource.getDeposit());
    assertEquals(0L, actualCheckUnDelegateResource.getVmShouldEndInUs());
    assertFalse(actualCheckUnDelegateResource.isConstantCall());
  }

  /**
   * Test DelegatableResource {@link DelegatableResource#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatableResource#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair DelegatableResource.execute(byte[])"})
  public void testDelegatableResourceExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    DelegatableResource delegatableResource = new DelegatableResource();

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
   * Test DelegatableResource {@link DelegatableResource#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatableResource#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair DelegatableResource.execute(byte[])"})
  public void testDelegatableResourceExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new DelegatableResource()).execute(null);

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
   * Test DelegatableResource {@link DelegatableResource#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link DelegatableResource#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DelegatableResource.getEnergyForData(byte[])"})
  public void testDelegatableResourceGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    DelegatableResource delegatableResource = new DelegatableResource();

    // Act and Assert
    assertEquals(50L, delegatableResource.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test DelegatableResource new {@link DelegatableResource} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link DelegatableResource}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatableResource.<init>()"})
  public void testDelegatableResourceNewDelegatableResource() {
    // Arrange and Act
    DelegatableResource actualDelegatableResource = new DelegatableResource();

    // Assert
    assertNull(actualDelegatableResource.getResult());
    assertNull(actualDelegatableResource.getDeposit());
    assertEquals(0L, actualDelegatableResource.getVmShouldEndInUs());
    assertFalse(actualDelegatableResource.isConstantCall());
  }

  /**
   * Test ECRecover {@link ECRecover#execute(byte[])}.
   * <p>
   * Method under test: {@link ECRecover#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair ECRecover.execute(byte[])"})
  public void testECRecoverExecute() throws UnsupportedEncodingException {
    // Arrange
    ECRecover ecRecover = new ECRecover();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = ecRecover.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{}, right);
  }

  /**
   * Test ECRecover {@link ECRecover#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link ECRecover#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ECRecover.getEnergyForData(byte[])"})
  public void testECRecoverGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    ECRecover ecRecover = new ECRecover();

    // Act and Assert
    assertEquals(3000L, ecRecover.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test ECRecover new {@link ECRecover} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ECRecover}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECRecover.<init>()"})
  public void testECRecoverNewECRecover() {
    // Arrange and Act
    ECRecover actualEcRecover = new ECRecover();

    // Assert
    assertNull(actualEcRecover.getResult());
    assertNull(actualEcRecover.getDeposit());
    assertEquals(0L, actualEcRecover.getVmShouldEndInUs());
    assertFalse(actualEcRecover.isConstantCall());
  }

  /**
   * Test EthRipemd160 {@link EthRipemd160#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EthRipemd160#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair EthRipemd160.execute(byte[])"})
  public void testEthRipemd160Execute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    EthRipemd160 ethRipemd160 = new EthRipemd160();

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
   * Test EthRipemd160 {@link EthRipemd160#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EthRipemd160#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair EthRipemd160.execute(byte[])"})
  public void testEthRipemd160Execute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new EthRipemd160()).execute(null);

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
   * Test EthRipemd160 {@link EthRipemd160#getEnergyForData(byte[])}.
   * <ul>
   *   <li>Then return seven hundred twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EthRipemd160#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EthRipemd160.getEnergyForData(byte[])"})
  public void testEthRipemd160GetEnergyForData_thenReturnSevenHundredTwenty() throws UnsupportedEncodingException {
    // Arrange
    EthRipemd160 ethRipemd160 = new EthRipemd160();

    // Act and Assert
    assertEquals(720L, ethRipemd160.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test EthRipemd160 {@link EthRipemd160#getEnergyForData(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return six hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link EthRipemd160#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EthRipemd160.getEnergyForData(byte[])"})
  public void testEthRipemd160GetEnergyForData_whenNull_thenReturnSixHundred() {
    // Arrange, Act and Assert
    assertEquals(600L, (new EthRipemd160()).getEnergyForData(null));
  }

  /**
   * Test EthRipemd160 new {@link EthRipemd160} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link EthRipemd160}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EthRipemd160.<init>()"})
  public void testEthRipemd160NewEthRipemd160() {
    // Arrange and Act
    EthRipemd160 actualEthRipemd160 = new EthRipemd160();

    // Assert
    assertNull(actualEthRipemd160.getResult());
    assertNull(actualEthRipemd160.getDeposit());
    assertEquals(0L, actualEthRipemd160.getVmShouldEndInUs());
    assertFalse(actualEthRipemd160.isConstantCall());
  }

  /**
   * Test ExpireUnfreezeBalanceV2 {@link ExpireUnfreezeBalanceV2#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpireUnfreezeBalanceV2#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair ExpireUnfreezeBalanceV2.execute(byte[])"})
  public void testExpireUnfreezeBalanceV2Execute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ExpireUnfreezeBalanceV2 expireUnfreezeBalanceV2 = new ExpireUnfreezeBalanceV2();

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
   * Test ExpireUnfreezeBalanceV2 {@link ExpireUnfreezeBalanceV2#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpireUnfreezeBalanceV2#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair ExpireUnfreezeBalanceV2.execute(byte[])"})
  public void testExpireUnfreezeBalanceV2Execute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new ExpireUnfreezeBalanceV2()).execute(null);

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
   * Test ExpireUnfreezeBalanceV2 {@link ExpireUnfreezeBalanceV2#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link ExpireUnfreezeBalanceV2#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExpireUnfreezeBalanceV2.getEnergyForData(byte[])"})
  public void testExpireUnfreezeBalanceV2GetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    ExpireUnfreezeBalanceV2 expireUnfreezeBalanceV2 = new ExpireUnfreezeBalanceV2();

    // Act and Assert
    assertEquals(50L, expireUnfreezeBalanceV2.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test ExpireUnfreezeBalanceV2 new {@link ExpireUnfreezeBalanceV2} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ExpireUnfreezeBalanceV2}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpireUnfreezeBalanceV2.<init>()"})
  public void testExpireUnfreezeBalanceV2NewExpireUnfreezeBalanceV2() {
    // Arrange and Act
    ExpireUnfreezeBalanceV2 actualExpireUnfreezeBalanceV2 = new ExpireUnfreezeBalanceV2();

    // Assert
    assertNull(actualExpireUnfreezeBalanceV2.getResult());
    assertNull(actualExpireUnfreezeBalanceV2.getDeposit());
    assertEquals(0L, actualExpireUnfreezeBalanceV2.getVmShouldEndInUs());
    assertFalse(actualExpireUnfreezeBalanceV2.isConstantCall());
  }

  /**
   * Test GetChainParameter {@link GetChainParameter#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetChainParameter#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair GetChainParameter.execute(byte[])"})
  public void testGetChainParameterExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    GetChainParameter getChainParameter = new GetChainParameter();

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
   * Test GetChainParameter {@link GetChainParameter#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetChainParameter#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair GetChainParameter.execute(byte[])"})
  public void testGetChainParameterExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new GetChainParameter()).execute(null);

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
   * Test GetChainParameter {@link GetChainParameter#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link GetChainParameter#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long GetChainParameter.getEnergyForData(byte[])"})
  public void testGetChainParameterGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    GetChainParameter getChainParameter = new GetChainParameter();

    // Act and Assert
    assertEquals(50L, getChainParameter.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test GetChainParameter new {@link GetChainParameter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link GetChainParameter}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetChainParameter.<init>()"})
  public void testGetChainParameterNewGetChainParameter() {
    // Arrange and Act
    GetChainParameter actualGetChainParameter = new GetChainParameter();

    // Assert
    assertNull(actualGetChainParameter.getResult());
    assertNull(actualGetChainParameter.getDeposit());
    assertEquals(0L, actualGetChainParameter.getVmShouldEndInUs());
    assertFalse(actualGetChainParameter.isConstantCall());
  }

  /**
   * Test {@link PrecompiledContracts#getOptimizedContractForConstant(PrecompiledContract)}.
   * <ul>
   *   <li>Then return {@link AvailableUnfreezeV2Size}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompiledContracts#getOptimizedContractForConstant(PrecompiledContract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PrecompiledContract PrecompiledContracts.getOptimizedContractForConstant(PrecompiledContract)"})
  public void testGetOptimizedContractForConstant_thenReturnAvailableUnfreezeV2Size() {
    // Arrange and Act
    PrecompiledContract actualOptimizedContractForConstant = PrecompiledContracts
        .getOptimizedContractForConstant(new AvailableUnfreezeV2Size());

    // Assert
    assertTrue(actualOptimizedContractForConstant instanceof AvailableUnfreezeV2Size);
    assertNull(actualOptimizedContractForConstant.getResult());
    assertNull(actualOptimizedContractForConstant.getDeposit());
    assertEquals(0L, actualOptimizedContractForConstant.getVmShouldEndInUs());
    assertFalse(actualOptimizedContractForConstant.isConstantCall());
  }

  /**
   * Test {@link PrecompiledContracts#getContractForAddress(DataWord)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When ZERO exp ZERO.</li>
   *   <li>Then return {@link ECRecover}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompiledContracts#getContractForAddress(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PrecompiledContract PrecompiledContracts.getContractForAddress(DataWord)"})
  public void testGetContractForAddress_givenZero_whenZeroExpZero_thenReturnECRecover() {
    // Arrange
    DataWord address = DataWord.ZERO();
    address.exp(DataWord.ZERO());

    // Act
    PrecompiledContract actualContractForAddress = PrecompiledContracts.getContractForAddress(address);

    // Assert
    assertTrue(actualContractForAddress instanceof ECRecover);
    assertNull(actualContractForAddress.getResult());
    assertNull(actualContractForAddress.getDeposit());
    assertEquals(0L, actualContractForAddress.getVmShouldEndInUs());
    assertFalse(actualContractForAddress.isConstantCall());
  }

  /**
   * Test {@link PrecompiledContracts#getContractForAddress(DataWord)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Identity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompiledContracts#getContractForAddress(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PrecompiledContract PrecompiledContracts.getContractForAddress(DataWord)"})
  public void testGetContractForAddress_whenNull_thenReturnIdentity() {
    // Arrange and Act
    PrecompiledContract actualContractForAddress = PrecompiledContracts.getContractForAddress(null);

    // Assert
    assertTrue(actualContractForAddress instanceof Identity);
    assertNull(actualContractForAddress.getResult());
    assertNull(actualContractForAddress.getDeposit());
    assertEquals(0L, actualContractForAddress.getVmShouldEndInUs());
    assertFalse(actualContractForAddress.isConstantCall());
  }

  /**
   * Test {@link PrecompiledContracts#getContractForAddress(DataWord)}.
   * <ul>
   *   <li>When ZERO.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompiledContracts#getContractForAddress(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PrecompiledContract PrecompiledContracts.getContractForAddress(DataWord)"})
  public void testGetContractForAddress_whenZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PrecompiledContracts.getContractForAddress(DataWord.ZERO()));
  }

  /**
   * Test Identity {@link Identity#execute(byte[])}.
   * <p>
   * Method under test: {@link Identity#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair Identity.execute(byte[])"})
  public void testIdentityExecute() throws UnsupportedEncodingException {
    // Arrange
    Identity identity = new Identity();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = identity.execute(data);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    assertSame(data, actualExecuteResult.getValue());
    byte[] expectedRight = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedRight, actualExecuteResult.getRight());
  }

  /**
   * Test Identity {@link Identity#getEnergyForData(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return eighteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link Identity#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Identity.getEnergyForData(byte[])"})
  public void testIdentityGetEnergyForData_whenAxaxaxaxBytesIsUtf8_thenReturnEighteen()
      throws UnsupportedEncodingException {
    // Arrange
    Identity identity = new Identity();

    // Act and Assert
    assertEquals(18L, identity.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Identity {@link Identity#getEnergyForData(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link Identity#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Identity.getEnergyForData(byte[])"})
  public void testIdentityGetEnergyForData_whenNull_thenReturnFifteen() {
    // Arrange, Act and Assert
    assertEquals(15L, (new Identity()).getEnergyForData(null));
  }

  /**
   * Test Identity new {@link Identity} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Identity}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Identity.<init>()"})
  public void testIdentityNewIdentity() {
    // Arrange and Act
    Identity actualIdentity = new Identity();

    // Assert
    assertNull(actualIdentity.getResult());
    assertNull(actualIdentity.getDeposit());
    assertEquals(0L, actualIdentity.getVmShouldEndInUs());
    assertFalse(actualIdentity.isConstantCall());
  }

  /**
   * Test IsSrCandidate {@link IsSrCandidate#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IsSrCandidate#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair IsSrCandidate.execute(byte[])"})
  public void testIsSrCandidateExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    IsSrCandidate isSrCandidate = new IsSrCandidate();

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
   * Test IsSrCandidate {@link IsSrCandidate#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IsSrCandidate#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair IsSrCandidate.execute(byte[])"})
  public void testIsSrCandidateExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new IsSrCandidate()).execute(null);

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
   * Test IsSrCandidate {@link IsSrCandidate#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link IsSrCandidate#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long IsSrCandidate.getEnergyForData(byte[])"})
  public void testIsSrCandidateGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    IsSrCandidate isSrCandidate = new IsSrCandidate();

    // Act and Assert
    assertEquals(20L, isSrCandidate.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test IsSrCandidate new {@link IsSrCandidate} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link IsSrCandidate}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IsSrCandidate.<init>()"})
  public void testIsSrCandidateNewIsSrCandidate() {
    // Arrange and Act
    IsSrCandidate actualIsSrCandidate = new IsSrCandidate();

    // Assert
    assertNull(actualIsSrCandidate.getResult());
    assertNull(actualIsSrCandidate.getDeposit());
    assertEquals(0L, actualIsSrCandidate.getVmShouldEndInUs());
    assertFalse(actualIsSrCandidate.isConstantCall());
  }

  /**
   * Test MerkleHash {@link MerkleHash#execute(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerkleHash#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair MerkleHash.execute(byte[])"})
  public void testMerkleHashExecute_whenA() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new MerkleHash())
        .execute(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{}, right);
  }

  /**
   * Test MerkleHash {@link MerkleHash#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerkleHash#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair MerkleHash.execute(byte[])"})
  public void testMerkleHashExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    MerkleHash merkleHash = new MerkleHash();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = merkleHash.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{}, right);
  }

  /**
   * Test MerkleHash {@link MerkleHash#execute(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerkleHash#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair MerkleHash.execute(byte[])"})
  public void testMerkleHashExecute_whenEmptyArrayOfByte() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new MerkleHash()).execute(new byte[]{});

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertFalse(actualExecuteResult.getKey());
    assertFalse(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{}, right);
  }

  /**
   * Test MerkleHash {@link MerkleHash#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link MerkleHash#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MerkleHash.getEnergyForData(byte[])"})
  public void testMerkleHashGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    MerkleHash merkleHash = new MerkleHash();

    // Act and Assert
    assertEquals(500L, merkleHash.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test MerkleHash new {@link MerkleHash} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link MerkleHash}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MerkleHash.<init>()"})
  public void testMerkleHashNewMerkleHash() {
    // Arrange and Act
    MerkleHash actualMerkleHash = new MerkleHash();

    // Assert
    assertNull(actualMerkleHash.getResult());
    assertNull(actualMerkleHash.getDeposit());
    assertEquals(0L, actualMerkleHash.getVmShouldEndInUs());
    assertFalse(actualMerkleHash.isConstantCall());
  }

  /**
   * Test ModExp {@link ModExp#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModExp#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair ModExp.execute(byte[])"})
  public void testModExpExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ModExp modExp = new ModExp();

    // Act
    Pair<Boolean, byte[]> actualExecuteResult = modExp.execute("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{}, right);
  }

  /**
   * Test ModExp {@link ModExp#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModExp#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair ModExp.execute(byte[])"})
  public void testModExpExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new ModExp()).execute(null);

    // Assert
    assertTrue(actualExecuteResult instanceof ImmutablePair);
    assertTrue(actualExecuteResult.getKey());
    assertTrue(actualExecuteResult.getLeft());
    byte[] right = actualExecuteResult.getRight();
    assertSame(right, actualExecuteResult.getValue());
    assertArrayEquals(new byte[]{}, right);
  }

  /**
   * Test ModExp {@link ModExp#getEnergyForData(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 14411570333761358}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModExp#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ModExp.getEnergyForData(byte[])"})
  public void testModExpGetEnergyForData_whenAxaxaxaxBytesIsUtf8_thenReturn14411570333761358()
      throws UnsupportedEncodingException {
    // Arrange
    ModExp modExp = new ModExp();

    // Act and Assert
    assertEquals(14411570333761358L, modExp.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test ModExp {@link ModExp#getEnergyForData(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModExp#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ModExp.getEnergyForData(byte[])"})
  public void testModExpGetEnergyForData_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ModExp()).getEnergyForData(null));
  }

  /**
   * Test ModExp new {@link ModExp} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ModExp}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ModExp.<init>()"})
  public void testModExpNewModExp() {
    // Arrange and Act
    ModExp actualModExp = new ModExp();

    // Assert
    assertNull(actualModExp.getResult());
    assertNull(actualModExp.getDeposit());
    assertEquals(0L, actualModExp.getVmShouldEndInUs());
    assertFalse(actualModExp.isConstantCall());
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#dataBoolean(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompiledContract#dataBoolean(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PrecompiledContract.dataBoolean(boolean)"})
  public void testPrecompiledContractDataBoolean_whenFalse() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        (new AvailableUnfreezeV2Size()).dataBoolean(false));
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#dataBoolean(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompiledContract#dataBoolean(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PrecompiledContract.dataBoolean(boolean)"})
  public void testPrecompiledContractDataBoolean_whenTrue() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        (new AvailableUnfreezeV2Size()).dataBoolean(true));
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#dataOne()}.
   * <p>
   * Method under test: {@link PrecompiledContract#dataOne()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PrecompiledContract.dataOne()"})
  public void testPrecompiledContractDataOne() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        (new AvailableUnfreezeV2Size()).dataOne());
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#getCallerAddress()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompiledContract#getCallerAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PrecompiledContract.getCallerAddress()"})
  public void testPrecompiledContractGetCallerAddress_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    AvailableUnfreezeV2Size availableUnfreezeV2Size = new AvailableUnfreezeV2Size();
    availableUnfreezeV2Size.setCallerAddress("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCallerAddress = availableUnfreezeV2Size.getCallerAddress();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCallerAddress);
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#getDeposit()}.
   * <p>
   * Method under test: {@link PrecompiledContract#getDeposit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Repository PrecompiledContract.getDeposit()"})
  public void testPrecompiledContractGetDeposit() {
    // Arrange, Act and Assert
    assertNull((new AvailableUnfreezeV2Size()).getDeposit());
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#getResult()}.
   * <p>
   * Method under test: {@link PrecompiledContract#getResult()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.runtime.ProgramResult PrecompiledContract.getResult()"})
  public void testPrecompiledContractGetResult() {
    // Arrange, Act and Assert
    assertNull((new AvailableUnfreezeV2Size()).getResult());
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#getVmShouldEndInUs()}.
   * <p>
   * Method under test: {@link PrecompiledContract#getVmShouldEndInUs()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long PrecompiledContract.getVmShouldEndInUs()"})
  public void testPrecompiledContractGetVmShouldEndInUs() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AvailableUnfreezeV2Size()).getVmShouldEndInUs());
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#isConstantCall()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompiledContract#isConstantCall()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrecompiledContract.isConstantCall()"})
  public void testPrecompiledContractIsConstantCall_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AvailableUnfreezeV2Size()).isConstantCall());
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#isConstantCall()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompiledContract#isConstantCall()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrecompiledContract.isConstantCall()"})
  public void testPrecompiledContractIsConstantCall_thenReturnTrue() {
    // Arrange
    AvailableUnfreezeV2Size availableUnfreezeV2Size = new AvailableUnfreezeV2Size();
    availableUnfreezeV2Size.setConstantCall(true);

    // Act and Assert
    assertTrue(availableUnfreezeV2Size.isConstantCall());
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#setCallerAddress(byte[])}.
   * <p>
   * Method under test: {@link PrecompiledContract#setCallerAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PrecompiledContract.setCallerAddress(byte[])"})
  public void testPrecompiledContractSetCallerAddress() throws UnsupportedEncodingException {
    // Arrange
    AvailableUnfreezeV2Size availableUnfreezeV2Size = new AvailableUnfreezeV2Size();

    // Act
    availableUnfreezeV2Size.setCallerAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedCallerAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedCallerAddress, availableUnfreezeV2Size.getCallerAddress());
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#setConstantCall(boolean)}.
   * <p>
   * Method under test: {@link PrecompiledContract#setConstantCall(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PrecompiledContract.setConstantCall(boolean)"})
  public void testPrecompiledContractSetConstantCall() {
    // Arrange
    AvailableUnfreezeV2Size availableUnfreezeV2Size = new AvailableUnfreezeV2Size();

    // Act
    availableUnfreezeV2Size.setConstantCall(true);

    // Assert
    assertTrue(availableUnfreezeV2Size.isConstantCall());
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#setRepository(Repository)}.
   * <p>
   * Method under test: {@link PrecompiledContract#setRepository(Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PrecompiledContract.setRepository(Repository)"})
  public void testPrecompiledContractSetRepository() {
    // Arrange
    AvailableUnfreezeV2Size availableUnfreezeV2Size = new AvailableUnfreezeV2Size();
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Act
    availableUnfreezeV2Size.setRepository(deposit);

    // Assert
    assertSame(deposit, availableUnfreezeV2Size.getDeposit());
  }

  /**
   * Test PrecompiledContract {@link PrecompiledContract#setVmShouldEndInUs(long)}.
   * <p>
   * Method under test: {@link PrecompiledContract#setVmShouldEndInUs(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PrecompiledContract.setVmShouldEndInUs(long)"})
  public void testPrecompiledContractSetVmShouldEndInUs() {
    // Arrange
    AvailableUnfreezeV2Size availableUnfreezeV2Size = new AvailableUnfreezeV2Size();

    // Act
    availableUnfreezeV2Size.setVmShouldEndInUs(1L);

    // Assert
    assertEquals(1L, availableUnfreezeV2Size.getVmShouldEndInUs());
  }

  /**
   * Test ReceivedVoteCount {@link ReceivedVoteCount#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceivedVoteCount#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair ReceivedVoteCount.execute(byte[])"})
  public void testReceivedVoteCountExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ReceivedVoteCount receivedVoteCount = new ReceivedVoteCount();

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
   * Test ReceivedVoteCount {@link ReceivedVoteCount#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceivedVoteCount#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair ReceivedVoteCount.execute(byte[])"})
  public void testReceivedVoteCountExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new ReceivedVoteCount()).execute(null);

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
   * Test ReceivedVoteCount {@link ReceivedVoteCount#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link ReceivedVoteCount#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ReceivedVoteCount.getEnergyForData(byte[])"})
  public void testReceivedVoteCountGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    ReceivedVoteCount receivedVoteCount = new ReceivedVoteCount();

    // Act and Assert
    assertEquals(20L, receivedVoteCount.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test ReceivedVoteCount new {@link ReceivedVoteCount} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ReceivedVoteCount}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceivedVoteCount.<init>()"})
  public void testReceivedVoteCountNewReceivedVoteCount() {
    // Arrange and Act
    ReceivedVoteCount actualReceivedVoteCount = new ReceivedVoteCount();

    // Assert
    assertNull(actualReceivedVoteCount.getResult());
    assertNull(actualReceivedVoteCount.getDeposit());
    assertEquals(0L, actualReceivedVoteCount.getVmShouldEndInUs());
    assertFalse(actualReceivedVoteCount.isConstantCall());
  }

  /**
   * Test ResourceUsage {@link ResourceUsage#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceUsage#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair ResourceUsage.execute(byte[])"})
  public void testResourceUsageExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ResourceUsage resourceUsage = new ResourceUsage();

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
   * Test ResourceUsage {@link ResourceUsage#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceUsage#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair ResourceUsage.execute(byte[])"})
  public void testResourceUsageExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new ResourceUsage()).execute(null);

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
   * Test ResourceUsage {@link ResourceUsage#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link ResourceUsage#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceUsage.getEnergyForData(byte[])"})
  public void testResourceUsageGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    ResourceUsage resourceUsage = new ResourceUsage();

    // Act and Assert
    assertEquals(50L, resourceUsage.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test ResourceUsage new {@link ResourceUsage} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ResourceUsage}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceUsage.<init>()"})
  public void testResourceUsageNewResourceUsage() {
    // Arrange and Act
    ResourceUsage actualResourceUsage = new ResourceUsage();

    // Assert
    assertNull(actualResourceUsage.getResult());
    assertNull(actualResourceUsage.getDeposit());
    assertEquals(0L, actualResourceUsage.getVmShouldEndInUs());
    assertFalse(actualResourceUsage.isConstantCall());
  }

  /**
   * Test ResourceV2 {@link ResourceV2#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceV2#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair ResourceV2.execute(byte[])"})
  public void testResourceV2Execute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ResourceV2 resourceV2 = new ResourceV2();

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
   * Test ResourceV2 {@link ResourceV2#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceV2#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair ResourceV2.execute(byte[])"})
  public void testResourceV2Execute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new ResourceV2()).execute(null);

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
   * Test ResourceV2 {@link ResourceV2#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link ResourceV2#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceV2.getEnergyForData(byte[])"})
  public void testResourceV2GetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    ResourceV2 resourceV2 = new ResourceV2();

    // Act and Assert
    assertEquals(50L, resourceV2.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test ResourceV2 new {@link ResourceV2} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ResourceV2}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceV2.<init>()"})
  public void testResourceV2NewResourceV2() {
    // Arrange and Act
    ResourceV2 actualResourceV2 = new ResourceV2();

    // Assert
    assertNull(actualResourceV2.getResult());
    assertNull(actualResourceV2.getDeposit());
    assertEquals(0L, actualResourceV2.getVmShouldEndInUs());
    assertFalse(actualResourceV2.isConstantCall());
  }

  /**
   * Test RewardBalance {@link RewardBalance#execute(byte[])}.
   * <ul>
   *   <li>Then return {@link ImmutablePair}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RewardBalance#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair RewardBalance.execute(byte[])"})
  public void testRewardBalanceExecute_thenReturnImmutablePair() throws UnsupportedEncodingException {
    // Arrange
    RewardBalance rewardBalance = new RewardBalance();
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
   * Test RewardBalance {@link RewardBalance#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link RewardBalance#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long RewardBalance.getEnergyForData(byte[])"})
  public void testRewardBalanceGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    RewardBalance rewardBalance = new RewardBalance();

    // Act and Assert
    assertEquals(500L, rewardBalance.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test RewardBalance new {@link RewardBalance} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link RewardBalance}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RewardBalance.<init>()"})
  public void testRewardBalanceNewRewardBalance() {
    // Arrange and Act
    RewardBalance actualRewardBalance = new RewardBalance();

    // Assert
    assertNull(actualRewardBalance.getResult());
    assertNull(actualRewardBalance.getDeposit());
    assertEquals(0L, actualRewardBalance.getVmShouldEndInUs());
    assertFalse(actualRewardBalance.isConstantCall());
  }

  /**
   * Test Ripempd160 {@link Ripempd160#execute(byte[])}.
   * <ul>
   *   <li>Then return Right is array of {@code byte} with minus fourteen and {@code `}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Ripempd160#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair Ripempd160.execute(byte[])"})
  public void testRipempd160Execute_thenReturnRightIsArrayOfByteWithMinusFourteenAndBacktick()
      throws UnsupportedEncodingException {
    // Arrange
    Ripempd160 ripempd160 = new Ripempd160();

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
   * Test Ripempd160 {@link Ripempd160#execute(byte[])}.
   * <ul>
   *   <li>Then return Right is array of {@code byte} with two and minus thirty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link Ripempd160#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair Ripempd160.execute(byte[])"})
  public void testRipempd160Execute_thenReturnRightIsArrayOfByteWithTwoAndMinusThirtyNine() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new Ripempd160()).execute(null);

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
   * Test Ripempd160 {@link Ripempd160#getEnergyForData(byte[])}.
   * <ul>
   *   <li>Then return seven hundred twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Ripempd160#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Ripempd160.getEnergyForData(byte[])"})
  public void testRipempd160GetEnergyForData_thenReturnSevenHundredTwenty() throws UnsupportedEncodingException {
    // Arrange
    Ripempd160 ripempd160 = new Ripempd160();

    // Act and Assert
    assertEquals(720L, ripempd160.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Ripempd160 {@link Ripempd160#getEnergyForData(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return six hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link Ripempd160#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Ripempd160.getEnergyForData(byte[])"})
  public void testRipempd160GetEnergyForData_whenNull_thenReturnSixHundred() {
    // Arrange, Act and Assert
    assertEquals(600L, (new Ripempd160()).getEnergyForData(null));
  }

  /**
   * Test Ripempd160 new {@link Ripempd160} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Ripempd160}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Ripempd160.<init>()"})
  public void testRipempd160NewRipempd160() {
    // Arrange and Act
    Ripempd160 actualRipempd160 = new Ripempd160();

    // Assert
    assertNull(actualRipempd160.getResult());
    assertNull(actualRipempd160.getDeposit());
    assertEquals(0L, actualRipempd160.getVmShouldEndInUs());
    assertFalse(actualRipempd160.isConstantCall());
  }

  /**
   * Test Sha256 {@link Sha256#execute(byte[])}.
   * <ul>
   *   <li>Then return Right is array of {@code byte} with {@code \} and {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Sha256#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair Sha256.execute(byte[])"})
  public void testSha256Execute_thenReturnRightIsArrayOfByteWithBackslashAndLeftSquareBracket()
      throws UnsupportedEncodingException {
    // Arrange
    Sha256 sha256 = new Sha256();

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
   * Test Sha256 {@link Sha256#execute(byte[])}.
   * <ul>
   *   <li>Then return Right is array of {@code byte} with minus twenty-nine and minus eighty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Sha256#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair Sha256.execute(byte[])"})
  public void testSha256Execute_thenReturnRightIsArrayOfByteWithMinusTwentyNineAndMinusEighty() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new Sha256()).execute(null);

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
   * Test Sha256 {@link Sha256#getEnergyForData(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return seventy-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Sha256#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Sha256.getEnergyForData(byte[])"})
  public void testSha256GetEnergyForData_whenAxaxaxaxBytesIsUtf8_thenReturnSeventyTwo()
      throws UnsupportedEncodingException {
    // Arrange
    Sha256 sha256 = new Sha256();

    // Act and Assert
    assertEquals(72L, sha256.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Sha256 {@link Sha256#getEnergyForData(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return sixty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Sha256#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Sha256.getEnergyForData(byte[])"})
  public void testSha256GetEnergyForData_whenNull_thenReturnSixty() {
    // Arrange, Act and Assert
    assertEquals(60L, (new Sha256()).getEnergyForData(null));
  }

  /**
   * Test Sha256 new {@link Sha256} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Sha256}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Sha256.<init>()"})
  public void testSha256NewSha256() {
    // Arrange and Act
    Sha256 actualSha256 = new Sha256();

    // Assert
    assertNull(actualSha256.getResult());
    assertNull(actualSha256.getDeposit());
    assertEquals(0L, actualSha256.getVmShouldEndInUs());
    assertFalse(actualSha256.isConstantCall());
  }

  /**
   * Test TotalAcquiredResource {@link TotalAcquiredResource#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotalAcquiredResource#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair TotalAcquiredResource.execute(byte[])"})
  public void testTotalAcquiredResourceExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    TotalAcquiredResource totalAcquiredResource = new TotalAcquiredResource();

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
   * Test TotalAcquiredResource {@link TotalAcquiredResource#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotalAcquiredResource#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair TotalAcquiredResource.execute(byte[])"})
  public void testTotalAcquiredResourceExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new TotalAcquiredResource()).execute(null);

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
   * Test TotalAcquiredResource {@link TotalAcquiredResource#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link TotalAcquiredResource#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TotalAcquiredResource.getEnergyForData(byte[])"})
  public void testTotalAcquiredResourceGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    TotalAcquiredResource totalAcquiredResource = new TotalAcquiredResource();

    // Act and Assert
    assertEquals(50L, totalAcquiredResource.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test TotalAcquiredResource new {@link TotalAcquiredResource} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TotalAcquiredResource}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TotalAcquiredResource.<init>()"})
  public void testTotalAcquiredResourceNewTotalAcquiredResource() {
    // Arrange and Act
    TotalAcquiredResource actualTotalAcquiredResource = new TotalAcquiredResource();

    // Assert
    assertNull(actualTotalAcquiredResource.getResult());
    assertNull(actualTotalAcquiredResource.getDeposit());
    assertEquals(0L, actualTotalAcquiredResource.getVmShouldEndInUs());
    assertFalse(actualTotalAcquiredResource.isConstantCall());
  }

  /**
   * Test TotalDelegatedResource {@link TotalDelegatedResource#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotalDelegatedResource#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair TotalDelegatedResource.execute(byte[])"})
  public void testTotalDelegatedResourceExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    TotalDelegatedResource totalDelegatedResource = new TotalDelegatedResource();

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
   * Test TotalDelegatedResource {@link TotalDelegatedResource#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotalDelegatedResource#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair TotalDelegatedResource.execute(byte[])"})
  public void testTotalDelegatedResourceExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new TotalDelegatedResource()).execute(null);

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
   * Test TotalDelegatedResource {@link TotalDelegatedResource#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link TotalDelegatedResource#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TotalDelegatedResource.getEnergyForData(byte[])"})
  public void testTotalDelegatedResourceGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    TotalDelegatedResource totalDelegatedResource = new TotalDelegatedResource();

    // Act and Assert
    assertEquals(50L, totalDelegatedResource.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test TotalDelegatedResource new {@link TotalDelegatedResource} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TotalDelegatedResource}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TotalDelegatedResource.<init>()"})
  public void testTotalDelegatedResourceNewTotalDelegatedResource() {
    // Arrange and Act
    TotalDelegatedResource actualTotalDelegatedResource = new TotalDelegatedResource();

    // Assert
    assertNull(actualTotalDelegatedResource.getResult());
    assertNull(actualTotalDelegatedResource.getDeposit());
    assertEquals(0L, actualTotalDelegatedResource.getVmShouldEndInUs());
    assertFalse(actualTotalDelegatedResource.isConstantCall());
  }

  /**
   * Test TotalResource {@link TotalResource#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotalResource#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair TotalResource.execute(byte[])"})
  public void testTotalResourceExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    TotalResource totalResource = new TotalResource();

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
   * Test TotalResource {@link TotalResource#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotalResource#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair TotalResource.execute(byte[])"})
  public void testTotalResourceExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new TotalResource()).execute(null);

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
   * Test TotalResource {@link TotalResource#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link TotalResource#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TotalResource.getEnergyForData(byte[])"})
  public void testTotalResourceGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    TotalResource totalResource = new TotalResource();

    // Act and Assert
    assertEquals(50L, totalResource.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test TotalResource new {@link TotalResource} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TotalResource}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TotalResource.<init>()"})
  public void testTotalResourceNewTotalResource() {
    // Arrange and Act
    TotalResource actualTotalResource = new TotalResource();

    // Assert
    assertNull(actualTotalResource.getResult());
    assertNull(actualTotalResource.getDeposit());
    assertEquals(0L, actualTotalResource.getVmShouldEndInUs());
    assertFalse(actualTotalResource.isConstantCall());
  }

  /**
   * Test TotalVoteCount {@link TotalVoteCount#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotalVoteCount#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair TotalVoteCount.execute(byte[])"})
  public void testTotalVoteCountExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    TotalVoteCount totalVoteCount = new TotalVoteCount();

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
   * Test TotalVoteCount {@link TotalVoteCount#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotalVoteCount#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair TotalVoteCount.execute(byte[])"})
  public void testTotalVoteCountExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new TotalVoteCount()).execute(null);

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
   * Test TotalVoteCount {@link TotalVoteCount#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link TotalVoteCount#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TotalVoteCount.getEnergyForData(byte[])"})
  public void testTotalVoteCountGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    TotalVoteCount totalVoteCount = new TotalVoteCount();

    // Act and Assert
    assertEquals(20L, totalVoteCount.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test TotalVoteCount new {@link TotalVoteCount} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TotalVoteCount}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TotalVoteCount.<init>()"})
  public void testTotalVoteCountNewTotalVoteCount() {
    // Arrange and Act
    TotalVoteCount actualTotalVoteCount = new TotalVoteCount();

    // Assert
    assertNull(actualTotalVoteCount.getResult());
    assertNull(actualTotalVoteCount.getDeposit());
    assertEquals(0L, actualTotalVoteCount.getVmShouldEndInUs());
    assertFalse(actualTotalVoteCount.isConstantCall());
  }

  /**
   * Test UnfreezableBalanceV2 {@link UnfreezableBalanceV2#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezableBalanceV2#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair UnfreezableBalanceV2.execute(byte[])"})
  public void testUnfreezableBalanceV2Execute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    UnfreezableBalanceV2 unfreezableBalanceV2 = new UnfreezableBalanceV2();

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
   * Test UnfreezableBalanceV2 {@link UnfreezableBalanceV2#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezableBalanceV2#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair UnfreezableBalanceV2.execute(byte[])"})
  public void testUnfreezableBalanceV2Execute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new UnfreezableBalanceV2()).execute(null);

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
   * Test UnfreezableBalanceV2 {@link UnfreezableBalanceV2#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link UnfreezableBalanceV2#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long UnfreezableBalanceV2.getEnergyForData(byte[])"})
  public void testUnfreezableBalanceV2GetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    UnfreezableBalanceV2 unfreezableBalanceV2 = new UnfreezableBalanceV2();

    // Act and Assert
    assertEquals(50L, unfreezableBalanceV2.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test UnfreezableBalanceV2 new {@link UnfreezableBalanceV2} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link UnfreezableBalanceV2}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnfreezableBalanceV2.<init>()"})
  public void testUnfreezableBalanceV2NewUnfreezableBalanceV2() {
    // Arrange and Act
    UnfreezableBalanceV2 actualUnfreezableBalanceV2 = new UnfreezableBalanceV2();

    // Assert
    assertNull(actualUnfreezableBalanceV2.getResult());
    assertNull(actualUnfreezableBalanceV2.getDeposit());
    assertEquals(0L, actualUnfreezableBalanceV2.getVmShouldEndInUs());
    assertFalse(actualUnfreezableBalanceV2.isConstantCall());
  }

  /**
   * Test UsedVoteCount {@link UsedVoteCount#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UsedVoteCount#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair UsedVoteCount.execute(byte[])"})
  public void testUsedVoteCountExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    UsedVoteCount usedVoteCount = new UsedVoteCount();

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
   * Test UsedVoteCount {@link UsedVoteCount#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UsedVoteCount#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair UsedVoteCount.execute(byte[])"})
  public void testUsedVoteCountExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new UsedVoteCount()).execute(null);

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
   * Test UsedVoteCount {@link UsedVoteCount#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link UsedVoteCount#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long UsedVoteCount.getEnergyForData(byte[])"})
  public void testUsedVoteCountGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    UsedVoteCount usedVoteCount = new UsedVoteCount();

    // Act and Assert
    assertEquals(20L, usedVoteCount.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test UsedVoteCount new {@link UsedVoteCount} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link UsedVoteCount}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UsedVoteCount.<init>()"})
  public void testUsedVoteCountNewUsedVoteCount() {
    // Arrange and Act
    UsedVoteCount actualUsedVoteCount = new UsedVoteCount();

    // Assert
    assertNull(actualUsedVoteCount.getResult());
    assertNull(actualUsedVoteCount.getDeposit());
    assertEquals(0L, actualUsedVoteCount.getVmShouldEndInUs());
    assertFalse(actualUsedVoteCount.isConstantCall());
  }

  /**
   * Test ValidateMultiSign {@link ValidateMultiSign#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link ValidateMultiSign#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ValidateMultiSign.getEnergyForData(byte[])"})
  public void testValidateMultiSignGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    ValidateMultiSign validateMultiSign = new ValidateMultiSign();

    // Act and Assert
    assertEquals(-1500L, validateMultiSign.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test ValidateMultiSign new {@link ValidateMultiSign} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ValidateMultiSign}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateMultiSign.<init>()"})
  public void testValidateMultiSignNewValidateMultiSign() {
    // Arrange and Act
    ValidateMultiSign actualValidateMultiSign = new ValidateMultiSign();

    // Assert
    assertNull(actualValidateMultiSign.getResult());
    assertNull(actualValidateMultiSign.getDeposit());
    assertEquals(0L, actualValidateMultiSign.getVmShouldEndInUs());
    assertFalse(actualValidateMultiSign.isConstantCall());
  }

  /**
   * Test VerifyBurnProof {@link VerifyBurnProof#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyBurnProof#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair VerifyBurnProof.execute(byte[])"})
  public void testVerifyBurnProofExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    VerifyBurnProof verifyBurnProof = new VerifyBurnProof();

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
   * Test VerifyBurnProof {@link VerifyBurnProof#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyBurnProof#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair VerifyBurnProof.execute(byte[])"})
  public void testVerifyBurnProofExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new VerifyBurnProof()).execute(null);

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
   * Test VerifyBurnProof {@link VerifyBurnProof#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link VerifyBurnProof#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long VerifyBurnProof.getEnergyForData(byte[])"})
  public void testVerifyBurnProofGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    VerifyBurnProof verifyBurnProof = new VerifyBurnProof();

    // Act and Assert
    assertEquals(150000L, verifyBurnProof.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test VerifyBurnProof new {@link VerifyBurnProof} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link VerifyBurnProof}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VerifyBurnProof.<init>()"})
  public void testVerifyBurnProofNewVerifyBurnProof() {
    // Arrange and Act
    VerifyBurnProof actualVerifyBurnProof = new VerifyBurnProof();

    // Assert
    assertNull(actualVerifyBurnProof.getResult());
    assertNull(actualVerifyBurnProof.getDeposit());
    assertEquals(0L, actualVerifyBurnProof.getVmShouldEndInUs());
    assertFalse(actualVerifyBurnProof.isConstantCall());
  }

  /**
   * Test VerifyMintProof {@link VerifyMintProof#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyMintProof#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair VerifyMintProof.execute(byte[])"})
  public void testVerifyMintProofExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    VerifyMintProof verifyMintProof = new VerifyMintProof();

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
   * Test VerifyMintProof {@link VerifyMintProof#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyMintProof#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair VerifyMintProof.execute(byte[])"})
  public void testVerifyMintProofExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new VerifyMintProof()).execute(null);

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
   * Test VerifyMintProof {@link VerifyMintProof#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link VerifyMintProof#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long VerifyMintProof.getEnergyForData(byte[])"})
  public void testVerifyMintProofGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    VerifyMintProof verifyMintProof = new VerifyMintProof();

    // Act and Assert
    assertEquals(150000L, verifyMintProof.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test VerifyMintProof new {@link VerifyMintProof} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link VerifyMintProof}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VerifyMintProof.<init>()"})
  public void testVerifyMintProofNewVerifyMintProof() {
    // Arrange and Act
    VerifyMintProof actualVerifyMintProof = new VerifyMintProof();

    // Assert
    assertNull(actualVerifyMintProof.getResult());
    assertNull(actualVerifyMintProof.getDeposit());
    assertEquals(0L, actualVerifyMintProof.getVmShouldEndInUs());
    assertFalse(actualVerifyMintProof.isConstantCall());
  }

  /**
   * Test VerifyProof {@link VerifyProof#insertLeaves(byte[][], long, byte[][])}.
   * <ul>
   *   <li>When empty 2D array of {@code byte}.</li>
   *   <li>Then return {@link ImmutablePair}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyProof#insertLeaves(byte[][], long, byte[][])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair VerifyProof.insertLeaves(byte[][], long, byte[][])"})
  public void testVerifyProofInsertLeaves_whenEmpty2dArrayOfByte_thenReturnImmutablePair()
      throws UnsupportedEncodingException {
    // Arrange
    VerifyBurnProof verifyBurnProof = new VerifyBurnProof();

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
   * Test VerifyProof {@link VerifyProof#insertLeaves(byte[][], long, byte[][])}.
   * <ul>
   *   <li>When thirty-two.</li>
   *   <li>Then return {@link ImmutablePair}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyProof#insertLeaves(byte[][], long, byte[][])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair VerifyProof.insertLeaves(byte[][], long, byte[][])"})
  public void testVerifyProofInsertLeaves_whenThirtyTwo_thenReturnImmutablePair() throws UnsupportedEncodingException {
    // Arrange
    VerifyBurnProof verifyBurnProof = new VerifyBurnProof();

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
   * Test VerifyProof {@link VerifyProof#insertLeaves(byte[][], long, byte[][])}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link ImmutablePair}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyProof#insertLeaves(byte[][], long, byte[][])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair VerifyProof.insertLeaves(byte[][], long, byte[][])"})
  public void testVerifyProofInsertLeaves_whenThree_thenReturnImmutablePair() throws UnsupportedEncodingException {
    // Arrange
    VerifyBurnProof verifyBurnProof = new VerifyBurnProof();

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
   * Test VerifyProof {@link VerifyProof#parseInt(byte[], int)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@link Integer#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyProof#parseInt(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VerifyProof.parseInt(byte[], int)"})
  public void testVerifyProofParseInt_whenA_thenReturnMax_value() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE,
        (new VerifyBurnProof()).parseInt(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test VerifyProof {@link VerifyProof#parseInt(byte[], int)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@link Integer#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyProof#parseInt(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VerifyProof.parseInt(byte[], int)"})
  public void testVerifyProofParseInt_whenAxaxaxaxBytesIsUtf8_thenReturnMax_value()
      throws UnsupportedEncodingException {
    // Arrange
    VerifyBurnProof verifyBurnProof = new VerifyBurnProof();

    // Act and Assert
    assertEquals(Integer.MAX_VALUE, verifyBurnProof.parseInt("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test VerifyProof {@link VerifyProof#parseInt(byte[], int)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyProof#parseInt(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VerifyProof.parseInt(byte[], int)"})
  public void testVerifyProofParseInt_whenEmptyArrayOfByte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new VerifyBurnProof()).parseInt(new byte[]{}, 1));
  }

  /**
   * Test VerifyProof {@link VerifyProof#parseLong(byte[], int)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyProof#parseLong(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long VerifyProof.parseLong(byte[], int)"})
  public void testVerifyProofParseLong_whenA_thenReturnMax_value() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE,
        (new VerifyBurnProof()).parseLong(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test VerifyProof {@link VerifyProof#parseLong(byte[], int)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyProof#parseLong(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long VerifyProof.parseLong(byte[], int)"})
  public void testVerifyProofParseLong_whenAxaxaxaxBytesIsUtf8_thenReturnMax_value()
      throws UnsupportedEncodingException {
    // Arrange
    VerifyBurnProof verifyBurnProof = new VerifyBurnProof();

    // Act and Assert
    assertEquals(Long.MAX_VALUE, verifyBurnProof.parseLong("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test VerifyProof {@link VerifyProof#parseLong(byte[], int)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyProof#parseLong(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long VerifyProof.parseLong(byte[], int)"})
  public void testVerifyProofParseLong_whenEmptyArrayOfByte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new VerifyBurnProof()).parseLong(new byte[]{}, 1));
  }

  /**
   * Test VerifyTransferProof {@link VerifyTransferProof#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyTransferProof#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair VerifyTransferProof.execute(byte[])"})
  public void testVerifyTransferProofExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    VerifyTransferProof verifyTransferProof = new VerifyTransferProof();

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
   * Test VerifyTransferProof {@link VerifyTransferProof#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyTransferProof#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair VerifyTransferProof.execute(byte[])"})
  public void testVerifyTransferProofExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new VerifyTransferProof()).execute(null);

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
   * Test VerifyTransferProof {@link VerifyTransferProof#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link VerifyTransferProof#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long VerifyTransferProof.getEnergyForData(byte[])"})
  public void testVerifyTransferProofGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    VerifyTransferProof verifyTransferProof = new VerifyTransferProof();

    // Act and Assert
    assertEquals(200000L, verifyTransferProof.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test VerifyTransferProof new {@link VerifyTransferProof} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link VerifyTransferProof}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VerifyTransferProof.<init>()"})
  public void testVerifyTransferProofNewVerifyTransferProof() {
    // Arrange and Act
    VerifyTransferProof actualVerifyTransferProof = new VerifyTransferProof();

    // Assert
    assertNull(actualVerifyTransferProof.getResult());
    assertNull(actualVerifyTransferProof.getDeposit());
    assertEquals(0L, actualVerifyTransferProof.getVmShouldEndInUs());
    assertFalse(actualVerifyTransferProof.isConstantCall());
  }

  /**
   * Test VoteCount {@link VoteCount#execute(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteCount#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair VoteCount.execute(byte[])"})
  public void testVoteCountExecute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    VoteCount voteCount = new VoteCount();

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
   * Test VoteCount {@link VoteCount#execute(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteCount#execute(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair VoteCount.execute(byte[])"})
  public void testVoteCountExecute_whenNull() {
    // Arrange and Act
    Pair<Boolean, byte[]> actualExecuteResult = (new VoteCount()).execute(null);

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
   * Test VoteCount {@link VoteCount#getEnergyForData(byte[])}.
   * <p>
   * Method under test: {@link VoteCount#getEnergyForData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long VoteCount.getEnergyForData(byte[])"})
  public void testVoteCountGetEnergyForData() throws UnsupportedEncodingException {
    // Arrange
    VoteCount voteCount = new VoteCount();

    // Act and Assert
    assertEquals(500L, voteCount.getEnergyForData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test VoteCount new {@link VoteCount} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link VoteCount}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VoteCount.<init>()"})
  public void testVoteCountNewVoteCount() {
    // Arrange and Act
    VoteCount actualVoteCount = new VoteCount();

    // Assert
    assertNull(actualVoteCount.getResult());
    assertNull(actualVoteCount.getDeposit());
    assertEquals(0L, actualVoteCount.getVmShouldEndInUs());
    assertFalse(actualVoteCount.isConstantCall());
  }
}
