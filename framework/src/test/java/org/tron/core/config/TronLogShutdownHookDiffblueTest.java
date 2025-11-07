package org.tron.core.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.ContextBase;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.InfoStatus;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusManager;
import java.util.List;
import org.junit.Test;

public class TronLogShutdownHookDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link TronLogShutdownHook}
   */
  @Test
  public void testNewTronLogShutdownHook() {
    // Arrange and Act
    TronLogShutdownHook actualTronLogShutdownHook = new TronLogShutdownHook();

    // Assert
    assertNull(actualTronLogShutdownHook.getContext());
    assertNull(actualTronLogShutdownHook.getStatusManager());
  }

  /**
   * Method under test: {@link TronLogShutdownHook#run()}
   */
  @Test
  public void testRun() {
    // Arrange
    TronLogShutdownHook tronLogShutdownHook = new TronLogShutdownHook();

    // Act
    tronLogShutdownHook.run();

    // Assert
    assertNull(tronLogShutdownHook.getStatusManager());
  }

  /**
   * Method under test: {@link TronLogShutdownHook#run()}
   */
  @Test
  public void testRun2() {
    // Arrange
    TronLogShutdownHook tronLogShutdownHook = new TronLogShutdownHook();
    tronLogShutdownHook.addStatus(new ErrorStatus("Msg", "Origin"));

    // Act
    tronLogShutdownHook.run();

    // Assert
    assertNull(tronLogShutdownHook.getStatusManager());
  }

  /**
   * Method under test: {@link TronLogShutdownHook#run()}
   */
  @Test
  public void testRun3() {
    // Arrange
    TronLogShutdownHook tronLogShutdownHook = new TronLogShutdownHook();
    tronLogShutdownHook.setContext(new LoggerContext());
    tronLogShutdownHook.addStatus(new ErrorStatus("Msg", "Origin"));

    // Act
    tronLogShutdownHook.run();

    // Assert
    StatusManager statusManager = tronLogShutdownHook.getStatusManager();
    assertTrue(statusManager instanceof BasicStatusManager);
    List<Status> copyOfStatusList = statusManager.getCopyOfStatusList();
    assertEquals(2, copyOfStatusList.size());
    Status getResult = copyOfStatusList.get(1);
    assertTrue(getResult instanceof InfoStatus);
    assertEquals("Logback context being closed via shutdown hook", getResult.getMessage());
    assertNull(getResult.getThrowable());
    assertEquals(0, getResult.getEffectiveLevel());
    assertEquals(0, getResult.getLevel());
    assertEquals(2, statusManager.getCount());
    assertFalse(getResult.hasChildren());
    assertFalse(getResult.iterator().hasNext());
    assertSame(tronLogShutdownHook, getResult.getOrigin());
  }

  /**
   * Method under test: {@link TronLogShutdownHook#run()}
   */
  @Test
  public void testRun4() {
    // Arrange
    TronLogShutdownHook tronLogShutdownHook = new TronLogShutdownHook();
    tronLogShutdownHook.setContext(new ContextBase());
    tronLogShutdownHook.addStatus(new ErrorStatus("Msg", "Origin"));

    // Act
    tronLogShutdownHook.run();

    // Assert
    StatusManager statusManager = tronLogShutdownHook.getStatusManager();
    assertTrue(statusManager instanceof BasicStatusManager);
    List<Status> copyOfStatusList = statusManager.getCopyOfStatusList();
    assertEquals(2, copyOfStatusList.size());
    Status getResult = copyOfStatusList.get(1);
    assertTrue(getResult instanceof InfoStatus);
    assertEquals("Logback context being closed via shutdown hook", getResult.getMessage());
    assertNull(getResult.getThrowable());
    assertEquals(0, getResult.getEffectiveLevel());
    assertEquals(0, getResult.getLevel());
    assertEquals(2, statusManager.getCount());
    assertFalse(getResult.hasChildren());
    assertFalse(getResult.iterator().hasNext());
    assertSame(tronLogShutdownHook, getResult.getOrigin());
  }
}
