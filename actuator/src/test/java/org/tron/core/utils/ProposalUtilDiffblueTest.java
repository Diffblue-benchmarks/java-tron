package org.tron.core.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.utils.ForkController;
import org.tron.core.config.Parameter;
import org.tron.core.config.Parameter.ForkBlockVersionEnum;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.utils.ProposalUtil.ProposalType;

public class ProposalUtilDiffblueTest {
  /**
   * Test ProposalType {@link ProposalType#contain(long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalType#contain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProposalType.contain(long)"})
  public void testProposalTypeContain_whenMinusOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ProposalType.contain(-1L));
  }

  /**
   * Test ProposalType {@link ProposalType#contain(long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalType#contain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProposalType.contain(long)"})
  public void testProposalTypeContain_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ProposalType.contain(1L));
  }

  /**
   * Test ProposalType {@link ProposalType#getCode()}.
   *
   * <p>Method under test: {@link ProposalType#getCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ProposalType.getCode()"})
  public void testProposalTypeGetCode() {
    // Arrange, Act and Assert
    assertEquals(0L, ProposalType.valueOf("MAINTENANCE_TIME_INTERVAL").getCode());
  }

  /**
   * Test ProposalType {@link ProposalType#getEnumOrNull(long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalType#getEnumOrNull(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProposalType ProposalType.getEnumOrNull(long)"})
  public void testProposalTypeGetEnumOrNull_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ProposalType.getEnumOrNull(-1L));
  }

  /**
   * Test ProposalType {@link ProposalType#getEnumOrNull(long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code ACCOUNT_UPGRADE_COST}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalType#getEnumOrNull(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProposalType ProposalType.getEnumOrNull(long)"})
  public void testProposalTypeGetEnumOrNull_whenOne_thenReturnAccountUpgradeCost() {
    // Arrange, Act and Assert
    assertEquals(ProposalType.ACCOUNT_UPGRADE_COST, ProposalType.getEnumOrNull(1L));
  }

  /**
   * Test ProposalType {@link ProposalType#getEnum(long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link ContractValidateException}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalType#getEnum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProposalType ProposalType.getEnum(long)"})
  public void testProposalTypeGetEnum_whenMinusOne_thenThrowContractValidateException()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(ContractValidateException.class, () -> ProposalType.getEnum(-1L));
  }

  /**
   * Test ProposalType {@link ProposalType#getEnum(long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code ACCOUNT_UPGRADE_COST}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalType#getEnum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProposalType ProposalType.getEnum(long)"})
  public void testProposalTypeGetEnum_whenOne_thenReturnAccountUpgradeCost()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertEquals(ProposalType.ACCOUNT_UPGRADE_COST, ProposalType.getEnum(1L));
  }

  /**
   * Test {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link ForkController} {@link ForkController#pass(ForkBlockVersionEnum)} return
   *       {@code false}.
   *   <li>Then calls {@link ForkController#pass(ForkBlockVersionEnum)}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController,
   * long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProposalUtil.validator(DynamicPropertiesStore, ForkController, long, long)"
  })
  public void testValidator_givenFalse_whenForkControllerPassReturnFalse_thenCallsPass()
      throws ContractValidateException {
    // Arrange
    ForkController forkController = mock(ForkController.class);
    when(forkController.pass(Mockito.<ForkBlockVersionEnum>any())).thenReturn(false);

    // Act and Assert
    assertThrows(
        ContractValidateException.class,
        () -> ProposalUtil.validator(null, forkController, 69L, 81000L));
    verify(forkController).pass(ForkBlockVersionEnum.VERSION_4_6);
  }

  /**
   * Test {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link ForkController} {@link ForkController#pass(ForkBlockVersionEnum)} return
   *       {@code true}.
   *   <li>Then calls {@link ForkController#pass(ForkBlockVersionEnum)}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController,
   * long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProposalUtil.validator(DynamicPropertiesStore, ForkController, long, long)"
  })
  public void testValidator_givenTrue_whenForkControllerPassReturnTrue_thenCallsPass()
      throws ContractValidateException {
    // Arrange
    ForkController forkController = mock(ForkController.class);
    when(forkController.pass(Mockito.<ForkBlockVersionEnum>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        ContractValidateException.class,
        () -> ProposalUtil.validator(null, forkController, 69L, 81000L));
    verify(forkController).pass(ForkBlockVersionEnum.VERSION_4_6);
  }

  /**
   * Test {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link ForkController} {@link ForkController#pass(ForkBlockVersionEnum)} return
   *       {@code true}.
   *   <li>Then calls {@link ForkController#pass(ForkBlockVersionEnum)}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController,
   * long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProposalUtil.validator(DynamicPropertiesStore, ForkController, long, long)"
  })
  public void testValidator_givenTrue_whenForkControllerPassReturnTrue_thenCallsPass2()
      throws ContractValidateException {
    // Arrange
    ForkController forkController = mock(ForkController.class);
    when(forkController.pass(Mockito.<ForkBlockVersionEnum>any())).thenReturn(true);

    // Act
    ProposalUtil.validator(null, forkController, 69L, 1L);

    // Assert
    verify(forkController).pass(ForkBlockVersionEnum.VERSION_4_6);
  }

  /**
   * Test {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}.
   *
   * <ul>
   *   <li>When {@code 86400001}.
   *   <li>Then throw {@link ContractValidateException}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController,
   * long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProposalUtil.validator(DynamicPropertiesStore, ForkController, long, long)"
  })
  public void testValidator_when86400001_thenThrowContractValidateException()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () -> ProposalUtil.validator(null, ForkController.instance(), 0L, 86400001L));
  }

  /**
   * Test {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}.
   *
   * <ul>
   *   <li>When {@code 100000000000000001}.
   *   <li>Then throw {@link ContractValidateException}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController,
   * long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProposalUtil.validator(DynamicPropertiesStore, ForkController, long, long)"
  })
  public void testValidator_when100000000000000001_thenThrowContractValidateException()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () -> ProposalUtil.validator(null, ForkController.instance(), 1L, 100000000000000001L));
  }

  /**
   * Test {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link ContractValidateException}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController,
   * long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProposalUtil.validator(DynamicPropertiesStore, ForkController, long, long)"
  })
  public void testValidator_whenMinusOne_thenThrowContractValidateException()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () -> ProposalUtil.validator(null, ForkController.instance(), 1L, -1L));
  }

  /**
   * Test {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController, long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link ContractValidateException}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalUtil#validator(DynamicPropertiesStore, ForkController,
   * long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProposalUtil.validator(DynamicPropertiesStore, ForkController, long, long)"
  })
  public void testValidator_whenZero_thenThrowContractValidateException()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () -> ProposalUtil.validator(null, ForkController.instance(), 0L, 42L));
  }
}
