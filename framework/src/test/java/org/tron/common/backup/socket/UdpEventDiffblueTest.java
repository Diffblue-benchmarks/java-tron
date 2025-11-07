package org.tron.common.backup.socket;

import static org.junit.Assert.assertSame;
import java.net.InetSocketAddress;
import org.junit.Test;
import org.tron.common.backup.message.KeepAliveMessage;
import org.tron.common.backup.message.Message;

public class UdpEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UdpEvent#UdpEvent(Message, InetSocketAddress)}
   *   <li>{@link UdpEvent#setAddress(InetSocketAddress)}
   *   <li>{@link UdpEvent#setMessage(Message)}
   *   <li>{@link UdpEvent#getAddress()}
   *   <li>{@link UdpEvent#getMessage()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    KeepAliveMessage message = new KeepAliveMessage(true, 1);

    // Act
    UdpEvent actualUdpEvent = new UdpEvent(message, InetSocketAddress.createUnresolved("foo", 1));
    InetSocketAddress address = InetSocketAddress.createUnresolved("foo", 1);
    actualUdpEvent.setAddress(address);
    KeepAliveMessage message2 = new KeepAliveMessage(true, 1);

    actualUdpEvent.setMessage(message2);
    InetSocketAddress actualAddress = actualUdpEvent.getAddress();

    // Assert that nothing has changed
    assertSame(message2, actualUdpEvent.getMessage());
    assertSame(address, actualAddress);
  }
}
