package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.BadItemException;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.TransactionInfo;
import org.tron.protos.Protocol.TransactionRet;

public class TransactionRetCapsuleDiffblueTest {
  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule()}.
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>()"})
  public void testNewTransactionRetCapsule() {
    // Arrange and Act
    TransactionRetCapsule actualTransactionRetCapsule = new TransactionRetCapsule();

    // Assert
    TransactionRet instance = actualTransactionRetCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, instance.getTransactioninfoCount());
    assertEquals(0L, instance.getBlockNumber());
    assertEquals(0L, instance.getBlockTimeStamp());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<TransactionInfo> transactioninfoList = instance.getTransactioninfoList();
    assertTrue(transactioninfoList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    TransactionRet actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertSame(transactioninfoList, instance.getTransactioninfoOrBuilderList());
    assertArrayEquals(new byte[] {}, actualTransactionRetCapsule.getData());
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(BlockCapsule)}.
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(BlockCapsule)"})
  public void testNewTransactionRetCapsule2() {
    // Arrange and Act
    TransactionRetCapsule actualTransactionRetCapsule =
        new TransactionRetCapsule((BlockCapsule) null);

    // Assert
    TransactionRet instance = actualTransactionRetCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, instance.getTransactioninfoCount());
    assertEquals(0L, instance.getBlockNumber());
    assertEquals(0L, instance.getBlockTimeStamp());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<TransactionInfo> transactioninfoList = instance.getTransactioninfoList();
    assertTrue(transactioninfoList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    TransactionRet actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertSame(transactioninfoList, instance.getTransactioninfoOrBuilderList());
    assertArrayEquals(new byte[] {}, actualTransactionRetCapsule.getData());
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule3() throws BadItemException {
    // Arrange and Act
    TransactionRetCapsule actualTransactionRetCapsule = new TransactionRetCapsule(new byte[] {});

    // Assert
    TransactionRet instance = actualTransactionRetCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, instance.getTransactioninfoCount());
    assertEquals(0L, instance.getBlockNumber());
    assertEquals(0L, instance.getBlockTimeStamp());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<TransactionInfo> transactioninfoList = instance.getTransactioninfoList();
    assertTrue(transactioninfoList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    TransactionRet actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertSame(transactioninfoList, instance.getTransactioninfoOrBuilderList());
    assertArrayEquals(new byte[] {}, actualTransactionRetCapsule.getData());
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule4()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionRetCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and backspace.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithAAndBackspace()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionRetCapsule(
                new byte[] {
                  'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  16
                }));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and backspace.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithAAndBackspace2()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionRetCapsule(
                new byte[] {
                  'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  26
                }));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and backspace.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithAAndBackspace3()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionRetCapsule(
                new byte[] {
                  'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  -1
                }));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with four and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithFourAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionRetCapsule(new byte[] {4, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithMinusOneAndX()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionRetCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithSixteenAndX()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionRetCapsule(new byte[] {16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and backspace.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndBackspace()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionRetCapsule(
                new byte[] {
                  26, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and backspace.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndBackspace2()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionRetCapsule(
                new byte[] {
                  26, '\b', 16, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and backspace.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndBackspace3()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionRetCapsule(
                new byte[] {
                  26, '\b', 2, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and backspace.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndBackspace4()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionRetCapsule(
                new byte[] {
                  26, '\b', 24, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and lf.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndLf()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionRetCapsule(
                new byte[] {
                  26, '\n', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndX()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionRetCapsule(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndZero()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionRetCapsule(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenAxaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionRetCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenLf_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionRetCapsule(
                new byte[] {
                  26, '\b', '\n', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenSpace_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionRetCapsule(
                new byte[] {
                  26, '\b', ' ', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenXxaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionRetCapsule("XXAXAXAX".getBytes("UTF-8")));
  }
}
