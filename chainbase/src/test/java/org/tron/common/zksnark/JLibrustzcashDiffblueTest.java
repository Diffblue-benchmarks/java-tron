package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.zksnark.LibrustzcashParam.BindingSigParams;
import org.tron.common.zksnark.LibrustzcashParam.CheckOutputNewParams;
import org.tron.common.zksnark.LibrustzcashParam.CheckOutputParams;
import org.tron.common.zksnark.LibrustzcashParam.CheckSpendNewParams;
import org.tron.common.zksnark.LibrustzcashParam.CheckSpendParams;
import org.tron.common.zksnark.LibrustzcashParam.ComputeCmParams;
import org.tron.common.zksnark.LibrustzcashParam.ComputeNfParams;
import org.tron.common.zksnark.LibrustzcashParam.FinalCheckNewParams;
import org.tron.common.zksnark.LibrustzcashParam.FinalCheckParams;
import org.tron.common.zksnark.LibrustzcashParam.IvkToPkdParams;
import org.tron.common.zksnark.LibrustzcashParam.KaAgreeParams;
import org.tron.common.zksnark.LibrustzcashParam.KaDerivepublicParams;
import org.tron.common.zksnark.LibrustzcashParam.OutputProofParams;
import org.tron.common.zksnark.LibrustzcashParam.SpendProofParams;
import org.tron.common.zksnark.LibrustzcashParam.SpendSigParams;
import org.tron.common.zksnark.LibrustzcashParam.Zip32XfvkAddressParams;
import org.tron.core.exception.ZksnarkException;

