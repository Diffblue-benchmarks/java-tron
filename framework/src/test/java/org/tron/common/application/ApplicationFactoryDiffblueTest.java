package org.tron.common.application;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationFactoryDiffblueTest {
  /**
   * Method under test: {@link ApplicationFactory#create(ApplicationContext)}
   */
  @Test
  public void testCreate() throws BeansException {
    // Arrange
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<ApplicationImpl>>any())).thenReturn(new ApplicationImpl());

    // Act
    Application actualCreateResult = ApplicationFactory.create(ctx);

    // Assert
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualCreateResult instanceof ApplicationImpl);
    assertNull(actualCreateResult.getChainBaseManager());
    assertNull(actualCreateResult.getDbManager());
  }

  /**
   * Method under test: {@link ApplicationFactory#createApplication()}
   */
  @Test
  public void testCreateApplication() {
    // Arrange and Act
    Application actualCreateApplicationResult = (new ApplicationFactory()).createApplication();

    // Assert
    assertTrue(actualCreateApplicationResult instanceof ApplicationImpl);
    assertNull(actualCreateApplicationResult.getChainBaseManager());
    assertNull(actualCreateApplicationResult.getDbManager());
  }
}
