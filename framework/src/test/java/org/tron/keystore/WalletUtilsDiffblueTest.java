package org.tron.keystore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WalletUtilsDiffblueTest {
  /**
   * Test {@link WalletUtils#getDefaultKeyDirectory()}.
   * <p>
   * Method under test: {@link WalletUtils#getDefaultKeyDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String WalletUtils.getDefaultKeyDirectory()"})
  public void testGetDefaultKeyDirectory() {
    // Arrange and Act
    String actualDefaultKeyDirectory = WalletUtils.getDefaultKeyDirectory();

    // Assert
    assertEquals(Paths.get(System.getProperty("user.home"), ".ethereum").toString(), actualDefaultKeyDirectory);
  }

  /**
   * Test {@link WalletUtils#getDefaultKeyDirectory(String)} with {@code String}.
   * <p>
   * Method under test: {@link WalletUtils#getDefaultKeyDirectory(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String WalletUtils.getDefaultKeyDirectory(String)"})
  public void testGetDefaultKeyDirectoryWithString() {
    // Arrange and Act
    String actualDefaultKeyDirectory = WalletUtils.getDefaultKeyDirectory("Os Name1");

    // Assert
    assertEquals(Paths.get(System.getProperty("user.home"), ".ethereum").toString(), actualDefaultKeyDirectory);
  }

  /**
   * Test {@link WalletUtils#getDefaultKeyDirectory(String)} with {@code String}.
   * <p>
   * Method under test: {@link WalletUtils#getDefaultKeyDirectory(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String WalletUtils.getDefaultKeyDirectory(String)"})
  public void testGetDefaultKeyDirectoryWithString2() {
    // Arrange and Act
    String actualDefaultKeyDirectory = WalletUtils.getDefaultKeyDirectory("mac");

    // Assert
    assertEquals(Paths.get(System.getProperty("user.home"), "Library", "Ethereum").toString(),
        actualDefaultKeyDirectory);
  }

  /**
   * Test {@link WalletUtils#getDefaultKeyDirectory(String)} with {@code String}.
   * <ul>
   *   <li>When {@code win}.</li>
   *   <li>Then return {@code null/Ethereum}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtils#getDefaultKeyDirectory(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String WalletUtils.getDefaultKeyDirectory(String)"})
  public void testGetDefaultKeyDirectoryWithString_whenWin_thenReturnNullEthereum() {
    // Arrange, Act and Assert
    assertEquals("null/Ethereum", WalletUtils.getDefaultKeyDirectory("win"));
  }

  /**
   * Test {@link WalletUtils#getTestnetKeyDirectory()}.
   * <p>
   * Method under test: {@link WalletUtils#getTestnetKeyDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String WalletUtils.getTestnetKeyDirectory()"})
  public void testGetTestnetKeyDirectory() {
    // Arrange and Act
    String actualTestnetKeyDirectory = WalletUtils.getTestnetKeyDirectory();

    // Assert
    assertEquals(Paths.get(System.getProperty("user.home"), ".ethereum", "testnet", "keystore").toString(),
        actualTestnetKeyDirectory);
  }

  /**
   * Test {@link WalletUtils#getMainnetKeyDirectory()}.
   * <p>
   * Method under test: {@link WalletUtils#getMainnetKeyDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String WalletUtils.getMainnetKeyDirectory()"})
  public void testGetMainnetKeyDirectory() {
    // Arrange and Act
    String actualMainnetKeyDirectory = WalletUtils.getMainnetKeyDirectory();

    // Assert
    assertEquals(Paths.get(System.getProperty("user.home"), ".ethereum", "keystore").toString(),
        actualMainnetKeyDirectory);
  }

  /**
   * Test {@link WalletUtils#passwordValid(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtils#passwordValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletUtils.passwordValid(String)"})
  public void testPasswordValid_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(WalletUtils.passwordValid(""));
  }

  /**
   * Test {@link WalletUtils#passwordValid(String)}.
   * <ul>
   *   <li>When {@code iloveyou}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtils#passwordValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletUtils.passwordValid(String)"})
  public void testPasswordValid_whenIloveyou_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(WalletUtils.passwordValid("iloveyou"));
  }

  /**
   * Test {@link WalletUtils#passwordValid(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtils#passwordValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletUtils.passwordValid(String)"})
  public void testPasswordValid_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(WalletUtils.passwordValid(null));
  }

  /**
   * Test {@link WalletUtils#passwordValid(String)}.
   * <ul>
   *   <li>When {@code \s+}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtils#passwordValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletUtils.passwordValid(String)"})
  public void testPasswordValid_whenS_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(WalletUtils.passwordValid("\\s+"));
  }
}
