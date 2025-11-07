package org.tron.common.crypto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.bouncycastle.math.ec.ECPoint;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HashDiffblueTest {
  /**
   * Test {@link Hash#sha3(byte[])} with {@code input}.
   * <p>
   * Method under test: {@link Hash#sha3(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.sha3(byte[])"})
  public void testSha3WithInput() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75,
        -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54},
        Hash.sha3("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Hash#sha3(byte[], byte[])} with {@code input1}, {@code input2}.
   * <p>
   * Method under test: {@link Hash#sha3(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.sha3(byte[], byte[])"})
  public void testSha3WithInput1Input2() throws UnsupportedEncodingException {
    // Arrange
    byte[] input1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'_', '\\', 'K', 24, 24, ',', -86, -15, -90, -81, -99, -127, '{', -23, 'i', -48, -7, -113, -47, '4',
            -19, -90, -77, -105, -79, '@', 'I', 'w', -34, '1', 'F', 16},
        Hash.sha3(input1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Hash#sha3(byte[], int, int)} with {@code input}, {@code start}, {@code length}.
   * <ul>
   *   <li>Then return array of {@code byte} with eleven and {@code r}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Hash#sha3(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.sha3(byte[], int, int)"})
  public void testSha3WithInputStartLength_thenReturnArrayOfByteWithElevenAndR() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{11, 'r', '"', '0', 'Z', ' ', -51, -89, 'c', -87, -27, -72, -120, -81, -60, '"', 5, -6,
        -15, -25, '6', -103, -111, -97, 'u', '^', 'd', -76, 'B', -50, -20, '\''},
        Hash.sha3("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link Hash#encodeElement(byte[])}.
   * <p>
   * Method under test: {@link Hash#encodeElement(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.encodeElement(byte[])"})
  public void testEncodeElement() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-127, Byte.MIN_VALUE}, Hash.encodeElement(new byte[]{Byte.MIN_VALUE}));
  }

  /**
   * Test {@link Hash#encodeElement(byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty and {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Hash#encodeElement(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.encodeElement(byte[])"})
  public void testEncodeElement_thenReturnArrayOfByteWithMinusOneHundredTwentyAndA()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-120, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        Hash.encodeElement("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Hash#encodeElement(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A}.</li>
   *   <li>Then return array of {@code byte} with {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Hash#encodeElement(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.encodeElement(byte[])"})
  public void testEncodeElement_whenArrayOfByteWithA_thenReturnArrayOfByteWithA() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A'}, Hash.encodeElement(new byte[]{'A'}));
  }

  /**
   * Test {@link Hash#encodeElement(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero.</li>
   *   <li>Then return array of {@code byte} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Hash#encodeElement(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.encodeElement(byte[])"})
  public void testEncodeElement_whenArrayOfByteWithZero_thenReturnArrayOfByteWithZero() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0}, Hash.encodeElement(new byte[]{0}));
  }

  /**
   * Test {@link Hash#encodeElement(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Hash#encodeElement(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.encodeElement(byte[])"})
  public void testEncodeElement_whenEmptyArrayOfByte_thenReturnArrayOfByteWithMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{Byte.MIN_VALUE}, Hash.encodeElement(new byte[]{}));
  }

  /**
   * Test {@link Hash#encodeElement(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Hash#encodeElement(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.encodeElement(byte[])"})
  public void testEncodeElement_whenNull_thenReturnArrayOfByteWithMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{Byte.MIN_VALUE}, Hash.encodeElement(null));
  }

  /**
   * Test {@link Hash#computeAddress(byte[])} with {@code pubBytes}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and nineteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link Hash#computeAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.computeAddress(byte[])"})
  public void testComputeAddressWithPubBytes_thenReturnArrayOfByteWithAAndNineteen()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 19, -117, -77, 'l', 'I', -90, ')', -16, 27, '!', 'a', '+', 17, 'Q', -31, -24,
        -124, '5', -121, -26}, Hash.computeAddress("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Hash#computeAddress(ECPoint)} with {@code pubPoint}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and nineteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link Hash#computeAddress(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.computeAddress(ECPoint)"})
  public void testComputeAddressWithPubPoint_thenReturnArrayOfByteWithAAndNineteen()
      throws UnsupportedEncodingException {
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
   * Test {@link Hash#computeAddress(ECPoint)} with {@code pubPoint}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Hash#computeAddress(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.computeAddress(ECPoint)"})
  public void testComputeAddressWithPubPoint_thenThrowRuntimeException() {
    // Arrange
    ECPoint pubPoint = mock(ECPoint.class);
    when(pubPoint.getEncoded(anyBoolean())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Hash.computeAddress(pubPoint));
    verify(pubPoint).getEncoded(eq(false));
  }

  /**
   * Test {@link Hash#sha3omit12(byte[])}.
   * <p>
   * Method under test: {@link Hash#sha3omit12(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.sha3omit12(byte[])"})
  public void testSha3omit12() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', '\n', '>', -48, '0', -75, -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q',
        -3, -89, -95, -54}, Hash.sha3omit12("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Hash#ripemd160(byte[])}.
   * <p>
   * Method under test: {@link Hash#ripemd160(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Hash.ripemd160(byte[])"})
  public void testRipemd160() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{-99, 'i', '~', -56, -105, '[', -65, '\r', 3, 'Q', -64, -113, -57, 1, 'U', -26, -28, -75, -47, -104},
        Hash.ripemd160("AXAXAXAX".getBytes("UTF-8")));
  }
}
