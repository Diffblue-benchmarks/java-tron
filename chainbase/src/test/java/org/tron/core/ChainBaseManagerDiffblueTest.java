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
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.storage.metric.DbStatService;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.db.BlockIndexStore;
import org.tron.core.db.BlockStore;
import org.tron.core.db.CommonDataBase;
import org.tron.core.db.CommonStore;
import org.tron.core.db.KhaosDatabase;
import org.tron.core.db.PbftSignDataStore;
import org.tron.core.db.RecentBlockStore;
import org.tron.core.db.RecentTransactionStore;
import org.tron.core.db.TransactionStore;
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
  @Mock
  private AbiStore abiStore;

  @Mock
  private AccountAssetStore accountAssetStore;

  @Mock
  private AccountIdIndexStore accountIdIndexStore;

  @Mock
  private AccountIndexStore accountIndexStore;

  @Mock
  private AccountStore accountStore;

  @Mock
  private AccountTraceStore accountTraceStore;

  @Mock
  private AssetIssueStore assetIssueStore;

  @Mock
  private AssetIssueV2Store assetIssueV2Store;

  @Mock
  private BalanceTraceStore balanceTraceStore;

  @Mock
  private BlockIndexStore blockIndexStore;

  @Mock
  private BlockStore blockStore;

  @InjectMocks
  private ChainBaseManager chainBaseManager;

  @Mock
  private CodeStore codeStore;

  @Mock
  private CommonDataBase commonDataBase;

  @Mock
  private CommonStore commonStore;

  @Mock
  private ContractStateStore contractStateStore;

  @Mock
  private ContractStore contractStore;

  @Mock
  private DbStatService dbStatService;

  @Mock
  private DelegatedResourceAccountIndexStore delegatedResourceAccountIndexStore;

  @Mock
  private DelegatedResourceStore delegatedResourceStore;

  @Mock
  private DelegationStore delegationStore;

  @Mock
  private DynamicPropertiesStore dynamicPropertiesStore;

  @Mock
  private ExchangeStore exchangeStore;

  @Mock
  private ExchangeV2Store exchangeV2Store;

  @Mock
  private IncrementalMerkleTreeStore incrementalMerkleTreeStore;

  @Mock
  private KhaosDatabase khaosDatabase;

  @Mock
  private MarketAccountStore marketAccountStore;

  @Mock
  private MarketOrderStore marketOrderStore;

  @Mock
  private MarketPairPriceToOrderStore marketPairPriceToOrderStore;

  @Mock
  private MarketPairToPriceStore marketPairToPriceStore;

  @Mock
  private NullifierStore nullifierStore;

  @Mock
  private PbftSignDataStore pbftSignDataStore;

  @Mock
  private ProposalStore proposalStore;

  @Mock
  private RecentBlockStore recentBlockStore;

  @Mock
  private RecentTransactionStore recentTransactionStore;

  @Mock
  private SectionBloomStore sectionBloomStore;

  @Mock
  private StorageRowStore storageRowStore;

  @Mock
  private TransactionHistoryStore transactionHistoryStore;

  @Mock
  private TransactionRetStore transactionRetStore;

  @Mock
  private TransactionStore transactionStore;

  @Mock
  private TreeBlockIndexStore treeBlockIndexStore;

  @Mock
  private VotesStore votesStore;

  @Mock
  private WitnessScheduleStore witnessScheduleStore;

  @Mock
  private WitnessStore witnessStore;

  @Mock
  private ZKProofStore zKProofStore;

  /**
   * Method under test: {@link ChainBaseManager#getWitnesses()}
   */
  @Test
  public void testGetWitnesses() {
    // Arrange
    ArrayList<ByteString> byteStringList = new ArrayList<>();
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(byteStringList);

    // Act
    List<ByteString> actualWitnesses = chainBaseManager.getWitnesses();

    // Assert
    verify(witnessScheduleStore).getActiveWitnesses();
    assertTrue(actualWitnesses.isEmpty());
    assertSame(byteStringList, actualWitnesses);
  }

  /**
   * Method under test: {@link ChainBaseManager#addWitness(ByteString)}
   */
  @Test
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
   * Method under test: {@link ChainBaseManager#getHead()}
   */
  @Test
  public void testGetHead() throws HeaderNotFound {
    // Arrange
    when(blockStore.getBlockByLatestNum(anyLong())).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(HeaderNotFound.class, () -> chainBaseManager.getHead());
    verify(blockStore).getBlockByLatestNum(eq(1L));
  }

  /**
   * Method under test: {@link ChainBaseManager#getHead()}
   */
  @Test
  public void testGetHead2() throws HeaderNotFound {
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
   * Method under test: {@link ChainBaseManager#getHeadBlockId()}
   */
  @Test
  public void testGetHeadBlockId() {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();
    when(dynamicPropertiesStore.getLatestBlockHeaderHash()).thenReturn(blockId);

    // Act
    BlockCapsule.BlockId actualHeadBlockId = chainBaseManager.getHeadBlockId();

    // Assert
    verify(dynamicPropertiesStore).getLatestBlockHeaderHash();
    assertEquals(blockId, actualHeadBlockId);
  }

  /**
   * Method under test: {@link ChainBaseManager#getHeadBlockNum()}
   */
  @Test
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
   * Method under test: {@link ChainBaseManager#getHeadBlockTimeStamp()}
   */
  @Test
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
   * Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  public void testContainBlock() {
    // Arrange
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(true);

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(null);

    // Assert
    verify(khaosDatabase).containBlockInMiniStore(isNull());
    assertTrue(actualContainBlockResult);
  }

  /**
   * Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  public void testContainBlock2() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenReturn(null);
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(false);

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(new BlockCapsule.BlockId());

    // Assert
    verify(khaosDatabase).containBlockInMiniStore(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockResult);
  }

  /**
   * Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  public void testContainBlock3() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenReturn(mock(BlockCapsule.class));
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(false);

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(new BlockCapsule.BlockId());

    // Assert
    verify(khaosDatabase).containBlockInMiniStore(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
    assertTrue(actualContainBlockResult);
  }

  /**
   * Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  public void testContainBlock4() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenThrow(new ItemNotFoundException("An error occurred"));
    when(khaosDatabase.containBlockInMiniStore(Mockito.<Sha256Hash>any())).thenReturn(false);

    // Act
    boolean actualContainBlockResult = chainBaseManager.containBlock(new BlockCapsule.BlockId());

    // Assert
    verify(khaosDatabase).containBlockInMiniStore(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockResult);
  }

  /**
   * Method under test: {@link ChainBaseManager#containBlock(Sha256Hash)}
   */
  @Test
  public void testContainBlock5() throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
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
   * Method under test:
   * {@link ChainBaseManager#containBlockInMainChain(BlockCapsule.BlockId)}
   */
  @Test
  public void testContainBlockInMainChain() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenReturn(null);

    // Act
    boolean actualContainBlockInMainChainResult = chainBaseManager.containBlockInMainChain(new BlockCapsule.BlockId());

    // Assert
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockInMainChainResult);
  }

  /**
   * Method under test:
   * {@link ChainBaseManager#containBlockInMainChain(BlockCapsule.BlockId)}
   */
  @Test
  public void testContainBlockInMainChain2() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenReturn(mock(BlockCapsule.class));

    // Act
    boolean actualContainBlockInMainChainResult = chainBaseManager.containBlockInMainChain(new BlockCapsule.BlockId());

    // Assert
    verify(blockStore).get(isA(byte[].class));
    assertTrue(actualContainBlockInMainChainResult);
  }

  /**
   * Method under test:
   * {@link ChainBaseManager#containBlockInMainChain(BlockCapsule.BlockId)}
   */
  @Test
  public void testContainBlockInMainChain3() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenThrow(new ItemNotFoundException("An error occurred"));

    // Act
    boolean actualContainBlockInMainChainResult = chainBaseManager.containBlockInMainChain(new BlockCapsule.BlockId());

    // Assert
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockInMainChainResult);
  }

  /**
   * Method under test:
   * {@link ChainBaseManager#containBlockInMainChain(BlockCapsule.BlockId)}
   */
  @Test
  public void testContainBlockInMainChain4()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenThrow(new ItemNotFoundException("An error occurred"));
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualContainBlockInMainChainResult = chainBaseManager.containBlockInMainChain(blockId);

    // Assert
    verify(blockId).getBytes();
    verify(blockStore).get(isA(byte[].class));
    assertFalse(actualContainBlockInMainChainResult);
  }

  /**
   * Method under test: {@link ChainBaseManager#getKhaosDbHead()}
   */
  @Test
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
   * Method under test: {@link ChainBaseManager#getBlockById(Sha256Hash)}
   */
  @Test
  public void testGetBlockById() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(mock(BlockCapsule.class));

    // Act
    chainBaseManager.getBlockById(null);

    // Assert
    verify(khaosDatabase).getBlock(isNull());
  }

  /**
   * Method under test: {@link ChainBaseManager#getBlockById(Sha256Hash)}
   */
  @Test
  public void testGetBlockById2() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockStore.get(Mockito.<byte[]>any())).thenReturn(null);
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(null);

    // Act
    BlockCapsule actualBlockById = chainBaseManager.getBlockById(new BlockCapsule.BlockId());

    // Assert
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
    verify(blockStore).get(isA(byte[].class));
    assertNull(actualBlockById);
  }

  /**
   * Method under test: {@link ChainBaseManager#hasBlocks()}
   */
  @Test
  public void testHasBlocks() {
    // Arrange
    when(blockStore.isNotEmpty()).thenReturn(true);

    // Act
    boolean actualHasBlocksResult = chainBaseManager.hasBlocks();

    // Assert
    verify(blockStore).isNotEmpty();
    assertTrue(actualHasBlocksResult);
  }

  /**
   * Method under test: {@link ChainBaseManager#hasBlocks()}
   */
  @Test
  public void testHasBlocks2() {
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
   * Method under test: {@link ChainBaseManager#hasBlocks()}
   */
  @Test
  public void testHasBlocks3() {
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
   * Method under test: {@link ChainBaseManager#getSolidBlockId()}
   */
  @Test
  public void testGetSolidBlockId() throws ItemNotFoundException {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(blockId);
    when(dynamicPropertiesStore.getLatestSolidifiedBlockNum()).thenReturn(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Act
    BlockCapsule.BlockId actualSolidBlockId = chainBaseManager.getSolidBlockId();

    // Assert
    verify(blockIndexStore).get(eq(1L));
    verify(dynamicPropertiesStore).getLatestSolidifiedBlockNum();
    assertSame(blockId, actualSolidBlockId);
  }

  /**
   * Method under test: {@link ChainBaseManager#getBlockIdByNum(long)}
   */
  @Test
  public void testGetBlockIdByNum() throws ItemNotFoundException {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(blockId);

    // Act
    BlockCapsule.BlockId actualBlockIdByNum = chainBaseManager.getBlockIdByNum(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Assert
    verify(blockIndexStore).get(eq(1L));
    assertSame(blockId, actualBlockIdByNum);
  }

  /**
   * Method under test: {@link ChainBaseManager#getBlockIdByNum(long)}
   */
  @Test
  public void testGetBlockIdByNum2() throws ItemNotFoundException {
    // Arrange
    when(blockIndexStore.get(Mockito.<Long>any())).thenThrow(new ItemNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(ItemNotFoundException.class,
        () -> chainBaseManager.getBlockIdByNum(Constant.TRANSACTION_FEE_POOL_PERIOD));
    verify(blockIndexStore).get(eq(1L));
  }

  /**
   * Method under test: {@link ChainBaseManager#getBlockByNum(long)}
   */
  @Test
  public void testGetBlockByNum() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(blockIndexStore.get(Mockito.<Long>any())).thenReturn(new BlockCapsule.BlockId());
    when(khaosDatabase.getBlock(Mockito.<Sha256Hash>any())).thenReturn(mock(BlockCapsule.class));

    // Act
    chainBaseManager.getBlockByNum(Constant.TRANSACTION_FEE_POOL_PERIOD);

    // Assert
    verify(blockIndexStore).get(eq(1L));
    verify(khaosDatabase).getBlock(isA(Sha256Hash.class));
  }

  /**
   * Method under test: {@link ChainBaseManager#init(ChainBaseManager)}
   */
  @Test
  public void testInit() {
    // Arrange, Act and Assert
    assertThrows(NullPointerException.class, () -> ChainBaseManager.init(ChainBaseManager.getChainBaseManager()));
  }

  /**
   * Method under test: {@link ChainBaseManager.NodeType#getType()}
   */
  @Test
  public void testNodeTypeGetType() {
    // Arrange, Act and Assert
    assertEquals(0, ChainBaseManager.NodeType.valueOf("FULL").getType());
  }

  /**
   * Method under test: {@link ChainBaseManager#shutdown()}
   */
  @Test
  public void testShutdown() {
    // Arrange
    doNothing().when(dbStatService).shutdown();

    // Act
    chainBaseManager.shutdown();

    // Assert that nothing has changed
    verify(dbStatService).shutdown();
  }

  /**
   * Method under test: {@link ChainBaseManager#isLiteNode()}
   */
  @Test
  public void testIsLiteNode() {
    // Arrange, Act and Assert
    assertFalse(chainBaseManager.isLiteNode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ChainBaseManager#getChainBaseManager()}
   *   <li>{@link ChainBaseManager#getInstance()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ChainBaseManager actualChainBaseManager = ChainBaseManager.getChainBaseManager();
    ChainBaseManager actualChainBaseManager2 = actualChainBaseManager.getChainBaseManager();

    // Assert
    assertNull(actualChainBaseManager2);
    assertNull(actualChainBaseManager.getInstance());
  }
}
