package org.tron.core.services.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.io.ByteArrayEndPoint;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpChannelState;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnection;
import org.eclipse.jetty.server.HttpInput;
import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.LocalConnector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.ResponseWriter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.Container;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.tron.api.GrpcAPI;
import org.tron.core.services.filter.CharResponseWrapper;
import org.tron.protos.Protocol;

public class UtilDiffblueTest {
  /**
   * Method under test: {@link Util#printErrorMsg(Exception)}
   */
  @Test
  public void testPrintErrorMsg() {
    // Arrange, Act and Assert
    assertEquals("{\"Error\":\"class java.lang.Exception : foo\"}", Util.printErrorMsg(new Exception("foo")));
  }

  /**
   * Method under test: {@link Util#printBlockList(GrpcAPI.BlockList, boolean)}
   */
  @Test
  public void testPrintBlockList() {
    // Arrange, Act and Assert
    assertEquals("{\"block\":[]}", Util.printBlockList(GrpcAPI.BlockList.getDefaultInstance(), true));
  }

  /**
   * Method under test: {@link Util#printBlock(Protocol.Block, boolean)}
   */
  @Test
  public void testPrintBlock() {
    // Arrange, Act and Assert
    assertEquals("{\"blockID\":\"00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855\"}",
        Util.printBlock(Protocol.Block.getDefaultInstance(), true));
    assertEquals("{\"blockID\":\"00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855\"}",
        Util.printBlock(Protocol.Block.getDefaultInstance(), false));
  }

  /**
   * Method under test: {@link Util#printBlockToJSON(Protocol.Block, boolean)}
   */
  @Test
  public void testPrintBlockToJSON() {
    // Arrange and Act
    JSONObject actualPrintBlockToJSONResult = Util.printBlockToJSON(Protocol.Block.getDefaultInstance(), true);

    // Assert
    assertEquals(1, actualPrintBlockToJSONResult.size());
    assertEquals("00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualPrintBlockToJSONResult.get("blockID"));
  }

  /**
   * Method under test:
   * {@link Util#printTransactionList(GrpcAPI.TransactionList, boolean)}
   */
  @Test
  public void testPrintTransactionList() {
    // Arrange, Act and Assert
    assertEquals("{\"transaction\":[]}", Util.printTransactionList(GrpcAPI.TransactionList.getDefaultInstance(), true));
  }

  /**
   * Method under test:
   * {@link Util#printTransactionIdList(GrpcAPI.TransactionIdList, boolean)}
   */
  @Test
  public void testPrintTransactionIdList() {
    // Arrange, Act and Assert
    assertEquals("{}", Util.printTransactionIdList(GrpcAPI.TransactionIdList.getDefaultInstance(), true));
  }

  /**
   * Method under test: {@link Util#printTransactionListToJSON(List, boolean)}
   */
  @Test
  public void testPrintTransactionListToJSON() {
    // Arrange, Act and Assert
    assertTrue(Util.printTransactionListToJSON(new ArrayList<>(), true).isEmpty());
  }

  /**
   * Method under test:
   * {@link Util#printTransactionExtention(GrpcAPI.TransactionExtention, boolean)}
   */
  @Test
  public void testPrintTransactionExtention() {
    // Arrange, Act and Assert
    assertEquals("{}", Util.printTransactionExtention(GrpcAPI.TransactionExtention.getDefaultInstance(), true));
  }

  /**
   * Method under test:
   * {@link Util#printEstimateEnergyMessage(GrpcAPI.EstimateEnergyMessage, boolean)}
   */
  @Test
  public void testPrintEstimateEnergyMessage() {
    // Arrange, Act and Assert
    assertEquals("{}", Util.printEstimateEnergyMessage(GrpcAPI.EstimateEnergyMessage.getDefaultInstance(), true));
  }

  /**
   * Method under test: {@link Util#getVisible(HttpServletRequest)}
   */
  @Test
  public void testGetVisible() {
    // Arrange, Act and Assert
    assertFalse(Util.getVisible(new MockHttpServletRequest()));
  }

  /**
   * Method under test: {@link Util#getVisible(HttpServletRequest)}
   */
  @Test
  public void testGetVisible2() {
    // Arrange
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    // Act and Assert
    assertFalse(Util.getVisible(new Request(channel, new HttpInput(mock(HttpChannelState.class)))));
  }

  /**
   * Method under test: {@link Util#existVisible(HttpServletRequest)}
   */
  @Test
  public void testExistVisible() {
    // Arrange, Act and Assert
    assertFalse(Util.existVisible(new MockHttpServletRequest()));
  }

  /**
   * Method under test: {@link Util#existVisible(HttpServletRequest)}
   */
  @Test
  public void testExistVisible2() {
    // Arrange
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    // Act and Assert
    assertFalse(Util.existVisible(new Request(channel, new HttpInput(mock(HttpChannelState.class)))));
  }

  /**
   * Method under test: {@link Util#getVisiblePost(String)}
   */
  @Test
  public void testGetVisiblePost() {
    // Arrange, Act and Assert
    assertFalse(Util.getVisiblePost(null));
    assertFalse(Util.getVisiblePost(""));
  }

  /**
   * Method under test: {@link Util#getHexAddress(String)}
   */
  @Test
  public void testGetHexAddress() {
    // Arrange, Act and Assert
    assertNull(Util.getHexAddress(null));
    assertEquals("", Util.getHexAddress("Address"));
    assertEquals("", Util.getHexAddress(""));
    assertEquals("", Util.getHexAddress("42"));
  }

  /**
   * Method under test: {@link Util#getHexString(String)}
   */
  @Test
  public void testGetHexString() {
    // Arrange, Act and Assert
    assertEquals("68747470733a2f2f6578616d706c652e6f72672f6578616d706c65",
        Util.getHexString("https://example.org/example"));
    assertEquals("", Util.getHexString(""));
  }

  /**
   * Method under test: {@link Util#getVisibleOnlyForSign(JSONObject)}
   */
  @Test
  public void testGetVisibleOnlyForSign() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put(Util.VISIBLE, 42);

    // Act and Assert
    assertFalse(Util.getVisibleOnlyForSign(jsonObject));
  }

