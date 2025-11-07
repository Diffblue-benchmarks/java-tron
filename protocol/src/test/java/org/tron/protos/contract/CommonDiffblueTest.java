package org.tron.protos.contract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.google.protobuf.Internal;
import org.junit.Test;

public class CommonDiffblueTest {
  /**
   * Method under test: {@link Common.ResourceCode#forNumber(int)}
   */
  @Test
  public void testResourceCodeForNumber() {
    // Arrange, Act and Assert
    assertNull(Common.ResourceCode.forNumber(42));
    assertEquals(Common.ResourceCode.BANDWIDTH, Common.ResourceCode.forNumber(0));
    assertEquals(Common.ResourceCode.ENERGY, Common.ResourceCode.forNumber(1));
    assertEquals(Common.ResourceCode.TRON_POWER, Common.ResourceCode.forNumber(2));
  }

  /**
   * Method under test: {@link Common.ResourceCode#getNumber()}
   */
  @Test
  public void testResourceCodeGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, Common.ResourceCode.BANDWIDTH.getNumber());
    assertThrows(IllegalArgumentException.class, () -> Common.ResourceCode.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link Common.ResourceCode#getValueDescriptor()}
   */
  @Test
  public void testResourceCodeGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> Common.ResourceCode.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link Common.ResourceCode#internalGetValueMap()}
   */
  @Test
  public void testResourceCodeInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<Common.ResourceCode> actualInternalGetValueMapResult = Common.ResourceCode
        .internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult
        .findValueByNumber(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link Common.ResourceCode#internalGetValueMap()}
   */
  @Test
  public void testResourceCodeInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<Common.ResourceCode> actualInternalGetValueMapResult = Common.ResourceCode
        .internalGetValueMap();

    // Assert
    assertEquals(Common.ResourceCode.ENERGY, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link Common.ResourceCode#internalGetValueMap()}
   */
  @Test
  public void testResourceCodeInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<Common.ResourceCode> actualInternalGetValueMapResult = Common.ResourceCode
        .internalGetValueMap();

    // Assert
    assertEquals(Common.ResourceCode.TRON_POWER, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link Common.ResourceCode#internalGetValueMap()}
   */
  @Test
  public void testResourceCodeInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<Common.ResourceCode> actualInternalGetValueMapResult = Common.ResourceCode
        .internalGetValueMap();

    // Assert
    assertEquals(Common.ResourceCode.BANDWIDTH, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link Common.ResourceCode#valueOf(int)}
   */
  @Test
  public void testResourceCodeValueOf() {
    // Arrange, Act and Assert
    assertNull(Common.ResourceCode.valueOf(42));
    assertEquals(Common.ResourceCode.BANDWIDTH, Common.ResourceCode.valueOf(0));
    assertEquals(Common.ResourceCode.ENERGY, Common.ResourceCode.valueOf(1));
    assertEquals(Common.ResourceCode.TRON_POWER, Common.ResourceCode.valueOf(2));
  }
}
