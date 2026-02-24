package org.tron.core.vm.config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.ChainBaseManager;
import org.tron.core.store.StoreFactory;

public class ConfigLoaderDiffblueTest {
  /**
   * Test {@link ConfigLoader#load(StoreFactory)}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} (default constructor).
   *   <li>Then calls {@link StoreFactory#getChainBaseManager()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigLoader#load(StoreFactory)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigLoader.load(StoreFactory)"})
  public void testLoad_givenChainBaseManager_thenCallsGetChainBaseManager() {
    // Arrange
    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(new ChainBaseManager());

    // Act
    ConfigLoader.load(storeFactory);

    // Assert
    verify(storeFactory).getChainBaseManager();
  }
}
