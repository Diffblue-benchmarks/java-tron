package org.tron.core.net.service.nodepersist;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DBNodeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DBNode#DBNode()}
   *   <li>{@link DBNode#setHost(String)}
   *   <li>{@link DBNode#setPort(int)}
   *   <li>{@link DBNode#getHost()}
   *   <li>{@link DBNode#getPort()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DBNode actualDbNode = new DBNode();
    actualDbNode.setHost("localhost");
    actualDbNode.setPort(8080);
    String actualHost = actualDbNode.getHost();

    // Assert that nothing has changed
    assertEquals("localhost", actualHost);
    assertEquals(8080, actualDbNode.getPort());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DBNode#DBNode(String, int)}
   *   <li>{@link DBNode#setHost(String)}
   *   <li>{@link DBNode#setPort(int)}
   *   <li>{@link DBNode#getHost()}
   *   <li>{@link DBNode#getPort()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    DBNode actualDbNode = new DBNode("localhost", 8080);
    actualDbNode.setHost("localhost");
    actualDbNode.setPort(8080);
    String actualHost = actualDbNode.getHost();

    // Assert that nothing has changed
    assertEquals("localhost", actualHost);
    assertEquals(8080, actualDbNode.getPort());
  }
}
