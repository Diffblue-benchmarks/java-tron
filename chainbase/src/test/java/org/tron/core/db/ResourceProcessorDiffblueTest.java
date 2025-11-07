package org.tron.core.db;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.AccountCapsule;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.Common;

public class ResourceProcessorDiffblueTest {
  /**
   * Method under test: {@link ResourceProcessor#increase(long, long, long, long)}
   */
  @Test
  public void testIncrease() {
    // Arrange, Act and Assert
    assertEquals(10L, (new BandwidthProcessor(new ChainBaseManager())).increase(5L, 5L, 5L, 5L));
    assertEquals(17605L, (new BandwidthProcessor(new ChainBaseManager())).increase(17600L, 5L, 5L, 5L));
    assertEquals(6L, (new BandwidthProcessor(new ChainBaseManager())).increase(1L, 5L, 5L, 5L));
    assertEquals(5L, (new BandwidthProcessor(new ChainBaseManager())).increase(0L, 5L, 5L, 5L));
    assertEquals(10L, (new BandwidthProcessor(new ChainBaseManager())).increase(5L, 5L, 1L, 5L));
    assertEquals(5L, (new BandwidthProcessor(new ChainBaseManager())).increase(5L, 5L, 17600L, Long.MAX_VALUE));
    assertEquals(10L, (new BandwidthProcessor(new ChainBaseManager())).increase(5L, 5L, 5L, 5L, 3L));
    assertEquals(7L, (new BandwidthProcessor(new ChainBaseManager())).increase(2L, 5L, 5L, 5L, 3L));
    assertEquals(6L, (new BandwidthProcessor(new ChainBaseManager())).increase(1L, 5L, 5L, 5L, 3L));
    assertEquals(5L, (new BandwidthProcessor(new ChainBaseManager())).increase(0L, 5L, 5L, 5L, 3L));
    assertEquals(5L, (new BandwidthProcessor(new ChainBaseManager())).increase(5L, 5L, 2L, 5L, 3L));
  }

