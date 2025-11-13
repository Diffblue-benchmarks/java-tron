package org.tron.common.crypto.sm2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithID;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.crypto.ECKey;

@RunWith(MockitoJUnitRunner.class)
public class SM2SignerDiffblueTest {
  @Mock private ECDomainParameters eCDomainParameters;

  @InjectMocks private SM2Signer sM2Signer;

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
   * Test {@link SM2Signer#generateSignature(byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#generateSignature(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger[] SM2Signer.generateSignature(byte[])"})
  public void testGenerateSignature_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    when(eCDomainParameters.getCurve()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> sM2Signer.generateSignature("AXAXAXAX".getBytes("UTF-8")));
    verify(eCDomainParameters).getCurve();
  }

  /**
   * Test {@link SM2Signer#generateSM3Hash(byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#generateSM3Hash(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2Signer.generateSM3Hash(byte[])"})
  public void testGenerateSM3Hash_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    when(eCDomainParameters.getCurve()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> sM2Signer.generateSM3Hash("AXAXAXAX".getBytes("UTF-8")));
    verify(eCDomainParameters).getCurve();
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
   * Test {@link SM2Signer#verifySignature(byte[], BigInteger, BigInteger, String)}.
   *
   * <ul>
   *   <li>Given {@link ECDomainParameters} {@link ECDomainParameters#getN()} return {@link
   *       ECConstants#EIGHT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#verifySignature(byte[], BigInteger, BigInteger, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signer.verifySignature(byte[], BigInteger, BigInteger, String)"})
  public void testVerifySignature_givenECDomainParametersGetNReturnEight_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    when(eCDomainParameters.getN()).thenReturn(ECConstants.EIGHT);

    // Act
    boolean actualVerifySignatureResult =
        sM2Signer.verifySignature(
            "AXAXAXAX".getBytes("UTF-8"), ECConstants.EIGHT, ECConstants.EIGHT, "User ID");

    // Assert
    verify(eCDomainParameters).getN();
    assertFalse(actualVerifySignatureResult);
  }

  /**
   * Test {@link SM2Signer#verifySignature(byte[], BigInteger, BigInteger, String)}.
   *
   * <ul>
   *   <li>Given {@link ECDomainParameters} {@link ECDomainParameters#getN()} return {@link
   *       ECKey#HALF_CURVE_ORDER}.
   *   <li>When {@link ECConstants#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#verifySignature(byte[], BigInteger, BigInteger, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signer.verifySignature(byte[], BigInteger, BigInteger, String)"})
  public void testVerifySignature_givenECDomainParametersGetNReturnHalf_curve_order_whenZero()
      throws UnsupportedEncodingException {
    // Arrange
    when(eCDomainParameters.getN()).thenReturn(ECKey.HALF_CURVE_ORDER);

    // Act
    boolean actualVerifySignatureResult =
        sM2Signer.verifySignature(
            "AXAXAXAX".getBytes("UTF-8"), ECConstants.EIGHT, ECConstants.ZERO, "User ID");

    // Assert
    verify(eCDomainParameters).getN();
    assertFalse(actualVerifySignatureResult);
  }

  /**
   * Test {@link SM2Signer#verifySignature(byte[], BigInteger, BigInteger, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#verifySignature(byte[], BigInteger, BigInteger, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signer.verifySignature(byte[], BigInteger, BigInteger, String)"})
  public void testVerifySignature_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    when(eCDomainParameters.getN()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            sM2Signer.verifySignature(
                "AXAXAXAX".getBytes("UTF-8"), ECConstants.EIGHT, ECConstants.EIGHT, "User ID"));
    verify(eCDomainParameters).getN();
  }

  /**
   * Test {@link SM2Signer#verifySignature(byte[], BigInteger, BigInteger, String)}.
   *
   * <ul>
   *   <li>When {@link ECConstants#FOUR}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#verifySignature(byte[], BigInteger, BigInteger, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signer.verifySignature(byte[], BigInteger, BigInteger, String)"})
  public void testVerifySignature_whenFour_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    when(eCDomainParameters.getN()).thenReturn(ECConstants.EIGHT);

    // Act
    boolean actualVerifySignatureResult =
        sM2Signer.verifySignature(
            "AXAXAXAX".getBytes("UTF-8"), ECConstants.FOUR, ECConstants.EIGHT, "User ID");

    // Assert
    verify(eCDomainParameters).getN();
    assertFalse(actualVerifySignatureResult);
  }

  /**
   * Test {@link SM2Signer#verifySignature(byte[], BigInteger, BigInteger, String)}.
   *
   * <ul>
   *   <li>When {@link ECConstants#ZERO}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#verifySignature(byte[], BigInteger, BigInteger, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signer.verifySignature(byte[], BigInteger, BigInteger, String)"})
  public void testVerifySignature_whenZero_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    when(eCDomainParameters.getN()).thenReturn(ECConstants.EIGHT);

    // Act
    boolean actualVerifySignatureResult =
        sM2Signer.verifySignature(
            "AXAXAXAX".getBytes("UTF-8"), ECConstants.ZERO, ECConstants.EIGHT, "User ID");

    // Assert
    verify(eCDomainParameters).getN();
    assertFalse(actualVerifySignatureResult);
  }

  /**
   * Test {@link SM2Signer#verifyHashSignature(byte[], BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>Given {@link ECDomainParameters} {@link ECDomainParameters#getN()} return {@link
   *       ECConstants#EIGHT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#verifyHashSignature(byte[], BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signer.verifyHashSignature(byte[], BigInteger, BigInteger)"})
  public void testVerifyHashSignature_givenECDomainParametersGetNReturnEight_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    when(eCDomainParameters.getN()).thenReturn(ECConstants.EIGHT);

    // Act
    boolean actualVerifyHashSignatureResult =
        sM2Signer.verifyHashSignature(
            "AXAXAXAX".getBytes("UTF-8"), ECConstants.EIGHT, ECConstants.EIGHT);

    // Assert
    verify(eCDomainParameters).getN();
    assertFalse(actualVerifyHashSignatureResult);
  }

  /**
   * Test {@link SM2Signer#verifyHashSignature(byte[], BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>Given {@link ECDomainParameters} {@link ECDomainParameters#getN()} return {@link
   *       ECKey#HALF_CURVE_ORDER}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#verifyHashSignature(byte[], BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signer.verifyHashSignature(byte[], BigInteger, BigInteger)"})
  public void testVerifyHashSignature_givenECDomainParametersGetNReturnHalf_curve_order()
      throws UnsupportedEncodingException {
    // Arrange
    when(eCDomainParameters.getN()).thenReturn(ECKey.HALF_CURVE_ORDER);

    // Act
    boolean actualVerifyHashSignatureResult =
        sM2Signer.verifyHashSignature(
            "AXAXAXAX".getBytes("UTF-8"), ECConstants.EIGHT, ECConstants.ZERO);

    // Assert
    verify(eCDomainParameters).getN();
    assertFalse(actualVerifyHashSignatureResult);
  }

  /**
   * Test {@link SM2Signer#verifyHashSignature(byte[], BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#verifyHashSignature(byte[], BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signer.verifyHashSignature(byte[], BigInteger, BigInteger)"})
  public void testVerifyHashSignature_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    when(eCDomainParameters.getN()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            sM2Signer.verifyHashSignature(
                "AXAXAXAX".getBytes("UTF-8"), ECConstants.EIGHT, ECConstants.EIGHT));
    verify(eCDomainParameters).getN();
  }

  /**
   * Test {@link SM2Signer#verifyHashSignature(byte[], BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When {@link ECConstants#FOUR}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#verifyHashSignature(byte[], BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signer.verifyHashSignature(byte[], BigInteger, BigInteger)"})
  public void testVerifyHashSignature_whenFour_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    when(eCDomainParameters.getN()).thenReturn(ECConstants.EIGHT);

    // Act
    boolean actualVerifyHashSignatureResult =
        sM2Signer.verifyHashSignature(
            "AXAXAXAX".getBytes("UTF-8"), ECConstants.FOUR, ECConstants.EIGHT);

    // Assert
    verify(eCDomainParameters).getN();
    assertFalse(actualVerifyHashSignatureResult);
  }

  /**
   * Test {@link SM2Signer#verifyHashSignature(byte[], BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When {@link ECConstants#ZERO}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signer#verifyHashSignature(byte[], BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signer.verifyHashSignature(byte[], BigInteger, BigInteger)"})
  public void testVerifyHashSignature_whenZero_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    when(eCDomainParameters.getN()).thenReturn(ECConstants.EIGHT);

    // Act
    boolean actualVerifyHashSignatureResult =
        sM2Signer.verifyHashSignature(
            "AXAXAXAX".getBytes("UTF-8"), ECConstants.ZERO, ECConstants.EIGHT);

    // Assert
    verify(eCDomainParameters).getN();
    assertFalse(actualVerifyHashSignatureResult);
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
    assertTrue(sM2Signer.createBasePointMultiplier() instanceof FixedPointCombMultiplier);
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
