package org.tron.common.crypto.jce;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigInteger;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ECAlgorithmParametersDiffblueTest {
  /**
   * Test {@link ECAlgorithmParameters#getParameterSpec()}.
   *
   * <p>Method under test: {@link ECAlgorithmParameters#getParameterSpec()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECParameterSpec ECAlgorithmParameters.getParameterSpec()"})
  public void testGetParameterSpec() {
    // Arrange and Act
    ECParameterSpec actualParameterSpec = ECAlgorithmParameters.getParameterSpec();

    // Assert
    EllipticCurve curve = actualParameterSpec.getCurve();
    assertTrue(curve.getField() instanceof ECFieldFp);
    BigInteger order = actualParameterSpec.getOrder();
    assertEquals(
        "115792089237316195423570985008687907852837564279074904382605163141518161494337",
        order.toString());
    assertNull(curve.getSeed());
    assertEquals(0, order.getLowestSetBit());
    assertEquals(1, order.signum());
    assertEquals(1, actualParameterSpec.getCofactor());
    assertArrayEquals(
        new byte[] {
          0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -70, -82, -36, -26,
          -81, 'H', -96, ';', -65, -46, '^', -116, -48, '6', 'A', 'A'
        },
        order.toByteArray());
  }

  /**
   * Test {@link ECAlgorithmParameters#getASN1Encoding()}.
   *
   * <p>Method under test: {@link ECAlgorithmParameters#getASN1Encoding()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECAlgorithmParameters.getASN1Encoding()"})
  public void testGetASN1Encoding() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {6, 5, '+', -127, 4, 0, '\n'}, ECAlgorithmParameters.getASN1Encoding());
  }
}
