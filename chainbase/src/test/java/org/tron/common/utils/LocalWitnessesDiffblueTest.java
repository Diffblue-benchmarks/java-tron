package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class LocalWitnessesDiffblueTest {
  /**
   * Method under test: {@link LocalWitnesses#getWitnessAccountAddress(boolean)}
   */
  @Test
  public void testGetWitnessAccountAddress() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();
    localWitnesses.setWitnessAccountAddress(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, localWitnesses.getWitnessAccountAddress(true));
  }

  /**
   * Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  public void testSetPrivateKeys() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    // Act
    localWitnesses.setPrivateKeys(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(localWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  public void testSetPrivateKeys2() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    ArrayList<String> privateKeys = new ArrayList<>();
    privateKeys.add("Private Keys");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> localWitnesses.setPrivateKeys(privateKeys));
  }

  /**
   * Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  public void testSetPrivateKeys3() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    // Act
    localWitnesses.setPrivateKeys(null);

    // Assert that nothing has changed
    assertTrue(localWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  public void testSetPrivateKeys4() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    ArrayList<String> privateKeys = new ArrayList<>();
    privateKeys.add("foo");
    privateKeys.add("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> localWitnesses.setPrivateKeys(privateKeys));
  }

  /**
   * Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  public void testSetPrivateKeys5() {
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
   * Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  public void testSetPrivateKeys6() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();
    COWArrayList<String> privateKeys = mock(COWArrayList.class);
    when(privateKeys.isEmpty()).thenReturn(true);

    // Act
    localWitnesses.setPrivateKeys(privateKeys);

    // Assert that nothing has changed
    verify(privateKeys).isEmpty();
    assertTrue(localWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Method under test: {@link LocalWitnesses#setPrivateKeys(List)}
   */
  @Test
  public void testSetPrivateKeys7() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();
    COWArrayList<String> privateKeys = mock(COWArrayList.class);
    when(privateKeys.isEmpty()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> localWitnesses.setPrivateKeys(privateKeys));
    verify(privateKeys).isEmpty();
  }

  /**
   * Method under test: {@link LocalWitnesses#addPrivateKeys(String)}
   */
  @Test
  public void testAddPrivateKeys() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new LocalWitnesses()).addPrivateKeys("Private Key"));
  }

  /**
   * Method under test: {@link LocalWitnesses#addPrivateKeys(String)}
   */
  @Test
  public void testAddPrivateKeys2() {
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
   * Method under test: {@link LocalWitnesses#getPrivateKey()}
   */
  @Test
  public void testGetPrivateKey() {
    // Arrange, Act and Assert
    assertNull((new LocalWitnesses()).getPrivateKey());
  }

  /**
   * Method under test: {@link LocalWitnesses#getPrivateKey()}
   */
  @Test
  public void testGetPrivateKey2() {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();
    localWitnesses.addPrivateKeys("0X");

    // Act and Assert
    assertEquals("0X", localWitnesses.getPrivateKey());
  }

  /**
   * Method under test: {@link LocalWitnesses#getPrivateKey()}
   */
  @Test
  public void testGetPrivateKey3() {
    // Arrange
    COWArrayList<String> privateKeys = mock(COWArrayList.class);
    when(privateKeys.isEmpty()).thenReturn(true);

    LocalWitnesses localWitnesses = new LocalWitnesses();
    localWitnesses.setPrivateKeys(privateKeys);

    // Act
    String actualPrivateKey = localWitnesses.getPrivateKey();

    // Assert
    verify(privateKeys).isEmpty();
    assertNull(actualPrivateKey);
  }

  /**
   * Method under test: {@link LocalWitnesses#getPrivateKey()}
   */
  @Test
  public void testGetPrivateKey4() {
    // Arrange
    COWArrayList<String> privateKeys = mock(COWArrayList.class);
    when(privateKeys.get(anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(privateKeys.isEmpty()).thenReturn(false);

    ArrayList<String> stringList = new ArrayList<>();
    when(privateKeys.iterator()).thenReturn(stringList.iterator());

    LocalWitnesses localWitnesses = new LocalWitnesses();
    localWitnesses.setPrivateKeys(privateKeys);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> localWitnesses.getPrivateKey());
    verify(privateKeys).get(eq(0));
    verify(privateKeys, atLeast(1)).isEmpty();
    verify(privateKeys).iterator();
  }

  /**
   * Method under test: {@link LocalWitnesses#getPublicKey()}
   */
  @Test
  public void testGetPublicKey() {
    // Arrange, Act and Assert
    assertNull((new LocalWitnesses()).getPublicKey());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LocalWitnesses#setWitnessAccountAddress(byte[])}
   *   <li>{@link LocalWitnesses#getPrivateKeys()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    LocalWitnesses localWitnesses = new LocalWitnesses();

    // Act
    localWitnesses.setWitnessAccountAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertTrue(localWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Method under test: {@link LocalWitnesses#LocalWitnesses()}
   */
  @Test
  public void testNewLocalWitnesses() {
    // Arrange and Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses();

    // Assert
    assertNull(actualLocalWitnesses.getPublicKey());
    assertNull(actualLocalWitnesses.getPrivateKey());
    assertTrue(actualLocalWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Method under test: {@link LocalWitnesses#LocalWitnesses(String)}
   */
  @Test
  public void testNewLocalWitnesses2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LocalWitnesses("Private Key"));
  }

  /**
   * Method under test: {@link LocalWitnesses#LocalWitnesses(String)}
   */
  @Test
  public void testNewLocalWitnesses3() {
    // Arrange and Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses("0X");

    // Assert
    List<String> privateKeys = actualLocalWitnesses.getPrivateKeys();
    assertEquals(1, privateKeys.size());
    assertEquals("0X", privateKeys.get(0));
    assertEquals("0X", actualLocalWitnesses.getPrivateKey());
  }

  /**
   * Method under test: {@link LocalWitnesses#LocalWitnesses(String)}
   */
  @Test
  public void testNewLocalWitnesses4() {
    // Arrange and Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses(
        "private key must be %d-bits hex string, actual: %dPrivate Keyapp");

    // Assert
    List<String> privateKeys = actualLocalWitnesses.getPrivateKeys();
    assertEquals(1, privateKeys.size());
    assertEquals("private key must be %d-bits hex string, actual: %dPrivate Keyapp", privateKeys.get(0));
    assertEquals("private key must be %d-bits hex string, actual: %dPrivate Keyapp",
        actualLocalWitnesses.getPrivateKey());
  }

  /**
   * Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  public void testNewLocalWitnesses5() {
    // Arrange and Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses(new ArrayList<>());

    // Assert
    assertNull(actualLocalWitnesses.getPublicKey());
    assertNull(actualLocalWitnesses.getPrivateKey());
    assertTrue(actualLocalWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  public void testNewLocalWitnesses6() {
    // Arrange
    ArrayList<String> privateKeys = new ArrayList<>();
    privateKeys.add("Private Keys");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LocalWitnesses(privateKeys));
  }

  /**
   * Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  public void testNewLocalWitnesses7() {
    // Arrange and Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses((List<String>) null);

    // Assert
    assertNull(actualLocalWitnesses.getPublicKey());
    assertNull(actualLocalWitnesses.getPrivateKey());
    assertTrue(actualLocalWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  public void testNewLocalWitnesses8() {
    // Arrange
    ArrayList<String> privateKeys = new ArrayList<>();
    privateKeys.add("foo");
    privateKeys.add("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LocalWitnesses(privateKeys));
  }

  /**
   * Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  public void testNewLocalWitnesses9() {
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
   * Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  public void testNewLocalWitnesses10() {
    // Arrange
    COWArrayList<String> privateKeys = mock(COWArrayList.class);
    when(privateKeys.isEmpty()).thenReturn(true);

    // Act
    LocalWitnesses actualLocalWitnesses = new LocalWitnesses(privateKeys);

    // Assert
    verify(privateKeys).isEmpty();
    assertNull(actualLocalWitnesses.getPublicKey());
    assertNull(actualLocalWitnesses.getPrivateKey());
    assertTrue(actualLocalWitnesses.getPrivateKeys().isEmpty());
  }

  /**
   * Method under test: {@link LocalWitnesses#LocalWitnesses(List)}
   */
  @Test
  public void testNewLocalWitnesses11() {
    // Arrange
    COWArrayList<String> privateKeys = mock(COWArrayList.class);
    when(privateKeys.isEmpty()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LocalWitnesses(privateKeys));
    verify(privateKeys).isEmpty();
  }
}
