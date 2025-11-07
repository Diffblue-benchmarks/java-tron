package org.tron.core.consensus;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
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
  @Mock
  private Manager manager;

  @InjectMocks
  private PbftBaseImpl pbftBaseImpl;

  /**
   * Method under test: {@link PbftBaseImpl#isSyncing()}
   */
  @Test
  public void testIsSyncing() {
    // Arrange, Act and Assert
    assertTrue(pbftBaseImpl.isSyncing());
  }

  /**
   * Method under test: {@link PbftBaseImpl#getBlock(long)}
   */
  @Test
  public void testGetBlock() throws BadItemException, ItemNotFoundException {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(null);
    when(manager.getChainBaseManager()).thenReturn(chainBaseManager);

    // Act
    BlockCapsule actualBlock = pbftBaseImpl.getBlock(1L);

    // Assert
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(manager).getChainBaseManager();
    assertNull(actualBlock);
  }
}
