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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.PedersenHash;

public class PedersenHashCapsuleDiffblueTest {
  /**
   * Test {@link PedersenHashCapsule#PedersenHashCapsule()}.
   *
   * <p>Method under test: {@link PedersenHashCapsule#PedersenHashCapsule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PedersenHashCapsule.<init>()"})
  public void testNewPedersenHashCapsule() {
    // Arrange and Act
    PedersenHashCapsule actualPedersenHashCapsule = new PedersenHashCapsule();

    // Assert
    PedersenHash instance = actualPedersenHashCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    ByteString content = actualPedersenHashCapsule.getContent();
    assertEquals("", content.toStringUtf8());
    assertEquals(0, instance.getSerializedSize());
    assertFalse(content.iterator().hasNext());
    assertFalse(actualPedersenHashCapsule.isPresent());
    assertTrue(content.isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertSame(content, instance.getContent());
    PedersenHash actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(instance, actualDefaultInstanceForType);
    assertArrayEquals(new byte[] {}, actualPedersenHashCapsule.getData());
  }

  /**
   * Test {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}.
   *
   * <p>Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PedersenHashCapsule.<init>(byte[])"})
  public void testNewPedersenHashCapsule2() {
    // Arrange and Act
    PedersenHashCapsule actualPedersenHashCapsule = new PedersenHashCapsule(new byte[] {});

    // Assert
    PedersenHash instance = actualPedersenHashCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    ByteString content = actualPedersenHashCapsule.getContent();
    assertEquals("", content.toStringUtf8());
    assertEquals(0, instance.getSerializedSize());
    assertFalse(content.iterator().hasNext());
    assertFalse(actualPedersenHashCapsule.isPresent());
    assertTrue(content.isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    PedersenHash actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertSame(content, instance.getContent());
    assertArrayEquals(new byte[] {}, actualPedersenHashCapsule.getData());
  }

  /**
   * Test {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PedersenHashCapsule.<init>(byte[])"})
  public void testNewPedersenHashCapsule_whenAAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new PedersenHashCapsule("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PedersenHashCapsule.<init>(byte[])"})
  public void testNewPedersenHashCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new PedersenHashCapsule("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PedersenHashCapsule.<init>(byte[])"})
  public void testNewPedersenHashCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    PedersenHashCapsule actualPedersenHashCapsule =
        new PedersenHashCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPedersenHashCapsule.getInstance());
  }

  /**
   * Test {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PedersenHashCapsule.<init>(byte[])"})
  public void testNewPedersenHashCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    PedersenHashCapsule actualPedersenHashCapsule =
        new PedersenHashCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPedersenHashCapsule.getInstance());
  }

  /**
   * Test {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PedersenHashCapsule.<init>(byte[])"})
  public void testNewPedersenHashCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new PedersenHashCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PedersenHashCapsule.<init>(byte[])"})
  public void testNewPedersenHashCapsule_whenLf_thenReturnInstanceIsNull() {
    // Arrange and Act
    PedersenHashCapsule actualPedersenHashCapsule =
        new PedersenHashCapsule(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 0, '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualPedersenHashCapsule.getInstance());
  }

  /**
   * Test {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PedersenHashCapsule.<init>(byte[])"})
  public void testNewPedersenHashCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new PedersenHashCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link PedersenHashCapsule#uncommitted()}.
   *
   * <p>Method under test: {@link PedersenHashCapsule#uncommitted()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PedersenHashCapsule PedersenHashCapsule.uncommitted()"})
  public void testUncommitted() throws ZksnarkException {
    // Arrange and Act
    PedersenHashCapsule actualUncommittedResult = PedersenHashCapsule.uncommitted();

    // Assert
    PedersenHash instance = actualUncommittedResult.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    ByteString content = actualUncommittedResult.getContent();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        content.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(34, instance.getSerializedSize());
    assertFalse(content.isEmpty());
    assertTrue(content.iterator().hasNext());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(actualUncommittedResult.isPresent());
    assertSame(content, instance.getContent());
    assertArrayEquals(
        new byte[] {
          '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0
        },
        actualUncommittedResult.getData());
  }

  /**
   * Test {@link PedersenHashCapsule#getContent()}.
   *
   * <p>Method under test: {@link PedersenHashCapsule#getContent()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString PedersenHashCapsule.getContent()"})
  public void testGetContent() throws ZksnarkException {
    // Arrange
    PedersenHashCapsule uncommittedResult = PedersenHashCapsule.uncommitted();

    // Act
    ByteString actualContent = uncommittedResult.getContent();

    // Assert
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        actualContent.toStringUtf8());
    ByteIterator iteratorResult = actualContent.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertFalse(actualContent.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertSame(
        ByteString.EMPTY, uncommittedResult.getInstance().getDefaultInstanceForType().getContent());
  }

  /**
   * Test {@link PedersenHashCapsule#setContent(ByteString)}.
   *
   * <p>Method under test: {@link PedersenHashCapsule#setContent(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PedersenHashCapsule.setContent(ByteString)"})
  public void testSetContent() throws ZksnarkException {
    // Arrange
    PedersenHashCapsule uncommittedResult = PedersenHashCapsule.uncommitted();
    ByteString content = mock(ByteString.class);

    // Act
    uncommittedResult.setContent(content);

    // Assert
    PedersenHash instance = uncommittedResult.getInstance();
    List<Descriptor> messageTypes = instance.getDescriptorForType().getFile().getMessageTypes();
    assertEquals(11, messageTypes.size());
    assertEquals(0, messageTypes.get(9).toProto().getExtensionCount());
    assertEquals(2, instance.getSerializedSize());
    assertSame(content, uncommittedResult.getContent());
    assertSame(content, instance.getContent());
    assertArrayEquals(new byte[] {'\n', 0}, uncommittedResult.getData());
  }

  /**
   * Test {@link PedersenHashCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isEmpty()} return {@code true}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PedersenHashCapsule.getData()"})
  public void testGetData_givenByteStringIsEmptyReturnTrue_thenReturnEmptyArrayOfByte()
      throws ZksnarkException {
    // Arrange
    ByteString content = mock(ByteString.class);
    when(content.isEmpty()).thenReturn(true);

    PedersenHashCapsule uncommittedResult = PedersenHashCapsule.uncommitted();
    uncommittedResult.setContent(content);

    // Act
    byte[] actualData = uncommittedResult.getData();

    // Assert
    verify(content, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {}, actualData);
  }

  /**
   * Test {@link PedersenHashCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#size()} return zero.
   *   <li>Then return array of {@code byte} with lf and zero.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PedersenHashCapsule.getData()"})
  public void testGetData_givenByteStringSizeReturnZero_thenReturnArrayOfByteWithLfAndZero()
      throws ZksnarkException {
    // Arrange
    ByteString content = mock(ByteString.class);
    when(content.size()).thenReturn(0);
    when(content.isEmpty()).thenReturn(false);

    PedersenHashCapsule uncommittedResult = PedersenHashCapsule.uncommitted();
    uncommittedResult.setContent(content);

    // Act
    byte[] actualData = uncommittedResult.getData();

    // Assert
    verify(content, atLeast(1)).isEmpty();
    verify(content, atLeast(1)).size();
    assertArrayEquals(new byte[] {'\n', 0}, actualData);
  }

  /**
   * Test {@link PedersenHashCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link PedersenHashCapsule#PedersenHashCapsule()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PedersenHashCapsule.getData()"})
  public void testGetData_givenPedersenHashCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new PedersenHashCapsule().getData());
  }

  /**
   * Test {@link PedersenHashCapsule#getData()}.
   *
   * <ul>
   *   <li>Given uncommitted.
   *   <li>Then return array of {@code byte} with lf and space.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PedersenHashCapsule.getData()"})
  public void testGetData_givenUncommitted_thenReturnArrayOfByteWithLfAndSpace()
      throws ZksnarkException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0
        },
        PedersenHashCapsule.uncommitted().getData());
  }

  /**
   * Test {@link PedersenHashCapsule#getInstance()}.
   *
   * <p>Method under test: {@link PedersenHashCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PedersenHash PedersenHashCapsule.getInstance()"})
  public void testGetInstance() throws ZksnarkException {
    // Arrange and Act
    PedersenHash actualInstance = PedersenHashCapsule.uncommitted().getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(1, actualInstance.getAllFields().size());
    assertEquals(34, actualInstance.getSerializedSize());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
  }

  /**
   * Test {@link PedersenHashCapsule#isPresent()}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isEmpty()} return {@code true}.
   *   <li>Then calls {@link ByteString#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#isPresent()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PedersenHashCapsule.isPresent()"})
  public void testIsPresent_givenByteStringIsEmptyReturnTrue_thenCallsIsEmpty()
      throws ZksnarkException {
    // Arrange
    ByteString content = mock(ByteString.class);
    when(content.isEmpty()).thenReturn(true);

    PedersenHashCapsule uncommittedResult = PedersenHashCapsule.uncommitted();
    uncommittedResult.setContent(content);

    // Act
    boolean actualIsPresentResult = uncommittedResult.isPresent();

    // Assert
    verify(content).isEmpty();
    assertFalse(actualIsPresentResult);
  }

  /**
   * Test {@link PedersenHashCapsule#isPresent()}.
   *
   * <ul>
   *   <li>Given {@link PedersenHashCapsule#PedersenHashCapsule()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#isPresent()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PedersenHashCapsule.isPresent()"})
  public void testIsPresent_givenPedersenHashCapsule_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PedersenHashCapsule().isPresent());
  }

  /**
   * Test {@link PedersenHashCapsule#isPresent()}.
   *
   * <ul>
   *   <li>Given uncommitted.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PedersenHashCapsule#isPresent()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PedersenHashCapsule.isPresent()"})
  public void testIsPresent_givenUncommitted_thenReturnTrue() throws ZksnarkException {
    // Arrange, Act and Assert
    assertTrue(PedersenHashCapsule.uncommitted().isPresent());
  }
}
