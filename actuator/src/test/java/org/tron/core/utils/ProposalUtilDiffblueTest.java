package org.tron.core.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.utils.ForkController;
import org.tron.core.config.Parameter;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.DynamicPropertiesStore;

@RunWith(MockitoJUnitRunner.class)
public class ProposalUtilDiffblueTest {
  @InjectMocks
  private ProposalUtil proposalUtil;

  /**
   * Method under test: {@link ProposalUtil.ProposalType#contain(long)}
   */
  @Test
  public void testProposalTypeContain() {
    // Arrange, Act and Assert
    assertTrue(ProposalUtil.ProposalType.contain(1L));
    assertFalse(ProposalUtil.ProposalType.contain(-1L));
  }

  /**
   * Method under test: {@link ProposalUtil.ProposalType#getCode()}
   */
  @Test
  public void testProposalTypeGetCode() {
    // Arrange, Act and Assert
    assertEquals(0L, ProposalUtil.ProposalType.valueOf("MAINTENANCE_TIME_INTERVAL").getCode());
  }

  /**
   * Method under test: {@link ProposalUtil.ProposalType#getEnum(long)}
   */
  @Test
  public void testProposalTypeGetEnum() throws ContractValidateException {
    // Arrange, Act and Assert
    assertEquals(ProposalUtil.ProposalType.ACCOUNT_UPGRADE_COST, ProposalUtil.ProposalType.getEnum(1L));
    assertThrows(ContractValidateException.class, () -> ProposalUtil.ProposalType.getEnum(-1L));
  }

  /**
   * Method under test: {@link ProposalUtil.ProposalType#getEnumOrNull(long)}
   */
  @Test
  public void testProposalTypeGetEnumOrNull() {
    // Arrange, Act and Assert
    assertEquals(ProposalUtil.ProposalType.ACCOUNT_UPGRADE_COST, ProposalUtil.ProposalType.getEnumOrNull(1L));
    assertNull(ProposalUtil.ProposalType.getEnumOrNull(-1L));
  }

  /**
   * Method under test:
   * {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}
   */
  @Test
  public void testValidator() throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(ContractValidateException.class,
        () -> ProposalUtil.validator(null, ForkController.instance(), 0L, 42L));
    assertThrows(ContractValidateException.class,
        () -> ProposalUtil.validator(null, ForkController.instance(), 1L, -1L));
    assertThrows(ContractValidateException.class,
        () -> ProposalUtil.validator(null, ForkController.instance(), 1L, Long.MAX_VALUE));
    assertThrows(ContractValidateException.class,
        () -> ProposalUtil.validator(null, ForkController.instance(), 0L, Long.MAX_VALUE));
  }

  /**
   * Method under test:
   * {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}
   */
  @Test
  public void testValidator2() throws ContractValidateException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getRemoveThePowerOfTheGr()).thenReturn(1L);

    // Act and Assert
    assertThrows(ContractValidateException.class,
        () -> ProposalUtil.validator(dynamicPropertiesStore, ForkController.instance(), 10L, 42L));
    verify(dynamicPropertiesStore).getRemoveThePowerOfTheGr();
  }

  /**
   * Method under test:
   * {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}
   */
  @Test
  public void testValidator3() throws ContractValidateException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getRemoveThePowerOfTheGr()).thenReturn(-1L);

    // Act and Assert
    assertThrows(ContractValidateException.class,
        () -> ProposalUtil.validator(dynamicPropertiesStore, ForkController.instance(), 10L, 42L));
    verify(dynamicPropertiesStore).getRemoveThePowerOfTheGr();
  }

  /**
   * Method under test:
   * {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}
   */
  @Test
  public void testValidator4() throws ContractValidateException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getRemoveThePowerOfTheGr()).thenReturn(1L);

    // Act
    ProposalUtil.validator(dynamicPropertiesStore, ForkController.instance(), 10L, 1L);

    // Assert that nothing has changed
    verify(dynamicPropertiesStore).getRemoveThePowerOfTheGr();
  }

  /**
   * Method under test:
   * {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}
   */
  @Test
  public void testValidator5() throws ContractValidateException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    ForkController forkController = mock(ForkController.class);
    when(forkController.pass(Mockito.<Parameter.ForkBlockVersionEnum>any())).thenReturn(true);

    // Act and Assert
    assertThrows(ContractValidateException.class,
        () -> ProposalUtil.validator(dynamicPropertiesStore, forkController, 69L, 42L));
    verify(forkController).pass(eq(Parameter.ForkBlockVersionEnum.VERSION_4_6));
  }

  /**
   * Method under test:
   * {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}
   */
  @Test
  public void testValidator6() throws ContractValidateException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    ForkController forkController = mock(ForkController.class);
    when(forkController.pass(Mockito.<Parameter.ForkBlockVersionEnum>any())).thenReturn(false);

    // Act and Assert
    assertThrows(ContractValidateException.class,
        () -> ProposalUtil.validator(dynamicPropertiesStore, forkController, 69L, 42L));
    verify(forkController).pass(eq(Parameter.ForkBlockVersionEnum.VERSION_4_6));
  }

  /**
   * Method under test:
   * {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}
   */
  @Test
  public void testValidator7() throws ContractValidateException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    ForkController forkController = mock(ForkController.class);
    when(forkController.pass(Mockito.<Parameter.ForkBlockVersionEnum>any())).thenReturn(true);

    // Act
    ProposalUtil.validator(dynamicPropertiesStore, forkController, 69L, 1L);

    // Assert that nothing has changed
    verify(forkController).pass(eq(Parameter.ForkBlockVersionEnum.VERSION_4_6));
  }
}
