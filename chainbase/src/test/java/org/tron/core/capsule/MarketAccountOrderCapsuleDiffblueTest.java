package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.MarketAccountOrder;

public class MarketAccountOrderCapsuleDiffblueTest {
  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString)}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(ByteString)"})
  public void testNewMarketAccountOrderCapsule() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule =
        new MarketAccountOrderCapsule(address);

    // Assert
    MarketAccountOrder instance = actualMarketAccountOrderCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getOrdersCount());
    assertEquals(0L, actualMarketAccountOrderCapsule.getCount());
    assertEquals(0L, actualMarketAccountOrderCapsule.getTotalCount());
    assertEquals(0L, instance.getCount());
    assertEquals(0L, instance.getTotalCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<ByteString> ordersList = actualMarketAccountOrderCapsule.getOrdersList();
    assertTrue(ordersList.isEmpty());
    assertTrue(instance.isInitialized());
    assertSame(ordersList, instance.getOrdersList());
    assertSame(address, actualMarketAccountOrderCapsule.getOwnerAddress());
    assertSame(address, instance.getOwnerAddress());
    assertArrayEquals(new byte[] {'\n', 0}, actualMarketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString, List, long)}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString,
   * List, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(ByteString, List, long)"})
  public void testNewMarketAccountOrderCapsule2() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule =
        new MarketAccountOrderCapsule(address, new ArrayList<>(), 3L);

    // Assert
    MarketAccountOrder instance = actualMarketAccountOrderCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getOrdersCount());
    assertEquals(0L, actualMarketAccountOrderCapsule.getTotalCount());
    assertEquals(0L, instance.getTotalCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, actualMarketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<ByteString> ordersList = actualMarketAccountOrderCapsule.getOrdersList();
    assertTrue(ordersList.isEmpty());
    assertTrue(instance.isInitialized());
    assertSame(ordersList, instance.getOrdersList());
    assertSame(address, actualMarketAccountOrderCapsule.getOwnerAddress());
    assertSame(address, instance.getOwnerAddress());
    assertArrayEquals(new byte[] {'\n', 0, 24, 3}, actualMarketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule3() {
    // Arrange and Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule =
        new MarketAccountOrderCapsule(new byte[] {});

    // Assert
    MarketAccountOrder instance = actualMarketAccountOrderCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    ByteString ownerAddress = actualMarketAccountOrderCapsule.getOwnerAddress();
    assertEquals("", ownerAddress.toStringUtf8());
    assertEquals(0, instance.getOrdersCount());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0L, actualMarketAccountOrderCapsule.getCount());
    assertEquals(0L, actualMarketAccountOrderCapsule.getTotalCount());
    assertEquals(0L, instance.getCount());
    assertEquals(0L, instance.getTotalCount());
    assertFalse(ownerAddress.iterator().hasNext());
    assertTrue(ownerAddress.isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<ByteString> ordersList = actualMarketAccountOrderCapsule.getOrdersList();
    assertTrue(ordersList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(instance.isInitialized());
    MarketAccountOrder actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertSame(ordersList, instance.getOrdersList());
    assertSame(ownerAddress, instance.getOwnerAddress());
    assertArrayEquals(new byte[] {}, actualMarketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenAAAAAAAABytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new MarketAccountOrderCapsule("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new MarketAccountOrderCapsule("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and lf.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithAAndLf() {
    // Arrange and Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule =
        new MarketAccountOrderCapsule(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 0, '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualMarketAccountOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and lf.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithEighteenAndLf() {
    // Arrange and Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule =
        new MarketAccountOrderCapsule(
            new byte[] {
              18, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualMarketAccountOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange and Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule =
        new MarketAccountOrderCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketAccountOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule =
        new MarketAccountOrderCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketAccountOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule =
        new MarketAccountOrderCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketAccountOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithTwentyFourAndX() {
    // Arrange and Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule =
        new MarketAccountOrderCapsule(new byte[] {24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketAccountOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithZeroAndX() {
    // Arrange and Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule =
        new MarketAccountOrderCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketAccountOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketAccountOrderCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketAccountOrderCapsule(" XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketAccountOrderCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getOwnerAddress()}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#getOwnerAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString MarketAccountOrderCapsule.getOwnerAddress()"})
  public void testGetOwnerAddress() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule =
        new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.getOwnerAddress();

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(4, fields.size());
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getOwnerAddress());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#createDbKey()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = new MarketAccountOrderCapsule(address).createDbKey();

    // Assert
    verify(address).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#createDbKey()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnEmptyArrayOfByte() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule =
        new MarketAccountOrderCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, marketAccountOrderCapsule.createDbKey());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getOrdersList()}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#getOrdersList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MarketAccountOrderCapsule.getOrdersList()"})
  public void testGetOrdersList() {
    // Arrange, Act and Assert
    assertTrue(new MarketAccountOrderCapsule(mock(ByteString.class)).getOrdersList().isEmpty());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#addOrders(ByteString)}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#addOrders(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.addOrders(ByteString)"})
  public void testAddOrders() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule =
        new MarketAccountOrderCapsule(mock(ByteString.class));
    ByteString order = mock(ByteString.class);

    // Act
    marketAccountOrderCapsule.addOrders(order);

    // Assert
    List<ByteString> ordersList = marketAccountOrderCapsule.getOrdersList();
    assertEquals(1, ordersList.size());
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getOrdersCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    assertTrue(instance.getDefaultInstanceForType().getOrdersList().isEmpty());
    assertSame(order, ordersList.get(0));
    assertArrayEquals(new byte[] {'\n', 0, 18, 0}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#removeOrder(ByteString)}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#removeOrder(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.removeOrder(ByteString)"})
  public void testRemoveOrder() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule =
        new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.removeOrder(mock(ByteString.class));

    // Assert
    assertEquals(-1L, marketAccountOrderCapsule.getCount());
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(-1L, instance.getCount());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertTrue(instance.getDefaultInstanceForType().getOrdersList().isEmpty());
    assertArrayEquals(
        new byte[] {'\n', 0, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setCount(long)}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#setCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setCount(long)"})
  public void testSetCount() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule =
        new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.setCount(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\n', 0, 24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getCount()}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#getCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketAccountOrderCapsule.getCount()"})
  public void testGetCount() {
    // Arrange, Act and Assert
    assertEquals(0L, new MarketAccountOrderCapsule(mock(ByteString.class)).getCount());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setOwnerAddress(long)}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#setOwnerAddress(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setOwnerAddress(long)"})
  public void testSetOwnerAddress() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule =
        new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\n', 0, 24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setTotalCount(long)}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#setTotalCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setTotalCount(long)"})
  public void testSetTotalCount() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule =
        new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.setTotalCount(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, marketAccountOrderCapsule.getTotalCount());
    assertEquals(3L, instance.getTotalCount());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\n', 0, ' ', 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getTotalCount()}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#getTotalCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketAccountOrderCapsule.getTotalCount()"})
  public void testGetTotalCount() {
    // Arrange, Act and Assert
    assertEquals(0L, new MarketAccountOrderCapsule(mock(ByteString.class)).getTotalCount());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.getData()"})
  public void testGetData() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(address);
    marketAccountOrderCapsule.setCount(Long.MAX_VALUE);

    // Act
    byte[] actualData = marketAccountOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#size()} return zero.
   *   <li>Then return array of {@code byte} with lf and zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.getData()"})
  public void testGetData_givenByteStringSizeReturnZero_thenReturnArrayOfByteWithLfAndZero() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.size()).thenReturn(0);
    when(address.isEmpty()).thenReturn(false);

    // Act
    byte[] actualData = new MarketAccountOrderCapsule(address).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(address, atLeast(1)).size();
    assertArrayEquals(new byte[] {'\n', 0}, actualData);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString)} with
   *       address is {@link ByteString} Count is minus one.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.getData()"})
  public void testGetData_givenMarketAccountOrderCapsuleWithAddressIsByteStringCountIsMinusOne() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(address);
    marketAccountOrderCapsule.setCount(-1L);

    // Act
    byte[] actualData = marketAccountOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])} with data is
   *       empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.getData()"})
  public void testGetData_givenMarketAccountOrderCapsuleWithDataIsEmptyArrayOfByte() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule =
        new MarketAccountOrderCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with space and three.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithSpaceAndThree() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(address);
    marketAccountOrderCapsule.setTotalCount(3L);

    // Act
    byte[] actualData = marketAccountOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {' ', 3}, actualData);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and three.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndThree() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(address);
    marketAccountOrderCapsule.setCount(3L);

    // Act
    byte[] actualData = marketAccountOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {24, 3}, actualData);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = new MarketAccountOrderCapsule(address).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {}, actualData);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getInstance()}.
   *
   * <p>Method under test: {@link MarketAccountOrderCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MarketAccountOrder MarketAccountOrderCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    MarketAccountOrder actualInstance =
        new MarketAccountOrderCapsule(mock(ByteString.class)).getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getOrdersCount());
    assertEquals(0L, actualInstance.getCount());
    assertEquals(0L, actualInstance.getTotalCount());
    assertEquals(1, actualInstance.getAllFields().size());
    assertEquals(2, actualInstance.getSerializedSize());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.getOrdersList().isEmpty());
    assertTrue(actualInstance.isInitialized());
  }
}
