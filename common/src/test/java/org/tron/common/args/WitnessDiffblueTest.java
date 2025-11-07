package org.tron.common.args;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class WitnessDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Witness}
   *   <li>{@link Witness#setVoteCount(long)}
   *   <li>{@link Witness#getAddress()}
   *   <li>{@link Witness#getUrl()}
   *   <li>{@link Witness#getVoteCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Witness actualWitness = new Witness();
    actualWitness.setVoteCount(3L);
    actualWitness.getAddress();
    actualWitness.getUrl();

    // Assert that nothing has changed
    assertEquals(3L, actualWitness.getVoteCount());
  }

  /**
   * Method under test: {@link Witness#setAddress(byte[])}
   */
  @Test
  public void testSetAddress() throws UnsupportedEncodingException {
    // Arrange
    Witness witness = new Witness();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> witness.setAddress("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Witness#setAddress(byte[])}
   */
  @Test
  public void testSetAddress2() {
    // Arrange
    Witness witness = new Witness();
    witness.setVoteCount(3L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> witness.setAddress(null));
  }

  /**
   * Method under test: {@link Witness#setAddress(byte[])}
   */
  @Test
  public void testSetAddress3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Witness()).setAddress(new byte[]{}));
  }

  /**
   * Method under test: {@link Witness#setUrl(String)}
   */
  @Test
  public void testSetUrl() {
    // Arrange
    Witness witness = new Witness();

    // Act
    witness.setUrl("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", witness.getUrl());
  }

  /**
   * Method under test: {@link Witness#setUrl(String)}
   */
  @Test
  public void testSetUrl2() {
    // Arrange
    Witness witness = new Witness();
    witness.setVoteCount(3L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> witness.setUrl(null));
  }

  /**
   * Method under test: {@link Witness#setUrl(String)}
   */
  @Test
  public void testSetUrl3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Witness()).setUrl(""));
  }
}
