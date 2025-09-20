package org.tron.common.utils;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.osgi.internal.container.EquinoxReentrantLock;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ALockDiffblueTest {
  /**
   * Test {@link ALock#close()}.
   *
   * <ul>
   *   <li>Given {@link EquinoxReentrantLock} {@link EquinoxReentrantLock#unlock()} does nothing.
   *   <li>Then calls {@link EquinoxReentrantLock#unlock()}.
   * </ul>
   *
   * <p>Method under test: {@link ALock#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ALock.close()"})
  public void testClose_givenEquinoxReentrantLockUnlockDoesNothing_thenCallsUnlock() {
    // Arrange
    EquinoxReentrantLock l = mock(EquinoxReentrantLock.class);
    doNothing().when(l).unlock();
    try (ALock aLock = new ALock(l)) {}

    // Act and Assert
    verify(l).unlock();
  }
}
