package org.tron.core.store;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StoreFactoryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Method under test: {@link StoreFactory#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.tron.core.ChainBaseManager StoreFactory.getChainBaseManager()",
    "StoreFactory StoreFactory.getInstance()",
    "StoreFactory StoreFactory.setChainBaseManager(org.tron.core.ChainBaseManager)"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull(StoreFactory.getInstance().getInstance());
  }
}
