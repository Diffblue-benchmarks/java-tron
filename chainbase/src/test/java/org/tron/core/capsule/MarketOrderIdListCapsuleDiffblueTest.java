package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.MarketOrderStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.MarketOrderIdList;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MarketOrderIdListCapsuleDiffblueTest {
  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    MarketOrderIdList actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    byte[] head = actualMarketOrderIdListCapsule.getHead();
    assertSame(head, actualMarketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[] {}, actualMarketOrderIdListCapsule.getData());
    assertArrayEquals(new byte[] {}, head);
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule2() {
    // Arrange and Act
    MarketOrderIdListCapsule actualMarketOrderIdListCapsule =
        new MarketOrderIdListCapsule(new byte[] {});

    // Assert
    MarketOrderIdList instance = actualMarketOrderIdListCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(actualMarketOrderIdListCapsule.isOrderEmpty());
    assertTrue(instance.isInitialized());
    MarketOrderIdList actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    byte[] head = actualMarketOrderIdListCapsule.getHead();
    assertSame(head, actualMarketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[] {}, actualMarketOrderIdListCapsule.getData());
    assertArrayEquals(new byte[] {}, head);
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[], byte[])}.
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[], byte[])"})
  public void testNewMarketOrderIdListCapsule3() throws UnsupportedEncodingException {
    // Arrange and Act
    MarketOrderIdListCapsule actualMarketOrderIdListCapsule =
        new MarketOrderIdListCapsule("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrderIdList instance = actualMarketOrderIdListCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertFalse(actualMarketOrderIdListCapsule.isOrderEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.isInitialized());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualMarketOrderIdListCapsule.getHead());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualMarketOrderIdListCapsule.getTail());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, '\b', 'A', 'X', 'A', 'X', 'A',
          'X', 'A', 'X'
        },
        actualMarketOrderIdListCapsule.getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenAAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new MarketOrderIdListCapsule("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new MarketOrderIdListCapsule("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and lf.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenArrayOfByteWithAAndLf() {
    // Arrange and Act
    MarketOrderIdListCapsule actualMarketOrderIdListCapsule =
        new MarketOrderIdListCapsule(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 0, '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualMarketOrderIdListCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and lf.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenArrayOfByteWithEighteenAndLf() {
    // Arrange and Act
    MarketOrderIdListCapsule actualMarketOrderIdListCapsule =
        new MarketOrderIdListCapsule(
            new byte[] {
              18, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualMarketOrderIdListCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange and Act
    MarketOrderIdListCapsule actualMarketOrderIdListCapsule =
        new MarketOrderIdListCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderIdListCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    MarketOrderIdListCapsule actualMarketOrderIdListCapsule =
        new MarketOrderIdListCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderIdListCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    MarketOrderIdListCapsule actualMarketOrderIdListCapsule =
        new MarketOrderIdListCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderIdListCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenArrayOfByteWithZeroAndX() {
    // Arrange and Act
    MarketOrderIdListCapsule actualMarketOrderIdListCapsule =
        new MarketOrderIdListCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderIdListCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketOrderIdListCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.<init>(byte[])"})
  public void testNewMarketOrderIdListCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketOrderIdListCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#isOrderExists(byte[], MarketOrderStore)}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#isOrderExists(byte[], MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketOrderIdListCapsule.isOrderExists(byte[], MarketOrderStore)"})
  public void testIsOrderExists_givenMarketOrderIdListCapsule_thenReturnFalse()
      throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange, Act and Assert
    assertFalse(new MarketOrderIdListCapsule().isOrderExists("AXAXAXAX".getBytes("UTF-8"), null));
  }

  /**
   * Test {@link MarketOrderIdListCapsule#isOrderExists(byte[], MarketOrderStore)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#isOrderExists(byte[], MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketOrderIdListCapsule.isOrderExists(byte[], MarketOrderStore)"})
  public void testIsOrderExists_thenReturnTrue()
      throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(
        marketOrderIdListCapsule.isOrderExists("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"), null));
  }

  /**
   * Test {@link MarketOrderIdListCapsule#isOrderExists(byte[], MarketOrderStore)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#isOrderExists(byte[], MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketOrderIdListCapsule.isOrderExists(byte[], MarketOrderStore)"})
  public void testIsOrderExists_whenEmptyArrayOfByte_thenReturnFalse()
      throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(marketOrderIdListCapsule.isOrderExists(new byte[] {}, null));
  }

  /**
   * Test {@link MarketOrderIdListCapsule#setHead(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#setHead(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.setHead(byte[])"})
  public void testSetHead() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();

    // Act
    marketOrderIdListCapsule.setHead("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString head = instance.getHead();
    assertEquals("AXAXAXAX", head.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertFalse(head.isEmpty());
    assertFalse(marketOrderIdListCapsule.isOrderEmpty());
    assertTrue(head.iterator().hasNext());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderIdListCapsule.getHead());
    assertArrayEquals("\n\bAXAXAXAX".getBytes("UTF-8"), marketOrderIdListCapsule.getData());
    assertArrayEquals(new byte[] {}, marketOrderIdListCapsule.getTail());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getHead()}.
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getHead()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getHead()"})
  public void testGetHead() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new MarketOrderIdListCapsule().getHead());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getTail()}.
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getTail()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getTail()"})
  public void testGetTail() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new MarketOrderIdListCapsule().getTail());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#setTail(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#setTail(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderIdListCapsule.setTail(byte[])"})
  public void testSetTail() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();

    // Act
    marketOrderIdListCapsule.setTail("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString tail = instance.getTail();
    assertEquals("AXAXAXAX", tail.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertFalse(tail.isEmpty());
    ByteIterator iteratorResult = tail.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderIdListCapsule.getTail());
    assertArrayEquals(
        new byte[] {18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderIdListCapsule.getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#isOrderEmpty()}.
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#isOrderEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketOrderIdListCapsule.isOrderEmpty()"})
  public void testIsOrderEmpty() {
    // Arrange, Act and Assert
    assertTrue(new MarketOrderIdListCapsule().isOrderEmpty());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#addOrder(MarketOrderCapsule, MarketOrderStore)}.
   *
   * <ul>
   *   <li>Then {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()} Instance Head
   *       toStringUtf8 is {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#addOrder(MarketOrderCapsule,
   * MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MarketOrderIdListCapsule.addOrder(MarketOrderCapsule, MarketOrderStore)"
  })
  public void testAddOrder_thenMarketOrderIdListCapsuleInstanceHeadToStringUtf8IsAxaxaxax()
      throws UnsupportedEncodingException, ItemNotFoundException {
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
    MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString head = instance.getHead();
    assertEquals("AXAXAXAX", head.toStringUtf8());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertFalse(head.isEmpty());
    assertFalse(marketOrderIdListCapsule.isOrderEmpty());
    ByteIterator iteratorResult = head.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderIdListCapsule.getHead());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderIdListCapsule.getTail());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, '\b', 'A', 'X', 'A', 'X', 'A',
          'X', 'A', 'X'
        },
        marketOrderIdListCapsule.getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getHeadOrder(MarketOrderStore)}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getHeadOrder(MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MarketOrderCapsule MarketOrderIdListCapsule.getHeadOrder(MarketOrderStore)"})
  public void testGetHeadOrder_givenMarketOrderIdListCapsule_whenNull_thenReturnNull()
      throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertNull(new MarketOrderIdListCapsule().getHeadOrder(null));
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getHeadOrder(MarketOrderStore)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MarketOrderStore} {@link MarketOrderStore#get(byte[])} return {@code null}.
   *   <li>Then calls {@link MarketOrderStore#get(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getHeadOrder(MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MarketOrderCapsule MarketOrderIdListCapsule.getHeadOrder(MarketOrderStore)"})
  public void testGetHeadOrder_givenNull_whenMarketOrderStoreGetReturnNull_thenCallsGet()
      throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

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
   *
   * <ul>
   *   <li>Given {@link MarketOrderCapsule} {@link MarketOrderCapsule#isNextNull()} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getOrderByIndex(int, MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MarketOrderCapsule MarketOrderIdListCapsule.getOrderByIndex(int, MarketOrderStore)"
  })
  public void testGetOrderByIndex_givenMarketOrderCapsuleIsNextNullReturnTrue()
      throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    MarketOrderCapsule marketOrderCapsule = mock(MarketOrderCapsule.class);
    when(marketOrderCapsule.isNextNull()).thenReturn(true);

    MarketOrderStore marketOrderStore = mock(MarketOrderStore.class);
    when(marketOrderStore.get(Mockito.<byte[]>any())).thenReturn(marketOrderCapsule);

    // Act
    MarketOrderCapsule actualOrderByIndex =
        marketOrderIdListCapsule.getOrderByIndex(1, marketOrderStore);

    // Assert
    verify(marketOrderCapsule).isNextNull();
    verify(marketOrderStore).get(isA(byte[].class));
    assertNull(actualOrderByIndex);
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getOrderByIndex(int, MarketOrderStore)}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderCapsule}.
   *   <li>When zero.
   *   <li>Then calls {@link MarketOrderStore#get(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getOrderByIndex(int, MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MarketOrderCapsule MarketOrderIdListCapsule.getOrderByIndex(int, MarketOrderStore)"
  })
  public void testGetOrderByIndex_givenMarketOrderCapsule_whenZero_thenCallsGet()
      throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    MarketOrderStore marketOrderStore = mock(MarketOrderStore.class);
    when(marketOrderStore.get(Mockito.<byte[]>any())).thenReturn(mock(MarketOrderCapsule.class));

    // Act
    marketOrderIdListCapsule.getOrderByIndex(0, marketOrderStore);

    // Assert
    verify(marketOrderStore).get(isA(byte[].class));
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getOrderByIndex(int, MarketOrderStore)}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getOrderByIndex(int, MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MarketOrderCapsule MarketOrderIdListCapsule.getOrderByIndex(int, MarketOrderStore)"
  })
  public void testGetOrderByIndex_givenMarketOrderIdListCapsule_whenNull_thenReturnNull()
      throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertNull(new MarketOrderIdListCapsule().getOrderByIndex(1, null));
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getOrderByIndex(int, MarketOrderStore)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MarketOrderStore} {@link MarketOrderStore#get(byte[])} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getOrderByIndex(int, MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MarketOrderCapsule MarketOrderIdListCapsule.getOrderByIndex(int, MarketOrderStore)"
  })
  public void testGetOrderByIndex_givenNull_whenMarketOrderStoreGetReturnNull_thenReturnNull()
      throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    MarketOrderStore marketOrderStore = mock(MarketOrderStore.class);
    when(marketOrderStore.get(Mockito.<byte[]>any())).thenReturn(null);

    // Act
    MarketOrderCapsule actualOrderByIndex =
        marketOrderIdListCapsule.getOrderByIndex(1, marketOrderStore);

    // Assert
    verify(marketOrderStore).get(isA(byte[].class));
    assertNull(actualOrderByIndex);
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getOrderByIndex(int, MarketOrderStore)}.
   *
   * <ul>
   *   <li>Then calls {@link MarketOrderCapsule#getNext()}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getOrderByIndex(int, MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MarketOrderCapsule MarketOrderIdListCapsule.getOrderByIndex(int, MarketOrderStore)"
  })
  public void testGetOrderByIndex_thenCallsGetNext()
      throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    MarketOrderCapsule marketOrderCapsule = mock(MarketOrderCapsule.class);
    when(marketOrderCapsule.isNextNull()).thenReturn(false);
    when(marketOrderCapsule.getNext()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    MarketOrderStore marketOrderStore = mock(MarketOrderStore.class);
    when(marketOrderStore.get(Mockito.<byte[]>any())).thenReturn(marketOrderCapsule);

    // Act
    marketOrderIdListCapsule.getOrderByIndex(1, marketOrderStore);

    // Assert
    verify(marketOrderCapsule).getNext();
    verify(marketOrderCapsule).isNextNull();
    verify(marketOrderStore, atLeast(1)).get(Mockito.<byte[]>any());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getOrderSize(MarketOrderStore)}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderCapsule} {@link MarketOrderCapsule#isNextNull()} return {@code
   *       true}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getOrderSize(MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MarketOrderIdListCapsule.getOrderSize(MarketOrderStore)"})
  public void testGetOrderSize_givenMarketOrderCapsuleIsNextNullReturnTrue_thenReturnOne()
      throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

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
   *
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getOrderSize(MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MarketOrderIdListCapsule.getOrderSize(MarketOrderStore)"})
  public void testGetOrderSize_givenMarketOrderIdListCapsule_whenNull_thenReturnZero()
      throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertEquals(0, new MarketOrderIdListCapsule().getOrderSize(null));
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getData()}.
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderIdListCapsule.getData()"})
  public void testGetData() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new MarketOrderIdListCapsule().getData());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getInstance()}.
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MarketOrderIdList MarketOrderIdListCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    MarketOrderIdList actualInstance = new MarketOrderIdListCapsule().getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getSerializedSize());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.isInitialized());
    MarketOrderIdList actualDefaultInstanceForType = actualInstance.getDefaultInstanceForType();
    assertEquals(actualInstance, actualDefaultInstanceForType);
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule()}.
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List MarketOrderIdListCapsule.getAllOrder(MarketOrderStore, long)"})
  public void testGetAllOrder_givenMarketOrderIdListCapsule_whenNull_thenReturnEmpty()
      throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertTrue(new MarketOrderIdListCapsule().getAllOrder(null, 1L).isEmpty());
  }

  /**
   * Test {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MarketOrderStore} {@link MarketOrderStore#getUnchecked(byte[])} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List MarketOrderIdListCapsule.getAllOrder(MarketOrderStore, long)"})
  public void testGetAllOrder_givenNull_whenMarketOrderStoreGetUncheckedReturnNull()
      throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

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
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List MarketOrderIdListCapsule.getAllOrder(MarketOrderStore, long)"})
  public void testGetAllOrder_thenReturnSizeIsOne() throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

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
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List MarketOrderIdListCapsule.getAllOrder(MarketOrderStore, long)"})
  public void testGetAllOrder_thenReturnSizeIsTwo() throws ItemNotFoundException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    MarketOrderCapsule marketOrderCapsule = mock(MarketOrderCapsule.class);
    when(marketOrderCapsule.getNextCapsule(Mockito.<MarketOrderStore>any())).thenReturn(null);

    MarketOrderCapsule marketOrderCapsule2 = mock(MarketOrderCapsule.class);
    when(marketOrderCapsule2.getNextCapsule(Mockito.<MarketOrderStore>any()))
        .thenReturn(marketOrderCapsule);

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
