package org.tron.keystore;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.CipherException;
import org.tron.keystore.WalletFile.Aes128CtrKdfParams;
import org.tron.keystore.WalletFile.CipherParams;
import org.tron.keystore.WalletFile.Crypto;

public class WalletDiffblueTest {
  /**
   * Test {@link Wallet#decrypt(String, WalletFile)}.
   *
   * <ul>
   *   <li>Given {@link Aes128CtrKdfParams} (default constructor) C is one.
   *   <li>Then throw {@link CipherException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.crypto.SignInterface Wallet.decrypt(String, WalletFile)"})
  public void testDecrypt_givenAes128CtrKdfParamsCIsOne_thenThrowCipherException()
      throws CipherException {
    // Arrange
    Aes128CtrKdfParams kdfparams = new Aes128CtrKdfParams();
    kdfparams.setC(1);
    kdfparams.setDklen(3);
    kdfparams.setSalt(null);
    kdfparams.setPrf("hmac-sha256");

    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv(null);

    Crypto crypto = new Crypto();
    crypto.setKdfparams(kdfparams);
    crypto.setCipher("aes-128-ctr");
    crypto.setKdf("pbkdf2");
    crypto.setMac(null);
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext(null);

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setId("42");
    walletFile.setCrypto(crypto);
    walletFile.setVersion(3);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.decrypt("iloveyou", walletFile));
  }

  /**
   * Test {@link Wallet#decrypt(String, WalletFile)}.
   *
   * <ul>
   *   <li>Given {@link Aes128CtrKdfParams} (default constructor) C is three.
   *   <li>Then throw {@link CipherException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.crypto.SignInterface Wallet.decrypt(String, WalletFile)"})
  public void testDecrypt_givenAes128CtrKdfParamsCIsThree_thenThrowCipherException()
      throws CipherException {
    // Arrange
    Aes128CtrKdfParams kdfparams = new Aes128CtrKdfParams();
    kdfparams.setC(3);
    kdfparams.setDklen(3);
    kdfparams.setSalt(null);
    kdfparams.setPrf("hmac-sha256");

    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv(null);

    Crypto crypto = new Crypto();
    crypto.setKdfparams(kdfparams);
    crypto.setCipher("aes-128-ctr");
    crypto.setKdf("pbkdf2");
    crypto.setMac(null);
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext(null);

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setId("42");
    walletFile.setCrypto(crypto);
    walletFile.setVersion(3);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.decrypt("iloveyou", walletFile));
  }

  /**
   * Test {@link Wallet#decrypt(String, WalletFile)}.
   *
   * <ul>
   *   <li>Given {@link Aes128CtrKdfParams} (default constructor) Prf is {@code aes-128-ctr}.
   *   <li>Then throw {@link CipherException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.crypto.SignInterface Wallet.decrypt(String, WalletFile)"})
  public void testDecrypt_givenAes128CtrKdfParamsPrfIsAes128Ctr_thenThrowCipherException()
      throws CipherException {
    // Arrange
    Aes128CtrKdfParams kdfparams = new Aes128CtrKdfParams();
    kdfparams.setC(1);
    kdfparams.setDklen(3);
    kdfparams.setSalt(null);
    kdfparams.setPrf("aes-128-ctr");

    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv(null);

    Crypto crypto = new Crypto();
    crypto.setKdfparams(kdfparams);
    crypto.setCipher("aes-128-ctr");
    crypto.setKdf("pbkdf2");
    crypto.setMac(null);
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext(null);

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setId("42");
    walletFile.setCrypto(crypto);
    walletFile.setVersion(3);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.decrypt("iloveyou", walletFile));
  }

  /**
   * Test {@link Wallet#decrypt(String, WalletFile)}.
   *
   * <ul>
   *   <li>Given {@link Aes128CtrKdfParams} (default constructor) Salt is {@code 42}.
   *   <li>Then throw {@link CipherException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.crypto.SignInterface Wallet.decrypt(String, WalletFile)"})
  public void testDecrypt_givenAes128CtrKdfParamsSaltIs42_thenThrowCipherException()
      throws CipherException {
    // Arrange
    Aes128CtrKdfParams kdfparams = new Aes128CtrKdfParams();
    kdfparams.setC(1);
    kdfparams.setDklen(3);
    kdfparams.setSalt("42");
    kdfparams.setPrf("hmac-sha256");

    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv(null);

    Crypto crypto = new Crypto();
    crypto.setKdfparams(kdfparams);
    crypto.setCipher("aes-128-ctr");
    crypto.setKdf("pbkdf2");
    crypto.setMac(null);
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext(null);

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setId("42");
    walletFile.setCrypto(crypto);
    walletFile.setVersion(3);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.decrypt("iloveyou", walletFile));
  }

  /**
   * Test {@link Wallet#decrypt(String, WalletFile)}.
   *
   * <ul>
   *   <li>Given {@link Crypto} (default constructor) Cipher is {@code Cipher}.
   *   <li>Then throw {@link CipherException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.crypto.SignInterface Wallet.decrypt(String, WalletFile)"})
  public void testDecrypt_givenCryptoCipherIsCipher_thenThrowCipherException()
      throws CipherException {
    // Arrange
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
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
   * Test {@link Wallet#decrypt(String, WalletFile)}.
   *
   * <ul>
   *   <li>Given {@link Crypto} (default constructor) Ciphertext is {@code 0x}.
   *   <li>Then throw {@link CipherException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.crypto.SignInterface Wallet.decrypt(String, WalletFile)"})
  public void testDecrypt_givenCryptoCiphertextIs0x_thenThrowCipherException()
      throws CipherException {
    // Arrange
    Aes128CtrKdfParams kdfparams = new Aes128CtrKdfParams();
    kdfparams.setC(1);
    kdfparams.setDklen(3);
    kdfparams.setSalt(null);
    kdfparams.setPrf("hmac-sha256");

    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv(null);

    Crypto crypto = new Crypto();
    crypto.setKdfparams(kdfparams);
    crypto.setCipher("aes-128-ctr");
    crypto.setKdf("pbkdf2");
    crypto.setMac(null);
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("0x");

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setId("42");
    walletFile.setCrypto(crypto);
    walletFile.setVersion(3);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.decrypt("iloveyou", walletFile));
  }

  /**
   * Test {@link Wallet#decrypt(String, WalletFile)}.
   *
   * <ul>
   *   <li>Given {@link Crypto} (default constructor) Kdf is {@code Kdf}.
   *   <li>Then throw {@link CipherException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.crypto.SignInterface Wallet.decrypt(String, WalletFile)"})
  public void testDecrypt_givenCryptoKdfIsKdf_thenThrowCipherException() throws CipherException {
    // Arrange
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher("aes-128-ctr");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
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
   * Test {@link Wallet#decrypt(String, WalletFile)}.
   *
   * <ul>
   *   <li>Given {@link Crypto} (default constructor) Kdf is {@code scrypt}.
   *   <li>Then throw {@link CipherException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.crypto.SignInterface Wallet.decrypt(String, WalletFile)"})
  public void testDecrypt_givenCryptoKdfIsScrypt_thenThrowCipherException() throws CipherException {
    // Arrange
    Aes128CtrKdfParams kdfparams = new Aes128CtrKdfParams();
    kdfparams.setC(1);
    kdfparams.setDklen(3);
    kdfparams.setSalt(null);
    kdfparams.setPrf("hmac-sha256");

    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv(null);

    Crypto crypto = new Crypto();
    crypto.setKdfparams(kdfparams);
    crypto.setCipher("aes-128-ctr");
    crypto.setKdf("scrypt");
    crypto.setMac(null);
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext(null);

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setId("42");
    walletFile.setCrypto(crypto);
    walletFile.setVersion(3);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.decrypt("iloveyou", walletFile));
  }

  /**
   * Test {@link Wallet#decrypt(String, WalletFile)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link WalletFile} (default constructor) Version is one.
   *   <li>Then throw {@link CipherException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.crypto.SignInterface Wallet.decrypt(String, WalletFile)"})
  public void testDecrypt_givenOne_whenWalletFileVersionIsOne_thenThrowCipherException()
      throws CipherException {
    // Arrange
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
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
   * Test {@link Wallet#validate(WalletFile)}.
   *
   * <ul>
   *   <li>Given {@link Crypto} (default constructor) Cipher is {@code aes-128-ctr}.
   *   <li>Then throw {@link CipherException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#validate(WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Wallet.validate(WalletFile)"})
  public void testValidate_givenCryptoCipherIsAes128Ctr_thenThrowCipherException()
      throws CipherException {
    // Arrange
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher("aes-128-ctr");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
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
   * Test {@link Wallet#validate(WalletFile)}.
   *
   * <ul>
   *   <li>Given {@link Crypto} (default constructor) Cipher is {@code Cipher}.
   *   <li>Then throw {@link CipherException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#validate(WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Wallet.validate(WalletFile)"})
  public void testValidate_givenCryptoCipherIsCipher_thenThrowCipherException()
      throws CipherException {
    // Arrange
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
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
   * Test {@link Wallet#validate(WalletFile)}.
   *
   * <ul>
   *   <li>Given {@link Crypto} (default constructor) Kdf is {@code pbkdf2}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#validate(WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Wallet.validate(WalletFile)"})
  public void testValidate_givenCryptoKdfIsPbkdf2_thenDoesNotThrow() throws CipherException {
    // Arrange
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdfparams(new Aes128CtrKdfParams());
    crypto.setMac("Mac");
    crypto.setCipher("aes-128-ctr");
    crypto.setKdf("pbkdf2");

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setId("42");
    walletFile.setVersion(3);
    walletFile.setCrypto(crypto);

    // Act and Assert
    Wallet.validate(walletFile);
  }

  /**
   * Test {@link Wallet#validate(WalletFile)}.
   *
   * <ul>
   *   <li>Given {@link Crypto} (default constructor) Kdf is {@code scrypt}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#validate(WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Wallet.validate(WalletFile)"})
  public void testValidate_givenCryptoKdfIsScrypt_thenDoesNotThrow() throws CipherException {
    // Arrange
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdfparams(new Aes128CtrKdfParams());
    crypto.setMac("Mac");
    crypto.setCipher("aes-128-ctr");
    crypto.setKdf("scrypt");

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setId("42");
    walletFile.setVersion(3);
    walletFile.setCrypto(crypto);

    // Act and Assert
    Wallet.validate(walletFile);
  }

  /**
   * Test {@link Wallet#validate(WalletFile)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link WalletFile} (default constructor) Version is one.
   *   <li>Then throw {@link CipherException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#validate(WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Wallet.validate(WalletFile)"})
  public void testValidate_givenOne_whenWalletFileVersionIsOne_thenThrowCipherException()
      throws CipherException {
    // Arrange
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile walletFile = new WalletFile();
    walletFile.setAddress("42 Main St");
    walletFile.setCrypto(crypto);
    walletFile.setId("42");
    walletFile.setVersion(1);

    // Act and Assert
    assertThrows(CipherException.class, () -> Wallet.validate(walletFile));
  }
}
