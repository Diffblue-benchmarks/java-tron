package org.tron.keystore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WalletUtilsDiffblueTest {
  /**
   * Test {@link WalletUtils#getDefaultKeyDirectory()}.
   *
   * <p>Method under test: {@link WalletUtils#getDefaultKeyDirectory()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String WalletUtils.getDefaultKeyDirectory()"})
  public void testGetDefaultKeyDirectory() {
    // Arrange, Act and Assert
    assertEquals(
        Paths.get(System.getProperty("user.home"), ".ethereum").toString(),
        WalletUtils.getDefaultKeyDirectory());
  }

  /**
   * Test {@link WalletUtils#getDefaultKeyDirectory(String)} with {@code String}.
   *
   * <p>Method under test: {@link WalletUtils#getDefaultKeyDirectory(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String WalletUtils.getDefaultKeyDirectory(String)"})
  public void testGetDefaultKeyDirectoryWithString() {
    // Arrange, Act and Assert
    assertEquals(
        Paths.get(System.getProperty("user.home"), ".ethereum").toString(),
        WalletUtils.getDefaultKeyDirectory("Os Name1"));
  }

  /**
   * Test {@link WalletUtils#getDefaultKeyDirectory(String)} with {@code String}.
   *
   * <p>Method under test: {@link WalletUtils#getDefaultKeyDirectory(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String WalletUtils.getDefaultKeyDirectory(String)"})
  public void testGetDefaultKeyDirectoryWithString2() {
    // Arrange, Act and Assert
    Path getResult = Paths.get(System.getProperty("user.home"), "Library", "Ethereum");
    assertEquals(getResult.toString(), WalletUtils.getDefaultKeyDirectory("mac"));
  }

  /**
   * Test {@link WalletUtils#getDefaultKeyDirectory(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code win}.
   *   <li>Then return {@code null/Ethereum}.
   * </ul>
   *
   * <p>Method under test: {@link WalletUtils#getDefaultKeyDirectory(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String WalletUtils.getDefaultKeyDirectory(String)"})
  public void testGetDefaultKeyDirectoryWithString_whenWin_thenReturnNullEthereum() {
    // Arrange, Act and Assert
    assertEquals("null/Ethereum", WalletUtils.getDefaultKeyDirectory("win"));
  }

  /**
   * Test {@link WalletUtils#getTestnetKeyDirectory()}.
   *
   * <p>Method under test: {@link WalletUtils#getTestnetKeyDirectory()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String WalletUtils.getTestnetKeyDirectory()"})
  public void testGetTestnetKeyDirectory() {
    // Arrange, Act and Assert
    Path getResult = Paths.get(System.getProperty("user.home"), ".ethereum", "testnet", "keystore");
    assertEquals(getResult.toString(), WalletUtils.getTestnetKeyDirectory());
  }

  /**
   * Test {@link WalletUtils#getMainnetKeyDirectory()}.
   *
   * <p>Method under test: {@link WalletUtils#getMainnetKeyDirectory()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String WalletUtils.getMainnetKeyDirectory()"})
  public void testGetMainnetKeyDirectory() {
    // Arrange, Act and Assert
    Path getResult = Paths.get(System.getProperty("user.home"), ".ethereum", "keystore");
    assertEquals(getResult.toString(), WalletUtils.getMainnetKeyDirectory());
  }

  /**
   * Test {@link WalletUtils#passwordValid(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WalletUtils#passwordValid(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WalletUtils.passwordValid(String)"})
  public void testPasswordValid_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(WalletUtils.passwordValid(""));
  }

  /**
   * Test {@link WalletUtils#passwordValid(String)}.
   *
   * <ul>
   *   <li>When {@code iloveyou}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WalletUtils#passwordValid(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WalletUtils.passwordValid(String)"})
  public void testPasswordValid_whenIloveyou_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(WalletUtils.passwordValid("iloveyou"));
  }

  /**
   * Test {@link WalletUtils#passwordValid(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WalletUtils#passwordValid(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WalletUtils.passwordValid(String)"})
  public void testPasswordValid_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(WalletUtils.passwordValid(null));
  }

  /**
   * Test {@link WalletUtils#passwordValid(String)}.
   *
   * <ul>
   *   <li>When {@code \s+}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WalletUtils#passwordValid(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WalletUtils.passwordValid(String)"})
  public void testPasswordValid_whenS_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(WalletUtils.passwordValid("\\s+"));
  }
}
