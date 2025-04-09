package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Fp6DiffblueTest {
  /**
   * Test {@link Fp6#Fp6(Fp2, Fp2, Fp2)}.
   * <p>
   * Method under test: {@link Fp6#Fp6(Fp2, Fp2, Fp2)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Fp6.<init>(Fp2, Fp2, Fp2)"})
  public void testNewFp6() {
    // Arrange and Act
    Fp6 actualFp6 = new Fp6(Fp6.NON_RESIDUE, Fp6.NON_RESIDUE, Fp6.NON_RESIDUE);

    // Assert
    Fp2 fp2 = actualFp6.a;
    assertFalse(fp2.isZero());
    Fp2 fp22 = actualFp6.b;
    assertFalse(fp22.isZero());
    Fp2 fp23 = actualFp6.c;
    assertFalse(fp23.isZero());
    assertTrue(fp2.isValid());
    assertTrue(fp22.isValid());
    assertTrue(fp23.isValid());
  }

  /**
   * Test {@link Fp6#squared()}.
   * <ul>
   *   <li>Given {@link Fp6#ZERO}.</li>
   *   <li>Then return {@link Fp6#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#squared()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp6 Fp6.squared()"})
  public void testSquared_givenZero_thenReturnZero() {
    // Arrange and Act
    Fp6 actualSquaredResult = Fp6.ZERO.squared();

    // Assert
    assertEquals(actualSquaredResult.ZERO, actualSquaredResult);
  }

  /**
   * Test {@link Fp6#dbl()}.
   * <ul>
   *   <li>Given {@link Fp6#ZERO}.</li>
   *   <li>Then return {@link Fp6#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#dbl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp6 Fp6.dbl()"})
  public void testDbl_givenZero_thenReturnZero() {
    // Arrange and Act
    Fp6 actualDblResult = Fp6.ZERO.dbl();

    // Assert
    assertEquals(actualDblResult.ZERO, actualDblResult);
  }

  /**
   * Test {@link Fp6#mul(Fp2)} with {@code Fp2}.
   * <ul>
   *   <li>Given {@link Fp6#ZERO}.</li>
   *   <li>When {@link Fp6#NON_RESIDUE}.</li>
   *   <li>Then return {@link Fp6#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#mul(Fp2)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp6 Fp6.mul(Fp2)"})
  public void testMulWithFp2_givenZero_whenNon_residue_thenReturnZero() {
    // Arrange and Act
    Fp6 actualMulResult = Fp6.ZERO.mul(Fp6.NON_RESIDUE);

    // Assert
    assertEquals(actualMulResult.ZERO, actualMulResult);
  }

  /**
   * Test {@link Fp6#mul(Fp6)} with {@code Fp6}.
   * <ul>
   *   <li>Given {@link Fp6#ZERO}.</li>
   *   <li>When {@link Fp6#ZERO}.</li>
   *   <li>Then return {@link Fp6#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#mul(Fp6)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp6 Fp6.mul(Fp6)"})
  public void testMulWithFp6_givenZero_whenZero_thenReturnZero() {
    // Arrange and Act
    Fp6 actualMulResult = Fp6.ZERO.mul(Fp6.ZERO);

    // Assert
    assertEquals(actualMulResult.ZERO, actualMulResult);
  }

  /**
   * Test {@link Fp6#mulByNonResidue()}.
   * <ul>
   *   <li>Given {@link Fp6#ZERO}.</li>
   *   <li>Then return {@link Fp6#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#mulByNonResidue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp6 Fp6.mulByNonResidue()"})
  public void testMulByNonResidue_givenZero_thenReturnZero() {
    // Arrange and Act
    Fp6 actualMulByNonResidueResult = Fp6.ZERO.mulByNonResidue();

    // Assert
    assertEquals(actualMulByNonResidueResult.ZERO, actualMulByNonResidueResult);
  }

  /**
   * Test {@link Fp6#add(Fp6)} with {@code Fp6}.
   * <ul>
   *   <li>Given {@link Fp6#ZERO}.</li>
   *   <li>When {@link Fp6#ZERO}.</li>
   *   <li>Then return {@link Fp6#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#add(Fp6)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp6 Fp6.add(Fp6)"})
  public void testAddWithFp6_givenZero_whenZero_thenReturnZero() {
    // Arrange and Act
    Fp6 actualAddResult = Fp6.ZERO.add(Fp6.ZERO);

    // Assert
    assertEquals(actualAddResult.ZERO, actualAddResult);
  }

  /**
   * Test {@link Fp6#sub(Fp6)} with {@code Fp6}.
   * <ul>
   *   <li>Given {@link Fp6#ZERO}.</li>
   *   <li>When {@link Fp6#ZERO}.</li>
   *   <li>Then return {@link Fp6#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#sub(Fp6)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp6 Fp6.sub(Fp6)"})
  public void testSubWithFp6_givenZero_whenZero_thenReturnZero() {
    // Arrange and Act
    Fp6 actualSubResult = Fp6.ZERO.sub(Fp6.ZERO);

    // Assert
    assertEquals(actualSubResult.ZERO, actualSubResult);
  }

  /**
   * Test {@link Fp6#inverse()}.
   * <ul>
   *   <li>Given {@link Fp6#_1}.</li>
   *   <li>Then return {@link Fp6#_1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#inverse()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp6 Fp6.inverse()"})
  public void testInverse_given_1_thenReturn_1() {
    // Arrange and Act
    Fp6 actualInverseResult = Fp6._1.inverse();

    // Assert
    assertEquals(actualInverseResult._1, actualInverseResult);
  }

  /**
   * Test {@link Fp6#negate()}.
   * <ul>
   *   <li>Given {@link Fp6#ZERO}.</li>
   *   <li>Then return {@link Fp6#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp6 Fp6.negate()"})
  public void testNegate_givenZero_thenReturnZero() {
    // Arrange and Act
    Fp6 actualNegateResult = Fp6.ZERO.negate();

    // Assert
    assertEquals(actualNegateResult.ZERO, actualNegateResult);
  }

  /**
   * Test {@link Fp6#isZero()}.
   * <p>
   * Method under test: {@link Fp6#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.isZero()"})
  public void testIsZero() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse((new Fp6(Fp2.ZERO, Fp2.create(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")), Fp6.NON_RESIDUE)).isZero());
  }

  /**
   * Test {@link Fp6#isZero()}.
   * <p>
   * Method under test: {@link Fp6#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.isZero()"})
  public void testIsZero2() {
    // Arrange, Act and Assert
    assertFalse((new Fp6(Fp2.ZERO, Fp2.create(new byte[]{}, new byte[]{}), Fp6.NON_RESIDUE)).isZero());
  }

  /**
   * Test {@link Fp6#isZero()}.
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@code null} and b is {@link Fp2#ZERO} and c is {@link Fp6#NON_RESIDUE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.isZero()"})
  public void testIsZero_givenFp6WithAIsNullAndBIsZeroAndCIsNon_residue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Fp6(null, Fp2.ZERO, Fp6.NON_RESIDUE)).isZero());
  }

  /**
   * Test {@link Fp6#isZero()}.
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@link Fp2#ZERO} and b is create {@code null} and {@link BN128G2#FR_NEG_ONE} and c is {@link Fp6#NON_RESIDUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.isZero()"})
  public void testIsZero_givenFp6WithAIsZeroAndBIsCreateNullAndFr_neg_oneAndCIsNon_residue() {
    // Arrange, Act and Assert
    assertFalse((new Fp6(Fp2.ZERO, Fp2.create(null, BN128G2.FR_NEG_ONE), Fp6.NON_RESIDUE)).isZero());
  }

  /**
   * Test {@link Fp6#isZero()}.
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@link Fp2#ZERO} and b is {@link Fp6#NON_RESIDUE} and c is {@link Fp6#NON_RESIDUE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.isZero()"})
  public void testIsZero_givenFp6WithAIsZeroAndBIsNon_residueAndCIsNon_residue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Fp6(Fp2.ZERO, Fp6.NON_RESIDUE, Fp6.NON_RESIDUE)).isZero());
  }

  /**
   * Test {@link Fp6#isZero()}.
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@link Fp2#ZERO} and b is {@code null} and c is {@link Fp6#NON_RESIDUE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.isZero()"})
  public void testIsZero_givenFp6WithAIsZeroAndBIsNullAndCIsNon_residue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Fp6(Fp2.ZERO, null, Fp6.NON_RESIDUE)).isZero());
  }

  /**
   * Test {@link Fp6#isZero()}.
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@link Fp2#ZERO} and b is {@link Fp2#ZERO} and c is {@link Fp6#NON_RESIDUE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.isZero()"})
  public void testIsZero_givenFp6WithAIsZeroAndBIsZeroAndCIsNon_residue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Fp6(Fp2.ZERO, Fp2.ZERO, Fp6.NON_RESIDUE)).isZero());
  }

  /**
   * Test {@link Fp6#isZero()}.
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@link Fp2#ZERO} and b is {@link Fp2#ZERO} and c is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.isZero()"})
  public void testIsZero_givenFp6WithAIsZeroAndBIsZeroAndCIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Fp6(Fp2.ZERO, Fp2.ZERO, null)).isZero());
  }

  /**
   * Test {@link Fp6#isZero()}.
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@link Fp2#ZERO} and b is {@link Fp2#ZERO} and c is {@link Fp2#ZERO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.isZero()"})
  public void testIsZero_givenFp6WithAIsZeroAndBIsZeroAndCIsZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Fp6(Fp2.ZERO, Fp2.ZERO, Fp2.ZERO)).isZero());
  }

  /**
   * Test {@link Fp6#isZero()}.
   * <ul>
   *   <li>Given {@link Fp6#ZERO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.isZero()"})
  public void testIsZero_givenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Fp6.ZERO.isZero());
  }

  /**
   * Test {@link Fp6#isZero()}.
   * <ul>
   *   <li>Given {@link Fp6#_1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.isZero()"})
  public void testIsZero_given_1_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Fp6._1.isZero());
  }

  /**
   * Test {@link Fp6#isValid()}.
   * <ul>
   *   <li>Given {@link Fp6#ZERO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#isValid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.isValid()"})
  public void testIsValid_givenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Fp6.ZERO.isValid());
  }

  /**
   * Test {@link Fp6#frobeniusMap(int)}.
   * <ul>
   *   <li>Given {@link Fp6#ZERO}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@link Fp6#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#frobeniusMap(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp6 Fp6.frobeniusMap(int)"})
  public void testFrobeniusMap_givenZero_whenOne_thenReturnZero() {
    // Arrange and Act
    Fp6 actualFrobeniusMapResult = Fp6.ZERO.frobeniusMap(1);

    // Assert
    assertEquals(actualFrobeniusMapResult.ZERO, actualFrobeniusMapResult);
  }

  /**
   * Test {@link Fp6#equals(Object)}, and {@link Fp6#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Fp6#equals(Object)}
   *   <li>{@link Fp6#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.equals(Object)", "int Fp6.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Fp6 fp6 = Fp6.ZERO;
    Fp6 fp62 = Fp6.ZERO;

    // Act and Assert
    assertEquals(fp6, fp62);
    int expectedHashCodeResult = fp6.hashCode();
    assertEquals(expectedHashCodeResult, fp62.hashCode());
  }

  /**
   * Test {@link Fp6#equals(Object)}, and {@link Fp6#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Fp6#equals(Object)}
   *   <li>{@link Fp6#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.equals(Object)", "int Fp6.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Fp6 fp6 = new Fp6(Fp2.ZERO, Fp2.ZERO, Fp2.ZERO);
    Fp6 fp62 = Fp6.ZERO;

    // Act and Assert
    assertEquals(fp6, fp62);
    int expectedHashCodeResult = fp6.hashCode();
    assertEquals(expectedHashCodeResult, fp62.hashCode());
  }

  /**
   * Test {@link Fp6#equals(Object)}, and {@link Fp6#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Fp6#equals(Object)}
   *   <li>{@link Fp6#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.equals(Object)", "int Fp6.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Fp6 fp6 = Fp6.ZERO;

    // Act and Assert
    assertEquals(fp6, fp6);
    int expectedHashCodeResult = fp6.hashCode();
    assertEquals(expectedHashCodeResult, fp6.hashCode());
  }

  /**
   * Test {@link Fp6#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.equals(Object)", "int Fp6.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp6._1, Fp6.ZERO);
  }

  /**
   * Test {@link Fp6#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.equals(Object)", "int Fp6.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new Fp6(Fp2.ZERO, Fp6.NON_RESIDUE, Fp6.NON_RESIDUE), Fp6.ZERO);
  }

  /**
   * Test {@link Fp6#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.equals(Object)", "int Fp6.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new Fp6(Fp2.ZERO, Fp2.ZERO, Fp6.NON_RESIDUE), Fp6.ZERO);
  }

  /**
   * Test {@link Fp6#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.equals(Object)", "int Fp6.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange, Act and Assert
    assertNotEquals(new Fp6(Fp2.ZERO, null, Fp6.NON_RESIDUE), Fp6.ZERO);
  }

  /**
   * Test {@link Fp6#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.equals(Object)", "int Fp6.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange, Act and Assert
    assertNotEquals(new Fp6(null, Fp2.ZERO, Fp6.NON_RESIDUE), Fp6.ZERO);
  }

  /**
   * Test {@link Fp6#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.equals(Object)", "int Fp6.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange, Act and Assert
    assertNotEquals(new Fp6(Fp2.ZERO, Fp2.ZERO, null), Fp6.ZERO);
  }

  /**
   * Test {@link Fp6#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.equals(Object)", "int Fp6.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp6.ZERO, null);
  }

  /**
   * Test {@link Fp6#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Fp6#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp6.equals(Object)", "int Fp6.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp6.ZERO, "Different type to Fp6");
  }
}
