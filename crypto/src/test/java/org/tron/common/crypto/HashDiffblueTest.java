package org.tron.common.crypto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.bouncycastle.math.ec.ECPoint;
import org.junit.Test;

public class HashDiffblueTest {
  /**
   * Method under test: {@link Hash#sha3(byte[])}
   */
  @Test
  public void testSha3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75,
        -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54},
        Hash.sha3("AXAXAXAX".getBytes("UTF-8")));
    assertArrayEquals(new byte[]{11, 'r', '"', '0', 'Z', ' ', -51, -89, 'c', -87, -27, -72, -120, -81, -60, '"', 5, -6,
        -15, -25, '6', -103, -111, -97, 'u', '^', 'd', -76, 'B', -50, -20, '\''},
        Hash.sha3("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Method under test: {@link Hash#sha3(byte[], byte[])}
   */
  @Test
  public void testSha32() throws UnsupportedEncodingException {
    // Arrange
    byte[] input1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'_', '\\', 'K', 24, 24, ',', -86, -15, -90, -81, -99, -127, '{', -23, 'i', -48, -7, -113, -47, '4',
            -19, -90, -77, -105, -79, '@', 'I', 'w', -34, '1', 'F', 16},
        Hash.sha3(input1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Hash#encodeElement(byte[])}
   */
  @Test
  public void testEncodeElement() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-120, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        Hash.encodeElement("AXAXAXAX".getBytes("UTF-8")));
    assertArrayEquals(new byte[]{Byte.MIN_VALUE}, Hash.encodeElement(null));
    assertArrayEquals(new byte[]{0}, Hash.encodeElement(new byte[]{0}));
    assertArrayEquals(new byte[]{Byte.MIN_VALUE}, Hash.encodeElement(new byte[]{}));
    assertArrayEquals(new byte[]{'A'}, Hash.encodeElement(new byte[]{'A'}));
    assertArrayEquals(new byte[]{-127, Byte.MIN_VALUE}, Hash.encodeElement(new byte[]{Byte.MIN_VALUE}));
  }

  /**
   * Method under test: {@link Hash#computeAddress(ECPoint)}
   */
  @Test
  public void testComputeAddress() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pubPoint = mock(ECPoint.class);
    when(pubPoint.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualComputeAddressResult = Hash.computeAddress(pubPoint);

    // Assert
    verify(pubPoint).getEncoded(eq(false));
    assertArrayEquals(new byte[]{'A', 19, -117, -77, 'l', 'I', -90, ')', -16, 27, '!', 'a', '+', 17, 'Q', -31, -24,
        -124, '5', -121, -26}, actualComputeAddressResult);
  }

  /**
   * Method under test: {@link Hash#computeAddress(ECPoint)}
   */
  @Test
  public void testComputeAddress2() {
    // Arrange
    ECPoint pubPoint = mock(ECPoint.class);
    when(pubPoint.getEncoded(anyBoolean())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Hash.computeAddress(pubPoint));
    verify(pubPoint).getEncoded(eq(false));
  }

  /**
   * Method under test: {@link Hash#computeAddress(byte[])}
   */
  @Test
  public void testComputeAddress3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 19, -117, -77, 'l', 'I', -90, ')', -16, 27, '!', 'a', '+', 17, 'Q', -31, -24,
        -124, '5', -121, -26}, Hash.computeAddress("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Hash#sha3omit12(byte[])}
   */
  @Test
  public void testSha3omit12() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', '\n', '>', -48, '0', -75, -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q',
        -3, -89, -95, -54}, Hash.sha3omit12("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Hash#ripemd160(byte[])}
   */
  @Test
  public void testRipemd160() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{-99, 'i', '~', -56, -105, '[', -65, '\r', 3, 'Q', -64, -113, -57, 1, 'U', -26, -28, -75, -47, -104},
        Hash.ripemd160("AXAXAXAX".getBytes("UTF-8")));
  }
}
