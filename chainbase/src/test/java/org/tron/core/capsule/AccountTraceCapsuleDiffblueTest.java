package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.BadItemException;
import org.tron.protos.contract.BalanceContract;
import org.tron.protos.contract.BalanceContract.AccountTrace;

public class AccountTraceCapsuleDiffblueTest {
  /**
   * Test {@link AccountTraceCapsule#AccountTraceCapsule(long)}.
   * <p>
   * Method under test: {@link AccountTraceCapsule#AccountTraceCapsule(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountTraceCapsule.<init>(long)"})
  public void testNewAccountTraceCapsule() {
    // Arrange and Act
    AccountTraceCapsule actualAccountTraceCapsule = new AccountTraceCapsule(42L);

    // Assert
    AccountTrace instance = actualAccountTraceCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0L, instance.getPlaceholder());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(42L, actualAccountTraceCapsule.getBalance().longValue());
    assertEquals(42L, instance.getBalance());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.isInitialized());
    assertArrayEquals(new byte[]{'\b', '*'}, actualAccountTraceCapsule.getData());
  }

  /**
   * Test {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}.
   * <p>
   * Method under test: {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountTraceCapsule.<init>(byte[])"})
  public void testNewAccountTraceCapsule2() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new AccountTraceCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountTraceCapsule.<init>(byte[])"})
  public void testNewAccountTraceCapsule_whenArrayOfByteWithMinusOneAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new AccountTraceCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountTraceCapsule.<init>(byte[])"})
  public void testNewAccountTraceCapsule_whenArrayOfByteWithTwentyFourAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new AccountTraceCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountTraceCapsule.<init>(byte[])"})
  public void testNewAccountTraceCapsule_whenArrayOfByteWithZeroAndX_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new AccountTraceCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountTraceCapsule.<init>(byte[])"})
  public void testNewAccountTraceCapsule_whenAxaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new AccountTraceCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}.
   * <ul>
   *   <li>When backspace.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountTraceCapsule.<init>(byte[])"})
  public void testNewAccountTraceCapsule_whenBackspace_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new AccountTraceCapsule(
        new byte[]{'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', -1}));
  }

  /**
   * Test {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTraceCapsule#AccountTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountTraceCapsule.<init>(byte[])"})
  public void testNewAccountTraceCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new AccountTraceCapsule("\bXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountTraceCapsule#getBalance()}.
   * <p>
   * Method under test: {@link AccountTraceCapsule#getBalance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long AccountTraceCapsule.getBalance()"})
  public void testGetBalance() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AccountTraceCapsule()).getBalance().longValue());
  }

  /**
   * Test {@link AccountTraceCapsule#getData()}.
   * <ul>
   *   <li>Given {@link AccountTraceCapsule#AccountTraceCapsule(long)} with balance is {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTraceCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AccountTraceCapsule.getData()"})
  public void testGetData_givenAccountTraceCapsuleWithBalanceIsMax_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'\b', -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE},
        (new AccountTraceCapsule(Long.MAX_VALUE)).getData());
  }

  /**
   * Test {@link AccountTraceCapsule#getData()}.
   * <ul>
   *   <li>Given {@link AccountTraceCapsule#AccountTraceCapsule(long)} with balance is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTraceCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AccountTraceCapsule.getData()"})
  public void testGetData_givenAccountTraceCapsuleWithBalanceIsMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        (new AccountTraceCapsule(-1L)).getData());
  }

  /**
   * Test {@link AccountTraceCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and {@code *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTraceCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AccountTraceCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithBackspaceAndAsterisk() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'\b', '*'}, (new AccountTraceCapsule(42L)).getData());
  }

  /**
   * Test {@link AccountTraceCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred four and six.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTraceCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AccountTraceCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithMinusOneHundredFourAndSix() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-104, 6, 1}, (new AccountTraceCapsule()).getData());
  }

  /**
   * Test {@link AccountTraceCapsule#getInstance()}.
   * <p>
   * Method under test: {@link AccountTraceCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTraceCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    AccountTrace actualInstance = (new AccountTraceCapsule()).getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getSerializedSize());
    assertEquals(0L, actualInstance.getBalance());
    assertEquals(0L, actualInstance.getPlaceholder());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.isInitialized());
    assertEquals(actualInstance, actualInstance.getDefaultInstanceForType());
  }
}
