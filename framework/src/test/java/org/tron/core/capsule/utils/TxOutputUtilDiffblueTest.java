package org.tron.core.capsule.utils;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.TXOutput;

public class TxOutputUtilDiffblueTest {
  /**
   * Test {@link TxOutputUtil#newTxOutput(long, String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link TxOutputUtil#newTxOutput(long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TXOutput TxOutputUtil.newTxOutput(long, String)"})
  public void testNewTxOutput_when0x() {
    // Arrange and Act
    TXOutput actualNewTxOutputResult = TxOutputUtil.newTxOutput(42L, "0x");

    // Assert
    UnknownFieldSet unknownFields = actualNewTxOutputResult.getUnknownFields();
    TXOutput defaultInstanceForType = actualNewTxOutputResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link TxOutputUtil#newTxOutput(long, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TxOutputUtil#newTxOutput(long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TXOutput TxOutputUtil.newTxOutput(long, String)"})
  public void testNewTxOutput_whenNull() {
    // Arrange and Act
    TXOutput actualNewTxOutputResult = TxOutputUtil.newTxOutput(42L, null);

    // Assert
    UnknownFieldSet unknownFields = actualNewTxOutputResult.getUnknownFields();
    TXOutput defaultInstanceForType = actualNewTxOutputResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }
}
