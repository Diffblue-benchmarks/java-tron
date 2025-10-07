package org.tron.common.application;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.ChainBaseManager;
import org.tron.core.config.args.Args;
import org.tron.core.services.RpcApiService;

public class CliApplicationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CliApplication.<init>()",
    "void CliApplication.addService(Service)",
    "ChainBaseManager CliApplication.getChainBaseManager()",
    "org.tron.core.db.Manager CliApplication.getDbManager()",
    "void CliApplication.init(org.tron.common.parameter.CommonParameter)",
    "void CliApplication.initServices(org.tron.common.parameter.CommonParameter)",
    "void CliApplication.setOptions(Args)",
    "void CliApplication.shutdown()",
    "void CliApplication.shutdownServices()",
    "void CliApplication.startServices()",
    "void CliApplication.startup()"
  })
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

    // Assert
    assertNull(actualChainBaseManager);
    assertNull(actualCliApplication.getDbManager());
  }
}
