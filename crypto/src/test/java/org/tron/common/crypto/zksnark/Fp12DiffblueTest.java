package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Fp12DiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fp12#Fp12(Fp6, Fp6)}
   *   <li>{@link Fp12#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Fp12.<init>(Fp6, Fp6)", "java.lang.String Fp12.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Fp12 actualFp12 = new Fp12(Fp6.ZERO, Fp6.ZERO);

    // Assert
    assertEquals(
        "Fp12 (0; 0)\n     (0; 0)\n     (0; 0)\n     (0; 0)\n     (0; 0)\n     (0; 0)\n",
        actualFp12.toString());
    Fp6 fp6 = actualFp12.a;
    assertTrue(fp6.isValid());
    Fp6 fp62 = actualFp12.b;
    assertTrue(fp62.isValid());
    assertTrue(fp6.isZero());
    assertTrue(fp62.isZero());
  }

  /**
   * Test {@link Fp12#squared()}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>Then return {@link Fp12#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#squared()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.squared()"})
  public void testSquared_givenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp12.ZERO, Fp12.ZERO.squared());
  }

  /**
   * Test {@link Fp12#dbl()}.
   *
   * <p>Method under test: {@link Fp12#dbl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.dbl()"})
  public void testDbl() {
    // Arrange, Act and Assert
    assertNull(Fp12.ZERO.dbl());
  }

  /**
   * Test {@link Fp12#mulBy024(Fp2, Fp2, Fp2)}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>When {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@link Fp12#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#mulBy024(Fp2, Fp2, Fp2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.mulBy024(Fp2, Fp2, Fp2)"})
  public void testMulBy024_givenZero_whenNon_residue_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp12.ZERO, Fp12.ZERO.mulBy024(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE));
  }

  /**
   * Test {@link Fp12#add(Fp12)} with {@code Fp12}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>When {@link Fp12#ZERO}.
   *   <li>Then return {@link Fp12#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#add(Fp12)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.add(Fp12)"})
  public void testAddWithFp12_givenZero_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp12.ZERO, Fp12.ZERO.add(Fp12.ZERO));
  }

  /**
   * Test {@link Fp12#mul(Fp12)} with {@code Fp12}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>When {@link Fp12#ZERO}.
   *   <li>Then return {@link Fp12#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#mul(Fp12)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.mul(Fp12)"})
  public void testMulWithFp12_givenZero_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp12.ZERO, Fp12.ZERO.mul(Fp12.ZERO));
  }

  /**
   * Test {@link Fp12#sub(Fp12)} with {@code Fp12}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>When {@link Fp12#ZERO}.
   *   <li>Then return {@link Fp12#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#sub(Fp12)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.sub(Fp12)"})
  public void testSubWithFp12_givenZero_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp12.ZERO, Fp12.ZERO.sub(Fp12.ZERO));
  }

  /**
   * Test {@link Fp12#inverse()}.
   *
   * <ul>
   *   <li>Given {@link Fp12#_1}.
   *   <li>Then return {@link Fp12#_1}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#inverse()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.inverse()"})
  public void testInverse_given_1_thenReturn_1() {
    // Arrange, Act and Assert
    assertEquals(Fp12._1, Fp12._1.inverse());
  }

  /**
   * Test {@link Fp12#negate()}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>Then return {@link Fp12#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#negate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.negate()"})
  public void testNegate_givenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp12.ZERO, Fp12.ZERO.negate());
  }

  /**
   * Test {@link Fp12#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@code null} and b is {@link Fp2#ZERO} and
   *       c is {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isZero()"})
  public void testIsZero_givenFp6WithAIsNullAndBIsZeroAndCIsNon_residue_thenReturnFalse() {
    // Arrange
    Fp6 a = new Fp6(null, Fp2.ZERO, Fp2.NON_RESIDUE);

    // Act and Assert
    assertFalse(new Fp12(a, Fp6.ZERO).isZero());
  }

  /**
   * Test {@link Fp12#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@link Fp2#ZERO} and b is {@link
   *       Fp2#NON_RESIDUE} and c is {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isZero()"})
  public void testIsZero_givenFp6WithAIsZeroAndBIsNon_residueAndCIsNon_residue_thenReturnFalse() {
    // Arrange
    Fp6 a = new Fp6(Fp2.ZERO, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Act and Assert
    assertFalse(new Fp12(a, Fp6.ZERO).isZero());
  }

  /**
   * Test {@link Fp12#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@link Fp2#ZERO} and b is {@code null} and
   *       c is {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isZero()"})
  public void testIsZero_givenFp6WithAIsZeroAndBIsNullAndCIsNon_residue_thenReturnFalse() {
    // Arrange
    Fp6 a = new Fp6(Fp2.ZERO, null, Fp2.NON_RESIDUE);

    // Act and Assert
    assertFalse(new Fp12(a, Fp6.ZERO).isZero());
  }

  /**
   * Test {@link Fp12#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@link Fp2#ZERO} and b is {@link Fp2#ZERO}
   *       and c is {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isZero()"})
  public void testIsZero_givenFp6WithAIsZeroAndBIsZeroAndCIsNon_residue_thenReturnFalse() {
    // Arrange
    Fp6 a = new Fp6(Fp2.ZERO, Fp2.ZERO, Fp2.NON_RESIDUE);

    // Act and Assert
    assertFalse(new Fp12(a, Fp6.ZERO).isZero());
  }

  /**
   * Test {@link Fp12#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@link Fp2#ZERO} and b is {@link Fp2#ZERO}
   *       and c is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isZero()"})
  public void testIsZero_givenFp6WithAIsZeroAndBIsZeroAndCIsNull_thenReturnFalse() {
    // Arrange
    Fp6 a = new Fp6(Fp2.ZERO, Fp2.ZERO, null);

    // Act and Assert
    assertFalse(new Fp12(a, Fp6.ZERO).isZero());
  }

  /**
   * Test {@link Fp12#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp6#Fp6(Fp2, Fp2, Fp2)} with a is {@link Fp2#ZERO} and b is {@link Fp2#ZERO}
   *       and c is {@link Fp2#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isZero()"})
  public void testIsZero_givenFp6WithAIsZeroAndBIsZeroAndCIsZero_thenReturnTrue() {
    // Arrange
    Fp6 a = new Fp6(Fp2.ZERO, Fp2.ZERO, Fp2.ZERO);

    // Act and Assert
    assertTrue(new Fp12(a, Fp6.ZERO).isZero());
  }

  /**
   * Test {@link Fp12#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp12#Fp12(Fp6, Fp6)} with a is {@code null} and b is {@link Fp6#ZERO}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isZero()"})
  public void testIsZero_givenFp12WithAIsNullAndBIsZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Fp12(null, Fp6.ZERO).isZero());
  }

  /**
   * Test {@link Fp12#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp12#Fp12(Fp6, Fp6)} with a is {@link Fp6#ZERO} and b is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isZero()"})
  public void testIsZero_givenFp12WithAIsZeroAndBIsNull_thenReturnFalse() {
    // Arrange
    Fp12 fp12 = new Fp12(Fp6.ZERO, null);

    // Act and Assert
    assertFalse(fp12.isZero());
  }

  /**
   * Test {@link Fp12#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp12#Fp12(Fp6, Fp6)} with a is {@link Fp6#ZERO} and b is {@link Fp6#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isZero()"})
  public void testIsZero_givenFp12WithAIsZeroAndBIsZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Fp12(Fp6.ZERO, Fp6.ZERO).isZero());
  }

  /**
   * Test {@link Fp12#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp12#Fp12(Fp6, Fp6)} with a is {@link Fp6#ZERO} and b is {@link Fp6#_1}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isZero()"})
  public void testIsZero_givenFp12WithAIsZeroAndBIs_1_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Fp12(Fp6.ZERO, Fp6._1).isZero());
  }

  /**
   * Test {@link Fp12#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isZero()"})
  public void testIsZero_givenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Fp12.ZERO.isZero());
  }

  /**
   * Test {@link Fp12#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp12#_1}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isZero()"})
  public void testIsZero_given_1_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Fp12._1.isZero());
  }

  /**
   * Test {@link Fp12#isValid()}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#isValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.isValid()"})
  public void testIsValid_givenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Fp12.ZERO.isValid());
  }

  /**
   * Test {@link Fp12#frobeniusMap(int)}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>When one.
   *   <li>Then return {@link Fp12#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#frobeniusMap(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.frobeniusMap(int)"})
  public void testFrobeniusMap_givenZero_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp12.ZERO, Fp12.ZERO.frobeniusMap(1));
  }

  /**
   * Test {@link Fp12#cyclotomicSquared()}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>Then return {@link Fp12#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#cyclotomicSquared()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.cyclotomicSquared()"})
  public void testCyclotomicSquared_givenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp12.ZERO, Fp12.ZERO.cyclotomicSquared());
  }

  /**
   * Test {@link Fp12#cyclotomicExp(BigInteger)}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>When {@link ECConstants#EIGHT}.
   *   <li>Then return {@link Fp12#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#cyclotomicExp(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.cyclotomicExp(BigInteger)"})
  public void testCyclotomicExp_givenZero_whenEight_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp12.ZERO, Fp12.ZERO.cyclotomicExp(ECConstants.EIGHT));
  }

  /**
   * Test {@link Fp12#unitaryInverse()}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>Then return {@link Fp12#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#unitaryInverse()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.unitaryInverse()"})
  public void testUnitaryInverse_givenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp12.ZERO, Fp12.ZERO.unitaryInverse());
  }

  /**
   * Test {@link Fp12#negExp(BigInteger)}.
   *
   * <ul>
   *   <li>Given {@link Fp12#ZERO}.
   *   <li>When {@link ECConstants#EIGHT}.
   *   <li>Then return {@link Fp12#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#negExp(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp12 Fp12.negExp(BigInteger)"})
  public void testNegExp_givenZero_whenEight_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp12.ZERO, Fp12.ZERO.negExp(ECConstants.EIGHT));
  }

  /**
   * Test {@link Fp12#equals(Object)}, and {@link Fp12#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fp12#equals(Object)}
   *   <li>{@link Fp12#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.equals(Object)", "int Fp12.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Fp12 fp12 = Fp12.ZERO;
    Fp12 fp122 = Fp12.ZERO;

    // Act and Assert
    assertEquals(fp12, fp122);
    assertEquals(fp12.hashCode(), fp122.hashCode());
  }

  /**
   * Test {@link Fp12#equals(Object)}, and {@link Fp12#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fp12#equals(Object)}
   *   <li>{@link Fp12#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.equals(Object)", "int Fp12.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Fp12 fp12 = new Fp12(Fp6.ZERO, Fp6.ZERO);
    Fp12 fp122 = Fp12.ZERO;

    // Act and Assert
    assertEquals(fp12, fp122);
    assertEquals(fp12.hashCode(), fp122.hashCode());
  }

  /**
   * Test {@link Fp12#equals(Object)}, and {@link Fp12#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fp12#equals(Object)}
   *   <li>{@link Fp12#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.equals(Object)", "int Fp12.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Fp12 fp12 = Fp12.ZERO;

    // Act and Assert
    assertEquals(fp12, fp12);
    int expectedHashCodeResult = fp12.hashCode();
    assertEquals(expectedHashCodeResult, fp12.hashCode());
  }

  /**
   * Test {@link Fp12#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.equals(Object)", "int Fp12.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp12._1, Fp12.ZERO);
  }

  /**
   * Test {@link Fp12#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.equals(Object)", "int Fp12.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new Fp12(null, Fp6.ZERO), Fp12.ZERO);
  }

  /**
   * Test {@link Fp12#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.equals(Object)", "int Fp12.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new Fp12(Fp6.ZERO, Fp6._1), Fp12.ZERO);
  }

  /**
   * Test {@link Fp12#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.equals(Object)", "int Fp12.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Fp12 fp12 = new Fp12(Fp6.ZERO, null);

    // Act and Assert
    assertNotEquals(fp12, Fp12.ZERO);
  }

  /**
   * Test {@link Fp12#equals(Object)}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.equals(Object)", "int Fp12.hashCode()"})
  public void testEquals_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Fp12 fp12 = new Fp12(null, Fp6.ZERO);

    // Act and Assert
    assertEquals(fp12, new Fp12(null, Fp6.ZERO));
  }

  /**
   * Test {@link Fp12#equals(Object)}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.equals(Object)", "int Fp12.hashCode()"})
  public void testEquals_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Fp12 fp12 = new Fp12(Fp6.ZERO, null);
    Fp12 fp122 = new Fp12(Fp6.ZERO, null);

    // Act and Assert
    assertEquals(fp12, fp122);
  }

  /**
   * Test {@link Fp12#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.equals(Object)", "int Fp12.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp12.ZERO, null);
  }

  /**
   * Test {@link Fp12#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp12#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp12.equals(Object)", "int Fp12.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp12.ZERO, "Different type to Fp12");
  }
}
