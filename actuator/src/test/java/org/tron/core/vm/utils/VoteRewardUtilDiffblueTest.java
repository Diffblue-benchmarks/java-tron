package org.tron.core.vm.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class VoteRewardUtilDiffblueTest {
  /**
   * Test {@link VoteRewardUtil#queryReward(byte[], Repository)}.
   * <p>
   * Method under test: {@link VoteRewardUtil#queryReward(byte[], Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long VoteRewardUtil.queryReward(byte[], Repository)"})
  public void testQueryReward() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L, VoteRewardUtil.queryReward(address,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }
}
