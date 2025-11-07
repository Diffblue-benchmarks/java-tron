package org.tron.core.metrics.blockchain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class DupWitnessInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DupWitnessInfo#equals(Object)}
   *   <li>{@link DupWitnessInfo#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = dupWitnessInfo.hashCode();
    assertEquals(expectedHashCodeResult, dupWitnessInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DupWitnessInfo#equals(Object)}
   *   <li>{@link DupWitnessInfo#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = dupWitnessInfo.hashCode();
    assertEquals(expectedHashCodeResult, dupWitnessInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DupWitnessInfo#equals(Object)}
   *   <li>{@link DupWitnessInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link DupWitnessInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DupWitnessInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DupWitnessInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DupWitnessInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DupWitnessInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DupWitnessInfo#equals(Object)}
   */
  @Test
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
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    DupWitnessInfo actualDupWitnessInfo = new DupWitnessInfo();
    actualDupWitnessInfo.setAddress("42 Main St");
    actualDupWitnessInfo.setBlockNum(1L);
    actualDupWitnessInfo.setCount(3);
    String actualToStringResult = actualDupWitnessInfo.toString();
    String actualAddress = actualDupWitnessInfo.getAddress();
    long actualBlockNum = actualDupWitnessInfo.getBlockNum();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualAddress);
    assertEquals("DupWitnessInfo(address=42 Main St, blockNum=1, count=3)", actualToStringResult);
    assertEquals(1L, actualBlockNum);
    assertEquals(3, actualDupWitnessInfo.getCount());
  }
}
