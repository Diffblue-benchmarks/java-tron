package org.tron.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.WitnessCapsule;
import org.tron.core.exception.BalanceInsufficientException;
import org.tron.core.store.AccountStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.WitnessStore;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AccountContract;

@RunWith(MockitoJUnitRunner.class)
public class MortgageServiceDiffblueTest {
  @InjectMocks
  private MortgageService mortgageService;

  @Mock
  private RewardViCalService rewardViCalService;

  /**
   * Method under test: {@link MortgageService#payStandbyWitness()}
   */
  @Test
  public void testPayStandbyWitness() {
    // Arrange
    WitnessStore witnessStore = mock(WitnessStore.class);
    when(witnessStore.getWitnessStandby()).thenReturn(new ArrayList<>());

    MortgageService mortgageService = new MortgageService();
    mortgageService.setWitnessStore(witnessStore);
    ReflectionTestUtils.setField(mortgageService, "rewardViCalService", mock(RewardViCalService.class));

    // Act
    mortgageService.payStandbyWitness();

    // Assert that nothing has changed
    verify(witnessStore).getWitnessStandby();
  }

  /**
   * Method under test: {@link MortgageService#payStandbyWitness()}
   */
  @Test
  public void testPayStandbyWitness2() {
    // Arrange
    ArrayList<WitnessCapsule> witnessCapsuleList = new ArrayList<>();
    witnessCapsuleList.add(new WitnessCapsule(Protocol.Witness.getDefaultInstance()));
    WitnessStore witnessStore = mock(WitnessStore.class);
    when(witnessStore.getWitnessStandby()).thenReturn(witnessCapsuleList);

    MortgageService mortgageService = new MortgageService();
    mortgageService.setWitnessStore(witnessStore);
    ReflectionTestUtils.setField(mortgageService, "rewardViCalService", mock(RewardViCalService.class));

    // Act
    mortgageService.payStandbyWitness();

    // Assert that nothing has changed
    verify(witnessStore).getWitnessStandby();
  }

