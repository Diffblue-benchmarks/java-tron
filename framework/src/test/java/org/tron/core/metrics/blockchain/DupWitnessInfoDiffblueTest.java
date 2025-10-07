package org.tron.core.metrics.blockchain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DupWitnessInfoDiffblueTest {
  /**
   * Test {@link DupWitnessInfo#equals(Object)}, and {@link DupWitnessInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DupWitnessInfo#equals(Object)}
   *   <li>{@link DupWitnessInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DupWitnessInfo.equals(Object)", "int DupWitnessInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DupWitnessInfo dupWitnessInfo = new DupWitnessInfo();
    dupWitnessInfo.setAddress("42 Main St");
    dupWitnessInfo.setBlockNum(1L);
    dupWitnessInfo.setCount(3);

    DupWitnessInfo dupWitnessInfo2 = new DupWitnessInfo();
    dupWitnessInfo2.setAddress("42 Main St");
    dupWitnessInfo2.setBlockNum(1L);
    dupWitnessInfo2.setCount(3);

    // Act and Assert
    assertEquals(dupWitnessInfo, dupWitnessInfo2);
    assertEquals(dupWitnessInfo.hashCode(), dupWitnessInfo2.hashCode());
  }

  /**
   * Test {@link DupWitnessInfo#equals(Object)}, and {@link DupWitnessInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DupWitnessInfo#equals(Object)}
   *   <li>{@link DupWitnessInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DupWitnessInfo.equals(Object)", "int DupWitnessInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DupWitnessInfo dupWitnessInfo = new DupWitnessInfo();
    dupWitnessInfo.setAddress(null);
    dupWitnessInfo.setBlockNum(1L);
    dupWitnessInfo.setCount(3);

    DupWitnessInfo dupWitnessInfo2 = new DupWitnessInfo();
    dupWitnessInfo2.setAddress(null);
    dupWitnessInfo2.setBlockNum(1L);
    dupWitnessInfo2.setCount(3);

    // Act and Assert
    assertEquals(dupWitnessInfo, dupWitnessInfo2);
    assertEquals(dupWitnessInfo.hashCode(), dupWitnessInfo2.hashCode());
  }

  /**
   * Test {@link DupWitnessInfo#equals(Object)}, and {@link DupWitnessInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DupWitnessInfo#equals(Object)}
   *   <li>{@link DupWitnessInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DupWitnessInfo.equals(Object)", "int DupWitnessInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DupWitnessInfo dupWitnessInfo = new DupWitnessInfo();
    dupWitnessInfo.setAddress("42 Main St");
    dupWitnessInfo.setBlockNum(1L);
    dupWitnessInfo.setCount(3);

    // Act and Assert
    assertEquals(dupWitnessInfo, dupWitnessInfo);
    int expectedHashCodeResult = dupWitnessInfo.hashCode();
    assertEquals(expectedHashCodeResult, dupWitnessInfo.hashCode());
  }

  /**
   * Test {@link DupWitnessInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DupWitnessInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DupWitnessInfo.equals(Object)", "int DupWitnessInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DupWitnessInfo dupWitnessInfo = new DupWitnessInfo();
    dupWitnessInfo.setAddress("17 High St");
    dupWitnessInfo.setBlockNum(1L);
    dupWitnessInfo.setCount(3);

    DupWitnessInfo dupWitnessInfo2 = new DupWitnessInfo();
    dupWitnessInfo2.setAddress("42 Main St");
    dupWitnessInfo2.setBlockNum(1L);
    dupWitnessInfo2.setCount(3);

    // Act and Assert
    assertNotEquals(dupWitnessInfo, dupWitnessInfo2);
  }

  /**
   * Test {@link DupWitnessInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DupWitnessInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DupWitnessInfo.equals(Object)", "int DupWitnessInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DupWitnessInfo dupWitnessInfo = new DupWitnessInfo();
    dupWitnessInfo.setAddress(null);
    dupWitnessInfo.setBlockNum(1L);
    dupWitnessInfo.setCount(3);

    DupWitnessInfo dupWitnessInfo2 = new DupWitnessInfo();
    dupWitnessInfo2.setAddress("42 Main St");
    dupWitnessInfo2.setBlockNum(1L);
    dupWitnessInfo2.setCount(3);

    // Act and Assert
    assertNotEquals(dupWitnessInfo, dupWitnessInfo2);
  }

  /**
   * Test {@link DupWitnessInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DupWitnessInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DupWitnessInfo.equals(Object)", "int DupWitnessInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DupWitnessInfo dupWitnessInfo = new DupWitnessInfo();
    dupWitnessInfo.setAddress("42 Main St");
    dupWitnessInfo.setBlockNum(3L);
    dupWitnessInfo.setCount(3);

    DupWitnessInfo dupWitnessInfo2 = new DupWitnessInfo();
    dupWitnessInfo2.setAddress("42 Main St");
    dupWitnessInfo2.setBlockNum(1L);
    dupWitnessInfo2.setCount(3);

    // Act and Assert
    assertNotEquals(dupWitnessInfo, dupWitnessInfo2);
  }

  /**
   * Test {@link DupWitnessInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DupWitnessInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DupWitnessInfo.equals(Object)", "int DupWitnessInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DupWitnessInfo dupWitnessInfo = new DupWitnessInfo();
    dupWitnessInfo.setAddress("42 Main St");
    dupWitnessInfo.setBlockNum(1L);
    dupWitnessInfo.setCount(1);

    DupWitnessInfo dupWitnessInfo2 = new DupWitnessInfo();
    dupWitnessInfo2.setAddress("42 Main St");
    dupWitnessInfo2.setBlockNum(1L);
    dupWitnessInfo2.setCount(3);

    // Act and Assert
    assertNotEquals(dupWitnessInfo, dupWitnessInfo2);
  }

  /**
   * Test {@link DupWitnessInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DupWitnessInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DupWitnessInfo.equals(Object)", "int DupWitnessInfo.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DupWitnessInfo dupWitnessInfo = new DupWitnessInfo();
    dupWitnessInfo.setAddress("42 Main St");
    dupWitnessInfo.setBlockNum(1L);
    dupWitnessInfo.setCount(3);

    // Act and Assert
    assertNotEquals(dupWitnessInfo, null);
  }

  /**
   * Test {@link DupWitnessInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DupWitnessInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DupWitnessInfo.equals(Object)", "int DupWitnessInfo.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DupWitnessInfo dupWitnessInfo = new DupWitnessInfo();
    dupWitnessInfo.setAddress("42 Main St");
    dupWitnessInfo.setBlockNum(1L);
    dupWitnessInfo.setCount(3);

    // Act and Assert
    assertNotEquals(dupWitnessInfo, "Different type to DupWitnessInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DupWitnessInfo}
   *   <li>{@link DupWitnessInfo#setAddress(String)}
   *   <li>{@link DupWitnessInfo#setBlockNum(long)}
   *   <li>{@link DupWitnessInfo#setCount(int)}
   *   <li>{@link DupWitnessInfo#toString()}
   *   <li>{@link DupWitnessInfo#getAddress()}
   *   <li>{@link DupWitnessInfo#getBlockNum()}
   *   <li>{@link DupWitnessInfo#getCount()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DupWitnessInfo.<init>()",
    "String DupWitnessInfo.getAddress()",
    "long DupWitnessInfo.getBlockNum()",
    "int DupWitnessInfo.getCount()",
    "void DupWitnessInfo.setAddress(String)",
    "void DupWitnessInfo.setBlockNum(long)",
    "void DupWitnessInfo.setCount(int)",
    "String DupWitnessInfo.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DupWitnessInfo actualDupWitnessInfo = new DupWitnessInfo();
    actualDupWitnessInfo.setAddress("42 Main St");
    actualDupWitnessInfo.setBlockNum(1L);
    actualDupWitnessInfo.setCount(3);
    String actualToStringResult = actualDupWitnessInfo.toString();
    String actualAddress = actualDupWitnessInfo.getAddress();
    long actualBlockNum = actualDupWitnessInfo.getBlockNum();

    // Assert
    assertEquals("42 Main St", actualAddress);
    assertEquals("DupWitnessInfo(address=42 Main St, blockNum=1, count=3)", actualToStringResult);
    assertEquals(1L, actualBlockNum);
    assertEquals(3, actualDupWitnessInfo.getCount());
  }
}
