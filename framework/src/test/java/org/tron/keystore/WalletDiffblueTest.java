package org.tron.keystore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.tron.core.exception.CipherException;

public class WalletDiffblueTest {
  /**
   * Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  public void testDecrypt() throws CipherException {
    // Arrange
    WalletFile.CipherParams cipherparams = new WalletFile.CipherParams();
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setCrypto(crypto);
    walletFile.setId("42");
    walletFile.setVersion(1);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.decrypt("iloveyou", walletFile));
  }

  /**
   * Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  public void testDecrypt2() throws CipherException {
    // Arrange
    WalletFile.CipherParams cipherparams = new WalletFile.CipherParams();
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setCrypto(crypto);
    walletFile.setId("42");
    walletFile.setVersion(3);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.decrypt("iloveyou", walletFile));
  }

  /**
   * Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  public void testDecrypt3() throws CipherException {
    // Arrange
    WalletFile.CipherParams cipherparams = new WalletFile.CipherParams();
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("aes-128-ctr");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setCrypto(crypto);
    walletFile.setId("42");
    walletFile.setVersion(3);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.decrypt("iloveyou", walletFile));
  }

  /**
   * Method under test: {@link Wallet#validate(WalletFile)}
   */
  @Test
  public void testValidate() throws CipherException {
    // Arrange
    WalletFile.CipherParams cipherparams = new WalletFile.CipherParams();
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setCrypto(crypto);
    walletFile.setId("42");
    walletFile.setVersion(1);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.validate(walletFile));
  }

  /**
   * Method under test: {@link Wallet#validate(WalletFile)}
   */
  @Test
  public void testValidate2() throws CipherException {
    // Arrange
    WalletFile.CipherParams cipherparams = new WalletFile.CipherParams();
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setCrypto(crypto);
    walletFile.setId("42");
    walletFile.setVersion(3);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.validate(walletFile));
  }

  /**
   * Method under test: {@link Wallet#validate(WalletFile)}
   */
  @Test
  public void testValidate3() throws CipherException {
    // Arrange
    WalletFile.CipherParams cipherparams = new WalletFile.CipherParams();
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("aes-128-ctr");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setCrypto(crypto);
    walletFile.setId("42");
    walletFile.setVersion(3);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.validate(walletFile));
  }

  /**
   * Method under test: {@link Wallet#generateRandomBytes(int)}
   */
  @Test
  public void testGenerateRandomBytes() {
    // Arrange, Act and Assert
    assertEquals(3, Wallet.generateRandomBytes(3).length);
  }
}
