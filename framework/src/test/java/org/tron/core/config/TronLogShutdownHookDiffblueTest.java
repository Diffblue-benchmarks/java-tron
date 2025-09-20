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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TronLogShutdownHookDiffblueTest {
  /**
   * Test new {@link TronLogShutdownHook} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TronLogShutdownHook}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronLogShutdownHook.<init>()"})
  public void testNewTronLogShutdownHook() {
    // Arrange and Act
    TronLogShutdownHook actualTronLogShutdownHook = new TronLogShutdownHook();

    // Assert
    assertNull(actualTronLogShutdownHook.getContext());
    assertNull(actualTronLogShutdownHook.getStatusManager());
  }

  /**
   * Test {@link TronLogShutdownHook#run()}.
   *
   * <ul>
   *   <li>Given {@link TronLogShutdownHook} (default constructor) Context is {@link ContextBase}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TronLogShutdownHook#run()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronLogShutdownHook.run()"})
  public void testRun_givenTronLogShutdownHookContextIsContextBase() {
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

  /**
   * Test {@link TronLogShutdownHook#run()}.
   *
   * <ul>
   *   <li>Then {@link TronLogShutdownHook} (default constructor) StatusManager {@link
   *       BasicStatusManager}.
   * </ul>
   *
   * <p>Method under test: {@link TronLogShutdownHook#run()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronLogShutdownHook.run()"})
  public void testRun_thenTronLogShutdownHookStatusManagerBasicStatusManager() {
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
}
