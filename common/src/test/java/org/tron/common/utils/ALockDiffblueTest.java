package org.tron.common.utils;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ALockDiffblueTest {
  /**
   * Test {@link ALock#ALock(Lock)}.
   * <p>
   * Method under test: {@link ALock#ALock(Lock)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ALock.<init>(Lock)"})
  public void testNewALock() {
    // Arrange and Act
    ALock actualALock = new ALock(new ReentrantLock());

    // Assert
    assertSame(actualALock, actualALock.lock());
  }

  /**
   * Test {@link ALock#ALock(Lock)}.
   * <p>
   * Method under test: {@link ALock#ALock(Lock)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ALock.<init>(Lock)"})
  public void testNewALock2() {
    // Arrange and Act
    ALock actualALock = new ALock(new ReentrantLock());

    // Assert
    assertSame(actualALock, actualALock.lock());
  }
}
