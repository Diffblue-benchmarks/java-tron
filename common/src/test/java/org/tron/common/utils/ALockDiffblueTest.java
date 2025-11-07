package org.tron.common.utils;

import static org.junit.Assert.assertSame;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

public class ALockDiffblueTest {
  /**
   * Method under test: {@link ALock#ALock(Lock)}
   */
  @Test
  public void testNewALock() {
    // Arrange and Act
    ALock actualALock = new ALock(new ReentrantLock());

    // Assert
    assertSame(actualALock, actualALock.lock());
  }

  /**
   * Method under test: {@link ALock#ALock(Lock)}
   */
  @Test
  public void testNewALock2() {
    // Arrange and Act
    ALock actualALock = new ALock(new ReentrantLock());

    // Assert
    assertSame(actualALock, actualALock.lock());
  }
}
