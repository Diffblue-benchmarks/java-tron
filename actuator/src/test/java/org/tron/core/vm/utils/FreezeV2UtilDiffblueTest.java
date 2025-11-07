package org.tron.core.vm.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AccountContract;

public class FreezeV2UtilDiffblueTest {
  /**
   * Method under test:
   * {@link FreezeV2Util#queryExpireUnfreezeBalanceV2(byte[], long, Repository)}
   */
  @Test
  public void testQueryExpireUnfreezeBalanceV2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L, FreezeV2Util.queryExpireUnfreezeBalanceV2(address, 10L,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link FreezeV2Util#queryUnfreezableBalanceV2(byte[], long, Repository)}
   */
  @Test
  public void testQueryUnfreezableBalanceV2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L, FreezeV2Util.queryUnfreezableBalanceV2(address, 1L,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link FreezeV2Util#queryResourceV2(byte[], byte[], long, Repository)}
   */
  @Test
  public void testQueryResourceV2() throws UnsupportedEncodingException {
    // Arrange
    byte[] from = "AXAXAXAX".getBytes("UTF-8");
    byte[] resultTo = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L, FreezeV2Util.queryResourceV2(from, resultTo, 1L,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link FreezeV2Util#queryFrozenBalanceUsage(byte[], long, Repository)}
   */
  @Test
  public void testQueryFrozenBalanceUsage() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Pair<Long, Long> actualQueryFrozenBalanceUsageResult = FreezeV2Util.queryFrozenBalanceUsage(address, 1L,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)));

    // Assert
    assertTrue(actualQueryFrozenBalanceUsageResult instanceof ImmutablePair);
    assertEquals(0L, actualQueryFrozenBalanceUsageResult.getKey().longValue());
    assertEquals(0L, actualQueryFrozenBalanceUsageResult.getLeft().longValue());
    assertEquals(0L, actualQueryFrozenBalanceUsageResult.getRight().longValue());
    assertEquals(0L, actualQueryFrozenBalanceUsageResult.getValue().longValue());
  }

  /**
   * Method under test:
   * {@link FreezeV2Util#queryAvailableUnfreezeV2Size(byte[], Repository)}
   */
  @Test
  public void testQueryAvailableUnfreezeV2Size() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L, FreezeV2Util.queryAvailableUnfreezeV2Size(address,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link FreezeV2Util#queryDelegatableResource(byte[], long, Repository)}
   */
  @Test
  public void testQueryDelegatableResource() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L, FreezeV2Util.queryDelegatableResource(address, 1L,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link FreezeV2Util#checkUndelegateResource(byte[], long, long, Repository)}
   */
  @Test
  public void testCheckUndelegateResource() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Triple<Long, Long, Long> actualCheckUndelegateResourceResult = FreezeV2Util.checkUndelegateResource(address, 10L,
        1L, new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)));

    // Assert
    assertTrue(actualCheckUndelegateResourceResult instanceof ImmutableTriple);
    assertEquals(0L, actualCheckUndelegateResourceResult.getLeft().longValue());
    assertEquals(0L, actualCheckUndelegateResourceResult.getMiddle().longValue());
    assertEquals(0L, actualCheckUndelegateResourceResult.getRight().longValue());
  }

  /**
   * Method under test: {@link FreezeV2Util#getV2NetUsage(AccountCapsule, long)}
   */
  @Test
  public void testGetV2NetUsage() {
    // Arrange, Act and Assert
    assertEquals(1L, FreezeV2Util.getV2NetUsage(new AccountCapsule(Protocol.Account.getDefaultInstance()), 1L));
  }

  /**
   * Method under test: {@link FreezeV2Util#getV2NetUsage(AccountCapsule, long)}
   */
  @Test
  public void testGetV2NetUsage2() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule ownerCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    ownerCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);

    // Act
    long actualV2NetUsage = FreezeV2Util.getV2NetUsage(ownerCapsule, 1L);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    assertEquals(1L, actualV2NetUsage);
  }

  /**
   * Method under test: {@link FreezeV2Util#getV2NetUsage(AccountCapsule, long)}
   */
  @Test
  public void testGetV2NetUsage3() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule ownerCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    ownerCapsule.setFrozen(42L, 1L);
    ownerCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);

    // Act
    long actualV2NetUsage = FreezeV2Util.getV2NetUsage(ownerCapsule, 1L);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    assertEquals(0L, actualV2NetUsage);
  }

  /**
   * Method under test:
   * {@link FreezeV2Util#getV2EnergyUsage(AccountCapsule, long)}
   */
  @Test
  public void testGetV2EnergyUsage() {
    // Arrange, Act and Assert
    assertEquals(1L, FreezeV2Util.getV2EnergyUsage(new AccountCapsule(Protocol.Account.getDefaultInstance()), 1L));
    assertEquals(1L, FreezeV2Util
        .getV2EnergyUsage(new AccountCapsule(AccountContract.AccountCreateContract.getDefaultInstance()), 1L));
  }

  /**
   * Method under test:
   * {@link FreezeV2Util#getV2EnergyUsage(AccountCapsule, long)}
   */
  @Test
  public void testGetV2EnergyUsage2() {
    // Arrange
    AccountCapsule ownerCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    ownerCapsule.addAcquiredDelegatedFrozenBalanceForEnergy(42L);

    // Act and Assert
    assertEquals(0L, FreezeV2Util.getV2EnergyUsage(ownerCapsule, 1L));
  }

  /**
   * Method under test:
   * {@link FreezeV2Util#getV2EnergyUsage(AccountCapsule, long)}
   */
  @Test
  public void testGetV2EnergyUsage3() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule ownerCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    ownerCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    ownerCapsule.addAcquiredDelegatedFrozenBalanceForEnergy(42L);

    // Act
    long actualV2EnergyUsage = FreezeV2Util.getV2EnergyUsage(ownerCapsule, 1L);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    assertEquals(0L, actualV2EnergyUsage);
  }

  /**
   * Method under test:
   * {@link FreezeV2Util#getV2EnergyUsage(AccountCapsule, long)}
   */
  @Test
  public void testGetV2EnergyUsage4() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule ownerCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    ownerCapsule.setFrozenForEnergy(42L, 10L);
    ownerCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    ownerCapsule.addAcquiredDelegatedFrozenBalanceForEnergy(42L);

    // Act
    long actualV2EnergyUsage = FreezeV2Util.getV2EnergyUsage(ownerCapsule, 1L);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    assertEquals(0L, actualV2EnergyUsage);
  }
}
