package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.google.api.Backend;
import com.google.api.BackendRule;
import com.google.api.ClientLibrarySettings;
import com.google.api.CommonLanguageSettings;
import com.google.protobuf.Any;
import com.google.protobuf.Api;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.util.HashMap;
import org.apache.commons.lang3.text.StrBuilder;
import org.aspectj.org.eclipse.jdt.internal.compiler.apt.model.NameImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.Wallet;

public class JsonFormatDiffblueTest {
  /**
   * Method under test:
   * {@link JsonFormat.InvalidEscapeSequence#InvalidEscapeSequence(String)}
   */
  @Test
  public void testInvalidEscapeSequenceNewInvalidEscapeSequence() {
    // Arrange and Act
    JsonFormat.InvalidEscapeSequence actualInvalidEscapeSequence = new JsonFormat.InvalidEscapeSequence(
        "https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", actualInvalidEscapeSequence.getMessage());
    assertNull(actualInvalidEscapeSequence.getCause());
    assertEquals(0, actualInvalidEscapeSequence.getSuppressed().length);
  }

  /**
   * Method under test: {@link JsonFormat.JsonGenerator#outdent()}
   */
  @Test
  public void testJsonGeneratorOutdent() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new JsonFormat.JsonGenerator(new SerializeWriter())).outdent());
  }

  /**
   * Method under test: {@link JsonFormat.JsonGenerator#print(CharSequence)}
   */
  @Test
  public void testJsonGeneratorPrint() throws IOException {
    // Arrange
    JsonFormat.JsonGenerator jsonGenerator = new JsonFormat.JsonGenerator(new SerializeWriter());
    NameImpl text = mock(NameImpl.class);
    when(text.charAt(anyInt())).thenReturn('A');
    when(text.length()).thenReturn(3);
    when(text.subSequence(anyInt(), anyInt())).thenReturn(PostParams.S_VALUE);

    // Act
    jsonGenerator.print(text);

    // Assert
    verify(text, atLeast(1)).charAt(anyInt());
    verify(text).length();
    verify(text).subSequence(eq(0), eq(3));
  }

  /**
   * Method under test: {@link JsonFormat.JsonGenerator#print(CharSequence)}
   */
  @Test
  public void testJsonGeneratorPrint2() throws IOException {
    // Arrange
    JsonFormat.JsonGenerator jsonGenerator = new JsonFormat.JsonGenerator(new SerializeWriter());
    NameImpl text = mock(NameImpl.class);
    when(text.charAt(anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(text.length()).thenReturn(3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jsonGenerator.print(text));
    verify(text).charAt(eq(0));
    verify(text).length();
  }

  /**
   * Method under test: {@link JsonFormat.ParseException#ParseException(String)}
   */
  @Test
  public void testParseExceptionNewParseException() {
    // Arrange and Act
    JsonFormat.ParseException actualParseException = new JsonFormat.ParseException("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", actualParseException.getMessage());
    assertNull(actualParseException.getCause());
    assertEquals(0, actualParseException.getSuppressed().length);
  }

  /**
   * Method under test: {@link JsonFormat#print(Message, Appendable, boolean)}
   */
  @Test
  public void testPrint() throws IOException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getAllFields()).thenReturn(new HashMap<>());
    SerializeWriter output = new SerializeWriter();

    // Act
    JsonFormat.print(message, output, true);

    // Assert
    verify(message).getAllFields();
    assertEquals(0, output.toCharArrayForSpringWebSocket().length);
    assertEquals(2, output.size());
    assertArrayEquals(new char[]{'{', '}'}, output.toCharArray());
  }

  /**
   * Method under test: {@link JsonFormat#print(Message, Appendable, boolean)}
   */
  @Test
  public void testPrint2() throws IOException {
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
   * Method under test: {@link JsonFormat#print(Message, Appendable, boolean)}
   */
  @Test
  public void testPrint3() throws IOException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getAllFields()).thenReturn(new HashMap<>());

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(message, output, true);

    // Assert
    verify(message).getAllFields();
    char[] toCharArrayResult = output.toCharArray();
    assertEquals('e', toCharArrayResult[4]);
    char[] toCharArrayForSpringWebSocketResult = output.toCharArrayForSpringWebSocket();
    assertEquals('e', toCharArrayForSpringWebSocketResult[3]);
    assertEquals('l', toCharArrayForSpringWebSocketResult[1]);
    assertEquals('u', toCharArrayResult[3]);
    assertEquals('u', toCharArrayForSpringWebSocketResult[2]);
    assertEquals('{', toCharArrayResult[5]);
    assertEquals('{', toCharArrayForSpringWebSocketResult[4]);
    assertEquals('}', toCharArrayResult[6]);
    assertEquals(5, toCharArrayForSpringWebSocketResult.length);
    assertEquals(7, output.size());
    assertEquals(7, toCharArrayResult.length);
    assertEquals(8, output.getBufferLength());
  }

  /**
   * Method under test: {@link JsonFormat#print(Message, Appendable, boolean)}
   */
  @Test
  public void testPrint4() throws IOException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getAllFields()).thenReturn(new HashMap<>());

    SerializeWriter output = new SerializeWriter(3);
    output.append("Csq");

    // Act
    JsonFormat.print(message, output, true);

    // Assert
    verify(message).getAllFields();
    char[] toCharArrayForSpringWebSocketResult = output.toCharArrayForSpringWebSocket();
    assertEquals('q', toCharArrayForSpringWebSocketResult[1]);
    char[] toCharArrayResult = output.toCharArray();
    assertEquals('{', toCharArrayResult[3]);
    assertEquals('{', toCharArrayForSpringWebSocketResult[2]);
    assertEquals('}', toCharArrayResult[4]);
    assertEquals(3, toCharArrayForSpringWebSocketResult.length);
    assertEquals(5, output.getBufferLength());
    assertEquals(5, output.size());
    assertEquals(5, toCharArrayResult.length);
  }

  /**
   * Method under test: {@link JsonFormat#print(Message, Appendable, boolean)}
   */
  @Test
  public void testPrint5() throws IOException {
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
    char[] toCharArrayForSpringWebSocketResult = output.toCharArrayForSpringWebSocket();
    assertEquals('q', toCharArrayForSpringWebSocketResult[1]);
    char[] toCharArrayResult = output.toCharArray();
    assertEquals('{', toCharArrayResult[3]);
    assertEquals('{', toCharArrayForSpringWebSocketResult[2]);
    assertEquals('}', toCharArrayResult[4]);
    assertEquals(3, toCharArrayForSpringWebSocketResult.length);
    assertEquals(5, output.getBufferLength());
    assertEquals(5, output.size());
    assertEquals(5, toCharArrayResult.length);
  }

  /**
   * Method under test:
   * {@link JsonFormat#print(Message, JsonFormat.JsonGenerator, boolean)}
   */
  @Test
  public void testPrint6() throws IOException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getAllFields()).thenReturn(new HashMap<>());

    // Act
    JsonFormat.print(message, new JsonFormat.JsonGenerator(new SerializeWriter()), true);

    // Assert that nothing has changed
    verify(message).getAllFields();
  }

  /**
   * Method under test:
   * {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  public void testPrint7() throws IOException {
    // Arrange
    UnknownFieldSet fields = UnknownFieldSet.getDefaultInstance();
    SerializeWriter output = new SerializeWriter();

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals(0, output.toCharArrayForSpringWebSocket().length);
    assertEquals(2, output.size());
    assertArrayEquals(new char[]{'{', '}'}, output.toCharArray());
  }

  /**
   * Method under test:
   * {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  public void testPrint8() throws IOException {
    // Arrange
    UnknownFieldSet fields = UnknownFieldSet.getDefaultInstance();
    StringWriter output = new StringWriter();

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    assertEquals("{}", output.toString());
  }

  /**
   * Method under test:
   * {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  public void testPrint9() throws IOException {
    // Arrange
    UnknownFieldSet fields = UnknownFieldSet.getDefaultInstance();

    SerializeWriter output = new SerializeWriter(3);
    output.append(PostParams.S_VALUE);

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    char[] toCharArrayResult = output.toCharArray();
    assertEquals('e', toCharArrayResult[4]);
    char[] toCharArrayForSpringWebSocketResult = output.toCharArrayForSpringWebSocket();
    assertEquals('e', toCharArrayForSpringWebSocketResult[3]);
    assertEquals('l', toCharArrayForSpringWebSocketResult[1]);
    assertEquals('u', toCharArrayResult[3]);
    assertEquals('u', toCharArrayForSpringWebSocketResult[2]);
    assertEquals('{', toCharArrayResult[5]);
    assertEquals('{', toCharArrayForSpringWebSocketResult[4]);
    assertEquals('}', toCharArrayResult[6]);
    assertEquals(5, toCharArrayForSpringWebSocketResult.length);
    assertEquals(7, output.size());
    assertEquals(7, toCharArrayResult.length);
    assertEquals(8, output.getBufferLength());
  }

  /**
   * Method under test:
   * {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  public void testPrint10() throws IOException {
    // Arrange
    UnknownFieldSet fields = UnknownFieldSet.getDefaultInstance();

    SerializeWriter output = new SerializeWriter(3);
    output.append("Csq");

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    char[] toCharArrayForSpringWebSocketResult = output.toCharArrayForSpringWebSocket();
    assertEquals('q', toCharArrayForSpringWebSocketResult[1]);
    char[] toCharArrayResult = output.toCharArray();
    assertEquals('{', toCharArrayResult[3]);
    assertEquals('{', toCharArrayForSpringWebSocketResult[2]);
    assertEquals('}', toCharArrayResult[4]);
    assertEquals(3, toCharArrayForSpringWebSocketResult.length);
    assertEquals(5, output.getBufferLength());
    assertEquals(5, output.size());
    assertEquals(5, toCharArrayResult.length);
  }

  /**
   * Method under test:
   * {@link JsonFormat#print(UnknownFieldSet, Appendable, boolean)}
   */
  @Test
  public void testPrint11() throws IOException {
    // Arrange
    UnknownFieldSet fields = UnknownFieldSet.getDefaultInstance();

    SerializeWriter output = new SerializeWriter(3);
    output.setMaxBufSize(10);
    output.append("Csq");

    // Act
    JsonFormat.print(fields, output, true);

    // Assert
    char[] toCharArrayForSpringWebSocketResult = output.toCharArrayForSpringWebSocket();
    assertEquals('q', toCharArrayForSpringWebSocketResult[1]);
    char[] toCharArrayResult = output.toCharArray();
    assertEquals('{', toCharArrayResult[3]);
    assertEquals('{', toCharArrayForSpringWebSocketResult[2]);
    assertEquals('}', toCharArrayResult[4]);
    assertEquals(3, toCharArrayForSpringWebSocketResult.length);
    assertEquals(5, output.getBufferLength());
    assertEquals(5, output.size());
    assertEquals(5, toCharArrayResult.length);
  }

  /**
   * Method under test: {@link JsonFormat#printToString(Message)}
   */
  @Test
  public void testPrintToString() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonFormat.printToString(DescriptorProtos.FeatureSetDefaults.getDefaultInstance()));
    assertEquals("{}", JsonFormat.printToString(Any.getDefaultInstance()));
    assertEquals("{}", JsonFormat.printToString(Api.getDefaultInstance()));
    assertEquals("{}", JsonFormat.printToString(Backend.getDefaultInstance()));
    assertEquals("{}", JsonFormat.printToString(BackendRule.getDefaultInstance()));
    assertEquals("{}", JsonFormat.printToString(ClientLibrarySettings.getDefaultInstance()));
    assertEquals("{}", JsonFormat.printToString(DescriptorProtos.FeatureSetDefaults.getDefaultInstance(), true));
    assertEquals("{}", JsonFormat.printToString(Api.getDefaultInstance(), true));
    assertEquals("{}", JsonFormat.printToString(CommonLanguageSettings.getDefaultInstance(), true));
    assertEquals("{}", JsonFormat.printToString(UnknownFieldSet.getDefaultInstance(), true));
  }

  /**
   * Method under test:
   * {@link JsonFormat#merge(CharSequence, ExtensionRegistry, Message.Builder, boolean)}
   */
  @Test
  public void testMerge() throws JsonFormat.ParseException {
    // Arrange
    NameImpl input = mock(NameImpl.class);
    when(input.subSequence(anyInt(), anyInt())).thenThrow(new RuntimeException("   "));
    when(input.charAt(anyInt())).thenReturn('A');
    when(input.length()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonFormat.merge(input, ExtensionRegistry.getEmptyRegistry(), null, true));
    verify(input, atLeast(1)).charAt(anyInt());
    verify(input).length();
    verify(input).subSequence(eq(0), eq(3));
  }

  /**
   * Method under test: {@link JsonFormat#merge(CharSequence, Message.Builder)}
   */
  @Test
  public void testMerge2() throws JsonFormat.ParseException {
    // Arrange
    NameImpl input = mock(NameImpl.class);
    when(input.subSequence(anyInt(), anyInt())).thenThrow(new RuntimeException("   "));
    when(input.charAt(anyInt())).thenReturn('A');
    when(input.length()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonFormat.merge(input, null));
    verify(input, atLeast(1)).charAt(anyInt());
    verify(input).length();
    verify(input).subSequence(eq(0), eq(3));
  }

  /**
   * Method under test:
   * {@link JsonFormat#merge(CharSequence, Message.Builder, boolean)}
   */
  @Test
  public void testMerge3() throws JsonFormat.ParseException {
    // Arrange
    NameImpl input = mock(NameImpl.class);
    when(input.subSequence(anyInt(), anyInt())).thenThrow(new RuntimeException("   "));
    when(input.charAt(anyInt())).thenReturn('A');
    when(input.length()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonFormat.merge(input, null, true));
    verify(input, atLeast(1)).charAt(anyInt());
    verify(input).length();
    verify(input).subSequence(eq(0), eq(3));
  }

  /**
   * Method under test: {@link JsonFormat#printErrorMsg(Exception)}
   */
  @Test
  public void testPrintErrorMsg() {
    // Arrange, Act and Assert
    assertEquals("{\"Error\":\"foo\"}", JsonFormat.printErrorMsg(new Exception("foo")));
  }

  /**
   * Method under test: {@link JsonFormat#toStringBuilder(Readable)}
   */
  @Test
  public void testToStringBuilder() throws IOException {
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
   * Method under test: {@link JsonFormat#escapeBytes(ByteString)}
   */
  @Test
  public void testEscapeBytes() throws UnsupportedEncodingException {
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
   * Method under test: {@link JsonFormat#escapeBytes(ByteString)}
   */
  @Test
  public void testEscapeBytes2() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonFormat.escapeBytes(input));
    verify(input).toByteArray();
  }

  /**
   * Method under test:
   * {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  public void testEscapeBytes3() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  public void testEscapeBytes4() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  public void testEscapeBytes5() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonFormat.escapeBytes(input, "https://example.org/example", true));
    verify(input).toByteArray();
  }

  /**
   * Method under test:
   * {@link JsonFormat#escapeBytes(ByteString, String, boolean)}
   */
  @Test
  public void testEscapeBytes6() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonFormat.escapeBytes(input, "https://example.org/example", false));
    verify(input).toByteArray();
  }

  /**
   * Method under test: {@link JsonFormat#escapeBytesSelfType(ByteString, String)}
   */
  @Test
  public void testEscapeBytesSelfType() throws UnsupportedEncodingException {
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
   * Method under test: {@link JsonFormat#escapeBytesSelfType(ByteString, String)}
   */
  @Test
  public void testEscapeBytesSelfType2() {
    // Arrange
    ByteString input = mock(ByteString.class);
    when(input.toByteArray()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonFormat.escapeBytesSelfType(input, "https://example.org/example"));
    verify(input).toByteArray();
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#atEnd()}
   */
  @Test
  public void testTokenizerAtEnd() {
    // Arrange, Act and Assert
    assertFalse((new JsonFormat.Tokenizer(PostParams.S_VALUE)).atEnd());
    assertTrue((new JsonFormat.Tokenizer("")).atEnd());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consume(String)}
   */
  @Test
  public void testTokenizerConsume() throws JsonFormat.ParseException {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.ParseException.class,
        () -> (new JsonFormat.Tokenizer(PostParams.S_VALUE)).consume("https://example.org/example"));
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consume(String)}
   */
  @Test
  public void testTokenizerConsume2() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(PostParams.S_VALUE);

    // Act
    tokenizer.consume(PostParams.S_VALUE);

    // Assert
    assertEquals("", tokenizer.currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeBoolean()}
   */
  @Test
  public void testTokenizerConsumeBoolean() throws JsonFormat.ParseException {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.ParseException.class,
        () -> (new JsonFormat.Tokenizer(PostParams.S_VALUE)).consumeBoolean());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeBoolean()}
   */
  @Test
  public void testTokenizerConsumeBoolean2() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(Boolean.TRUE.toString());

    // Act
    boolean actualConsumeBooleanResult = tokenizer.consumeBoolean();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertTrue(actualConsumeBooleanResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeBoolean()}
   */
  @Test
  public void testTokenizerConsumeBoolean3() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(Boolean.FALSE.toString());

    // Act
    boolean actualConsumeBooleanResult = tokenizer.consumeBoolean();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertFalse(actualConsumeBooleanResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeBoolean()}
   */
  @Test
  public void testTokenizerConsumeBoolean4() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder(Boolean.TRUE.toString());
    text.appendCodePoint(1);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    boolean actualConsumeBooleanResult = tokenizer.consumeBoolean();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertTrue(actualConsumeBooleanResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeBoolean()}
   */
  @Test
  public void testTokenizerConsumeBoolean5() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder(Boolean.TRUE.toString());
    text.appendCodePoint(10);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    boolean actualConsumeBooleanResult = tokenizer.consumeBoolean();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertTrue(actualConsumeBooleanResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeByteString()}
   */
  @Test
  public void testTokenizerConsumeByteString() throws JsonFormat.ParseException {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.ParseException.class,
        () -> (new JsonFormat.Tokenizer(PostParams.S_VALUE)).consumeByteString());
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer("")).consumeByteString());
    assertThrows(JsonFormat.ParseException.class,
        () -> (new JsonFormat.Tokenizer(PostParams.S_VALUE)).consumeByteString("https://example.org/example", true));
    assertThrows(JsonFormat.ParseException.class,
        () -> (new JsonFormat.Tokenizer("")).consumeByteString("https://example.org/example", true));
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeDouble()}
   */
  @Test
  public void testTokenizerConsumeDouble() throws JsonFormat.ParseException {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(PostParams.S_VALUE)).consumeDouble());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeDouble()}
   */
  @Test
  public void testTokenizerConsumeDouble2() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("infinity");

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Double.POSITIVE_INFINITY, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeDouble()}
   */
  @Test
  public void testTokenizerConsumeDouble3() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("nan");

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Double.NaN, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeDouble()}
   */
  @Test
  public void testTokenizerConsumeDouble4() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("42");

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(42.0d, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeDouble()}
   */
  @Test
  public void testTokenizerConsumeDouble5() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("infinity");
    text.appendCodePoint(1);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertEquals(Double.POSITIVE_INFINITY, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeDouble()}
   */
  @Test
  public void testTokenizerConsumeDouble6() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("infinity");
    text.appendCodePoint(10);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Double.POSITIVE_INFINITY, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeDouble()}
   */
  @Test
  public void testTokenizerConsumeDouble7() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("infinity");
    text.insert(0, "-");
    text.appendCodePoint(1);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertEquals(Double.NEGATIVE_INFINITY, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeDouble()}
   */
  @Test
  public void testTokenizerConsumeDouble8() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("infinity");
    text.append("\u0001\t\u0001\t".toCharArray());
    text.appendCodePoint(10);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    double actualConsumeDoubleResult = tokenizer.consumeDouble();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertEquals(Double.POSITIVE_INFINITY, actualConsumeDoubleResult, 0.0);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeFloat()}
   */
  @Test
  public void testTokenizerConsumeFloat() throws JsonFormat.ParseException {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(PostParams.S_VALUE)).consumeFloat());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeFloat()}
   */
  @Test
  public void testTokenizerConsumeFloat2() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("infinity");

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Float.POSITIVE_INFINITY, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeFloat()}
   */
  @Test
  public void testTokenizerConsumeFloat3() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("nan");

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Float.NaN, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeFloat()}
   */
  @Test
  public void testTokenizerConsumeFloat4() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("42");

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(42.0f, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeFloat()}
   */
  @Test
  public void testTokenizerConsumeFloat5() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("nanf?");

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("?", tokenizer.currentToken());
    assertEquals(Float.NaN, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeFloat()}
   */
  @Test
  public void testTokenizerConsumeFloat6() throws JsonFormat.ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(42.0f, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeFloat()}
   */
  @Test
  public void testTokenizerConsumeFloat7() throws JsonFormat.ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("nan", "Objs");
    text.appendln("42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    float actualConsumeFloatResult = tokenizer.consumeFloat();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals(Float.NaN, actualConsumeFloatResult, 0.0f);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(PostParams.S_VALUE);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(PostParams.S_VALUE, actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier2() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("https://example.org/example");

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals(":", tokenizer.currentToken());
    assertEquals("https", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier3() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(Util.CONTRACT_ADDRESS);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Util.CONTRACT_ADDRESS, actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier4() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(Util.CONTRACT_TYPE);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(Util.CONTRACT_TYPE, actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier5() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("\"");

    // Act and Assert
    assertEquals("", tokenizer.consumeIdentifier());
    assertEquals("", tokenizer.currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier6() throws JsonFormat.ParseException {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer("\"|'")).consumeIdentifier());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier7() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("42");

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier8() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(Wallet.CONTRACT_VALIDATE_ERROR);

    // Act and Assert
    assertEquals("Contract", tokenizer.consumeIdentifier());
    assertEquals("validate", tokenizer.currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier9() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier10() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("4242", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier11() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("\"|'");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act and Assert
    assertEquals("", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier12() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier13() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("false42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier14() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("a42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier15() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("9742", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier16() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.542", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier17() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 3);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("3", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier18() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 97);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("97", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier19() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 34);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("34", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier20() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 65);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("65", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier21() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 48);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("48", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier22() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 1);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("1", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier23() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 0);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier24() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 95);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("95", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier25() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "foo");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foo", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier26() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 46);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("46", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier27() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((Object) "42");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("424242", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier28() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append((Object) "42");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foo4242", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier29() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value4242", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier30() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append((Object) "42");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("true4242", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier31() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append((Object) "42");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("344242", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier32() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 5);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("542", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier33() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 34);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("3442", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier34() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 65);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("6542", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier35() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 48);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("4842", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier36() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 1);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("142", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier37() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 0);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("042", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier38() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 95);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("9542", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier39() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "foo");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foo42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier40() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 46);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("4642", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier41() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append("\"|'");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act and Assert
    assertEquals("42", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier42() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append("\"|'");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("|", tokenizer.currentToken());
    assertEquals(PostParams.S_VALUE, actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier43() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append("\"|'");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("|", tokenizer.currentToken());
    assertEquals(Boolean.FALSE.toString(), actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier44() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(2);
    text.append("\"|'");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act and Assert
    assertEquals("2", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier45() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append("\"|'");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act and Assert
    assertEquals("10.0", tokenizer.consumeIdentifier());
    assertEquals("|", tokenizer.currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier46() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42value42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier47() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier48() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("truevalue42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier49() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("avalue42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier50() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("97value42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier51() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append((CharSequence) PostParams.S_VALUE);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.5value42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier52() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(false);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42false42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier53() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append(false);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foofalse42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier54() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(false);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier55() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(false);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("falsefalse42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier56() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append(false);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("34false42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier57() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("true42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier58() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append('a');
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("42a42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier59() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append('a');
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("valuea42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier60() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append('a');
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("truea42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier61() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(4);
    text.append('a');
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("4a42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier62() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append('a');
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.0a42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier63() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('A');
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("A42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier64() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('_');
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("_42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier65() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('Z');
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("Z42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier66() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('.');
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(".42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier67() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('z');
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("z42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier68() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(97);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("429742", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier69() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(97);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value9742", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier70() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(false);
    text.append(97);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("false9742", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier71() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append('a');
    text.append(97);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("a9742", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier72() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(97);
    text.append(97);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("979742", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier73() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(0.5f);
    text.append(97);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("0.59742", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier74() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("922337203685477580742", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier75() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) "42");
    text.append(0.5f);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("420.542", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier76() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append("foo");
    text.append(0.5f);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("foo0.542", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier77() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((CharSequence) PostParams.S_VALUE);
    text.append(0.5f);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("value0.542", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier78() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(true);
    text.append(0.5f);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("true0.542", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier79() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(34);
    text.append(0.5f);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("340.542", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier80() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(10.0f);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("10.042", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier81() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append(Float.NaN);
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("NaN42", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeIdentifier()}
   */
  @Test
  public void testTokenizerConsumeIdentifier82() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("\"");
    text.append((Object) 52);
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    String actualConsumeIdentifierResult = tokenizer.consumeIdentifier();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals("52", actualConsumeIdentifierResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt32()}
   */
  @Test
  public void testTokenizerConsumeInt32() throws JsonFormat.ParseException {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(PostParams.S_VALUE)).consumeInt32());
    assertThrows(JsonFormat.ParseException.class,
        () -> (new JsonFormat.Tokenizer(Util.CONTRACT_ADDRESS)).consumeInt32());
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer("-")).consumeInt32());
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer("0x")).consumeInt32());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt64()}
   */
  @Test
  public void testTokenizerConsumeInt64() throws JsonFormat.ParseException {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(PostParams.S_VALUE)).consumeInt64());
    assertThrows(JsonFormat.ParseException.class,
        () -> (new JsonFormat.Tokenizer(Util.CONTRACT_ADDRESS)).consumeInt64());
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer("-")).consumeInt64());
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer("0x")).consumeInt64());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt32()}
   */
  @Test
  public void testTokenizerConsumeInt322() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("0");

    // Act
    int actualConsumeInt32Result = tokenizer.consumeInt32();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(0, actualConsumeInt32Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt32()}
   */
  @Test
  public void testTokenizerConsumeInt323() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    int actualConsumeInt32Result = tokenizer.consumeInt32();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(-42, actualConsumeInt32Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt32()}
   */
  @Test
  public void testTokenizerConsumeInt324() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append((Object) Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(text)).consumeInt32());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt32()}
   */
  @Test
  public void testTokenizerConsumeInt325() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");

    // Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(text)).consumeInt32());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt32()}
   */
  @Test
  public void testTokenizerConsumeInt326() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append("1\n\u0001\n".toCharArray());
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    int actualConsumeInt32Result = tokenizer.consumeInt32();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertEquals(-1, actualConsumeInt32Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt32()}
   */
  @Test
  public void testTokenizerConsumeInt327() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("0x");
    text.append((Object) Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(text)).consumeInt32());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt32()}
   */
  @Test
  public void testTokenizerConsumeInt328() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("0x");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");

    // Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(text)).consumeInt32());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt64()}
   */
  @Test
  public void testTokenizerConsumeInt642() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("0");

    // Act
    long actualConsumeInt64Result = tokenizer.consumeInt64();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(0L, actualConsumeInt64Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt64()}
   */
  @Test
  public void testTokenizerConsumeInt643() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    long actualConsumeInt64Result = tokenizer.consumeInt64();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(-42L, actualConsumeInt64Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt64()}
   */
  @Test
  public void testTokenizerConsumeInt644() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");

    // Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(text)).consumeInt64());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt64()}
   */
  @Test
  public void testTokenizerConsumeInt645() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append("1\n\u0001\n".toCharArray());
    text.append((Object) "42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    long actualConsumeInt64Result = tokenizer.consumeInt64();

    // Assert
    assertEquals("\u0001", tokenizer.currentToken());
    assertEquals(-1L, actualConsumeInt64Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt64()}
   */
  @Test
  public void testTokenizerConsumeInt646() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("0x");
    text.append(Long.MAX_VALUE);
    text.append((Object) "42");

    // Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(text)).consumeInt64());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeInt64()}
   */
  @Test
  public void testTokenizerConsumeInt647() throws JsonFormat.ParseException {
    // Arrange
    StringBuilder text = new StringBuilder("-");
    text.append(Long.MAX_VALUE);
    text.append((Object) ":");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    long actualConsumeInt64Result = tokenizer.consumeInt64();

    // Assert
    assertEquals(":", tokenizer.currentToken());
    assertEquals(-9223372036854775807L, actualConsumeInt64Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeString()}
   */
  @Test
  public void testTokenizerConsumeString() throws JsonFormat.ParseException {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(PostParams.S_VALUE)).consumeString());
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer("")).consumeString());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeUInt32()}
   */
  @Test
  public void testTokenizerConsumeUInt32() throws JsonFormat.ParseException {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(PostParams.S_VALUE)).consumeUInt32());
    assertThrows(JsonFormat.ParseException.class,
        () -> (new JsonFormat.Tokenizer(Util.CONTRACT_ADDRESS)).consumeUInt32());
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer("-")).consumeUInt32());
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer("0x")).consumeUInt32());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeUInt64()}
   */
  @Test
  public void testTokenizerConsumeUInt64() throws JsonFormat.ParseException {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer(PostParams.S_VALUE)).consumeUInt64());
    assertThrows(JsonFormat.ParseException.class,
        () -> (new JsonFormat.Tokenizer(Util.CONTRACT_ADDRESS)).consumeUInt64());
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer("-")).consumeUInt64());
    assertThrows(JsonFormat.ParseException.class, () -> (new JsonFormat.Tokenizer("0x")).consumeUInt64());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeUInt32()}
   */
  @Test
  public void testTokenizerConsumeUInt322() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("0");

    // Act
    int actualConsumeUInt32Result = tokenizer.consumeUInt32();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(0, actualConsumeUInt32Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeUInt32()}
   */
  @Test
  public void testTokenizerConsumeUInt323() throws JsonFormat.ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    int actualConsumeUInt32Result = tokenizer.consumeUInt32();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(42, actualConsumeUInt32Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeUInt32()}
   */
  @Test
  public void testTokenizerConsumeUInt324() throws JsonFormat.ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("0");
    text.appendln("42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    int actualConsumeUInt32Result = tokenizer.consumeUInt32();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals(0, actualConsumeUInt32Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeUInt32()}
   */
  @Test
  public void testTokenizerConsumeUInt325() throws JsonFormat.ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendFixedWidthPadRight(Short.SIZE, 3, '\u0002');
    text.appendln("42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    int actualConsumeUInt32Result = tokenizer.consumeUInt32();

    // Assert
    assertEquals("\u0002", tokenizer.currentToken());
    assertEquals(Short.SIZE, actualConsumeUInt32Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeUInt64()}
   */
  @Test
  public void testTokenizerConsumeUInt642() throws JsonFormat.ParseException {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("0");

    // Act
    long actualConsumeUInt64Result = tokenizer.consumeUInt64();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(0L, actualConsumeUInt64Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeUInt64()}
   */
  @Test
  public void testTokenizerConsumeUInt643() throws JsonFormat.ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    long actualConsumeUInt64Result = tokenizer.consumeUInt64();

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertEquals(42L, actualConsumeUInt64Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeUInt64()}
   */
  @Test
  public void testTokenizerConsumeUInt644() throws JsonFormat.ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendln("0");
    text.appendln("42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    long actualConsumeUInt64Result = tokenizer.consumeUInt64();

    // Assert
    assertEquals("42", tokenizer.currentToken());
    assertEquals(0L, actualConsumeUInt64Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#consumeUInt64()}
   */
  @Test
  public void testTokenizerConsumeUInt645() throws JsonFormat.ParseException {
    // Arrange
    StrBuilder text = new StrBuilder();
    text.appendFixedWidthPadRight(10, 3, '\u0010');
    text.appendln("42");
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(text);

    // Act
    long actualConsumeUInt64Result = tokenizer.consumeUInt64();

    // Assert
    assertEquals("\u0010", tokenizer.currentToken());
    assertEquals(10L, actualConsumeUInt64Result);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#currentToken()}
   */
  @Test
  public void testTokenizerCurrentToken() {
    // Arrange, Act and Assert
    assertEquals(PostParams.S_VALUE, (new JsonFormat.Tokenizer(PostParams.S_VALUE)).currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#lookingAtBoolean()}
   */
  @Test
  public void testTokenizerLookingAtBoolean() {
    // Arrange, Act and Assert
    assertFalse((new JsonFormat.Tokenizer(PostParams.S_VALUE)).lookingAtBoolean());
    assertTrue((new JsonFormat.Tokenizer(Boolean.TRUE.toString())).lookingAtBoolean());
    assertTrue((new JsonFormat.Tokenizer(Boolean.FALSE.toString())).lookingAtBoolean());
    assertFalse((new JsonFormat.Tokenizer("")).lookingAtBoolean());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#lookingAtInteger()}
   */
  @Test
  public void testTokenizerLookingAtInteger() {
    // Arrange, Act and Assert
    assertFalse((new JsonFormat.Tokenizer(PostParams.S_VALUE)).lookingAtInteger());
    assertFalse((new JsonFormat.Tokenizer("")).lookingAtInteger());
    assertTrue((new JsonFormat.Tokenizer("42")).lookingAtInteger());
    assertTrue((new JsonFormat.Tokenizer("-")).lookingAtInteger());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#Tokenizer(CharSequence)}
   */
  @Test
  public void testTokenizerNewTokenizer() {
    // Arrange, Act and Assert
    assertEquals(PostParams.S_VALUE, (new JsonFormat.Tokenizer(PostParams.S_VALUE)).currentToken());
    assertEquals("", (new JsonFormat.Tokenizer("   ")).currentToken());
    assertEquals("\u0005",
        (new JsonFormat.Tokenizer(new NameImpl("\u0005\u0001\u0005\u0001".toCharArray()))).currentToken());
    assertEquals("", (new JsonFormat.Tokenizer(System.lineSeparator())).currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#nextToken()}
   */
  @Test
  public void testTokenizerNextToken() {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(PostParams.S_VALUE);

    // Act
    tokenizer.nextToken();

    // Assert
    assertEquals("", tokenizer.currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#nextToken()}
   */
  @Test
  public void testTokenizerNextToken2() {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer("https://example.org/example");

    // Act
    tokenizer.nextToken();

    // Assert
    assertEquals(":", tokenizer.currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#nextToken()}
   */
  @Test
  public void testTokenizerNextToken3() {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(Wallet.CONTRACT_VALIDATE_ERROR);

    // Act
    tokenizer.nextToken();

    // Assert
    assertEquals("validate", tokenizer.currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#parseException(String)}
   */
  @Test
  public void testTokenizerParseException() {
    // Arrange and Act
    JsonFormat.ParseException actualParseExceptionResult = (new JsonFormat.Tokenizer(PostParams.S_VALUE))
        .parseException("https://example.org/example");

    // Assert
    assertEquals("1:1: https://example.org/example", actualParseExceptionResult.getLocalizedMessage());
    assertEquals("1:1: https://example.org/example", actualParseExceptionResult.getMessage());
    assertNull(actualParseExceptionResult.getCause());
    assertEquals(0, actualParseExceptionResult.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link JsonFormat.Tokenizer#parseExceptionPreviousToken(String)}
   */
  @Test
  public void testTokenizerParseExceptionPreviousToken() {
    // Arrange and Act
    JsonFormat.ParseException actualParseExceptionPreviousTokenResult = (new JsonFormat.Tokenizer(PostParams.S_VALUE))
        .parseExceptionPreviousToken("https://example.org/example");

    // Assert
    assertEquals("1:1: https://example.org/example", actualParseExceptionPreviousTokenResult.getLocalizedMessage());
    assertEquals("1:1: https://example.org/example", actualParseExceptionPreviousTokenResult.getMessage());
    assertNull(actualParseExceptionPreviousTokenResult.getCause());
    assertEquals(0, actualParseExceptionPreviousTokenResult.getSuppressed().length);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#tryConsume(String)}
   */
  @Test
  public void testTokenizerTryConsume() {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(PostParams.S_VALUE);

    // Act and Assert
    assertFalse(tokenizer.tryConsume("https://example.org/example"));
    assertEquals(PostParams.S_VALUE, tokenizer.currentToken());
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#tryConsume(String)}
   */
  @Test
  public void testTokenizerTryConsume2() {
    // Arrange
    JsonFormat.Tokenizer tokenizer = new JsonFormat.Tokenizer(PostParams.S_VALUE);

    // Act
    boolean actualTryConsumeResult = tokenizer.tryConsume(PostParams.S_VALUE);

    // Assert
    assertEquals("", tokenizer.currentToken());
    assertTrue(actualTryConsumeResult);
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#unescapeBytes(CharSequence)}
   */
  @Test
  public void testTokenizerUnescapeBytes() throws JsonFormat.InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.InvalidEscapeSequence.class, () -> JsonFormat.Tokenizer.unescapeBytes(PostParams.S_VALUE));
    assertThrows(JsonFormat.InvalidEscapeSequence.class, () -> JsonFormat.Tokenizer.unescapeBytes(Util.CALL_DATA));
    assertThrows(JsonFormat.InvalidEscapeSequence.class, () -> JsonFormat.Tokenizer.unescapeBytes(null));
  }

  /**
   * Method under test: {@link JsonFormat.Tokenizer#unescapeBytes(CharSequence)}
   */
  @Test
  public void testTokenizerUnescapeBytes2() throws JsonFormat.InvalidEscapeSequence {
    // Arrange and Act
    ByteString actualUnescapeBytesResult = JsonFormat.Tokenizer.unescapeBytes("0x");

    // Assert
    assertEquals("", actualUnescapeBytesResult.toStringUtf8());
    assertFalse(actualUnescapeBytesResult.iterator().hasNext());
    assertTrue(actualUnescapeBytesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link JsonFormat.Tokenizer#unescapeBytesSelfType(String, String)}
   */
  @Test
  public void testTokenizerUnescapeBytesSelfType() throws JsonFormat.InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.InvalidEscapeSequence.class,
        () -> JsonFormat.Tokenizer.unescapeBytesSelfType("https://example.org/example", "https://example.org/example"));
    assertThrows(JsonFormat.InvalidEscapeSequence.class,
        () -> JsonFormat.Tokenizer.unescapeBytesSelfType(null, "https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link JsonFormat.Tokenizer#unescapeBytesSelfType(String, String)}
   */
  @Test
  public void testTokenizerUnescapeBytesSelfType2() throws JsonFormat.InvalidEscapeSequence {
    // Arrange and Act
    ByteString actualUnescapeBytesSelfTypeResult = JsonFormat.Tokenizer.unescapeBytesSelfType("0x",
        "https://example.org/example");

    // Assert
    assertEquals("", actualUnescapeBytesSelfTypeResult.toStringUtf8());
    assertFalse(actualUnescapeBytesSelfTypeResult.iterator().hasNext());
    assertTrue(actualUnescapeBytesSelfTypeResult.isEmpty());
  }

  /**
   * Method under test: {@link JsonFormat#unicodeEscaped(char)}
   */
  @Test
  public void testUnicodeEscaped() {
    // Arrange, Act and Assert
    assertEquals("\\u0041", JsonFormat.unicodeEscaped('A'));
    assertEquals("\\u000f", JsonFormat.unicodeEscaped('\u000f'));
    assertEquals("\\u0100", JsonFormat.unicodeEscaped('Ā'));
    assertEquals("\\u1000", JsonFormat.unicodeEscaped('က'));
  }

  /**
   * Method under test: {@link JsonFormat#unescapeBytes(CharSequence)}
   */
  @Test
  public void testUnescapeBytes() throws JsonFormat.InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertThrows(JsonFormat.InvalidEscapeSequence.class, () -> JsonFormat.unescapeBytes(PostParams.S_VALUE));
    assertThrows(JsonFormat.InvalidEscapeSequence.class, () -> JsonFormat.unescapeBytes(Util.CALL_DATA));
    assertThrows(JsonFormat.InvalidEscapeSequence.class, () -> JsonFormat.unescapeBytes(null));
  }

  /**
   * Method under test: {@link JsonFormat#unescapeBytes(CharSequence)}
   */
  @Test
  public void testUnescapeBytes2() throws JsonFormat.InvalidEscapeSequence {
    // Arrange and Act
    ByteString actualUnescapeBytesResult = JsonFormat.unescapeBytes("0x");

    // Assert
    assertEquals("", actualUnescapeBytesResult.toStringUtf8());
    assertFalse(actualUnescapeBytesResult.iterator().hasNext());
    assertTrue(actualUnescapeBytesResult.isEmpty());
  }

  /**
   * Method under test: {@link JsonFormat#escapeText(String)}
   */
  @Test
  public void testEscapeText() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", JsonFormat.escapeText("https://example.org/example"));
    assertEquals("\\\"", JsonFormat.escapeText("\""));
    assertEquals("\\\\\\\\\\\"", JsonFormat.escapeText("\\\\\""));
  }

  /**
   * Method under test:
   * {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}
   */
  @Test
  public void testAppendEscapedUnicode() {
    // Arrange
    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonFormat.appendEscapedUnicode(builder, 'A');

    // Assert
    assertEquals("foo\\u0041", builder.toString());
  }

  /**
   * Method under test:
   * {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}
   */
  @Test
  public void testAppendEscapedUnicode2() {
    // Arrange
    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonFormat.appendEscapedUnicode(builder, '\u000f');

    // Assert
    assertEquals("foo\\u000f", builder.toString());
  }

  /**
   * Method under test:
   * {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}
   */
  @Test
  public void testAppendEscapedUnicode3() {
    // Arrange
    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonFormat.appendEscapedUnicode(builder, 'Ā');

    // Assert
    assertEquals("foo\\u0100", builder.toString());
  }

  /**
   * Method under test:
   * {@link JsonFormat#appendEscapedUnicode(StringBuilder, char)}
   */
  @Test
  public void testAppendEscapedUnicode4() {
    // Arrange
    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonFormat.appendEscapedUnicode(builder, 'က');

    // Assert
    assertEquals("foo\\u1000", builder.toString());
  }

  /**
   * Method under test: {@link JsonFormat#unescapeText(String)}
   */
  @Test
  public void testUnescapeText() throws JsonFormat.InvalidEscapeSequence {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", JsonFormat.unescapeText("https://example.org/example"));
    assertEquals("\\\"", JsonFormat.unescapeText("\\\\\""));
    assertThrows(JsonFormat.InvalidEscapeSequence.class, () -> JsonFormat.unescapeText("\\u"));
    assertEquals("B", JsonFormat.unescapeText("\\u0042"));
  }

  /**
   * Method under test: {@link JsonFormat#parseInt32(String)}
   */
  @Test
  public void testParseInt32() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0, JsonFormat.parseInt32("0"));
    assertEquals(0, JsonFormat.parseInt32("-0"));
  }

  /**
   * Method under test: {@link JsonFormat#parseUInt32(String)}
   */
  @Test
  public void testParseUInt32() throws NumberFormatException {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> JsonFormat.parseUInt32("-"));
    assertEquals(0, JsonFormat.parseUInt32("0"));
  }

  /**
   * Method under test: {@link JsonFormat#parseInt64(String)}
   */
  @Test
  public void testParseInt64() throws NumberFormatException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonFormat.parseInt64("0"));
    assertEquals(0L, JsonFormat.parseInt64("-0"));
  }

  /**
   * Method under test: {@link JsonFormat#parseUInt64(String)}
   */
  @Test
  public void testParseUInt64() throws NumberFormatException {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> JsonFormat.parseUInt64("-"));
    assertEquals(0L, JsonFormat.parseUInt64("0"));
  }
}
