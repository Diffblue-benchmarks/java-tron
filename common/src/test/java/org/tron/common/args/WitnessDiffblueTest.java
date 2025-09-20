package org.tron.common.args;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WitnessDiffblueTest {
  /**
   * Test {@link Witness#setAddress(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Witness#setAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Witness.setAddress(byte[])"})
  public void testSetAddress_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Witness().setAddress("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Witness#setAddress(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Witness#setAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Witness.setAddress(byte[])"})
  public void testSetAddress_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Witness().setAddress(new byte[] {}));
  }

  /**
   * Test {@link Witness#setUrl(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Witness#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Witness.setUrl(String)"})
  public void testSetUrl_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Witness().setUrl(""));
  }

  /**
   * Test {@link Witness#setUrl(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then {@link Witness} (default constructor) Url is {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link Witness#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Witness.setUrl(String)"})
  public void testSetUrl_whenHttpsExampleOrgExample_thenWitnessUrlIsHttpsExampleOrgExample() {
    // Arrange
    Witness witness = new Witness();

    // Act
    witness.setUrl("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", witness.getUrl());
  }

  /**
   * Test {@link Witness#setUrl(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Witness#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Witness.setUrl(String)"})
  public void testSetUrl_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Witness().setUrl(null));
  }

  /**
   * Test {@link Witness#setUrl(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Witness#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Witness.setUrl(String)"})
  public void testSetUrl_whenSpace_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Witness().setUrl(" "));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Witness}
   *   <li>{@link Witness#setVoteCount(long)}
   *   <li>{@link Witness#getAddress()}
   *   <li>{@link Witness#getUrl()}
   *   <li>{@link Witness#getVoteCount()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Witness.<init>()",
    "byte[] Witness.getAddress()",
    "String Witness.getUrl()",
    "long Witness.getVoteCount()",
    "void Witness.setVoteCount(long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Witness actualWitness = new Witness();
    actualWitness.setVoteCount(3L);
    byte[] actualAddress = actualWitness.getAddress();
    String actualUrl = actualWitness.getUrl();

    // Assert
    assertNull(actualAddress);
    assertNull(actualUrl);
    assertEquals(3L, actualWitness.getVoteCount());
  }
}