public class JLibrustzcashDiffblueTest {
  /**
   * Test {@link JLibrustzcash#librustzcashZip32XfvkAddress(Zip32XfvkAddressParams)}.
   *
   * <p>Method under test: {@link
   * JLibrustzcash#librustzcashZip32XfvkAddress(Zip32XfvkAddressParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashZip32XfvkAddress(Zip32XfvkAddressParams)"})
  public void testLibrustzcashZip32XfvkAddress()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    Zip32XfvkAddressParams params =
        new Zip32XfvkAddressParams(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(JLibrustzcash.librustzcashZip32XfvkAddress(params));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashKaAgree(KaAgreeParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashKaAgree(KaAgreeParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashKaAgree(KaAgreeParams)"})
  public void testLibrustzcashKaAgree_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashKaAgree(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashComputeCm(ComputeCmParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashComputeCm(ComputeCmParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashComputeCm(ComputeCmParams)"})
  public void testLibrustzcashComputeCm_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashComputeCm(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashComputeNf(ComputeNfParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashComputeNf(ComputeNfParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashComputeNf(ComputeNfParams)"})
  public void testLibrustzcashComputeNf_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashComputeNf(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashAskToAk(byte[])}.
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashAskToAk(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JLibrustzcash.librustzcashAskToAk(byte[])"})
  public void testLibrustzcashAskToAk() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {}, JLibrustzcash.librustzcashAskToAk("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashNskToNk(byte[])}.
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashNskToNk(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JLibrustzcash.librustzcashNskToNk(byte[])"})
  public void testLibrustzcashNskToNk() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {}, JLibrustzcash.librustzcashNskToNk("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingGenerateR(byte[])}.
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashSaplingGenerateR(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JLibrustzcash.librustzcashSaplingGenerateR(byte[])"})
  public void testLibrustzcashSaplingGenerateR()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {}, JLibrustzcash.librustzcashSaplingGenerateR("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingKaDerivepublic(KaDerivepublicParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JLibrustzcash#librustzcashSaplingKaDerivepublic(KaDerivepublicParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JLibrustzcash.librustzcashSaplingKaDerivepublic(KaDerivepublicParams)"
  })
  public void testLibrustzcashSaplingKaDerivepublic_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingKaDerivepublic(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingProvingCtxInit()}.
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashSaplingProvingCtxInit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JLibrustzcash.librustzcashSaplingProvingCtxInit()"})
  public void testLibrustzcashSaplingProvingCtxInit() {
    // Arrange, Act and Assert
    assertEquals(0L, JLibrustzcash.librustzcashSaplingProvingCtxInit());
  }

  /**
   * Test {@link JLibrustzcash#librustzcashCheckDiversifier(byte[])}.
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashCheckDiversifier(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashCheckDiversifier(byte[])"})
  public void testLibrustzcashCheckDiversifier()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashCheckDiversifier("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingSpendProof(SpendProofParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashSaplingSpendProof(SpendProofParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashSaplingSpendProof(SpendProofParams)"})
  public void testLibrustzcashSaplingSpendProof_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingSpendProof(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingOutputProof(OutputProofParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashSaplingOutputProof(OutputProofParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashSaplingOutputProof(OutputProofParams)"})
  public void testLibrustzcashSaplingOutputProof_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingOutputProof(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingSpendSig(SpendSigParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashSaplingSpendSig(SpendSigParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashSaplingSpendSig(SpendSigParams)"})
  public void testLibrustzcashSaplingSpendSig_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingSpendSig(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingBindingSig(BindingSigParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashSaplingBindingSig(BindingSigParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashSaplingBindingSig(BindingSigParams)"})
  public void testLibrustzcashSaplingBindingSig_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingBindingSig(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingVerificationCtxInit()}.
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashSaplingVerificationCtxInit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JLibrustzcash.librustzcashSaplingVerificationCtxInit()"})
  public void testLibrustzcashSaplingVerificationCtxInit() {
    // Arrange, Act and Assert
    assertEquals(0L, JLibrustzcash.librustzcashSaplingVerificationCtxInit());
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingCheckSpend(CheckSpendParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashSaplingCheckSpend(CheckSpendParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashSaplingCheckSpend(CheckSpendParams)"})
  public void testLibrustzcashSaplingCheckSpend_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingCheckSpend(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingCheckOutput(CheckOutputParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashSaplingCheckOutput(CheckOutputParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashSaplingCheckOutput(CheckOutputParams)"})
  public void testLibrustzcashSaplingCheckOutput_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingCheckOutput(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingFinalCheck(FinalCheckParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashSaplingFinalCheck(FinalCheckParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashSaplingFinalCheck(FinalCheckParams)"})
  public void testLibrustzcashSaplingFinalCheck_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingFinalCheck(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingCheckSpendNew(CheckSpendNewParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JLibrustzcash#librustzcashSaplingCheckSpendNew(CheckSpendNewParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashSaplingCheckSpendNew(CheckSpendNewParams)"})
  public void testLibrustzcashSaplingCheckSpendNew_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingCheckSpendNew(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingCheckOutputNew(CheckOutputNewParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JLibrustzcash#librustzcashSaplingCheckOutputNew(CheckOutputNewParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JLibrustzcash.librustzcashSaplingCheckOutputNew(CheckOutputNewParams)"
  })
  public void testLibrustzcashSaplingCheckOutputNew_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingCheckOutputNew(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashSaplingFinalCheckNew(FinalCheckNewParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JLibrustzcash#librustzcashSaplingFinalCheckNew(FinalCheckNewParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashSaplingFinalCheckNew(FinalCheckNewParams)"})
  public void testLibrustzcashSaplingFinalCheckNew_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingFinalCheckNew(null));
  }

  /**
   * Test {@link JLibrustzcash#librustzcashIvkToPkd(IvkToPkdParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JLibrustzcash#librustzcashIvkToPkd(IvkToPkdParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.librustzcashIvkToPkd(IvkToPkdParams)"})
  public void testLibrustzcashIvkToPkd_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashIvkToPkd(null));
  }

  /**
   * Test {@link JLibrustzcash#isOpenZen()}.
   *
   * <p>Method under test: {@link JLibrustzcash#isOpenZen()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JLibrustzcash.isOpenZen()"})
  public void testIsOpenZen() {
    // Arrange, Act and Assert
    assertFalse(JLibrustzcash.isOpenZen());
  }
}
