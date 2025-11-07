package org.tron.common.log.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.ContextBase;
import ch.qos.logback.core.Layout;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusListener;
import ch.qos.logback.core.status.StatusManager;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;

public class MultiLayoutPatternDiffblueTest {
  /**
   * Method under test:
   * {@link MultiLayoutPattern#addRule(MultiLayoutPattern.Rule)}
   */
  @Test
  public void testAddRule() {
    // Arrange
    MultiLayoutPattern multiLayoutPattern = new MultiLayoutPattern();
    MultiLayoutPattern.Rule rule = new MultiLayoutPattern.Rule();

    // Act
    multiLayoutPattern.addRule(rule);

    // Assert
    PatternLayoutEncoder patternLayoutEncoder = rule.getPatternLayoutEncoder();
    Layout<ILoggingEvent> layout = patternLayoutEncoder.getLayout();
    assertTrue(layout instanceof PatternLayout);
    Map<String, String> defaultConverterMap = ((PatternLayout) layout).getDefaultConverterMap();
    assertEquals(62, defaultConverterMap.size());
    assertEquals("ch.qos.logback.classic.pattern.DateConverter", defaultConverterMap.get("date"));
    assertEquals("ch.qos.logback.classic.pattern.MessageConverter", defaultConverterMap.get("msg"));
    assertEquals("ch.qos.logback.classic.pattern.ThrowableProxyConverter", defaultConverterMap.get("exception"));
    assertEquals("text/plain", layout.getContentType());
    assertNull(layout.getContext());
    assertNull(multiLayoutPattern.getContext());
    assertNull(patternLayoutEncoder.getContext());
    assertNull(multiLayoutPattern.getStatusManager());
    assertNull(patternLayoutEncoder.getStatusManager());
    assertNull(((PatternLayout) layout).getStatusManager());
    assertNull(layout.getFileFooter());
    assertNull(layout.getFileHeader());
    assertNull(layout.getPresentationFooter());
    assertNull(layout.getPresentationHeader());
    assertNull(((PatternLayout) layout).getPattern());
    assertNull(patternLayoutEncoder.getPattern());
    assertNull(patternLayoutEncoder.getCharset());
    assertFalse(patternLayoutEncoder.isStarted());
    assertFalse(((PatternLayout) layout).isOutputPatternAsHeader());
    assertFalse(patternLayoutEncoder.isOutputPatternAsHeader());
    assertFalse(patternLayoutEncoder.isOutputPatternAsPresentationHeader());
    assertFalse(layout.isStarted());
    assertTrue(((PatternLayout) layout).getInstanceConverterMap().isEmpty());
    assertEquals(defaultConverterMap, ((PatternLayout) layout).getEffectiveConverterMap());
  }

