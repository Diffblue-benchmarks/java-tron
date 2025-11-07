package org.tron.common.prometheus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MetricAspect.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MetricAspectDiffblueTest {
  @Autowired
  private MetricAspect metricAspect;

  /**
   * Method under test:
   * {@link MetricAspect#aroundAdviceMetricTime(ProceedingJoinPoint, MetricTime)}
   */
  @Test
  public void testAroundAdviceMetricTime() throws Throwable {
    // Arrange
    Signature signature = mock(Signature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getDeclaringType()).thenReturn(forNameResult);
    ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
    when(pjp.proceed()).thenReturn("Proceed");
    when(pjp.getSignature()).thenReturn(signature);
    MetricTime metricTime = mock(MetricTime.class);
    when(metricTime.value()).thenReturn("42");

    // Act
    Object actualAroundAdviceMetricTimeResult = metricAspect.aroundAdviceMetricTime(pjp, metricTime);

    // Assert
    verify(pjp).getSignature();
    verify(pjp).proceed();
    verify(signature).getDeclaringType();
    verify(metricTime, atLeast(1)).value();
    assertEquals("Proceed", actualAroundAdviceMetricTimeResult);
  }

  /**
   * Method under test:
   * {@link MetricAspect#aroundAdviceMetricTime(ProceedingJoinPoint, MetricTime)}
   */
  @Test
  public void testAroundAdviceMetricTime2() throws Throwable {
    // Arrange
    Signature signature = mock(Signature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getDeclaringType()).thenReturn(forNameResult);
    ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
    when(pjp.proceed()).thenThrow(new Throwable());
    when(pjp.getSignature()).thenReturn(signature);
    MetricTime metricTime = mock(MetricTime.class);
    when(metricTime.value()).thenReturn("42");

    // Act and Assert
    assertThrows(Throwable.class, () -> metricAspect.aroundAdviceMetricTime(pjp, metricTime));
    verify(pjp, atLeast(1)).getSignature();
    verify(pjp).proceed();
    verify(signature, atLeast(1)).getDeclaringType();
    verify(metricTime, atLeast(1)).value();
  }

  /**
   * Method under test:
   * {@link MetricAspect#aroundAdviceMetricTime(ProceedingJoinPoint, MetricTime)}
   */
  @Test
  public void testAroundAdviceMetricTime3() throws Throwable {
    // Arrange
    Signature signature = mock(Signature.class);
    when(signature.getName()).thenReturn("Name");
    Class<Object> forNameResult = Object.class;
    when(signature.getDeclaringType()).thenReturn(forNameResult);
    ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
    when(pjp.proceed()).thenReturn("Proceed");
    when(pjp.getSignature()).thenReturn(signature);
    MetricTime metricTime = mock(MetricTime.class);
    when(metricTime.value()).thenReturn("");

    // Act
    Object actualAroundAdviceMetricTimeResult = metricAspect.aroundAdviceMetricTime(pjp, metricTime);

    // Assert
    verify(pjp, atLeast(1)).getSignature();
    verify(pjp).proceed();
    verify(signature).getDeclaringType();
    verify(signature).getName();
    verify(metricTime).value();
    assertEquals("Proceed", actualAroundAdviceMetricTimeResult);
  }

  /**
   * Method under test:
   * {@link MetricAspect#walletAroundAdvice(ProceedingJoinPoint)}
   */
  @Test
  public void testWalletAroundAdvice() throws Throwable {
    // Arrange
    Signature signature = mock(Signature.class);
    when(signature.getName()).thenReturn("Name");
    Class<Object> forNameResult = Object.class;
    when(signature.getDeclaringType()).thenReturn(forNameResult);
    ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
    when(pjp.proceed()).thenReturn("Proceed");
    when(pjp.getSignature()).thenReturn(signature);

    // Act
    Object actualWalletAroundAdviceResult = metricAspect.walletAroundAdvice(pjp);

    // Assert
    verify(pjp, atLeast(1)).getSignature();
    verify(pjp).proceed();
    verify(signature).getDeclaringType();
    verify(signature).getName();
    assertEquals("Proceed", actualWalletAroundAdviceResult);
  }

  /**
   * Method under test:
   * {@link MetricAspect#walletAroundAdvice(ProceedingJoinPoint)}
   */
  @Test
  public void testWalletAroundAdvice2() throws Throwable {
    // Arrange
    Signature signature = mock(Signature.class);
    when(signature.getName()).thenReturn("Name");
    Class<Object> forNameResult = Object.class;
    when(signature.getDeclaringType()).thenReturn(forNameResult);
    ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
    when(pjp.proceed()).thenThrow(new Throwable());
    when(pjp.getSignature()).thenReturn(signature);

    // Act and Assert
    assertThrows(Throwable.class, () -> metricAspect.walletAroundAdvice(pjp));
    verify(pjp, atLeast(1)).getSignature();
    verify(pjp).proceed();
    verify(signature, atLeast(1)).getDeclaringType();
    verify(signature, atLeast(1)).getName();
  }
}
