package org.tron.core.vm.program.listener;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.mockito.Mockito;

public class CompositeProgramListenerDiffblueTest {
  /**
   * Method under test: {@link CompositeProgramListener#onMemoryExtend(int)}
   */
  @Test
  public void testOnMemoryExtend() {
    // Arrange
    ProgramListenerAdaptor listener = mock(ProgramListenerAdaptor.class);
    doNothing().when(listener).onMemoryExtend(anyInt());

    CompositeProgramListener compositeProgramListener = new CompositeProgramListener();
    compositeProgramListener.addListener(listener);

    // Act
    compositeProgramListener.onMemoryExtend(2);

    // Assert that nothing has changed
    verify(listener).onMemoryExtend(eq(2));
  }

  /**
   * Method under test:
   * {@link CompositeProgramListener#onMemoryWrite(int, byte[], int)}
   */
  @Test
  public void testOnMemoryWrite() throws UnsupportedEncodingException {
    // Arrange
    ProgramListenerAdaptor listener = mock(ProgramListenerAdaptor.class);
    doNothing().when(listener).onMemoryWrite(anyInt(), Mockito.<byte[]>any(), anyInt());

    CompositeProgramListener compositeProgramListener = new CompositeProgramListener();
    compositeProgramListener.addListener(listener);

    // Act
    compositeProgramListener.onMemoryWrite(19088743, "AXAXAXAX".getBytes("UTF-8"), 3);

    // Assert that nothing has changed
    verify(listener).onMemoryWrite(eq(19088743), isA(byte[].class), eq(3));
  }

  /**
   * Method under test: {@link CompositeProgramListener#onStackPop()}
   */
  @Test
  public void testOnStackPop() {
    // Arrange
    ProgramListenerAdaptor listener = mock(ProgramListenerAdaptor.class);
    doNothing().when(listener).onStackPop();

    CompositeProgramListener compositeProgramListener = new CompositeProgramListener();
    compositeProgramListener.addListener(listener);

    // Act
    compositeProgramListener.onStackPop();

    // Assert that nothing has changed
    verify(listener).onStackPop();
  }

  /**
   * Method under test: {@link CompositeProgramListener#onStackSwap(int, int)}
   */
  @Test
  public void testOnStackSwap() {
    // Arrange
    ProgramListenerAdaptor listener = mock(ProgramListenerAdaptor.class);
    doNothing().when(listener).onStackSwap(anyInt(), anyInt());

    CompositeProgramListener compositeProgramListener = new CompositeProgramListener();
    compositeProgramListener.addListener(listener);

    // Act
    compositeProgramListener.onStackSwap(1, 1);

    // Assert that nothing has changed
    verify(listener).onStackSwap(eq(1), eq(1));
  }

  /**
   * Method under test: {@link CompositeProgramListener#onStorageClear()}
   */
  @Test
  public void testOnStorageClear() {
    // Arrange
    ProgramListenerAdaptor listener = mock(ProgramListenerAdaptor.class);
    doNothing().when(listener).onStorageClear();

    CompositeProgramListener compositeProgramListener = new CompositeProgramListener();
    compositeProgramListener.addListener(listener);

    // Act
    compositeProgramListener.onStorageClear();

    // Assert that nothing has changed
    verify(listener).onStorageClear();
  }

  /**
   * Method under test:
   * {@link CompositeProgramListener#addListener(ProgramListener)}
   */
  @Test
  public void testAddListener() {
    // Arrange
    CompositeProgramListener compositeProgramListener = new CompositeProgramListener();
    CompositeProgramListener listener = new CompositeProgramListener();

    // Act
    compositeProgramListener.addListener(listener);

    // Assert
    assertTrue(listener.isEmpty());
  }

  /**
   * Method under test:
   * {@link CompositeProgramListener#addListener(ProgramListener)}
   */
  @Test
  public void testAddListener2() {
    // Arrange
    CompositeProgramListener compositeProgramListener = new CompositeProgramListener();

    // Act
    compositeProgramListener.addListener(mock(ProgramListenerAdaptor.class));

    // Assert
    assertFalse(compositeProgramListener.isEmpty());
  }

  /**
   * Method under test: {@link CompositeProgramListener#isEmpty()}
   */
  @Test
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new CompositeProgramListener()).isEmpty());
  }

  /**
   * Method under test: {@link CompositeProgramListener#isEmpty()}
   */
  @Test
  public void testIsEmpty2() {
    // Arrange
    CompositeProgramListener compositeProgramListener = new CompositeProgramListener();
    compositeProgramListener.addListener(new CompositeProgramListener());

    // Act and Assert
    assertFalse(compositeProgramListener.isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link CompositeProgramListener}
   */
  @Test
  public void testNewCompositeProgramListener() {
    // Arrange, Act and Assert
    assertTrue((new CompositeProgramListener()).isEmpty());
  }
}
