package org.tron.keystore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.crypto.ECKey;
import org.tron.common.crypto.SignInterface;
import org.tron.common.crypto.sm2.SM2;

public class CredentialsDiffblueTest {
  /**
   * Test {@link Credentials#create(SignInterface)} with {@code cryptoEngine}.
   * <ul>
   *   <li>When {@link ECKey#ECKey()}.</li>
   *   <li>Then return SignInterface is {@link ECKey#ECKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Credentials#create(SignInterface)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Credentials Credentials.create(SignInterface)"})
  public void testCreateWithCryptoEngine_whenECKey_thenReturnSignInterfaceIsECKey() {
    // Arrange
    ECKey cryptoEngine = new ECKey();

    // Act and Assert
    assertSame(cryptoEngine, Credentials.create(cryptoEngine).getSignInterface());
  }

  /**
   * Test {@link Credentials#create(SM2)} with {@code sm2Pair}.
   * <ul>
   *   <li>When {@link SM2#SM2()}.</li>
   *   <li>Then return SignInterface is {@link SM2#SM2()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Credentials#create(SM2)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Credentials Credentials.create(SM2)"})
  public void testCreateWithSm2Pair_whenSm2_thenReturnSignInterfaceIsSm2() {
    // Arrange
    SM2 sm2Pair = new SM2();

    // Act and Assert
    assertSame(sm2Pair, Credentials.create(sm2Pair).getSignInterface());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Credentials#getAddress()}
   *   <li>{@link Credentials#getSignInterface()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Credentials.getAddress()", "SignInterface Credentials.getSignInterface()"})
  public void testGettersAndSetters() {
    // Arrange
    ECKey cryptoEngine = new ECKey();
    Credentials createResult = Credentials.create(cryptoEngine);

    // Act
    createResult.getAddress();

    // Assert
    assertSame(cryptoEngine, createResult.getSignInterface());
  }

  /**
   * Test {@link Credentials#equals(Object)}, and {@link Credentials#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Credentials#equals(Object)}
   *   <li>{@link Credentials#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Credentials.equals(Object)", "int Credentials.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Credentials createResult = Credentials.create(new ECKey());

    // Act and Assert
    assertEquals(createResult, createResult);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult.hashCode());
  }

  /**
   * Test {@link Credentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Credentials#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Credentials.equals(Object)", "int Credentials.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Credentials createResult = Credentials.create(new ECKey());

    // Act and Assert
    assertNotEquals(createResult, Credentials.create(new ECKey()));
  }

  /**
   * Test {@link Credentials#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Credentials#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Credentials.equals(Object)", "int Credentials.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Credentials.create(new ECKey()), null);
  }

  /**
   * Test {@link Credentials#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Credentials#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Credentials.equals(Object)", "int Credentials.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Credentials.create(new ECKey()), "Different type to Credentials");
  }
}
