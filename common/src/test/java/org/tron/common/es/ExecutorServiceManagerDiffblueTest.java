package org.tron.common.es;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExecutorServiceManagerDiffblueTest {
  /**
   * Test {@link ExecutorServiceManager#newFixedThreadPool(String, int, boolean)} with {@code name}, {@code fixThreads}, {@code isDaemon}.
   * <ul>
   *   <li>Then return {@link ThreadPoolExecutor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExecutorServiceManager#newFixedThreadPool(String, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExecutorService ExecutorServiceManager.newFixedThreadPool(String, int, boolean)"})
  public void testNewFixedThreadPoolWithNameFixThreadsIsDaemon_thenReturnThreadPoolExecutor() {
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
   * Test {@link ExecutorServiceManager#newFixedThreadPool(String, int)} with {@code name}, {@code fixThreads}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@link ThreadPoolExecutor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExecutorServiceManager#newFixedThreadPool(String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExecutorService ExecutorServiceManager.newFixedThreadPool(String, int)"})
  public void testNewFixedThreadPoolWithNameFixThreads_whenName_thenReturnThreadPoolExecutor() {
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
   * Test {@link ExecutorServiceManager#newThreadPoolExecutor(int, int, long, TimeUnit, BlockingQueue, String)} with {@code corePoolSize}, {@code maximumPoolSize}, {@code keepAliveTime}, {@code unit}, {@code workQueue}, {@code name}.
   * <p>
   * Method under test: {@link ExecutorServiceManager#newThreadPoolExecutor(int, int, long, TimeUnit, BlockingQueue, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExecutorService ExecutorServiceManager.newThreadPoolExecutor(int, int, long, TimeUnit, BlockingQueue, String)"})
  public void testNewThreadPoolExecutorWithCorePoolSizeMaximumPoolSizeKeepAliveTimeUnitWorkQueueName() {
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
    assertSame(workQueue, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getQueue());
  }

  /**
   * Test {@link ExecutorServiceManager#newThreadPoolExecutor(int, int, long, TimeUnit, BlockingQueue, String, boolean)} with {@code corePoolSize}, {@code maximumPoolSize}, {@code keepAliveTime}, {@code unit}, {@code workQueue}, {@code name}, {@code isDaemon}.
   * <p>
   * Method under test: {@link ExecutorServiceManager#newThreadPoolExecutor(int, int, long, TimeUnit, BlockingQueue, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExecutorService ExecutorServiceManager.newThreadPoolExecutor(int, int, long, TimeUnit, BlockingQueue, String, boolean)"})
  public void testNewThreadPoolExecutorWithCorePoolSizeMaximumPoolSizeKeepAliveTimeUnitWorkQueueNameIsDaemon() {
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
    assertSame(workQueue, ((ThreadPoolExecutor) actualNewThreadPoolExecutorResult).getQueue());
  }
}
