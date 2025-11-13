package org.tron.core.capsule.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.TXInput;
import org.tron.protos.Protocol.TXInput.raw;

public class TxInputUtilDiffblueTest {
  /**
   * Test {@link TxInputUtil#newTxInput(byte[], long, byte[], byte[])}.
   *
   * <ul>
   *   <li>Then return RawData SerializedSize is twenty-two.
   * </ul>
   *
   * <p>Method under test: {@link TxInputUtil#newTxInput(byte[], long, byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TXInput TxInputUtil.newTxInput(byte[], long, byte[], byte[])"})
  public void testNewTxInput_thenReturnRawDataSerializedSizeIsTwentyTwo()
      throws UnsupportedEncodingException {
    // Arrange and Act
    TXInput actualNewTxInputResult =
        TxInputUtil.newTxInput(
            "AXAXAXAX".getBytes("UTF-8"),
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    raw rawData = actualNewTxInputResult.getRawData();
    assertEquals(22, rawData.getSerializedSize());
    assertEquals(3, rawData.getAllFields().size());
    assertEquals(34, actualNewTxInputResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualNewTxInputResult.getUnknownFields();
    TXInput defaultInstanceForType = actualNewTxInputResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, rawData.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(rawData, actualNewTxInputResult.getRawDataOrBuilder());
  }

  /**
   * Test {@link TxInputUtil#newTxInput(byte[], long, byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return RawData SerializedSize is twelve.
   * </ul>
   *
   * <p>Method under test: {@link TxInputUtil#newTxInput(byte[], long, byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TXInput TxInputUtil.newTxInput(byte[], long, byte[], byte[])"})
  public void testNewTxInput_whenEmptyArrayOfByte_thenReturnRawDataSerializedSizeIsTwelve()
      throws UnsupportedEncodingException {
    // Arrange and Act
    TXInput actualNewTxInputResult =
        TxInputUtil.newTxInput(
            new byte[] {}, 1L, "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    raw rawData = actualNewTxInputResult.getRawData();
    assertEquals(12, rawData.getSerializedSize());
    assertEquals(2, rawData.getAllFields().size());
    assertEquals(24, actualNewTxInputResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualNewTxInputResult.getUnknownFields();
    TXInput defaultInstanceForType = actualNewTxInputResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, rawData.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(rawData, actualNewTxInputResult.getRawDataOrBuilder());
  }
}
