package org.tron.common.crypto.jce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.Provider;
import javax.crypto.KeyAgreement;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ECKeyAgreementDiffblueTest {
  /**
   * Test {@link ECKeyAgreement#getInstance()}.
   * <p>
   * Method under test: {@link ECKeyAgreement#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyAgreement ECKeyAgreement.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    KeyAgreement actualInstance = ECKeyAgreement.getInstance();

    // Assert
    Provider provider = actualInstance.getProvider();
    assertEquals(49, provider.size());
    assertEquals("Software", provider.get("Signature.SHA224withECDSA ImplementedIn"));
    assertEquals("Software", provider.get("Signature.SHA256withECDSA ImplementedIn"));
    assertEquals("SunEC", provider.get("Provider.id name"));
    assertEquals("java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey",
        provider.get("KeyAgreement.ECDH SupportedKeyClasses"));
    assertEquals("java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey",
        provider.get("Signature.NONEwithECDSA SupportedKeyClasses"));
    assertEquals("sun.security.util.ECParameters", provider.get("AlgorithmParameters.EC"));
    assertEquals(ECKeyAgreement.ALGORITHM, actualInstance.getAlgorithm());
  }

  /**
   * Test {@link ECKeyAgreement#getInstance(Provider)} with {@code Provider}.
   * <p>
   * Method under test: {@link ECKeyAgreement#getInstance(Provider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyAgreement ECKeyAgreement.getInstance(Provider)"})
  public void testGetInstanceWithProvider() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();

    // Act
    KeyAgreement actualInstance = ECKeyAgreement.getInstance(provider);

    // Assert
    assertEquals(ECKeyAgreement.ALGORITHM, actualInstance.getAlgorithm());
    assertSame(provider, actualInstance.getProvider());
  }
}