  /**
   * Method under test:
   * {@link ResourceProcessor#recovery(AccountCapsule, Common.ResourceCode, long, long, long)}
   */
  @Test
  public void testRecovery() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());

    // Act and Assert
    assertEquals(1L, bandwidthProcessor.recovery(new AccountCapsule(Protocol.Account.getDefaultInstance()),
        Common.ResourceCode.BANDWIDTH, 1L, 1L, 1L));
  }

  /**
   * Method under test:
   * {@link ResourceProcessor#recovery(AccountCapsule, Common.ResourceCode, long, long, long)}
   */
  @Test
  public void testRecovery2() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());

    // Act and Assert
    assertEquals(1L, bandwidthProcessor.recovery(new AccountCapsule(Protocol.Account.getDefaultInstance()),
        Common.ResourceCode.ENERGY, 1L, 1L, 1L));
  }

  /**
   * Method under test:
   * {@link ResourceProcessor#increaseV2(AccountCapsule, Common.ResourceCode, long, long, long, long)}
   */
  @Test
  public void testIncreaseV2() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());
    Protocol.Account account = Protocol.Account.getDefaultInstance();
    AccountCapsule accountCapsule = new AccountCapsule(account);

    // Act
    long actualIncreaseV2Result = bandwidthProcessor.increaseV2(accountCapsule, Common.ResourceCode.BANDWIDTH, 1L, 1L,
        1L, 1L);

    // Assert
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800000L, instance.getNetWindowSize());
    assertEquals(2L, actualIncreaseV2Result);
    assertEquals(9, instance.getSerializedSize());
    assertTrue(instance.getNetWindowOptimized());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-64, 1, Byte.MIN_VALUE, -24, -35, '\r', -56, 1, 1}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ResourceProcessor#increaseV2(AccountCapsule, Common.ResourceCode, long, long, long, long)}
   */
  @Test
  public void testIncreaseV22() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());
    AccountCapsule accountCapsule = new AccountCapsule(AccountContract.AccountCreateContract.getDefaultInstance());

    // Act
    long actualIncreaseV2Result = bandwidthProcessor.increaseV2(accountCapsule, Common.ResourceCode.BANDWIDTH, 1L, 1L,
        1L, 1L);

    // Assert
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28800000L, instance.getNetWindowSize());
    assertEquals(2L, actualIncreaseV2Result);
    assertEquals(9, instance.getSerializedSize());
    assertTrue(instance.getNetWindowOptimized());
    assertArrayEquals(new byte[]{-64, 1, Byte.MIN_VALUE, -24, -35, '\r', -56, 1, 1}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ResourceProcessor#increaseV2(AccountCapsule, Common.ResourceCode, long, long, long, long)}
   */
  @Test
  public void testIncreaseV23() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(3L);

    // Act
    long actualIncreaseV2Result = bandwidthProcessor.increaseV2(accountCapsule, Common.ResourceCode.BANDWIDTH, 1L, 1L,
        1L, 1L);

    // Assert
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(28800000L, instance.getNetWindowSize());
    assertEquals(2L, actualIncreaseV2Result);
    assertEquals(3, instance.getAllFields().size());
    assertTrue(instance.getNetWindowOptimized());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-64, 1, Byte.MIN_VALUE, -24, -35, '\r', -56, 1, 1, -48, 2, 3},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ResourceProcessor#increaseV2(AccountCapsule, Common.ResourceCode, long, long, long, long)}
   */
  @Test
  public void testIncreaseV24() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addDelegatedFrozenV2BalanceForBandwidth(3L);

    // Act
    long actualIncreaseV2Result = bandwidthProcessor.increaseV2(accountCapsule, Common.ResourceCode.BANDWIDTH, 1L, 1L,
        1L, 1L);

    // Assert
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(28800000L, instance.getNetWindowSize());
    assertEquals(2L, actualIncreaseV2Result);
    assertEquals(3, instance.getAllFields().size());
    assertTrue(instance.getNetWindowOptimized());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-64, 1, Byte.MIN_VALUE, -24, -35, '\r', -56, 1, 1, -96, 2, 3},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ResourceProcessor#increaseV2(AccountCapsule, Common.ResourceCode, long, long, long, long)}
   */
  @Test
  public void testIncreaseV25() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addFrozenBalanceForBandwidthV2(3L);

    // Act
    long actualIncreaseV2Result = bandwidthProcessor.increaseV2(accountCapsule, Common.ResourceCode.BANDWIDTH, 1L, 1L,
        1L, 1L);

    // Assert
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(14, instance.getSerializedSize());
    assertEquals(28800000L, instance.getNetWindowSize());
    assertEquals(2L, actualIncreaseV2Result);
    assertEquals(3, instance.getAllFields().size());
    assertTrue(instance.getNetWindowOptimized());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-64, 1, Byte.MIN_VALUE, -24, -35, '\r', -56, 1, 1, -110, 2, 2, 16, 3},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ResourceProcessor#increaseV2(AccountCapsule, Common.ResourceCode, long, long, long, long)}
   */
  @Test
  public void testIncreaseV26() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenBalanceForBandwidth(3L);

    // Act
    long actualIncreaseV2Result = bandwidthProcessor.increaseV2(accountCapsule, Common.ResourceCode.BANDWIDTH, 1L, 1L,
        1L, 1L);

    // Assert
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(28800000L, instance.getNetWindowSize());
    assertEquals(2L, actualIncreaseV2Result);
    assertEquals(3, instance.getAllFields().size());
    assertTrue(instance.getNetWindowOptimized());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-64, 1, Byte.MIN_VALUE, -24, -35, '\r', -56, 1, 1, -56, 2, 3},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ResourceProcessor#increaseV2(AccountCapsule, Common.ResourceCode, long, long, long, long)}
   */
  @Test
  public void testIncreaseV27() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenV2BalanceForBandwidth(3L);

    // Act
    long actualIncreaseV2Result = bandwidthProcessor.increaseV2(accountCapsule, Common.ResourceCode.BANDWIDTH, 1L, 1L,
        1L, 1L);

    // Assert
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(28800000L, instance.getNetWindowSize());
    assertEquals(2L, actualIncreaseV2Result);
    assertEquals(3, instance.getAllFields().size());
    assertTrue(instance.getNetWindowOptimized());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-64, 1, Byte.MIN_VALUE, -24, -35, '\r', -56, 1, 1, -88, 2, 3},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ResourceProcessor#increaseV2(AccountCapsule, Common.ResourceCode, long, long, long, long)}
   */
  @Test
  public void testIncreaseV28() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenBalanceForEnergy(3L);

    // Act
    long actualIncreaseV2Result = bandwidthProcessor.increaseV2(accountCapsule, Common.ResourceCode.BANDWIDTH, 1L, 1L,
        1L, 1L);

    // Assert
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(14, instance.getSerializedSize());
    assertEquals(28800000L, instance.getNetWindowSize());
    assertEquals(2L, actualIncreaseV2Result);
    assertEquals(3, instance.getAllFields().size());
    assertTrue(instance.getNetWindowOptimized());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-64, 1, Byte.MIN_VALUE, -24, -35, '\r', -56, 1, 1, -46, 1, 2, ' ', 3},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ResourceProcessor#increaseV2(AccountCapsule, Common.ResourceCode, long, long, long, long)}
   */
  @Test
  public void testIncreaseV29() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addUnfrozenV2List(Common.ResourceCode.ENERGY, 28800000L, 28800000L);

    // Act
    long actualIncreaseV2Result = bandwidthProcessor.increaseV2(accountCapsule, Common.ResourceCode.BANDWIDTH, 1L, 1L,
        1L, 1L);

    // Assert
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(24, instance.getSerializedSize());
    assertEquals(28800000L, instance.getNetWindowSize());
    assertEquals(2L, actualIncreaseV2Result);
    assertEquals(3, instance.getAllFields().size());
    assertTrue(instance.getNetWindowOptimized());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-64, 1, Byte.MIN_VALUE, -24, -35, '\r', -56, 1, 1, -102, 2, '\f', '\b', 1, 24,
        Byte.MIN_VALUE, -24, -35, '\r', ' ', Byte.MIN_VALUE, -24, -35, '\r'}, accountCapsule.getData());
  }
}
