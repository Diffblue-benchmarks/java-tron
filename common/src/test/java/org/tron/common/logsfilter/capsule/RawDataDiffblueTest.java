package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.common.runtime.vm.DataWord;

public class RawDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RawData#equals(Object)}
   *   <li>{@link RawData#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    RawData rawData = new RawData(address, topics, "AXAXAXAX".getBytes("UTF-8"));
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    RawData rawData2 = new RawData(address2, topics2, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(rawData, rawData2);
    int expectedHashCodeResult = rawData.hashCode();
    assertEquals(expectedHashCodeResult, rawData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RawData#equals(Object)}
   *   <li>{@link RawData#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    RawData rawData = new RawData(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(rawData, rawData);
    int expectedHashCodeResult = rawData.hashCode();
    assertEquals(expectedHashCodeResult, rawData.hashCode());
  }

  /**
   * Method under test: {@link RawData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<DataWord> topics = new ArrayList<>();
    RawData rawData = new RawData(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, topics,
        "AXAXAXAX".getBytes("UTF-8"));
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(rawData, new RawData(address, topics2, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link RawData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData = new RawData(address, topics, "AXAXAXAX".getBytes("UTF-8"));
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(rawData, new RawData(address2, topics2, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link RawData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData = new RawData(address, new ArrayList<>(), new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();

    // Act and Assert
    assertNotEquals(rawData, new RawData(address2, topics, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link RawData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();

    // Act and Assert
    assertNotEquals(new RawData(address, topics, "AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Method under test: {@link RawData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();

    // Act and Assert
    assertNotEquals(new RawData(address, topics, "AXAXAXAX".getBytes("UTF-8")), "Different type to RawData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RawData#setAddress(String)}
   *   <li>{@link RawData#setData(String)}
   *   <li>{@link RawData#setTopics(List)}
   *   <li>{@link RawData#toString()}
   *   <li>{@link RawData#getAddress()}
   *   <li>{@link RawData#getData()}
   *   <li>{@link RawData#getTopics()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    RawData rawData = new RawData(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    rawData.setAddress("42 Main St");
    rawData.setData("Data");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    rawData.setTopics(topics2);
    String actualToStringResult = rawData.toString();
    String actualAddress = rawData.getAddress();
    String actualData = rawData.getData();
    List<DataWord> actualTopics = rawData.getTopics();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualAddress);
    assertEquals("Data", actualData);
    assertEquals("RawData(address=42 Main St, topics=[], data=Data)", actualToStringResult);
    assertTrue(actualTopics.isEmpty());
    assertSame(topics2, actualTopics);
  }

  /**
   * Method under test: {@link RawData#RawData(byte[], List, byte[])}
   */
  @Test
  public void testNewRawData() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();

    // Act
    RawData actualRawData = new RawData(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4158415841584158", actualRawData.getAddress());
    assertEquals("4158415841584158", actualRawData.getData());
    List<DataWord> topics2 = actualRawData.getTopics();
    assertTrue(topics2.isEmpty());
    assertSame(topics, topics2);
  }

  /**
   * Method under test: {@link RawData#RawData(byte[], List, byte[])}
   */
  @Test
  public void testNewRawData2() {
    // Arrange and Act
    RawData actualRawData = new RawData(null, new ArrayList<>(), null);

    // Assert
    assertEquals("", actualRawData.getAddress());
    assertEquals("", actualRawData.getData());
    assertTrue(actualRawData.getTopics().isEmpty());
  }

  /**
   * Method under test: {@link RawData#RawData(byte[], List, byte[])}
   */
  @Test
  public void testNewRawData3() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);

    // Act
    RawData actualRawData = new RawData(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4158415841584158", actualRawData.getAddress());
    assertEquals("4158415841584158", actualRawData.getData());
    assertSame(topics, actualRawData.getTopics());
  }

  /**
   * Method under test: {@link RawData#RawData(byte[], List, byte[])}
   */
  @Test
  public void testNewRawData4() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    topics.add(DataWord.ZERO);

    // Act
    RawData actualRawData = new RawData(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4158415841584158", actualRawData.getAddress());
    assertEquals("4158415841584158", actualRawData.getData());
    assertSame(topics, actualRawData.getTopics());
  }
}
