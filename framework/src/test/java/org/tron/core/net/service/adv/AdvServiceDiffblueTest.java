package org.tron.core.net.service.adv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.cache.Cache;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.overlay.message.Message;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.message.adv.BlockMessage;
import org.tron.core.net.message.adv.TransactionMessage;
import org.tron.core.net.peer.Item;
import org.tron.core.net.peer.PeerConnection;
import org.tron.core.net.service.fetchblock.FetchBlockService;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class AdvServiceDiffblueTest {
  @InjectMocks
  private AdvService advService;

  @Mock
  private FetchBlockService fetchBlockService;

  @Mock
  private TronNetDelegate tronNetDelegate;

  /**
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  public void testAddInv() {
    // Arrange, Act and Assert
    assertTrue(advService.addInv(new Item(mock(Sha256Hash.class), Protocol.Inventory.InventoryType.TRX)));
  }

  /**
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  public void testAddInv2() {
    // Arrange
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(Protocol.Inventory.InventoryType.TRX);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(item, atLeast(1)).getType();
    assertTrue(actualAddInvResult);
  }

  /**
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  public void testAddInv3() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(Protocol.Inventory.InventoryType.BLOCK);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(item, atLeast(1)).getType();
    assertTrue(actualAddInvResult);
  }

  /**
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  public void testAddInv4() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(Protocol.Inventory.InventoryType.BLOCK);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(item, atLeast(1)).getType();
    assertTrue(actualAddInvResult);
  }

  /**
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  public void testAddInv5() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(Protocol.Inventory.InventoryType.BLOCK);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(item, atLeast(1)).getType();
    assertTrue(actualAddInvResult);
  }

  /**
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  public void testAddInv6() {
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
    when(item.getType()).thenReturn(Protocol.Inventory.InventoryType.BLOCK);

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
   * Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  public void testAddInv7() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isIdle()).thenReturn(false);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(Protocol.Inventory.InventoryType.BLOCK);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(item, atLeast(1)).getType();
    verify(peerConnection).isIdle();
    assertTrue(actualAddInvResult);
  }

  /**
   * Method under test: {@link AdvService#getMessage(Item)}
   */
  @Test
  public void testGetMessage() {
    // Arrange, Act and Assert
    assertNull(advService.getMessage(new Item(new BlockCapsule.BlockId(), Protocol.Inventory.InventoryType.TRX)));
    assertNull(advService.getMessage(new Item(mock(Sha256Hash.class), Protocol.Inventory.InventoryType.TRX)));
  }

  /**
   * Method under test: {@link AdvService#getMessage(Item)}
   */
  @Test
  public void testGetMessage2() {
    // Arrange
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(Protocol.Inventory.InventoryType.TRX);

    // Act
    Message actualMessage = advService.getMessage(item);

    // Assert
    verify(item).getType();
    assertNull(actualMessage);
  }

  /**
   * Method under test: {@link AdvService#getMessage(Item)}
   */
  @Test
  public void testGetMessage3() {
    // Arrange
    Item item = mock(Item.class);
    when(item.getType()).thenReturn(Protocol.Inventory.InventoryType.BLOCK);

    // Act
    Message actualMessage = advService.getMessage(item);

    // Assert
    verify(item).getType();
    assertNull(actualMessage);
  }

  /**
   * Method under test:
   * {@link AdvService#fastBroadcastTransaction(TransactionMessage)}
   */
  @Test
  public void testFastBroadcastTransaction() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());

    // Act
    int actualFastBroadcastTransactionResult = advService
        .fastBroadcastTransaction(new TransactionMessage(Protocol.Transaction.getDefaultInstance()));

    // Assert
    verify(tronNetDelegate).getActivePeer();
    assertEquals(0, actualFastBroadcastTransactionResult);
  }

  /**
   * Method under test:
   * {@link AdvService#fastBroadcastTransaction(TransactionMessage)}
   */
  @Test
  public void testFastBroadcastTransaction2() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    int actualFastBroadcastTransactionResult = advService
        .fastBroadcastTransaction(new TransactionMessage(Protocol.Transaction.getDefaultInstance()));

    // Assert
    verify(tronNetDelegate).getActivePeer();
    assertEquals(0, actualFastBroadcastTransactionResult);
  }

  /**
   * Method under test:
   * {@link AdvService#fastBroadcastTransaction(TransactionMessage)}
   */
  @Test
  public void testFastBroadcastTransaction3() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    int actualFastBroadcastTransactionResult = advService
        .fastBroadcastTransaction(new TransactionMessage(Protocol.Transaction.getDefaultInstance()));

    // Assert
    verify(tronNetDelegate).getActivePeer();
    assertEquals(0, actualFastBroadcastTransactionResult);
  }

  /**
   * Method under test:
   * {@link AdvService#fastBroadcastTransaction(TransactionMessage)}
   */
  @Test
  public void testFastBroadcastTransaction4() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());
    TransactionMessage msg = mock(TransactionMessage.class);
    when(msg.getMessageId()).thenReturn(null);

    // Act
    int actualFastBroadcastTransactionResult = advService.fastBroadcastTransaction(msg);

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getMessageId();
    assertEquals(0, actualFastBroadcastTransactionResult);
  }

  /**
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  public void testBroadcast() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(msg.getMessageId()).thenReturn(new BlockCapsule.BlockId());
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
  }

  /**
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  public void testBroadcast2() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(msg.getMessageId()).thenReturn(new BlockCapsule.BlockId());
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
  }

  /**
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  public void testBroadcast3() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(msg.getMessageId()).thenReturn(new BlockCapsule.BlockId());
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
  }

  /**
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  public void testBroadcast4() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(msg.getMessageId()).thenReturn(mock(Sha256Hash.class));
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
  }

  /**
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  public void testBroadcast5() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isNeedSyncFromPeer()).thenReturn(true);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(msg.getMessageId()).thenReturn(new BlockCapsule.BlockId());
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
    verify(peerConnection).isNeedSyncFromPeer();
  }

  /**
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  public void testBroadcast6() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isNeedSyncFromPeer()).thenReturn(false);
    when(peerConnection.isNeedSyncFromUs()).thenReturn(true);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(msg.getMessageId()).thenReturn(new BlockCapsule.BlockId());
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(blockId).getString();
    verify(tronNetDelegate).getActivePeer();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(msg).getMessageId();
    verify(peerConnection).isNeedSyncFromPeer();
    verify(peerConnection).isNeedSyncFromUs();
  }

  /**
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  public void testBroadcast7() {
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
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(msg.getMessageId()).thenReturn(new BlockCapsule.BlockId());
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(cache).getIfPresent(isA(Object.class));
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
   * Method under test: {@link AdvService#broadcast(Message)}
   */
  @Test
  public void testBroadcast8() {
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
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(msg.getMessageId()).thenReturn(new BlockCapsule.BlockId());
    when(msg.getBlockId()).thenReturn(blockId);

    // Act
    advService.broadcast(msg);

    // Assert
    verify(cache2).getIfPresent(isA(Object.class));
    verify(cache).getIfPresent(isA(Object.class));
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
   * Method under test: {@link AdvService.InvSender#getSize(PeerConnection)}
   */
  @Test
  public void testInvSenderGetSize() {
    // Arrange, Act and Assert
    assertEquals(0, ((new AdvService()).new InvSender()).getSize(null));
  }

  /**
   * Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  public void testOnDisconnect() {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(new HashMap<>());

    // Act
    advService.onDisconnect(peer);

    // Assert that nothing has changed
    verify(peer).getAdvInvRequest();
  }

  /**
   * Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  public void testOnDisconnect2() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());

    HashMap<Item, Long> itemResultLongMap = new HashMap<>();
    itemResultLongMap.put(new Item(new BlockCapsule.BlockId(), Protocol.Inventory.InventoryType.TRX), 1L);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(itemResultLongMap);

    // Act
    advService.onDisconnect(peer);

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(peer, atLeast(1)).getAdvInvRequest();
  }

  /**
   * Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  public void testOnDisconnect3() {
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
    itemResultLongMap.put(new Item(new BlockCapsule.BlockId(), Protocol.Inventory.InventoryType.TRX), 1L);
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
   * Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  public void testOnDisconnect4() {
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
    itemResultLongMap.put(new Item(new BlockCapsule.BlockId(), Protocol.Inventory.InventoryType.TRX), 1L);
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
   * Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  public void testOnDisconnect5() {
    // Arrange
    Cache<Item, Long> cache = mock(Cache.class);
    when(cache.getIfPresent(Mockito.<Object>any())).thenReturn(null);
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.getAdvInvReceive()).thenReturn(cache);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    HashMap<Item, Long> itemResultLongMap = new HashMap<>();
    itemResultLongMap.put(new Item(new BlockCapsule.BlockId(), Protocol.Inventory.InventoryType.TRX), 1L);
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
   * Method under test: {@link AdvService#getTrxCount()}
   */
  @Test
  public void testGetTrxCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AdvService()).getTrxCount().getTotalCount());
  }
}
