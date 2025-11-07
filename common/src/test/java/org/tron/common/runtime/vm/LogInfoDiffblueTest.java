package org.tron.common.runtime.vm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import ch.qos.logback.core.util.COWArrayList;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class LogInfoDiffblueTest {
  /**
   * Method under test: {@link LogInfo#getHexTopics()}
   */
  @Test
  public void testGetHexTopics() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();

    // Act and Assert
    assertTrue((new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"))).getHexTopics().isEmpty());
  }

  /**
   * Method under test: {@link LogInfo#getHexTopics()}
   */
  @Test
  public void testGetHexTopics2() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    List<String> actualHexTopics = (new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"))).getHexTopics();

    // Assert
    assertEquals(1, actualHexTopics.size());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", actualHexTopics.get(0));
  }

  /**
   * Method under test: {@link LogInfo#getClonedTopics()}
   */
  @Test
  public void testGetClonedTopics() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();

    // Act and Assert
    assertTrue((new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"))).getClonedTopics().isEmpty());
  }

  /**
   * Method under test: {@link LogInfo#getClonedTopics()}
   */
  @Test
  public void testGetClonedTopics2() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    List<byte[]> actualClonedTopics = (new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"))).getClonedTopics();

    // Assert
    assertEquals(1, actualClonedTopics.size());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualClonedTopics.get(0));
  }

  /**
   * Method under test: {@link LogInfo#getHexData()}
   */
  @Test
  public void testGetHexData() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();

    // Act and Assert
    assertEquals("4158415841584158", (new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"))).getHexData());
  }

  /**
   * Method under test: {@link LogInfo#getClonedData()}
   */
  @Test
  public void testGetClonedData() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();

    // Act
    byte[] actualClonedData = (new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"))).getClonedData();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualClonedData);
  }

  /**
   * Method under test: {@link LogInfo#getClonedData()}
   */
  @Test
  public void testGetClonedData2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, (new LogInfo(address, new ArrayList<>(), new byte[]{})).getClonedData().length);
  }

  /**
   * Method under test: {@link LogInfo#toString()}
   */
  @Test
  public void testToString() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();

    // Act and Assert
    assertEquals("LogInfo{address=4158415841584158, topics=[], data=4158415841584158}",
        (new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"))).toString());
  }

  /**
   * Method under test: {@link LogInfo#toString()}
   */
  @Test
  public void testToString2() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(
        "LogInfo{address=4158415841584158, topics=[0000000000000000000000000000000000000000000000000000000000000000"
            + " ], data=4158415841584158}",
        (new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"))).toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LogInfo#getAddress()}
   *   <li>{@link LogInfo#getData()}
   *   <li>{@link LogInfo#getTopics()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    LogInfo logInfo = new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualAddress = logInfo.getAddress();
    byte[] actualData = logInfo.getData();
    List<DataWord> actualTopics = logInfo.getTopics();

    // Assert
    assertTrue(actualTopics.isEmpty());
    assertSame(topics, actualTopics);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Method under test: {@link LogInfo#LogInfo(byte[], List, byte[])}
   */
  @Test
  public void testNewLogInfo() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    LogInfo actualLogInfo = new LogInfo(address, topics, data);

    // Assert
    assertEquals("4158415841584158", actualLogInfo.getHexData());
    assertTrue(actualLogInfo.getClonedTopics().isEmpty());
    assertTrue(actualLogInfo.getHexTopics().isEmpty());
    List<DataWord> topics2 = actualLogInfo.getTopics();
    assertTrue(topics2.isEmpty());
    assertSame(topics, topics2);
    assertSame(address, actualLogInfo.getAddress());
    assertSame(data, actualLogInfo.getData());
    byte[] expectedClonedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedClonedData, actualLogInfo.getClonedData());
  }

  /**
   * Method under test: {@link LogInfo#LogInfo(byte[], List, byte[])}
   */
  @Test
  public void testNewLogInfo2() {
    // Arrange and Act
    LogInfo actualLogInfo = new LogInfo(null, null, null);

    // Assert
    assertEquals("", actualLogInfo.getHexData());
    assertEquals(0, actualLogInfo.getAddress().length);
    assertEquals(0, actualLogInfo.getClonedData().length);
    assertEquals(0, actualLogInfo.getData().length);
    assertTrue(actualLogInfo.getClonedTopics().isEmpty());
    assertTrue(actualLogInfo.getHexTopics().isEmpty());
    assertTrue(actualLogInfo.getTopics().isEmpty());
  }

  /**
   * Method under test: {@link LogInfo#LogInfo(byte[], List, byte[])}
   */
  @Test
  public void testNewLogInfo3() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    LogInfo actualLogInfo = new LogInfo(address, topics, data);

    // Assert
    List<String> hexTopics = actualLogInfo.getHexTopics();
    assertEquals(1, hexTopics.size());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", hexTopics.get(0));
    assertEquals("4158415841584158", actualLogInfo.getHexData());
    List<byte[]> clonedTopics = actualLogInfo.getClonedTopics();
    assertEquals(1, clonedTopics.size());
    assertSame(topics, actualLogInfo.getTopics());
    assertSame(address, actualLogInfo.getAddress());
    assertSame(data, actualLogInfo.getData());
    byte[] expectedClonedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedClonedData, actualLogInfo.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        clonedTopics.get(0));
  }

  /**
   * Method under test: {@link LogInfo#LogInfo(byte[], List, byte[])}
   */
  @Test
  public void testNewLogInfo4() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    topics.add(DataWord.ZERO);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    LogInfo actualLogInfo = new LogInfo(address, topics, data);

    // Assert
    List<String> hexTopics = actualLogInfo.getHexTopics();
    assertEquals(2, hexTopics.size());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", hexTopics.get(0));
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", hexTopics.get(1));
    assertEquals("4158415841584158", actualLogInfo.getHexData());
    List<byte[]> clonedTopics = actualLogInfo.getClonedTopics();
    assertEquals(2, clonedTopics.size());
    assertSame(topics, actualLogInfo.getTopics());
    assertSame(address, actualLogInfo.getAddress());
    assertSame(data, actualLogInfo.getData());
    byte[] expectedClonedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedClonedData, actualLogInfo.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        clonedTopics.get(0));
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        clonedTopics.get(1));
  }

  /**
   * Method under test: {@link LogInfo#LogInfo(byte[], List, byte[])}
   */
  @Test
  public void testNewLogInfo5() {
    // Arrange
    COWArrayList<DataWord> topics = mock(COWArrayList.class);

    // Act
    LogInfo actualLogInfo = new LogInfo(null, topics, null);

    // Assert
    assertEquals("", actualLogInfo.getHexData());
    assertEquals(0, actualLogInfo.getAddress().length);
    assertEquals(0, actualLogInfo.getClonedData().length);
    assertEquals(0, actualLogInfo.getData().length);
    assertTrue(actualLogInfo.getClonedTopics().isEmpty());
    assertSame(topics, actualLogInfo.getTopics());
  }
}
