package org.tron.core.vm.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class FreezeV2UtilDiffblueTest {
  /**
   * Test {@link FreezeV2Util#queryExpireUnfreezeBalanceV2(byte[], long, Repository)}.
   *
   * <p>Method under test: {@link FreezeV2Util#queryExpireUnfreezeBalanceV2(byte[], long,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FreezeV2Util.queryExpireUnfreezeBalanceV2(byte[], long, Repository)"})
  public void testQueryExpireUnfreezeBalanceV2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl repository =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act and Assert
    assertEquals(0L, FreezeV2Util.queryExpireUnfreezeBalanceV2(address, 10L, repository));
  }

  /**
   * Test {@link FreezeV2Util#queryUnfreezableBalanceV2(byte[], long, Repository)}.
   *
   * <p>Method under test: {@link FreezeV2Util#queryUnfreezableBalanceV2(byte[], long, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FreezeV2Util.queryUnfreezableBalanceV2(byte[], long, Repository)"})
  public void testQueryUnfreezableBalanceV2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl repository =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act and Assert
    assertEquals(0L, FreezeV2Util.queryUnfreezableBalanceV2(address, 1L, repository));
  }

  /**
   * Test {@link FreezeV2Util#queryResourceV2(byte[], byte[], long, Repository)}.
   *
   * <p>Method under test: {@link FreezeV2Util#queryResourceV2(byte[], byte[], long, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FreezeV2Util.queryResourceV2(byte[], byte[], long, Repository)"})
  public void testQueryResourceV2() throws UnsupportedEncodingException {
    // Arrange
    byte[] from = "AXAXAXAX".getBytes("UTF-8");
    byte[] resultTo = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl repository =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    long actualQueryResourceV2Result = FreezeV2Util.queryResourceV2(from, resultTo, 1L, repository);

    // Assert
    assertEquals(0L, actualQueryResourceV2Result);
  }

  /**
   * Test {@link FreezeV2Util#queryFrozenBalanceUsage(byte[], long, Repository)}.
   *
   * <p>Method under test: {@link FreezeV2Util#queryFrozenBalanceUsage(byte[], long, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair FreezeV2Util.queryFrozenBalanceUsage(byte[], long, Repository)"})
  public void testQueryFrozenBalanceUsage() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl repository =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    Pair<Long, Long> actualQueryFrozenBalanceUsageResult =
        FreezeV2Util.queryFrozenBalanceUsage(address, 1L, repository);

    // Assert
    assertTrue(actualQueryFrozenBalanceUsageResult instanceof ImmutablePair);
    assertEquals(0L, actualQueryFrozenBalanceUsageResult.getKey().longValue());
    assertEquals(0L, actualQueryFrozenBalanceUsageResult.getLeft().longValue());
    assertEquals(0L, actualQueryFrozenBalanceUsageResult.getRight().longValue());
    assertEquals(0L, actualQueryFrozenBalanceUsageResult.getValue().longValue());
  }

  /**
   * Test {@link FreezeV2Util#queryAvailableUnfreezeV2Size(byte[], Repository)}.
   *
   * <p>Method under test: {@link FreezeV2Util#queryAvailableUnfreezeV2Size(byte[], Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FreezeV2Util.queryAvailableUnfreezeV2Size(byte[], Repository)"})
  public void testQueryAvailableUnfreezeV2Size() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl repository =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    long actualQueryAvailableUnfreezeV2SizeResult =
        FreezeV2Util.queryAvailableUnfreezeV2Size(address, repository);

    // Assert
    assertEquals(0L, actualQueryAvailableUnfreezeV2SizeResult);
  }

  /**
   * Test {@link FreezeV2Util#queryDelegatableResource(byte[], long, Repository)}.
   *
   * <p>Method under test: {@link FreezeV2Util#queryDelegatableResource(byte[], long, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FreezeV2Util.queryDelegatableResource(byte[], long, Repository)"})
  public void testQueryDelegatableResource() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl repository =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act and Assert
    assertEquals(0L, FreezeV2Util.queryDelegatableResource(address, 1L, repository));
  }

  /**
   * Test {@link FreezeV2Util#checkUndelegateResource(byte[], long, long, Repository)}.
   *
   * <p>Method under test: {@link FreezeV2Util#checkUndelegateResource(byte[], long, long,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Triple FreezeV2Util.checkUndelegateResource(byte[], long, long, Repository)"})
  public void testCheckUndelegateResource() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl repository =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    Triple<Long, Long, Long> actualCheckUndelegateResourceResult =
        FreezeV2Util.checkUndelegateResource(address, 10L, 1L, repository);

    // Assert
    assertTrue(actualCheckUndelegateResourceResult instanceof ImmutableTriple);
    assertEquals(0L, actualCheckUndelegateResourceResult.getLeft().longValue());
    assertEquals(0L, actualCheckUndelegateResourceResult.getMiddle().longValue());
    assertEquals(0L, actualCheckUndelegateResourceResult.getRight().longValue());
  }

  /**
   * Test {@link FreezeV2Util#getV2NetUsage(AccountCapsule, long)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link FreezeV2Util#getV2NetUsage(AccountCapsule, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FreezeV2Util.getV2NetUsage(AccountCapsule, long)"})
  public void testGetV2NetUsage_givenOne_thenReturnZero() {
    // Arrange
    AccountCapsule ownerCapsule = mock(AccountCapsule.class);
    when(ownerCapsule.getAcquiredDelegatedFrozenBalanceForBandwidth()).thenReturn(1L);
    when(ownerCapsule.getAcquiredDelegatedFrozenV2BalanceForBandwidth()).thenReturn(1L);
    when(ownerCapsule.getFrozenBalance()).thenReturn(42L);

    // Act
    long actualV2NetUsage = FreezeV2Util.getV2NetUsage(ownerCapsule, 1L);

    // Assert
    verify(ownerCapsule).getAcquiredDelegatedFrozenBalanceForBandwidth();
    verify(ownerCapsule).getAcquiredDelegatedFrozenV2BalanceForBandwidth();
    verify(ownerCapsule).getFrozenBalance();
    assertEquals(0L, actualV2NetUsage);
  }

  /**
   * Test {@link FreezeV2Util#getV2EnergyUsage(AccountCapsule, long)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link FreezeV2Util#getV2EnergyUsage(AccountCapsule, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FreezeV2Util.getV2EnergyUsage(AccountCapsule, long)"})
  public void testGetV2EnergyUsage_givenFortyTwo_thenReturnZero() {
    // Arrange
    AccountCapsule ownerCapsule = mock(AccountCapsule.class);
    when(ownerCapsule.getAcquiredDelegatedFrozenBalanceForEnergy()).thenReturn(42L);
    when(ownerCapsule.getAcquiredDelegatedFrozenV2BalanceForEnergy()).thenReturn(42L);
    when(ownerCapsule.getEnergyFrozenBalance()).thenReturn(42L);

    // Act
    long actualV2EnergyUsage = FreezeV2Util.getV2EnergyUsage(ownerCapsule, 1L);

    // Assert
    verify(ownerCapsule).getAcquiredDelegatedFrozenBalanceForEnergy();
    verify(ownerCapsule).getAcquiredDelegatedFrozenV2BalanceForEnergy();
    verify(ownerCapsule).getEnergyFrozenBalance();
    assertEquals(0L, actualV2EnergyUsage);
  }
}
