package org.tron.core.consensus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.backup.BackupManager;
import org.tron.common.overlay.message.Message;
import org.tron.consensus.Consensus;
import org.tron.consensus.base.Param;
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
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class BlockHandleImplDiffblueTest {
  @Mock
  private BackupManager backupManager;

  @InjectMocks
  private BlockHandleImpl blockHandleImpl;

  @Mock
  private Consensus consensus;

  @Mock
  private Manager manager;

  @Mock
  private TronNetService tronNetService;

  /**
   * Method under test: {@link BlockHandleImpl#getState()}
   */
  @Test
  public void testGetState() {
    // Arrange
    when(backupManager.getStatus()).thenReturn(BackupManager.BackupStatusEnum.INIT);

    // Act
    State actualState = blockHandleImpl.getState();

    // Assert
    verify(backupManager).getStatus();
    assertEquals(State.BACKUP_IS_NOT_MASTER, actualState);
  }

  /**
   * Method under test: {@link BlockHandleImpl#getState()}
   */
  @Test
  public void testGetState2() {
    // Arrange
    when(backupManager.getStatus()).thenReturn(BackupManager.BackupStatusEnum.MASTER);

    // Act
    State actualState = blockHandleImpl.getState();

    // Assert
    verify(backupManager).getStatus();
    assertEquals(State.OK, actualState);
  }

  /**
   * Method under test: {@link BlockHandleImpl#getLock()}
   */
  @Test
  public void testGetLock() {
    // Arrange, Act and Assert
    assertNull((new BlockHandleImpl()).getLock());
  }

  /**
   * Method under test: {@link BlockHandleImpl#produce(Param.Miner, long, long)}
   */
  @Test
  public void testProduce() throws UnsupportedEncodingException {
    // Arrange
    when(manager.generateBlock(Mockito.<Param.Miner>any(), anyLong(), anyLong())).thenReturn(null);
    Param instance = Param.getInstance();

    // Act
    BlockCapsule actualProduceResult = blockHandleImpl
        .produce(instance.new Miner("AXAXAXAX".getBytes("UTF-8"), null, null), 1L, 10L);

    // Assert
    verify(manager).generateBlock(isA(Param.Miner.class), eq(1L), eq(10L));
    assertNull(actualProduceResult);
  }

  /**
   * Method under test: {@link BlockHandleImpl#produce(Param.Miner, long, long)}
   */
  @Test
  public void testProduce2() throws UnsupportedEncodingException, AccountResourceInsufficientException,
      BadBlockException, BadNumberBlockException, ContractExeException, ContractValidateException,
      DupTransactionException, EventBloomException, NonCommonBlockException, ReceiptCheckErrException, TaposException,
      TooBigTransactionException, TooBigTransactionResultException, TransactionExpirationException,
      UnLinkedBlockException, VMIllegalException, ValidateScheduleException, ValidateSignatureException,
      ZksnarkException {
    // Arrange
    doNothing().when(consensus).receiveBlock(Mockito.<BlockCapsule>any());
    doNothing().when(manager).pushBlock(Mockito.<BlockCapsule>any());
    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    when(manager.generateBlock(Mockito.<Param.Miner>any(), anyLong(), anyLong())).thenReturn(blockCapsule);
    doNothing().when(tronNetService).broadcast(Mockito.<Message>any());
    Param instance = Param.getInstance();

    // Act
    BlockCapsule actualProduceResult = blockHandleImpl
        .produce(instance.new Miner("AXAXAXAX".getBytes("UTF-8"), null, null), 1L, 10L);

    // Assert
    verify(consensus).receiveBlock(isA(BlockCapsule.class));
    verify(manager).generateBlock(isA(Param.Miner.class), eq(1L), eq(10L));
    verify(manager).pushBlock(isA(BlockCapsule.class));
    verify(tronNetService).broadcast(isA(Message.class));
    assertSame(blockCapsule, actualProduceResult);
  }

  /**
   * Method under test: {@link BlockHandleImpl#produce(Param.Miner, long, long)}
   */
  @Test
  public void testProduce3() throws UnsupportedEncodingException, AccountResourceInsufficientException,
      BadBlockException, BadNumberBlockException, ContractExeException, ContractValidateException,
      DupTransactionException, EventBloomException, NonCommonBlockException, ReceiptCheckErrException, TaposException,
      TooBigTransactionException, TooBigTransactionResultException, TransactionExpirationException,
      UnLinkedBlockException, VMIllegalException, ValidateScheduleException, ValidateSignatureException,
      ZksnarkException {
    // Arrange
    doNothing().when(consensus).receiveBlock(Mockito.<BlockCapsule>any());
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(manager).pushBlock(Mockito.<BlockCapsule>any());
    when(manager.generateBlock(Mockito.<Param.Miner>any(), anyLong(), anyLong())).thenReturn(blockCapsule);
    doNothing().when(tronNetService).broadcast(Mockito.<Message>any());
    Param instance = Param.getInstance();

    // Act
    blockHandleImpl.produce(instance.new Miner("AXAXAXAX".getBytes("UTF-8"), null, null), 1L, 10L);

    // Assert
    verify(consensus).receiveBlock(isA(BlockCapsule.class));
    verify(blockCapsule).getData();
    verify(manager).generateBlock(isA(Param.Miner.class), eq(1L), eq(10L));
    verify(manager).pushBlock(isA(BlockCapsule.class));
    verify(tronNetService).broadcast(isA(Message.class));
  }

  /**
   * Method under test: {@link BlockHandleImpl#setBlockWaitLock(boolean)}
   */
  @Test
  public void testSetBlockWaitLock() {
    // Arrange
    doNothing().when(manager).setBlockWaitLock(anyBoolean());

    // Act
    blockHandleImpl.setBlockWaitLock(true);

    // Assert that nothing has changed
    verify(manager).setBlockWaitLock(eq(true));
  }
}
