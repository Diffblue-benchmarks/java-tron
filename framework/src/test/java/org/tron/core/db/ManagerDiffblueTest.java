package org.tron.core.db;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.ChainBaseManager;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class ManagerDiffblueTest {
  @Mock private ChainBaseManager chainBaseManager;

  @InjectMocks private Manager manager;

  @Mock private RevokingDatabase revokingDatabase;

  /**
   * Test {@link Manager#close()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#shutdown()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Manager#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.close()"})
  public void testClose_givenChainBaseManagerShutdownThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException()).when(chainBaseManager).shutdown();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.close());
    verify(chainBaseManager).shutdown();
  }

  /**
   * Test {@link Manager#close()}.
   *
   * <ul>
   *   <li>Given {@link RevokingDatabase} {@link RevokingDatabase#shutdown()} does nothing.
   *   <li>Then calls {@link RevokingDatabase#shutdown()}.
   * </ul>
   *
   * <p>Method under test: {@link Manager#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.close()"})
  public void testClose_givenRevokingDatabaseShutdownDoesNothing_thenCallsShutdown() {
    // Arrange
    doNothing().when(chainBaseManager).shutdown();
    doNothing().when(revokingDatabase).shutdown();

    // Act
    manager.close();

    // Assert
    verify(chainBaseManager).shutdown();
    verify(revokingDatabase).shutdown();
  }

  /**
   * Test {@link Manager#close()}.
   *
   * <ul>
   *   <li>Given {@link RevokingDatabase} {@link RevokingDatabase#shutdown()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Manager#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.close()"})
  public void testClose_givenRevokingDatabaseShutdownThrowIllegalArgumentException() {
    // Arrange
    doNothing().when(chainBaseManager).shutdown();
    doThrow(new IllegalArgumentException()).when(revokingDatabase).shutdown();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.close());
    verify(chainBaseManager).shutdown();
    verify(revokingDatabase).shutdown();
  }
}
