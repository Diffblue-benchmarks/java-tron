package org.tron.core.net.peer;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.context.ApplicationContext;
import org.tron.p2p.connection.Channel;

public class PeerManagerDiffblueTest {
  /**
   * Test {@link PeerManager#add(ApplicationContext, Channel)}.
   *
   * <ul>
   *   <li>When {@link ApplicationContext}.
   *   <li>Then throw {@link NullPointerException}.
   * </ul>
   *
   * <p>Method under test: {@link PeerManager#add(ApplicationContext, Channel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.tron.core.net.peer.PeerConnection PeerManager.add(ApplicationContext, Channel)"
  })
  public void testAdd_whenApplicationContext_thenThrowNullPointerException() {
    // Arrange
    ApplicationContext ctx = mock(ApplicationContext.class);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> PeerManager.add(ctx, new Channel()));
  }
}
