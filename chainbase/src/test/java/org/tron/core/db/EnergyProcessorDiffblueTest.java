package org.tron.core.db;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.store.AccountStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.Common;

@RunWith(MockitoJUnitRunner.class)
public class EnergyProcessorDiffblueTest {
  @Mock
  private AccountStore accountStore;

  @Mock
  private DynamicPropertiesStore dynamicPropertiesStore;

  @InjectMocks
  private EnergyProcessor energyProcessor;

  /**
   * Method under test:
   * {@link EnergyProcessor#getHeadSlot(DynamicPropertiesStore)}
   */
  @Test
  public void testGetHeadSlot() {
    // Arrange
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> EnergyProcessor.getHeadSlot(dynamicPropertiesStore));
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
  }

  /**
   * Method under test: {@link EnergyProcessor#updateAdaptiveTotalEnergyLimit()}
   */
  @Test
  public void testUpdateAdaptiveTotalEnergyLimit() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAdaptiveResourceLimitMultiplier()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyAverageUsage()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyTargetLimit()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveTotalEnergyCurrentLimit(anyLong());

    // Act
    (new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class))).updateAdaptiveTotalEnergyLimit();

    // Assert that nothing has changed
    verify(dynamicPropertiesStore).getAdaptiveResourceLimitMultiplier();
    verify(dynamicPropertiesStore).getTotalEnergyAverageUsage();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyLimit();
    verify(dynamicPropertiesStore).getTotalEnergyTargetLimit();
    verify(dynamicPropertiesStore).saveTotalEnergyCurrentLimit(eq(1L));
  }

  /**
   * Method under test: {@link EnergyProcessor#updateAdaptiveTotalEnergyLimit()}
   */
  @Test
  public void testUpdateAdaptiveTotalEnergyLimit2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAdaptiveResourceLimitMultiplier()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyAverageUsage()).thenReturn(1000L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyTargetLimit()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveTotalEnergyCurrentLimit(anyLong());

    // Act
    (new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class))).updateAdaptiveTotalEnergyLimit();

    // Assert that nothing has changed
    verify(dynamicPropertiesStore).getAdaptiveResourceLimitMultiplier();
    verify(dynamicPropertiesStore).getTotalEnergyAverageUsage();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyLimit();
    verify(dynamicPropertiesStore).getTotalEnergyTargetLimit();
    verify(dynamicPropertiesStore).saveTotalEnergyCurrentLimit(eq(1L));
  }

  /**
   * Method under test: {@link EnergyProcessor#updateAdaptiveTotalEnergyLimit()}
   */
  @Test
  public void testUpdateAdaptiveTotalEnergyLimit3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyAverageUsage())
        .thenThrow(new RuntimeException("Adjust totalEnergyCurrentLimit, old: {}, new: {}."));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class))).updateAdaptiveTotalEnergyLimit());
    verify(dynamicPropertiesStore).getTotalEnergyAverageUsage();
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();
    AccountCapsule accountCapsule = new AccountCapsule(account);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(4, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Short.SIZE, instance.getSerializedSize());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doThrow(new RuntimeException("foo")).when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> energyProcessor.useEnergy(new AccountCapsule(Protocol.Account.getDefaultInstance()), 1L, 1L));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();
    AccountCapsule accountCapsule = new AccountCapsule(account);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(13, instance.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800L, accountResource.getEnergyWindowSize());
    assertEquals(3, accountResource.getAllFields().size());
    assertEquals(8, accountResource.getSerializedSize());
    assertFalse(accountResource.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'P', 1, -46, 1, '\b', '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -31, 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(3L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();
    AccountCapsule accountCapsule = new AccountCapsule(account);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(4, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Short.SIZE, instance.getSerializedSize());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy5() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(0L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();
    AccountCapsule accountCapsule = new AccountCapsule(account);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(4, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Short.SIZE, instance.getSerializedSize());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy6() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();
    AccountCapsule accountCapsule = new AccountCapsule(account);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, accountResource.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(2, accountResource.getAllFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, accountResource.getSerializedSize());
    assertEquals(9, instance.getSerializedSize());
    assertFalse(accountResource.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'P', 1, -46, 1, 4, '\b', 1, 24, 1}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy7() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(0L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();
    AccountCapsule accountCapsule = new AccountCapsule(account);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(4, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Short.SIZE, instance.getSerializedSize());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy8() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    AccountCapsule accountCapsule = new AccountCapsule(AccountContract.AccountCreateContract.getDefaultInstance());

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(4, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Short.SIZE, instance.getSerializedSize());
    Protocol.Account.AccountResource defaultInstanceForType2 = defaultInstanceForType.getDefaultInstanceForType();
    Protocol.Account defaultInstanceForType3 = instance.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, defaultInstanceForType3.getAccountResource());
    assertSame(defaultInstanceForType2, defaultInstanceForType3.getAccountResourceOrBuilder());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertArrayEquals(new byte[]{'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy9() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(19, instance.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(
        new byte[]{'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1, -48, 2, '*'},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy10() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addDelegatedFrozenV2BalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(19, instance.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(
        new byte[]{'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1, -96, 2, '*'},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy11() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addFrozenBalanceForBandwidthV2(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(21, instance.getSerializedSize());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1, -110,
        2, 2, 16, '*'}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy12() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(19, instance.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(
        new byte[]{'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1, -56, 2, '*'},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy13() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenV2BalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(19, instance.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(
        new byte[]{'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1, -88, 2, '*'},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy14() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenBalanceForEnergy(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(13, accountResource.getSerializedSize());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(18, instance.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(5, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(
        new byte[]{'P', 1, -46, 1, '\r', '\b', 1, 24, 1, ' ', '*', 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy15() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenV2BalanceForEnergy(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(13, accountResource.getSerializedSize());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(18, instance.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(5, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(
        new byte[]{'P', 1, -46, 1, '\r', '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', 'X', '*', '`', 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy16() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addDelegatedFrozenBalanceForEnergy(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(13, accountResource.getSerializedSize());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(18, instance.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(5, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(
        new byte[]{'P', 1, -46, 1, '\r', '\b', 1, 24, 1, '(', '*', 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy17() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addDelegatedFrozenV2BalanceForEnergy(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(13, accountResource.getSerializedSize());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(18, instance.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(5, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(
        new byte[]{'P', 1, -46, 1, '\r', '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', 'P', '*', '`', 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy18() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addFrozenBalanceForEnergyV2(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(23, instance.getSerializedSize());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1, -110,
        2, 4, '\b', 1, 16, '*'}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy19() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addUnfrozenV2List(Common.ResourceCode.BANDWIDTH, 1L, 1L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(23, instance.getSerializedSize());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1, -102,
        2, 4, 24, 1, ' ', 1}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy20() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addStorageUsage(1L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(13, accountResource.getSerializedSize());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(18, instance.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(5, accountResource.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(
        new byte[]{'P', 1, -46, 1, '\r', '\b', 1, 24, 1, '8', 1, 'H', Byte.MIN_VALUE, -24, -35, '\r', '`', 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy21() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAccountName(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(29, instance.getSerializedSize());
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals(4, instance.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'P', 1, -46, 1, 11, '\b', 1, 24, 1, 'H',
        Byte.MIN_VALUE, -24, -35, '\r', '`', 1, -48, 2, '*'}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy22() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAccountId(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals(30, instance.getSerializedSize());
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals(4, instance.getAllFields().size());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'P', 1, -70, 1, '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1, -46, 1, 11, '\b', 1, 24, 1, 'H',
        Byte.MIN_VALUE, -24, -35, '\r', '`', 1, -48, 2, '*'}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy23() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[11]);
    assertEquals((byte) -35, data[12]);
    assertEquals((byte) -46, data[2]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[Short.SIZE]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[4]);
    assertEquals((byte) 16, data[83]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[70]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[84]);
    assertEquals((byte) 24, data[7]);
    assertEquals((byte) 26, data[19]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[82]);
    assertEquals((byte) 2, data[86]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[20]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(88, instance.getSerializedSize());
    assertEquals(88, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[10]);
    assertEquals(' ', data[69]);
    assertEquals('*', data[87]);
    assertEquals('2', data[71]);
    assertEquals(':', data[81]);
    assertEquals('A', data[73]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('H', data[9]);
    assertEquals('P', data[0]);
    assertEquals('X', data[74]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('\b', data[5]);
    assertEquals('\b', data[72]);
    assertEquals('\r', data[13]);
    assertEquals('\r', data[18]);
    assertEquals('`', data[14]);
    assertEquals('a', data[63]);
    assertEquals('c', data[Double.SIZE]);
    assertEquals('e', data[24]);
    assertEquals('e', data[68]);
    assertEquals('i', data[66]);
    assertEquals('n', data[23]);
    assertEquals('o', data[21]);
    assertEquals('t', data[65]);
    assertEquals('v', data[67]);
    assertEquals('w', data[22]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy24() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 0L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(1L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[9]);
    assertEquals((byte) -35, data[10]);
    assertEquals((byte) -46, data[2]);
    assertEquals((byte) -48, data[83]);
    assertEquals((byte) -6, data[14]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, accountCapsule.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, accountResource.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals((byte) 16, data[81]);
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[68]);
    assertEquals((byte) 1, data[82]);
    assertEquals((byte) 24, data[5]);
    assertEquals((byte) 26, data[17]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[80]);
    assertEquals((byte) 2, data[84]);
    assertEquals(3, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[18]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(86, instance.getSerializedSize());
    assertEquals(86, data.length);
    assertEquals(9, accountResource.getSerializedSize());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[8]);
    assertEquals(' ', data[24]);
    assertEquals(' ', data[67]);
    assertEquals('*', data[85]);
    assertEquals('2', data[69]);
    assertEquals(':', data[79]);
    assertEquals('A', data[71]);
    assertEquals('A', data[73]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('H', data[7]);
    assertEquals('P', data[0]);
    assertEquals('X', data[72]);
    assertEquals('X', data[74]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('\b', data[70]);
    assertEquals('\r', data[11]);
    assertEquals('\r', data[Short.SIZE]);
    assertEquals('\t', data[4]);
    assertEquals('`', data[12]);
    assertEquals('a', data[61]);
    assertEquals('c', data[62]);
    assertEquals('e', data[22]);
    assertEquals('e', data[66]);
    assertEquals('i', data[Double.SIZE]);
    assertEquals('n', data[21]);
    assertEquals('o', data[19]);
    assertEquals('r', data[23]);
    assertEquals('t', data[63]);
    assertEquals('v', data[65]);
    assertEquals('w', data[20]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy25() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 0L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[9]);
    assertEquals((byte) -35, data[10]);
    assertEquals((byte) -46, data[2]);
    assertEquals((byte) -48, data[83]);
    assertEquals((byte) -6, data[14]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals((byte) 16, data[81]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[68]);
    assertEquals((byte) 1, data[82]);
    assertEquals((byte) 26, data[17]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[80]);
    assertEquals((byte) 2, data[84]);
    assertEquals(3, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[18]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(86, instance.getSerializedSize());
    assertEquals(86, data.length);
    assertEquals(9, accountResource.getSerializedSize());
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[8]);
    assertEquals(' ', data[24]);
    assertEquals(' ', data[67]);
    assertEquals('*', data[85]);
    assertEquals('2', data[69]);
    assertEquals(':', data[79]);
    assertEquals('A', data[71]);
    assertEquals('A', data[73]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('H', data[7]);
    assertEquals('P', data[0]);
    assertEquals('X', data[72]);
    assertEquals('X', data[74]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('\b', data[5]);
    assertEquals('\b', data[70]);
    assertEquals('\r', data[11]);
    assertEquals('\r', data[Short.SIZE]);
    assertEquals('\t', data[4]);
    assertEquals('`', data[12]);
    assertEquals('a', data[61]);
    assertEquals('c', data[62]);
    assertEquals('e', data[22]);
    assertEquals('e', data[66]);
    assertEquals('i', data[Double.SIZE]);
    assertEquals('n', data[21]);
    assertEquals('o', data[19]);
    assertEquals('r', data[23]);
    assertEquals('t', data[63]);
    assertEquals('v', data[65]);
    assertEquals('w', data[20]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy26() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, Long.MAX_VALUE);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -1, data[10]);
    assertEquals((byte) -1, data[11]);
    assertEquals((byte) -1, data[12]);
    assertEquals((byte) -1, data[13]);
    assertEquals((byte) -1, data[14]);
    assertEquals((byte) -1, data[15]);
    assertEquals((byte) -1, data[8]);
    assertEquals((byte) -1, data[9]);
    assertEquals((byte) -24, data[19]);
    assertEquals((byte) -35, data[20]);
    assertEquals((byte) -46, data[2]);
    assertEquals((byte) -48, data[93]);
    assertEquals((byte) -6, data[24]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals((byte) 16, data[91]);
    assertEquals(19, accountResource.getSerializedSize());
    assertEquals((byte) 19, data[4]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[23]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[78]);
    assertEquals((byte) 1, data[92]);
    assertEquals((byte) 24, data[7]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[90]);
    assertEquals((byte) 2, data[94]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals(6, instance.getAllFields().size());
    assertEquals(96, instance.getSerializedSize());
    assertEquals(96, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MAX_VALUE, data[Short.SIZE]);
    assertEquals(Byte.MIN_VALUE, data[18]);
    assertEquals(Long.MAX_VALUE, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(Long.MAX_VALUE, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals(' ', data[77]);
    assertEquals('*', data[95]);
    assertEquals('2', data[79]);
    assertEquals(':', data[89]);
    assertEquals('A', data[81]);
    assertEquals('A', data[83]);
    assertEquals('A', data[85]);
    assertEquals('A', data[87]);
    assertEquals('H', data[17]);
    assertEquals('P', data[0]);
    assertEquals('X', data[82]);
    assertEquals('X', data[84]);
    assertEquals('X', data[86]);
    assertEquals('X', data[88]);
    assertEquals('\b', data[5]);
    assertEquals('\b', data[80]);
    assertEquals('\r', data[21]);
    assertEquals('`', data[22]);
    assertEquals('a', data[71]);
    assertEquals('c', data[72]);
    assertEquals('e', data[76]);
    assertEquals('i', data[74]);
    assertEquals('t', data[73]);
    assertEquals('v', data[75]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy27() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setBalance(42L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[13]);
    assertEquals((byte) -35, data[14]);
    assertEquals((byte) -46, data[4]);
    assertEquals((byte) -48, data[87]);
    assertEquals((byte) -6, data[18]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[6]);
    assertEquals((byte) 16, data[85]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[10]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[19]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[72]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[86]);
    assertEquals((byte) 24, data[9]);
    assertEquals((byte) 26, data[21]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[84]);
    assertEquals((byte) 2, data[88]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[22]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(90, instance.getSerializedSize());
    assertEquals(90, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[12]);
    assertEquals(' ', data[0]);
    assertEquals(' ', data[71]);
    assertEquals('*', data[1]);
    assertEquals('*', data[89]);
    assertEquals('2', data[73]);
    assertEquals(':', data[83]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('A', data[81]);
    assertEquals('H', data[11]);
    assertEquals('P', data[2]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('X', data[82]);
    assertEquals('\b', data[7]);
    assertEquals('\b', data[74]);
    assertEquals('\r', data[15]);
    assertEquals('\r', data[20]);
    assertEquals('`', data[Short.SIZE]);
    assertEquals('a', data[65]);
    assertEquals('c', data[66]);
    assertEquals('e', data[70]);
    assertEquals('i', data[68]);
    assertEquals('o', data[23]);
    assertEquals('t', data[67]);
    assertEquals('v', data[69]);
    assertEquals('w', data[24]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy28() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestConsumeTime(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[14]);
    assertEquals((byte) -35, data[15]);
    assertEquals((byte) -46, data[5]);
    assertEquals((byte) -48, data[88]);
    assertEquals((byte) -6, data[19]);
    assertEquals((byte) -88, data[2]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[7]);
    assertEquals((byte) 16, data[86]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[18]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[73]);
    assertEquals((byte) 1, data[87]);
    assertEquals((byte) 1, data[9]);
    assertEquals((byte) 24, data[10]);
    assertEquals((byte) 26, data[22]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[85]);
    assertEquals((byte) 2, data[89]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[23]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(91, instance.getSerializedSize());
    assertEquals(91, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[13]);
    assertEquals(' ', data[72]);
    assertEquals('*', data[90]);
    assertEquals('2', data[74]);
    assertEquals(':', data[84]);
    assertEquals('A', data[76]);
    assertEquals('A', data[78]);
    assertEquals('A', data[80]);
    assertEquals('A', data[82]);
    assertEquals('H', data[12]);
    assertEquals('P', data[0]);
    assertEquals('X', data[77]);
    assertEquals('X', data[79]);
    assertEquals('X', data[81]);
    assertEquals('X', data[83]);
    assertEquals('\b', data[75]);
    assertEquals('\b', data[8]);
    assertEquals('\r', data[21]);
    assertEquals('\r', data[Short.SIZE]);
    assertEquals('`', data[17]);
    assertEquals('a', data[66]);
    assertEquals('c', data[67]);
    assertEquals('e', data[71]);
    assertEquals('i', data[69]);
    assertEquals('o', data[24]);
    assertEquals('t', data[68]);
    assertEquals('v', data[70]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy29() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestConsumeFreeTime(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[14]);
    assertEquals((byte) -35, data[15]);
    assertEquals((byte) -46, data[5]);
    assertEquals((byte) -48, data[88]);
    assertEquals((byte) -6, data[19]);
    assertEquals((byte) -80, data[2]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[7]);
    assertEquals((byte) 16, data[86]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[18]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[73]);
    assertEquals((byte) 1, data[87]);
    assertEquals((byte) 1, data[9]);
    assertEquals((byte) 24, data[10]);
    assertEquals((byte) 26, data[22]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[85]);
    assertEquals((byte) 2, data[89]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[23]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(91, instance.getSerializedSize());
    assertEquals(91, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[13]);
    assertEquals(' ', data[72]);
    assertEquals('*', data[90]);
    assertEquals('2', data[74]);
    assertEquals(':', data[84]);
    assertEquals('A', data[76]);
    assertEquals('A', data[78]);
    assertEquals('A', data[80]);
    assertEquals('A', data[82]);
    assertEquals('H', data[12]);
    assertEquals('P', data[0]);
    assertEquals('X', data[77]);
    assertEquals('X', data[79]);
    assertEquals('X', data[81]);
    assertEquals('X', data[83]);
    assertEquals('\b', data[75]);
    assertEquals('\b', data[8]);
    assertEquals('\r', data[21]);
    assertEquals('\r', data[Short.SIZE]);
    assertEquals('`', data[17]);
    assertEquals('a', data[66]);
    assertEquals('c', data[67]);
    assertEquals('e', data[71]);
    assertEquals('i', data[69]);
    assertEquals('o', data[24]);
    assertEquals('t', data[68]);
    assertEquals('v', data[70]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy30() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAssetOptimized(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[11]);
    assertEquals((byte) -32, data[88]);
    assertEquals((byte) -35, data[12]);
    assertEquals((byte) -46, data[2]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[Short.SIZE]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[4]);
    assertEquals((byte) 16, data[83]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[70]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[84]);
    assertEquals((byte) 1, data[90]);
    assertEquals((byte) 24, data[7]);
    assertEquals((byte) 26, data[19]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[82]);
    assertEquals((byte) 2, data[86]);
    assertEquals((byte) 3, data[89]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[20]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(91, instance.getSerializedSize());
    assertEquals(91, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[10]);
    assertEquals(' ', data[69]);
    assertEquals('*', data[87]);
    assertEquals('2', data[71]);
    assertEquals(':', data[81]);
    assertEquals('A', data[73]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('H', data[9]);
    assertEquals('P', data[0]);
    assertEquals('X', data[74]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('\b', data[5]);
    assertEquals('\b', data[72]);
    assertEquals('\r', data[13]);
    assertEquals('\r', data[18]);
    assertEquals('`', data[14]);
    assertEquals('e', data[24]);
    assertEquals('e', data[68]);
    assertEquals('i', data[66]);
    assertEquals('n', data[23]);
    assertEquals('o', data[21]);
    assertEquals('v', data[67]);
    assertEquals('w', data[22]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy31() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAssetIssuedName(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -118, data[2]);
    assertEquals((byte) -24, data[22]);
    assertEquals((byte) -35, data[23]);
    assertEquals((byte) -46, data[13]);
    assertEquals((byte) -48, data[96]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[15]);
    assertEquals((byte) 16, data[94]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[10]);
    assertEquals((byte) 1, data[12]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[19]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[81]);
    assertEquals((byte) 1, data[95]);
    assertEquals((byte) 24, data[18]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[93]);
    assertEquals((byte) 2, data[97]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals(7, instance.getAllFields().size());
    assertEquals(99, instance.getSerializedSize());
    assertEquals(99, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[21]);
    assertEquals(' ', data[80]);
    assertEquals('*', data[98]);
    assertEquals('2', data[82]);
    assertEquals(':', data[92]);
    assertEquals('A', data[11]);
    assertEquals('A', data[5]);
    assertEquals('A', data[7]);
    assertEquals('A', data[84]);
    assertEquals('A', data[86]);
    assertEquals('A', data[88]);
    assertEquals('A', data[9]);
    assertEquals('A', data[90]);
    assertEquals('H', data[20]);
    assertEquals('P', data[0]);
    assertEquals('X', data[85]);
    assertEquals('X', data[87]);
    assertEquals('X', data[89]);
    assertEquals('X', data[91]);
    assertEquals('\b', data[4]);
    assertEquals('\b', data[83]);
    assertEquals('\b', data[Short.SIZE]);
    assertEquals('\r', data[24]);
    assertEquals('a', data[74]);
    assertEquals('c', data[75]);
    assertEquals('e', data[79]);
    assertEquals('i', data[77]);
    assertEquals('t', data[76]);
    assertEquals('v', data[78]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy32() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAssetIssuedID(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[11]);
    assertEquals((byte) -35, data[12]);
    assertEquals((byte) -46, data[2]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -54, data[88]);
    assertEquals((byte) -6, data[Short.SIZE]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[4]);
    assertEquals((byte) 16, data[83]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[84]);
    assertEquals((byte) 1, data[92]);
    assertEquals((byte) 1, data[94]);
    assertEquals((byte) 1, data[96]);
    assertEquals((byte) 1, data[98]);
    assertEquals((byte) 24, data[7]);
    assertEquals((byte) 26, data[19]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[82]);
    assertEquals((byte) 2, data[86]);
    assertEquals((byte) 3, data[89]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[20]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(99, instance.getSerializedSize());
    assertEquals(99, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[10]);
    assertEquals('*', data[87]);
    assertEquals(':', data[81]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('A', data[91]);
    assertEquals('A', data[93]);
    assertEquals('A', data[95]);
    assertEquals('A', data[97]);
    assertEquals('H', data[9]);
    assertEquals('P', data[0]);
    assertEquals('X', data[74]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('\b', data[5]);
    assertEquals('\b', data[90]);
    assertEquals('\r', data[13]);
    assertEquals('\r', data[18]);
    assertEquals('`', data[14]);
    assertEquals('e', data[24]);
    assertEquals('n', data[23]);
    assertEquals('o', data[21]);
    assertEquals('w', data[22]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy33() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAllowance(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[13]);
    assertEquals((byte) -35, data[14]);
    assertEquals((byte) -46, data[4]);
    assertEquals((byte) -48, data[87]);
    assertEquals((byte) -6, data[18]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[6]);
    assertEquals((byte) 16, data[85]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[10]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[19]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[72]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[86]);
    assertEquals((byte) 24, data[9]);
    assertEquals((byte) 26, data[21]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[84]);
    assertEquals((byte) 2, data[88]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[22]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(90, instance.getSerializedSize());
    assertEquals(90, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[12]);
    assertEquals(' ', data[71]);
    assertEquals('*', data[89]);
    assertEquals('2', data[73]);
    assertEquals(':', data[83]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('A', data[81]);
    assertEquals('H', data[11]);
    assertEquals('P', data[0]);
    assertEquals('X', data[2]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('X', data[82]);
    assertEquals('\b', data[7]);
    assertEquals('\b', data[74]);
    assertEquals('\r', data[15]);
    assertEquals('\r', data[20]);
    assertEquals('`', data[Short.SIZE]);
    assertEquals('a', data[65]);
    assertEquals('c', data[66]);
    assertEquals('e', data[70]);
    assertEquals('i', data[68]);
    assertEquals('o', data[23]);
    assertEquals('t', data[67]);
    assertEquals('v', data[69]);
    assertEquals('w', data[24]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy34() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestWithdrawTime(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[13]);
    assertEquals((byte) -35, data[14]);
    assertEquals((byte) -46, data[4]);
    assertEquals((byte) -48, data[87]);
    assertEquals((byte) -6, data[18]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[6]);
    assertEquals((byte) 16, data[85]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[10]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[19]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[72]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[86]);
    assertEquals((byte) 24, data[9]);
    assertEquals((byte) 26, data[21]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[84]);
    assertEquals((byte) 2, data[88]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[22]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(90, instance.getSerializedSize());
    assertEquals(90, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[12]);
    assertEquals(' ', data[71]);
    assertEquals('*', data[89]);
    assertEquals('2', data[73]);
    assertEquals(':', data[83]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('A', data[81]);
    assertEquals('H', data[11]);
    assertEquals('P', data[0]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('X', data[82]);
    assertEquals('\b', data[7]);
    assertEquals('\b', data[74]);
    assertEquals('\r', data[15]);
    assertEquals('\r', data[20]);
    assertEquals('`', data[2]);
    assertEquals('`', data[Short.SIZE]);
    assertEquals('a', data[65]);
    assertEquals('c', data[66]);
    assertEquals('e', data[70]);
    assertEquals('i', data[68]);
    assertEquals('o', data[23]);
    assertEquals('t', data[67]);
    assertEquals('v', data[69]);
    assertEquals('w', data[24]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy35() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setIsWitness(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[13]);
    assertEquals((byte) -35, data[14]);
    assertEquals((byte) -46, data[4]);
    assertEquals((byte) -48, data[87]);
    assertEquals((byte) -6, data[18]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[6]);
    assertEquals((byte) 16, data[85]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[10]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[19]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[72]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[86]);
    assertEquals((byte) 24, data[9]);
    assertEquals((byte) 26, data[21]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[84]);
    assertEquals((byte) 2, data[88]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[22]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(90, instance.getSerializedSize());
    assertEquals(90, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[12]);
    assertEquals(' ', data[71]);
    assertEquals('*', data[89]);
    assertEquals('2', data[73]);
    assertEquals(':', data[83]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('A', data[81]);
    assertEquals('H', data[11]);
    assertEquals('P', data[0]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('X', data[82]);
    assertEquals('\b', data[7]);
    assertEquals('\b', data[74]);
    assertEquals('\r', data[15]);
    assertEquals('\r', data[20]);
    assertEquals('`', data[Short.SIZE]);
    assertEquals('a', data[65]);
    assertEquals('c', data[66]);
    assertEquals('e', data[70]);
    assertEquals('i', data[68]);
    assertEquals('o', data[23]);
    assertEquals('p', data[2]);
    assertEquals('t', data[67]);
    assertEquals('v', data[69]);
    assertEquals('w', data[24]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy36() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setIsCommittee(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[13]);
    assertEquals((byte) -35, data[14]);
    assertEquals((byte) -46, data[4]);
    assertEquals((byte) -48, data[87]);
    assertEquals((byte) -6, data[18]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[6]);
    assertEquals((byte) 16, data[85]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[10]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[19]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[72]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[86]);
    assertEquals((byte) 24, data[9]);
    assertEquals((byte) 26, data[21]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[84]);
    assertEquals((byte) 2, data[88]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[22]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(90, instance.getSerializedSize());
    assertEquals(90, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[12]);
    assertEquals(' ', data[71]);
    assertEquals('*', data[89]);
    assertEquals('2', data[73]);
    assertEquals(':', data[83]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('A', data[81]);
    assertEquals('H', data[11]);
    assertEquals('P', data[0]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('X', data[82]);
    assertEquals('\b', data[7]);
    assertEquals('\b', data[74]);
    assertEquals('\r', data[15]);
    assertEquals('\r', data[20]);
    assertEquals('`', data[Short.SIZE]);
    assertEquals('a', data[65]);
    assertEquals('c', data[66]);
    assertEquals('e', data[70]);
    assertEquals('i', data[68]);
    assertEquals('o', data[23]);
    assertEquals('t', data[67]);
    assertEquals('v', data[69]);
    assertEquals('w', data[24]);
    assertEquals('x', data[2]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy37() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setFrozen(42L, 1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[17]);
    assertEquals((byte) -35, data[18]);
    assertEquals((byte) -46, data[8]);
    assertEquals((byte) -48, data[91]);
    assertEquals((byte) -6, data[22]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[10]);
    assertEquals((byte) 16, data[4]);
    assertEquals((byte) 16, data[89]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[12]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[21]);
    assertEquals((byte) 1, data[23]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[7]);
    assertEquals((byte) 1, data[76]);
    assertEquals((byte) 1, data[9]);
    assertEquals((byte) 1, data[90]);
    assertEquals((byte) 24, data[13]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[88]);
    assertEquals((byte) 2, data[92]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 4, data[1]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(94, instance.getSerializedSize());
    assertEquals(94, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[Short.SIZE]);
    assertEquals(' ', data[75]);
    assertEquals('*', data[3]);
    assertEquals('*', data[93]);
    assertEquals('2', data[77]);
    assertEquals(':', data[0]);
    assertEquals(':', data[87]);
    assertEquals('A', data[79]);
    assertEquals('A', data[81]);
    assertEquals('A', data[83]);
    assertEquals('A', data[85]);
    assertEquals('H', data[15]);
    assertEquals('P', data[6]);
    assertEquals('X', data[80]);
    assertEquals('X', data[82]);
    assertEquals('X', data[84]);
    assertEquals('X', data[86]);
    assertEquals('\b', data[11]);
    assertEquals('\b', data[2]);
    assertEquals('\b', data[78]);
    assertEquals('\r', data[19]);
    assertEquals('\r', data[24]);
    assertEquals('`', data[20]);
    assertEquals('a', data[69]);
    assertEquals('c', data[70]);
    assertEquals('e', data[74]);
    assertEquals('i', data[72]);
    assertEquals('t', data[71]);
    assertEquals('v', data[73]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy38() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setNetUsage(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[13]);
    assertEquals((byte) -35, data[14]);
    assertEquals((byte) -46, data[4]);
    assertEquals((byte) -48, data[87]);
    assertEquals((byte) -6, data[18]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[6]);
    assertEquals((byte) 16, data[85]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[10]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[19]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[72]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[86]);
    assertEquals((byte) 24, data[9]);
    assertEquals((byte) 26, data[21]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[84]);
    assertEquals((byte) 2, data[88]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[22]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(90, instance.getSerializedSize());
    assertEquals(90, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[12]);
    assertEquals(' ', data[71]);
    assertEquals('*', data[89]);
    assertEquals('2', data[73]);
    assertEquals(':', data[83]);
    assertEquals('@', data[0]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('A', data[81]);
    assertEquals('H', data[11]);
    assertEquals('P', data[2]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('X', data[82]);
    assertEquals('\b', data[7]);
    assertEquals('\b', data[74]);
    assertEquals('\r', data[15]);
    assertEquals('\r', data[20]);
    assertEquals('`', data[Short.SIZE]);
    assertEquals('a', data[65]);
    assertEquals('c', data[66]);
    assertEquals('e', data[70]);
    assertEquals('i', data[68]);
    assertEquals('o', data[23]);
    assertEquals('t', data[67]);
    assertEquals('v', data[69]);
    assertEquals('w', data[24]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy39() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setFrozenForEnergy(42L, 10L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[17]);
    assertEquals((byte) -35, data[18]);
    assertEquals((byte) -46, data[2]);
    assertEquals((byte) -48, data[91]);
    assertEquals((byte) -6, data[22]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals((byte) 16, data[11]);
    assertEquals((byte) 16, data[89]);
    assertEquals(17, accountResource.getSerializedSize());
    assertEquals((byte) 17, data[4]);
    assertEquals((byte) 18, data[7]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[21]);
    assertEquals((byte) 1, data[23]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[76]);
    assertEquals((byte) 1, data[90]);
    assertEquals((byte) 24, data[13]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[88]);
    assertEquals((byte) 2, data[92]);
    assertEquals((byte) 4, data[8]);
    assertEquals(5, accountResource.getAllFields().size());
    assertEquals(6, instance.getAllFields().size());
    assertEquals(94, instance.getSerializedSize());
    assertEquals(94, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[Short.SIZE]);
    assertEquals(' ', data[75]);
    assertEquals('*', data[10]);
    assertEquals('*', data[93]);
    assertEquals('2', data[77]);
    assertEquals(':', data[87]);
    assertEquals('A', data[79]);
    assertEquals('A', data[81]);
    assertEquals('A', data[83]);
    assertEquals('A', data[85]);
    assertEquals('H', data[15]);
    assertEquals('P', data[0]);
    assertEquals('X', data[80]);
    assertEquals('X', data[82]);
    assertEquals('X', data[84]);
    assertEquals('X', data[86]);
    assertEquals('\b', data[5]);
    assertEquals('\b', data[78]);
    assertEquals('\b', data[9]);
    assertEquals('\n', data[12]);
    assertEquals('\r', data[19]);
    assertEquals('\r', data[24]);
    assertEquals('`', data[20]);
    assertEquals('a', data[69]);
    assertEquals('c', data[70]);
    assertEquals('e', data[74]);
    assertEquals('i', data[72]);
    assertEquals('t', data[71]);
    assertEquals('v', data[73]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy40() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setEnergyUsage(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -116, data[10]);
    assertEquals((byte) -28, data[11]);
    assertEquals((byte) -35, data[12]);
    assertEquals((byte) -46, data[2]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[Short.SIZE]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[4]);
    assertEquals((byte) 16, data[83]);
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[70]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[84]);
    assertEquals((byte) 24, data[7]);
    assertEquals((byte) 26, data[19]);
    assertEquals(28799500L, accountResource.getEnergyWindowSize());
    assertEquals(2L, accountCapsule.getEnergyUsage());
    assertEquals(2L, accountResource.getEnergyUsage());
    assertEquals((byte) 2, data[6]);
    assertEquals((byte) 2, data[82]);
    assertEquals((byte) 2, data[86]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[20]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(88, instance.getSerializedSize());
    assertEquals(88, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[69]);
    assertEquals('*', data[87]);
    assertEquals('2', data[71]);
    assertEquals(':', data[81]);
    assertEquals('A', data[73]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('H', data[9]);
    assertEquals('P', data[0]);
    assertEquals('X', data[74]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('\b', data[5]);
    assertEquals('\b', data[72]);
    assertEquals('\r', data[13]);
    assertEquals('\r', data[18]);
    assertEquals('`', data[14]);
    assertEquals('a', data[63]);
    assertEquals('c', data[Double.SIZE]);
    assertEquals('e', data[24]);
    assertEquals('e', data[68]);
    assertEquals('i', data[66]);
    assertEquals('n', data[23]);
    assertEquals('o', data[21]);
    assertEquals('t', data[65]);
    assertEquals('v', data[67]);
    assertEquals('w', data[22]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy41() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestConsumeTimeForEnergy(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[11]);
    assertEquals((byte) -35, data[12]);
    assertEquals((byte) -46, data[2]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[Short.SIZE]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[4]);
    assertEquals((byte) 16, data[83]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[70]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[84]);
    assertEquals((byte) 24, data[7]);
    assertEquals((byte) 26, data[19]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[82]);
    assertEquals((byte) 2, data[86]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[20]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(88, instance.getSerializedSize());
    assertEquals(88, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[10]);
    assertEquals(' ', data[69]);
    assertEquals('*', data[87]);
    assertEquals('2', data[71]);
    assertEquals(':', data[81]);
    assertEquals('A', data[73]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('H', data[9]);
    assertEquals('P', data[0]);
    assertEquals('X', data[74]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('\b', data[5]);
    assertEquals('\b', data[72]);
    assertEquals('\r', data[13]);
    assertEquals('\r', data[18]);
    assertEquals('`', data[14]);
    assertEquals('a', data[63]);
    assertEquals('c', data[Double.SIZE]);
    assertEquals('e', data[24]);
    assertEquals('e', data[68]);
    assertEquals('i', data[66]);
    assertEquals('n', data[23]);
    assertEquals('o', data[21]);
    assertEquals('t', data[65]);
    assertEquals('v', data[67]);
    assertEquals('w', data[22]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy42() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setFreeNetUsage(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -104, data[2]);
    assertEquals((byte) -24, data[14]);
    assertEquals((byte) -35, data[15]);
    assertEquals((byte) -46, data[5]);
    assertEquals((byte) -48, data[88]);
    assertEquals((byte) -6, data[19]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[7]);
    assertEquals((byte) 16, data[86]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[18]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[73]);
    assertEquals((byte) 1, data[87]);
    assertEquals((byte) 1, data[9]);
    assertEquals((byte) 24, data[10]);
    assertEquals((byte) 26, data[22]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[85]);
    assertEquals((byte) 2, data[89]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[23]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(91, instance.getSerializedSize());
    assertEquals(91, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[13]);
    assertEquals(' ', data[72]);
    assertEquals('*', data[90]);
    assertEquals('2', data[74]);
    assertEquals(':', data[84]);
    assertEquals('A', data[76]);
    assertEquals('A', data[78]);
    assertEquals('A', data[80]);
    assertEquals('A', data[82]);
    assertEquals('H', data[12]);
    assertEquals('P', data[0]);
    assertEquals('X', data[77]);
    assertEquals('X', data[79]);
    assertEquals('X', data[81]);
    assertEquals('X', data[83]);
    assertEquals('\b', data[75]);
    assertEquals('\b', data[8]);
    assertEquals('\r', data[21]);
    assertEquals('\r', data[Short.SIZE]);
    assertEquals('`', data[17]);
    assertEquals('a', data[66]);
    assertEquals('c', data[67]);
    assertEquals('e', data[71]);
    assertEquals('i', data[69]);
    assertEquals('o', data[24]);
    assertEquals('t', data[68]);
    assertEquals('v', data[70]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy43() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setStorageLimit(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[13]);
    assertEquals((byte) -35, data[14]);
    assertEquals((byte) -46, data[2]);
    assertEquals((byte) -48, data[87]);
    assertEquals((byte) -6, data[18]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(13, accountResource.getSerializedSize());
    assertEquals((byte) 16, data[85]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[10]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[19]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[72]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[86]);
    assertEquals((byte) 24, data[7]);
    assertEquals((byte) 26, data[21]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[84]);
    assertEquals((byte) 2, data[88]);
    assertEquals(5, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[22]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(90, instance.getSerializedSize());
    assertEquals(90, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[12]);
    assertEquals(' ', data[71]);
    assertEquals('*', data[89]);
    assertEquals('0', data[9]);
    assertEquals('2', data[73]);
    assertEquals(':', data[83]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('A', data[81]);
    assertEquals('H', data[11]);
    assertEquals('P', data[0]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('X', data[82]);
    assertEquals('\b', data[5]);
    assertEquals('\b', data[74]);
    assertEquals('\r', data[15]);
    assertEquals('\r', data[20]);
    assertEquals('\r', data[4]);
    assertEquals('`', data[Short.SIZE]);
    assertEquals('a', data[65]);
    assertEquals('c', data[66]);
    assertEquals('e', data[70]);
    assertEquals('i', data[68]);
    assertEquals('o', data[23]);
    assertEquals('t', data[67]);
    assertEquals('v', data[69]);
    assertEquals('w', data[24]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy44() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestExchangeStorageTime(10L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[13]);
    assertEquals((byte) -35, data[14]);
    assertEquals((byte) -46, data[2]);
    assertEquals((byte) -48, data[87]);
    assertEquals((byte) -6, data[18]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(13, accountResource.getSerializedSize());
    assertEquals((byte) 16, data[85]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[19]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[72]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[86]);
    assertEquals((byte) 24, data[7]);
    assertEquals((byte) 26, data[21]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[84]);
    assertEquals((byte) 2, data[88]);
    assertEquals(5, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[22]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(90, instance.getSerializedSize());
    assertEquals(90, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[12]);
    assertEquals(' ', data[71]);
    assertEquals('*', data[89]);
    assertEquals('2', data[73]);
    assertEquals(':', data[83]);
    assertEquals('@', data[9]);
    assertEquals('A', data[75]);
    assertEquals('A', data[77]);
    assertEquals('A', data[79]);
    assertEquals('A', data[81]);
    assertEquals('H', data[11]);
    assertEquals('P', data[0]);
    assertEquals('X', data[76]);
    assertEquals('X', data[78]);
    assertEquals('X', data[80]);
    assertEquals('X', data[82]);
    assertEquals('\b', data[5]);
    assertEquals('\b', data[74]);
    assertEquals('\n', data[10]);
    assertEquals('\r', data[15]);
    assertEquals('\r', data[20]);
    assertEquals('\r', data[4]);
    assertEquals('`', data[Short.SIZE]);
    assertEquals('a', data[65]);
    assertEquals('c', data[66]);
    assertEquals('e', data[70]);
    assertEquals('i', data[68]);
    assertEquals('o', data[23]);
    assertEquals('t', data[67]);
    assertEquals('v', data[69]);
    assertEquals('w', data[24]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy45() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setNewWindowSize(Common.ResourceCode.BANDWIDTH, 3L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[14]);
    assertEquals((byte) -35, data[15]);
    assertEquals((byte) -46, data[5]);
    assertEquals((byte) -48, data[88]);
    assertEquals((byte) -64, data[2]);
    assertEquals((byte) -6, data[19]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[7]);
    assertEquals((byte) 16, data[86]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[18]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[73]);
    assertEquals((byte) 1, data[87]);
    assertEquals((byte) 1, data[9]);
    assertEquals((byte) 24, data[10]);
    assertEquals((byte) 26, data[22]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[85]);
    assertEquals((byte) 2, data[89]);
    assertEquals((byte) 3, data[4]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[23]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(91, instance.getSerializedSize());
    assertEquals(91, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[13]);
    assertEquals(' ', data[72]);
    assertEquals('*', data[90]);
    assertEquals('2', data[74]);
    assertEquals(':', data[84]);
    assertEquals('A', data[76]);
    assertEquals('A', data[78]);
    assertEquals('A', data[80]);
    assertEquals('A', data[82]);
    assertEquals('H', data[12]);
    assertEquals('P', data[0]);
    assertEquals('X', data[77]);
    assertEquals('X', data[79]);
    assertEquals('X', data[81]);
    assertEquals('X', data[83]);
    assertEquals('\b', data[75]);
    assertEquals('\b', data[8]);
    assertEquals('\r', data[21]);
    assertEquals('\r', data[Short.SIZE]);
    assertEquals('`', data[17]);
    assertEquals('a', data[66]);
    assertEquals('c', data[67]);
    assertEquals('e', data[71]);
    assertEquals('i', data[69]);
    assertEquals('o', data[24]);
    assertEquals('t', data[68]);
    assertEquals('v', data[70]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#useEnergy(AccountCapsule, long, long)}
   */
  @Test
  public void testUseEnergy46() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBlockEnergyUsage()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveBlockEnergyUsage(anyLong());
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowAdaptiveEnergy()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowTvmFreeze()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, accountStore);
    DynamicPropertiesStore dynamicPropertiesStore2 = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore2.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setWindowOptimized(Common.ResourceCode.BANDWIDTH, true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore2);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    boolean actualUseEnergyResult = energyProcessor.useEnergy(accountCapsule, 1L, 1L);

    // Assert
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
    verify(dynamicPropertiesStore2).getActiveDefaultOperations();
    verify(dynamicPropertiesStore).getAllowAdaptiveEnergy();
    verify(dynamicPropertiesStore).getAllowTvmFreeze();
    verify(dynamicPropertiesStore).getBlockEnergyUsage();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).saveBlockEnergyUsage(eq(2L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore, atLeast(1)).supportUnfreezeDelay();
    Protocol.Account.AccountResource accountResource = accountCapsule.getAccountResource();
    Protocol.Account.AccountResource defaultInstanceForType = accountResource.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -24, data[14]);
    assertEquals((byte) -35, data[15]);
    assertEquals((byte) -46, data[5]);
    assertEquals((byte) -48, data[88]);
    assertEquals((byte) -56, data[2]);
    assertEquals((byte) -6, data[19]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyWindowSize());
    assertEquals(0L, defaultInstanceForType.getLatestConsumeTimeForEnergy());
    assertEquals(0L, defaultInstanceForType.getLatestExchangeStorageTime());
    assertEquals(0L, defaultInstanceForType.getStorageLimit());
    assertEquals(0L, defaultInstanceForType.getStorageUsage());
    assertEquals(11, accountResource.getSerializedSize());
    assertEquals((byte) 11, data[7]);
    assertEquals((byte) 16, data[86]);
    assertEquals(1L, accountCapsule.getEnergyUsage());
    assertEquals(1L, accountCapsule.getLatestConsumeTimeForEnergy());
    assertEquals(1L, accountCapsule.getLatestOperationTime());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1L, instance.getLatestOprationTime());
    assertEquals(1L, accountResource.getEnergyUsage());
    assertEquals(1L, accountResource.getLatestConsumeTimeForEnergy());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[18]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[73]);
    assertEquals((byte) 1, data[87]);
    assertEquals((byte) 1, data[9]);
    assertEquals((byte) 24, data[10]);
    assertEquals((byte) 26, data[22]);
    assertEquals(28800000L, accountResource.getEnergyWindowSize());
    assertEquals((byte) 2, data[85]);
    assertEquals((byte) 2, data[89]);
    assertEquals(4, accountResource.getAllFields().size());
    assertEquals((byte) 5, data[23]);
    assertEquals(7, instance.getAllFields().size());
    assertEquals(91, instance.getSerializedSize());
    assertEquals(91, data.length);
    assertFalse(defaultInstanceForType.getEnergyWindowOptimized());
    assertFalse(defaultInstanceForType.hasFrozenBalanceForEnergy());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualUseEnergyResult);
    assertTrue(instance.hasAccountResource());
    assertTrue(accountResource.getEnergyWindowOptimized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Byte.MIN_VALUE, data[13]);
    assertEquals(' ', data[72]);
    assertEquals('*', data[90]);
    assertEquals('2', data[74]);
    assertEquals(':', data[84]);
    assertEquals('A', data[76]);
    assertEquals('A', data[78]);
    assertEquals('A', data[80]);
    assertEquals('A', data[82]);
    assertEquals('H', data[12]);
    assertEquals('P', data[0]);
    assertEquals('X', data[77]);
    assertEquals('X', data[79]);
    assertEquals('X', data[81]);
    assertEquals('X', data[83]);
    assertEquals('\b', data[75]);
    assertEquals('\b', data[8]);
    assertEquals('\r', data[21]);
    assertEquals('\r', data[Short.SIZE]);
    assertEquals('`', data[17]);
    assertEquals('a', data[66]);
    assertEquals('c', data[67]);
    assertEquals('e', data[71]);
    assertEquals('i', data[69]);
    assertEquals('o', data[24]);
    assertEquals('t', data[68]);
    assertEquals('v', data[70]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class));

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor
        .calculateGlobalEnergyLimit(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenThrow(new RuntimeException("foo"));
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> energyProcessor.calculateGlobalEnergyLimit(new AccountCapsule(Protocol.Account.getDefaultInstance())));
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(0L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class));

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor
        .calculateGlobalEnergyLimit(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class));

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor
        .calculateGlobalEnergyLimit(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit5() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addFrozenBalanceForBandwidthV2(42L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit6() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAcquiredDelegatedFrozenBalanceForEnergy(42L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit7() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addFrozenBalanceForEnergyV2(42L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit8() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setFrozenForEnergy(42L, 10L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit9() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addFrozenBalanceForEnergyV2(2L);
    accountCapsule.addFrozenBalanceForBandwidthV2(42L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimitV2(long)}
   */
  @Test
  public void testCalculateGlobalEnergyLimitV2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);

    // Act
    long actualCalculateGlobalEnergyLimitV2Result = (new EnergyProcessor(dynamicPropertiesStore,
        mock(AccountStore.class))).calculateGlobalEnergyLimitV2(42L);

    // Assert
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    assertEquals(0L, actualCalculateGlobalEnergyLimitV2Result);
  }

  /**
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimitV2(long)}
   */
  @Test
  public void testCalculateGlobalEnergyLimitV22() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(0L);

    // Act
    long actualCalculateGlobalEnergyLimitV2Result = (new EnergyProcessor(dynamicPropertiesStore,
        mock(AccountStore.class))).calculateGlobalEnergyLimitV2(42L);

    // Assert
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    assertEquals(0L, actualCalculateGlobalEnergyLimitV2Result);
  }

  /**
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimitV2(long)}
   */
  @Test
  public void testCalculateGlobalEnergyLimitV23() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class)))
        .calculateGlobalEnergyLimitV2(42L));
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
  }

  /**
   * Method under test:
   * {@link EnergyProcessor#EnergyProcessor(DynamicPropertiesStore, AccountStore)}
   */
  @Test
  public void testNewEnergyProcessor() {
    // Arrange and Act
    EnergyProcessor actualEnergyProcessor = new EnergyProcessor(null, null);

    // Assert
    assertNull(actualEnergyProcessor.accountStore);
    assertNull(actualEnergyProcessor.dynamicPropertiesStore);
    assertEquals(1000000L, actualEnergyProcessor.precision);
    assertEquals(20L, actualEnergyProcessor.averageWindowSize);
    assertEquals(28800L, actualEnergyProcessor.windowSize);
  }
}
