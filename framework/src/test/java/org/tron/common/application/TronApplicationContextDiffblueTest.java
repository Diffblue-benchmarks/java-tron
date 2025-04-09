package org.tron.common.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ProtocolResolver;

public class TronApplicationContextDiffblueTest {
  /**
   * Test {@link TronApplicationContext#TronApplicationContext()}.
   * <p>
   * Method under test: {@link TronApplicationContext#TronApplicationContext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronApplicationContext.<init>()"})
  public void testNewTronApplicationContext() {
    // Arrange and Act
    TronApplicationContext actualTronApplicationContext = new TronApplicationContext();

    // Assert
    Collection<ApplicationListener<?>> applicationListeners = actualTronApplicationContext.getApplicationListeners();
    assertTrue(applicationListeners instanceof Set);
    Collection<ProtocolResolver> protocolResolvers = actualTronApplicationContext.getProtocolResolvers();
    assertTrue(protocolResolvers instanceof Set);
    ConfigurableListableBeanFactory beanFactory = actualTronApplicationContext.getBeanFactory();
    assertTrue(beanFactory instanceof DefaultListableBeanFactory);
    assertTrue(actualTronApplicationContext.getEnvironment() instanceof StandardEnvironment);
    assertEquals("", actualTronApplicationContext.getApplicationName());
    assertNull(actualTronApplicationContext.getParentBeanFactory());
    assertNull(actualTronApplicationContext.getParent());
    assertEquals(0L, actualTronApplicationContext.getStartupDate());
    assertEquals(5, actualTronApplicationContext.getBeanDefinitionCount());
    assertEquals(5, actualTronApplicationContext.getBeanDefinitionNames().length);
    assertFalse(actualTronApplicationContext.isActive());
    assertFalse(actualTronApplicationContext.isRunning());
    assertTrue(applicationListeners.isEmpty());
    assertTrue(protocolResolvers.isEmpty());
    assertTrue(actualTronApplicationContext.getBeanFactoryPostProcessors().isEmpty());
    assertSame(beanFactory, actualTronApplicationContext.getDefaultListableBeanFactory());
  }

  /**
   * Test {@link TronApplicationContext#TronApplicationContext(Class[])}.
   * <p>
   * Method under test: {@link TronApplicationContext#TronApplicationContext(Class[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronApplicationContext.<init>(Class[])"})
  public void testNewTronApplicationContext2() throws IllegalStateException {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    TronApplicationContext actualTronApplicationContext = new TronApplicationContext(forNameResult);

    // Assert
    Collection<ApplicationListener<?>> applicationListeners = actualTronApplicationContext.getApplicationListeners();
    assertTrue(applicationListeners instanceof Set);
    Collection<ProtocolResolver> protocolResolvers = actualTronApplicationContext.getProtocolResolvers();
    assertTrue(protocolResolvers instanceof Set);
    AutowireCapableBeanFactory autowireCapableBeanFactory = actualTronApplicationContext
        .getAutowireCapableBeanFactory();
    assertTrue(autowireCapableBeanFactory instanceof DefaultListableBeanFactory);
    assertTrue(actualTronApplicationContext.getEnvironment() instanceof StandardEnvironment);
    assertEquals("", actualTronApplicationContext.getApplicationName());
    assertNull(actualTronApplicationContext.getParentBeanFactory());
    assertNull(actualTronApplicationContext.getParent());
    assertEquals(6, actualTronApplicationContext.getBeanDefinitionCount());
    assertEquals(6, actualTronApplicationContext.getBeanDefinitionNames().length);
    assertTrue(applicationListeners.isEmpty());
    assertTrue(protocolResolvers.isEmpty());
    assertTrue(actualTronApplicationContext.getBeanFactoryPostProcessors().isEmpty());
    assertTrue(actualTronApplicationContext.isActive());
    assertTrue(actualTronApplicationContext.isRunning());
    assertSame(autowireCapableBeanFactory, actualTronApplicationContext.getBeanFactory());
    assertSame(autowireCapableBeanFactory, actualTronApplicationContext.getDefaultListableBeanFactory());
  }

  /**
   * Test {@link TronApplicationContext#TronApplicationContext(String[])}.
   * <p>
   * Method under test: {@link TronApplicationContext#TronApplicationContext(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronApplicationContext.<init>(String[])"})
  public void testNewTronApplicationContext3() throws IllegalStateException {
    // Arrange and Act
    TronApplicationContext actualTronApplicationContext = new TronApplicationContext("java.text");

    // Assert
    Collection<ApplicationListener<?>> applicationListeners = actualTronApplicationContext.getApplicationListeners();
    assertTrue(applicationListeners instanceof Set);
    Collection<ProtocolResolver> protocolResolvers = actualTronApplicationContext.getProtocolResolvers();
    assertTrue(protocolResolvers instanceof Set);
    AutowireCapableBeanFactory autowireCapableBeanFactory = actualTronApplicationContext
        .getAutowireCapableBeanFactory();
    assertTrue(autowireCapableBeanFactory instanceof DefaultListableBeanFactory);
    assertTrue(actualTronApplicationContext.getEnvironment() instanceof StandardEnvironment);
    assertEquals("", actualTronApplicationContext.getApplicationName());
    assertNull(actualTronApplicationContext.getParentBeanFactory());
    assertNull(actualTronApplicationContext.getParent());
    assertEquals(5, actualTronApplicationContext.getBeanDefinitionCount());
    assertEquals(5, actualTronApplicationContext.getBeanDefinitionNames().length);
    assertTrue(applicationListeners.isEmpty());
    assertTrue(protocolResolvers.isEmpty());
    assertTrue(actualTronApplicationContext.getBeanFactoryPostProcessors().isEmpty());
    assertTrue(actualTronApplicationContext.isActive());
    assertTrue(actualTronApplicationContext.isRunning());
    assertSame(autowireCapableBeanFactory, actualTronApplicationContext.getBeanFactory());
    assertSame(autowireCapableBeanFactory, actualTronApplicationContext.getDefaultListableBeanFactory());
  }
}
