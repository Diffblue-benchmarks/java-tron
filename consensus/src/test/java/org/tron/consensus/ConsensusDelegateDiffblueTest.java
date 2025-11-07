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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import org.tron.core.store.WitnessScheduleStore;
import org.tron.core.store.WitnessStore;

@RunWith(MockitoJUnitRunner.class)
public class ConsensusDelegateDiffblueTest {
  @InjectMocks
  private ConsensusDelegate consensusDelegate;

  @Mock
  private DynamicPropertiesStore dynamicPropertiesStore;

  @Mock
  private AccountStore accountStore;

  @Mock
  private WitnessScheduleStore witnessScheduleStore;

  @Mock
  private WitnessStore witnessStore;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ConsensusDelegate#getDelegationStore()}
   *   <li>{@link ConsensusDelegate#getDynamicPropertiesStore()}
   *   <li>{@link ConsensusDelegate#getVotesStore()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegationStore ConsensusDelegate.getDelegationStore()",
      "DynamicPropertiesStore ConsensusDelegate.getDynamicPropertiesStore()",
      "org.tron.core.store.VotesStore ConsensusDelegate.getVotesStore()"})
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

  /**
   * Test {@link ConsensusDelegate#calculateFilledSlotsCount()}.
   * <p>
   * Method under test: {@link ConsensusDelegate#calculateFilledSlotsCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ConsensusDelegate.calculateFilledSlotsCount()"})
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
   * Test {@link ConsensusDelegate#saveRemoveThePowerOfTheGr(long)}.
   * <p>
   * Method under test: {@link ConsensusDelegate#saveRemoveThePowerOfTheGr(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConsensusDelegate.saveRemoveThePowerOfTheGr(long)"})
  public void testSaveRemoveThePowerOfTheGr() {
    // Arrange
    doNothing().when(dynamicPropertiesStore).saveRemoveThePowerOfTheGr(anyLong());

    // Act
    consensusDelegate.saveRemoveThePowerOfTheGr(1L);

    // Assert
    verify(dynamicPropertiesStore).saveRemoveThePowerOfTheGr(eq(1L));
  }

  /**
   * Test {@link ConsensusDelegate#getRemoveThePowerOfTheGr()}.
   * <p>
   * Method under test: {@link ConsensusDelegate#getRemoveThePowerOfTheGr()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ConsensusDelegate.getRemoveThePowerOfTheGr()"})
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
   * Test {@link ConsensusDelegate#getWitnessStandbyAllowance()}.
   * <p>
   * Method under test: {@link ConsensusDelegate#getWitnessStandbyAllowance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ConsensusDelegate.getWitnessStandbyAllowance()"})
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
   * Test {@link ConsensusDelegate#getLatestBlockHeaderTimestamp()}.
   * <p>
   * Method under test: {@link ConsensusDelegate#getLatestBlockHeaderTimestamp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ConsensusDelegate.getLatestBlockHeaderTimestamp()"})
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
   * Test {@link ConsensusDelegate#getLatestBlockHeaderNumber()}.
   * <p>
   * Method under test: {@link ConsensusDelegate#getLatestBlockHeaderNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ConsensusDelegate.getLatestBlockHeaderNumber()"})
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
   * Test {@link ConsensusDelegate#lastHeadBlockIsMaintenance()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsensusDelegate#lastHeadBlockIsMaintenance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConsensusDelegate.lastHeadBlockIsMaintenance()"})
  public void testLastHeadBlockIsMaintenance_thenReturnFalse() {
    // Arrange
    when(dynamicPropertiesStore.getStateFlag()).thenReturn(0);

    // Act
    boolean actualLastHeadBlockIsMaintenanceResult = consensusDelegate.lastHeadBlockIsMaintenance();

    // Assert
    verify(dynamicPropertiesStore).getStateFlag();
    assertFalse(actualLastHeadBlockIsMaintenanceResult);
  }

  /**
   * Test {@link ConsensusDelegate#lastHeadBlockIsMaintenance()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsensusDelegate#lastHeadBlockIsMaintenance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConsensusDelegate.lastHeadBlockIsMaintenance()"})
  public void testLastHeadBlockIsMaintenance_thenReturnTrue() {
    // Arrange
    when(dynamicPropertiesStore.getStateFlag()).thenReturn(1);

    // Act
    boolean actualLastHeadBlockIsMaintenanceResult = consensusDelegate.lastHeadBlockIsMaintenance();

    // Assert
    verify(dynamicPropertiesStore).getStateFlag();
    assertTrue(actualLastHeadBlockIsMaintenanceResult);
  }

  /**
   * Test {@link ConsensusDelegate#getMaintenanceSkipSlots()}.
   * <p>
   * Method under test: {@link ConsensusDelegate#getMaintenanceSkipSlots()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ConsensusDelegate.getMaintenanceSkipSlots()"})
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
   * Test {@link ConsensusDelegate#saveActiveWitnesses(List)}.
   * <ul>
   *   <li>Given {@link ByteString}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsensusDelegate#saveActiveWitnesses(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConsensusDelegate.saveActiveWitnesses(List)"})
  public void testSaveActiveWitnesses_givenByteString_whenArrayListAddByteString() {
    // Arrange
    doNothing().when(witnessScheduleStore).saveActiveWitnesses(Mockito.<List<ByteString>>any());

    ArrayList<ByteString> addresses = new ArrayList<>();
    addresses.add(mock(ByteString.class));

    // Act
    consensusDelegate.saveActiveWitnesses(addresses);

    // Assert
    verify(witnessScheduleStore).saveActiveWitnesses(isA(List.class));
  }

  /**
   * Test {@link ConsensusDelegate#saveActiveWitnesses(List)}.
   * <ul>
   *   <li>Given {@link ByteString}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsensusDelegate#saveActiveWitnesses(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConsensusDelegate.saveActiveWitnesses(List)"})
  public void testSaveActiveWitnesses_givenByteString_whenArrayListAddByteString2() {
    // Arrange
    doNothing().when(witnessScheduleStore).saveActiveWitnesses(Mockito.<List<ByteString>>any());

    ArrayList<ByteString> addresses = new ArrayList<>();
    addresses.add(mock(ByteString.class));
    addresses.add(mock(ByteString.class));

    // Act
    consensusDelegate.saveActiveWitnesses(addresses);

    // Assert
    verify(witnessScheduleStore).saveActiveWitnesses(isA(List.class));
  }

  /**
   * Test {@link ConsensusDelegate#saveActiveWitnesses(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsensusDelegate#saveActiveWitnesses(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConsensusDelegate.saveActiveWitnesses(List)"})
  public void testSaveActiveWitnesses_whenArrayList() {
    // Arrange
    doNothing().when(witnessScheduleStore).saveActiveWitnesses(Mockito.<List<ByteString>>any());

    // Act
    consensusDelegate.saveActiveWitnesses(new ArrayList<>());

    // Assert
    verify(witnessScheduleStore).saveActiveWitnesses(isA(List.class));
  }

  /**
   * Test {@link ConsensusDelegate#getActiveWitnesses()}.
   * <p>
   * Method under test: {@link ConsensusDelegate#getActiveWitnesses()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ConsensusDelegate.getActiveWitnesses()"})
  public void testGetActiveWitnesses() {
    // Arrange
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());

    // Act
    List<ByteString> actualActiveWitnesses = consensusDelegate.getActiveWitnesses();

    // Assert
    verify(witnessScheduleStore).getActiveWitnesses();
    assertTrue(actualActiveWitnesses.isEmpty());
  }

  /**
   * Test {@link ConsensusDelegate#getAccount(byte[])}.
   * <p>
   * Method under test: {@link ConsensusDelegate#getAccount(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCapsule ConsensusDelegate.getAccount(byte[])"})
  public void testGetAccount() throws UnsupportedEncodingException {
    // Arrange
    when(accountStore.get(Mockito.<byte[]>any())).thenReturn(null);

    // Act
    AccountCapsule actualAccount = consensusDelegate.getAccount("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(accountStore).get(isA(byte[].class));
    assertNull(actualAccount);
  }

  /**
   * Test {@link ConsensusDelegate#saveAccount(AccountCapsule)}.
   * <ul>
   *   <li>Given {@link AccountStore} {@link AccountStore#put(byte[], AccountCapsule)} does nothing.</li>
   *   <li>Then calls {@link AccountCapsule#createDbKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsensusDelegate#saveAccount(AccountCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConsensusDelegate.saveAccount(AccountCapsule)"})
  public void testSaveAccount_givenAccountStorePutDoesNothing_thenCallsCreateDbKey()
      throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    consensusDelegate.saveAccount(accountCapsule);

    // Assert
    verify(accountCapsule).createDbKey();
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Test {@link ConsensusDelegate#getWitness(byte[])}.
   * <p>
   * Method under test: {@link ConsensusDelegate#getWitness(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCapsule ConsensusDelegate.getWitness(byte[])"})
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
   * Test {@link ConsensusDelegate#saveWitness(WitnessCapsule)}.
   * <ul>
   *   <li>Then calls {@link WitnessCapsule#createDbKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsensusDelegate#saveWitness(WitnessCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConsensusDelegate.saveWitness(WitnessCapsule)"})
  public void testSaveWitness_thenCallsCreateDbKey() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(witnessStore).put(Mockito.<byte[]>any(), Mockito.<WitnessCapsule>any());
    WitnessCapsule witnessCapsule = mock(WitnessCapsule.class);
    when(witnessCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    consensusDelegate.saveWitness(witnessCapsule);

    // Assert
    verify(witnessCapsule).createDbKey();
    verify(witnessStore).put(isA(byte[].class), isA(WitnessCapsule.class));
  }

  /**
   * Test {@link ConsensusDelegate#saveWitness(WitnessCapsule)}.
   * <ul>
   *   <li>Then calls {@link ByteString#toByteArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsensusDelegate#saveWitness(WitnessCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConsensusDelegate.saveWitness(WitnessCapsule)"})
  public void testSaveWitness_thenCallsToByteArray() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(witnessStore).put(Mockito.<byte[]>any(), Mockito.<WitnessCapsule>any());
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    consensusDelegate.saveWitness(new WitnessCapsule(address));

    // Assert
    verify(address).toByteArray();
    verify(witnessStore).put(isA(byte[].class), isA(WitnessCapsule.class));
  }

  /**
   * Test {@link ConsensusDelegate#getAllWitnesses()}.
   * <p>
   * Method under test: {@link ConsensusDelegate#getAllWitnesses()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ConsensusDelegate.getAllWitnesses()"})
  public void testGetAllWitnesses() {
    // Arrange
    when(witnessStore.getAllWitnesses()).thenReturn(new ArrayList<>());

    // Act
    List<WitnessCapsule> actualAllWitnesses = consensusDelegate.getAllWitnesses();

    // Assert
    verify(witnessStore).getAllWitnesses();
    assertTrue(actualAllWitnesses.isEmpty());
  }

  /**
   * Test {@link ConsensusDelegate#saveStateFlag(int)}.
   * <p>
   * Method under test: {@link ConsensusDelegate#saveStateFlag(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConsensusDelegate.saveStateFlag(int)"})
  public void testSaveStateFlag() {
    // Arrange
    doNothing().when(dynamicPropertiesStore).saveStateFlag(anyInt());

    // Act
    consensusDelegate.saveStateFlag(1);

    // Assert
    verify(dynamicPropertiesStore).saveStateFlag(eq(1));
  }

  /**
   * Test {@link ConsensusDelegate#updateNextMaintenanceTime(long)}.
   * <p>
   * Method under test: {@link ConsensusDelegate#updateNextMaintenanceTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConsensusDelegate.updateNextMaintenanceTime(long)"})
  public void testUpdateNextMaintenanceTime() {
    // Arrange
    doNothing().when(dynamicPropertiesStore).updateNextMaintenanceTime(anyLong());

    // Act
    consensusDelegate.updateNextMaintenanceTime(10L);

    // Assert
    verify(dynamicPropertiesStore).updateNextMaintenanceTime(eq(10L));
  }

  /**
   * Test {@link ConsensusDelegate#getNextMaintenanceTime()}.
   * <p>
   * Method under test: {@link ConsensusDelegate#getNextMaintenanceTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ConsensusDelegate.getNextMaintenanceTime()"})
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
   * Test {@link ConsensusDelegate#getLatestSolidifiedBlockNum()}.
   * <p>
   * Method under test: {@link ConsensusDelegate#getLatestSolidifiedBlockNum()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ConsensusDelegate.getLatestSolidifiedBlockNum()"})
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
   * Test {@link ConsensusDelegate#saveLatestSolidifiedBlockNum(long)}.
   * <p>
   * Method under test: {@link ConsensusDelegate#saveLatestSolidifiedBlockNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConsensusDelegate.saveLatestSolidifiedBlockNum(long)"})
  public void testSaveLatestSolidifiedBlockNum() {
    // Arrange
    doNothing().when(dynamicPropertiesStore).saveLatestSolidifiedBlockNum(anyLong());

    // Act
    consensusDelegate.saveLatestSolidifiedBlockNum(1L);

    // Assert
    verify(dynamicPropertiesStore).saveLatestSolidifiedBlockNum(eq(1L));
  }

  /**
   * Test {@link ConsensusDelegate#applyBlock(boolean)}.
   * <p>
   * Method under test: {@link ConsensusDelegate#applyBlock(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConsensusDelegate.applyBlock(boolean)"})
  public void testApplyBlock() {
    // Arrange
    doNothing().when(dynamicPropertiesStore).applyBlock(anyBoolean());

    // Act
    consensusDelegate.applyBlock(true);

    // Assert
    verify(dynamicPropertiesStore).applyBlock(eq(true));
  }

  /**
   * Test {@link ConsensusDelegate#allowChangeDelegation()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsensusDelegate#allowChangeDelegation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConsensusDelegate.allowChangeDelegation()"})
  public void testAllowChangeDelegation_thenReturnFalse() {
    // Arrange
    when(dynamicPropertiesStore.allowChangeDelegation()).thenReturn(false);

    // Act
    boolean actualAllowChangeDelegationResult = consensusDelegate.allowChangeDelegation();

    // Assert
    verify(dynamicPropertiesStore).allowChangeDelegation();
    assertFalse(actualAllowChangeDelegationResult);
  }

  /**
   * Test {@link ConsensusDelegate#allowChangeDelegation()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsensusDelegate#allowChangeDelegation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConsensusDelegate.allowChangeDelegation()"})
  public void testAllowChangeDelegation_thenReturnTrue() {
    // Arrange
    when(dynamicPropertiesStore.allowChangeDelegation()).thenReturn(true);

    // Act
    boolean actualAllowChangeDelegationResult = consensusDelegate.allowChangeDelegation();

    // Assert
    verify(dynamicPropertiesStore).allowChangeDelegation();
    assertTrue(actualAllowChangeDelegationResult);
  }
}
