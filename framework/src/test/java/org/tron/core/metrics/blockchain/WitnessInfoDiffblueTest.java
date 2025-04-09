package org.tron.core.metrics.blockchain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WitnessInfoDiffblueTest {
  /**
   * Test {@link WitnessInfo#equals(Object)}, and {@link WitnessInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessInfo#equals(Object)}
   *   <li>{@link WitnessInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessInfo.equals(Object)", "int WitnessInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WitnessInfo witnessInfo = new WitnessInfo("42 Main St", 1);
    WitnessInfo witnessInfo2 = new WitnessInfo("42 Main St", 1);

    // Act and Assert
    assertEquals(witnessInfo, witnessInfo2);
    int expectedHashCodeResult = witnessInfo.hashCode();
    assertEquals(expectedHashCodeResult, witnessInfo2.hashCode());
  }

  /**
   * Test {@link WitnessInfo#equals(Object)}, and {@link WitnessInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessInfo#equals(Object)}
   *   <li>{@link WitnessInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessInfo.equals(Object)", "int WitnessInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WitnessInfo witnessInfo = new WitnessInfo(null, 1);
    WitnessInfo witnessInfo2 = new WitnessInfo(null, 1);

    // Act and Assert
    assertEquals(witnessInfo, witnessInfo2);
    int expectedHashCodeResult = witnessInfo.hashCode();
    assertEquals(expectedHashCodeResult, witnessInfo2.hashCode());
  }

  /**
   * Test {@link WitnessInfo#equals(Object)}, and {@link WitnessInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessInfo#equals(Object)}
   *   <li>{@link WitnessInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessInfo.equals(Object)", "int WitnessInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WitnessInfo witnessInfo = new WitnessInfo("42 Main St", 1);

    // Act and Assert
    assertEquals(witnessInfo, witnessInfo);
    int expectedHashCodeResult = witnessInfo.hashCode();
    assertEquals(expectedHashCodeResult, witnessInfo.hashCode());
  }

  /**
   * Test {@link WitnessInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessInfo.equals(Object)", "int WitnessInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WitnessInfo witnessInfo = new WitnessInfo("17 High St", 1);

    // Act and Assert
    assertNotEquals(witnessInfo, new WitnessInfo("42 Main St", 1));
  }

  /**
   * Test {@link WitnessInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessInfo.equals(Object)", "int WitnessInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WitnessInfo witnessInfo = new WitnessInfo(null, 1);

    // Act and Assert
    assertNotEquals(witnessInfo, new WitnessInfo("42 Main St", 1));
  }

  /**
   * Test {@link WitnessInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessInfo.equals(Object)", "int WitnessInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WitnessInfo witnessInfo = new WitnessInfo("42 Main St", 3);

    // Act and Assert
    assertNotEquals(witnessInfo, new WitnessInfo("42 Main St", 1));
  }

  /**
   * Test {@link WitnessInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessInfo.equals(Object)", "int WitnessInfo.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WitnessInfo("42 Main St", 1), null);
  }

  /**
   * Test {@link WitnessInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessInfo.equals(Object)", "int WitnessInfo.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WitnessInfo("42 Main St", 1), "Different type to WitnessInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessInfo#WitnessInfo(String, int)}
   *   <li>{@link WitnessInfo#setAddress(String)}
   *   <li>{@link WitnessInfo#setVersion(int)}
   *   <li>{@link WitnessInfo#toString()}
   *   <li>{@link WitnessInfo#getAddress()}
   *   <li>{@link WitnessInfo#getVersion()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessInfo.<init>(String, int)", "String WitnessInfo.getAddress()",
      "int WitnessInfo.getVersion()", "void WitnessInfo.setAddress(String)", "void WitnessInfo.setVersion(int)",
      "String WitnessInfo.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    WitnessInfo actualWitnessInfo = new WitnessInfo("42 Main St", 1);
    actualWitnessInfo.setAddress("42 Main St");
    actualWitnessInfo.setVersion(1);
    String actualToStringResult = actualWitnessInfo.toString();
    String actualAddress = actualWitnessInfo.getAddress();

    // Assert
    assertEquals("42 Main St", actualAddress);
    assertEquals("WitnessInfo(address=42 Main St, version=1)", actualToStringResult);
    assertEquals(1, actualWitnessInfo.getVersion());
  }
}
