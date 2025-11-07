package org.tron.core.net.message.handshake;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.tron.p2p.discover.Node;

public class HelloMessageDiffblueTest {
  /**
   * Method under test: {@link HelloMessage#getVersion()}
   */
  @Test
  public void testGetVersion() throws Exception {
    // Arrange, Act and Assert
    assertEquals(0, (new HelloMessage(new byte[]{})).getVersion());
  }

  /**
   * Method under test: {@link HelloMessage#getNodeType()}
   */
  @Test
  public void testGetNodeType() throws Exception {
    // Arrange, Act and Assert
    assertEquals(0, (new HelloMessage(new byte[]{})).getNodeType());
  }

  /**
   * Method under test: {@link HelloMessage#getLowestBlockNum()}
   */
  @Test
  public void testGetLowestBlockNum() throws Exception {
    // Arrange, Act and Assert
    assertEquals(0L, (new HelloMessage(new byte[]{})).getLowestBlockNum());
  }

  /**
   * Method under test: {@link HelloMessage#getTimestamp()}
   */
  @Test
  public void testGetTimestamp() throws Exception {
    // Arrange, Act and Assert
    assertEquals(0L, (new HelloMessage(new byte[]{})).getTimestamp());
  }

  /**
   * Method under test: {@link HelloMessage#getFrom()}
   */
  @Test
  public void testGetFrom() throws Exception {
    // Arrange and Act
    Node actualFrom = (new HelloMessage(new byte[]{})).getFrom();

    // Assert
    assertEquals("", actualFrom.getHexId());
    assertEquals("", actualFrom.getIdString());
    assertEquals("Node{ hostV4='null', hostV6='null', port=0}", actualFrom.format());
    assertNull(actualFrom.getHostV4());
    assertNull(actualFrom.getHostV6());
    assertNull(actualFrom.getInetSocketAddressV4());
    assertNull(actualFrom.getInetSocketAddressV6());
    assertNull(actualFrom.getPreferInetSocketAddress());
    assertEquals(0, actualFrom.getPort());
    assertEquals(0, actualFrom.getId().length);
  }

  /**
   * Method under test: {@link HelloMessage#valid()}
   */
  @Test
  public void testValid() throws Exception {
    // Arrange, Act and Assert
    assertFalse((new HelloMessage(new byte[]{})).valid());
  }
}
