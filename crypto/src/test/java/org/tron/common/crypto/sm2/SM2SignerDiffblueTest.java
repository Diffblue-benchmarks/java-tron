package org.tron.common.crypto.sm2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithID;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SM2SignerDiffblueTest {
  /**
   * Test {@link SM2Signer#init(boolean, CipherParameters)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#init(boolean, CipherParameters)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SM2Signer.init(boolean, CipherParameters)"})
  public void testInit_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    SM2Signer sm2Signer = new SM2Signer();

    ECKeyParameters ecKeyParameters = mock(ECKeyParameters.class);
    when(ecKeyParameters.getParameters()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> sm2Signer.init(true, new ParametersWithRandom(ecKeyParameters)));
    verify(ecKeyParameters).getParameters();
  }

  /**
   * Test {@link SM2Signer#init(boolean, CipherParameters)}.
   *
   * <ul>
   *   <li>When {@link ParametersWithID#ParametersWithID(CipherParameters, byte[])} with {@link
   *       ParametersWithRandom#ParametersWithRandom(CipherParameters)} and {@code AXAXAXAX} Bytes
   *       is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#init(boolean, CipherParameters)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SM2Signer.init(boolean, CipherParameters)"})
  public void testInit_whenParametersWithIDWithParametersWithRandomAndAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signer sm2Signer = new SM2Signer();

    ECKeyParameters ecKeyParameters = mock(ECKeyParameters.class);
    when(ecKeyParameters.getParameters()).thenThrow(new IllegalArgumentException());
    ParametersWithRandom parametersWithRandom = new ParametersWithRandom(ecKeyParameters);
    ParametersWithID param =
        new ParametersWithID(parametersWithRandom, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> sm2Signer.init(true, param));
    verify(ecKeyParameters).getParameters();
  }

  /**
   * Test {@link SM2Signer#generateHashSignature(byte[])}.
   *
   * <p>Method under test: {@link SM2Signer#generateHashSignature(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger[] SM2Signer.generateHashSignature(byte[])"})
  public void testGenerateHashSignature() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new SM2Signer().generateHashSignature("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2Signer#createBasePointMultiplier()}.
   *
   * <p>Method under test: {@link SM2Signer#createBasePointMultiplier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bouncycastle.math.ec.ECMultiplier SM2Signer.createBasePointMultiplier()"})
  public void testCreateBasePointMultiplier() {
    // Arrange, Act and Assert
    assertTrue(new SM2Signer().createBasePointMultiplier() instanceof FixedPointCombMultiplier);
  }

  /**
   * Test {@link SM2Signer#calculateE(byte[])}.
   *
   * <p>Method under test: {@link SM2Signer#calculateE(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger SM2Signer.calculateE(byte[])"})
  public void testCalculateE() throws UnsupportedEncodingException {
    // Arrange and Act
    BigInteger actualCalculateEResult = new SM2Signer().calculateE("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4708585257725083992", actualCalculateEResult.toString());
    assertEquals(1, actualCalculateEResult.signum());
    assertEquals(3, actualCalculateEResult.getLowestSetBit());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, actualCalculateEResult.toByteArray());
  }

  /**
   * Test new {@link SM2Signer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SM2Signer}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SM2Signer.<init>()"})
  public void testNewSM2Signer() {
    // Arrange, Act and Assert
    assertTrue(new SM2Signer().createBasePointMultiplier() instanceof FixedPointCombMultiplier);
  }
}
