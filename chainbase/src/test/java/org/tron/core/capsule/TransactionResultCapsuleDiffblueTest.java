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
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.tron.core.exception.BadItemException;
import org.tron.protos.Protocol;

public class TransactionResultCapsuleDiffblueTest {
  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals(2, data.length);
    assertEquals(2L, transactionResultCapsule.getFee());
    assertEquals(2L, transactionResultCapsule.getInstance().getFee());
    assertEquals((byte) 2, data[1]);
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus15() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.FAILED, 1L);

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    byte[] data = transactionResultCapsule.getData();
    assertEquals(2, data.length);
    assertEquals(2L, transactionResultCapsule.getFee());
    assertEquals(2L, instance.getFee());
    assertEquals((byte) 2, data[1]);
    assertEquals(Protocol.Transaction.Result.code.SUCESS, instance.getRet());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setStatus(long, Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetStatus16() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setStatus(1L, Protocol.Transaction.Result.code.SUCESS);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\b', 1, -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getFee()}
   */
  @Test
  public void testGetFee() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionResultCapsule()).getFee());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getFee()}
   */
  @Test
  public void testGetFee2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, transactionResultCapsule.getFee());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setFee(long)}
   */
  @Test
  public void testSetFee14() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setFee(1L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\b', 1, -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getUnfreezeAmount()}
   */
  @Test
  public void testGetUnfreezeAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionResultCapsule()).getUnfreezeAmount());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getUnfreezeAmount()}
   */
  @Test
  public void testGetUnfreezeAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, transactionResultCapsule.getUnfreezeAmount());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertEquals(5, data.length);
    assertEquals(Byte.MIN_VALUE, data[2]);
    assertEquals('\n', data[4]);
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'r', 2, '4', '2', Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.FAILED, 1L);

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertEquals(7, data.length);
    assertEquals(Byte.MIN_VALUE, data[4]);
    assertEquals('\n', data[6]);
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount15() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setUnfreezeAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getUnfreezeAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getAssetIssueID()}
   */
  @Test
  public void testGetAssetIssueID() {
    // Arrange, Act and Assert
    assertEquals("", (new TransactionResultCapsule()).getAssetIssueID());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getAssetIssueID()}
   */
  @Test
  public void testGetAssetIssueID2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Act and Assert
    assertEquals("", transactionResultCapsule.getAssetIssueID());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getWithdrawAmount()}
   */
  @Test
  public void testGetWithdrawAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionResultCapsule()).getWithdrawAmount());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getWithdrawAmount()}
   */
  @Test
  public void testGetWithdrawAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, transactionResultCapsule.getWithdrawAmount());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    byte[] data = transactionResultCapsule.getData();
    assertEquals(4, data.length);
    assertEquals('\n', data[3]);
    assertEquals('x', data[2]);
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'r', 2, '4', '2', 'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.FAILED, 1L);

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    byte[] data = transactionResultCapsule.getData();
    assertEquals(6, data.length);
    assertEquals('\n', data[5]);
    assertEquals('x', data[4]);
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount15() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setWithdrawAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'x', '\n', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getWithdrawExpireAmount()}
   */
  @Test
  public void testGetWithdrawExpireAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionResultCapsule()).getWithdrawExpireAmount());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getWithdrawExpireAmount()}
   */
  @Test
  public void testGetWithdrawExpireAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, transactionResultCapsule.getWithdrawExpireAmount());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -40, data[2]);
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertEquals(5, data.length);
    assertEquals('\n', data[4]);
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-46, 1, 0, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'r', 2, '4', '2', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-96, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-88, 1, 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-104, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-80, 1, 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-54, 1, 0, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.FAILED, 1L);

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -40, data[4]);
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertEquals(7, data.length);
    assertEquals('\n', data[6]);
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setWithdrawExpireAmount(long)}
   */
  @Test
  public void testSetWithdrawExpireAmount15() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setWithdrawExpireAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getWithdrawExpireAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getWithdrawExpireAmount());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{-40, 1, '\n', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#getCancelUnfreezeV2AmountMap()}
   */
  @Test
  public void testGetCancelUnfreezeV2AmountMap() {
    // Arrange, Act and Assert
    assertTrue((new TransactionResultCapsule()).getCancelUnfreezeV2AmountMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#getCancelUnfreezeV2AmountMap()}
   */
  @Test
  public void testGetCancelUnfreezeV2AmountMap2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#getCancelUnfreezeV2AmountMap()}
   */
  @Test
  public void testGetCancelUnfreezeV2AmountMap3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    HashMap<String, Long> map = new HashMap<>();

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, transactionResultCapsule.getData().length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertTrue(instance.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertEquals(instance, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, transactionResultCapsule.getData().length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertTrue(instance.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertEquals(instance, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    Protocol.Transaction.Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertArrayEquals(new byte[]{-46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    Protocol.Transaction.Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    Protocol.Transaction.Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertArrayEquals(new byte[]{'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertEquals(2, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    Protocol.Transaction.Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertArrayEquals(new byte[]{'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    Protocol.Transaction.Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertArrayEquals(new byte[]{-40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    Protocol.Transaction.Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertArrayEquals(new byte[]{-112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    Protocol.Transaction.Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertArrayEquals(new byte[]{-96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    Protocol.Transaction.Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertArrayEquals(new byte[]{-88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    Protocol.Transaction.Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertArrayEquals(new byte[]{-104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    Protocol.Transaction.Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertArrayEquals(new byte[]{-80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    HashMap<String, Long> map = new HashMap<>();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(2, enumTypes.size());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(transactionResultCapsule.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    Protocol.Transaction.Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(map, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(map, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(map, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(map, options3.getAllFields());
    assertEquals(map, features.getAllFieldsRaw());
    assertEquals(map, options2.getAllFieldsRaw());
    assertEquals(map, options3.getAllFieldsRaw());
    assertArrayEquals(new byte[]{-54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#putAllCancelUnfreezeV2AmountMap(Map)}
   */
  @Test
  public void testPutAllCancelUnfreezeV2AmountMap14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    // Act
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    Map<String, Long> cancelUnfreezeV2AmountMap = transactionResultCapsule.getCancelUnfreezeV2AmountMap();
    assertEquals(1, cancelUnfreezeV2AmountMap.size());
    Map<String, Long> cancelUnfreezeV2Amount = instance.getCancelUnfreezeV2Amount();
    assertEquals(1, cancelUnfreezeV2Amount.size());
    Map<String, Long> cancelUnfreezeV2AmountMap2 = instance.getCancelUnfreezeV2AmountMap();
    assertEquals(1, cancelUnfreezeV2AmountMap2.size());
    assertEquals(1, instance.getCancelUnfreezeV2AmountCount());
    assertEquals(10, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(15, descriptorForType.getFields().size());
    assertEquals(1L, cancelUnfreezeV2AmountMap.get("foo").longValue());
    assertEquals(1L, cancelUnfreezeV2Amount.get("foo").longValue());
    assertEquals(1L, cancelUnfreezeV2AmountMap2.get("foo").longValue());
    assertEquals(2, descriptorForType.getEnumTypes().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    Protocol.Transaction.Result defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertArrayEquals(new byte[]{-30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#getExchangeReceivedAmount()}
   */
  @Test
  public void testGetExchangeReceivedAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionResultCapsule()).getExchangeReceivedAmount());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#getExchangeReceivedAmount()}
   */
  @Test
  public void testGetExchangeReceivedAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, transactionResultCapsule.getExchangeReceivedAmount());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -112, data[2]);
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertEquals(5, data.length);
    assertEquals('\n', data[4]);
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n', -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'r', 2, '4', '2', -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.FAILED, 1L);

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -112, data[4]);
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertEquals(7, data.length);
    assertEquals('\n', data[6]);
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeReceivedAmount(long)}
   */
  @Test
  public void testSetExchangeReceivedAmount15() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setExchangeReceivedAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeReceivedAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeReceivedAmount());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{-112, 1, '\n', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#getExchangeWithdrawAnotherAmount()}
   */
  @Test
  public void testGetExchangeWithdrawAnotherAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionResultCapsule()).getExchangeWithdrawAnotherAmount());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#getExchangeWithdrawAnotherAmount()}
   */
  @Test
  public void testGetExchangeWithdrawAnotherAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -96, data[2]);
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertEquals(5, data.length);
    assertEquals('\n', data[4]);
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-96, 1, '\n', -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'r', 2, '4', '2', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-96, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-96, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-104, 1, '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-96, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-96, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.FAILED, 1L);

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -96, data[4]);
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertEquals(7, data.length);
    assertEquals('\n', data[6]);
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeWithdrawAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeWithdrawAnotherAmount15() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeWithdrawAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeWithdrawAnotherAmount());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{-96, 1, '\n', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getExchangeId()}
   */
  @Test
  public void testGetExchangeId() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionResultCapsule()).getExchangeId());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getExchangeId()}
   */
  @Test
  public void testGetExchangeId2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, transactionResultCapsule.getExchangeId());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    assertEquals(1L, instance.getExchangeId());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -88, data[2]);
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[4]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertEquals(5, data.length);
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    assertEquals(1L, instance.getExchangeId());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-88, 1, 1, -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'r', 2, '4', '2', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-88, 1, 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-96, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-104, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-88, 1, 1, -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-88, 1, 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.FAILED, 1L);

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -88, data[4]);
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[6]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertEquals(7, data.length);
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setExchangeId(long)}
   */
  @Test
  public void testSetExchangeId15() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setExchangeId(1L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(13, instance.getSerializedSize());
    assertEquals(1L, transactionResultCapsule.getExchangeId());
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{-88, 1, 1, -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#getExchangeInjectAnotherAmount()}
   */
  @Test
  public void testGetExchangeInjectAnotherAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionResultCapsule()).getExchangeInjectAnotherAmount());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#getExchangeInjectAnotherAmount()}
   */
  @Test
  public void testGetExchangeInjectAnotherAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, transactionResultCapsule.getExchangeInjectAnotherAmount());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -104, data[2]);
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertEquals(5, data.length);
    assertEquals('\n', data[4]);
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-104, 1, '\n', -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'r', 2, '4', '2', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-104, 1, '\n', -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n', -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-104, 1, '\n', -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-104, 1, '\n', -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-104, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-104, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.FAILED, 1L);

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -104, data[4]);
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertEquals(7, data.length);
    assertEquals('\n', data[6]);
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setExchangeInjectAnotherAmount(long)}
   */
  @Test
  public void testSetExchangeInjectAnotherAmount15() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);

    // Assert
    assertEquals(10L, transactionResultCapsule.getExchangeInjectAnotherAmount());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(10L, instance.getExchangeInjectAnotherAmount());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{-104, 1, '\n', -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.SUCESS, 1L);

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals(2, data.length);
    assertEquals(2L, transactionResultCapsule.getFee());
    assertEquals(2L, transactionResultCapsule.getInstance().getFee());
    assertEquals((byte) 2, data[1]);
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee15() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.FAILED, 1L);

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    assertEquals(2L, transactionResultCapsule.getFee());
    assertEquals(2L, transactionResultCapsule.getInstance().getFee());
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) 2, data[1]);
    assertEquals(4, data.length);
  }

  /**
   * Method under test: {@link TransactionResultCapsule#addFee(long)}
   */
  @Test
  public void testAddFee16() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.addFee(1L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(1L, transactionResultCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\b', 1, -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setErrorCode(Protocol.Transaction.Result.code)}
   */
  @Test
  public void testSetErrorCode() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.FAILED, 1L);

    // Act
    transactionResultCapsule.setErrorCode(Protocol.Transaction.Result.code.SUCESS);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(0, instance.getRetValue());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, transactionResultCapsule.getData().length);
    assertEquals(Protocol.Transaction.Result.code.SUCESS, instance.getRet());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#getShieldedTransactionFee()}
   */
  @Test
  public void testGetShieldedTransactionFee() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionResultCapsule()).getShieldedTransactionFee());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#getShieldedTransactionFee()}
   */
  @Test
  public void testGetShieldedTransactionFee2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, transactionResultCapsule.getShieldedTransactionFee());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.SUCESS, 1L);

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -80, data[2]);
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[4]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertEquals(5, data.length);
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-80, 1, 1, -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'r', 2, '4', '2', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'x', '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-80, 1, 1, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-112, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-96, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-88, 1, 1, -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-104, 1, '\n', -80, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{-80, 1, 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.FAILED, 1L);

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -80, data[4]);
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[6]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertEquals(7, data.length);
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#setShieldedTransactionFee(long)}
   */
  @Test
  public void testSetShieldedTransactionFee15() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);

    // Act
    transactionResultCapsule.setShieldedTransactionFee(1L);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(13, instance.getSerializedSize());
    assertEquals(1L, transactionResultCapsule.getShieldedTransactionFee());
    assertEquals(1L, instance.getShieldedTransactionFee());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{-80, 1, 1, -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getOrderId()}
   */
  @Test
  public void testGetOrderId() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();

    // Act
    ByteString actualOrderId = transactionResultCapsule.getOrderId();

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(15, fields.size());
    assertEquals(instance, instance.getDefaultInstanceForType());
    ByteString byteString = actualOrderId.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(13).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(14).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, instance.getAssetIssueIDBytes());
    assertSame(byteString, actualOrderId);
    assertSame(byteString, instance.getOrderId());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getOrderId()}
   */
  @Test
  public void testGetOrderId2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Act
    ByteString actualOrderId = transactionResultCapsule.getOrderId();

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    ByteString byteString = actualOrderId.EMPTY;
    assertEquals(byteString, instance.getAssetIssueIDBytes());
    assertSame(byteString, instance.getDefaultInstanceForType().getOrderId());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{-54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.SUCESS, 1L);
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -54, data[2]);
    assertEquals((byte) 0, data[4]);
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertEquals(5, data.length);
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{-54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    Protocol.MarketOrderDetail orderDetail = Protocol.MarketOrderDetail.getDefaultInstance();
    transactionResultCapsule.addOrderDetails(orderDetail);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    List<Protocol.MarketOrderDetail> orderDetailsList = transactionResultCapsule.getOrderDetailsList();
    assertEquals(1, orderDetailsList.size());
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertSame(orderDetail, orderDetailsList.get(0));
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{-54, 1, 0, -46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{'r', 2, '4', '2', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{'x', '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{-54, 1, 0, -40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{-112, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{-96, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{-88, 1, 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{-104, 1, '\n', -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{-80, 1, 1, -54, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId14() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule(
        Protocol.Transaction.Result.code.FAILED, 1L);
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    byte[] data = transactionResultCapsule.getData();
    assertEquals((byte) -54, data[4]);
    assertEquals((byte) 0, data[6]);
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertEquals(7, data.length);
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#setOrderId(ByteString)}
   */
  @Test
  public void testSetOrderId15() {
    // Arrange
    HashMap<String, Long> map = new HashMap<>();
    map.put("foo", 1L);

    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(map);
    ByteString orderId = mock(ByteString.class);

    // Act
    transactionResultCapsule.setOrderId(orderId);

    // Assert
    Protocol.Transaction.Result instance = transactionResultCapsule.getInstance();
    assertEquals(13, instance.getSerializedSize());
    assertEquals(15, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
    ByteString expectedOrderId = orderId.EMPTY;
    assertSame(expectedOrderId, instance.getDefaultInstanceForType().getOrderId());
    assertSame(orderId, transactionResultCapsule.getOrderId());
    assertSame(orderId, instance.getOrderId());
    assertArrayEquals(new byte[]{-54, 1, 0, -30, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1},
        transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getOrderDetailsList()}
   */
  @Test
  public void testGetOrderDetailsList() {
    // Arrange, Act and Assert
    assertTrue((new TransactionResultCapsule()).getOrderDetailsList().isEmpty());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getOrderDetailsList()}
   */
  @Test
  public void testGetOrderDetailsList2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setOrderId(mock(ByteString.class));

    // Act and Assert
    assertTrue(transactionResultCapsule.getOrderDetailsList().isEmpty());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new TransactionResultCapsule()).getData().length);
    assertArrayEquals(new byte[]{'\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        (new TransactionResultCapsule(Protocol.Transaction.Result.code.SUCESS, -1L)).getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertEquals(0, transactionResultCapsule.getData().length);
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addFee(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[]{'\b', 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.addOrderDetails(Protocol.MarketOrderDetail.getDefaultInstance());
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[]{-46, 1, 0}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData5() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setUnfreezeAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData6() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setAssetIssueID("42");
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[]{'r', 2, '4', '2'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData7() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[]{'x', '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData8() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setWithdrawExpireAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[]{-40, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData9() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeReceivedAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[]{-112, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData10() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeWithdrawAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[]{-96, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData11() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeId(1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[]{-88, 1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData12() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setExchangeInjectAnotherAmount(10L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[]{-104, 1, '\n'}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData13() {
    // Arrange
    TransactionResultCapsule transactionResultCapsule = new TransactionResultCapsule();
    transactionResultCapsule.setShieldedTransactionFee(-1L);
    transactionResultCapsule.putAllCancelUnfreezeV2AmountMap(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[]{-80, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, transactionResultCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData14() {
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
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link TransactionResultCapsule#getData()}
   */
  @Test
  public void testGetData15() {
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
    assertArrayEquals(new byte[]{-30, 1, 16, '\n', 3, 'f', 'o', 'o', 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        actualData);
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#TransactionResultCapsule(Protocol.Transaction.Result)}
   */
  @Test
  public void testNewTransactionResultCapsule() {
    // Arrange
    Protocol.Transaction.Result trxRet = Protocol.Transaction.Result.getDefaultInstance();

    // Act and Assert
    assertSame(trxRet, (new TransactionResultCapsule(trxRet)).getInstance());
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  public void testNewTransactionResultCapsule2() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionResultCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  public void testNewTransactionResultCapsule3() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionResultCapsule("\bXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  public void testNewTransactionResultCapsule4() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionResultCapsule(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  public void testNewTransactionResultCapsule5() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionResultCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  public void testNewTransactionResultCapsule6() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionResultCapsule("rXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  public void testNewTransactionResultCapsule7() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionResultCapsule("xXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  public void testNewTransactionResultCapsule8() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionResultCapsule("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  public void testNewTransactionResultCapsule9() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionResultCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  public void testNewTransactionResultCapsule10() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionResultCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  public void testNewTransactionResultCapsule11() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionResultCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionResultCapsule#TransactionResultCapsule(byte[])}
   */
  @Test
  public void testNewTransactionResultCapsule12() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionResultCapsule(new byte[]{'r', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }
}
