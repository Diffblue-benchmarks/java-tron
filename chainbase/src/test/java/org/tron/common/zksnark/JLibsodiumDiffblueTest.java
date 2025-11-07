package org.tron.common.zksnark;

import static org.junit.Assert.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.exception.ZksnarkException;

public class JLibsodiumDiffblueTest {
  /**
   * Method under test:
   * {@link JLibsodium#cryptoGenerichashBlake2bInitSaltPersonal(JLibsodiumParam.Blake2bInitSaltPersonalParams)}
   */
  @Test
  public void testCryptoGenerichashBlake2bInitSaltPersonal() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    byte[] salt = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, JLibsodium.cryptoGenerichashBlake2bInitSaltPersonal(
        new JLibsodiumParam.Blake2bInitSaltPersonalParams(1L, key, 3, 3, salt, "AXAXAXAXAXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test:
   * {@link JLibsodium#cryptoGenerichashBlake2bUpdate(JLibsodiumParam.Blake2bUpdateParams)}
   */
  @Test
  public void testCryptoGenerichashBlake2bUpdate() {
    // Arrange, Act and Assert
    assertEquals(0, JLibsodium.cryptoGenerichashBlake2bUpdate(null));
  }

  /**
   * Method under test:
   * {@link JLibsodium#cryptoGenerichashBlake2bFinal(JLibsodiumParam.Blake2bFinalParams)}
   */
  @Test
  public void testCryptoGenerichashBlake2bFinal() {
    // Arrange, Act and Assert
    assertEquals(0, JLibsodium.cryptoGenerichashBlake2bFinal(null));
  }

  /**
   * Method under test:
   * {@link JLibsodium#cryptoGenerichashBlack2bSaltPersonal(JLibsodiumParam.Black2bSaltPersonalParams)}
   */
  @Test
  public void testCryptoGenerichashBlack2bSaltPersonal() {
    // Arrange, Act and Assert
    assertEquals(0, JLibsodium.cryptoGenerichashBlack2bSaltPersonal(null));
  }

  /**
   * Method under test:
   * {@link JLibsodium#cryptoAeadChacha20poly1305IetfDecrypt(JLibsodiumParam.Chacha20poly1305IetfDecryptParams)}
   */
  @Test
  public void testCryptoAeadChacha20poly1305IetfDecrypt() {
    // Arrange, Act and Assert
    assertEquals(0, JLibsodium.cryptoAeadChacha20poly1305IetfDecrypt(null));
  }

  /**
   * Method under test:
   * {@link JLibsodium#cryptoAeadChacha20Poly1305IetfEncrypt(JLibsodiumParam.Chacha20Poly1305IetfEncryptParams)}
   */
  @Test
  public void testCryptoAeadChacha20Poly1305IetfEncrypt() {
    // Arrange, Act and Assert
    assertEquals(0, JLibsodium.cryptoAeadChacha20Poly1305IetfEncrypt(null));
  }

  /**
   * Method under test: {@link JLibsodium#initState()}
   */
  @Test
  public void testInitState() {
    // Arrange, Act and Assert
    assertEquals(0L, JLibsodium.initState());
  }
}
