package org.tron.common.logsfilter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.bouncycastle.crypto.OutputLengthException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ContractEventParserDiffblueTest {
  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenAAAAAAAABytesIsUtf8_thenReturnTrueToString()
      throws UnsupportedEncodingException {
    // Arrange and Act
    String actualParseDataBytesResult =
        ContractEventParser.parseDataBytes("A A A A A A A A ".getBytes("UTF-8"), "bool", 0);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualParseDataBytesResult);
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenA_thenReturnTrueToString() {
    // Arrange and Act
    String actualParseDataBytesResult =
        ContractEventParser.parseDataBytes(
            new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "bool", 0);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualParseDataBytesResult);
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   *
   * <ul>
   *   <li>When {@code bool}.
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenBool_thenReturnTrueToString()
      throws UnsupportedEncodingException {
    // Arrange and Act
    String actualParseDataBytesResult =
        ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "bool", 0);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualParseDataBytesResult);
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   *
   * <ul>
   *   <li>When {@code bytes}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenBytes_thenThrowUnsupportedOperationException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "bytes", 0));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenEmptyArrayOfByte_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes(new byte[] {}, "Type Str", 1));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   *
   * <ul>
   *   <li>When {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenInt() throws UnsupportedEncodingException {
    // Arrange and Act
    String actualParseDataBytesResult =
        ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "int", 0);

    // Assert
    assertEquals(
        "29556268692482266223246998998943815163684370458768864140436198419308407160832",
        actualParseDataBytesResult);
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes(null, "int", 1));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenOne_thenThrowUnsupportedOperationException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "Type Str", 1));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   *
   * <ul>
   *   <li>When {@code string}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenString_thenThrowUnsupportedOperationException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "string", 0));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   *
   * <ul>
   *   <li>When {@code trcToken}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenTrcToken() throws UnsupportedEncodingException {
    // Arrange and Act
    String actualParseDataBytesResult =
        ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "trcToken", 0);

    // Assert
    assertEquals(
        "29556268692482266223246998998943815163684370458768864140436198419308407160832",
        actualParseDataBytesResult);
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   *
   * <ul>
   *   <li>When {@code Type Str}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenTypeStr_thenThrowUnsupportedOperationException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "Type Str", 0));
  }

  /**
   * Test {@link ContractEventParser#parseDataBytes(byte[], String, int)}.
   *
   * <ul>
   *   <li>When {@code uint}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseDataBytes(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseDataBytes(byte[], String, int)"})
  public void testParseDataBytes_whenUint() throws UnsupportedEncodingException {
    // Arrange and Act
    String actualParseDataBytesResult =
        ContractEventParser.parseDataBytes("AXAXAXAX".getBytes("UTF-8"), "uint", 0);

    // Assert
    assertEquals(
        "29556268692482266223246998998943815163684370458768864140436198419308407160832",
        actualParseDataBytesResult);
  }

  /**
   * Test {@link ContractEventParser#subBytes(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link OutputLengthException}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractEventParser.subBytes(byte[], int, int)"})
  public void testSubBytes_whenA_thenThrowOutputLengthException() {
    // Arrange, Act and Assert
    assertThrows(
        OutputLengthException.class,
        () ->
            ContractEventParser.subBytes(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                1,
                FilterQuery.LATEST_BLOCK_NUM));
  }

  /**
   * Test {@link ContractEventParser#subBytes(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code XAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractEventParser.subBytes(byte[], int, int)"})
  public void testSubBytes_whenAxaxaxaxBytesIsUtf8_thenReturnXaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "XAX".getBytes("UTF-8"), ContractEventParser.subBytes("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link ContractEventParser#subBytes(byte[], int, int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then throw {@link OutputLengthException}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractEventParser.subBytes(byte[], int, int)"})
  public void testSubBytes_whenEight_thenThrowOutputLengthException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        OutputLengthException.class,
        () -> ContractEventParser.subBytes("AXAXAXAX".getBytes("UTF-8"), 8, 3));
  }

  /**
   * Test {@link ContractEventParser#subBytes(byte[], int, int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link OutputLengthException}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractEventParser.subBytes(byte[], int, int)"})
  public void testSubBytes_whenEmptyArrayOfByte_thenThrowOutputLengthException() {
    // Arrange, Act and Assert
    assertThrows(
        OutputLengthException.class, () -> ContractEventParser.subBytes(new byte[] {}, 1, 3));
  }

  /**
   * Test {@link ContractEventParser#subBytes(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link OutputLengthException}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#subBytes(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractEventParser.subBytes(byte[], int, int)"})
  public void testSubBytes_whenNull_thenThrowOutputLengthException() {
    // Arrange, Act and Assert
    assertThrows(OutputLengthException.class, () -> ContractEventParser.subBytes(null, 1, 0));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenA_thenReturnTrueToString() {
    // Arrange, Act and Assert
    assertEquals(
        Boolean.TRUE.toString(),
        ContractEventParser.parseTopic(
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "bool"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code address}.
   *   <li>Then return {@code 1111113HK8zu}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenAddress_thenReturn1111113HK8zu() {
    // Arrange, Act and Assert
    assertEquals(
        "1111113HK8zu",
        ContractEventParser.parseTopic(
            new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "address"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenAxaxaxaxBytesIsUtf8_thenReturn4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "4158415841584158",
        ContractEventParser.parseTopic("AXAXAXAX".getBytes("UTF-8"), "Type Str"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code bool}.
   *   <li>Then return {@link Boolean#FALSE} toString.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenBool_thenReturnFalseToString() {
    // Arrange, Act and Assert
    assertEquals(
        Boolean.FALSE.toString(),
        ContractEventParser.parseTopic(
            new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "bool"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code bytes}.
   *   <li>Then return {@code 000000000000000000000000000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenBytes_thenReturn000000000000000000000000000000000000() {
    // Arrange, Act and Assert
    assertEquals(
        "000000000000000000000000000000000000",
        ContractEventParser.parseTopic(
            new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "bytes"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenEmptyArrayOfByte_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ContractEventParser.parseTopic(new byte[] {}, "Type Str"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        ContractEventParser.parseTopic(
            new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, ""));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code int}.
   *   <li>Then return {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenInt_thenReturn0() {
    // Arrange, Act and Assert
    assertEquals(
        "0",
        ContractEventParser.parseTopic(
            new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "int"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        ContractEventParser.parseTopic(
            new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, null));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenNull_thenReturnEmptyString2() {
    // Arrange, Act and Assert
    assertEquals("", ContractEventParser.parseTopic(null, ""));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code string}.
   *   <li>Then return {@code 000000000000000000000000000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenString_thenReturn000000000000000000000000000000000000() {
    // Arrange, Act and Assert
    assertEquals(
        "000000000000000000000000000000000000",
        ContractEventParser.parseTopic(
            new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "string"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code trcToken}.
   *   <li>Then return {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenTrcToken_thenReturn0() {
    // Arrange, Act and Assert
    assertEquals(
        "0",
        ContractEventParser.parseTopic(
            new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "trcToken"));
  }

  /**
   * Test {@link ContractEventParser#parseTopic(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code uint}.
   *   <li>Then return {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParser#parseTopic(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContractEventParser.parseTopic(byte[], String)"})
  public void testParseTopic_whenUint_thenReturn0() {
    // Arrange, Act and Assert
    assertEquals(
        "0",
        ContractEventParser.parseTopic(
            new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "uint"));
  }
}
