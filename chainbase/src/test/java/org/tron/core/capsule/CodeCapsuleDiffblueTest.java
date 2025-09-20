package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;

public class CodeCapsuleDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeCapsule#CodeCapsule(byte[])}
   *   <li>{@link CodeCapsule#toString()}
   *   <li>{@link CodeCapsule#getData()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CodeCapsule.<init>(byte[])",
    "byte[] CodeCapsule.getData()",
    "String CodeCapsule.toString()"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    CodeCapsule actualCodeCapsule = new CodeCapsule(code);
    String actualToStringResult = actualCodeCapsule.toString();

    // Assert
    assertEquals("[65, 88, 65, 88, 65, 88, 65, 88]", actualToStringResult);
    assertSame(code, actualCodeCapsule.getData());
    byte[] instance = actualCodeCapsule.getInstance();
    assertSame(code, instance);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), instance);
  }

  /**
   * Test {@link CodeCapsule#getCodeHash()}.
   *
   * <p>Method under test: {@link CodeCapsule#getCodeHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash CodeCapsule.getCodeHash()"})
  public void testGetCodeHash() throws UnsupportedEncodingException {
    // Arrange and Act
    Sha256Hash actualCodeHash = new CodeCapsule("AXAXAXAX".getBytes("UTF-8")).getCodeHash();

    // Assert
    ByteString byteString = actualCodeHash.getByteString();
    assertFalse(byteString.isEmpty());
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\\', iteratorResult.next().byteValue());
    assertEquals('[', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals("\\[b\t�g�� �\ru�/���l�؊KS�\u0001�9�\u001a`��", byteString.toStringUtf8());
    assertArrayEquals(
        new byte[] {
          '\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
          'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36
        },
        actualCodeHash.getBytes());
    BigInteger toBigIntegerResult = actualCodeHash.toBigInteger();
    assertEquals(2, toBigIntegerResult.getLowestSetBit());
    assertEquals(1, toBigIntegerResult.signum());
    assertArrayEquals(
        new byte[] {
          '\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
          'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36
        },
        toBigIntegerResult.toByteArray());
    assertEquals(
        "41774241789126944098306227155094803171342615589867574088397738610130220530396",
        toBigIntegerResult.toString());
  }

  /**
   * Test {@link CodeCapsule#getInstance()}.
   *
   * <p>Method under test: {@link CodeCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] CodeCapsule.getInstance()"})
  public void testGetInstance() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), new CodeCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }
}
