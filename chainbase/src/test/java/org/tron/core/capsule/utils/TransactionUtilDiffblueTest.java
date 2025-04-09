package org.tron.core.capsule.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSet;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.UnknownFieldSet;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.InternalTransaction;
import org.tron.protos.Protocol.InternalTransaction.CallValueInfo;

public class TransactionUtilDiffblueTest {
  /**
   * Test {@link TransactionUtil#newGenesisTransaction(byte[], long)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#newGenesisTransaction(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.Transaction TransactionUtil.newGenesisTransaction(byte[], long)"})
  public void testNewGenesisTransaction_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransactionUtil.newGenesisTransaction("AXAXAXAX".getBytes("UTF-8"), 42L));
  }

  /**
   * Test {@link TransactionUtil#newGenesisTransaction(byte[], long)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#newGenesisTransaction(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.Transaction TransactionUtil.newGenesisTransaction(byte[], long)"})
  public void testNewGenesisTransaction_whenEmptyArrayOfByte() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransactionUtil.newGenesisTransaction(new byte[]{}, 42L));
  }

  /**
   * Test {@link TransactionUtil#newGenesisTransaction(byte[], long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#newGenesisTransaction(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.Transaction TransactionUtil.newGenesisTransaction(byte[], long)"})
  public void testNewGenesisTransaction_whenNull() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransactionUtil.newGenesisTransaction(null, 42L));
  }

  /**
   * Test {@link TransactionUtil#buildInternalTransaction(InternalTransaction)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return CallValueInfoList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#buildInternalTransaction(org.tron.common.runtime.InternalTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "InternalTransaction TransactionUtil.buildInternalTransaction(org.tron.common.runtime.InternalTransaction)"})
  public void testBuildInternalTransaction_givenFoo_thenReturnCallValueInfoListSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> tokenInfo = new HashMap<>();
    tokenInfo.put("foo", 1L);
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    InternalTransaction actualBuildInternalTransactionResult = TransactionUtil
        .buildInternalTransaction(new org.tron.common.runtime.InternalTransaction(parentHash, 1, 1, sendAddress,
            transferToAddress, 42L, "AXAXAXAX".getBytes("UTF-8"), "Note", 1L, tokenInfo));

    // Assert
    List<CallValueInfo> callValueInfoList = actualBuildInternalTransactionResult.getCallValueInfoList();
    assertEquals(2, callValueInfoList.size());
    CallValueInfo getResult = callValueInfoList.get(1);
    ByteString tokenIdBytes = getResult.getTokenIdBytes();
    assertEquals("foo", tokenIdBytes.toStringUtf8());
    assertEquals("foo", getResult.getTokenId());
    assertEquals(1L, getResult.getCallValue());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(2, actualBuildInternalTransactionResult.getCallValueInfoCount());
    assertEquals(7, getResult.getSerializedSize());
    assertEquals(73, actualBuildInternalTransactionResult.getSerializedSize());
    assertFalse(tokenIdBytes.isEmpty());
    ByteIterator iteratorResult = tokenIdBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('f', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link TransactionUtil#buildInternalTransaction(InternalTransaction)}.
   * <ul>
   *   <li>Then return CallValueInfoCount is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#buildInternalTransaction(org.tron.common.runtime.InternalTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "InternalTransaction TransactionUtil.buildInternalTransaction(org.tron.common.runtime.InternalTransaction)"})
  public void testBuildInternalTransaction_thenReturnCallValueInfoCountIsOne() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    HashMap<String, Long> tokenInfo = new HashMap<>();

    // Act
    InternalTransaction actualBuildInternalTransactionResult = TransactionUtil
        .buildInternalTransaction(new org.tron.common.runtime.InternalTransaction(parentHash, 1, 1, sendAddress,
            transferToAddress, 42L, data, "Note", 1L, tokenInfo));

    // Assert
    assertEquals(1, actualBuildInternalTransactionResult.getCallValueInfoCount());
    Descriptor descriptorForType = actualBuildInternalTransactionResult.getDescriptorForType();
    assertEquals(tokenInfo, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(tokenInfo, features.getAllFields());
    assertEquals(tokenInfo, features.getAllFieldsRaw());
    assertEquals(Double.SIZE, actualBuildInternalTransactionResult.getSerializedSize());
  }

  /**
   * Test {@link TransactionUtil#buildInternalTransaction(InternalTransaction)}.
   * <ul>
   *   <li>Then return CallValueInfoList size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#buildInternalTransaction(org.tron.common.runtime.InternalTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "InternalTransaction TransactionUtil.buildInternalTransaction(org.tron.common.runtime.InternalTransaction)"})
  public void testBuildInternalTransaction_thenReturnCallValueInfoListSizeIsThree()
      throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> tokenInfo = new HashMap<>();
    tokenInfo.put("", 2L);
    tokenInfo.put("foo", 1L);
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    InternalTransaction actualBuildInternalTransactionResult = TransactionUtil
        .buildInternalTransaction(new org.tron.common.runtime.InternalTransaction(parentHash, 1, 1, sendAddress,
            transferToAddress, 42L, "AXAXAXAX".getBytes("UTF-8"), "Note", 1L, tokenInfo));

    // Assert
    List<CallValueInfo> callValueInfoList = actualBuildInternalTransactionResult.getCallValueInfoList();
    assertEquals(3, callValueInfoList.size());
    CallValueInfo getResult = callValueInfoList.get(2);
    assertEquals("", getResult.getInitializationErrorString());
    CallValueInfo getResult2 = callValueInfoList.get(1);
    assertEquals("", getResult2.getTokenId());
    assertEquals("foo", getResult.getTokenId());
    assertEquals(1, getResult2.getAllFields().size());
    assertEquals(1L, getResult.getCallValue());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(2, getResult2.getSerializedSize());
    assertEquals(2L, getResult2.getCallValue());
    assertEquals(3, actualBuildInternalTransactionResult.getCallValueInfoCount());
    assertEquals(7, getResult.getSerializedSize());
    assertEquals(77, actualBuildInternalTransactionResult.getSerializedSize());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
  }

  /**
   * Test {@link TransactionUtil#buildInternalTransaction(InternalTransaction)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Hash toStringUtf8 is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#buildInternalTransaction(org.tron.common.runtime.InternalTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "InternalTransaction TransactionUtil.buildInternalTransaction(org.tron.common.runtime.InternalTransaction)"})
  public void testBuildInternalTransaction_whenA_thenReturnHashToStringUtf8IsAString()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    InternalTransaction actualBuildInternalTransactionResult = TransactionUtil.buildInternalTransaction(
        new org.tron.common.runtime.InternalTransaction(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1,
            sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Assert
    ByteString hash = actualBuildInternalTransactionResult.getHash();
    assertEquals("�Ka�[��h��(e�\r���-\n\u0013R\b��N9v�?��-", hash.toStringUtf8());
    Descriptor descriptorForType = actualBuildInternalTransactionResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getNestedTypes().size());
    assertTrue(hash.iterator().hasNext());
    InternalTransaction defaultInstanceForType = actualBuildInternalTransactionResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualBuildInternalTransactionResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ByteString callerAddress = defaultInstanceForType.getCallerAddress();
    assertSame(callerAddress, defaultInstanceForType.getHash());
    assertSame(callerAddress, defaultInstanceForType.getNote());
    assertSame(callerAddress, defaultInstanceForType.getTransferToAddress());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link TransactionUtil#isNumber(byte[])}.
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#isNumber(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.isNumber(byte[])"})
  public void testIsNumber_when0xaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.isNumber("0XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#isNumber(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#isNumber(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.isNumber(byte[])"})
  public void testIsNumber_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.isNumber("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#isNumber(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#isNumber(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.isNumber(byte[])"})
  public void testIsNumber_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.isNumber(new byte[]{}));
  }

  /**
   * Test {@link TransactionUtil#isNumber(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#isNumber(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.isNumber(byte[])"})
  public void testIsNumber_whenXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.isNumber("\bXAXAXAX".getBytes("UTF-8")));
  }
}
