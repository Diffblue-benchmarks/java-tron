package org.tron.common.logsfilter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import org.bouncycastle.crypto.OutputLengthException;
import org.junit.Test;

public class ContractEventParserDiffblueTest {
  /**
   * Method under test:
   * {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  public void testParseDataBytes() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "Type Str", 1));
    assertThrows(UnsupportedOperationException.class, () -> ContractEventParser.parseDataBytes(null, "int", 1));
    assertThrows(UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes(new byte[]{}, "Type Str", 1));
    assertThrows(UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "Type Str", 0));
    assertEquals("29556268692482266223246998998943815163684370458768864140436198419308407160832",
        ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "int", 0));
    assertEquals("29556268692482266223246998998943815163684370458768864140436198419308407160832",
        ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "uint", 0));
    assertEquals("29556268692482266223246998998943815163684370458768864140436198419308407160832",
        ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "trcToken", 0));
    assertEquals("T9yD14Nj9j7xAB4dbGeiX9h8unkKHxuWwb",
        ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "address", 0));
  }

  /**
   * Method under test:
   * {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  public void testParseDataBytes2() throws UnsupportedEncodingException {
    // Arrange and Act
    String actualParseDataBytesResult = ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "bool", 0);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualParseDataBytesResult);
  }

  /**
   * Method under test:
   * {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  public void testParseDataBytes3() throws UnsupportedEncodingException {
    // Arrange and Act
    String actualParseDataBytesResult = ContractEventParser.parseDataBytes(" XAXAXAX".getBytes("UTF-8"), "bool", 0);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualParseDataBytesResult);
  }

  /**
   * Method under test:
   * {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  public void testParseDataBytes4() {
    // Arrange and Act
    String actualParseDataBytesResult = ContractEventParser
        .parseDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "bool", 0);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualParseDataBytesResult);
  }

  /**
   * Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  public void testSubBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualSubBytesResult = ContractEventParser.subBytes("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    assertArrayEquals("XAX".getBytes("UTF-8"), actualSubBytesResult);
  }

  /**
   * Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  public void testSubBytes2() {
    // Arrange, Act and Assert
    assertThrows(OutputLengthException.class, () -> ContractEventParser.subBytes(null, 1, 0));
  }

  /**
   * Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  public void testSubBytes3() {
    // Arrange, Act and Assert
    assertThrows(OutputLengthException.class, () -> ContractEventParser
        .subBytes(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, FilterQuery.LATEST_BLOCK_NUM));
  }

  /**
   * Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  public void testSubBytes4() {
    // Arrange, Act and Assert
    assertThrows(OutputLengthException.class, () -> ContractEventParser.subBytes(new byte[]{}, 1, 3));
  }

  /**
   * Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  public void testSubBytes5() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(OutputLengthException.class, () -> ContractEventParser.subBytes("AXAXAXAX".getBytes("UTF-8"), 8, 3));
  }

  /**
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  public void testParseTopic() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", ContractEventParser.parseTopic("AXAXAXAX".getBytes("UTF-8"), "Type Str"));
    assertEquals("", ContractEventParser.parseTopic(null, "int"));
    assertEquals("4708585257725083992",
        ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "int"));
    assertEquals("4708585257725083992",
        ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "uint"));
    assertEquals("4708585257725083992",
        ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "trcToken"));
    assertEquals("4158415841584158",
        ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "string"));
    assertEquals("4158415841584158",
        ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "bytes"));
    assertEquals("", ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null));
    assertEquals("", ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, ""));
    assertEquals("1111113HK8zu",
        ContractEventParser.parseTopic(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "address"));
    assertEquals("", ContractEventParser.parseTopic(new byte[]{}, "Type Str"));
  }

  /**
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  public void testParseTopic2() {
    // Arrange and Act
    String actualParseTopicResult = ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "bool");

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualParseTopicResult);
  }

  /**
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  public void testParseTopic3() {
    // Arrange and Act
    String actualParseTopicResult = ContractEventParser
        .parseTopic(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "bool");

    // Assert
    assertEquals(Boolean.FALSE.toString(), actualParseTopicResult);
  }
}
