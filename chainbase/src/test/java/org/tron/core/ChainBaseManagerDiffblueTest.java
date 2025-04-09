package org.tron.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.springframework.test.util.ReflectionTestUtils;
import org.tron.common.storage.metric.DbStatService;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.ChainBaseManager.NodeType;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.db.BlockIndexStore;
import org.tron.core.db.BlockStore;
import org.tron.core.db.CommonDataBase;
import org.tron.core.db.CommonStore;
import org.tron.core.db.KhaosDatabase;
import org.tron.core.db.PbftSignDataStore;
import org.tron.core.db.RecentBlockStore;
import org.tron.core.db.RecentTransactionStore;
import org.tron.core.db.TransactionStore;
import org.tron.core.db.TronStoreWithRevoking;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.HeaderNotFound;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.AbiStore;
import org.tron.core.store.AccountAssetStore;
import org.tron.core.store.AccountIdIndexStore;
import org.tron.core.store.AccountIndexStore;
import org.tron.core.store.AccountStore;
import org.tron.core.store.AccountTraceStore;
import org.tron.core.store.AssetIssueStore;
import org.tron.core.store.AssetIssueV2Store;
import org.tron.core.store.BalanceTraceStore;
import org.tron.core.store.CodeStore;
import org.tron.core.store.ContractStateStore;
import org.tron.core.store.ContractStore;
import org.tron.core.store.DelegatedResourceAccountIndexStore;
import org.tron.core.store.DelegatedResourceStore;
import org.tron.core.store.DelegationStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.ExchangeStore;
import org.tron.core.store.ExchangeV2Store;
import org.tron.core.store.IncrementalMerkleTreeStore;
import org.tron.core.store.MarketAccountStore;
import org.tron.core.store.MarketOrderStore;
import org.tron.core.store.MarketPairPriceToOrderStore;
import org.tron.core.store.MarketPairToPriceStore;
import org.tron.core.store.NullifierStore;
import org.tron.core.store.ProposalStore;
import org.tron.core.store.SectionBloomStore;
import org.tron.core.store.StorageRowStore;
import org.tron.core.store.TransactionHistoryStore;
import org.tron.core.store.TransactionRetStore;
import org.tron.core.store.TreeBlockIndexStore;
import org.tron.core.store.VotesStore;
import org.tron.core.store.WitnessScheduleStore;
import org.tron.core.store.WitnessStore;
import org.tron.core.store.ZKProofStore;

@RunWith(MockitoJUnitRunner.class)
public class ChainBaseManagerDiffblueTest {
  @InjectMocks
  private ChainBaseManager chainBaseManager;

  @Mock
  private WitnessScheduleStore witnessScheduleStore;

  @Mock
  private KhaosDatabase khaosDatabase;

  @Mock
  private BlockStore blockStore;

  @Mock
  private BlockIndexStore blockIndexStore;

  @Mock
  private DynamicPropertiesStore dynamicPropertiesStore;

  @Mock
  private DbStatService dbStatService;

