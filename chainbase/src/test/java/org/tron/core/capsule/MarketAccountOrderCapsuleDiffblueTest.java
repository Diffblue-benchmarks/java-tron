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
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(ByteString)"})
  public void testNewMarketAccountOrderCapsule() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule = new MarketAccountOrderCapsule(address);

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
    assertArrayEquals(new byte[]{'\n', 0}, actualMarketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule2() {
    // Arrange and Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule = new MarketAccountOrderCapsule(new byte[]{});

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
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertSame(ordersList, instance.getOrdersList());
    assertSame(ownerAddress, instance.getOwnerAddress());
    assertArrayEquals(new byte[]{}, actualMarketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString, List, long)}.
   * <ul>
   *   <li>Given {@link ByteString}.</li>
   *   <li>Then return OrdersList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString, List, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(ByteString, List, long)"})
  public void testNewMarketAccountOrderCapsule_givenByteString_thenReturnOrdersListSizeIsOne() {
    // Arrange
    ByteString address = mock(ByteString.class);

    ArrayList<ByteString> orders = new ArrayList<>();
    orders.add(mock(ByteString.class));

    // Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule = new MarketAccountOrderCapsule(address, orders, 3L);

    // Assert
    assertEquals(1, actualMarketAccountOrderCapsule.getOrdersList().size());
    MarketAccountOrder instance = actualMarketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getOrdersCount());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 24, 3}, actualMarketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString, List, long)}.
   * <ul>
   *   <li>Then return Instance OrdersCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString, List, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(ByteString, List, long)"})
  public void testNewMarketAccountOrderCapsule_thenReturnInstanceOrdersCountIsZero() {
    // Arrange
    ByteString address = mock(ByteString.class);
    ArrayList<ByteString> orders = new ArrayList<>();

    // Act
    MarketAccountOrderCapsule actualMarketAccountOrderCapsule = new MarketAccountOrderCapsule(address, orders, 3L);

    // Assert
    MarketAccountOrder instance = actualMarketAccountOrderCapsule.getInstance();
    assertEquals(0, instance.getOrdersCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(actualMarketAccountOrderCapsule.getOrdersList().isEmpty());
    assertEquals(orders, instance.getDescriptorForType().toProto().getReservedNameList());
    assertArrayEquals(new byte[]{'\n', 0, 24, 3}, actualMarketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithLfAndZero() {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithTwentyFourAndX() {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenArrayOfByteWithZeroAndX() {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(" XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.<init>(byte[])"})
  public void testNewMarketAccountOrderCapsule_whenXxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getOwnerAddress()}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#getOwnerAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString MarketAccountOrderCapsule.getOwnerAddress()"})
  public void testGetOwnerAddress() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    ByteString actualOwnerAddress = marketAccountOrderCapsule.getOwnerAddress();

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualOwnerAddress.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getOwnerAddress());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#createDbKey()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = (new MarketAccountOrderCapsule(address)).createDbKey();

    // Assert
    verify(address).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#createDbKey()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new MarketAccountOrderCapsule(new byte[]{})).createDbKey());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getOrdersList()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#getOrdersList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MarketAccountOrderCapsule.getOrdersList()"})
  public void testGetOrdersList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new MarketAccountOrderCapsule(mock(ByteString.class))).getOrdersList().isEmpty());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#addOrders(ByteString)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#addOrders(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.addOrders(ByteString)"})
  public void testAddOrders() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.addOrders(mock(ByteString.class));

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#addOrders(ByteString)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#addOrders(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.addOrders(ByteString)"})
  public void testAddOrders2() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setTotalCount(3L);

    // Act
    marketAccountOrderCapsule.addOrders(mock(ByteString.class));

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, ' ', 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#addOrders(ByteString)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#addOrders(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.addOrders(ByteString)"})
  public void testAddOrders3() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(new byte[]{});

    // Act
    marketAccountOrderCapsule.addOrders(mock(ByteString.class));

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{18, 0}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#addOrders(ByteString)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#addOrders(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.addOrders(ByteString)"})
  public void testAddOrders4() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    marketAccountOrderCapsule.addOrders(mock(ByteString.class));

    // Assert
    assertEquals(18, marketAccountOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals(
        new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#addOrders(ByteString)}.
   * <ul>
   *   <li>Given {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString)} with address is {@link ByteString} Count is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#addOrders(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.addOrders(ByteString)"})
  public void testAddOrders_givenMarketAccountOrderCapsuleWithAddressIsByteStringCountIsThree() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setCount(3L);

    // Act
    marketAccountOrderCapsule.addOrders(mock(ByteString.class));

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#removeOrder(ByteString)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#removeOrder(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.removeOrder(ByteString)"})
  public void testRemoveOrder() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.removeOrder(mock(ByteString.class));

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#removeOrder(ByteString)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#removeOrder(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.removeOrder(ByteString)"})
  public void testRemoveOrder2() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setTotalCount(3L);

    // Act
    marketAccountOrderCapsule.removeOrder(mock(ByteString.class));

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(15, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, ' ', 3},
        marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#removeOrder(ByteString)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#removeOrder(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.removeOrder(ByteString)"})
  public void testRemoveOrder3() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(new byte[]{});

    // Act
    marketAccountOrderCapsule.removeOrder(mock(ByteString.class));

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(11, instance.getSerializedSize());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#removeOrder(ByteString)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#removeOrder(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.removeOrder(ByteString)"})
  public void testRemoveOrder4() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    marketAccountOrderCapsule.removeOrder(mock(ByteString.class));

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(27, instance.getSerializedSize());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#removeOrder(ByteString)}.
   * <ul>
   *   <li>Then {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString)} with address is {@link ByteString} Count is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#removeOrder(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.removeOrder(ByteString)"})
  public void testRemoveOrder_thenMarketAccountOrderCapsuleWithAddressIsByteStringCountIsTwo() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setCount(3L);

    // Act
    marketAccountOrderCapsule.removeOrder(mock(ByteString.class));

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(2L, marketAccountOrderCapsule.getCount());
    assertEquals(2L, instance.getCount());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 24, 2}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setCount(long)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setCount(long)"})
  public void testSetCount() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Act
    marketAccountOrderCapsule.setCount(3L);

    // Assert that nothing has changed
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setCount(long)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setCount(long)"})
  public void testSetCount2() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setTotalCount(3L);

    // Act
    marketAccountOrderCapsule.setCount(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 24, 3, ' ', 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setCount(long)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setCount(long)"})
  public void testSetCount3() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(new byte[]{});

    // Act
    marketAccountOrderCapsule.setCount(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setCount(long)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setCount(long)"})
  public void testSetCount4() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    marketAccountOrderCapsule.setCount(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{24, 3, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setCount(long)}.
   * <ul>
   *   <li>Given {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString)} with address is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setCount(long)"})
  public void testSetCount_givenMarketAccountOrderCapsuleWithAddressIsByteString() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.setCount(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getCount()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#getCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketAccountOrderCapsule.getCount()"})
  public void testGetCount_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketAccountOrderCapsule(mock(ByteString.class))).getCount());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setOwnerAddress(long)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setOwnerAddress(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setOwnerAddress(long)"})
  public void testSetOwnerAddress() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setCount(3L);

    // Act
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Assert that nothing has changed
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setOwnerAddress(long)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setOwnerAddress(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setOwnerAddress(long)"})
  public void testSetOwnerAddress2() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setTotalCount(3L);

    // Act
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 24, 3, ' ', 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setOwnerAddress(long)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setOwnerAddress(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setOwnerAddress(long)"})
  public void testSetOwnerAddress3() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(new byte[]{});

    // Act
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setOwnerAddress(long)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setOwnerAddress(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setOwnerAddress(long)"})
  public void testSetOwnerAddress4() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{24, 3, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setOwnerAddress(long)}.
   * <ul>
   *   <li>Given {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString)} with address is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setOwnerAddress(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setOwnerAddress(long)"})
  public void testSetOwnerAddress_givenMarketAccountOrderCapsuleWithAddressIsByteString() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setTotalCount(long)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setTotalCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setTotalCount(long)"})
  public void testSetTotalCount() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.setTotalCount(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, ' ', 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setTotalCount(long)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setTotalCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setTotalCount(long)"})
  public void testSetTotalCount2() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setCount(3L);

    // Act
    marketAccountOrderCapsule.setTotalCount(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 24, 3, ' ', 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setTotalCount(long)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setTotalCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setTotalCount(long)"})
  public void testSetTotalCount3() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(new byte[]{});

    // Act
    marketAccountOrderCapsule.setTotalCount(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{' ', 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#setTotalCount(long)}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#setTotalCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketAccountOrderCapsule.setTotalCount(long)"})
  public void testSetTotalCount4() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    marketAccountOrderCapsule.setTotalCount(3L);

    // Assert
    MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{' ', 3, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        marketAccountOrderCapsule.getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getTotalCount()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#getTotalCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketAccountOrderCapsule.getTotalCount()"})
  public void testGetTotalCount_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketAccountOrderCapsule(mock(ByteString.class))).getTotalCount());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
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
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   * <ul>
   *   <li>Given {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString)} with address is {@link ByteString} Count is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
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
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   * <ul>
   *   <li>Given {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])} with data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.getData()"})
  public void testGetData_givenMarketAccountOrderCapsuleWithDataIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new MarketAccountOrderCapsule(new byte[]{})).getData());
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with space and three.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
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
    assertArrayEquals(new byte[]{' ', 3}, actualData);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and three.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
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
    assertArrayEquals(new byte[]{24, 3}, actualData);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketAccountOrderCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new MarketAccountOrderCapsule(address)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link MarketAccountOrderCapsule#getInstance()}.
   * <p>
   * Method under test: {@link MarketAccountOrderCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MarketAccountOrder MarketAccountOrderCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    MarketAccountOrder actualInstance = (new MarketAccountOrderCapsule(mock(ByteString.class))).getInstance();

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
