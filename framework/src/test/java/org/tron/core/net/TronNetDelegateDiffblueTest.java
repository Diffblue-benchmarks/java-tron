package org.tron.core.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.db.Manager;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.exception.NonCommonBlockException;
import org.tron.core.exception.P2pException;
import org.tron.core.net.message.MessageTypes;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Inventory;
import org.tron.protos.Protocol.Inventory.InventoryType;

@RunWith(MockitoJUnitRunner.class)
public class TronNetDelegateDiffblueTest {
  @Mock private ChainBaseManager chainBaseManager;

  @Mock private Manager manager;

  @InjectMocks private TronNetDelegate tronNetDelegate;

  /**
   * Test {@link TronNetDelegate#getSyncBeginNumber()}.
   *
   * <p>Method under test: {@link TronNetDelegate#getSyncBeginNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TronNetDelegate.getSyncBeginNumber()"})
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
   * Test {@link TronNetDelegate#getBlockTime(BlockId)}.
   *
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getTimeStamp()} return ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getBlockTime(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TronNetDelegate.getBlockTime(BlockId)"})
  public void testGetBlockTime_givenBlockCapsuleGetTimeStampReturnTen_thenReturnTen()
      throws BadItemException, ItemNotFoundException, P2pException {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any())).thenReturn(blockCapsule);

    // Act
    long actualBlockTime = tronNetDelegate.getBlockTime(new BlockId());

    // Assert
    verify(chainBaseManager).getBlockById(isA(Sha256Hash.class));
    verify(blockCapsule).getTimeStamp();
    assertEquals(10L, actualBlockTime);
  }

  /**
   * Test {@link TronNetDelegate#getBlockTime(BlockId)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link BlockId} {@link BlockId#getString()} return {@code String}.
   *   <li>Then calls {@link BlockId#getString()}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getBlockTime(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TronNetDelegate.getBlockTime(BlockId)"})
  public void testGetBlockTime_givenString_whenBlockIdGetStringReturnString_thenCallsGetString()
      throws BadItemException, ItemNotFoundException, P2pException {
    // Arrange
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any()))
        .thenThrow(new BadItemException("An error occurred"));

    BlockId id = mock(BlockId.class);
    when(id.getString()).thenReturn("String");

    // Act and Assert
    assertThrows(P2pException.class, () -> tronNetDelegate.getBlockTime(id));
    verify(chainBaseManager).getBlockById(isA(Sha256Hash.class));
    verify(id).getString();
  }

  /**
   * Test {@link TronNetDelegate#getBlockTime(BlockId)}.
   *
   * <ul>
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getBlockTime(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TronNetDelegate.getBlockTime(BlockId)"})
  public void testGetBlockTime_thenThrowP2pException()
      throws BadItemException, ItemNotFoundException, P2pException {
    // Arrange
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any()))
        .thenThrow(new BadItemException("An error occurred"));

    // Act and Assert
    assertThrows(P2pException.class, () -> tronNetDelegate.getBlockTime(new BlockId()));
    verify(chainBaseManager).getBlockById(isA(Sha256Hash.class));
  }

  /**
   * Test {@link TronNetDelegate#getHeadBlockId()}.
   *
   * <p>Method under test: {@link TronNetDelegate#getHeadBlockId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockId TronNetDelegate.getHeadBlockId()"})
  public void testGetHeadBlockId() {
    // Arrange
    BlockId blockId = new BlockId();
    when(chainBaseManager.getHeadBlockId()).thenReturn(blockId);

    // Act
    BlockId actualHeadBlockId = tronNetDelegate.getHeadBlockId();

    // Assert
    verify(chainBaseManager).getHeadBlockId();
    assertSame(blockId, actualHeadBlockId);
  }

  /**
   * Test {@link TronNetDelegate#getKhaosDbHeadBlockId()}.
   *
   * <ul>
   *   <li>Then return {@link BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getKhaosDbHeadBlockId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockId TronNetDelegate.getKhaosDbHeadBlockId()"})
  public void testGetKhaosDbHeadBlockId_thenReturnBlockId() {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    BlockId blockId = new BlockId();
    when(blockCapsule.getBlockId()).thenReturn(blockId);
    when(chainBaseManager.getKhaosDbHead()).thenReturn(blockCapsule);

    // Act
    BlockId actualKhaosDbHeadBlockId = tronNetDelegate.getKhaosDbHeadBlockId();

    // Assert
    verify(chainBaseManager).getKhaosDbHead();
    verify(blockCapsule).getBlockId();
    assertSame(blockId, actualKhaosDbHeadBlockId);
  }

  /**
   * Test {@link TronNetDelegate#getSolidBlockId()}.
   *
   * <p>Method under test: {@link TronNetDelegate#getSolidBlockId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockId TronNetDelegate.getSolidBlockId()"})
  public void testGetSolidBlockId() {
    // Arrange
    BlockId blockId = new BlockId();
    when(chainBaseManager.getSolidBlockId()).thenReturn(blockId);

    // Act
    BlockId actualSolidBlockId = tronNetDelegate.getSolidBlockId();

    // Assert
    verify(chainBaseManager).getSolidBlockId();
    assertSame(blockId, actualSolidBlockId);
  }

  /**
   * Test {@link TronNetDelegate#getGenesisBlockId()}.
   *
   * <p>Method under test: {@link TronNetDelegate#getGenesisBlockId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockId TronNetDelegate.getGenesisBlockId()"})
  public void testGetGenesisBlockId() {
    // Arrange
    BlockId blockId = new BlockId();
    when(chainBaseManager.getGenesisBlockId()).thenReturn(blockId);

    // Act
    BlockId actualGenesisBlockId = tronNetDelegate.getGenesisBlockId();

    // Assert
    verify(chainBaseManager).getGenesisBlockId();
    assertSame(blockId, actualGenesisBlockId);
  }

  /**
   * Test {@link TronNetDelegate#getBlockIdByNum(long)}.
   *
   * <ul>
   *   <li>Then return {@link BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getBlockIdByNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockId TronNetDelegate.getBlockIdByNum(long)"})
  public void testGetBlockIdByNum_thenReturnBlockId() throws ItemNotFoundException, P2pException {
    // Arrange
    BlockId blockId = new BlockId();
    when(chainBaseManager.getBlockIdByNum(anyLong())).thenReturn(blockId);

    // Act
    BlockId actualBlockIdByNum = tronNetDelegate.getBlockIdByNum(1L);

    // Assert
    verify(chainBaseManager).getBlockIdByNum(1L);
    assertSame(blockId, actualBlockIdByNum);
  }

  /**
   * Test {@link TronNetDelegate#getBlockIdByNum(long)}.
   *
   * <ul>
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getBlockIdByNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockId TronNetDelegate.getBlockIdByNum(long)"})
  public void testGetBlockIdByNum_thenThrowP2pException()
      throws ItemNotFoundException, P2pException {
    // Arrange
    when(chainBaseManager.getBlockIdByNum(anyLong()))
        .thenThrow(new ItemNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(P2pException.class, () -> tronNetDelegate.getBlockIdByNum(1L));
    verify(chainBaseManager).getBlockIdByNum(1L);
  }

  /**
   * Test {@link TronNetDelegate#getGenesisBlock()}.
   *
   * <p>Method under test: {@link TronNetDelegate#getGenesisBlock()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockCapsule TronNetDelegate.getGenesisBlock()"})
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
   * Test {@link TronNetDelegate#getHeadBlockTimeStamp()}.
   *
   * <p>Method under test: {@link TronNetDelegate#getHeadBlockTimeStamp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TronNetDelegate.getHeadBlockTimeStamp()"})
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
   * Test {@link TronNetDelegate#containBlock(BlockId)}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#containBlock(Sha256Hash)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#containBlock(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetDelegate.containBlock(BlockId)"})
  public void testContainBlock_givenChainBaseManagerContainBlockReturnFalse_thenReturnFalse() {
    // Arrange
    when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(false);

    // Act
    boolean actualContainBlockResult = tronNetDelegate.containBlock(new BlockId());

    // Assert
    verify(chainBaseManager).containBlock(isA(Sha256Hash.class));
    assertFalse(actualContainBlockResult);
  }

  /**
   * Test {@link TronNetDelegate#containBlock(BlockId)}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#containBlock(Sha256Hash)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#containBlock(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetDelegate.containBlock(BlockId)"})
  public void testContainBlock_givenChainBaseManagerContainBlockReturnTrue_thenReturnTrue() {
    // Arrange
    when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(true);

    // Act
    boolean actualContainBlockResult = tronNetDelegate.containBlock(new BlockId());

    // Assert
    verify(chainBaseManager).containBlock(isA(Sha256Hash.class));
    assertTrue(actualContainBlockResult);
  }

  /**
   * Test {@link TronNetDelegate#containBlockInMainChain(BlockId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#containBlockInMainChain(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetDelegate.containBlockInMainChain(BlockId)"})
  public void testContainBlockInMainChain_thenReturnFalse() {
    // Arrange
    when(chainBaseManager.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(false);

    // Act
    boolean actualContainBlockInMainChainResult =
        tronNetDelegate.containBlockInMainChain(new BlockId());

    // Assert
    verify(chainBaseManager).containBlockInMainChain(isA(BlockId.class));
    assertFalse(actualContainBlockInMainChainResult);
  }

  /**
   * Test {@link TronNetDelegate#containBlockInMainChain(BlockId)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#containBlockInMainChain(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetDelegate.containBlockInMainChain(BlockId)"})
  public void testContainBlockInMainChain_thenReturnTrue() {
    // Arrange
    when(chainBaseManager.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(true);

    // Act
    boolean actualContainBlockInMainChainResult =
        tronNetDelegate.containBlockInMainChain(new BlockId());

    // Assert
    verify(chainBaseManager).containBlockInMainChain(isA(BlockId.class));
    assertTrue(actualContainBlockInMainChainResult);
  }

  /**
   * Test {@link TronNetDelegate#getBlockChainHashesOnFork(BlockId)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link BlockId#getString()}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getBlockChainHashesOnFork(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TronNetDelegate.getBlockChainHashesOnFork(BlockId)"})
  public void testGetBlockChainHashesOnFork_givenString_thenCallsGetString()
      throws NonCommonBlockException, P2pException {
    // Arrange
    when(manager.getBlockChainHashesOnFork(Mockito.<BlockId>any()))
        .thenThrow(new NonCommonBlockException());

    BlockId forkBlockHash = mock(BlockId.class);
    when(forkBlockHash.getString()).thenReturn("String");

    // Act and Assert
    assertThrows(
        P2pException.class, () -> tronNetDelegate.getBlockChainHashesOnFork(forkBlockHash));
    verify(forkBlockHash).getString();
    verify(manager).getBlockChainHashesOnFork(isA(BlockId.class));
  }

  /**
   * Test {@link TronNetDelegate#getBlockChainHashesOnFork(BlockId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getBlockChainHashesOnFork(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TronNetDelegate.getBlockChainHashesOnFork(BlockId)"})
  public void testGetBlockChainHashesOnFork_thenReturnEmpty()
      throws NonCommonBlockException, P2pException {
    // Arrange
    when(manager.getBlockChainHashesOnFork(Mockito.<BlockId>any())).thenReturn(new LinkedList<>());

    // Act
    List<BlockId> actualBlockChainHashesOnFork =
        tronNetDelegate.getBlockChainHashesOnFork(new BlockId());

    // Assert
    verify(manager).getBlockChainHashesOnFork(isA(BlockId.class));
    assertTrue(actualBlockChainHashesOnFork.isEmpty());
  }

  /**
   * Test {@link TronNetDelegate#getBlockChainHashesOnFork(BlockId)}.
   *
   * <ul>
   *   <li>When {@link BlockId#BlockId()}.
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getBlockChainHashesOnFork(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TronNetDelegate.getBlockChainHashesOnFork(BlockId)"})
  public void testGetBlockChainHashesOnFork_whenBlockId_thenThrowP2pException()
      throws NonCommonBlockException, P2pException {
    // Arrange
    when(manager.getBlockChainHashesOnFork(Mockito.<BlockId>any()))
        .thenThrow(new NonCommonBlockException());

    // Act and Assert
    assertThrows(
        P2pException.class, () -> tronNetDelegate.getBlockChainHashesOnFork(new BlockId()));
    verify(manager).getBlockChainHashesOnFork(isA(BlockId.class));
  }

  /**
   * Test {@link TronNetDelegate#canChainRevoke(long)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getSyncBeginNumber()} return {@link Long#MAX_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#canChainRevoke(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetDelegate.canChainRevoke(long)"})
  public void testCanChainRevoke_givenManagerGetSyncBeginNumberReturnMax_value_thenReturnFalse() {
    // Arrange
    when(manager.getSyncBeginNumber()).thenReturn(Long.MAX_VALUE);

    // Act
    boolean actualCanChainRevokeResult = tronNetDelegate.canChainRevoke(1L);

    // Assert
    verify(manager).getSyncBeginNumber();
    assertFalse(actualCanChainRevokeResult);
  }

  /**
   * Test {@link TronNetDelegate#canChainRevoke(long)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getSyncBeginNumber()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#canChainRevoke(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetDelegate.canChainRevoke(long)"})
  public void testCanChainRevoke_givenManagerGetSyncBeginNumberReturnOne_thenReturnTrue() {
    // Arrange
    when(manager.getSyncBeginNumber()).thenReturn(1L);

    // Act
    boolean actualCanChainRevokeResult = tronNetDelegate.canChainRevoke(1L);

    // Assert
    verify(manager).getSyncBeginNumber();
    assertTrue(actualCanChainRevokeResult);
  }

  /**
   * Test {@link TronNetDelegate#contain(Sha256Hash, MessageTypes)}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#containBlock(Sha256Hash)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#contain(Sha256Hash, MessageTypes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetDelegate.contain(Sha256Hash, MessageTypes)"})
  public void testContain_givenChainBaseManagerContainBlockReturnTrue_thenReturnTrue() {
    // Arrange
    when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(true);

    // Act
    boolean actualContainResult =
        tronNetDelegate.contain(mock(Sha256Hash.class), MessageTypes.BLOCK);

    // Assert
    verify(chainBaseManager).containBlock(isA(Sha256Hash.class));
    assertTrue(actualContainResult);
  }

  /**
   * Test {@link TronNetDelegate#contain(Sha256Hash, MessageTypes)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#contain(Sha256Hash, MessageTypes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetDelegate.contain(Sha256Hash, MessageTypes)"})
  public void testContain_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(tronNetDelegate.contain(null, MessageTypes.FIRST));
  }

  /**
   * Test {@link TronNetDelegate#getData(Sha256Hash, InventoryType)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@code UNRECOGNIZED}.
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getData(Sha256Hash,
   * Protocol.Inventory.InventoryType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "org.tron.common.overlay.message.Message TronNetDelegate.getData(Sha256Hash, Protocol.Inventory.InventoryType)"
  })
  public void testGetData_givenNull_whenUnrecognized_thenThrowP2pException() throws P2pException {
    // Arrange
    Sha256Hash hash = mock(Sha256Hash.class);
    when(hash.getByteString()).thenReturn(null);

    // Act and Assert
    assertThrows(
        P2pException.class, () -> tronNetDelegate.getData(hash, InventoryType.UNRECOGNIZED));
    verify(hash).getByteString();
  }

  /**
   * Test {@link TronNetDelegate#getData(Sha256Hash, InventoryType)}.
   *
   * <ul>
   *   <li>Then calls {@link ChainBaseManager#getBlockById(Sha256Hash)}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getData(Sha256Hash,
   * Protocol.Inventory.InventoryType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "org.tron.common.overlay.message.Message TronNetDelegate.getData(Sha256Hash, Protocol.Inventory.InventoryType)"
  })
  public void testGetData_thenCallsGetBlockById()
      throws BadItemException, ItemNotFoundException, P2pException {
    // Arrange
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any()))
        .thenThrow(new BadItemException("An error occurred"));

    Sha256Hash hash = mock(Sha256Hash.class);
    when(hash.getByteString()).thenReturn(null);

    // Act and Assert
    assertThrows(P2pException.class, () -> tronNetDelegate.getData(hash, InventoryType.BLOCK));
    verify(hash).getByteString();
    verify(chainBaseManager).getBlockById(isA(Sha256Hash.class));
  }

  /**
   * Test {@link TronNetDelegate#allowPBFT()}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#allowPBFT()} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#allowPBFT()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetDelegate.allowPBFT()"})
  public void testAllowPBFT_givenDynamicPropertiesStoreAllowPBFTReturnFalse_thenReturnFalse() {
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
   * Test {@link TronNetDelegate#allowPBFT()}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#allowPBFT()} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#allowPBFT()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetDelegate.allowPBFT()"})
  public void testAllowPBFT_givenDynamicPropertiesStoreAllowPBFTReturnTrue_thenReturnTrue() {
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
   * Test {@link TronNetDelegate#getForkLock()}.
   *
   * <p>Method under test: {@link TronNetDelegate#getForkLock()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object TronNetDelegate.getForkLock()"})
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
   * Test {@link TronNetDelegate#getNextMaintenanceTime()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getNextMaintenanceTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TronNetDelegate.getNextMaintenanceTime()"})
  public void testGetNextMaintenanceTime_thenReturnOne() {
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
   * Test {@link TronNetDelegate#getMaintenanceTimeInterval()}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getMaintenanceTimeInterval()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TronNetDelegate.getMaintenanceTimeInterval()"})
  public void testGetMaintenanceTimeInterval_thenReturnFortyTwo() {
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
   * Test {@link TronNetDelegate#isBlockUnsolidified()}.
   *
   * <p>Method under test: {@link TronNetDelegate#isBlockUnsolidified()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetDelegate.isBlockUnsolidified()"})
  public void testIsBlockUnsolidified() {
    // Arrange, Act and Assert
    assertFalse(tronNetDelegate.isBlockUnsolidified());
  }

  /**
   * Test {@link TronNetDelegate#getNextBlockSlotTime()}.
   *
   * <ul>
   *   <li>Then return {@code 3001}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getNextBlockSlotTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TronNetDelegate.getNextBlockSlotTime()"})
  public void testGetNextBlockSlotTime_thenReturn3001() {
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
   * Test {@link TronNetDelegate#getNextBlockSlotTime()}.
   *
   * <ul>
   *   <li>Then return {@code 6001}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetDelegate#getNextBlockSlotTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TronNetDelegate.getNextBlockSlotTime()"})
  public void testGetNextBlockSlotTime_thenReturn6001() {
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TronNetDelegate#setExit(boolean)}
   *   <li>{@link TronNetDelegate#getBlockLock()}
   *   <li>{@link TronNetDelegate#isHitDown()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Object TronNetDelegate.getBlockLock()",
    "boolean TronNetDelegate.isHitDown()",
    "void TronNetDelegate.setExit(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    TronNetDelegate tronNetDelegate = new TronNetDelegate();

    // Act
    tronNetDelegate.setExit(true);
    tronNetDelegate.getBlockLock();

    // Assert
    assertFalse(tronNetDelegate.isHitDown());
  }
}
