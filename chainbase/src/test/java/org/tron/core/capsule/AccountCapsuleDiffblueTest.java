package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Account;
import org.tron.protos.Protocol.Account.Frozen;
import org.tron.protos.Protocol.AccountType;
import org.tron.protos.Protocol.Key;
import org.tron.protos.Protocol.Permission;
import org.tron.protos.Protocol.Permission.PermissionType;
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.AccountContract.AccountCreateContract;

public class AccountCapsuleDiffblueTest {
  /**
   * Test {@link AccountCapsule#AccountCapsule(ByteString, AccountType, long, boolean,
   * DynamicPropertiesStore)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicPropertiesStore#getActiveDefaultOperations()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(ByteString, AccountType, long,
   * boolean, DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccountCapsule.<init>(ByteString, AccountType, long, boolean, DynamicPropertiesStore)"
  })
  public void testNewAccountCapsule_thenCallsGetActiveDefaultOperations()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations())
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(address, AccountType.Normal, 1L, true, dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    assertArrayEquals(
        new byte[] {
          26, 0, 'H', 1, -6, 1, 15, 26, 5, 'o', 'w', 'n', 'e', 'r', ' ', 1, ':', 4, '\n', 0, 16, 1,
          -118, 2, 30, '\b', 2, 16, 2, 26, 6, 'a', 'c', 't', 'i', 'v', 'e', ' ', 1, '2', '\b', 'A',
          'X', 'A', 'X', 'A', 'X', 'A', 'X', ':', 4, '\n', 0, 16, 1
        },
        actualAccountCapsule.getData());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(AccountCreateContract, long, boolean,
   * DynamicPropertiesStore)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicPropertiesStore#getActiveDefaultOperations()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccountCapsule#AccountCapsule(AccountContract.AccountCreateContract, long, boolean,
   * DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccountCapsule.<init>(AccountContract.AccountCreateContract, long, boolean, DynamicPropertiesStore)"
  })
  public void testNewAccountCapsule_thenCallsGetActiveDefaultOperations2()
      throws UnsupportedEncodingException {
    // Arrange
    AccountCreateContract contract = mock(AccountCreateContract.class);
    when(contract.getTypeValue()).thenReturn(42);
    when(contract.getType()).thenReturn(AccountType.Normal);
    when(contract.getAccountAddress()).thenReturn(mock(ByteString.class));

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations())
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(contract, 1L, true, dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(contract, atLeast(1)).getAccountAddress();
    verify(contract).getType();
    verify(contract).getTypeValue();
    assertArrayEquals(
        new byte[] {
          16, '*', 26, 0, 'H', 1, -6, 1, 15, 26, 5, 'o', 'w', 'n', 'e', 'r', ' ', 1, ':', 4, '\n',
          0, 16, 1, -118, 2, 30, '\b', 2, 16, 2, 26, 6, 'a', 'c', 't', 'i', 'v', 'e', ' ', 1, '2',
          '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', ':', 4, '\n', 0, 16, 1
        },
        actualAccountCapsule.getData());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(AccountCreateContract, long, boolean,
   * DynamicPropertiesStore)}.
   *
   * <ul>
   *   <li>Then return Data is array of {@code byte} with sixteen and {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccountCapsule#AccountCapsule(AccountContract.AccountCreateContract, long, boolean,
   * DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccountCapsule.<init>(AccountContract.AccountCreateContract, long, boolean, DynamicPropertiesStore)"
  })
  public void testNewAccountCapsule_thenReturnDataIsArrayOfByteWithSixteenAndAsterisk() {
    // Arrange
    AccountCreateContract contract = mock(AccountCreateContract.class);
    when(contract.getTypeValue()).thenReturn(42);
    when(contract.getType()).thenReturn(AccountType.Normal);
    when(contract.getAccountAddress()).thenReturn(mock(ByteString.class));

    // Act
    AccountCapsule actualAccountCapsule = new AccountCapsule(contract, 1L, false, null);

    // Assert
    verify(contract).getAccountAddress();
    verify(contract).getType();
    verify(contract).getTypeValue();
    assertArrayEquals(new byte[] {16, '*', 26, 0, 'H', 1}, actualAccountCapsule.getData());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_when2xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AccountCapsule("2XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and two.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWith2AndTwo_thenReturnInstanceIsNull() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(
            new byte[] {'2', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWith2AndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(new byte[] {'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and two.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWithAAndTwo_thenReturnInstanceIsNull() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(
            new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and two.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWithAAndTwo_thenReturnInstanceIsNull2() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(
            new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 'A', 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and two.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWithAsteriskAndTwo_thenReturnInstanceIsNull() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(
            new byte[] {'*', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and zero.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWithAsteriskAndZero() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(new byte[] {'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and two.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWithLfAndTwo_thenReturnInstanceIsNull() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(
            new byte[] {'\n', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWithLfAndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(new byte[] {'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWithMin_valueAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWithSixteenAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(new byte[] {16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and two.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWithTwentySixAndTwo() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(
            new byte[] {26, 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWithTwentySixAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAccountCapsule.getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(ByteString, ByteString, AccountType)}.
   *
   * <ul>
   *   <li>When {@code AssetIssue}.
   *   <li>Then return Type is {@code AssetIssue}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(ByteString, ByteString,
   * AccountType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(ByteString, ByteString, AccountType)"})
  public void testNewAccountCapsule_whenAssetIssue_thenReturnTypeIsAssetIssue() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(mock(ByteString.class), mock(ByteString.class), AccountType.AssetIssue);

    // Assert
    assertEquals(AccountType.AssetIssue, actualAccountCapsule.getType());
    assertArrayEquals(new byte[] {'\n', 0, 16, 1, 26, 0}, actualAccountCapsule.getData());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AccountCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(ByteString, ByteString, AccountType)}.
   *
   * <ul>
   *   <li>When {@link ByteString}.
   *   <li>Then return Type is {@code Normal}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(ByteString, ByteString,
   * AccountType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(ByteString, ByteString, AccountType)"})
  public void testNewAccountCapsule_whenByteString_thenReturnTypeIsNormal() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(mock(ByteString.class), mock(ByteString.class), AccountType.Normal);

    // Assert
    assertEquals(AccountType.Normal, actualAccountCapsule.getType());
    assertArrayEquals(new byte[] {'\n', 0, 26, 0}, actualAccountCapsule.getData());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(ByteString, AccountType)}.
   *
   * <ul>
   *   <li>When {@link ByteString}.
   *   <li>Then return WitnessPermissionAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(ByteString, AccountType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(ByteString, AccountType)"})
  public void testNewAccountCapsule_whenByteString_thenReturnWitnessPermissionAddressIsNull() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act
    AccountCapsule actualAccountCapsule = new AccountCapsule(address, AccountType.Normal);

    // Assert
    assertNull(actualAccountCapsule.getWitnessPermissionAddress());
    assertEquals(0, actualAccountCapsule.getFrozenCount());
    assertEquals(0, actualAccountCapsule.getFrozenSupplyCount());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAllTronPower());
    assertEquals(0L, actualAccountCapsule.getAllowance());
    assertEquals(0L, actualAccountCapsule.getBalance());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getEnergyFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getEnergyUsage());
    assertEquals(0L, actualAccountCapsule.getFreeNetUsage());
    assertEquals(0L, actualAccountCapsule.getFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getFrozenSupplyBalance());
    assertEquals(0L, actualAccountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeFreeTime());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeTime());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(0L, actualAccountCapsule.getLatestExchangeStorageTime());
    assertEquals(0L, actualAccountCapsule.getLatestOperationTime());
    assertEquals(0L, actualAccountCapsule.getLatestWithdrawTime());
    assertEquals(0L, actualAccountCapsule.getNetUsage());
    assertEquals(0L, actualAccountCapsule.getStorageLeft());
    assertEquals(0L, actualAccountCapsule.getStorageLimit());
    assertEquals(0L, actualAccountCapsule.getStorageUsage());
    assertEquals(0L, actualAccountCapsule.getTotalAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getTotalAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getTotalDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getTotalDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getTronPower());
    assertEquals(0L, actualAccountCapsule.getTronPowerFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, actualAccountCapsule.getTronPowerUsage());
    assertEquals(AccountType.Normal, actualAccountCapsule.getType());
    assertFalse(actualAccountCapsule.getAssetOptimized());
    assertFalse(actualAccountCapsule.getIsCommittee());
    assertFalse(actualAccountCapsule.getIsWitness());
    List<Frozen> frozenList = actualAccountCapsule.getFrozenList();
    assertTrue(frozenList.isEmpty());
    assertTrue(actualAccountCapsule.getAllFreeAssetNetUsage().isEmpty());
    assertTrue(actualAccountCapsule.getAllFreeAssetNetUsageV2().isEmpty());
    assertTrue(actualAccountCapsule.getAssetMap().isEmpty());
    assertTrue(actualAccountCapsule.getAssetMapForTest().isEmpty());
    assertTrue(actualAccountCapsule.getLatestAssetOperationTimeMap().isEmpty());
    assertTrue(actualAccountCapsule.getLatestAssetOperationTimeMapV2().isEmpty());
    assertSame(frozenList, actualAccountCapsule.getFrozenSupplyList());
    assertSame(frozenList, actualAccountCapsule.getFrozenV2List());
    assertSame(frozenList, actualAccountCapsule.getUnfrozenV2List());
    assertSame(frozenList, actualAccountCapsule.getVotesList());
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, actualAccountCapsule.getAccountId());
    assertSame(byteString, actualAccountCapsule.getAccountName());
    assertSame(byteString, actualAccountCapsule.getAssetIssuedID());
    assertSame(byteString, actualAccountCapsule.getAssetIssuedName());
    assertSame(address, actualAccountCapsule.getAddress());
    assertArrayEquals(new byte[] {26, 0}, actualAccountCapsule.getData());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(AccountCreateContract)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return FrozenCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccountCapsule#AccountCapsule(AccountContract.AccountCreateContract)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(AccountContract.AccountCreateContract)"})
  public void testNewAccountCapsule_whenDefaultInstance_thenReturnFrozenCountIsZero() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(AccountCreateContract.getDefaultInstance());

    // Assert
    assertEquals(0, actualAccountCapsule.getFrozenCount());
    assertEquals(0, actualAccountCapsule.getFrozenSupplyCount());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAllTronPower());
    assertEquals(0L, actualAccountCapsule.getAllowance());
    assertEquals(0L, actualAccountCapsule.getBalance());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getEnergyFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getEnergyUsage());
    assertEquals(0L, actualAccountCapsule.getFreeNetUsage());
    assertEquals(0L, actualAccountCapsule.getFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getFrozenSupplyBalance());
    assertEquals(0L, actualAccountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeFreeTime());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeTime());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(0L, actualAccountCapsule.getLatestExchangeStorageTime());
    assertEquals(0L, actualAccountCapsule.getLatestOperationTime());
    assertEquals(0L, actualAccountCapsule.getLatestWithdrawTime());
    assertEquals(0L, actualAccountCapsule.getNetUsage());
    assertEquals(0L, actualAccountCapsule.getStorageLeft());
    assertEquals(0L, actualAccountCapsule.getStorageLimit());
    assertEquals(0L, actualAccountCapsule.getStorageUsage());
    assertEquals(0L, actualAccountCapsule.getTotalAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getTotalAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getTotalDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getTotalDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getTronPower());
    assertEquals(0L, actualAccountCapsule.getTronPowerFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, actualAccountCapsule.getTronPowerUsage());
    assertEquals(AccountType.Normal, actualAccountCapsule.getType());
    assertFalse(actualAccountCapsule.getAssetOptimized());
    assertFalse(actualAccountCapsule.getIsCommittee());
    assertFalse(actualAccountCapsule.getIsWitness());
    List<Frozen> frozenList = actualAccountCapsule.getFrozenList();
    assertTrue(frozenList.isEmpty());
    assertTrue(actualAccountCapsule.getAllFreeAssetNetUsage().isEmpty());
    assertTrue(actualAccountCapsule.getAllFreeAssetNetUsageV2().isEmpty());
    assertTrue(actualAccountCapsule.getAssetMap().isEmpty());
    assertTrue(actualAccountCapsule.getAssetMapForTest().isEmpty());
    assertTrue(actualAccountCapsule.getLatestAssetOperationTimeMap().isEmpty());
    assertTrue(actualAccountCapsule.getLatestAssetOperationTimeMapV2().isEmpty());
    assertSame(frozenList, actualAccountCapsule.getFrozenSupplyList());
    assertSame(frozenList, actualAccountCapsule.getFrozenV2List());
    assertSame(frozenList, actualAccountCapsule.getUnfrozenV2List());
    assertSame(frozenList, actualAccountCapsule.getVotesList());
    assertArrayEquals(new byte[] {}, actualAccountCapsule.getData());
    assertArrayEquals(new byte[] {}, actualAccountCapsule.getWitnessPermissionAddress());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return FrozenCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenEmptyArrayOfByte_thenReturnFrozenCountIsZero() {
    // Arrange and Act
    AccountCapsule actualAccountCapsule = new AccountCapsule(new byte[] {});

    // Assert
    assertEquals(0, actualAccountCapsule.getFrozenCount());
    assertEquals(0, actualAccountCapsule.getFrozenSupplyCount());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAllTronPower());
    assertEquals(0L, actualAccountCapsule.getAllowance());
    assertEquals(0L, actualAccountCapsule.getBalance());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getEnergyFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getEnergyUsage());
    assertEquals(0L, actualAccountCapsule.getFreeNetUsage());
    assertEquals(0L, actualAccountCapsule.getFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getFrozenSupplyBalance());
    assertEquals(0L, actualAccountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeFreeTime());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeTime());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(0L, actualAccountCapsule.getLatestExchangeStorageTime());
    assertEquals(0L, actualAccountCapsule.getLatestOperationTime());
    assertEquals(0L, actualAccountCapsule.getLatestWithdrawTime());
    assertEquals(0L, actualAccountCapsule.getNetUsage());
    assertEquals(0L, actualAccountCapsule.getStorageLeft());
    assertEquals(0L, actualAccountCapsule.getStorageLimit());
    assertEquals(0L, actualAccountCapsule.getStorageUsage());
    assertEquals(0L, actualAccountCapsule.getTotalAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getTotalAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getTotalDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getTotalDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getTronPower());
    assertEquals(0L, actualAccountCapsule.getTronPowerFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, actualAccountCapsule.getTronPowerUsage());
    assertEquals(AccountType.Normal, actualAccountCapsule.getType());
    assertFalse(actualAccountCapsule.getAssetOptimized());
    assertFalse(actualAccountCapsule.getIsCommittee());
    assertFalse(actualAccountCapsule.getIsWitness());
    List<Frozen> frozenList = actualAccountCapsule.getFrozenList();
    assertTrue(frozenList.isEmpty());
    assertTrue(actualAccountCapsule.getAllFreeAssetNetUsage().isEmpty());
    assertTrue(actualAccountCapsule.getAllFreeAssetNetUsageV2().isEmpty());
    assertTrue(actualAccountCapsule.getAssetMap().isEmpty());
    assertTrue(actualAccountCapsule.getAssetMapForTest().isEmpty());
    assertTrue(actualAccountCapsule.getLatestAssetOperationTimeMap().isEmpty());
    assertTrue(actualAccountCapsule.getLatestAssetOperationTimeMapV2().isEmpty());
    assertSame(frozenList, actualAccountCapsule.getFrozenSupplyList());
    assertSame(frozenList, actualAccountCapsule.getFrozenV2List());
    assertSame(frozenList, actualAccountCapsule.getUnfrozenV2List());
    assertSame(frozenList, actualAccountCapsule.getVotesList());
    assertArrayEquals(new byte[] {}, actualAccountCapsule.getData());
    assertArrayEquals(new byte[] {}, actualAccountCapsule.getWitnessPermissionAddress());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(ByteString, ByteString, AccountType, long)}.
   *
   * <ul>
   *   <li>When {@code Normal}.
   *   <li>Then return WitnessPermissionAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(ByteString, ByteString, AccountType,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(ByteString, ByteString, AccountType, long)"})
  public void testNewAccountCapsule_whenNormal_thenReturnWitnessPermissionAddressIsNull() {
    // Arrange
    ByteString accountName = mock(ByteString.class);
    ByteString address = mock(ByteString.class);

    // Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(accountName, address, AccountType.Normal, 42L);

    // Assert
    assertNull(actualAccountCapsule.getWitnessPermissionAddress());
    assertEquals(0, actualAccountCapsule.getFrozenCount());
    assertEquals(0, actualAccountCapsule.getFrozenSupplyCount());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAllTronPower());
    assertEquals(0L, actualAccountCapsule.getAllowance());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getEnergyFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getEnergyUsage());
    assertEquals(0L, actualAccountCapsule.getFreeNetUsage());
    assertEquals(0L, actualAccountCapsule.getFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getFrozenSupplyBalance());
    assertEquals(0L, actualAccountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeFreeTime());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeTime());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(0L, actualAccountCapsule.getLatestExchangeStorageTime());
    assertEquals(0L, actualAccountCapsule.getLatestOperationTime());
    assertEquals(0L, actualAccountCapsule.getLatestWithdrawTime());
    assertEquals(0L, actualAccountCapsule.getNetUsage());
    assertEquals(0L, actualAccountCapsule.getStorageLeft());
    assertEquals(0L, actualAccountCapsule.getStorageLimit());
    assertEquals(0L, actualAccountCapsule.getStorageUsage());
    assertEquals(0L, actualAccountCapsule.getTotalAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getTotalAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getTotalDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getTotalDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getTronPower());
    assertEquals(0L, actualAccountCapsule.getTronPowerFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, actualAccountCapsule.getTronPowerUsage());
    assertEquals(42L, actualAccountCapsule.getBalance());
    assertEquals(AccountType.Normal, actualAccountCapsule.getType());
    assertFalse(actualAccountCapsule.getAssetOptimized());
    assertFalse(actualAccountCapsule.getIsCommittee());
    assertFalse(actualAccountCapsule.getIsWitness());
    List<Frozen> frozenList = actualAccountCapsule.getFrozenList();
    assertTrue(frozenList.isEmpty());
    assertTrue(actualAccountCapsule.getAllFreeAssetNetUsage().isEmpty());
    assertTrue(actualAccountCapsule.getAllFreeAssetNetUsageV2().isEmpty());
    assertTrue(actualAccountCapsule.getAssetMap().isEmpty());
    assertTrue(actualAccountCapsule.getAssetMapForTest().isEmpty());
    assertTrue(actualAccountCapsule.getLatestAssetOperationTimeMap().isEmpty());
    assertTrue(actualAccountCapsule.getLatestAssetOperationTimeMapV2().isEmpty());
    assertSame(frozenList, actualAccountCapsule.getFrozenSupplyList());
    assertSame(frozenList, actualAccountCapsule.getFrozenV2List());
    assertSame(frozenList, actualAccountCapsule.getUnfrozenV2List());
    assertSame(frozenList, actualAccountCapsule.getVotesList());
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, actualAccountCapsule.getAccountId());
    assertSame(byteString, actualAccountCapsule.getAssetIssuedID());
    assertSame(byteString, actualAccountCapsule.getAssetIssuedName());
    assertSame(accountName, actualAccountCapsule.getAccountName());
    assertSame(address, actualAccountCapsule.getAddress());
    assertArrayEquals(new byte[] {'\n', 0, 26, 0, ' ', '*'}, actualAccountCapsule.getData());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(ByteString, AccountType, long, boolean,
   * DynamicPropertiesStore)}.
   *
   * <ul>
   *   <li>When {@code Normal}.
   *   <li>Then return WitnessPermissionAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(ByteString, AccountType, long,
   * boolean, DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccountCapsule.<init>(ByteString, AccountType, long, boolean, DynamicPropertiesStore)"
  })
  public void testNewAccountCapsule_whenNormal_thenReturnWitnessPermissionAddressIsNull2() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act
    AccountCapsule actualAccountCapsule =
        new AccountCapsule(address, AccountType.Normal, 1L, false, null);

    // Assert
    assertNull(actualAccountCapsule.getWitnessPermissionAddress());
    assertEquals(0, actualAccountCapsule.getFrozenCount());
    assertEquals(0, actualAccountCapsule.getFrozenSupplyCount());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getAllTronPower());
    assertEquals(0L, actualAccountCapsule.getAllowance());
    assertEquals(0L, actualAccountCapsule.getBalance());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getEnergyFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getEnergyUsage());
    assertEquals(0L, actualAccountCapsule.getFreeNetUsage());
    assertEquals(0L, actualAccountCapsule.getFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getFrozenSupplyBalance());
    assertEquals(0L, actualAccountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeFreeTime());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeTime());
    assertEquals(0L, actualAccountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(0L, actualAccountCapsule.getLatestExchangeStorageTime());
    assertEquals(0L, actualAccountCapsule.getLatestOperationTime());
    assertEquals(0L, actualAccountCapsule.getLatestWithdrawTime());
    assertEquals(0L, actualAccountCapsule.getNetUsage());
    assertEquals(0L, actualAccountCapsule.getStorageLeft());
    assertEquals(0L, actualAccountCapsule.getStorageLimit());
    assertEquals(0L, actualAccountCapsule.getStorageUsage());
    assertEquals(0L, actualAccountCapsule.getTotalAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getTotalAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getTotalDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualAccountCapsule.getTotalDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualAccountCapsule.getTronPower());
    assertEquals(0L, actualAccountCapsule.getTronPowerFrozenBalance());
    assertEquals(0L, actualAccountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, actualAccountCapsule.getTronPowerUsage());
    assertEquals(AccountType.Normal, actualAccountCapsule.getType());
    assertFalse(actualAccountCapsule.getAssetOptimized());
    assertFalse(actualAccountCapsule.getIsCommittee());
    assertFalse(actualAccountCapsule.getIsWitness());
    List<Frozen> frozenList = actualAccountCapsule.getFrozenList();
    assertTrue(frozenList.isEmpty());
    assertTrue(actualAccountCapsule.getAllFreeAssetNetUsage().isEmpty());
    assertTrue(actualAccountCapsule.getAllFreeAssetNetUsageV2().isEmpty());
    assertTrue(actualAccountCapsule.getAssetMap().isEmpty());
    assertTrue(actualAccountCapsule.getAssetMapForTest().isEmpty());
    assertTrue(actualAccountCapsule.getLatestAssetOperationTimeMap().isEmpty());
    assertTrue(actualAccountCapsule.getLatestAssetOperationTimeMapV2().isEmpty());
    assertSame(frozenList, actualAccountCapsule.getFrozenSupplyList());
    assertSame(frozenList, actualAccountCapsule.getFrozenV2List());
    assertSame(frozenList, actualAccountCapsule.getUnfrozenV2List());
    assertSame(frozenList, actualAccountCapsule.getVotesList());
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, actualAccountCapsule.getAccountId());
    assertSame(byteString, actualAccountCapsule.getAccountName());
    assertSame(byteString, actualAccountCapsule.getAssetIssuedID());
    assertSame(byteString, actualAccountCapsule.getAssetIssuedName());
    assertSame(address, actualAccountCapsule.getAddress());
    assertArrayEquals(new byte[] {26, 0, 'H', 1}, actualAccountCapsule.getData());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AccountCapsule("\nXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AccountCapsule(" XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code *XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AccountCapsule("*XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code :XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull4()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AccountCapsule(":XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AccountCapsule#AccountCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#AccountCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountCapsule.<init>(byte[])"})
  public void testNewAccountCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AccountCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AccountCapsule#createDefaultOwnerPermission(ByteString)}.
   *
   * <p>Method under test: {@link AccountCapsule#createDefaultOwnerPermission(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission AccountCapsule.createDefaultOwnerPermission(ByteString)"})
  public void testCreateDefaultOwnerPermission() {
    // Arrange and Act
    Permission actualCreateDefaultOwnerPermissionResult =
        AccountCapsule.createDefaultOwnerPermission(mock(ByteString.class));

    // Assert
    assertEquals("", actualCreateDefaultOwnerPermissionResult.getInitializationErrorString());
    assertEquals("owner", actualCreateDefaultOwnerPermissionResult.getPermissionName());
    assertEquals(0, actualCreateDefaultOwnerPermissionResult.getId());
    assertEquals(0, actualCreateDefaultOwnerPermissionResult.getParentId());
    assertEquals(0, actualCreateDefaultOwnerPermissionResult.getTypeValue());
    List<Key> keysList = actualCreateDefaultOwnerPermissionResult.getKeysList();
    assertEquals(1, keysList.size());
    assertEquals(1, actualCreateDefaultOwnerPermissionResult.getKeysCount());
    assertEquals(15, actualCreateDefaultOwnerPermissionResult.getSerializedSize());
    assertEquals(1L, actualCreateDefaultOwnerPermissionResult.getThreshold());
    assertEquals(3, actualCreateDefaultOwnerPermissionResult.getAllFields().size());
    assertEquals(PermissionType.Owner, actualCreateDefaultOwnerPermissionResult.getType());
    assertTrue(actualCreateDefaultOwnerPermissionResult.findInitializationErrors().isEmpty());
    assertSame(keysList, actualCreateDefaultOwnerPermissionResult.getKeysOrBuilderList());
    assertSame(ByteString.EMPTY, actualCreateDefaultOwnerPermissionResult.getOperations());
  }

  /**
   * Test {@link AccountCapsule#createDefaultActivePermission(ByteString, DynamicPropertiesStore)}.
   *
   * <p>Method under test: {@link AccountCapsule#createDefaultActivePermission(ByteString,
   * DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Permission AccountCapsule.createDefaultActivePermission(ByteString, DynamicPropertiesStore)"
  })
  public void testCreateDefaultActivePermission() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations())
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Permission actualCreateDefaultActivePermissionResult =
        AccountCapsule.createDefaultActivePermission(address, dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    assertEquals("", actualCreateDefaultActivePermissionResult.getInitializationErrorString());
    assertEquals("active", actualCreateDefaultActivePermissionResult.getPermissionName());
    assertEquals(0, actualCreateDefaultActivePermissionResult.getParentId());
    List<Key> keysList = actualCreateDefaultActivePermissionResult.getKeysList();
    assertEquals(1, keysList.size());
    assertEquals(1, actualCreateDefaultActivePermissionResult.getKeysCount());
    assertEquals(1L, actualCreateDefaultActivePermissionResult.getThreshold());
    assertEquals(2, actualCreateDefaultActivePermissionResult.getId());
    assertEquals(2, actualCreateDefaultActivePermissionResult.getTypeValue());
    assertEquals(30, actualCreateDefaultActivePermissionResult.getSerializedSize());
    assertEquals(6, actualCreateDefaultActivePermissionResult.getAllFields().size());
    assertEquals(PermissionType.Active, actualCreateDefaultActivePermissionResult.getType());
    assertTrue(actualCreateDefaultActivePermissionResult.findInitializationErrors().isEmpty());
    assertSame(keysList, actualCreateDefaultActivePermissionResult.getKeysOrBuilderList());
  }

  /**
   * Test {@link AccountCapsule#createDefaultWitnessPermission(ByteString)}.
   *
   * <p>Method under test: {@link AccountCapsule#createDefaultWitnessPermission(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission AccountCapsule.createDefaultWitnessPermission(ByteString)"})
  public void testCreateDefaultWitnessPermission() {
    // Arrange and Act
    Permission actualCreateDefaultWitnessPermissionResult =
        AccountCapsule.createDefaultWitnessPermission(mock(ByteString.class));

    // Assert
    assertEquals("", actualCreateDefaultWitnessPermissionResult.getInitializationErrorString());
    assertEquals("witness", actualCreateDefaultWitnessPermissionResult.getPermissionName());
    assertEquals(0, actualCreateDefaultWitnessPermissionResult.getParentId());
    List<Key> keysList = actualCreateDefaultWitnessPermissionResult.getKeysList();
    assertEquals(1, keysList.size());
    assertEquals(1, actualCreateDefaultWitnessPermissionResult.getId());
    assertEquals(1, actualCreateDefaultWitnessPermissionResult.getKeysCount());
    assertEquals(1, actualCreateDefaultWitnessPermissionResult.getTypeValue());
    assertEquals(1L, actualCreateDefaultWitnessPermissionResult.getThreshold());
    assertEquals(21, actualCreateDefaultWitnessPermissionResult.getSerializedSize());
    assertEquals(5, actualCreateDefaultWitnessPermissionResult.getAllFields().size());
    assertEquals(PermissionType.Witness, actualCreateDefaultWitnessPermissionResult.getType());
    assertTrue(actualCreateDefaultWitnessPermissionResult.findInitializationErrors().isEmpty());
    assertSame(keysList, actualCreateDefaultWitnessPermissionResult.getKeysOrBuilderList());
    assertSame(ByteString.EMPTY, actualCreateDefaultWitnessPermissionResult.getOperations());
  }

  /**
   * Test {@link AccountCapsule#getDefaultPermission(ByteString)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AccountCapsule#getDefaultPermission(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission AccountCapsule.getDefaultPermission(ByteString)"})
  public void testGetDefaultPermission_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    Permission actualDefaultPermission =
        AccountCapsule.getDefaultPermission(mock(ByteString.class));

    // Assert
    assertEquals("", actualDefaultPermission.getInitializationErrorString());
    assertEquals("owner", actualDefaultPermission.getPermissionName());
    assertEquals(0, actualDefaultPermission.getId());
    assertEquals(0, actualDefaultPermission.getParentId());
    assertEquals(0, actualDefaultPermission.getTypeValue());
    List<Key> keysList = actualDefaultPermission.getKeysList();
    assertEquals(1, keysList.size());
    assertEquals(1, actualDefaultPermission.getKeysCount());
    assertEquals(15, actualDefaultPermission.getSerializedSize());
    assertEquals(1L, actualDefaultPermission.getThreshold());
    assertEquals(3, actualDefaultPermission.getAllFields().size());
    assertEquals(PermissionType.Owner, actualDefaultPermission.getType());
    assertTrue(actualDefaultPermission.findInitializationErrors().isEmpty());
    assertSame(keysList, actualDefaultPermission.getKeysOrBuilderList());
    assertSame(ByteString.EMPTY, actualDefaultPermission.getOperations());
  }
}
