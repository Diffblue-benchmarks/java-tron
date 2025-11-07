package org.tron.core.db.accountstate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;

public class TrieServiceDiffblueTest {
  /**
   * Method under test: {@link TrieService#getFullAccountStateRootHash()}
   */
  @Test
  public void testGetFullAccountStateRootHash() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    TrieService trieService = new TrieService();
    trieService.setChainBaseManager(chainBaseManager);

    // Act
    byte[] actualFullAccountStateRootHash = trieService.getFullAccountStateRootHash();

    // Assert
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    assertNull(actualFullAccountStateRootHash);
  }

  /**
   * Method under test: {@link TrieService#getFullAccountStateRootHash()}
   */
  @Test
  public void testGetFullAccountStateRootHash2() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    TrieService trieService = new TrieService();
    trieService.setChainBaseManager(chainBaseManager);

    // Act
    byte[] actualFullAccountStateRootHash = trieService.getFullAccountStateRootHash();

    // Assert
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    assertArrayEquals(new byte[]{'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
        -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'}, actualFullAccountStateRootHash);
  }

  /**
   * Method under test: {@link TrieService#getFullAccountStateRootHash()}
   */
  @Test
  public void testGetFullAccountStateRootHash3() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getInstance()).thenReturn(null);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    TrieService trieService = new TrieService();
    trieService.setChainBaseManager(chainBaseManager);

    // Act
    byte[] actualFullAccountStateRootHash = trieService.getFullAccountStateRootHash();

    // Assert
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(blockCapsule).getInstance();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    assertNull(actualFullAccountStateRootHash);
  }

  /**
   * Method under test: {@link TrieService#getFullAccountStateRootHash()}
   */
  @Test
  public void testGetFullAccountStateRootHash4()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    blockCapsule.setAccountStateRoot("AXAXAXAX".getBytes("UTF-8"));
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    TrieService trieService = new TrieService();
    trieService.setChainBaseManager(chainBaseManager);

    // Act
    byte[] actualFullAccountStateRootHash = trieService.getFullAccountStateRootHash();

    // Assert
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualFullAccountStateRootHash);
  }

  /**
   * Method under test: {@link TrieService#getSolidityAccountStateRootHash()}
   */
  @Test
  public void testGetSolidityAccountStateRootHash() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestSolidifiedBlockNum()).thenReturn(1L);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    TrieService trieService = new TrieService();
    trieService.setChainBaseManager(chainBaseManager);

    // Act
    byte[] actualSolidityAccountStateRootHash = trieService.getSolidityAccountStateRootHash();

    // Assert
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestSolidifiedBlockNum();
    assertNull(actualSolidityAccountStateRootHash);
  }

  /**
   * Method under test: {@link TrieService#getSolidityAccountStateRootHash()}
   */
  @Test
  public void testGetSolidityAccountStateRootHash2() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestSolidifiedBlockNum()).thenReturn(1L);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    TrieService trieService = new TrieService();
    trieService.setChainBaseManager(chainBaseManager);

    // Act
    byte[] actualSolidityAccountStateRootHash = trieService.getSolidityAccountStateRootHash();

    // Assert
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestSolidifiedBlockNum();
    assertArrayEquals(new byte[]{'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
        -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'}, actualSolidityAccountStateRootHash);
  }

  /**
   * Method under test: {@link TrieService#getSolidityAccountStateRootHash()}
   */
  @Test
  public void testGetSolidityAccountStateRootHash3() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestSolidifiedBlockNum()).thenReturn(1L);
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getInstance()).thenReturn(null);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    TrieService trieService = new TrieService();
    trieService.setChainBaseManager(chainBaseManager);

    // Act
    byte[] actualSolidityAccountStateRootHash = trieService.getSolidityAccountStateRootHash();

    // Assert
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(blockCapsule).getInstance();
    verify(dynamicPropertiesStore).getLatestSolidifiedBlockNum();
    assertNull(actualSolidityAccountStateRootHash);
  }

  /**
   * Method under test: {@link TrieService#getSolidityAccountStateRootHash()}
   */
  @Test
  public void testGetSolidityAccountStateRootHash4()
      throws UnsupportedEncodingException, BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestSolidifiedBlockNum()).thenReturn(1L);

    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    blockCapsule.setAccountStateRoot("AXAXAXAX".getBytes("UTF-8"));
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    TrieService trieService = new TrieService();
    trieService.setChainBaseManager(chainBaseManager);

    // Act
    byte[] actualSolidityAccountStateRootHash = trieService.getSolidityAccountStateRootHash();

    // Assert
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestSolidifiedBlockNum();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSolidityAccountStateRootHash);
  }
}