  /**
   * Test {@link ChainBaseManager#getWitnesses()}.
   * <p>
   * Method under test: {@link ChainBaseManager#getWitnesses()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link ChainBaseManager#addWitness(ByteString)}.
   * <p>
   * Method under test: {@link ChainBaseManager#addWitness(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link ChainBaseManager#getHead()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#getHead()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getHead()"})
  public void testGetHead_givenArrayListAddNull_thenReturnNull() throws HeaderNotFound {
    // Arrange
    ArrayList<BlockCapsule> blockCapsuleList = new ArrayList<>();
    blockCapsuleList.add(null);
    when(blockStore.getBlockByLatestNum(anyLong())).thenReturn(blockCapsuleList);

    // Act
    BlockCapsule actualHead = chainBaseManager.getHead();

    // Assert
    verify(blockStore).getBlockByLatestNum(eq(1L));
    assertNull(actualHead);
  }

  /**
   * Test {@link ChainBaseManager#getHead()}.
   * <ul>
   *   <li>Then throw {@link HeaderNotFound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#getHead()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getHead()"})
  public void testGetHead_thenThrowHeaderNotFound() throws HeaderNotFound {
    // Arrange
    when(blockStore.getBlockByLatestNum(anyLong())).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(HeaderNotFound.class, () -> chainBaseManager.getHead());
    verify(blockStore).getBlockByLatestNum(eq(1L));
  }

  /**
   * Test {@link ChainBaseManager#getHeadBlockId()}.
   * <ul>
   *   <li>Then return {@link BlockId#BlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#getHeadBlockId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockId ChainBaseManager.getHeadBlockId()"})
  public void testGetHeadBlockId_thenReturnBlockId() {
    // Arrange
    BlockId blockId = new BlockId();
    when(dynamicPropertiesStore.getLatestBlockHeaderHash()).thenReturn(blockId);

    // Act
    BlockId actualHeadBlockId = chainBaseManager.getHeadBlockId();

    // Assert
    verify(dynamicPropertiesStore).getLatestBlockHeaderHash();
    assertEquals(blockId, actualHeadBlockId);
  }

  /**
   * Test {@link ChainBaseManager#getHeadBlockNum()}.
   * <p>
   * Method under test: {@link ChainBaseManager#getHeadBlockNum()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ChainBaseManager.getHeadBlockNum()"})
  public void testGetHeadBlockNum() {
    // Arrange
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Act
    long actualHeadBlockNum = chainBaseManager.getHeadBlockNum();

    // Assert
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    assertEquals(Constant.TRANSACTION_FEE_POOL_PERIOD, actualHeadBlockNum);
  }

  /**
   * Test {@link ChainBaseManager#getHeadBlockTimeStamp()}.
   * <p>
   * Method under test: {@link ChainBaseManager#getHeadBlockTimeStamp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ChainBaseManager.getHeadBlockTimeStamp()"})
  public void testGetHeadBlockTimeStamp() {
    // Arrange
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Act
    long actualHeadBlockTimeStamp = chainBaseManager.getHeadBlockTimeStamp();

    // Assert
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    assertEquals(Constant.TRANSACTION_FEE_POOL_PERIOD, actualHeadBlockTimeStamp);
  }

  /**
   * Test {@link ChainBaseManager#getHeadSlot()}.
   * <ul>
   *   <li>Then return {@link Constant#PB_DEFAULT_ENERGY_LIMIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#getHeadSlot()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ChainBaseManager.getHeadSlot()"})
  public void testGetHeadSlot_thenReturnPb_default_energy_limit() {
    // Arrange
    BlockCapsule genesisBlock = mock(BlockCapsule.class);
    when(genesisBlock.getTimeStamp()).thenReturn(10L);

    ChainBaseManager chainBaseManager = new ChainBaseManager();
    chainBaseManager.setGenesisBlock(genesisBlock);
    ReflectionTestUtils.setField(chainBaseManager, "witnessStore", mock(WitnessStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "witnessScheduleStore", mock(WitnessScheduleStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "votesStore", mock(VotesStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "transactionStore", mock(TransactionStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "transactionRetStore", mock(TransactionRetStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "transactionHistoryStore", mock(TransactionHistoryStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "storageRowStore", mock(StorageRowStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "sectionBloomStore", mock(SectionBloomStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "recentTransactionStore", mock(RecentTransactionStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "recentBlockStore", mock(RecentBlockStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "proposalStore", mock(ProposalStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "proofStore", mock(ZKProofStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "pbftSignDataStore", mock(PbftSignDataStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "nullifierStore", mock(NullifierStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "merkleTreeStore", mock(IncrementalMerkleTreeStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "merkleTreeIndexStore", mock(TreeBlockIndexStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "marketPairToPriceStore", mock(MarketPairToPriceStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "marketPairPriceToOrderStore",
        mock(MarketPairPriceToOrderStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "marketOrderStore", mock(MarketOrderStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "marketAccountStore", mock(MarketAccountStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "khaosDb", mock(KhaosDatabase.class));
    ReflectionTestUtils.setField(chainBaseManager, "exchangeV2Store", mock(ExchangeV2Store.class));
    ReflectionTestUtils.setField(chainBaseManager, "exchangeStore", mock(ExchangeStore.class));
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(Constant.TRANSACTION_FEE_POOL_PERIOD);
    ReflectionTestUtils.setField(chainBaseManager, "dynamicPropertiesStore", dynamicPropertiesStore);
    ReflectionTestUtils.setField(chainBaseManager, "delegationStore", mock(DelegationStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "delegatedResourceStore", mock(DelegatedResourceStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "delegatedResourceAccountIndexStore",
        mock(DelegatedResourceAccountIndexStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "dbStatService", mock(DbStatService.class));
    ReflectionTestUtils.setField(chainBaseManager, "contractStore", mock(ContractStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "contractStateStore", mock(ContractStateStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "commonStore", mock(CommonStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "commonDataBase", mock(CommonDataBase.class));
    ReflectionTestUtils.setField(chainBaseManager, "codeStore", mock(CodeStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "blockStore", mock(BlockStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "blockIndexStore", mock(BlockIndexStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "balanceTraceStore", mock(BalanceTraceStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "assetIssueV2Store", mock(AssetIssueV2Store.class));
    ReflectionTestUtils.setField(chainBaseManager, "assetIssueStore", mock(AssetIssueStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "accountTraceStore", mock(AccountTraceStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "accountStore", mock(AccountStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "accountIndexStore", mock(AccountIndexStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "accountIdIndexStore", mock(AccountIdIndexStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "accountAssetStore", mock(AccountAssetStore.class));
    ReflectionTestUtils.setField(chainBaseManager, "abiStore", mock(AbiStore.class));

    // Act
    long actualHeadSlot = chainBaseManager.getHeadSlot();

    // Assert
    verify(genesisBlock).getTimeStamp();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    assertEquals(Constant.PB_DEFAULT_ENERGY_LIMIT, actualHeadSlot);
  }

  /**
   * Test {@link ChainBaseManager#containBlock(Sha256Hash)}.
   * <p>
   * Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ChainBaseManager.containBlock(Sha256Hash)"})
  public void testContainBlock() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(false);

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(new BlockId());

    // Assert
    verify(khaosDatabase).containBlockInMiniStore(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlock(Sha256Hash)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then calls {@link Sha256Hash#getBytes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ChainBaseManager.containBlock(Sha256Hash)"})
  public void testContainBlock_givenAxaxaxaxBytesIsUtf8_thenCallsGetBytes()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenThrow(new ItemNotFoundException("An error occurred"));
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
   * <ul>
   *   <li>Given {@link BlockStore} {@link TronStoreWithRevoking#get(byte[])} return {@link BlockCapsule}.</li>
   *   <li>When {@link BlockId#BlockId()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ChainBaseManager.containBlock(Sha256Hash)"})
  public void testContainBlock_givenBlockStoreGetReturnBlockCapsule_whenBlockId_thenReturnTrue()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenReturn(mock(BlockCapsule.class));
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(false);

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(new BlockId());

    // Assert
    verify(khaosDatabase).containBlockInMiniStore(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
    assertTrue(actualContainBlockResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlock(Sha256Hash)}.
   * <ul>
   *   <li>Given {@link BlockStore} {@link TronStoreWithRevoking#get(byte[])} return {@code null}.</li>
   *   <li>When {@link BlockId#BlockId()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ChainBaseManager.containBlock(Sha256Hash)"})
  public void testContainBlock_givenBlockStoreGetReturnNull_whenBlockId_thenReturnFalse()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenReturn(null);
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(false);

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(new BlockId());

    // Assert
    verify(khaosDatabase).containBlockInMiniStore(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlock(Sha256Hash)}.
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#containBlockInMiniStore(Sha256Hash)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ChainBaseManager.containBlock(Sha256Hash)"})
  public void testContainBlock_givenKhaosDatabaseContainBlockInMiniStoreReturnTrue() {
    // Arrange
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(true);

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(null);

    // Assert
    verify(khaosDatabase).containBlockInMiniStore(isNull());
    assertTrue(actualContainBlockResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlockInMainChain(BlockId)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then calls {@link Sha256Hash#getBytes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#containBlockInMainChain(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ChainBaseManager.containBlockInMainChain(BlockId)"})
  public void testContainBlockInMainChain_givenAxaxaxaxBytesIsUtf8_thenCallsGetBytes()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenThrow(new ItemNotFoundException("An error occurred"));
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
   * <ul>
   *   <li>Given {@link BlockStore} {@link TronStoreWithRevoking#get(byte[])} return {@link BlockCapsule}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#containBlockInMainChain(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ChainBaseManager.containBlockInMainChain(BlockId)"})
  public void testContainBlockInMainChain_givenBlockStoreGetReturnBlockCapsule_thenReturnTrue()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenReturn(mock(BlockCapsule.class));

    // Act
    boolean actualContainBlockInMainChainResult = chainBaseManager.containBlockInMainChain(new BlockId());

    // Assert
    verify(blockStore).get(isA(byte[].class));
    assertTrue(actualContainBlockInMainChainResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlockInMainChain(BlockId)}.
   * <ul>
   *   <li>Given {@link BlockStore} {@link TronStoreWithRevoking#get(byte[])} return {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#containBlockInMainChain(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ChainBaseManager.containBlockInMainChain(BlockId)"})
  public void testContainBlockInMainChain_givenBlockStoreGetReturnNull_thenReturnFalse()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenReturn(null);

    // Act
    boolean actualContainBlockInMainChainResult = chainBaseManager.containBlockInMainChain(new BlockId());

    // Assert
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockInMainChainResult);
  }

  /**
   * Test {@link ChainBaseManager#containBlockInMainChain(BlockId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#containBlockInMainChain(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ChainBaseManager.containBlockInMainChain(BlockId)"})
  public void testContainBlockInMainChain_thenReturnFalse() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenThrow(new ItemNotFoundException("An error occurred"));

    // Act
    boolean actualContainBlockInMainChainResult = chainBaseManager.containBlockInMainChain(new BlockId());

    // Assert
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockInMainChainResult);
  }

  /**
   * Test {@link ChainBaseManager#getKhaosDbHead()}.
   * <p>
   * Method under test: {@link ChainBaseManager#getKhaosDbHead()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link ChainBaseManager#getBlockById(Sha256Hash)}.
   * <ul>
   *   <li>Given {@link BlockStore} {@link TronStoreWithRevoking#get(byte[])} return {@code null}.</li>
   *   <li>When {@link BlockId#BlockId()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#getBlockById(Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockById(Sha256Hash)"})
  public void testGetBlockById_givenBlockStoreGetReturnNull_whenBlockId_thenReturnNull()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenReturn(null);
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(null);

    // Act
    BlockCapsule actualBlockById = chainBaseManager.getBlockById(new BlockId());

    // Assert
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
    assertNull(actualBlockById);
  }

  /**
   * Test {@link ChainBaseManager#getBlockById(Sha256Hash)}.
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#getBlock(Sha256Hash)} return {@link BlockCapsule}.</li>
   *   <li>Then calls {@link KhaosDatabase#getBlock(Sha256Hash)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#getBlockById(Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockById(Sha256Hash)"})
  public void testGetBlockById_givenKhaosDatabaseGetBlockReturnBlockCapsule_thenCallsGetBlock()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(mock(BlockCapsule.class));

    // Act
    chainBaseManager.getBlockById(null);

    // Assert
    verify(khaosDatabase).getBlock(isNull());
  }

  /**
   * Test {@link ChainBaseManager#hasBlocks()}.
   * <ul>
   *   <li>Given {@link BlockStore} {@link TronStoreWithRevoking#isNotEmpty()} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#hasBlocks()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#hasData()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#hasBlocks()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#hasData()} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#hasBlocks()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link ChainBaseManager#getSolidBlockId()}.
   * <ul>
   *   <li>Given {@link BlockIndexStore} {@link BlockIndexStore#get(Long)} return {@link BlockId#BlockId()}.</li>
   *   <li>Then return {@link BlockId#BlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#getSolidBlockId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockId ChainBaseManager.getSolidBlockId()"})
  public void testGetSolidBlockId_givenBlockIndexStoreGetReturnBlockId_thenReturnBlockId()
      throws ItemNotFoundException {
    // Arrange
    BlockId blockId = new BlockId();
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(blockId);
    when(dynamicPropertiesStore.getLatestSolidifiedBlockNum()).thenReturn(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Act
    BlockId actualSolidBlockId = chainBaseManager.getSolidBlockId();

    // Assert
    verify(blockIndexStore).get(eq(1L));
    verify(dynamicPropertiesStore).getLatestSolidifiedBlockNum();
    assertSame(blockId, actualSolidBlockId);
  }

  /**
   * Test {@link ChainBaseManager#getGenesisBlockId()}.
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link BlockId#BlockId()}.</li>
   *   <li>Then return {@link BlockId#BlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#getGenesisBlockId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link ChainBaseManager#getBlockIdByNum(long)}.
   * <ul>
   *   <li>Given {@link BlockIndexStore} {@link BlockIndexStore#get(Long)} return {@link BlockId#BlockId()}.</li>
   *   <li>Then return {@link BlockId#BlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#getBlockIdByNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockId ChainBaseManager.getBlockIdByNum(long)"})
  public void testGetBlockIdByNum_givenBlockIndexStoreGetReturnBlockId_thenReturnBlockId()
      throws ItemNotFoundException {
    // Arrange
    BlockId blockId = new BlockId();
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(blockId);

    // Act
    BlockId actualBlockIdByNum = chainBaseManager.getBlockIdByNum(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Assert
    verify(blockIndexStore).get(eq(1L));
    assertSame(blockId, actualBlockIdByNum);
  }

  /**
   * Test {@link ChainBaseManager#getBlockIdByNum(long)}.
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#getBlockIdByNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockId ChainBaseManager.getBlockIdByNum(long)"})
  public void testGetBlockIdByNum_thenThrowItemNotFoundException() throws ItemNotFoundException {
    // Arrange
    when(blockIndexStore.get(Mockito.<Long>any())).thenThrow(new ItemNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(ItemNotFoundException.class,
        () -> chainBaseManager.getBlockIdByNum(Constant.TRANSACTION_FEE_POOL_PERIOD));
    verify(blockIndexStore).get(eq(1L));
  }

  /**
   * Test {@link ChainBaseManager#getBlockByNum(long)}.
   * <ul>
   *   <li>Given {@link KhaosDatabase} {@link KhaosDatabase#getBlock(Sha256Hash)} return {@link BlockCapsule}.</li>
   *   <li>Then calls {@link BlockIndexStore#get(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#getBlockByNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockCapsule ChainBaseManager.getBlockByNum(long)"})
  public void testGetBlockByNum_givenKhaosDatabaseGetBlockReturnBlockCapsule_thenCallsGet()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(new BlockId());
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(mock(BlockCapsule.class));

    // Act
    chainBaseManager.getBlockByNum(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Assert
    verify(blockIndexStore).get(eq(1L));
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
  }

  /**
   * Test NodeType {@link NodeType#getType()}.
   * <p>
   * Method under test: {@link NodeType#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int NodeType.getType()"})
  public void testNodeTypeGetType() {
    // Arrange, Act and Assert
    assertEquals(0, NodeType.valueOf("FULL").getType());
  }

  /**
   * Test {@link ChainBaseManager#shutdown()}.
   * <p>
   * Method under test: {@link ChainBaseManager#shutdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChainBaseManager.shutdown()"})
  public void testShutdown() {
    // Arrange
    doNothing().when(dbStatService).shutdown();

    // Act
    chainBaseManager.shutdown();

    // Assert
    verify(dbStatService).shutdown();
  }

  /**
   * Test {@link ChainBaseManager#isLiteNode()}.
   * <ul>
   *   <li>Given {@link ChainBaseManager} NodeType is {@link NodeType#LITE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#isLiteNode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ChainBaseManager.isLiteNode()"})
  public void testIsLiteNode_givenChainBaseManagerNodeTypeIsLite_thenReturnTrue() {
    // Arrange
    chainBaseManager.setNodeType(NodeType.LITE);

    // Act and Assert
    assertTrue(chainBaseManager.isLiteNode());
  }

  /**
   * Test {@link ChainBaseManager#isLiteNode()}.
   * <ul>
   *   <li>Given {@link ChainBaseManager}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainBaseManager#isLiteNode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ChainBaseManager.isLiteNode()"})
  public void testIsLiteNode_givenChainBaseManager_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(chainBaseManager.isLiteNode());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ChainBaseManager#getChainBaseManager()}
   *   <li>{@link ChainBaseManager#getInstance()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AbiStore ChainBaseManager.getAbiStore()",
      "AccountAssetStore ChainBaseManager.getAccountAssetStore()",
      "AccountIdIndexStore ChainBaseManager.getAccountIdIndexStore()",
      "AccountIndexStore ChainBaseManager.getAccountIndexStore()", "AccountStore ChainBaseManager.getAccountStore()",
      "AccountTraceStore ChainBaseManager.getAccountTraceStore()",
      "AssetIssueStore ChainBaseManager.getAssetIssueStore()",
      "AssetIssueV2Store ChainBaseManager.getAssetIssueV2Store()",
      "BalanceTraceStore ChainBaseManager.getBalanceTraceStore()",
      "BlockIndexStore ChainBaseManager.getBlockIndexStore()", "BlockStore ChainBaseManager.getBlockStore()",
      "ChainBaseManager ChainBaseManager.getChainBaseManager()", "CodeStore ChainBaseManager.getCodeStore()",
      "CommonDataBase ChainBaseManager.getCommonDataBase()", "CommonStore ChainBaseManager.getCommonStore()",
      "ContractStateStore ChainBaseManager.getContractStateStore()",
      "ContractStore ChainBaseManager.getContractStore()",
      "DelegatedResourceAccountIndexStore ChainBaseManager.getDelegatedResourceAccountIndexStore()",
      "DelegatedResourceStore ChainBaseManager.getDelegatedResourceStore()",
      "DelegationStore ChainBaseManager.getDelegationStore()",
      "DynamicPropertiesStore ChainBaseManager.getDynamicPropertiesStore()",
      "ExchangeStore ChainBaseManager.getExchangeStore()", "ExchangeV2Store ChainBaseManager.getExchangeV2Store()",
      "org.tron.common.utils.ForkController ChainBaseManager.getForkController()",
      "BlockCapsule ChainBaseManager.getGenesisBlock()", "ChainBaseManager ChainBaseManager.getInstance()",
      "KhaosDatabase ChainBaseManager.getKhaosDb()", "long ChainBaseManager.getLatestSaveBlockTime()",
      "long ChainBaseManager.getLowestBlockNum()", "MarketAccountStore ChainBaseManager.getMarketAccountStore()",
      "MarketOrderStore ChainBaseManager.getMarketOrderStore()",
      "MarketPairPriceToOrderStore ChainBaseManager.getMarketPairPriceToOrderStore()",
      "MarketPairToPriceStore ChainBaseManager.getMarketPairToPriceStore()",
      "org.tron.common.zksnark.MerkleContainer ChainBaseManager.getMerkleContainer()",
      "TreeBlockIndexStore ChainBaseManager.getMerkleTreeIndexStore()",
      "IncrementalMerkleTreeStore ChainBaseManager.getMerkleTreeStore()",
      "org.tron.core.service.MortgageService ChainBaseManager.getMortgageService()",
      "NodeType ChainBaseManager.getNodeType()", "NullifierStore ChainBaseManager.getNullifierStore()",
      "PbftSignDataStore ChainBaseManager.getPbftSignDataStore()", "ZKProofStore ChainBaseManager.getProofStore()",
      "ProposalStore ChainBaseManager.getProposalStore()", "RecentBlockStore ChainBaseManager.getRecentBlockStore()",
      "RecentTransactionStore ChainBaseManager.getRecentTransactionStore()",
      "SectionBloomStore ChainBaseManager.getSectionBloomStore()",
      "StorageRowStore ChainBaseManager.getStorageRowStore()",
      "TransactionHistoryStore ChainBaseManager.getTransactionHistoryStore()",
      "TransactionRetStore ChainBaseManager.getTransactionRetStore()",
      "TransactionStore ChainBaseManager.getTransactionStore()", "VotesStore ChainBaseManager.getVotesStore()",
      "WitnessScheduleStore ChainBaseManager.getWitnessScheduleStore()",
      "WitnessStore ChainBaseManager.getWitnessStore()", "void ChainBaseManager.setGenesisBlock(BlockCapsule)",
      "void ChainBaseManager.setLatestSaveBlockTime(long)", "void ChainBaseManager.setLowestBlockNum(long)",
      "void ChainBaseManager.setMerkleContainer(org.tron.common.zksnark.MerkleContainer)",
      "void ChainBaseManager.setMerkleTreeIndexStore(TreeBlockIndexStore)",
      "void ChainBaseManager.setMortgageService(org.tron.core.service.MortgageService)",
      "void ChainBaseManager.setNodeType(NodeType)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ChainBaseManager actualChainBaseManager = ChainBaseManager.getChainBaseManager();
    ChainBaseManager actualChainBaseManager2 = actualChainBaseManager.getChainBaseManager();

    // Assert
    assertNull(actualChainBaseManager2);
    assertNull(actualChainBaseManager.getInstance());
  }
}
