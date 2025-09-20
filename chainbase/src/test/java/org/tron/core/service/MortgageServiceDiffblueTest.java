package org.tron.core.service;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.WitnessCapsule;
import org.tron.core.store.AccountStore;
import org.tron.core.store.DelegationStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.WitnessStore;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MortgageServiceDiffblueTest {
  /**
   * Test {@link MortgageService#payStandbyWitness()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link WitnessCapsule#WitnessCapsule(byte[])}
   *       with data is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MortgageService#payStandbyWitness()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MortgageService.payStandbyWitness()"})
  public void testPayStandbyWitness_givenArrayListAddWitnessCapsuleWithDataIsEmptyArrayOfByte() {
    // Arrange
    ArrayList<WitnessCapsule> witnessCapsuleList = new ArrayList<>();
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[] {});
    witnessCapsuleList.add(witnessCapsule);

    WitnessStore witnessStore = mock(WitnessStore.class);
    when(witnessStore.getWitnessStandby()).thenReturn(witnessCapsuleList);

    MortgageService mortgageService = new MortgageService();
    mortgageService.setWitnessStore(witnessStore);

    // Act
    mortgageService.payStandbyWitness();

    // Assert
    verify(witnessStore).getWitnessStandby();
  }

  /**
   * Test {@link MortgageService#payStandbyWitness()}.
   *
   * <ul>
   *   <li>Then calls {@link WitnessStore#getWitnessStandby()}.
   * </ul>
   *
   * <p>Method under test: {@link MortgageService#payStandbyWitness()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MortgageService.payStandbyWitness()"})
  public void testPayStandbyWitness_thenCallsGetWitnessStandby() {
    // Arrange
    WitnessStore witnessStore = mock(WitnessStore.class);
    when(witnessStore.getWitnessStandby()).thenReturn(new ArrayList<>());

    MortgageService mortgageService = new MortgageService();
    mortgageService.setWitnessStore(witnessStore);

    // Act
    mortgageService.payStandbyWitness();

    // Assert
    verify(witnessStore).getWitnessStandby();
  }

  /**
   * Test {@link MortgageService#payBlockReward(byte[], long)}.
   *
   * <ul>
   *   <li>Given {@link DelegationStore} {@link DelegationStore#getBrokerage(long, byte[])} return
   *       one.
   *   <li>Then calls {@link DelegationStore#addReward(long, byte[], long)}.
   * </ul>
   *
   * <p>Method under test: {@link MortgageService#payBlockReward(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MortgageService.payBlockReward(byte[], long)"})
  public void testPayBlockReward_givenDelegationStoreGetBrokerageReturnOne_thenCallsAddReward()
      throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);

    DelegationStore delegationStore = mock(DelegationStore.class);
    when(delegationStore.getBrokerage(anyLong(), Mockito.<byte[]>any())).thenReturn(1);
    doNothing().when(delegationStore).addReward(anyLong(), Mockito.<byte[]>any(), anyLong());

    MortgageService mortgageService = new MortgageService();
    mortgageService.setDelegationStore(delegationStore);
    mortgageService.setDynamicPropertiesStore(dynamicPropertiesStore);

    // Act
    mortgageService.payBlockReward("AXAXAXAX".getBytes("UTF-8"), 42L);

    // Assert
    verify(delegationStore).addReward(eq(1L), isA(byte[].class), eq(42L));
    verify(delegationStore).getBrokerage(eq(1L), isA(byte[].class));
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
  }

  /**
   * Test {@link MortgageService#payTransactionFeeReward(byte[], long)}.
   *
   * <ul>
   *   <li>Then calls {@link DelegationStore#addReward(long, byte[], long)}.
   * </ul>
   *
   * <p>Method under test: {@link MortgageService#payTransactionFeeReward(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MortgageService.payTransactionFeeReward(byte[], long)"})
  public void testPayTransactionFeeReward_thenCallsAddReward() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);

    DelegationStore delegationStore = mock(DelegationStore.class);
    when(delegationStore.getBrokerage(anyLong(), Mockito.<byte[]>any())).thenReturn(1);
    doNothing().when(delegationStore).addReward(anyLong(), Mockito.<byte[]>any(), anyLong());

    MortgageService mortgageService = new MortgageService();
    mortgageService.setDelegationStore(delegationStore);
    mortgageService.setDynamicPropertiesStore(dynamicPropertiesStore);

    // Act
    mortgageService.payTransactionFeeReward("AXAXAXAX".getBytes("UTF-8"), 42L);

    // Assert
    verify(delegationStore).addReward(eq(1L), isA(byte[].class), eq(42L));
    verify(delegationStore).getBrokerage(eq(1L), isA(byte[].class));
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
  }

  /**
   * Test {@link MortgageService#getWitnessByAddress(ByteString)}.
   *
   * <ul>
   *   <li>Given {@link WitnessStore} {@link WitnessStore#get(byte[])} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MortgageService#getWitnessByAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCapsule MortgageService.getWitnessByAddress(ByteString)"})
  public void testGetWitnessByAddress_givenWitnessStoreGetReturnNull_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    WitnessStore witnessStore = mock(WitnessStore.class);
    when(witnessStore.get(Mockito.<byte[]>any())).thenReturn(null);

    MortgageService mortgageService = new MortgageService();
    mortgageService.setWitnessStore(witnessStore);

    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    WitnessCapsule actualWitnessByAddress = mortgageService.getWitnessByAddress(address);

    // Assert
    verify(address).toByteArray();
    verify(witnessStore).get(isA(byte[].class));
    assertNull(actualWitnessByAddress);
  }

  /**
   * Test {@link MortgageService#adjustAllowance(byte[], long)} with {@code address}, {@code
   * amount}.
   *
   * <ul>
   *   <li>Then calls {@link AccountCapsule#createDbKey()}.
   * </ul>
   *
   * <p>Method under test: {@link MortgageService#adjustAllowance(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MortgageService.adjustAllowance(byte[], long)"})
  public void testAdjustAllowanceWithAddressAmount_thenCallsCreateDbKey()
      throws UnsupportedEncodingException {
    // Arrange
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getAllowance()).thenReturn(1L);
    doNothing().when(accountCapsule).setAllowance(anyLong());

    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    MortgageService mortgageService = new MortgageService();
    mortgageService.setAccountStore(accountStore);

    // Act
    mortgageService.adjustAllowance("AXAXAXAX".getBytes("UTF-8"), 10L);

    // Assert
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getAllowance();
    verify(accountCapsule).setAllowance(11L);
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MortgageService#setAccountStore(AccountStore)}
   *   <li>{@link MortgageService#setDynamicPropertiesStore(DynamicPropertiesStore)}
   *   <li>{@link MortgageService#setWitnessStore(WitnessStore)}
   *   <li>{@link MortgageService#getDelegationStore()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "DelegationStore MortgageService.getDelegationStore()",
    "void MortgageService.setAccountStore(AccountStore)",
    "void MortgageService.setDelegationStore(DelegationStore)",
    "void MortgageService.setDynamicPropertiesStore(DynamicPropertiesStore)",
    "void MortgageService.setWitnessStore(WitnessStore)"
  })
  public void testGettersAndSetters() {
    // Arrange
    MortgageService mortgageService = new MortgageService();

    // Act
    mortgageService.setAccountStore(null);
    mortgageService.setDynamicPropertiesStore(null);
    mortgageService.setWitnessStore(null);

    // Assert
    assertNull(mortgageService.getDelegationStore());
  }
}
