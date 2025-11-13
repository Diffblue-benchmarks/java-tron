package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSet;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.BadItemException;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.MarketOrderDetail;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Result;
import org.tron.protos.Protocol.Transaction.Result.code;
import org.tron.protos.Protocol.Transaction.Result.contractResult;

public class TransactionResultCapsuleDiffblueTest {
  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>()"})
  public void testNewTransactionResultCapsule() {
    // Arrange and Act
    TransactionResultCapsule actualTransactionResultCapsule = new TransactionResultCapsule();

    // Assert
    assertEquals("", actualTransactionResultCapsule.getAssetIssueID());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeId());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeInjectAnotherAmount());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeReceivedAmount());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeWithdrawAnotherAmount());
    assertEquals(0L, actualTransactionResultCapsule.getFee());
    assertEquals(0L, actualTransactionResultCapsule.getShieldedTransactionFee());
    assertEquals(0L, actualTransactionResultCapsule.getUnfreezeAmount());
    assertEquals(0L, actualTransactionResultCapsule.getWithdrawAmount());
    assertEquals(0L, actualTransactionResultCapsule.getWithdrawExpireAmount());
    assertTrue(actualTransactionResultCapsule.getOrderDetailsList().isEmpty());
    assertTrue(actualTransactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertArrayEquals(new byte[] {}, actualTransactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule2()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionResultCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule3()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionResultCapsule("r\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule4()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionResultCapsule("A\bA\bA\bA\bA\bA\bA\bAx".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <ul>
   *   <li>Then return AssetIssueID is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule_thenReturnAssetIssueIDIsEmptyString()
      throws BadItemException {
    // Arrange and Act
    TransactionResultCapsule actualTransactionResultCapsule =
        new TransactionResultCapsule(new byte[] {});

    // Assert
    assertEquals("", actualTransactionResultCapsule.getAssetIssueID());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeId());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeInjectAnotherAmount());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeReceivedAmount());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeWithdrawAnotherAmount());
    assertEquals(0L, actualTransactionResultCapsule.getFee());
    assertEquals(0L, actualTransactionResultCapsule.getShieldedTransactionFee());
    assertEquals(0L, actualTransactionResultCapsule.getUnfreezeAmount());
    assertEquals(0L, actualTransactionResultCapsule.getWithdrawAmount());
    assertEquals(0L, actualTransactionResultCapsule.getWithdrawExpireAmount());
    assertTrue(actualTransactionResultCapsule.getOrderDetailsList().isEmpty());
    assertTrue(actualTransactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertArrayEquals(new byte[] {}, actualTransactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule_whenArrayOfByteWithMinusOneAndX()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionResultCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule_whenArrayOfByteWithSixteenAndX()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionResultCapsule(new byte[] {16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule_whenArrayOfByteWithTwentyFourAndX()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionResultCapsule(new byte[] {24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule_whenArrayOfByteWithZeroAndX()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionResultCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionResultCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule_whenBackspace_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionResultCapsule(
                new byte[] {
                  'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  16
                }));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule_whenBackspace_thenThrowBadItemException2()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionResultCapsule(
                new byte[] {
                  'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  24
                }));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule_whenBackspace_thenThrowBadItemException3()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionResultCapsule(
                new byte[] {
                  'A',
                  '\b',
                  'A',
                  '\b',
                  'A',
                  '\b',
                  'A',
                  '\b',
                  'A',
                  '\b',
                  'A',
                  '\b',
                  'A',
                  '\b',
                  'A',
                  Byte.MIN_VALUE
                }));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(contractResult)}.
   *
   * <ul>
   *   <li>When {@code DEFAULT}.
   *   <li>Then return AssetIssueID is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(contractResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(contractResult)"})
  public void testNewTransactionResultCapsule_whenDefault_thenReturnAssetIssueIDIsEmptyString() {
    // Arrange and Act
    TransactionResultCapsule actualTransactionResultCapsule =
        new TransactionResultCapsule(contractResult.DEFAULT);

    // Assert
    assertEquals("", actualTransactionResultCapsule.getAssetIssueID());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeId());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeInjectAnotherAmount());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeReceivedAmount());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeWithdrawAnotherAmount());
    assertEquals(0L, actualTransactionResultCapsule.getFee());
    assertEquals(0L, actualTransactionResultCapsule.getShieldedTransactionFee());
    assertEquals(0L, actualTransactionResultCapsule.getUnfreezeAmount());
    assertEquals(0L, actualTransactionResultCapsule.getWithdrawAmount());
    assertEquals(0L, actualTransactionResultCapsule.getWithdrawExpireAmount());
    assertTrue(actualTransactionResultCapsule.getOrderDetailsList().isEmpty());
    assertTrue(actualTransactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertArrayEquals(new byte[] {}, actualTransactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code rXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule_whenRXAXAXAXBytesIsUtf8()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionResultCapsule("rXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(code, long)}.
   *
   * <ul>
   *   <li>When {@code SUCESS}.
   *   <li>Then return AssetIssueID is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(code, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(code, long)"})
  public void testNewTransactionResultCapsule_whenSucess_thenReturnAssetIssueIDIsEmptyString() {
    // Arrange and Act
    TransactionResultCapsule actualTransactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Assert
    assertEquals("", actualTransactionResultCapsule.getAssetIssueID());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeId());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeInjectAnotherAmount());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeReceivedAmount());
    assertEquals(0L, actualTransactionResultCapsule.getExchangeWithdrawAnotherAmount());
    assertEquals(0L, actualTransactionResultCapsule.getShieldedTransactionFee());
    assertEquals(0L, actualTransactionResultCapsule.getUnfreezeAmount());
    assertEquals(0L, actualTransactionResultCapsule.getWithdrawAmount());
    assertEquals(0L, actualTransactionResultCapsule.getWithdrawExpireAmount());
    assertEquals(1L, actualTransactionResultCapsule.getFee());
    assertTrue(actualTransactionResultCapsule.getOrderDetailsList().isEmpty());
    assertTrue(actualTransactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertArrayEquals(new byte[] {'\b', 1}, actualTransactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code xXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule_whenXXAXAXAXBytesIsUtf8()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionResultCapsule("xXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.<init>(byte[])"})
  public void testNewTransactionResultCapsule_whenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionResultCapsule("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2L, transactionResultCapsule.getFee());
    assertEquals(2L, instance.getFee());
    assertArrayEquals(new byte[] {'\b', 2}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(2L, transactionResultCapsule.getFee());
    assertEquals(2L, instance.getFee());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {'\b', 2}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} addOrderDetails
   *       DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_givenTransactionResultCapsuleAddOrderDetailsDefaultInstance() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeId is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_givenTransactionResultCapsuleExchangeIdIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}
   *       ExchangeInjectAnotherAmount is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_givenTransactionResultCapsuleExchangeInjectAnotherAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeReceivedAmount
   *       is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_givenTransactionResultCapsuleExchangeReceivedAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}
   *       ExchangeWithdrawAnotherAmount is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_givenTransactionResultCapsuleExchangeWithdrawAnotherAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} OrderId is {@link
   *       ByteString}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_givenTransactionResultCapsuleOrderIdIsByteString() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ShieldedTransactionFee
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_givenTransactionResultCapsuleShieldedTransactionFeeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} UnfreezeAmount is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_givenTransactionResultCapsuleUnfreezeAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'\b', 1, Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} WithdrawExpireAmount is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_givenTransactionResultCapsuleWithdrawExpireAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance AllFields size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_thenTransactionResultCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance AllFields size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_thenTransactionResultCapsuleInstanceAllFieldsSizeIsOne2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is four.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_thenTransactionResultCapsuleInstanceSerializedSizeIsFour() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is six.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_thenTransactionResultCapsuleInstanceSerializedSizeIsSix() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setStatus(long, code)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is twelve.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setStatus(long, code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setStatus(long, code)"})
  public void testSetStatus_thenTransactionResultCapsuleInstanceSerializedSizeIsTwelve() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setStatus(1L, code.SUCESS);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {'\b', 1, -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getFee()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getFee()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionResultCapsule.getFee()"})
  public void testGetFee() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionResultCapsule().getFee());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_givenTransactionResultCapsule() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} addOrderDetails
   *       DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_givenTransactionResultCapsuleAddOrderDetailsDefaultInstance() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeId is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_givenTransactionResultCapsuleExchangeIdIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}
   *       ExchangeInjectAnotherAmount is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_givenTransactionResultCapsuleExchangeInjectAnotherAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeReceivedAmount
   *       is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_givenTransactionResultCapsuleExchangeReceivedAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}
   *       ExchangeWithdrawAnotherAmount is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_givenTransactionResultCapsuleExchangeWithdrawAnotherAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} OrderId is {@link
   *       ByteString}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_givenTransactionResultCapsuleOrderIdIsByteString() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ShieldedTransactionFee
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_givenTransactionResultCapsuleShieldedTransactionFeeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} UnfreezeAmount is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_givenTransactionResultCapsuleUnfreezeAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'\b', 1, Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} WithdrawExpireAmount is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_givenTransactionResultCapsuleWithdrawExpireAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance AllFields size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_thenTransactionResultCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is four.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_thenTransactionResultCapsuleInstanceSerializedSizeIsFour() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is six.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_thenTransactionResultCapsuleInstanceSerializedSizeIsSix() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is twelve.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_thenTransactionResultCapsuleInstanceSerializedSizeIsTwelve() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {'\b', 1, -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setFee(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule(code, long)} with code is
   *       {@code FAILED} and fee is one Fee is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setFee(long)"})
  public void testSetFee_thenTransactionResultCapsuleWithCodeIsFailedAndFeeIsOneFeeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert that nothing has changed
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 16, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getUnfreezeAmount()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getUnfreezeAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionResultCapsule.getUnfreezeAmount()"})
  public void testGetUnfreezeAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionResultCapsule().getUnfreezeAmount());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'\b', 1, Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'\b', 1, 16, 1, Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount6() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_givenTransactionResultCapsule() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeId is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_givenTransactionResultCapsuleExchangeIdIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeReceivedAmount
   *       is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_givenTransactionResultCapsuleExchangeReceivedAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} OrderId is {@link
   *       ByteString}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_givenTransactionResultCapsuleOrderIdIsByteString() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ShieldedTransactionFee
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_givenTransactionResultCapsuleShieldedTransactionFeeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} WithdrawExpireAmount is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_givenTransactionResultCapsuleWithdrawExpireAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance AllFields size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_thenTransactionResultCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is five.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_thenTransactionResultCapsuleInstanceSerializedSizeIsFive() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'x', '\n', Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setUnfreezeAmount(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is seven.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_thenTransactionResultCapsuleInstanceSerializedSizeIsSeven() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'r', 2, '4', '2', Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getAssetIssueID()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getAssetIssueID()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransactionResultCapsule.getAssetIssueID()"})
  public void testGetAssetIssueID() {
    // Arrange, Act and Assert
    assertEquals("", new TransactionResultCapsule().getAssetIssueID());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'r', 2, '4', '2', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'r', 2, '4', '2', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'\b', 1, 16, 1, 'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} addOrderDetails
   *       DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID_givenTransactionResultCapsuleAddOrderDetailsDefaultInstance() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'r', 2, '4', '2', -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeId is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID_givenTransactionResultCapsuleExchangeIdIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'r', 2, '4', '2', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeReceivedAmount
   *       is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID_givenTransactionResultCapsuleExchangeReceivedAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'r', 2, '4', '2', -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} OrderId is {@link
   *       ByteString}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID_givenTransactionResultCapsuleOrderIdIsByteString() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    assertArrayEquals(new byte[] {'r', 2, '4', '2', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ShieldedTransactionFee
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID_givenTransactionResultCapsuleShieldedTransactionFeeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'r', 2, '4', '2', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} UnfreezeAmount is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID_givenTransactionResultCapsuleUnfreezeAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'r', 2, '4', '2', Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} WithdrawExpireAmount is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID_givenTransactionResultCapsuleWithdrawExpireAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'r', 2, '4', '2', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance AllFields size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID_thenTransactionResultCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance AllFields size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID_thenTransactionResultCapsuleInstanceAllFieldsSizeIsOne2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID_thenTransactionResultCapsuleInstanceSerializedSizeIsFourteen() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(14, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {'r', 2, '4', '2', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setAssetIssueID(String)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is six.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setAssetIssueID(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setAssetIssueID(String)"})
  public void testSetAssetIssueID_thenTransactionResultCapsuleInstanceSerializedSizeIsSix() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setAssetIssueID("42");

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'r', 2, '4', '2', 'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getWithdrawAmount()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getWithdrawAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionResultCapsule.getWithdrawAmount()"})
  public void testGetWithdrawAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionResultCapsule().getWithdrawAmount());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 16, 1, 'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_givenTransactionResultCapsule() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeId is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_givenTransactionResultCapsuleExchangeIdIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeReceivedAmount
   *       is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_givenTransactionResultCapsuleExchangeReceivedAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} OrderId is {@link
   *       ByteString}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_givenTransactionResultCapsuleOrderIdIsByteString() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ShieldedTransactionFee
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_givenTransactionResultCapsuleShieldedTransactionFeeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} UnfreezeAmount is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_givenTransactionResultCapsuleUnfreezeAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'x', '\n', Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} WithdrawExpireAmount is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_givenTransactionResultCapsuleWithdrawExpireAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance AllFields size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_thenTransactionResultCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is six.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_thenTransactionResultCapsuleInstanceSerializedSizeIsSix() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'r', 2, '4', '2', 'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawAmount(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is twelve.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_thenTransactionResultCapsuleInstanceSerializedSizeIsTwelve() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {'x', '\n', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getWithdrawExpireAmount()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getWithdrawExpireAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionResultCapsule.getWithdrawExpireAmount()"})
  public void testGetWithdrawExpireAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionResultCapsule().getWithdrawExpireAmount());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-46, 1, 0, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'r', 2, '4', '2', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-96, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-88, 1, 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-80, 1, 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-54, 1, 0, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'\b', 1, 16, 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount14() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {-40, 1, '\n', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setWithdrawExpireAmount(long)"})
  public void testSetWithdrawExpireAmount_givenTransactionResultCapsule() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getCancelUnfreezeV2AmountMap()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getCancelUnfreezeV2AmountMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TransactionResultCapsule.getCancelUnfreezeV2AmountMap()"})
  public void testGetCancelUnfreezeV2AmountMap() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
  }

  /**
   * Test {@link TransactionResultCapsule#getCancelUnfreezeV2AmountMap()}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getCancelUnfreezeV2AmountMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TransactionResultCapsule.getCancelUnfreezeV2AmountMap()"})
  public void testGetCancelUnfreezeV2AmountMap_givenTransactionResultCapsule() {
    // Arrange, Act and Assert
    assertTrue(new TransactionResultCapsule().getCancelUnfreezeV2AmountMap().isEmpty());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    HashMap<String, Long> map = new HashMap<>();

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);
    HashMap<String, Long> map = new HashMap<>();

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {-46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {-40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {-112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {-96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {-88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {-104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {-80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {-54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap15() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(map, transactionResultCapsule.getCancelUnfreezeV2AmountMap());
    assertEquals(map, instance.getCancelUnfreezeV2Amount());
    assertEquals(map, instance.getCancelUnfreezeV2AmountMap());
    assertArrayEquals(
        new byte[] {-30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.putAllCancelUnfreezeV2AmountMap(Map)"})
  public void testPutAllCancelUnfreezeV2AmountMap16() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);
    HashMap<String, Long> map = new HashMap<>();

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(map, features.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {'\b', 1, 16, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getExchangeReceivedAmount()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getExchangeReceivedAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionResultCapsule.getExchangeReceivedAmount()"})
  public void testGetExchangeReceivedAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionResultCapsule().getExchangeReceivedAmount());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n', -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'r', 2, '4', '2', -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {-112, 1, '\n', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'\b', 1, 16, 1, -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount12() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {-112, 1, '\n', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount_givenTransactionResultCapsule() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeId is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount_givenTransactionResultCapsuleExchangeIdIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} OrderId is {@link
   *       ByteString}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeReceivedAmount(long)"})
  public void testSetExchangeReceivedAmount_givenTransactionResultCapsuleOrderIdIsByteString() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getExchangeWithdrawAnotherAmount()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getExchangeWithdrawAnotherAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionResultCapsule.getExchangeWithdrawAnotherAmount()"})
  public void testGetExchangeWithdrawAnotherAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionResultCapsule().getExchangeWithdrawAnotherAmount());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-96, 1, '\n', -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'r', 2, '4', '2', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-96, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-96, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-96, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-96, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'\b', 1, 16, 1, -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount14() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {-96, 1, '\n', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeWithdrawAnotherAmount(long)"})
  public void testSetExchangeWithdrawAnotherAmount_givenTransactionResultCapsule() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getExchangeId()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getExchangeId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionResultCapsule.getExchangeId()"})
  public void testGetExchangeId() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionResultCapsule().getExchangeId());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-96, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 16, 1, -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId_givenTransactionResultCapsule() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    assertEquals(1L, instance.getExchangeId());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} addOrderDetails
   *       DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId_givenTransactionResultCapsuleAddOrderDetailsDefaultInstance() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-88, 1, 1, -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} OrderId is {@link
   *       ByteString}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId_givenTransactionResultCapsuleOrderIdIsByteString() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-88, 1, 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ShieldedTransactionFee
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId_givenTransactionResultCapsuleShieldedTransactionFeeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-88, 1, 1, -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} WithdrawExpireAmount is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId_givenTransactionResultCapsuleWithdrawExpireAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-88, 1, 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance AllFields size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId_thenTransactionResultCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    assertEquals(1L, instance.getExchangeId());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is five.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId_thenTransactionResultCapsuleInstanceSerializedSizeIsFive() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is seven.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId_thenTransactionResultCapsuleInstanceSerializedSizeIsSeven() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'r', 2, '4', '2', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeId(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is thirteen.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeId(long)"})
  public void testSetExchangeId_thenTransactionResultCapsuleInstanceSerializedSizeIsThirteen() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(13, instance.getSerializedSize());
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {-88, 1, 1, -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getExchangeInjectAnotherAmount()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getExchangeInjectAnotherAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionResultCapsule.getExchangeInjectAnotherAmount()"})
  public void testGetExchangeInjectAnotherAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionResultCapsule().getExchangeInjectAnotherAmount());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n', -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'r', 2, '4', '2', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {-112, 1, '\n', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'\b', 1, 16, 1, -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount13() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {-104, 1, '\n', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount_givenTransactionResultCapsule() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeId is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setExchangeInjectAnotherAmount(long)"})
  public void testSetExchangeInjectAnotherAmount_givenTransactionResultCapsuleExchangeIdIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2L, transactionResultCapsule.getFee());
    assertEquals(2L, instance.getFee());
    assertArrayEquals(new byte[] {'\b', 2}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(2L, transactionResultCapsule.getFee());
    assertEquals(2L, instance.getFee());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 2, 16, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_givenTransactionResultCapsule() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} addOrderDetails
   *       DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_givenTransactionResultCapsuleAddOrderDetailsDefaultInstance() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeId is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_givenTransactionResultCapsuleExchangeIdIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}
   *       ExchangeInjectAnotherAmount is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_givenTransactionResultCapsuleExchangeInjectAnotherAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ExchangeReceivedAmount
   *       is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_givenTransactionResultCapsuleExchangeReceivedAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}
   *       ExchangeWithdrawAnotherAmount is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_givenTransactionResultCapsuleExchangeWithdrawAnotherAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} OrderId is {@link
   *       ByteString}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_givenTransactionResultCapsuleOrderIdIsByteString() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} ShieldedTransactionFee
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_givenTransactionResultCapsuleShieldedTransactionFeeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} UnfreezeAmount is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_givenTransactionResultCapsuleUnfreezeAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'\b', 1, Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} WithdrawExpireAmount is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_givenTransactionResultCapsuleWithdrawExpireAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance AllFields size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_thenTransactionResultCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is four.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_thenTransactionResultCapsuleInstanceSerializedSizeIsFour() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is six.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_thenTransactionResultCapsuleInstanceSerializedSizeIsSix() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#addFee(long)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is twelve.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.addFee(long)"})
  public void testAddFee_thenTransactionResultCapsuleInstanceSerializedSizeIsTwelve() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {'\b', 1, -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {-46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {-40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {-112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {-96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {-88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {-104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {-80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {-54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is four.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode_thenTransactionResultCapsuleInstanceSerializedSizeIsFour() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode_thenTransactionResultCapsuleInstanceSerializedSizeIsTen() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(
        new byte[] {-30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode_thenTransactionResultCapsuleInstanceSerializedSizeIsTwo() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertArrayEquals(new byte[] {'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is zero.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode_thenTransactionResultCapsuleInstanceSerializedSizeIsZero() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertTrue(instance.getAllFields().isEmpty());
    assertArrayEquals(new byte[] {}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setErrorCode(code)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is zero.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setErrorCode(code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setErrorCode(code)"})
  public void testSetErrorCode_thenTransactionResultCapsuleInstanceSerializedSizeIsZero2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setErrorCode(code.SUCESS);

    // Assert that nothing has changed
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(code.SUCESS, instance.getRet());
    assertTrue(instance.getAllFields().isEmpty());
    assertArrayEquals(new byte[] {}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getShieldedTransactionFee()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getShieldedTransactionFee()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionResultCapsule.getShieldedTransactionFee()"})
  public void testGetShieldedTransactionFee() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionResultCapsule().getShieldedTransactionFee());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-80, 1, 1, -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'r', 2, '4', '2', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-80, 1, 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-96, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-88, 1, 1, -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 16, 1, -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee13() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(13, instance.getSerializedSize());
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {-80, 1, 1, -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee_givenTransactionResultCapsule() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setShieldedTransactionFee(long)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} OrderId is {@link
   *       ByteString}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setShieldedTransactionFee(long)"})
  public void testSetShieldedTransactionFee_givenTransactionResultCapsuleOrderIdIsByteString() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-80, 1, 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getOrderId()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getOrderId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString TransactionResultCapsule.getOrderId()"})
  public void testGetOrderId() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    ByteString actualOrderId = transactionResultCapsule.getOrderId();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(byteString, instance.getAssetIssueIDBytes());
    Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getAssetIssueIDBytes());
    assertSame(byteString, actualOrderId);
    assertSame(byteString, instance.getOrderId());
    assertSame(byteString, defaultInstanceForType.getOrderId());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    assertArrayEquals(new byte[] {'\b', 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-112, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-96, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-88, 1, 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-104, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-80, 1, 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule =
        new TransactionResultCapsule(code.FAILED, 1L);

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    assertEquals(3, transactionResultCapsule.getInstance().getAllFields().size());
    assertArrayEquals(new byte[] {'\b', 1, 16, 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()} WithdrawExpireAmount is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId_givenTransactionResultCapsuleWithdrawExpireAmountIsTen() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-54, 1, 0, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Data is array of {@code
   *       byte} with {@link Byte#MIN_VALUE} and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId_thenTransactionResultCapsuleDataIsArrayOfByteWithMin_valueAndOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {Byte.MIN_VALUE, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance AllFields size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId_thenTransactionResultCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance AllFields size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId_thenTransactionResultCapsuleInstanceAllFieldsSizeIsOne2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is five.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId_thenTransactionResultCapsuleInstanceSerializedSizeIsFive() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is seven.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId_thenTransactionResultCapsuleInstanceSerializedSizeIsSeven() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'r', 2, '4', '2', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} Instance SerializedSize
   *       is thirteen.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId_thenTransactionResultCapsuleInstanceSerializedSizeIsThirteen() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    Result instance = transactionResultCapsule.getInstance();
    assertEquals(13, instance.getSerializedSize());
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {-54, 1, 0, -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#setOrderId(ByteString)}.
   *
   * <ul>
   *   <li>Then {@link TransactionResultCapsule#TransactionResultCapsule()} OrderDetailsList size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionResultCapsule.setOrderId(ByteString)"})
  public void testSetOrderId_thenTransactionResultCapsuleOrderDetailsListSizeIsOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Assert
    List<MarketOrderDetail> orderDetailsList = transactionResultCapsule.getOrderDetailsList();
    assertEquals(1, orderDetailsList.size());
    ByteString byteString = ByteString.EMPTY;
    MarketOrderDetail getResult = orderDetailsList.get(0);
    assertSame(byteString, getResult.getMakerOrderId());
    assertSame(byteString, getResult.getTakerOrderId());
    assertArrayEquals(new byte[] {-54, 1, 0, -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getOrderDetailsList()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getOrderDetailsList()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TransactionResultCapsule.getOrderDetailsList()"})
  public void testGetOrderDetailsList() {
    // Arrange, Act and Assert
    assertTrue(new TransactionResultCapsule().getOrderDetailsList().isEmpty());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isEmpty()} return {@code true}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_givenByteStringIsEmptyReturnTrue_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString orderId = mock(ByteString.class);
    when(orderId.isEmpty()).thenReturn(true);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(orderId);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    byte[] actualData = transactionResultCapsule.getData();

    // Assert
    verify(orderId, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {}, actualData);
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is minus one.
   *   <li>Then return array of {@code byte} with minus thirty and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_givenHashMapFooIsMinusOne_thenReturnArrayOfByteWithMinusThirtyAndOne() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", -1L);

    ByteString orderId = mock(ByteString.class);
    when(orderId.isEmpty()).thenReturn(true);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(orderId);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    byte[] actualData = transactionResultCapsule.getData();

    // Assert
    verify(orderId, atLeast(1)).isEmpty();
    assertArrayEquals(
        new byte[] {-30, 1, 16, '\n', 3, 'f', 'o', 'o', 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        actualData);
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link TransactionResultCapsule#TransactionResultCapsule()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_givenTransactionResultCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new TransactionResultCapsule().getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and minus one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithBackspaceAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        new TransactionResultCapsule(code.SUCESS, -1L).getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithBackspaceAndOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[] {'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE} and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithMin_valueAndOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[] {Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus eighty and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithMinusEightyAndOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(-1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(
        new byte[] {-80, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus eighty-eight and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithMinusEightyEightAndOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[] {-88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus fifty-four and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithMinusFiftyFourAndOne() {
    // Arrange
    ByteString orderId = mock(ByteString.class);
    when(orderId.size()).thenReturn(0);
    when(orderId.isEmpty()).thenReturn(false);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(orderId);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    byte[] actualData = transactionResultCapsule.getData();

    // Assert
    verify(orderId, atLeast(1)).isEmpty();
    verify(orderId, atLeast(1)).size();
    assertArrayEquals(new byte[] {-54, 1, 0}, actualData);
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus fifty-four and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithMinusFiftyFourAndOne2() {
    // Arrange
    ByteString orderId = mock(ByteString.class);
    when(orderId.size()).thenReturn(0);
    when(orderId.isEmpty()).thenReturn(false);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(Long.MAX_VALUE);
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.setOrderId(orderId);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    byte[] actualData = transactionResultCapsule.getData();

    // Assert
    verify(orderId, atLeast(1)).isEmpty();
    verify(orderId, atLeast(1)).size();
    assertArrayEquals(
        new byte[] {-54, 1, 0, -46, 1, 0, -40, 1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE},
        actualData);
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus forty and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithMinusFortyAndOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[] {-40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus forty-six and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithMinusFortySixAndOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[] {-46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus ninety-six and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithMinusNinetySixAndOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[] {-96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred four and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithMinusOneHundredFourAndOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[] {-104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twelve and one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithMinusOneHundredTwelveAndOne() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[] {-112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code r} and two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithRAndTwo() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[] {'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code x} and lf.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithXAndLf() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[] {'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionResultCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[] {}, transactionResultCapsule.getData());
  }

  /**
   * Test {@link TransactionResultCapsule#getInstance()}.
   *
   * <p>Method under test: {@link TransactionResultCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Result TransactionResultCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    Result actualInstance = new TransactionResultCapsule().getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals("", actualInstance.getAssetIssueID());
    assertEquals(0, actualInstance.getCancelUnfreezeV2AmountCount());
    assertEquals(0, actualInstance.getContractRetValue());
    assertEquals(0, actualInstance.getOrderDetailsCount());
    assertEquals(0, actualInstance.getRetValue());
    assertEquals(0, actualInstance.getSerializedSize());
    assertEquals(0L, actualInstance.getExchangeId());
    assertEquals(0L, actualInstance.getExchangeInjectAnotherAmount());
    assertEquals(0L, actualInstance.getExchangeReceivedAmount());
    assertEquals(0L, actualInstance.getExchangeWithdrawAnotherAmount());
    assertEquals(0L, actualInstance.getFee());
    assertEquals(0L, actualInstance.getShieldedTransactionFee());
    assertEquals(0L, actualInstance.getUnfreezeAmount());
    assertEquals(0L, actualInstance.getWithdrawAmount());
    assertEquals(0L, actualInstance.getWithdrawExpireAmount());
    assertEquals(code.SUCESS, actualInstance.getRet());
    assertEquals(contractResult.DEFAULT, actualInstance.getContractRet());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    List<MarketOrderDetail> orderDetailsList = actualInstance.getOrderDetailsList();
    assertTrue(orderDetailsList.isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(actualInstance.getCancelUnfreezeV2AmountMap().isEmpty());
    Result actualDefaultInstanceForType = actualInstance.getDefaultInstanceForType();
    assertEquals(actualInstance, actualDefaultInstanceForType);
    assertSame(orderDetailsList, actualInstance.getOrderDetailsOrBuilderList());
  }
}
