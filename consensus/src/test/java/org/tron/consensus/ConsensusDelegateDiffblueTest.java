package org.tron.consensus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.WitnessCapsule;
import org.tron.core.store.AccountStore;
import org.tron.core.store.DelegationStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.VotesStore;
import org.tron.core.store.WitnessScheduleStore;
import org.tron.core.store.WitnessStore;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class ConsensusDelegateDiffblueTest {
  @Mock
  private AccountStore accountStore;

  @InjectMocks
  private ConsensusDelegate consensusDelegate;

  @Mock
  private DelegationStore delegationStore;

  @Mock
  private DynamicPropertiesStore dynamicPropertiesStore;

  @Mock
  private VotesStore votesStore;

  @Mock
  private WitnessScheduleStore witnessScheduleStore;

  @Mock
  private WitnessStore witnessStore;

  /**
   * Method under test: {@link ConsensusDelegate#calculateFilledSlotsCount()}
   */
  @Test
  public void testCalculateFilledSlotsCount() {
    // Arrange
    when(dynamicPropertiesStore.calculateFilledSlotsCount()).thenReturn(3);

    // Act
    int actualCalculateFilledSlotsCountResult = consensusDelegate.calculateFilledSlotsCount();

    // Assert
    verify(dynamicPropertiesStore).calculateFilledSlotsCount();
    assertEquals(3, actualCalculateFilledSlotsCountResult);
  }

  /**
   * Method under test: {@link ConsensusDelegate#saveRemoveThePowerOfTheGr(long)}
   */
  @Test
  public void testSaveRemoveThePowerOfTheGr() {
    // Arrange
    doNothing().when(dynamicPropertiesStore).saveRemoveThePowerOfTheGr(anyLong());

    // Act
    consensusDelegate.saveRemoveThePowerOfTheGr(1L);

    // Assert that nothing has changed
    verify(dynamicPropertiesStore).saveRemoveThePowerOfTheGr(eq(1L));
  }

  /**
   * Method under test: {@link ConsensusDelegate#getRemoveThePowerOfTheGr()}
   */
  @Test
  public void testGetRemoveThePowerOfTheGr() {
    // Arrange
    when(dynamicPropertiesStore.getRemoveThePowerOfTheGr()).thenReturn(1L);

    // Act
    long actualRemoveThePowerOfTheGr = consensusDelegate.getRemoveThePowerOfTheGr();

    // Assert
    verify(dynamicPropertiesStore).getRemoveThePowerOfTheGr();
    assertEquals(1L, actualRemoveThePowerOfTheGr);
  }

  /**
   * Method under test: {@link ConsensusDelegate#getWitnessStandbyAllowance()}
   */
  @Test
  public void testGetWitnessStandbyAllowance() {
    // Arrange
    when(dynamicPropertiesStore.getWitnessStandbyAllowance()).thenReturn(1L);

    // Act
    long actualWitnessStandbyAllowance = consensusDelegate.getWitnessStandbyAllowance();

    // Assert
    verify(dynamicPropertiesStore).getWitnessStandbyAllowance();
    assertEquals(1L, actualWitnessStandbyAllowance);
  }

  /**
   * Method under test: {@link ConsensusDelegate#getLatestBlockHeaderTimestamp()}
   */
  @Test
  public void testGetLatestBlockHeaderTimestamp() {
    // Arrange
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);

    // Act
    long actualLatestBlockHeaderTimestamp = consensusDelegate.getLatestBlockHeaderTimestamp();

    // Assert
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    assertEquals(1L, actualLatestBlockHeaderTimestamp);
  }

  /**
   * Method under test: {@link ConsensusDelegate#getLatestBlockHeaderNumber()}
   */
  @Test
  public void testGetLatestBlockHeaderNumber() {
    // Arrange
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    // Act
    long actualLatestBlockHeaderNumber = consensusDelegate.getLatestBlockHeaderNumber();

    // Assert
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    assertEquals(1L, actualLatestBlockHeaderNumber);
  }

  /**
   * Method under test: {@link ConsensusDelegate#lastHeadBlockIsMaintenance()}
   */
  @Test
  public void testLastHeadBlockIsMaintenance() {
    // Arrange
    when(dynamicPropertiesStore.getStateFlag()).thenReturn(1);

    // Act
    boolean actualLastHeadBlockIsMaintenanceResult = consensusDelegate.lastHeadBlockIsMaintenance();

    // Assert
    verify(dynamicPropertiesStore).getStateFlag();
    assertTrue(actualLastHeadBlockIsMaintenanceResult);
  }

  /**
   * Method under test: {@link ConsensusDelegate#lastHeadBlockIsMaintenance()}
   */
  @Test
  public void testLastHeadBlockIsMaintenance2() {
    // Arrange
    when(dynamicPropertiesStore.getStateFlag()).thenReturn(0);

    // Act
    boolean actualLastHeadBlockIsMaintenanceResult = consensusDelegate.lastHeadBlockIsMaintenance();

    // Assert
    verify(dynamicPropertiesStore).getStateFlag();
    assertFalse(actualLastHeadBlockIsMaintenanceResult);
  }

  /**
   * Method under test: {@link ConsensusDelegate#getMaintenanceSkipSlots()}
   */
  @Test
  public void testGetMaintenanceSkipSlots() {
    // Arrange
    when(dynamicPropertiesStore.getMaintenanceSkipSlots()).thenReturn(1L);

    // Act
    long actualMaintenanceSkipSlots = consensusDelegate.getMaintenanceSkipSlots();

    // Assert
    verify(dynamicPropertiesStore).getMaintenanceSkipSlots();
    assertEquals(1L, actualMaintenanceSkipSlots);
  }

  /**
   * Method under test: {@link ConsensusDelegate#saveActiveWitnesses(List)}
   */
  @Test
  public void testSaveActiveWitnesses() {
    // Arrange
    doNothing().when(witnessScheduleStore).saveActiveWitnesses(Mockito.<List<ByteString>>any());

    // Act
    consensusDelegate.saveActiveWitnesses(new ArrayList<>());

    // Assert that nothing has changed
    verify(witnessScheduleStore).saveActiveWitnesses(isA(List.class));
  }

  /**
   * Method under test: {@link ConsensusDelegate#saveActiveWitnesses(List)}
   */
  @Test
  public void testSaveActiveWitnesses2() {
    // Arrange
    doNothing().when(witnessScheduleStore).saveActiveWitnesses(Mockito.<List<ByteString>>any());

    ArrayList<ByteString> addresses = new ArrayList<>();
    addresses.add(mock(ByteString.class));

    // Act
    consensusDelegate.saveActiveWitnesses(addresses);

    // Assert that nothing has changed
    verify(witnessScheduleStore).saveActiveWitnesses(isA(List.class));
  }

  /**
   * Method under test: {@link ConsensusDelegate#saveActiveWitnesses(List)}
   */
  @Test
  public void testSaveActiveWitnesses3() {
    // Arrange
    doNothing().when(witnessScheduleStore).saveActiveWitnesses(Mockito.<List<ByteString>>any());

    ArrayList<ByteString> addresses = new ArrayList<>();
    addresses.add(mock(ByteString.class));
    addresses.add(mock(ByteString.class));

    // Act
    consensusDelegate.saveActiveWitnesses(addresses);

    // Assert that nothing has changed
    verify(witnessScheduleStore).saveActiveWitnesses(isA(List.class));
  }

  /**
   * Method under test: {@link ConsensusDelegate#getActiveWitnesses()}
   */
  @Test
  public void testGetActiveWitnesses() {
    // Arrange
    ArrayList<ByteString> byteStringList = new ArrayList<>();
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(byteStringList);

    // Act
    List<ByteString> actualActiveWitnesses = consensusDelegate.getActiveWitnesses();

    // Assert
    verify(witnessScheduleStore).getActiveWitnesses();
    assertTrue(actualActiveWitnesses.isEmpty());
    assertSame(byteStringList, actualActiveWitnesses);
  }

  /**
   * Method under test: {@link ConsensusDelegate#getAccount(byte[])}
   */
  @Test
  public void testGetAccount() throws UnsupportedEncodingException {
    // Arrange
    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    when(accountStore.get(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    AccountCapsule actualAccount = consensusDelegate.getAccount("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(accountStore).get(isA(byte[].class));
    assertSame(accountCapsule, actualAccount);
  }

  /**
   * Method under test: {@link ConsensusDelegate#saveAccount(AccountCapsule)}
   */
  @Test
  public void testSaveAccount() {
    // Arrange
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());

    // Act
    consensusDelegate.saveAccount(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert that nothing has changed
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test: {@link ConsensusDelegate#saveAccount(AccountCapsule)}
   */
  @Test
  public void testSaveAccount2() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    consensusDelegate.saveAccount(accountCapsule);

    // Assert that nothing has changed
    verify(accountCapsule).createDbKey();
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test: {@link ConsensusDelegate#getWitness(byte[])}
   */
  @Test
  public void testGetWitness() throws UnsupportedEncodingException {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    when(witnessStore.get(Mockito.<byte[]>any())).thenReturn(witnessCapsule);

    // Act
    WitnessCapsule actualWitness = consensusDelegate.getWitness("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(witnessStore).get(isA(byte[].class));
    assertSame(witnessCapsule, actualWitness);
  }

  /**
   * Method under test: {@link ConsensusDelegate#saveWitness(WitnessCapsule)}
   */
  @Test
  public void testSaveWitness() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(witnessStore).put(Mockito.<byte[]>any(), Mockito.<WitnessCapsule>any());
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    consensusDelegate.saveWitness(new WitnessCapsule(address));

    // Assert that nothing has changed
    verify(address).toByteArray();
    verify(witnessStore).put(isA(byte[].class), isA(WitnessCapsule.class));
  }

  /**
   * Method under test: {@link ConsensusDelegate#saveWitness(WitnessCapsule)}
   */
  @Test
  public void testSaveWitness2() {
    // Arrange
    doNothing().when(witnessStore).put(Mockito.<byte[]>any(), Mockito.<WitnessCapsule>any());

    // Act
    consensusDelegate.saveWitness(new WitnessCapsule(Protocol.Witness.getDefaultInstance()));

    // Assert that nothing has changed
    verify(witnessStore).put(isA(byte[].class), isA(WitnessCapsule.class));
  }

  /**
   * Method under test: {@link ConsensusDelegate#saveWitness(WitnessCapsule)}
   */
  @Test
  public void testSaveWitness3() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(witnessStore).put(Mockito.<byte[]>any(), Mockito.<WitnessCapsule>any());
    WitnessCapsule witnessCapsule = mock(WitnessCapsule.class);
    when(witnessCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    consensusDelegate.saveWitness(witnessCapsule);

    // Assert that nothing has changed
    verify(witnessCapsule).createDbKey();
    verify(witnessStore).put(isA(byte[].class), isA(WitnessCapsule.class));
  }

  /**
   * Method under test: {@link ConsensusDelegate#getAllWitnesses()}
   */
  @Test
  public void testGetAllWitnesses() {
    // Arrange
    ArrayList<WitnessCapsule> witnessCapsuleList = new ArrayList<>();
    when(witnessStore.getAllWitnesses()).thenReturn(witnessCapsuleList);

    // Act
    List<WitnessCapsule> actualAllWitnesses = consensusDelegate.getAllWitnesses();

    // Assert
    verify(witnessStore).getAllWitnesses();
    assertTrue(actualAllWitnesses.isEmpty());
    assertSame(witnessCapsuleList, actualAllWitnesses);
  }

  /**
   * Method under test: {@link ConsensusDelegate#saveStateFlag(int)}
   */
  @Test
  public void testSaveStateFlag() {
    // Arrange
    doNothing().when(dynamicPropertiesStore).saveStateFlag(anyInt());

    // Act
    consensusDelegate.saveStateFlag(1);

    // Assert that nothing has changed
    verify(dynamicPropertiesStore).saveStateFlag(eq(1));
  }

  /**
   * Method under test: {@link ConsensusDelegate#updateNextMaintenanceTime(long)}
   */
  @Test
  public void testUpdateNextMaintenanceTime() {
    // Arrange
    doNothing().when(dynamicPropertiesStore).updateNextMaintenanceTime(anyLong());

    // Act
    consensusDelegate.updateNextMaintenanceTime(10L);

    // Assert that nothing has changed
    verify(dynamicPropertiesStore).updateNextMaintenanceTime(eq(10L));
  }

  /**
   * Method under test: {@link ConsensusDelegate#getNextMaintenanceTime()}
   */
  @Test
  public void testGetNextMaintenanceTime() {
    // Arrange
    when(dynamicPropertiesStore.getNextMaintenanceTime()).thenReturn(1L);

    // Act
    long actualNextMaintenanceTime = consensusDelegate.getNextMaintenanceTime();

    // Assert
    verify(dynamicPropertiesStore).getNextMaintenanceTime();
    assertEquals(1L, actualNextMaintenanceTime);
  }

  /**
   * Method under test: {@link ConsensusDelegate#getLatestSolidifiedBlockNum()}
   */
  @Test
  public void testGetLatestSolidifiedBlockNum() {
    // Arrange
    when(dynamicPropertiesStore.getLatestSolidifiedBlockNum()).thenReturn(1L);

    // Act
    long actualLatestSolidifiedBlockNum = consensusDelegate.getLatestSolidifiedBlockNum();

    // Assert
    verify(dynamicPropertiesStore).getLatestSolidifiedBlockNum();
    assertEquals(1L, actualLatestSolidifiedBlockNum);
  }

  /**
   * Method under test:
   * {@link ConsensusDelegate#saveLatestSolidifiedBlockNum(long)}
   */
  @Test
  public void testSaveLatestSolidifiedBlockNum() {
    // Arrange
    doNothing().when(dynamicPropertiesStore).saveLatestSolidifiedBlockNum(anyLong());

    // Act
    consensusDelegate.saveLatestSolidifiedBlockNum(1L);

    // Assert that nothing has changed
    verify(dynamicPropertiesStore).saveLatestSolidifiedBlockNum(eq(1L));
  }

  /**
   * Method under test: {@link ConsensusDelegate#applyBlock(boolean)}
   */
  @Test
  public void testApplyBlock() {
    // Arrange
    doNothing().when(dynamicPropertiesStore).applyBlock(anyBoolean());

    // Act
    consensusDelegate.applyBlock(true);

    // Assert that nothing has changed
    verify(dynamicPropertiesStore).applyBlock(eq(true));
  }

  /**
   * Method under test: {@link ConsensusDelegate#allowChangeDelegation()}
   */
  @Test
  public void testAllowChangeDelegation() {
    // Arrange
    when(dynamicPropertiesStore.allowChangeDelegation()).thenReturn(true);

    // Act
    boolean actualAllowChangeDelegationResult = consensusDelegate.allowChangeDelegation();

    // Assert
    verify(dynamicPropertiesStore).allowChangeDelegation();
    assertTrue(actualAllowChangeDelegationResult);
  }

  /**
   * Method under test: {@link ConsensusDelegate#allowChangeDelegation()}
   */
  @Test
  public void testAllowChangeDelegation2() {
    // Arrange
    when(dynamicPropertiesStore.allowChangeDelegation()).thenReturn(false);

    // Act
    boolean actualAllowChangeDelegationResult = consensusDelegate.allowChangeDelegation();

    // Assert
    verify(dynamicPropertiesStore).allowChangeDelegation();
    assertFalse(actualAllowChangeDelegationResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConsensusDelegate#getDelegationStore()}
   *   <li>{@link ConsensusDelegate#getDynamicPropertiesStore()}
   *   <li>{@link ConsensusDelegate#getVotesStore()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ConsensusDelegate consensusDelegate = new ConsensusDelegate();

    // Act
    DelegationStore actualDelegationStore = consensusDelegate.getDelegationStore();
    DynamicPropertiesStore actualDynamicPropertiesStore = consensusDelegate.getDynamicPropertiesStore();

    // Assert
    assertNull(actualDelegationStore);
    assertNull(actualDynamicPropertiesStore);
    assertNull(consensusDelegate.getVotesStore());
  }
}
