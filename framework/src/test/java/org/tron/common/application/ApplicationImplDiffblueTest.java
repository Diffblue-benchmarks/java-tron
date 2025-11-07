package org.tron.common.application;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.tron.common.parameter.CommonParameter;
import org.tron.core.ChainBaseManager;
import org.tron.core.config.args.Args;
import org.tron.core.consensus.ConsensusService;
import org.tron.core.db.Manager;
import org.tron.core.net.TronNetService;

public class ApplicationImplDiffblueTest {
  /**
   * Method under test: {@link ApplicationImpl#startup()}
   */
  @Test
  public void testStartup() {
    // Arrange
    ApplicationImpl applicationImpl = new ApplicationImpl();
    applicationImpl.init(mock(CommonParameter.class));
    ReflectionTestUtils.setField(applicationImpl, "tronNetService", mock(TronNetService.class));
    ReflectionTestUtils.setField(applicationImpl, "dbManager", mock(Manager.class));
    ConsensusService consensusService = mock(ConsensusService.class);
    doNothing().when(consensusService).start();
    ReflectionTestUtils.setField(applicationImpl, "consensusService", consensusService);
    ReflectionTestUtils.setField(applicationImpl, "chainBaseManager", mock(ChainBaseManager.class));

    // Act
    applicationImpl.startup();

    // Assert
    verify(consensusService).start();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApplicationImpl#setOptions(Args)}
   *   <li>{@link ApplicationImpl#getChainBaseManager()}
   *   <li>{@link ApplicationImpl#getDbManager()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ApplicationImpl applicationImpl = new ApplicationImpl();

    // Act
    applicationImpl.setOptions(new Args());
    ChainBaseManager actualChainBaseManager = applicationImpl.getChainBaseManager();

    // Assert that nothing has changed
    assertNull(actualChainBaseManager);
    assertNull(applicationImpl.getDbManager());
  }

  /**
   * Method under test: {@link ApplicationImpl#shutdown()}
   */
  @Test
  public void testShutdown() {
    // Arrange
    ApplicationImpl applicationImpl = new ApplicationImpl();
    applicationImpl.init(mock(CommonParameter.class));
    ReflectionTestUtils.setField(applicationImpl, "tronNetService", mock(TronNetService.class));
    Manager manager = mock(Manager.class);
    doNothing().when(manager).close();
    ReflectionTestUtils.setField(applicationImpl, "dbManager", manager);
    ConsensusService consensusService = mock(ConsensusService.class);
    doNothing().when(consensusService).stop();
    ReflectionTestUtils.setField(applicationImpl, "consensusService", consensusService);
    ReflectionTestUtils.setField(applicationImpl, "chainBaseManager", mock(ChainBaseManager.class));

    // Act
    applicationImpl.shutdown();

    // Assert that nothing has changed
    verify(consensusService).stop();
    verify(manager).close();
  }
}
