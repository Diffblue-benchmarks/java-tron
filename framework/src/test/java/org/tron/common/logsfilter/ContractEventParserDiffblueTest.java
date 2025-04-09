package org.tron.common.logsfilter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.bouncycastle.crypto.OutputLengthException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ContractEventParserDiffblueTest {
  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenA_thenReturnTrueToString() {
    // Arrange and Act
    String actualParseDataBytesResult = ContractEventParser
        .parseDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "bool", 0);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualParseDataBytesResult);
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   * <ul>
   *   <li>When {@code bool}.</li>
   *   <li>Then return {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenBool_thenReturnTrueToString() throws UnsupportedEncodingException {
    // Arrange and Act
    String actualParseDataBytesResult = ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "bool", 0);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualParseDataBytesResult);
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   * <ul>
   *   <li>When {@code bytes}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenBytes_thenThrowUnsupportedOperationException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "bytes", 0));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenEmptyArrayOfByte_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes(new byte[]{}, "Type Str", 1));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   * <ul>
   *   <li>When {@code int}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenInt() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("29556268692482266223246998998943815163684370458768864140436198419308407160832",
        ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "int", 0));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ContractEventParser.parseDataBytes(null, "int", 1));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenOne_thenThrowUnsupportedOperationException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "Type Str", 1));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   * <ul>
   *   <li>When {@code string}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenString_thenThrowUnsupportedOperationException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "string", 0));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   * <ul>
   *   <li>When {@code trcToken}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenTrcToken() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("29556268692482266223246998998943815163684370458768864140436198419308407160832",
        ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "trcToken", 0));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   * <ul>
   *   <li>When {@code Type Str}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenTypeStr_thenThrowUnsupportedOperationException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "Type Str", 0));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   * <ul>
   *   <li>When {@code uint}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenUint() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("29556268692482266223246998998943815163684370458768864140436198419308407160832",
        ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "uint", 0));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenXaxaxaxBytesIsUtf8_thenReturnTrueToString() throws UnsupportedEncodingException {
    // Arrange and Act
    String actualParseDataBytesResult = ContractEventParser.parseDataBytes(" XAXAXAX".getBytes("UTF-8"), "bool", 0);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualParseDataBytesResult);
  }

  /**
   * Test {@link ContractEventParser#subBytes(byte[], int, int)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link OutputLengthException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractEventParser.subBytes(byte[], int, int)"})
  public void testSubBytes_whenA_thenThrowOutputLengthException() {
    // Arrange, Act and Assert
    assertThrows(OutputLengthException.class, () -> ContractEventParser
        .subBytes(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, FilterQuery.LATEST_BLOCK_NUM));
  }

  /**
   * Test {@link ContractEventParser#subBytes(byte[], int, int)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code XAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractEventParser.subBytes(byte[], int, int)"})
  public void testSubBytes_whenAxaxaxaxBytesIsUtf8_thenReturnXaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualSubBytesResult = ContractEventParser.subBytes("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    assertArrayEquals("XAX".getBytes("UTF-8"), actualSubBytesResult);
  }

  /**
   * Test {@link ContractEventParser#subBytes(byte[], int, int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then throw {@link OutputLengthException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractEventParser.subBytes(byte[], int, int)"})
  public void testSubBytes_whenEight_thenThrowOutputLengthException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(OutputLengthException.class, () -> ContractEventParser.subBytes("AXAXAXAX".getBytes("UTF-8"), 8, 3));
  }

  /**
   * Test {@link ContractEventParser#subBytes(byte[], int, int)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then throw {@link OutputLengthException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractEventParser.subBytes(byte[], int, int)"})
  public void testSubBytes_whenEmptyArrayOfByte_thenThrowOutputLengthException() {
    // Arrange, Act and Assert
    assertThrows(OutputLengthException.class, () -> ContractEventParser.subBytes(new byte[]{}, 1, 3));
  }

  /**
   * Test {@link ContractEventParser#subBytes(byte[], int, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link OutputLengthException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractEventParser.subBytes(byte[], int, int)"})
  public void testSubBytes_whenNull_thenThrowOutputLengthException() {
    // Arrange, Act and Assert
    assertThrows(OutputLengthException.class, () -> ContractEventParser.subBytes(null, 1, 0));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   *   <li>Then return {@code 1111113HK8zu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenArrayOfByteWithZeroAndZero_thenReturn1111113HK8zu() {
    // Arrange, Act and Assert
    assertEquals("1111113HK8zu",
        ContractEventParser.parseTopic(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "address"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   *   <li>Then return {@link Boolean#FALSE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenArrayOfByteWithZeroAndZero_thenReturnFalseToString() {
    // Arrange and Act
    String actualParseTopicResult = ContractEventParser
        .parseTopic(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "bool");

    // Assert
    assertEquals(Boolean.FALSE.toString(), actualParseTopicResult);
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenAxaxaxaxBytesIsUtf8_thenReturn4158415841584158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", ContractEventParser.parseTopic("AXAXAXAX".getBytes("UTF-8"), "Type Str"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When {@code bool}.</li>
   *   <li>Then return {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenBool_thenReturnTrueToString() {
    // Arrange and Act
    String actualParseTopicResult = ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "bool");

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualParseTopicResult);
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When {@code bytes}.</li>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenBytes_thenReturn4158415841584158() {
    // Arrange, Act and Assert
    assertEquals("4158415841584158",
        ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "bytes"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenEmptyArrayOfByte_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ContractEventParser.parseTopic(new byte[]{}, "Type Str"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, ""));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When {@code int}.</li>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenInt_thenReturn4708585257725083992() {
    // Arrange, Act and Assert
    assertEquals("4708585257725083992",
        ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "int"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ContractEventParser.parseTopic(null, "int"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenNull_thenReturnEmptyString2() {
    // Arrange, Act and Assert
    assertEquals("", ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When {@code string}.</li>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenString_thenReturn4158415841584158() {
    // Arrange, Act and Assert
    assertEquals("4158415841584158",
        ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "string"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When {@code trcToken}.</li>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenTrcToken_thenReturn4708585257725083992() {
    // Arrange, Act and Assert
    assertEquals("4708585257725083992",
        ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "trcToken"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   * <ul>
   *   <li>When {@code uint}.</li>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenUint_thenReturn4708585257725083992() {
    // Arrange, Act and Assert
    assertEquals("4708585257725083992",
        ContractEventParser.parseTopic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "uint"));
  }
}
