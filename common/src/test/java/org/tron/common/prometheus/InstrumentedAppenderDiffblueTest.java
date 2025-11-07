package org.tron.common.prometheus;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import org.junit.Test;

public class InstrumentedAppenderDiffblueTest {
  /**
   * Method under test: {@link InstrumentedAppender#append(ILoggingEvent)}
   */
  @Test
  public void testAppend() {
    // Arrange
    InstrumentedAppender instrumentedAppender = new InstrumentedAppender();
    LoggingEvent event = mock(LoggingEvent.class);
    when(event.getLevel()).thenReturn(Level.fromLocationAwareLoggerInteger(0));

    // Act
    instrumentedAppender.append(event);

    // Assert that nothing has changed
    verify(event).getLevel();
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link InstrumentedAppender}
   */
  @Test
  public void testNewInstrumentedAppender() {
    // Arrange and Act
    InstrumentedAppender actualInstrumentedAppender = new InstrumentedAppender();

    // Assert
    assertNull(actualInstrumentedAppender.getContext());
    assertNull(actualInstrumentedAppender.getStatusManager());
    assertNull(actualInstrumentedAppender.getName());
    assertFalse(actualInstrumentedAppender.isStarted());
    assertTrue(actualInstrumentedAppender.getCopyOfAttachedFiltersList().isEmpty());
  }
}
