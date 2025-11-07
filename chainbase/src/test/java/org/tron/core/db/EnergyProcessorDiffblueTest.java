package org.tron.core.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.store.AccountStore;
import org.tron.core.store.DynamicPropertiesStore;

@RunWith(MockitoJUnitRunner.class)
public class EnergyProcessorDiffblueTest {
  @Mock
  private DynamicPropertiesStore dynamicPropertiesStore;

  /**
   * Test {@link EnergyProcessor#EnergyProcessor(DynamicPropertiesStore, AccountStore)}.
   * <p>
   * Method under test: {@link EnergyProcessor#EnergyProcessor(DynamicPropertiesStore, AccountStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EnergyProcessor.<init>(DynamicPropertiesStore, AccountStore)"})
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

  /**
   * Test {@link EnergyProcessor#getHeadSlot(DynamicPropertiesStore)} with {@code DynamicPropertiesStore}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyProcessor#getHeadSlot(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyProcessor.getHeadSlot(DynamicPropertiesStore)"})
  public void testGetHeadSlotWithDynamicPropertiesStore_thenThrowRuntimeException() {
    // Arrange
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> EnergyProcessor.getHeadSlot(dynamicPropertiesStore));
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
  }

  /**
   * Test {@link EnergyProcessor#updateAdaptiveTotalEnergyLimit()}.
   * <p>
   * Method under test: {@link EnergyProcessor#updateAdaptiveTotalEnergyLimit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EnergyProcessor.updateAdaptiveTotalEnergyLimit()"})
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

    // Assert
    verify(dynamicPropertiesStore).getAdaptiveResourceLimitMultiplier();
    verify(dynamicPropertiesStore).getTotalEnergyAverageUsage();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyLimit();
    verify(dynamicPropertiesStore).getTotalEnergyTargetLimit();
    verify(dynamicPropertiesStore).saveTotalEnergyCurrentLimit(eq(1L));
  }

  /**
   * Test {@link EnergyProcessor#updateAdaptiveTotalEnergyLimit()}.
   * <p>
   * Method under test: {@link EnergyProcessor#updateAdaptiveTotalEnergyLimit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EnergyProcessor.updateAdaptiveTotalEnergyLimit()"})
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

    // Assert
    verify(dynamicPropertiesStore).getAdaptiveResourceLimitMultiplier();
    verify(dynamicPropertiesStore).getTotalEnergyAverageUsage();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyLimit();
    verify(dynamicPropertiesStore).getTotalEnergyTargetLimit();
    verify(dynamicPropertiesStore).saveTotalEnergyCurrentLimit(eq(1L));
  }

  /**
   * Test {@link EnergyProcessor#updateAdaptiveTotalEnergyLimit()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyProcessor#updateAdaptiveTotalEnergyLimit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EnergyProcessor.updateAdaptiveTotalEnergyLimit()"})
  public void testUpdateAdaptiveTotalEnergyLimit_thenThrowRuntimeException() {
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
   * Test {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}.
   * <p>
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyProcessor.calculateGlobalEnergyLimit(AccountCapsule)"})
  public void testCalculateGlobalEnergyLimit() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, null);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForEnergy()).thenReturn(42L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(accountCapsule).getAllFrozenBalanceForEnergy();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Test {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}.
   * <p>
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyProcessor.calculateGlobalEnergyLimit(AccountCapsule)"})
  public void testCalculateGlobalEnergyLimit2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenThrow(new RuntimeException("foo"));
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, null);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForEnergy()).thenReturn(42L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> energyProcessor.calculateGlobalEnergyLimit(accountCapsule));
    verify(accountCapsule).getAllFrozenBalanceForEnergy();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Test {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}.
   * <p>
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyProcessor.calculateGlobalEnergyLimit(AccountCapsule)"})
  public void testCalculateGlobalEnergyLimit3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(0L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, null);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForEnergy()).thenReturn(42L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(accountCapsule).getAllFrozenBalanceForEnergy();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Test {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}.
   * <p>
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyProcessor.calculateGlobalEnergyLimit(AccountCapsule)"})
  public void testCalculateGlobalEnergyLimit4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowNewReward()).thenReturn(false);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, null);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForEnergy()).thenReturn(1000000L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(accountCapsule).getAllFrozenBalanceForEnergy();
    verify(dynamicPropertiesStore).allowNewReward();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(1L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Test {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}.
   * <p>
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyProcessor.calculateGlobalEnergyLimit(AccountCapsule)"})
  public void testCalculateGlobalEnergyLimit5() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowNewReward()).thenReturn(true);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(0L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, null);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForEnergy()).thenReturn(1000000L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(accountCapsule).getAllFrozenBalanceForEnergy();
    verify(dynamicPropertiesStore).allowNewReward();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Test {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}.
   * <p>
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyProcessor.calculateGlobalEnergyLimit(AccountCapsule)"})
  public void testCalculateGlobalEnergyLimit6() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowNewReward()).thenThrow(new RuntimeException("foo"));
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, null);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForEnergy()).thenReturn(1000000L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> energyProcessor.calculateGlobalEnergyLimit(accountCapsule));
    verify(accountCapsule).getAllFrozenBalanceForEnergy();
    verify(dynamicPropertiesStore).allowNewReward();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Test {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyProcessor.calculateGlobalEnergyLimit(AccountCapsule)"})
  public void testCalculateGlobalEnergyLimit_thenReturnOne() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowNewReward()).thenReturn(true);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalEnergyWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, null);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForEnergy()).thenReturn(1000000L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(accountCapsule).getAllFrozenBalanceForEnergy();
    verify(dynamicPropertiesStore).allowNewReward();
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
    verify(dynamicPropertiesStore).getTotalEnergyWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(1L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Test {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyProcessor.calculateGlobalEnergyLimit(AccountCapsule)"})
  public void testCalculateGlobalEnergyLimit_thenReturnZero() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    EnergyProcessor energyProcessor = new EnergyProcessor(dynamicPropertiesStore, null);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForEnergy()).thenReturn(42L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = energyProcessor.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(accountCapsule).getAllFrozenBalanceForEnergy();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Test {@link EnergyProcessor#calculateGlobalEnergyLimitV2(long)}.
   * <p>
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimitV2(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyProcessor.calculateGlobalEnergyLimitV2(long)"})
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
   * Test {@link EnergyProcessor#calculateGlobalEnergyLimitV2(long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimitV2(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyProcessor.calculateGlobalEnergyLimitV2(long)"})
  public void testCalculateGlobalEnergyLimitV2_thenThrowRuntimeException() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalEnergyCurrentLimit()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new EnergyProcessor(dynamicPropertiesStore, mock(AccountStore.class)))
        .calculateGlobalEnergyLimitV2(42L));
    verify(dynamicPropertiesStore).getTotalEnergyCurrentLimit();
  }

  /**
   * Test {@link EnergyProcessor#calculateGlobalEnergyLimitV2(long)}.
   * <p>
   * Method under test: {@link EnergyProcessor#calculateGlobalEnergyLimitV2(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyProcessor.calculateGlobalEnergyLimitV2(long)"})
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
}
