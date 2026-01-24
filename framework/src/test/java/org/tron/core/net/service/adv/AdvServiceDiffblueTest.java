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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
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

  @Mock private ConcurrentHashMap<Item, Long> concurrentHashMap;

  @Mock private TronNetDelegate tronNetDelegate;

  /**
   * Test {@link AdvService#addInvToCache(Item)}.
   *
   * <ul>
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link BlockId#BlockId()}
   *       and type is {@code TRX}.
   *   <li>Then calls {@link ConcurrentHashMap#remove(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInvToCache(Item)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.addInvToCache(Item)"})
  public void testAddInvToCache_whenItemWithHashIsBlockIdAndTypeIsTrx_thenCallsRemove() {
    // Arrange
    when(concurrentHashMap.remove(Mockito.<Object>any())).thenReturn(1L);

    // Act
    advService.addInvToCache(new Item(new BlockId(), InventoryType.TRX));

    // Assert
    verify(concurrentHashMap).remove(isA(Object.class));
  }

  /**
   * Test {@link AdvService#addInvToCache(Item)}.
   *
   * <ul>
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link Sha256Hash} and
   *       type is {@code TRX}.
   *   <li>Then calls {@link ConcurrentHashMap#remove(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInvToCache(Item)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.addInvToCache(Item)"})
  public void testAddInvToCache_whenItemWithHashIsSha256HashAndTypeIsTrx_thenCallsRemove() {
    // Arrange
    when(concurrentHashMap.remove(Mockito.<Object>any())).thenReturn(1L);

    // Act
    advService.addInvToCache(new Item(mock(Sha256Hash.class), InventoryType.TRX));

    // Assert
    verify(concurrentHashMap).remove(isA(Object.class));
  }

  /**
   * Test {@link AdvService#addInvToCache(Item)}.
   *
   * <ul>
   *   <li>When {@link Sha256Hash#Sha256Hash(long, Sha256Hash)} with num is one and hash is {@link
   *       BlockId#BlockId()}.
   *   <li>Then calls {@link ConcurrentHashMap#remove(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInvToCache(Item)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.addInvToCache(Item)"})
  public void testAddInvToCache_whenSha256HashWithNumIsOneAndHashIsBlockId_thenCallsRemove() {
    // Arrange
    when(concurrentHashMap.remove(Mockito.<Object>any())).thenReturn(1L);
    Sha256Hash hash = new Sha256Hash(1L, new BlockId());

    // Act
    advService.addInvToCache(new Item(hash, InventoryType.TRX));

    // Assert
    verify(concurrentHashMap).remove(isA(Object.class));
  }

  /**
   * Test {@link AdvService#addInv(Item)}.
   *
   * <ul>
   *   <li>Given {@link AdvService} (default constructor).
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link BlockId#BlockId()}
   *       and type is {@code TRX}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_givenAdvService_whenItemWithHashIsBlockIdAndTypeIsTrx_thenReturnTrue() {
    // Arrange
    AdvService advService = new AdvService();

    // Act
    boolean actualAddInvResult = advService.addInv(new Item(new BlockId(), InventoryType.TRX));

    // Assert
    assertTrue(actualAddInvResult);
  }

  /**
   * Test {@link AdvService#addInv(Item)}.
   *
   * <ul>
   *   <li>Given {@link AdvService} (default constructor).
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link Sha256Hash} and
   *       type is {@code TRX}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_givenAdvService_whenItemWithHashIsSha256HashAndTypeIsTrx() {
    // Arrange
    AdvService advService = new AdvService();

    // Act
    boolean actualAddInvResult =
        advService.addInv(new Item(mock(Sha256Hash.class), InventoryType.TRX));

    // Assert
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_givenTrx_whenItemGetTypeReturnTrx_thenCallsGetType() {
    // Arrange
    AdvService advService = new AdvService();

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
   *   <li>Given {@code UNRECOGNIZED}.
   *   <li>When {@link Item} {@link Item#getType()} return {@code UNRECOGNIZED}.
   *   <li>Then calls {@link Item#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#addInv(Item)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdvService.addInv(Item)"})
  public void testAddInv_givenUnrecognized_whenItemGetTypeReturnUnrecognized_thenCallsGetType() {
    // Arrange
    AdvService advService = new AdvService();

    Item item = mock(Item.class);
    when(item.getType()).thenReturn(InventoryType.UNRECOGNIZED);

    // Act
    boolean actualAddInvResult = advService.addInv(item);

    // Assert
    verify(item, atLeast(1)).getType();
    assertTrue(actualAddInvResult);
  }

  /**
   * Test {@link AdvService#getMessage(Item)}.
   *
   * <ul>
   *   <li>Given {@link AdvService} (default constructor).
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link BlockId#BlockId()}
   *       and type is {@code TRX}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#getMessage(Item)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Message AdvService.getMessage(Item)"})
  public void testGetMessage_givenAdvService_whenItemWithHashIsBlockIdAndTypeIsTrx() {
    // Arrange
    AdvService advService = new AdvService();

    // Act
    Message actualMessage = advService.getMessage(new Item(new BlockId(), InventoryType.TRX));

    // Assert
    assertNull(actualMessage);
  }

  /**
   * Test {@link AdvService#getMessage(Item)}.
   *
   * <ul>
   *   <li>Given {@link AdvService} (default constructor).
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link Sha256Hash} and
   *       type is {@code TRX}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#getMessage(Item)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Message AdvService.getMessage(Item)"})
  public void testGetMessage_givenAdvService_whenItemWithHashIsSha256HashAndTypeIsTrx() {
    // Arrange
    AdvService advService = new AdvService();

    // Act
    Message actualMessage =
        advService.getMessage(new Item(mock(Sha256Hash.class), InventoryType.TRX));

    // Assert
    assertNull(actualMessage);
  }

  /**
   * Test {@link AdvService#getMessage(Item)}.
   *
   * <ul>
   *   <li>Given {@link AdvService}.
   *   <li>When {@link Sha256Hash#Sha256Hash(long, Sha256Hash)} with num is one and hash is {@link
   *       BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#getMessage(Item)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Message AdvService.getMessage(Item)"})
  public void testGetMessage_givenAdvService_whenSha256HashWithNumIsOneAndHashIsBlockId() {
    // Arrange
    Sha256Hash hash = new Sha256Hash(1L, new BlockId());

    // Act and Assert
    assertNull(advService.getMessage(new Item(hash, InventoryType.TRX)));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Message AdvService.getMessage(Item)"})
  public void testGetMessage_givenBlock_whenItemGetTypeReturnBlock_thenCallsGetType() {
    // Arrange
    AdvService advService = new AdvService();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Message AdvService.getMessage(Item)"})
  public void testGetMessage_givenTrx_whenItemGetTypeReturnTrx_thenCallsGetType() {
    // Arrange
    AdvService advService = new AdvService();

    Item item = mock(Item.class);
    when(item.getType()).thenReturn(InventoryType.TRX);

    // Act
    Message actualMessage = advService.getMessage(item);

    // Assert
    verify(item).getType();
    assertNull(actualMessage);
  }

  /**
   * Test InvSender {@link InvSender#add(Entry, PeerConnection)} with {@code Entry}, {@code
   * PeerConnection}.
   *
   * <p>Method under test: {@link InvSender#add(Entry, PeerConnection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *   <li>Then calls {@link Item#getHash()}.
   * </ul>
   *
   * <p>Method under test: {@link InvSender#add(Item, PeerConnection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvSender.add(Item, PeerConnection)"})
  public void testInvSenderAddWithItemPeerConnection_thenCallsGetHash() {
    // Arrange
    InvSender invSender = new AdvService().new InvSender();

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
   *   <li>Given {@link InvSender#InvSender(AdvService)} with this$0 is {@link AdvService} (default
   *       constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link InvSender#getSize(PeerConnection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvSender.getSize(PeerConnection)"})
  public void testInvSenderGetSize_givenInvSenderWithThis$0IsAdvService_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new AdvService().new InvSender().getSize(null));
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isIdle()).thenReturn(true);

    PeerConnection peerConnection2 = new PeerConnection();
    peerConnection2.setSyncChainRequested(new Pair<>(new LinkedList<>(), 42L));

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection2);
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    doNothing().when(concurrentHashMap).forEach(Mockito.<BiConsumer<Item, Long>>any());
    when(concurrentHashMap.isEmpty()).thenReturn(false);
    when(concurrentHashMap.size()).thenReturn(3);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(new HashMap<>());

    // Act
    advService.onDisconnect(peer);

    // Assert
    verify(concurrentHashMap).forEach(isA(BiConsumer.class));
    verify(concurrentHashMap).isEmpty();
    verify(concurrentHashMap).size();
    verify(tronNetDelegate).getActivePeer();
    verify(peer).getAdvInvRequest();
    verify(peerConnection).isIdle();
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link AdvService} (default constructor).
   *   <li>Then calls {@link PeerConnection#getAdvInvRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenAdvService_thenCallsGetAdvInvRequest() {
    // Arrange
    AdvService advService = new AdvService();

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
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PeerConnection} (default constructor).
   *   <li>Then calls {@link ConcurrentHashMap#forEach(BiConsumer)}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenArrayListAddPeerConnection_thenCallsForEach() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    doNothing().when(concurrentHashMap).forEach(Mockito.<BiConsumer<Item, Long>>any());
    when(concurrentHashMap.isEmpty()).thenReturn(false);
    when(concurrentHashMap.size()).thenReturn(3);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(new HashMap<>());

    // Act
    advService.onDisconnect(peer);

    // Assert
    verify(concurrentHashMap).forEach(isA(BiConsumer.class));
    verify(concurrentHashMap).isEmpty();
    verify(concurrentHashMap).size();
    verify(tronNetDelegate).getActivePeer();
    verify(peer).getAdvInvRequest();
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentHashMap} {@link ConcurrentHashMap#isEmpty()} return {@code true}.
   *   <li>When {@link PeerConnection} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenConcurrentHashMapIsEmptyReturnTrue_whenPeerConnection() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());
    when(concurrentHashMap.isEmpty()).thenReturn(true);
    when(concurrentHashMap.size()).thenReturn(3);

    // Act
    advService.onDisconnect(new PeerConnection());

    // Assert
    verify(concurrentHashMap).isEmpty();
    verify(concurrentHashMap).size();
    verify(tronNetDelegate).getActivePeer();
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentHashMap} {@link ConcurrentHashMap#isEmpty()} return {@code true}.
   *   <li>When {@link PeerConnection} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenConcurrentHashMapIsEmptyReturnTrue_whenPeerConnection2() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    when(concurrentHashMap.isEmpty()).thenReturn(true);
    when(concurrentHashMap.size()).thenReturn(3);

    // Act
    advService.onDisconnect(new PeerConnection());

    // Assert
    verify(concurrentHashMap).isEmpty();
    verify(concurrentHashMap).size();
    verify(tronNetDelegate).getActivePeer();
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentHashMap} {@link ConcurrentHashMap#isEmpty()} return {@code true}.
   *   <li>When {@link PeerConnection} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenConcurrentHashMapIsEmptyReturnTrue_whenPeerConnection3() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    when(concurrentHashMap.isEmpty()).thenReturn(true);
    when(concurrentHashMap.size()).thenReturn(3);

    // Act
    advService.onDisconnect(new PeerConnection());

    // Assert
    verify(concurrentHashMap).isEmpty();
    verify(concurrentHashMap).size();
    verify(tronNetDelegate).getActivePeer();
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link BlockId#BlockId()} is one.
   *   <li>Then calls {@link ConcurrentHashMap#forEach(BiConsumer)}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenHashMapBlockIdIsOne_thenCallsForEach() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isIdle()).thenReturn(true);

    HashMap<BlockId, Long> syncBlockRequested = new HashMap<>();
    syncBlockRequested.put(new BlockId(), 1L);

    PeerConnection peerConnection2 = new PeerConnection();
    peerConnection2.setSyncBlockRequested(syncBlockRequested);
    peerConnection2.setSyncChainRequested(new Pair<>(new LinkedList<>(), 42L));

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection2);
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    doNothing().when(concurrentHashMap).forEach(Mockito.<BiConsumer<Item, Long>>any());
    when(concurrentHashMap.isEmpty()).thenReturn(false);
    when(concurrentHashMap.size()).thenReturn(3);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(new HashMap<>());

    // Act
    advService.onDisconnect(peer);

    // Assert
    verify(concurrentHashMap).forEach(isA(BiConsumer.class));
    verify(concurrentHashMap).isEmpty();
    verify(concurrentHashMap).size();
    verify(tronNetDelegate).getActivePeer();
    verify(peer).getAdvInvRequest();
    verify(peerConnection).isIdle();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenPeerConnectionIsIdleReturnFalse_thenCallsIsIdle() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isIdle()).thenReturn(false);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    when(concurrentHashMap.isEmpty()).thenReturn(false);
    when(concurrentHashMap.size()).thenReturn(3);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(new HashMap<>());

    // Act
    advService.onDisconnect(peer);

    // Assert
    verify(concurrentHashMap).isEmpty();
    verify(concurrentHashMap).size();
    verify(tronNetDelegate).getActivePeer();
    verify(peer).getAdvInvRequest();
    verify(peerConnection).isIdle();
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link PeerConnection} {@link PeerConnection#isIdle()} return {@code true}.
   *   <li>Then calls {@link ConcurrentHashMap#forEach(BiConsumer)}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenPeerConnectionIsIdleReturnTrue_thenCallsForEach() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isIdle()).thenReturn(true);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);
    doNothing().when(concurrentHashMap).forEach(Mockito.<BiConsumer<Item, Long>>any());
    when(concurrentHashMap.isEmpty()).thenReturn(false);
    when(concurrentHashMap.size()).thenReturn(3);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(new HashMap<>());

    // Act
    advService.onDisconnect(peer);

    // Assert
    verify(concurrentHashMap).forEach(isA(BiConsumer.class));
    verify(concurrentHashMap).isEmpty();
    verify(concurrentHashMap).size();
    verify(tronNetDelegate).getActivePeer();
    verify(peer).getAdvInvRequest();
    verify(peerConnection).isIdle();
  }

  /**
   * Test {@link AdvService#onDisconnect(PeerConnection)}.
   *
   * <ul>
   *   <li>Then calls {@link PeerConnection#getAdvInvRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link AdvService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_thenCallsGetAdvInvRequest() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());
    when(concurrentHashMap.isEmpty()).thenReturn(false);
    when(concurrentHashMap.size()).thenReturn(3);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getAdvInvRequest()).thenReturn(new HashMap<>());

    // Act
    advService.onDisconnect(peer);

    // Assert
    verify(concurrentHashMap).isEmpty();
    verify(concurrentHashMap).size();
    verify(tronNetDelegate).getActivePeer();
    verify(peer).getAdvInvRequest();
  }

  /**
   * Test {@link AdvService#getTrxCount()}.
   *
   * <p>Method under test: {@link AdvService#getTrxCount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.net.service.statistics.MessageCount AdvService.getTrxCount()"})
  public void testGetTrxCount() {
    // Arrange, Act and Assert
    assertEquals(0L, new AdvService().getTrxCount().getTotalCount());
  }
}
