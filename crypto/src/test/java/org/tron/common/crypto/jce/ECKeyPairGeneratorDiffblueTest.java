package org.tron.common.crypto.jce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;

public class ECKeyPairGeneratorDiffblueTest {
  /**
   * Method under test: {@link ECKeyPairGenerator#generateKeyPair()}
   */
  @Test
  public void testGenerateKeyPair() {
    // Arrange, Act and Assert
    assertFalse(ECKeyPairGenerator.generateKeyPair().getPrivate().isDestroyed());
  }

  /**
   * Method under test:
   * {@link ECKeyPairGenerator#getInstance(Provider, SecureRandom)}
   */
  @Test
  public void testGetInstance() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();

    // Act
    KeyPairGenerator actualInstance = ECKeyPairGenerator.getInstance(provider, new SecureRandom());

    // Assert
    assertTrue(actualInstance instanceof KeyPairGeneratorSpi.EC);
    assertEquals(ECKeyPairGenerator.ALGORITHM, actualInstance.getAlgorithm());
    assertSame(provider, actualInstance.getProvider());
  }
}
