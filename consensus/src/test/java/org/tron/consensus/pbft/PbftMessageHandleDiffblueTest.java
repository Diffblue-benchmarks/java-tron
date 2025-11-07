package org.tron.consensus.pbft;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.tron.consensus.base.Param;
import org.tron.consensus.dpos.MaintenanceManager;
import org.tron.consensus.pbft.message.PbftMessage;
import org.tron.core.ChainBaseManager;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class PbftMessageHandleDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  @Mock
  private PbftMessageAction pbftMessageAction;

  @InjectMocks
  private PbftMessageHandle pbftMessageHandle;

  /**
   * Method under test: {@link PbftMessageHandle#init()}
   */
  @Test
  public void testInit() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("Data String");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");

    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.onPrePrepare(message);

    // Act
    pbftMessageHandle.init();

    // Assert that nothing has changed
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Method under test: {@link PbftMessageHandle#close()}
   */
  @Test
  public void testClose() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("Data String");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");

    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.onPrePrepare(message);

    // Act
    pbftMessageHandle.close();

    // Assert
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Method under test: {@link PbftMessageHandle#getSrMinerList(long)}
   */
  @Test
  public void testGetSrMinerList() {
    // Arrange
    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.setMaintenanceManager(new MaintenanceManager());
    ReflectionTestUtils.setField(pbftMessageHandle, "pbftMessageAction", mock(PbftMessageAction.class));
    ReflectionTestUtils.setField(pbftMessageHandle, "chainBaseManager", mock(ChainBaseManager.class));

    // Act and Assert
    assertTrue(pbftMessageHandle.getSrMinerList(1L).isEmpty());
  }

  /**
   * Method under test: {@link PbftMessageHandle#getSrMinerList(long)}
   */
  @Test
  public void testGetSrMinerList2() {
    // Arrange
    MaintenanceManager maintenanceManager = mock(MaintenanceManager.class);
    when(maintenanceManager.getBeforeWitness()).thenReturn(new ArrayList<>());
    when(maintenanceManager.getBeforeMaintenanceTime()).thenReturn(1L);

    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.setMaintenanceManager(maintenanceManager);
    ReflectionTestUtils.setField(pbftMessageHandle, "pbftMessageAction", mock(PbftMessageAction.class));
    ReflectionTestUtils.setField(pbftMessageHandle, "chainBaseManager", mock(ChainBaseManager.class));

    // Act
    List<Param.Miner> actualSrMinerList = pbftMessageHandle.getSrMinerList(1L);

    // Assert
    verify(maintenanceManager).getBeforeMaintenanceTime();
    verify(maintenanceManager).getBeforeWitness();
    assertTrue(actualSrMinerList.isEmpty());
  }

  /**
   * Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  public void testOnPrePrepare() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("Data String");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");
    when(message.setPbftMessage(Mockito.<Protocol.PBFTMessage>any())).thenReturn(new PbftMessage());
    message.setPbftMessage(null);

    // Act
    pbftMessageHandle.onPrePrepare(message);

    // Assert
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).setPbftMessage(isNull());
    verify(message).getNo();
  }

  /**
   * Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  public void testOnPrePrepare2() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("block chain switch, again proposal block num: {}, data: {}");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");
    when(message.setPbftMessage(Mockito.<Protocol.PBFTMessage>any())).thenReturn(new PbftMessage());
    message.setPbftMessage(null);

    // Act
    pbftMessageHandle.onPrePrepare(message);

    // Assert
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).setPbftMessage(isNull());
    verify(message).getNo();
  }

  /**
   * Method under test: {@link PbftMessageHandle#onPrepare(PbftMessage)}
   */
  @Test
  public void testOnPrepare() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getKey()).thenReturn("Key");
    when(message.getNo()).thenReturn("No");
    when(message.setPbftMessage(Mockito.<Protocol.PBFTMessage>any())).thenReturn(new PbftMessage());
    message.setPbftMessage(null);

    // Act
    pbftMessageHandle.onPrepare(message);

    // Assert
    verify(message).getKey();
    verify(message).setPbftMessage(isNull());
    verify(message).getNo();
  }

  /**
   * Method under test: {@link PbftMessageHandle#onPrepare(PbftMessage)}
   */
  @Test
  public void testOnPrepare2() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance());
    PbftMessage message = mock(PbftMessage.class);
    when(message.getKey()).thenReturn("Key");
    when(message.getNo()).thenReturn("No");
    when(message.setPbftMessage(Mockito.<Protocol.PBFTMessage>any())).thenReturn(pbftMessage);
    message.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance());

    // Act
    pbftMessageHandle.onPrepare(message);

    // Assert
    verify(message).getKey();
    verify(message).setPbftMessage(isA(Protocol.PBFTMessage.class));
    verify(message).getNo();
  }

  /**
   * Method under test: {@link PbftMessageHandle#onCommit(PbftMessage)}
   */
  @Test
  public void testOnCommit() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getKey()).thenReturn("Key");
    when(message.setPbftMessage(Mockito.<Protocol.PBFTMessage>any())).thenReturn(new PbftMessage());
    message.setPbftMessage(null);

    // Act
    pbftMessageHandle.onCommit(message);

    // Assert
    verify(message).getKey();
    verify(message).setPbftMessage(isNull());
  }

  /**
   * Method under test: {@link PbftMessageHandle#onCommit(PbftMessage)}
   */
  @Test
  public void testOnCommit2() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setData(new byte[]{'A', 'X', 'A', -1, 'A', 'X', 'A', 'X'});
    PbftMessage message = mock(PbftMessage.class);
    when(message.getKey()).thenReturn("Key");
    when(message.setPbftMessage(Mockito.<Protocol.PBFTMessage>any())).thenReturn(pbftMessage);
    message.setPbftMessage(null);

    // Act
    pbftMessageHandle.onCommit(message);

    // Assert
    verify(message).getKey();
    verify(message).setPbftMessage(isNull());
  }

  /**
   * Method under test: {@link PbftMessageHandle#checkIsCanSendMsg(long)}
   */
  @Test
  public void testCheckIsCanSendMsg() {
    // Arrange
    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.setMaintenanceManager(new MaintenanceManager());
    ReflectionTestUtils.setField(pbftMessageHandle, "pbftMessageAction", mock(PbftMessageAction.class));
    ReflectionTestUtils.setField(pbftMessageHandle, "chainBaseManager", mock(ChainBaseManager.class));

    // Act and Assert
    assertFalse(pbftMessageHandle.checkIsCanSendMsg(1L));
  }

  /**
   * Method under test: {@link PbftMessageHandle#checkIsCanSendMsg(long)}
   */
  @Test
  public void testCheckIsCanSendMsg2() {
    // Arrange
    MaintenanceManager maintenanceManager = mock(MaintenanceManager.class);
    when(maintenanceManager.getBeforeWitness()).thenReturn(new ArrayList<>());
    when(maintenanceManager.getBeforeMaintenanceTime()).thenReturn(1L);

    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.setMaintenanceManager(maintenanceManager);
    ReflectionTestUtils.setField(pbftMessageHandle, "pbftMessageAction", mock(PbftMessageAction.class));
    ReflectionTestUtils.setField(pbftMessageHandle, "chainBaseManager", mock(ChainBaseManager.class));

    // Act
    boolean actualCheckIsCanSendMsgResult = pbftMessageHandle.checkIsCanSendMsg(1L);

    // Assert
    verify(maintenanceManager).getBeforeMaintenanceTime();
    verify(maintenanceManager).getBeforeWitness();
    assertFalse(actualCheckIsCanSendMsgResult);
  }

  /**
   * Method under test: {@link PbftMessageHandle#isSyncing()}
   */
  @Test
  public void testIsSyncing() {
    // Arrange, Act and Assert
    assertFalse(pbftMessageHandle.isSyncing());
  }

  /**
   * Method under test: {@link PbftMessageHandle#start()}
   */
  @Test
  public void testStart() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("Data String");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");

    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.onPrePrepare(message);

    // Act
    pbftMessageHandle.start();

    // Assert that nothing has changed
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Method under test: {@link PbftMessageHandle#start()}
   */
  @Test
  public void testStart2() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("42");
    when(message.getNumber()).thenReturn(Long.MIN_VALUE);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");

    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.onPrePrepare(message);

    // Act
    pbftMessageHandle.start();

    // Assert that nothing has changed
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Method under test: {@link PbftMessageHandle#start()}
   */
  @Test
  public void testStart3() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("foo");
    when(message.getNumber()).thenReturn(Long.MIN_VALUE);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("42");

    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.onPrePrepare(message);

    // Act
    pbftMessageHandle.start();

    // Assert that nothing has changed
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Method under test: {@link PbftMessageHandle#start()}
   */
  @Test
  public void testStart4() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("foo");
    when(message.getNumber()).thenReturn(Long.MIN_VALUE);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("42");

    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.setMaintenanceManager(null);
    pbftMessageHandle.onPrePrepare(message);

    // Act
    pbftMessageHandle.start();

    // Assert that nothing has changed
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }
}
