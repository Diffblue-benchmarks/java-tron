package org.tron.core.net;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.backup.socket.BackupServer;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.db.Manager;
import org.tron.core.db.TransactionStore;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.exception.NonCommonBlockException;
import org.tron.core.exception.P2pException;
import org.tron.core.metrics.MetricsService;
import org.tron.core.net.message.MessageTypes;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.WitnessScheduleStore;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class TronNetDelegateDiffblueTest {
  @Mock
  private BackupServer backupServer;

  @Mock
  private ChainBaseManager chainBaseManager;

  @Mock
  private Manager manager;

  @Mock
  private MetricsService metricsService;

  @InjectMocks
  private TronNetDelegate tronNetDelegate;

  @Mock
  private WitnessScheduleStore witnessScheduleStore;

  /**
   * Method under test: {@link TronNetDelegate#getSyncBeginNumber()}
   */
  @Test
  public void testGetSyncBeginNumber() {
    // Arrange
    when(manager.getSyncBeginNumber()).thenReturn(1L);

    // Act
    long actualSyncBeginNumber = tronNetDelegate.getSyncBeginNumber();

    // Assert
    verify(manager).getSyncBeginNumber();
    assertEquals(1L, actualSyncBeginNumber);
  }

  /**
   * Method under test: {@link TronNetDelegate#getBlockTime(BlockCapsule.BlockId)}
   */
  @Test
  public void testGetBlockTime() throws BadItemException, ItemNotFoundException, P2pException {
    // Arrange
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any()))
        .thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));

    // Act
    long actualBlockTime = tronNetDelegate.getBlockTime(new BlockCapsule.BlockId());

    // Assert
    verify(chainBaseManager).getBlockById(isA(Sha256Hash.class));
    assertEquals(0L, actualBlockTime);
  }

  /**
   * Method under test: {@link TronNetDelegate#getBlockTime(BlockCapsule.BlockId)}
   */
  @Test
  public void testGetBlockTime2() throws BadItemException, ItemNotFoundException, P2pException {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any())).thenReturn(blockCapsule);

    // Act
    long actualBlockTime = tronNetDelegate.getBlockTime(new BlockCapsule.BlockId());

    // Assert
    verify(chainBaseManager).getBlockById(isA(Sha256Hash.class));
    verify(blockCapsule).getTimeStamp();
    assertEquals(10L, actualBlockTime);
  }

  /**
   * Method under test: {@link TronNetDelegate#getBlockTime(BlockCapsule.BlockId)}
   */
  @Test
  public void testGetBlockTime3() throws BadItemException, ItemNotFoundException, P2pException {
    // Arrange
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any())).thenThrow(new BadItemException("An error occurred"));

    // Act and Assert
    assertThrows(P2pException.class, () -> tronNetDelegate.getBlockTime(new BlockCapsule.BlockId()));
    verify(chainBaseManager).getBlockById(isA(Sha256Hash.class));
  }

  /**
   * Method under test: {@link TronNetDelegate#getBlockTime(BlockCapsule.BlockId)}
   */
  @Test
  public void testGetBlockTime4()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException, P2pException {
    // Arrange
    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    blockCapsule.setAccountStateRoot("AXAXAXAX".getBytes("UTF-8"));
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any())).thenReturn(blockCapsule);

    // Act
    long actualBlockTime = tronNetDelegate.getBlockTime(new BlockCapsule.BlockId());

    // Assert
    verify(chainBaseManager).getBlockById(isA(Sha256Hash.class));
    assertEquals(0L, actualBlockTime);
  }

  /**
   * Method under test: {@link TronNetDelegate#getHeadBlockId()}
   */
  @Test
  public void testGetHeadBlockId() {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();
    when(chainBaseManager.getHeadBlockId()).thenReturn(blockId);

    // Act
    BlockCapsule.BlockId actualHeadBlockId = tronNetDelegate.getHeadBlockId();

    // Assert
    verify(chainBaseManager).getHeadBlockId();
    assertSame(blockId, actualHeadBlockId);
  }

  /**
   * Method under test: {@link TronNetDelegate#getKhaosDbHeadBlockId()}
   */
  @Test
  public void testGetKhaosDbHeadBlockId() {
    // Arrange
    when(chainBaseManager.getKhaosDbHead()).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));

    // Act
    BlockCapsule.BlockId actualKhaosDbHeadBlockId = tronNetDelegate.getKhaosDbHeadBlockId();

    // Assert
    verify(chainBaseManager).getKhaosDbHead();
    BigInteger toBigIntegerResult = actualKhaosDbHeadBlockId.toBigInteger();
    assertEquals("3800201620905452580889821578709714074795303883058992822357", toBigIntegerResult.toString());
    assertEquals("Num:0,ID:00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualKhaosDbHeadBlockId.getString());
    ByteString byteString = actualKhaosDbHeadBlockId.getByteString();
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000���șo�$'�A�d��L���\u001bxR�U",
        byteString.toStringUtf8());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0L, actualKhaosDbHeadBlockId.getNum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals(1, toBigIntegerResult.signum());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[]{0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28, 'd', -101, -109, 'L',
        -92, -107, -103, 27, 'x', 'R', -72, 'U'}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
        'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, actualKhaosDbHeadBlockId.getBytes());
  }

  /**
   * Method under test: {@link TronNetDelegate#getKhaosDbHeadBlockId()}
   */
  @Test
  public void testGetKhaosDbHeadBlockId2() {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();
    when(blockCapsule.getBlockId()).thenReturn(blockId);
    when(chainBaseManager.getKhaosDbHead()).thenReturn(blockCapsule);

    // Act
    BlockCapsule.BlockId actualKhaosDbHeadBlockId = tronNetDelegate.getKhaosDbHeadBlockId();

    // Assert
    verify(chainBaseManager).getKhaosDbHead();
    verify(blockCapsule).getBlockId();
    assertSame(blockId, actualKhaosDbHeadBlockId);
  }

  /**
   * Method under test: {@link TronNetDelegate#getKhaosDbHeadBlockId()}
   */
  @Test
  public void testGetKhaosDbHeadBlockId3() throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    blockCapsule.setAccountStateRoot("AXAXAXAX".getBytes("UTF-8"));
    when(chainBaseManager.getKhaosDbHead()).thenReturn(blockCapsule);

    // Act
    BlockCapsule.BlockId actualKhaosDbHeadBlockId = tronNetDelegate.getKhaosDbHeadBlockId();

    // Assert
    verify(chainBaseManager).getKhaosDbHead();
    BigInteger toBigIntegerResult = actualKhaosDbHeadBlockId.toBigInteger();
    assertEquals("1951008271384299538986167461928191100453722984819457538283", toBigIntegerResult.toString());
    assertEquals("Num:0,ID:00000000000000004f917a0e8dfab76ab8da58cb3befebb7afb9091e673838eb",
        actualKhaosDbHeadBlockId.getString());
    ByteString byteString = actualKhaosDbHeadBlockId.getByteString();
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000O�z\u000e���j��X�;�뷯�\t\u001eg88�",
        byteString.toStringUtf8());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0L, actualKhaosDbHeadBlockId.getNum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals(1, toBigIntegerResult.signum());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[]{'O', -111, 'z', 14, -115, -6, -73, 'j', -72, -38, 'X', -53, ';', -17, -21, -73, -81,
        -71, '\t', 30, 'g', '8', '8', -21}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 'O', -111, 'z', 14, -115, -6, -73, 'j', -72, -38, 'X', -53,
        ';', -17, -21, -73, -81, -71, '\t', 30, 'g', '8', '8', -21}, actualKhaosDbHeadBlockId.getBytes());
  }

  /**
   * Method under test: {@link TronNetDelegate#getKhaosDbHeadBlockId()}
   */
  @Test
  public void testGetKhaosDbHeadBlockId4() {
    // Arrange
    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    blockCapsule.setWitness("ECKey");
    when(chainBaseManager.getKhaosDbHead()).thenReturn(blockCapsule);

    // Act
    BlockCapsule.BlockId actualKhaosDbHeadBlockId = tronNetDelegate.getKhaosDbHeadBlockId();

    // Assert
    verify(chainBaseManager).getKhaosDbHead();
    BigInteger toBigIntegerResult = actualKhaosDbHeadBlockId.toBigInteger();
    assertEquals("3272197632470858664502464031352598961015771882402473398061", toBigIntegerResult.toString());
    assertEquals("Num:0,ID:00000000000000008573565b4496eced6462f7e621fa01f4c45154f6f3494f2d",
        actualKhaosDbHeadBlockId.getString());
    ByteString byteString = actualKhaosDbHeadBlockId.getByteString();
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000�sV[D���db��!�\u0001��QT��IO-",
        byteString.toStringUtf8());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0L, actualKhaosDbHeadBlockId.getNum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals(1, toBigIntegerResult.signum());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[]{0, -123, 's', 'V', '[', 'D', -106, -20, -19, 'd', 'b', -9, -26, '!', -6, 1, -12, -60,
        'Q', 'T', -10, -13, 'I', 'O', '-'}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, -123, 's', 'V', '[', 'D', -106, -20, -19, 'd', 'b', -9, -26,
        '!', -6, 1, -12, -60, 'Q', 'T', -10, -13, 'I', 'O', '-'}, actualKhaosDbHeadBlockId.getBytes());
  }

  /**
   * Method under test: {@link TronNetDelegate#getSolidBlockId()}
   */
  @Test
  public void testGetSolidBlockId() {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();
    when(chainBaseManager.getSolidBlockId()).thenReturn(blockId);

    // Act
    BlockCapsule.BlockId actualSolidBlockId = tronNetDelegate.getSolidBlockId();

    // Assert
    verify(chainBaseManager).getSolidBlockId();
    assertSame(blockId, actualSolidBlockId);
  }

  /**
   * Method under test: {@link TronNetDelegate#getGenesisBlockId()}
   */
  @Test
  public void testGetGenesisBlockId() {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();
    when(chainBaseManager.getGenesisBlockId()).thenReturn(blockId);

    // Act
    BlockCapsule.BlockId actualGenesisBlockId = tronNetDelegate.getGenesisBlockId();

    // Assert
    verify(chainBaseManager).getGenesisBlockId();
    assertSame(blockId, actualGenesisBlockId);
  }

  /**
   * Method under test: {@link TronNetDelegate#getBlockIdByNum(long)}
   */
  @Test
  public void testGetBlockIdByNum() throws ItemNotFoundException, P2pException {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();
    when(chainBaseManager.getBlockIdByNum(anyLong())).thenReturn(blockId);

    // Act
    BlockCapsule.BlockId actualBlockIdByNum = tronNetDelegate.getBlockIdByNum(1L);

    // Assert
    verify(chainBaseManager).getBlockIdByNum(eq(1L));
    assertSame(blockId, actualBlockIdByNum);
  }

  /**
   * Method under test: {@link TronNetDelegate#getBlockIdByNum(long)}
   */
  @Test
  public void testGetBlockIdByNum2() throws ItemNotFoundException, P2pException {
    // Arrange
    when(chainBaseManager.getBlockIdByNum(anyLong())).thenThrow(new ItemNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(P2pException.class, () -> tronNetDelegate.getBlockIdByNum(1L));
    verify(chainBaseManager).getBlockIdByNum(eq(1L));
  }

  /**
   * Method under test: {@link TronNetDelegate#getGenesisBlock()}
   */
  @Test
  public void testGetGenesisBlock() {
    // Arrange
    when(chainBaseManager.getGenesisBlock()).thenReturn(null);

    // Act
    BlockCapsule actualGenesisBlock = tronNetDelegate.getGenesisBlock();

    // Assert
    verify(chainBaseManager).getGenesisBlock();
    assertNull(actualGenesisBlock);
  }

  /**
   * Method under test: {@link TronNetDelegate#getHeadBlockTimeStamp()}
   */
  @Test
  public void testGetHeadBlockTimeStamp() {
    // Arrange
    when(chainBaseManager.getHeadBlockTimeStamp()).thenReturn(1L);

    // Act
    long actualHeadBlockTimeStamp = tronNetDelegate.getHeadBlockTimeStamp();

    // Assert
    verify(chainBaseManager).getHeadBlockTimeStamp();
    assertEquals(1L, actualHeadBlockTimeStamp);
  }

  /**
   * Method under test: {@link TronNetDelegate#containBlock(BlockCapsule.BlockId)}
   */
  @Test
  public void testContainBlock() {
    // Arrange
    when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(true);

    // Act
    boolean actualContainBlockResult = tronNetDelegate.containBlock(new BlockCapsule.BlockId());

    // Assert
    verify(chainBaseManager).containBlock(isA(Sha256Hash.class));
    assertTrue(actualContainBlockResult);
  }

  /**
   * Method under test: {@link TronNetDelegate#containBlock(BlockCapsule.BlockId)}
   */
  @Test
  public void testContainBlock2() {
    // Arrange
    when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(false);

    // Act
    boolean actualContainBlockResult = tronNetDelegate.containBlock(new BlockCapsule.BlockId());

    // Assert
    verify(chainBaseManager).containBlock(isA(Sha256Hash.class));
    assertFalse(actualContainBlockResult);
  }

  /**
   * Method under test:
   * {@link TronNetDelegate#containBlockInMainChain(BlockCapsule.BlockId)}
   */
  @Test
  public void testContainBlockInMainChain() {
    // Arrange
    when(chainBaseManager.containBlockInMainChain(Mockito.<BlockCapsule.BlockId>any())).thenReturn(true);

    // Act
    boolean actualContainBlockInMainChainResult = tronNetDelegate.containBlockInMainChain(new BlockCapsule.BlockId());

    // Assert
    verify(chainBaseManager).containBlockInMainChain(isA(BlockCapsule.BlockId.class));
    assertTrue(actualContainBlockInMainChainResult);
  }

  /**
   * Method under test:
   * {@link TronNetDelegate#containBlockInMainChain(BlockCapsule.BlockId)}
   */
  @Test
  public void testContainBlockInMainChain2() {
    // Arrange
    when(chainBaseManager.containBlockInMainChain(Mockito.<BlockCapsule.BlockId>any())).thenReturn(false);

    // Act
    boolean actualContainBlockInMainChainResult = tronNetDelegate.containBlockInMainChain(new BlockCapsule.BlockId());

    // Assert
    verify(chainBaseManager).containBlockInMainChain(isA(BlockCapsule.BlockId.class));
    assertFalse(actualContainBlockInMainChainResult);
  }

  /**
   * Method under test:
   * {@link TronNetDelegate#getBlockChainHashesOnFork(BlockCapsule.BlockId)}
   */
  @Test
  public void testGetBlockChainHashesOnFork() throws NonCommonBlockException, P2pException {
    // Arrange
    LinkedList<BlockCapsule.BlockId> blockIdList = new LinkedList<>();
    when(manager.getBlockChainHashesOnFork(Mockito.<BlockCapsule.BlockId>any())).thenReturn(blockIdList);

    // Act
    List<BlockCapsule.BlockId> actualBlockChainHashesOnFork = tronNetDelegate
        .getBlockChainHashesOnFork(new BlockCapsule.BlockId());

    // Assert
    verify(manager).getBlockChainHashesOnFork(isA(BlockCapsule.BlockId.class));
    assertTrue(actualBlockChainHashesOnFork.isEmpty());
    assertSame(blockIdList, actualBlockChainHashesOnFork);
  }

  /**
   * Method under test:
   * {@link TronNetDelegate#getBlockChainHashesOnFork(BlockCapsule.BlockId)}
   */
  @Test
  public void testGetBlockChainHashesOnFork2() throws NonCommonBlockException, P2pException {
    // Arrange
    when(manager.getBlockChainHashesOnFork(Mockito.<BlockCapsule.BlockId>any()))
        .thenThrow(new NonCommonBlockException());

    // Act and Assert
    assertThrows(P2pException.class, () -> tronNetDelegate.getBlockChainHashesOnFork(new BlockCapsule.BlockId()));
    verify(manager).getBlockChainHashesOnFork(isA(BlockCapsule.BlockId.class));
  }

  /**
   * Method under test: {@link TronNetDelegate#canChainRevoke(long)}
   */
  @Test
  public void testCanChainRevoke() {
    // Arrange
    when(manager.getSyncBeginNumber()).thenReturn(1L);

    // Act
    boolean actualCanChainRevokeResult = tronNetDelegate.canChainRevoke(1L);

    // Assert
    verify(manager).getSyncBeginNumber();
    assertTrue(actualCanChainRevokeResult);
  }

  /**
   * Method under test: {@link TronNetDelegate#canChainRevoke(long)}
   */
  @Test
  public void testCanChainRevoke2() {
    // Arrange
    when(manager.getSyncBeginNumber()).thenReturn(Long.MAX_VALUE);

    // Act
    boolean actualCanChainRevokeResult = tronNetDelegate.canChainRevoke(1L);

    // Assert
    verify(manager).getSyncBeginNumber();
    assertFalse(actualCanChainRevokeResult);
  }

  /**
   * Method under test: {@link TronNetDelegate#contain(Sha256Hash, MessageTypes)}
   */
  @Test
  public void testContain() {
    // Arrange, Act and Assert
    assertFalse(tronNetDelegate.contain(null, MessageTypes.FIRST));
    assertFalse(tronNetDelegate.contain(mock(Sha256Hash.class), MessageTypes.FIRST));
  }

  /**
   * Method under test: {@link TronNetDelegate#contain(Sha256Hash, MessageTypes)}
   */
  @Test
  public void testContain2() throws UnsupportedEncodingException {
    // Arrange
    TransactionStore transactionStore = mock(TransactionStore.class);
    when(transactionStore.has(Mockito.<byte[]>any())).thenReturn(true);
    when(manager.getTransactionStore()).thenReturn(transactionStore);
    Sha256Hash hash = mock(Sha256Hash.class);
    when(hash.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualContainResult = tronNetDelegate.contain(hash, MessageTypes.TRX);

    // Assert
    verify(hash).getBytes();
    verify(manager).getTransactionStore();
    verify(transactionStore).has(isA(byte[].class));
    assertTrue(actualContainResult);
  }

  /**
   * Method under test: {@link TronNetDelegate#contain(Sha256Hash, MessageTypes)}
   */
  @Test
  public void testContain3() {
    // Arrange
    when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(true);

    // Act
    boolean actualContainResult = tronNetDelegate.contain(mock(Sha256Hash.class), MessageTypes.BLOCK);

    // Assert
    verify(chainBaseManager).containBlock(isA(Sha256Hash.class));
    assertTrue(actualContainResult);
  }

  /**
   * Method under test: {@link TronNetDelegate#allowPBFT()}
   */
  @Test
  public void testAllowPBFT() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    boolean actualAllowPBFTResult = tronNetDelegate.allowPBFT();

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
    assertTrue(actualAllowPBFTResult);
  }

  /**
   * Method under test: {@link TronNetDelegate#allowPBFT()}
   */
  @Test
  public void testAllowPBFT2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(false);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    boolean actualAllowPBFTResult = tronNetDelegate.allowPBFT();

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
    assertFalse(actualAllowPBFTResult);
  }

  /**
   * Method under test: {@link TronNetDelegate#getForkLock()}
   */
  @Test
  public void testGetForkLock() {
    // Arrange
    when(manager.getForkLock()).thenReturn("Fork Lock");

    // Act
    Object actualForkLock = tronNetDelegate.getForkLock();

    // Assert
    verify(manager).getForkLock();
    assertEquals("Fork Lock", actualForkLock);
  }

  /**
   * Method under test: {@link TronNetDelegate#getNextMaintenanceTime()}
   */
  @Test
  public void testGetNextMaintenanceTime() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getNextMaintenanceTime()).thenReturn(1L);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    long actualNextMaintenanceTime = tronNetDelegate.getNextMaintenanceTime();

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getNextMaintenanceTime();
    assertEquals(1L, actualNextMaintenanceTime);
  }

  /**
   * Method under test: {@link TronNetDelegate#getMaintenanceTimeInterval()}
   */
  @Test
  public void testGetMaintenanceTimeInterval() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    long actualMaintenanceTimeInterval = tronNetDelegate.getMaintenanceTimeInterval();

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getMaintenanceTimeInterval();
    assertEquals(42L, actualMaintenanceTimeInterval);
  }

  /**
   * Method under test: {@link TronNetDelegate#isBlockUnsolidified()}
   */
  @Test
  public void testIsBlockUnsolidified() {
    // Arrange, Act and Assert
    assertFalse(tronNetDelegate.isBlockUnsolidified());
  }

  /**
   * Method under test: {@link TronNetDelegate#getNextBlockSlotTime()}
   */
  @Test
  public void testGetNextBlockSlotTime() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getMaintenanceSkipSlots()).thenReturn(1L);
    when(dynamicPropertiesStore.getStateFlag()).thenReturn(1);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    long actualNextBlockSlotTime = tronNetDelegate.getNextBlockSlotTime();

    // Assert
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getMaintenanceSkipSlots();
    verify(dynamicPropertiesStore).getStateFlag();
    assertEquals(6001L, actualNextBlockSlotTime);
  }

  /**
   * Method under test: {@link TronNetDelegate#getNextBlockSlotTime()}
   */
  @Test
  public void testGetNextBlockSlotTime2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getStateFlag()).thenReturn(3000);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    long actualNextBlockSlotTime = tronNetDelegate.getNextBlockSlotTime();

    // Assert
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getStateFlag();
    assertEquals(3001L, actualNextBlockSlotTime);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TronNetDelegate#setExit(boolean)}
   *   <li>{@link TronNetDelegate#getBlockLock()}
   *   <li>{@link TronNetDelegate#isHitDown()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    TronNetDelegate tronNetDelegate = new TronNetDelegate();

    // Act
    tronNetDelegate.setExit(true);
    tronNetDelegate.getBlockLock();

    // Assert that nothing has changed
    assertFalse(tronNetDelegate.isHitDown());
  }
}
