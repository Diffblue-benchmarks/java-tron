package org.tron.core.db.accountstate;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.ChainBaseManager;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.DynamicPropertiesStore;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TrieServiceDiffblueTest {
  /**
   * Test {@link TrieService#getFullAccountStateRootHash()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieService#getFullAccountStateRootHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieService.getFullAccountStateRootHash()"})
  public void testGetFullAccountStateRootHash_thenReturnNull()
      throws BadItemException, ItemNotFoundException {
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
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    assertNull(actualFullAccountStateRootHash);
  }

  /**
   * Test {@link TrieService#getSolidityAccountStateRootHash()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieService#getSolidityAccountStateRootHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieService.getSolidityAccountStateRootHash()"})
  public void testGetSolidityAccountStateRootHash_thenReturnNull()
      throws BadItemException, ItemNotFoundException {
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
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestSolidifiedBlockNum();
    assertNull(actualSolidityAccountStateRootHash);
  }
}
