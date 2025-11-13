package org.tron.common.application;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class ApplicationFactoryDiffblueTest {
  /**
   * Test {@link ApplicationFactory#create(ApplicationContext)}.
   *
   * <p>Method under test: {@link ApplicationFactory#create(ApplicationContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Application ApplicationFactory.create(ApplicationContext)"})
  public void testCreate() throws BeansException {
    // Arrange
    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(ApplicationImpl.class)).thenReturn(new ApplicationImpl());

    // Act
    Application actualCreateResult = ApplicationFactory.create(ctx);

    // Assert
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualCreateResult instanceof ApplicationImpl);
    assertNull(actualCreateResult.getChainBaseManager());
    assertNull(actualCreateResult.getDbManager());
  }

  /**
   * Test {@link ApplicationFactory#createApplication()}.
   *
   * <p>Method under test: {@link ApplicationFactory#createApplication()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Application ApplicationFactory.createApplication()"})
  public void testCreateApplication() {
    // Arrange and Act
    Application actualCreateApplicationResult = new ApplicationFactory().createApplication();

    // Assert
    assertTrue(actualCreateApplicationResult instanceof ApplicationImpl);
    assertNull(actualCreateApplicationResult.getChainBaseManager());
    assertNull(actualCreateApplicationResult.getDbManager());
  }
}