  /**
   * Method under test: {@link Util#getVisibleOnlyForSign(JSONObject)}
   */
  @Test
  public void testGetVisibleOnlyForSign2() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put(Util.VISIBLE, 1);

    // Act and Assert
    assertTrue(Util.getVisibleOnlyForSign(jsonObject));
  }

  /**
   * Method under test: {@link Util#parseMethod(String, String)}
   */
  @Test
  public void testParseMethod() {
    // Arrange, Act and Assert
    assertEquals("7382265bhttps://example.org/example",
        Util.parseMethod("https://example.org/example", "https://example.org/example"));
    assertEquals("7382265b", Util.parseMethod("https://example.org/example", null));
    assertEquals("7382265b", Util.parseMethod("https://example.org/example", ""));
  }

  /**
   * Method under test: {@link Util#getJsonLongValue(JSONObject, String)}
   */
  @Test
  public void testGetJsonLongValue() {
    // Arrange, Act and Assert
    assertEquals(0L, Util.getJsonLongValue(new JSONObject(), "https://example.org/example"));
    assertThrows(InvalidParameterException.class,
        () -> Util.getJsonLongValue(new JSONObject(), "https://example.org/example", true));
    assertEquals(0L, Util.getJsonLongValue(new JSONObject(), "https://example.org/example", false));
  }

  /**
   * Method under test: {@link Util#getJsonLongValue(JSONObject, String)}
   */
  @Test
  public void testGetJsonLongValue2() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("Key", 42);

    // Act and Assert
    assertEquals(42L, Util.getJsonLongValue(jsonObject, "Key"));
  }

  /**
   * Method under test: {@link Util#getJsonLongValue(JSONObject, String)}
   */
  @Test
  public void testGetJsonLongValue3() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("Key", "");

    // Act and Assert
    assertEquals(0L, Util.getJsonLongValue(jsonObject, "Key"));
  }

  /**
   * Method under test: {@link Util#getJsonLongValue(JSONObject, String, boolean)}
   */
  @Test
  public void testGetJsonLongValue4() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("42", 42);

    // Act and Assert
    assertEquals(42L, Util.getJsonLongValue(jsonObject, "42", true));
  }

  /**
   * Method under test: {@link Util#getJsonLongValue(JSONObject, String, boolean)}
   */
  @Test
  public void testGetJsonLongValue5() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("42", "");

    // Act and Assert
    assertThrows(InvalidParameterException.class, () -> Util.getJsonLongValue(jsonObject, "42", true));
  }

  /**
   * Method under test: {@link Util#getMemo(byte[])}
   */
  @Test
  public void testGetMemo() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", Util.getMemo("AXAXAXAX".getBytes("UTF-8")));
    assertEquals("AXAXAXA", Util.getMemo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0}));
    assertEquals("", Util.getMemo(new byte[]{}));
  }

  /**
   * Method under test: {@link Util#processError(Exception, HttpServletResponse)}
   */
  @Test
  public void testProcessError() throws IOException {
    // Arrange
    Exception e = new Exception("foo");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    Util.processError(e, response2);

    // Assert
    assertEquals(44, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test: {@link Util#processError(Exception, HttpServletResponse)}
   */
  @Test
  public void testProcessError2() throws IOException {
    // Arrange
    Exception e = new Exception("foo");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    LocalConnector connector3 = new LocalConnector(new Server());
    HttpConfiguration configuration2 = new HttpConfiguration();
    ByteArrayEndPoint endPoint2 = new ByteArrayEndPoint();
    HttpConfiguration config2 = new HttpConfiguration();
    LocalConnector connector4 = new LocalConnector(new Server());
    HttpOutput out = new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
        new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true)));
    Response response = new Response(channel, out);

    // Act
    Util.processError(e, response);

    // Assert
    assertTrue(response.getWriter() instanceof ResponseWriter);
    assertEquals(44L, response.getContentCount());
    assertFalse(response.isStreaming());
    assertTrue(response.isWriting());
    assertSame(channel, response.getHttpChannel());
    assertSame(out, response.getHttpOutput());
  }

  /**
   * Method under test: {@link Util#processError(Exception, HttpServletResponse)}
   */
  @Test
  public void testProcessError3() throws IOException {
    // Arrange
    Exception e = new Exception("foo");
    Container.Listener listener = mock(Container.Listener.class);
    doNothing().when(listener).beanAdded(Mockito.<Container>any(), Mockito.<Object>any());

    Server server = new Server();
    server.addEventListener(listener);
    LocalConnector connector = new LocalConnector(server);
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    LocalConnector connector3 = new LocalConnector(new Server());
    HttpConfiguration configuration2 = new HttpConfiguration();
    ByteArrayEndPoint endPoint2 = new ByteArrayEndPoint();
    HttpConfiguration config2 = new HttpConfiguration();
    LocalConnector connector4 = new LocalConnector(new Server());
    HttpOutput out = new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
        new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true)));
    Response response = new Response(channel, out);

    // Act
    Util.processError(e, response);

    // Assert
    verify(listener).beanAdded(isA(Container.class), isA(Object.class));
    assertTrue(response.getWriter() instanceof ResponseWriter);
    assertEquals(44L, response.getContentCount());
    assertFalse(response.isStreaming());
    assertTrue(response.isWriting());
    assertSame(channel, response.getHttpChannel());
    assertSame(out, response.getHttpOutput());
  }

  /**
   * Method under test: {@link Util#convertOutput(Protocol.Account)}
   */
  @Test
  public void testConvertOutput() {
    // Arrange, Act and Assert
    assertEquals("{}", Util.convertOutput(Protocol.Account.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link Util#printAccount(Protocol.Account, HttpServletResponse, Boolean)}
   */
  @Test
  public void testPrintAccount() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    Util.printAccount(null, response2, true);

    // Assert
    assertEquals(3, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link Util#printAccount(Protocol.Account, HttpServletResponse, Boolean)}
   */
  @Test
  public void testPrintAccount2() throws IOException {
    // Arrange
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    LocalConnector connector3 = new LocalConnector(new Server());
    HttpConfiguration configuration2 = new HttpConfiguration();
    ByteArrayEndPoint endPoint2 = new ByteArrayEndPoint();
    HttpConfiguration config2 = new HttpConfiguration();
    LocalConnector connector4 = new LocalConnector(new Server());
    HttpOutput out = new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
        new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true)));
    Response response = new Response(channel, out);

    // Act
    Util.printAccount(null, response, true);

    // Assert
    assertTrue(response.getWriter() instanceof ResponseWriter);
    assertEquals(3L, response.getContentCount());
    assertFalse(response.isStreaming());
    assertTrue(response.isWriting());
    assertSame(channel, response.getHttpChannel());
    assertSame(out, response.getHttpOutput());
  }

  /**
   * Method under test:
   * {@link Util#printAccount(Protocol.Account, HttpServletResponse, Boolean)}
   */
  @Test
  public void testPrintAccount3() throws IOException {
    // Arrange
    Protocol.Account reply = Protocol.Account.getDefaultInstance();
    Container.Listener listener = mock(Container.Listener.class);
    doNothing().when(listener).beanAdded(Mockito.<Container>any(), Mockito.<Object>any());

    Server server = new Server();
    server.addEventListener(listener);
    LocalConnector connector = new LocalConnector(server);
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    LocalConnector connector3 = new LocalConnector(new Server());
    HttpConfiguration configuration2 = new HttpConfiguration();
    ByteArrayEndPoint endPoint2 = new ByteArrayEndPoint();
    HttpConfiguration config2 = new HttpConfiguration();
    LocalConnector connector4 = new LocalConnector(new Server());

    // Act
    Util.printAccount(reply, new Response(channel, new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
        new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true)))), true);

    // Assert
    verify(listener).beanAdded(isA(Container.class), isA(Object.class));
  }

  /**
   * Method under test:
   * {@link Util#printAccount(Protocol.Account, HttpServletResponse, Boolean)}
   */
  @Test
  public void testPrintAccount4() throws IOException {
    // Arrange
    Protocol.Account reply = Protocol.Account.getDefaultInstance();
    Container.Listener listener = mock(Container.Listener.class);
    doNothing().when(listener).beanAdded(Mockito.<Container>any(), Mockito.<Object>any());

    Server server = new Server();
    server.addEventListener(listener);
    LocalConnector connector = new LocalConnector(server);
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    LocalConnector connector3 = new LocalConnector(new Server());
    HttpConfiguration configuration2 = new HttpConfiguration();
    ByteArrayEndPoint endPoint2 = new ByteArrayEndPoint();
    HttpConfiguration config2 = new HttpConfiguration();
    LocalConnector connector4 = new LocalConnector(new Server());

    // Act
    Util.printAccount(reply,
        new Response(channel,
            new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
                new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true)))),
        false);

    // Assert
    verify(listener).beanAdded(isA(Container.class), isA(Object.class));
  }

  /**
   * Method under test: {@link Util#getAddress(HttpServletRequest)}
   */
  @Test
  public void testGetAddress() throws Exception {
    // Arrange, Act and Assert
    assertNull(Util.getAddress(new MockHttpServletRequest()));
    assertNull(Util.getAddress(new MockMultipartHttpServletRequest()));
  }

  /**
   * Method under test: {@link Util#getAddress(HttpServletRequest)}
   */
  @Test
  public void testGetAddress2() throws Exception {
    // Arrange
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    // Act and Assert
    assertNull(Util.getAddress(new Request(channel, new HttpInput(mock(HttpChannelState.class)))));
  }

  /**
   * Method under test: {@link Util#getRequestValue(HttpServletRequest)}
   */
  @Test
  public void testGetRequestValue() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", Util.getRequestValue(new MockHttpServletRequest()));
  }

  /**
   * Method under test:
   * {@link Util#convertLogAddressToTronAddress(Protocol.TransactionInfo)}
   */
  @Test
  public void testConvertLogAddressToTronAddress() {
    // Arrange and Act
    List<Protocol.TransactionInfo.Log> actualConvertLogAddressToTronAddressResult = Util
        .convertLogAddressToTronAddress(Protocol.TransactionInfo.getDefaultInstance());

    // Assert
    assertTrue(actualConvertLogAddressToTronAddressResult.isEmpty());
  }

  /**
   * Method under test: {@link Util#getJsonString(String)}
   */
  @Test
  public void testGetJsonString() {
    // Arrange, Act and Assert
    assertEquals("{\"https://example.org/example\":\"\"}", Util.getJsonString("https://example.org/example"));
    assertEquals("", Util.getJsonString(null));
    assertEquals("{\"Str\":\"\"}", Util.getJsonString("Str"));
    assertEquals("", Util.getJsonString(""));
    assertEquals("42", Util.getJsonString("42"));
    assertEquals("{\"function_selector\":\"\"}", Util.getJsonString(Util.FUNCTION_SELECTOR));
    assertEquals("{\"42https://example.org/example\":\"\"}", Util.getJsonString("42https://example.org/example"));
    assertEquals("{\"42Str\":\"\"}", Util.getJsonString("42Str"));
    assertEquals("{\"42Error\":\"\"}", Util.getJsonString("42Error"));
  }

  /**
   * Method under test: {@link Util#isValidJson(String)}
   */
  @Test
  public void testIsValidJson() {
    // Arrange, Act and Assert
    assertFalse(Util.isValidJson("https://example.org/example"));
    assertTrue(Util.isValidJson(null));
    assertTrue(Util.isValidJson(""));
    assertTrue(Util.isValidJson("42"));
    assertFalse(Util.isValidJson(Util.FUNCTION_SELECTOR));
    assertFalse(Util.isValidJson("42https://example.org/example"));
    assertFalse(Util.isValidJson("42Error"));
    assertFalse(Util.isValidJson("42function_selector"));
  }
}
