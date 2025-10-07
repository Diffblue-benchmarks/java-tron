package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;

public class RawDataDiffblueTest {
  /**
   * Test {@link RawData#RawData(byte[], List, byte[])}.
   *
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link DataWord#ZERO}.
   *   <li>Then return Topics size is one.
   * </ul>
   *
   * <p>Method under test: {@link RawData#RawData(byte[], List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RawData.<init>(byte[], List, byte[])"})
  public void testNewRawData_givenZero_whenArrayListAddZero_thenReturnTopicsSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);

    // Act
    RawData actualRawData = new RawData(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<DataWord> topics2 = actualRawData.getTopics();
    assertEquals(1, topics2.size());
    DataWord getResult = topics2.get(0);
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        getResult.getClonedData());
  }

  /**
   * Test {@link RawData#RawData(byte[], List, byte[])}.
   *
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link DataWord#ZERO}.
   *   <li>Then return Topics size is two.
   * </ul>
   *
   * <p>Method under test: {@link RawData#RawData(byte[], List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RawData.<init>(byte[], List, byte[])"})
  public void testNewRawData_givenZero_whenArrayListAddZero_thenReturnTopicsSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    topics.add(DataWord.ZERO);

    // Act
    RawData actualRawData = new RawData(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<DataWord> topics2 = actualRawData.getTopics();
    assertEquals(2, topics2.size());
    DataWord getResult = topics2.get(0);
    assertSame(getResult, topics2.get(1));
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        getResult.getClonedData());
  }

  /**
   * Test {@link RawData#RawData(byte[], List, byte[])}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Address is {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link RawData#RawData(byte[], List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RawData.<init>(byte[], List, byte[])"})
  public void testNewRawData_whenArrayList_thenReturnAddressIs4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    RawData actualRawData = new RawData(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4158415841584158", actualRawData.getAddress());
    assertEquals("4158415841584158", actualRawData.getData());
    assertTrue(actualRawData.getTopics().isEmpty());
  }

  /**
   * Test {@link RawData#RawData(byte[], List, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Address is empty string.
   * </ul>
   *
   * <p>Method under test: {@link RawData#RawData(byte[], List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RawData.<init>(byte[], List, byte[])"})
  public void testNewRawData_whenNull_thenReturnAddressIsEmptyString() {
    // Arrange and Act
    RawData actualRawData = new RawData(null, new ArrayList<>(), null);

    // Assert
    assertEquals("", actualRawData.getAddress());
    assertEquals("", actualRawData.getData());
    assertTrue(actualRawData.getTopics().isEmpty());
  }

  /**
   * Test {@link RawData#equals(Object)}, and {@link RawData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RawData#equals(Object)}
   *   <li>{@link RawData#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RawData.equals(Object)", "int RawData.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData = new RawData(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData2 = new RawData(address2, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(rawData, rawData2);
    assertEquals(rawData.hashCode(), rawData2.hashCode());
  }

  /**
   * Test {@link RawData#equals(Object)}, and {@link RawData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RawData#equals(Object)}
   *   <li>{@link RawData#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RawData.equals(Object)", "int RawData.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData = new RawData(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(rawData, rawData);
    int expectedHashCodeResult = rawData.hashCode();
    assertEquals(expectedHashCodeResult, rawData.hashCode());
  }

  /**
   * Test {@link RawData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RawData#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RawData.equals(Object)", "int RawData.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(new RawData(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8")), 1);
  }

  /**
   * Test {@link RawData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RawData#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RawData.equals(Object)", "int RawData.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    RawData rawData = new RawData(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    rawData.setAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(
        rawData, new RawData(address2, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RawData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RawData#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RawData.equals(Object)", "int RawData.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    RawData rawData = new RawData(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    rawData.setAddress(null);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(
        rawData, new RawData(address2, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RawData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RawData#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RawData.equals(Object)", "int RawData.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    RawData rawData =
        new RawData("AXAXAXAX".getBytes("UTF-8"), topics, "AXAXAXAX".getBytes("UTF-8"));
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(rawData, new RawData(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RawData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RawData#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RawData.equals(Object)", "int RawData.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData =
        new RawData(address, new ArrayList<>(), new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(
        rawData, new RawData(address2, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RawData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RawData#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RawData.equals(Object)", "int RawData.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(new RawData(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Test {@link RawData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RawData#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RawData.equals(Object)", "int RawData.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(
        new RawData(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8")),
        "Different type to RawData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RawData.getAddress()",
    "String RawData.getData()",
    "List RawData.getTopics()",
    "void RawData.setAddress(String)",
    "void RawData.setData(String)",
    "void RawData.setTopics(List)",
    "String RawData.toString()"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData = new RawData(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));

    // Act
    rawData.setAddress("42 Main St");
    rawData.setData("Data");
    ArrayList<DataWord> topics = new ArrayList<>();
    rawData.setTopics(topics);
    String actualToStringResult = rawData.toString();
    String actualAddress = rawData.getAddress();
    String actualData = rawData.getData();
    List<DataWord> actualTopics = rawData.getTopics();

    // Assert
    assertEquals("42 Main St", actualAddress);
    assertEquals("Data", actualData);
    assertEquals("RawData(address=42 Main St, topics=[], data=Data)", actualToStringResult);
    assertTrue(actualTopics.isEmpty());
    assertSame(topics, actualTopics);
  }
}
