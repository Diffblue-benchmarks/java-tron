package org.tron.common.application;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.ChainBaseManager;
import org.tron.core.config.args.Args;

public class ApplicationImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApplicationImpl#setOptions(Args)}
   *   <li>{@link ApplicationImpl#getChainBaseManager()}
   *   <li>{@link ApplicationImpl#getDbManager()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChainBaseManager ApplicationImpl.getChainBaseManager()",
    "org.tron.core.db.Manager ApplicationImpl.getDbManager()",
    "void ApplicationImpl.setOptions(Args)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ApplicationImpl applicationImpl = new ApplicationImpl();

    // Act
    applicationImpl.setOptions(new Args());
    ChainBaseManager actualChainBaseManager = applicationImpl.getChainBaseManager();

    // Assert
    assertNull(actualChainBaseManager);
    assertNull(applicationImpl.getDbManager());
  }
}
