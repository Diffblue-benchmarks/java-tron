package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSet;
import com.google.protobuf.DescriptorProtos.FieldOptions;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.api.GrpcAPI;
import org.tron.api.GrpcAPI.BlockList;
import org.tron.api.GrpcAPI.EstimateEnergyMessage;
import org.tron.api.GrpcAPI.TransactionExtention;
import org.tron.api.GrpcAPI.TransactionIdList;
import org.tron.api.GrpcAPI.TransactionList;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Account;
import org.tron.protos.Protocol.Block;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Result;
import org.tron.protos.Protocol.Transaction.raw;
import org.tron.protos.Protocol.TransactionInfo;
import org.tron.protos.Protocol.TransactionInfo.Log;

public class UtilDiffblueTest {
  /**
   * Test {@link Util#printErrorMsg(Exception)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then return {@code {"Error":"class Exception : null"}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#printErrorMsg(Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.printErrorMsg(Exception)"})
  public void testPrintErrorMsg_whenException_thenReturnErrorClassJavaLangExceptionNull() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"Error\":\"class java.lang.Exception : null\"}", Util.printErrorMsg(new Exception()));
  }

  /**
   * Test {@link Util#printBlockList(BlockList, boolean)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return {@code {"block":[]}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#printBlockList(BlockList, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.printBlockList(BlockList, boolean)"})
  public void testPrintBlockList_whenDefaultInstance_thenReturnBlock() {
    // Arrange, Act and Assert
    assertEquals("{\"block\":[]}", Util.printBlockList(BlockList.getDefaultInstance(), true));
  }

  /**
   * Test {@link Util#printBlock(Block, boolean)}.
   *
   * <p>Method under test: {@link Util#printBlock(Protocol.Block, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.printBlock(Protocol.Block, boolean)"})
  public void testPrintBlock() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"blockID\":\"00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855\"}",
        Util.printBlock(Block.getDefaultInstance(), true));
  }

  /**
   * Test {@link Util#printBlock(Block, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Util#printBlock(Protocol.Block, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.printBlock(Protocol.Block, boolean)"})
  public void testPrintBlock_whenFalse() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"blockID\":\"00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855\"}",
        Util.printBlock(Block.getDefaultInstance(), false));
  }

  /**
   * Test {@link Util#printBlockToJSON(Block, boolean)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Util#printBlockToJSON(Protocol.Block, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject Util.printBlockToJSON(Protocol.Block, boolean)"})
  public void testPrintBlockToJSON_whenDefaultInstance_thenReturnSizeIsOne() {
    // Arrange and Act
    JSONObject actualPrintBlockToJSONResult =
        Util.printBlockToJSON(Block.getDefaultInstance(), true);

    // Assert
    assertEquals(1, actualPrintBlockToJSONResult.size());
    assertEquals(
        "00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualPrintBlockToJSONResult.get("blockID"));
  }

  /**
   * Test {@link Util#printTransactionList(TransactionList, boolean)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return {@code {"transaction":[]}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#printTransactionList(GrpcAPI.TransactionList, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.printTransactionList(GrpcAPI.TransactionList, boolean)"})
  public void testPrintTransactionList_whenDefaultInstance_thenReturnTransaction() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"transaction\":[]}",
        Util.printTransactionList(TransactionList.getDefaultInstance(), true));
  }

  /**
   * Test {@link Util#printTransactionIdList(TransactionIdList, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#printTransactionIdList(GrpcAPI.TransactionIdList, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.printTransactionIdList(GrpcAPI.TransactionIdList, boolean)"})
  public void testPrintTransactionIdList_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("{}", Util.printTransactionIdList(TransactionIdList.getDefaultInstance(), true));
  }

  /**
   * Test {@link Util#printTransactionListToJSON(List, boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Util#printTransactionListToJSON(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONArray Util.printTransactionListToJSON(List, boolean)"})
  public void testPrintTransactionListToJSON_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    JSONArray actualPrintTransactionListToJSONResult =
        Util.printTransactionListToJSON(new ArrayList<>(), true);

    // Assert
    assertTrue(actualPrintTransactionListToJSONResult.isEmpty());
  }

  /**
   * Test {@link Util#printTransactionExtention(TransactionExtention, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#printTransactionExtention(GrpcAPI.TransactionExtention,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Util.printTransactionExtention(GrpcAPI.TransactionExtention, boolean)"
  })
  public void testPrintTransactionExtention_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals(
        "{}", Util.printTransactionExtention(TransactionExtention.getDefaultInstance(), true));
  }

  /**
   * Test {@link Util#printEstimateEnergyMessage(EstimateEnergyMessage, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#printEstimateEnergyMessage(GrpcAPI.EstimateEnergyMessage,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Util.printEstimateEnergyMessage(GrpcAPI.EstimateEnergyMessage, boolean)"
  })
  public void testPrintEstimateEnergyMessage_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals(
        "{}", Util.printEstimateEnergyMessage(EstimateEnergyMessage.getDefaultInstance(), true));
  }

  /**
   * Test {@link Util#checkBodySize(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Util#checkBodySize(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Util.checkBodySize(String)"})
  public void testCheckBodySize_whenEmptyString_thenDoesNotThrow() throws Exception {
    // Arrange, Act and Assert
    Util.checkBodySize("");
  }

  /**
   * Test {@link Util#getVisible(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisible(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisible(HttpServletRequest)"})
  public void testGetVisible_givenEmptyString() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "");

    // Act and Assert
    assertFalse(Util.getVisible(request));
  }

  /**
   * Test {@link Util#getVisible(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisible(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisible(HttpServletRequest)"})
  public void testGetVisible_givenNotBlank() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");

    // Act and Assert
    assertFalse(Util.getVisible(request));
  }

  /**
   * Test {@link Util#getVisible(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisible(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisible(HttpServletRequest)"})
  public void testGetVisible_whenMockHttpServletRequest() {
    // Arrange, Act and Assert
    assertFalse(Util.getVisible(new MockHttpServletRequest()));
  }

  /**
   * Test {@link Util#existVisible(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link Util#VISIBLE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Util#existVisible(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.existVisible(HttpServletRequest)"})
  public void testExistVisible_givenVisible_thenReturnTrue() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "https://example.org/example");

    // Act and Assert
    assertTrue(Util.existVisible(request));
  }

  /**
   * Test {@link Util#existVisible(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Util#existVisible(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.existVisible(HttpServletRequest)"})
  public void testExistVisible_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Util.existVisible(new MockHttpServletRequest()));
  }

  /**
   * Test {@link Util#getVisiblePost(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisiblePost(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisiblePost(String)"})
  public void testGetVisiblePost_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Util.getVisiblePost(""));
  }

  /**
   * Test {@link Util#getVisiblePost(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisiblePost(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisiblePost(String)"})
  public void testGetVisiblePost_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Util.getVisiblePost(null));
  }

  /**
   * Test {@link Util#getHexAddress(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#getHexAddress(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getHexAddress(String)"})
  public void testGetHexAddress_when42_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", Util.getHexAddress("42"));
  }

  /**
   * Test {@link Util#getHexAddress(String)}.
   *
   * <ul>
   *   <li>When {@code Address}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#getHexAddress(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getHexAddress(String)"})
  public void testGetHexAddress_whenAddress_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", Util.getHexAddress("Address"));
  }

  /**
   * Test {@link Util#getHexAddress(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#getHexAddress(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getHexAddress(String)"})
  public void testGetHexAddress_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", Util.getHexAddress(""));
  }

  /**
   * Test {@link Util#getHexAddress(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getHexAddress(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getHexAddress(String)"})
  public void testGetHexAddress_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Util.getHexAddress(null));
  }

  /**
   * Test {@link Util#getHexString(String)}.
   *
   * <p>Method under test: {@link Util#getHexString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getHexString(String)"})
  public void testGetHexString() {
    // Arrange, Act and Assert
    assertEquals(
        "68747470733a2f2f6578616d706c652e6f72672f6578616d706c65",
        Util.getHexString("https://example.org/example"));
  }

  /**
   * Test {@link Util#getHexString(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#getHexString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getHexString(String)"})
  public void testGetHexString_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", Util.getHexString(""));
  }

  /**
   * Test {@link Util#setTransactionPermissionId(JSONObject, Transaction)} with {@code jsonObject},
   * {@code transaction}.
   *
   * <p>Method under test: {@link Util#setTransactionPermissionId(JSONObject, Protocol.Transaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Protocol.Transaction Util.setTransactionPermissionId(JSONObject, Protocol.Transaction)"
  })
  public void testSetTransactionPermissionIdWithJsonObjectTransaction() {
    // Arrange
    JSONObject jsonObject = new JSONObject();

    // Act
    Transaction actualSetTransactionPermissionIdResult =
        Util.setTransactionPermissionId(jsonObject, Transaction.getDefaultInstance());

    // Assert
    Descriptor descriptorForType = actualSetTransactionPermissionIdResult.getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(
        jsonObject, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(jsonObject, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(jsonObject, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(jsonObject, defaultInstanceForType.getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(jsonObject, features.getAllFields());
    FieldOptions options = fields.get(0).getOptions();
    assertEquals(jsonObject, options.getAllFields());
    assertEquals(jsonObject, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(jsonObject, features.getAllFieldsRaw());
    assertEquals(jsonObject, options.getAllFieldsRaw());
  }

  /**
   * Test {@link Util#setTransactionPermissionId(JSONObject, Transaction)} with {@code jsonObject},
   * {@code transaction}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link Util#setTransactionPermissionId(JSONObject, Protocol.Transaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Protocol.Transaction Util.setTransactionPermissionId(JSONObject, Protocol.Transaction)"
  })
  public void testSetTransactionPermissionIdWithJsonObjectTransaction_givenZero() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put(Util.PERMISSION_ID, 0);

    // Act
    Transaction actualSetTransactionPermissionIdResult =
        Util.setTransactionPermissionId(jsonObject, Transaction.getDefaultInstance());

    // Assert
    assertEquals(
        3, actualSetTransactionPermissionIdResult.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link Util#setTransactionPermissionId(int, Transaction)} with {@code permissionId},
   * {@code transaction}.
   *
   * <p>Method under test: {@link Util#setTransactionPermissionId(int, Protocol.Transaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Protocol.Transaction Util.setTransactionPermissionId(int, Protocol.Transaction)"
  })
  public void testSetTransactionPermissionIdWithPermissionIdTransaction() {
    // Arrange and Act
    Transaction actualSetTransactionPermissionIdResult =
        Util.setTransactionPermissionId(0, Transaction.getDefaultInstance());

    // Assert
    assertEquals("", actualSetTransactionPermissionIdResult.getInitializationErrorString());
    assertEquals(0, actualSetTransactionPermissionIdResult.getRetCount());
    assertEquals(0, actualSetTransactionPermissionIdResult.getSerializedSize());
    assertEquals(0, actualSetTransactionPermissionIdResult.getSignatureCount());
    assertFalse(actualSetTransactionPermissionIdResult.hasRawData());
    assertTrue(actualSetTransactionPermissionIdResult.findInitializationErrors().isEmpty());
    List<Result> retList = actualSetTransactionPermissionIdResult.getRetList();
    assertTrue(retList.isEmpty());
    assertTrue(actualSetTransactionPermissionIdResult.getSignatureList().isEmpty());
    assertTrue(actualSetTransactionPermissionIdResult.getAllFields().isEmpty());
    assertSame(retList, actualSetTransactionPermissionIdResult.getRetOrBuilderList());
    Transaction actualDefaultInstanceForType =
        actualSetTransactionPermissionIdResult.getDefaultInstanceForType();
    assertSame(actualSetTransactionPermissionIdResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link Util#setTransactionExtraData(String, Transaction, boolean)} with {@code data},
   * {@code transaction}, {@code visible}.
   *
   * <p>Method under test: {@link Util#setTransactionExtraData(String, Protocol.Transaction,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Protocol.Transaction Util.setTransactionExtraData(String, Protocol.Transaction, boolean)"
  })
  public void testSetTransactionExtraDataWithDataTransactionVisible() {
    // Arrange and Act
    Transaction actualSetTransactionExtraDataResult =
        Util.setTransactionExtraData(
            "https://example.org/example", Transaction.getDefaultInstance(), true);

    // Assert
    assertEquals(31, actualSetTransactionExtraDataResult.getSerializedSize());
  }

  /**
   * Test {@link Util#setTransactionExtraData(String, Transaction, boolean)} with {@code data},
   * {@code transaction}, {@code visible}.
   *
   * <p>Method under test: {@link Util#setTransactionExtraData(String, Protocol.Transaction,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Protocol.Transaction Util.setTransactionExtraData(String, Protocol.Transaction, boolean)"
  })
  public void testSetTransactionExtraDataWithDataTransactionVisible2() {
    // Arrange and Act
    Transaction actualSetTransactionExtraDataResult =
        Util.setTransactionExtraData("", Transaction.getDefaultInstance(), true);

    // Assert
    assertEquals(0, actualSetTransactionExtraDataResult.getSerializedSize());
    assertFalse(actualSetTransactionExtraDataResult.hasRawData());
    assertTrue(actualSetTransactionExtraDataResult.getAllFields().isEmpty());
    Transaction actualDefaultInstanceForType =
        actualSetTransactionExtraDataResult.getDefaultInstanceForType();
    assertSame(actualSetTransactionExtraDataResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link Util#setTransactionExtraData(String, Transaction, boolean)} with {@code data},
   * {@code transaction}, {@code visible}.
   *
   * <p>Method under test: {@link Util#setTransactionExtraData(String, Protocol.Transaction,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Protocol.Transaction Util.setTransactionExtraData(String, Protocol.Transaction, boolean)"
  })
  public void testSetTransactionExtraDataWithDataTransactionVisible3() {
    // Arrange and Act
    Transaction actualSetTransactionExtraDataResult =
        Util.setTransactionExtraData("0x", Transaction.getDefaultInstance(), false);

    // Assert
    assertEquals(2, actualSetTransactionExtraDataResult.getSerializedSize());
  }

  /**
   * Test {@link Util#setTransactionExtraData(String, Transaction, boolean)} with {@code data},
   * {@code transaction}, {@code visible}.
   *
   * <p>Method under test: {@link Util#setTransactionExtraData(String, Protocol.Transaction,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Protocol.Transaction Util.setTransactionExtraData(String, Protocol.Transaction, boolean)"
  })
  public void testSetTransactionExtraDataWithDataTransactionVisible4() {
    // Arrange and Act
    Transaction actualSetTransactionExtraDataResult =
        Util.setTransactionExtraData("0", Transaction.getDefaultInstance(), false);

    // Assert
    assertEquals(5, actualSetTransactionExtraDataResult.getSerializedSize());
  }

  /**
   * Test {@link Util#setTransactionExtraData(JSONObject, Transaction, boolean)} with {@code
   * jsonObject}, {@code transaction}, {@code visible}.
   *
   * <p>Method under test: {@link Util#setTransactionExtraData(JSONObject, Protocol.Transaction,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Protocol.Transaction Util.setTransactionExtraData(JSONObject, Protocol.Transaction, boolean)"
  })
  public void testSetTransactionExtraDataWithJsonObjectTransactionVisible() {
    // Arrange
    JSONObject jsonObject = new JSONObject();

    // Act
    Transaction actualSetTransactionExtraDataResult =
        Util.setTransactionExtraData(jsonObject, Transaction.getDefaultInstance(), true);

    // Assert
    Descriptor descriptorForType = actualSetTransactionExtraDataResult.getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(
        jsonObject, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(jsonObject, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(jsonObject, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(jsonObject, defaultInstanceForType.getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(jsonObject, features.getAllFields());
    FieldOptions options = fields.get(0).getOptions();
    assertEquals(jsonObject, options.getAllFields());
    assertEquals(jsonObject, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(jsonObject, features.getAllFieldsRaw());
    assertEquals(jsonObject, options.getAllFieldsRaw());
  }

  /**
   * Test {@link Util#setTransactionExtraData(JSONObject, Transaction, boolean)} with {@code
   * jsonObject}, {@code transaction}, {@code visible}.
   *
   * <p>Method under test: {@link Util#setTransactionExtraData(JSONObject, Protocol.Transaction,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Protocol.Transaction Util.setTransactionExtraData(JSONObject, Protocol.Transaction, boolean)"
  })
  public void testSetTransactionExtraDataWithJsonObjectTransactionVisible2() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put(Util.EXTRA_DATA, "Value");

    // Act
    Transaction actualSetTransactionExtraDataResult =
        Util.setTransactionExtraData(jsonObject, Transaction.getDefaultInstance(), true);

    // Assert
    Descriptor descriptorForType = actualSetTransactionExtraDataResult.getDescriptorForType();
    assertEquals(3, descriptorForType.getNestedTypes().size());
    assertEquals(7, actualSetTransactionExtraDataResult.getRawData().getSerializedSize());
    assertEquals(9, actualSetTransactionExtraDataResult.getSerializedSize());
    Transaction defaultInstanceForType =
        actualSetTransactionExtraDataResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link Util#setTransactionExtraData(JSONObject, Transaction, boolean)} with {@code
   * jsonObject}, {@code transaction}, {@code visible}.
   *
   * <p>Method under test: {@link Util#setTransactionExtraData(JSONObject, Protocol.Transaction,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Protocol.Transaction Util.setTransactionExtraData(JSONObject, Protocol.Transaction, boolean)"
  })
  public void testSetTransactionExtraDataWithJsonObjectTransactionVisible3() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put(Util.EXTRA_DATA, "0x");

    // Act
    Transaction actualSetTransactionExtraDataResult =
        Util.setTransactionExtraData(jsonObject, Transaction.getDefaultInstance(), false);

    // Assert
    assertEquals(2, actualSetTransactionExtraDataResult.getSerializedSize());
    raw expectedRawData = actualSetTransactionExtraDataResult.getRawData();
    assertEquals(
        expectedRawData,
        actualSetTransactionExtraDataResult.getDefaultInstanceForType().getRawData());
  }

  /**
   * Test {@link Util#setTransactionExtraData(JSONObject, Transaction, boolean)} with {@code
   * jsonObject}, {@code transaction}, {@code visible}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#setTransactionExtraData(JSONObject, Protocol.Transaction,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Protocol.Transaction Util.setTransactionExtraData(JSONObject, Protocol.Transaction, boolean)"
  })
  public void testSetTransactionExtraDataWithJsonObjectTransactionVisible_givenEmptyString() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put(Util.EXTRA_DATA, "");

    // Act
    Transaction actualSetTransactionExtraDataResult =
        Util.setTransactionExtraData(jsonObject, Transaction.getDefaultInstance(), true);

    // Assert
    assertEquals(3, actualSetTransactionExtraDataResult.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link Util#getVisibleOnlyForSign(JSONObject)}.
   *
   * <ul>
   *   <li>Given {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisibleOnlyForSign(JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisibleOnlyForSign(JSONObject)"})
  public void testGetVisibleOnlyForSign_given0() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put(Util.VISIBLE, "Json Object");

    JSONObject jsonObject = new JSONObject(1);
    jsonObject.put(Util.TRANSACTION, objectObjectMap);
    jsonObject.put(Util.VISIBLE, "0");

    // Act and Assert
    assertFalse(Util.getVisibleOnlyForSign(jsonObject));
  }

  /**
   * Test {@link Util#getVisibleOnlyForSign(JSONObject)}.
   *
   * <ul>
   *   <li>Given {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisibleOnlyForSign(JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisibleOnlyForSign(JSONObject)"})
  public void testGetVisibleOnlyForSign_given1() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put(Util.VISIBLE, "Json Object");

    JSONObject jsonObject = new JSONObject(1);
    jsonObject.put(Util.TRANSACTION, objectObjectMap);
    jsonObject.put(Util.VISIBLE, "1");

    // Act and Assert
    assertTrue(Util.getVisibleOnlyForSign(jsonObject));
  }

  /**
   * Test {@link Util#getVisibleOnlyForSign(JSONObject)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>When {@link JSONObject#JSONObject()} {@link Util#VISIBLE} is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisibleOnlyForSign(JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisibleOnlyForSign(JSONObject)"})
  public void testGetVisibleOnlyForSign_givenFortyTwo_whenJSONObjectVisibleIsFortyTwo() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put(Util.VISIBLE, 42);

    // Act and Assert
    assertFalse(Util.getVisibleOnlyForSign(jsonObject));
  }

  /**
   * Test {@link Util#getVisibleOnlyForSign(JSONObject)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} one is {@code Json Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisibleOnlyForSign(JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisibleOnlyForSign(JSONObject)"})
  public void testGetVisibleOnlyForSign_givenHashMapOneIsJsonObject_thenReturnFalse() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put(1, "Json Object");

    JSONObject jsonObject = new JSONObject(1);
    jsonObject.put(Util.TRANSACTION, objectObjectMap);
    jsonObject.put("Key", 1);

    // Act and Assert
    assertFalse(Util.getVisibleOnlyForSign(jsonObject));
  }

  /**
   * Test {@link Util#getVisibleOnlyForSign(JSONObject)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link Util#VISIBLE} is one.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisibleOnlyForSign(JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisibleOnlyForSign(JSONObject)"})
  public void testGetVisibleOnlyForSign_givenHashMapVisibleIsOne() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put(Util.VISIBLE, 1);

    JSONObject jsonObject = new JSONObject(1);
    jsonObject.put(Util.TRANSACTION, objectObjectMap);
    jsonObject.put("Key", 1);

    // Act and Assert
    assertTrue(Util.getVisibleOnlyForSign(jsonObject));
  }

  /**
   * Test {@link Util#getVisibleOnlyForSign(JSONObject)}.
   *
   * <ul>
   *   <li>Given {@code N}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisibleOnlyForSign(JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisibleOnlyForSign(JSONObject)"})
  public void testGetVisibleOnlyForSign_givenN() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put(Util.VISIBLE, "Json Object");

    JSONObject jsonObject = new JSONObject(1);
    jsonObject.put(Util.TRANSACTION, objectObjectMap);
    jsonObject.put(Util.VISIBLE, "N");

    // Act and Assert
    assertFalse(Util.getVisibleOnlyForSign(jsonObject));
  }

  /**
   * Test {@link Util#getVisibleOnlyForSign(JSONObject)}.
   *
   * <ul>
   *   <li>Given {@code T}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisibleOnlyForSign(JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisibleOnlyForSign(JSONObject)"})
  public void testGetVisibleOnlyForSign_givenT() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put(Util.VISIBLE, "Json Object");

    JSONObject jsonObject = new JSONObject(1);
    jsonObject.put(Util.TRANSACTION, objectObjectMap);
    jsonObject.put(Util.VISIBLE, "T");

    // Act and Assert
    assertTrue(Util.getVisibleOnlyForSign(jsonObject));
  }

  /**
   * Test {@link Util#getVisibleOnlyForSign(JSONObject)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisibleOnlyForSign(JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisibleOnlyForSign(JSONObject)"})
  public void testGetVisibleOnlyForSign_givenTrue() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put(Util.VISIBLE, "Json Object");

    JSONObject jsonObject = new JSONObject(1);
    jsonObject.put(Util.TRANSACTION, objectObjectMap);
    jsonObject.put(Util.VISIBLE, true);

    // Act and Assert
    assertTrue(Util.getVisibleOnlyForSign(jsonObject));
  }

  /**
   * Test {@link Util#getVisibleOnlyForSign(JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject(int)} with initialCapacity is one {@link Util#VISIBLE}
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link Util#getVisibleOnlyForSign(JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.getVisibleOnlyForSign(JSONObject)"})
  public void testGetVisibleOnlyForSign_whenJSONObjectWithInitialCapacityIsOneVisibleIsOne() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put(Util.VISIBLE, "Json Object");

    JSONObject jsonObject = new JSONObject(1);
    jsonObject.put(Util.TRANSACTION, objectObjectMap);
    jsonObject.put(Util.VISIBLE, 1);

    // Act and Assert
    assertTrue(Util.getVisibleOnlyForSign(jsonObject));
  }

  /**
   * Test {@link Util#parseMethod(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code 7382265bhttps://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link Util#parseMethod(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.parseMethod(String, String)"})
  public void testParseMethod_thenReturn7382265bhttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "7382265bhttps://example.org/example",
        Util.parseMethod("https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link Util#parseMethod(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code 7382265b}.
   * </ul>
   *
   * <p>Method under test: {@link Util#parseMethod(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.parseMethod(String, String)"})
  public void testParseMethod_whenEmptyString_thenReturn7382265b() {
    // Arrange, Act and Assert
    assertEquals("7382265b", Util.parseMethod("https://example.org/example", ""));
  }

  /**
   * Test {@link Util#parseMethod(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code 7382265b}.
   * </ul>
   *
   * <p>Method under test: {@link Util#parseMethod(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.parseMethod(String, String)"})
  public void testParseMethod_whenNull_thenReturn7382265b() {
    // Arrange, Act and Assert
    assertEquals("7382265b", Util.parseMethod("https://example.org/example", null));
  }

  /**
   * Test {@link Util#getJsonLongValue(JSONObject, String, boolean)} with {@code jsonObject}, {@code
   * key}, {@code required}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonLongValue(JSONObject, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Util.getJsonLongValue(JSONObject, String, boolean)"})
  public void testGetJsonLongValueWithJsonObjectKeyRequired_givenEmptyString() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("42", "");

    // Act and Assert
    assertThrows(
        InvalidParameterException.class, () -> Util.getJsonLongValue(jsonObject, "42", true));
  }

  /**
   * Test {@link Util#getJsonLongValue(JSONObject, String, boolean)} with {@code jsonObject}, {@code
   * key}, {@code required}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonLongValue(JSONObject, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Util.getJsonLongValue(JSONObject, String, boolean)"})
  public void testGetJsonLongValueWithJsonObjectKeyRequired_givenFortyTwo_thenReturnFortyTwo() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("42", 42);

    // Act
    long actualJsonLongValue = Util.getJsonLongValue(jsonObject, "42", true);

    // Assert
    assertEquals(42L, actualJsonLongValue);
  }

  /**
   * Test {@link Util#getJsonLongValue(JSONObject, String, boolean)} with {@code jsonObject}, {@code
   * key}, {@code required}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonLongValue(JSONObject, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Util.getJsonLongValue(JSONObject, String, boolean)"})
  public void testGetJsonLongValueWithJsonObjectKeyRequired_thenThrowInvalidParameterException() {
    // Arrange, Act and Assert
    assertThrows(
        InvalidParameterException.class,
        () -> Util.getJsonLongValue(new JSONObject(), "https://example.org/example", true));
  }

  /**
   * Test {@link Util#getJsonLongValue(JSONObject, String, boolean)} with {@code jsonObject}, {@code
   * key}, {@code required}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonLongValue(JSONObject, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Util.getJsonLongValue(JSONObject, String, boolean)"})
  public void testGetJsonLongValueWithJsonObjectKeyRequired_whenFalse_thenReturnZero() {
    // Arrange and Act
    long actualJsonLongValue =
        Util.getJsonLongValue(new JSONObject(), "https://example.org/example", false);

    // Assert
    assertEquals(0L, actualJsonLongValue);
  }

  /**
   * Test {@link Util#getJsonLongValue(JSONObject, String)} with {@code jsonObject}, {@code key}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonLongValue(JSONObject, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Util.getJsonLongValue(JSONObject, String)"})
  public void testGetJsonLongValueWithJsonObjectKey_givenEmptyString() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("42", "");

    // Act and Assert
    assertEquals(0L, Util.getJsonLongValue(jsonObject, "42"));
  }

  /**
   * Test {@link Util#getJsonLongValue(JSONObject, String)} with {@code jsonObject}, {@code key}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonLongValue(JSONObject, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Util.getJsonLongValue(JSONObject, String)"})
  public void testGetJsonLongValueWithJsonObjectKey_givenFortyTwo_thenReturnFortyTwo() {
    // Arrange
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("42", 42);

    // Act and Assert
    assertEquals(42L, Util.getJsonLongValue(jsonObject, "42"));
  }

  /**
   * Test {@link Util#getJsonLongValue(JSONObject, String)} with {@code jsonObject}, {@code key}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonLongValue(JSONObject, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Util.getJsonLongValue(JSONObject, String)"})
  public void testGetJsonLongValueWithJsonObjectKey_whenJSONObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, Util.getJsonLongValue(new JSONObject(), "https://example.org/example"));
  }

  /**
   * Test {@link Util#getMemo(byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code AXAXAXA}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getMemo(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getMemo(byte[])"})
  public void testGetMemo_whenA_thenReturnAxaxaxa() {
    // Arrange, Act and Assert
    assertEquals("AXAXAXA", Util.getMemo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link Util#getMemo(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getMemo(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getMemo(byte[])"})
  public void testGetMemo_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxax()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", Util.getMemo("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Util#getMemo(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#getMemo(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getMemo(byte[])"})
  public void testGetMemo_whenEmptyArrayOfByte_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", Util.getMemo(new byte[] {}));
  }

  /**
   * Test {@link Util#processError(Exception, HttpServletResponse)}.
   *
   * <p>Method under test: {@link Util#processError(Exception, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Util.processError(Exception, HttpServletResponse)"})
  public void testProcessError() throws UnsupportedEncodingException {
    // Arrange
    Exception e = new Exception();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    Util.processError(e, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.Exception : null\"}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.Exception : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link Util#convertOutput(Account)}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#convertOutput(Account)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.convertOutput(Account)"})
  public void testConvertOutput_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("{}", Util.convertOutput(Account.getDefaultInstance()));
  }

  /**
   * Test {@link Util#printAccount(Account, HttpServletResponse, Boolean)}.
   *
   * <p>Method under test: {@link Util#printAccount(Account, HttpServletResponse, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Util.printAccount(Account, HttpServletResponse, Boolean)"})
  public void testPrintAccount() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    Util.printAccount(null, response, true);

    // Assert
    assertEquals("{}\n", response.getContentAsString());
    assertArrayEquals("{}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link Util#getAddress(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code address}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code address}
   *       and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getAddress(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Util.getAddress(HttpServletRequest)"})
  public void testGetAddress_givenAddress_whenMockHttpServletRequestAddParameterAddressAnd42()
      throws Exception {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("address", "42");

    // Act and Assert
    assertNull(Util.getAddress(request));
  }

  /**
   * Test {@link Util#getAddress(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getAddress(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Util.getAddress(HttpServletRequest)"})
  public void testGetAddress_whenMockHttpServletRequest() throws Exception {
    // Arrange, Act and Assert
    assertNull(Util.getAddress(new MockHttpServletRequest()));
  }

  /**
   * Test {@link Util#getRequestValue(HttpServletRequest)}.
   *
   * <p>Method under test: {@link Util#getRequestValue(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getRequestValue(HttpServletRequest)"})
  public void testGetRequestValue() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", Util.getRequestValue(new MockHttpServletRequest()));
  }

  /**
   * Test {@link Util#convertLogAddressToTronAddress(TransactionInfo)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Util#convertLogAddressToTronAddress(TransactionInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List Util.convertLogAddressToTronAddress(TransactionInfo)"})
  public void testConvertLogAddressToTronAddress_whenDefaultInstance_thenReturnEmpty() {
    // Arrange and Act
    List<Log> actualConvertLogAddressToTronAddressResult =
        Util.convertLogAddressToTronAddress(TransactionInfo.getDefaultInstance());

    // Assert
    assertTrue(actualConvertLogAddressToTronAddressResult.isEmpty());
  }

  /**
   * Test {@link Util#getJsonString(String)}.
   *
   * <ul>
   *   <li>Then return {@code {"42https://example.org/example":""}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getJsonString(String)"})
  public void testGetJsonString_thenReturn42httpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"42https://example.org/example\":\"\"}",
        Util.getJsonString("42https://example.org/example"));
  }

  /**
   * Test {@link Util#getJsonString(String)}.
   *
   * <ul>
   *   <li>When {@code 42Error}.
   *   <li>Then return {@code {"42Error":""}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getJsonString(String)"})
  public void testGetJsonString_when42Error_thenReturn42Error() {
    // Arrange, Act and Assert
    assertEquals("{\"42Error\":\"\"}", Util.getJsonString("42Error"));
  }

  /**
   * Test {@link Util#getJsonString(String)}.
   *
   * <ul>
   *   <li>When {@code 42Str}.
   *   <li>Then return {@code {"42Str":""}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getJsonString(String)"})
  public void testGetJsonString_when42Str_thenReturn42Str() {
    // Arrange, Act and Assert
    assertEquals("{\"42Str\":\"\"}", Util.getJsonString("42Str"));
  }

  /**
   * Test {@link Util#getJsonString(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getJsonString(String)"})
  public void testGetJsonString_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", Util.getJsonString("42"));
  }

  /**
   * Test {@link Util#getJsonString(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getJsonString(String)"})
  public void testGetJsonString_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", Util.getJsonString(""));
  }

  /**
   * Test {@link Util#getJsonString(String)}.
   *
   * <ul>
   *   <li>When {@link Util#FUNCTION_SELECTOR}.
   *   <li>Then return {@code {"function_selector":""}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getJsonString(String)"})
  public void testGetJsonString_whenFunction_selector_thenReturnFunctionSelector() {
    // Arrange, Act and Assert
    assertEquals("{\"function_selector\":\"\"}", Util.getJsonString(Util.FUNCTION_SELECTOR));
  }

  /**
   * Test {@link Util#getJsonString(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code {"https://example.org/example":""}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getJsonString(String)"})
  public void testGetJsonString_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"https://example.org/example\":\"\"}",
        Util.getJsonString("https://example.org/example"));
  }

  /**
   * Test {@link Util#getJsonString(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getJsonString(String)"})
  public void testGetJsonString_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", Util.getJsonString(null));
  }

  /**
   * Test {@link Util#getJsonString(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code {"Str":""}}.
   * </ul>
   *
   * <p>Method under test: {@link Util#getJsonString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Util.getJsonString(String)"})
  public void testGetJsonString_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("{\"Str\":\"\"}", Util.getJsonString("Str"));
  }

  /**
   * Test {@link Util#isValidJson(String)}.
   *
   * <ul>
   *   <li>When {@code 42Error}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Util#isValidJson(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.isValidJson(String)"})
  public void testIsValidJson_when42Error_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Util.isValidJson("42Error"));
  }

  /**
   * Test {@link Util#isValidJson(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Util#isValidJson(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.isValidJson(String)"})
  public void testIsValidJson_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Util.isValidJson("42"));
  }

  /**
   * Test {@link Util#isValidJson(String)}.
   *
   * <ul>
   *   <li>When {@code 42function_selector}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Util#isValidJson(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.isValidJson(String)"})
  public void testIsValidJson_when42functionSelector_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Util.isValidJson("42function_selector"));
  }

  /**
   * Test {@link Util#isValidJson(String)}.
   *
   * <ul>
   *   <li>When {@code 42https://example.org/example}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Util#isValidJson(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.isValidJson(String)"})
  public void testIsValidJson_when42httpsExampleOrgExample_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Util.isValidJson("42https://example.org/example"));
  }

  /**
   * Test {@link Util#isValidJson(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Util#isValidJson(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.isValidJson(String)"})
  public void testIsValidJson_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Util.isValidJson(""));
  }

  /**
   * Test {@link Util#isValidJson(String)}.
   *
   * <ul>
   *   <li>When {@link Util#FUNCTION_SELECTOR}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Util#isValidJson(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.isValidJson(String)"})
  public void testIsValidJson_whenFunction_selector_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Util.isValidJson(Util.FUNCTION_SELECTOR));
  }

  /**
   * Test {@link Util#isValidJson(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Util#isValidJson(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.isValidJson(String)"})
  public void testIsValidJson_whenHttpsExampleOrgExample_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Util.isValidJson("https://example.org/example"));
  }

  /**
   * Test {@link Util#isValidJson(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Util#isValidJson(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Util.isValidJson(String)"})
  public void testIsValidJson_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Util.isValidJson(null));
  }
}
