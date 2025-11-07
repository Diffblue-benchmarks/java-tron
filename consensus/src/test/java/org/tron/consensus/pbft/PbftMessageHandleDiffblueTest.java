package org.tron.consensus.pbft;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.consensus.base.Param;
import org.tron.consensus.base.Param.Miner;
import org.tron.consensus.dpos.MaintenanceManager;
import org.tron.consensus.pbft.message.PbftBaseMessage;
import org.tron.consensus.pbft.message.PbftMessage;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PbftMessageHandleDiffblueTest {
  @InjectMocks
  private PbftMessageHandle pbftMessageHandle;

  /**
   * Test {@link PbftMessageHandle#getSrMinerList(long)}.
   * <ul>
   *   <li>Given {@link PbftMessageHandle} (default constructor) MaintenanceManager is {@link MaintenanceManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageHandle#getSrMinerList(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PbftMessageHandle.getSrMinerList(long)"})
  public void testGetSrMinerList_givenPbftMessageHandleMaintenanceManagerIsMaintenanceManager() {
    // Arrange
    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.setMaintenanceManager(new MaintenanceManager());

    // Act and Assert
    assertTrue(pbftMessageHandle.getSrMinerList(1L).isEmpty());
  }

  /**
   * Test {@link PbftMessageHandle#getSrMinerList(long)}.
   * <ul>
   *   <li>Then calls {@link MaintenanceManager#getBeforeMaintenanceTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageHandle#getSrMinerList(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PbftMessageHandle.getSrMinerList(long)"})
  public void testGetSrMinerList_thenCallsGetBeforeMaintenanceTime() {
    // Arrange
    MaintenanceManager maintenanceManager = mock(MaintenanceManager.class);
    when(maintenanceManager.getBeforeWitness()).thenReturn(new ArrayList<>());
    when(maintenanceManager.getBeforeMaintenanceTime()).thenReturn(1L);

    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.setMaintenanceManager(maintenanceManager);

    // Act
    List<Miner> actualSrMinerList = pbftMessageHandle.getSrMinerList(1L);

    // Assert
    verify(maintenanceManager).getBeforeMaintenanceTime();
    verify(maintenanceManager).getBeforeWitness();
    assertTrue(actualSrMinerList.isEmpty());
  }

  /**
   * Test {@link PbftMessageHandle#onPrePrepare(PbftMessage)}.
   * <ul>
   *   <li>Given {@code Data String}.</li>
   *   <li>Then calls {@link PbftBaseMessage#getDataString()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageHandle.onPrePrepare(PbftMessage)"})
  public void testOnPrePrepare_givenDataString_thenCallsGetDataString() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("Data String");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");

    // Act
    pbftMessageHandle.onPrePrepare(message);

    // Assert
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onPrepare(PbftMessage)}.
   * <ul>
   *   <li>Given {@code Key}.</li>
   *   <li>When {@link PbftMessage} {@link PbftBaseMessage#getKey()} return {@code Key}.</li>
   *   <li>Then calls {@link PbftBaseMessage#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageHandle#onPrepare(PbftMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageHandle.onPrepare(PbftMessage)"})
  public void testOnPrepare_givenKey_whenPbftMessageGetKeyReturnKey_thenCallsGetKey() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getKey()).thenReturn("Key");
    when(message.getNo()).thenReturn("No");

    // Act
    pbftMessageHandle.onPrepare(message);

    // Assert
    verify(message).getKey();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onCommit(PbftMessage)}.
   * <ul>
   *   <li>Given {@code Key}.</li>
   *   <li>When {@link PbftMessage} {@link PbftBaseMessage#getKey()} return {@code Key}.</li>
   *   <li>Then calls {@link PbftBaseMessage#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageHandle#onCommit(PbftMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageHandle.onCommit(PbftMessage)"})
  public void testOnCommit_givenKey_whenPbftMessageGetKeyReturnKey_thenCallsGetKey() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getKey()).thenReturn("Key");

    // Act
    pbftMessageHandle.onCommit(message);

    // Assert
    verify(message).getKey();
  }

  /**
   * Test {@link PbftMessageHandle#checkIsCanSendMsg(long)}.
   * <p>
   * Method under test: {@link PbftMessageHandle#checkIsCanSendMsg(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PbftMessageHandle.checkIsCanSendMsg(long)"})
  public void testCheckIsCanSendMsg() {
    // Arrange
    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.setMaintenanceManager(new MaintenanceManager());

    // Act and Assert
    assertFalse(pbftMessageHandle.checkIsCanSendMsg(1L));
  }

  /**
   * Test {@link PbftMessageHandle#checkIsCanSendMsg(long)}.
   * <ul>
   *   <li>Then calls {@link MaintenanceManager#getBeforeMaintenanceTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageHandle#checkIsCanSendMsg(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PbftMessageHandle.checkIsCanSendMsg(long)"})
  public void testCheckIsCanSendMsg_thenCallsGetBeforeMaintenanceTime() {
    // Arrange
    MaintenanceManager maintenanceManager = mock(MaintenanceManager.class);
    when(maintenanceManager.getBeforeWitness()).thenReturn(new ArrayList<>());
    when(maintenanceManager.getBeforeMaintenanceTime()).thenReturn(1L);

    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.setMaintenanceManager(maintenanceManager);

    // Act
    boolean actualCheckIsCanSendMsgResult = pbftMessageHandle.checkIsCanSendMsg(1L);

    // Assert
    verify(maintenanceManager).getBeforeMaintenanceTime();
    verify(maintenanceManager).getBeforeWitness();
    assertFalse(actualCheckIsCanSendMsgResult);
  }

  /**
   * Test {@link PbftMessageHandle#isSyncing()}.
   * <p>
   * Method under test: {@link PbftMessageHandle#isSyncing()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PbftMessageHandle.isSyncing()"})
  public void testIsSyncing() {
    // Arrange, Act and Assert
    assertFalse(pbftMessageHandle.isSyncing());
  }
}