  /**
   * Method under test:
   * {@link MultiLayoutPattern#addRule(MultiLayoutPattern.Rule)}
   */
  @Test
  public void testAddRule2() {
    // Arrange
    MultiLayoutPattern multiLayoutPattern = new MultiLayoutPattern();
    LoggerContext context = new LoggerContext();
    multiLayoutPattern.setContext(context);

    MultiLayoutPattern.Rule rule = new MultiLayoutPattern.Rule();
    rule.setPattern("42");

    // Act
    multiLayoutPattern.addRule(rule);

    // Assert
    PatternLayoutEncoder patternLayoutEncoder = rule.getPatternLayoutEncoder();
    Layout<ILoggingEvent> layout = patternLayoutEncoder.getLayout();
    assertTrue(layout instanceof PatternLayout);
    StatusManager statusManager = patternLayoutEncoder.getStatusManager();
    assertTrue(statusManager instanceof BasicStatusManager);
    assertEquals("42", ((PatternLayout) layout).getPattern());
    assertEquals("42", patternLayoutEncoder.getPattern());
    Map<String, String> defaultConverterMap = ((PatternLayout) layout).getDefaultConverterMap();
    assertEquals(62, defaultConverterMap.size());
    assertEquals("ch.qos.logback.classic.pattern.DateConverter", defaultConverterMap.get("date"));
    assertEquals("ch.qos.logback.classic.pattern.MessageConverter", defaultConverterMap.get("msg"));
    assertEquals("ch.qos.logback.classic.pattern.ThrowableProxyConverter", defaultConverterMap.get("exception"));
    assertEquals("text/plain", layout.getContentType());
    assertNull(layout.getFileFooter());
    assertNull(layout.getFileHeader());
    assertNull(layout.getPresentationFooter());
    assertNull(layout.getPresentationHeader());
    assertNull(patternLayoutEncoder.getCharset());
    assertEquals(0, ((BasicStatusManager) statusManager).getLevel());
    assertEquals(0, statusManager.getCount());
    assertFalse(patternLayoutEncoder.isStarted());
    assertFalse(((PatternLayout) layout).isOutputPatternAsHeader());
    assertFalse(patternLayoutEncoder.isOutputPatternAsHeader());
    assertFalse(patternLayoutEncoder.isOutputPatternAsPresentationHeader());
    assertTrue(layout.isStarted());
    assertTrue(statusManager.getCopyOfStatusList().isEmpty());
    assertTrue(statusManager.getCopyOfStatusListenerList().isEmpty());
    assertTrue(((PatternLayout) layout).getInstanceConverterMap().isEmpty());
    assertEquals(defaultConverterMap, ((PatternLayout) layout).getEffectiveConverterMap());
    assertSame(context, layout.getContext());
    assertSame(context, multiLayoutPattern.getContext());
    assertSame(context, patternLayoutEncoder.getContext());
    assertSame(statusManager, multiLayoutPattern.getStatusManager());
    assertSame(statusManager, ((PatternLayout) layout).getStatusManager());
  }

