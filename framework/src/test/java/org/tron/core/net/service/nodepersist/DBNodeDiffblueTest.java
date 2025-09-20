package org.tron.core.net.service.nodepersist;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DBNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DBNode#DBNode()}
   *   <li>{@link DBNode#setHost(String)}
   *   <li>{@link DBNode#setPort(int)}
   *   <li>{@link DBNode#getHost()}
   *   <li>{@link DBNode#getPort()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DBNode.<init>()",
    "void DBNode.<init>(String, int)",
    "String DBNode.getHost()",
    "int DBNode.getPort()",
    "void DBNode.setHost(String)",
    "void DBNode.setPort(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DBNode actualDbNode = new DBNode();
    actualDbNode.setHost("localhost");
    actualDbNode.setPort(8080);
    String actualHost = actualDbNode.getHost();

    // Assert
    assertEquals("localhost", actualHost);
    assertEquals(8080, actualDbNode.getPort());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code localhost}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DBNode#DBNode(String, int)}
   *   <li>{@link DBNode#setHost(String)}
   *   <li>{@link DBNode#setPort(int)}
   *   <li>{@link DBNode#getHost()}
   *   <li>{@link DBNode#getPort()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DBNode.<init>()",
    "void DBNode.<init>(String, int)",
    "String DBNode.getHost()",
    "int DBNode.getPort()",
    "void DBNode.setHost(String)",
    "void DBNode.setPort(int)"
  })
  public void testGettersAndSetters_whenLocalhost() {
    // Arrange and Act
    DBNode actualDbNode = new DBNode("localhost", 8080);
    actualDbNode.setHost("localhost");
    actualDbNode.setPort(8080);
    String actualHost = actualDbNode.getHost();

    // Assert
    assertEquals("localhost", actualHost);
    assertEquals(8080, actualDbNode.getPort());
  }
}
