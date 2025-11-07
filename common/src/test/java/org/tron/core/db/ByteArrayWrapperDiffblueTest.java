package org.tron.core.db;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ByteArrayWrapperDiffblueTest {
  /**
   * Test {@link ByteArrayWrapper#ByteArrayWrapper(byte[])}.
   * <ul>
   *   <li>Then return Data is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArrayWrapper#ByteArrayWrapper(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ByteArrayWrapper.<init>(byte[])"})
  public void testNewByteArrayWrapper_thenReturnDataIsAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    ByteArrayWrapper actualByteArrayWrapper = new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualByteArrayWrapper.getData());
  }

  /**
   * Test {@link ByteArrayWrapper#ByteArrayWrapper(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArrayWrapper#ByteArrayWrapper(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ByteArrayWrapper.<init>(byte[])"})
  public void testNewByteArrayWrapper_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ByteArrayWrapper(null));
  }

  /**
   * Test {@link ByteArrayWrapper#equals(Object)}, and {@link ByteArrayWrapper#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ByteArrayWrapper#equals(Object)}
   *   <li>{@link ByteArrayWrapper#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArrayWrapper.equals(Object)", "int ByteArrayWrapper.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayWrapper byteArrayWrapper2 = new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(byteArrayWrapper, byteArrayWrapper2);
    int expectedHashCodeResult = byteArrayWrapper.hashCode();
    assertEquals(expectedHashCodeResult, byteArrayWrapper2.hashCode());
  }

  /**
   * Test {@link ByteArrayWrapper#equals(Object)}, and {@link ByteArrayWrapper#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ByteArrayWrapper#equals(Object)}
   *   <li>{@link ByteArrayWrapper#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArrayWrapper.equals(Object)", "int ByteArrayWrapper.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(byteArrayWrapper, byteArrayWrapper);
    int expectedHashCodeResult = byteArrayWrapper.hashCode();
    assertEquals(expectedHashCodeResult, byteArrayWrapper.hashCode());
  }

  /**
   * Test {@link ByteArrayWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArrayWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArrayWrapper.equals(Object)", "int ByteArrayWrapper.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper("\bXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(byteArrayWrapper, new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArrayWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArrayWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArrayWrapper.equals(Object)", "int ByteArrayWrapper.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Test {@link ByteArrayWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArrayWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArrayWrapper.equals(Object)", "int ByteArrayWrapper.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8")), "Different type to ByteArrayWrapper");
  }

  /**
   * Test {@link ByteArrayWrapper#compareTo(ByteArrayWrapper)} with {@code ByteArrayWrapper}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArrayWrapper#compareTo(ByteArrayWrapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArrayWrapper.compareTo(ByteArrayWrapper)"})
  public void testCompareToWithByteArrayWrapper_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(0, byteArrayWrapper.compareTo(new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ByteArrayWrapper#toString()}
   *   <li>{@link ByteArrayWrapper#getData()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteArrayWrapper.getData()", "String ByteArrayWrapper.toString()"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualToStringResult = byteArrayWrapper.toString();
    byte[] actualData = byteArrayWrapper.getData();

    // Assert
    assertEquals("4158415841584158", actualToStringResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }
}
