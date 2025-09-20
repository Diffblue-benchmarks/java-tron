package org.tron.common.crypto.jce;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.Provider;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TronCastleProviderDiffblueTest {
  /**
   * Test {@link TronCastleProvider#getInstance()}.
   *
   * <p>Method under test: {@link TronCastleProvider#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Provider TronCastleProvider.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    Provider actualInstance = TronCastleProvider.getInstance();

    // Assert
    assertEquals(2946, actualInstance.size());
    assertEquals("HMACSkein-256-224", actualInstance.get("Alg.Alias.Mac.HMAC/Skein-256-224"));
    assertEquals(
        "PBEWITHSHAAND192BITAES-CBC-BC",
        actualInstance.get("Alg.Alias.Cipher.1.3.6.1.4.1.22554.1.1.2.1.22"));
    assertEquals("PSS", actualInstance.get("Alg.Alias.AlgorithmParameters.SHA512withRSA/PSS"));
    assertEquals("RC2WRAP", actualInstance.get("Alg.Alias.Cipher.1.2.840.113549.1.9.16.3.7"));
    assertEquals("SHA-256", actualInstance.get("Alg.Alias.MessageDigest.SHA256"));
    assertEquals("SHA256WITHDSA", actualInstance.get("Alg.Alias.Signature.SHA256/DSA"));
    assertEquals(
        "SHA3-224WITHPLAIN-ECDSA",
        actualInstance.get("Alg.Alias.Signature.SHA3-224withPLAIN-ECDSA"));
    assertEquals(
        "SHA384WITHRSAANDMGF1", actualInstance.get("Alg.Alias.Signature.SHA384WithRSAAndMGF1"));
    assertEquals("SIPHASH", actualInstance.get("Alg.Alias.KeyGenerator.SIPHASH-2-4"));
    assertEquals(
        "org.bouncycastle.jcajce.provider.asymmetric.elgamal.CipherSpi$NoPadding",
        actualInstance.get("Cipher.ElGamal"));
    assertEquals(
        "org.bouncycastle.jcajce.provider.symmetric.ARIA$RFC3211Wrap",
        actualInstance.get("Cipher.ARIARFC3211WRAP"));
  }
}
