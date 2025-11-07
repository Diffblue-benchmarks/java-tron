package org.tron.core.metrics.node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class NodeInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeInfo#equals(Object)}
   *   <li>{@link NodeInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");

    NodeInfo nodeInfo2 = new NodeInfo();
    nodeInfo2.setBackupStatus(1);
    nodeInfo2.setIp("127.0.0.1");
    nodeInfo2.setNodeType(1);
    nodeInfo2.setVersion("1.0.2");

    // Act and Assert
    assertEquals(nodeInfo, nodeInfo2);
    int expectedHashCodeResult = nodeInfo.hashCode();
    assertEquals(expectedHashCodeResult, nodeInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeInfo#equals(Object)}
   *   <li>{@link NodeInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp(null);
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");

    NodeInfo nodeInfo2 = new NodeInfo();
    nodeInfo2.setBackupStatus(1);
    nodeInfo2.setIp(null);
    nodeInfo2.setNodeType(1);
    nodeInfo2.setVersion("1.0.2");

    // Act and Assert
    assertEquals(nodeInfo, nodeInfo2);
    int expectedHashCodeResult = nodeInfo.hashCode();
    assertEquals(expectedHashCodeResult, nodeInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeInfo#equals(Object)}
   *   <li>{@link NodeInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion(null);

    NodeInfo nodeInfo2 = new NodeInfo();
    nodeInfo2.setBackupStatus(1);
    nodeInfo2.setIp("127.0.0.1");
    nodeInfo2.setNodeType(1);
    nodeInfo2.setVersion(null);

    // Act and Assert
    assertEquals(nodeInfo, nodeInfo2);
    int expectedHashCodeResult = nodeInfo.hashCode();
    assertEquals(expectedHashCodeResult, nodeInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeInfo#equals(Object)}
   *   <li>{@link NodeInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");

    // Act and Assert
    assertEquals(nodeInfo, nodeInfo);
    int expectedHashCodeResult = nodeInfo.hashCode();
    assertEquals(expectedHashCodeResult, nodeInfo.hashCode());
  }

  /**
   * Method under test: {@link NodeInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(3);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");

    NodeInfo nodeInfo2 = new NodeInfo();
    nodeInfo2.setBackupStatus(1);
    nodeInfo2.setIp("127.0.0.1");
    nodeInfo2.setNodeType(1);
    nodeInfo2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(nodeInfo, nodeInfo2);
  }

  /**
   * Method under test: {@link NodeInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("1.0.2");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");

    NodeInfo nodeInfo2 = new NodeInfo();
    nodeInfo2.setBackupStatus(1);
    nodeInfo2.setIp("127.0.0.1");
    nodeInfo2.setNodeType(1);
    nodeInfo2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(nodeInfo, nodeInfo2);
  }

  /**
   * Method under test: {@link NodeInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp(null);
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");

    NodeInfo nodeInfo2 = new NodeInfo();
    nodeInfo2.setBackupStatus(1);
    nodeInfo2.setIp("127.0.0.1");
    nodeInfo2.setNodeType(1);
    nodeInfo2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(nodeInfo, nodeInfo2);
  }

  /**
   * Method under test: {@link NodeInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(3);
    nodeInfo.setVersion("1.0.2");

    NodeInfo nodeInfo2 = new NodeInfo();
    nodeInfo2.setBackupStatus(1);
    nodeInfo2.setIp("127.0.0.1");
    nodeInfo2.setNodeType(1);
    nodeInfo2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(nodeInfo, nodeInfo2);
  }

  /**
   * Method under test: {@link NodeInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("127.0.0.1");

    NodeInfo nodeInfo2 = new NodeInfo();
    nodeInfo2.setBackupStatus(1);
    nodeInfo2.setIp("127.0.0.1");
    nodeInfo2.setNodeType(1);
    nodeInfo2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(nodeInfo, nodeInfo2);
  }

  /**
   * Method under test: {@link NodeInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion(null);

    NodeInfo nodeInfo2 = new NodeInfo();
    nodeInfo2.setBackupStatus(1);
    nodeInfo2.setIp("127.0.0.1");
    nodeInfo2.setNodeType(1);
    nodeInfo2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(nodeInfo, nodeInfo2);
  }

  /**
   * Method under test: {@link NodeInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(nodeInfo, null);
  }

  /**
   * Method under test: {@link NodeInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(nodeInfo, "Different type to NodeInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NodeInfo}
   *   <li>{@link NodeInfo#setBackupStatus(int)}
   *   <li>{@link NodeInfo#setIp(String)}
   *   <li>{@link NodeInfo#setNodeType(int)}
   *   <li>{@link NodeInfo#setVersion(String)}
   *   <li>{@link NodeInfo#toString()}
   *   <li>{@link NodeInfo#getBackupStatus()}
   *   <li>{@link NodeInfo#getIp()}
   *   <li>{@link NodeInfo#getNodeType()}
   *   <li>{@link NodeInfo#getVersion()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NodeInfo actualNodeInfo = new NodeInfo();
    actualNodeInfo.setBackupStatus(1);
    actualNodeInfo.setIp("127.0.0.1");
    actualNodeInfo.setNodeType(1);
    actualNodeInfo.setVersion("1.0.2");
    actualNodeInfo.toString();
    int actualBackupStatus = actualNodeInfo.getBackupStatus();
    actualNodeInfo.getIp();
    int actualNodeType = actualNodeInfo.getNodeType();

    // Assert that nothing has changed
    assertEquals("1.0.2", actualNodeInfo.getVersion());
    assertEquals(1, actualBackupStatus);
    assertEquals(1, actualNodeType);
  }
}
