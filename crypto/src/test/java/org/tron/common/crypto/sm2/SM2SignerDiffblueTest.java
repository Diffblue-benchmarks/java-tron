package org.tron.common.crypto.sm2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SM2SignerDiffblueTest {
  /**
   * Test {@link SM2Signer#generateHashSignature(byte[])}.
   * <p>
   * Method under test: {@link SM2Signer#generateHashSignature(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigInteger[] SM2Signer.generateHashSignature(byte[])"})
  public void testGenerateHashSignature() throws UnsupportedEncodingException {
    // Arrange
    SM2Signer sm2Signer = new SM2Signer();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> sm2Signer.generateHashSignature("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2Signer#calculateE(byte[])}.
   * <p>
   * Method under test: {@link SM2Signer#calculateE(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigInteger SM2Signer.calculateE(byte[])"})
  public void testCalculateE() throws UnsupportedEncodingException {
    // Arrange
    SM2Signer sm2Signer = new SM2Signer();

    // Act
    BigInteger actualCalculateEResult = sm2Signer.calculateE("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4708585257725083992", actualCalculateEResult.toString());
    assertEquals(1, actualCalculateEResult.signum());
    assertEquals(3, actualCalculateEResult.getLowestSetBit());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, actualCalculateEResult.toByteArray());
  }

  /**
   * Test new {@link SM2Signer} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SM2Signer}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SM2Signer.<init>()"})
  public void testNewSM2Signer() {
    // Arrange, Act and Assert
    assertTrue((new SM2Signer()).createBasePointMultiplier() instanceof FixedPointCombMultiplier);
  }
}
