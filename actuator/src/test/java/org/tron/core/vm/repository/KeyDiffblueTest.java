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
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Data is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#Key(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Key.<init>(byte[])"})
  public void testNewKey_whenAxaxaxaxBytesIsUtf8_thenReturnDataIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Key actualKey = new Key("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualKey.getData());
  }

  /**
   * Test {@link Key#Key(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#Key(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Key.<init>(byte[])"})
  public void testNewKey_whenEmptyArrayOfByte_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new Key(new byte[]{})).getData());
  }

  /**
   * Test {@link Key#Key(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#Key(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Key.<init>(byte[])"})
  public void testNewKey_whenNull_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new Key(null)).getData());
  }

  /**
   * Test {@link Key#create(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Data is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Key Key.create(byte[])"})
  public void testCreate_whenAxaxaxaxBytesIsUtf8_thenReturnDataIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Key actualCreateResult = Key.create("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualCreateResult.getData());
  }

  /**
   * Test {@link Key#create(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Key Key.create(byte[])"})
  public void testCreate_whenEmptyArrayOfByte_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, Key.create(new byte[]{}).getData());
  }

  /**
   * Test {@link Key#create(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Key Key.create(byte[])"})
  public void testCreate_whenNull_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, Key.create(null).getData());
  }

  /**
   * Test {@link Key#clone()}.
   * <p>
   * Method under test: {@link Key#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Key Key.clone()"})
  public void testClone() throws UnsupportedEncodingException {
    // Arrange
    Key createResult = Key.create("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(createResult, createResult.clone());
  }

  /**
   * Test {@link Key#getData()}.
   * <p>
   * Method under test: {@link Key#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Key.getData()"})
  public void testGetData() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualData = Key.create("AXAXAXAX".getBytes("UTF-8")).getData();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test {@link Key#equals(Object)}, and {@link Key#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Key#equals(Object)}
   *   <li>{@link Key#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    Key createResult = Key.create("AXAXAXAX".getBytes("UTF-8"));
    Key createResult2 = Key.create("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(createResult, createResult2);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult2.hashCode());
  }

  /**
   * Test {@link Key#equals(Object)}, and {@link Key#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Key#equals(Object)}
   *   <li>{@link Key#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    Key createResult = Key.create("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(createResult, createResult);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult.hashCode());
  }

  /**
   * Test {@link Key#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    Key createResult = Key.create("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(createResult, Key.create("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Key#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#equals(Object)}
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(Key.create("AXAXAXAX".getBytes("UTF-8")), "Different type to Key");
  }
}
