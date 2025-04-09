package org.tron.keystore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.crypto.ECKey;
import org.tron.common.crypto.SignInterface;
import org.tron.core.exception.CipherException;
import org.tron.keystore.WalletFile.Aes128CtrKdfParams;
import org.tron.keystore.WalletFile.CipherParams;
import org.tron.keystore.WalletFile.Crypto;
import org.tron.keystore.WalletFile.KdfParams;
import org.tron.keystore.WalletFile.ScryptKdfParams;

public class WalletDiffblueTest {
  /**
   * Test {@link Wallet#create(String, SignInterface, int, int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then Crypto Kdfparams return {@link ScryptKdfParams}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Wallet#create(String, SignInterface, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WalletFile Wallet.create(String, SignInterface, int, int)"})
  public void testCreate_whenTwo_thenCryptoKdfparamsReturnScryptKdfParams() throws CipherException {
    // Arrange and Act
    WalletFile actualCreateResult = Wallet.create("iloveyou", new ECKey(), 2, 1);

    // Assert
    Crypto crypto = actualCreateResult.getCrypto();
    KdfParams kdfparams = crypto.getKdfparams();
    assertTrue(kdfparams instanceof ScryptKdfParams);
    assertEquals("aes-128-ctr", crypto.getCipher());
    assertEquals("scrypt", crypto.getKdf());
    assertEquals(1, ((ScryptKdfParams) kdfparams).getP());
    assertEquals(2, ((ScryptKdfParams) kdfparams).getN());
    assertEquals(3, actualCreateResult.getVersion());
    assertEquals(8, ((ScryptKdfParams) kdfparams).getR());
    assertEquals(Integer.SIZE, kdfparams.getDklen());
  }

  /**
   * Test {@link Wallet#decrypt(String, WalletFile)}.
   * <ul>
   *   <li>Given {@link CipherParams} (default constructor) Iv is {@code Iv}.</li>
   *   <li>Then throw {@link CipherException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignInterface Wallet.decrypt(String, WalletFile)"})
  public void testDecrypt_givenCipherParamsIvIsIv_thenThrowCipherException() throws CipherException {
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
   * <ul>
   *   <li>Given {@link Crypto} (default constructor) Cipher is {@code Cipher}.</li>
   *   <li>Then throw {@link CipherException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignInterface Wallet.decrypt(String, WalletFile)"})
  public void testDecrypt_givenCryptoCipherIsCipher_thenThrowCipherException() throws CipherException {
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
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link WalletFile} (default constructor) Version is one.</li>
   *   <li>Then throw {@link CipherException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Wallet#decrypt(String, WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignInterface Wallet.decrypt(String, WalletFile)"})
  public void testDecrypt_givenOne_whenWalletFileVersionIsOne_thenThrowCipherException() throws CipherException {
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
   * <ul>
   *   <li>Given {@link Crypto} (default constructor) Cipher is {@code aes-128-ctr}.</li>
   *   <li>Then throw {@link CipherException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Wallet#validate(WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Wallet.validate(WalletFile)"})
  public void testValidate_givenCryptoCipherIsAes128Ctr_thenThrowCipherException() throws CipherException {
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
   * <ul>
   *   <li>Given {@link Crypto} (default constructor) Cipher is {@code Cipher}.</li>
   *   <li>Then throw {@link CipherException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Wallet#validate(WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Wallet.validate(WalletFile)"})
  public void testValidate_givenCryptoCipherIsCipher_thenThrowCipherException() throws CipherException {
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
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link WalletFile} (default constructor) Version is one.</li>
   *   <li>Then throw {@link CipherException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Wallet#validate(WalletFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Wallet.validate(WalletFile)"})
  public void testValidate_givenOne_whenWalletFileVersionIsOne_thenThrowCipherException() throws CipherException {
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
