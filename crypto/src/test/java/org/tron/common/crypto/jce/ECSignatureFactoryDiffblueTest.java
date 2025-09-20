package org.tron.common.crypto.jce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.Provider;
import java.security.Signature;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ECSignatureFactoryDiffblueTest {
  /**
   * Test {@link ECSignatureFactory#getRawInstance()}.
   *
   * <p>Method under test: {@link ECSignatureFactory#getRawInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Signature ECSignatureFactory.getRawInstance()"})
  public void testGetRawInstance() {
    // Arrange and Act
    Signature actualRawInstance = ECSignatureFactory.getRawInstance();

    // Assert
    Provider provider = actualRawInstance.getProvider();
    assertEquals(49, provider.size());
    assertEquals("Software", provider.get("Signature.SHA224withECDSA ImplementedIn"));
    assertEquals("Software", provider.get("Signature.SHA256withECDSA ImplementedIn"));
    assertEquals("SunEC", provider.get("Provider.id name"));
    assertEquals(
        "java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey",
        provider.get("KeyAgreement.ECDH SupportedKeyClasses"));
    assertEquals(
        "java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey",
        provider.get("Signature.NONEwithECDSA SupportedKeyClasses"));
    assertEquals("sun.security.util.ECParameters", provider.get("AlgorithmParameters.EC"));
    assertNull(actualRawInstance.getParameters());
    assertEquals(ECSignatureFactory.RAW_ALGORITHM, actualRawInstance.getAlgorithm());
  }

  /**
   * Test {@link ECSignatureFactory#getRawInstance(Provider)} with {@code Provider}.
   *
   * <p>Method under test: {@link ECSignatureFactory#getRawInstance(Provider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Signature ECSignatureFactory.getRawInstance(Provider)"})
  public void testGetRawInstanceWithProvider() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();

    // Act
    Signature actualRawInstance = ECSignatureFactory.getRawInstance(provider);

    // Assert
    assertNull(actualRawInstance.getParameters());
    assertEquals(ECSignatureFactory.RAW_ALGORITHM, actualRawInstance.getAlgorithm());
    assertSame(provider, actualRawInstance.getProvider());
  }
}
