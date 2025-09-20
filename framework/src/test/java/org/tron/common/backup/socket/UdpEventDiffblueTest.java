package org.tron.common.backup.socket;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.backup.message.KeepAliveMessage;
import org.tron.common.backup.message.Message;

public class UdpEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UdpEvent#UdpEvent(Message, InetSocketAddress)}
   *   <li>{@link UdpEvent#setMessage(Message)}
   *   <li>{@link UdpEvent#getAddress()}
   *   <li>{@link UdpEvent#getMessage()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UdpEvent.<init>(Message, InetSocketAddress)",
    "InetSocketAddress UdpEvent.getAddress()",
    "Message UdpEvent.getMessage()",
    "void UdpEvent.setAddress(InetSocketAddress)",
    "void UdpEvent.setMessage(Message)"
  })
  public void testGettersAndSetters() {
    // Arrange
    KeepAliveMessage message = new KeepAliveMessage(true, 1);
    InetSocketAddress address = InetSocketAddress.createUnresolved("foo", 1);

    // Act
    UdpEvent actualUdpEvent = new UdpEvent(message, address);
    KeepAliveMessage message2 = new KeepAliveMessage(true, 1);
    actualUdpEvent.setMessage(message2);
    InetSocketAddress actualAddress = actualUdpEvent.getAddress();

    // Assert
    assertSame(message2, actualUdpEvent.getMessage());
    assertSame(address, actualAddress);
  }
}
