package org.tron.keystore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.IOException;
import org.junit.Test;
import org.mockito.Mockito;

public class WalletFileDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile.Aes128CtrKdfParams#equals(Object)}
   *   <li>{@link WalletFile.Aes128CtrKdfParams#hashCode()}
   * </ul>
   */
  @Test
  public void testAes128CtrKdfParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt("Salt");

    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams2 = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf("Prf");
    aes128CtrKdfParams2.setSalt("Salt");

    // Act and Assert
    assertEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
    int expectedHashCodeResult = aes128CtrKdfParams.hashCode();
    assertEquals(expectedHashCodeResult, aes128CtrKdfParams2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile.Aes128CtrKdfParams#equals(Object)}
   *   <li>{@link WalletFile.Aes128CtrKdfParams#hashCode()}
   * </ul>
   */
  @Test
  public void testAes128CtrKdfParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf(null);
    aes128CtrKdfParams.setSalt("Salt");

    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams2 = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf(null);
    aes128CtrKdfParams2.setSalt("Salt");

    // Act and Assert
    assertEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
    int expectedHashCodeResult = aes128CtrKdfParams.hashCode();
    assertEquals(expectedHashCodeResult, aes128CtrKdfParams2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile.Aes128CtrKdfParams#equals(Object)}
   *   <li>{@link WalletFile.Aes128CtrKdfParams#hashCode()}
   * </ul>
   */
  @Test
  public void testAes128CtrKdfParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt(null);

    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams2 = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf("Prf");
    aes128CtrKdfParams2.setSalt(null);

    // Act and Assert
    assertEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
    int expectedHashCodeResult = aes128CtrKdfParams.hashCode();
    assertEquals(expectedHashCodeResult, aes128CtrKdfParams2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile.Aes128CtrKdfParams#equals(Object)}
   *   <li>{@link WalletFile.Aes128CtrKdfParams#hashCode()}
   * </ul>
   */
  @Test
  public void testAes128CtrKdfParamsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt("Salt");

    // Act and Assert
    assertEquals(aes128CtrKdfParams, aes128CtrKdfParams);
    int expectedHashCodeResult = aes128CtrKdfParams.hashCode();
    assertEquals(expectedHashCodeResult, aes128CtrKdfParams.hashCode());
  }

  /**
   * Method under test: {@link WalletFile.Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  public void testAes128CtrKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(3);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt("Salt");

    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams2 = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf("Prf");
    aes128CtrKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
  }

  /**
   * Method under test: {@link WalletFile.Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  public void testAes128CtrKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(1);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt("Salt");

    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams2 = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf("Prf");
    aes128CtrKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
  }

  /**
   * Method under test: {@link WalletFile.Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  public void testAes128CtrKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Salt");
    aes128CtrKdfParams.setSalt("Salt");

    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams2 = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf("Prf");
    aes128CtrKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
  }

  /**
   * Method under test: {@link WalletFile.Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  public void testAes128CtrKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf(null);
    aes128CtrKdfParams.setSalt("Salt");

    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams2 = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf("Prf");
    aes128CtrKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
  }

  /**
   * Method under test: {@link WalletFile.Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  public void testAes128CtrKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt(null);

    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams2 = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf("Prf");
    aes128CtrKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
  }

  /**
   * Method under test: {@link WalletFile.Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  public void testAes128CtrKdfParamsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, null);
  }

  /**
   * Method under test: {@link WalletFile.Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  public void testAes128CtrKdfParamsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WalletFile.Aes128CtrKdfParams aes128CtrKdfParams = new WalletFile.Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, "Different type to Aes128CtrKdfParams");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link WalletFile.Aes128CtrKdfParams}
   *   <li>{@link WalletFile.Aes128CtrKdfParams#setC(int)}
   *   <li>{@link WalletFile.Aes128CtrKdfParams#setDklen(int)}
   *   <li>{@link WalletFile.Aes128CtrKdfParams#setPrf(String)}
   *   <li>{@link WalletFile.Aes128CtrKdfParams#setSalt(String)}
   *   <li>{@link WalletFile.Aes128CtrKdfParams#getC()}
   *   <li>{@link WalletFile.Aes128CtrKdfParams#getDklen()}
   *   <li>{@link WalletFile.Aes128CtrKdfParams#getPrf()}
   *   <li>{@link WalletFile.Aes128CtrKdfParams#getSalt()}
   * </ul>
   */
  @Test
  public void testAes128CtrKdfParamsGettersAndSetters() {
    // Arrange and Act
    WalletFile.Aes128CtrKdfParams actualAes128CtrKdfParams = new WalletFile.Aes128CtrKdfParams();
    actualAes128CtrKdfParams.setC(1);
    actualAes128CtrKdfParams.setDklen(3);
    actualAes128CtrKdfParams.setPrf("Prf");
    actualAes128CtrKdfParams.setSalt("Salt");
    int actualC = actualAes128CtrKdfParams.getC();
    int actualDklen = actualAes128CtrKdfParams.getDklen();
    String actualPrf = actualAes128CtrKdfParams.getPrf();

    // Assert that nothing has changed
    assertEquals("Prf", actualPrf);
    assertEquals("Salt", actualAes128CtrKdfParams.getSalt());
    assertEquals(1, actualC);
    assertEquals(3, actualDklen);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile.CipherParams#equals(Object)}
   *   <li>{@link WalletFile.CipherParams#hashCode()}
   * </ul>
   */
  @Test
  public void testCipherParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WalletFile.CipherParams cipherParams = new WalletFile.CipherParams();
    cipherParams.setIv("Iv");

    WalletFile.CipherParams cipherParams2 = new WalletFile.CipherParams();
    cipherParams2.setIv("Iv");

    // Act and Assert
    assertEquals(cipherParams, cipherParams2);
    int expectedHashCodeResult = cipherParams.hashCode();
    assertEquals(expectedHashCodeResult, cipherParams2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile.CipherParams#equals(Object)}
   *   <li>{@link WalletFile.CipherParams#hashCode()}
   * </ul>
   */
  @Test
  public void testCipherParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WalletFile.CipherParams cipherParams = new WalletFile.CipherParams();
    cipherParams.setIv(null);

    WalletFile.CipherParams cipherParams2 = new WalletFile.CipherParams();
    cipherParams2.setIv(null);

    // Act and Assert
    assertEquals(cipherParams, cipherParams2);
    int expectedHashCodeResult = cipherParams.hashCode();
    assertEquals(expectedHashCodeResult, cipherParams2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile.CipherParams#equals(Object)}
   *   <li>{@link WalletFile.CipherParams#hashCode()}
   * </ul>
   */
  @Test
  public void testCipherParamsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WalletFile.CipherParams cipherParams = new WalletFile.CipherParams();
    cipherParams.setIv("Iv");

    // Act and Assert
    assertEquals(cipherParams, cipherParams);
    int expectedHashCodeResult = cipherParams.hashCode();
    assertEquals(expectedHashCodeResult, cipherParams.hashCode());
  }

  /**
   * Method under test: {@link WalletFile.CipherParams#equals(Object)}
   */
  @Test
  public void testCipherParamsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WalletFile.CipherParams cipherParams = new WalletFile.CipherParams();
    cipherParams.setIv(null);

    WalletFile.CipherParams cipherParams2 = new WalletFile.CipherParams();
    cipherParams2.setIv("Iv");

    // Act and Assert
    assertNotEquals(cipherParams, cipherParams2);
  }

  /**
   * Method under test: {@link WalletFile.CipherParams#equals(Object)}
   */
  @Test
  public void testCipherParamsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WalletFile.CipherParams cipherParams = new WalletFile.CipherParams();
    cipherParams.setIv("Iv");

    // Act and Assert
    assertNotEquals(cipherParams, null);
  }

  /**
   * Method under test: {@link WalletFile.CipherParams#equals(Object)}
   */
  @Test
  public void testCipherParamsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WalletFile.CipherParams cipherParams = new WalletFile.CipherParams();
    cipherParams.setIv("Iv");

    // Act and Assert
    assertNotEquals(cipherParams, "Different type to CipherParams");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link WalletFile.CipherParams}
   *   <li>{@link WalletFile.CipherParams#setIv(String)}
   *   <li>{@link WalletFile.CipherParams#getIv()}
   * </ul>
   */
  @Test
  public void testCipherParamsGettersAndSetters() {
    // Arrange and Act
    WalletFile.CipherParams actualCipherParams = new WalletFile.CipherParams();
    actualCipherParams.setIv("Iv");

    // Assert that nothing has changed
    assertEquals("Iv", actualCipherParams.getIv());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile.Crypto#equals(Object)}
   *   <li>{@link WalletFile.Crypto#hashCode()}
   * </ul>
   */
  @Test
  public void testCryptoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    WalletFile.CipherParams cipherparams2 = new WalletFile.CipherParams();
    cipherparams2.setIv("Iv");

    WalletFile.Crypto crypto2 = new WalletFile.Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertEquals(crypto, crypto2);
    int expectedHashCodeResult = crypto.hashCode();
    assertEquals(expectedHashCodeResult, crypto2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile.Crypto#equals(Object)}
   *   <li>{@link WalletFile.Crypto#hashCode()}
   * </ul>
   */
  @Test
  public void testCryptoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(crypto, crypto);
    int expectedHashCodeResult = crypto.hashCode();
    assertEquals(expectedHashCodeResult, crypto.hashCode());
  }

  /**
   * Method under test: {@link WalletFile.Crypto#equals(Object)}
   */
  @Test
  public void testCryptoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WalletFile.CipherParams cipherparams = new WalletFile.CipherParams();
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("Ciphertext");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile.CipherParams cipherparams2 = new WalletFile.CipherParams();
    cipherparams2.setIv("Iv");

    WalletFile.Crypto crypto2 = new WalletFile.Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertNotEquals(crypto, crypto2);
  }

  /**
   * Method under test: {@link WalletFile.Crypto#equals(Object)}
   */
  @Test
  public void testCryptoEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WalletFile.CipherParams cipherparams = new WalletFile.CipherParams();
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher(null);
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile.CipherParams cipherparams2 = new WalletFile.CipherParams();
    cipherparams2.setIv("Iv");

    WalletFile.Crypto crypto2 = new WalletFile.Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertNotEquals(crypto, crypto2);
  }

  /**
   * Method under test: {@link WalletFile.Crypto#equals(Object)}
   */
  @Test
  public void testCryptoEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WalletFile.CipherParams cipherparams = mock(WalletFile.CipherParams.class);
    doNothing().when(cipherparams).setIv(Mockito.<String>any());
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile.CipherParams cipherparams2 = new WalletFile.CipherParams();
    cipherparams2.setIv("Iv");

    WalletFile.Crypto crypto2 = new WalletFile.Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertNotEquals(crypto, crypto2);
  }

  /**
   * Method under test: {@link WalletFile.Crypto#equals(Object)}
   */
  @Test
  public void testCryptoEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WalletFile.CipherParams cipherparams = mock(WalletFile.CipherParams.class);
    doNothing().when(cipherparams).setIv(Mockito.<String>any());
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Cipher");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile.CipherParams cipherparams2 = new WalletFile.CipherParams();
    cipherparams2.setIv("Iv");

    WalletFile.Crypto crypto2 = new WalletFile.Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertNotEquals(crypto, crypto2);
  }

  /**
   * Method under test: {@link WalletFile.Crypto#equals(Object)}
   */
  @Test
  public void testCryptoEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WalletFile.CipherParams cipherparams = mock(WalletFile.CipherParams.class);
    doNothing().when(cipherparams).setIv(Mockito.<String>any());
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext(null);
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile.CipherParams cipherparams2 = new WalletFile.CipherParams();
    cipherparams2.setIv("Iv");

    WalletFile.Crypto crypto2 = new WalletFile.Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertNotEquals(crypto, crypto2);
  }

  /**
   * Method under test: {@link WalletFile.Crypto#equals(Object)}
   */
  @Test
  public void testCryptoEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WalletFile.CipherParams cipherparams = mock(WalletFile.CipherParams.class);
    doNothing().when(cipherparams).setIv(Mockito.<String>any());
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext(null);
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    WalletFile.CipherParams cipherparams2 = new WalletFile.CipherParams();
    cipherparams2.setIv("Iv");

    WalletFile.Crypto crypto2 = new WalletFile.Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext(null);
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertNotEquals(crypto, crypto2);
  }

  /**
   * Method under test: {@link WalletFile.Crypto#equals(Object)}
   */
  @Test
  public void testCryptoEquals_whenOtherIsNull_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(crypto, null);
  }

  /**
   * Method under test: {@link WalletFile.Crypto#equals(Object)}
   */
  @Test
  public void testCryptoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(crypto, "Different type to Crypto");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link WalletFile.Crypto}
   *   <li>{@link WalletFile.Crypto#setCipher(String)}
   *   <li>{@link WalletFile.Crypto#setCipherparams(WalletFile.CipherParams)}
   *   <li>{@link WalletFile.Crypto#setCiphertext(String)}
   *   <li>{@link WalletFile.Crypto#setKdf(String)}
   *   <li>{@link WalletFile.Crypto#setKdfparams(WalletFile.KdfParams)}
   *   <li>{@link WalletFile.Crypto#setMac(String)}
   *   <li>{@link WalletFile.Crypto#getCipher()}
   *   <li>{@link WalletFile.Crypto#getCipherparams()}
   *   <li>{@link WalletFile.Crypto#getCiphertext()}
   *   <li>{@link WalletFile.Crypto#getKdf()}
   *   <li>{@link WalletFile.Crypto#getKdfparams()}
   *   <li>{@link WalletFile.Crypto#getMac()}
   * </ul>
   */
  @Test
  public void testCryptoGettersAndSetters() {
    // Arrange and Act
    WalletFile.Crypto actualCrypto = new WalletFile.Crypto();
    actualCrypto.setCipher("Cipher");
    WalletFile.CipherParams cipherparams = new WalletFile.CipherParams();
    cipherparams.setIv("Iv");
    actualCrypto.setCipherparams(cipherparams);
    actualCrypto.setCiphertext("Ciphertext");
    actualCrypto.setKdf("Kdf");
    WalletFile.Aes128CtrKdfParams kdfparams = new WalletFile.Aes128CtrKdfParams();
    actualCrypto.setKdfparams(kdfparams);
    actualCrypto.setMac("Mac");
    String actualCipher = actualCrypto.getCipher();
    WalletFile.CipherParams actualCipherparams = actualCrypto.getCipherparams();
    String actualCiphertext = actualCrypto.getCiphertext();
    String actualKdf = actualCrypto.getKdf();
    WalletFile.KdfParams actualKdfparams = actualCrypto.getKdfparams();
    String actualMac = actualCrypto.getMac();

    // Assert that nothing has changed
    assertEquals("Cipher", actualCipher);
    assertEquals("Ciphertext", actualCiphertext);
    assertEquals("Iv", actualCipherparams.getIv());
    assertEquals("Kdf", actualKdf);
    assertEquals("Mac", actualMac);
    assertSame(kdfparams, actualKdfparams);
    assertSame(cipherparams, actualCipherparams);
  }

  /**
   * Method under test:
   * {@link WalletFile.KdfParamsDeserialiser#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  public void testKdfParamsDeserialiserDeserialize() throws IOException {
    // Arrange
    WalletFile.KdfParamsDeserialiser kdfParamsDeserialiser = new WalletFile.KdfParamsDeserialiser();
    JsonParser d = mock(JsonParser.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(new ObjectMapper());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act
    WalletFile.KdfParams actualDeserializeResult = kdfParamsDeserialiser.deserialize(jsonParser,
        new DefaultDeserializationContext.Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig())));

    // Assert
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).nextToken();
    assertTrue(actualDeserializeResult instanceof WalletFile.Aes128CtrKdfParams);
    assertNull(((WalletFile.Aes128CtrKdfParams) actualDeserializeResult).getPrf());
    assertNull(actualDeserializeResult.getSalt());
    assertEquals(0, ((WalletFile.Aes128CtrKdfParams) actualDeserializeResult).getC());
    assertEquals(0, actualDeserializeResult.getDklen());
  }

  /**
   * Method under test:
   * {@link WalletFile.KdfParamsDeserialiser#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  public void testKdfParamsDeserialiserDeserialize2() throws IOException {
    // Arrange
    WalletFile.KdfParamsDeserialiser kdfParamsDeserialiser = new WalletFile.KdfParamsDeserialiser();
    JsonParser d = mock(JsonParser.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.currentToken()).thenReturn(null);
    when(d.getCodec()).thenReturn(new ObjectMapper());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act
    WalletFile.KdfParams actualDeserializeResult = kdfParamsDeserialiser.deserialize(jsonParser,
        new DefaultDeserializationContext.Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig())));

    // Assert
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d, atLeast(1)).nextToken();
    assertTrue(actualDeserializeResult instanceof WalletFile.Aes128CtrKdfParams);
    assertNull(((WalletFile.Aes128CtrKdfParams) actualDeserializeResult).getPrf());
    assertNull(actualDeserializeResult.getSalt());
    assertEquals(0, ((WalletFile.Aes128CtrKdfParams) actualDeserializeResult).getC());
    assertEquals(0, actualDeserializeResult.getDklen());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link WalletFile.KdfParamsDeserialiser}
   */
  @Test
  public void testKdfParamsDeserialiserNewKdfParamsDeserialiser() {
    // Arrange and Act
    WalletFile.KdfParamsDeserialiser actualKdfParamsDeserialiser = new WalletFile.KdfParamsDeserialiser();

    // Assert
    assertNull(actualKdfParamsDeserialiser.getDelegatee());
    assertNull(actualKdfParamsDeserialiser.getObjectIdReader());
    assertNull(actualKdfParamsDeserialiser.getEmptyValue());
    assertNull(actualKdfParamsDeserialiser.getKnownPropertyNames());
    assertNull(actualKdfParamsDeserialiser.getNullValue());
    assertEquals(AccessPattern.CONSTANT, actualKdfParamsDeserialiser.getNullAccessPattern());
    assertEquals(AccessPattern.DYNAMIC, actualKdfParamsDeserialiser.getEmptyAccessPattern());
    assertFalse(actualKdfParamsDeserialiser.isCachable());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile.ScryptKdfParams#equals(Object)}
   *   <li>{@link WalletFile.ScryptKdfParams#hashCode()}
   * </ul>
   */
  @Test
  public void testScryptKdfParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WalletFile.ScryptKdfParams scryptKdfParams = new WalletFile.ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    WalletFile.ScryptKdfParams scryptKdfParams2 = new WalletFile.ScryptKdfParams();
    scryptKdfParams2.setDklen(3);
    scryptKdfParams2.setN(1);
    scryptKdfParams2.setP(1);
    scryptKdfParams2.setR(1);
    scryptKdfParams2.setSalt("Salt");

    // Act and Assert
    assertEquals(scryptKdfParams, scryptKdfParams2);
    int expectedHashCodeResult = scryptKdfParams.hashCode();
    assertEquals(expectedHashCodeResult, scryptKdfParams2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile.ScryptKdfParams#equals(Object)}
   *   <li>{@link WalletFile.ScryptKdfParams#hashCode()}
   * </ul>
   */
  @Test
  public void testScryptKdfParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WalletFile.ScryptKdfParams scryptKdfParams = new WalletFile.ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt(null);

    WalletFile.ScryptKdfParams scryptKdfParams2 = new WalletFile.ScryptKdfParams();
    scryptKdfParams2.setDklen(3);
    scryptKdfParams2.setN(1);
    scryptKdfParams2.setP(1);
    scryptKdfParams2.setR(1);
    scryptKdfParams2.setSalt(null);

    // Act and Assert
    assertEquals(scryptKdfParams, scryptKdfParams2);
    int expectedHashCodeResult = scryptKdfParams.hashCode();
    assertEquals(expectedHashCodeResult, scryptKdfParams2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile.ScryptKdfParams#equals(Object)}
   *   <li>{@link WalletFile.ScryptKdfParams#hashCode()}
   * </ul>
   */
  @Test
  public void testScryptKdfParamsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WalletFile.ScryptKdfParams scryptKdfParams = new WalletFile.ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    // Act and Assert
    assertEquals(scryptKdfParams, scryptKdfParams);
    int expectedHashCodeResult = scryptKdfParams.hashCode();
    assertEquals(expectedHashCodeResult, scryptKdfParams.hashCode());
  }

  /**
   * Method under test: {@link WalletFile.ScryptKdfParams#equals(Object)}
   */
  @Test
  public void testScryptKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WalletFile.ScryptKdfParams scryptKdfParams = new WalletFile.ScryptKdfParams();
    scryptKdfParams.setDklen(1);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    WalletFile.ScryptKdfParams scryptKdfParams2 = new WalletFile.ScryptKdfParams();
    scryptKdfParams2.setDklen(3);
    scryptKdfParams2.setN(1);
    scryptKdfParams2.setP(1);
    scryptKdfParams2.setR(1);
    scryptKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, scryptKdfParams2);
  }

  /**
   * Method under test: {@link WalletFile.ScryptKdfParams#equals(Object)}
   */
  @Test
  public void testScryptKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WalletFile.ScryptKdfParams scryptKdfParams = new WalletFile.ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(3);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    WalletFile.ScryptKdfParams scryptKdfParams2 = new WalletFile.ScryptKdfParams();
    scryptKdfParams2.setDklen(3);
    scryptKdfParams2.setN(1);
    scryptKdfParams2.setP(1);
    scryptKdfParams2.setR(1);
    scryptKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, scryptKdfParams2);
  }

  /**
   * Method under test: {@link WalletFile.ScryptKdfParams#equals(Object)}
   */
  @Test
  public void testScryptKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WalletFile.ScryptKdfParams scryptKdfParams = new WalletFile.ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(3);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    WalletFile.ScryptKdfParams scryptKdfParams2 = new WalletFile.ScryptKdfParams();
    scryptKdfParams2.setDklen(3);
    scryptKdfParams2.setN(1);
    scryptKdfParams2.setP(1);
    scryptKdfParams2.setR(1);
    scryptKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, scryptKdfParams2);
  }

  /**
   * Method under test: {@link WalletFile.ScryptKdfParams#equals(Object)}
   */
  @Test
  public void testScryptKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WalletFile.ScryptKdfParams scryptKdfParams = new WalletFile.ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(3);
    scryptKdfParams.setSalt("Salt");

    WalletFile.ScryptKdfParams scryptKdfParams2 = new WalletFile.ScryptKdfParams();
    scryptKdfParams2.setDklen(3);
    scryptKdfParams2.setN(1);
    scryptKdfParams2.setP(1);
    scryptKdfParams2.setR(1);
    scryptKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, scryptKdfParams2);
  }

  /**
   * Method under test: {@link WalletFile.ScryptKdfParams#equals(Object)}
   */
  @Test
  public void testScryptKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WalletFile.ScryptKdfParams scryptKdfParams = new WalletFile.ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt(null);

    WalletFile.ScryptKdfParams scryptKdfParams2 = new WalletFile.ScryptKdfParams();
    scryptKdfParams2.setDklen(3);
    scryptKdfParams2.setN(1);
    scryptKdfParams2.setP(1);
    scryptKdfParams2.setR(1);
    scryptKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, scryptKdfParams2);
  }

  /**
   * Method under test: {@link WalletFile.ScryptKdfParams#equals(Object)}
   */
  @Test
  public void testScryptKdfParamsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WalletFile.ScryptKdfParams scryptKdfParams = new WalletFile.ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, null);
  }

  /**
   * Method under test: {@link WalletFile.ScryptKdfParams#equals(Object)}
   */
  @Test
  public void testScryptKdfParamsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WalletFile.ScryptKdfParams scryptKdfParams = new WalletFile.ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, "Different type to ScryptKdfParams");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link WalletFile.ScryptKdfParams}
   *   <li>{@link WalletFile.ScryptKdfParams#setDklen(int)}
   *   <li>{@link WalletFile.ScryptKdfParams#setN(int)}
   *   <li>{@link WalletFile.ScryptKdfParams#setP(int)}
   *   <li>{@link WalletFile.ScryptKdfParams#setR(int)}
   *   <li>{@link WalletFile.ScryptKdfParams#setSalt(String)}
   *   <li>{@link WalletFile.ScryptKdfParams#getDklen()}
   *   <li>{@link WalletFile.ScryptKdfParams#getN()}
   *   <li>{@link WalletFile.ScryptKdfParams#getP()}
   *   <li>{@link WalletFile.ScryptKdfParams#getR()}
   *   <li>{@link WalletFile.ScryptKdfParams#getSalt()}
   * </ul>
   */
  @Test
  public void testScryptKdfParamsGettersAndSetters() {
    // Arrange and Act
    WalletFile.ScryptKdfParams actualScryptKdfParams = new WalletFile.ScryptKdfParams();
    actualScryptKdfParams.setDklen(3);
    actualScryptKdfParams.setN(1);
    actualScryptKdfParams.setP(1);
    actualScryptKdfParams.setR(1);
    actualScryptKdfParams.setSalt("Salt");
    int actualDklen = actualScryptKdfParams.getDklen();
    int actualN = actualScryptKdfParams.getN();
    int actualP = actualScryptKdfParams.getP();
    int actualR = actualScryptKdfParams.getR();

    // Assert that nothing has changed
    assertEquals("Salt", actualScryptKdfParams.getSalt());
    assertEquals(1, actualN);
    assertEquals(1, actualP);
    assertEquals(1, actualR);
    assertEquals(3, actualDklen);
  }

  /**
   * Method under test: {@link WalletFile#setCryptoV1(WalletFile.Crypto)}
   */
  @Test
  public void testSetCryptoV1() {
    // Arrange
    WalletFile walletFile = new WalletFile();

    WalletFile.CipherParams cipherparams = new WalletFile.CipherParams();
    cipherparams.setIv("Iv");

    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");

    // Act
    walletFile.setCryptoV1(crypto);

    // Assert
    assertSame(crypto, walletFile.getCrypto());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile#equals(Object)}
   *   <li>{@link WalletFile#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    WalletFile.CipherParams cipherparams2 = new WalletFile.CipherParams();
    cipherparams2.setIv("Iv");

    WalletFile.Crypto crypto2 = new WalletFile.Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    WalletFile walletFile2 = new WalletFile();
    walletFile2.setAddress("42 Main St");
    walletFile2.setCrypto(crypto2);
    walletFile2.setId("42");
    walletFile2.setVersion(1);

    // Act and Assert
    assertEquals(walletFile, walletFile2);
    int expectedHashCodeResult = walletFile.hashCode();
    assertEquals(expectedHashCodeResult, walletFile2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile#equals(Object)}
   *   <li>{@link WalletFile#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
    assertEquals(walletFile, walletFile);
    int expectedHashCodeResult = walletFile.hashCode();
    assertEquals(expectedHashCodeResult, walletFile.hashCode());
  }

  /**
   * Method under test: {@link WalletFile#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
    walletFile.setAddress("17 High St");
    walletFile.setCrypto(crypto);
    walletFile.setId("42");
    walletFile.setVersion(1);

    WalletFile.CipherParams cipherparams2 = new WalletFile.CipherParams();
    cipherparams2.setIv("Iv");

    WalletFile.Crypto crypto2 = new WalletFile.Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    WalletFile walletFile2 = new WalletFile();
    walletFile2.setAddress("42 Main St");
    walletFile2.setCrypto(crypto2);
    walletFile2.setId("42");
    walletFile2.setVersion(1);

    // Act and Assert
    assertNotEquals(walletFile, walletFile2);
  }

  /**
   * Method under test: {@link WalletFile#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
    walletFile.setAddress(null);
    walletFile.setCrypto(crypto);
    walletFile.setId("42");
    walletFile.setVersion(1);

    WalletFile.CipherParams cipherparams2 = new WalletFile.CipherParams();
    cipherparams2.setIv("Iv");

    WalletFile.Crypto crypto2 = new WalletFile.Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    WalletFile walletFile2 = new WalletFile();
    walletFile2.setAddress("42 Main St");
    walletFile2.setCrypto(crypto2);
    walletFile2.setId("42");
    walletFile2.setVersion(1);

    // Act and Assert
    assertNotEquals(walletFile, walletFile2);
  }

  /**
   * Method under test: {@link WalletFile#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WalletFile.CipherParams cipherparams = new WalletFile.CipherParams();
    cipherparams.setIv("Iv");
    WalletFile.Crypto crypto = mock(WalletFile.Crypto.class);
    doNothing().when(crypto).setCipher(Mockito.<String>any());
    doNothing().when(crypto).setCipherparams(Mockito.<WalletFile.CipherParams>any());
    doNothing().when(crypto).setCiphertext(Mockito.<String>any());
    doNothing().when(crypto).setKdf(Mockito.<String>any());
    doNothing().when(crypto).setKdfparams(Mockito.<WalletFile.KdfParams>any());
    doNothing().when(crypto).setMac(Mockito.<String>any());
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

    WalletFile.CipherParams cipherparams2 = new WalletFile.CipherParams();
    cipherparams2.setIv("Iv");

    WalletFile.Crypto crypto2 = new WalletFile.Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    WalletFile walletFile2 = new WalletFile();
    walletFile2.setAddress("42 Main St");
    walletFile2.setCrypto(crypto2);
    walletFile2.setId("42");
    walletFile2.setVersion(1);

    // Act and Assert
    assertNotEquals(walletFile, walletFile2);
  }

  /**
   * Method under test: {@link WalletFile#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
    assertNotEquals(walletFile, null);
  }

  /**
   * Method under test: {@link WalletFile#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
    assertNotEquals(walletFile, "Different type to WalletFile");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link WalletFile}
   *   <li>{@link WalletFile#setAddress(String)}
   *   <li>{@link WalletFile#setCrypto(WalletFile.Crypto)}
   *   <li>{@link WalletFile#setId(String)}
   *   <li>{@link WalletFile#setVersion(int)}
   *   <li>{@link WalletFile#getAddress()}
   *   <li>{@link WalletFile#getCrypto()}
   *   <li>{@link WalletFile#getId()}
   *   <li>{@link WalletFile#getVersion()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    WalletFile actualWalletFile = new WalletFile();
    actualWalletFile.setAddress("42 Main St");
    WalletFile.CipherParams cipherparams = new WalletFile.CipherParams();
    cipherparams.setIv("Iv");
    WalletFile.Crypto crypto = new WalletFile.Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new WalletFile.Aes128CtrKdfParams());
    crypto.setMac("Mac");
    actualWalletFile.setCrypto(crypto);
    actualWalletFile.setId("42");
    actualWalletFile.setVersion(1);
    String actualAddress = actualWalletFile.getAddress();
    WalletFile.Crypto actualCrypto = actualWalletFile.getCrypto();
    String actualId = actualWalletFile.getId();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualAddress);
    assertEquals("42", actualId);
    assertEquals(1, actualWalletFile.getVersion());
    assertSame(crypto, actualCrypto);
  }
}
