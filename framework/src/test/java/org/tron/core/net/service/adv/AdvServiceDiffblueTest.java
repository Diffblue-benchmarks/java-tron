package org.tron.core.net.service.adv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.cache.Cache;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
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
import org.tron.common.utils.Pair;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.peer.Item;
import org.tron.core.net.peer.PeerConnection;
import org.tron.core.net.service.adv.AdvService.InvSender;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Inventory;
import org.tron.protos.Protocol.Inventory.InventoryType;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class AdvServiceDiffblueTest {
  @InjectMocks private AdvService advService;

  @Mock private AdvService advService2;

  @Mock private TronNetDelegate tronNetDelegate;

  /**
   * Test {@link AdvService#addInv(Item)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PeerConnection} (default constructor).
   *   <li>Then calls {@link TronNetDelegate#getActivePeer()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInv(Item)}
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PeerConnection} (default constructor).
   *   <li>Then calls {@link TronNetDelegate#getActivePeer()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInv(Item)}
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
   *
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#getIfPresent(Object)} return one.
   *   <li>Then calls {@link Cache#getIfPresent(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInv(Item)}
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
   *
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#getIfPresent(Object)} return one.
   *   <li>Then calls {@link PeerConnection#setSyncBlockRequested(Map)}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_givenCacheGetIfPresentReturnOne_thenCallsSetSyncBlockRequested() {
    // Arrange
    Cache<Item, Long> cache = mock(Cache.class);
    when(cache.getIfPresent(Mockito.<Object>any())).thenReturn(Long.MAX_VALUE);

    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.checkAndPutAdvInvRequest(Mockito.<Item>any(), Mockito.<Long>any()))
        .thenReturn(false);
    when(peerConnection.getAdvInvReceive()).thenReturn(cache);
    when(peerConnection.isIdle()).thenReturn(true);

    PeerConnection peerConnection2 = mock(PeerConnection.class);
    when(peerConnection2.isIdle()).thenReturn(false);

    HashMap<BlockId, Long> syncBlockRequested = new HashMap<>();
    syncBlockRequested.put(new BlockId(), 1L);

    Cache<Item, Long> cache2 = mock(Cache.class);
    when(cache2.getIfPresent(Mockito.<Object>any())).thenReturn(1L);

    PeerConnection peerConnection3 = mock(PeerConnection.class);
    when(peerConnection3.getAdvInvReceive()).thenReturn(cache2);
    when(peerConnection3.isIdle()).thenReturn(true);
    doNothing().when(peerConnection3).setSyncBlockRequested(Mockito.<Map<BlockId, Long>>any());
    doNothing()
        .when(peerConnection3)
        .setSyncChainRequested(Mockito.<Pair<Deque<BlockId>, Long>>any());
    peerConnection3.setSyncBlockRequested(syncBlockRequested);
    peerConnection3.setSyncChainRequested(new Pair<>(new LinkedList<>(), 42L));

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection3);
    peerConnectionList.add(peerConnection2);
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    Item item = mock(Item.class);
    when(item.getType()).thenReturn(InventoryType.BLOCK);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(cache2).getIfPresent(isA(Object.class));
    verify(cache).getIfPresent(isA(Object.class));
    verify(tronNetDelegate).getActivePeer();
    verify(item, atLeast(1)).getType();
    verify(peerConnection3).getAdvInvReceive();
    verify(peerConnection).getAdvInvReceive();
    verify(peerConnection3).isIdle();
    verify(peerConnection2).isIdle();
    verify(peerConnection).isIdle();
    verify(peerConnection3).setSyncBlockRequested(isA(Map.class));
    verify(peerConnection3).setSyncChainRequested(isA(Pair.class));
    assertTrue(actualAddInvResult);
  }

  /**
   * Test {@link AdvService#addInv(Item)}.
   *
   * <ul>
   *   <li>Given {@code TRX}.
   *   <li>When {@link Item} {@link Item#getType()} return {@code TRX}.
   *   <li>Then calls {@link Item#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInv(Item)}
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
   *
   * <ul>
   *   <li>Then calls {@link TronNetDelegate#getActivePeer()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInv(Item)}
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
   *
   * <ul>
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link BlockId#BlockId()}
   *       and type is {@code TRX}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInv(Item)}
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
   *
   * <ul>
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link Sha256Hash} and
   *       type is {@code TRX}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInv(Item)}
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
   *
   * <ul>
   *   <li>Given {@code BLOCK}.
   *   <li>When {@link Item} {@link Item#getType()} return {@code BLOCK}.
   *   <li>Then calls {@link Item#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#getMessage(Item)}
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
   *
   * <ul>
   *   <li>Given {@link Protocol.Inventory.InventoryType#TRX}.
   *   <li>When {@link Item} {@link Item#getType()} return {@link
   *       Protocol.Inventory.InventoryType#TRX}.
   *   <li>Then calls {@link Item#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#getMessage(Item)}
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
   *
   * <ul>
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link BlockId#BlockId()}
   *       and type is {@code TRX}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#getMessage(Item)}
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
   *
   * <ul>
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link Sha256Hash} and
   *       type is {@code TRX}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#getMessage(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Message AdvService.getMessage(Item)"})
  public void testGetMessage_whenItemWithHashIsSha256HashAndTypeIsTrx_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(advService.getMessage(new Item(mock(Sha256Hash.class), InventoryType.TRX)));
  }

  /**
   * Test {@link AdvService#getMessage(Item)}.
   *
   * <ul>
   *   <li>When {@link Sha256Hash#Sha256Hash(long, Sha256Hash)} with num is one and hash is {@link
   *       BlockId#BlockId()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#getMessage(Item)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Message AdvService.getMessage(Item)"})
  public void testGetMessage_whenSha256HashWithNumIsOneAndHashIsBlockId_thenReturnNull() {
    // Arrange
    Sha256Hash hash = new Sha256Hash(1L, new BlockId());

    // Act and Assert
    assertNull(advService.getMessage(new Item(hash, InventoryType.TRX)));
  }

  /**
   * Test InvSender {@link InvSender#add(Entry, PeerConnection)} with {@code Entry}, {@code
   * PeerConnection}.
   *
   * <p>Method under test: {@link InvSender#add(Entry, PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvSender.add(Entry, PeerConnection)"})
  public void testInvSenderAddWithEntryPeerConnection() {
    // Arrange
    InvSender invSender = new AdvService().new InvSender();

    // Act
    invSender.add(new SimpleEntry<>(null, InventoryType.TRX), null);

    // Assert
    assertEquals(1, invSender.getSize(null));
  }

  /**
   * Test InvSender {@link InvSender#add(Item, PeerConnection)} with {@code Item}, {@code
   * PeerConnection}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then calls {@link Item#getHash()}.
   * </ul>
   *
   * <p>Method under test: {@link InvSender#add(Item, PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvSender.add(Item, PeerConnection)"})
  public void testInvSenderAddWithItemPeerConnection_givenNull_thenCallsGetHash() {
    // Arrange
    InvSender invSender = advService2.new InvSender();

    Item id = mock(Item.class);
    when(id.getHash()).thenReturn(null);
    when(id.getType()).thenReturn(InventoryType.TRX);

    // Act
    invSender.add(id, null);

    // Assert
    verify(id).getHash();
    verify(id, atLeast(1)).getType();
  }

  /**
   * Test InvSender {@link InvSender#getSize(PeerConnection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link InvSender#getSize(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InvSender.getSize(PeerConnection)"})
  public void testInvSenderGetSize_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, advService2.new InvSender().getSize(null));
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#getIfPresent(Object)} return {@code null}.
   *   <li>Then calls {@link Cache#getIfPresent(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
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
   *
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#getIfPresent(Object)} return one.
   *   <li>Then calls {@link PeerConnection#isIdle()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
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
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link Item} is one.
   *   <li>Then calls {@link PeerConnection#isIdle()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenHashMapItemIsOne_thenCallsIsIdle() {
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
    itemResultLongMap.put(mock(Item.class), 1L);

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
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link Item#Item(Sha256Hash, InventoryType)} with hash is
   *       {@link BlockId#BlockId()} and type is {@code TRX} is one.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenHashMapItemWithHashIsBlockIdAndTypeIsTrxIsOne() {
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
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link Item#Item(Sha256Hash, InventoryType)} with hash is
   *       {@link Sha256Hash} and type is {@code TRX} is one.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenHashMapItemWithHashIsSha256HashAndTypeIsTrxIsOne() {
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
    itemResultLongMap.put(new Item(mock(Sha256Hash.class), InventoryType.TRX), 1L);

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
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link PeerConnection#getAdvInvRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
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
   *
   * <ul>
   *   <li>Given {@link PeerConnection} {@link PeerConnection#isIdle()} return {@code false}.
   *   <li>Then calls {@link PeerConnection#isIdle()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
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
   * Test {@link AdvService#getTrxCount()}.
   *
   * <p>Method under test: {@link AdvService#getTrxCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.net.service.statistics.MessageCount AdvService.getTrxCount()"})
  public void testGetTrxCount() {
    // Arrange, Act and Assert
    assertEquals(0L, new AdvService().getTrxCount().getTotalCount());
  }
}
