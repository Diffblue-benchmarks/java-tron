package org.tron.core.consensus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.common.backup.BackupManager;
import org.tron.common.backup.BackupManager.BackupStatusEnum;
import org.tron.common.overlay.message.Message;
import org.tron.consensus.Consensus;
import org.tron.consensus.base.Param;
import org.tron.consensus.base.Param.Miner;
import org.tron.consensus.base.State;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.db.Manager;
import org.tron.core.exception.AccountResourceInsufficientException;
import org.tron.core.exception.BadBlockException;
import org.tron.core.exception.BadNumberBlockException;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.exception.DupTransactionException;
import org.tron.core.exception.EventBloomException;
import org.tron.core.exception.NonCommonBlockException;
import org.tron.core.exception.ReceiptCheckErrException;
import org.tron.core.exception.TaposException;
import org.tron.core.exception.TooBigTransactionException;
import org.tron.core.exception.TooBigTransactionResultException;
import org.tron.core.exception.TransactionExpirationException;
import org.tron.core.exception.UnLinkedBlockException;
import org.tron.core.exception.VMIllegalException;
import org.tron.core.exception.ValidateScheduleException;
import org.tron.core.exception.ValidateSignatureException;
import org.tron.core.exception.ZksnarkException;
import org.tron.core.net.TronNetService;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class BlockHandleImplDiffblueTest {
  @Mock private BackupManager backupManager;

  @InjectMocks private BlockHandleImpl blockHandleImpl;

  @Mock private Consensus consensus;

  @Mock private Manager manager;

  @Mock private TronNetService tronNetService;

  /**
   * Test {@link BlockHandleImpl#getState()}.
   *
   * <ul>
   *   <li>Given {@link BackupManager} {@link BackupManager#getStatus()} return {@code INIT}.
   *   <li>Then return {@code BACKUP_IS_NOT_MASTER}.
   * </ul>
   *
   * <p>Method under test: {@link BlockHandleImpl#getState()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"State BlockHandleImpl.getState()"})
  public void testGetState_givenBackupManagerGetStatusReturnInit_thenReturnBackupIsNotMaster() {
    // Arrange
    when(backupManager.getStatus()).thenReturn(BackupStatusEnum.INIT);

    // Act
    State actualState = blockHandleImpl.getState();

    // Assert
    verify(backupManager).getStatus();
    assertEquals(State.BACKUP_IS_NOT_MASTER, actualState);
  }

  /**
   * Test {@link BlockHandleImpl#getState()}.
   *
   * <ul>
   *   <li>Given {@link BackupManager} {@link BackupManager#getStatus()} return {@code MASTER}.
   *   <li>Then return {@code OK}.
   * </ul>
   *
   * <p>Method under test: {@link BlockHandleImpl#getState()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"State BlockHandleImpl.getState()"})
  public void testGetState_givenBackupManagerGetStatusReturnMaster_thenReturnOk() {
    // Arrange
    when(backupManager.getStatus()).thenReturn(BackupStatusEnum.MASTER);

    // Act
    State actualState = blockHandleImpl.getState();

    // Assert
    verify(backupManager).getStatus();
    assertEquals(State.OK, actualState);
  }

  /**
   * Test {@link BlockHandleImpl#getLock()}.
   *
   * <p>Method under test: {@link BlockHandleImpl#getLock()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Object BlockHandleImpl.getLock()"})
  public void testGetLock() {
    // Arrange, Act and Assert
    assertNull(new BlockHandleImpl().getLock());
  }

  /**
   * Test {@link BlockHandleImpl#produce(Miner, long, long)}.
   *
   * <ul>
   *   <li>Given {@link Consensus} {@link Consensus#receiveBlock(BlockCapsule)} does nothing.
   *   <li>Then calls {@link Consensus#receiveBlock(BlockCapsule)}.
   * </ul>
   *
   * <p>Method under test: {@link BlockHandleImpl#produce(Miner, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockCapsule BlockHandleImpl.produce(Miner, long, long)"})
  public void testProduce_givenConsensusReceiveBlockDoesNothing_thenCallsReceiveBlock()
      throws UnsupportedEncodingException, AccountResourceInsufficientException, BadBlockException,
          BadNumberBlockException, ContractExeException, ContractValidateException,
          DupTransactionException, EventBloomException, NonCommonBlockException,
          ReceiptCheckErrException, TaposException, TooBigTransactionException,
          TooBigTransactionResultException, TransactionExpirationException, UnLinkedBlockException,
          VMIllegalException, ValidateScheduleException, ValidateSignatureException,
          ZksnarkException {
    // Arrange
    doNothing().when(consensus).receiveBlock(Mockito.<BlockCapsule>any());

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(manager).pushBlock(Mockito.<BlockCapsule>any());
    when(manager.generateBlock(Mockito.<Miner>any(), anyLong(), anyLong()))
        .thenReturn(blockCapsule);
    doNothing().when(tronNetService).broadcast(Mockito.<Message>any());
    Miner miner = Param.getInstance().new Miner("AXAXAXAX".getBytes("UTF-8"), null, null);

    // Act
    blockHandleImpl.produce(miner, 1L, 10L);

    // Assert
    verify(consensus).receiveBlock(isA(BlockCapsule.class));
    verify(blockCapsule).getData();
    verify(manager).generateBlock(isA(Miner.class), eq(1L), eq(10L));
    verify(manager).pushBlock(isA(BlockCapsule.class));
    verify(tronNetService).broadcast(isA(Message.class));
  }

  /**
   * Test {@link BlockHandleImpl#produce(Miner, long, long)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#generateBlock(Miner, long, long)} return {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BlockHandleImpl#produce(Miner, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockCapsule BlockHandleImpl.produce(Miner, long, long)"})
  public void testProduce_givenManagerGenerateBlockReturnNull_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    when(manager.generateBlock(Mockito.<Miner>any(), anyLong(), anyLong())).thenReturn(null);
    Miner miner = Param.getInstance().new Miner("AXAXAXAX".getBytes("UTF-8"), null, null);

    // Act
    BlockCapsule actualProduceResult = blockHandleImpl.produce(miner, 1L, 10L);

    // Assert
    verify(manager).generateBlock(isA(Miner.class), eq(1L), eq(10L));
    assertNull(actualProduceResult);
  }

  /**
   * Test {@link BlockHandleImpl#setBlockWaitLock(boolean)}.
   *
   * <p>Method under test: {@link BlockHandleImpl#setBlockWaitLock(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockHandleImpl.setBlockWaitLock(boolean)"})
  public void testSetBlockWaitLock() {
    // Arrange
    doNothing().when(manager).setBlockWaitLock(anyBoolean());

    // Act
    blockHandleImpl.setBlockWaitLock(true);

    // Assert
    verify(manager).setBlockWaitLock(true);
  }
}
