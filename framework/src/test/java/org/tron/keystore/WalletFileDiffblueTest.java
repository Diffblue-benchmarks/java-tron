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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.IOException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.keystore.WalletFile.Aes128CtrKdfParams;
import org.tron.keystore.WalletFile.CipherParams;
import org.tron.keystore.WalletFile.Crypto;
import org.tron.keystore.WalletFile.KdfParams;
import org.tron.keystore.WalletFile.KdfParamsDeserialiser;
import org.tron.keystore.WalletFile.ScryptKdfParams;

public class WalletFileDiffblueTest {
  /**
   * Test Aes128CtrKdfParams {@link Aes128CtrKdfParams#equals(Object)}, and {@link Aes128CtrKdfParams#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Aes128CtrKdfParams#equals(Object)}
   *   <li>{@link Aes128CtrKdfParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Aes128CtrKdfParams.equals(Object)", "int Aes128CtrKdfParams.hashCode()"})
  public void testAes128CtrKdfParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Aes128CtrKdfParams aes128CtrKdfParams = new Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt("Salt");

    Aes128CtrKdfParams aes128CtrKdfParams2 = new Aes128CtrKdfParams();
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
   * Test Aes128CtrKdfParams {@link Aes128CtrKdfParams#equals(Object)}, and {@link Aes128CtrKdfParams#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Aes128CtrKdfParams#equals(Object)}
   *   <li>{@link Aes128CtrKdfParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Aes128CtrKdfParams.equals(Object)", "int Aes128CtrKdfParams.hashCode()"})
  public void testAes128CtrKdfParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Aes128CtrKdfParams aes128CtrKdfParams = new Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf(null);
    aes128CtrKdfParams.setSalt("Salt");

    Aes128CtrKdfParams aes128CtrKdfParams2 = new Aes128CtrKdfParams();
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
   * Test Aes128CtrKdfParams {@link Aes128CtrKdfParams#equals(Object)}, and {@link Aes128CtrKdfParams#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Aes128CtrKdfParams#equals(Object)}
   *   <li>{@link Aes128CtrKdfParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Aes128CtrKdfParams.equals(Object)", "int Aes128CtrKdfParams.hashCode()"})
  public void testAes128CtrKdfParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Aes128CtrKdfParams aes128CtrKdfParams = new Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt(null);

    Aes128CtrKdfParams aes128CtrKdfParams2 = new Aes128CtrKdfParams();
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
   * Test Aes128CtrKdfParams {@link Aes128CtrKdfParams#equals(Object)}, and {@link Aes128CtrKdfParams#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Aes128CtrKdfParams#equals(Object)}
   *   <li>{@link Aes128CtrKdfParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Aes128CtrKdfParams.equals(Object)", "int Aes128CtrKdfParams.hashCode()"})
  public void testAes128CtrKdfParamsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Aes128CtrKdfParams aes128CtrKdfParams = new Aes128CtrKdfParams();
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
   * Test Aes128CtrKdfParams {@link Aes128CtrKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Aes128CtrKdfParams.equals(Object)", "int Aes128CtrKdfParams.hashCode()"})
  public void testAes128CtrKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Aes128CtrKdfParams aes128CtrKdfParams = new Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(3);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt("Salt");

    Aes128CtrKdfParams aes128CtrKdfParams2 = new Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf("Prf");
    aes128CtrKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
  }

  /**
   * Test Aes128CtrKdfParams {@link Aes128CtrKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Aes128CtrKdfParams.equals(Object)", "int Aes128CtrKdfParams.hashCode()"})
  public void testAes128CtrKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Aes128CtrKdfParams aes128CtrKdfParams = new Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(1);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt("Salt");

    Aes128CtrKdfParams aes128CtrKdfParams2 = new Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf("Prf");
    aes128CtrKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
  }

  /**
   * Test Aes128CtrKdfParams {@link Aes128CtrKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Aes128CtrKdfParams.equals(Object)", "int Aes128CtrKdfParams.hashCode()"})
  public void testAes128CtrKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Aes128CtrKdfParams aes128CtrKdfParams = new Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Salt");
    aes128CtrKdfParams.setSalt("Salt");

    Aes128CtrKdfParams aes128CtrKdfParams2 = new Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf("Prf");
    aes128CtrKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
  }

  /**
   * Test Aes128CtrKdfParams {@link Aes128CtrKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Aes128CtrKdfParams.equals(Object)", "int Aes128CtrKdfParams.hashCode()"})
  public void testAes128CtrKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Aes128CtrKdfParams aes128CtrKdfParams = new Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf(null);
    aes128CtrKdfParams.setSalt("Salt");

    Aes128CtrKdfParams aes128CtrKdfParams2 = new Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf("Prf");
    aes128CtrKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
  }

  /**
   * Test Aes128CtrKdfParams {@link Aes128CtrKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Aes128CtrKdfParams.equals(Object)", "int Aes128CtrKdfParams.hashCode()"})
  public void testAes128CtrKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Aes128CtrKdfParams aes128CtrKdfParams = new Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt(null);

    Aes128CtrKdfParams aes128CtrKdfParams2 = new Aes128CtrKdfParams();
    aes128CtrKdfParams2.setC(1);
    aes128CtrKdfParams2.setDklen(3);
    aes128CtrKdfParams2.setPrf("Prf");
    aes128CtrKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, aes128CtrKdfParams2);
  }

  /**
   * Test Aes128CtrKdfParams {@link Aes128CtrKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Aes128CtrKdfParams.equals(Object)", "int Aes128CtrKdfParams.hashCode()"})
  public void testAes128CtrKdfParamsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Aes128CtrKdfParams aes128CtrKdfParams = new Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, null);
  }

  /**
   * Test Aes128CtrKdfParams {@link Aes128CtrKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Aes128CtrKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Aes128CtrKdfParams.equals(Object)", "int Aes128CtrKdfParams.hashCode()"})
  public void testAes128CtrKdfParamsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Aes128CtrKdfParams aes128CtrKdfParams = new Aes128CtrKdfParams();
    aes128CtrKdfParams.setC(1);
    aes128CtrKdfParams.setDklen(3);
    aes128CtrKdfParams.setPrf("Prf");
    aes128CtrKdfParams.setSalt("Salt");

    // Act and Assert
    assertNotEquals(aes128CtrKdfParams, "Different type to Aes128CtrKdfParams");
  }

  /**
   * Test Aes128CtrKdfParams getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Aes128CtrKdfParams}
   *   <li>{@link Aes128CtrKdfParams#setC(int)}
   *   <li>{@link Aes128CtrKdfParams#setDklen(int)}
   *   <li>{@link Aes128CtrKdfParams#setPrf(String)}
   *   <li>{@link Aes128CtrKdfParams#setSalt(String)}
   *   <li>{@link Aes128CtrKdfParams#getC()}
   *   <li>{@link Aes128CtrKdfParams#getDklen()}
   *   <li>{@link Aes128CtrKdfParams#getPrf()}
   *   <li>{@link Aes128CtrKdfParams#getSalt()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Aes128CtrKdfParams.<init>()", "int Aes128CtrKdfParams.getC()",
      "int Aes128CtrKdfParams.getDklen()", "String Aes128CtrKdfParams.getPrf()", "String Aes128CtrKdfParams.getSalt()",
      "void Aes128CtrKdfParams.setC(int)", "void Aes128CtrKdfParams.setDklen(int)",
      "void Aes128CtrKdfParams.setPrf(String)", "void Aes128CtrKdfParams.setSalt(String)"})
  public void testAes128CtrKdfParamsGettersAndSetters() {
    // Arrange and Act
    Aes128CtrKdfParams actualAes128CtrKdfParams = new Aes128CtrKdfParams();
    actualAes128CtrKdfParams.setC(1);
    actualAes128CtrKdfParams.setDklen(3);
    actualAes128CtrKdfParams.setPrf("Prf");
    actualAes128CtrKdfParams.setSalt("Salt");
    int actualC = actualAes128CtrKdfParams.getC();
    int actualDklen = actualAes128CtrKdfParams.getDklen();
    String actualPrf = actualAes128CtrKdfParams.getPrf();

    // Assert
    assertEquals("Prf", actualPrf);
    assertEquals("Salt", actualAes128CtrKdfParams.getSalt());
    assertEquals(1, actualC);
    assertEquals(3, actualDklen);
  }

  /**
   * Test CipherParams {@link CipherParams#equals(Object)}, and {@link CipherParams#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CipherParams#equals(Object)}
   *   <li>{@link CipherParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CipherParams.equals(Object)", "int CipherParams.hashCode()"})
  public void testCipherParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CipherParams cipherParams = new CipherParams();
    cipherParams.setIv("Iv");

    CipherParams cipherParams2 = new CipherParams();
    cipherParams2.setIv("Iv");

    // Act and Assert
    assertEquals(cipherParams, cipherParams2);
    int expectedHashCodeResult = cipherParams.hashCode();
    assertEquals(expectedHashCodeResult, cipherParams2.hashCode());
  }

  /**
   * Test CipherParams {@link CipherParams#equals(Object)}, and {@link CipherParams#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CipherParams#equals(Object)}
   *   <li>{@link CipherParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CipherParams.equals(Object)", "int CipherParams.hashCode()"})
  public void testCipherParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CipherParams cipherParams = new CipherParams();
    cipherParams.setIv(null);

    CipherParams cipherParams2 = new CipherParams();
    cipherParams2.setIv(null);

    // Act and Assert
    assertEquals(cipherParams, cipherParams2);
    int expectedHashCodeResult = cipherParams.hashCode();
    assertEquals(expectedHashCodeResult, cipherParams2.hashCode());
  }

  /**
   * Test CipherParams {@link CipherParams#equals(Object)}, and {@link CipherParams#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CipherParams#equals(Object)}
   *   <li>{@link CipherParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CipherParams.equals(Object)", "int CipherParams.hashCode()"})
  public void testCipherParamsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CipherParams cipherParams = new CipherParams();
    cipherParams.setIv("Iv");

    // Act and Assert
    assertEquals(cipherParams, cipherParams);
    int expectedHashCodeResult = cipherParams.hashCode();
    assertEquals(expectedHashCodeResult, cipherParams.hashCode());
  }

  /**
   * Test CipherParams {@link CipherParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CipherParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CipherParams.equals(Object)", "int CipherParams.hashCode()"})
  public void testCipherParamsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CipherParams cipherParams = new CipherParams();
    cipherParams.setIv(null);

    CipherParams cipherParams2 = new CipherParams();
    cipherParams2.setIv("Iv");

    // Act and Assert
    assertNotEquals(cipherParams, cipherParams2);
  }

  /**
   * Test CipherParams {@link CipherParams#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CipherParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CipherParams.equals(Object)", "int CipherParams.hashCode()"})
  public void testCipherParamsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CipherParams cipherParams = new CipherParams();
    cipherParams.setIv("Iv");

    // Act and Assert
    assertNotEquals(cipherParams, null);
  }

  /**
   * Test CipherParams {@link CipherParams#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CipherParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CipherParams.equals(Object)", "int CipherParams.hashCode()"})
  public void testCipherParamsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CipherParams cipherParams = new CipherParams();
    cipherParams.setIv("Iv");

    // Act and Assert
    assertNotEquals(cipherParams, "Different type to CipherParams");
  }

  /**
   * Test CipherParams getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CipherParams}
   *   <li>{@link CipherParams#setIv(String)}
   *   <li>{@link CipherParams#getIv()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CipherParams.<init>()", "String CipherParams.getIv()", "void CipherParams.setIv(String)"})
  public void testCipherParamsGettersAndSetters() {
    // Arrange and Act
    CipherParams actualCipherParams = new CipherParams();
    actualCipherParams.setIv("Iv");

    // Assert
    assertEquals("Iv", actualCipherParams.getIv());
  }

  /**
   * Test Crypto {@link Crypto#equals(Object)}, and {@link Crypto#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Crypto#equals(Object)}
   *   <li>{@link Crypto#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Crypto.equals(Object)", "int Crypto.hashCode()"})
  public void testCryptoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    CipherParams cipherparams2 = new CipherParams();
    cipherparams2.setIv("Iv");

    Crypto crypto2 = new Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertEquals(crypto, crypto2);
    int expectedHashCodeResult = crypto.hashCode();
    assertEquals(expectedHashCodeResult, crypto2.hashCode());
  }

  /**
   * Test Crypto {@link Crypto#equals(Object)}, and {@link Crypto#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Crypto#equals(Object)}
   *   <li>{@link Crypto#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Crypto.equals(Object)", "int Crypto.hashCode()"})
  public void testCryptoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(crypto, crypto);
    int expectedHashCodeResult = crypto.hashCode();
    assertEquals(expectedHashCodeResult, crypto.hashCode());
  }

  /**
   * Test Crypto {@link Crypto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crypto#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Crypto.equals(Object)", "int Crypto.hashCode()"})
  public void testCryptoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher("Ciphertext");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
    crypto.setMac("Mac");

    CipherParams cipherparams2 = new CipherParams();
    cipherparams2.setIv("Iv");

    Crypto crypto2 = new Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertNotEquals(crypto, crypto2);
  }

  /**
   * Test Crypto {@link Crypto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crypto#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Crypto.equals(Object)", "int Crypto.hashCode()"})
  public void testCryptoEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher(null);
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
    crypto.setMac("Mac");

    CipherParams cipherparams2 = new CipherParams();
    cipherparams2.setIv("Iv");

    Crypto crypto2 = new Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertNotEquals(crypto, crypto2);
  }

  /**
   * Test Crypto {@link Crypto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crypto#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Crypto.equals(Object)", "int Crypto.hashCode()"})
  public void testCryptoEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CipherParams cipherparams = mock(CipherParams.class);
    doNothing().when(cipherparams).setIv(Mockito.<String>any());
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
    crypto.setMac("Mac");

    CipherParams cipherparams2 = new CipherParams();
    cipherparams2.setIv("Iv");

    Crypto crypto2 = new Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertNotEquals(crypto, crypto2);
  }

  /**
   * Test Crypto {@link Crypto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crypto#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Crypto.equals(Object)", "int Crypto.hashCode()"})
  public void testCryptoEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CipherParams cipherparams = mock(CipherParams.class);
    doNothing().when(cipherparams).setIv(Mockito.<String>any());
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Cipher");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
    crypto.setMac("Mac");

    CipherParams cipherparams2 = new CipherParams();
    cipherparams2.setIv("Iv");

    Crypto crypto2 = new Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertNotEquals(crypto, crypto2);
  }

  /**
   * Test Crypto {@link Crypto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crypto#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Crypto.equals(Object)", "int Crypto.hashCode()"})
  public void testCryptoEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CipherParams cipherparams = mock(CipherParams.class);
    doNothing().when(cipherparams).setIv(Mockito.<String>any());
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext(null);
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
    crypto.setMac("Mac");

    CipherParams cipherparams2 = new CipherParams();
    cipherparams2.setIv("Iv");

    Crypto crypto2 = new Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertNotEquals(crypto, crypto2);
  }

  /**
   * Test Crypto {@link Crypto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crypto#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Crypto.equals(Object)", "int Crypto.hashCode()"})
  public void testCryptoEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CipherParams cipherparams = mock(CipherParams.class);
    doNothing().when(cipherparams).setIv(Mockito.<String>any());
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext(null);
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
    crypto.setMac("Mac");

    CipherParams cipherparams2 = new CipherParams();
    cipherparams2.setIv("Iv");

    Crypto crypto2 = new Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext(null);
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new Aes128CtrKdfParams());
    crypto2.setMac("Mac");

    // Act and Assert
    assertNotEquals(crypto, crypto2);
  }

  /**
   * Test Crypto {@link Crypto#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crypto#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Crypto.equals(Object)", "int Crypto.hashCode()"})
  public void testCryptoEquals_whenOtherIsNull_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(crypto, null);
  }

  /**
   * Test Crypto {@link Crypto#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crypto#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Crypto.equals(Object)", "int Crypto.hashCode()"})
  public void testCryptoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(crypto, "Different type to Crypto");
  }

  /**
   * Test Crypto getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Crypto}
   *   <li>{@link Crypto#setCipher(String)}
   *   <li>{@link Crypto#setCipherparams(CipherParams)}
   *   <li>{@link Crypto#setCiphertext(String)}
   *   <li>{@link Crypto#setKdf(String)}
   *   <li>{@link Crypto#setKdfparams(KdfParams)}
   *   <li>{@link Crypto#setMac(String)}
   *   <li>{@link Crypto#getCipher()}
   *   <li>{@link Crypto#getCipherparams()}
   *   <li>{@link Crypto#getCiphertext()}
   *   <li>{@link Crypto#getKdf()}
   *   <li>{@link Crypto#getKdfparams()}
   *   <li>{@link Crypto#getMac()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Crypto.<init>()", "String Crypto.getCipher()", "CipherParams Crypto.getCipherparams()",
      "String Crypto.getCiphertext()", "String Crypto.getKdf()", "KdfParams Crypto.getKdfparams()",
      "String Crypto.getMac()", "void Crypto.setCipher(String)", "void Crypto.setCipherparams(CipherParams)",
      "void Crypto.setCiphertext(String)", "void Crypto.setKdf(String)", "void Crypto.setKdfparams(KdfParams)",
      "void Crypto.setMac(String)"})
  public void testCryptoGettersAndSetters() {
    // Arrange and Act
    Crypto actualCrypto = new Crypto();
    actualCrypto.setCipher("Cipher");
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");
    actualCrypto.setCipherparams(cipherparams);
    actualCrypto.setCiphertext("Ciphertext");
    actualCrypto.setKdf("Kdf");
    Aes128CtrKdfParams kdfparams = new Aes128CtrKdfParams();
    actualCrypto.setKdfparams(kdfparams);
    actualCrypto.setMac("Mac");
    String actualCipher = actualCrypto.getCipher();
    CipherParams actualCipherparams = actualCrypto.getCipherparams();
    String actualCiphertext = actualCrypto.getCiphertext();
    String actualKdf = actualCrypto.getKdf();
    KdfParams actualKdfparams = actualCrypto.getKdfparams();
    String actualMac = actualCrypto.getMac();

    // Assert
    assertEquals("Cipher", actualCipher);
    assertEquals("Ciphertext", actualCiphertext);
    assertEquals("Iv", actualCipherparams.getIv());
    assertEquals("Kdf", actualKdf);
    assertEquals("Mac", actualMac);
    assertSame(kdfparams, actualKdfparams);
    assertSame(cipherparams, actualCipherparams);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link WalletFile}
   *   <li>{@link WalletFile#setAddress(String)}
   *   <li>{@link WalletFile#setCrypto(Crypto)}
   *   <li>{@link WalletFile#setId(String)}
   *   <li>{@link WalletFile#setVersion(int)}
   *   <li>{@link WalletFile#getAddress()}
   *   <li>{@link WalletFile#getCrypto()}
   *   <li>{@link WalletFile#getId()}
   *   <li>{@link WalletFile#getVersion()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletFile.<init>()", "String WalletFile.getAddress()", "Crypto WalletFile.getCrypto()",
      "String WalletFile.getId()", "int WalletFile.getVersion()", "void WalletFile.setAddress(String)",
      "void WalletFile.setCrypto(Crypto)", "void WalletFile.setId(String)", "void WalletFile.setVersion(int)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    WalletFile actualWalletFile = new WalletFile();
    actualWalletFile.setAddress("42 Main St");
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");
    Crypto crypto = new Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
    crypto.setMac("Mac");
    actualWalletFile.setCrypto(crypto);
    actualWalletFile.setId("42");
    actualWalletFile.setVersion(1);
    String actualAddress = actualWalletFile.getAddress();
    Crypto actualCrypto = actualWalletFile.getCrypto();
    String actualId = actualWalletFile.getId();

    // Assert
    assertEquals("42 Main St", actualAddress);
    assertEquals("42", actualId);
    assertEquals(1, actualWalletFile.getVersion());
    assertSame(crypto, actualCrypto);
  }

  /**
   * Test KdfParamsDeserialiser {@link KdfParamsDeserialiser#deserialize(JsonParser, DeserializationContext)} with {@code jsonParser}, {@code deserializationContext}.
   * <p>
   * Method under test: {@link KdfParamsDeserialiser#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KdfParams KdfParamsDeserialiser.deserialize(JsonParser, DeserializationContext)"})
  public void testKdfParamsDeserialiserDeserializeWithJsonParserDeserializationContext() throws IOException {
    // Arrange
    KdfParamsDeserialiser kdfParamsDeserialiser = new KdfParamsDeserialiser();
    JsonParser d = mock(JsonParser.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act
    KdfParams actualDeserializeResult = kdfParamsDeserialiser.deserialize(jsonParser,
        new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig())));

    // Assert
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).nextToken();
    assertTrue(actualDeserializeResult instanceof Aes128CtrKdfParams);
    assertNull(((Aes128CtrKdfParams) actualDeserializeResult).getPrf());
    assertNull(actualDeserializeResult.getSalt());
    assertEquals(0, ((Aes128CtrKdfParams) actualDeserializeResult).getC());
    assertEquals(0, actualDeserializeResult.getDklen());
  }

  /**
   * Test KdfParamsDeserialiser {@link KdfParamsDeserialiser#deserialize(JsonParser, DeserializationContext)} with {@code jsonParser}, {@code deserializationContext}.
   * <p>
   * Method under test: {@link KdfParamsDeserialiser#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KdfParams KdfParamsDeserialiser.deserialize(JsonParser, DeserializationContext)"})
  public void testKdfParamsDeserialiserDeserializeWithJsonParserDeserializationContext2() throws IOException {
    // Arrange
    KdfParamsDeserialiser kdfParamsDeserialiser = new KdfParamsDeserialiser();
    JsonParser d = mock(JsonParser.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.currentToken()).thenReturn(null);
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act
    KdfParams actualDeserializeResult = kdfParamsDeserialiser.deserialize(jsonParser,
        new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig())));

    // Assert
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d, atLeast(1)).nextToken();
    assertTrue(actualDeserializeResult instanceof Aes128CtrKdfParams);
    assertNull(((Aes128CtrKdfParams) actualDeserializeResult).getPrf());
    assertNull(actualDeserializeResult.getSalt());
    assertEquals(0, ((Aes128CtrKdfParams) actualDeserializeResult).getC());
    assertEquals(0, actualDeserializeResult.getDklen());
  }

  /**
   * Test KdfParamsDeserialiser {@link KdfParamsDeserialiser#deserialize(JsonParser, DeserializationContext)} with {@code jsonParser}, {@code deserializationContext}.
   * <p>
   * Method under test: {@link KdfParamsDeserialiser#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KdfParams KdfParamsDeserialiser.deserialize(JsonParser, DeserializationContext)"})
  public void testKdfParamsDeserialiserDeserializeWithJsonParserDeserializationContext3() throws IOException {
    // Arrange
    KdfParamsDeserialiser kdfParamsDeserialiser = new KdfParamsDeserialiser();
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper buildResult = builderResult.findAndAddModules().build();
    JsonParser d = mock(JsonParser.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(buildResult);
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act
    KdfParams actualDeserializeResult = kdfParamsDeserialiser.deserialize(jsonParser,
        new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig())));

    // Assert
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).nextToken();
    assertTrue(actualDeserializeResult instanceof Aes128CtrKdfParams);
    assertNull(((Aes128CtrKdfParams) actualDeserializeResult).getPrf());
    assertNull(actualDeserializeResult.getSalt());
    assertEquals(0, ((Aes128CtrKdfParams) actualDeserializeResult).getC());
    assertEquals(0, actualDeserializeResult.getDklen());
  }

  /**
   * Test KdfParamsDeserialiser new {@link KdfParamsDeserialiser} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link KdfParamsDeserialiser}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KdfParamsDeserialiser.<init>()"})
  public void testKdfParamsDeserialiserNewKdfParamsDeserialiser() {
    // Arrange and Act
    KdfParamsDeserialiser actualKdfParamsDeserialiser = new KdfParamsDeserialiser();

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
   * Test ScryptKdfParams {@link ScryptKdfParams#equals(Object)}, and {@link ScryptKdfParams#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ScryptKdfParams#equals(Object)}
   *   <li>{@link ScryptKdfParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScryptKdfParams.equals(Object)", "int ScryptKdfParams.hashCode()"})
  public void testScryptKdfParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ScryptKdfParams scryptKdfParams = new ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    ScryptKdfParams scryptKdfParams2 = new ScryptKdfParams();
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
   * Test ScryptKdfParams {@link ScryptKdfParams#equals(Object)}, and {@link ScryptKdfParams#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ScryptKdfParams#equals(Object)}
   *   <li>{@link ScryptKdfParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScryptKdfParams.equals(Object)", "int ScryptKdfParams.hashCode()"})
  public void testScryptKdfParamsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ScryptKdfParams scryptKdfParams = new ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt(null);

    ScryptKdfParams scryptKdfParams2 = new ScryptKdfParams();
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
   * Test ScryptKdfParams {@link ScryptKdfParams#equals(Object)}, and {@link ScryptKdfParams#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ScryptKdfParams#equals(Object)}
   *   <li>{@link ScryptKdfParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScryptKdfParams.equals(Object)", "int ScryptKdfParams.hashCode()"})
  public void testScryptKdfParamsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ScryptKdfParams scryptKdfParams = new ScryptKdfParams();
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
   * Test ScryptKdfParams {@link ScryptKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScryptKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScryptKdfParams.equals(Object)", "int ScryptKdfParams.hashCode()"})
  public void testScryptKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ScryptKdfParams scryptKdfParams = new ScryptKdfParams();
    scryptKdfParams.setDklen(1);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    ScryptKdfParams scryptKdfParams2 = new ScryptKdfParams();
    scryptKdfParams2.setDklen(3);
    scryptKdfParams2.setN(1);
    scryptKdfParams2.setP(1);
    scryptKdfParams2.setR(1);
    scryptKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, scryptKdfParams2);
  }

  /**
   * Test ScryptKdfParams {@link ScryptKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScryptKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScryptKdfParams.equals(Object)", "int ScryptKdfParams.hashCode()"})
  public void testScryptKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ScryptKdfParams scryptKdfParams = new ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(3);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    ScryptKdfParams scryptKdfParams2 = new ScryptKdfParams();
    scryptKdfParams2.setDklen(3);
    scryptKdfParams2.setN(1);
    scryptKdfParams2.setP(1);
    scryptKdfParams2.setR(1);
    scryptKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, scryptKdfParams2);
  }

  /**
   * Test ScryptKdfParams {@link ScryptKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScryptKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScryptKdfParams.equals(Object)", "int ScryptKdfParams.hashCode()"})
  public void testScryptKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ScryptKdfParams scryptKdfParams = new ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(3);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    ScryptKdfParams scryptKdfParams2 = new ScryptKdfParams();
    scryptKdfParams2.setDklen(3);
    scryptKdfParams2.setN(1);
    scryptKdfParams2.setP(1);
    scryptKdfParams2.setR(1);
    scryptKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, scryptKdfParams2);
  }

  /**
   * Test ScryptKdfParams {@link ScryptKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScryptKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScryptKdfParams.equals(Object)", "int ScryptKdfParams.hashCode()"})
  public void testScryptKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ScryptKdfParams scryptKdfParams = new ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(3);
    scryptKdfParams.setSalt("Salt");

    ScryptKdfParams scryptKdfParams2 = new ScryptKdfParams();
    scryptKdfParams2.setDklen(3);
    scryptKdfParams2.setN(1);
    scryptKdfParams2.setP(1);
    scryptKdfParams2.setR(1);
    scryptKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, scryptKdfParams2);
  }

  /**
   * Test ScryptKdfParams {@link ScryptKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScryptKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScryptKdfParams.equals(Object)", "int ScryptKdfParams.hashCode()"})
  public void testScryptKdfParamsEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ScryptKdfParams scryptKdfParams = new ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt(null);

    ScryptKdfParams scryptKdfParams2 = new ScryptKdfParams();
    scryptKdfParams2.setDklen(3);
    scryptKdfParams2.setN(1);
    scryptKdfParams2.setP(1);
    scryptKdfParams2.setR(1);
    scryptKdfParams2.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, scryptKdfParams2);
  }

  /**
   * Test ScryptKdfParams {@link ScryptKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScryptKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScryptKdfParams.equals(Object)", "int ScryptKdfParams.hashCode()"})
  public void testScryptKdfParamsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ScryptKdfParams scryptKdfParams = new ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, null);
  }

  /**
   * Test ScryptKdfParams {@link ScryptKdfParams#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScryptKdfParams#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScryptKdfParams.equals(Object)", "int ScryptKdfParams.hashCode()"})
  public void testScryptKdfParamsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ScryptKdfParams scryptKdfParams = new ScryptKdfParams();
    scryptKdfParams.setDklen(3);
    scryptKdfParams.setN(1);
    scryptKdfParams.setP(1);
    scryptKdfParams.setR(1);
    scryptKdfParams.setSalt("Salt");

    // Act and Assert
    assertNotEquals(scryptKdfParams, "Different type to ScryptKdfParams");
  }

  /**
   * Test ScryptKdfParams getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ScryptKdfParams}
   *   <li>{@link ScryptKdfParams#setDklen(int)}
   *   <li>{@link ScryptKdfParams#setN(int)}
   *   <li>{@link ScryptKdfParams#setP(int)}
   *   <li>{@link ScryptKdfParams#setR(int)}
   *   <li>{@link ScryptKdfParams#setSalt(String)}
   *   <li>{@link ScryptKdfParams#getDklen()}
   *   <li>{@link ScryptKdfParams#getN()}
   *   <li>{@link ScryptKdfParams#getP()}
   *   <li>{@link ScryptKdfParams#getR()}
   *   <li>{@link ScryptKdfParams#getSalt()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScryptKdfParams.<init>()", "int ScryptKdfParams.getDklen()", "int ScryptKdfParams.getN()",
      "int ScryptKdfParams.getP()", "int ScryptKdfParams.getR()", "String ScryptKdfParams.getSalt()",
      "void ScryptKdfParams.setDklen(int)", "void ScryptKdfParams.setN(int)", "void ScryptKdfParams.setP(int)",
      "void ScryptKdfParams.setR(int)", "void ScryptKdfParams.setSalt(String)"})
  public void testScryptKdfParamsGettersAndSetters() {
    // Arrange and Act
    ScryptKdfParams actualScryptKdfParams = new ScryptKdfParams();
    actualScryptKdfParams.setDklen(3);
    actualScryptKdfParams.setN(1);
    actualScryptKdfParams.setP(1);
    actualScryptKdfParams.setR(1);
    actualScryptKdfParams.setSalt("Salt");
    int actualDklen = actualScryptKdfParams.getDklen();
    int actualN = actualScryptKdfParams.getN();
    int actualP = actualScryptKdfParams.getP();
    int actualR = actualScryptKdfParams.getR();

    // Assert
    assertEquals("Salt", actualScryptKdfParams.getSalt());
    assertEquals(1, actualN);
    assertEquals(1, actualP);
    assertEquals(1, actualR);
    assertEquals(3, actualDklen);
  }

  /**
   * Test {@link WalletFile#setCryptoV1(Crypto)}.
   * <p>
   * Method under test: {@link WalletFile#setCryptoV1(Crypto)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletFile.setCryptoV1(Crypto)"})
  public void testSetCryptoV1() {
    // Arrange
    WalletFile walletFile = new WalletFile();

    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");

    Crypto crypto = new Crypto();
    crypto.setCipher("Cipher");
    crypto.setCipherparams(cipherparams);
    crypto.setCiphertext("Ciphertext");
    crypto.setKdf("Kdf");
    crypto.setKdfparams(new Aes128CtrKdfParams());
    crypto.setMac("Mac");

    // Act
    walletFile.setCryptoV1(crypto);

    // Assert
    assertSame(crypto, walletFile.getCrypto());
  }

  /**
   * Test {@link WalletFile#equals(Object)}, and {@link WalletFile#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile#equals(Object)}
   *   <li>{@link WalletFile#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletFile.equals(Object)", "int WalletFile.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    CipherParams cipherparams2 = new CipherParams();
    cipherparams2.setIv("Iv");

    Crypto crypto2 = new Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new Aes128CtrKdfParams());
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
   * Test {@link WalletFile#equals(Object)}, and {@link WalletFile#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WalletFile#equals(Object)}
   *   <li>{@link WalletFile#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletFile.equals(Object)", "int WalletFile.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
    assertEquals(walletFile, walletFile);
    int expectedHashCodeResult = walletFile.hashCode();
    assertEquals(expectedHashCodeResult, walletFile.hashCode());
  }

  /**
   * Test {@link WalletFile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletFile#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletFile.equals(Object)", "int WalletFile.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
    walletFile.setAddress("17 High St");
    walletFile.setCrypto(crypto);
    walletFile.setId("42");
    walletFile.setVersion(1);

    CipherParams cipherparams2 = new CipherParams();
    cipherparams2.setIv("Iv");

    Crypto crypto2 = new Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new Aes128CtrKdfParams());
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
   * Test {@link WalletFile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletFile#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletFile.equals(Object)", "int WalletFile.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
    walletFile.setAddress(null);
    walletFile.setCrypto(crypto);
    walletFile.setId("42");
    walletFile.setVersion(1);

    CipherParams cipherparams2 = new CipherParams();
    cipherparams2.setIv("Iv");

    Crypto crypto2 = new Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new Aes128CtrKdfParams());
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
   * Test {@link WalletFile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletFile#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletFile.equals(Object)", "int WalletFile.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CipherParams cipherparams = new CipherParams();
    cipherparams.setIv("Iv");
    Crypto crypto = mock(Crypto.class);
    doNothing().when(crypto).setCipher(Mockito.<String>any());
    doNothing().when(crypto).setCipherparams(Mockito.<CipherParams>any());
    doNothing().when(crypto).setCiphertext(Mockito.<String>any());
    doNothing().when(crypto).setKdf(Mockito.<String>any());
    doNothing().when(crypto).setKdfparams(Mockito.<KdfParams>any());
    doNothing().when(crypto).setMac(Mockito.<String>any());
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

    CipherParams cipherparams2 = new CipherParams();
    cipherparams2.setIv("Iv");

    Crypto crypto2 = new Crypto();
    crypto2.setCipher("Cipher");
    crypto2.setCipherparams(cipherparams2);
    crypto2.setCiphertext("Ciphertext");
    crypto2.setKdf("Kdf");
    crypto2.setKdfparams(new Aes128CtrKdfParams());
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
   * Test {@link WalletFile#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletFile#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletFile.equals(Object)", "int WalletFile.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
    assertNotEquals(walletFile, null);
  }

  /**
   * Test {@link WalletFile#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletFile#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletFile.equals(Object)", "int WalletFile.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
    assertNotEquals(walletFile, "Different type to WalletFile");
  }
}
