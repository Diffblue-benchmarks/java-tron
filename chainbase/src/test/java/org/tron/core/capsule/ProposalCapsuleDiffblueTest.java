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
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSet;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Proposal;
import org.tron.protos.Protocol.Proposal.State;

public class ProposalCapsuleDiffblueTest {
  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_when2xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("2XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 8XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_when8xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("8XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithEighteenAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-seven and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithTwentySevenAndX() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{27, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithTwentySixAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(ByteString, long)}.
   * <ul>
   *   <li>When {@link ByteString}.</li>
   *   <li>Then return CreateTime is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(ByteString, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(ByteString, long)"})
  public void testNewProposalCapsule_whenByteString_thenReturnCreateTimeIsZero() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act
    ProposalCapsule actualProposalCapsule = new ProposalCapsule(address, 1L);

    // Assert
    assertEquals(0L, actualProposalCapsule.getCreateTime());
    assertEquals(0L, actualProposalCapsule.getExpirationTime());
    assertEquals(1L, actualProposalCapsule.getID());
    assertEquals(State.PENDING, actualProposalCapsule.getState());
    assertFalse(actualProposalCapsule.hasCanceled());
    assertFalse(actualProposalCapsule.hasProcessed());
    assertTrue(actualProposalCapsule.getApprovals().isEmpty());
    assertTrue(actualProposalCapsule.getParameters().isEmpty());
    assertSame(address, actualProposalCapsule.getProposalAddress());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0}, actualProposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return CreateTime is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenEmptyArrayOfByte_thenReturnCreateTimeIsZero() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule = new ProposalCapsule(new byte[]{});

    // Assert
    assertEquals(0L, actualProposalCapsule.getCreateTime());
    assertEquals(0L, actualProposalCapsule.getExpirationTime());
    assertEquals(0L, actualProposalCapsule.getID());
    assertEquals(State.PENDING, actualProposalCapsule.getState());
    assertFalse(actualProposalCapsule.hasCanceled());
    assertFalse(actualProposalCapsule.hasProcessed());
    assertTrue(actualProposalCapsule.getApprovals().isEmpty());
    assertTrue(actualProposalCapsule.getParameters().isEmpty());
    assertArrayEquals(new byte[]{}, actualProposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("\bXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(" XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When {@code (XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("(XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#calculateDbKey(long)}.
   * <p>
   * Method under test: {@link ProposalCapsule#calculateDbKey(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProposalCapsule.calculateDbKey(long)"})
  public void testCalculateDbKey() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1}, ProposalCapsule.calculateDbKey(1L));
  }

  /**
   * Test {@link ProposalCapsule#getID()}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getID()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ProposalCapsule.getID()"})
  public void testGetID_givenProposalCapsuleWithAddressIsByteStringAndIdIsOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1L, (new ProposalCapsule(mock(ByteString.class), 1L)).getID());
  }

  /**
   * Test {@link ProposalCapsule#setID(long)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setID(long)"})
  public void testSetID() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});

    // Act
    proposalCapsule.setID(1L);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, proposalCapsule.getID());
    assertEquals(1L, instance.getProposalId());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setID(long)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setID(long)"})
  public void testSetID2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Act
    proposalCapsule.setID(1L);

    // Assert that nothing has changed
    assertEquals(1L, proposalCapsule.getID());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setID(long)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setID(long)"})
  public void testSetID3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setExpirationTime(10L);

    // Act
    proposalCapsule.setID(1L);

    // Assert that nothing has changed
    assertEquals(1L, proposalCapsule.getID());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, ' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setID(long)}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setID(long)"})
  public void testSetID_givenProposalCapsuleWithAddressIsByteStringAndIdIsOne() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act
    proposalCapsule.setID(1L);

    // Assert that nothing has changed
    assertEquals(1L, proposalCapsule.getID());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setID(long)}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one CreateTime is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setID(long)"})
  public void testSetID_givenProposalCapsuleWithAddressIsByteStringAndIdIsOneCreateTimeIsTen() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setCreateTime(10L);

    // Act
    proposalCapsule.setID(1L);

    // Assert that nothing has changed
    assertEquals(1L, proposalCapsule.getID());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, '(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getProposalAddress()}.
   * <p>
   * Method under test: {@link ProposalCapsule#getProposalAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString ProposalCapsule.getProposalAddress()"})
  public void testGetProposalAddress() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act
    ByteString actualProposalAddress = proposalCapsule.getProposalAddress();

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    ByteString byteString = actualProposalAddress.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getProposerAddress());
  }

  /**
   * Test {@link ProposalCapsule#setProposalAddress(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setProposalAddress(ByteString)"})
  public void testSetProposalAddress() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    ByteString proposerAddress = instance.getDefaultInstanceForType().getProposerAddress();
    assertEquals("", proposerAddress.toStringUtf8());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertFalse(proposerAddress.iterator().hasNext());
    assertTrue(proposerAddress.isEmpty());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setProposalAddress(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setProposalAddress(ByteString)"})
  public void testSetProposalAddress2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});

    // Act
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    ByteString proposerAddress = instance.getDefaultInstanceForType().getProposerAddress();
    assertEquals("", proposerAddress.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(proposerAddress.iterator().hasNext());
    assertTrue(proposerAddress.isEmpty());
    assertArrayEquals(new byte[]{18, 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setProposalAddress(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setProposalAddress(ByteString)"})
  public void testSetProposalAddress3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setID(1L);

    // Act
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    ByteString proposerAddress = instance.getDefaultInstanceForType().getProposerAddress();
    assertEquals("", proposerAddress.toStringUtf8());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertFalse(proposerAddress.iterator().hasNext());
    assertTrue(proposerAddress.isEmpty());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setProposalAddress(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setProposalAddress(ByteString)"})
  public void testSetProposalAddress4() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setExpirationTime(10L);

    // Act
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    ByteString proposerAddress = instance.getDefaultInstanceForType().getProposerAddress();
    assertEquals("", proposerAddress.toStringUtf8());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(proposerAddress.iterator().hasNext());
    assertTrue(proposerAddress.isEmpty());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, ' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setProposalAddress(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setProposalAddress(ByteString)"})
  public void testSetProposalAddress5() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setCreateTime(10L);

    // Act
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    ByteString proposerAddress = instance.getDefaultInstanceForType().getProposerAddress();
    assertEquals("", proposerAddress.toStringUtf8());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(proposerAddress.iterator().hasNext());
    assertTrue(proposerAddress.isEmpty());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, '(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setProposalAddress(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setProposalAddress(ByteString)"})
  public void testSetProposalAddress6() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    ByteString proposerAddress = instance.getDefaultInstanceForType().getProposerAddress();
    assertEquals("", proposerAddress.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertFalse(proposerAddress.iterator().hasNext());
    assertTrue(proposerAddress.isEmpty());
    assertArrayEquals(
        new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getParameters()}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getParameters()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ProposalCapsule.getParameters()"})
  public void testGetParameters_givenProposalCapsuleWithAddressIsByteStringAndIdIsOne() {
    // Arrange, Act and Assert
    assertTrue((new ProposalCapsule(mock(ByteString.class), 1L)).getParameters().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#getParameters()}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one ID is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getParameters()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ProposalCapsule.getParameters()"})
  public void testGetParameters_givenProposalCapsuleWithAddressIsByteStringAndIdIsOneIdIsOne() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setID(1L);

    // Act and Assert
    assertTrue(proposalCapsule.getParameters().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#setParameters(Map)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setParameters(Map)"})
  public void testSetParameters() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(parameters, features.getAllFields());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setParameters(Map)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setParameters(Map)"})
  public void testSetParameters2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(parameters, features.getAllFields());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertArrayEquals(new byte[]{}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setParameters(Map)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setParameters(Map)"})
  public void testSetParameters3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(4L, 4L);

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getParametersCount());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(parameters, proposalCapsule.getParameters());
    assertEquals(parameters, instance.getParameters());
    assertEquals(parameters, instance.getParametersMap());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 26, 4, '\b', 4, 16, 4}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setParameters(Map)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setParameters(Map)"})
  public void testSetParameters4() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setExpirationTime(10L);
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(parameters, features.getAllFields());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, ' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setParameters(Map)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setParameters(Map)"})
  public void testSetParameters5() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setCreateTime(10L);
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(parameters, features.getAllFields());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, '(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setParameters(Map)}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one ID is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setParameters(Map)"})
  public void testSetParameters_givenProposalCapsuleWithAddressIsByteStringAndIdIsOneIdIsOne() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setID(1L);
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(parameters, features.getAllFields());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getExpirationTime()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getExpirationTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ProposalCapsule.getExpirationTime()"})
  public void testGetExpirationTime_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ProposalCapsule(mock(ByteString.class), 1L)).getExpirationTime());
  }

  /**
   * Test {@link ProposalCapsule#setExpirationTime(long)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setExpirationTime(long)"})
  public void testSetExpirationTime() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, proposalCapsule.getExpirationTime());
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setExpirationTime(long)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setExpirationTime(long)"})
  public void testSetExpirationTime2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setID(1L);

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, ' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setExpirationTime(long)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setExpirationTime(long)"})
  public void testSetExpirationTime3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setCreateTime(10L);

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(4, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, ' ', '\n', '(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setExpirationTime(long)}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setExpirationTime(long)"})
  public void testSetExpirationTime_givenProposalCapsuleWithAddressIsByteStringAndIdIsOne() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, ' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getCreateTime()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getCreateTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ProposalCapsule.getCreateTime()"})
  public void testGetCreateTime_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ProposalCapsule(mock(ByteString.class), 1L)).getCreateTime());
  }

  /**
   * Test {@link ProposalCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setCreateTime(long)"})
  public void testSetCreateTime() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, proposalCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setCreateTime(long)"})
  public void testSetCreateTime2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setExpirationTime(10L);

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(4, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, ' ', '\n', '(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setCreateTime(long)}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setCreateTime(long)"})
  public void testSetCreateTime_givenProposalCapsuleWithAddressIsByteStringAndIdIsOne() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, '(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setCreateTime(long)}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one ID is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.setCreateTime(long)"})
  public void testSetCreateTime_givenProposalCapsuleWithAddressIsByteStringAndIdIsOneIdIsOne() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setID(1L);

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, '(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getApprovals()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getApprovals()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProposalCapsule.getApprovals()"})
  public void testGetApprovals_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ProposalCapsule(mock(ByteString.class), 1L)).getApprovals().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#removeApproval(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.removeApproval(ByteString)"})
  public void testRemoveApproval() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertTrue(proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#removeApproval(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.removeApproval(ByteString)"})
  public void testRemoveApproval2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setExpirationTime(10L);

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertTrue(proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#removeApproval(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.removeApproval(ByteString)"})
  public void testRemoveApproval3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setCreateTime(10L);

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertTrue(proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#removeApproval(ByteString)}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.removeApproval(ByteString)"})
  public void testRemoveApproval_givenProposalCapsuleWithAddressIsByteStringAndIdIsOne() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertTrue(proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#removeApproval(ByteString)}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one ID is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.removeApproval(ByteString)"})
  public void testRemoveApproval_givenProposalCapsuleWithAddressIsByteStringAndIdIsOneIdIsOne() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setID(1L);

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertTrue(proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   * <p>
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.clearApproval();

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.getAllFields().isEmpty());
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   * <p>
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});
    proposalCapsule.setID(1L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.clearApproval();

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getApprovalsCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertTrue(approvals.isEmpty());
    assertSame(approvals, instance.getDefaultInstanceForType().getApprovalsList());
    assertArrayEquals(new byte[]{'\b', 1}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   * <p>
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});
    proposalCapsule.setExpirationTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.clearApproval();

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getApprovalsCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertTrue(approvals.isEmpty());
    assertSame(approvals, instance.getDefaultInstanceForType().getApprovalsList());
    assertArrayEquals(new byte[]{' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   * <p>
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval4() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});
    proposalCapsule.setCreateTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.clearApproval();

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getApprovalsCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertTrue(approvals.isEmpty());
    assertSame(approvals, instance.getDefaultInstanceForType().getApprovalsList());
    assertArrayEquals(new byte[]{'(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   * <p>
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval5() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act
    proposalCapsule.clearApproval();

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getApprovalsCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertTrue(approvals.isEmpty());
    assertSame(approvals, instance.getDefaultInstanceForType().getApprovalsList());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   * <p>
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval6() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    proposalCapsule.clearApproval();

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getApprovalsCount());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertTrue(approvals.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertEquals(Short.SIZE, instance.getSerializedSize());
    assertSame(approvals, instance.getDefaultInstanceForType().getApprovalsList());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval_givenProposalCapsuleWithDataIsEmptyArrayOfByte() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});

    // Act
    proposalCapsule.clearApproval();

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getApprovalsCount());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertTrue(approvals.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertSame(approvals, instance.getDefaultInstanceForType().getApprovalsList());
    assertArrayEquals(new byte[]{}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#addApproval(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.addApproval(ByteString)"})
  public void testAddApproval() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act
    proposalCapsule.addApproval(mock(ByteString.class));

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#addApproval(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.addApproval(ByteString)"})
  public void testAddApproval2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});

    // Act
    proposalCapsule.addApproval(mock(ByteString.class));

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#addApproval(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.addApproval(ByteString)"})
  public void testAddApproval3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setExpirationTime(10L);

    // Act
    proposalCapsule.addApproval(mock(ByteString.class));

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(4, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, ' ', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#addApproval(ByteString)}.
   * <p>
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.addApproval(ByteString)"})
  public void testAddApproval4() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setCreateTime(10L);

    // Act
    proposalCapsule.addApproval(mock(ByteString.class));

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(4, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, '(', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#addApproval(ByteString)}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one ID is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalCapsule.addApproval(ByteString)"})
  public void testAddApproval_givenProposalCapsuleWithAddressIsByteStringAndIdIsOneIdIsOne() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    proposalCapsule.setID(1L);

    // Act
    proposalCapsule.addApproval(mock(ByteString.class));

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getState()}.
   * <ul>
   *   <li>Then return {@code PENDING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getState()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"State ProposalCapsule.getState()"})
  public void testGetState_thenReturnPending() {
    // Arrange, Act and Assert
    assertEquals(State.PENDING, (new ProposalCapsule(mock(ByteString.class), 1L)).getState());
  }

  /**
   * Test {@link ProposalCapsule#hasProcessed()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#hasProcessed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProposalCapsule.hasProcessed()"})
  public void testHasProcessed_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ProposalCapsule(mock(ByteString.class), 1L)).hasProcessed());
  }

  /**
   * Test {@link ProposalCapsule#hasCanceled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#hasCanceled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProposalCapsule.hasCanceled()"})
  public void testHasCanceled_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ProposalCapsule(mock(ByteString.class), 1L)).hasCanceled());
  }

  /**
   * Test {@link ProposalCapsule#hasExpired(long)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#hasExpired(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProposalCapsule.hasExpired(long)"})
  public void testHasExpired_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ProposalCapsule(mock(ByteString.class), 1L)).hasExpired(10L));
  }

  /**
   * Test {@link ProposalCapsule#hasExpired(long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#hasExpired(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProposalCapsule.hasExpired(long)"})
  public void testHasExpired_whenMinusOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ProposalCapsule(mock(ByteString.class), 1L)).hasExpired(-1L));
  }

  /**
   * Test {@link ProposalCapsule#createDbKey()}.
   * <ul>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProposalCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnArrayOfByteWithZeroAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1},
        (new ProposalCapsule(mock(ByteString.class), 1L)).createDbKey());
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   * <p>
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ProposalCapsule proposalCapsule = new ProposalCapsule(address, 1L);
    proposalCapsule.setExpirationTime(10L);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, ' ', '\n'}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   * <p>
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ProposalCapsule proposalCapsule = new ProposalCapsule(address, 1L);
    proposalCapsule.setState(State.DISAPPROVED);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, '8', 1}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} one is one.</li>
   *   <li>Then return array of {@code byte} with backspace and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_givenHashMapOneIsOne_thenReturnArrayOfByteWithBackspaceAndOne() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(address, 1L);
    proposalCapsule.setParameters(parameters);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, 26, 4, '\b', 1, 16, 1}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_givenProposalCapsuleWithAddressIsByteStringAndIdIsMax_value() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ProposalCapsule(address, Long.MAX_VALUE)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_givenProposalCapsuleWithAddressIsByteStringAndIdIsMinusOne() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ProposalCapsule(address, -1L)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_givenProposalCapsuleWithAddressIsByteStringAndIdIsOne() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ProposalCapsule(address, 1L)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one CreateTime is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_givenProposalCapsuleWithAddressIsByteStringAndIdIsOneCreateTimeIsTen() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ProposalCapsule proposalCapsule = new ProposalCapsule(address, 1L);
    proposalCapsule.setCreateTime(10L);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, '(', '\n'}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(ByteString, long)} with address is {@link ByteString} and id is one ID is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_givenProposalCapsuleWithAddressIsByteStringAndIdIsOneIdIsOne() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ProposalCapsule proposalCapsule = new ProposalCapsule(address, 1L);
    proposalCapsule.setID(1L);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ProposalCapsule(address, 0L)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getInstance()}.
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.Proposal ProposalCapsule.getInstance()"})
  public void testGetInstance_givenProposalCapsuleWithDataIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#hasMostApprovals(List)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalCapsule#hasMostApprovals(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProposalCapsule.hasMostApprovals(List)"})
  public void testHasMostApprovals_thenReturnTrue() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});

    // Act and Assert
    assertTrue(proposalCapsule.hasMostApprovals(new ArrayList<>()));
  }
}
