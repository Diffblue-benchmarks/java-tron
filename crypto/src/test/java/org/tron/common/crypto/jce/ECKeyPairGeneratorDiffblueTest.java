package org.tron.common.crypto.jce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi.EC;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ECKeyPairGeneratorDiffblueTest {
  /**
   * Test {@link ECKeyPairGenerator#generateKeyPair()}.
   *
   * <p>Method under test: {@link ECKeyPairGenerator#generateKeyPair()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.security.KeyPair ECKeyPairGenerator.generateKeyPair()"})
  public void testGenerateKeyPair() {
    // Arrange, Act and Assert
    assertFalse(ECKeyPairGenerator.generateKeyPair().getPrivate().isDestroyed());
  }

  /**
   * Test {@link ECKeyPairGenerator#getInstance(Provider, SecureRandom)} with {@code Provider},
   * {@code SecureRandom}.
   *
   * <p>Method under test: {@link ECKeyPairGenerator#getInstance(Provider, SecureRandom)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyPairGenerator ECKeyPairGenerator.getInstance(Provider, SecureRandom)"})
  public void testGetInstanceWithProviderSecureRandom() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();

    // Act
    KeyPairGenerator actualInstance = ECKeyPairGenerator.getInstance(provider, new SecureRandom());

    // Assert
    assertTrue(actualInstance instanceof EC);
    assertEquals(ECKeyPairGenerator.ALGORITHM, actualInstance.getAlgorithm());
    assertSame(provider, actualInstance.getProvider());
  }
}
