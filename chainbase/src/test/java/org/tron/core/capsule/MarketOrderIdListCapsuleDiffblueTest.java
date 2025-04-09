package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.db.TronStoreWithRevoking;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.MarketOrderStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.MarketOrderIdList;

public class MarketOrderIdListCapsuleDiffblueTest {
  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>()"})
  public void testNewMarketOrderIdListCapsule() {
    // Arrange and Act
    MarketOrderIdListCapsule actualMarketOrderIdListCapsule = new MarketOrderIdListCapsule();

    // Assert
    MarketOrderIdList instance = actualMarketOrderIdListCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(actualMarketOrderIdListCapsule.isOrderEmpty());
    assertTrue(instance.isInitialized());
    assertEquals(instance, instance.getDefaultInstanceForType());
    byte[] head = actualMarketOrderIdListCapsule.getHead();
    assertSame(head, actualMarketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{}, actualMarketOrderIdListCapsule.getData());
    assertArrayEquals(new byte[]{}, head);
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule2() {
    // Arrange and Act
    MarketOrderIdListCapsule actualMarketOrderIdListCapsule = new MarketOrderIdListCapsule(new byte[]{});

    // Assert
    MarketOrderIdList instance = actualMarketOrderIdListCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(actualMarketOrderIdListCapsule.isOrderEmpty());
    assertTrue(instance.isInitialized());
    assertEquals(instance, instance.getDefaultInstanceForType());
    byte[] head = actualMarketOrderIdListCapsule.getHead();
    assertSame(head, actualMarketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{}, actualMarketOrderIdListCapsule.getData());
    assertArrayEquals(new byte[]{}, head);
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[], byte[])}.
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[], byte[])"})
  public void testNewMarketOrderIdListCapsule3() throws UnsupportedEncodingException {
    // Arrange
    byte[] head = "AXAXAXAX".getBytes("UTF-8");

    // Act
    MarketOrderIdListCapsule actualMarketOrderIdListCapsule = new MarketOrderIdListCapsule(head,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrderIdList instance = actualMarketOrderIdListCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertFalse(actualMarketOrderIdListCapsule.isOrderEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.isInitialized());
    byte[] expectedHead = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedHead, actualMarketOrderIdListCapsule.getHead());
    byte[] expectedTail = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTail, actualMarketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, '\b', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X'}, actualMarketOrderIdListCapsule.getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenArrayOfByteWithLfAndZero() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenArrayOfByteWithZeroAndX() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#isOrderExists(byte[], MarketOrderStore)}.
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#isOrderExists(byte[], MarketOrderStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketOrderIdListCapsule.isOrderExists(byte[], MarketOrderStore)"})
  public void testIsOrderExists_givenMarketOrderIdListCapsule_thenReturnFalse()
      throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();

    // Act and Assert
    assertFalse(marketOrderIdListCapsule.isOrderExists("AXAXAXAX".getBytes("UTF-8"), null));
  }

  /**
   * Test {@link MarketOrderIdListCapsule#isOrderExists(byte[], MarketOrderStore)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#isOrderExists(byte[], MarketOrderStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketOrderIdListCapsule.isOrderExists(byte[], MarketOrderStore)"})
  public void testIsOrderExists_whenEmptyArrayOfByte_thenReturnFalse() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertFalse((new MarketOrderIdListCapsule()).isOrderExists(new byte[]{}, null));
  }

  /**
   * Test {@link MarketOrderIdListCapsule#setHead(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#setHead(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.setHead(byte[])"})
  public void testSetHead() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule(new byte[]{});

    // Act
    marketOrderIdListCapsule.setHead("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString tail = instance.getTail();
    assertEquals("", tail.toStringUtf8());
    assertFalse(tail.iterator().hasNext());
    assertTrue(tail.isEmpty());
    MarketOrderIdList defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(tail, defaultInstanceForType.getHead());
    assertSame(tail, defaultInstanceForType.getTail());
    byte[] expectedHead = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedHead, marketOrderIdListCapsule.getHead());
    byte[] expectedData = "\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderIdListCapsule.getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#setHead(byte[])}.
   * <ul>
   *   <li>Then {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()} Instance Tail toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#setHead(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.setHead(byte[])"})
  public void testSetHead_thenMarketOrderIdListCapsuleInstanceTailToStringUtf8IsEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();

    // Act
    marketOrderIdListCapsule.setHead("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString tail = instance.getTail();
    assertEquals("", tail.toStringUtf8());
    assertFalse(tail.iterator().hasNext());
    assertTrue(tail.isEmpty());
    MarketOrderIdList defaultInstanceForType = instance.getDefaultInstanceForType();
    ByteString head = defaultInstanceForType.getHead();
    assertEquals(tail, head);
    assertSame(head, defaultInstanceForType.getTail());
    byte[] expectedHead = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedHead, marketOrderIdListCapsule.getHead());
    byte[] expectedData = "\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderIdListCapsule.getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getHead()}.
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getHead()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getHead()"})
  public void testGetHead_givenMarketOrderIdListCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new MarketOrderIdListCapsule()).getHead());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getHead()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getHead()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getHead()"})
  public void testGetHead_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualHead = marketOrderIdListCapsule.getHead();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualHead);
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getTail()}.
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getTail()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getTail()"})
  public void testGetTail_givenMarketOrderIdListCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new MarketOrderIdListCapsule()).getTail());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getTail()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getTail()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getTail()"})
  public void testGetTail_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setTail("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualTail = marketOrderIdListCapsule.getTail();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualTail);
  }

  /**
   * Test {@link MarketOrderIdListCapsule#setTail(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#setTail(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.setTail(byte[])"})
  public void testSetTail() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule(new byte[]{});

    // Act
    marketOrderIdListCapsule.setTail("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(2, marketOrderIdListCapsule.getInstance().getDescriptorForType().getFields().size());
    byte[] expectedTail = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTail, marketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, marketOrderIdListCapsule.getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#setTail(byte[])}.
   * <ul>
   *   <li>Then {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()} Instance DescriptorForType Fields size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#setTail(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.setTail(byte[])"})
  public void testSetTail_thenMarketOrderIdListCapsuleInstanceDescriptorForTypeFieldsSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();

    // Act
    marketOrderIdListCapsule.setTail("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(2, marketOrderIdListCapsule.getInstance().getDescriptorForType().getFields().size());
    byte[] expectedTail = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTail, marketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, marketOrderIdListCapsule.getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#isOrderEmpty()}.
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#isOrderEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketOrderIdListCapsule.isOrderEmpty()"})
  public void testIsOrderEmpty_givenMarketOrderIdListCapsule_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new MarketOrderIdListCapsule()).isOrderEmpty());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#isOrderEmpty()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#isOrderEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketOrderIdListCapsule.isOrderEmpty()"})
  public void testIsOrderEmpty_thenReturnFalse() {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertFalse(marketOrderIdListCapsule.isOrderEmpty());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#addOrder(MarketOrderCapsule, MarketOrderStore)}.
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#addOrder(MarketOrderCapsule, MarketOrderStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.addOrder(MarketOrderCapsule, MarketOrderStore)"})
  public void testAddOrder() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule currentCapsule = mock(MarketOrderCapsule.class);
    when(currentCapsule.getID()).thenReturn(byteString);

    // Act
    marketOrderIdListCapsule.addOrder(currentCapsule, null);

    // Assert
    verify(byteString).toByteArray();
    verify(currentCapsule).getID();
    MarketOrderIdList defaultInstanceForType = marketOrderIdListCapsule.getInstance().getDefaultInstanceForType();
    ByteString head = defaultInstanceForType.getHead();
    assertEquals("", head.toStringUtf8());
    assertFalse(head.iterator().hasNext());
    assertTrue(head.isEmpty());
    assertSame(head, defaultInstanceForType.getTail());
    byte[] expectedHead = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedHead, marketOrderIdListCapsule.getHead());
    byte[] expectedTail = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTail, marketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, '\b', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X'}, marketOrderIdListCapsule.getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#addOrder(MarketOrderCapsule, MarketOrderStore)}.
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#addOrder(MarketOrderCapsule, MarketOrderStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderIdListCapsule.addOrder(MarketOrderCapsule, MarketOrderStore)"})
  public void testAddOrder2() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule(new byte[]{});
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule currentCapsule = mock(MarketOrderCapsule.class);
    when(currentCapsule.getID()).thenReturn(byteString);

    // Act
    marketOrderIdListCapsule.addOrder(currentCapsule, null);

    // Assert
    verify(byteString).toByteArray();
    verify(currentCapsule).getID();
    MarketOrderIdList defaultInstanceForType = marketOrderIdListCapsule.getInstance().getDefaultInstanceForType();
    ByteString head = defaultInstanceForType.getHead();
    assertEquals("", head.toStringUtf8());
    assertFalse(head.iterator().hasNext());
    assertTrue(head.isEmpty());
    assertSame(head, defaultInstanceForType.getTail());
    byte[] expectedHead = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedHead, marketOrderIdListCapsule.getHead());
    byte[] expectedTail = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTail, marketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, '\b', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X'}, marketOrderIdListCapsule.getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getHeadOrder(MarketOrderStore)}.
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getHeadOrder(MarketOrderStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MarketOrderCapsule MarketOrderIdListCapsule.getHeadOrder(MarketOrderStore)"})
  public void testGetHeadOrder_givenMarketOrderIdListCapsule_whenNull_thenReturnNull() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule()).getHeadOrder(null));
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getHeadOrder(MarketOrderStore)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link MarketOrderStore} {@link MarketOrderStore#get(byte[])} return {@code null}.</li>
   *   <li>Then calls {@link MarketOrderStore#get(byte[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getHeadOrder(MarketOrderStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MarketOrderCapsule MarketOrderIdListCapsule.getHeadOrder(MarketOrderStore)"})
  public void testGetHeadOrder_givenNull_whenMarketOrderStoreGetReturnNull_thenCallsGet() throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    MarketOrderStore marketOrderStore = mock(MarketOrderStore.class);
    when(marketOrderStore.get(Mockito.<byte[]>any())).thenReturn(null);

    // Act
    MarketOrderCapsule actualHeadOrder = marketOrderIdListCapsule.getHeadOrder(marketOrderStore);

    // Assert
    verify(marketOrderStore).get(isA(byte[].class));
    assertNull(actualHeadOrder);
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getOrderByIndex(int, MarketOrderStore)}.
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getOrderByIndex(int, MarketOrderStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MarketOrderCapsule MarketOrderIdListCapsule.getOrderByIndex(int, MarketOrderStore)"})
  public void testGetOrderByIndex_givenMarketOrderIdListCapsule_thenReturnNull() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule()).getOrderByIndex(1, null));
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getOrderSize(MarketOrderStore)}.
   * <ul>
   *   <li>Given {@link MarketOrderCapsule} {@link MarketOrderCapsule#isNextNull()} return {@code true}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getOrderSize(MarketOrderStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketOrderIdListCapsule.getOrderSize(MarketOrderStore)"})
  public void testGetOrderSize_givenMarketOrderCapsuleIsNextNullReturnTrue_thenReturnOne()
      throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    MarketOrderCapsule marketOrderCapsule = mock(MarketOrderCapsule.class);
    when(marketOrderCapsule.isNextNull()).thenReturn(true);
    MarketOrderStore marketOrderStore = mock(MarketOrderStore.class);
    when(marketOrderStore.get(Mockito.<byte[]>any())).thenReturn(marketOrderCapsule);

    // Act
    int actualOrderSize = marketOrderIdListCapsule.getOrderSize(marketOrderStore);

    // Assert
    verify(marketOrderCapsule).isNextNull();
    verify(marketOrderStore).get(isA(byte[].class));
    assertEquals(1, actualOrderSize);
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getOrderSize(MarketOrderStore)}.
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getOrderSize(MarketOrderStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketOrderIdListCapsule.getOrderSize(MarketOrderStore)"})
  public void testGetOrderSize_givenMarketOrderIdListCapsule_whenNull_thenReturnZero() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertEquals(0, (new MarketOrderIdListCapsule()).getOrderSize(null));
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getData()}.
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getData()"})
  public void testGetData_givenMarketOrderIdListCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new MarketOrderIdListCapsule()).getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getData()}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getData()"})
  public void testGetData_givenX_thenReturnArrayOfByteWithAAndX() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        (new MarketOrderIdListCapsule(
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}))
                .getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getData()}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getData()"})
  public void testGetData_givenX_thenReturnArrayOfByteWithAAndX2() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'},
        (new MarketOrderIdListCapsule(
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'})).getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with eighteen and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithEighteenAndBackspace() {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setTail(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertArrayEquals(new byte[]{18, '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, marketOrderIdListCapsule.getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with lf and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithLfAndBackspace() {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, marketOrderIdListCapsule.getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getData()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAXAAAXAXAXAXXAXAXA} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getData()"})
  public void testGetData_thenReturnAxaxaxaxaaaxaxaxaxxaxaxaBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualData = (new MarketOrderIdListCapsule("AXAXAXAXAXAXAXAAAXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    assertArrayEquals("AXAXAXAXAAAXAXAXAXXAXAXA".getBytes("UTF-8"), actualData);
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getInstance()}.
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MarketOrderIdList MarketOrderIdListCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    MarketOrderIdList actualInstance = (new MarketOrderIdListCapsule()).getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getSerializedSize());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.isInitialized());
    assertEquals(actualInstance, actualInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}.
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MarketOrderIdListCapsule.getAllOrder(MarketOrderStore, long)"})
  public void testGetAllOrder_givenMarketOrderIdListCapsule_whenNull_thenReturnEmpty() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertTrue((new MarketOrderIdListCapsule()).getAllOrder(null, 1L).isEmpty());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link MarketOrderStore} {@link TronStoreWithRevoking#getUnchecked(byte[])} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MarketOrderIdListCapsule.getAllOrder(MarketOrderStore, long)"})
  public void testGetAllOrder_givenNull_whenMarketOrderStoreGetUncheckedReturnNull() throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    MarketOrderStore orderStore = mock(MarketOrderStore.class);
    when(orderStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(null);

    // Act
    List<MarketOrderCapsule> actualAllOrder = marketOrderIdListCapsule.getAllOrder(orderStore, 1L);

    // Assert
    verify(orderStore).getUnchecked(isA(byte[].class));
    assertTrue(actualAllOrder.isEmpty());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MarketOrderIdListCapsule.getAllOrder(MarketOrderStore, long)"})
  public void testGetAllOrder_thenReturnSizeIsOne() throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    MarketOrderCapsule marketOrderCapsule = mock(MarketOrderCapsule.class);
    when(marketOrderCapsule.getNextCapsule(Mockito.<MarketOrderStore>any())).thenReturn(null);
    MarketOrderStore orderStore = mock(MarketOrderStore.class);
    when(orderStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(marketOrderCapsule);

    // Act
    List<MarketOrderCapsule> actualAllOrder = marketOrderIdListCapsule.getAllOrder(orderStore, 1L);

    // Assert
    verify(marketOrderCapsule).getNextCapsule(isA(MarketOrderStore.class));
    verify(orderStore).getUnchecked(isA(byte[].class));
    assertEquals(1, actualAllOrder.size());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MarketOrderIdListCapsule.getAllOrder(MarketOrderStore, long)"})
  public void testGetAllOrder_thenReturnSizeIsTwo() throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    MarketOrderCapsule marketOrderCapsule = mock(MarketOrderCapsule.class);
    when(marketOrderCapsule.getNextCapsule(Mockito.<MarketOrderStore>any())).thenReturn(null);
    MarketOrderCapsule marketOrderCapsule2 = mock(MarketOrderCapsule.class);
    when(marketOrderCapsule2.getNextCapsule(Mockito.<MarketOrderStore>any())).thenReturn(marketOrderCapsule);
    MarketOrderStore orderStore = mock(MarketOrderStore.class);
    when(orderStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(marketOrderCapsule2);

    // Act
    List<MarketOrderCapsule> actualAllOrder = marketOrderIdListCapsule.getAllOrder(orderStore, 1L);

    // Assert
    verify(marketOrderCapsule2).getNextCapsule(isA(MarketOrderStore.class));
    verify(marketOrderCapsule).getNextCapsule(isA(MarketOrderStore.class));
    verify(orderStore).getUnchecked(isA(byte[].class));
    assertEquals(2, actualAllOrder.size());
  }
}
