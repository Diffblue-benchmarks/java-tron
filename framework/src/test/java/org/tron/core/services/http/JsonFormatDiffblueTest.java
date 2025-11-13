package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSetDefaults;
import com.google.protobuf.DescriptorProtos.MessageOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet.Field;
import com.google.protobuf.UnknownFieldSet.Field.Builder;
import java.io.CharArrayWriter;
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
import org.tron.api.GrpcAPI;
import org.tron.api.GrpcAPI.AccountNetMessage;
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
   * <p>Method under test: {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType3() throws IOException {
    // Arrange
    UnknownFieldSet fields = UnknownFieldSet.getDefaultInstance();

    SerializeWriter output = new SerializeWriter(SerializerFeature.QuoteFieldNames);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(7, output.size());
    char[] expectedToCharArrayForSpringWebSocketResult = "alue{".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType4() throws IOException {
    // Arrange
    UnknownFieldSet fields = UnknownFieldSet.newBuilder().build();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(7, output.size());
    assertEquals(8, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult = "alue{".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType5() throws IOException {
    // Arrange
    UnknownFieldSet.Builder newBuilderResult = UnknownFieldSet.newBuilder();
    newBuilderResult.addField(10, Field.newBuilder().build());
    UnknownFieldSet fields = newBuilderResult.build();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(15, output.size());
    assertEquals(20, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult = "alue{\"10\": []".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{\"10\": []}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType6() throws IOException {
    // Arrange
    UnknownFieldSet.Builder newBuilderResult = UnknownFieldSet.newBuilder();
    newBuilderResult.addField(2, Field.newBuilder().build());
    newBuilderResult.addField(10, Field.newBuilder().build());
    UnknownFieldSet fields = newBuilderResult.build();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(24, output.size());
    assertEquals(31, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult = "alue{\"2\": [], \"10\": []".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{\"2\": [], \"10\": []}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType7() throws IOException {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(17, output.size());
    assertEquals(20, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult = "alue{\"10\": [42]".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{\"10\": [42]}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType8() throws IOException {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(1L);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(20, output.getBufferLength());
    assertEquals(20, output.size());
    char[] expectedToCharArrayForSpringWebSocketResult = "alue{\"10\": [1, 42]".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{\"10\": [1, 42]}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType9() throws IOException {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed32(2);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(31, output.getBufferLength());
    assertEquals(31, output.size());
    char[] expectedToCharArrayForSpringWebSocketResult =
        "alue{\"10\": [42, \"0x00000002\"]".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{\"10\": [42, \"0x00000002\"]}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType10() throws IOException {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed64(1L);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(39, output.size());
    assertEquals(55, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult =
        "alue{\"10\": [42, \"0x0000000000000001\"]".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{\"10\": [42, \"0x0000000000000001\"]}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType11() throws IOException {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addGroup(UnknownFieldSet.newBuilder().build());
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(21, output.size());
    assertEquals(31, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult = "alue{\"10\": [42, {}]".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{\"10\": [42, {}]}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType12() throws IOException {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed32(42);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(27, output.size());
    assertEquals(31, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult =
        "alue{\"10\": [\"0x0000002a\"]".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{\"10\": [\"0x0000002a\"]}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType13() throws IOException {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed64(42L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(35, output.size());
    assertEquals(49, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult =
        "alue{\"10\": [\"0x000000000000002a\"]".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{\"10\": [\"0x000000000000002a\"]}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType14() throws IOException {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addGroup(UnknownFieldSet.newBuilder().build());
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(17, output.size());
    assertEquals(20, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult = "alue{\"10\": [{}]".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{\"10\": [{}]}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
  public void testPrintWithFieldsOutputSelfType15() throws IOException {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(-1L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(35, output.size());
    assertEquals(50, output.getBufferLength());
    char[] expectedToCharArrayForSpringWebSocketResult =
        "alue{\"10\": [18446744073709551615]".toCharArray();
    assertArrayEquals(
        expectedToCharArrayForSpringWebSocketResult, output.toCharArrayForSpringWebSocket());
    char[] expectedToCharArrayResult = "value{\"10\": [18446744073709551615]}".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, output.toCharArray());
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
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType() throws IOException {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.compareTo(Mockito.<FieldDescriptor>any()))
        .thenThrow(new RuntimeException());

    HashMap<FieldDescriptor, Object> fieldDescriptorObjectMap = new HashMap<>();
    fieldDescriptorObjectMap.put(fieldDescriptor, "42");

    FeatureSetDefaults message = mock(FeatureSetDefaults.class);
    when(message.getAllFields()).thenReturn(fieldDescriptorObjectMap);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonFormat.print(message, new JsonGenerator(new SerializeWriter()), true));
    verify(fieldDescriptor).compareTo(isA(FieldDescriptor.class));
    verify(message).getAllFields();
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType2() throws IOException {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getContainingType()).thenThrow(new RuntimeException());
    when(fieldDescriptor.isExtension()).thenReturn(true);
    when(fieldDescriptor.compareTo(Mockito.<FieldDescriptor>any())).thenReturn(1);

    HashMap<FieldDescriptor, Object> fieldDescriptorObjectMap = new HashMap<>();
    fieldDescriptorObjectMap.put(fieldDescriptor, "42");

    FeatureSetDefaults message = mock(FeatureSetDefaults.class);
    when(message.getAllFields()).thenReturn(fieldDescriptorObjectMap);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonFormat.print(message, new JsonGenerator(new SerializeWriter()), true));
    verify(fieldDescriptor).compareTo(isA(FieldDescriptor.class));
    verify(fieldDescriptor).getContainingType();
    verify(fieldDescriptor).isExtension();
    verify(message).getAllFields();
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType3() throws IOException {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getFullName()).thenThrow(new RuntimeException());
    when(fieldDescriptor.getContainingType()).thenReturn(AccountNetMessage.getDescriptor());
    when(fieldDescriptor.isExtension()).thenReturn(true);
    when(fieldDescriptor.compareTo(Mockito.<FieldDescriptor>any())).thenReturn(1);

    HashMap<FieldDescriptor, Object> fieldDescriptorObjectMap = new HashMap<>();
    fieldDescriptorObjectMap.put(fieldDescriptor, "42");

    FeatureSetDefaults message = mock(FeatureSetDefaults.class);
    when(message.getAllFields()).thenReturn(fieldDescriptorObjectMap);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonFormat.print(message, new JsonGenerator(new SerializeWriter()), true));
    verify(fieldDescriptor).compareTo(isA(FieldDescriptor.class));
    verify(fieldDescriptor).getContainingType();
    verify(fieldDescriptor).getFullName();
    verify(fieldDescriptor).isExtension();
    verify(message).getAllFields();
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType4() throws IOException {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenThrow(new RuntimeException());
    when(fieldDescriptor.getFullName()).thenReturn("Dr Jane Doe");
    when(fieldDescriptor.getContainingType()).thenReturn(AccountNetMessage.getDescriptor());
    when(fieldDescriptor.isExtension()).thenReturn(true);
    when(fieldDescriptor.compareTo(Mockito.<FieldDescriptor>any())).thenReturn(1);

    HashMap<FieldDescriptor, Object> fieldDescriptorObjectMap = new HashMap<>();
    fieldDescriptorObjectMap.put(fieldDescriptor, "42");

    FeatureSetDefaults message = mock(FeatureSetDefaults.class);
    when(message.getAllFields()).thenReturn(fieldDescriptorObjectMap);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonFormat.print(message, new JsonGenerator(new CharArrayWriter()), true));
    verify(fieldDescriptor).compareTo(isA(FieldDescriptor.class));
    verify(fieldDescriptor).getContainingType();
    verify(fieldDescriptor).getFullName();
    verify(fieldDescriptor).getJavaType();
    verify(fieldDescriptor).isExtension();
    verify(message).getAllFields();
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType5() throws IOException {
    // Arrange
    Descriptor descriptor = mock(Descriptor.class);
    when(descriptor.getOptions()).thenThrow(new RuntimeException());

    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getContainingType()).thenReturn(descriptor);
    when(fieldDescriptor.isExtension()).thenReturn(true);
    when(fieldDescriptor.compareTo(Mockito.<FieldDescriptor>any())).thenReturn(1);

    HashMap<FieldDescriptor, Object> fieldDescriptorObjectMap = new HashMap<>();
    fieldDescriptorObjectMap.put(fieldDescriptor, "42");

    FeatureSetDefaults message = mock(FeatureSetDefaults.class);
    when(message.getAllFields()).thenReturn(fieldDescriptorObjectMap);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonFormat.print(message, new JsonGenerator(new SerializeWriter()), true));
    verify(descriptor).getOptions();
    verify(fieldDescriptor).compareTo(isA(FieldDescriptor.class));
    verify(fieldDescriptor).getContainingType();
    verify(fieldDescriptor).isExtension();
    verify(message).getAllFields();
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType_givenHashMap() throws IOException {
    // Arrange
    FeatureSetDefaults message = mock(FeatureSetDefaults.class);
    when(message.getAllFields()).thenReturn(new HashMap<>());

    // Act
    JsonFormat.print(message, new JsonGenerator(new SerializeWriter()), true);

    // Assert
    verify(message).getAllFields();
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType_givenRuntimeException() throws IOException {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.isExtension()).thenReturn(true);
    when(fieldDescriptor.compareTo(Mockito.<FieldDescriptor>any())).thenReturn(1);

    HashMap<FieldDescriptor, Object> fieldDescriptorObjectMap = new HashMap<>();
    fieldDescriptorObjectMap.put(fieldDescriptor, "42");

    FeatureSetDefaults message = mock(FeatureSetDefaults.class);
    when(message.getAllFields()).thenReturn(fieldDescriptorObjectMap);

    SerializeWriter output = mock(SerializeWriter.class);
    when(output.append(Mockito.<CharSequence>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JsonFormat.print(message, new JsonGenerator(output), true));
    verify(output).append(isA(CharSequence.class));
    verify(fieldDescriptor).compareTo(isA(FieldDescriptor.class));
    verify(fieldDescriptor).isExtension();
    verify(message).getAllFields();
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <ul>
   *   <li>Given {@link SerializeWriter#SerializeWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType_givenSerializeWriter() throws IOException {
    // Arrange
    Descriptor descriptor = mock(Descriptor.class);
    when(descriptor.getOptions()).thenThrow(new IllegalArgumentException());

    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getContainingType()).thenReturn(descriptor);
    when(fieldDescriptor.isExtension()).thenReturn(true);
    when(fieldDescriptor.compareTo(Mockito.<FieldDescriptor>any())).thenReturn(1);

    HashMap<FieldDescriptor, Object> fieldDescriptorObjectMap = new HashMap<>();
    fieldDescriptorObjectMap.put(fieldDescriptor, "42");

    FeatureSetDefaults message = mock(FeatureSetDefaults.class);
    when(message.getAllFields()).thenReturn(fieldDescriptorObjectMap);

    SerializeWriter output = mock(SerializeWriter.class);
    when(output.append(Mockito.<CharSequence>any())).thenReturn(new SerializeWriter());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JsonFormat.print(message, new JsonGenerator(output), true));
    verify(output, atLeast(1)).append(Mockito.<CharSequence>any());
    verify(descriptor).getOptions();
    verify(fieldDescriptor).compareTo(isA(FieldDescriptor.class));
    verify(fieldDescriptor).getContainingType();
    verify(fieldDescriptor).isExtension();
    verify(message).getAllFields();
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <ul>
   *   <li>Then calls {@link FieldDescriptor#getJavaType()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType_thenCallsGetJavaType() throws IOException {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenThrow(new RuntimeException());
    when(fieldDescriptor.getFullName()).thenReturn("Dr Jane Doe");
    when(fieldDescriptor.getContainingType()).thenReturn(AccountNetMessage.getDescriptor());
    when(fieldDescriptor.isExtension()).thenReturn(true);
    when(fieldDescriptor.compareTo(Mockito.<FieldDescriptor>any())).thenReturn(1);

    HashMap<FieldDescriptor, Object> fieldDescriptorObjectMap = new HashMap<>();
    fieldDescriptorObjectMap.put(fieldDescriptor, "42");

    FeatureSetDefaults message = mock(FeatureSetDefaults.class);
    when(message.getAllFields()).thenReturn(fieldDescriptorObjectMap);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonFormat.print(message, new JsonGenerator(new SerializeWriter()), true));
    verify(fieldDescriptor).compareTo(isA(FieldDescriptor.class));
    verify(fieldDescriptor).getContainingType();
    verify(fieldDescriptor).getFullName();
    verify(fieldDescriptor).getJavaType();
    verify(fieldDescriptor).isExtension();
    verify(message).getAllFields();
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <ul>
   *   <li>Then calls {@link JsonGenerator#print(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType_thenCallsPrint() throws IOException {
    // Arrange
    Descriptor descriptor = mock(Descriptor.class);
    when(descriptor.getOptions()).thenThrow(new IllegalArgumentException());

    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getContainingType()).thenReturn(descriptor);
    when(fieldDescriptor.isExtension()).thenReturn(true);
    when(fieldDescriptor.compareTo(Mockito.<FieldDescriptor>any())).thenReturn(1);

    HashMap<FieldDescriptor, Object> fieldDescriptorObjectMap = new HashMap<>();
    fieldDescriptorObjectMap.put(fieldDescriptor, "42");

    FeatureSetDefaults message = mock(FeatureSetDefaults.class);
    when(message.getAllFields()).thenReturn(fieldDescriptorObjectMap);

    JsonGenerator generator = mock(JsonGenerator.class);
    doNothing().when(generator).print(Mockito.<CharSequence>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsonFormat.print(message, generator, true));
    verify(descriptor).getOptions();
    verify(fieldDescriptor).compareTo(isA(FieldDescriptor.class));
    verify(fieldDescriptor).getContainingType();
    verify(fieldDescriptor).isExtension();
    verify(message).getAllFields();
    verify(generator).print(isA(CharSequence.class));
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType_whenDefaultInstance_thenDoesNotThrow()
      throws IOException {
    // Arrange
    MessageOptions message = MessageOptions.getDefaultInstance();

    // Act and Assert
    JsonFormat.print(message, new JsonGenerator(new SerializeWriter()), true);
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType_whenDefaultInstance_thenDoesNotThrow2()
      throws IOException {
    // Arrange
    Any message = Any.getDefaultInstance();

    // Act and Assert
    JsonFormat.print(message, new JsonGenerator(new SerializeWriter()), true);
  }

  /**
   * Test {@link JsonFormat#print(Message, JsonGenerator, boolean)} with {@code message}, {@code
   * generator}, {@code selfType}.
   *
   * <ul>
   *   <li>When {@link SerializeWriter#SerializeWriter(int)} with initialSize is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#print(Message, JsonGenerator, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.print(Message, JsonGenerator, boolean)"})
  public void testPrintWithMessageGeneratorSelfType_whenSerializeWriterWithInitialSizeIsThree()
      throws IOException {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenThrow(new RuntimeException());
    when(fieldDescriptor.getFullName()).thenReturn("Dr Jane Doe");
    when(fieldDescriptor.getContainingType()).thenReturn(AccountNetMessage.getDescriptor());
    when(fieldDescriptor.isExtension()).thenReturn(true);
    when(fieldDescriptor.compareTo(Mockito.<FieldDescriptor>any())).thenReturn(1);

    HashMap<FieldDescriptor, Object> fieldDescriptorObjectMap = new HashMap<>();
    fieldDescriptorObjectMap.put(fieldDescriptor, "42");

    FeatureSetDefaults message = mock(FeatureSetDefaults.class);
    when(message.getAllFields()).thenReturn(fieldDescriptorObjectMap);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonFormat.print(message, new JsonGenerator(new SerializeWriter(3)), true));
    verify(fieldDescriptor).compareTo(isA(FieldDescriptor.class));
    verify(fieldDescriptor).getContainingType();
    verify(fieldDescriptor).getFullName();
    verify(fieldDescriptor).getJavaType();
    verify(fieldDescriptor).isExtension();
    verify(message).getAllFields();
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code
   * selfType}.
   *
   * <ul>
   *   <li>Given newBuilder addVarint one.
   *   <li>Then return {@code {"10": [1, 42]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_givenNewBuilderAddVarintOne_thenReturn10142() {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(1L);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [1, 42]}", JsonFormat.printToString(fields, true));
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
    UnknownFieldSet.Builder newBuilderResult = UnknownFieldSet.newBuilder();
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
    UnknownFieldSet.Builder newBuilderResult = UnknownFieldSet.newBuilder();
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
   *   <li>Then return {@code {"10": [{}]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn10() {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addGroup(UnknownFieldSet.newBuilder().build());
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [{}]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code
   * selfType}.
   *
   * <ul>
   *   <li>Then return {@code {"10": ["0x0000002a"]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn100x0000002a() {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed32(42);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [\"0x0000002a\"]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code
   * selfType}.
   *
   * <ul>
   *   <li>Then return {@code {"10": ["0x000000000000002a"]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn100x000000000000002a() {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed64(42L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [\"0x000000000000002a\"]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code
   * selfType}.
   *
   * <ul>
   *   <li>Then return {@code {"10": [42]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn1042() {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [42]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code
   * selfType}.
   *
   * <ul>
   *   <li>Then return {@code {"10": [42, "0x0000000000000001"]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn10420x0000000000000001() {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed64(1L);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [42, \"0x0000000000000001\"]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code
   * selfType}.
   *
   * <ul>
   *   <li>Then return {@code {"10": [42, "0x00000002"]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn10420x00000002() {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed32(2);
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [42, \"0x00000002\"]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code
   * selfType}.
   *
   * <ul>
   *   <li>Then return {@code {"10": [42, {}]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn10422() {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addGroup(UnknownFieldSet.newBuilder().build());
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [42, {}]}", JsonFormat.printToString(fields, true));
  }

  /**
   * Test {@link JsonFormat#printToString(UnknownFieldSet, boolean)} with {@code fields}, {@code
   * selfType}.
   *
   * <ul>
   *   <li>Then return {@code {"10": [18446744073709551615]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printToString(UnknownFieldSet, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.printToString(UnknownFieldSet, boolean)"})
  public void testPrintToStringWithFieldsSelfType_thenReturn1018446744073709551615() {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(-1L);
    Field field = newBuilderResult.build();

    UnknownFieldSet.Builder newBuilderResult2 = UnknownFieldSet.newBuilder();
    newBuilderResult2.addField(10, field);
    UnknownFieldSet fields = newBuilderResult2.build();

    // Act and Assert
    assertEquals("{\"10\": [18446744073709551615]}", JsonFormat.printToString(fields, true));
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
   *   <li>Given {@link ByteString} {@link ByteString#toByteArray()} return {@code AXAXAXAX} Bytes
   *       is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenByteStringToByteArrayReturnAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    ByteString value = mock(ByteString.class);
    when(value.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addLengthDelimited(value);
    Field field = newBuilderResult.build();

    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(1, field);

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    JsonGenerator generator = mock(JsonGenerator.class);
    doNothing().when(generator).print(Mockito.<CharSequence>any());

    // Act
    JsonFormat.printUnknownFields(unknownFields, generator, true);

    // Assert
    verify(value).toByteArray();
    verify(unknownFields).asMap();
    verify(generator, atLeast(1)).print(Mockito.<CharSequence>any());
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} All is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenHashMapAllIsHashMap() throws IOException {
    // Arrange
    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.putAll(new HashMap<>());
    integerFieldMap.put(1, Field.newBuilder().build());

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    // Act
    JsonFormat.printUnknownFields(unknownFields, new JsonGenerator(new SerializeWriter(3)), true);

    // Assert
    verify(unknownFields).asMap();
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} ten is newBuilder build.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenHashMapTenIsNewBuilderBuild() throws IOException {
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
   *   <li>Given {@link HashMap#HashMap()} zero is newBuilder build.
   *   <li>Then calls {@link JsonGenerator#print(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenHashMapZeroIsNewBuilderBuild_thenCallsPrint()
      throws IOException {
    // Arrange
    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(0, Field.newBuilder().build());
    integerFieldMap.put(1, Field.newBuilder().build());

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    JsonGenerator generator = mock(JsonGenerator.class);
    doNothing().when(generator).print(Mockito.<CharSequence>any());

    // Act
    JsonFormat.printUnknownFields(unknownFields, generator, true);

    // Assert
    verify(unknownFields).asMap();
    verify(generator, atLeast(1)).print(Mockito.<CharSequence>any());
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link JsonGenerator#JsonGenerator(Appendable)} with output is {@link
   *       SerializeWriter#SerializeWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenHashMap_whenJsonGeneratorWithOutputIsSerializeWriter()
      throws IOException {
    // Arrange
    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(new HashMap<>());

    // Act
    JsonFormat.printUnknownFields(unknownFields, new JsonGenerator(new SerializeWriter()), true);

    // Assert
    verify(unknownFields).asMap();
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>Given newBuilder addFixed32 forty-two.
   *   <li>Then calls {@link JsonGenerator#print(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenNewBuilderAddFixed32FortyTwo_thenCallsPrint()
      throws IOException {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed32(42);
    Field field = newBuilderResult.build();

    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(1, field);

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    JsonGenerator generator = mock(JsonGenerator.class);
    doNothing().when(generator).print(Mockito.<CharSequence>any());

    // Act
    JsonFormat.printUnknownFields(unknownFields, generator, true);

    // Assert
    verify(unknownFields).asMap();
    verify(generator, atLeast(1)).print(Mockito.<CharSequence>any());
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>Given newBuilder addFixed64 forty-two.
   *   <li>Then calls {@link JsonGenerator#print(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenNewBuilderAddFixed64FortyTwo_thenCallsPrint()
      throws IOException {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addFixed64(42L);
    Field field = newBuilderResult.build();

    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(1, field);

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    JsonGenerator generator = mock(JsonGenerator.class);
    doNothing().when(generator).print(Mockito.<CharSequence>any());

    // Act
    JsonFormat.printUnknownFields(unknownFields, generator, true);

    // Assert
    verify(unknownFields).asMap();
    verify(generator, atLeast(1)).print(Mockito.<CharSequence>any());
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>Given newBuilder addVarint forty-two.
   *   <li>Then calls {@link JsonGenerator#print(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenNewBuilderAddVarintFortyTwo_thenCallsPrint()
      throws IOException {
    // Arrange
    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(42L);
    Field field = newBuilderResult.build();

    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(1, field);

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    JsonGenerator generator = mock(JsonGenerator.class);
    doNothing().when(generator).print(Mockito.<CharSequence>any());

    // Act
    JsonFormat.printUnknownFields(unknownFields, generator, true);

    // Assert
    verify(unknownFields).asMap();
    verify(generator, atLeast(1)).print(Mockito.<CharSequence>any());
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>Given newBuilder addVarint minus one.
   *   <li>Then calls {@link ByteString#toByteArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenNewBuilderAddVarintMinusOne_thenCallsToByteArray()
      throws IOException {
    // Arrange
    ByteString value = mock(ByteString.class);
    when(value.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ByteString value2 = mock(ByteString.class);
    when(value2.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(-1L);
    newBuilderResult.addLengthDelimited(value2);
    newBuilderResult.addLengthDelimited(value);
    Field field = newBuilderResult.build();

    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(1, field);

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    JsonGenerator generator = mock(JsonGenerator.class);
    doNothing().when(generator).print(Mockito.<CharSequence>any());

    // Act
    JsonFormat.printUnknownFields(unknownFields, generator, true);

    // Assert
    verify(value2).toByteArray();
    verify(value).toByteArray();
    verify(unknownFields).asMap();
    verify(generator, atLeast(1)).print(Mockito.<CharSequence>any());
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>Given newBuilder addVarint one.
   *   <li>Then calls {@link ByteString#toByteArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_givenNewBuilderAddVarintOne_thenCallsToByteArray()
      throws IOException {
    // Arrange
    ByteString value = mock(ByteString.class);
    when(value.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addVarint(1L);
    newBuilderResult.addLengthDelimited(value);
    Field field = newBuilderResult.build();

    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(1, field);

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    JsonGenerator generator = mock(JsonGenerator.class);
    doNothing().when(generator).print(Mockito.<CharSequence>any());

    // Act
    JsonFormat.printUnknownFields(unknownFields, generator, true);

    // Assert
    verify(value).toByteArray();
    verify(unknownFields).asMap();
    verify(generator, atLeast(1)).print(Mockito.<CharSequence>any());
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_thenThrowRuntimeException() throws IOException {
    // Arrange
    ByteString value = mock(ByteString.class);
    when(value.toByteArray()).thenThrow(new RuntimeException());

    Builder newBuilderResult = Field.newBuilder();
    newBuilderResult.addLengthDelimited(value);
    Field field = newBuilderResult.build();

    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(1, field);

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    JsonGenerator generator = mock(JsonGenerator.class);
    doNothing().when(generator).print(Mockito.<CharSequence>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonFormat.printUnknownFields(unknownFields, generator, true));
    verify(value).toByteArray();
    verify(unknownFields).asMap();
    verify(generator, atLeast(1)).print(Mockito.<CharSequence>any());
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_whenDefaultInstance_thenDoesNotThrow() throws IOException {
    // Arrange
    UnknownFieldSet unknownFields = UnknownFieldSet.getDefaultInstance();

    // Act and Assert
    JsonFormat.printUnknownFields(unknownFields, new JsonGenerator(new SerializeWriter()), true);
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>When {@link JsonGenerator} {@link JsonGenerator#print(CharSequence)} does nothing.
   *   <li>Then calls {@link JsonGenerator#print(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_whenJsonGeneratorPrintDoesNothing_thenCallsPrint()
      throws IOException {
    // Arrange
    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(1, Field.newBuilder().build());

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    JsonGenerator generator = mock(JsonGenerator.class);
    doNothing().when(generator).print(Mockito.<CharSequence>any());

    // Act
    JsonFormat.printUnknownFields(unknownFields, generator, true);

    // Assert
    verify(unknownFields).asMap();
    verify(generator, atLeast(1)).print(Mockito.<CharSequence>any());
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>When {@link JsonGenerator#JsonGenerator(Appendable)} with output is {@link
   *       CharArrayWriter#CharArrayWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_whenJsonGeneratorWithOutputIsCharArrayWriter()
      throws IOException {
    // Arrange
    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(1, Field.newBuilder().build());

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    // Act
    JsonFormat.printUnknownFields(unknownFields, new JsonGenerator(new CharArrayWriter()), true);

    // Assert
    verify(unknownFields).asMap();
  }

  /**
   * Test {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)}.
   *
   * <ul>
   *   <li>When {@link JsonGenerator#JsonGenerator(Appendable)} with output is {@link
   *       SerializeWriter#SerializeWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#printUnknownFields(UnknownFieldSet, JsonGenerator,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonFormat.printUnknownFields(UnknownFieldSet, JsonGenerator, boolean)"})
  public void testPrintUnknownFields_whenJsonGeneratorWithOutputIsSerializeWriter()
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
   *   <li>When {@link SerializeWriter#SerializeWriter(int)} with initialSize is three.
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
  public void testPrintUnknownFields_whenSerializeWriterWithInitialSizeIsThree_thenCallsAsMap()
      throws IOException {
    // Arrange
    HashMap<Integer, Field> integerFieldMap = new HashMap<>();
    integerFieldMap.put(1, Field.newBuilder().build());

    UnknownFieldSet unknownFields = mock(UnknownFieldSet.class);
    when(unknownFields.asMap()).thenReturn(integerFieldMap);

    // Act
    JsonFormat.printUnknownFields(unknownFields, new JsonGenerator(new SerializeWriter(3)), true);

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
   *   <li>Then return {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonFormat.escapeBytes(ByteString, String, boolean)"})
  public void testEscapeBytesWithInputFliedNameSelfType_thenReturn41584158415841582()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualEscapeBytesResult =
        JsonFormat.escapeBytes(input, "https://example.org/example", false);

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
   * Test Tokenizer {@link Tokenizer#consume(String)}.
   *
   * <p>Method under test: {@link Tokenizer#consume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.consume(String)"})
  public void testTokenizerConsume() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder(PostParams.S_VALUE);
    text.appendCodePoint(1);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    tokenizer.consume(PostParams.S_VALUE);

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consume(String)}.
   *
   * <p>Method under test: {@link Tokenizer#consume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.consume(String)"})
  public void testTokenizerConsume2() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder(PostParams.S_VALUE);
    text.appendCodePoint(10);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    tokenizer.consume(PostParams.S_VALUE);

    // Assert
    assertEquals("", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consume(String)}.
   *
   * <p>Method under test: {@link Tokenizer#consume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.consume(String)"})
  public void testTokenizerConsume3() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder(PostParams.S_VALUE);
    text.appendCodePoint(1);
    text.appendCodePoint(10);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    tokenizer.consume(PostParams.S_VALUE);

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
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
   *
   * <p>Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Tokenizer#consumeBoolean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code infinity} appendCodePoint
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeDouble()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double Tokenizer.consumeDouble()"})
  public void testTokenizerConsumeDouble_givenStringBuilderWithInfinityAppendCodePointOne()
      throws ParseException {
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
   * Test Tokenizer {@link Tokenizer#consumeFloat()}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link
   *       StrBuilder#StrBuilder(String)} currentToken is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeFloat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float Tokenizer.consumeFloat()"})
  public void testTokenizerConsumeFloat_thenTokenizerWithTextIsStrBuilderCurrentTokenIs1()
      throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder("infinity");
    text.appendFixedWidthPadLeft(1, 2, '\t');
    text.appendNewLine();
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("1", tokenizer.currentToken());
    assertEquals(Float.POSITIVE_INFINITY, actualConsumeFloatResult, 0.0f);
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
    Tokenizer tokenizer = new Tokenizer("\"");

    // Act and Assert
    assertEquals("", tokenizer.consumeIdentifier());
    assertEquals("", tokenizer.currentToken());
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
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 3a}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn3a() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(3);
    text.append('a');
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("3a", tokenizer.consumeIdentifier());
    assertEquals("42", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn05() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("0.5", tokenizer.consumeIdentifier());
    assertEquals("42", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 0.5a42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn05a42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append('a');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.5a42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 0.5foovalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn05foovalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append("foo");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.5foovalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 0.5true4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn05true4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append(true);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.5true4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 0.5truefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn05truefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append(true);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.5truefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 0.5value}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn05value() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("0.5value", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 8false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn8false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(8);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("8false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 10value4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn10value4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10value4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 13falsevalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn13falsevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(13);
    text.append(false);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("13falsevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 13valuefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn13valuefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(13);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("13valuefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 32}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn32() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(3);
    text.append(2);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("32", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 34false}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn34false() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append(false);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("34false", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 34foo4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn34foo4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append("foo");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("34foo4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 34true}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn34true() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append(true);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("34true", tokenizer.consumeIdentifier());
    assertEquals("42", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 34value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn34value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("34value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 34valuevalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn34valuevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("34valuevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 42a}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42a() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append('a');
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("42a", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 42a42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 42false}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42false() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(false);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("42false", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 42false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 42falsevalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42falsevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(false);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42falsevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 42foo4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 42foovalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42foovalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append("foo");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42foovalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 42true}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42true() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(true);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("42true", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 42true4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 42truefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42truefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(true);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42truefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 42value}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42value() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("42value", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 42value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 42value4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 42valuefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42valuefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42valuefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 42valuevalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42valuevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42valuevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 97}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn97() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("97", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 97a42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn97a42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append('a');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("97a42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 97foovalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn97foovalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append("foo");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("97foovalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 97true4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn97true4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append(true);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("97true4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 97truefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn97truefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append(true);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("97truefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 97value}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn97value() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("97value", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 10.0a}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn100a() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append('a');
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("10.0a", tokenizer.consumeIdentifier());
    assertEquals("42", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 10.0false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn100false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.0false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 10.0falsevalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn100falsevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append(false);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.0falsevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 10.0value4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn100value4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.0value4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 10.0valuefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn100valuefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.0valuefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 348false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn348false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append(8);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("348false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 428false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn428false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(8);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("428false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 442}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn442() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(4);
    text.append((Object) "42");
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("442", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 0.534value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn0534value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append(34);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.534value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 0.542}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 0.597}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn0597() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append(97);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("0.597", tokenizer.consumeIdentifier());
    assertEquals("42", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 10.02}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn1002() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append(2);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("10.02", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 1042value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn1042value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10);
    text.append((Object) "42");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("1042value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 340.5}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn3405() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append(0.5f);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("340.5", tokenizer.consumeIdentifier());
    assertEquals("42", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 3442false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn3442false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append((Object) "42");
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("3442false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 420.5}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn4205() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(0.5f);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("420.5", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 422}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn4222() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(2);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("422", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 4234value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn4234value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(34);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("4234value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 4242false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn4242false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((Object) "42");
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("4242false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 4242value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn4242value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("4242value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 4297}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn4297() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(97);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("4297", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 0.510.0}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn05100() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append(10.0f);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("0.510.0", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 9734value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn9734value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append(34);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("9734value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 9742}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 9797}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn9797() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append(97);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("9797", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 10.042}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn10042() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append((Object) "42");
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("10.042", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 10.042value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn10042value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append((Object) "42");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.042value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 1210.0false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn12100false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(12);
    text.append(10.0f);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("1210.0false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 4210.0}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42100() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(10.0f);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("4210.0", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 4210.0false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42100false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(10.0f);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("4210.0false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn42422() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((Object) "42");
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("4242", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 60.542}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn60542() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(6);
    text.append(0.5f);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("60.542", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 9710.0}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn97100() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append(10.0f);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("9710.0", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 10.010.0false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn100100false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append(10.0f);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.010.0false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 344242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 349742}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn349742() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append(97);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("349742", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 420.542}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 424242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 429742}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 10.00.542}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn1000542() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append(0.5f);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.00.542", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 0.5424242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn05424242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.5424242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 34344242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn34344242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append(34);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("34344242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code 42344242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 42424242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 97424242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturn97424242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("97424242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code a}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnA() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("a", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code a34value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnA34value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append(34);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("a34value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code a42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code a97}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnA97() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append(97);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("a97", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code a10.0}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnA100() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append(10.0f);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("a10.0", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code a424242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnA424242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("a424242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code aa42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnAa42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append('a');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("aa42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code afoovalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnAfoovalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append("foo");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("afoovalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code atrue4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnAtrue4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append(true);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("atrue4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code atruefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnAtruefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append(true);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("atruefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code avalue}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnAvalue() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append((CharSequence) PostParams.S_VALUE);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("avalue", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
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
  public void testTokenizerConsumeIdentifier_thenReturnEmptyString2() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("", tokenizer.consumeIdentifier());
    assertEquals("42", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code false0.5}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalse05() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(0.5f);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("false0.5", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code false42false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalse42false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append((Object) "42");
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("false42false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code false10.0}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalse100() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(10.0f);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("false10.0", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code false10.0false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalse100false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(10.0f);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("false10.0false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalse422() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append((Object) "42");
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("false42", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code false0.542}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalse0542() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(0.5f);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("false0.542", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@link Boolean#FALSE} toString.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code falsea}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalsea() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append('a');
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("falsea", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code falsea42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalsea42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append('a');
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("falsea42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code falsefalse}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalsefalse() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(false);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("falsefalse", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code falsefalsevalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalsefalsevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(false);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("falsefalsevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code falsefoo4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalsefoo4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append("foo");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("falsefoo4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code falsefoovalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalsefoovalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append("foo");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("falsefoovalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code falsetrue4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalsetrue4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(true);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("falsetrue4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code falsetruefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalsetruefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(true);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("falsetruefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code falsevalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFalsevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("falsevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code foo0.5}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoo05() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append(0.5f);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("foo0.5", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code foo8false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoo8false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append(8);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foo8false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code foo42false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoo42false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append((Object) "42");
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foo42false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code foo4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code foo9742}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoo9742() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append(97);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foo9742", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code foo344242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoo344242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append(34);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foo344242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code foofalse}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoofalse() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append(false);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("foofalse", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code foofoo4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoofoo4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append("foo");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foofoo4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code footrue}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFootrue() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append(true);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("footrue", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code foovalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoovalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foovalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code foovaluevalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnFoovaluevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foovaluevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@link PostParams#S_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code true2}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTrue2() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append(2);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("true2", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code true8false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTrue8false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append(8);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("true8false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code true34value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTrue34value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append(34);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("true34value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code true42value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTrue42value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append((Object) "42");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("true42value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code true97}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTrue97() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append(97);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("true97", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code true4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code true9742}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTrue9742() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append(97);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("true9742", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code true344242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTrue344242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append(34);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("true344242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code true424242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTrue424242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("true424242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTrueToString() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals(Boolean.TRUE.toString(), actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code truefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTruefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("truefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code truetrue}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTruetrue() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append(true);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("truetrue", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code truevalue}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTruevalue() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("truevalue", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code truevalue4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTruevalue4242() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("truevalue4242", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code truevaluefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTruevaluefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("truevaluefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code truevaluevalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnTruevaluevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("truevaluevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code value2}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue2() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(2);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("value2", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code value0.5}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue05() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(0.5f);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("value0.5", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code value8false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue8false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(8);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value8false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code value34value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue34value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(34);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value34value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code value42false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue42false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value42false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code value42value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue42value42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value42value42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code value97}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue97() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(97);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("value97", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code value10.0}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue100() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(10.0f);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("value10.0", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code value10.0false42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue100false42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(10.0f);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value10.0false42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code value42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValue422() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("value42", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code value0.542}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code value4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code value9742}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code value344242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code value424242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code valuea}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuea() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append('a');
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("valuea", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code valuea42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code valuefalse}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuefalse() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(false);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("valuefalse", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code valuefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code valuefalsevalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuefalsevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(false);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuefalsevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code valuefoo4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code valuefoovalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuefoovalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append("foo");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuefoovalue42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code valuetrue}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuetrue() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(true);
    text.append(new StringBuffer("\""));
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals("valuetrue", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code valuetrue4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code valuetruefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuetruefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(true);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuetruefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code valuevalue}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuevalue() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append("\"|'");
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act and Assert
    assertEquals("valuevalue", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code valuevalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code valuevalue4242}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code valuevaluefalse42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuevaluefalse42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(false);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuevaluefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code valuevaluevalue42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeIdentifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tokenizer.consumeIdentifier()"})
  public void testTokenizerConsumeIdentifier_thenReturnValuevaluevalue42() throws ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuevaluevalue42", actualConsumeIdentifierResult);
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
   * <p>Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32() throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("42", "Objs");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    int actualConsumeUInt32Result = tokenizer.consumeUInt32();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(42, actualConsumeUInt32Result);
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
   * Test Tokenizer {@link Tokenizer#consumeUInt32()}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link
   *       StrBuilder#StrBuilder()} currentToken is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt32()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tokenizer.consumeUInt32()"})
  public void testTokenizerConsumeUInt32_thenTokenizerWithTextIsStrBuilderCurrentTokenIs42()
      throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln(42);
    text.appendln("42", "Objs");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    int actualConsumeUInt32Result = tokenizer.consumeUInt32();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals(42, actualConsumeUInt32Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64() throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("42", "Objs");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    long actualConsumeUInt64Result = tokenizer.consumeUInt64();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(42L, actualConsumeUInt64Result);
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
   * Test Tokenizer {@link Tokenizer#consumeUInt64()}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link
   *       StrBuilder#StrBuilder()} currentToken is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consumeUInt64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tokenizer.consumeUInt64()"})
  public void testTokenizerConsumeUInt64_thenTokenizerWithTextIsStrBuilderCurrentTokenIs42()
      throws ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln(42);
    text.appendln("42", "Objs");
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    long actualConsumeUInt64Result = tokenizer.consumeUInt64();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals(42L, actualConsumeUInt64Result);
  }

  /**
   * Test Tokenizer {@link Tokenizer#consume(String)}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}
   *       currentToken is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.consume(String)"})
  public void testTokenizerConsume_thenTokenizerWithTextIsS_valueCurrentTokenIsEmptyString()
      throws ParseException {
    // Arrange
    Tokenizer tokenizer = new Tokenizer(PostParams.S_VALUE);

    // Act
    tokenizer.consume(PostParams.S_VALUE);

    // Assert
    assertEquals("", tokenizer.currentToken());
  }

  /**
   * Test Tokenizer {@link Tokenizer#consume(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then throw {@link ParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#consume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.consume(String)"})
  public void testTokenizerConsume_whenHttpsExampleOrgExample_thenThrowParseException()
      throws ParseException {
    // Arrange, Act and Assert
    assertThrows(
        ParseException.class,
        () -> new Tokenizer(PostParams.S_VALUE).consume("https://example.org/example"));
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
   *       NameImpl#NameImpl(char[])} currentToken is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#nextToken()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tokenizer.nextToken()"})
  public void testTokenizerNextToken_thenTokenizerWithTextIsNameImplCurrentTokenIsA() {
    // Arrange
    NameImpl text = new NameImpl("\u0005A\u0005\n".toCharArray());
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    tokenizer.nextToken();

    // Assert
    assertEquals("A", tokenizer.currentToken());
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
    StringBuilder text = new StringBuilder(PostParams.S_VALUE);
    text.appendCodePoint(1);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    boolean actualTryConsumeResult = tokenizer.tryConsume(PostParams.S_VALUE);

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertTrue(actualTryConsumeResult);
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
  public void testTokenizerTryConsume2() {
    // Arrange
    StringBuilder text = new StringBuilder(PostParams.S_VALUE);
    text.appendCodePoint(10);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    boolean actualTryConsumeResult = tokenizer.tryConsume(PostParams.S_VALUE);

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertTrue(actualTryConsumeResult);
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
  public void testTokenizerTryConsume3() {
    // Arrange
    StringBuilder text = new StringBuilder(PostParams.S_VALUE);
    text.appendCodePoint(1);
    text.appendCodePoint(10);
    Tokenizer tokenizer = new Tokenizer(text);

    // Act
    boolean actualTryConsumeResult = tokenizer.tryConsume(PostParams.S_VALUE);

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertTrue(actualTryConsumeResult);
  }

  /**
   * Test Tokenizer {@link Tokenizer#tryConsume(String)}.
   *
   * <ul>
   *   <li>Then {@link Tokenizer#Tokenizer(CharSequence)} with text is {@link PostParams#S_VALUE}
   *       currentToken is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#tryConsume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Tokenizer#tryConsume(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
