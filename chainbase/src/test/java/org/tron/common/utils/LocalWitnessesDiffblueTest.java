package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LocalWitnessesDiffblueTest {
  /**
   * Test {@link LocalWitnesses#LocalWitnesses()}.
   *
   * <p>Method under test: {@link LocalWitnesses#LocalWitnesses()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.<init>()"})
  public void testNewLocalWitnesses() {
    // Arrange and Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses();

    // Assert
    assertNull(actualLocalWitnesses.getPublicKey());
    assertNull(actualLocalWitnesses.getPrivateKey());
    assertTrue(actualLocalWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Test {@link LocalWitnesses#LocalWitnesses(String)}.
   *
   * <p>Method under test: {@link LocalWitnesses#LocalWitnesses(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.<init>(String)"})
  public void testNewLocalWitnesses2() {
    // Arrange and Act
    LocalWitnesses actualLocalWitnesses =
        new LocalWitnesses("private key must be %d-bits hex string, actual: %dPrivate Keyapp");

    // Assert
    List<String> privateKeys = actualLocalWitnesses.getPrivateKeys();
    assertEquals(1, privateKeys.size());
    assertEquals(
        "private key must be %d-bits hex string, actual: %dPrivate Keyapp", privateKeys.get(0));
    assertEquals(
        "private key must be %d-bits hex string, actual: %dPrivate Keyapp",
        actualLocalWitnesses.getPrivateKey());
  }

  /**
   * Test {@link LocalWitnesses#LocalWitnesses(List)}.
   *
   * <ul>
   *   <li>Given {@code 0X}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 0X}.
   *   <li>Then return PrivateKey is {@code 0X}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.<init>(List)"})
  public void testNewLocalWitnesses_given0x_whenArrayListAdd0x_thenReturnPrivateKeyIs0x() {
    // Arrange
    ArrayList<String> privateKeys = new ArrayList<>();
    privateKeys.add("0X");
    privateKeys.add("");

    // Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses(privateKeys);

    // Assert
    assertEquals("0X", actualLocalWitnesses.getPrivateKey());
    assertSame(privateKeys, actualLocalWitnesses.getPrivateKeys());
  }

  /**
   * Test {@link LocalWitnesses#LocalWitnesses(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.<init>(List)"})
  public void testNewLocalWitnesses_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> privateKeys = new ArrayList<>();
    privateKeys.add("foo");
    privateKeys.add("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LocalWitnesses(privateKeys));
  }

  /**
   * Test {@link LocalWitnesses#LocalWitnesses(List)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.<init>(List)"})
  public void testNewLocalWitnesses_givenNotBlank_whenArrayListAddNotBlank() {
    // Arrange
    ArrayList<String> privateKeys = new ArrayList<>();
    privateKeys.add("not blank");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LocalWitnesses(privateKeys));
  }

  /**
   * Test {@link LocalWitnesses#LocalWitnesses(List)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>Then return PrivateKey is space.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.<init>(List)"})
  public void testNewLocalWitnesses_givenSpace_thenReturnPrivateKeyIsSpace() {
    // Arrange
    ArrayList<String> privateKeys = new ArrayList<>();
    privateKeys.add(" ");

    // Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses(privateKeys);

    // Assert
    assertEquals(" ", actualLocalWitnesses.getPrivateKey());
    assertSame(privateKeys, actualLocalWitnesses.getPrivateKeys());
  }

  /**
   * Test {@link LocalWitnesses#LocalWitnesses(String)}.
   *
   * <ul>
   *   <li>When {@code 0X}.
   *   <li>Then return PrivateKeys first is {@code 0X}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#LocalWitnesses(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.<init>(String)"})
  public void testNewLocalWitnesses_when0x_thenReturnPrivateKeysFirstIs0x() {
    // Arrange and Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses("0X");

    // Assert
    List<String> privateKeys = actualLocalWitnesses.getPrivateKeys();
    assertEquals(1, privateKeys.size());
    assertEquals("0X", privateKeys.get(0));
    assertEquals("0X", actualLocalWitnesses.getPrivateKey());
  }

  /**
   * Test {@link LocalWitnesses#LocalWitnesses(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return PublicKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.<init>(List)"})
  public void testNewLocalWitnesses_whenArrayList_thenReturnPublicKeyIsNull() {
    // Arrange and Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses(new ArrayList<>());

    // Assert
    assertNull(actualLocalWitnesses.getPublicKey());
    assertNull(actualLocalWitnesses.getPrivateKey());
    assertTrue(actualLocalWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Test {@link LocalWitnesses#LocalWitnesses(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return PublicKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.<init>(List)"})
  public void testNewLocalWitnesses_whenNull_thenReturnPublicKeyIsNull() {
    // Arrange and Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses((List<String>) null);

    // Assert
    assertNull(actualLocalWitnesses.getPublicKey());
    assertNull(actualLocalWitnesses.getPrivateKey());
    assertTrue(actualLocalWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Test {@link LocalWitnesses#LocalWitnesses(String)}.
   *
   * <ul>
   *   <li>When {@code Private Key}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#LocalWitnesses(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.<init>(String)"})
  public void testNewLocalWitnesses_whenPrivateKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LocalWitnesses("Private Key"));
  }

  /**
   * Test {@link LocalWitnesses#LocalWitnesses(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return PrivateKeys first is space.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#LocalWitnesses(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.<init>(String)"})
  public void testNewLocalWitnesses_whenSpace_thenReturnPrivateKeysFirstIsSpace() {
    // Arrange and Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses(" ");

    // Assert
    List<String> privateKeys = actualLocalWitnesses.getPrivateKeys();
    assertEquals(1, privateKeys.size());
    assertEquals(" ", privateKeys.get(0));
    assertEquals(" ", actualLocalWitnesses.getPrivateKey());
  }

  /**
   * Test {@link LocalWitnesses#getWitnessAccountAddress(boolean)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@code true}.
   *   <li>Then return array of {@code byte} with {@code A} and one.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#getWitnessAccountAddress(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LocalWitnesses.getWitnessAccountAddress(boolean)"})
  public void testGetWitnessAccountAddress_givenA_whenTrue_thenReturnArrayOfByteWithAAndOne() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();
    localWitnesses.setWitnessAccountAddress(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertArrayEquals(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, localWitnesses.getWitnessAccountAddress(true));
  }

  /**
   * Test {@link LocalWitnesses#setPrivateKeys(List)}.
   *
   * <ul>
   *   <li>Given {@code 0X}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 0X}.
   *   <li>Then {@link LocalWitnesses#LocalWitnesses()} PrivateKey is {@code 0X}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.setPrivateKeys(List)"})
  public void testSetPrivateKeys_given0x_whenArrayListAdd0x_thenLocalWitnessesPrivateKeyIs0x() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    ArrayList<String> privateKeys = new ArrayList<>();
    privateKeys.add("0X");
    privateKeys.add("");

    // Act
    localWitnesses.setPrivateKeys(privateKeys);

    // Assert
    assertEquals("0X", localWitnesses.getPrivateKey());
    assertSame(privateKeys, localWitnesses.getPrivateKeys());
  }

  /**
   * Test {@link LocalWitnesses#setPrivateKeys(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.setPrivateKeys(List)"})
  public void testSetPrivateKeys_givenFoo_whenArrayListAddFoo() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    ArrayList<String> privateKeys = new ArrayList<>();
    privateKeys.add("foo");
    privateKeys.add("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> localWitnesses.setPrivateKeys(privateKeys));
  }

  /**
   * Test {@link LocalWitnesses#setPrivateKeys(List)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.setPrivateKeys(List)"})
  public void testSetPrivateKeys_givenNotBlank_whenArrayListAddNotBlank() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    ArrayList<String> privateKeys = new ArrayList<>();
    privateKeys.add("not blank");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> localWitnesses.setPrivateKeys(privateKeys));
  }

  /**
   * Test {@link LocalWitnesses#setPrivateKeys(List)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>Then {@link LocalWitnesses#LocalWitnesses()} PrivateKey is space.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.setPrivateKeys(List)"})
  public void testSetPrivateKeys_givenSpace_thenLocalWitnessesPrivateKeyIsSpace() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    ArrayList<String> privateKeys = new ArrayList<>();
    privateKeys.add(" ");

    // Act
    localWitnesses.setPrivateKeys(privateKeys);

    // Assert
    assertEquals(" ", localWitnesses.getPrivateKey());
    assertSame(privateKeys, localWitnesses.getPrivateKeys());
  }

  /**
   * Test {@link LocalWitnesses#setPrivateKeys(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link LocalWitnesses#LocalWitnesses()} PrivateKeys Empty.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.setPrivateKeys(List)"})
  public void testSetPrivateKeys_whenArrayList_thenLocalWitnessesPrivateKeysEmpty() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    // Act
    localWitnesses.setPrivateKeys(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(localWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Test {@link LocalWitnesses#setPrivateKeys(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link LocalWitnesses#LocalWitnesses()} PrivateKeys Empty.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.setPrivateKeys(List)"})
  public void testSetPrivateKeys_whenNull_thenLocalWitnessesPrivateKeysEmpty() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    // Act
    localWitnesses.setPrivateKeys(null);

    // Assert that nothing has changed
    assertTrue(localWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Test {@link LocalWitnesses#addPrivateKeys(String)}.
   *
   * <ul>
   *   <li>When {@code 0X}.
   *   <li>Then {@link LocalWitnesses#LocalWitnesses()} PrivateKeys first is {@code 0X}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#addPrivateKeys(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.addPrivateKeys(String)"})
  public void testAddPrivateKeys_when0x_thenLocalWitnessesPrivateKeysFirstIs0x() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    // Act
    localWitnesses.addPrivateKeys("0X");

    // Assert
    List<String> privateKeys = localWitnesses.getPrivateKeys();
    assertEquals(1, privateKeys.size());
    assertEquals("0X", privateKeys.get(0));
    assertEquals("0X", localWitnesses.getPrivateKey());
  }

  /**
   * Test {@link LocalWitnesses#addPrivateKeys(String)}.
   *
   * <ul>
   *   <li>When {@code Private Key}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#addPrivateKeys(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.addPrivateKeys(String)"})
  public void testAddPrivateKeys_whenPrivateKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new LocalWitnesses().addPrivateKeys("Private Key"));
  }

  /**
   * Test {@link LocalWitnesses#addPrivateKeys(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then {@link LocalWitnesses#LocalWitnesses()} PrivateKeys first is space.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#addPrivateKeys(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalWitnesses.addPrivateKeys(String)"})
  public void testAddPrivateKeys_whenSpace_thenLocalWitnessesPrivateKeysFirstIsSpace() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    // Act
    localWitnesses.addPrivateKeys(" ");

    // Assert
    List<String> privateKeys = localWitnesses.getPrivateKeys();
    assertEquals(1, privateKeys.size());
    assertEquals(" ", privateKeys.get(0));
    assertEquals(" ", localWitnesses.getPrivateKey());
  }

  /**
   * Test {@link LocalWitnesses#getPrivateKey()}.
   *
   * <ul>
   *   <li>Given {@link LocalWitnesses#LocalWitnesses()} addPrivateKeys {@code 0X}.
   *   <li>Then return {@code 0X}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#getPrivateKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalWitnesses.getPrivateKey()"})
  public void testGetPrivateKey_givenLocalWitnessesAddPrivateKeys0x_thenReturn0x() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();
    localWitnesses.addPrivateKeys("0X");

    // Act and Assert
    assertEquals("0X", localWitnesses.getPrivateKey());
  }

  /**
   * Test {@link LocalWitnesses#getPrivateKey()}.
   *
   * <ul>
   *   <li>Given {@link LocalWitnesses#LocalWitnesses()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#getPrivateKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalWitnesses.getPrivateKey()"})
  public void testGetPrivateKey_givenLocalWitnesses_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new LocalWitnesses().getPrivateKey());
  }

  /**
   * Test {@link LocalWitnesses#getPublicKey()}.
   *
   * <ul>
   *   <li>Given {@link LocalWitnesses#LocalWitnesses()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LocalWitnesses#getPublicKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LocalWitnesses.getPublicKey()"})
  public void testGetPublicKey_givenLocalWitnesses_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new LocalWitnesses().getPublicKey());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocalWitnesses#setWitnessAccountAddress(byte[])}
   *   <li>{@link LocalWitnesses#getPrivateKeys()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LocalWitnesses.getPrivateKeys()",
    "void LocalWitnesses.setWitnessAccountAddress(byte[])"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    // Act
    localWitnesses.setWitnessAccountAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(localWitnesses.getPrivateKeys().isEmpty());
  }
}
