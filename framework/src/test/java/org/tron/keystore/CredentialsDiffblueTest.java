package org.tron.keystore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.common.crypto.ECKey;
import org.tron.common.crypto.SignInterface;

public class CredentialsDiffblueTest {
  /**
   * Method under test: {@link Credentials#create(SignInterface)}
   */
  @Test
  public void testCreate() {
    // Arrange
    ECKey cryptoEngine = new ECKey();

    // Act and Assert
    assertSame(cryptoEngine, Credentials.create(cryptoEngine).getSignInterface());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Credentials#equals(Object)}
   *   <li>{@link Credentials#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Credentials createResult = Credentials.create(new ECKey());

    // Act and Assert
    assertEquals(createResult, createResult);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult.hashCode());
  }

  /**
   * Method under test: {@link Credentials#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Credentials createResult = Credentials.create(new ECKey());

    // Act and Assert
    assertNotEquals(createResult, Credentials.create(new ECKey()));
  }

  /**
   * Method under test: {@link Credentials#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws UnsupportedEncodingException {
    // Arrange
    ECKey cryptoEngine = mock(ECKey.class);
    when(cryptoEngine.getAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Credentials createResult = Credentials.create(cryptoEngine);

    // Act and Assert
    assertNotEquals(createResult, Credentials.create(new ECKey()));
  }

  /**
   * Method under test: {@link Credentials#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Credentials.create(new ECKey()), null);
  }

  /**
   * Method under test: {@link Credentials#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Credentials.create(new ECKey()), "Different type to Credentials");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Credentials#getAddress()}
   *   <li>{@link Credentials#getSignInterface()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ECKey cryptoEngine = new ECKey();
    Credentials createResult = Credentials.create(cryptoEngine);

    // Act
    createResult.getAddress();

    // Assert
    assertSame(cryptoEngine, createResult.getSignInterface());
  }
}
