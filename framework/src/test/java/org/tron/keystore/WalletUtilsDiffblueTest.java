package org.tron.keystore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.nio.file.Paths;
import org.junit.Test;

public class WalletUtilsDiffblueTest {
  /**
   * Method under test: {@link WalletUtils#getDefaultKeyDirectory()}
   */
  @Test
  public void testGetDefaultKeyDirectory() {
    // Arrange and Act
    String actualDefaultKeyDirectory = WalletUtils.getDefaultKeyDirectory();

    // Assert
    assertEquals(Paths.get(System.getProperty("user.home"), ".ethereum").toString(), actualDefaultKeyDirectory);
  }

  /**
   * Method under test: {@link WalletUtils#getDefaultKeyDirectory(String)}
   */
  @Test
  public void testGetDefaultKeyDirectory2() {
    // Arrange and Act
    String actualDefaultKeyDirectory = WalletUtils.getDefaultKeyDirectory("Os Name1");

    // Assert
    assertEquals(Paths.get(System.getProperty("user.home"), ".ethereum").toString(), actualDefaultKeyDirectory);
  }

  /**
   * Method under test: {@link WalletUtils#getDefaultKeyDirectory(String)}
   */
  @Test
  public void testGetDefaultKeyDirectory3() {
    // Arrange and Act
    String actualDefaultKeyDirectory = WalletUtils.getDefaultKeyDirectory("mac");

    // Assert
    assertEquals(Paths.get(System.getProperty("user.home"), "Library", "Ethereum").toString(),
        actualDefaultKeyDirectory);
  }

  /**
   * Method under test: {@link WalletUtils#getDefaultKeyDirectory(String)}
   */
  @Test
  public void testGetDefaultKeyDirectory4() {
    // Arrange, Act and Assert
    assertEquals("null/Ethereum", WalletUtils.getDefaultKeyDirectory("win"));
  }

  /**
   * Method under test: {@link WalletUtils#getTestnetKeyDirectory()}
   */
  @Test
  public void testGetTestnetKeyDirectory() {
    // Arrange and Act
    String actualTestnetKeyDirectory = WalletUtils.getTestnetKeyDirectory();

    // Assert
    assertEquals(Paths.get(System.getProperty("user.home"), ".ethereum", "testnet", "keystore").toString(),
        actualTestnetKeyDirectory);
  }

  /**
   * Method under test: {@link WalletUtils#getMainnetKeyDirectory()}
   */
  @Test
  public void testGetMainnetKeyDirectory() {
    // Arrange and Act
    String actualMainnetKeyDirectory = WalletUtils.getMainnetKeyDirectory();

    // Assert
    assertEquals(Paths.get(System.getProperty("user.home"), ".ethereum", "keystore").toString(),
        actualMainnetKeyDirectory);
  }

  /**
   * Method under test: {@link WalletUtils#passwordValid(String)}
   */
  @Test
  public void testPasswordValid() {
    // Arrange, Act and Assert
    assertTrue(WalletUtils.passwordValid("iloveyou"));
    assertFalse(WalletUtils.passwordValid(null));
    assertFalse(WalletUtils.passwordValid("\\s+"));
    assertFalse(WalletUtils.passwordValid(""));
  }
}
