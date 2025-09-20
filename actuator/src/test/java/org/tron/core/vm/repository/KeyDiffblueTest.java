package org.tron.core.vm.repository;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KeyDiffblueTest {
  /**
   * Test {@link Key#Key(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Data is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Key#Key(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Key.<init>(byte[])"})
  public void testNewKey_whenAxaxaxaxBytesIsUtf8_thenReturnDataIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), new Key("AXAXAXAX".getBytes("UTF-8")).getData());
  }

  /**
   * Test {@link Key#Key(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Data is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Key#Key(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Key.<init>(byte[])"})
  public void testNewKey_whenEmptyArrayOfByte_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange and Act
    Key actualKey = new Key(new byte[] {});

    // Assert
    assertArrayEquals(new byte[] {}, actualKey.getData());
  }

  /**
   * Test {@link Key#Key(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Data is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Key#Key(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Key.<init>(byte[])"})
  public void testNewKey_whenNull_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new Key(null).getData());
  }

  /**
   * Test {@link Key#create(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Data is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Key#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Key Key.create(byte[])"})
  public void testCreate_whenAxaxaxaxBytesIsUtf8_thenReturnDataIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), Key.create("AXAXAXAX".getBytes("UTF-8")).getData());
  }

  /**
   * Test {@link Key#create(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Data is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Key#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Key Key.create(byte[])"})
  public void testCreate_whenEmptyArrayOfByte_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, Key.create(new byte[] {}).getData());
  }

  /**
   * Test {@link Key#create(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Data is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Key#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Key Key.create(byte[])"})
  public void testCreate_whenNull_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange and Act
    Key actualCreateResult = Key.create(null);

    // Assert
    assertArrayEquals(new byte[] {}, actualCreateResult.getData());
  }

  /**
   * Test {@link Key#clone()}.
   *
   * <p>Method under test: {@link Key#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Key Key.clone()"})
  public void testClone() throws UnsupportedEncodingException {
    // Arrange
    Key createResult = Key.create("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Key actualCloneResult = createResult.clone();

    // Assert
    assertEquals(createResult, actualCloneResult);
  }

  /**
   * Test {@link Key#getData()}.
   *
   * <p>Method under test: {@link Key#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Key.getData()"})
  public void testGetData() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), Key.create("AXAXAXAX".getBytes("UTF-8")).getData());
  }

  /**
   * Test {@link Key#equals(Object)}, and {@link Key#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Key#equals(Object)}
   *   <li>{@link Key#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    Key createResult = Key.create("AXAXAXAX".getBytes("UTF-8"));
    Key createResult2 = Key.create("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(createResult, createResult2);
    assertEquals(createResult.hashCode(), createResult2.hashCode());
  }

  /**
   * Test {@link Key#equals(Object)}, and {@link Key#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Key#equals(Object)}
   *   <li>{@link Key#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    Key createResult = Key.create("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(createResult, createResult);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult.hashCode());
  }

  /**
   * Test {@link Key#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Key#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(Key.create("AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Test {@link Key#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Key#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(Key.create("AXAXAXAX".getBytes("UTF-8")), "Different type to Key");
  }
}
