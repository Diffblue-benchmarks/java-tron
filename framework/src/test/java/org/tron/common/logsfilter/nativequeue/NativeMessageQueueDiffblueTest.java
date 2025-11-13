package org.tron.common.logsfilter.nativequeue;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;

@RunWith(MockitoJUnitRunner.class)
public class NativeMessageQueueDiffblueTest {
  @InjectMocks private NativeMessageQueue nativeMessageQueue;

  @Mock private Socket socket;

  @Mock private ZContext zContext;

  /**
   * Test {@link NativeMessageQueue#stop()}.
   *
   * <ul>
   *   <li>Given {@link Socket} {@link Socket#close()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link NativeMessageQueue#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NativeMessageQueue.stop()"})
  public void testStop_givenSocketCloseThrowRuntimeException_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(socket).close();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> nativeMessageQueue.stop());
    verify(socket).close();
  }

  /**
   * Test {@link NativeMessageQueue#stop()}.
   *
   * <ul>
   *   <li>Given {@link ZContext} {@link ZContext#close()} does nothing.
   *   <li>Then calls {@link ZContext#close()}.
   * </ul>
   *
   * <p>Method under test: {@link NativeMessageQueue#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NativeMessageQueue.stop()"})
  public void testStop_givenZContextCloseDoesNothing_thenCallsClose() {
    // Arrange
    doNothing().when(zContext).close();
    doNothing().when(socket).close();

    // Act
    nativeMessageQueue.stop();

    // Assert
    verify(zContext).close();
    verify(socket).close();
  }

  /**
   * Test {@link NativeMessageQueue#stop()}.
   *
   * <ul>
   *   <li>Given {@link ZContext} {@link ZContext#close()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link NativeMessageQueue#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NativeMessageQueue.stop()"})
  public void testStop_givenZContextCloseThrowRuntimeException_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(zContext).close();
    doNothing().when(socket).close();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> nativeMessageQueue.stop());
    verify(zContext).close();
    verify(socket).close();
  }

  /**
   * Test {@link NativeMessageQueue#publishTrigger(String, String)}.
   *
   * <ul>
   *   <li>Given {@link Socket} {@link Socket#sendMore(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link Socket#sendMore(String)}.
   * </ul>
   *
   * <p>Method under test: {@link NativeMessageQueue#publishTrigger(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NativeMessageQueue.publishTrigger(String, String)"})
  public void testPublishTrigger_givenSocketSendMoreThrowRuntimeException_thenCallsSendMore() {
    // Arrange
    when(zContext.isClosed()).thenReturn(false);
    when(socket.sendMore(Mockito.<String>any())).thenThrow(new RuntimeException());

    // Act
    nativeMessageQueue.publishTrigger("Data", "Topic");

    // Assert
    verify(zContext).isClosed();
    verify(socket).sendMore("Topic");
  }

  /**
   * Test {@link NativeMessageQueue#publishTrigger(String, String)}.
   *
   * <ul>
   *   <li>Given {@link Socket} {@link Socket#send(String)} return {@code true}.
   *   <li>Then calls {@link Socket#send(String)}.
   * </ul>
   *
   * <p>Method under test: {@link NativeMessageQueue#publishTrigger(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NativeMessageQueue.publishTrigger(String, String)"})
  public void testPublishTrigger_givenSocketSendReturnTrue_thenCallsSend() {
    // Arrange
    when(zContext.isClosed()).thenReturn(false);
    when(socket.send(Mockito.<String>any())).thenReturn(true);
    when(socket.sendMore(Mockito.<String>any())).thenReturn(true);

    // Act
    nativeMessageQueue.publishTrigger("Data", "Topic");

    // Assert
    verify(zContext).isClosed();
    verify(socket).send("Data");
    verify(socket).sendMore("Topic");
  }

  /**
   * Test {@link NativeMessageQueue#publishTrigger(String, String)}.
   *
   * <ul>
   *   <li>Given {@link ZContext} {@link ZContext#isClosed()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NativeMessageQueue#publishTrigger(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NativeMessageQueue.publishTrigger(String, String)"})
  public void testPublishTrigger_givenZContextIsClosedReturnTrue() {
    // Arrange
    when(zContext.isClosed()).thenReturn(true);

    // Act
    nativeMessageQueue.publishTrigger("Data", "Topic");

    // Assert
    verify(zContext).isClosed();
  }

  /**
   * Test {@link NativeMessageQueue#publishTrigger(String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link NativeMessageQueue#publishTrigger(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NativeMessageQueue.publishTrigger(String, String)"})
  public void testPublishTrigger_thenThrowRuntimeException() {
    // Arrange
    when(zContext.isClosed()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> nativeMessageQueue.publishTrigger("Data", "Topic"));
    verify(zContext).isClosed();
  }
}
