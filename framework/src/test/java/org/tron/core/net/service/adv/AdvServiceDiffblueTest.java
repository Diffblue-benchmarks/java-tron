package org.tron.core.net.service.adv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.cache.Cache;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.common.overlay.message.Message;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.message.adv.BlockMessage;
import org.tron.core.net.message.adv.TransactionMessage;
import org.tron.core.net.peer.Item;
import org.tron.core.net.peer.PeerConnection;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Inventory;
import org.tron.protos.Protocol.Inventory.InventoryType;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AdvServiceDiffblueTest {
  @InjectMocks
  private AdvService advService;

  @Mock
  private TronNetDelegate tronNetDelegate;

  /**
   * Test {@link AdvService#addInv(Item)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PeerConnection} (default constructor).</li>
   *   <li>Then calls {@link TronNetDelegate#getActivePeer()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_givenArrayListAddPeerConnection_thenCallsGetActivePeer() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(InventoryType.BLOCK);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(item, atLeast(1)).getType();
    assertTrue(actualAddInvResult);
  }

  /**
   * Test {@link AdvService#addInv(Item)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PeerConnection} (default constructor).</li>
   *   <li>Then calls {@link TronNetDelegate#getActivePeer()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_givenArrayListAddPeerConnection_thenCallsGetActivePeer2() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(InventoryType.BLOCK);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(item, atLeast(1)).getType();
    assertTrue(actualAddInvResult);
  }

  /**
   * Test {@link AdvService#addInv(Item)}.
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#getIfPresent(Object)} return one.</li>
   *   <li>Then calls {@link Cache#getIfPresent(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_givenCacheGetIfPresentReturnOne_thenCallsGetIfPresent() {
    // Arrange
    Cache<Item, Long> cache = mock(Cache.class);
    when(cache.getIfPresent(Mockito.<Object>any())).thenReturn(1L);
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.getAdvInvReceive()).thenReturn(cache);
    when(peerConnection.isIdle()).thenReturn(true);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(InventoryType.BLOCK);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(cache).getIfPresent(isA(Object.class));
    verify(tronNetDelegate).getActivePeer();
    verify(item, atLeast(1)).getType();
    verify(peerConnection).getAdvInvReceive();
    verify(peerConnection).isIdle();
    assertTrue(actualAddInvResult);
  }

  /**
   * Test {@link AdvService#addInv(Item)}.
   * <ul>
   *   <li>Given {@link PeerConnection} {@link PeerConnection#isIdle()} return {@code false}.</li>
   *   <li>Then calls {@link PeerConnection#isIdle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_givenPeerConnectionIsIdleReturnFalse_thenCallsIsIdle() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isIdle()).thenReturn(false);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(InventoryType.BLOCK);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(item, atLeast(1)).getType();
    verify(peerConnection).isIdle();
    assertTrue(actualAddInvResult);
  }

  /**
   * Test {@link AdvService#addInv(Item)}.
   * <ul>
   *   <li>Given {@code TRX}.</li>
   *   <li>When {@link Item} {@link Item#getType()} return {@code TRX}.</li>
   *   <li>Then calls {@link Item#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_givenTrx_whenItemGetTypeReturnTrx_thenCallsGetType() {
    // Arrange
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(InventoryType.TRX);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(item, atLeast(1)).getType();
    assertTrue(actualAddInvResult);
  }

  /**
   * Test {@link AdvService#addInv(Item)}.
   * <ul>
   *   <li>Then calls {@link TronNetDelegate#getActivePeer()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_thenCallsGetActivePeer() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(InventoryType.BLOCK);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(item, atLeast(1)).getType();
    assertTrue(actualAddInvResult);
  }

  /**
   * Test {@link AdvService#addInv(Item)}.
   * <ul>
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link BlockId#BlockId()} and type is {@code TRX}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_whenItemWithHashIsBlockIdAndTypeIsTrx_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(advService.addInv(new Item(new BlockId(), InventoryType.TRX)));
  }

  /**
   * Test {@link AdvService#addInv(Item)}.
   * <ul>
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link Sha256Hash} and type is {@code TRX}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_whenItemWithHashIsSha256HashAndTypeIsTrx_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(advService.addInv(new Item(mock(Sha256Hash.class), InventoryType.TRX)));
  }

  /**
   * Test {@link AdvService#getMessage(Item)}.
   * <ul>
   *   <li>Given {@code BLOCK}.</li>
   *   <li>When {@link Item} {@link Item#getType()} return {@code BLOCK}.</li>
   *   <li>Then calls {@link Item#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#getMessage(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Message AdvService.getMessage(Item)"})
  public void testGetMessage_givenBlock_whenItemGetTypeReturnBlock_thenCallsGetType() {
    // Arrange
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(InventoryType.BLOCK);

    // Act
    Message actualMessage = advService.getMessage(item);

    // Assert
    verify(item).getType();
    assertNull(actualMessage);
  }

  /**
   * Test {@link AdvService#getMessage(Item)}.
   * <ul>
   *   <li>Given {@code TRX}.</li>
   *   <li>When {@link Item} {@link Item#getType()} return {@code TRX}.</li>
   *   <li>Then calls {@link Item#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#getMessage(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Message AdvService.getMessage(Item)"})
  public void testGetMessage_givenTrx_whenItemGetTypeReturnTrx_thenCallsGetType() {
    // Arrange
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(InventoryType.TRX);

    // Act
    Message actualMessage = advService.getMessage(item);

    // Assert
    verify(item).getType();
    assertNull(actualMessage);
  }

  /**
   * Test {@link AdvService#getMessage(Item)}.
   * <ul>
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link BlockId#BlockId()} and type is {@code TRX}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#getMessage(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Message AdvService.getMessage(Item)"})
  public void testGetMessage_whenItemWithHashIsBlockIdAndTypeIsTrx_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(advService.getMessage(new Item(new BlockId(), InventoryType.TRX)));
  }

  /**
   * Test {@link AdvService#getMessage(Item)}.
   * <ul>
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link Sha256Hash} and type is {@code TRX}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#getMessage(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Message AdvService.getMessage(Item)"})
  public void testGetMessage_whenItemWithHashIsSha256HashAndTypeIsTrx_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(advService.getMessage(new Item(mock(Sha256Hash.class), InventoryType.TRX)));
  }

  /**
   * Test {@link AdvService#fastBroadcastTransaction(TransactionMessage)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#fastBroadcastTransaction(TransactionMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AdvService.fastBroadcastTransaction(TransactionMessage)"})
  public void testFastBroadcastTransaction_givenNull_thenReturnZero() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isNeedSyncFromPeer()).thenReturn(true);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    TransactionMessage msg = mock(TransactionMessage.class);
    when(msg.getMessageId()).thenReturn(null);

    // Act
    int actualFastBroadcastTransactionResult = advService.fastBroadcastTransaction(msg);

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getMessageId();
    verify(peerConnection).isNeedSyncFromPeer();
    assertEquals(0, actualFastBroadcastTransactionResult);
  }

  /**
   * Test {@link AdvService#broadcast(Message)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PeerConnection} (default constructor).</li>
   *   <li>Then calls {@link BlockCapsule#getTransactions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.broadcast(Message)"})
  public void testBroadcast_givenArrayListAddPeerConnection_thenCallsGetTransactions() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    BlockId blockId = mock(BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTransactions()).thenReturn(new ArrayList<>());
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(blockCapsule);
    when(msg.getMessageId()).thenReturn(mock(Sha256Hash.class));
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(blockCapsule).getTransactions();
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
  }

  /**
   * Test {@link AdvService#broadcast(Message)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PeerConnection} (default constructor).</li>
   *   <li>Then calls {@link BlockCapsule#getTransactions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.broadcast(Message)"})
  public void testBroadcast_givenArrayListAddPeerConnection_thenCallsGetTransactions2() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    BlockId blockId = mock(BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTransactions()).thenReturn(new ArrayList<>());
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(blockCapsule);
    when(msg.getMessageId()).thenReturn(mock(Sha256Hash.class));
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(blockCapsule).getTransactions();
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
  }

  /**
   * Test {@link AdvService#broadcast(Message)}.
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#getIfPresent(Object)} return one.</li>
   *   <li>Then calls {@link PeerConnection#getAdvInvSpread()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.broadcast(Message)"})
  public void testBroadcast_givenCacheGetIfPresentReturnOne_thenCallsGetAdvInvSpread() {
    // Arrange
    Cache<Item, Long> cache = mock(Cache.class);
    when(cache.getIfPresent(Mockito.<Object>any())).thenReturn(null);
    Cache<Item, Long> cache2 = mock(Cache.class);
    when(cache2.getIfPresent(Mockito.<Object>any())).thenReturn(1L);
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.getAdvInvSpread()).thenReturn(cache2);
    when(peerConnection.isNeedSyncFromPeer()).thenReturn(false);
    when(peerConnection.isNeedSyncFromUs()).thenReturn(false);
    when(peerConnection.getAdvInvReceive()).thenReturn(cache);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    BlockId blockId = mock(BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTransactions()).thenReturn(new ArrayList<>());
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(blockCapsule);
    when(msg.getMessageId()).thenReturn(mock(Sha256Hash.class));
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(cache2).getIfPresent(isA(Object.class));
    verify(cache).getIfPresent(isA(Object.class));
    verify(blockCapsule).getTransactions();
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
    verify(peerConnection).getAdvInvReceive();
    verify(peerConnection).getAdvInvSpread();
    verify(peerConnection).isNeedSyncFromPeer();
    verify(peerConnection).isNeedSyncFromUs();
  }

  /**
   * Test {@link AdvService#broadcast(Message)}.
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#getIfPresent(Object)} return one.</li>
   *   <li>Then calls {@link Cache#getIfPresent(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.broadcast(Message)"})
  public void testBroadcast_givenCacheGetIfPresentReturnOne_thenCallsGetIfPresent() {
    // Arrange
    Cache<Item, Long> cache = mock(Cache.class);
    when(cache.getIfPresent(Mockito.<Object>any())).thenReturn(1L);
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isNeedSyncFromPeer()).thenReturn(false);
    when(peerConnection.isNeedSyncFromUs()).thenReturn(false);
    when(peerConnection.getAdvInvReceive()).thenReturn(cache);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    BlockId blockId = mock(BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTransactions()).thenReturn(new ArrayList<>());
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(blockCapsule);
    when(msg.getMessageId()).thenReturn(mock(Sha256Hash.class));
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(cache).getIfPresent(isA(Object.class));
    verify(blockCapsule).getTransactions();
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
    verify(peerConnection).getAdvInvReceive();
    verify(peerConnection).isNeedSyncFromPeer();
    verify(peerConnection).isNeedSyncFromUs();
  }

  /**
   * Test {@link AdvService#broadcast(Message)}.
   * <ul>
   *   <li>Given {@link PeerConnection} {@link PeerConnection#isNeedSyncFromPeer()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.broadcast(Message)"})
  public void testBroadcast_givenPeerConnectionIsNeedSyncFromPeerReturnTrue() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isNeedSyncFromPeer()).thenReturn(true);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    BlockId blockId = mock(BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTransactions()).thenReturn(new ArrayList<>());
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(blockCapsule);
    when(msg.getMessageId()).thenReturn(mock(Sha256Hash.class));
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(blockCapsule).getTransactions();
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
    verify(peerConnection).isNeedSyncFromPeer();
  }

  /**
   * Test {@link AdvService#broadcast(Message)}.
   * <ul>
   *   <li>Given {@link PeerConnection} {@link PeerConnection#isNeedSyncFromUs()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.broadcast(Message)"})
  public void testBroadcast_givenPeerConnectionIsNeedSyncFromUsReturnTrue() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isNeedSyncFromPeer()).thenReturn(false);
    when(peerConnection.isNeedSyncFromUs()).thenReturn(true);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    BlockId blockId = mock(BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTransactions()).thenReturn(new ArrayList<>());
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(blockCapsule);
    when(msg.getMessageId()).thenReturn(mock(Sha256Hash.class));
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(blockCapsule).getTransactions();
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
    verify(peerConnection).isNeedSyncFromPeer();
    verify(peerConnection).isNeedSyncFromUs();
  }

  /**
   * Test {@link AdvService#broadcast(Message)}.
   * <ul>
   *   <li>Given {@link Sha256Hash}.</li>
   *   <li>Then calls {@link BlockCapsule#getTransactions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.broadcast(Message)"})
  public void testBroadcast_givenSha256Hash_thenCallsGetTransactions() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());
    BlockId blockId = mock(BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTransactions()).thenReturn(new ArrayList<>());
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(blockCapsule);
    when(msg.getMessageId()).thenReturn(mock(Sha256Hash.class));
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(blockCapsule).getTransactions();
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#getIfPresent(Object)} return {@code null}.</li>
   *   <li>Then calls {@link Cache#getIfPresent(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenCacheGetIfPresentReturnNull_thenCallsGetIfPresent() {
    // Arrange
    Cache<Item, Long> cache = mock(Cache.class);
    when(cache.getIfPresent(Mockito.<Object>any())).thenReturn(null);
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.getAdvInvReceive()).thenReturn(cache);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    HashMap<Item, Long> itemResultLongMap = new HashMap<>();
    itemResultLongMap.put(new Item(new BlockId(), InventoryType.TRX), 1L);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(itemResultLongMap);

    // Act
    advService.onDisconnect(peer);

    // Assert
    verify(cache).getIfPresent(isA(Object.class));
    verify(tronNetDelegate).getActivePeer();
    verify(peerConnection).getAdvInvReceive();
    verify(peer, atLeast(1)).getAdvInvRequest();
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#getIfPresent(Object)} return one.</li>
   *   <li>Then calls {@link PeerConnection#isIdle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenCacheGetIfPresentReturnOne_thenCallsIsIdle() {
    // Arrange
    Cache<Item, Long> cache = mock(Cache.class);
    when(cache.getIfPresent(Mockito.<Object>any())).thenReturn(1L);
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isIdle()).thenReturn(true);
    when(peerConnection.getAdvInvReceive()).thenReturn(cache);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    HashMap<Item, Long> itemResultLongMap = new HashMap<>();
    itemResultLongMap.put(new Item(new BlockId(), InventoryType.TRX), 1L);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(itemResultLongMap);

    // Act
    advService.onDisconnect(peer);

    // Assert
    verify(cache, atLeast(1)).getIfPresent(isA(Object.class));
    verify(tronNetDelegate, atLeast(1)).getActivePeer();
    verify(peerConnection, atLeast(1)).getAdvInvReceive();
    verify(peer, atLeast(1)).getAdvInvRequest();
    verify(peerConnection).isIdle();
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link PeerConnection#getAdvInvRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenHashMap_thenCallsGetAdvInvRequest() {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(new HashMap<>());

    // Act
    advService.onDisconnect(peer);

    // Assert
    verify(peer).getAdvInvRequest();
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   * <ul>
   *   <li>Given {@link PeerConnection} {@link PeerConnection#isIdle()} return {@code false}.</li>
   *   <li>Then calls {@link PeerConnection#isIdle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenPeerConnectionIsIdleReturnFalse_thenCallsIsIdle() {
    // Arrange
    Cache<Item, Long> cache = mock(Cache.class);
    when(cache.getIfPresent(Mockito.<Object>any())).thenReturn(1L);
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isIdle()).thenReturn(false);
    when(peerConnection.getAdvInvReceive()).thenReturn(cache);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    HashMap<Item, Long> itemResultLongMap = new HashMap<>();
    itemResultLongMap.put(new Item(new BlockId(), InventoryType.TRX), 1L);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(itemResultLongMap);

    // Act
    advService.onDisconnect(peer);

    // Assert
    verify(cache).getIfPresent(isA(Object.class));
    verify(tronNetDelegate, atLeast(1)).getActivePeer();
    verify(peerConnection).getAdvInvReceive();
    verify(peer, atLeast(1)).getAdvInvRequest();
    verify(peerConnection).isIdle();
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   * <ul>
   *   <li>Then calls {@link TronNetDelegate#getActivePeer()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_thenCallsGetActivePeer() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());

    HashMap<Item, Long> itemResultLongMap = new HashMap<>();
    itemResultLongMap.put(new Item(new BlockId(), InventoryType.TRX), 1L);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(itemResultLongMap);

    // Act
    advService.onDisconnect(peer);

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(peer, atLeast(1)).getAdvInvRequest();
  }

  /**
   * Test {@link AdvService#getTrxCount()}.
   * <p>
   * Method under test: {@link AdvService#getTrxCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.net.service.statistics.MessageCount AdvService.getTrxCount()"})
  public void testGetTrxCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AdvService()).getTrxCount().getTotalCount());
  }
}
