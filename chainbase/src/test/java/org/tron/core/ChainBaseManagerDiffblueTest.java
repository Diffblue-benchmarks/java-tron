package org.tron.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.ChainBaseManager.NodeType;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.db.BlockIndexStore;
import org.tron.core.db.BlockStore;
import org.tron.core.db.KhaosDatabase;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.HeaderNotFound;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.WitnessScheduleStore;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class ChainBaseManagerDiffblueTest {
  @Mock private BlockIndexStore blockIndexStore;

  @Mock private BlockStore blockStore;

  @InjectMocks private ChainBaseManager chainBaseManager;

  @Mock private DynamicPropertiesStore dynamicPropertiesStore;

  @Mock private KhaosDatabase khaosDatabase;

  @Mock private WitnessScheduleStore witnessScheduleStore;

  /**
   * Test {@link ChainBaseManager#getWitnesses()}.
   *
   * <p>Method under test: {@link ChainBaseManager#getWitnesses()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChainBaseManager.getWitnesses()"})
  public void testGetWitnesses() {
    // Arrange
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());

    // Act
    List<ByteString> actualWitnesses = chainBaseManager.getWitnesses();

    // Assert
    verify(witnessScheduleStore).getActiveWitnesses();
    assertTrue(actualWitnesses.isEmpty());
  }

  /**
   * Test {@link ChainBaseManager#getWitnesses()}.
   *
   * <p>Method under test: {@link ChainBaseManager#getWitnesses()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChainBaseManager.getWitnesses()"})
  public void testGetWitnesses2() {
    // Arrange
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());

    // Act
    List<ByteString> actualWitnesses = chainBaseManager.getWitnesses();

    // Assert
    verify(witnessScheduleStore).getActiveWitnesses();
    assertTrue(actualWitnesses.isEmpty());
  }

  /**
   * Test {@link ChainBaseManager#addWitness(ByteString)}.
   *
   * <p>Method under test: {@link ChainBaseManager#addWitness(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChainBaseManager.addWitness(ByteString)"})
  public void testAddWitness() {
    // Arrange
    ArrayList<ByteString> byteStringList = new ArrayList<>();
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(byteStringList);
    doNothing().when(witnessScheduleStore).saveActiveWitnesses(Mockito.<List<ByteString>>any());

    // Act
    chainBaseManager.addWitness(null);

    // Assert
    verify(witnessScheduleStore).getActiveWitnesses();
    verify(witnessScheduleStore).saveActiveWitnesses(isA(List.class));
    List<ByteString> witnesses = chainBaseManager.getWitnesses();
    assertEquals(1, witnesses.size());
    assertNull(witnesses.get(0));
    assertSame(byteStringList, witnesses);
  }

  /**
   * Test {@link ChainBaseManager#addWitness(ByteString)}.
   *
   * <p>Method under test: {@link ChainBaseManager#addWitness(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChainBaseManager.addWitness(ByteString)"})
  public void testAddWitness2() {
    // Arrange
    ArrayList<ByteString> byteStringList = new ArrayList<>();
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(byteStringList);
    doNothing().when(witnessScheduleStore).saveActiveWitnesses(Mockito.<List<ByteString>>any());

    // Act
    chainBaseManager.addWitness(null);

    // Assert
    verify(witnessScheduleStore).getActiveWitnesses();
    verify(witnessScheduleStore).saveActiveWitnesses(isA(List.class));
    List<ByteString> witnesses = chainBaseManager.getWitnesses();
    assertEquals(1, witnesses.size());
    assertNull(witnesses.get(0));
    assertSame(byteStringList, witnesses);
  }

  /**
   * Test {@link ChainBaseManager#getHead()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getHead()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getHead()"})
  public void testGetHead_givenArrayListAddNull_thenReturnNull() throws HeaderNotFound {
    // Arrange
    ArrayList<BlockCapsule> blockCapsuleList = new ArrayList<>();
    blockCapsuleList.add(null);
    when(blockStore.getBlockByLatestNum(anyLong())).thenReturn(blockCapsuleList);

    // Act
    BlockCapsule actualHead = chainBaseManager.getHead();

    // Assert
    verify(blockStore).getBlockByLatestNum(1L);
    assertNull(actualHead);
  }

  /**
   * Test {@link ChainBaseManager#getHead()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getHead()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getHead()"})
  public void testGetHead_givenArrayListAddNull_thenReturnNull2() throws HeaderNotFound {
    // Arrange
    ArrayList<BlockCapsule> blockCapsuleList = new ArrayList<>();
    blockCapsuleList.add(null);
    when(blockStore.getBlockByLatestNum(anyLong())).thenReturn(blockCapsuleList);

    // Act
    BlockCapsule actualHead = chainBaseManager.getHead();

    // Assert
    verify(blockStore).getBlockByLatestNum(1L);
    assertNull(actualHead);
  }

  /**
   * Test {@link ChainBaseManager#getHead()}.
   *
   * <ul>
   *   <li>Then throw {@link HeaderNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getHead()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getHead()"})
  public void testGetHead_thenThrowHeaderNotFound() throws HeaderNotFound {
    // Arrange
    when(blockStore.getBlockByLatestNum(anyLong())).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(HeaderNotFound.class, () -> chainBaseManager.getHead());
    verify(blockStore).getBlockByLatestNum(1L);
  }

  /**
   * Test {@link ChainBaseManager#getHead()}.
   *
   * <ul>
   *   <li>Then throw {@link HeaderNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getHead()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getHead()"})
  public void testGetHead_thenThrowHeaderNotFound2() throws HeaderNotFound {
    // Arrange
    when(blockStore.getBlockByLatestNum(anyLong())).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(HeaderNotFound.class, () -> chainBaseManager.getHead());
    verify(blockStore).getBlockByLatestNum(1L);
  }

  /**
   * Test {@link ChainBaseManager#getHeadBlockId()}.
   *
   * <ul>
   *   <li>Then return {@link Sha256Hash#ZERO_HASH}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getHeadBlockId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockId ChainBaseManager.getHeadBlockId()"})
  public void testGetHeadBlockId_thenReturnZero_hash() {
    // Arrange
    when(dynamicPropertiesStore.getLatestBlockHeaderHash()).thenReturn(Sha256Hash.ZERO_HASH);

    // Act
    BlockId actualHeadBlockId = chainBaseManager.getHeadBlockId();

    // Assert
    verify(dynamicPropertiesStore).getLatestBlockHeaderHash();
    assertEquals(Sha256Hash.ZERO_HASH, actualHeadBlockId);
  }

  /**
   * Test {@link ChainBaseManager#getHeadBlockId()}.
   *
   * <ul>
   *   <li>Then return {@link Sha256Hash#ZERO_HASH}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getHeadBlockId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockId ChainBaseManager.getHeadBlockId()"})
  public void testGetHeadBlockId_thenReturnZero_hash2() {
    // Arrange
    when(dynamicPropertiesStore.getLatestBlockHeaderHash()).thenReturn(Sha256Hash.ZERO_HASH);

    // Act
    BlockId actualHeadBlockId = chainBaseManager.getHeadBlockId();

    // Assert
    verify(dynamicPropertiesStore).getLatestBlockHeaderHash();
    assertEquals(Sha256Hash.ZERO_HASH, actualHeadBlockId);
  }

  /**
   * Test {@link ChainBaseManager#getHeadBlockNum()}.
   *
   * <p>Method under test: {@link ChainBaseManager#getHeadBlockNum()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ChainBaseManager.getHeadBlockNum()"})
  public void testGetHeadBlockNum() {
    // Arrange
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber())
        .thenReturn(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Act
    long actualHeadBlockNum = chainBaseManager.getHeadBlockNum();

    // Assert
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    assertEquals(Constant.TRANSACTION_FEE_POOL_PERIOD, actualHeadBlockNum);
  }

  /**
   * Test {@link ChainBaseManager#getHeadBlockNum()}.
   *
   * <p>Method under test: {@link ChainBaseManager#getHeadBlockNum()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ChainBaseManager.getHeadBlockNum()"})
  public void testGetHeadBlockNum2() {
    // Arrange
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber())
        .thenReturn(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Act
    long actualHeadBlockNum = chainBaseManager.getHeadBlockNum();

    // Assert
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    assertEquals(Constant.TRANSACTION_FEE_POOL_PERIOD, actualHeadBlockNum);
  }

  /**
   * Test {@link ChainBaseManager#getHeadBlockTimeStamp()}.
   *
   * <p>Method under test: {@link ChainBaseManager#getHeadBlockTimeStamp()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ChainBaseManager.getHeadBlockTimeStamp()"})
  public void testGetHeadBlockTimeStamp() {
    // Arrange
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp())
        .thenReturn(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Act
    long actualHeadBlockTimeStamp = chainBaseManager.getHeadBlockTimeStamp();

    // Assert
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    assertEquals(Constant.TRANSACTION_FEE_POOL_PERIOD, actualHeadBlockTimeStamp);
  }

  /**
   * Test {@link ChainBaseManager#getHeadBlockTimeStamp()}.
   *
   * <p>Method under test: {@link ChainBaseManager#getHeadBlockTimeStamp()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ChainBaseManager.getHeadBlockTimeStamp()"})
  public void testGetHeadBlockTimeStamp2() {
    // Arrange
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp())
        .thenReturn(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Act
    long actualHeadBlockTimeStamp = chainBaseManager.getHeadBlockTimeStamp();

    // Assert
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    assertEquals(Constant.TRANSACTION_FEE_POOL_PERIOD, actualHeadBlockTimeStamp);
  }

  /**
   * Test {@link ChainBaseManager#containBlock(Sha256Hash)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then calls {@link Sha256Hash#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.containBlock(Sha256Hash)"})
  public void testContainBlock_givenAxaxaxaxBytesIsUtf8_thenCallsGetBytes()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(false);

    Sha256Hash blockHash = mock(Sha256Hash.class);
    when(blockHash.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(blockHash);

    // Assert
    verify(blockHash).getBytes();
    verify(khaosDatabase).containBlockInMiniStore(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlock(Sha256Hash)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then calls {@link Sha256Hash#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.containBlock(Sha256Hash)"})
  public void testContainBlock_givenAxaxaxaxBytesIsUtf8_thenCallsGetBytes2()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(false);

    Sha256Hash blockHash = mock(Sha256Hash.class);
    when(blockHash.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(blockHash);

    // Assert
    verify(blockHash).getBytes();
    verify(khaosDatabase).containBlockInMiniStore(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlock(Sha256Hash)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.containBlock(Sha256Hash)"})
  public void testContainBlock_thenReturnTrue() {
    // Arrange
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(true);

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(Sha256Hash.ZERO_HASH);

    // Assert
    verify(khaosDatabase).containBlockInMiniStore(isA(Sha256Hash.class));
    assertTrue(actualContainBlockResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlock(Sha256Hash)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.containBlock(Sha256Hash)"})
  public void testContainBlock_thenReturnTrue2() {
    // Arrange
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(true);

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(Sha256Hash.ZERO_HASH);

    // Assert
    verify(khaosDatabase).containBlockInMiniStore(isA(Sha256Hash.class));
    assertTrue(actualContainBlockResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlock(Sha256Hash)}.
   *
   * <ul>
   *   <li>When {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.containBlock(Sha256Hash)"})
  public void testContainBlock_whenZero_hash_thenReturnFalse()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(false);

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(Sha256Hash.ZERO_HASH);

    // Assert
    verify(khaosDatabase).containBlockInMiniStore(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlock(Sha256Hash)}.
   *
   * <ul>
   *   <li>When {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.containBlock(Sha256Hash)"})
  public void testContainBlock_whenZero_hash_thenReturnFalse2()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(false);

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(Sha256Hash.ZERO_HASH);

    // Assert
    verify(khaosDatabase).containBlockInMiniStore(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlockInMainChain(BlockId)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then calls {@link BlockId#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#containBlockInMainChain(BlockId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.containBlockInMainChain(BlockId)"})
  public void testContainBlockInMainChain_givenAxaxaxaxBytesIsUtf8_thenCallsGetBytes()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));

    BlockId blockId = mock(BlockId.class);
    when(blockId.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualContainBlockInMainChainResult = chainBaseManager.containBlockInMainChain(blockId);

    // Assert
    verify(blockId).getBytes();
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockInMainChainResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlockInMainChain(BlockId)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then calls {@link BlockId#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#containBlockInMainChain(BlockId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.containBlockInMainChain(BlockId)"})
  public void testContainBlockInMainChain_givenAxaxaxaxBytesIsUtf8_thenCallsGetBytes2()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));

    BlockId blockId = mock(BlockId.class);
    when(blockId.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualContainBlockInMainChainResult = chainBaseManager.containBlockInMainChain(blockId);

    // Assert
    verify(blockId).getBytes();
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockInMainChainResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlockInMainChain(BlockId)}.
   *
   * <ul>
   *   <li>When {@link BlockId#BlockId()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#containBlockInMainChain(BlockId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.containBlockInMainChain(BlockId)"})
  public void testContainBlockInMainChain_whenBlockId_thenReturnFalse()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));

    // Act
    boolean actualContainBlockInMainChainResult =
        chainBaseManager.containBlockInMainChain(new BlockId());

    // Assert
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockInMainChainResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlockInMainChain(BlockId)}.
   *
   * <ul>
   *   <li>When {@link BlockId#BlockId()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#containBlockInMainChain(BlockId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.containBlockInMainChain(BlockId)"})
  public void testContainBlockInMainChain_whenBlockId_thenReturnFalse2()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));

    // Act
    boolean actualContainBlockInMainChainResult =
        chainBaseManager.containBlockInMainChain(new BlockId());

    // Assert
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockInMainChainResult);
  }

  /**
   * Test {@link ChainBaseManager#getKhaosDbHead()}.
   *
   * <p>Method under test: {@link ChainBaseManager#getKhaosDbHead()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getKhaosDbHead()"})
  public void testGetKhaosDbHead() {
    // Arrange
    when(khaosDatabase.getHead()).thenReturn(null);

    // Act
    BlockCapsule actualKhaosDbHead = chainBaseManager.getKhaosDbHead();

    // Assert
    verify(khaosDatabase).getHead();
    assertNull(actualKhaosDbHead);
  }

  /**
   * Test {@link ChainBaseManager#getKhaosDbHead()}.
   *
   * <p>Method under test: {@link ChainBaseManager#getKhaosDbHead()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getKhaosDbHead()"})
  public void testGetKhaosDbHead2() {
    // Arrange
    when(khaosDatabase.getHead()).thenReturn(null);

    // Act
    BlockCapsule actualKhaosDbHead = chainBaseManager.getKhaosDbHead();

    // Assert
    verify(khaosDatabase).getHead();
    assertNull(actualKhaosDbHead);
  }

  /**
   * Test {@link ChainBaseManager#getBlockById(Sha256Hash)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then calls {@link Sha256Hash#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockById(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockById(Sha256Hash)"})
  public void testGetBlockById_givenAxaxaxaxBytesIsUtf8_thenCallsGetBytes()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(null);

    Sha256Hash hash = mock(Sha256Hash.class);
    when(hash.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> chainBaseManager.getBlockById(hash));
    verify(hash).getBytes();
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
  }

  /**
   * Test {@link ChainBaseManager#getBlockById(Sha256Hash)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then calls {@link Sha256Hash#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockById(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockById(Sha256Hash)"})
  public void testGetBlockById_givenAxaxaxaxBytesIsUtf8_thenCallsGetBytes2()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(null);

    Sha256Hash hash = mock(Sha256Hash.class);
    when(hash.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> chainBaseManager.getBlockById(hash));
    verify(hash).getBytes();
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
  }

  /**
   * Test {@link ChainBaseManager#getBlockById(Sha256Hash)}.
   *
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#getBlock(Sha256Hash)} return {@link
   *       BlockCapsule}.
   *   <li>When {@link Sha256Hash#ZERO_HASH}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockById(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockById(Sha256Hash)"})
  public void testGetBlockById_givenKhaosDatabaseGetBlockReturnBlockCapsule_whenZero_hash()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(mock(BlockCapsule.class));

    // Act
    chainBaseManager.getBlockById(Sha256Hash.ZERO_HASH);

    // Assert
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
  }

  /**
   * Test {@link ChainBaseManager#getBlockById(Sha256Hash)}.
   *
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#getBlock(Sha256Hash)} return {@link
   *       BlockCapsule}.
   *   <li>When {@link Sha256Hash#ZERO_HASH}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockById(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockById(Sha256Hash)"})
  public void testGetBlockById_givenKhaosDatabaseGetBlockReturnBlockCapsule_whenZero_hash2()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(mock(BlockCapsule.class));

    // Act
    chainBaseManager.getBlockById(Sha256Hash.ZERO_HASH);

    // Assert
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
  }

  /**
   * Test {@link ChainBaseManager#getBlockById(Sha256Hash)}.
   *
   * <ul>
   *   <li>When {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then throw {@link ItemNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockById(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockById(Sha256Hash)"})
  public void testGetBlockById_whenZero_hash_thenThrowItemNotFoundException()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class, () -> chainBaseManager.getBlockById(Sha256Hash.ZERO_HASH));
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
  }

  /**
   * Test {@link ChainBaseManager#getBlockById(Sha256Hash)}.
   *
   * <ul>
   *   <li>When {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then throw {@link ItemNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockById(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockById(Sha256Hash)"})
  public void testGetBlockById_whenZero_hash_thenThrowItemNotFoundException2()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class, () -> chainBaseManager.getBlockById(Sha256Hash.ZERO_HASH));
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ChainBaseManager#getChainBaseManager()}
   *   <li>{@link ChainBaseManager#getInstance()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.tron.core.store.AbiStore ChainBaseManager.getAbiStore()",
    "org.tron.core.store.AccountAssetStore ChainBaseManager.getAccountAssetStore()",
    "org.tron.core.store.AccountIdIndexStore ChainBaseManager.getAccountIdIndexStore()",
    "org.tron.core.store.AccountIndexStore ChainBaseManager.getAccountIndexStore()",
    "org.tron.core.store.AccountStore ChainBaseManager.getAccountStore()",
    "org.tron.core.store.AccountTraceStore ChainBaseManager.getAccountTraceStore()",
    "org.tron.core.store.AssetIssueStore ChainBaseManager.getAssetIssueStore()",
    "org.tron.core.store.AssetIssueV2Store ChainBaseManager.getAssetIssueV2Store()",
    "org.tron.core.store.BalanceTraceStore ChainBaseManager.getBalanceTraceStore()",
    "BlockIndexStore ChainBaseManager.getBlockIndexStore()",
    "BlockStore ChainBaseManager.getBlockStore()",
    "ChainBaseManager ChainBaseManager.getChainBaseManager()",
    "org.tron.core.store.CodeStore ChainBaseManager.getCodeStore()",
    "org.tron.core.db.CommonDataBase ChainBaseManager.getCommonDataBase()",
    "org.tron.core.db.CommonStore ChainBaseManager.getCommonStore()",
    "org.tron.core.store.ContractStateStore ChainBaseManager.getContractStateStore()",
    "org.tron.core.store.ContractStore ChainBaseManager.getContractStore()",
    "org.tron.core.store.DelegatedResourceAccountIndexStore ChainBaseManager.getDelegatedResourceAccountIndexStore()",
    "org.tron.core.store.DelegatedResourceStore ChainBaseManager.getDelegatedResourceStore()",
    "org.tron.core.store.DelegationStore ChainBaseManager.getDelegationStore()",
    "DynamicPropertiesStore ChainBaseManager.getDynamicPropertiesStore()",
    "org.tron.core.store.ExchangeStore ChainBaseManager.getExchangeStore()",
    "org.tron.core.store.ExchangeV2Store ChainBaseManager.getExchangeV2Store()",
    "org.tron.common.utils.ForkController ChainBaseManager.getForkController()",
    "BlockCapsule ChainBaseManager.getGenesisBlock()",
    "ChainBaseManager ChainBaseManager.getInstance()",
    "KhaosDatabase ChainBaseManager.getKhaosDb()",
    "long ChainBaseManager.getLatestSaveBlockTime()",
    "long ChainBaseManager.getLowestBlockNum()",
    "org.tron.core.store.MarketAccountStore ChainBaseManager.getMarketAccountStore()",
    "org.tron.core.store.MarketOrderStore ChainBaseManager.getMarketOrderStore()",
    "org.tron.core.store.MarketPairPriceToOrderStore ChainBaseManager.getMarketPairPriceToOrderStore()",
    "org.tron.core.store.MarketPairToPriceStore ChainBaseManager.getMarketPairToPriceStore()",
    "org.tron.common.zksnark.MerkleContainer ChainBaseManager.getMerkleContainer()",
    "org.tron.core.store.TreeBlockIndexStore ChainBaseManager.getMerkleTreeIndexStore()",
    "org.tron.core.store.IncrementalMerkleTreeStore ChainBaseManager.getMerkleTreeStore()",
    "org.tron.core.service.MortgageService ChainBaseManager.getMortgageService()",
    "NodeType ChainBaseManager.getNodeType()",
    "org.tron.core.store.NullifierStore ChainBaseManager.getNullifierStore()",
    "org.tron.core.db.PbftSignDataStore ChainBaseManager.getPbftSignDataStore()",
    "org.tron.core.store.ZKProofStore ChainBaseManager.getProofStore()",
    "org.tron.core.store.ProposalStore ChainBaseManager.getProposalStore()",
    "org.tron.core.db.RecentBlockStore ChainBaseManager.getRecentBlockStore()",
    "org.tron.core.db.RecentTransactionStore ChainBaseManager.getRecentTransactionStore()",
    "org.tron.core.store.SectionBloomStore ChainBaseManager.getSectionBloomStore()",
    "org.tron.core.store.StorageRowStore ChainBaseManager.getStorageRowStore()",
    "org.tron.core.store.TransactionHistoryStore ChainBaseManager.getTransactionHistoryStore()",
    "org.tron.core.store.TransactionRetStore ChainBaseManager.getTransactionRetStore()",
    "org.tron.core.db.TransactionStore ChainBaseManager.getTransactionStore()",
    "org.tron.core.store.VotesStore ChainBaseManager.getVotesStore()",
    "WitnessScheduleStore ChainBaseManager.getWitnessScheduleStore()",
    "org.tron.core.store.WitnessStore ChainBaseManager.getWitnessStore()",
    "void ChainBaseManager.setGenesisBlock(BlockCapsule)",
    "void ChainBaseManager.setLatestSaveBlockTime(long)",
    "void ChainBaseManager.setLowestBlockNum(long)",
    "void ChainBaseManager.setMerkleContainer(org.tron.common.zksnark.MerkleContainer)",
    "void ChainBaseManager.setMerkleTreeIndexStore(org.tron.core.store.TreeBlockIndexStore)",
    "void ChainBaseManager.setMortgageService(org.tron.core.service.MortgageService)",
    "void ChainBaseManager.setNodeType(NodeType)"
  })
  public void testGettersAndSetters2() {
    // Arrange and Act
    ChainBaseManager actualChainBaseManager = ChainBaseManager.getChainBaseManager();
    ChainBaseManager actualChainBaseManager2 = actualChainBaseManager.getChainBaseManager();

    // Assert
    assertNull(actualChainBaseManager2);
    assertNull(actualChainBaseManager.getInstance());
  }

  /**
   * Test {@link ChainBaseManager#hasBlocks()}.
   *
   * <ul>
   *   <li>Given {@link BlockStore} {@link BlockStore#isNotEmpty()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#hasBlocks()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.hasBlocks()"})
  public void testHasBlocks_givenBlockStoreIsNotEmptyReturnTrue_thenReturnTrue() {
    // Arrange
    when(blockStore.isNotEmpty()).thenReturn(true);

    // Act
    boolean actualHasBlocksResult = chainBaseManager.hasBlocks();

    // Assert
    verify(blockStore).isNotEmpty();
    assertTrue(actualHasBlocksResult);
  }

  /**
   * Test {@link ChainBaseManager#hasBlocks()}.
   *
   * <ul>
   *   <li>Given {@link BlockStore} {@link BlockStore#isNotEmpty()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#hasBlocks()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.hasBlocks()"})
  public void testHasBlocks_givenBlockStoreIsNotEmptyReturnTrue_thenReturnTrue2() {
    // Arrange
    when(blockStore.isNotEmpty()).thenReturn(true);

    // Act
    boolean actualHasBlocksResult = chainBaseManager.hasBlocks();

    // Assert
    verify(blockStore).isNotEmpty();
    assertTrue(actualHasBlocksResult);
  }

  /**
   * Test {@link ChainBaseManager#hasBlocks()}.
   *
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#hasData()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#hasBlocks()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.hasBlocks()"})
  public void testHasBlocks_givenKhaosDatabaseHasDataReturnFalse_thenReturnFalse() {
    // Arrange
    when(blockStore.isNotEmpty()).thenReturn(false);
    when(khaosDatabase.hasData()).thenReturn(false);

    // Act
    boolean actualHasBlocksResult = chainBaseManager.hasBlocks();

    // Assert
    verify(khaosDatabase).hasData();
    verify(blockStore).isNotEmpty();
    assertFalse(actualHasBlocksResult);
  }

  /**
   * Test {@link ChainBaseManager#hasBlocks()}.
   *
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#hasData()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#hasBlocks()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.hasBlocks()"})
  public void testHasBlocks_givenKhaosDatabaseHasDataReturnFalse_thenReturnFalse2() {
    // Arrange
    when(blockStore.isNotEmpty()).thenReturn(false);
    when(khaosDatabase.hasData()).thenReturn(false);

    // Act
    boolean actualHasBlocksResult = chainBaseManager.hasBlocks();

    // Assert
    verify(khaosDatabase).hasData();
    verify(blockStore).isNotEmpty();
    assertFalse(actualHasBlocksResult);
  }

  /**
   * Test {@link ChainBaseManager#hasBlocks()}.
   *
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#hasData()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#hasBlocks()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.hasBlocks()"})
  public void testHasBlocks_givenKhaosDatabaseHasDataReturnTrue_thenReturnTrue() {
    // Arrange
    when(blockStore.isNotEmpty()).thenReturn(false);
    when(khaosDatabase.hasData()).thenReturn(true);

    // Act
    boolean actualHasBlocksResult = chainBaseManager.hasBlocks();

    // Assert
    verify(khaosDatabase).hasData();
    verify(blockStore).isNotEmpty();
    assertTrue(actualHasBlocksResult);
  }

  /**
   * Test {@link ChainBaseManager#hasBlocks()}.
   *
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#hasData()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#hasBlocks()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.hasBlocks()"})
  public void testHasBlocks_givenKhaosDatabaseHasDataReturnTrue_thenReturnTrue2() {
    // Arrange
    when(blockStore.isNotEmpty()).thenReturn(false);
    when(khaosDatabase.hasData()).thenReturn(true);

    // Act
    boolean actualHasBlocksResult = chainBaseManager.hasBlocks();

    // Assert
    verify(khaosDatabase).hasData();
    verify(blockStore).isNotEmpty();
    assertTrue(actualHasBlocksResult);
  }

  /**
   * Test {@link ChainBaseManager#getSolidBlockId()}.
   *
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link
   *       BlockId#BlockId()}.
   *   <li>Then calls {@link BlockCapsule#getBlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getSolidBlockId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockId ChainBaseManager.getSolidBlockId()"})
  public void testGetSolidBlockId_givenBlockCapsuleGetBlockIdReturnBlockId_thenCallsGetBlockId() {
    // Arrange
    BlockCapsule genesisBlock = mock(BlockCapsule.class);
    BlockId blockId = new BlockId();
    when(genesisBlock.getBlockId()).thenReturn(blockId);

    ChainBaseManager chainBaseManager = new ChainBaseManager();
    chainBaseManager.setGenesisBlock(genesisBlock);

    // Act
    BlockId actualSolidBlockId = chainBaseManager.getSolidBlockId();

    // Assert
    verify(genesisBlock).getBlockId();
    assertSame(blockId, actualSolidBlockId);
  }

  /**
   * Test {@link ChainBaseManager#getSolidBlockId()}.
   *
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link
   *       BlockId#BlockId()}.
   *   <li>Then calls {@link BlockCapsule#getBlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getSolidBlockId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockId ChainBaseManager.getSolidBlockId()"})
  public void testGetSolidBlockId_givenBlockCapsuleGetBlockIdReturnBlockId_thenCallsGetBlockId2() {
    // Arrange
    BlockCapsule genesisBlock = mock(BlockCapsule.class);
    BlockId blockId = new BlockId();
    when(genesisBlock.getBlockId()).thenReturn(blockId);

    ChainBaseManager chainBaseManager = new ChainBaseManager();
    chainBaseManager.setGenesisBlock(genesisBlock);

    // Act
    BlockId actualSolidBlockId = chainBaseManager.getSolidBlockId();

    // Assert
    verify(genesisBlock).getBlockId();
    assertSame(blockId, actualSolidBlockId);
  }

  /**
   * Test {@link ChainBaseManager#getSolidBlockId()}.
   *
   * <ul>
   *   <li>Given {@link BlockIndexStore} {@link BlockIndexStore#get(Long)} return {@link
   *       BlockId#BlockId()}.
   *   <li>Then calls {@link BlockIndexStore#get(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getSolidBlockId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockId ChainBaseManager.getSolidBlockId()"})
  public void testGetSolidBlockId_givenBlockIndexStoreGetReturnBlockId_thenCallsGet()
      throws ItemNotFoundException {
    // Arrange
    BlockId blockId = new BlockId();
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(blockId);
    when(dynamicPropertiesStore.getLatestSolidifiedBlockNum())
        .thenReturn(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Act
    BlockId actualSolidBlockId = chainBaseManager.getSolidBlockId();

    // Assert
    verify(blockIndexStore).get(1L);
    verify(dynamicPropertiesStore).getLatestSolidifiedBlockNum();
    assertSame(blockId, actualSolidBlockId);
  }

  /**
   * Test {@link ChainBaseManager#getSolidBlockId()}.
   *
   * <ul>
   *   <li>Given {@link BlockIndexStore} {@link BlockIndexStore#get(Long)} return {@link
   *       BlockId#BlockId()}.
   *   <li>Then calls {@link BlockIndexStore#get(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getSolidBlockId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockId ChainBaseManager.getSolidBlockId()"})
  public void testGetSolidBlockId_givenBlockIndexStoreGetReturnBlockId_thenCallsGet2()
      throws ItemNotFoundException {
    // Arrange
    BlockId blockId = new BlockId();
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(blockId);
    when(dynamicPropertiesStore.getLatestSolidifiedBlockNum())
        .thenReturn(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Act
    BlockId actualSolidBlockId = chainBaseManager.getSolidBlockId();

    // Assert
    verify(blockIndexStore).get(1L);
    verify(dynamicPropertiesStore).getLatestSolidifiedBlockNum();
    assertSame(blockId, actualSolidBlockId);
  }

  /**
   * Test {@link ChainBaseManager#getGenesisBlockId()}.
   *
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link
   *       BlockId#BlockId()}.
   *   <li>Then return {@link BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getGenesisBlockId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockId ChainBaseManager.getGenesisBlockId()"})
  public void testGetGenesisBlockId_givenBlockCapsuleGetBlockIdReturnBlockId_thenReturnBlockId() {
    // Arrange
    BlockCapsule genesisBlock = mock(BlockCapsule.class);
    BlockId blockId = new BlockId();
    when(genesisBlock.getBlockId()).thenReturn(blockId);

    ChainBaseManager chainBaseManager = new ChainBaseManager();
    chainBaseManager.setGenesisBlock(genesisBlock);

    // Act
    BlockId actualGenesisBlockId = chainBaseManager.getGenesisBlockId();

    // Assert
    verify(genesisBlock).getBlockId();
    assertSame(blockId, actualGenesisBlockId);
  }

  /**
   * Test {@link ChainBaseManager#getGenesisBlockId()}.
   *
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link
   *       BlockId#BlockId()}.
   *   <li>Then return {@link BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getGenesisBlockId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockId ChainBaseManager.getGenesisBlockId()"})
  public void testGetGenesisBlockId_givenBlockCapsuleGetBlockIdReturnBlockId_thenReturnBlockId2() {
    // Arrange
    BlockCapsule genesisBlock = mock(BlockCapsule.class);
    BlockId blockId = new BlockId();
    when(genesisBlock.getBlockId()).thenReturn(blockId);

    ChainBaseManager chainBaseManager = new ChainBaseManager();
    chainBaseManager.setGenesisBlock(genesisBlock);

    // Act
    BlockId actualGenesisBlockId = chainBaseManager.getGenesisBlockId();

    // Assert
    verify(genesisBlock).getBlockId();
    assertSame(blockId, actualGenesisBlockId);
  }

  /**
   * Test {@link ChainBaseManager#getBlockIdByNum(long)}.
   *
   * <ul>
   *   <li>Given {@link BlockIndexStore} {@link BlockIndexStore#get(Long)} return {@link
   *       BlockId#BlockId()}.
   *   <li>Then return {@link BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockIdByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockId ChainBaseManager.getBlockIdByNum(long)"})
  public void testGetBlockIdByNum_givenBlockIndexStoreGetReturnBlockId_thenReturnBlockId()
      throws ItemNotFoundException {
    // Arrange
    BlockId blockId = new BlockId();
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(blockId);

    // Act
    BlockId actualBlockIdByNum =
        chainBaseManager.getBlockIdByNum(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Assert
    verify(blockIndexStore).get(1L);
    assertSame(blockId, actualBlockIdByNum);
  }

  /**
   * Test {@link ChainBaseManager#getBlockIdByNum(long)}.
   *
   * <ul>
   *   <li>Given {@link BlockIndexStore} {@link BlockIndexStore#get(Long)} return {@link
   *       BlockId#BlockId()}.
   *   <li>Then return {@link BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockIdByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockId ChainBaseManager.getBlockIdByNum(long)"})
  public void testGetBlockIdByNum_givenBlockIndexStoreGetReturnBlockId_thenReturnBlockId2()
      throws ItemNotFoundException {
    // Arrange
    BlockId blockId = new BlockId();
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(blockId);

    // Act
    BlockId actualBlockIdByNum =
        chainBaseManager.getBlockIdByNum(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Assert
    verify(blockIndexStore).get(1L);
    assertSame(blockId, actualBlockIdByNum);
  }

  /**
   * Test {@link ChainBaseManager#getBlockIdByNum(long)}.
   *
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockIdByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockId ChainBaseManager.getBlockIdByNum(long)"})
  public void testGetBlockIdByNum_thenThrowItemNotFoundException() throws ItemNotFoundException {
    // Arrange
    when(blockIndexStore.get(Mockito.<Long>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class,
        () -> chainBaseManager.getBlockIdByNum(Constant.TRANSACTION_FEE_POOL_PERIOD));
    verify(blockIndexStore).get(1L);
  }

  /**
   * Test {@link ChainBaseManager#getBlockIdByNum(long)}.
   *
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockIdByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockId ChainBaseManager.getBlockIdByNum(long)"})
  public void testGetBlockIdByNum_thenThrowItemNotFoundException2() throws ItemNotFoundException {
    // Arrange
    when(blockIndexStore.get(Mockito.<Long>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class,
        () -> chainBaseManager.getBlockIdByNum(Constant.TRANSACTION_FEE_POOL_PERIOD));
    verify(blockIndexStore).get(1L);
  }

  /**
   * Test {@link ChainBaseManager#getBlockByNum(long)}.
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockByNum(long)"})
  public void testGetBlockByNum() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockIndexStore.get(Mockito.<Long>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class,
        () -> chainBaseManager.getBlockByNum(Constant.TRANSACTION_FEE_POOL_PERIOD));
    verify(blockIndexStore).get(1L);
  }

  /**
   * Test {@link ChainBaseManager#getBlockByNum(long)}.
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockByNum(long)"})
  public void testGetBlockByNum2() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockIndexStore.get(Mockito.<Long>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class,
        () -> chainBaseManager.getBlockByNum(Constant.TRANSACTION_FEE_POOL_PERIOD));
    verify(blockIndexStore).get(1L);
  }

  /**
   * Test {@link ChainBaseManager#getBlockByNum(long)}.
   *
   * <ul>
   *   <li>Given {@link BlockIndexStore} {@link BlockIndexStore#get(Long)} return {@link
   *       BlockId#BlockId()}.
   *   <li>Then calls {@link BlockStore#get(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockByNum(long)"})
  public void testGetBlockByNum_givenBlockIndexStoreGetReturnBlockId_thenCallsGet()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(new BlockId());
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class,
        () -> chainBaseManager.getBlockByNum(Constant.TRANSACTION_FEE_POOL_PERIOD));
    verify(blockIndexStore).get(1L);
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
  }

  /**
   * Test {@link ChainBaseManager#getBlockByNum(long)}.
   *
   * <ul>
   *   <li>Given {@link BlockIndexStore} {@link BlockIndexStore#get(Long)} return {@link
   *       BlockId#BlockId()}.
   *   <li>Then calls {@link BlockStore#get(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockByNum(long)"})
  public void testGetBlockByNum_givenBlockIndexStoreGetReturnBlockId_thenCallsGet2()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(new BlockId());
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class,
        () -> chainBaseManager.getBlockByNum(Constant.TRANSACTION_FEE_POOL_PERIOD));
    verify(blockIndexStore).get(1L);
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
  }

  /**
   * Test {@link ChainBaseManager#getBlockByNum(long)}.
   *
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#getBlock(Sha256Hash)} return {@link
   *       BlockCapsule}.
   *   <li>Then calls {@link KhaosDatabase#getBlock(Sha256Hash)}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockByNum(long)"})
  public void testGetBlockByNum_givenKhaosDatabaseGetBlockReturnBlockCapsule_thenCallsGetBlock()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(new BlockId());
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(mock(BlockCapsule.class));

    // Act
    chainBaseManager.getBlockByNum(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Assert
    verify(blockIndexStore).get(1L);
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
  }

  /**
   * Test {@link ChainBaseManager#getBlockByNum(long)}.
   *
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#getBlock(Sha256Hash)} return {@link
   *       BlockCapsule}.
   *   <li>Then calls {@link KhaosDatabase#getBlock(Sha256Hash)}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockByNum(long)"})
  public void testGetBlockByNum_givenKhaosDatabaseGetBlockReturnBlockCapsule_thenCallsGetBlock2()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(new BlockId());
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(mock(BlockCapsule.class));

    // Act
    chainBaseManager.getBlockByNum(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Assert
    verify(blockIndexStore).get(1L);
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
  }

  /**
   * Test {@link ChainBaseManager#getBlockByNum(long)}.
   *
   * <ul>
   *   <li>Then calls {@link BlockId#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockByNum(long)"})
  public void testGetBlockByNum_thenCallsGetBytes()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(blockId);
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class,
        () -> chainBaseManager.getBlockByNum(Constant.TRANSACTION_FEE_POOL_PERIOD));
    verify(blockId).getBytes();
    verify(blockIndexStore).get(1L);
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
  }

  /**
   * Test {@link ChainBaseManager#getBlockByNum(long)}.
   *
   * <ul>
   *   <li>Then calls {@link BlockId#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#getBlockByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockByNum(long)"})
  public void testGetBlockByNum_thenCallsGetBytes2()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(blockId);
    when(blockStore.get(Mockito.<byte[]>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class,
        () -> chainBaseManager.getBlockByNum(Constant.TRANSACTION_FEE_POOL_PERIOD));
    verify(blockId).getBytes();
    verify(blockIndexStore).get(1L);
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
  }

  /**
   * Test {@link ChainBaseManager#isLiteNode()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} NodeType is {@link NodeType#LITE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#isLiteNode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.isLiteNode()"})
  public void testIsLiteNode_givenChainBaseManagerNodeTypeIsLite_thenReturnTrue() {
    // Arrange
    chainBaseManager.setNodeType(NodeType.LITE);

    // Act and Assert
    assertTrue(chainBaseManager.isLiteNode());
  }

  /**
   * Test {@link ChainBaseManager#isLiteNode()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} NodeType is {@link NodeType#LITE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#isLiteNode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.isLiteNode()"})
  public void testIsLiteNode_givenChainBaseManagerNodeTypeIsLite_thenReturnTrue2() {
    // Arrange
    chainBaseManager.setNodeType(NodeType.LITE);

    // Act and Assert
    assertTrue(chainBaseManager.isLiteNode());
  }

  /**
   * Test {@link ChainBaseManager#isLiteNode()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#isLiteNode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.isLiteNode()"})
  public void testIsLiteNode_givenChainBaseManager_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(chainBaseManager.isLiteNode());
  }

  /**
   * Test {@link ChainBaseManager#isLiteNode()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChainBaseManager#isLiteNode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChainBaseManager.isLiteNode()"})
  public void testIsLiteNode_givenChainBaseManager_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(chainBaseManager.isLiteNode());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ChainBaseManager#getChainBaseManager()}
   *   <li>{@link ChainBaseManager#getInstance()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.tron.core.store.AbiStore ChainBaseManager.getAbiStore()",
    "org.tron.core.store.AccountAssetStore ChainBaseManager.getAccountAssetStore()",
    "org.tron.core.store.AccountIdIndexStore ChainBaseManager.getAccountIdIndexStore()",
    "org.tron.core.store.AccountIndexStore ChainBaseManager.getAccountIndexStore()",
    "org.tron.core.store.AccountStore ChainBaseManager.getAccountStore()",
    "org.tron.core.store.AccountTraceStore ChainBaseManager.getAccountTraceStore()",
    "org.tron.core.store.AssetIssueStore ChainBaseManager.getAssetIssueStore()",
    "org.tron.core.store.AssetIssueV2Store ChainBaseManager.getAssetIssueV2Store()",
    "org.tron.core.store.BalanceTraceStore ChainBaseManager.getBalanceTraceStore()",
    "BlockIndexStore ChainBaseManager.getBlockIndexStore()",
    "BlockStore ChainBaseManager.getBlockStore()",
    "ChainBaseManager ChainBaseManager.getChainBaseManager()",
    "org.tron.core.store.CodeStore ChainBaseManager.getCodeStore()",
    "org.tron.core.db.CommonDataBase ChainBaseManager.getCommonDataBase()",
    "org.tron.core.db.CommonStore ChainBaseManager.getCommonStore()",
    "org.tron.core.store.ContractStateStore ChainBaseManager.getContractStateStore()",
    "org.tron.core.store.ContractStore ChainBaseManager.getContractStore()",
    "org.tron.core.store.DelegatedResourceAccountIndexStore ChainBaseManager.getDelegatedResourceAccountIndexStore()",
    "org.tron.core.store.DelegatedResourceStore ChainBaseManager.getDelegatedResourceStore()",
    "org.tron.core.store.DelegationStore ChainBaseManager.getDelegationStore()",
    "DynamicPropertiesStore ChainBaseManager.getDynamicPropertiesStore()",
    "org.tron.core.store.ExchangeStore ChainBaseManager.getExchangeStore()",
    "org.tron.core.store.ExchangeV2Store ChainBaseManager.getExchangeV2Store()",
    "org.tron.common.utils.ForkController ChainBaseManager.getForkController()",
    "BlockCapsule ChainBaseManager.getGenesisBlock()",
    "ChainBaseManager ChainBaseManager.getInstance()",
    "KhaosDatabase ChainBaseManager.getKhaosDb()",
    "long ChainBaseManager.getLatestSaveBlockTime()",
    "long ChainBaseManager.getLowestBlockNum()",
    "org.tron.core.store.MarketAccountStore ChainBaseManager.getMarketAccountStore()",
    "org.tron.core.store.MarketOrderStore ChainBaseManager.getMarketOrderStore()",
    "org.tron.core.store.MarketPairPriceToOrderStore ChainBaseManager.getMarketPairPriceToOrderStore()",
    "org.tron.core.store.MarketPairToPriceStore ChainBaseManager.getMarketPairToPriceStore()",
    "org.tron.common.zksnark.MerkleContainer ChainBaseManager.getMerkleContainer()",
    "org.tron.core.store.TreeBlockIndexStore ChainBaseManager.getMerkleTreeIndexStore()",
    "org.tron.core.store.IncrementalMerkleTreeStore ChainBaseManager.getMerkleTreeStore()",
    "org.tron.core.service.MortgageService ChainBaseManager.getMortgageService()",
    "NodeType ChainBaseManager.getNodeType()",
    "org.tron.core.store.NullifierStore ChainBaseManager.getNullifierStore()",
    "org.tron.core.db.PbftSignDataStore ChainBaseManager.getPbftSignDataStore()",
    "org.tron.core.store.ZKProofStore ChainBaseManager.getProofStore()",
    "org.tron.core.store.ProposalStore ChainBaseManager.getProposalStore()",
    "org.tron.core.db.RecentBlockStore ChainBaseManager.getRecentBlockStore()",
    "org.tron.core.db.RecentTransactionStore ChainBaseManager.getRecentTransactionStore()",
    "org.tron.core.store.SectionBloomStore ChainBaseManager.getSectionBloomStore()",
    "org.tron.core.store.StorageRowStore ChainBaseManager.getStorageRowStore()",
    "org.tron.core.store.TransactionHistoryStore ChainBaseManager.getTransactionHistoryStore()",
    "org.tron.core.store.TransactionRetStore ChainBaseManager.getTransactionRetStore()",
    "org.tron.core.db.TransactionStore ChainBaseManager.getTransactionStore()",
    "org.tron.core.store.VotesStore ChainBaseManager.getVotesStore()",
    "WitnessScheduleStore ChainBaseManager.getWitnessScheduleStore()",
    "org.tron.core.store.WitnessStore ChainBaseManager.getWitnessStore()",
    "void ChainBaseManager.setGenesisBlock(BlockCapsule)",
    "void ChainBaseManager.setLatestSaveBlockTime(long)",
    "void ChainBaseManager.setLowestBlockNum(long)",
    "void ChainBaseManager.setMerkleContainer(org.tron.common.zksnark.MerkleContainer)",
    "void ChainBaseManager.setMerkleTreeIndexStore(org.tron.core.store.TreeBlockIndexStore)",
    "void ChainBaseManager.setMortgageService(org.tron.core.service.MortgageService)",
    "void ChainBaseManager.setNodeType(NodeType)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ChainBaseManager actualChainBaseManager = ChainBaseManager.getChainBaseManager();
    ChainBaseManager actualChainBaseManager2 = actualChainBaseManager.getChainBaseManager();

    // Assert
    assertNull(actualChainBaseManager2);
    assertNull(actualChainBaseManager.getInstance());
  }
}
