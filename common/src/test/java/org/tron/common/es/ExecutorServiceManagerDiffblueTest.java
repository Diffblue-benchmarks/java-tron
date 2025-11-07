package org.tron.common.es;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class ExecutorServiceManagerDiffblueTest {
  /**
   * Method under test:
   * {@link ExecutorServiceManager#newFixedThreadPool(String, int)}
   */
  @Test
  public void testNewFixedThreadPool() {
    // Arrange and Act
    ExecutorService actualNewFixedThreadPoolResult = ExecutorServiceManager.newFixedThreadPool("Name", 1);

    // Assert
    assertTrue(actualNewFixedThreadPoolResult instanceof ThreadPoolExecutor);
    assertEquals(0, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getActiveCount());
    assertEquals(0, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getLargestPoolSize());
    assertEquals(0, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getPoolSize());
    assertEquals(0L, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getCompletedTaskCount());
    assertEquals(0L, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getTaskCount());
    assertEquals(1, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getCorePoolSize());
    assertEquals(1, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getMaximumPoolSize());
    assertTrue(((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getQueue().isEmpty());
  }

  /**
   * Method under test:
   * {@link ExecutorServiceManager#newFixedThreadPool(String, int, boolean)}
   */
  @Test
  public void testNewFixedThreadPool2() {
    // Arrange and Act
    ExecutorService actualNewFixedThreadPoolResult = ExecutorServiceManager.newFixedThreadPool("Name", 1, true);

    // Assert
    assertTrue(actualNewFixedThreadPoolResult instanceof ThreadPoolExecutor);
    assertEquals(0, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getActiveCount());
    assertEquals(0, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getLargestPoolSize());
    assertEquals(0, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getPoolSize());
    assertEquals(0L, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getCompletedTaskCount());
    assertEquals(0L, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getTaskCount());
    assertEquals(1, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getCorePoolSize());
    assertEquals(1, ((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getMaximumPoolSize());
    assertTrue(((ThreadPoolExecutor) actualNewFixedThreadPoolResult).getQueue().isEmpty());
  }

  /**
   * Method under test:
   * {@link ExecutorServiceManager#newThreadPoolExecutor(int, int, long, TimeUnit, BlockingQueue, String)}
   */
  @Test
  public void testNewThreadPoolExecutor() {
    // Arrange
    LinkedBlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>();

    // Act
    ExecutorService actualNewThreadPoolExecutorResult = ExecutorServiceManager.newThreadPoolExecutor(3, 3, 1L,
        TimeUnit.NANOSECONDS, workQueue, "Name");

    // Assert
    assertTrue(actualNewThreadPoolExecutorResult instanceof ThreadPoolExecutor);
    assertEquals(0, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getActiveCount());
    assertEquals(0, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getLargestPoolSize());
    assertEquals(0, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getPoolSize());
    assertEquals(0L, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getCompletedTaskCount());
    assertEquals(0L, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getTaskCount());
    assertEquals(3, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getCorePoolSize());
    assertEquals(3, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getMaximumPoolSize());
    assertTrue(workQueue.isEmpty());
    BlockingQueue<Runnable> queue = ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getQueue();
    assertTrue(queue.isEmpty());
    assertSame(workQueue, queue);
  }

  /**
   * Method under test:
   * {@link ExecutorServiceManager#newThreadPoolExecutor(int, int, long, TimeUnit, BlockingQueue, String)}
   */
  @Test
  public void testNewThreadPoolExecutor2() {
    // Arrange
    LinkedBlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>();
    workQueue.add(mock(Runnable.class));

    // Act
    ExecutorService actualNewThreadPoolExecutorResult = ExecutorServiceManager.newThreadPoolExecutor(3, 3, 1L,
        TimeUnit.NANOSECONDS, workQueue, "Name");

    // Assert
    assertTrue(actualNewThreadPoolExecutorResult instanceof ThreadPoolExecutor);
    assertEquals(0, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getActiveCount());
    assertEquals(0, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getLargestPoolSize());
    assertEquals(0, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getPoolSize());
    assertEquals(0L, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getCompletedTaskCount());
    assertEquals(3, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getCorePoolSize());
    assertEquals(3, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getMaximumPoolSize());
    assertSame(workQueue, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getQueue());
  }

  /**
   * Method under test:
   * {@link ExecutorServiceManager#newThreadPoolExecutor(int, int, long, TimeUnit, BlockingQueue, String, boolean)}
   */
  @Test
  public void testNewThreadPoolExecutor3() {
    // Arrange
    LinkedBlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>();

    // Act
    ExecutorService actualNewThreadPoolExecutorResult = ExecutorServiceManager.newThreadPoolExecutor(3, 3, 1L,
        TimeUnit.NANOSECONDS, workQueue, "Name", true);

    // Assert
    assertTrue(actualNewThreadPoolExecutorResult instanceof ThreadPoolExecutor);
    assertEquals(0, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getActiveCount());
    assertEquals(0, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getLargestPoolSize());
    assertEquals(0, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getPoolSize());
    assertEquals(0L, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getCompletedTaskCount());
    assertEquals(0L, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getTaskCount());
    assertEquals(3, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getCorePoolSize());
    assertEquals(3, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getMaximumPoolSize());
    assertTrue(workQueue.isEmpty());
    BlockingQueue<Runnable> queue = ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getQueue();
    assertTrue(queue.isEmpty());
    assertSame(workQueue, queue);
  }

  /**
   * Method under test:
   * {@link ExecutorServiceManager#newThreadPoolExecutor(int, int, long, TimeUnit, BlockingQueue, String, boolean)}
   */
  @Test
  public void testNewThreadPoolExecutor4() {
    // Arrange
    LinkedBlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>();
    workQueue.add(mock(Runnable.class));

    // Act
    ExecutorService actualNewThreadPoolExecutorResult = ExecutorServiceManager.newThreadPoolExecutor(3, 3, 1L,
        TimeUnit.NANOSECONDS, workQueue, "Name", true);

    // Assert
    assertTrue(actualNewThreadPoolExecutorResult instanceof ThreadPoolExecutor);
    assertEquals(0, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getActiveCount());
    assertEquals(0, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getLargestPoolSize());
    assertEquals(0, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getPoolSize());
    assertEquals(0L, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getCompletedTaskCount());
    assertEquals(3, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getCorePoolSize());
    assertEquals(3, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getMaximumPoolSize());
    assertSame(workQueue, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getQueue());
  }
}
