package org.tron.common.runtime.vm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.TransactionInfo;
import org.tron.protos.Protocol.TransactionInfo.Log;

public class LogInfoDiffblueTest {
  /**
   * Test {@link LogInfo#LogInfo(byte[], List, byte[])}.
   *
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link DataWord#ZERO}.
   *   <li>Then return ClonedTopics size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#LogInfo(byte[], List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogInfo.<init>(byte[], List, byte[])"})
  public void testNewLogInfo_givenZero_whenArrayListAddZero_thenReturnClonedTopicsSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);

    // Act
    LogInfo actualLogInfo = new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<byte[]> clonedTopics = actualLogInfo.getClonedTopics();
    assertEquals(1, clonedTopics.size());
    assertEquals(1, actualLogInfo.getHexTopics().size());
    List<DataWord> topics2 = actualLogInfo.getTopics();
    assertEquals(1, topics2.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getAddress());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getClonedData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getData());
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
        clonedTopics.get(0));
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        getResult.getClonedData());
  }

  /**
   * Test {@link LogInfo#LogInfo(byte[], List, byte[])}.
   *
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link DataWord#ZERO}.
   *   <li>Then return HexTopics size is two.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#LogInfo(byte[], List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogInfo.<init>(byte[], List, byte[])"})
  public void testNewLogInfo_givenZero_whenArrayListAddZero_thenReturnHexTopicsSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    topics.add(DataWord.ZERO);

    // Act
    LogInfo actualLogInfo = new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<String> hexTopics = actualLogInfo.getHexTopics();
    assertEquals(2, hexTopics.size());
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000", hexTopics.get(1));
    List<byte[]> clonedTopics = actualLogInfo.getClonedTopics();
    assertEquals(2, clonedTopics.size());
    List<DataWord> topics2 = actualLogInfo.getTopics();
    assertEquals(2, topics2.size());
    DataWord getResult = topics2.get(0);
    assertSame(getResult, topics2.get(1));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getAddress());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getClonedData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getData());
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
        clonedTopics.get(0));
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        clonedTopics.get(1));
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        getResult.getClonedData());
  }

  /**
   * Test {@link LogInfo#LogInfo(byte[], List, byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return ClonedTopics Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#LogInfo(byte[], List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogInfo.<init>(byte[], List, byte[])"})
  public void testNewLogInfo_whenA_thenReturnClonedTopicsEmpty()
      throws UnsupportedEncodingException {
    // Arrange and Act
    LogInfo actualLogInfo =
        new LogInfo(
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            null,
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertTrue(actualLogInfo.getClonedTopics().isEmpty());
    assertTrue(actualLogInfo.getHexTopics().isEmpty());
    assertTrue(actualLogInfo.getTopics().isEmpty());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getAddress());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getClonedData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getData());
  }

  /**
   * Test {@link LogInfo#LogInfo(byte[], List, byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return HexData is empty string.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#LogInfo(byte[], List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogInfo.<init>(byte[], List, byte[])"})
  public void testNewLogInfo_whenA_thenReturnHexDataIsEmptyString()
      throws UnsupportedEncodingException {
    // Arrange and Act
    LogInfo actualLogInfo =
        new LogInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, new ArrayList<>(), null);

    // Assert
    assertEquals("", actualLogInfo.getHexData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getAddress());
    assertArrayEquals(new byte[] {}, actualLogInfo.getClonedData());
    assertArrayEquals(new byte[] {}, actualLogInfo.getData());
  }

  /**
   * Test {@link LogInfo#LogInfo(byte[], List, byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return ClonedTopics Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#LogInfo(byte[], List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogInfo.<init>(byte[], List, byte[])"})
  public void testNewLogInfo_whenAxaxaxaxBytesIsUtf8_thenReturnClonedTopicsEmpty()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    LogInfo actualLogInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualLogInfo.getClonedTopics().isEmpty());
    assertTrue(actualLogInfo.getHexTopics().isEmpty());
    assertTrue(actualLogInfo.getTopics().isEmpty());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getAddress());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getClonedData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getData());
  }

  /**
   * Test {@link LogInfo#LogInfo(byte[], List, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Address is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#LogInfo(byte[], List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogInfo.<init>(byte[], List, byte[])"})
  public void testNewLogInfo_whenNull_thenReturnAddressIsEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange and Act
    LogInfo actualLogInfo =
        new LogInfo(null, new ArrayList<>(), new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertTrue(actualLogInfo.getClonedTopics().isEmpty());
    assertTrue(actualLogInfo.getHexTopics().isEmpty());
    assertTrue(actualLogInfo.getTopics().isEmpty());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getClonedData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualLogInfo.getData());
    assertArrayEquals(new byte[] {}, actualLogInfo.getAddress());
  }

  /**
   * Test {@link LogInfo#buildLog(LogInfo)}.
   *
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link DataWord#ZERO}.
   *   <li>Then return TopicsList size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#buildLog(LogInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Log LogInfo.buildLog(LogInfo)"})
  public void testBuildLog_givenZero_whenArrayListAddZero_thenReturnTopicsListSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    LogInfo logInfo =
        new LogInfo("AXAXAXAX".getBytes("UTF-8"), topics, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    Log actualBuildLogResult = LogInfo.buildLog(logInfo);

    // Assert
    List<ByteString> topicsList = actualBuildLogResult.getTopicsList();
    assertEquals(1, topicsList.size());
    ByteString getResult = topicsList.get(0);
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        getResult.toStringUtf8());
    assertEquals(1, actualBuildLogResult.getTopicsCount());
    assertEquals(3, actualBuildLogResult.getAllFields().size());
    assertEquals(54, actualBuildLogResult.getSerializedSize());
    assertFalse(getResult.isEmpty());
    assertTrue(getResult.iterator().hasNext());
  }

  /**
   * Test {@link LogInfo#buildLog(LogInfo)}.
   *
   * <ul>
   *   <li>Given {@link DataWord#ZERO}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link DataWord#ZERO}.
   *   <li>Then return TopicsList size is two.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#buildLog(LogInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Log LogInfo.buildLog(LogInfo)"})
  public void testBuildLog_givenZero_whenArrayListAddZero_thenReturnTopicsListSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    topics.add(DataWord.ZERO);
    LogInfo logInfo =
        new LogInfo("AXAXAXAX".getBytes("UTF-8"), topics, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    Log actualBuildLogResult = LogInfo.buildLog(logInfo);

    // Assert
    List<ByteString> topicsList = actualBuildLogResult.getTopicsList();
    assertEquals(2, topicsList.size());
    assertEquals(2, actualBuildLogResult.getTopicsCount());
    assertEquals(88, actualBuildLogResult.getSerializedSize());
    ByteString expectedGetResult = topicsList.get(0);
    assertEquals(expectedGetResult, topicsList.get(1));
  }

  /**
   * Test {@link LogInfo#buildLog(LogInfo)}.
   *
   * <ul>
   *   <li>Then return TopicsCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#buildLog(LogInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Log LogInfo.buildLog(LogInfo)"})
  public void testBuildLog_thenReturnTopicsCountIsZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();

    LogInfo logInfo = new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    Log actualBuildLogResult = LogInfo.buildLog(logInfo);

    // Assert
    assertEquals(0, actualBuildLogResult.getTopicsCount());
    assertEquals(2, actualBuildLogResult.getAllFields().size());
    assertEquals(20, actualBuildLogResult.getSerializedSize());
    assertTrue(actualBuildLogResult.getTopicsList().isEmpty());
    assertEquals(
        topics, actualBuildLogResult.getDescriptorForType().toProto().getReservedNameList());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LogInfo#getAddress()}
   *   <li>{@link LogInfo#getData()}
   *   <li>{@link LogInfo#getTopics()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] LogInfo.getAddress()",
    "byte[] LogInfo.getData()",
    "List LogInfo.getTopics()"
  })
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
   * Test {@link LogInfo#getHexTopics()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DataWord#ZERO}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#getHexTopics()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogInfo.getHexTopics()"})
  public void testGetHexTopics_givenArrayListAddZero_thenReturnSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    LogInfo logInfo =
        new LogInfo("AXAXAXAX".getBytes("UTF-8"), topics, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    List<String> actualHexTopics = logInfo.getHexTopics();

    // Assert
    assertEquals(1, actualHexTopics.size());
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000", actualHexTopics.get(0));
  }

  /**
   * Test {@link LogInfo#getHexTopics()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#getHexTopics()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogInfo.getHexTopics()"})
  public void testGetHexTopics_thenReturnEmpty() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(logInfo.getHexTopics().isEmpty());
  }

  /**
   * Test {@link LogInfo#getClonedTopics()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DataWord#ZERO}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#getClonedTopics()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogInfo.getClonedTopics()"})
  public void testGetClonedTopics_givenArrayListAddZero_thenReturnSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    LogInfo logInfo =
        new LogInfo("AXAXAXAX".getBytes("UTF-8"), topics, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    List<byte[]> actualClonedTopics = logInfo.getClonedTopics();

    // Assert
    assertEquals(1, actualClonedTopics.size());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualClonedTopics.get(0));
  }

  /**
   * Test {@link LogInfo#getClonedTopics()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#getClonedTopics()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogInfo.getClonedTopics()"})
  public void testGetClonedTopics_thenReturnEmpty() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(logInfo.getClonedTopics().isEmpty());
  }

  /**
   * Test {@link LogInfo#getHexData()}.
   *
   * <p>Method under test: {@link LogInfo#getHexData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LogInfo.getHexData()"})
  public void testGetHexData() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("4158415841584158", logInfo.getHexData());
  }

  /**
   * Test {@link LogInfo#getClonedData()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#getClonedData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LogInfo.getClonedData()"})
  public void testGetClonedData_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), logInfo.getClonedData());
  }

  /**
   * Test {@link LogInfo#getClonedData()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#getClonedData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LogInfo.getClonedData()"})
  public void testGetClonedData_thenReturnEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, logInfo.getClonedData());
  }

  /**
   * Test {@link LogInfo#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DataWord#ZERO}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LogInfo.toString()"})
  public void testToString_givenArrayListAddZero_thenReturnAString()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<DataWord> topics = new ArrayList<>();
    topics.add(DataWord.ZERO);
    LogInfo logInfo =
        new LogInfo("AXAXAXAX".getBytes("UTF-8"), topics, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "LogInfo{address=4158415841584158, topics=[0000000000000000000000000000000000000000000000000000000000000000"
            + " ], data=4158415841584158}",
        logInfo.toString());
  }

  /**
   * Test {@link LogInfo#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LogInfo{address=4158415841584158, topics=[], data=4158415841584158}}.
   * </ul>
   *
   * <p>Method under test: {@link LogInfo#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LogInfo.toString()"})
  public void testToString_thenReturnLogInfoAddress4158415841584158TopicsData4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "LogInfo{address=4158415841584158, topics=[], data=4158415841584158}", logInfo.toString());
  }
}