  /**
   * Method under test: {@link MultiLayoutPattern#encode(ILoggingEvent)}
   */
  @Test
  public void testEncode() {
    // Arrange
    MultiLayoutPattern multiLayoutPattern = new MultiLayoutPattern();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> multiLayoutPattern.encode(new LoggingEvent()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MultiLayoutPattern.Rule}
   *   <li>{@link MultiLayoutPattern.Rule#setLogger(String)}
   *   <li>{@link MultiLayoutPattern.Rule#setOutputPatternAsHeader(boolean)}
   *   <li>{@link MultiLayoutPattern.Rule#setPattern(String)}
   *   <li>{@link MultiLayoutPattern.Rule#getLogger()}
   *   <li>{@link MultiLayoutPattern.Rule#getPattern()}
   *   <li>{@link MultiLayoutPattern.Rule#getPatternLayoutEncoder()}
   *   <li>{@link MultiLayoutPattern.Rule#isOutputPatternAsHeader()}
   * </ul>
   */
  @Test
  public void testRuleGettersAndSetters() {
    // Arrange and Act
    MultiLayoutPattern.Rule actualRule = new MultiLayoutPattern.Rule();
    actualRule.setLogger("Logger");
    actualRule.setOutputPatternAsHeader(true);
    actualRule.setPattern("Pattern");
    String actualLogger = actualRule.getLogger();
    String actualPattern = actualRule.getPattern();
    actualRule.getPatternLayoutEncoder();

    // Assert that nothing has changed
    assertEquals("Logger", actualLogger);
    assertEquals("Pattern", actualPattern);
    assertTrue(actualRule.isOutputPatternAsHeader());
  }

  /**
   * Method under test: {@link MultiLayoutPattern.Rule#start(Context)}
   */
  @Test
  public void testRuleStart() {
    // Arrange
    MultiLayoutPattern.Rule rule = new MultiLayoutPattern.Rule();
    LoggerContext context = new LoggerContext();

    // Act
    rule.start(context);

    // Assert
    StatusManager statusManager = context.getStatusManager();
    List<Status> copyOfStatusList = statusManager.getCopyOfStatusList();
    assertEquals(1, copyOfStatusList.size());
    Status getResult = copyOfStatusList.get(0);
    Object origin = getResult.getOrigin();
    assertTrue(origin instanceof PatternLayout);
    assertTrue(statusManager instanceof BasicStatusManager);
    assertTrue(getResult instanceof ErrorStatus);
    assertEquals("Empty or null pattern.", getResult.getMessage());
    Map<String, String> defaultConverterMap = ((PatternLayout) origin).getDefaultConverterMap();
    assertEquals(62, defaultConverterMap.size());
    assertEquals("ch.qos.logback.classic.pattern.DateConverter", defaultConverterMap.get("date"));
    assertEquals("ch.qos.logback.classic.pattern.MessageConverter", defaultConverterMap.get("msg"));
    assertEquals("text/plain", ((PatternLayout) origin).getContentType());
    assertNull(((PatternLayout) origin).getFileFooter());
    assertNull(((PatternLayout) origin).getFileHeader());
    assertNull(((PatternLayout) origin).getPresentationFooter());
    assertNull(((PatternLayout) origin).getPattern());
    assertNull(((PatternLayout) origin).getPresentationHeader());
    PatternLayoutEncoder patternLayoutEncoder = rule.getPatternLayoutEncoder();
    assertNull(patternLayoutEncoder.getPattern());
    assertNull(getResult.getThrowable());
    assertNull(patternLayoutEncoder.getCharset());
    assertEquals(1, statusManager.getCount());
    assertEquals(2, ((BasicStatusManager) statusManager).getLevel());
    assertEquals(2, getResult.getEffectiveLevel());
    assertEquals(2, getResult.getLevel());
    assertFalse(((PatternLayout) origin).isStarted());
    assertFalse(patternLayoutEncoder.isStarted());
    assertFalse(((PatternLayout) origin).isOutputPatternAsHeader());
    assertFalse(patternLayoutEncoder.isOutputPatternAsHeader());
    assertFalse(patternLayoutEncoder.isOutputPatternAsPresentationHeader());
    assertFalse(getResult.hasChildren());
    assertFalse(getResult.iterator().hasNext());
    assertTrue(((PatternLayout) origin).getInstanceConverterMap().isEmpty());
    assertEquals(defaultConverterMap, ((PatternLayout) origin).getEffectiveConverterMap());
    assertSame(context, ((PatternLayout) origin).getContext());
    assertSame(context, patternLayoutEncoder.getContext());
    assertSame(origin, patternLayoutEncoder.getLayout());
    assertSame(statusManager, patternLayoutEncoder.getStatusManager());
    assertSame(statusManager, ((PatternLayout) origin).getStatusManager());
  }

  /**
   * Method under test: {@link MultiLayoutPattern.Rule#start(Context)}
   */
  @Test
  public void testRuleStart2() {
    // Arrange
    MultiLayoutPattern.Rule rule = new MultiLayoutPattern.Rule();
    rule.setPattern("Pattern");
    LoggerContext context = new LoggerContext();

    // Act
    rule.start(context);

    // Assert
    PatternLayoutEncoder patternLayoutEncoder = rule.getPatternLayoutEncoder();
    Layout<ILoggingEvent> layout = patternLayoutEncoder.getLayout();
    assertTrue(layout instanceof PatternLayout);
    StatusManager statusManager = context.getStatusManager();
    assertTrue(statusManager instanceof BasicStatusManager);
    assertEquals("Pattern", ((PatternLayout) layout).getPattern());
    assertEquals("Pattern", patternLayoutEncoder.getPattern());
    Map<String, String> defaultConverterMap = ((PatternLayout) layout).getDefaultConverterMap();
    assertEquals(62, defaultConverterMap.size());
    assertEquals("ch.qos.logback.classic.pattern.DateConverter", defaultConverterMap.get("date"));
    assertEquals("ch.qos.logback.classic.pattern.MessageConverter", defaultConverterMap.get("msg"));
    assertEquals("ch.qos.logback.classic.pattern.ThrowableProxyConverter", defaultConverterMap.get("exception"));
    assertEquals("text/plain", layout.getContentType());
    assertNull(layout.getFileFooter());
    assertNull(layout.getFileHeader());
    assertNull(layout.getPresentationFooter());
    assertNull(layout.getPresentationHeader());
    assertNull(patternLayoutEncoder.getCharset());
    assertEquals(0, ((BasicStatusManager) statusManager).getLevel());
    assertEquals(0, statusManager.getCount());
    assertFalse(patternLayoutEncoder.isStarted());
    assertFalse(((PatternLayout) layout).isOutputPatternAsHeader());
    assertFalse(patternLayoutEncoder.isOutputPatternAsHeader());
    assertFalse(patternLayoutEncoder.isOutputPatternAsPresentationHeader());
    assertTrue(layout.isStarted());
    assertTrue(statusManager.getCopyOfStatusList().isEmpty());
    assertTrue(((PatternLayout) layout).getInstanceConverterMap().isEmpty());
    assertEquals(defaultConverterMap, ((PatternLayout) layout).getEffectiveConverterMap());
    assertSame(context, layout.getContext());
    assertSame(context, patternLayoutEncoder.getContext());
    assertSame(statusManager, patternLayoutEncoder.getStatusManager());
    assertSame(statusManager, ((PatternLayout) layout).getStatusManager());
  }

  /**
   * Method under test: {@link MultiLayoutPattern.Rule#start(Context)}
   */
  @Test
  public void testRuleStart3() {
    // Arrange
    MultiLayoutPattern.Rule rule = new MultiLayoutPattern.Rule();
    rule.setPattern("");
    StatusListener listener = mock(StatusListener.class);
    doNothing().when(listener).addStatusEvent(Mockito.<Status>any());
    StatusListener listener2 = mock(StatusListener.class);
    doNothing().when(listener2).addStatusEvent(Mockito.<Status>any());

    BasicStatusManager statusManager = new BasicStatusManager();
    statusManager.add(listener2);
    statusManager.add(new ErrorStatus("Msg", "Origin"));
    statusManager.add(listener);

    ContextBase context = new ContextBase();
    context.setStatusManager(statusManager);

    // Act
    rule.start(context);

    // Assert
    verify(listener).addStatusEvent(isA(Status.class));
    verify(listener2, atLeast(1)).addStatusEvent(Mockito.<Status>any());
    PatternLayoutEncoder patternLayoutEncoder = rule.getPatternLayoutEncoder();
    assertEquals("", patternLayoutEncoder.getPattern());
    assertNull(patternLayoutEncoder.getCharset());
    assertFalse(patternLayoutEncoder.isStarted());
    assertFalse(patternLayoutEncoder.isOutputPatternAsHeader());
    assertFalse(patternLayoutEncoder.isOutputPatternAsPresentationHeader());
    assertSame(statusManager, context.getStatusManager());
    assertSame(statusManager, patternLayoutEncoder.getStatusManager());
    assertSame(context, patternLayoutEncoder.getContext());
  }

  /**
   * Method under test: {@link MultiLayoutPattern#start()}
   */
  @Test
  public void testStart() {
    // Arrange
    MultiLayoutPattern multiLayoutPattern = new MultiLayoutPattern();

    // Act
    multiLayoutPattern.start();

    // Assert
    Layout<ILoggingEvent> layout = multiLayoutPattern.getLayout();
    assertTrue(layout instanceof PatternLayout);
    Map<String, String> defaultConverterMap = ((PatternLayout) layout).getDefaultConverterMap();
    assertEquals(62, defaultConverterMap.size());
    assertEquals("ch.qos.logback.classic.pattern.DateConverter", defaultConverterMap.get("date"));
    assertEquals("ch.qos.logback.classic.pattern.MessageConverter", defaultConverterMap.get("msg"));
    assertEquals("ch.qos.logback.classic.pattern.NopThrowableInformationConverter", defaultConverterMap.get("nopex"));
    assertEquals("ch.qos.logback.classic.pattern.ThrowableProxyConverter", defaultConverterMap.get("exception"));
    assertEquals("text/plain", layout.getContentType());
    assertNull(layout.getContext());
    assertNull(((PatternLayout) layout).getStatusManager());
    assertNull(layout.getFileFooter());
    assertNull(layout.getFileHeader());
    assertNull(layout.getPresentationFooter());
    assertNull(layout.getPresentationHeader());
    assertNull(((PatternLayout) layout).getPattern());
    assertFalse(((PatternLayout) layout).isOutputPatternAsHeader());
    assertFalse(layout.isStarted());
    assertTrue(((PatternLayout) layout).getInstanceConverterMap().isEmpty());
    assertEquals(defaultConverterMap, ((PatternLayout) layout).getEffectiveConverterMap());
  }

  /**
   * Method under test: {@link MultiLayoutPattern#start()}
   */
  @Test
  public void testStart2() {
    // Arrange
    MultiLayoutPattern multiLayoutPattern = new MultiLayoutPattern();
    LoggerContext context = new LoggerContext();
    multiLayoutPattern.setContext(context);
    multiLayoutPattern.setPattern("Pattern");

    // Act
    multiLayoutPattern.start();

    // Assert
    Layout<ILoggingEvent> layout = multiLayoutPattern.getLayout();
    assertTrue(layout instanceof PatternLayout);
    assertEquals("Pattern", ((PatternLayout) layout).getPattern());
    Map<String, String> defaultConverterMap = ((PatternLayout) layout).getDefaultConverterMap();
    assertEquals(62, defaultConverterMap.size());
    assertEquals("ch.qos.logback.classic.pattern.DateConverter", defaultConverterMap.get("date"));
    assertEquals("ch.qos.logback.classic.pattern.MessageConverter", defaultConverterMap.get("msg"));
    assertEquals("ch.qos.logback.classic.pattern.NopThrowableInformationConverter", defaultConverterMap.get("nopex"));
    assertEquals("ch.qos.logback.classic.pattern.ThrowableProxyConverter", defaultConverterMap.get("exception"));
    assertEquals("text/plain", layout.getContentType());
    assertNull(layout.getFileFooter());
    assertNull(layout.getFileHeader());
    assertNull(layout.getPresentationFooter());
    assertNull(layout.getPresentationHeader());
    assertFalse(((PatternLayout) layout).isOutputPatternAsHeader());
    assertTrue(layout.isStarted());
    assertTrue(((PatternLayout) layout).getInstanceConverterMap().isEmpty());
    assertEquals(defaultConverterMap, ((PatternLayout) layout).getEffectiveConverterMap());
    assertSame(context, layout.getContext());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link MultiLayoutPattern}
   */
  @Test
  public void testNewMultiLayoutPattern() {
    // Arrange and Act
    MultiLayoutPattern actualMultiLayoutPattern = new MultiLayoutPattern();

    // Assert
    assertNull(actualMultiLayoutPattern.getContext());
    assertNull(actualMultiLayoutPattern.getLayout());
    assertNull(actualMultiLayoutPattern.getStatusManager());
    assertNull(actualMultiLayoutPattern.getPattern());
    assertNull(actualMultiLayoutPattern.getCharset());
    assertFalse(actualMultiLayoutPattern.isStarted());
    assertFalse(actualMultiLayoutPattern.isOutputPatternAsHeader());
    assertFalse(actualMultiLayoutPattern.isOutputPatternAsPresentationHeader());
  }
}
