package org.tron.core.vm.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.ChainBaseManager;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class VoteRewardUtilDiffblueTest {
  /**
   * Method under test: {@link VoteRewardUtil#withdrawReward(byte[], Repository)}
   */
  @Test
  public void testWithdrawReward() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(new ChainBaseManager());

    // Act
    VoteRewardUtil.withdrawReward(address, new RepositoryImpl(storeFactory, null));

    // Assert that nothing has changed
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Method under test: {@link VoteRewardUtil#queryReward(byte[], Repository)}
   */
  @Test
  public void testQueryReward() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L, VoteRewardUtil.queryReward(address,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }
}
