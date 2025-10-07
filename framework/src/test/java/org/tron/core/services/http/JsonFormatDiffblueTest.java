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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.MessageOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet.Builder;
import com.google.protobuf.UnknownFieldSet.Field;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.util.HashMap;
import javax.swing.text.Segment;
import org.apache.commons.lang3.text.StrBuilder;
import org.aspectj.org.eclipse.jdt.internal.compiler.apt.model.NameImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.services.http.JsonFormat.InvalidEscapeSequence;
import org.tron.core.services.http.JsonFormat.JsonGenerator;
import org.tron.core.services.http.JsonFormat.ParseException;
import org.tron.core.services.http.JsonFormat.Tokenizer;

public class JsonFormatDiffblueTest {
  /**
   * Test InvalidEscapeSequence {@link InvalidEscapeSequence#InvalidEscapeSequence(String)}.
   *
   * <p>Method under test: {@link InvalidEscapeSequence#InvalidEscapeSequence(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvalidEscapeSequence.<init>(String)"})
  public void testInvalidEscapeSequenceNewInvalidEscapeSequence() {
    // Arrange and Act
    InvalidEscapeSequence actualInvalidEscapeSequence =
        new InvalidEscapeSequence("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", actualInvalidEscapeSequence.getMessage());
    assertNull(actualInvalidEscapeSequence.getCause());
    assertEquals(0, actualInvalidEscapeSequence.getSuppressed().length);
  }

  /**
   * Test JsonGenerator {@link JsonGenerator#outdent()}.
   *
   * <p>Method under test: {@link JsonGenerator#outdent()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonGenerator.outdent()"})
  public void testJsonGeneratorOutdent() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new JsonGenerator(new SerializeWriter()).outdent());
  }

  /**
   * Test ParseException {@link ParseException#ParseException(String)}.
   *
   * <p>Method under test: {@link ParseException#ParseException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)} with {@code fields}, {@code
   * output}, {@code selfType}.
   *
   * <p>Method under test: {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)} with {@code fields}, {@code
   * output}, {@code selfType}.
   *
   * <ul>
   *   <li>Then {@link SerializeWriter#SerializeWriter()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(UnknownFieldSet, Appendable, boolean)"})
  public void testPrintWithFieldsOutputSelfType_thenSerializeWriterSizeIsTwo() throws IOException {
    // Arrange
    UnknownFieldSet fields = UnknownFieldSet.getDefaultInstance();
    SerializeWriter output = new SerializeWriter();

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(2, output.size());
    assertArrayEquals(new char[] {}, output.toCharArrayForSpringWebSocket());
    assertArrayEquals(new char[] {'{', '}'}, output.toCharArray());
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code
   * selfType}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then return {@code {"10": []}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_givenTen_thenReturn10() {
    // Arrange
    Builder newBuilderResult = UnknownFieldSet.newBuilder();
    newBuilderResult.addField(10, Field.newBuilder().build());
    UnknownFieldSet fields = newBuilderResult.build();

    // Act and Assert
    assertEquals("{\"10\": []}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code
   * selfType}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then return {@code {"2": [], "10": []}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_givenTwo_thenReturn210() {
    // Arrange
    Builder newBuilderResult = UnknownFieldSet.newBuilder();
    newBuilderResult.addField(2, Field.newBuilder().build());
    newBuilderResult.addField(10, Field.newBuilder().build());
    UnknownFieldSet fields = newBuilderResult.build();

    // Act and Assert
    assertEquals("{\"2\": [], \"10\": []}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code
   * selfType}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(UnknownFieldSet.getDefaultInstance(), true));
  }

  /**
   * Test {@link JsonFormat#printToString(Message)} with {@code message}.
   *
   * <p>Method under test: {@link JsonFormat#printToString(Message)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(Message)"})
  public void testPrintToStringWithMessage() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(MessageOptions.getDefaultInstance()));
  }

  /**
   * Test {@link JsonFormat#printToString(Message, boolean)} with {@code message}, {@code selfType}.
   *
   * <p>Method under test: {@link JsonFormat#printToString(Message, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(Message, boolean)"})
  public void testPrintToStringWithMessageSelfType() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(MessageOptions.getDefaultInstance(), true));
  }

  /**
   * Test {@link JsonFormat#printErrorMsg(Exception)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then return {@code {"Error":"null"}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printErrorMsg(Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printErrorMsg(Exception)"})
  public void testPrintErrorMsg_whenException_thenReturnErrorNull() {
    // Arrange, Act and Assert
    assertEquals("{\"Error\":\"null\"}", JsonFormat.printErrorMsg(new Exception()));
  }

  /**
   * Test {@link JsonFormat#printField(FieldDescriptor, Object, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>When {@link FieldDescriptor} {@link FieldDescriptor#isExtension()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printField(FieldDescriptor, Object, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printField(FieldDescriptor, Object, JsonGenerator, boolean)"})
  public void testPrintField_whenFieldDescriptorIsExtensionThrowRuntimeException()
      throws IOException {
    // Arrange
    FieldDescriptor field = mock(FieldDescriptor.class);
    when(field.isExtension()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonFormat.printField(field, "Value", new JsonGenerator(new SerializeWriter()), true));
    verify(field).isExtension();
  }

  /**
   * Test {@link JsonFormat#printField(FieldDescriptor, Object, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>When {@link JsonGenerator#JsonGenerator(Appendable)} with output is {@link
   *       SerializeWriter#SerializeWriter()}.
   *   <li>Then calls {@link FieldDescriptor#getJavaType()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printField(FieldDescriptor, Object, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printField(FieldDescriptor, Object, JsonGenerator, boolean)"})
  public void testPrintField_whenJsonGeneratorWithOutputIsSerializeWriter_thenCallsGetJavaType()
      throws IOException {
    // Arrange
    FieldDescriptor field = mock(FieldDescriptor.class);
    when(field.getJavaType()).thenThrow(new RuntimeException());
    when(field.isExtension()).thenReturn(false);
    when(field.getType()).thenReturn(Type.MESSAGE);
    when(field.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonFormat.printField(field, "Value", new JsonGenerator(new SerializeWriter()), true));
    verify(field).getJavaType();
    verify(field).getName();
    verify(field).getType();
    verify(field).isExtension();
  }

  /**
   * Test {@link JsonFormat#printField(FieldDescriptor, Object, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>When {@link JsonGenerator#JsonGenerator(Appendable)} with output is {@link
   *       StringWriter#StringWriter()}.
   *   <li>Then calls {@link FieldDescriptor#getJavaType()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printField(FieldDescriptor, Object, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printField(FieldDescriptor, Object, JsonGenerator, boolean)"})
  public void testPrintField_whenJsonGeneratorWithOutputIsStringWriter_thenCallsGetJavaType()
      throws IOException {
    // Arrange
    FieldDescriptor field = mock(FieldDescriptor.class);
    when(field.getJavaType()).thenThrow(new RuntimeException());
    when(field.isExtension()).thenReturn(false);
    when(field.getType()).thenReturn(Type.MESSAGE);
    when(field.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonFormat.printField(field, "Value", new JsonGenerator(new StringWriter()), true));
    verify(field).getJavaType();
    verify(field).getName();
    verify(field).getType();
    verify(field).isExtension();
  }

  /**
   * Test {@link JsonFormat#printField(FieldDescriptor, Object, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>When {@link SerializeWriter#SerializeWriter(int)} with initialSize is three.
   *   <li>Then calls {@link FieldDescriptor#getJavaType()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printField(FieldDescriptor, Object, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printField(FieldDescriptor, Object, JsonGenerator, boolean)"})
  public void testPrintField_whenSerializeWriterWithInitialSizeIsThree_thenCallsGetJavaType()
      throws IOException {
    // Arrange
    FieldDescriptor field = mock(FieldDescriptor.class);
    when(field.getJavaType()).thenThrow(new RuntimeException());
    when(field.isExtension()).thenReturn(false);
    when(field.getType()).thenReturn(Type.MESSAGE);
    when(field.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonFormat.printField(field, "Value", new JsonGenerator(new SerializeWriter(3)), true));
    verify(field).getJavaType();
    verify(field).getName();
    verify(field).getType();
    verify(field).isExtension();
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} one is newBuilder build.
   *   <li>Then calls {@link UnknownFieldSet#asMap()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenHashMapOneIsNewBuilderBuild_thenCallsAsMap()
      throws IOException {
    // Arrange
    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(1, Field.newBuilder().build());

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    // Act
    JsonFormat.printUnknownFields(unknownFields, new JsonGenerator(new SerializeWriter()), true);

    // Assert
    verify(unknownFields).asMap();
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} ten is newBuilder build.
   *   <li>Then calls {@link UnknownFieldSet#asMap()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenHashMapTenIsNewBuilderBuild_thenCallsAsMap()
      throws IOException {
    // Arrange
    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(10, Field.newBuilder().build());
    integerFieldMap.put(1, Field.newBuilder().build());

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    // Act
    JsonFormat.printUnknownFields(unknownFields, new JsonGenerator(new SerializeWriter()), true);

    // Assert
    verify(unknownFields).asMap();
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link UnknownFieldSet#asMap()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenHashMap_thenCallsAsMap() throws IOException {
    // Arrange
    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(new HashMap<>());

    // Act
    JsonFormat.printUnknownFields(unknownFields, new JsonGenerator(new SerializeWriter()), true);

    // Assert
    verify(unknownFields).asMap();
  }

  /**
   * Test {@link JsonFormat#toStringBuilder(Readable)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>Then return toString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#toStringBuilder(Readable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder JsonFormat.toStringBuilder(Readable)"})
  public void testToStringBuilder_givenMinusOne_thenReturnToStringIsEmptyString()
      throws IOException {
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
   * Test {@link JsonFormat#escapeBytes(ByteString, String, boolean)} with {@code input}, {@code
   * fliedName}, {@code selfType}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString, String, boolean)"})
  public void testEscapeBytesWithInputFliedNameSelfType_givenNull_thenReturnEmptyString() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenReturn(null);

    // Act
    String actualEscapeBytesResult =
        JsonFormat.escapeBytes(input, "https://example.org/example", true);

    // Assert
    verify(input).toByteArray();
    assertEquals("", actualEscapeBytesResult);
  }

  /**
   * Test {@link JsonFormat#escapeBytes(ByteString, String, boolean)} with {@code input}, {@code
   * fliedName}, {@code selfType}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString, String, boolean)"})
  public void testEscapeBytesWithInputFliedNameSelfType_givenNull_thenReturnEmptyString2() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenReturn(null);

    // Act
    String actualEscapeBytesResult =
        JsonFormat.escapeBytes(input, "https://example.org/example", false);

    // Assert
    verify(input).toByteArray();
    assertEquals("", actualEscapeBytesResult);
  }

  /**
   * Test {@link JsonFormat#escapeBytes(ByteString, String, boolean)} with {@code input}, {@code
   * fliedName}, {@code selfType}.
   *
   * <ul>
   *   <li>Then return {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString, String, boolean)"})
  public void testEscapeBytesWithInputFliedNameSelfType_thenReturn4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualEscapeBytesResult =
        JsonFormat.escapeBytes(input, "https://example.org/example", true);

    // Assert
    verify(input).toByteArray();
    assertEquals("4158415841584158", actualEscapeBytesResult);
  }

  /**
   * Test {@link JsonFormat#escapeBytes(ByteString, String, boolean)} with {@code input}, {@code
   * fliedName}, {@code selfType}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString, String, boolean)"})
  public void testEscapeBytesWithInputFliedNameSelfType_thenThrowRuntimeException() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonFormat.escapeBytes(input, "https://example.org/example", true));
    verify(input).toByteArray();
  }

  /**
   * Test {@link JsonFormat#escapeBytes(ByteString, String, boolean)} with {@code input}, {@code
   * fliedName}, {@code selfType}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString, String, boolean)"})
  public void testEscapeBytesWithInputFliedNameSelfType_thenThrowRuntimeException2() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonFormat.escapeBytes(input, "https://example.org/example", false));
    verify(input).toByteArray();
  }

  /**
   * Test {@link JsonFormat#escapeBytes(ByteString)} with {@code input}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeBytes(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeBytes(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString)"})
  public void testEscapeBytesWithInput_givenNull_thenReturnEmptyString() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenReturn(null);

    // Act
    String actualEscapeBytesResult = JsonFormat.escapeBytes(input);

    // Assert
    verify(input).toByteArray();
    assertEquals("", actualEscapeBytesResult);
  }

  /**
   * Test {@link JsonFormat#escapeBytes(ByteString)} with {@code input}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeBytes(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString)"})
  public void testEscapeBytesWithInput_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonFormat.escapeBytes(input));
    verify(input).toByteArray();
  }

  /**
   * Test {@link JsonFormat#escapeBytesSelfType(ByteString, String)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeBytesSelfType(ByteString, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeBytesSelfType(ByteString, String)"})
  public void testEscapeBytesSelfType_givenAxaxaxaxBytesIsUtf8_thenReturn4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualEscapeBytesSelfTypeResult =
        JsonFormat.escapeBytesSelfType(input, "https://example.org/example");

    // Assert
    verify(input).toByteArray();
    assertEquals("4158415841584158", actualEscapeBytesSelfTypeResult);
  }

  /**
   * Test {@link JsonFormat#escapeBytesSelfType(ByteString, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeBytesSelfType(ByteString, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeBytesSelfType(ByteString, String)"})
  public void testEscapeBytesSelfType_givenNull_thenReturnEmptyString() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenReturn(null);

    // Act
    String actualEscapeBytesSelfTypeResult =
        JsonFormat.escapeBytesSelfType(input, "https://example.org/example");

    // Assert
    verify(input).toByteArray();
    assertEquals("", actualEscapeBytesSelfTypeResult);
  }

  /**
   * Test {@link JsonFormat#escapeBytesSelfType(ByteString, String)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeBytesSelfType(ByteString, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeBytesSelfType(ByteString, String)"})
  public void testEscapeBytesSelfType_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonFormat.escapeBytesSelfType(input, "https://example.org/example"));
    verify(input).toByteArray();
  }

  /**
   * Test Tokenizer {@link Tokenizer#atEnd()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#atEnd()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.atEnd()"})
  public void testTokenizerAtEnd_givenTokenizerWithTextIsEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Tokenizer("").atEnd());
  }

  /**
   * Test Tokenizer {@link Tokenizer#atEnd()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#atEnd()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.atEnd()"})
  public void testTokenizerAtEnd_givenTokenizerWithTextIsS_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Tokenizer(PostParams.S_VALUE).atEnd());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeBoolean()}.
   *
   * <p>Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.consumeBoolean()"})
  public void testTokenizerConsumeBoolean3() throws ParseException {
    // Arrange
    StringBuffer text = new StringBuffer(Boolean.TRUE.toString());
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
   *
   * <p>Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.consumeBoolean()"})
  public void testTokenizerConsumeBoolean4() throws ParseException {
    // Arrange
    StringBuffer text = new StringBuffer(Boolean.TRUE.toString());
    text.append('\u0001');
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
   *
   * <ul>
   *   <li>Given {@link StringBuffer#StringBuffer(String)} with {@link Boolean#TRUE} toString
   *       appendCodePoint one.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.consumeBoolean()"})
  public void testTokenizerConsumeBoolean_givenStringBufferWithTrueToStringAppendCodePointOne()
      throws ParseException {
    // Arrange
    StringBuffer text = new StringBuffer(Boolean.TRUE.toString());
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
   *
   * <ul>
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.consumeBoolean()"})
  public void testTokenizerConsumeBoolean_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(PostParams.S_VALUE).consumeBoolean());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeByteString(String, boolean)} with {@code String}, {@code
   * boolean}.
   *
   * <p>Method under test: {@link Tokenizer#consumeByteString(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.consumeByteString(String, boolean)"})
  public void testTokenizerConsumeByteStringWithStringBoolean() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(
        ParseException.class,
        () -> new Tokenizer("").consumeByteString("https://example.org/example", true));
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeByteString(String, boolean)} with {@code String}, {@code
   * boolean}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeByteString(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.consumeByteString(String, boolean)"})
  public void testTokenizerConsumeByteStringWithStringBoolean_givenTokenizerWithTextIsS_value()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(
        ParseException.class,
        () ->
            new Tokenizer(PostParams.S_VALUE)
                .consumeByteString("https://example.org/example", true));
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeByteString()}.
   *
   * <ul>
   *   <li>Given {@link Segment#Segment(char[], int, int)} with &quot; enquiry &quot; toCharArray
   *       and one and one.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeByteString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.consumeByteString()"})
  public void testTokenizerConsumeByteString_givenSegmentWithEnquiryToCharArrayAndOneAndOne()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(
        ParseException.class,
        () ->
            new Tokenizer(new Segment("\u0005\"\u0005\"".toCharArray(), 1, 1)).consumeByteString());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeByteString()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeByteString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.consumeByteString()"})
  public void testTokenizerConsumeByteString_givenTokenizerWithTextIsEmptyString()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer("").consumeByteString());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeByteString()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeByteString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.consumeByteString()"})
  public void testTokenizerConsumeByteString_givenTokenizerWithTextIsS_value()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(PostParams.S_VALUE).consumeByteString());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeDouble()}.
   *
   * <p>Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble2() throws ParseException {
    // Arrange
    StringBuffer text = new StringBuffer("infinity");
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
   *
   * <p>Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble3() throws ParseException {
    // Arrange
    StringBuffer text = new StringBuffer("infinity");
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
   *
   * <ul>
   *   <li>Given {@link StringBuffer#StringBuffer(String)} with {@code infinity} appendCodePoint
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble_givenStringBufferWithInfinityAppendCodePointOne()
      throws ParseException {
    // Arrange
    StringBuffer text = new StringBuffer("infinity");
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
   *
   * <ul>
   *   <li>Then return {@link Double#NEGATIVE_INFINITY}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble_thenReturnNegative_infinity() throws ParseException {
    // Arrange
    StringBuffer text = new StringBuffer("infinity");
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
   *
   * <ul>
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(PostParams.S_VALUE).consumeDouble());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeDouble()}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 42} currentToken is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble_thenTokenizerWithTextIs42CurrentTokenIsEmptyString()
      throws ParseException {
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
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code nan} currentToken is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble_thenTokenizerWithTextIsNanCurrentTokenIsEmptyString()
      throws ParseException {
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
   *
   * <p>Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat2() throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder("infinity");
    text.appendNewLine();
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Float.POSITIVE_INFINITY, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeFloat()}.
   *
   * <p>Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat3() throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder("infinity");
    text.append("\u0001\t\u0001\t".toCharArray());
    text.appendNewLine();
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertEquals(Float.POSITIVE_INFINITY, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeFloat()}.
   *
   * <ul>
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(PostParams.S_VALUE).consumeFloat());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeFloat()}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 42} currentToken is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat_thenTokenizerWithTextIs42CurrentTokenIsEmptyString()
      throws ParseException {
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
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code nan} currentToken is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat_thenTokenizerWithTextIsNanCurrentTokenIsEmptyString()
      throws ParseException {
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
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code nanf?} currentToken is
   *       {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat_thenTokenizerWithTextIsNanfCurrentTokenIsQuestionMark()
      throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("nanf?");

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("?", tokenizer.currentToken());
    assertEquals(Float.NaN, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier5() throws ParseException {
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
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnEmptyString() throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("\"");

    // Act and Assert
    assertEquals("", tokenizer.consumeIdentifier());
    assertEquals("", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenThrowParseException() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer("\"|'").consumeIdentifier());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   *
   * <p>Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code 0x} append {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenStringBuilderWith0xAppendMin_value()
      throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("0x");
    text.append((Object) Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(text).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   *
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code -} append {@link
   *       Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenStringBuilderWithDashAppendMax_value()
      throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");

    // Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(text).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   *
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code -} append {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenStringBuilderWithDashAppendMin_value()
      throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append((Object) Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(text).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0x}.
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenTokenizerWithTextIs0x_thenThrowParseException()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer("0x").consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link
   *       Util#CONTRACT_ADDRESS}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenTokenizerWithTextIsContract_address()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(Util.CONTRACT_ADDRESS).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code -}.
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenTokenizerWithTextIsDash_thenThrowParseException()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer("-").consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_givenTokenizerWithTextIsS_value() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(PostParams.S_VALUE).consumeInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt32()}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0} currentToken is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeInt32()"})
  public void testTokenizerConsumeInt32_thenTokenizerWithTextIs0CurrentTokenIsEmptyString()
      throws ParseException {
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
   *
   * <p>Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code 0x} append {@link
   *       Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_givenStringBuilderWith0xAppendMax_value()
      throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("0x");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");

    // Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(text).consumeInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   *
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code -} append {@link
   *       Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_givenStringBuilderWithDashAppendMax_value()
      throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");

    // Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(text).consumeInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0x}.
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_givenTokenizerWithTextIs0x_thenThrowParseException()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer("0x").consumeInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link
   *       Util#CONTRACT_ADDRESS}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_givenTokenizerWithTextIsContract_address()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(Util.CONTRACT_ADDRESS).consumeInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code -}.
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_givenTokenizerWithTextIsDash_thenThrowParseException()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer("-").consumeInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_givenTokenizerWithTextIsS_value() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(PostParams.S_VALUE).consumeInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeInt64()}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0} currentToken is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeInt64()"})
  public void testTokenizerConsumeInt64_thenTokenizerWithTextIs0CurrentTokenIsEmptyString()
      throws ParseException {
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
   *
   * <p>Method under test: {@link Tokenizer#consumeInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Tokenizer#consumeInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test Tokenizer {@link Tokenizer#consumeString()}.
   *
   * <ul>
   *   <li>Given {@link Segment#Segment(char[], int, int)} with &quot; enquiry &quot; toCharArray
   *       and one and one.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeString()"})
  public void testTokenizerConsumeString_givenSegmentWithEnquiryToCharArrayAndOneAndOne()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(
        ParseException.class,
        () -> new Tokenizer(new Segment("\u0005\"\u0005\"".toCharArray(), 1, 1)).consumeString());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeString()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeString()"})
  public void testTokenizerConsumeString_givenTokenizerWithTextIsEmptyString()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer("").consumeString());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeString()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeString()"})
  public void testTokenizerConsumeString_givenTokenizerWithTextIsS_value() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(PostParams.S_VALUE).consumeString());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0x}.
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32_givenTokenizerWithTextIs0x_thenThrowParseException()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer("0x").consumeUInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link
   *       Util#CONTRACT_ADDRESS}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32_givenTokenizerWithTextIsContract_address()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(Util.CONTRACT_ADDRESS).consumeUInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code -}.
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32_givenTokenizerWithTextIsDash_thenThrowParseException()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer("-").consumeUInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32_givenTokenizerWithTextIsS_value() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(PostParams.S_VALUE).consumeUInt32());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0} currentToken is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32_thenTokenizerWithTextIs0CurrentTokenIsEmptyString()
      throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("0");

    // Act
    int actualConsumeUInt32Result = tokenizer.consumeUInt32();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(0, actualConsumeUInt32Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0x}.
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64_givenTokenizerWithTextIs0x_thenThrowParseException()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer("0x").consumeUInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link
   *       Util#CONTRACT_ADDRESS}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64_givenTokenizerWithTextIsContract_address()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(Util.CONTRACT_ADDRESS).consumeUInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code -}.
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64_givenTokenizerWithTextIsDash_thenThrowParseException()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer("-").consumeUInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64_givenTokenizerWithTextIsS_value() throws ParseException {
    // Arrange, Act and Assert
    assertThrows(ParseException.class, () -> new Tokenizer(PostParams.S_VALUE).consumeUInt64());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 0} currentToken is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64_thenTokenizerWithTextIs0CurrentTokenIsEmptyString()
      throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("0");

    // Act
    long actualConsumeUInt64Result = tokenizer.consumeUInt64();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(0L, actualConsumeUInt64Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consume(String)}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.consume(String)"})
  public void testTokenizerConsume_givenTokenizerWithTextIsS_value_thenThrowParseException()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(
        ParseException.class,
        () -> new Tokenizer(PostParams.S_VALUE).consume("https://example.org/example"));
  }

  /**
   * Test Tokenizer {@link Tokenizer#consume(String)}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 42} currentToken is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.consume(String)"})
  public void testTokenizerConsume_thenTokenizerWithTextIs42CurrentTokenIsEmptyString()
      throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("42");

    // Act
    tokenizer.consume("42");

    // Assert
    assertEquals("", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consume(String)}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is empty string currentToken is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.consume(String)"})
  public void testTokenizerConsume_thenTokenizerWithTextIsEmptyStringCurrentTokenIsEmptyString()
      throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("");

    // Act
    tokenizer.consume("");

    // Assert that nothing has changed
    assertEquals("", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#currentToken()}.
   *
   * <p>Method under test: {@link Tokenizer#currentToken()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.currentToken()"})
  public void testTokenizerCurrentToken() {
    // Arrange, Act and Assert
    assertEquals(PostParams.S_VALUE, new Tokenizer(PostParams.S_VALUE).currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtBoolean()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#lookingAtBoolean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.lookingAtBoolean()"})
  public void testTokenizerLookingAtBoolean_givenTokenizerWithTextIsEmptyString() {
    // Arrange, Act and Assert
    assertFalse(new Tokenizer("").lookingAtBoolean());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtBoolean()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link Boolean#FALSE}
   *       toString.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#lookingAtBoolean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.lookingAtBoolean()"})
  public void testTokenizerLookingAtBoolean_givenTokenizerWithTextIsFalseToString() {
    // Arrange, Act and Assert
    assertTrue(new Tokenizer(Boolean.FALSE.toString()).lookingAtBoolean());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtBoolean()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#lookingAtBoolean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.lookingAtBoolean()"})
  public void testTokenizerLookingAtBoolean_givenTokenizerWithTextIsS_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Tokenizer(PostParams.S_VALUE).lookingAtBoolean());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtBoolean()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link Boolean#TRUE}
   *       toString.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#lookingAtBoolean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.lookingAtBoolean()"})
  public void testTokenizerLookingAtBoolean_givenTokenizerWithTextIsTrueToString() {
    // Arrange, Act and Assert
    assertTrue(new Tokenizer(Boolean.TRUE.toString()).lookingAtBoolean());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtInteger()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#lookingAtInteger()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.lookingAtInteger()"})
  public void testTokenizerLookingAtInteger_givenTokenizerWithTextIs42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Tokenizer("42").lookingAtInteger());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtInteger()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code -}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#lookingAtInteger()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.lookingAtInteger()"})
  public void testTokenizerLookingAtInteger_givenTokenizerWithTextIsDash_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Tokenizer("-").lookingAtInteger());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtInteger()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#lookingAtInteger()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.lookingAtInteger()"})
  public void testTokenizerLookingAtInteger_givenTokenizerWithTextIsEmptyString() {
    // Arrange, Act and Assert
    assertFalse(new Tokenizer("").lookingAtInteger());
  }

  /**
   * Test Tokenizer {@link Tokenizer#lookingAtInteger()}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#lookingAtInteger()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.lookingAtInteger()"})
  public void testTokenizerLookingAtInteger_givenTokenizerWithTextIsS_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Tokenizer(PostParams.S_VALUE).lookingAtInteger());
  }

  /**
   * Test Tokenizer {@link Tokenizer#Tokenizer(CharSequence)}.
   *
   * <ul>
   *   <li>Then return currentToken is enquiry.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#Tokenizer(CharSequence)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.<init>(CharSequence)"})
  public void testTokenizerNewTokenizer_thenReturnCurrentTokenIsEnquiry() {
    // Arrange
    NameImpl text = new NameImpl("\u0005\u0001\u0005\u0001".toCharArray());

    // Act and Assert
    assertEquals("\u0005", new Tokenizer(text).currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#Tokenizer(CharSequence)}.
   *
   * <ul>
   *   <li>When lineSeparator.
   *   <li>Then return currentToken is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#Tokenizer(CharSequence)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.<init>(CharSequence)"})
  public void testTokenizerNewTokenizer_whenLineSeparator_thenReturnCurrentTokenIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new Tokenizer(System.lineSeparator()).currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#Tokenizer(CharSequence)}.
   *
   * <ul>
   *   <li>When {@link PostParams#S_VALUE}.
   *   <li>Then return currentToken is {@link PostParams#S_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#Tokenizer(CharSequence)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.<init>(CharSequence)"})
  public void testTokenizerNewTokenizer_whenS_value_thenReturnCurrentTokenIsS_value() {
    // Arrange, Act and Assert
    assertEquals(PostParams.S_VALUE, new Tokenizer(PostParams.S_VALUE).currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#Tokenizer(CharSequence)}.
   *
   * <ul>
   *   <li>When space space space.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#Tokenizer(CharSequence)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.<init>(CharSequence)"})
  public void testTokenizerNewTokenizer_whenSpaceSpaceSpace() {
    // Arrange, Act and Assert
    assertEquals("", new Tokenizer("   ").currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#nextToken()}.
   *
   * <p>Method under test: {@link Tokenizer#nextToken()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link
   *       NameImpl#NameImpl(char[])} currentToken is enquiry.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#nextToken()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.nextToken()"})
  public void testTokenizerNextToken_thenTokenizerWithTextIsNameImplCurrentTokenIsEnquiry() {
    // Arrange
    NameImpl text = new NameImpl("\u0005\n\u0005\n".toCharArray());
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    tokenizer.nextToken();

    // Assert that nothing has changed
    assertEquals("\u0005", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}
   *       currentToken is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#nextToken()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Tokenizer#parseException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseException Tokenizer.parseException(String)"})
  public void testTokenizerParseException() {
    // Arrange and Act
    ParseException actualParseExceptionResult =
        new Tokenizer(PostParams.S_VALUE).parseException("https://example.org/example");

    // Assert
    assertEquals(
        "1:1: https://example.org/example", actualParseExceptionResult.getLocalizedMessage());
    assertEquals("1:1: https://example.org/example", actualParseExceptionResult.getMessage());
    assertNull(actualParseExceptionResult.getCause());
    assertEquals(0, actualParseExceptionResult.getSuppressed().length);
  }

  /**
   * Test Tokenizer {@link Tokenizer#parseExceptionPreviousToken(String)}.
   *
   * <p>Method under test: {@link Tokenizer#parseExceptionPreviousToken(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseException Tokenizer.parseExceptionPreviousToken(String)"})
  public void testTokenizerParseExceptionPreviousToken() {
    // Arrange and Act
    ParseException actualParseExceptionPreviousTokenResult =
        new Tokenizer(PostParams.S_VALUE)
            .parseExceptionPreviousToken("https://example.org/example");

    // Assert
    assertEquals(
        "1:1: https://example.org/example",
        actualParseExceptionPreviousTokenResult.getLocalizedMessage());
    assertEquals(
        "1:1: https://example.org/example", actualParseExceptionPreviousTokenResult.getMessage());
    assertNull(actualParseExceptionPreviousTokenResult.getCause());
    assertEquals(0, actualParseExceptionPreviousTokenResult.getSuppressed().length);
  }

  /**
   * Test Tokenizer {@link Tokenizer#tryConsume(String)}.
   *
   * <p>Method under test: {@link Tokenizer#tryConsume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.tryConsume(String)"})
  public void testTokenizerTryConsume() {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("");

    // Act
    boolean actualTryConsumeResult = tokenizer.tryConsume("");

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertTrue(actualTryConsumeResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#tryConsume(String)}.
   *
   * <ul>
   *   <li>Given {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#tryConsume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.tryConsume(String)"})
  public void testTokenizerTryConsume_givenTokenizerWithTextIsS_value_thenReturnFalse() {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(PostParams.S_VALUE);

    // Act and Assert
    assertFalse(tokenizer.tryConsume("https://example.org/example"));
    assertEquals(PostParams.S_VALUE, tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#tryConsume(String)}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@code 42} currentToken is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#tryConsume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tokenizer.tryConsume(String)"})
  public void testTokenizerTryConsume_thenTokenizerWithTextIs42CurrentTokenIsEmptyString() {
    // Arrange
    Tokenizer tokenizer = new Tokenizer("42");

    // Act
    boolean actualTryConsumeResult = tokenizer.tryConsume("42");

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertTrue(actualTryConsumeResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytesSelfType(String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidEscapeSequence}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#unescapeBytesSelfType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytesSelfType(String, String)"})
  public void testTokenizerUnescapeBytesSelfType_thenThrowInvalidEscapeSequence()
      throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(
        InvalidEscapeSequence.class,
        () ->
            Tokenizer.unescapeBytesSelfType(
                "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytesSelfType(String, String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then return toStringUtf8 is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#unescapeBytesSelfType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytesSelfType(String, String)"})
  public void testTokenizerUnescapeBytesSelfType_when0x_thenReturnToStringUtf8IsEmptyString()
      throws InvalidEscapeSequence {
    // Arrange and Act
    ByteString actualUnescapeBytesSelfTypeResult =
        Tokenizer.unescapeBytesSelfType("0x", "https://example.org/example");

    // Assert
    assertEquals("", actualUnescapeBytesSelfTypeResult.toStringUtf8());
    assertFalse(actualUnescapeBytesSelfTypeResult.iterator().hasNext());
    assertTrue(actualUnescapeBytesSelfTypeResult.isEmpty());
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytesSelfType(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#unescapeBytesSelfType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytesSelfType(String, String)"})
  public void testTokenizerUnescapeBytesSelfType_whenEmptyString() throws InvalidEscapeSequence {
    // Arrange and Act
    ByteString actualUnescapeBytesSelfTypeResult =
        Tokenizer.unescapeBytesSelfType("", "https://example.org/example");

    // Assert
    assertEquals("", actualUnescapeBytesSelfTypeResult.toStringUtf8());
    assertFalse(actualUnescapeBytesSelfTypeResult.iterator().hasNext());
    assertTrue(actualUnescapeBytesSelfTypeResult.isEmpty());
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytesSelfType(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link InvalidEscapeSequence}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#unescapeBytesSelfType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytesSelfType(String, String)"})
  public void testTokenizerUnescapeBytesSelfType_whenNull_thenThrowInvalidEscapeSequence()
      throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(
        InvalidEscapeSequence.class,
        () -> Tokenizer.unescapeBytesSelfType(null, "https://example.org/example"));
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytes(CharSequence)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then return toStringUtf8 is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytes(CharSequence)"})
  public void testTokenizerUnescapeBytes_when0x_thenReturnToStringUtf8IsEmptyString()
      throws InvalidEscapeSequence {
    // Arrange and Act
    ByteString actualUnescapeBytesResult = Tokenizer.unescapeBytes("0x");

    // Assert
    assertEquals("", actualUnescapeBytesResult.toStringUtf8());
    assertFalse(actualUnescapeBytesResult.iterator().hasNext());
    assertTrue(actualUnescapeBytesResult.isEmpty());
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytes(CharSequence)}.
   *
   * <ul>
   *   <li>When {@link Util#CALL_DATA}.
   *   <li>Then throw {@link InvalidEscapeSequence}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytes(CharSequence)"})
  public void testTokenizerUnescapeBytes_whenCall_data_thenThrowInvalidEscapeSequence()
      throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class, () -> Tokenizer.unescapeBytes(Util.CALL_DATA));
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytes(CharSequence)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link InvalidEscapeSequence}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytes(CharSequence)"})
  public void testTokenizerUnescapeBytes_whenNull_thenThrowInvalidEscapeSequence()
      throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class, () -> Tokenizer.unescapeBytes(null));
  }

  /**
   * Test Tokenizer {@link Tokenizer#unescapeBytes(CharSequence)}.
   *
   * <ul>
   *   <li>When {@link PostParams#S_VALUE}.
   *   <li>Then throw {@link InvalidEscapeSequence}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Tokenizer.unescapeBytes(CharSequence)"})
  public void testTokenizerUnescapeBytes_whenS_value_thenThrowInvalidEscapeSequence()
      throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class, () -> Tokenizer.unescapeBytes(PostParams.S_VALUE));
  }

  /**
   * Test {@link JsonFormat#unicodeEscaped(char)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code \u0041}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#unicodeEscaped(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.unicodeEscaped(char)"})
  public void testUnicodeEscaped_whenA_thenReturnU0041() {
    // Arrange, Act and Assert
    assertEquals("\\u0041", JsonFormat.unicodeEscaped('A'));
  }

  /**
   * Test {@link JsonFormat#unicodeEscaped(char)}.
   *
   * <ul>
   *   <li>When shift in.
   *   <li>Then return {@code \u000f}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#unicodeEscaped(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.unicodeEscaped(char)"})
  public void testUnicodeEscaped_whenShiftIn_thenReturnU000f() {
    // Arrange, Act and Assert
    assertEquals("\\u000f", JsonFormat.unicodeEscaped('\u000f'));
  }

  /**
   * Test {@link JsonFormat#unicodeEscaped(char)}.
   *
   * <ul>
   *   <li>When {@code Ā}.
   *   <li>Then return {@code \u0100}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#unicodeEscaped(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.unicodeEscaped(char)"})
  public void testUnicodeEscaped_when_thenReturnU0100() {
    // Arrange, Act and Assert
    assertEquals("\\u0100", JsonFormat.unicodeEscaped('Ā'));
  }

  /**
   * Test {@link JsonFormat#unicodeEscaped(char)}.
   *
   * <ul>
   *   <li>When {@code က}.
   *   <li>Then return {@code \u1000}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#unicodeEscaped(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.unicodeEscaped(char)"})
  public void testUnicodeEscaped_when_thenReturnU1000() {
    // Arrange, Act and Assert
    assertEquals("\\u1000", JsonFormat.unicodeEscaped('က'));
  }

  /**
   * Test {@link JsonFormat#unescapeBytes(CharSequence)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then return toStringUtf8 is empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString JsonFormat.unescapeBytes(CharSequence)"})
  public void testUnescapeBytes_when0x_thenReturnToStringUtf8IsEmptyString()
      throws InvalidEscapeSequence {
    // Arrange and Act
    ByteString actualUnescapeBytesResult = JsonFormat.unescapeBytes("0x");

    // Assert
    assertEquals("", actualUnescapeBytesResult.toStringUtf8());
    assertFalse(actualUnescapeBytesResult.iterator().hasNext());
    assertTrue(actualUnescapeBytesResult.isEmpty());
  }

  /**
   * Test {@link JsonFormat#unescapeBytes(CharSequence)}.
   *
   * <ul>
   *   <li>When {@link Util#CALL_DATA}.
   *   <li>Then throw {@link InvalidEscapeSequence}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString JsonFormat.unescapeBytes(CharSequence)"})
  public void testUnescapeBytes_whenCall_data_thenThrowInvalidEscapeSequence()
      throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class, () -> JsonFormat.unescapeBytes(Util.CALL_DATA));
  }

  /**
   * Test {@link JsonFormat#unescapeBytes(CharSequence)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link InvalidEscapeSequence}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString JsonFormat.unescapeBytes(CharSequence)"})
  public void testUnescapeBytes_whenNull_thenThrowInvalidEscapeSequence()
      throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class, () -> JsonFormat.unescapeBytes(null));
  }

  /**
   * Test {@link JsonFormat#unescapeBytes(CharSequence)}.
   *
   * <ul>
   *   <li>When {@link PostParams#S_VALUE}.
   *   <li>Then throw {@link InvalidEscapeSequence}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#unescapeBytes(CharSequence)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString JsonFormat.unescapeBytes(CharSequence)"})
  public void testUnescapeBytes_whenS_value_thenThrowInvalidEscapeSequence()
      throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(InvalidEscapeSequence.class, () -> JsonFormat.unescapeBytes(PostParams.S_VALUE));
  }

  /**
   * Test {@link JsonFormat#escapeText(String)}.
   *
   * <p>Method under test: {@link JsonFormat#escapeText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeText(String)"})
  public void testEscapeText() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\\\\\"", JsonFormat.escapeText("\\\\\""));
  }

  /**
   * Test {@link JsonFormat#escapeText(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeText(String)"})
  public void testEscapeText_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example", JsonFormat.escapeText("https://example.org/example"));
  }

  /**
   * Test {@link JsonFormat#escapeText(String)}.
   *
   * <ul>
   *   <li>When {@code "}.
   *   <li>Then return {@code \"}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeText(String)"})
  public void testEscapeText_whenQuotationMark_thenReturnBackslashQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\\\"", JsonFormat.escapeText("\""));
  }

  /**
   * Test {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo\u0041}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When shift in.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo\u000f}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code Ā}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo\u0100}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code က}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo\u1000}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code \"}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#unescapeText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.unescapeText(String)"})
  public void testUnescapeText_thenReturnBackslashQuotationMark() throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertEquals("\\\"", JsonFormat.unescapeText("\\\\\""));
  }

  /**
   * Test {@link JsonFormat#unescapeText(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#unescapeText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.unescapeText(String)"})
  public void testUnescapeText_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample()
      throws InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example", JsonFormat.unescapeText("https://example.org/example"));
  }

  /**
   * Test {@link JsonFormat#parseInt32(String)}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseInt32(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonFormat.parseInt32(String)"})
  public void testParseInt32_when0_thenReturnZero() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0, JsonFormat.parseInt32("0"));
  }

  /**
   * Test {@link JsonFormat#parseInt32(String)}.
   *
   * <ul>
   *   <li>When {@code -0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseInt32(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonFormat.parseInt32(String)"})
  public void testParseInt32_when0_thenReturnZero2() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0, JsonFormat.parseInt32("-0"));
  }

  /**
   * Test {@link JsonFormat#parseInt32(String)}.
   *
   * <ul>
   *   <li>When {@code 0x0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseInt32(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonFormat.parseInt32(String)"})
  public void testParseInt32_when0x0_thenReturnZero() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0, JsonFormat.parseInt32("0x0"));
  }

  /**
   * Test {@link JsonFormat#parseInt32(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseInt32(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonFormat.parseInt32(String)"})
  public void testParseInt32_when42_thenReturnFortyTwo() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(42, JsonFormat.parseInt32("42"));
  }

  /**
   * Test {@link JsonFormat#parseUInt32(String)}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseUInt32(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonFormat.parseUInt32(String)"})
  public void testParseUInt32_when0_thenReturnZero() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0, JsonFormat.parseUInt32("0"));
  }

  /**
   * Test {@link JsonFormat#parseUInt32(String)}.
   *
   * <ul>
   *   <li>When {@code 0x0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseUInt32(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonFormat.parseUInt32(String)"})
  public void testParseUInt32_when0x0_thenReturnZero() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0, JsonFormat.parseUInt32("0x0"));
  }

  /**
   * Test {@link JsonFormat#parseUInt32(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseUInt32(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonFormat.parseUInt32(String)"})
  public void testParseUInt32_when42_thenReturnFortyTwo() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(42, JsonFormat.parseUInt32("42"));
  }

  /**
   * Test {@link JsonFormat#parseUInt32(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseUInt32(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonFormat.parseUInt32(String)"})
  public void testParseUInt32_whenDash_thenThrowNumberFormatException()
      throws NumberFormatException {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> JsonFormat.parseUInt32("-"));
  }

  /**
   * Test {@link JsonFormat#parseInt64(String)}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseInt64(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonFormat.parseInt64(String)"})
  public void testParseInt64_when0_thenReturnZero() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonFormat.parseInt64("0"));
  }

  /**
   * Test {@link JsonFormat#parseInt64(String)}.
   *
   * <ul>
   *   <li>When {@code -0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseInt64(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonFormat.parseInt64(String)"})
  public void testParseInt64_when0_thenReturnZero2() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonFormat.parseInt64("-0"));
  }

  /**
   * Test {@link JsonFormat#parseInt64(String)}.
   *
   * <ul>
   *   <li>When {@code 0x0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseInt64(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonFormat.parseInt64(String)"})
  public void testParseInt64_when0x0_thenReturnZero() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonFormat.parseInt64("0x0"));
  }

  /**
   * Test {@link JsonFormat#parseInt64(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseInt64(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonFormat.parseInt64(String)"})
  public void testParseInt64_when42_thenReturnFortyTwo() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(42L, JsonFormat.parseInt64("42"));
  }

  /**
   * Test {@link JsonFormat#parseUInt64(String)}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseUInt64(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonFormat.parseUInt64(String)"})
  public void testParseUInt64_when0_thenReturnZero() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonFormat.parseUInt64("0"));
  }

  /**
   * Test {@link JsonFormat#parseUInt64(String)}.
   *
   * <ul>
   *   <li>When {@code 0x0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseUInt64(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonFormat.parseUInt64(String)"})
  public void testParseUInt64_when0x0_thenReturnZero() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonFormat.parseUInt64("0x0"));
  }

  /**
   * Test {@link JsonFormat#parseUInt64(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseUInt64(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonFormat.parseUInt64(String)"})
  public void testParseUInt64_when42_thenReturnFortyTwo() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(42L, JsonFormat.parseUInt64("42"));
  }

  /**
   * Test {@link JsonFormat#parseUInt64(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#parseUInt64(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonFormat.parseUInt64(String)"})
  public void testParseUInt64_whenDash_thenThrowNumberFormatException()
      throws NumberFormatException {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> JsonFormat.parseUInt64("-"));
  }
}
