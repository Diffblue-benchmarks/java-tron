package org.tron.common.application;

import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.tron.core.ChainBaseManager;
import org.tron.core.config.args.Args;
import org.tron.core.services.RpcApiService;

public class CliApplicationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CliApplication}
   *   <li>{@link CliApplication#addService(Service)}
   *   <li>{@link CliApplication#setOptions(Args)}
   *   <li>{@link CliApplication#shutdown()}
   *   <li>{@link CliApplication#shutdownServices()}
   *   <li>{@link CliApplication#startServices()}
   *   <li>{@link CliApplication#startup()}
   *   <li>{@link CliApplication#getChainBaseManager()}
   *   <li>{@link CliApplication#getDbManager()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CliApplication actualCliApplication = new CliApplication();
    actualCliApplication.addService(new RpcApiService());
    actualCliApplication.setOptions(new Args());
    actualCliApplication.shutdown();
    actualCliApplication.shutdownServices();
    actualCliApplication.startServices();
    actualCliApplication.startup();
    ChainBaseManager actualChainBaseManager = actualCliApplication.getChainBaseManager();

    // Assert that nothing has changed
    assertNull(actualChainBaseManager);
    assertNull(actualCliApplication.getDbManager());
  }
}