  /**
   * Method under test: {@link MortgageService#withdrawReward(byte[])}
   */
  @Test
  public void testWithdrawReward() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowChangeDelegation()).thenReturn(false);

    MortgageService mortgageService = new MortgageService();
    mortgageService.setDynamicPropertiesStore(dynamicPropertiesStore);
    ReflectionTestUtils.setField(mortgageService, "rewardViCalService", mock(RewardViCalService.class));

    // Act
    mortgageService.withdrawReward("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    verify(dynamicPropertiesStore).allowChangeDelegation();
  }

  /**
   * Method under test: {@link MortgageService#queryReward(byte[])}
   */
  @Test
  public void testQueryReward() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowChangeDelegation()).thenReturn(false);

    MortgageService mortgageService = new MortgageService();
    mortgageService.setDynamicPropertiesStore(dynamicPropertiesStore);
    ReflectionTestUtils.setField(mortgageService, "rewardViCalService", mock(RewardViCalService.class));

    // Act
    long actualQueryRewardResult = mortgageService.queryReward("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(dynamicPropertiesStore).allowChangeDelegation();
    assertEquals(0L, actualQueryRewardResult);
  }

  /**
   * Method under test: {@link MortgageService#getWitnessByAddress(ByteString)}
   */
  @Test
  public void testGetWitnessByAddress() throws UnsupportedEncodingException {
    // Arrange
    WitnessStore witnessStore = mock(WitnessStore.class);
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    when(witnessStore.get(Mockito.<byte[]>any())).thenReturn(witnessCapsule);

    MortgageService mortgageService = new MortgageService();
    mortgageService.setWitnessStore(witnessStore);
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    WitnessCapsule actualWitnessByAddress = mortgageService.getWitnessByAddress(address);

    // Assert
    verify(address).toByteArray();
    verify(witnessStore).get(isA(byte[].class));
    assertSame(witnessCapsule, actualWitnessByAddress);
  }

  /**
   * Method under test:
   * {@link MortgageService#adjustAllowance(AccountStore, byte[], long)}
   */
  @Test
  public void testAdjustAllowance() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.getUnchecked(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Act
    mortgageService.adjustAllowance(accountStore, "AXAXAXAX".getBytes("UTF-8"), 10L);

    // Assert
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test:
   * {@link MortgageService#adjustAllowance(AccountStore, byte[], long)}
   */
  @Test
  public void testAdjustAllowance2() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.getUnchecked(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(AccountContract.AccountCreateContract.getDefaultInstance()));

    // Act
    mortgageService.adjustAllowance(accountStore, "AXAXAXAX".getBytes("UTF-8"), 10L);

    // Assert
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test:
   * {@link MortgageService#adjustAllowance(AccountStore, byte[], long)}
   */
  @Test
  public void testAdjustAllowance3() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getAllowance()).thenReturn(1L);
    doNothing().when(accountCapsule).setAllowance(anyLong());
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    mortgageService.adjustAllowance(accountStore, "AXAXAXAX".getBytes("UTF-8"), 10L);

    // Assert that nothing has changed
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getAllowance();
    verify(accountCapsule).setAllowance(eq(11L));
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test:
   * {@link MortgageService#adjustAllowance(AccountStore, byte[], long)}
   */
  @Test
  public void testAdjustAllowance4() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllowance()).thenReturn(1L);
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    mortgageService.adjustAllowance(accountStore, "AXAXAXAX".getBytes("UTF-8"), 0L);

    // Assert that nothing has changed
    verify(accountCapsule).getAllowance();
    verify(accountStore).getUnchecked(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link MortgageService#adjustAllowance(AccountStore, byte[], long)}
   */
  @Test
  public void testAdjustAllowance5() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getAllowance()).thenReturn(1L);
    doNothing().when(accountCapsule).setAllowance(anyLong());
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    mortgageService.adjustAllowance(accountStore, "AXAXAXAX".getBytes("UTF-8"), -1L);

    // Assert that nothing has changed
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getAllowance();
    verify(accountCapsule).setAllowance(eq(0L));
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test:
   * {@link MortgageService#adjustAllowance(AccountStore, byte[], long)}
   */
  @Test
  public void testAdjustAllowance6() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllowance()).thenReturn(-1L);
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act and Assert
    assertThrows(BalanceInsufficientException.class,
        () -> mortgageService.adjustAllowance(accountStore, "AXAXAXAX".getBytes("UTF-8"), -1L));
    verify(accountCapsule).getAllowance();
    verify(accountStore).getUnchecked(isA(byte[].class));
  }

  /**
   * Method under test: {@link MortgageService#adjustAllowance(byte[], long)}
   */
  @Test
  public void testAdjustAllowance7() throws UnsupportedEncodingException {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.getUnchecked(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    MortgageService mortgageService = new MortgageService();
    mortgageService.setAccountStore(accountStore);

    // Act
    mortgageService.adjustAllowance("AXAXAXAX".getBytes("UTF-8"), 10L);

    // Assert
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test: {@link MortgageService#adjustAllowance(byte[], long)}
   */
  @Test
  public void testAdjustAllowance8() throws UnsupportedEncodingException {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.getUnchecked(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(AccountContract.AccountCreateContract.getDefaultInstance()));

    MortgageService mortgageService = new MortgageService();
    mortgageService.setAccountStore(accountStore);

    // Act
    mortgageService.adjustAllowance("AXAXAXAX".getBytes("UTF-8"), 10L);

    // Assert
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test: {@link MortgageService#adjustAllowance(byte[], long)}
   */
  @Test
  public void testAdjustAllowance9() throws UnsupportedEncodingException {
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

    // Assert that nothing has changed
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getAllowance();
    verify(accountCapsule).setAllowance(eq(11L));
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MortgageService#setAccountStore(AccountStore)}
   *   <li>{@link MortgageService#setDynamicPropertiesStore(DynamicPropertiesStore)}
   *   <li>{@link MortgageService#setWitnessStore(WitnessStore)}
   *   <li>{@link MortgageService#getDelegationStore()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    MortgageService mortgageService = new MortgageService();

    // Act
    mortgageService.setAccountStore(null);
    mortgageService.setDynamicPropertiesStore(null);
    mortgageService.setWitnessStore(null);

    // Assert that nothing has changed
    assertNull(mortgageService.getDelegationStore());
  }
}
