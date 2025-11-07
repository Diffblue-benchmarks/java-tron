package org.tron.common.application;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.tron.core.services.RpcApiService;

public class ServiceContainerDiffblueTest {
  /**
   * Method under test: {@link ServiceContainer#init()}
   */
  @Test
  public void testInit() {
    // Arrange
    RpcApiService service = mock(RpcApiService.class);
    doNothing().when(service).init();

    ServiceContainer serviceContainer = new ServiceContainer();
    serviceContainer.add(service);

    // Act
    serviceContainer.init();

    // Assert that nothing has changed
    verify(service).init();
  }

  /**
   * Method under test: {@link ServiceContainer#init()}
   */
  @Test
  public void testInit2() {
    // Arrange
    RpcApiService service = mock(RpcApiService.class);
    doNothing().when(service).init();

    ServiceContainer serviceContainer = new ServiceContainer();
    serviceContainer.add(new RpcApiService());
    serviceContainer.add(service);

    // Act
    serviceContainer.init();

    // Assert that nothing has changed
    verify(service).init();
  }

  /**
   * Method under test: {@link ServiceContainer#start()}
   */
  @Test
  public void testStart() {
    // Arrange
    RpcApiService service = mock(RpcApiService.class);
    doNothing().when(service).start();

    ServiceContainer serviceContainer = new ServiceContainer();
    serviceContainer.add(service);

    // Act
    serviceContainer.start();

    // Assert that nothing has changed
    verify(service).start();
  }

  /**
   * Method under test: {@link ServiceContainer#start()}
   */
  @Test
  public void testStart2() {
    // Arrange
    RpcApiService service = mock(RpcApiService.class);
    doNothing().when(service).start();

    ServiceContainer serviceContainer = new ServiceContainer();
    serviceContainer.add(new RpcApiService());
    serviceContainer.add(service);

    // Act
    serviceContainer.start();

    // Assert
    verify(service).start();
  }

  /**
   * Method under test: {@link ServiceContainer#stop()}
   */
  @Test
  public void testStop() {
    // Arrange
    RpcApiService service = mock(RpcApiService.class);
    doNothing().when(service).stop();

    ServiceContainer serviceContainer = new ServiceContainer();
    serviceContainer.add(service);

    // Act
    serviceContainer.stop();

    // Assert that nothing has changed
    verify(service).stop();
  }

  /**
   * Method under test: {@link ServiceContainer#stop()}
   */
  @Test
  public void testStop2() {
    // Arrange
    RpcApiService service = mock(RpcApiService.class);
    doNothing().when(service).stop();

    ServiceContainer serviceContainer = new ServiceContainer();
    serviceContainer.add(new RpcApiService());
    serviceContainer.add(service);

    // Act
    serviceContainer.stop();

    // Assert that nothing has changed
    verify(service).stop();
  }

  /**
   * Method under test: {@link ServiceContainer#blockUntilShutdown()}
   */
  @Test
  public void testBlockUntilShutdown() {
    // Arrange
    RpcApiService service = mock(RpcApiService.class);
    doNothing().when(service).blockUntilShutdown();

    ServiceContainer serviceContainer = new ServiceContainer();
    serviceContainer.add(service);

    // Act
    serviceContainer.blockUntilShutdown();

    // Assert that nothing has changed
    verify(service).blockUntilShutdown();
  }
}
