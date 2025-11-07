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
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.ShieldContract;

public class PedersenHashCapsuleDiffblueTest {
  /**
   * Method under test: {@link PedersenHashCapsule#getContent()}
   */
  @Test
  public void testGetContent() throws ZksnarkException {
    // Arrange
    PedersenHashCapsule uncommittedResult = PedersenHashCapsule.uncommitted();

    // Act
    ByteString actualContent = uncommittedResult.getContent();

    // Assert
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        actualContent.toStringUtf8());
    ByteString.ByteIterator iteratorResult = actualContent.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    ShieldContract.PedersenHash instance = uncommittedResult.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(1, fields.size());
    assertFalse(actualContent.isEmpty());
    assertTrue(iteratorResult.hasNext());
    ByteString byteString = actualContent.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getContent());
  }

  /**
   * Method under test: {@link PedersenHashCapsule#getContent()}
   */
  @Test
  public void testGetContent2() throws ZksnarkException {
    // Arrange
    PedersenHashCapsule uncommittedResult = PedersenHashCapsule.uncommitted();
    uncommittedResult.setContent(mock(ByteString.class));

    // Act
    ByteString actualContent = uncommittedResult.getContent();

    // Assert
    ShieldContract.PedersenHash instance = uncommittedResult.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(1, fields.size());
    ByteString byteString = actualContent.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getContent());
  }

  /**
   * Method under test: {@link PedersenHashCapsule#setContent(ByteString)}
   */
  @Test
  public void testSetContent() throws ZksnarkException {
    // Arrange
    PedersenHashCapsule uncommittedResult = PedersenHashCapsule.uncommitted();
    ByteString content = mock(ByteString.class);

    // Act
    uncommittedResult.setContent(content);

    // Assert
    byte[] data = uncommittedResult.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.PedersenHash instance = uncommittedResult.getInstance();
    List<Descriptors.Descriptor> messageTypes = instance.getDescriptorForType().getFile().getMessageTypes();
    assertEquals(11, messageTypes.size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, data.length);
    assertEquals(99, messageTypes.get(1).toProto().getSerializedSize());
    assertSame(content, uncommittedResult.getContent());
    assertSame(content, instance.getContent());
  }

  /**
   * Method under test: {@link PedersenHashCapsule#getData()}
   */
  @Test
  public void testGetData() throws ZksnarkException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'\n', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0}, PedersenHashCapsule.uncommitted().getData());
    assertEquals(0, (new PedersenHashCapsule()).getData().length);
  }

  /**
   * Method under test: {@link PedersenHashCapsule#getData()}
   */
  @Test
  public void testGetData2() throws ZksnarkException {
    // Arrange
    ByteString content = mock(ByteString.class);
    when(content.isEmpty()).thenReturn(true);
    PedersenHashCapsule uncommittedResult = PedersenHashCapsule.uncommitted();
    uncommittedResult.setContent(content);

    // Act
    byte[] actualData = uncommittedResult.getData();

    // Assert
    verify(content, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link PedersenHashCapsule#isPresent()}
   */
  @Test
  public void testIsPresent() throws ZksnarkException {
    // Arrange, Act and Assert
    assertTrue(PedersenHashCapsule.uncommitted().isPresent());
    assertFalse((new PedersenHashCapsule()).isPresent());
  }

  /**
   * Method under test: {@link PedersenHashCapsule#isPresent()}
   */
  @Test
  public void testIsPresent2() throws ZksnarkException {
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
   * Method under test:
   * {@link PedersenHashCapsule#PedersenHashCapsule(ShieldContract.PedersenHash)}
   */
  @Test
  public void testNewPedersenHashCapsule() {
    // Arrange
    ShieldContract.PedersenHash pedersenHash = ShieldContract.PedersenHash.getDefaultInstance();

    // Act and Assert
    assertSame(pedersenHash, (new PedersenHashCapsule(pedersenHash)).getInstance());
  }

  /**
   * Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  public void testNewPedersenHashCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new PedersenHashCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  public void testNewPedersenHashCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new PedersenHashCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  public void testNewPedersenHashCapsule4() {
    // Arrange, Act and Assert
    assertNull((new PedersenHashCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  public void testNewPedersenHashCapsule5() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new PedersenHashCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  public void testNewPedersenHashCapsule6() {
    // Arrange, Act and Assert
    assertNull((new PedersenHashCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  public void testNewPedersenHashCapsule7() {
    // Arrange, Act and Assert
    assertNull((new PedersenHashCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link PedersenHashCapsule#PedersenHashCapsule(byte[])}
   */
  @Test
  public void testNewPedersenHashCapsule8() {
    // Arrange, Act and Assert
    assertNull((new PedersenHashCapsule(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', -1})).getInstance());
  }
}
