package org.tron.common.zksnark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.exception.ZksnarkException;

public class JLibrustzcashDiffblueTest {
  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashZip32XfvkAddress(LibrustzcashParam.Zip32XfvkAddressParams)}
   */
  @Test
  public void testLibrustzcashZip32XfvkAddress() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] xfvk = "AXAXAXAX".getBytes("UTF-8");
    byte[] j = "AXAXAXAX".getBytes("UTF-8");
    byte[] j_ret = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(JLibrustzcash.librustzcashZip32XfvkAddress(
        new LibrustzcashParam.Zip32XfvkAddressParams(xfvk, j, j_ret, "AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashKaAgree(LibrustzcashParam.KaAgreeParams)}
   */
  @Test
  public void testLibrustzcashKaAgree() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashKaAgree(null));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashComputeCm(LibrustzcashParam.ComputeCmParams)}
   */
  @Test
  public void testLibrustzcashComputeCm() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashComputeCm(null));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashComputeNf(LibrustzcashParam.ComputeNfParams)}
   */
  @Test
  public void testLibrustzcashComputeNf() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashComputeNf(null));
  }

  /**
   * Method under test: {@link JLibrustzcash#librustzcashAskToAk(byte[])}
   */
  @Test
  public void testLibrustzcashAskToAk() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertEquals(0, JLibrustzcash.librustzcashAskToAk("AXAXAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Method under test: {@link JLibrustzcash#librustzcashNskToNk(byte[])}
   */
  @Test
  public void testLibrustzcashNskToNk() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertEquals(0, JLibrustzcash.librustzcashNskToNk("AXAXAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Method under test: {@link JLibrustzcash#librustzcashSaplingGenerateR(byte[])}
   */
  @Test
  public void testLibrustzcashSaplingGenerateR() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertEquals(0, JLibrustzcash.librustzcashSaplingGenerateR("AXAXAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashSaplingKaDerivepublic(LibrustzcashParam.KaDerivepublicParams)}
   */
  @Test
  public void testLibrustzcashSaplingKaDerivepublic() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingKaDerivepublic(null));
  }

  /**
   * Method under test: {@link JLibrustzcash#librustzcashSaplingProvingCtxInit()}
   */
  @Test
  public void testLibrustzcashSaplingProvingCtxInit() {
    // Arrange, Act and Assert
    assertEquals(0L, JLibrustzcash.librustzcashSaplingProvingCtxInit());
  }

  /**
   * Method under test: {@link JLibrustzcash#librustzcashCheckDiversifier(byte[])}
   */
  @Test
  public void testLibrustzcashCheckDiversifier() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashCheckDiversifier("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashSaplingSpendProof(LibrustzcashParam.SpendProofParams)}
   */
  @Test
  public void testLibrustzcashSaplingSpendProof() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingSpendProof(null));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashSaplingOutputProof(LibrustzcashParam.OutputProofParams)}
   */
  @Test
  public void testLibrustzcashSaplingOutputProof() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingOutputProof(null));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashSaplingSpendSig(LibrustzcashParam.SpendSigParams)}
   */
  @Test
  public void testLibrustzcashSaplingSpendSig() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingSpendSig(null));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashSaplingBindingSig(LibrustzcashParam.BindingSigParams)}
   */
  @Test
  public void testLibrustzcashSaplingBindingSig() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingBindingSig(null));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashSaplingVerificationCtxInit()}
   */
  @Test
  public void testLibrustzcashSaplingVerificationCtxInit() {
    // Arrange, Act and Assert
    assertEquals(0L, JLibrustzcash.librustzcashSaplingVerificationCtxInit());
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashSaplingCheckSpend(LibrustzcashParam.CheckSpendParams)}
   */
  @Test
  public void testLibrustzcashSaplingCheckSpend() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingCheckSpend(null));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashSaplingCheckOutput(LibrustzcashParam.CheckOutputParams)}
   */
  @Test
  public void testLibrustzcashSaplingCheckOutput() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingCheckOutput(null));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashSaplingFinalCheck(LibrustzcashParam.FinalCheckParams)}
   */
  @Test
  public void testLibrustzcashSaplingFinalCheck() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingFinalCheck(null));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashSaplingCheckSpendNew(LibrustzcashParam.CheckSpendNewParams)}
   */
  @Test
  public void testLibrustzcashSaplingCheckSpendNew() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingCheckSpendNew(null));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashSaplingCheckOutputNew(LibrustzcashParam.CheckOutputNewParams)}
   */
  @Test
  public void testLibrustzcashSaplingCheckOutputNew() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingCheckOutputNew(null));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashSaplingFinalCheckNew(LibrustzcashParam.FinalCheckNewParams)}
   */
  @Test
  public void testLibrustzcashSaplingFinalCheckNew() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashSaplingFinalCheckNew(null));
  }

  /**
   * Method under test:
   * {@link JLibrustzcash#librustzcashIvkToPkd(LibrustzcashParam.IvkToPkdParams)}
   */
  @Test
  public void testLibrustzcashIvkToPkd() {
    // Arrange, Act and Assert
    assertTrue(JLibrustzcash.librustzcashIvkToPkd(null));
  }

  /**
   * Method under test: {@link JLibrustzcash#isOpenZen()}
   */
  @Test
  public void testIsOpenZen() {
    // Arrange, Act and Assert
    assertFalse(JLibrustzcash.isOpenZen());
  }
}
