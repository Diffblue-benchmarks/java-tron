package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Backend;
import com.google.api.BackendRule;
import com.google.api.ClientLibrarySettings;
import com.google.api.CommonLanguageSettings;
import com.google.protobuf.Any;
import com.google.protobuf.Api;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSetDefaults;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet.Builder;
import com.google.protobuf.UnknownFieldSet.Field;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.util.HashMap;
import org.apache.commons.lang3.text.StrBuilder;
import org.aspectj.org.eclipse.jdt.internal.compiler.apt.model.NameImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.Wallet;
import org.tron.core.services.http.JsonFormat.InvalidEscapeSequence;
import org.tron.core.services.http.JsonFormat.JsonGenerator;
import org.tron.core.services.http.JsonFormat.ParseException;
import org.tron.core.services.http.JsonFormat.Tokenizer;

public class JsonFormatDiffblueTest {
  /**
   * Test InvalidEscapeSequence {@link InvalidEscapeSequence#InvalidEscapeSequence(String)}.
   * <p>
   * Method under test: {@link InvalidEscapeSequence#InvalidEscapeSequence(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvalidEscapeSequence.<init>(String)"})
  public void testInvalidEscapeSequenceNewInvalidEscapeSequence() {
    // Arrange and Act
    InvalidEscapeSequence actualInvalidEscapeSequence = new InvalidEscapeSequence("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", actualInvalidEscapeSequence.getMessage());
    assertNull(actualInvalidEscapeSequence.getCause());
    assertEquals(0, actualInvalidEscapeSequence.getSuppressed().length);
  }

  /**
   * Test JsonGenerator {@link JsonGenerator#outdent()}.
   * <p>
   * Method under test: {@link JsonGenerator#outdent()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonGenerator.outdent()"})
  public void testJsonGeneratorOutdent() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new JsonGenerator(new SerializeWriter())).outdent());
  }

  /**
   * Test ParseException {@link ParseException#ParseException(String)}.
   * <p>
   * Method under test: {@link ParseException#ParseException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ParseException.<init>(String)"})
  public void testParseExceptionNewParseException() {
    // Arrange and Act
    ParseException actualParseException = new ParseException("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", actualParseException.getMessage());
    assertNull(actualParseException.getCause());
    assertEquals(0, actualParseException.getSuppressed().length);
  }

  /**
   * Test {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)} with {@code fields}, {@code output}, {@code selfType}.
   * <p>
   * Method under test: {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.print(UnknownFieldSet, Appendable, boolean)"})
  public void testPrintWithFieldsOutputSelfType() throws IOException {
    // Arrange
    UnknownFieldSet fields = UnknownFieldSet.getDefaultInstance();
    StringWriter output = new StringWriter();

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals("{}", output.toString());
  }

  /**
   * Test {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)} with {@code fields}, {@code output}, {@code selfType}.
   * <p>
   * Method under test: {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.print(UnknownFieldSet, Appendable, boolean)"})
  public void testPrintWithFieldsOutputSelfType2() throws IOException {
    // Arrange
    UnknownFieldSet fields = UnknownFieldSet.getDefaultInstance();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(7, output.size());
    assertEquals(8, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult = "alue{".toCharArray();
    assertArrayEquals(expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
  }

  /**
   * Test {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)} with {@code fields}, {@code output}, {@code selfType}.
   * <p>
   * Method under test: {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.print(UnknownFieldSet, Appendable, boolean)"})
  public void testPrintWithFieldsOutputSelfType3() throws IOException {
    // Arrange
    UnknownFieldSet fields = UnknownFieldSet.getDefaultInstance();

    SerializeWriter output = new SerializeWriter(3);
    output.append("Csq");

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(5, output.getBufferLength());
    assertEquals(5, output.size());
    char[] expectedToCharArrayResult = "Csq{}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
    char[] expectedToCharArrayForSpringWebSocketResult = "sq{".toCharArray();
    assertArrayEquals(expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
  }

  /**
   * Test {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)} with {@code fields}, {@code output}, {@code selfType}.
   * <p>
   * Method under test: {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.print(UnknownFieldSet, Appendable, boolean)"})
  public void testPrintWithFieldsOutputSelfType4() throws IOException {
    // Arrange
    UnknownFieldSet fields = UnknownFieldSet.getDefaultInstance();

    SerializeWriter output = new SerializeWriter(3);
    output.setMaxBufSize(10);
    output.append("Csq");

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(5, output.getBufferLength());
    assertEquals(5, output.size());
    char[] expectedToCharArrayResult = "Csq{}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
    char[] expectedToCharArrayForSpringWebSocketResult = "sq{".toCharArray();
    assertArrayEquals(expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
  }

  /**
   * Test {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)} with {@code fields}, {@code output}, {@code selfType}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>Then {@link SerializeWriter#SerializeWriter()} size is nineteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.print(UnknownFieldSet, Appendable, boolean)"})
  public void testPrintWithFieldsOutputSelfType_givenTwo_thenSerializeWriterSizeIsNineteen() throws IOException {
    // Arrange
    Builder newBuilderResult = UnknownFieldSet.newBuilder();
    Field field = Field.newBuilder().build();
    newBuilderResult.addField(2, field);
    Field field2 = Field.newBuilder().build();
    newBuilderResult.addField(10, field2);
    UnknownFieldSet fields = newBuilderResult.build();
    SerializeWriter output = new SerializeWriter();

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(19, output.size());
    assertEquals(2048, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult = "\"2\": [], \"10\": []".toCharArray();
    assertArrayEquals(expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "{\"2\": [], \"10\": []}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
  }

  /**
   * Test {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)} with {@code fields}, {@code output}, {@code selfType}.
   * <ul>
   *   <li>Then {@link SerializeWriter#SerializeWriter()} size is {@link Short#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.print(UnknownFieldSet, Appendable, boolean)"})
  public void testPrintWithFieldsOutputSelfType_thenSerializeWriterSizeIsSize() throws IOException {
    // Arrange
    Field.Builder newBuilderResult = Field.newBuilder();
    UnknownFieldSet value = UnknownFieldSet.newBuilder().build();
    newBuilderResult.addGroup(value);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();
    SerializeWriter output = new SerializeWriter();

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(2048, output.getBufferLength());
    assertEquals(Short.SIZE, output.size());
    char[] expectedToCharArrayForSpringWebSocketResult = "\"10\": [42, {}]".toCharArray();
    assertArrayEquals(expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "{\"10\": [42, {}]}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
  }

  /**
   * Test {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)} with {@code fields}, {@code output}, {@code selfType}.
   * <ul>
   *   <li>Then {@link SerializeWriter#SerializeWriter()} size is thirty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.print(UnknownFieldSet, Appendable, boolean)"})
  public void testPrintWithFieldsOutputSelfType_thenSerializeWriterSizeIsThirtyFour() throws IOException {
    // Arrange
    Field.Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed64(1L);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();
    SerializeWriter output = new SerializeWriter();

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(2048, output.getBufferLength());
    assertEquals(34, output.size());
    char[] expectedToCharArrayForSpringWebSocketResult = "\"10\": [42, \"0x0000000000000001\"]".toCharArray();
    assertArrayEquals(expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "{\"10\": [42, \"0x0000000000000001\"]}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code generator}, {@code selfType}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link MessageOrBuilder#getAllFields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType_givenHashMap_thenCallsGetAllFields() throws IOException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getAllFields()).thenReturn(new HashMap<>());

    // Act
    JsonFormat.print(message, new JsonGenerator(new SerializeWriter()), true);

    // Assert
    verify(message).getAllFields();
  }

  /**
   * Test {@link JsonFormat#print(Message, Appendable, boolean)} with {@code message}, {@code output}, {@code selfType}.
   * <p>
   * Method under test: {@link JsonFormat#print(Message, Appendable, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.print(Message, Appendable, boolean)"})
  public void testPrintWithMessageOutputSelfType() throws IOException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getAllFields()).thenReturn(new HashMap<>());
    StringWriter output = new StringWriter();

    // Act
    JsonFormat.print(message, output, true);

    // Assert
    verify(message).getAllFields();
    assertEquals("{}", output.toString());
  }

  /**
   * Test {@link JsonFormat#print(Message, Appendable, boolean)} with {@code message}, {@code output}, {@code selfType}.
   * <p>
   * Method under test: {@link JsonFormat#print(Message, Appendable, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.print(Message, Appendable, boolean)"})
  public void testPrintWithMessageOutputSelfType2() throws IOException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getAllFields()).thenReturn(new HashMap<>());

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(message, output, true);

    // Assert
    verify(message).getAllFields();
    assertEquals(7, output.size());
    assertEquals(8, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult = "alue{".toCharArray();
    assertArrayEquals(expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
  }

  /**
   * Test {@link JsonFormat#print(Message, Appendable, boolean)} with {@code message}, {@code output}, {@code selfType}.
   * <p>
   * Method under test: {@link JsonFormat#print(Message, Appendable, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.print(Message, Appendable, boolean)"})
  public void testPrintWithMessageOutputSelfType3() throws IOException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getAllFields()).thenReturn(new HashMap<>());

    SerializeWriter output = new SerializeWriter(3);
    output.append("Csq");

    // Act
    JsonFormat.print(message, output, true);

    // Assert
    verify(message).getAllFields();
    assertEquals(5, output.getBufferLength());
    assertEquals(5, output.size());
    char[] expectedToCharArrayResult = "Csq{}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
    char[] expectedToCharArrayForSpringWebSocketResult = "sq{".toCharArray();
    assertArrayEquals(expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
  }

  /**
   * Test {@link JsonFormat#print(Message, Appendable, boolean)} with {@code message}, {@code output}, {@code selfType}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#print(Message, Appendable, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.print(Message, Appendable, boolean)"})
  public void testPrintWithMessageOutputSelfType_givenTen() throws IOException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getAllFields()).thenReturn(new HashMap<>());

    SerializeWriter output = new SerializeWriter(3);
    output.setMaxBufSize(10);
    output.append("Csq");

    // Act
    JsonFormat.print(message, output, true);

    // Assert
    verify(message).getAllFields();
    assertEquals(5, output.getBufferLength());
    assertEquals(5, output.size());
    char[] expectedToCharArrayResult = "Csq{}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
    char[] expectedToCharArrayForSpringWebSocketResult = "sq{".toCharArray();
    assertArrayEquals(expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code selfType}.
   * <ul>
   *   <li>Given newBuilder addVarint one.</li>
   *   <li>Then return {@code {"10": [1, 42]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_givenNewBuilderAddVarintOne_thenReturn10142() {
    // Arrange
    Field.Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(1L);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [1, 42]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code selfType}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then return {@code {"10": []}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_givenTen_thenReturn10() {
    // Arrange
    Builder newBuilderResult = UnknownFieldSet.newBuilder();
    Field field = Field.newBuilder().build();
    newBuilderResult.addField(10, field);
    UnknownFieldSet fields = newBuilderResult.build();

    // Act and Assert
    assertEquals("{\"10\": []}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code selfType}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>Then return {@code {"2": [], "10": []}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_givenTwo_thenReturn210() {
    // Arrange
    Builder newBuilderResult = UnknownFieldSet.newBuilder();
    Field field = Field.newBuilder().build();
    newBuilderResult.addField(2, field);
    Field field2 = Field.newBuilder().build();
    newBuilderResult.addField(10, field2);
    UnknownFieldSet fields = newBuilderResult.build();

    // Act and Assert
    assertEquals("{\"2\": [], \"10\": []}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code {"10": [{}]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn10() {
    // Arrange
    Field.Builder newBuilderResult = Field.newBuilder();
    UnknownFieldSet value = UnknownFieldSet.newBuilder().build();
    newBuilderResult.addGroup(value);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [{}]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code {"10": ["0x0000002a"]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn100x0000002a() {
    // Arrange
    Field.Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed32(42);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [\"0x0000002a\"]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code {"10": ["0x000000000000002a"]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn100x000000000000002a() {
    // Arrange
    Field.Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed64(42L);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [\"0x000000000000002a\"]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code {"10": [42]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn1042() {
    // Arrange
    Field.Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [42]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code {"10": [42, "0x0000000000000001"]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn10420x0000000000000001() {
    // Arrange
    Field.Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed64(1L);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [42, \"0x0000000000000001\"]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code {"10": [42, "0x00000002"]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn10420x00000002() {
    // Arrange
    Field.Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed32(2);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [42, \"0x00000002\"]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code {"10": [42, {}]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn10422() {
    // Arrange
    Field.Builder newBuilderResult = Field.newBuilder();
    UnknownFieldSet value = UnknownFieldSet.newBuilder().build();
    newBuilderResult.addGroup(value);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [42, {}]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code {"10": [18446744073709551615]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn1018446744073709551615() {
    // Arrange
    Field.Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(-1L);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [18446744073709551615]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(UnknownFieldSet.getDefaultInstance(), true));
  }

  /**
   * Test {@link JsonFormat#printToString(Message, boolean)} with {@code message}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(Message, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(Message, boolean)"})
  public void testPrintToStringWithMessageSelfType_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(FeatureSetDefaults.getDefaultInstance(), true));
  }

  /**
   * Test {@link JsonFormat#printToString(Message, boolean)} with {@code message}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(Message, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(Message, boolean)"})
  public void testPrintToStringWithMessageSelfType_thenReturnLeftCurlyBracketRightCurlyBracket2() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(Api.getDefaultInstance(), true));
  }

  /**
   * Test {@link JsonFormat#printToString(Message, boolean)} with {@code message}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(Message, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(Message, boolean)"})
  public void testPrintToStringWithMessageSelfType_thenReturnLeftCurlyBracketRightCurlyBracket3() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(CommonLanguageSettings.getDefaultInstance(), true));
  }

  /**
   * Test {@link JsonFormat#printToString(Message)} with {@code message}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(Message)"})
  public void testPrintToStringWithMessage_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(FeatureSetDefaults.getDefaultInstance()));
  }

  /**
   * Test {@link JsonFormat#printToString(Message)} with {@code message}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(Message)"})
  public void testPrintToStringWithMessage_thenReturnLeftCurlyBracketRightCurlyBracket2() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(Any.getDefaultInstance()));
  }

  /**
   * Test {@link JsonFormat#printToString(Message)} with {@code message}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(Message)"})
  public void testPrintToStringWithMessage_thenReturnLeftCurlyBracketRightCurlyBracket3() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(Api.getDefaultInstance()));
  }

  /**
   * Test {@link JsonFormat#printToString(Message)} with {@code message}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(Message)"})
  public void testPrintToStringWithMessage_thenReturnLeftCurlyBracketRightCurlyBracket4() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(Backend.getDefaultInstance()));
  }

  /**
   * Test {@link JsonFormat#printToString(Message)} with {@code message}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(Message)"})
  public void testPrintToStringWithMessage_thenReturnLeftCurlyBracketRightCurlyBracket5() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(BackendRule.getDefaultInstance()));
  }

  /**
   * Test {@link JsonFormat#printToString(Message)} with {@code message}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printToString(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printToString(Message)"})
  public void testPrintToStringWithMessage_thenReturnLeftCurlyBracketRightCurlyBracket6() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(ClientLibrarySettings.getDefaultInstance()));
  }

  /**
   * Test {@link JsonFormat#printErrorMsg(Exception)}.
   * <ul>
   *   <li>When {@link Exception#Exception(String)} with {@code foo}.</li>
   *   <li>Then return {@code {"Error":"foo"}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printErrorMsg(Exception)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.printErrorMsg(Exception)"})
  public void testPrintErrorMsg_whenExceptionWithFoo_thenReturnErrorFoo() {
    // Arrange, Act and Assert
    assertEquals("{\"Error\":\"foo\"}", JsonFormat.printErrorMsg(new Exception("foo")));
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   * <ul>
   *   <li>Given newBuilder addVarint minus one.</li>
   *   <li>Then calls {@link ByteString#toByteArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenNewBuilderAddVarintMinusOne_thenCallsToByteArray() throws IOException {
    // Arrange
    ByteString value = mock(ByteString.class);
    when(value.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ByteString value2 = mock(ByteString.class);
    when(value2.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ByteString value3 = mock(ByteString.class);
    when(value3.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ByteString value4 = mock(ByteString.class);
    when(value4.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Field.Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(-1L);
    newBuilderResult.addLengthDelimited(value4);
    newBuilderResult.addLengthDelimited(value3);
    newBuilderResult.addLengthDelimited(value2);
    newBuilderResult.addLengthDelimited(value);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet unknownFields = newBuilderResult2.build();

    // Act
    JsonFormat.printUnknownFields(unknownFields, new JsonGenerator(new SerializeWriter()), true);

    // Assert
    verify(value4).toByteArray();
    verify(value3).toByteArray();
    verify(value2).toByteArray();
    verify(value).toByteArray();
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   * <ul>
   *   <li>Then calls {@link ByteString#toByteArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_thenCallsToByteArray() throws IOException {
    // Arrange
    ByteString value = mock(ByteString.class);
    when(value.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Field.Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addLengthDelimited(value);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();
    Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet unknownFields = newBuilderResult2.build();

    // Act
    JsonFormat.printUnknownFields(unknownFields, new JsonGenerator(new SerializeWriter()), true);

    // Assert
    verify(value).toByteArray();
  }

  /**
   * Test {@link JsonFormat#toStringBuilder(Readable)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>Then return toString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#toStringBuilder(Readable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonFormat.toStringBuilder(Readable)"})
  public void testToStringBuilder_givenMinusOne_thenReturnToStringIsEmptyString() throws IOException {
    // Arrange
    Readable input = mock(Readable.class);
    when(input.read(Mockito.<CharBuffer>any())).thenReturn(-1);

    // Act
    StringBuilder actualToStringBuilderResult = JsonFormat.toStringBuilder(input);

    // Assert
    verify(input).read(isA(CharBuffer.class));
    assertEquals("", actualToStringBuilderResult.toString());
  }

  /**
   * Test {@link JsonFormat#escapeBytes(ByteString, String, boolean)} with {@code input}, {@code fliedName}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString, String, boolean)"})
  public void testEscapeBytesWithInputFliedNameSelfType_thenReturn4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualEscapeBytesResult = JsonFormat.escapeBytes(input, "https://example.org/example", true);

    // Assert
    verify(input).toByteArray();
    assertEquals("4158415841584158", actualEscapeBytesResult);
  }

  /**
   * Test {@link JsonFormat#escapeBytes(ByteString, String, boolean)} with {@code input}, {@code fliedName}, {@code selfType}.
   * <ul>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString, String, boolean)"})
  public void testEscapeBytesWithInputFliedNameSelfType_thenReturn41584158415841582()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualEscapeBytesResult = JsonFormat.escapeBytes(input, "https://example.org/example", false);

    // Assert
    verify(input).toByteArray();
    assertEquals("4158415841584158", actualEscapeBytesResult);
  }

  /**
   * Test {@link JsonFormat#escapeBytes(ByteString, String, boolean)} with {@code input}, {@code fliedName}, {@code selfType}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString, String, boolean)"})
  public void testEscapeBytesWithInputFliedNameSelfType_thenThrowRuntimeException() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonFormat.escapeBytes(input, "https://example.org/example", true));
    verify(input).toByteArray();
  }

  /**
   * Test {@link JsonFormat#escapeBytes(ByteString, String, boolean)} with {@code input}, {@code fliedName}, {@code selfType}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString, String, boolean)"})
  public void testEscapeBytesWithInputFliedNameSelfType_thenThrowRuntimeException2() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonFormat.escapeBytes(input, "https://example.org/example", false));
    verify(input).toByteArray();
  }

  /**
   * Test {@link JsonFormat#escapeBytes(ByteString)} with {@code input}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#escapeBytes(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString)"})
  public void testEscapeBytesWithInput_givenAxaxaxaxBytesIsUtf8_thenReturn4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualEscapeBytesResult = JsonFormat.escapeBytes(input);

    // Assert
    verify(input).toByteArray();
    assertEquals("4158415841584158", actualEscapeBytesResult);
  }

  /**
   * Test {@link JsonFormat#escapeBytes(ByteString)} with {@code input}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#escapeBytes(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString)"})
  public void testEscapeBytesWithInput_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonFormat.escapeBytes(input));
    verify(input).toByteArray();
  }

  /**
   * Test {@link JsonFormat#escapeBytesSelfType(ByteString, String)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#escapeBytesSelfType(ByteString, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.escapeBytesSelfType(ByteString, String)"})
  public void testEscapeBytesSelfType_givenAxaxaxaxBytesIsUtf8_thenReturn4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualEscapeBytesSelfTypeResult = JsonFormat.escapeBytesSelfType(input, "https://example.org/example");

    // Assert
    verify(input).toByteArray();
    assertEquals("4158415841584158", actualEscapeBytesSelfTypeResult);
  }

  /**
   * Test {@link JsonFormat#escapeBytesSelfType(ByteString, String)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#escapeBytesSelfType(ByteString, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.escapeBytesSelfType(ByteString, String)"})
  public void testEscapeBytesSelfType_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonFormat.escapeBytesSelfType(input, "https://example.org/example"));
    verify(input).toByteArray();
  }

  /**
   * Test Tokenizer {@link Tokenizer#atEnd()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#atEnd()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.atEnd()"})
  public void testTokenizerAtEnd_givenTokenizerWithTextIsEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Tokenizer("")).atEnd());
  }

  /**
   * Test Tokenizer {@link Tokenizer#atEnd()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#atEnd()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.atEnd()"})
  public void testTokenizerAtEnd_givenTokenizerWithTextIsS_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Tokenizer(PostParams.S_VALUE)).atEnd());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeBoolean()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.consumeBoolean()"})
  public void testTokenizerConsumeBoolean() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(Boolean.TRUE.toString());

    // Act
    boolean actualConsumeBooleanResult = tokenizer.consumeBoolean();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertTrue(actualConsumeBooleanResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeBoolean()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.consumeBoolean()"})
  public void testTokenizerConsumeBoolean2() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(Boolean.FALSE.toString());

    // Act
    boolean actualConsumeBooleanResult = tokenizer.consumeBoolean();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertFalse(actualConsumeBooleanResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeBoolean()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.consumeBoolean()"})
  public void testTokenizerConsumeBoolean3() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder(Boolean.TRUE.toString());
    text.appendCodePoint(1);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    boolean actualConsumeBooleanResult = tokenizer.consumeBoolean();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertTrue(actualConsumeBooleanResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeBoolean()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.consumeBoolean()"})
  public void testTokenizerConsumeBoolean4() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder(Boolean.TRUE.toString());
    text.appendCodePoint(10);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    boolean actualConsumeBooleanResult = tokenizer.consumeBoolean();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertTrue(actualConsumeBooleanResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeBoolean()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.consumeBoolean()"})
  public void testTokenizerConsumeBoolean5() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder(Boolean.TRUE.toString());
    text.appendCodePoint(1);
    text.appendCodePoint(10);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    boolean actualConsumeBooleanResult = tokenizer.consumeBoolean();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertTrue(actualConsumeBooleanResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeBoolean()}.
   * <ul>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.consumeBoolean()"})
  public void testTokenizerConsumeBoolean_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(PostParams.S_VALUE)).consumeBoolean());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeByteString(String, boolean)} with {@code String}, {@code boolean}.
   * <p>
   * Method under test: {@link Tokenizer#consumeByteString(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Tokenizer.consumeByteString(String, boolean)"})
  public void testTokenizerConsumeByteStringWithStringBoolean() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class,
        () -> (new Tokenizer("")).consumeByteString("https://example.org/example", true));
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeByteString(String, boolean)} with {@code String}, {@code boolean}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeByteString(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Tokenizer.consumeByteString(String, boolean)"})
  public void testTokenizerConsumeByteStringWithStringBoolean_givenTokenizerWithTextIsS_value() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class,
        () -> (new Tokenizer(PostParams.S_VALUE)).consumeByteString("https://example.org/example", true));
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeByteString()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeByteString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Tokenizer.consumeByteString()"})
  public void testTokenizerConsumeByteString_givenTokenizerWithTextIsEmptyString() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer("")).consumeByteString());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeByteString()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeByteString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Tokenizer.consumeByteString()"})
  public void testTokenizerConsumeByteString_givenTokenizerWithTextIsS_value() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(PostParams.S_VALUE)).consumeByteString());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeDouble()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("infinity");

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Double.POSITIVE_INFINITY, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeDouble()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble2() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("infinity");
    text.appendCodePoint(10);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Double.POSITIVE_INFINITY, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeDouble()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble3() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("infinity");
    text.append("\u0001\t\u0001\t".toCharArray());
    text.appendCodePoint(10);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertEquals(Double.POSITIVE_INFINITY, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeDouble()}.
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code infinity} appendCodePoint one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble_givenStringBuilderWithInfinityAppendCodePointOne() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("infinity");
    text.appendCodePoint(1);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertEquals(Double.POSITIVE_INFINITY, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeDouble()}.
   * <ul>
   *   <li>Then return {@link Double#NEGATIVE_INFINITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble_thenReturnNegative_infinity() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("infinity");
    text.insert(0, "-");
    text.appendCodePoint(1);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertEquals(Double.NEGATIVE_INFINITY, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeDouble()}.
   * <ul>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(PostParams.S_VALUE)).consumeDouble());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeDouble()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 42} currentToken is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble_thenTokenizerWithTextIs42CurrentTokenIsEmptyString() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("42");

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(42.0d, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeDouble()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code nan} currentToken is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble_thenTokenizerWithTextIsNanCurrentTokenIsEmptyString() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("nan");

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Double.NaN, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeFloat()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("infinity");

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Float.POSITIVE_INFINITY, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeFloat()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat2() throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(42.0f, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeFloat()}.
   * <ul>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(PostParams.S_VALUE)).consumeFloat());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeFloat()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 42} currentToken is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat_thenTokenizerWithTextIs42CurrentTokenIsEmptyString() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("42");

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(42.0f, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeFloat()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code nan} currentToken is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat_thenTokenizerWithTextIsNanCurrentTokenIsEmptyString() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("nan");

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Float.NaN, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeFloat()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code nanf?} currentToken is {@code ?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat_thenTokenizerWithTextIsNanfCurrentTokenIsQuestionMark() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("nanf?");

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("?", tokenizer.currentToken());
    assertEquals(Float.NaN, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeFloat()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link StrBuilder#StrBuilder()} currentToken is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat_thenTokenizerWithTextIsStrBuilderCurrentTokenIs42() throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("nan", "Objs");
    text.appendln("42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals(Float.NaN, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(PostParams.S_VALUE);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(PostParams.S_VALUE, actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier2() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("https://example.org/example");

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals(":", tokenizer.currentToken());
    assertEquals("https", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier3() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(Util.CONTRACT_ADDRESS);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Util.CONTRACT_ADDRESS, actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier4() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(Util.CONTRACT_TYPE);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Util.CONTRACT_TYPE, actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier5() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("\"");

    // Act and Assert
    assertEquals("", tokenizer.consumeIdentifier());
    assertEquals("", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier6() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("42");

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier7() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("\na\na".toCharArray());
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("", tokenizer.consumeIdentifier());
    assertEquals("a", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn0() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 0);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn1() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 1);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("1", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn2() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(2);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("2", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn3() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 3);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("3", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 4a42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn4a42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(4);
    text.append('a');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("4a42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 0.5foo4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn05foo4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append("foo");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.5foo4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 0.5value42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn05value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.5value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 9true4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn9true4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(9);
    text.append(true);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("9true4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 34}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn34() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 34);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("34", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 34false42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn34false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("34false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 34value4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn34value4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("34value4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 42a42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42a42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append('a');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42a42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 42false42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 42foo4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42foo4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append("foo");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42foo4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 42true4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42true4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(true);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42true4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 42value42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 42value4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42value4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42value4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 042}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn042() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 0);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("042", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 46}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn46() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 46);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("46", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 48}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn48() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 48);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("48", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 52}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn52() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 52);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("52", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 65}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn65() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 65);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("65", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 95}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn95() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 95);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("95", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 97}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn97() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 97);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("97", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 97foo4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn97foo4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append("foo");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("97foo4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 97value42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn97value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("97value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 10.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn100() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("10.0", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 10.0a42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn100a42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append('a');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.0a42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 10.0true4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn100true4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append(true);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.0true4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 142}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn142() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 1);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("142", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn422() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("42", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code _42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn423() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('_');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("_42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code .42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn424() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('.');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(".42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 542}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn542() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 5);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("542", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 0.542}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn0542() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.542", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 3442}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn3442() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 34);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("3442", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 04242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn04242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 0);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("04242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 4642}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn4642() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 46);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("4642", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 4842}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn4842() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 48);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("4842", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 6542}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn6542() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 65);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("6542", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 9542}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn9542() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 95);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("9542", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 9742}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn9742() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("9742", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 10.042}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn10042() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.042", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 14242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn14242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 1);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("14242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 0.54242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn054242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.54242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 0.59742}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn059742() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append(97);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.59742", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 74242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn74242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 7);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("74242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 340.542}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn340542() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append(0.5f);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("340.542", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 344242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn344242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("344242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 420.542}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn420542() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(0.5f);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("420.542", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 424242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn424242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("424242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 429742}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn429742() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(97);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("429742", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 464242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn464242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 46);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("464242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 484242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn484242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 48);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("484242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 654242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn654242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 65);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("654242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 954242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn954242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 95);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("954242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 974242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn974242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 97);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("974242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 979742}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn979742() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append(97);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("979742", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 10.04242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn1004242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.04242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 0.5344242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn05344242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append(34);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.5344242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 7424242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn7424242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(7);
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("7424242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 42344242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42344242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(34);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42344242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 42424242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42424242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42424242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 97344242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn97344242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append(34);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("97344242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 10.0424242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn100424242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.0424242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 922337203685477580742}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn922337203685477580742() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("922337203685477580742", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code 92233720368547758074242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn92233720368547758074242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("92233720368547758074242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code a42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnA42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("a42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code A42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnA422() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('A');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("A42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code A4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnA4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('A');
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("A4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code a9742}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnA9742() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append(97);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("a9742", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code a4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnA42422() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("a4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code a344242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnA344242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append(34);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("a344242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code afoo4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnAfoo4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append("foo");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("afoo4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code avalue42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnAvalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("avalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code Contract}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnContract() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(Wallet.CONTRACT_VALIDATE_ERROR);

    // Act and Assert
    assertEquals("Contract", tokenizer.consumeIdentifier());
    assertEquals("validate", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnEmptyString() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code false42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code false4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalse4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("false4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code false9742}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalse9742() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(97);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("false9742", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code false344242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalse344242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(34);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("false344242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code false424242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalse424242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("false424242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@link Boolean#FALSE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalseToString() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("|", tokenizer.currentToken());
    assertEquals(Boolean.FALSE.toString(), actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code falsefalse42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalsefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("falsefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code falsevalue4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalsevalue4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("falsevalue4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoo() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "foo");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foo", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code foo42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoo42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "foo");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foo42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code foo0.542}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoo0542() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append(0.5f);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foo0.542", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code foo4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoo4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foo4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code foofalse42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoofalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foofalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code foovalue4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoovalue4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foovalue4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code NaN42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnNaN42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(Float.NaN);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("NaN42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code NaN4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnNaN4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(Float.NaN);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("NaN4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@link PostParams#S_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnS_value() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("|", tokenizer.currentToken());
    assertEquals(PostParams.S_VALUE, actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code true42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTrue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("true42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code true0.542}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTrue0542() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append(0.5f);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("true0.542", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code true4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTrue4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("true4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code truea42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTruea42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append('a');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("truea42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code truefoo4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTruefoo4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append("foo");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("truefoo4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code truetrue4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTruetrue4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append(true);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("truetrue4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code truevalue42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTruevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("truevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code value42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code value0.542}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue0542() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(0.5f);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value0.542", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code value4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code value9742}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue9742() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(97);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value9742", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code value344242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue344242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(34);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value344242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code value424242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue424242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value424242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code valuea42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuea42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append('a');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuea42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code valuefalse42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code valuefoo4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuefoo4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append("foo");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuefoo4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code valuetrue4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuetrue4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(true);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuetrue4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code valuevalue42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code valuevalue4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuevalue4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuevalue4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code Z42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnZ42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('Z');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("Z42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code z42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnZ422() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('z');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("z42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code Z4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnZ4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('Z');
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("Z4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then return {@code z4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnZ42422() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('z');
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("z4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   * <ul>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer("\"|'")).consumeIdentifier());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    int actualConsumeInt32Result = tokenizer.consumeInt32();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(-42, actualConsumeInt32Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code 0x} append {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenStringBuilderWith0xAppendMax_value() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("0x");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");

    // Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(text)).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code 0x} append {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenStringBuilderWith0xAppendMin_value() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("0x");
    text.append((Object) Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(text)).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code -} append {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenStringBuilderWithDashAppendMax_value() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");

    // Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(text)).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code -} append {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenStringBuilderWithDashAppendMin_value() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append((Object) Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(text)).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0x}.</li>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenTokenizerWithTextIs0x_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer("0x")).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link Util#CONTRACT_ADDRESS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenTokenizerWithTextIsContract_address() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(Util.CONTRACT_ADDRESS)).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code -}.</li>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenTokenizerWithTextIsDash_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer("-")).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenTokenizerWithTextIsS_value() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(PostParams.S_VALUE)).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0} currentToken is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_thenTokenizerWithTextIs0CurrentTokenIsEmptyString() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("0");

    // Act
    int actualConsumeInt32Result = tokenizer.consumeInt32();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(0, actualConsumeInt32Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    long actualConsumeInt64Result = tokenizer.consumeInt64();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(-42L, actualConsumeInt64Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code 0x} append {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_givenStringBuilderWith0xAppendMax_value() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("0x");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");

    // Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(text)).consumeInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code -} append {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_givenStringBuilderWithDashAppendMax_value() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");

    // Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(text)).consumeInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0x}.</li>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_givenTokenizerWithTextIs0x_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer("0x")).consumeInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link Util#CONTRACT_ADDRESS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_givenTokenizerWithTextIsContract_address() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(Util.CONTRACT_ADDRESS)).consumeInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code -}.</li>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_givenTokenizerWithTextIsDash_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer("-")).consumeInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_givenTokenizerWithTextIsS_value() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(PostParams.S_VALUE)).consumeInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0} currentToken is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_thenTokenizerWithTextIs0CurrentTokenIsEmptyString() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("0");

    // Act
    long actualConsumeInt64Result = tokenizer.consumeInt64();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(0L, actualConsumeInt64Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt322() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append("1\n\u0001\n".toCharArray());
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    int actualConsumeInt32Result = tokenizer.consumeInt32();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertEquals(-1, actualConsumeInt32Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt642() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append("1\n\u0001\n".toCharArray());
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    long actualConsumeInt64Result = tokenizer.consumeInt64();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertEquals(-1L, actualConsumeInt64Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt643() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append(Long.MAX_VALUE);
    text.append((Object) ":");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    long actualConsumeInt64Result = tokenizer.consumeInt64();

    // Assert
    assertEquals(":", tokenizer.currentToken());
    assertEquals(-9223372036854775807L, actualConsumeInt64Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeString()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeString()"})
  public void testTokenizerConsumeString_givenTokenizerWithTextIsEmptyString() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer("")).consumeString());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeString()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.consumeString()"})
  public void testTokenizerConsumeString_givenTokenizerWithTextIsS_value() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(PostParams.S_VALUE)).consumeString());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32() throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    int actualConsumeUInt32Result = tokenizer.consumeUInt32();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(42, actualConsumeUInt32Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0x}.</li>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32_givenTokenizerWithTextIs0x_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer("0x")).consumeUInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link Util#CONTRACT_ADDRESS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32_givenTokenizerWithTextIsContract_address() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(Util.CONTRACT_ADDRESS)).consumeUInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code -}.</li>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32_givenTokenizerWithTextIsDash_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer("-")).consumeUInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32_givenTokenizerWithTextIsS_value() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(PostParams.S_VALUE)).consumeUInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0} currentToken is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32_thenTokenizerWithTextIs0CurrentTokenIsEmptyString() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("0");

    // Act
    int actualConsumeUInt32Result = tokenizer.consumeUInt32();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(0, actualConsumeUInt32Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link StrBuilder#StrBuilder()} currentToken is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32_thenTokenizerWithTextIsStrBuilderCurrentTokenIs42() throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("0");
    text.appendln("42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    int actualConsumeUInt32Result = tokenizer.consumeUInt32();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals(0, actualConsumeUInt32Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64() throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    long actualConsumeUInt64Result = tokenizer.consumeUInt64();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(42L, actualConsumeUInt64Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0x}.</li>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64_givenTokenizerWithTextIs0x_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer("0x")).consumeUInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link Util#CONTRACT_ADDRESS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64_givenTokenizerWithTextIsContract_address() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(Util.CONTRACT_ADDRESS)).consumeUInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code -}.</li>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64_givenTokenizerWithTextIsDash_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer("-")).consumeUInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64_givenTokenizerWithTextIsS_value() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> (new Tokenizer(PostParams.S_VALUE)).consumeUInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0} currentToken is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64_thenTokenizerWithTextIs0CurrentTokenIsEmptyString() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("0");

    // Act
    long actualConsumeUInt64Result = tokenizer.consumeUInt64();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(0L, actualConsumeUInt64Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link StrBuilder#StrBuilder()} currentToken is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64_thenTokenizerWithTextIsStrBuilderCurrentTokenIs42() throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("0");
    text.appendln("42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    long actualConsumeUInt64Result = tokenizer.consumeUInt64();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals(0L, actualConsumeUInt64Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt322() throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendFixedWidthPadRight(Short.SIZE, 3, '\u0002');
    text.appendln("42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    int actualConsumeUInt32Result = tokenizer.consumeUInt32();

    // Assert
    assertEquals("\u0002", tokenizer.currentToken());
    assertEquals(Short.SIZE, actualConsumeUInt32Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   * <p>
   * Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt642() throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendFixedWidthPadRight(10, 3, '\u0010');
    text.appendln("42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    long actualConsumeUInt64Result = tokenizer.consumeUInt64();

    // Assert
    assertEquals("\u0010", tokenizer.currentToken());
    assertEquals(10L, actualConsumeUInt64Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consume(String)}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE} currentToken is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consume(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Tokenizer.consume(String)"})
  public void testTokenizerConsume_thenTokenizerWithTextIsS_valueCurrentTokenIsEmptyString() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(PostParams.S_VALUE);

    // Act
    tokenizer.consume(PostParams.S_VALUE);

    // Assert
    assertEquals("", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consume(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then throw {@link ParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#consume(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Tokenizer.consume(String)"})
  public void testTokenizerConsume_whenHttpsExampleOrgExample_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class,
        () -> (new Tokenizer(PostParams.S_VALUE)).consume("https://example.org/example"));
  }

  /**
   * Test Tokenizer {@link Tokenizer#currentToken()}.
   * <p>
   * Method under test: {@link Tokenizer#currentToken()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Tokenizer.currentToken()"})
  public void testTokenizerCurrentToken() {
    // Arrange, Act and Assert
    assertEquals(PostParams.S_VALUE, (new Tokenizer(PostParams.S_VALUE)).currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtBoolean()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#lookingAtBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.lookingAtBoolean()"})
  public void testTokenizerLookingAtBoolean_givenTokenizerWithTextIsEmptyString() {
    // Arrange, Act and Assert
    assertFalse((new Tokenizer("")).lookingAtBoolean());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtBoolean()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link Boolean#FALSE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#lookingAtBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.lookingAtBoolean()"})
  public void testTokenizerLookingAtBoolean_givenTokenizerWithTextIsFalseToString() {
    // Arrange, Act and Assert
    assertTrue((new Tokenizer(Boolean.FALSE.toString())).lookingAtBoolean());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtBoolean()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#lookingAtBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.lookingAtBoolean()"})
  public void testTokenizerLookingAtBoolean_givenTokenizerWithTextIsS_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Tokenizer(PostParams.S_VALUE)).lookingAtBoolean());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtBoolean()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#lookingAtBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.lookingAtBoolean()"})
  public void testTokenizerLookingAtBoolean_givenTokenizerWithTextIsTrueToString() {
    // Arrange, Act and Assert
    assertTrue((new Tokenizer(Boolean.TRUE.toString())).lookingAtBoolean());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtInteger()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#lookingAtInteger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.lookingAtInteger()"})
  public void testTokenizerLookingAtInteger_givenTokenizerWithTextIs42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Tokenizer("42")).lookingAtInteger());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtInteger()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code -}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#lookingAtInteger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.lookingAtInteger()"})
  public void testTokenizerLookingAtInteger_givenTokenizerWithTextIsDash_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Tokenizer("-")).lookingAtInteger());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtInteger()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#lookingAtInteger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.lookingAtInteger()"})
  public void testTokenizerLookingAtInteger_givenTokenizerWithTextIsEmptyString() {
    // Arrange, Act and Assert
    assertFalse((new Tokenizer("")).lookingAtInteger());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtInteger()}.
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#lookingAtInteger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.lookingAtInteger()"})
  public void testTokenizerLookingAtInteger_givenTokenizerWithTextIsS_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Tokenizer(PostParams.S_VALUE)).lookingAtInteger());
  }

  /**
   * Test Tokenizer {@link Tokenizer#Tokenizer(CharSequence)}.
   * <ul>
   *   <li>Then return currentToken is enquiry.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#Tokenizer(CharSequence)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Tokenizer.<init>(CharSequence)"})
  public void testTokenizerNewTokenizer_thenReturnCurrentTokenIsEnquiry() {
    // Arrange, Act and Assert
    assertEquals("\u0005", (new Tokenizer(new NameImpl("\u0005\u0001\u0005\u0001".toCharArray()))).currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#Tokenizer(CharSequence)}.
   * <ul>
   *   <li>When lineSeparator.</li>
   *   <li>Then return currentToken is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#Tokenizer(CharSequence)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Tokenizer.<init>(CharSequence)"})
  public void testTokenizerNewTokenizer_whenLineSeparator_thenReturnCurrentTokenIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new Tokenizer(System.lineSeparator())).currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#Tokenizer(CharSequence)}.
   * <ul>
   *   <li>When {@link PostParams#S_VALUE}.</li>
   *   <li>Then return currentToken is {@link PostParams#S_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#Tokenizer(CharSequence)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Tokenizer.<init>(CharSequence)"})
  public void testTokenizerNewTokenizer_whenS_value_thenReturnCurrentTokenIsS_value() {
    // Arrange, Act and Assert
    assertEquals(PostParams.S_VALUE, (new Tokenizer(PostParams.S_VALUE)).currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#Tokenizer(CharSequence)}.
   * <ul>
   *   <li>When space space space.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#Tokenizer(CharSequence)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Tokenizer.<init>(CharSequence)"})
  public void testTokenizerNewTokenizer_whenSpaceSpaceSpace() {
    // Arrange, Act and Assert
    assertEquals("", (new Tokenizer("   ")).currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#nextToken()}.
   * <p>
   * Method under test: {@link Tokenizer#nextToken()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Tokenizer.nextToken()"})
  public void testTokenizerNextToken() {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("https://example.org/example");

    // Act
    tokenizer.nextToken();

    // Assert
    assertEquals(":", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#nextToken()}.
   * <p>
   * Method under test: {@link Tokenizer#nextToken()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Tokenizer.nextToken()"})
  public void testTokenizerNextToken2() {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(Wallet.CONTRACT_VALIDATE_ERROR);

    // Act
    tokenizer.nextToken();

    // Assert
    assertEquals("validate", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#nextToken()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link NameImpl#NameImpl(char[])} currentToken is enquiry.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#nextToken()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Tokenizer.nextToken()"})
  public void testTokenizerNextToken_thenTokenizerWithTextIsNameImplCurrentTokenIsEnquiry() {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(new NameImpl("\u0005\n\u0005\n".toCharArray()));

    // Act
    tokenizer.nextToken();

    // Assert that nothing has changed
    assertEquals("\u0005", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#nextToken()}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE} currentToken is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#nextToken()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Tokenizer.nextToken()"})
  public void testTokenizerNextToken_thenTokenizerWithTextIsS_valueCurrentTokenIsEmptyString() {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(PostParams.S_VALUE);

    // Act
    tokenizer.nextToken();

    // Assert
    assertEquals("", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#parseException(String)}.
   * <p>
   * Method under test: {@link Tokenizer#parseException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParseException Tokenizer.parseException(String)"})
  public void testTokenizerParseException() {
    // Arrange and Act
    ParseException actualParseExceptionResult = (new Tokenizer(PostParams.S_VALUE))
        .parseException("https://example.org/example");

    // Assert
    assertEquals("1:1: https://example.org/example", actualParseExceptionResult.getLocalizedMessage());
    assertEquals("1:1: https://example.org/example", actualParseExceptionResult.getMessage());
    assertNull(actualParseExceptionResult.getCause());
    assertEquals(0, actualParseExceptionResult.getSuppressed().length);
  }

  /**
   * Test Tokenizer {@link Tokenizer#parseExceptionPreviousToken(String)}.
   * <p>
   * Method under test: {@link Tokenizer#parseExceptionPreviousToken(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParseException Tokenizer.parseExceptionPreviousToken(String)"})
  public void testTokenizerParseExceptionPreviousToken() {
    // Arrange and Act
    ParseException actualParseExceptionPreviousTokenResult = (new Tokenizer(PostParams.S_VALUE))
        .parseExceptionPreviousToken("https://example.org/example");

    // Assert
    assertEquals("1:1: https://example.org/example", actualParseExceptionPreviousTokenResult.getLocalizedMessage());
    assertEquals("1:1: https://example.org/example", actualParseExceptionPreviousTokenResult.getMessage());
    assertNull(actualParseExceptionPreviousTokenResult.getCause());
    assertEquals(0, actualParseExceptionPreviousTokenResult.getSuppressed().length);
  }

  /**
   * Test Tokenizer {@link Tokenizer#tryConsume(String)}.
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE} currentToken is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#tryConsume(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.tryConsume(String)"})
  public void testTokenizerTryConsume_thenTokenizerWithTextIsS_valueCurrentTokenIsEmptyString() {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(PostParams.S_VALUE);

    // Act
    boolean actualTryConsumeResult = tokenizer.tryConsume(PostParams.S_VALUE);

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertTrue(actualTryConsumeResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#tryConsume(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#tryConsume(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Tokenizer.tryConsume(String)"})
  public void testTokenizerTryConsume_whenHttpsExampleOrgExample_thenReturnFalse() {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(PostParams.S_VALUE);

    // Act and Assert
    assertFalse(tokenizer.tryConsume("https://example.org/example"));
    assertEquals(PostParams.S_VALUE, tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytesSelfType(String, String)}.
   * <ul>
   *   <li>Then throw {@link InvalidEscapeSequence}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#unescapeBytesSelfType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytesSelfType(String, String)"})
  public void testTokenizerUnescapeBytesSelfType_thenThrowInvalidEscapeSequence() throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class,
        () -> Tokenizer.unescapeBytesSelfType("https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytesSelfType(String, String)}.
   * <ul>
   *   <li>When {@code 0x}.</li>
   *   <li>Then return toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#unescapeBytesSelfType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytesSelfType(String, String)"})
  public void testTokenizerUnescapeBytesSelfType_when0x_thenReturnToStringUtf8IsEmptyString()
      throws InvalidEscapeSequence {
    // Arrange and Act
    ByteString actualUnescapeBytesSelfTypeResult = Tokenizer.unescapeBytesSelfType("0x", "https://example.org/example");

    // Assert
    assertEquals("", actualUnescapeBytesSelfTypeResult.toStringUtf8());
    assertFalse(actualUnescapeBytesSelfTypeResult.iterator().hasNext());
    assertTrue(actualUnescapeBytesSelfTypeResult.isEmpty());
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytesSelfType(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#unescapeBytesSelfType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytesSelfType(String, String)"})
  public void testTokenizerUnescapeBytesSelfType_whenEmptyString() throws InvalidEscapeSequence {
    // Arrange and Act
    ByteString actualUnescapeBytesSelfTypeResult = Tokenizer.unescapeBytesSelfType("", "https://example.org/example");

    // Assert
    assertEquals("", actualUnescapeBytesSelfTypeResult.toStringUtf8());
    assertFalse(actualUnescapeBytesSelfTypeResult.iterator().hasNext());
    assertTrue(actualUnescapeBytesSelfTypeResult.isEmpty());
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytesSelfType(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link InvalidEscapeSequence}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#unescapeBytesSelfType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytesSelfType(String, String)"})
  public void testTokenizerUnescapeBytesSelfType_whenNull_thenThrowInvalidEscapeSequence()
      throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class,
        () -> Tokenizer.unescapeBytesSelfType(null, "https://example.org/example"));
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytes(CharSequence)}.
   * <ul>
   *   <li>When {@code 0x}.</li>
   *   <li>Then return toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytes(CharSequence)"})
  public void testTokenizerUnescapeBytes_when0x_thenReturnToStringUtf8IsEmptyString() throws InvalidEscapeSequence {
    // Arrange and Act
    ByteString actualUnescapeBytesResult = Tokenizer.unescapeBytes("0x");

    // Assert
    assertEquals("", actualUnescapeBytesResult.toStringUtf8());
    assertFalse(actualUnescapeBytesResult.iterator().hasNext());
    assertTrue(actualUnescapeBytesResult.isEmpty());
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytes(CharSequence)}.
   * <ul>
   *   <li>When {@link Util#CALL_DATA}.</li>
   *   <li>Then throw {@link InvalidEscapeSequence}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytes(CharSequence)"})
  public void testTokenizerUnescapeBytes_whenCall_data_thenThrowInvalidEscapeSequence() throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class, () -> Tokenizer.unescapeBytes(Util.CALL_DATA));
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytes(CharSequence)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link InvalidEscapeSequence}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytes(CharSequence)"})
  public void testTokenizerUnescapeBytes_whenNull_thenThrowInvalidEscapeSequence() throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class, () -> Tokenizer.unescapeBytes(null));
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytes(CharSequence)}.
   * <ul>
   *   <li>When {@link PostParams#S_VALUE}.</li>
   *   <li>Then throw {@link InvalidEscapeSequence}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tokenizer#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytes(CharSequence)"})
  public void testTokenizerUnescapeBytes_whenS_value_thenThrowInvalidEscapeSequence() throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class, () -> Tokenizer.unescapeBytes(PostParams.S_VALUE));
  }

  /**
   * Test {@link JsonFormat#unicodeEscaped(char)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code \u0041}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#unicodeEscaped(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.unicodeEscaped(char)"})
  public void testUnicodeEscaped_whenA_thenReturnU0041() {
    // Arrange, Act and Assert
    assertEquals("\\u0041", JsonFormat.unicodeEscaped('A'));
  }

  /**
   * Test {@link JsonFormat#unicodeEscaped(char)}.
   * <ul>
   *   <li>When shift in.</li>
   *   <li>Then return {@code \u000f}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#unicodeEscaped(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.unicodeEscaped(char)"})
  public void testUnicodeEscaped_whenShiftIn_thenReturnU000f() {
    // Arrange, Act and Assert
    assertEquals("\\u000f", JsonFormat.unicodeEscaped('\u000f'));
  }

  /**
   * Test {@link JsonFormat#unicodeEscaped(char)}.
   * <ul>
   *   <li>When {@code Ā}.</li>
   *   <li>Then return {@code \u0100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#unicodeEscaped(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.unicodeEscaped(char)"})
  public void testUnicodeEscaped_when_thenReturnU0100() {
    // Arrange, Act and Assert
    assertEquals("\\u0100", JsonFormat.unicodeEscaped('Ā'));
  }

  /**
   * Test {@link JsonFormat#unicodeEscaped(char)}.
   * <ul>
   *   <li>When {@code က}.</li>
   *   <li>Then return {@code \u1000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#unicodeEscaped(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.unicodeEscaped(char)"})
  public void testUnicodeEscaped_when_thenReturnU1000() {
    // Arrange, Act and Assert
    assertEquals("\\u1000", JsonFormat.unicodeEscaped('က'));
  }

  /**
   * Test {@link JsonFormat#unescapeBytes(CharSequence)}.
   * <ul>
   *   <li>When {@code 0x}.</li>
   *   <li>Then return toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString JsonFormat.unescapeBytes(CharSequence)"})
  public void testUnescapeBytes_when0x_thenReturnToStringUtf8IsEmptyString() throws InvalidEscapeSequence {
    // Arrange and Act
    ByteString actualUnescapeBytesResult = JsonFormat.unescapeBytes("0x");

    // Assert
    assertEquals("", actualUnescapeBytesResult.toStringUtf8());
    assertFalse(actualUnescapeBytesResult.iterator().hasNext());
    assertTrue(actualUnescapeBytesResult.isEmpty());
  }

  /**
   * Test {@link JsonFormat#unescapeBytes(CharSequence)}.
   * <ul>
   *   <li>When {@link Util#CALL_DATA}.</li>
   *   <li>Then throw {@link InvalidEscapeSequence}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString JsonFormat.unescapeBytes(CharSequence)"})
  public void testUnescapeBytes_whenCall_data_thenThrowInvalidEscapeSequence() throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class, () -> JsonFormat.unescapeBytes(Util.CALL_DATA));
  }

  /**
   * Test {@link JsonFormat#unescapeBytes(CharSequence)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link InvalidEscapeSequence}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString JsonFormat.unescapeBytes(CharSequence)"})
  public void testUnescapeBytes_whenNull_thenThrowInvalidEscapeSequence() throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class, () -> JsonFormat.unescapeBytes(null));
  }

  /**
   * Test {@link JsonFormat#unescapeBytes(CharSequence)}.
   * <ul>
   *   <li>When {@link PostParams#S_VALUE}.</li>
   *   <li>Then throw {@link InvalidEscapeSequence}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString JsonFormat.unescapeBytes(CharSequence)"})
  public void testUnescapeBytes_whenS_value_thenThrowInvalidEscapeSequence() throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class, () -> JsonFormat.unescapeBytes(PostParams.S_VALUE));
  }

  /**
   * Test {@link JsonFormat#escapeText(String)}.
   * <p>
   * Method under test: {@link JsonFormat#escapeText(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.escapeText(String)"})
  public void testEscapeText() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\\\\\"", JsonFormat.escapeText("\\\\\""));
  }

  /**
   * Test {@link JsonFormat#escapeText(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#escapeText(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.escapeText(String)"})
  public void testEscapeText_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", JsonFormat.escapeText("https://example.org/example"));
  }

  /**
   * Test {@link JsonFormat#escapeText(String)}.
   * <ul>
   *   <li>When {@code "}.</li>
   *   <li>Then return {@code \"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#escapeText(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.escapeText(String)"})
  public void testEscapeText_whenQuotationMark_thenReturnBackslashQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\\\"", JsonFormat.escapeText("\""));
  }

  /**
   * Test {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code foo\u0041}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.appendEscapedUnicode(StringBuilder, char)"})
  public void testAppendEscapedUnicode_whenA_thenStringBuilderWithFooToStringIsFooU0041() {
    // Arrange
    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonFormat.appendEscapedUnicode(builder, 'A');

    // Assert
    assertEquals("foo\\u0041", builder.toString());
  }

  /**
   * Test {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}.
   * <ul>
   *   <li>When shift in.</li>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code foo\u000f}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.appendEscapedUnicode(StringBuilder, char)"})
  public void testAppendEscapedUnicode_whenShiftIn_thenStringBuilderWithFooToStringIsFooU000f() {
    // Arrange
    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonFormat.appendEscapedUnicode(builder, '\u000f');

    // Assert
    assertEquals("foo\\u000f", builder.toString());
  }

  /**
   * Test {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}.
   * <ul>
   *   <li>When {@code Ā}.</li>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code foo\u0100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.appendEscapedUnicode(StringBuilder, char)"})
  public void testAppendEscapedUnicode_when_thenStringBuilderWithFooToStringIsFooU0100() {
    // Arrange
    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonFormat.appendEscapedUnicode(builder, 'Ā');

    // Assert
    assertEquals("foo\\u0100", builder.toString());
  }

  /**
   * Test {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}.
   * <ul>
   *   <li>When {@code က}.</li>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code foo\u1000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonFormat.appendEscapedUnicode(StringBuilder, char)"})
  public void testAppendEscapedUnicode_when_thenStringBuilderWithFooToStringIsFooU1000() {
    // Arrange
    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonFormat.appendEscapedUnicode(builder, 'က');

    // Assert
    assertEquals("foo\\u1000", builder.toString());
  }

  /**
   * Test {@link JsonFormat#unescapeText(String)}.
   * <ul>
   *   <li>Then return {@code \"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#unescapeText(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.unescapeText(String)"})
  public void testUnescapeText_thenReturnBackslashQuotationMark() throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertEquals("\\\"", JsonFormat.unescapeText("\\\\\""));
  }

  /**
   * Test {@link JsonFormat#unescapeText(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#unescapeText(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonFormat.unescapeText(String)"})
  public void testUnescapeText_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample()
      throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", JsonFormat.unescapeText("https://example.org/example"));
  }

  /**
   * Test {@link JsonFormat#parseInt32(String)}.
   * <ul>
   *   <li>When {@code 0}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#parseInt32(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JsonFormat.parseInt32(String)"})
  public void testParseInt32_when0_thenReturnZero() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0, JsonFormat.parseInt32("0"));
  }

  /**
   * Test {@link JsonFormat#parseInt32(String)}.
   * <ul>
   *   <li>When {@code -0}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#parseInt32(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JsonFormat.parseInt32(String)"})
  public void testParseInt32_when0_thenReturnZero2() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0, JsonFormat.parseInt32("-0"));
  }

  /**
   * Test {@link JsonFormat#parseUInt32(String)}.
   * <ul>
   *   <li>When {@code 0}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#parseUInt32(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JsonFormat.parseUInt32(String)"})
  public void testParseUInt32_when0_thenReturnZero() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0, JsonFormat.parseUInt32("0"));
  }

  /**
   * Test {@link JsonFormat#parseUInt32(String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#parseUInt32(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JsonFormat.parseUInt32(String)"})
  public void testParseUInt32_whenDash_thenThrowNumberFormatException() throws NumberFormatException {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> JsonFormat.parseUInt32("-"));
  }

  /**
   * Test {@link JsonFormat#parseInt64(String)}.
   * <ul>
   *   <li>When {@code 0}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#parseInt64(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonFormat.parseInt64(String)"})
  public void testParseInt64_when0_thenReturnZero() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonFormat.parseInt64("0"));
  }

  /**
   * Test {@link JsonFormat#parseInt64(String)}.
   * <ul>
   *   <li>When {@code -0}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#parseInt64(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonFormat.parseInt64(String)"})
  public void testParseInt64_when0_thenReturnZero2() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonFormat.parseInt64("-0"));
  }

  /**
   * Test {@link JsonFormat#parseUInt64(String)}.
   * <ul>
   *   <li>When {@code 0}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#parseUInt64(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonFormat.parseUInt64(String)"})
  public void testParseUInt64_when0_thenReturnZero() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonFormat.parseUInt64("0"));
  }

  /**
   * Test {@link JsonFormat#parseUInt64(String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonFormat#parseUInt64(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonFormat.parseUInt64(String)"})
  public void testParseUInt64_whenDash_thenThrowNumberFormatException() throws NumberFormatException {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> JsonFormat.parseUInt64("-"));
  }
}
