package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.exception.BadItemException;
import org.tron.protos.contract.BalanceContract;
import org.tron.protos.contract.BalanceContract.BlockBalanceTrace;
import org.tron.protos.contract.BalanceContract.BlockBalanceTrace.BlockIdentifier;
import org.tron.protos.contract.BalanceContract.TransactionBalanceTrace;

public class BlockBalanceTraceCapsuleDiffblueTest {
  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule()}.
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>()"})
  public void testNewBlockBalanceTraceCapsule() {
    // Arrange and Act
    BlockBalanceTraceCapsule actualBlockBalanceTraceCapsule = new BlockBalanceTraceCapsule();

    // Assert
    assertEquals(0L, actualBlockBalanceTraceCapsule.getTimestamp());
    assertTrue(actualBlockBalanceTraceCapsule.getTransactions().isEmpty());
    assertArrayEquals(new byte[]{}, actualBlockBalanceTraceCapsule.getData());
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(BlockCapsule)}.
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.</li>
   *   <li>Then return Timestamp is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(BlockCapsule)"})
  public void testNewBlockBalanceTraceCapsule_givenBlockId_thenReturnTimestampIsTen() {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(1L);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);
    when(blockCapsule.getBlockId()).thenReturn(new BlockId());

    // Act
    BlockBalanceTraceCapsule actualBlockBalanceTraceCapsule = new BlockBalanceTraceCapsule(blockCapsule);

    // Assert
    verify(blockCapsule).getBlockId();
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
    assertEquals(10L, actualBlockBalanceTraceCapsule.getTimestamp());
    assertTrue(actualBlockBalanceTraceCapsule.getTransactions().isEmpty());
    assertArrayEquals(new byte[]{'\n', '$', '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 1, 16, '\n'}, actualBlockBalanceTraceCapsule.getData());
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithEighteenAndTwo() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{18, 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithLfAndTwo() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithLfAndTwo2() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 2, 2, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithLfAndTwo3() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 2, 16, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithLfAndTwo4() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 2, 'X', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithLfAndZero() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithLfAndZero2() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 0, '\n', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithMinusOneAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithSixteenAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithSixteenAndX2() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{16, 'X', 26, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithTwentySixAndTwo() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithTwentySixAndTwo2() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, 2, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithTwentySixAndTwo3() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, 16, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithTwentySixAndTwo4() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, 26, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithTwentySixAndTwo5() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, 18, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithTwentySixAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithTwentySixAndZero() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with two and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenArrayOfByteWithTwoAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockBalanceTraceCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Timestamp is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenEmptyArrayOfByte_thenReturnTimestampIsZero() throws BadItemException {
    // Arrange and Act
    BlockBalanceTraceCapsule actualBlockBalanceTraceCapsule = new BlockBalanceTraceCapsule(new byte[]{});

    // Assert
    assertEquals(0L, actualBlockBalanceTraceCapsule.getTimestamp());
    assertTrue(actualBlockBalanceTraceCapsule.getTransactions().isEmpty());
    assertArrayEquals(new byte[]{}, actualBlockBalanceTraceCapsule.getData());
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenLf_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 2, '\n', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenLf_thenThrowBadItemException2() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, '\n', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When {@code "}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenQuotationMark_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, '"', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockBalanceTraceCapsule("\nXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockBalanceTraceCapsule.<init>(byte[])"})
  public void testNewBlockBalanceTraceCapsule_whenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockBalanceTraceCapsule("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#getData()}.
   * <ul>
   *   <li>Given {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule()}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] BlockBalanceTraceCapsule.getData()"})
  public void testGetData_givenBlockBalanceTraceCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new BlockBalanceTraceCapsule()).getData());
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-six and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] BlockBalanceTraceCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentySixAndZero() {
    // Arrange
    BlockBalanceTraceCapsule blockBalanceTraceCapsule = new BlockBalanceTraceCapsule();
    blockBalanceTraceCapsule.addTransactionBalanceTrace(TransactionBalanceTrace.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{26, 0}, blockBalanceTraceCapsule.getData());
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#getInstance()}.
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTraceCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    BlockBalanceTrace actualInstance = (new BlockBalanceTraceCapsule()).getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getSerializedSize());
    assertEquals(0, actualInstance.getTransactionBalanceTraceCount());
    assertEquals(0L, actualInstance.getTimestamp());
    assertFalse(actualInstance.hasBlockIdentifier());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    List<TransactionBalanceTrace> transactionBalanceTraceList = actualInstance.getTransactionBalanceTraceList();
    assertTrue(transactionBalanceTraceList.isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.isInitialized());
    assertEquals(actualInstance, actualInstance.getDefaultInstanceForType());
    assertSame(transactionBalanceTraceList, actualInstance.getTransactionBalanceTraceOrBuilderList());
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#getBlockIdentifier()}.
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#getBlockIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockIdentifier BlockBalanceTraceCapsule.getBlockIdentifier()"})
  public void testGetBlockIdentifier() {
    // Arrange and Act
    BlockIdentifier actualBlockIdentifier = (new BlockBalanceTraceCapsule()).getBlockIdentifier();

    // Assert
    assertEquals("", actualBlockIdentifier.getInitializationErrorString());
    assertEquals(0, actualBlockIdentifier.getSerializedSize());
    assertEquals(0L, actualBlockIdentifier.getNumber());
    assertTrue(actualBlockIdentifier.findInitializationErrors().isEmpty());
    assertTrue(actualBlockIdentifier.getAllFields().isEmpty());
    assertTrue(actualBlockIdentifier.isInitialized());
    assertSame(actualBlockIdentifier, actualBlockIdentifier.getDefaultInstanceForType());
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#getTimestamp()}.
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#getTimestamp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BlockBalanceTraceCapsule.getTimestamp()"})
  public void testGetTimestamp() {
    // Arrange, Act and Assert
    assertEquals(0L, (new BlockBalanceTraceCapsule()).getTimestamp());
  }

  /**
   * Test {@link BlockBalanceTraceCapsule#getTransactions()}.
   * <p>
   * Method under test: {@link BlockBalanceTraceCapsule#getTransactions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BlockBalanceTraceCapsule.getTransactions()"})
  public void testGetTransactions() {
    // Arrange, Act and Assert
    assertTrue((new BlockBalanceTraceCapsule()).getTransactions().isEmpty());
  }
}
