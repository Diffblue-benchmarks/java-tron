package org.tron.core.consensus;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.db.Manager;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class PbftBaseImplDiffblueTest {
  @Mock private Manager manager;

  @InjectMocks private PbftBaseImpl pbftBaseImpl;

  /**
   * Test {@link PbftBaseImpl#isSyncing()}.
   *
   * <p>Method under test: {@link PbftBaseImpl#isSyncing()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PbftBaseImpl.isSyncing()"})
  public void testIsSyncing() {
    // Arrange, Act and Assert
    assertTrue(new PbftBaseImpl().isSyncing());
  }

  /**
   * Test {@link PbftBaseImpl#getBlock(long)}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getBlockByNum(long)} return {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PbftBaseImpl#getBlock(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule PbftBaseImpl.getBlock(long)"})
  public void testGetBlock_givenChainBaseManagerGetBlockByNumReturnNull_thenReturnNull()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(null);
    when(manager.getChainBaseManager()).thenReturn(chainBaseManager);

    // Act
    BlockCapsule actualBlock = pbftBaseImpl.getBlock(1L);

    // Assert
    verify(chainBaseManager).getBlockByNum(1L);
    verify(manager).getChainBaseManager();
    assertNull(actualBlock);
  }
}
