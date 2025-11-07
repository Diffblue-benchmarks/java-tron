package org.tron.protos.contract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal.EnumLiteMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.contract.AssetIssueContractOuterClass.AssetIssueContract;
import org.tron.protos.contract.Common.ResourceCode;

public class CommonDiffblueTest {
  /**
   * Test ResourceCode {@link ResourceCode#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode ResourceCode.forNumber(int)"})
  public void testResourceCodeForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ResourceCode.forNumber(42));
  }

  /**
   * Test ResourceCode {@link ResourceCode#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code ENERGY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode ResourceCode.forNumber(int)"})
  public void testResourceCodeForNumber_whenOne_thenReturnEnergy() {
    // Arrange, Act and Assert
    assertEquals(ResourceCode.ENERGY, ResourceCode.forNumber(1));
  }

  /**
   * Test ResourceCode {@link ResourceCode#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code TRON_POWER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode ResourceCode.forNumber(int)"})
  public void testResourceCodeForNumber_whenTwo_thenReturnTronPower() {
    // Arrange, Act and Assert
    assertEquals(ResourceCode.TRON_POWER, ResourceCode.forNumber(2));
  }

  /**
   * Test ResourceCode {@link ResourceCode#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code BANDWIDTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode ResourceCode.forNumber(int)"})
  public void testResourceCodeForNumber_whenZero_thenReturnBandwidth() {
    // Arrange, Act and Assert
    assertEquals(ResourceCode.BANDWIDTH, ResourceCode.forNumber(0));
  }

  /**
   * Test ResourceCode {@link ResourceCode#getDescriptor()}.
   * <p>
   * Method under test: {@link ResourceCode#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EnumDescriptor ResourceCode.getDescriptor()"})
  public void testResourceCodeGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = ResourceCode.getDescriptor();

    // Assert
    assertEquals("ResourceCode", actualDescriptor.getName());
    assertEquals("protocol.ResourceCode", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }

  /**
   * Test ResourceCode {@link ResourceCode#getDescriptorForType()}.
   * <p>
   * Method under test: {@link ResourceCode#getDescriptorForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EnumDescriptor ResourceCode.getDescriptorForType()"})
  public void testResourceCodeGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = ResourceCode.BANDWIDTH.getDescriptorForType();

    // Assert
    assertEquals("ResourceCode", actualDescriptorForType.getName());
    assertEquals("protocol.ResourceCode", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(3, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test ResourceCode {@link ResourceCode#getNumber()}.
   * <ul>
   *   <li>Given {@code BANDWIDTH}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#getNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourceCode.getNumber()"})
  public void testResourceCodeGetNumber_givenBandwidth_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ResourceCode.BANDWIDTH.getNumber());
  }

  /**
   * Test ResourceCode {@link ResourceCode#getNumber()}.
   * <ul>
   *   <li>Given {@link ResourceCode#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#getNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourceCode.getNumber()"})
  public void testResourceCodeGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ResourceCode.UNRECOGNIZED.getNumber());
  }

  /**
   * Test ResourceCode {@link ResourceCode#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@code BANDWIDTH}.</li>
   *   <li>Then return Name is {@code BANDWIDTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#getValueDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ResourceCode.getValueDescriptor()"})
  public void testResourceCodeGetValueDescriptor_givenBandwidth_thenReturnNameIsBandwidth() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = ResourceCode.BANDWIDTH.getValueDescriptor();

    // Assert
    assertEquals("BANDWIDTH", actualValueDescriptor.getName());
    assertEquals("protocol.ResourceCode.BANDWIDTH", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test ResourceCode {@link ResourceCode#getValueDescriptor()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#getValueDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ResourceCode.getValueDescriptor()"})
  public void testResourceCodeGetValueDescriptor_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ResourceCode.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test ResourceCode {@link ResourceCode#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ResourceCode#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ResourceCode.internalGetValueMap()"})
  public void testResourceCodeInternalGetValueMap() {
    // Arrange and Act
    EnumLiteMap<ResourceCode> actualInternalGetValueMapResult = ResourceCode.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AssetIssueContract.END_TIME_FIELD_NUMBER));
  }

  /**
   * Test ResourceCode {@link ResourceCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code ENERGY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ResourceCode.internalGetValueMap()"})
  public void testResourceCodeInternalGetValueMap_thenReturnFindValueByNumberOneIsEnergy() {
    // Arrange and Act
    EnumLiteMap<ResourceCode> actualInternalGetValueMapResult = ResourceCode.internalGetValueMap();

    // Assert
    assertEquals(ResourceCode.ENERGY, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test ResourceCode {@link ResourceCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code TRON_POWER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ResourceCode.internalGetValueMap()"})
  public void testResourceCodeInternalGetValueMap_thenReturnFindValueByNumberTwoIsTronPower() {
    // Arrange and Act
    EnumLiteMap<ResourceCode> actualInternalGetValueMapResult = ResourceCode.internalGetValueMap();

    // Assert
    assertEquals(ResourceCode.TRON_POWER, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test ResourceCode {@link ResourceCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code BANDWIDTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ResourceCode.internalGetValueMap()"})
  public void testResourceCodeInternalGetValueMap_thenReturnFindValueByNumberZeroIsBandwidth() {
    // Arrange and Act
    EnumLiteMap<ResourceCode> actualInternalGetValueMapResult = ResourceCode.internalGetValueMap();

    // Assert
    assertEquals(ResourceCode.BANDWIDTH, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test ResourceCode {@link ResourceCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode ResourceCode.valueOf(int)"})
  public void testResourceCodeValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ResourceCode.valueOf(42));
  }

  /**
   * Test ResourceCode {@link ResourceCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code ENERGY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode ResourceCode.valueOf(int)"})
  public void testResourceCodeValueOfWithValue_whenOne_thenReturnEnergy() {
    // Arrange, Act and Assert
    assertEquals(ResourceCode.ENERGY, ResourceCode.valueOf(1));
  }

  /**
   * Test ResourceCode {@link ResourceCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code TRON_POWER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode ResourceCode.valueOf(int)"})
  public void testResourceCodeValueOfWithValue_whenTwo_thenReturnTronPower() {
    // Arrange, Act and Assert
    assertEquals(ResourceCode.TRON_POWER, ResourceCode.valueOf(2));
  }

  /**
   * Test ResourceCode {@link ResourceCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code BANDWIDTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceCode#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode ResourceCode.valueOf(int)"})
  public void testResourceCodeValueOfWithValue_whenZero_thenReturnBandwidth() {
    // Arrange, Act and Assert
    assertEquals(ResourceCode.BANDWIDTH, ResourceCode.valueOf(0));
  }
}
