package org.tron.common.prometheus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.prometheus.MetricKeys.Histogram;

public class MetricAspectDiffblueTest {
  /**
   * Test {@link MetricAspect#aroundAdviceMetricTime(ProceedingJoinPoint, MetricTime)}.
   *
   * <ul>
   *   <li>Given {@link Histogram#INTERNAL_SERVICE_LATENCY}.
   *   <li>Then return {@code Proceed}.
   * </ul>
   *
   * <p>Method under test: {@link MetricAspect#aroundAdviceMetricTime(ProceedingJoinPoint,
   * MetricTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricAspect.aroundAdviceMetricTime(ProceedingJoinPoint, MetricTime)"})
  public void testAroundAdviceMetricTime_givenInternal_service_latency_thenReturnProceed()
      throws Throwable {
    // Arrange
    MetricAspect metricAspect = new MetricAspect();

    Signature signature = mock(Signature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getDeclaringType()).thenReturn(forNameResult);

    ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
    when(pjp.proceed()).thenReturn("Proceed");
    when(pjp.getSignature()).thenReturn(signature);

    MetricTime metricTime = mock(MetricTime.class);
    when(metricTime.value()).thenReturn(Histogram.INTERNAL_SERVICE_LATENCY);

    // Act
    Object actualAroundAdviceMetricTimeResult =
        metricAspect.aroundAdviceMetricTime(pjp, metricTime);

    // Assert
    verify(pjp).getSignature();
    verify(pjp).proceed();
    verify(signature).getDeclaringType();
    verify(metricTime, atLeast(1)).value();
    assertEquals("Proceed", actualAroundAdviceMetricTimeResult);
  }

  /**
   * Test {@link MetricAspect#aroundAdviceMetricTime(ProceedingJoinPoint, MetricTime)}.
   *
   * <ul>
   *   <li>Given {@link Signature} {@link Signature#getName()} return {@code Name}.
   *   <li>Then return {@code Proceed}.
   * </ul>
   *
   * <p>Method under test: {@link MetricAspect#aroundAdviceMetricTime(ProceedingJoinPoint,
   * MetricTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricAspect.aroundAdviceMetricTime(ProceedingJoinPoint, MetricTime)"})
  public void testAroundAdviceMetricTime_givenSignatureGetNameReturnName_thenReturnProceed()
      throws Throwable {
    // Arrange
    MetricAspect metricAspect = new MetricAspect();

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
    Object actualAroundAdviceMetricTimeResult =
        metricAspect.aroundAdviceMetricTime(pjp, metricTime);

    // Assert
    verify(pjp, atLeast(1)).getSignature();
    verify(pjp).proceed();
    verify(signature).getDeclaringType();
    verify(signature).getName();
    verify(metricTime).value();
    assertEquals("Proceed", actualAroundAdviceMetricTimeResult);
  }

  /**
   * Test {@link MetricAspect#aroundAdviceMetricTime(ProceedingJoinPoint, MetricTime)}.
   *
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.
   *   <li>Then throw {@link Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link MetricAspect#aroundAdviceMetricTime(ProceedingJoinPoint,
   * MetricTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricAspect.aroundAdviceMetricTime(ProceedingJoinPoint, MetricTime)"})
  public void testAroundAdviceMetricTime_givenThrowable_thenThrowThrowable() throws Throwable {
    // Arrange
    MetricAspect metricAspect = new MetricAspect();

    Signature signature = mock(Signature.class);
    when(signature.getName()).thenReturn("Name");
    Class<Object> forNameResult = Object.class;
    when(signature.getDeclaringType()).thenReturn(forNameResult);

    ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
    when(pjp.proceed()).thenThrow(new Throwable());
    when(pjp.getSignature()).thenReturn(signature);

    MetricTime metricTime = mock(MetricTime.class);
    when(metricTime.value()).thenReturn("");

    // Act and Assert
    assertThrows(Throwable.class, () -> metricAspect.aroundAdviceMetricTime(pjp, metricTime));
    verify(pjp, atLeast(1)).getSignature();
    verify(pjp).proceed();
    verify(signature, atLeast(1)).getDeclaringType();
    verify(signature, atLeast(1)).getName();
    verify(metricTime, atLeast(1)).value();
  }

  /**
   * Test {@link MetricAspect#aroundAdviceMetricTime(ProceedingJoinPoint, MetricTime)}.
   *
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.
   *   <li>Then throw {@link Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link MetricAspect#aroundAdviceMetricTime(ProceedingJoinPoint,
   * MetricTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricAspect.aroundAdviceMetricTime(ProceedingJoinPoint, MetricTime)"})
  public void testAroundAdviceMetricTime_givenThrowable_thenThrowThrowable2() throws Throwable {
    // Arrange
    MetricAspect metricAspect = new MetricAspect();

    Signature signature = mock(Signature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getDeclaringType()).thenReturn(forNameResult);

    ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
    when(pjp.proceed()).thenThrow(new Throwable());
    when(pjp.getSignature()).thenReturn(signature);

    MetricTime metricTime = mock(MetricTime.class);
    when(metricTime.value()).thenReturn(Histogram.INTERNAL_SERVICE_LATENCY);

    // Act and Assert
    assertThrows(Throwable.class, () -> metricAspect.aroundAdviceMetricTime(pjp, metricTime));
    verify(pjp, atLeast(1)).getSignature();
    verify(pjp).proceed();
    verify(signature, atLeast(1)).getDeclaringType();
    verify(metricTime, atLeast(1)).value();
  }

  /**
   * Test {@link MetricAspect#walletAroundAdvice(ProceedingJoinPoint)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@code Proceed}.
   * </ul>
   *
   * <p>Method under test: {@link MetricAspect#walletAroundAdvice(ProceedingJoinPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricAspect.walletAroundAdvice(ProceedingJoinPoint)"})
  public void testWalletAroundAdvice_givenJavaLangObject_thenReturnProceed() throws Throwable {
    // Arrange
    MetricAspect metricAspect = new MetricAspect();

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
   * Test {@link MetricAspect#walletAroundAdvice(ProceedingJoinPoint)}.
   *
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.
   *   <li>Then throw {@link Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link MetricAspect#walletAroundAdvice(ProceedingJoinPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricAspect.walletAroundAdvice(ProceedingJoinPoint)"})
  public void testWalletAroundAdvice_givenThrowable_thenThrowThrowable() throws Throwable {
    // Arrange
    MetricAspect metricAspect = new MetricAspect();

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
