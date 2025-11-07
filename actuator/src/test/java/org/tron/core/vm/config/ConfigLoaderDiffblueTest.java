package org.tron.core.vm.config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.tron.core.ChainBaseManager;
import org.tron.core.store.StoreFactory;

public class ConfigLoaderDiffblueTest {
  /**
   * Method under test: {@link ConfigLoader#load(StoreFactory)}
   */
  @Test
  public void testLoad() {
    // Arrange
    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(new ChainBaseManager());

    // Act
    ConfigLoader.load(storeFactory);

    // Assert
    verify(storeFactory).getChainBaseManager();
  }
}
