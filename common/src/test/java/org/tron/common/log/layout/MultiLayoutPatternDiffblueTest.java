package org.tron.common.log.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.Layout;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusManager;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.log.layout.MultiLayoutPattern.Rule;

public class MultiLayoutPatternDiffblueTest {
  /**
   * Test {@link MultiLayoutPattern#addRule(Rule)}.
   *
   * <ul>
   *   <li>Then {@link Rule} (default constructor) PatternLayoutEncoder Context {@link
   *       LoggerContext}.
   * </ul>
   *
   * <p>Method under test: {@link MultiLayoutPattern#addRule(Rule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiLayoutPattern.addRule(Rule)"})
  public void testAddRule_thenRulePatternLayoutEncoderContextLoggerContext() {
    // Arrange
    MultiLayoutPattern multiLayoutPattern = new MultiLayoutPattern();
    LoggerContext context = new LoggerContext();
    multiLayoutPattern.setContext(context);

    Rule rule = new Rule();
    rule.setPattern("42");

    // Act
    multiLayoutPattern.addRule(rule);

    // Assert
    PatternLayoutEncoder patternLayoutEncoder = rule.getPatternLayoutEncoder();
    Context context2 = patternLayoutEncoder.getContext();
    assertTrue(context2 instanceof LoggerContext);
    StatusManager statusManager = patternLayoutEncoder.getStatusManager();
    assertTrue(statusManager instanceof BasicStatusManager);
    assertEquals("42", patternLayoutEncoder.getPattern());
    assertSame(context, multiLayoutPattern.getContext());
    assertSame(context, context2);
    assertSame(statusManager, multiLayoutPattern.getStatusManager());
  }

  /**
   * Test {@link MultiLayoutPattern#addRule(Rule)}.
   *
   * <ul>
   *   <li>When {@link Rule} (default constructor).
   *   <li>Then {@link Rule} (default constructor) PatternLayoutEncoder Layout {@link
   *       PatternLayout}.
   * </ul>
   *
   * <p>Method under test: {@link MultiLayoutPattern#addRule(Rule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiLayoutPattern.addRule(Rule)"})
  public void testAddRule_whenRule_thenRulePatternLayoutEncoderLayoutPatternLayout() {
    // Arrange
    MultiLayoutPattern multiLayoutPattern = new MultiLayoutPattern();
    Rule rule = new Rule();

    // Act
    multiLayoutPattern.addRule(rule);

    // Assert
    PatternLayoutEncoder patternLayoutEncoder = rule.getPatternLayoutEncoder();
    Layout<ILoggingEvent> layout = patternLayoutEncoder.getLayout();
    assertTrue(layout instanceof PatternLayout);
    assertNull(layout.getContext());
    assertNull(multiLayoutPattern.getContext());
    assertNull(patternLayoutEncoder.getContext());
    assertNull(multiLayoutPattern.getStatusManager());
    assertNull(patternLayoutEncoder.getStatusManager());
    assertNull(((PatternLayout) layout).getStatusManager());
    assertNull(((PatternLayout) layout).getPattern());
    assertNull(patternLayoutEncoder.getPattern());
    assertFalse(layout.isStarted());
  }

  /**
   * Test {@link MultiLayoutPattern#encode(ILoggingEvent)} with {@code ILoggingEvent}.
   *
   * <ul>
   *   <li>When {@link LoggingEvent#LoggingEvent()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MultiLayoutPattern#encode(ILoggingEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MultiLayoutPattern.encode(ILoggingEvent)"})
  public void testEncodeWithILoggingEvent_whenLoggingEvent_thenThrowIllegalArgumentException() {
    // Arrange
    MultiLayoutPattern multiLayoutPattern = new MultiLayoutPattern();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> multiLayoutPattern.encode(new LoggingEvent()));
  }

  /**
   * Test Rule getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Rule}
   *   <li>{@link Rule#setLogger(String)}
   *   <li>{@link Rule#setOutputPatternAsHeader(boolean)}
   *   <li>{@link Rule#setPattern(String)}
   *   <li>{@link Rule#getLogger()}
   *   <li>{@link Rule#getPattern()}
   *   <li>{@link Rule#getPatternLayoutEncoder()}
   *   <li>{@link Rule#isOutputPatternAsHeader()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Rule.<init>()",
    "String Rule.getLogger()",
    "String Rule.getPattern()",
    "PatternLayoutEncoder Rule.getPatternLayoutEncoder()",
    "boolean Rule.isOutputPatternAsHeader()",
    "void Rule.setLogger(String)",
    "void Rule.setOutputPatternAsHeader(boolean)",
    "void Rule.setPattern(String)"
  })
  public void testRuleGettersAndSetters() {
    // Arrange and Act
    Rule actualRule = new Rule();
    actualRule.setLogger("Logger");
    actualRule.setOutputPatternAsHeader(true);
    actualRule.setPattern("Pattern");
    String actualLogger = actualRule.getLogger();
    String actualPattern = actualRule.getPattern();
    PatternLayoutEncoder actualPatternLayoutEncoder = actualRule.getPatternLayoutEncoder();

    // Assert
    assertEquals("Logger", actualLogger);
    assertEquals("Pattern", actualPattern);
    assertNull(actualPatternLayoutEncoder);
    assertTrue(actualRule.isOutputPatternAsHeader());
  }

  /**
   * Test Rule {@link Rule#start(Context)}.
   *
   * <ul>
   *   <li>Given {@link Rule} (default constructor).
   *   <li>Then {@link LoggerContext} (default constructor) StatusManager CopyOfStatusList size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link Rule#start(Context)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Rule.start(Context)"})
  public void testRuleStart_givenRule_thenLoggerContextStatusManagerCopyOfStatusListSizeIsOne() {
    // Arrange
    Rule rule = new Rule();
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
    PatternLayoutEncoder patternLayoutEncoder = rule.getPatternLayoutEncoder();
    assertNull(patternLayoutEncoder.getPattern());
    assertNull(getResult.getThrowable());
    assertEquals(1, statusManager.getCount());
    assertEquals(2, ((BasicStatusManager) statusManager).getLevel());
    assertEquals(2, getResult.getEffectiveLevel());
    assertEquals(2, getResult.getLevel());
    assertFalse(getResult.hasChildren());
    assertFalse(getResult.iterator().hasNext());
    assertSame(origin, patternLayoutEncoder.getLayout());
  }

  /**
   * Test Rule {@link Rule#start(Context)}.
   *
   * <ul>
   *   <li>Then {@link Rule} (default constructor) PatternLayoutEncoder Layout {@link
   *       PatternLayout}.
   * </ul>
   *
   * <p>Method under test: {@link Rule#start(Context)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Rule.start(Context)"})
  public void testRuleStart_thenRulePatternLayoutEncoderLayoutPatternLayout() {
    // Arrange
    Rule rule = new Rule();
    rule.setPattern("Pattern");
    LoggerContext context = new LoggerContext();

    // Act
    rule.start(context);

    // Assert
    PatternLayoutEncoder patternLayoutEncoder = rule.getPatternLayoutEncoder();
    assertTrue(patternLayoutEncoder.getLayout() instanceof PatternLayout);
    StatusManager statusManager = context.getStatusManager();
    assertTrue(statusManager instanceof BasicStatusManager);
    assertEquals("Pattern", patternLayoutEncoder.getPattern());
    assertEquals(0, ((BasicStatusManager) statusManager).getLevel());
    assertEquals(0, statusManager.getCount());
    assertTrue(statusManager.getCopyOfStatusList().isEmpty());
  }

  /**
   * Test {@link MultiLayoutPattern#start()}.
   *
   * <ul>
   *   <li>Given {@link MultiLayoutPattern} (default constructor).
   *   <li>Then {@link MultiLayoutPattern} (default constructor) Layout Context is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiLayoutPattern#start()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiLayoutPattern.start()"})
  public void testStart_givenMultiLayoutPattern_thenMultiLayoutPatternLayoutContextIsNull() {
    // Arrange
    MultiLayoutPattern multiLayoutPattern = new MultiLayoutPattern();

    // Act
    multiLayoutPattern.start();

    // Assert
    Layout<ILoggingEvent> layout = multiLayoutPattern.getLayout();
    assertTrue(layout instanceof PatternLayout);
    assertNull(layout.getContext());
    assertNull(((PatternLayout) layout).getStatusManager());
    assertNull(((PatternLayout) layout).getPattern());
    assertFalse(layout.isStarted());
  }

  /**
   * Test {@link MultiLayoutPattern#start()}.
   *
   * <ul>
   *   <li>Then {@link MultiLayoutPattern} (default constructor) Layout Pattern is {@code Pattern}.
   * </ul>
   *
   * <p>Method under test: {@link MultiLayoutPattern#start()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiLayoutPattern.start()"})
  public void testStart_thenMultiLayoutPatternLayoutPatternIsPattern() {
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
    assertTrue(layout.isStarted());
    assertSame(context, layout.getContext());
  }

  /**
   * Test new {@link MultiLayoutPattern} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MultiLayoutPattern}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiLayoutPattern.<init>()"})
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
